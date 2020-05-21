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
    public int remove ( OrderList orderList ) {
        return 0;
    }
    @Override
    public int modify ( OrderList orderList ) {
        return 0;
    }
    @Override
    public int modifyOrderStatusByUserName ( String userName ) {
        return 0;
    }
}
