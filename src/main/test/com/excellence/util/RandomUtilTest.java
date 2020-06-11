package com.excellence.util;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * RandomUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>6�� 11, 2020</pre>
 */
public class RandomUtilTest {

    @Before
    public void before ( ) throws Exception {
    }

    @After
    public void after ( ) throws Exception {
    }

    /**
     * Method: getUniqueId(int length)
     */
    @Test
    public void testGetUniqueId ( ) throws Exception {
        System.out.println( RandomUtil.getUniqueId(20));
    }


} 
