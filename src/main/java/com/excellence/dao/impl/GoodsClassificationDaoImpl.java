package com.excellence.dao.impl;

import com.excellence.dao.GoodsClassificationDao;
import com.excellence.model.GoodsClassification;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName GoodsClassificationDaoImpl.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:05:00 星期三
 * @Description TODO
 */
public class GoodsClassificationDaoImpl implements GoodsClassificationDao {
    @Override
    public List<GoodsClassification> findAllGoodsClassification ( ) {
        return null;
    }
    @Override
    public boolean addGoodsClassification ( GoodsClassification goodsClassification ) {
        return false;
    }
    @Override
    public boolean removeGoodsClassification ( GoodsClassification goodsClassification ) {
        return false;
    }
    @Override
    public boolean modifyGoodsClassification ( GoodsClassification goodsClassification, String goodsClassificationName ) {
        return false;
    }
}
