package com.excellence.dao.impl;

import com.excellence.dao.UserDao;
import com.excellence.model.HeadPicture;
import com.excellence.model.User;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/**
 * UserDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>5月 21, 2020</pre>
 */
public class UserDaoImplTest {

    static UserDao userDao = new UserDaoImpl( );
    static List<User> userList = new ArrayList( );

    public static void show ( ) {
        userList = userDao.findAllUser( 1, 100 );
        for ( User e : userList )
            System.out.println(
                    e.getUserName( ) + "\t" +
                            e.getUserNickname( ) + "\t" +
                            e.getUserPassword( ) + "\t" +
                            e.getRole( ) + "\t" +
                            e.getPhone( ) + "\t" +
                            e.getUserEmail( )
            );
        System.out.println( );
    }

    @Before
    public void before ( ) throws Exception {
    }

    @After
    public void after ( ) throws Exception {
    }

    /**
     * Method: findAllUser()
     */
    @Test
    public void testFindAllUser ( ) throws Exception {
        show( );
        System.out.println( userDao.count_findAllUser() );
    }

    /**
     * Method: findBy_userName_userPassword(String userName, String userPassword)
     */
    @Test
    public void testFindBy_userName_userPassword ( ) throws Exception {
        User user = userDao.findBy_userName_userPassword( "dpxwz", "123456" );
        System.out.println(
                user.getUserName( ) + "\t" +
                        user.getUserNickname( ) + "\t" +
                        user.getUserPassword( ) + "\t" +
                        user.getRole( ) + "\t" +
                        user.getPhone( ) + "\t" +
                        user.getUserEmail( )
        );
    }

    /**
     * Method: findBy_userEmail_userPassword(String userEmail, String userPassword)
     */
    @Test
    public void testFindBy_userEmail_userPassword ( ) throws Exception {
        User user = userDao.findBy_userEmail_userPassword( "hhh@hhh.com", "123456" );
        System.out.println(
                user.getUserName( ) + "\t" +
                        user.getUserNickname( ) + "\t" +
                        user.getUserPassword( ) + "\t" +
                        user.getRole( ) + "\t" +
                        user.getPhone( ) + "\t" +
                        user.getUserEmail( )
        );
    }

    /**
     * Method: addUser(User user)
     */
    @Test
    public void testAddUser ( ) throws Exception {
        userDao.addUser(
                new User(
                        "hhh",
                        "hhh",
                        "hhh",
                        0,
                        "111222333444",
                        "1231231@1.com",
                        "1.jpg")
        );
        userDao.modifyUser(
                new User(
                        "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
                        "aaa",
                        "aaa",
                        0,
                        "888888888888888888",
                        "8881@1.com",
                        "1.jpg"),
                "hhh"
        );
        userDao.removeUser( "hhh" );
        show( );
    }

    /**
     * Method: removeUser(User user)
     */
    @Test
    public void testRemoveUser ( ) throws Exception {
        userDao.removeUser( "hhh" );
        show( );
    }

    /**
     * Method: modifyUser(User user, String userName)
     */
    @Test
    public void testModifyUser ( ) throws Exception {
        userDao.modifyUser(
                new User(
                        "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
                        "aaa",
                        "aaa",
                        0,
                        "888888888888888888",
                        "8881@1.com",
                        "1.jpg"),
                "hhh"
        );
        show( );
    }

} 
