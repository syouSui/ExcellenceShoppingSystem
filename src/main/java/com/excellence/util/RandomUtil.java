package com.excellence.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName RandomUtil.java
 * @PackageLoaction com.excellence.util
 * @createTime 2020-06-11 21:03:00 星期四
 * @Description TODO
 */
public class RandomUtil {
    static Random random = new Random( );

    public static String getUniqueId ( int length ) {
        String id = new SimpleDateFormat( "yyyyMMddHHmmss" ).format( new Date( ) );
        for ( int i = 0; i < length-id.length(); ++i ) {
            id += random.nextInt( 10 );
        }
        return id;
    }
}
