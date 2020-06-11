package com.excellence.service.normal;

import com.excellence.dao.UserDao;
import com.excellence.dao.impl.UserDaoImpl;
import com.excellence.model.User;
import com.excellence.util.ResultVo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.IOException;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName LoginAndRegisterService.java
 * @PackageLoaction com.excellence.service.loginAndRegister
 * @createTime 2020-06-09 15:05:00 星期二
 * @Description TODO
 */
public class LoginAndRegisterService {
    static UserDao userDao = new UserDaoImpl( );

    public void login ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        User user = null;
        user = userDao.findBy_userName_userPassword( request.getParameter( "userName" ), request.getParameter( "userPassword" ) );
        if ( user == null ) {
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", user ).toJSON( ) );
        } else {
            HttpSession session = request.getSession( );
            session.setAttribute( "userName", request.getParameter( "userName" ) );
            session.setAttribute( "userPass", request.getParameter( "userPassword" ) );
            if ( "1".equals( request.getParameter( "rememberMe" ) ) ) {
                Cookie userNameCookie = new Cookie( "userName", user.getUserName( ) );
                Cookie userPasswordCookie = new Cookie( "", user.getUserPassword( ) );
                Cookie rememberMeCookie = new Cookie( "", request.getParameter( "rememberMe" ) );
                userNameCookie.setMaxAge( 3 * 24 * 60 * 60 );
                userPasswordCookie.setMaxAge( 3 * 24 * 60 * 60 );
                rememberMeCookie.setMaxAge( 3 * 24 * 60 * 60 );
                response.addCookie( userNameCookie );
                response.addCookie( userPasswordCookie );
                response.addCookie( rememberMeCookie );
            }
            session.setAttribute( "role", user.getRole( ) );
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", user ).toJSON( ) );
        }
        System.out.println( "login" );
    }

    public void register ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        String role = request.getParameter( "role" );
        if ( "0".equals( role ) == false || "1".equals( role ) == false ) {
            role = "0";
        }
        if ( userDao.addUser(
                new User(
                        request.getParameter( "userName" ),
                        "",
                        request.getParameter( "userPassword" ),
                        Integer.parseInt( role ),
                        "",
                        request.getParameter( "userEmail" ),
                        ""
                )
        ) != 1 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", null ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", 1 ).toJSON( ) );
        System.out.println( "register" );
    }

}
