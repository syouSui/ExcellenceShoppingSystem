package test.com.excellence.dao.impl;

import com.excellence.dao.HeadPictureDao;
import com.excellence.dao.impl.HeadPictureDaoImpl;
import com.excellence.model.HeadPicture;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * HeadPictureDaoImpl Tester.
 *
 * @author acmaker
 * @version 1.0
 * @since <pre>5月 21, 2020</pre>
 */
public class HeadPictureDaoImplTest {

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
     * Method: findAll()
     */
    @Test
    public void testFindAll ( ) throws Exception {
        show( );
    }

    /**
     * Method: add(HeadPicture headPicture)
     */
    @Test
    public void testAdd ( ) throws Exception {
        headPictureDao.add( new HeadPicture( "6" ) );
        show( );
    }

    /**
     * Method: remove(HeadPicture headPicture)
     */
    @Test
    public void testRemove ( ) throws Exception {
        headPictureDao.modify( new HeadPicture( "6" ), new HeadPicture( "7" ) );
        show( );
    }

    /**
     * Method: modify(HeadPicture from, HeadPicture to)
     */
    @Test
    public void testModify ( ) throws Exception {
        headPictureDao.remove( new HeadPicture( "7" ) );
        show( );
    }


}
