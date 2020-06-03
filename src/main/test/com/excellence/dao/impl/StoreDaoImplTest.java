package com.excellence.dao.impl;

import com.excellence.dao.StoreDao;
import com.excellence.model.Store;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * StoreDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>6�� 3, 2020</pre>
 */
public class StoreDaoImplTest {

    @Before
    public void before ( ) throws Exception {
    }

    @After
    public void after ( ) throws Exception {
    }

    StoreDao storeDao = new StoreDaoImpl( );
    Store store = null;
    List<Store> storeList = null;

    /**
     * Method: findAllStore(int currentPage, int pageSize)
     */
    @Test
    public void testFindAllStore ( ) throws Exception {
        storeList = storeDao.findAllStore( 1, 100 );
    }

    /**
     * Method: count_findAllUser()
     */
    @Test
    public void testCount_findAllUser ( ) throws Exception {
        System.out.println( storeDao.count_findAllStore( ) );
    }

    /**
     * Method: findBy_storeName(String storeName, int currentPage, int pageSize)
     */
    @Test
    public void testFindBy_storeName ( ) throws Exception {
        storeList = storeDao.findBy_storeName( "a", 1, 100 );
    }

    /**
     * Method: count_findBy_storeName(String storeName)
     */
    @Test
    public void testCount_findBy_storeName ( ) throws Exception {
        System.out.println( storeDao.count_findBy_storeName( "a" ) );
    }

    /**
     * Method: findBy_storeId(String storeId)
     */
    @Test
    public void testFindBy_storeId ( ) throws Exception {
        store = storeDao.findBy_storeId( "2323" );
    }

    /**
     * Method: findBy_userName(String userName)
     */
    @Test
    public void testFindBy_userName ( ) throws Exception {
        store = storeDao.findBy_userName( "lyx" );
    }

    /**
     * Method: addStore(Store store)
     */
    @Test
    public void testAddStore ( ) throws Exception {
        storeDao.addStore(
                new Store(
                        "33323",
                        "llyyxx",
                        "dpxwz",
                        "lllhhh",
                        "dpxwz" )
        );
    }

    /**
     * Method: removeStore(String storeId)
     */
    @Test
    public void testRemoveStore ( ) throws Exception {
        storeDao.removeStore( "33323" );
    }

    /**
     * Method: modifyStore(String storeId, Store store)
     */
    @Test
    public void testModifyStore ( ) throws Exception {
        storeDao.modifyStore(
                "33323",
                new Store(
                        "33323",
                        "_llyyxx",
                        "_dpxwz",
                        "_lllhhh",
                        "dpxwz" )
        );
    }

} 
