package com.tsalapova.bicyclerental.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/2/2018
 */
@WebFilter(urlPatterns = {"/jsp/*"}, initParams = {@WebInitParam(name = "MAIN", value = "/index.jsp")})
public class JspAccessFilter implements Filter {
    private String mainPage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        mainPage = filterConfig.getInitParameter("MAIN");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.sendRedirect(request.getContextPath() + mainPage);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
