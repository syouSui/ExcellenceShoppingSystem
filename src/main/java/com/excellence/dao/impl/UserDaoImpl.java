package com.excellence.dao.impl;

import com.excellence.dao.UserDao;
import com.excellence.model.User;
import com.excellence.util.C3P0Utils;
import com.excellence.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
public class UserDaoImpl extends C3P0Utils implements UserDao {
    String selectSQL = "select * from user where 1=1 ";
    String select_userName = "and userName = ? ";
    String select_userEmail = "and userEmail = ? ";
    String select_userPassword = "and userPassword = ? ";
    String insertSQL = "insert into user values(?,?,?,?,?,?)";
    String modifySQL = "update user set userNickname = ?, userPassword = ?, role = ?, phone = ?, userEmail=? where userName = ?";
    String removeSQL = "delete from user where userName = ?";

    @Override
    public List<User> findAllUser ( ) {
        List<User> list = null;
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    super.getConnection( ),
                    selectSQL,
                    new BeanListHandler<>( User.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( );
        return list;
    }

    @Override
    public User findBy_userName_userPassword ( String userName, String userPassword ) {
        User user = null;
        Object[] param = new Object[] { userName, userPassword };
        try {
            user = new QueryRunner( super.getDataSource( ) ).query(
                    super.getConnection( ),
                    selectSQL + select_userName + select_userPassword,
                    new BeanHandler<>( User.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( );
        return user;
    }

    @Override
    public User findBy_userEmail_userPassword ( String userEmail, String userPassword ) {
        User user = null;
        Object[] param = new Object[] { userEmail, userPassword };
        try {
            user = new QueryRunner( super.getDataSource( ) ).query(
                    super.getConnection( ),
                    selectSQL + select_userEmail + select_userPassword,
                    new BeanHandler<>( User.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( );
        return user;
    }

    @Override
    public int addUser ( User user ) {
        int count = 0;
        Object[] param = new Object[] {
                user.getUserName( ),
                user.getUserNickname( ),
                user.getUserPassword( ),
                user.getRole( ) + "",
                user.getPhone( ),
                user.getUserEmail( )
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
        super.closeConnection( );
        return count;
    }

    @Override
    public int removeUser ( String userName ) {
        int count = 0;
        Object[] param = new Object[] {
                userName
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
        super.closeConnection( );
        return count;
    }

    @Override
    public int modifyUser ( User user, String userName ) {
        int count = 0;
        Object[] param = new Object[] {
                user.getUserNickname( ),
                user.getUserPassword( ),
                user.getRole( ) + "",
                user.getPhone( ),
                user.getUserEmail( ),
                userName
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    super.getConnection( ),
                    modifySQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( );
        return count;
    }
}
