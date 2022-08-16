package com.example.demo.proxy2.JDKProxy;

import com.example.demo.proxy.tencent.ThirdPartyTVLib;
import com.example.demo.proxy2.staticProxy.Rent;

import java.lang.reflect.InvocationHandler;

/**
 * @author sunxian
 * @version 2022-08-05 14:17
 */
public class ProxyO implements Rent {

    private ClassLoader loader;
    private Class<?>[] interfaces;
    private  InvocationHandler h;


    public ProxyO(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
        this.loader = loader;
        this.interfaces = interfaces;
        this.h = h;
    }



    @Override
    public void rent() {

        try {
            h.invoke(this, Rent.class.getMethod("rent"), null);
        } catch (Throwable e) {
            e.printStackTrace();
        }


    }


}
