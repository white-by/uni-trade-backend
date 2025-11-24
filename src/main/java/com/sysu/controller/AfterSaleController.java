package com.sysu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sysu.common.Result;
import com.sysu.entity.RefundComplaint;
import com.sysu.service.RefundComplaintService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AfterSaleController {
    @Resource
    private RefundComplaintService refundComplaintService;

    @GetMapping("admin/afterSale")
    public Result getAfterSaleList(
            @RequestParam(required = false) String searchQuery,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        IPage<RefundComplaint> page = refundComplaintService.getRefundListPage(0, searchQuery, pageNum, pageSize);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("pageNum", page.getCurrent());
        data.put("refundList", page.getRecords());

        return Result.success(data);
    }
}
