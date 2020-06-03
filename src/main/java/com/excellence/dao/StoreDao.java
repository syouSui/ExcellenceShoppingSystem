package com.excellence.dao;

import com.excellence.model.Store;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName StoreDao.java
 * @PackageLoaction com.excellence.dao
 * @createTime 2020-06-03 17:54:00 星期三
 * @Description TODO
 */
public interface StoreDao {
    public List<Store> findAllStore ( int currentPage, int pageSize );

    public int count_findAllStore ( );

    public List<Store> findBy_storeName ( String storeName, int currentPage, int pageSize );

    public int count_findBy_storeName ( String storeName );

    public Store findBy_storeId ( String storeId );

    public Store findBy_userName ( String userName );

    public int addStore ( Store store );

    public int modifyStore ( String storeId, Store store );

    public int removeStore ( String storeId );

}
