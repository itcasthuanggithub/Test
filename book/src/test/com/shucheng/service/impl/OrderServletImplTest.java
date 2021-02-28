    package test.com.shucheng.service.impl;

    import com.shucheng.pojo.Cart;
    import com.shucheng.pojo.CartItem;
    import com.shucheng.service.OrderService;
import com.shucheng.service.impl.OrderServiceImpl;
import org.junit.Test;

    import java.math.BigDecimal;

    /**
    * OrderServiceImpl Tester.
    *
    * @author <Authors name>
    * @since <pre>9�� 11, 2020</pre>
    * @version 1.0
    */
    public class OrderServletImplTest {

    /**
    *
    * Method: saveOrder(Cart cart, Integer userId)
    *
    */
    @Test
    public void testSaveOrder() throws Exception {
        OrderService orderService = new OrderServiceImpl();
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"金瓶梅",1,new BigDecimal(200),new BigDecimal(500)));
        cart.addItem(new CartItem(1,"金瓶梅",1,new BigDecimal(300),new BigDecimal(300)));
        cart.addItem(new CartItem(2,"平凡的世界",1,new BigDecimal(2000),new BigDecimal(2000)));

        String orderId = orderService.saveOrder(cart,1);
        System.out.println(orderId);
    }


    }
