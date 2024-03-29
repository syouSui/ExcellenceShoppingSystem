package com.excellence.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter ( "/*" )
public class EncodingFilter implements Filter {
    public void destroy ( ) {
    }

    public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding( "UTF-8" );
        response.setCharacterEncoding( "UTF-8" );
//        response.setContentType( "text/html;charset=UTF-8;" );
//        chain.doFilter( req, resp );
        chain.doFilter( (ServletRequest)request, (ServletResponse)response );
    }

    public void init ( FilterConfig config ) throws ServletException {

    }

}
