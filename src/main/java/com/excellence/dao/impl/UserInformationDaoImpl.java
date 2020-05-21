package com.excellence.dao.impl;

import com.excellence.dao.UserDao;
import com.excellence.dao.UserInformationDao;
import com.excellence.model.User;
import com.excellence.model.UserInformation;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName UserInformationImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 18:25:00 星期三
 * @Description TODO
 */
public class UserInformationDaoImpl implements UserInformationDao {

    @Override
    public List<UserInformation> findBy_userName ( String userName ) {
        return null;
    }
    @Override
    public UserInformation add ( UserInformation userInformation ) {
        return null;
    }
    @Override
    public boolean remove ( UserInformation userInformation ) {
        return false;
    }
    @Override
    public boolean modify ( UserInformation userInformation ) {
        return false;
    }
}
