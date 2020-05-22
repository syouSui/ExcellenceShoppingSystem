package com.excellence.model;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/18 17:17
 ** LastEditors: Kaffu-Chino
 ** Description： 
 *********************************************************************************/

public class HeadPicture {
    private String pictureAddress;

    public HeadPicture ( ) {
    }

    public HeadPicture( String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }
}
