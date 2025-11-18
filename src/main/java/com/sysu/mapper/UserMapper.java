package com.sysu.mapper;

import com.sysu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author whiteby
* @description 针对表【users】的数据库操作Mapper
* @createDate 2025-11-18 21:57:43
* @Entity com.sysu.entity.Users
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




