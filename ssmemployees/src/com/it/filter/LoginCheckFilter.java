package com.it.filter;

import com.it.util.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter({"/olderServlet"})
//过滤器，拦截订单请求，自动转到登录页面
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)request1;
        HttpServletResponse response = (HttpServletResponse)response1;
        Users user;
        HttpSession sessionObj = request.getSession(false); // 获取当前会话中的session，如果没有则返回null

        if(sessionObj != null) {
            user = (Users) sessionObj.getAttribute("users"); // 从session中获取用户信息
            if (user == null){
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
        }else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
