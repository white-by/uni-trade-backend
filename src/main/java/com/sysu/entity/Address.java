package com.sysu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName address
 */
@TableName(value ="address")
@Data
public class Address {
    /**
     * 
     */
    @TableId(value = "addrID", type = IdType.AUTO)
    private Integer addrID;

    /**
     * 
     */
    @TableField(value = "userID")
    private Integer userID;

    /**
     * 
     */
    @TableField(value = "province")
    private String province;

    /**
     * 
     */
    @TableField(value = "city")
    private String city;

    /**
     * 
     */
    @TableField(value = "districts")
    private String districts;

    /**
     * 
     */
    @TableField(value = "address")
    private String address;

    /**
     * 
     */
    @TableField(value = "tel")
    private String tel;

    /**
     * 
     */
    @TableField(value = "receiver")
    private String receiver;

    /**
     * 
     */
    @TableField(value = "isDefault")
    private Integer isDefault;
}