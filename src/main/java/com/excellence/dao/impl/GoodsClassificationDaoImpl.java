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
    public int addGoodsClassification ( GoodsClassification goodsClassification ) {
        return 0;
    }
    @Override
    public int removeGoodsClassification ( GoodsClassification goodsClassification ) {
        return 0;
    }
    @Override
    public int modifyGoodsClassification ( GoodsClassification goodsClassification, String goodsClassificationName ) {
        return 0;
    }
}
