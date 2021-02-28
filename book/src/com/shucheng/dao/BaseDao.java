package com.shucheng.dao;

import com.shucheng.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();
/*执行insert update delete语句
* sql： 要执行是sql语句
* args： 要执行的sql语句参数值
* return： 手影响的行数
* */
    public int update(String sql, Object...args){
        Connection conn = jdbcUtils.getConn();
        try {
            return queryRunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return -1;
    }
        /*返回javaBean的方法
        * sql：要执行的sql语句
        * srgd：执行的sql语句的参数值
        * <T>：返回JavaBean的泛型
        * return：返回-1说明查询失败
        * */
    public <T>T queryForOne(Class<T> type,String sql,Object...args){
        Connection conn = jdbcUtils.getConn();
        try {
           return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return null;
    }
        /*返回多个JavaBean 的多个方法
        * type：
        * sql：
        * args：
        * <T>:
        * */
    public <T>List<T> queryForList(Class<T> type,String sql,Object...args){
        Connection conn = jdbcUtils.getConn();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }

        return null;
    }

    public Object queryForSingleValue(String sql,Object...args){
        Connection conn = jdbcUtils.getConn();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }

        return null;
    }
}
