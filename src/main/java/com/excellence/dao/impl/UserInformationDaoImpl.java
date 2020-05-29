package com.excellence.dao.impl;

import com.excellence.dao.UserInformationDao;
import com.excellence.model.UserInformation;
import com.excellence.util.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
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
public class UserInformationDaoImpl extends C3P0Utils implements UserInformationDao {
    String selectSQL = "select * from user_information where 1=1 ";
    String select_userName = "and userName = ? ";
    String modifySQL = "";
    String insertSQL = "insert into user_information values(?,?,?,?)";
    String removeSQL = "delete from user_information where userName = ? and relativeName = ? and address = ? and relativePhone = ? ";


    @Override
    public List<UserInformation> findBy_userName ( String userName ) {
        Object[] param = new Object[] { userName };
        Connection conn = super.getConnection();
        List<UserInformation> list = null;
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    super.getConnection( ),
                    selectSQL + select_userName,
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
    public int add ( UserInformation userInformation ) {
        int count = 0;
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                userInformation.getUserName( ),
                userInformation.getRelativeName( ),
                userInformation.getAddress( ),
                userInformation.getRelativePhone( )
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    super.getConnection( ),
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
        Connection conn = super.getConnection();
        Object[] param = new Object[] {
                userInformation.getUserName( ),
                userInformation.getRelativeName( ),
                userInformation.getAddress( ),
                userInformation.getRelativePhone( )
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    super.getConnection( ),
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
        Connection conn = super.getConnection();
        int[] count = new int[] { 0, 0 };
        count[0] = remove( from );
        count[1] = add( to );
        super.closeConnection( conn );
        return count;
    }

}
