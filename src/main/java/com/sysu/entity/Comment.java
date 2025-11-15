package com.sysu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName comment
 */
@TableName(value ="comment")
@Data
public class Comment {
    /**
     * 
     */
    @TableId(value = "commentID", type = IdType.AUTO)
    private Integer commentID;

    /**
     * 
     */
    @TableField(value = "goodsID")
    private Integer goodsID;

    /**
     * 
     */
    @TableField(value = "commentatorID")
    private Integer commentatorID;

    /**
     * 
     */
    @TableField(value = "commentContent")
    private String commentContent;

    /**
     * 
     */
    @TableField(value = "commentTime")
    private Date commentTime;

    @TableField(exist = false)
    private String commentatorName;

    @TableField(exist = false)
    private String goodsName;
}