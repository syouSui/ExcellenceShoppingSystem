package com.excellence.service.normal;

import com.excellence.dao.GoodsDao;
import com.excellence.dao.impl.GoodsDaoImpl;
import com.excellence.model.Goods;
import com.excellence.model.User;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author acmaker & Kaffu chino
 * @ClassName FindGoodsService.java
 * @PackageLoaction com.excellence.service.normal
 * @createTime 2020-06-10 15:09:00 星期三
 * @Description TODO
 */
public class FindGoodsService {
    static GoodsDao goodsDao = new GoodsDaoImpl( );

    public void findAllGoods ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        List<Goods> list = null;
        list = goodsDao.findAllGoods(
                Integer.parseInt( request.getParameter( "currentPage" ) ),
                Integer.parseInt( request.getParameter( "pageSize" ) )
        );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findAll" );
    }

    public void count_findAllGoods ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println( new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        goodsDao.count_findAllGoods( )
                ).toJSON( )
        );
    }

    public void findBy_goodsName ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        List<Goods> list = null;
        list = goodsDao.findBy_goodsName(
                request.getParameter( "goodsName" ),
                Integer.parseInt( request.getParameter( "currentPage" ) ),
                Integer.parseInt( request.getParameter( "pageSize" ) )
        );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findBy_goodsName" );
    }

    public void count_findBy_goodsName ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println( new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        goodsDao.count_findBy_goodsName( request.getParameter( "goodsName" ) )
                ).toJSON( )
        );
    }

    public void findBy_storeId ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        List<Goods> list = null;
        list = goodsDao.findBy_storeId(
                request.getParameter( "storeId" ),
                Integer.parseInt( request.getParameter( "currentPage" ) ),
                Integer.parseInt( request.getParameter( "pageSize" ) )
        );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findBy_storeId" );
    }

    public void count_findBy_storeId ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println( new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        goodsDao.count_findBy_storeId( request.getParameter( "storeId" ) )
                ).toJSON( )
        );
    }

    public void findBy_classificationId ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        List<Goods> list = null;
        list = goodsDao.findBy_classificationId(
                request.getParameter( "classificationId" ),
                Integer.parseInt( request.getParameter( "currentPage" ) ),
                Integer.parseInt( request.getParameter( "pageSize" ) )
        );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findBy_goodsName" );
    }

    public void count_findBy_classificationId ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println( new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        goodsDao.count_findBy_classificationId( request.getParameter( "classificationId" ) )
                ).toJSON( )
        );
    }

    public void findBy_goodsNumber ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        Goods goods = null;
        goods = goodsDao.findBy_goodsNumber( request.getParameter( "goodsNumber" ) );
        if ( goods == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", goods ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", goods ).toJSON( ) );
        System.out.println( "findBy_goodsNumber" );
    }
}
