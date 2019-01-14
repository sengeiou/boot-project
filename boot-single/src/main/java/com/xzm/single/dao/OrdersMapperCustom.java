package com.xzm.single.dao;

import com.xzm.single.entity.Orders;
import com.xzm.single.entity.OrdersCustom;
import com.xzm.single.entity.User;

import java.util.List;

/**
 * Created by 10412 on 2016/12/4.
 */
//@Mapper
public interface OrdersMapperCustom
{

    //查询订单关联查询用户信息
    public List<OrdersCustom> findOrdersUser() ;

    //查询订单关联查询用户信息
    public List<Orders> findOrdersUserResultMap() ;

    //查询订单及订单明细信息
    public List<Orders> findOrdersAndOrderDetailResultMap() ;

    //查询用户及用户购买商品信息
    public List<User> findUserAndItemsResultMap();

    //查询订单并且关联查询用户信息 关联用户信息用延迟加载
    public List<Orders> findOrdersUserLazyLoading();
}
