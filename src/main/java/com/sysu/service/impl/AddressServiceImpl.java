package com.sysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sysu.entity.Address;
import com.sysu.service.AddressService;
import com.sysu.mapper.AddressMapper;
import org.springframework.stereotype.Service;

/**
* @author whiteby
* @description 针对表【address】的数据库操作Service实现
* @createDate 2025-11-13 17:32:27
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
    implements AddressService{

}




