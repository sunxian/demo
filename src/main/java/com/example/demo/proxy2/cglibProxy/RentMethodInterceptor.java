package com.example.demo.proxy2.cglibProxy;

import com.example.demo.proxy2.staticProxy.LandLord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sunxian
 * @version 2022-08-05 13:19
 */
@Slf4j
public class RentMethodInterceptor implements MethodInterceptor {



    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        log.info("带看");
        Object invoke = methodProxy.invokeSuper(target, args);
        log.info("收费");
        return  invoke;
    }
}
