package com.shucheng.service;

import com.shucheng.pojo.Cart;
import com.shucheng.pojo.Order;

import java.util.List;

/**
 * @Author 黄仔杰
 * @Date 2020/9/11 1:18
 * @Version 1.8
 */

public interface OrderService {
    public String saveOrder(Cart cart,Integer userId);

    public Order queryOrderByOrderId(Integer orderId);

    public List<Order> queryOrders();
}
