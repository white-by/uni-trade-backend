package com.sysu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@RestController
public class DbTestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/db-test")
    public String testConnection() {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            return "数据库连接成功！<br/>" +
                    "数据库URL: " + metaData.getURL() + "<br/>" +
                    "用户名: " + metaData.getUserName() + "<br/>" +
                    "数据库产品: " + metaData.getDatabaseProductName() + "<br/>" +
                    "版本: " + metaData.getDatabaseProductVersion();
        } catch (SQLException e) {
            return "数据库连接失败: " + e.getMessage();
        }
    }
}