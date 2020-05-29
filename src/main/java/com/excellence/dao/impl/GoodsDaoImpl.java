package com.excellence.dao.impl;

import com.excellence.model.Goods;
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
 * @ClassName GoodsDao.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:05:00 星期三
 * @Description TODO
 */
public class GoodsDaoImpl extends C3P0Utils implements com.excellence.dao.GoodsDao {
    private String FINDAll = "select * from goods;";
    private String FINDBy_goodsName = "select * from goods where goodsName like  '%'|| ? ||'%'";
    private String FINDBy_goodsClassification = "select * from goods where goodsClassification=?;";
    private String ADD = "insert into goods values(?,?,?,?,?,?,?,?);";
    private String REMOVE = "delete from goods where goodsNumber=?;";
    private String MODIFY = "update goods as g set g.goodsPictureTop=?, g.goodsClassification=?, g.goodsName=?, g.priceOrigin=?, g.priceSale=?, g.counter=?, g.goodsPicture=? where g.goodsNumber=?;";

    @Override
    public List<Goods> findAllGoods ( ) {
        List<Goods> list = new ArrayList<>( );
        Connection conn = super.getConnection();
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner(super.getDataSource()).query(
                    super.getConnection(),
                    FINDAll,
                    new BeanListHandler<>(Goods.class),
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public List<Goods> findBy_goodsName ( String goodsName ) {
        List<Goods> list = new ArrayList<>( );
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                goodsName
        };
        try {
            list = new QueryRunner(super.getDataSource()).query(
                    super.getConnection(),
                    FINDBy_goodsName,
                    new BeanListHandler<>(Goods.class),
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public List<Goods> findBy_goodsClassification ( String goodsClassification ) {
        List<Goods> list = new ArrayList<>( );
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                goodsClassification
        };
        try {
            list = new QueryRunner(super.getDataSource()).query(
                    super.getConnection(),
                    FINDBy_goodsClassification,
                    new BeanListHandler<>(Goods.class),
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public int addGoods ( Goods goods ) {
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                goods.getGoodsNumber( ),
                goods.getGoodsPictureTop( ),
                goods.getGoodsClassification( ),
                goods.getGoodsName( ),
                goods.getPriceOrigin( ) + "",
                goods.getPriceSale( ) + "",
                goods.getCounter( ) + "",
                goods.getGoodPicture( )
        };
        int count = 0;
        try {
            count = new QueryRunner(super.getDataSource()).update(
                    super.getConnection(),
                    ADD,
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return count;
    }
    @Override
    public int removeGoods ( String goodsNumber ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                goodsNumber
        };
        try {
            count = new QueryRunner(super.getDataSource()).update(
                    super.getConnection(),
                    REMOVE,
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return count;
    }
    @Override
    public int modifyGoods ( Goods goods, String goodsNumber ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                goods.getGoodsPictureTop( ),
                goods.getGoodsClassification( ),
                goods.getGoodsName( ),
                goods.getPriceOrigin( ) + "",
                goods.getPriceSale( ) + "",
                goods.getCounter( ) + "",
                goods.getGoodPicture( ),
                goodsNumber
        };
        try {
            count = new QueryRunner(super.getDataSource()).update(
                    super.getConnection(),
                    MODIFY,
                    param
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return count;
    }
}
