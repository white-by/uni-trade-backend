package com.sysu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sysu.entity.RefundComplaint;
import com.sysu.service.RefundComplaintService;
import com.sysu.mapper.RefundComplaintMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author whiteby
* @description 针对表【refund_complaint】的数据库操作Service实现
* @createDate 2025-11-24 13:16:27
*/
@Service
public class RefundComplaintServiceImpl extends ServiceImpl<RefundComplaintMapper, RefundComplaint>
    implements RefundComplaintService{
    @Resource
    private RefundComplaintMapper refundComplaintMapper;

    @Override
    public IPage<RefundComplaint> getRefundListPage(int status, String searchQuery, Integer pageNum, Integer pageSize) {
        Page<RefundComplaint> page = new Page<>(pageNum, pageSize);
        return refundComplaintMapper.selectRefundListPage(page, status, searchQuery);
    }
}




