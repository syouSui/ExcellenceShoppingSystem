package com.excellence.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @PackageLoaction ${PACKAGE_NAME}
 * @createTime 2020-06-10 14:43:00 星期三
 * @Description TODO
 */
@WebFilter ( filterName = "ShopAdministratorFilter" )
public class ShopAdministratorFilter implements Filter {
    public void destroy ( ) {
    }

    public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
        chain.doFilter( req, resp );
    }

    public void init ( FilterConfig config ) throws ServletException {

    }

}
