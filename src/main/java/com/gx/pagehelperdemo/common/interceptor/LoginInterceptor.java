package com.gx.pagehelperdemo.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义登录拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("------LoginInterceptor into-------");
        String uri = request.getRequestURI();
        if(uri.contains("login")){
            return true;
        }
        Object object = request.getSession().getAttribute("loginName");
        if(object != null){
            return true;
        }
        System.out.println("------LoginInterceptor out-------");
        response.sendRedirect(request.getContextPath()+"/login.jsp");
        return false;
    }

}
