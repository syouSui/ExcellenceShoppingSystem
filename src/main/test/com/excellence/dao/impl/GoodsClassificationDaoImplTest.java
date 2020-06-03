package com.excellence.dao.impl;

import com.excellence.dao.GoodsClassificationDao;
import com.excellence.model.GoodsClassification;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * GoodsClassificationDaoImpl Tester.
 *
 * @author acmaker
 * @version 1.0
 * @since <pre>5月 21, 2020</pre>
 */
public class GoodsClassificationDaoImplTest {

    static GoodsClassificationDao goodsClassificationDao = new GoodsClassificationDaoImpl( );
    static List<GoodsClassification> goodsClassificationList = null;

    public static void show ( ) {
        goodsClassificationList = goodsClassificationDao.findAllGoodsClassification( 1, 2 );
        for ( GoodsClassification e : goodsClassificationList )
            System.out.println(
                    e.getClassificationId( ) + "\t" +
                            e.getClassificationName( )
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
     * Method: findAllGoodsClassification()
     */
    @Test
    public void testFindAllGoodsClassification ( ) throws Exception {
        show( );
        System.out.println( goodsClassificationDao.count_findAllGoodsClassification( ) );
        System.out.println( goodsClassificationDao.count_findBy_classificationName( "e" ) );
    }

    /**
     * Method: findClassification(String classification, int currentPage, int pageSize)
     */
    @Test
    public void testFindClassification ( ) throws Exception {
        GoodsClassification byClassificationId = goodsClassificationDao.findBy_classificationId( "1" );
    }

    /**
     * Method: findClassificationName(String classificationName, int currentPage, int pageSize)
     */
    @Test
    public void testFindClassificationName ( ) throws Exception {
        List<GoodsClassification> e = goodsClassificationDao.findBy_classificationName( "e", 1, 100 );
    }


    /**
     * Method: addGoodsClassification(GoodsClassification goodsClassification)
     */
    @Test
    public void testAddGoodsClassification ( ) throws Exception {
        goodsClassificationDao.addGoodsClassification( new GoodsClassification(
                "4",
                "d" )
        );
        show( );
    }

    /**
     * Method: removeGoodsClassification(GoodsClassification goodsClassification)
     */
    @Test
    public void testRemoveGoodsClassification ( ) throws Exception {
        goodsClassificationDao.removeGoodsClassification( "4" );
        show( );
    }

    /**
     * Method: modifyGoodsClassification(GoodsClassification goodsClassification, String wantGoodsClassification)
     */
    @Test
    public void testModifyGoodsClassification ( ) throws Exception {
        goodsClassificationDao.modifyGoodsClassification( new GoodsClassification(
                        "4",
                        "d" ),
                "hhhhhh"
        );
        show( );
    }
}
