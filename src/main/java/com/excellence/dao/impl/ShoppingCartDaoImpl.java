package com.excellence.dao.impl;

import com.excellence.dao.ShoppingCartDao;
import com.excellence.model.ShoppingCart;
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
 * @ClassName ShoppingCartDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:08:00 星期三
 * @Description TODO
 */
public class ShoppingCartDaoImpl extends C3P0Utils implements ShoppingCartDao {
    private String selectSQL = "select * from shopping_cart where 1=1 ";
    private String select_userName = "and userName = ? ";
    private String select_goodsNumber = "and goodsNumber=? ";
    private String insertSQL = "insert into shopping_cart values(?,?,?)";
    private String removeSQL = "delete from shopping_cart where userName = ? and goodsNumber = ? and counter = ?";
    private String modifySQL = "update shopping_cart set counter = ? where userName = ? and goodsNumber = ? ";
    private String addSQL = "update shopping_cart set counter = counter+? where userName = ? and goodsNumber = ? ";

    final private int default_pageSize = 10;

    @Override
    public List<ShoppingCart> findBy_userName ( String userName, int currentPage, int pageSize ) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<ShoppingCart> shoppingCartList = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { userName };
        try {
            shoppingCartList = new QueryRunner( super.getDataSource( ) ).query(
                    super.getConnection( ),
                    selectSQL + select_userName + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>( ShoppingCart.class ),
                    param );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return shoppingCartList;
    }

    @Override
    public int add ( ShoppingCart shoppingCart ) {
        List<ShoppingCart> list = null;
        Connection conn = super.getConnection( );
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + select_userName,
                    new BeanListHandler<>( ShoppingCart.class ),
                    new Object[] {
                            shoppingCart.getUserName( ),
                    }
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        if ( list.size( ) > 99 ) return -1;
        list = null;
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + select_userName + select_goodsNumber,
                    new BeanListHandler<>( ShoppingCart.class ),
                    new Object[] {
                            shoppingCart.getUserName( ),
                            shoppingCart.getGoodsNumber( )
                    }
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        int count = 0;
        if ( list.size( ) != 0 ) {
            count = addCount( shoppingCart, shoppingCart.getCounter( ) );
        } else {
            Object[] param = new Object[] {
                    shoppingCart.getUserName( ),
                    shoppingCart.getGoodsNumber( ),
                    shoppingCart.getCounter( ) + "",
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
        }
        return count;
    }

    @Override
    public int remove ( ShoppingCart shoppingCart ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                shoppingCart.getUserName( ),
                shoppingCart.getGoodsNumber( ),
                shoppingCart.getCounter( ) + "",
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
    public int modifyCount ( ShoppingCart shoppingCart, int num ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                num + "",
                shoppingCart.getUserName( ),
                shoppingCart.getGoodsNumber( ),
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

    @Override
    public int addCount ( ShoppingCart shoppingCart, int num ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                num + "",
                shoppingCart.getUserName( ),
                shoppingCart.getGoodsNumber( ),
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    addSQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }
}
