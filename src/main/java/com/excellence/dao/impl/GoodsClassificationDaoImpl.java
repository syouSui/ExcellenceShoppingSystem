package com.excellence.dao.impl;

import com.excellence.dao.GoodsClassificationDao;
import com.excellence.model.GoodsClassification;
import com.excellence.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName GoodsClassificationDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:05:00 星期三
 * @Description TODO
 */
public class GoodsClassificationDaoImpl extends DBUtil implements GoodsClassificationDao {
    private String FIND = "select * from goods_classification;";
    private String ADD = "insert into goods_classification values(?,?);";
    private String REMOVE = "delete from goods_classification where goodsClassification=?;";
    private String MODIFY = "update goods_classification set classification=? where classification=?;";

    @Override
    public List<GoodsClassification> findAllGoodsClassification ( ) {
        List<GoodsClassification> list = new ArrayList<>( );
        super.getConnection( );
        String[] param = new String[] { };
        ResultSet rs = null;
        rs = super.executeQuery( FIND, param );
        try {
            while ( rs.next( ) ) {
                list.add( new GoodsClassification(
                        rs.getString( "goodsClassification" ),
                        rs.getString( "classificationName" )
                ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        super.closeAll( );
        return list;
    }

    @Override
    public int addGoodsClassification ( GoodsClassification goodsClassification ) {
        int count = 0;
        super.getConnection( );
        String[] param = new String[] {
                goodsClassification.getGoodsClassification( ),
                goodsClassification.getClassificationName( )
        };
        count = super.executeUpdate( ADD, param );
        super.closeAll( );
        return count;
    }

    @Override
    public int[] removeGoodsClassification ( GoodsClassification goodsClassification ) {
        int[] count = new int[] { 0, 0 };
        super.getConnection( );
        String[] param = new String[] {
                goodsClassification.getGoodsClassification( ),
        };
        count[0] = super.executeUpdate( REMOVE, param );
        count[1] = super.executeUpdate( "delete * from goods where goodsClassification=?;", new String[] { goodsClassification.getGoodsClassification( ) } );
        super.closeAll( );
        return count;
    }

    @Override
    public int[] modifyGoodsClassification ( GoodsClassification goodsClassification, String wantGoodsClassification ) {
        int[] count = new int[] { 0, 0 };
        super.getConnection( );
        String[] param = new String[] {
                wantGoodsClassification,
                goodsClassification.getGoodsClassification( ),
        };
        count[0] = super.executeUpdate( MODIFY, param );
        count[1] = super.executeUpdate( "update goods set goodsClassification=? where goodsClassification=?;", new String[] { wantGoodsClassification, goodsClassification.getGoodsClassification() } );
        super.closeAll( );
        return count;
    }
}
