package com.tsalapova.bicyclerental.filter;

import com.tsalapova.bicyclerental.util.PageConstant;
import com.tsalapova.bicyclerental.util.SessionConstant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/2/2018
 * Class prevents direct access of jsp pages from browser
 */
@WebFilter(urlPatterns = {"/jsp/*"}, initParams = {@WebInitParam(name = "MAIN", value = PageConstant.MAIN)})
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
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute(SessionConstant.ROLE);
        if (role == null && (PageConstant.LOGIN.equals(requestURI) || PageConstant.REGISTER.equals(requestURI)) ||
                SessionConstant.ROLE_NAME.ADMINISTRATOR.name().toLowerCase().equals(role) && PageConstant.ADMIN.equals(requestURI)) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + mainPage);
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
