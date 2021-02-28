package com.shucheng.dao.impl;

import com.shucheng.dao.BaseDao;
import com.shucheng.dao.OrderDao;
import com.shucheng.pojo.Order;

/**
 * @Author 黄仔杰
 * @Date 2020/9/10 21:50
 * @Version 1.8
 */

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateDate(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
