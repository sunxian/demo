package com.example.demo.proxy.tencent.jdk;

import com.example.demo.proxy.tencent.ThirdPartyTVLib;
import com.example.demo.proxy.tencent.cglib.ThirdPartyTVCglibClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunxian
 * @version 2022-08-05 14:17
 */
public class ProxyO implements ThirdPartyTVLib {

    private ClassLoader loader;
    private Class<?>[] interfaces;
    private  InvocationHandler h;


    public ProxyO(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
        this.loader = loader;
        this.interfaces = interfaces;
        this.h = h;
    }



    @Override
    public String getVideoInfo() {
        try {
            return (String) h.invoke(this, ThirdPartyTVLib.class.getMethod("getVideoInfo"), null);

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return "ssss";
    }
}
