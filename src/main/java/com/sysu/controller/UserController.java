package com.sysu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.common.Result;
import com.sysu.entity.User;
import com.sysu.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/admin/usersInfo")
    public Result getUser(
            @RequestParam(required = false) String searchQuery,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        Page<User> page = userService.getUserPage(searchQuery, pageNum, pageSize);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("pageNum", page.getCurrent());
        data.put("usersList", page.getRecords());

        return Result.success(data);
    }
}
