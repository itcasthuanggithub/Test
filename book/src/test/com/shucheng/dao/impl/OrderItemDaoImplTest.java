    package test.com.shucheng.dao.impl;

    import com.shucheng.dao.OrderDao;
    import com.shucheng.dao.impl.OrderDaoImpl;
    import com.shucheng.pojo.Order;
    import org.junit.Test;

    import java.math.BigDecimal;
    import java.util.Date;

    /**
    * OrderItemDaoImpl Tester.
    *
    * @author <Authors name>
    * @since <pre>9月 10, 2020</pre>
    * @version 1.0
    */
    public class OrderItemDaoImplTest {

    /**
    *
    * Method: saveOrderItem(OrderItem orderItem)
    *
    */
    @Test
    public void testSaveOrderItem() throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("1111111111",new Date(),new BigDecimal(189),0,1));
    }


    }
