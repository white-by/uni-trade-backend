package com.sysu.service;

import com.github.pagehelper.PageInfo;
import com.sysu.entity.Admins;

/**
* @author whiteby
* @description 针对表【admin_info】的数据库操作Service
* @createDate 2025-11-13 20:13:40
*/
public interface AdminService {
    PageInfo<Admins> getAdminPage(String searchQuery, int pageNum, int pageSize);

    int addAdminInfo(Admins admins);

    boolean updateAdminInfo(Admins admins);

    boolean deleteAdminInfo(Integer adminID);

    Admins adminLogin(String mail, String password);
}
