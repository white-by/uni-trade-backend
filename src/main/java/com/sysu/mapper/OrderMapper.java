package com.sysu.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author whiteby
* @description 针对表【trade_records】的数据库操作Mapper
* @createDate 2025-11-20 12:07:46
* @Entity com.sysu.entity.TradeRecords
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    Page<Order> getOrderPage(Page<Order> page, String searchQuery);
}




