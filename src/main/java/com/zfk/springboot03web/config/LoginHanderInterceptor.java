package com.zfk.springboot03web.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHanderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功 应该有用户的session

        Object loginuser=request.getSession().getAttribute("loginUser");
        if(loginuser==null){//没有登陆
            request.setAttribute("msg","没有权限，请先登录");
            System.out.println("没有权限，请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
            return true;
        }

    }


}
