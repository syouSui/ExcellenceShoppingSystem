package com.excellence.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/18 16:40
 ** LastEditors: Kaffu-Chino
 ** Description： 
 *********************************************************************************/

public class OrderList implements Serializable {
    private String orderId;
    private String orderDate;
    private String userName;
    private String goodsNumber;
    private int counter;
    private String relativeName;
    private String address;
    private String relativePhone;
    private int orderStatus;

    public OrderList ( ) {
    }

    public OrderList ( String orderId, String orderDate, String userName, String goodsNumber, int counter, String relativeName, String address, String relativePhone, int orderStatus ) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.userName = userName;
        this.goodsNumber = goodsNumber;
        this.counter = counter;
        this.relativeName = relativeName;
        this.address = address;
        this.relativePhone = relativePhone;
        this.orderStatus = orderStatus;
    }

    public String getOrderId ( ) {
        return orderId;
    }

    public void setOrderId ( String orderId ) {
        this.orderId = orderId;
    }

    public String getOrderDate ( ) {
        return orderDate;
    }

    public void setOrderDate ( String orderDate ) {
        this.orderDate = orderDate;
    }

    public String getUserName ( ) {
        return userName;
    }

    public void setUserName ( String userName ) {
        this.userName = userName;
    }

    public String getGoodsNumber ( ) {
        return goodsNumber;
    }

    public void setGoodsNumber ( String goodsNumber ) {
        this.goodsNumber = goodsNumber;
    }

    public int getCounter ( ) {
        return counter;
    }

    public void setCounter ( int counter ) {
        this.counter = counter;
    }

    public String getRelativeName ( ) {
        return relativeName;
    }

    public void setRelativeName ( String relativeName ) {
        this.relativeName = relativeName;
    }

    public String getAddress ( ) {
        return address;
    }

    public void setAddress ( String address ) {
        this.address = address;
    }

    public String getRelativePhone ( ) {
        return relativePhone;
    }

    public void setRelativePhone ( String relativePhone ) {
        this.relativePhone = relativePhone;
    }

    public int getOrderStatus ( ) {
        return orderStatus;
    }

    public void setOrderStatus ( int orderStatus ) {
        this.orderStatus = orderStatus;
    }

    public static String getSystemDateString ( ) {
        Date date = new Date( );
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
        String strdate = sdf.format( date );
        return strdate;
    }

}
