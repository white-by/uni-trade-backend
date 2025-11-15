package com.sysu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sysu.entity.Admins;
import com.sysu.service.AdminService;
import com.sysu.mapper.AdminInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author whiteby
* @description 针对表【admin_info】的数据库操作Service实现
* @createDate 2025-11-13 20:13:40
*/
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public PageInfo<Admins> getAdminPage(String searchQuery, int pageNum, int pageSize) {
        // 调用 PageHelper.startPage 开启分页
        PageHelper.startPage(pageNum, pageSize);

        // 如果 searchQuery 有值，则按 adminName 模糊查询
        QueryWrapper<Admins> wrapper = new QueryWrapper<>();
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            wrapper.like("adminName", searchQuery);
        }

        List<Admins> list = adminInfoMapper.selectList(wrapper);

        return new PageInfo<>(list);
    }

    @Override
    public int addAdminInfo(Admins admins) {
        adminInfoMapper.insert(admins);
        return admins.getAdminID();
    }

    @Override
    public boolean updateAdminInfo(Admins admins) {
        int rows = adminInfoMapper.updateById(admins);
        return rows > 0;
    }

    @Override
    public boolean deleteAdminInfo(Integer adminID) {
        int rows = adminInfoMapper.deleteById(adminID);
        return rows > 0;
    }

    @Override
    public Admins adminLogin(String mail, String password) {
        // 根据邮箱查询
        Admins admin = adminInfoMapper.selectOne(
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<Admins>()
                        .eq("mail", mail)
        );

        if (admin != null && admin.getPasswords().equals(password)) {
            return admin;
        }
        return null;
    }

}





