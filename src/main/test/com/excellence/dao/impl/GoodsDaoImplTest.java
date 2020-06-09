package com.excellence.dao.impl;

import com.excellence.dao.GoodsDao;
import com.excellence.model.Goods;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/**
 * GoodsDaoImpl Tester.
 *
 * @author acmaker
 * @version 1.0
 * @since <pre>5月 21, 2020</pre>
 */
public class GoodsDaoImplTest {

    static GoodsDao goodsDao = new GoodsDaoImpl( );
    static List<Goods> goodsList = new ArrayList<>( );

    @Before
    public void before ( ) throws Exception {
    }

    @After
    public void after ( ) throws Exception {
    }

    /**
     * Method: findAllGoods()
     */
    @Test
    public void testFindAllGoods ( ) throws Exception {
        goodsList = goodsDao.findAllGoods( 1,2 );

        System.out.println( goodsDao.count_findBy_classificationId( "1" ) );
        System.out.println( goodsDao.count_findBy_goodsName( "l" ) );
    }

    /**
     * Method: fingBy_goodsName(String goodsName)
     */
    @Test
    public void testFindBy_goodsName ( ) throws Exception {
        goodsList = goodsDao.findBy_goodsName( "pp", 1, 100 );
    }

    /**
     * Method: findBy_goodsClassification(String goodsClassification)
     */
    @Test
    public void testFindBy_goodsClassification ( ) throws Exception {
        goodsList = goodsDao.findBy_classificationId( "1", 1,100 );
    }

    /**
     * Method: addGoods(Goods goods)
     */
    @Test
    public void testAddGoods ( ) throws Exception {
        goodsDao.addGoods( new Goods(
                        "88",
                        "3.jpg",
                        "3",
                        "banana",
                        (float) 8.8,
                        (float) 8,
                        10,
                        "8.jpg",
                "1"
                )
        );
    }

    /**
     * Method: removeGoods(String goodsNumber)
     */
    @Test
    public void testRemoveGoods ( ) throws Exception {
        goodsDao.removeGoods( "88" );
    }

    /**
     * Method: modifyGoods(Goods goods, String goodsNumber)
     */
    @Test
    public void testModifyGoods ( ) throws Exception {
        goodsDao.modifyGoods(
                new Goods(
                        "88",
                        "3.jpg",
                        "3",
                        "banana",
                        (float) 8.8,
                        (float) 8,
                        9999,
                        "8.jpg",
                        "1"
                ),
                "88"
        );
    }


} 
