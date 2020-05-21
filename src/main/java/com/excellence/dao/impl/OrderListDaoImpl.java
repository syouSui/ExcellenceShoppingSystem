package com.excellence.dao.impl;

import com.excellence.dao.OrderListDao;
import com.excellence.model.OrderList;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName OrderListDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:07:00 星期三
 * @Description TODO
 */
public class OrderListDaoImpl implements OrderListDao {

    @Override
    public List<OrderList> findBy_userName ( String userName ) {
        return null;
    }
    @Override
    public OrderList add ( OrderList orderList ) {
        return null;
    }
    @Override
    public boolean remove ( OrderList orderList ) {
        return false;
    }
    @Override
    public boolean modify ( OrderList orderList ) {
        return false;
    }
    @Override
    public boolean modifyOrderStatusByUserName ( String userName ) {
        return false;
    }
}
