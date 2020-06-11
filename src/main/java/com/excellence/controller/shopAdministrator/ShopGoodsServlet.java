package com.excellence.controller.shopAdministrator;

import com.excellence.service.shopAdministrator.ShopGoodsService;

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
 ** Date： 2020/6/11 0:15
 ** LastEditors: Kaffu Chino
 ** Description： 
 *********************************************************************************/
@WebServlet(name = "ShopGoodsServlet", urlPatterns={"/ShopGoodsServlet"})
public class ShopGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str_method = request.getParameter( "method" );
        try {
            Method method = ShopGoodsService.class.getMethod( str_method, HttpServletRequest.class, HttpServletResponse.class );
            method.invoke( new ShopGoodsService( ), request, response );
        } catch ( NoSuchMethodException e ) {
            e.printStackTrace( );
        } catch ( IllegalAccessException e ) {
            e.printStackTrace( );
        } catch ( InvocationTargetException e ) {
            e.printStackTrace( );
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
