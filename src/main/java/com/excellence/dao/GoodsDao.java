package com.excellence.dao;

import com.excellence.model.Goods;

import java.util.List;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/18 18:23
 ** LastEditors: Kaffu-Chino
 ** Description： 
 *********************************************************************************/

/**
 * find
 * add
 * remove
 * modify
 */
public interface GoodsDao {
    public List<Goods> findAllGoods ( );

    public List<Goods> findBy_goodsName( String goodsName );

    public List<Goods> findBy_goodsClassification(String goodsClassification );

    public int addGoods ( Goods goods );

    public int removeGoods ( String goodsNumber );

    public int modifyGoods ( Goods goods, String goodsName );

}
