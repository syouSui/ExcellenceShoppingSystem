package com.excellence.service.normalUser;

import com.excellence.dao.StoreDao;
import com.excellence.dao.impl.StoreDaoImpl;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kaffu chino
 * @version 1.0.0
 * @ClassName NormalUserService.java
 * @PackageLoaction com.excellence.service.normalUser.trolley
 * @createTime 2020-06-10 22:10:23 星期三
 * @Description TODO
 */

public class UserStoreService {
    StoreDao storeDao = new StoreDaoImpl( );
    public void findAllStore ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        storeDao.findAllStore(
                                Integer.parseInt( request.getParameter( "currentPage" ) ),
                                Integer.parseInt( request.getParameter( "pageSize" ) )
                        )
                ).toJSON( )
        );
    }

    public void count_findAllStore ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        storeDao.count_findAllStore( )
                ).toJSON( )
        );
    }

    public void findBy_storeName ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        storeDao.findBy_storeName(
                                request.getParameter( "storeName" ),
                                Integer.parseInt( request.getParameter( "currentPage" ) ),
                                Integer.parseInt( request.getParameter( "pageSize" ) )
                        )
                ).toJSON( )
        );
    }

    public void count_findBy_storeName ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        storeDao.count_findBy_storeName( request.getParameter( "storeName" ) )
                ).toJSON( )
        );
    }

    public void findBy_storeId ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        storeDao.findBy_storeId( request.getParameter( "storeId" ) )
                ).toJSON( )
        );
    }
}
