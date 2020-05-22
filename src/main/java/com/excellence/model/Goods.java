package com.excellence.model;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/18 16:54
 ** LastEditors: Kaffu-Chino
 ** Description： 
 *********************************************************************************/
public class Goods {
    private String goodsNumber;
    private String goodsPictureTop;
    private String goodsClassification;
    private String goodsName;
    private float priceOrigin;
    private float priceSale;
    private int counter;
    private String goodPicture;

    public Goods () {

    }

    public Goods(String goodsNumber, String goodsPictureTop, String goodsClassification, String goodsName, float priceOrigin, float priceSale, int counter, String goodPicture) {
        this.goodsNumber = goodsNumber;
        this.goodsPictureTop = goodsPictureTop;
        this.goodsClassification = goodsClassification;
        this.goodsName = goodsName;
        this.priceOrigin = priceOrigin;
        this.priceSale = priceSale;
        this.counter = counter;
        this.goodPicture = goodPicture;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsPictureTop() {
        return goodsPictureTop;
    }

    public void setGoodsPictureTop(String goodsPictureTop) {
        this.goodsPictureTop = goodsPictureTop;
    }

    public String getGoodsClassification() {
        return goodsClassification;
    }

    public void setGoodsClassification(String goodsClassification) {
        this.goodsClassification = goodsClassification;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getPriceOrigin() {
        return priceOrigin;
    }

    public void setPriceOrigin(float priceOrigin) {
        this.priceOrigin = priceOrigin;
    }

    public float getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(float priceSale) {
        this.priceSale = priceSale;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getGoodPicture() {
        return goodPicture;
    }

    public void setGoodPicture(String goodPicture) {
        this.goodPicture = goodPicture;
    }
}
