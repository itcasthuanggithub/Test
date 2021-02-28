package com.shucheng.dao;

        import com.shucheng.pojo.User;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public interface UserDao {
 /* 通过用户名查询用户信息
  *如果正常返回说明用户名已存在，如果返回null说明用户名可用
  * */
 public User queryByUsername(String username);

 /*通过用户名和密码查询到用户信息
  * username
  * password
  * 如果正常返回，说明可用正常登陆。否则登陆失败
  * */
 public User queryByUsernameAndPassword(String username,String password);
 /*保存用户信息
  *uer
  * 如果返回 -1 说明保存失败
  * */
 public int saveUser(User user);
}
