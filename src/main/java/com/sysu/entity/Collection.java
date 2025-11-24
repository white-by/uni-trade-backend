package com.sysu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName collection
 */
@TableName(value ="collection")
@Data
public class Collection {
    /**
     * 
     */
    @TableId(value = "goodsID")
    private Integer goodsID;

    /**
     * 
     */
    @TableField(value = "userID")
    private Integer userID;

    /**
     * 
     */
    @TableField(value = "createdTime")
    private Date createdTime;
}