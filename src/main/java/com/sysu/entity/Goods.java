package com.sysu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName goods
 */
@TableName(value ="goods")
@Data
public class Goods {
    /**
     * 
     */
    @TableId(value = "goodsID", type = IdType.AUTO)
    private Integer goodsID;

    /**
     * 
     */
    @TableField(value = "goodsName")
    private String goodsName;

    /**
     * 
     */
    @TableField(value = "userID")
    private Integer userID;

    /**
     * 
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 
     */
    @TableField(value = "categoryID")
    private Integer categoryID;

    /**
     * 
     */
    @TableField(value = "details")
    private String details;

    /**
     * 
     */
    @TableField(value = "isSold")
    private Integer isSold;

    /**
     * 
     */
    @TableField(value = "goodsImages")
    private String goodsImages;

    /**
     * 
     */
    @TableField(value = "createdTime")
    private Date createdTime;

    /**
     * 
     */
    @TableField(value = "deliveryMethod")
    private String deliveryMethod;

    /**
     * 
     */
    @TableField(value = "shippingCost")
    private Integer shippingCost;

    /**
     * 
     */
    @TableField(value = "addrID")
    private Integer addrID;

    /**
     * 
     */
    @TableField(value = "view")
    private Integer view;
}