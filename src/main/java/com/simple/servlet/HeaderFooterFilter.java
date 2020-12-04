package com.simple.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class HeaderFooterFilter implements Filter {

    private transient FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterConfig.getServletContext().
                getRequestDispatcher("/header.html").
                include(servletRequest, servletResponse);
        filterConfig.getServletContext().
                getRequestDispatcher("/footer.html").
                include(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
