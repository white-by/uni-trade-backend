package com.sysu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sysu.entity.RefundComplaint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author whiteby
* @description 针对表【refund_complaint】的数据库操作Mapper
* @createDate 2025-11-24 13:16:27
* @Entity com.sysu.entity.RefundComplaint
*/
@Mapper
public interface RefundComplaintMapper extends BaseMapper<RefundComplaint> {

    IPage<RefundComplaint> selectRefundListPage(Page<RefundComplaint> page, int status, String searchQuery);
}




