package test.com.shucheng.service.impl; 

import com.shucheng.pojo.User;
import com.shucheng.service.UserService;
import com.shucheng.service.impl.UserServiceImpl;
import org.junit.Test;

/** 
* UserServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>9月 3, 2020</pre>
* @version 1.0 
*/ 
public class UserServiceImplTest { 

/** 
* 
* Method: regist(User user) 
* 
*/ 
@Test
public void testRegist() throws Exception {
    UserService userService = new UserServiceImpl();
    userService.regist(new User(null,"daye","daye","daye@qq.com"));

}

/** 
* 
* Method: login(String username, String password) 
* 
*/ 
@Test
public void testLogin() throws Exception {
    UserService userService = new UserServiceImpl();
    User user = userService.login("admin","admin");
    if (user==null){
        System.out.println("登录失败！");
    }else {
        System.out.println("登陆成功！");
    }
}
/** 
* 
* Method: existUsername(String username) 
* 
*/ 
@Test
public void testExistUsername() throws Exception {
    UserService userService = new UserServiceImpl();
    if ( userService.existUsername("admin")){
        System.out.println("用户名已存在！");
    }else {
        System.out.println("用户名可用！");
    }
}


} 
