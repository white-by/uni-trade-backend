package com.sysu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.entity.Admin;

/**
* @author whiteby
* @description 针对表【admin_info】的数据库操作Service
* @createDate 2025-11-13 20:13:40
*/
public interface AdminService {
    Page<Admin> getAdminPage(String searchQuery, int pageNum, int pageSize);

    int addAdminInfo(Admin admin);

    boolean updateAdminInfo(Admin admin);

    boolean deleteAdminInfo(Integer adminID);

    Admin adminLogin(String mail, String password);
}
