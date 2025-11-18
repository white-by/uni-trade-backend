package com.sysu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.entity.Admin;
import com.sysu.service.AdminService;
import com.sysu.mapper.AdminMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author whiteby
* @description 针对表【admin_info】的数据库操作Service实现
* @createDate 2025-11-13 20:13:40
*/
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Page<Admin> getAdminPage(String searchQuery, int pageNum, int pageSize) {
        Page<Admin> page = new Page<>(pageNum, pageSize);

        // 如果 searchQuery 有值，则按 adminName 模糊查询
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            wrapper.like("adminName", searchQuery);
        }

        return adminMapper.selectPage(page, wrapper);
    }

    @Override
    public int addAdminInfo(Admin admin) {
        adminMapper.insert(admin);
        return admin.getAdminID();
    }

    @Override
    public boolean updateAdminInfo(Admin admin) {
        int rows = adminMapper.updateById(admin);
        return rows > 0;
    }

    @Override
    public boolean deleteAdminInfo(Integer adminID) {
        int rows = adminMapper.deleteById(adminID);
        return rows > 0;
    }

    @Override
    public Admin adminLogin(String mail, String password) {
        // 根据邮箱查询
        Admin admin = adminMapper.selectOne(
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<Admin>()
                        .eq("mail", mail)
        );

        if (admin != null && admin.getPasswords().equals(password)) {
            return admin;
        }
        return null;
    }

}





