package com.sysu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sysu.entity.AdminInfo;
import com.sysu.service.AdminInfoService;
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
public class AdminInfoServiceImpl implements AdminInfoService {

    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public PageInfo<AdminInfo> getAdminInfoPage(int pageNum, int pageSize) {
        // 调用 PageHelper.startPage 开启分页
        PageHelper.startPage(pageNum, pageSize);
        List<AdminInfo> list = adminInfoMapper.selectList(null);

        return new PageInfo<>(list);
    }

    @Override
    public int addAdminInfo(AdminInfo adminInfo) {
        adminInfoMapper.insert(adminInfo);
        return adminInfo.getAdminID();
    }

    @Override
    public boolean updateAdminInfo(AdminInfo adminInfo) {
        int rows = adminInfoMapper.updateById(adminInfo);
        return rows > 0;
    }

    @Override
    public boolean deleteAdminInfo(Integer adminID) {
        int rows = adminInfoMapper.deleteById(adminID);
        return rows > 0;
    }

    @Override
    public AdminInfo adminLogin(String mail, String password) {
        // 根据邮箱查询
        AdminInfo admin = adminInfoMapper.selectOne(
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<AdminInfo>()
                        .eq("mail", mail)
        );

        if (admin != null && admin.getPasswords().equals(password)) {
            return admin;
        }
        return null;
    }

}





