package com.excellence.controller.shopAdministrator;

import com.excellence.service.normalUser.NormalUserService;
import com.excellence.service.shopAdministrator.EditShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @PackageLoaction ${PACKAGE_NAME}
 * @createTime 2020-06-10 14:28:00 星期三
 * @Description TODO
 */
@WebServlet ( name = "EditShopServlet" )
public class EditShopServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String str_method = request.getParameter( "method" );
        try {
            Method method = EditShopService.class.getMethod( str_method, HttpServletRequest.class, HttpServletResponse.class );
            method.invoke( new EditShopService( ), request, response );
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
