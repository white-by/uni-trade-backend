package com.sysu.mapper;

import com.sysu.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author whiteby
* @description 针对表【admin_info】的数据库操作Mapper
* @createDate 2025-11-13 20:13:40
* @Entity com.sysu.entity.AdminInfo
*/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}




