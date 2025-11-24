package com.sysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sysu.entity.Address;
import com.sysu.service.AddressService;
import com.sysu.mapper.AddressMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author whiteby
* @description 针对表【address】的数据库操作Service实现
* @createDate 2025-11-13 17:32:27
*/
@Slf4j
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
    implements AddressService{
    @Resource
    private AddressMapper addressMapper;

    public Address getAddressById(Integer addrID) {
        log.info("ad;drID = " + addrID);
        if (addrID == null) return null;
        return addressMapper.selectById(addrID);
    }
}




