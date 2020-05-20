package com.excellence.model;

import java.io.Serializable;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/18 16:28
 ** LastEditors: Kaffu-Chino
 ** Description： 
 *********************************************************************************/

public class User implements Serializable {
    private String userName;
    private String userNickname;
    private String userPassword;
    private int role;
    private String phone;
    private String usrEmail;

    public User ( String userName,String userNickname, String userPassword, int role, String phone, String usrEmail ) {
        this.userName = userName;
        this.userNickname = userNickname;
        this.userPassword = userPassword;
        this.role = role;
        this.phone = phone;
        this.usrEmail = usrEmail;
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

    public String getUserPass ( ) {
        return userPassword;
    }

    public void setUserPass ( String userPassword ) {
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

    public String getUsrEmail ( ) {
        return usrEmail;
    }

    public void setUsrEmail ( String usrEmail ) {
        this.usrEmail = usrEmail;
    }

}
