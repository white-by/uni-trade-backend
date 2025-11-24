package com.sysu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private Integer goodsID;

    /**
     * 
     */
    @TableField(value = "goodsName")
    @JsonProperty("title")
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
    @JsonProperty("imageUrl")
    private String goodsImages;

    /**
     * 
     */
    @TableField(value = "createdTime")
    @JsonProperty("postTime")
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
    @JsonProperty("views")
    private Integer view;

    /** 扩展字段，不在 goods 表中存在 **/
    @TableField(exist = false)
    private String userName;        // 发布者名

    @TableField(exist = false)
    private String category;        // 分类名

    @TableField(exist = false)
    private String description;     // 分类描述或商品描述

    @TableField(exist = false)
    private String province;        // 地址省

    @TableField(exist = false)
    private String city;            // 地址市

    @TableField(exist = false)
    private String area;            // 地址区

    @TableField(exist = false)
    private String detailArea;      // 地址详细

    @TableField(exist = false)
    private Integer stars;          // 收藏量

    @TableField(exist = false)
    private Integer isStar;         // 当前用户是否收藏，0/1


}