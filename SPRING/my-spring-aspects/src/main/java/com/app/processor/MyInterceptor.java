package com.app.processor;

import org.aopalliance.intercept.Interceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;


public class MyInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before");

        Method method = methodInvocation.getMethod();
        Object[] args = methodInvocation.getArguments();
        if("Denis".equals(args[0])){
            return "Incorrect parameter";
        }

        Object res = methodInvocation.proceed();

        System.out.println("After");
        //return "Fake";
        return res;
    }
}
