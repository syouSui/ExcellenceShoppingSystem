package com.excellence.controller.normal;

import com.excellence.service.normal.FindGoodsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @PackageLoaction ${PACKAGE_NAME}
 * @createTime 2020-06-10 15:11:00 星期三
 * @Description TODO
 */
@WebServlet ( name = "FindGoodsServlet", urlPatterns = { "/FindGoodsServlet" } )
public class FindGoodsServlet extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String str_method = request.getParameter( "method" );
        try {
            Method method = FindGoodsService.class.getMethod( str_method, HttpServletRequest.class, HttpServletResponse.class );
            method.invoke( new FindGoodsService( ), request, response );
        } catch ( NoSuchMethodException | IllegalAccessException | InvocationTargetException e ) {
            e.printStackTrace( );
        }

//        // 读取请求内容
//        BufferedReader br = new BufferedReader( new InputStreamReader( request.getInputStream( ), StandardCharsets.UTF_8 ) );
//        String line = null;
//        StringBuilder sb = new StringBuilder( );
//        while ( (line = br.readLine( )) != null ) {
//            sb.append( line );
//        }
//        // 将字符串转换为json对象
//        ObjectMapper objectMapper = new ObjectMapper( );
//        JsonNode jsonNode = objectMapper.readTree( sb.toString( ) );
//
//        String str_method = jsonNode.get( "params" ).get( "method" ).asText( );
////        String str_method = jsonNode.at( "/params/method" ).asText( );
//        try {
//            Method method = FindGoodsService.class.getMethod( str_method, HttpServletRequest.class, HttpServletResponse.class );
//            method.invoke( new FindGoodsService( ), request, response );
//        } catch ( NoSuchMethodException | IllegalAccessException | InvocationTargetException e ) {
//            e.printStackTrace( );
//        }
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doPost( request, response );
    }
}
