package com.excellence.dao.impl;

import com.excellence.dao.ShoppingCartDao;
import com.excellence.model.ShoppingCart;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCartDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>5月 21, 2020</pre>
 */
public class ShoppingCartDaoImplTest extends TestCase {
    static ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl( );
    static List<ShoppingCart> shoppingCartList = new ArrayList<>( );

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
        shoppingCartDao.findBy_userName( "lyx" );
    }

    /**
     * Method: add(ShoppingCart shoppingCart)
     */
    @Test
    public void testAdd ( ) throws Exception {
        shoppingCartDao.add( new ShoppingCart(
                "lyx",
                "77272281",
                3 )
        );
    }

    /**
     * Method: remove(ShoppingCart shoppingCart)
     */
    @Test
    public void testRemove ( ) throws Exception {
        shoppingCartDao.remove( new ShoppingCart(
                "lyx",
                "77272281",
                3 )
        );
    }

    @Test
    public void testModifyCount ( ) {
        shoppingCartDao.modifyCount(
                new ShoppingCart(
                        "lyx",
                        "77272281",
                        3 ),
                99
        );
    }
}