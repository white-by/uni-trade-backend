package com.sysu.mapper;

import com.sysu.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author whiteby
* @description 针对表【category】的数据库操作Mapper
* @createDate 2025-11-20 11:16:55
* @Entity com.sysu.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




