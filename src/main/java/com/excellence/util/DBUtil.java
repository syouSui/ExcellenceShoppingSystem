/**
 * @Author : acmaker
 * @Date : 2020-04-28 13:56:20
 * @LastEditTime: 2020-04-28 17:01:42
 * @FilePath : \PersonalWebpage\src\com\supreme\\util\DBUtil.java
 * @Website : http://csdn.acmaker.vip
 * @Description :
 */


package com.excellence.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private Connection conn = null;
    private PreparedStatement psm = null;
    private ResultSet rs = null;

    private static String driver;
    private static String url;
    private static String name;
    private static String password;

    static {
        final Properties properties = new Properties( );
        try {
            properties.load( DBUtil.class.getResourceAsStream( "./../../../jdbc.properties" ) );
        } catch ( final IOException e1 ) {
            e1.printStackTrace( );
        }
        driver = properties.getProperty( "driverName" );
        url = properties.getProperty( "url" );
        name = properties.getProperty( "userName" );
        password = properties.getProperty( "userPassword" );
        try {
            Class.forName( driver );
        } catch ( final ClassNotFoundException e ) {
            e.printStackTrace( );
        }
    }

    public Connection getConnection ( ) {
        try {
            conn = DriverManager.getConnection( url, name, password );
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        return conn;
    }

    public ResultSet executeQuery ( String preparedSql, String[] param ) {
        try {
            psm = conn.prepareStatement( preparedSql );
            if ( param != null ) {
                // 给 preparedSql 语句中的问号赋值
                for ( int i = 0; i < param.length; ++i ) {
                    psm.setString( i + 1, param[i] );
                }
            }
            rs = psm.executeQuery( );
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        return rs;
    }

    public int executeUpdate ( String preparedSql, String[] param ) {
        int count = 0; // 更新记录数
        try {
            psm = conn.prepareStatement( preparedSql );
            if ( param != null ) {
                // 给 preparedSql 语句中的问号赋值
                for ( int i = 0; i < param.length; ++i ) {
                    psm.setString( i + 1, param[i] );
                }
            }
            count = psm.executeUpdate( );
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
        return count;
    }

    public void closeAll ( ) {
        if ( rs != null ) {
            try {
                rs.close( );
            } catch ( SQLException e ) {
                e.printStackTrace( );
            }
        }
        if ( psm != null ) {
            try {
                psm.close( );
            } catch ( SQLException e ) {
                e.printStackTrace( );
            }
        }
        if ( conn != null ) {
            try {
                conn.close( );
            } catch ( SQLException e ) {
                e.printStackTrace( );
            }
        }
    }

}
