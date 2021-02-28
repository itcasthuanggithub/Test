    package test.com.shucheng.pojo;

    import com.shucheng.pojo.Cart;
    import com.shucheng.pojo.CartItem;
    import org.junit.Test;

    import java.math.BigDecimal;

    /**
    * Cart Tester.
    *
    * @author <Authors name>
    * @since <pre>9�� 10, 2020</pre>
    * @version 1.0
    */
    public class CartTest {

    @Test
    public void testAddItem() throws Exception {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"金瓶梅",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"金瓶梅",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"平凡的世界",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.deleteItem(1);
        cart.clear();
        cart.addItem(new CartItem(2,"坏小孩",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.updateCount(3,10);
        System.out.println(cart);
    }

    /**
    *
    * Method: deleteItem(Integer id)
    *
    */
    @Test
    public void testDeleteItem() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: clear()
    *
    */
    @Test
    public void testClear() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: updateCount(Integer id, Integer count)
    *
    */
    @Test
    public void testUpdateCount() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getTotalCount()
    *
    */
    @Test
    public void testGetTotalCount() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: setTotalCount(Integer totalCount)
    *
    */
    @Test
    public void testSetTotalCount() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getTotalPrice()
    *
    */
    @Test
    public void testGetTotalPrice() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: setTotalPrice(BigDecimal totalPrice)
    *
    */
    @Test
    public void testSetTotalPrice() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getItems()
    *
    */
    @Test
    public void testGetItems() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: setItems(Map<Integer, CartItem> items)
    *
    */
    @Test
    public void testSetItems() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: toString()
    *
    */
    @Test
    public void testToString() throws Exception {
    //TODO: Test goes here...
    }


    }
