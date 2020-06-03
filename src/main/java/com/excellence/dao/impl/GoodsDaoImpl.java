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
    private String FINDAll = "select * from goods ";
    private String FINDBy_goodsName = "select * from goods where goodsName like ?";
    private String FINDBy_classificationId = "select * from goods where classificationId=? ";
    private String ADD = "insert into goods values(?,?,?,?,?,?,?,?);";
    private String REMOVE = "delete from goods where goodsNumber=?;";
    private String MODIFY = "update goods as g set g.goodsPictureTop=?, g.goodsClassification=?, g.goodsName=?, g.priceOrigin=?, g.priceSale=?, g.counter=?, g.goodsPicture=? where g.goodsNumber=?;";

    final private int default_pageSize = 10;
    // 1: (目的页数-1)*显示条数        2: 显示条数

    @Override
    public List<Goods> findAllGoods ( int currentPage, int pageSize ) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<Goods> list = new ArrayList<>( );
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    FINDAll + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>( Goods.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }

    @Override
    public List<Goods> findBy_goodsName ( String goodsName, int currentPage, int pageSize ) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<Goods> list = new ArrayList<>( );
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                "%" + goodsName + "%"
        };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    FINDBy_goodsName + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>( Goods.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }

    @Override
    public List<Goods> findBy_classificationId ( String classificationId, int currentPage, int pageSize ) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<Goods> list = new ArrayList<>( );
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                classificationId
        };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    FINDBy_classificationId + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>( Goods.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public int addGoods ( Goods goods ) {
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                goods.getGoodsNumber( ),
                goods.getGoodsPictureTop( ),
                goods.getClassificationId( ),
                goods.getGoodsName( ),
                goods.getPriceOrigin( ) + "",
                goods.getPriceSale( ) + "",
                goods.getCounter( ) + "",
                goods.getGoodPicture( )
        };
        int count = 0;
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    super.getConnection( ),
                    ADD,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }
    @Override
    public int removeGoods ( String goodsNumber ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                goodsNumber
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    super.getConnection( ),
                    REMOVE,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }
    @Override
    public int modifyGoods ( Goods goods, String goodsNumber ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                goods.getGoodsPictureTop( ),
                goods.getClassificationId( ),
                goods.getGoodsName( ),
                goods.getPriceOrigin( ) + "",
                goods.getPriceSale( ) + "",
                goods.getCounter( ) + "",
                goods.getGoodPicture( ),
                goodsNumber
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    MODIFY,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }
}
