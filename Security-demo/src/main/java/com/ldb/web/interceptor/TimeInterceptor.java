package com.ldb.web.interceptor;

import com.sun.xml.internal.ws.resources.HandlerMessages;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Bobbi
 * @date 2017/11/14
 * 拦截器类
 */
@Component

public class TimeInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("preHandle");
//      获取Bean类型和方法名
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());

        httpServletRequest.setAttribute("startTime",System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        long start=(Long)httpServletRequest.getAttribute("startTime");
        System.out.println("timeInterceptor 耗时："+(System.currentTimeMillis()-start));
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
        long start=(Long)httpServletRequest.getAttribute("startTime");
        System.out.println("timeInterceptor 耗时："+(System.currentTimeMillis()-start));
        System.out.println("exception is"+e);
    }
}
