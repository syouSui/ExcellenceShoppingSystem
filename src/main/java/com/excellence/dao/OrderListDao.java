package com.excellence.dao;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName OrderListDao.java
 * @PackageLoaction com.excellence.dao
 * @createTime 2020-05-20 16:14:00 星期三
 * @Description TODO
 */

import com.excellence.model.OrderList;

import java.util.List;

/**
 * find
 * add
 * remove
 * modify
 */
public interface OrderListDao {
    public List<OrderList> findBy_userName( String userName);

    public OrderList add ( OrderList orderList );

    public int remove ( OrderList orderList );

    public int modify ( OrderList orderList );

    public int modifyOrderStatusByUserName( String userName );
}
