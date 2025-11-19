package com.sysu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.common.Result;
import com.sysu.entity.User;
import com.sysu.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/admin/usersInfo")
    public Result addUser(@RequestBody User user) {
        int userID = userService.addUser(user);

        Map<String, Object> data = new HashMap<>();
        data.put("userID", userID);

        return Result.success(data);
    }

    @PutMapping("/admin/usersInfo/{userID}")
    public Result updateUser(@PathVariable Integer userID, @RequestBody User user) {
        user.setUserID(userID);
        boolean ok = userService.updateUser(user);

        if (!ok) {
            return Result.error("用户不存在");
        }
        return Result.success();
    }

    @DeleteMapping("/admin/usersInfo/{userID}")
    public Result deleteUser(@PathVariable Integer userID) {
        boolean ok = userService.deleteUser(userID);

        if (!ok) {
            return Result.error("用户不存在或已删除");
        }
        return Result.success();
    }
}
