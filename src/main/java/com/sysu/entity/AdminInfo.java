package com.sysu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 
 * @TableName admins
 */
@TableName(value ="admins")
@Data
public class AdminInfo {
    /**
     * 
     */
    @TableId(value = "adminID", type = IdType.AUTO)
    private Integer adminID;

    /**
     * 
     */
    @TableField(value = "passwords")
    @JsonProperty("password")
    private String passwords;

    /**
     * 
     */
    @TableField(value = "adminName")
    private String adminName;

    /**
     * 
     */
    @TableField(value = "tel")
    private String tel;

    /**
     * 
     */
    @TableField(value = "mail")
    private String mail;

    /**
     * 
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 
     */
    @TableField(value = "age")
    private Integer age;
}