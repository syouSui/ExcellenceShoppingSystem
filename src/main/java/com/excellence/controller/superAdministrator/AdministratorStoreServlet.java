package com.excellence.controller.superAdministrator;

import com.excellence.service.superAdministrator.AdministratorStoreService;

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
 ** Date： 2020/6/11 0:17
 ** LastEditors: Kaffu Chino
 ** Description： 
 *********************************************************************************/
@WebServlet ( name = "AdministratorStoreServlet", urlPatterns = "/AdministratorStoreServlet" )
public class AdministratorStoreServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String str_method = request.getParameter( "method" );
        try {
            Method method = AdministratorStoreService.class.getMethod( str_method, HttpServletRequest.class, HttpServletResponse.class );
            method.invoke( new AdministratorStoreService( ), request, response );
        } catch ( NoSuchMethodException e ) {
            e.printStackTrace( );
        } catch ( IllegalAccessException e ) {
            e.printStackTrace( );
        } catch ( InvocationTargetException e ) {
            e.printStackTrace( );
        }
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }
}
