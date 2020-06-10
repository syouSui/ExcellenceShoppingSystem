package com.excellence.service.superAdministrator;

import com.excellence.dao.OrderListDao;
import com.excellence.dao.impl.OrderListDaoImpl;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author acmaker & Kafffu chino
 * @version 1.0.0
 * @ClassName AdministratorOrderService.java
 * @PackageLoaction com.excellence.service.superAdministrator
 * @createTime 2020-06-10 14:35:00 星期三
 * @Description TODO
 */
public class AdministratorOrderService {
    OrderListDao orderListDao =  new OrderListDaoImpl();
    public void findAll(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        orderListDao.findAll(
                                Integer.parseInt( request.getParameter( "currentPage" ) ),
                                Integer.parseInt( request.getParameter( "pageSize" ) )
                        )
                ).toJSON( )
        );
    }
    public void count_findAll(HttpServletRequest request,HttpServletResponse response)throws IOException{
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        orderListDao.count_findAll()
                        )
                .toJSON()
        );
    }
}
