package com.excellence.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter ( "/*" )
public class CORSFilter implements Filter {
    public void destroy ( ) {
    }

    public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setHeader( "Access-Control-Allow-Origin", request.getHeader( "Origin" ) );
        response.setHeader( "Access-Control-Allow-Methods", "*" );
        response.setHeader("Access-Control-Allow-Headers", "*");
//        response.setHeader( "Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH" );
//        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, token-type, Accept,Authorization");
        response.setHeader( "Access-Control-Allow-Credentials", "true" );
        response.setHeader( "Access-Control-Max-Age", "3600" );
        if ( request.getMethod( ).equalsIgnoreCase( "OPTIONS" ) ) {
            resp.getOutputStream( ).write( "Success".getBytes( StandardCharsets.UTF_8 ) );
        } else {
            chain.doFilter( (ServletRequest) request, (ServletResponse) response );
        }
    }

    public void init ( FilterConfig config ) throws ServletException {

    }

}
