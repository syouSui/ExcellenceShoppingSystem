package com.excellence.dao.impl;

import com.excellence.dao.ShoppingCartDao;
import com.excellence.model.ShoppingCart;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ShoppingCartDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:08:00 星期三
 * @Description TODO
 */
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    @Override
    public List<ShoppingCart> findBy_userName ( String userName ) {
        return null;
    }
    @Override
    public ShoppingCart add ( ShoppingCart shoppingCart ) {
        return null;
    }
    @Override
    public int remove ( ShoppingCart shoppingCart ) {
        return 0;
    }
    @Override
    public int modify ( ShoppingCart shoppingCart ) {
        return 0;
    }
}
