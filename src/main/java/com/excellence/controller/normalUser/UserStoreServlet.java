package com.excellence.controller.normalUser;

import com.excellence.service.normalUser.UserStoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu Chino
 ** Date： 2020/6/11 0:11
 ** LastEditors: Kaffu Chino
 ** Description： 
 *********************************************************************************/
@WebServlet ( name = "UserStoreServlet", urlPatterns = "/UserStoreServlet" )
public class UserStoreServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String str_method = request.getParameter( "method" );
        try {
            Method method = UserStoreService.class.getMethod( str_method, HttpServletRequest.class, HttpServletResponse.class );
            method.invoke( new UserStoreService( ), request, response );
        } catch ( NoSuchMethodException e ) {
            e.printStackTrace( );
        } catch ( IllegalAccessException e ) {
            e.printStackTrace( );
        } catch ( InvocationTargetException e ) {
            e.printStackTrace( );
        }
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doPost( request, response );
    }
}
