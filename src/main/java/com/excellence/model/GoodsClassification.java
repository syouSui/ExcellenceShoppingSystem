package com.excellence.model;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/18 17:11
 ** LastEditors: Kaffu-Chino
 ** Description： 
 *********************************************************************************/

public class GoodsClassification {
    private String goodsClassification;
    private String classificationName;

    public GoodsClassification(String goodsClassification, String classificationName) {
        this.goodsClassification = goodsClassification;
        this.classificationName = classificationName;
    }

    public String getGoodsClassification() {
        return goodsClassification;
    }

    public void setGoodsClassification(String goodsClassification) {
        this.goodsClassification = goodsClassification;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }
}
