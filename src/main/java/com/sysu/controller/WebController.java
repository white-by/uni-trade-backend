package com.sysu.controller;

import com.sysu.common.Result;
import com.sysu.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/hello")
    public Result hello() {
//        int a = 1/0;
        return Result.success("Hello World");
    }

    @Resource
    AddressService addressService;
    @GetMapping("/test")
    public Object test() {
        return addressService.getById(1);
    }
}
