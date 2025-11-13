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
        List<AdminInfo> list = adminInfoMapper.selectList(null); // 或你的查询条件
        return new PageInfo<>(list);
    }
}





