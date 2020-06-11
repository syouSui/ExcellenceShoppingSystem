package com.excellence.dao.impl;

import com.excellence.dao.StoreDao;
import com.excellence.model.Store;
import com.excellence.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName StoreDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-06-03 18:19:00 星期三
 * @Description TODO
 */
public class StoreDaoImpl extends C3P0Util implements StoreDao {
    private String selectSQL = "select * from store where 1=1 ";
    private String selectBy_storeName = " and storeName like ? ";
    private String selectBy_storeId = " and storeId=? ";
    private String selectBy_userName = " and userName=? ";
    private String countSQL = "select count(*) from store where 1=1 ";
    private String insertSQL = "insert into store values(?,?,?,?,?) ";
    private String modifySQL = "update store set storeName=?, storePicture=?, storeDescription=? where storeId=? ";
    private String removeSQL = "delete from store where storeId=? ";

    final private int default_pageSize = 10;

    @Override
    public List<Store> findAllStore ( int currentPage, int pageSize ) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<Store> list = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + "limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>( Store.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }

    @Override
    public int count_findAllStore ( ) {
        Long count = 0L;
        Object[] param = new Object[] { };
        Connection conn = super.getConnection( );
        try {
            count = (Long) new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    countSQL,
                    new ArrayHandler( ),
                    param
            )[0];
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count.intValue( );
    }

    @Override
    public List<Store> findBy_storeName ( String storeName, int currentPage, int pageSize ) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<Store> list = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { "%" + storeName + "%" };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + selectBy_storeName + "limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>( Store.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;

    }

    @Override
    public int count_findBy_storeName ( String storeName ) {
        Long count = 0L;
        Object[] param = new Object[] { "%" + storeName + "%" };
        Connection conn = super.getConnection( );
        try {
            count = (Long) new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    countSQL + selectBy_storeName,
                    new ArrayHandler( ),
                    param
            )[0];
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count.intValue( );
    }

    @Override
    public Store findBy_storeId ( String storeId ) {
        Store store = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { storeId };
        try {
            store = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + selectBy_storeId,
                    new BeanHandler<>( Store.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return store;
    }

    @Override
    public Store findBy_userName ( String userName ) {
        Store store = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { userName };
        try {
            store = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + selectBy_userName,
                    new BeanHandler<>( Store.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return store;
    }

    @Override
    public int addStore ( Store store ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                store.getStoreId( ),
                store.getStoreName( ),
                store.getStorePicture( ),
                store.getStoreDescription( ),
                store.getUserName( )
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    insertSQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int removeStore ( String storeId ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                storeId
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    removeSQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int modifyStore ( String storeId, Store store ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                store.getStoreName( ),
                store.getStorePicture( ),
                store.getStoreDescription( ),
                storeId
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    modifySQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }

}




