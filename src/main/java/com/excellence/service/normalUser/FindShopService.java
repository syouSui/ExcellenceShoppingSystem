package com.excellence.service.normalUser;

import com.excellence.dao.StoreDao;
import com.excellence.dao.impl.StoreDaoImpl;
import com.excellence.model.Store;
import com.excellence.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName FindShopService.java
 * @PackageLoaction com.excellence.service.normalUser
 * @createTime 2020-06-10 14:27:00 星期三
 * @Description TODO
 */
public class FindShopService {
    static StoreDao storeDao = new StoreDaoImpl();


}
