package com.shucheng.dao.impl;

import com.shucheng.dao.BaseDao;
import com.shucheng.dao.UserDao;
import com.shucheng.pojo.User;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryByUsername(String username) {
        String sql = "select id,username,password from t_user where username=?";
        return queryForOne(User.class,sql,username);

    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password) values(?,?)";
        return update(sql,user.getUsername(),user.getPassword());

    }
}
