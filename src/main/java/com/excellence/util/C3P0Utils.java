package com.excellence.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName JDBCUtils.java
 * @PackageLoaction com.excellence.util
 * @createTime 2020-05-25 17:13:00 星期一
 * @Description TODO
 */
public class C3P0Utils {
    private static ComboPooledDataSource ds = new ComboPooledDataSource( "mysql" );

    public static DataSource getDataSource ( ) {
        return ds;
    }

    public Connection getConnection ( ) {
        Connection conn = null;
        try {
            conn = ds.getConnection( );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        return conn;
    }

    public void closeConnection ( Connection conn ) {
        try {
            conn.close( );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
    }

}
