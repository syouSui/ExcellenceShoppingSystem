package com.excellence.controller;


import com.excellence.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName UserServlet.java
 * @PackageLoaction com.excellence.controller
 * @createTime 2020-05-22 17:21:00 星期五
 * @Description TODO
 */
@WebServlet ( "/UserServlet" )
public class UserServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        new User( );

    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }
}
