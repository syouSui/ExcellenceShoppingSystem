package com.excellence.dao.impl;

import com.excellence.dao.HeadPictureDao;
import com.excellence.model.HeadPicture;
import com.excellence.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName HeadPictureDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:06:00 星期三
 * @Description TODO
 */
public class HeadPictureDaoImpl extends DBUtil implements HeadPictureDao {
    private String FIND = "select * from head_picture;";
    private String ADD = "insert into head_picture values(?);";
    private String REMOVE = "delete from head_picture where headPicture=?;";
    private String MODIFY = "update head_picture set headPicture=?;";

    @Override
    public List<HeadPicture> findAll ( ) {
        List<HeadPicture> list = new ArrayList<>( );
        super.getConnection( );
        String[] param = new String[] { };
        ResultSet rs = null;
        rs = super.executeQuery( FIND, param );
        try {
            while ( rs.next( ) ) {
                list.add( new HeadPicture( rs.getString( "pictureAddress" )
                ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        super.closeAll();
        return list;
    }
    @Override
    public HeadPicture add ( HeadPicture headPicture ) {
        return null;
    }
    @Override
    public boolean remove ( HeadPicture headPicture ) {
        return false;
    }
    @Override
    public boolean modify ( HeadPicture headPicture ) {
        return false;
    }
}
