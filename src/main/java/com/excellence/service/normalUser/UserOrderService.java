package com.excellence.service.normalUser;

import com.excellence.dao.OrderListDao;
import com.excellence.dao.impl.OrderListDaoImpl;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author acmaker & Kaffu chino
 * @version 1.0.0
 * @ClassName UserOrderServlet.java
 * @PackageLoaction com.excellence.service.normalUser
 * @createTime 2020-06-10 14:34:00 星期三
 * @Description TODO
 */
public class UserOrderService {
    OrderListDao orderListDao =  new OrderListDaoImpl();
    public void findBy_orderId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        orderListDao.findBy_orderId(request.getParameter("orderId" ),
                                Integer.parseInt( request.getParameter( "currentPage" ) ),
                                Integer.parseInt( request.getParameter( "pageSize" ) ))
                ).toJSON( )
        );
    }
    public void count_findBy_orderId(HttpServletRequest request,HttpServletResponse response)throws IOException{
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        orderListDao.count_findBy_orderId(request.getParameter("orderId"))
                ).toJSON()
        );
    }
    public void findBy_userName (HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        orderListDao.findBy_orderId(request.getParameter("userName" ),
                                Integer.parseInt( request.getParameter( "currentPage" ) ),
                                Integer.parseInt( request.getParameter( "pageSize" ) ))
                ).toJSON( )
        );
    };
    public void count_findBy_userName ( HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        orderListDao.count_findBy_orderId(request.getParameter("userName"))
                ).toJSON()
        );
    };
}
