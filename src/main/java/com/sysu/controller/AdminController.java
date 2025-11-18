package com.sysu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.common.Result;
import com.sysu.entity.Admin;
import com.sysu.service.AdminService;
import com.sysu.utils.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminInfoService;

    @Resource
    private JwtUtil jwtUtil;

    @GetMapping("/adminInfo")
    public Result getAdminInfo(
            @RequestParam(required = false) String searchQuery,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        Page<Admin> page = adminInfoService.getAdminPage(searchQuery, pageNum, pageSize);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("pageNum", page.getCurrent());
        data.put("adminList", page.getRecords());

        return Result.success(data);
    }

    @PostMapping("/adminInfo")
    public Result addAdminInfo(@RequestBody Admin admin) {
        int adminID = adminInfoService.addAdminInfo(admin);

        Map<String, Object> data = new HashMap<>();
        data.put("adminID", adminID);

        return Result.success(data);
    }

    @PutMapping("/adminInfo/{adminID}")
    public Result updateAdminInfo(@PathVariable Integer adminID, @RequestBody Admin admin) {
        admin.setAdminID(adminID);

        boolean ok = adminInfoService.updateAdminInfo(admin);
        if (!ok) {
            return Result.error("管理员不存在");
        }
        return Result.success();
    }

    @DeleteMapping("/adminInfo/{adminID}")
    public Result deleteAdminInfo(@PathVariable Integer adminID) {
        boolean ok = adminInfoService.deleteAdminInfo(adminID);
        if (!ok) {
            return Result.error("管理员不存在或已删除");
        }
        return Result.success();
    }

    @PostMapping("/login")
    public Result adminLogin(@RequestBody Map<String, String> body) {
        String mail = body.get("mail");
        String password = body.get("password");

        // 校验邮箱和密码
        Admin admin = adminInfoService.adminLogin(mail, password);
        if (admin == null) {
            return Result.error("邮箱或密码错误");
        }

        // 生成 token
        String token = jwtUtil.createToken(admin.getAdminID().toString());

        // 把 token 加到 admin 对象中
        admin.setToken("Bearer " + token);

        return Result.success(admin);
    }

}

