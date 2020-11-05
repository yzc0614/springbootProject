package com.chinasoft.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceper implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");

        if(user==null){
            request.setAttribute("msg","无权限访问 请先登录");
            request.getRequestDispatcher("/user/").forward(request,response);
            return false;
        }
        return true;
    }
}
