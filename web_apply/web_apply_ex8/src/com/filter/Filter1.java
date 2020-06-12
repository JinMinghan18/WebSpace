package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FilterOne",urlPatterns = {"/admin/*"},dispatcherTypes = DispatcherType.FORWARD)
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        System.out.println("这里是过滤器FilterOne");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
