package com.excellence.dao;

import com.excellence.model.HeadPicture;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName HeadPictureDao.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 16:17:00 星期三
 * @Description TODO
 */

/**
 * find
 * add
 * remove
 * modify
 */
public interface HeadPictureDao {
    public List<HeadPicture> findAll ( );

    public boolean add ( HeadPicture headPicture );

    public boolean remove ( HeadPicture headPicture );

    public boolean modify ( HeadPicture from, HeadPicture to );
}
