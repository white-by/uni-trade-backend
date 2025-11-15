package com.sysu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName announcement
 */
@TableName(value ="announcement")
@Data
public class Announcement {
    /**
     * 
     */
    @TableId(value = "announcementID", type = IdType.AUTO)
    private Integer announcementID;

    /**
     * 
     */
    @TableField(value = "anTitle")
    private String anTitle;

    /**
     * 
     */
    @TableField(value = "anContent")
    private String anContent;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "anTime")
    private Date anTime;
}