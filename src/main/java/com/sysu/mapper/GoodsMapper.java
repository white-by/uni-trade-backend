package com.sysu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author whiteby
* @description 针对表【goods】的数据库操作Mapper
* @createDate 2025-11-24 12:44:16
* @Entity com.sysu.entity.Goods
*/
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    IPage<Goods> selectGoodsPage(Page<Goods> page, String searchQuery);
}




