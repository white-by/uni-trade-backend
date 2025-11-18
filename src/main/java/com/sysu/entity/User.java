package com.sysu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName users
 */
@TableName(value ="users")
@Data
public class User {
    /**
     * 
     */
    @TableId(value = "userID", type = IdType.AUTO)
    private Integer userID;

    /**
     * 
     */
    @TableField(value = "userName")
    private String userName;

    /**
     * 
     */
    @TableField(value = "passwords")
    private String passwords;

    /**
     * 
     */
    @TableField(value = "schoolID")
    private Integer schoolID;

    /**
     * 
     */
    @TableField(value = "picture")
    private String picture;

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
    @TableField(value = "userStatus")
    private Integer userStatus;
}