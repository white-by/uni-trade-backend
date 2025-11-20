package com.sysu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.common.Result;
import com.sysu.entity.Category;
import com.sysu.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/admin/category")
    public Result getCategoryPage(
            @RequestParam(required = false) String searchQuery,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        Page<Category> page = categoryService.getCategoryPage(searchQuery, pageNum, pageSize);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("pageNum", page.getCurrent());
        data.put("categoryList", page.getRecords());

        return Result.success(data);
    }

    @PostMapping("/admin/category")
    public Result addCategory(@RequestBody Category category){
        int categoryID = categoryService.addCategory(category);

        Map<String, Object> data = new HashMap<>();
        data.put("categoryID", categoryID);
        return Result.success(data);

    }

    @PutMapping("/admin/category/{categoryID}")
    public Result updateCategory(@PathVariable int categoryID, @RequestBody Category category){
        category.setCategoryID(categoryID);
        boolean ok = categoryService.updateCategory(category);
        if (!ok) {
            return Result.error("商品分类不存在");
        }
        return Result.success();
    }

    @DeleteMapping("/admin/category/{categoryID}")
    public Result deleteCategory(@PathVariable int categoryID){
        boolean ok = categoryService.deleteCategory(categoryID);
        if (!ok) {
            return Result.error("商品分类不存在或已删除");
        }
        return Result.success();
    }
}
