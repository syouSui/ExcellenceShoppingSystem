package com.excellence.model;

import java.io.Serializable;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/18 16:28
 ** LastEditors: acmaker
 ** Description： 
 *********************************************************************************/

public class User implements Serializable {
    private String userName;
    private String userNickname;
    private String userPassword;
    private int role;
    private String phone;
    private String userEmail;
    private String userPicture;

    public User ( ) {
    }

    public User ( String userName, String userNickname, String userPassword, int role, String phone, String usrEmail, String userPicture ) {
        this.userName = userName;
        this.userNickname = userNickname;
        this.userPassword = userPassword;
        this.role = role;
        this.phone = phone;
        this.userEmail = usrEmail;
        this.userPicture = userPicture;
    }

    public String getUserName ( ) {
        return userName;
    }
    public void setUserName ( String userName ) {
        this.userName = userName;
    }
    public String getUserNickname ( ) {
        return userNickname;
    }
    public void setUserNickname ( String userNickname ) {
        this.userNickname = userNickname;
    }
    public String getUserPassword ( ) {
        return userPassword;
    }
    public void setUserPassword ( String userPassword ) {
        this.userPassword = userPassword;
    }
    public int getRole ( ) {
        return role;
    }
    public void setRole ( int role ) {
        this.role = role;
    }
    public String getPhone ( ) {
        return phone;
    }
    public void setPhone ( String phone ) {
        this.phone = phone;
    }
    public String getUserEmail ( ) {
        return userEmail;
    }
    public void setUserEmail ( String userEmail ) {
        this.userEmail = userEmail;
    }
    public String getUserPicture ( ) {
        return userPicture;
    }
    public void setUserPicture ( String userPicture ) {
        this.userPicture = userPicture;
    }
}
