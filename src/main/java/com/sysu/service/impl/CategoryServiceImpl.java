package com.sysu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sysu.entity.Category;
import com.sysu.service.CategoryService;
import com.sysu.mapper.CategoryMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author whiteby
* @description 针对表【category】的数据库操作Service实现
* @createDate 2025-11-20 11:16:55
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public Page<Category> getCategoryPage(String searchQuery, Integer pageNum, Integer pageSize) {
        Page<Category> page = new Page<>(pageNum, pageSize);

        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        if (searchQuery != null && searchQuery.trim().isEmpty()) {
            wrapper.like("categoryName", "%" + searchQuery + "%");
        }

        return categoryMapper.selectPage(page, wrapper);
    }

    @Override
    public int addCategory(Category category) {
        categoryMapper.insert(category);
        return category.getCategoryID();
    }

    @Override
    public boolean updateCategory(Category category) {
        int rows = categoryMapper.updateById(category);
        return rows > 0;
    }

    @Override
    public boolean deleteCategory(int categoryID) {
        int rows = categoryMapper.deleteById(categoryID);
        return rows > 0;
    }
}




