package com.sysu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sysu.common.Result;
import com.sysu.entity.Goods;
import com.sysu.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("/admin/product")
    public Result getGoodsPage(
            @RequestParam(required = false) String searchQuery,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        IPage<Goods> page = goodsService.getGoodsPage(searchQuery, pageNum, pageSize);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("pageNum", page.getCurrent());
        data.put("productList", page.getRecords());

        return Result.success(data);
    }

    @DeleteMapping("/admin/product/{productID}")
    public Result deleteGoods(@PathVariable Integer productID){
        boolean ok = goodsService.deleteGoods(productID);
        if (!ok) {
            return Result.error("商品不存在或已删除");
        }
        return Result.success();
    }
}
