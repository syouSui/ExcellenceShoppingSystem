package com.excellence.model;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/18 16:47
 ** LastEditors: Kaffu-Chino
 ** Description： 
 *********************************************************************************/

public class UserInformation {
    private String userName;
    private String relativeName;
    private String address;
    private String relativePhone;

    public UserInformation ( ) {
    }

    public UserInformation( String userName, String relativeName, String address, String relativePhone) {
        this.userName = userName;
        this.relativeName = relativeName;
        this.address = address;
        this.relativePhone = relativePhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRelativePhone() {
        return relativePhone;
    }

    public void setRelativePhone(String relativePhone) {
        this.relativePhone = relativePhone;
    }
}
