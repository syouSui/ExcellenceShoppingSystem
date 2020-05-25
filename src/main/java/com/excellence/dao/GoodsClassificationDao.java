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
    public List<GoodsClassification> findAllGoodsClassification ( );

    public int addGoodsClassification ( GoodsClassification goodsClassification );

    public int removeGoodsClassification ( String goodsClassification );

    public int modifyGoodsClassification ( GoodsClassification goodsClassification, String goodsClassificationName );

}
