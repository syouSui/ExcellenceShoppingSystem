package com.excellence.dao.impl;

import com.excellence.dao.OrderListDao;
import com.excellence.model.OrderList;
import com.excellence.util.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
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
public class OrderListDaoImpl extends C3P0Utils implements OrderListDao {
    private String selectSQL= "select * from order_list where 1=1 ";
    private String select_userName = "and userName = ? ";
    private String insertSQL = "insert into order_list values(?,?,?,?,?,?,?,?,?)";
    private String removeSQL = "delete from order_list where orderId = ? and orderDate = ? and userName = ? and goodsNumber = ? ";
    private String modifySQL = "update order_list set counter = ?,relativeName = ?, address = ?, relativePhone = ?, orderStatus = ? where orderId = ? and orderDate = ? and userName = ? and goodsNumber = ? ";

    @Override
    public List<OrderList> findBy_userName ( String userName ) {
        List<OrderList> orderLists =new ArrayList<>();
        Connection conn = super.getConnection();
        Object[] param = new Object[]{ userName };
        try {
            orderLists = new QueryRunner(super.getDataSource()).query(
                    super.getConnection(),
                    selectSQL+select_userName,
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
                orderList.getOrderStatus()+""
        };
        try {
            count = new QueryRunner(super.getDataSource()).update(
                    super.getConnection(),
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
                    super.getConnection(),
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
                    super.getConnection(),
                    modifySQL,
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return count;
    }

}
