package com.excellence.dao.impl;

import com.excellence.dao.OrderListDao;
import com.excellence.model.OrderList;
import com.excellence.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author acmaker & Kaffu-chino
 * @version 1.0.0
 * @ClassName OrderListDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:07:00 星期三
 * @Description TODO
 */
public class OrderListDaoImpl extends C3P0Util implements OrderListDao {
    private String selectSQL= "select * from order_list where 1=1 ";
    private String countSQL = "select count(*) from order_list where 1=1 ";
    private String select_userName = "and userName = ? ";
    private String select_storeId = "and storeId = ? ";
    private String select_orderId = "and orderId = ? ";
    private String insertSQL = "insert into order_list values(?,?,?,?,?,?,?,?,?,?)";
    private String removeSQL = "delete from order_list where orderId = ? and orderDate = ? and userName = ? and goodsNumber = ? ";
    private String modifySQL = "update order_list set counter = ?,relativeName = ?, address = ?, relativePhone = ?, orderStatus = ? where orderId = ? and orderDate = ? and userName = ? and goodsNumber = ? ";
    private String modifySQL_orderStatus = "update order_list set orderStatus = ? where orderId = ? ";

    final private int default_pageSize = 10;

    @Override
    public List<OrderList> findBy_orderId(String orderId, int currentPage, int pageSize) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<OrderList> orderLists =new ArrayList<>();
        Connection conn = super.getConnection();
        Object[] param = new Object[]{ orderId };
        try {
            orderLists = new QueryRunner(super.getDataSource()).query(
                    conn,
                    selectSQL+ select_orderId + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>(OrderList.class),
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return orderLists;
    }

    @Override
    public int count_findBy_orderId(String orderId) {
        Long count = 0L;
        Object[] param = new Object[] { orderId };
        Connection conn = super.getConnection( );
        try {
            count = (Long)new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    countSQL+ select_orderId,
                    new ArrayHandler( ),
                    param
            )[0];
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count.intValue();
    }

    @Override
    public List<OrderList> findAll(int currentPage, int pageSize) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<OrderList> orderLists =new ArrayList<>();
        Connection conn = super.getConnection();
        Object[] param = new Object[]{ };
        try {
            orderLists = new QueryRunner(super.getDataSource()).query(
                    conn,
                    selectSQL + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>(OrderList.class),
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return orderLists;
    }

    @Override
    public int count_findAll() {
        Long count = 0L;
        Object[] param = new Object[] {  };
        Connection conn = super.getConnection( );
        try {
            count = (Long)new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    countSQL,
                    new ArrayHandler( ),
                    param
            )[0];
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count.intValue();
    }

    @Override
    public List<OrderList> findBy_storeId(String storeId, int currentPage, int pageSize) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<OrderList> orderLists =new ArrayList<>();
        Connection conn = super.getConnection();
        Object[] param = new Object[]{ storeId };
        try {
            orderLists = new QueryRunner(super.getDataSource()).query(
                    conn,
                    selectSQL+ select_storeId + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>(OrderList.class),
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return orderLists;
    }

    @Override
    public int count_findBy_storeId(String storeId) {
        Long count = 0L;
        Object[] param = new Object[] { storeId };
        Connection conn = super.getConnection( );
        try {
            count = (Long)new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    countSQL+ select_storeId,
                    new ArrayHandler( ),
                    param
            )[0];
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count.intValue();
    }

    @Override
    public List<OrderList> findBy_userName ( String userName, int currentPage, int pageSize) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<OrderList> orderLists =new ArrayList<>();
        Connection conn = super.getConnection();
        Object[] param = new Object[]{ userName };
        try {
            orderLists = new QueryRunner(super.getDataSource()).query(
                    conn,
                    selectSQL+select_userName + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>(OrderList.class),
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return orderLists;
    }

    @Override
    public int count_findBy_userName ( String userName ) {
        Long count = 0L;
        Object[] param = new Object[] { userName  };
        Connection conn = super.getConnection( );
        try {
            count = (Long)new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    countSQL+ select_userName,
                    new ArrayHandler( ),
                    param
            )[0];
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count.intValue();
    }

    @Override
    public int add ( OrderList orderList ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[]{
                orderList.getOrderId(),
                orderList.getOrderDate()+"",
                orderList.getUserName(),
                orderList.getGoodsNumber(),
                orderList.getCounter()+"",
                orderList.getRelativeName(),
                orderList.getAddress(),
                orderList.getRelativePhone(),
                orderList.getOrderStatus()+"",
                orderList.getStoreId()
        };
        try {
            count = new QueryRunner(super.getDataSource()).update(
                    conn,
                    insertSQL,
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int remove ( OrderList orderList ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[]{
                orderList.getOrderId(),
                orderList.getOrderDate()+"",
                orderList.getUserName(),
                orderList.getGoodsNumber(),
        };
        try {
            count = new QueryRunner(super.getDataSource()).update(
                    conn,
                    removeSQL,
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int modify ( OrderList orderList ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[]{
                orderList.getCounter()+"",
                orderList.getRelativeName(),
                orderList.getAddress(),
                orderList.getRelativePhone(),
                orderList.getOrderStatus()+"",
                orderList.getOrderId(),
                orderList.getOrderDate()+"",
                orderList.getUserName(),
                orderList.getGoodsNumber()
        };
        try {
            count = new QueryRunner(super.getDataSource()).update(
                    conn,
                    modifySQL,
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int modify_orderStatus_By_orderId(String orderId,int orderStatus) {
        int countModify = 0;
        int countFind = count_findBy_orderId(orderId);
        Connection conn = super.getConnection();
        Object[] param = new Object[]{
                orderStatus,
                orderId
        };
        try {
            countModify = new QueryRunner(super.getDataSource()).update(
                    conn,
                    modifySQL_orderStatus,
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return (countModify == countFind && countModify != 0)?1 : 0;
    }

}
