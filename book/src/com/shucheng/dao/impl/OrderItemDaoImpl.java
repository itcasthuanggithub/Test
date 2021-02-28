package com.shucheng.dao.impl;

import com.shucheng.dao.BaseDao;
import com.shucheng.dao.OrderItemDao;
import com.shucheng.pojo.OrderItem;

/**
 * @Author 黄仔杰
 * @Date 2020/9/10 21:54
 * @Version 1.8
 */

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
