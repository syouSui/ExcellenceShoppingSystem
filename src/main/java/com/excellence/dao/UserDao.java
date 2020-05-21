package com.excellence.dao;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/19 16:57
 ** LastEditors: Kaffu-Chino
 ** Description： 
 *********************************************************************************/

import com.excellence.model.User;

import java.util.List;

/**
 * find
 * add
 * remove
 * modify
 */
public interface UserDao {

    public List<User> findAllUser();

    public User findBy_userName_userPassword(String userName,String userPassword);

    public User findBy_userEmail_userPassword(String userEmail,String userPassword);

    public boolean addUser(User user);

    public boolean removeUser(User user);

    public boolean modifyUser(User user,String userName);

}
