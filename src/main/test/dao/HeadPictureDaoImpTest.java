package dao;

import com.excellence.dao.HeadPictureDao;
import com.excellence.dao.impl.HeadPictureDaoImpl;
import com.excellence.model.HeadPicture;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName HeadPictureDaoImpTest.java
 * @PackageLoaction dao
 * @createTime 2020-05-20 21:18:00 星期三
 * @Description TODO
 */
public class HeadPictureDaoImpTest {

    static HeadPictureDao headPictureDao = new HeadPictureDaoImpl( );
    static List<HeadPicture> headPictureList = null;

    public static void show ( ) {
        headPictureList = headPictureDao.findAll( );
        for ( HeadPicture e : headPictureList )
            System.out.println( e.getPictureAddress( ) );
        System.out.println( );
    }

    public static void main ( String[] args ) {

        show();

        headPictureDao.add( new HeadPicture( "6" ) );
        show();

        headPictureDao.modify( new HeadPicture( "6" ), new HeadPicture( "7" ) );
        show();

        headPictureDao.remove( new HeadPicture( "7" ) );
        show();

    }
}
