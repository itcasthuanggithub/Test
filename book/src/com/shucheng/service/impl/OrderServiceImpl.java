package com.shucheng.service.impl;

import com.shucheng.dao.BookDao;
import com.shucheng.dao.OrderDao;
import com.shucheng.dao.OrderItemDao;
import com.shucheng.dao.impl.BookDaoImpl;
import com.shucheng.dao.impl.OrderDaoImpl;
import com.shucheng.dao.impl.OrderItemDaoImpl;
import com.shucheng.pojo.*;
import com.shucheng.service.OrderService;

import java.util.Date;
import java.util.List;

/**
 * @Author 黄仔杰
 * @Date 2020/9/11 1:20
 * @Version 1.8
 */

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String saveOrder(Cart cart, Integer userId) {
        //调用 orderDao 保存订单
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
        //调用 orderItemDao 保存订单项
        for(CartItem cartItem:cart.getItems().values()){
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);

            //更新图书库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            //更新
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        return orderId;
    }
//查询所有订单
    @Override
    public Order queryOrderByOrderId(Integer orderId) {
        return null;
    }

    @Override
    public List<Order> queryOrders() {
        return null;
    }
}
