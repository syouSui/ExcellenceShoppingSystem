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
    private String REMOVE = "delete from head_picture where pictureAddress=?;";
    private String MODIFY = "update head_picture set pictureAddress=? where pictureAddress=?;";

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
            e.printStackTrace( );
        }
        super.closeAll( );
        return list;
    }
    @Override
    public boolean add ( HeadPicture headPicture ) {
        super.getConnection( );
        String[] param = new String[] {
            headPicture.getPictureAddress( )
        };
        int count = super.executeUpdate( ADD, param );
        super.closeAll( );
        return count==1 ? true : false;
    }
    @Override
    public int remove ( HeadPicture headPicture ) {
        super.getConnection( );
        String[] param = new String[] {
            headPicture.getPictureAddress( )
        };
        int count = super.executeUpdate( REMOVE, param );
        super.closeAll( );
        return count==1 ? true : false;
    }
    @Override
    public int modify ( HeadPicture from, HeadPicture to ) {
        super.getConnection( );
        String[] param = new String[] {
            to.getPictureAddress( ),
            from.getPictureAddress( )
        };
        int count = super.executeUpdate( MODIFY, param );
        super.closeAll( );
        return count==1 ? true : false;
    }
}
