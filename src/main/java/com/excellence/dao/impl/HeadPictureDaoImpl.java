package com.excellence.dao.impl;

import com.excellence.dao.HeadPictureDao;
import com.excellence.model.HeadPicture;
import com.excellence.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName HeadPictureDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:06:00 星期三
 * @Description TODO
 */
public class HeadPictureDaoImpl extends C3P0Util implements HeadPictureDao {
    private String FIND = "select * from head_picture;";
    private String ADD = "insert into head_picture values(?);";
    private String REMOVE = "delete from head_picture where pictureAddress=?;";
    private String MODIFY = "update head_picture set pictureAddress=? where pictureAddress=?;";

    final private int default_pageSize = 10;

    @Override
    public List<HeadPicture> findAll ( ) {
        List<HeadPicture> list = null;
        Connection conn = super.getConnection();
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    FIND,
                    new BeanListHandler<>( HeadPicture.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }

    @Override
    public int add ( HeadPicture headPicture ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                headPicture.getPictureAddress( )
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
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
    public int remove ( HeadPicture headPicture ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                headPicture.getPictureAddress( )
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
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
    public int modify ( HeadPicture from, HeadPicture to ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                to.getPictureAddress( ),
                from.getPictureAddress( )
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
