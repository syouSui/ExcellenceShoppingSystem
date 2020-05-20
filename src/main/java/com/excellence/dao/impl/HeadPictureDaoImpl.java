package com.excellence.dao.impl;

import com.excellence.dao.HeadPictureDao;
import com.excellence.model.HeadPicture;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName HeadPictureDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:06:00 星期三
 * @Description TODO
 */
public class HeadPictureDaoImpl implements HeadPictureDao {
    @Override
    public List<HeadPicture> findBy_userName ( String userName ) {
        return null;
    }
    @Override
    public HeadPicture add ( HeadPicture headPicture ) {
        return null;
    }
    @Override
    public boolean remove ( HeadPicture headPicture ) {
        return false;
    }
    @Override
    public boolean modify ( HeadPicture headPicture ) {
        return false;
    }
}
