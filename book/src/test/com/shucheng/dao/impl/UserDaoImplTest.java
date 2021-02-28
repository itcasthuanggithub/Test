    package test.com.shucheng.dao.impl;

    import com.shucheng.dao.UserDao;
    import com.shucheng.dao.impl.UserDaoImpl;
    import com.shucheng.pojo.User;
    import org.junit.After;
    import org.junit.Before;
    import org.junit.Test;

    /**
    * UserDaoImpl Tester.
    *
    * @author <Authors name>
    * @since <pre>9月 3, 2020</pre>
    * @version 1.0
    */
    public class UserDaoImplTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testQueryByUsername() throws Exception {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryByUsername("admin") != null){
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }

    @Test
    public void testQueryByUsernameAndPassword() throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryByUsernameAndPassword("admin","admin");
        if (user != null){
            System.out.println("登陆成功！");
        }else {
            System.out.println("登陆失败！");
        }
    }
    @Test
    public void testSaveUser() throws Exception {
        UserDao userDao = new UserDaoImpl();
        int resutl = userDao.saveUser(new User(null, "admin", "admin", "email@qq.com"));
        if (resutl != -1){
            System.out.println("用户保存成功！");
        }else {
            System.out.println("用户保存失败！");
        }
    }
    }
