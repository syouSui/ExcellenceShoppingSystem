package com.excellence.service.shopAdministrator;

import com.excellence.dao.OrderListDao;
import com.excellence.dao.impl.OrderListDaoImpl;
import com.excellence.model.OrderList;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author acmaker & Kaffu chino
 * @version 1.0.0
 * @ClassName ShopOrderService.java
 * @PackageLoaction com.excellence.service.shopAdministrator
 * @createTime 2020-06-10 14:34:00 星期三
 * @Description TODO
 */
public class ShopOrderService {
    OrderListDao orderListDao = new OrderListDaoImpl( );
    public void findBy_storeId ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        orderListDao.findBy_storeId(
                                request.getParameter( "storeId" ),
                                Integer.parseInt( request.getParameter( "currentPage" ) ),
                                Integer.parseInt( request.getParameter( "pageSize" ) )
                        )
                ).toJSON( )
        );
    }
    public void count_findBy_storeId ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        orderListDao.count_findBy_storeId( request.getParameter( "storeId" ) )
                ).toJSON( )
        );
    }

    public void remove ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        OrderList orderList = new OrderList(
                request.getParameter( "orderId" ),
                request.getParameter( "userName" ),
                request.getParameter( "goodsNumber" ),
                0,
                null,
                null,
                null,
                0,
                null
        );
        orderList.setOrderDate( request.getParameter( "orderDate" ) );
        if ( orderListDao.remove( orderList ) != 1 ) {
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
