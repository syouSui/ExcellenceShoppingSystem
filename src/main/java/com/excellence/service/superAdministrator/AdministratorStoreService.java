package com.excellence.service.superAdministrator;

import com.excellence.dao.StoreDao;
import com.excellence.dao.impl.StoreDaoImpl;
import com.excellence.model.Store;
import com.excellence.util.RandomUtil;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdministratorStoreService {
    StoreDao storeDao = new StoreDaoImpl( );

    public void removeStore ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( storeDao.removeStore( request.getParameter( "storeId" ) ) != 1 ) {
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
    public void addStore ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        if ( storeDao.addStore(
                new Store(
                        RandomUtil.getUniqueId( 15 ),
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
