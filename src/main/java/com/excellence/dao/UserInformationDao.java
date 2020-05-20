package com.excellence.dao;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName UserInformationDao.java
 * @PackageLoaction com.excellence.dao
 * @createTime 2020-05-20 16:15:00 星期三
 * @Description TODO
 */

import com.excellence.model.UserInformation;

import java.util.List;

/**
 * find
 * add
 * remove
 * modify
 */
public interface UserInformationDao {
    public List<UserInformation> findBy_userName(String userName);

//    public List<UserInformation> findBy_userName_userPassword(String userName);

    public UserInformation add ( UserInformation userInformation );

    public int remove ( UserInformation userInformation );

    public int modify ( UserInformation userInformation );
}
