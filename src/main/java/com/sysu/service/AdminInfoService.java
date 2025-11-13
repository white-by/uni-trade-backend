package com.sysu.service;

import com.github.pagehelper.PageInfo;
import com.sysu.entity.AdminInfo;

/**
* @author whiteby
* @description 针对表【admin_info】的数据库操作Service
* @createDate 2025-11-13 20:13:40
*/
public interface AdminInfoService {
    PageInfo<AdminInfo> getAdminInfoPage(int pageNum, int pageSize);
}
