    package test.com.shucheng.dao.impl;

    import com.shucheng.dao.OrderItemDao;
    import com.shucheng.dao.impl.OrderItemDaoImpl;
    import com.shucheng.pojo.OrderItem;
    import org.junit.Test;

    import java.math.BigDecimal;

    /**
    * OrderDaoImpl Tester.
    *
    * @author <Authors name>
    * @since <pre>9�� 10, 2020</pre>
    * @version 1.0
    */
    public class OrderDaoImplTest {


    /**
    *
    * Method: saveOrder(Order order)
    *
    */
    @Test
    public void testSaveOrder() throws Exception {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"挪威的森林",1,new BigDecimal(65),new BigDecimal(87),"123456789"));
        orderItemDao.saveOrderItem(new OrderItem(null,"人生海海",2,new BigDecimal(55),new BigDecimal(88),"123456789"));
        orderItemDao.saveOrderItem(new OrderItem(null,"羊脂球",3,new BigDecimal(56),new BigDecimal(89),"123456789"));
    }
}
