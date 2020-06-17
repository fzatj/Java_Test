package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author TianJun
 * @date 2020/5/20
 */
@WebFilter(filterName = "FilterTest")
public class FilterTest implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request =  (HttpServletRequest)  req;
        //获取 servletpath
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        String path = null;
        //判断servletPath ，若琪等于"/input.action",则转发到 input.jsp
        if ("/input.action".equals(servletPath)){
             path = "/WEB-INF/page/input.jsp";

        }
        if ("/login.jsp".equals(servletPath)){

            path = "/WEB-INF/page/login.jsp";
        }

        if (path != null){
            request.getRequestDispatcher(path).forward(req,resp);
            return;
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
