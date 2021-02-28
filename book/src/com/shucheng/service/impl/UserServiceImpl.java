package com.shucheng.service.impl;

import com.shucheng.dao.UserDao;
import com.shucheng.dao.impl.UserDaoImpl;
import com.shucheng.pojo.User;
import com.shucheng.service.UserService;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void regist(User user) {
        int resutl = userDao.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.queryByUsernameAndPassword(username,password);
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryByUsername(username)==null){
            //如果返回null，说明不存在
            return false;
        }
        return true;
    }
}
