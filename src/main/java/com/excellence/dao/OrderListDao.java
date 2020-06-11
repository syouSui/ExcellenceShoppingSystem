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
    public List<OrderList> findBy_orderId ( String orderId, int currentPage, int pageSize );

    public int count_findBy_orderId ( String orderId );

    public List<OrderList> findAll ( int currentPage, int pageSize );

    public int count_findAll (  );

    public List<OrderList> findBy_storeId ( String storeId, int currentPage, int pageSize );

    public int count_findBy_storeId ( String storeId );

    public List<OrderList> findBy_userName ( String userName, int currentPage, int pageSize );

    public int count_findBy_userName ( String userName );

    public int add ( OrderList orderList );

    public int remove ( OrderList orderList );

    public int modify ( OrderList orderList );

    public int modify_orderStatus_By_orderId (String orderId,int orderStatus);

}
