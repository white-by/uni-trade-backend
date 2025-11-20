package com.sysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sysu.entity.Goods;
import com.sysu.service.GoodsService;
import com.sysu.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author whiteby
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2025-11-20 12:28:18
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

}




