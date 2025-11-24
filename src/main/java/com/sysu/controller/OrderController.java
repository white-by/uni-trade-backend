package com.sysu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.common.Result;
import com.sysu.entity.Order;
import com.sysu.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {
    @Resource
    OrderService orderService;

    @GetMapping("/admin/order")
    public Result getOrderPage(
            @RequestParam(required = false) String searchQuery,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        Page<Order> page = orderService.getOrderPage(searchQuery, pageNum, pageSize);

        // 按你需求的格式组装（不使用 DTO）
        Map<String, Object> data = new HashMap<>();
        data.put("orderList", page.getRecords());
        data.put("total", page.getTotal());
        data.put("pageNum", page.getCurrent());

        return Result.success(data);
    }
}
