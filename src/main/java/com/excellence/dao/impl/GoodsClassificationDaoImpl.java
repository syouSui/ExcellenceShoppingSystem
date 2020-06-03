package com.excellence.dao.impl;

import com.excellence.dao.GoodsClassificationDao;
import com.excellence.model.GoodsClassification;
import com.excellence.util.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author acmaker & Kaffu-chino
 * @version 1.0.0
 * @ClassName GoodsClassificationDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:05:00 星期三
 * @Description TODO
 */
public class GoodsClassificationDaoImpl extends C3P0Utils implements GoodsClassificationDao {
    private String FIND = "select * from goods_classification where 1=1 ";
    private String FINDBy_goodsClassification = " and classificationId=? ";
    private String FINDBy_classificationName = " and classificationName like ? ";
    private String ADD = "insert into goods_classification values(?,?);";
    private String REMOVE = "delete from goods_classification where goodsClassification=?;";
    private String MODIFY = "update goods_classification set classificationName = ? where goodsClassification = ?;";
    private String COUNT = "select count(*) from goods_classification where 1=1 ";

    final private int default_pageSize = 10;
//    final private int default_pageSize = 2;

    @Override
    public List<GoodsClassification> findAllGoodsClassification ( int currentPage, int pageSize ) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<GoodsClassification> list = new ArrayList<>( );
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    FIND + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>( GoodsClassification.class ),
                    param );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }

    @Override
    public int count_findAllGoodsClassification ( ) {
        Long count = 0L;
        Object[] param = new Object[] { };
        Connection conn = super.getConnection( );
        try {
            count = (Long) new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    COUNT,
                    new ArrayHandler( ),
                    param )[0];
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        return count.intValue( );
    }

    @Override
    public GoodsClassification findBy_classificationId ( String classificationId ) {
        GoodsClassification goodsClassification = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { classificationId };
        try {
            goodsClassification = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    FIND + FINDBy_goodsClassification,
                    new BeanHandler<>( GoodsClassification.class ),
                    param );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return goodsClassification;
    }

    @Override
    public List<GoodsClassification> findBy_classificationName ( String classificationName, int currentPage, int pageSize ) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<GoodsClassification> list = new ArrayList<>( );
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { "%" + classificationName + "%" };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    FIND + FINDBy_classificationName + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>( GoodsClassification.class ),
                    param );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }

    @Override
    public int count_findBy_classificationName ( String classificationName ) {
        Long count = 0L;
        Object[] param = new Object[] { "%"+classificationName+"%" };
        Connection conn = super.getConnection( );
        try {
            count = (Long) new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    COUNT + FINDBy_classificationName,
                    new ArrayHandler( ),
                    param )[0];
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        return count.intValue( );
    }

    @Override
    public int addGoodsClassification ( GoodsClassification goodsClassification ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                goodsClassification.getClassificationId( ),
                goodsClassification.getClassificationName( )
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    ADD,
                    param );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int removeGoodsClassification ( String goodsClassification ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                goodsClassification
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    REMOVE,
                    param );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int modifyGoodsClassification ( GoodsClassification goodsClassification, String wantGoodsClassification ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                wantGoodsClassification,
                goodsClassification.getClassificationId( ),
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    MODIFY,
                    param );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }
}
