package com.sysu.dto;

import com.sysu.entity.AdminInfo;
import lombok.Data;

import java.util.List;

@Data
public class AdminListData {
    private List<AdminInfo> adminList; // 当前页管理员列表
    private Integer total;             // 总记录数
    private Integer pageNum;           // 当前页码
}