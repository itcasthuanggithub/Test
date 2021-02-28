package com.shucheng.test;

import com.shucheng.utils.jdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class jdbcUtilsTest {
    @Test
    public void getConnTest(){
        for (int i = 0; i < 10; i++) {
            Connection conn = jdbcUtils.getConn();
            System.out.println(conn);
            jdbcUtils.close(conn);//关闭程序
        }

    }
}
