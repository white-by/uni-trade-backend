package com.sysu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author whiteby
* @description 针对表【users】的数据库操作Service
* @createDate 2025-11-18 21:57:43
*/
public interface UserService extends IService<User> {

    Page<User> getUserPage(String searchQuery, Integer pageNum, Integer pageSize);
}
