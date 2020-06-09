package com.excellence.service.loginAndRegister;

import com.excellence.dao.UserDao;
import com.excellence.dao.impl.UserDaoImpl;
import com.excellence.model.User;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        if ( user != null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", user ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", user ).toJSON( ) );
        System.out.println( "login" );
    }

    public void register ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( userDao.addUser(
                new User(
                        request.getParameter( "userName" ),
                        "",
                        request.getParameter( "userPassword" ),
                        0,
                        "",
                        "",
                        ""
                )
        )==1 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", null ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", null ).toJSON( ) );
        System.out.println( "login" );
    }

}
