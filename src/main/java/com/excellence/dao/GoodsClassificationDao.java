package com.excellence.dao;

import com.excellence.model.GoodsClassification;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName GoddsClassification.java
 * @PackageLoaction com.excellence.dao
 * @createTime 2020-05-20 16:16:00 星期三
 * @Description TODO
 */

/**
 * find
 * add
 * remove
 * modify
 */
public interface GoodsClassificationDao {
    public List<GoodsClassification> findAllGoodsClassification ( int currentPage, int pageSize );

    public int count_findAllGoodsClassification();

    public GoodsClassification findBy_classificationId ( String classificationId );

    public List<GoodsClassification> findBy_classificationName ( String classificationName, int currentPage, int pageSize );

    public int count_findBy_classificationName( String classificationName );

    public int addGoodsClassification ( GoodsClassification classification );

    public int removeGoodsClassification ( String classificationId );

    public int modifyGoodsClassification ( GoodsClassification classificationId, String classificationName );

}
