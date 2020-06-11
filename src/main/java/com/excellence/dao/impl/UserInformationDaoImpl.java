package com.excellence.dao.impl;

import com.excellence.dao.UserInformationDao;
import com.excellence.model.UserInformation;
import com.excellence.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName UserInformationImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 18:25:00 星期三
 * @Description TODO
 */
public class UserInformationDaoImpl extends C3P0Util implements UserInformationDao {
    private String selectSQL = "select * from user_information where 1=1 ";
    private String select_userName = "and userName = ? ";
    private String countSQL = "select count(*) from user_information where 1=1 ";
    private String modifySQL = "";
    private String insertSQL = "insert into user_information values(?,?,?,?)";
    private String removeSQL = "delete from user_information where userName = ? and relativeName = ? and address = ? and relativePhone = ? ";

    final private int default_pageSize = 10;

    @Override
    public List<UserInformation> findBy_userName ( String userName, int currentPage, int pageSize ) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        Object[] param = new Object[] { userName };
        Connection conn = super.getConnection( );
        List<UserInformation> list = null;
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + select_userName + " limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>( UserInformation.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }

    @Override
    public int count_findBy_userName ( String userName ) {
        Long count = 0L;
        Object[] param = new Object[] { userName };
        Connection conn = super.getConnection( );
        try {
            count = (Long)new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    countSQL + select_userName,
                    new ArrayHandler( ),
                    param
            )[0];
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count.intValue();
    }

    @Override
    public int add ( UserInformation userInformation ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                userInformation.getUserName( ),
                userInformation.getRelativeName( ),
                userInformation.getAddress( ),
                userInformation.getRelativePhone( )
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    insertSQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int remove ( UserInformation userInformation ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                userInformation.getUserName( ),
                userInformation.getRelativeName( ),
                userInformation.getAddress( ),
                userInformation.getRelativePhone( )
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    removeSQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int[] modify ( UserInformation from, UserInformation to ) {
        int[] count = new int[] { 0, 0 };
        count[0] = remove( from );
        count[1] = add( to );
        return count;
    }

}
