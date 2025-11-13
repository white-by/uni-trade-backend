package com.sysu.controller;

import com.github.pagehelper.PageInfo;
import com.sysu.common.Result;
import com.sysu.dto.AdminListData;
import com.sysu.entity.AdminInfo;
import com.sysu.service.AdminInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminInfoService adminInfoService;

    @GetMapping("/adminInfo")
    public Result<AdminListData> getAdminInfo(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageInfo<AdminInfo> pageInfo = adminInfoService.getAdminInfoPage(pageNum, pageSize);

        // 封装 DTO
        AdminListData data = new AdminListData();
        data.setAdminList(pageInfo.getList());
        data.setTotal((int) pageInfo.getTotal());
        data.setPageNum(pageNum);

        return Result.success(data);
    }
}

