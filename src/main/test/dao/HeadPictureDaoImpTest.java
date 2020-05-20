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
    public static void main ( String[] args ) {
        HeadPictureDao headPictureDao = new HeadPictureDaoImpl();
        List<HeadPicture> headPictureList = headPictureDao.findAll();

        for ( HeadPicture e : headPictureList ) {
            System.out.println( e.getPictureAddress() );
        }
    }
}
