package com.excellence.dao.impl;

import com.excellence.model.Goods;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName GoodsDao.java
 * @PackageLoaction com.excellence.dao.impl
 * @createTime 2020-05-20 19:05:00 星期三
 * @Description TODO
 */
public class GoodsDaoImpl implements com.excellence.dao.GoodsDao {
    @Override
    public List<Goods> findAllGoods ( ) {
        return null;
    }
    @Override
    public List<Goods> fingBy_goodsName ( String goodsName ) {
        return null;
    }
    @Override
    public List<Goods> findBy_goodsClassification ( String goodsClassification ) {
        return null;
    }
    @Override
    public int addGoods ( Goods goods ) {
        return 0;
    }
    @Override
    public int removeGoods ( Goods goods ) {
        return 0;
    }
    @Override
    public int modifyGoods ( Goods goods, String goodsName ) {
        return 0;
    }
}
