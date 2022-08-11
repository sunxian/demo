package com.example.demo.proxy2.JDKProxy;

import com.example.demo.proxy2.staticProxy.LandLord;
import com.example.demo.proxy2.staticProxy.Rent;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunxian
 * @version 2022-08-05 10:20
 */
@Slf4j
public class RentInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LandLord landLord = new LandLord();
        log.info("带看");
        Object invoke = method.invoke(landLord, args);
        log.info("收费");
        return invoke;
    }
}
