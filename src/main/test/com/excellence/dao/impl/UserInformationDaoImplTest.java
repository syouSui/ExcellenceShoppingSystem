package com.excellence.dao.impl;

import com.excellence.dao.UserInformationDao;
import com.excellence.model.UserInformation;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/**
 * UserInformationDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>5月 21, 2020</pre>
 */
public class UserInformationDaoImplTest {
    static UserInformationDao userInformationDao = new UserInformationDaoImpl( );
    static List<UserInformation> userInformationList = new ArrayList<>( );

    @Before
    public void before ( ) throws Exception {
    }

    @After
    public void after ( ) throws Exception {
    }

    /**
     * Method: findBy_userName(String userName)
     */
    @Test
    public void testFindBy_userName ( ) throws Exception {
        userInformationList = userInformationDao.findBy_userName( "lyx" );
    }

    /**
     * Method: add(UserInformation userInformation)
     */
    @Test
    public void testAdd ( ) throws Exception {
        userInformationDao.add( new UserInformation(
                "lyx",
                "dpxwz_lyx",
                "wfu",
                "18888889999" )
        );
    }

    /**
     * Method: remove(UserInformation userInformation)
     */
    @Test
    public void testRemove ( ) throws Exception {
        userInformationDao.remove( new UserInformation(
                "lyx",
                "dpxwz_lyx",
                "wfu",
                "18888889999" )
        );
    }

    /**
     * Method: modify(UserInformation userInformation)
     */
    @Test
    public void testModify ( ) throws Exception {
        userInformationDao.modify(
                new UserInformation(
                        "lyx",
                        "dpxwz_lyx",
                        "wfu",
                        "18888889999" ),
                new UserInformation(
                        "lyx",
                        "dpxwz_lyx_modifyTest",
                        "wfuwfu",
                        "0000000000000" )
        );
    }


} 
