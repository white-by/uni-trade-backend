package com.sysu.controller;

import com.github.pagehelper.PageInfo;
import com.sysu.common.Result;
import com.sysu.entity.AdminInfo;
import com.sysu.service.AdminInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminInfoService adminInfoService;

    @GetMapping("/adminInfo")
    public Result getAdminInfo(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageInfo<AdminInfo> pageInfo = adminInfoService.getAdminInfoPage(pageNum, pageSize);

        Map<String, Object> data = new HashMap<>();
        data.put("total", pageInfo.getTotal());
        data.put("pageNum", pageInfo.getPageNum());
        data.put("adminList", pageInfo.getList());

        return Result.success(data);
    }

    @PostMapping("/adminInfo")
    public Result addAdminInfo(@RequestBody AdminInfo adminInfo) {
        int adminID = adminInfoService.addAdminInfo(adminInfo);

        Map<String, Object> data = new HashMap<>();
        data.put("adminID", adminID);

        return Result.success(data);
    }

    @PutMapping("/adminInfo/{adminID}")
    public Result updateAdminInfo(@PathVariable Integer adminID, @RequestBody AdminInfo adminInfo) {
        adminInfo.setAdminID(adminID);

        boolean ok = adminInfoService.updateAdminInfo(adminInfo);
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
}

