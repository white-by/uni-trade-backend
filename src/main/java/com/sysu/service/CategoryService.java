package com.sysu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author whiteby
* @description 针对表【category】的数据库操作Service
* @createDate 2025-11-20 11:16:55
*/
public interface CategoryService extends IService<Category> {

    Page<Category> getCategoryPage(String searchQuery, Integer pageNum, Integer pageSize);

    int addCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(int categoryID);
}
