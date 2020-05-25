package com.excellence.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter ( "/*" )
public class CORSFilter implements Filter {
    public void destroy ( ) {
    }

    public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String origin = request.getHeader("Origin");
//        //response.addHeader("Access-Control-Allow-Origin","http://acmaker.vip:8080");
        response.setHeader("Access-Control-Allow-Origin",origin);
        response.setHeader("Access-Control-Allow-Credentials","true");
        chain.doFilter( req, resp );
    }

    public void init ( FilterConfig config ) throws ServletException {

    }

}
