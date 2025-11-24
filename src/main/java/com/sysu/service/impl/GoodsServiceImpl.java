package com.sysu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sysu.entity.Goods;
import com.sysu.service.GoodsService;
import com.sysu.mapper.GoodsMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author whiteby
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2025-11-24 12:44:16
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public IPage<Goods> getGoodsPage(String searchQuery, Integer pageNum, Integer pageSize) {
        Page<Goods> page = new Page<>(pageNum, pageSize);
        return goodsMapper.selectGoodsPage(page, searchQuery);
    }

    @Override
    public boolean deleteGoods(Integer productID) {
        int rows = goodsMapper.deleteById(productID);
        return rows > 0;
    }
}




