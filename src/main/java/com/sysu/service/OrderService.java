package com.sysu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author whiteby
* @description 针对表【trade_records】的数据库操作Service
* @createDate 2025-11-20 12:07:46
*/
public interface OrderService extends IService<Order> {

    Page<Order> getOrderPage(String searchQuery, Integer pageNum, Integer pageSize);
}
