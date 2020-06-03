package com.excellence.model;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName Store.java
 * @PackageLoaction com.excellence.model
 * @createTime 2020-06-03 17:51:00 星期三
 * @Description TODO
 */
public class Store {
    private String storeId;
    private String storeName;
    private String storePicture;
    private String storeDescription;
    private String userName;

    public Store ( ) {
    }
    public Store ( String storeId, String storeName, String storePicture, String storeDescription, String userName ) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storePicture = storePicture;
        this.storeDescription = storeDescription;
        this.userName = userName;
    }
    public String getStoreId ( ) {
        return storeId;
    }
    public void setStoreId ( String storeId ) {
        this.storeId = storeId;
    }
    public String getStoreName ( ) {
        return storeName;
    }
    public void setStoreName ( String storeName ) {
        this.storeName = storeName;
    }
    public String getStorePicture ( ) {
        return storePicture;
    }
    public void setStorePicture ( String storePicture ) {
        this.storePicture = storePicture;
    }
    public String getStoreDescription ( ) {
        return storeDescription;
    }
    public void setStoreDescription ( String storeDescription ) {
        this.storeDescription = storeDescription;
    }
    public String getUserName ( ) {
        return userName;
    }
    public void setUserName ( String userName ) {
        this.userName = userName;
    }
}
