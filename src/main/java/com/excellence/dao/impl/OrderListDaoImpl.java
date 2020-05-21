package com.excellence.dao.impl;

import com.excellence.dao.OrderListDao;
import com.excellence.model.OrderList;
import com.excellence.util.DBUtil;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.OptionalDouble;

/**
 * @author acmaker &
 * @version 1.0.0
 * @ClassName OrderListDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:07:00 星期三
 * @Description TODO
 */
public class OrderListDaoImpl extends DBUtil implements OrderListDao {
    String selectSQL= "select * from order_list where 1=1 ";
    String select_userName = "and userName = ? ";
    String insertSQL = "insert into user values(?,?,?,?,?,?,?,?,?)";
    String modifySQL = "update order_list set counter = ?, relativeName = ?, address = ?, relativeName = ?, address = ?, relativePhone = ?, orderStatus = ? where orderId = ? and orderDate = ? and userName = ? and goodsNumber = ? ";
    String removeSQL = "delete from order_list where orderId = ? and orderDate = ? and userName = ? and goodsNumber = ? ";

    @Override
    public List<OrderList> findBy_userName ( String userName ) {
        List<OrderList> orderLists = null;
        ResultSet resultSet = null;
        String[] param = new String[]{ userName };
        super.getConnection();
        resultSet = super.executeQuery(selectSQL+select_userName,param);
        try {
            while (resultSet.next()) {
                OrderList orderList = new OrderList(
                        resultSet.getString("orderId"),
                        resultSet.getDate("orderDate"),
                        resultSet.getString("userName"),
                        resultSet.getNString("goodsNumber"),
                        resultSet.getInt("counter"),
                        resultSet.getString("relativeName"),
                        resultSet.getString("address"),
                        resultSet.getString("relativePhone"),
                        resultSet.getInt("orderStatus")
                );
                orderLists.add(orderList);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        super.closeAll();
        return orderLists;
    }

    @Override
    public int add ( OrderList orderList ) {
        int count = 0;
        String[] param = new String[]{
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
        super.getConnection();
        count = super.executeUpdate(insertSQL,param);
        super.closeAll();
        return count;
    }

    @Override
    public int remove ( OrderList orderList ) {
        int count = 0;
        String[] param = new String[]{
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
        super.getConnection();
        count = super.executeUpdate(removeSQL,param);
        super.closeAll();
        return count;
    }

    @Override
    public int modify ( OrderList orderList ) {
        int count = 0;
        String[] param = new String[]{
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
        super.getConnection();
        count = super.executeUpdate(modifySQL,param);
        return count;
    }

    @Override
    public int modifyOrderStatusByUserName (String userName) {//#########################################################
        return 0;
    }
}
