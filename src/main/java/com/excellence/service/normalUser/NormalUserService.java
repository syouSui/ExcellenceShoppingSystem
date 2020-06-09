package com.excellence.service.normalUser;

import com.excellence.dao.GoodsDao;
import com.excellence.dao.StoreDao;
import com.excellence.dao.UserDao;
import com.excellence.dao.impl.GoodsDaoImpl;
import com.excellence.dao.impl.StoreDaoImpl;
import com.excellence.dao.impl.UserDaoImpl;
import com.excellence.model.Goods;
import com.excellence.model.Store;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName NormalUserService.java
 * @PackageLoaction com.excellence.service.normalUser.trolley
 * @createTime 2020-06-09 15:10:00 星期二
 * @Description TODO
 */
public class NormalUserService {
    static UserDao userDao = new UserDaoImpl( );
    static StoreDao storeDao = new StoreDaoImpl( );
    static GoodsDao goodsDao = new GoodsDaoImpl( );

    public void findBy_storeName ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        List<Store> list = null;
        list = storeDao.findBy_storeName( request.getParameter( "storeName" ),
                Integer.parseInt( request.getParameter( "currentPage" ) ),
                Integer.parseInt( request.getParameter( "pageSize" ) )
        );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findBy_storeName" );
    }

    public void findBy_goodsNumber ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        Goods goods = null;
        goods = goodsDao.findBy_goodsNumber( request.getParameter( "goodsNumber" ) );
        if ( goods == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", goods ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", goods ).toJSON( ) );
        System.out.println( "findBy_goodsNumber" );
    }

    public void findAllGoods ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        List<Goods> list = null;
        list = goodsDao.findAllGoods(
                Integer.parseInt( request.getParameter( "currentPage" ) ),
                Integer.parseInt( request.getParameter( "pageSize" ) )
        );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findAllGoods" );
    }

    public void findBy_goodsName ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        List<Goods> list = null;
        list = goodsDao.findBy_goodsName( request.getParameter( "goodsName" ),
                Integer.parseInt( request.getParameter( "currentPage" ) ),
                Integer.parseInt( request.getParameter( "pageSize" ) )
        );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findBy_goodsName" );
    }

    public void findBy_classificationId ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        List<Goods> list = null;
        list = goodsDao.findBy_goodsName( request.getParameter( "classificationId" ),
                Integer.parseInt( request.getParameter( "currentPage" ) ),
                Integer.parseInt( request.getParameter( "pageSize" ) )
        );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findBy_classificationId" );
    }

}
