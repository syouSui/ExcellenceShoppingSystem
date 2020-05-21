package com.excellence.dao.impl;

import com.excellence.dao.UserDao;
import com.excellence.model.User;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName UserDao.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 18:22:00 星期三
 * @Description TODO
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAllUser ( ) {
        return null;
    }
    @Override
    public User findBy_userName_userPassword ( String userName, String userPassword ) {
        return null;
    }
    @Override
    public User findBy_userEmail_userPassword ( String userEmail, String userPassword ) {
        return null;
    }
    @Override
    public int addUser ( User user ) {
        return 0;
    }
    @Override
    public int removeUser ( User user ) {
        return 0;
    }
    @Override
    public int modifyUser ( User user, String userName ) {
        return 0;
    }
}
