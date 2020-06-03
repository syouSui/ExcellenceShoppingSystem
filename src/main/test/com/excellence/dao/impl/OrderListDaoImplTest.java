package com.excellence.dao.impl;

import com.excellence.dao.OrderListDao;
import com.excellence.dao.UserDao;
import com.excellence.model.OrderList;
import com.excellence.model.User;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * OrderListDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>5月 21, 2020</pre>
 */
public class OrderListDaoImplTest {

    static OrderListDaoImpl orderListDao = new OrderListDaoImpl( );
    static List<OrderList> orderLists = new ArrayList<>( );

    @Before
    public void before ( ) throws Exception {
    }

    @After
    public void after ( ) throws Exception {
    }

    /**
     * Method: findBy_userName(String userName)
     */
    @Test
    public void testFindBy_userName ( ) throws Exception {
        orderLists = orderListDao.findBy_userName( "lyx", 1, 100 );
        for ( OrderList o : orderLists ) {
            System.out.println(
                    o.getAddress( ) + "\t" +
                            o.getRelativeName( ) + "\t" +
                            o.getOrderDate( )
            );
        }
        System.out.println( orderListDao.count_findBy_userName( "lyx" ) );
    }

    /**
     * Method: add(OrderList orderList)
     */
    @Test
    public void testAdd ( ) throws Exception {

        orderListDao.add( new OrderList(
                "12",
                OrderList.getSystemDateString( ),
                "lyx",
                "000988888",
                66,
                "lux",
                "lyx",
                "12314",
                1 )
        );

    }

    /**
     * Method: remove(OrderList orderList)
     */
    @Test
    public void testRemove ( ) throws Exception {
        orderListDao.remove( new OrderList(
                "12",
                "2020-05-22 02:36:57",
                "lyx",
                "000988888",
                99,
                "lyx_test",
                "wfu",
                "18888889999",
                1 )
        );
    }

    /**
     * Method: modify(OrderList orderList)
     */
    @Test
    public void testModify ( ) throws Exception {
        orderListDao.modify( new OrderList(
                "12",
                "2020-05-25 08:58:36",
                "lyx",
                "000988888",
                99,
                "lyx_test",
                "wfu",
                "-1",
                1 )
        );
    }

} 
