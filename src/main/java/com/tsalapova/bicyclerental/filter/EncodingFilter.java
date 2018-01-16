package com.tsalapova.bicyclerental.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author TsalapovaMD
 * @version 1.0, 12/30/2017
 */
@WebFilter(urlPatterns = {"/*"}, initParams = {@WebInitParam(name="encoding", value = "UTF-8")})
public class EncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) {
        encoding=filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestEncoding=servletRequest.getCharacterEncoding();
        if(encoding!=null&&!encoding.equalsIgnoreCase(requestEncoding)){
            servletRequest.setCharacterEncoding(encoding);
            servletResponse.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
