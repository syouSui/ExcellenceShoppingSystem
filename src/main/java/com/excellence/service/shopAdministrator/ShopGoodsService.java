package com.excellence.service.shopAdministrator;

import com.excellence.dao.GoodsDao;
import com.excellence.dao.impl.GoodsDaoImpl;
import com.excellence.model.Goods;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName EditGoodsService.java
 * @PackageLoaction com.excellence.service.shopAdministrator
 * @createTime 2020-06-10 17:18:00 星期三
 * @Description TODO
 */
public class ShopGoodsService {
    static GoodsDao goodsDao = new GoodsDaoImpl( );

    public void addGoods ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( goodsDao.addGoods(
                new Goods(
                        request.getParameter( "goodsNumber" ),
                        request.getParameter( "goodsPictureTop" ),
                        request.getParameter( "classificationId" ),
                        request.getParameter( "goodsName" ),
                        Float.parseFloat( request.getParameter( "priceOrigin" ) ),
                        Float.parseFloat(  request.getParameter( "priceSale" ) ),
                        Integer.parseInt( request.getParameter( "counter" ) ),
                        request.getParameter( "goodPicture" ),
                        request.getParameter( "storeId" )
                )
        )!=1 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", null ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", 1 ).toJSON( ) );
        System.out.println( "addGoods" );
    }

    public void removeGoods ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( goodsDao.removeGoods( request.getParameter( "goodsNumber" ) )!=1 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", null ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", 1 ).toJSON( ) );
        System.out.println( "removeGoods" );
    }

    public void modifyGoods ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( goodsDao.modifyGoods(
                new Goods(
                        request.getParameter( "goodsNumber" ),
                        request.getParameter( "goodsPictureTop" ),
                        request.getParameter( "classificationId" ),
                        request.getParameter( "goodsName" ),
                        Float.parseFloat( request.getParameter( "priceOrigin" ) ),
                        Float.parseFloat(  request.getParameter( "priceSale" ) ),
                        Integer.parseInt( request.getParameter( "counter" ) ),
                        request.getParameter( "goodPicture" ),
                        request.getParameter( "storeId" )
                ),
                request.getParameter( "goodsNumber" )
        )!=1 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", null ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", 1 ).toJSON( ) );
        System.out.println( "modifyGoods" );
    }
}
