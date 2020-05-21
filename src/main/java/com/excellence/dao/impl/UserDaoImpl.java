package com.excellence.dao.impl;

import com.excellence.dao.UserDao;
import com.excellence.model.User;
import com.excellence.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author acmaker & Kaffu-Chino
 * @version 1.0.0
 * @ClassName UserDao.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 18:22:00 星期三
 * @Description TODO
 */
public class UserDaoImpl extends DBUtil implements UserDao {
    String selectSQL = "select * from user where 1=1 ";
    String select_userName = "and userName = ? ";
    String select_userEmail = "and userEmail = ? ";
    String select_userPassword = "and userPassword = ? ";
    String insertSQL = "insert into user values(?,?,?,?,?,?)";
    String modifySQL = "update user set userNickname = ?, userPassword = ?, role = ?, phone = ?, userEmail=? where userName = ?";
    String removeSQL = "delete from user where userName = ?";

    @Override
    public List<User> findAllUser ( ) {
        List<User> userList = null;
        ResultSet resultSet = null;
        String[] param = new String[] { };
        super.getConnection( );
        resultSet = super.executeQuery( selectSQL, param );
        try {
            while ( resultSet.next( ) ) {
                userList.add(
                        new User( resultSet.getString( "userName" ),
                                resultSet.getString( "userNickname" ),
                                resultSet.getString( "userPassword" ),
                                resultSet.getInt( "role" ),
                                resultSet.getString( "phone" ),
                                resultSet.getString( "userEmail" ) )
                );
            }
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeAll( );
        return userList;
    }
    @Override
    public User findBy_userName_userPassword ( String userName, String userPassword ) {
        User user = null;
        ResultSet resultSet = null;
        String[] param = new String[] { userName, userPassword };
        super.getConnection( );
        resultSet = super.executeQuery( selectSQL + select_userName + select_userPassword, param );
        try {
            user = new User( resultSet.getString( "userName" ),
                    resultSet.getString( "userNickname" ),
                    resultSet.getString( "userPassword" ),
                    resultSet.getInt( "role" ),
                    resultSet.getString( "phone" ),
                    resultSet.getString( "userEmail" ) );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeAll( );
        return user;
    }
    @Override
    public User findBy_userEmail_userPassword ( String userEmail, String userPassword ) {
        User user = null;
        ResultSet resultSet = null;
        String[] param = new String[] { userEmail, userPassword };
        resultSet = super.executeQuery( selectSQL + select_userEmail + userPassword, param );
        super.getConnection( );
        try {
            user = new User( resultSet.getString( "userName" ),
                    resultSet.getString( "userNickname" ),
                    resultSet.getString( "userPassword" ),
                    resultSet.getInt( "role" ),
                    resultSet.getString( "phone" ),
                    resultSet.getString( "userEmail" ) );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeAll( );
        return user;
    }
    @Override
    public int addUser ( User user ) {
        int count = 0;
        String[] param = new String[] {
                user.getUserName( ),
                user.getUserNickname( ),
                user.getUserPassword( ),
                user.getRole( ) + "",
                user.getPhone( ),
                user.getUserEmail( )
        };
        super.getConnection( );
        count = super.executeUpdate( insertSQL, param );
        super.closeAll( );
        return count;
    }
    @Override
    public int removeUser ( User user ) {
        int count = 0;
        String[] param = new String[] {
                user.getUserName( ),
                user.getUserNickname( ),
                user.getUserPassword( ),
                user.getRole( ) + "",
                user.getPhone( ),
                user.getUserEmail( )
        };
        super.getConnection( );
        count = super.executeUpdate( removeSQL, param );
        return count;
    }
    @Override
    public int modifyUser ( User user, String userName ) {
        int count = 0;
        String[] param = new String[] {
                user.getUserNickname( ),
                user.getUserPassword( ),
                user.getRole( ) + "",
                user.getPhone( ),
                user.getUserEmail( ),
                userName
        };
        super.getConnection( );
        count = super.executeUpdate( modifySQL, param );
        super.closeAll( );
        return count;
    }
}
