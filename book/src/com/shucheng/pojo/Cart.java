package com.shucheng.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class Cart {
    //private Integer totalCount;
   // private BigDecimal totalPrice;
    //private List<CartItem> items = new ArrayList<>();
    private Map<Integer,CartItem> items = new LinkedHashMap<>();
    //添加到购物车
    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());
        if (item == null){
            items.put(cartItem.getId(),cartItem);
        }else {
            //更新商品数量
            item.setCount(item.getCount()+1);
            //更新商品总价
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }
    //从购物车中删除
    public void deleteItem(Integer id ){
        items.remove(id);
    }
    //清空购物车
    public void clear( ){
        items.clear();
    }
    //修改购物车中商品数量
    public void updateCount( Integer id,Integer count){
        CartItem cartItem = items.get(id);
        if (cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public Cart() {
        super();
    }
    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem item:items.values()){
            totalCount += item.getCount();
        }
        return totalCount;
    }

   /* public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }*/

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem item:items.values()){
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }

   /* public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }*/

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}

