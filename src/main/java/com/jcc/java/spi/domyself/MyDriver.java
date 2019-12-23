package com.jcc.java.spi.domyself;


import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.NonRegisteringDriver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: javaknowledge->MyDriver
 * @description: 自定义Driver
 * @author: jinchuanchuan1@le.com
 * @create: 2019-12-23 14:56
 **/
public class MyDriver extends NonRegisteringDriver implements java.sql.Driver {

    static {
        try {
            java.sql.DriverManager.registerDriver(new Driver());
        } catch (SQLException E) {
            throw new RuntimeException("Can't register driver!");
        }
    }

    /**
     * Construct a new driver and register it with DriverManager
     *
     * @throws SQLException if a database error occurs.
     */
    public MyDriver() throws SQLException {
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        System.out.println("准备创建数据库连接.url:"+url);
        System.out.println("JDBC配置信息："+info);
        info.setProperty("user", "root");
        info.setProperty("password", "jiechuan");
        Connection connection =  super.connect(url, info);
        System.out.println("数据库连接创建完成"+connection.toString());
        return connection;
    }

}
