package com.excellence.dao.impl;

import com.excellence.model.Goods;
import com.excellence.model.GoodsClassification;
import com.excellence.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName GoodsDao.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:05:00 星期三
 * @Description TODO
 */
public class GoodsDaoImpl extends DBUtil implements com.excellence.dao.GoodsDao {
    private String FINDAll = "select * from goods;";
    private String FINDBy_goodsName = "select * from goods where goodsName like  '%'|| ? ||'%'";
    private String FINDBy_goodsClassification = "select * from goods where goodsClassification=?;";
    private String ADD = "insert into goods values(?,?,?,?,?,?,?,?);";
    private String REMOVE = "delete from goods where goodsNumber=?;";
    private String MODIFY = "update goods as g set g.goodsPictureTop=?, g.goodsClassification=?, g.goodsName=?, g.priceOrigin=?, g.priceSale=?, g.counter=?, g.goodsPicture=? where g.goodsNumber=?;";

    @Override
    public List<Goods> findAllGoods ( ) {
        List<Goods> list = new ArrayList<>( );
        super.getConnection( );
        String[] param = new String[] { };
        ResultSet rs = null;
        rs = super.executeQuery( FINDAll, param );
        try {
            while ( rs.next( ) ) {
                list.add( new Goods(
                        rs.getString( "goodsNumber" ),
                        rs.getString( "goodsPictureTop" ),
                        rs.getString( "goodsClassification" ),
                        rs.getString( "goodsName" ),
                        rs.getFloat( "priceOrigin" ),
                        rs.getFloat( "priceSale" ),
                        rs.getInt( "counter" ),
                        rs.getString( "goodsPicture" )
                ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        super.closeAll( );
        return list;
    }
    @Override
    public List<Goods> findBy_goodsName ( String goodsName ) {
        List<Goods> list = new ArrayList<>( );
        super.getConnection( );
        String[] param = new String[] {
                goodsName
        };
        ResultSet rs = null;
        rs = super.executeQuery( FINDBy_goodsName, param );
        try {
            while ( rs.next( ) ) {
                list.add( new Goods(
                        rs.getString( "goodsNumber" ),
                        rs.getString( "goodsPictureTop" ),
                        rs.getString( "goodsClassification" ),
                        rs.getString( "goodsName" ),
                        rs.getFloat( "priceOrigin" ),
                        rs.getFloat( "priceSale" ),
                        rs.getInt( "counter" ),
                        rs.getString( "goodsPicture" )
                ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        super.closeAll( );
        return list;
    }
    @Override
    public List<Goods> findBy_goodsClassification ( String goodsClassification ) {
        List<Goods> list = new ArrayList<>( );
        super.getConnection( );
        String[] param = new String[] {
                goodsClassification
        };
        ResultSet rs = null;
        rs = super.executeQuery( FINDBy_goodsClassification, param );
        try {
            while ( rs.next( ) ) {
                list.add( new Goods(
                        rs.getString( "goodsNumber" ),
                        rs.getString( "goodsPictureTop" ),
                        rs.getString( "goodsClassification" ),
                        rs.getString( "goodsName" ),
                        rs.getFloat( "priceOrigin" ),
                        rs.getFloat( "priceSale" ),
                        rs.getInt( "counter" ),
                        rs.getString( "goodsPicture" )
                ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        super.closeAll( );
        return list;
    }
    @Override
    public int addGoods ( Goods goods ) {
        super.getConnection( );
        String[] param = new String[] {
                goods.getGoodsNumber( ),
                goods.getGoodsPictureTop( ),
                goods.getGoodsClassification( ),
                goods.getGoodsName( ),
                goods.getPriceOrigin( ) + "",
                goods.getPriceSale( ) + "",
                goods.getCounter( ) + "",
                goods.getGoodPicture( )

        };
        int count = super.executeUpdate( ADD, param );
        super.closeAll( );
        return count;
    }
    @Override
    public int removeGoods ( String goodsNumber ) {
        int count = 0;
        super.getConnection( );
        String[] param = new String[] {
                goodsNumber
        };
        count = super.executeUpdate( REMOVE, param );
        super.closeAll( );
        return count;
    }
    @Override
    public int modifyGoods ( Goods goods, String goodsNumber ) {
        int count = 0;
        super.getConnection( );
        String[] param = new String[] {
                goods.getGoodsPictureTop( ),
                goods.getGoodsClassification( ),
                goods.getGoodsName( ),
                goods.getPriceOrigin( ) + "",
                goods.getPriceSale( ) + "",
                goods.getCounter( ) + "",
                goods.getGoodPicture( ),
                goodsNumber
        };
        count = super.executeUpdate( MODIFY, param );
        super.closeAll( );
        return count;
    }
}
