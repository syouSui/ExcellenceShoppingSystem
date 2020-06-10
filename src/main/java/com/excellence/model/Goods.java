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
    private String classificationId;
    private String goodsName;
    private float priceOrigin;
    private float priceSale;
    private int counter;
    private String goodPicture;
    private String storeId;

    public Goods () {

    }

    public Goods( String goodsNumber, String goodsPictureTop, String classificationId, String goodsName, float priceOrigin, float priceSale, int counter, String goodPicture, String storeId) {
        this.goodsNumber = goodsNumber;
        this.goodsPictureTop = goodsPictureTop;
        this.classificationId = classificationId;
        this.goodsName = goodsName;
        this.priceOrigin = priceOrigin;
        this.priceSale = priceSale;
        this.counter = counter;
        this.goodPicture = goodPicture;
        this.storeId = storeId;
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

    public String getClassificationId () {
        return classificationId;
    }

    public void setClassificationId ( String classificationId ) {
        this.classificationId = classificationId;
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

    public String getStoreId ( ) {
        return storeId;
    }

    public void setStoreId ( String storeId ) {
        this.storeId = storeId;
    }
}
