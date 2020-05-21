package com.excellence.dao.impl;

import com.excellence.dao.HeadPictureDao;
import com.excellence.model.HeadPicture;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * GoodsClassificationDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>5月 21, 2020</pre>
 */
public class GoodsClassificationDaoImplTest {

    static HeadPictureDao headPictureDao = new HeadPictureDaoImpl( );
    static List<HeadPicture> headPictureList = null;

    public static void show ( ) {
        headPictureList = headPictureDao.findAll( );
        for ( HeadPicture e : headPictureList )
            System.out.println( e.getPictureAddress( ) );
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
    }

    /**
     * Method: addGoodsClassification(GoodsClassification goodsClassification)
     */
    @Test
    public void testAddGoodsClassification ( ) throws Exception {
        headPictureDao.add( new HeadPicture( "6" ) );
        show( );
    }

    /**
     * Method: removeGoodsClassification(GoodsClassification goodsClassification)
     */
    @Test
    public void testRemoveGoodsClassification ( ) throws Exception {
        headPictureDao.modify( new HeadPicture( "6" ), new HeadPicture( "7" ) );
        show( );
    }

    /**
     * Method: modifyGoodsClassification(GoodsClassification goodsClassification, String wantGoodsClassification)
     */
    @Test
    public void testModifyGoodsClassification ( ) throws Exception {
        headPictureDao.remove( new HeadPicture( "7" ) );
        show( );
    }


} 
