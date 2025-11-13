package com.sysu.mapper;

import com.sysu.entity.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author whiteby
* @description 针对表【address】的数据库操作Mapper
* @createDate 2025-11-13 17:32:27
* @Entity com.sysu.entity.Address
*/
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

}




