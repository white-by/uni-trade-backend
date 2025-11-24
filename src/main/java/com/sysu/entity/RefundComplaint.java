package com.sysu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 
 * @TableName refund_complaint
 */
@TableName(value ="refund_complaint")
@Data
public class RefundComplaint {
    /**
     * 
     */
    @TableId(value = "complaintID", type = IdType.AUTO)
    private Integer complaintID;

    /**
     * 
     */
    @TableField(value = "tradeID")
    private Integer tradeID;

    /**
     * 
     */
    @TableField(value = "sellerReason")
    private String sellerReason;

    /**
     * 
     */
    @TableField(value = "cTime")
    @JsonProperty("refundTime")
    private Date cTime;

    /**
     * 
     */
    @TableField(value = "cStatus")
    @JsonProperty("status")
    private Integer cStatus;

    /**
     * 
     */
    @TableField(value = "buyerReason")
    private String buyerReason;

    /** 扩展字段，不在 goods 表中存在 **/
    @TableField(exist = false)
    private String goodsName;

    @TableField(exist = false)
    private String sellerName;

    @TableField(exist = false)
    private String buyerName;

    @TableField(exist = false)
    private Double price;

    @TableField(exist = false)
    private Double shippingCost;

    @TableField(exist = false)
    private Date orderTime;

    @TableField(exist = false)
    private Date payTime;

    @TableField(exist = false)
    private Integer sellerID;

    @TableField(exist = false)
    private Integer buyerID;
}