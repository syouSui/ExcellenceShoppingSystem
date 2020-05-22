package com.excellence.dao.impl;

import com.excellence.dao.ShoppingCartDao;
import com.excellence.model.ShoppingCart;
import com.excellence.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ShoppingCartDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:08:00 星期三
 * @Description TODO
 */
public class ShoppingCartDaoImpl extends DBUtil implements ShoppingCartDao {
    String selectSQL = "select * from shopping_cart where 1=1 ";
    String select_userName = "and userName = ? ";
    String insertSQL = "insert into shopping_cart values(?,?,?)";
    String removeSQL = "delete from shopping_cart where userName = ? and goodsNumber = ? and counter = ?";
    String modifySQL = "update shopping_cart set counter = ? where userName = ? and goodsNumber = ? ";

    @Override
    public List<ShoppingCart> findBy_userName ( String userName ) {
        List<ShoppingCart> shoppingCartList = new ArrayList<>( );
        ResultSet resultSet = null;
        String[] param = new String[] { userName };
        super.getConnection( );
        resultSet = super.executeQuery( selectSQL + select_userName, param );
        try {
            while ( resultSet.next( ) ) {
                ShoppingCart shoppingCart = new ShoppingCart(
                        resultSet.getString( "userName" ),
                        resultSet.getString( "goodsNumber" ),
                        resultSet.getInt( "counter" )
                );
                shoppingCartList.add( shoppingCart );
            }
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeAll( );
        return shoppingCartList;
    }

    @Override
    public int add ( ShoppingCart shoppingCart ) {
        int count = 0;
        String[] param = new String[] {
                shoppingCart.getUserName( ),
                shoppingCart.getGoodsNumber( ),
                shoppingCart.getCounter( ) + "",
        };
        super.getConnection( );
        count = super.executeUpdate( insertSQL, param );
        super.closeAll( );
        return count;
    }

    @Override
    public int remove ( ShoppingCart shoppingCart ) {//#########################################################
        int count = 0;
        String[] param = new String[] {
                shoppingCart.getUserName( ),
                shoppingCart.getGoodsNumber( ),
                shoppingCart.getCounter( ) + "",
        };
        super.getConnection( );
        count = super.executeUpdate( removeSQL, param );
        super.closeAll( );
        return count;
    }

    @Override
    public int modifyCount ( ShoppingCart shoppingCart, int num ) {
        int count = 0;
        String[] param = new String[] {
                num + "",
                shoppingCart.getUserName( ),
                shoppingCart.getGoodsNumber( ),
        };
        super.getConnection( );
        count = super.executeUpdate( modifySQL, param );
        super.closeAll( );
        return count;
    }
}
