package com.shucheng.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class jdbcUtils {
    private static DruidDataSource dataSource;
    static {
            Properties properties = new Properties();
        try {
            properties.load(jdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //从数据库连接池中获取数据库连接
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

  /*测试语句
    public static void main(String[] args) {
        Connection conn = jdbcUtils.getConn();
        System.out.println(conn);
    }*/
    //关闭数据库连接
    public static void close(Connection conn){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
