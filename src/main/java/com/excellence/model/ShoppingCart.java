package com.excellence.model;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/18 16:52
 ** LastEditors: Kaffu-Chino
 ** Description： 
 *********************************************************************************/

public class ShoppingCart {
    private String userName;
    private String goodsNumber;
    private int counter;

    public ShoppingCart ( ) {
    }

    public ShoppingCart( String userName, String goodsNumber, int counter) {
        this.userName = userName;
        this.goodsNumber = goodsNumber;
        this.counter = counter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
