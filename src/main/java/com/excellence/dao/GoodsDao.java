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
    public List<Goods> findAllGoods ( int currentPage, int pageSize );

    public List<Goods> findBy_goodsName ( String goodsName, int currentPage, int pageSize );

    public int count_findBy_goodsName(String goodsName);

    public List<Goods> findBy_classificationId ( String classificationId, int currentPage, int pageSize );

    public int count_findBy_classificationId(String classificationId);

    public int addGoods ( Goods goods );

    public int removeGoods ( String goodsNumber );

    public int modifyGoods ( Goods goods, String goodsName );

}
