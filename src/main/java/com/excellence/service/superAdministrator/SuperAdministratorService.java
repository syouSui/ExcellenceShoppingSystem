package com.excellence.service.superAdministrator;

import com.excellence.dao.StoreDao;
import com.excellence.dao.UserDao;
import com.excellence.dao.impl.StoreDaoImpl;
import com.excellence.dao.impl.UserDaoImpl;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author acmaker & Kaffu Chino
 * @version 1.0.0
 * @ClassName SuperAdministratorService.java
 * @PackageLoaction com.excellence.service.superAdministrator.statistics
 * @createTime 2020-06-09 15:11:00 星期二
 * @Description TODO
 */
public class SuperAdministratorService {
    static UserDao userDao = new UserDaoImpl( );
    static StoreDao storeDao = new StoreDaoImpl( );
    public void findUser ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( request.getParameter( "userName" ) == null )
            response.getWriter( ).println(
                    new ResultVo(
                            ResultVo.CODE_SUCCESS,
                            "success",
                            userDao.findBy_userEmail( request.getParameter( "userEmail" ) )
                    ).toJSON( )
            );
        else
            response.getWriter( ).println(
                    new ResultVo(
                            ResultVo.CODE_SUCCESS,
                            "success",
                            userDao.findBy_userEmail( request.getParameter( "userName" ) )
                    ).toJSON( )
            );
    }
    public void findAllUser ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        userDao.findAllUser(
                                Integer.parseInt( request.getParameter( "currentPage" ) ),
                                Integer.parseInt( request.getParameter( "pageSize" ) )
                        )
                ).toJSON( )
        );
    }
    public void removeUser ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        userDao.removeUser( request.getParameter( "userName" ) )
                ).toJSON( )
        );
    }
    public void removeStore ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        storeDao.removeStore( request.getParameter( "storeId" ) )
                ).toJSON( )
        );
    }
}
