package com.excellence.filter;

import com.excellence.util.ResultVo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @PackageLoaction ${PACKAGE_NAME}
 * @createTime 2020-06-10 14:43:00 星期三
 * @Description TODO
 */
@WebFilter ( filterName = "SuperAdministratorFilter" ,servletNames = {
        "AdministratorOrderServlet",
        "AdministratorStoreServlet",
        "SuperAdministratorServlet"
})
public class SuperAdministratorFilter implements Filter {
    public void destroy ( ) {
    }

    public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)req).getSession();
        if(session.getAttribute("role") == null && (Integer.parseInt((String) session.getAttribute("role")) < 1)) {
            resp.getWriter().println(
                    new ResultVo(
                            ResultVo.CODE_AUTH_FAIL,
                            "forbidden",
                            null
                    ).toJSON()
            );
            return;
        }
        chain.doFilter( req, resp );
    }

    public void init ( FilterConfig config ) throws ServletException {

    }

}
