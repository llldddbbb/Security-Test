package com.ldb.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Component;

/**
 * @author Bobbi
 * @date 2017/11/14
 * 缺点：无法拿到原始request，response
 */
//@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* com.ldb.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");
        Object[] args=pjp.getArgs();
        long start=System.currentTimeMillis();
        for (Object arg : args) {
            System.out.println("arg is "+arg);
        }
        Object object=pjp.proceed();
        System.out.println("time aspect 耗时："+(System.currentTimeMillis()-start));
        System.out.println("time aspect end");
        return object;
    }
}
