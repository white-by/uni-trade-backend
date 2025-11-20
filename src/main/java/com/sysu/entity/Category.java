package com.sysu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 
 * @TableName category
 */
@TableName(value ="category")
@Data
public class Category {
    /**
     * 
     */
    @TableId(value = "categoryID", type = IdType.AUTO)
    private Integer categoryID;

    /**
     * 
     */
    @TableField(value = "categoryName")
    private String categoryName;

    /**
     * 
     */
    @TableField(value = "descriptions")
    @JsonProperty("description")
    private String descriptions;
}