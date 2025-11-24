package com.sysu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sysu.entity.RefundComplaint;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author whiteby
* @description 针对表【refund_complaint】的数据库操作Service
* @createDate 2025-11-24 13:16:27
*/
public interface RefundComplaintService extends IService<RefundComplaint> {

    IPage<RefundComplaint> getRefundListPage(int status, String searchQuery, Integer pageNum, Integer pageSize);
}
