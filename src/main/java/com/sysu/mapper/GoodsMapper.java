package com.sysu.mapper;

import com.sysu.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author whiteby
* @description 针对表【goods】的数据库操作Mapper
* @createDate 2025-11-20 12:28:18
* @Entity com.sysu.entity.Goods
*/
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}




