package com.example.demo.proxy.tencent.jdk;

import com.example.demo.proxy.tencent.ThirdPartyTVClass;
import com.example.demo.proxy.tencent.ThirdPartyTVLib;
import com.example.demo.proxy.tencent.jdk.TVProxyFactory;
import com.example.demo.proxy2.JDKProxy.RentInvocationHandler;
import com.example.demo.proxy2.staticProxy.LandLord;
import com.example.demo.proxy2.staticProxy.Rent;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author sunxian
 * @version 2022-06-23 17:24
 */
public class DynamicTest {

    public static void main(String[] args) {

    }

    /**
     * loader，指定代理对象的类加载器；
     * interfaces，代理对象需要实现的接口，可以同时指定多个接口；
     * handler，方法调用的实际处理者，代理对象的方法调用都会转发到这里
     * newProxyInstance()会返回一个实现了指定接口的代理对象，对该对象的所有方法调用都会转发给InvocationHandler.invoke()
     * invoke()方法里我们可以加入任何逻辑，比如修改方法参数，加入日志功能、安全检查功能等
     */
    @Test
    public void testJDKDynamicProxy(){
        //代理对象
        ThirdPartyTVLib proxyInstance = (ThirdPartyTVLib) Proxy.newProxyInstance(ThirdPartyTVClass.class.getClassLoader(), ThirdPartyTVClass.class.getInterfaces(),new TVInvocationHandler());
        proxyInstance.getVideoInfo();
        proxyInstance.getVideoInfo();
        proxyInstance.getVideoInfo();
        proxyInstance.getVideoInfo();
        proxyInstance.getVideoInfo();
    }

    @Test
    public void testJDKDynamicProxy2(){
        //代理对象
        ProxyO proxyO = new ProxyO(ThirdPartyTVClass.class.getClassLoader(), ThirdPartyTVClass.class.getInterfaces(), new TVInvocationHandler());
        proxyO.getVideoInfo();
        proxyO.getVideoInfo();
        proxyO.getVideoInfo();
        proxyO.getVideoInfo();
        proxyO.getVideoInfo();
    }


    @Test
    public void testJDKDynamicProxy1(){
        //代理对象
        Rent proxyInstance = (Rent) Proxy.newProxyInstance(LandLord.class.getClassLoader(), LandLord.class.getInterfaces(),new RentInvocationHandler());
        proxyInstance.rent();
    }


}
