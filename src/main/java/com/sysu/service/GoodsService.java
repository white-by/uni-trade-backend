package com.sysu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sysu.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author whiteby
* @description 针对表【goods】的数据库操作Service
* @createDate 2025-11-24 12:44:16
*/
public interface GoodsService extends IService<Goods> {

    IPage<Goods> getGoodsPage(String searchQuery, Integer pageNum, Integer pageSize);

    boolean deleteGoods(Integer productID);
}
