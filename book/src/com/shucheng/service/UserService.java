package com.shucheng.service;

import com.shucheng.pojo.User;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public interface UserService {
    /*
    * 用户注册
    * user
    * */
    public void regist(User user);
    /*用户登陆
    * username
    * password
    * 如果返回User 说明登陆成功，如果返回null 说明登陆失败
    * */
    public User login(String username,String password);
    /*
    * 判断用户名是否存在
    * username
    * return ： 如果返回null 说明用户名可用*/
    public boolean existUsername(String username);
}
