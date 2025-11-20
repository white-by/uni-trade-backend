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
 * @TableName trade_records
 */
@TableName(value ="trade_records")
@Data
public class Order {
    /**
     * 
     */
    @TableId(value = "tradeID", type = IdType.AUTO)
    private Integer tradeID;

    /**
     * 
     */
    @TableField(value = "sellerID")
    private Integer sellerID;

    /**
     * 
     */
    @TableField(value = "buyerID")
    private Integer buyerID;

    /**
     * 
     */
    @TableField(value = "goodsID")
    private Integer goodsID;

    /**
     * 
     */
    @TableField(value = "turnoverAmount")
    private BigDecimal turnoverAmount;

    /**
     * 
     */
    @TableField(value = "shippingAddrID")
    private Integer shippingAddrID;

    /**
     * 
     */
    @TableField(value = "deliveryAddrID")
    private Integer deliveryAddrID;

    /**
     * 
     */
    @TableField(value = "orderTime")
    private Date orderTime;

    /**
     * 
     */
    @TableField(value = "payTime")
    private Date payTime;

    /**
     * 
     */
    @TableField(value = "shippingTime")
    private Date shippingTime;

    /**
     * 
     */
    @TableField(value = "shippingCost")
    private BigDecimal shippingCost;

    /**
     * 
     */
    @TableField(value = "turnoverTime")
    private Date turnoverTime;

    /**
     * 
     */
    @TableField(value = "payMethod")
    private Integer payMethod;

    /**
     * 
     */
    @TableField(value = "trackingNumber")
    private String trackingNumber;

    /**
     * 
     */
    @TableField(value = "isReturn")
    private Integer isReturn;

    /**
     * 
     */
    @TableField(value = "status")
    private String status;


    // 不在 trade_records 表中，但需要返回
    @TableField(exist = false)
    private String sellerName;

    @TableField(exist = false)
    private String buyerName;

    @TableField(exist = false)
    private String goodsName;

    @TableField(exist = false)
    private BigDecimal price;

    @TableField(exist = false)
    private String deliveryMethod;

    // 地址对象（发货地址）
    @TableField(exist = false)
    private Address senderAddress;

    // 地址对象（收货地址）
    @TableField(exist = false)
    private Address shippingAddress;

    // 地址字段（临时字段，用于 xml 映射）
    @TableField(exist = false)
    private String senderProvince;

    @TableField(exist = false)
    private String senderCity;

    @TableField(exist = false)
    private String senderArea;

    @TableField(exist = false)
    private String senderDetailArea;

    @TableField(exist = false)
    private String shippingProvince;

    @TableField(exist = false)
    private String shippingCity;

    @TableField(exist = false)
    private String shippingArea;

    @TableField(exist = false)
    private String shippingDetailArea;

}