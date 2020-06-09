package com.excellence.dao.impl;

import com.excellence.dao.UserDao;
import com.excellence.model.User;
import com.excellence.util.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
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
    private String selectSQL = "select * from user where 1=1 ";
    private String countSQL = "select count(*) from user where 1=1 ";
    private String select_userName = "and userName = ? ";
    private String select_userEmail = "and userEmail = ? ";
    private String select_userPassword = "and userPassword = ? ";
    private String insertSQL = "insert into user values(?,?,?,?,?,?,?)";
    private String modifySQL = "update user set userNickname = ?, userPassword = ?, role = ?, phone = ?, userEmail=? where userName = ?";
    private String removeSQL = "delete from user where userName = ?";

    final private int default_pageSize = 10;

    @Override
    public User findBy_userName ( String userName ) {
        User user = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { userName };
        try {
            user = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + select_userName,
                    new BeanHandler<>( User.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return user;
    }

    @Override
    public User findBy_userEmail ( String userEmail ) {
        User user = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { userEmail };
        try {
            user = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + select_userEmail,
                    new BeanHandler<>( User.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return user;

    }

    @Override
    public List<User> findAllUser ( int currentPage, int pageSize ) {
        pageSize = pageSize == -1 ? default_pageSize : pageSize;
        List<User> list = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + "limit " + (currentPage - 1) * pageSize + ", " + pageSize,
                    new BeanListHandler<>( User.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }

    @Override
    public int count_findAllUser ( ) {
        Long count = 0L;
        Object[] param = new Object[] { };
        Connection conn = super.getConnection( );
        try {
            count = (Long) new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    countSQL,
                    new ArrayHandler( ),
                    param
            )[0];
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count.intValue( );
    }

    @Override
    public User findBy_userName_userPassword ( String userName, String userPassword ) {
        User user = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { userName, userPassword };
        try {
            user = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    "select userName, userNickname, role, phone, userEmail, userPicture" + select_userName + select_userPassword,
                    new BeanHandler<>( User.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return user;
    }

    @Override
    public User findBy_userEmail_userPassword ( String userEmail, String userPassword ) {
        User user = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { userEmail, userPassword };
        try {
            user = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    "select userName, userNickname, role, phone, userEmail, userPicture" + select_userEmail + select_userPassword,
                    new BeanHandler<>( User.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return user;
    }

    @Override
    public int addUser ( User user ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                user.getUserName( ),
                user.getUserNickname( ),
                user.getUserPassword( ),
                user.getRole( ) + "",
                user.getPhone( ),
                user.getUserEmail( ),
                user.getUserPicture( ),
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
    public int removeUser ( String userName ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                userName
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
    public int modifyUser ( User user, String userName ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                user.getUserNickname( ),
                user.getUserPassword( ),
                user.getRole( ) + "",
                user.getPhone( ),
                user.getUserEmail( ),
                user.getUserPicture( ),
                userName
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    modifySQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }
}
