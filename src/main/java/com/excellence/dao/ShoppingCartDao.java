package com.excellence.dao;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ShoppingCartDao.java
 * @PackageLoaction com.excellence.dao
 * @createTime 2020-05-20 16:15:00 星期三
 * @Description TODO
 */

import com.excellence.model.ShoppingCart;

import java.util.List;

/**
 * find
 * add
 * remove
 * modify
 */
public interface ShoppingCartDao {
    public List<ShoppingCart> findBy_userName ( String userName, int currentPage, int pageSize );

    public int count_findBy_userName ( String userName );

    public int add ( ShoppingCart shoppingCart );

    public int remove ( ShoppingCart shoppingCart );

    public int modifyCount ( ShoppingCart shoppingCart, int num );

    public int addCount ( ShoppingCart shoppingCart, int num );
}
