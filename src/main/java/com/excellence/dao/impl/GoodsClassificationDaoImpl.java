package com.excellence.dao.impl;

import com.excellence.dao.GoodsClassificationDao;
import com.excellence.model.GoodsClassification;
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
 * @ClassName GoodsClassificationDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:05:00 星期三
 * @Description TODO
 */
public class GoodsClassificationDaoImpl extends C3P0Utils implements GoodsClassificationDao {
    private String FIND = "select * from goods_classification;";
    private String ADD = "insert into goods_classification values(?,?);";
    private String REMOVE = "delete from goods_classification where goodsClassification=?;";
    private String MODIFY = "update goods_classification set classificationName = ? where goodsClassification = ?;";

    @Override
    public List<GoodsClassification> findAllGoodsClassification ( ) {
        List<GoodsClassification> list = new ArrayList<>( );
        Connection conn = super.getConnection();
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner(super.getDataSource()).query(
                    conn,
                    FIND,
                    new BeanListHandler<>(GoodsClassification.class),
                    param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return list;
    }

    @Override
    public int addGoodsClassification ( GoodsClassification goodsClassification ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                goodsClassification.getGoodsClassification( ),
                goodsClassification.getClassificationName( )
        };
        try {
            count = new QueryRunner(super.getDataSource()).update(
                    super.getConnection(),
                    ADD,
                    param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int removeGoodsClassification ( String goodsClassification ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                goodsClassification
        };
        try {
            count = new QueryRunner(super.getDataSource()).update(
                    super.getConnection(),
                    REMOVE,
                    param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int modifyGoodsClassification ( GoodsClassification goodsClassification, String wantGoodsClassification ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                wantGoodsClassification,
                goodsClassification.getGoodsClassification( ),
        };
        try {
            count = new QueryRunner(super.getDataSource()).update(
                    super.getConnection(),
                    MODIFY,
                    param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        super.closeConnection( conn ); return count;
    }
}
