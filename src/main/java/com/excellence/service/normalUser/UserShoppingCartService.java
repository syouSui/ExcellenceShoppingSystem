package com.excellence.service.normalUser;

import com.excellence.dao.ShoppingCartDao;
import com.excellence.dao.impl.ShoppingCartDaoImpl;
import com.excellence.model.ShoppingCart;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserShoppingCartService {
    ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl( );

    public void findBy_userName ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        shoppingCartDao.findBy_userName(
                                request.getParameter( "userName" ),
                                Integer.parseInt( request.getParameter( "currentPage" ) ),
                                Integer.parseInt( request.getParameter( "pageSize" ) )
                        )
                ).toJSON( )
        );
    }

    public void count_findBy_userName ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        shoppingCartDao.count_findBy_userName( request.getParameter( "userName" ) )
                ).toJSON( )
        );
    }

    public void add ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( shoppingCartDao.add(
                new ShoppingCart(
                        request.getParameter( "userName" ),
                        request.getParameter( "goodsNumber" ),
                        Integer.parseInt( request.getParameter( "counter" ) )
                )
        ) != 1 ) {
            response.getWriter( ).println(
                    new ResultVo(
                            ResultVo.CODE_FAILED,
                            "failed",
                            null
                    ).toJSON( )
            );
        } else {
            response.getWriter( ).println(
                    new ResultVo(
                            ResultVo.CODE_SUCCESS,
                            "success",
                            null
                    ).toJSON( )
            );
        }
    }

    public void remove ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( shoppingCartDao.remove(
                new ShoppingCart(
                        request.getParameter( "userName" ),
                        request.getParameter( "goodsNumber" ),
                        0
                )
        ) != 1 ) {
            response.getWriter( ).println(
                    new ResultVo(
                            ResultVo.CODE_FAILED,
                            "failed",
                            null
                    ).toJSON( )
            );
        } else {
            response.getWriter( ).println(
                    new ResultVo(
                            ResultVo.CODE_SUCCESS,
                            "success",
                            null
                    ).toJSON( )
            );
        }
    }

    public void modifyCount ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( shoppingCartDao.modifyCount(
                new ShoppingCart(
                        request.getParameter( "userName" ),
                        request.getParameter( "goodsNumber" ),
                        0
                ),
                Integer.parseInt( request.getParameter( "counter" ) )
        ) != 1 ) {
            response.getWriter( ).println(
                    new ResultVo(
                            ResultVo.CODE_FAILED,
                            "failed",
                            null
                    ).toJSON( )
            );
        } else {
            response.getWriter( ).println(
                    new ResultVo(
                            ResultVo.CODE_SUCCESS,
                            "success",
                            null
                    ).toJSON( )
            );
        }
    }

    public void addCount ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( shoppingCartDao.addCount(
                new ShoppingCart(
                        request.getParameter( "userName" ),
                        request.getParameter( "goodsNumber" ),
                        0
                ),
                Integer.parseInt( request.getParameter( "counter" ) )
        ) != 1 ) {
            response.getWriter( ).println(
                    new ResultVo(
                            ResultVo.CODE_FAILED,
                            "failed",
                            null
                    ).toJSON( )
            );
        } else {
            response.getWriter( ).println(
                    new ResultVo(
                            ResultVo.CODE_SUCCESS,
                            "success",
                            null
                    ).toJSON( )
            );
        }
    }
}
