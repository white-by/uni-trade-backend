package com.sysu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sysu.entity.User;
import com.sysu.service.UserService;
import com.sysu.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author whiteby
* @description 针对表【users】的数据库操作Service实现
* @createDate 2025-11-18 21:57:43
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Page<User> getUserPage(String searchQuery, Integer pageNum, Integer pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);

        return userMapper.selectUser(page, searchQuery);
    }

    @Override
    public int addUser(User user) {
        userMapper.insert(user);
        return user.getUserID();
    }

    @Override
    public boolean updateUser(User user) {
        int rows = userMapper.updateById(user);
        return rows > 0;
    }

    @Override
    public boolean deleteUser(Integer userID) {
        int rows = userMapper.deleteById(userID);
        return rows > 0;
    }
}




