package com.excellence.service.normalUser;

import com.excellence.dao.OrderListDao;
import com.excellence.dao.impl.OrderListDaoImpl;
import com.excellence.model.OrderList;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    public void cancelOrder (HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<OrderList> orderLists = null;
        orderLists = orderListDao.findBy_orderId(
                request.getParameter("orderId"),
                1,
                100);
        if(orderLists != null && orderLists.get(0).getOrderStatus() == 3){
            if(orderListDao.modify_orderStatus_By_orderId(
                    request.getParameter("orderId"),
                    Integer.parseInt( request.getParameter( "orderStatus" ) )
                    ) == 1) {
                response.getWriter().println(new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        null
                ));
            }
            else {
                response.getWriter().println(new ResultVo(
                        ResultVo.CODE_FAILED,
                        "failed",
                        null
                ));
            }
        }
        else{//订单不存在或已付款
            response.getWriter().println(new ResultVo(
                    ResultVo.CODE_FAILED,
                    "failed",
                    null
            ));
        }
    }
}
