package com.excellence.service.shopAdministrator;

import com.excellence.dao.StoreDao;
import com.excellence.dao.impl.StoreDaoImpl;
import com.excellence.model.Store;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author acmaker & kaffu chino
 * @version 1.0.0
 * @ClassName AddStop.java
 * @PackageLoaction com.excellence.service.shopAdministrator
 * @createTime 2020-06-10 14:27:00 星期三
 * @Description TODO
 */
public class EditShopService {
    StoreDao storeDao = new StoreDaoImpl( );
    public void modifyStore ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( storeDao.modifyStore(
                request.getParameter( "storeId" ),
                new Store(
                        null,
                        request.getParameter( "storeName" ),
                        request.getParameter( "storePicture" ),
                        request.getParameter( "storeDescription" ),
                        request.getParameter( "userName" )
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
}
