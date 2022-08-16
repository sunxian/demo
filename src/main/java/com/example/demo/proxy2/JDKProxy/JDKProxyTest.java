package com.example.demo.proxy2.JDKProxy;

import com.example.demo.proxy.tencent.ThirdPartyTVClass;
import com.example.demo.proxy.tencent.jdk.TVInvocationHandler;
import com.example.demo.proxy2.staticProxy.LandLord;
import com.example.demo.proxy2.staticProxy.Rent;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sunxian
 * @version 2022-08-05 10:05
 */
public class JDKProxyTest {
    public static void main(String[] args) {


        Rent o1 = (Rent)Proxy.newProxyInstance(LandLord.class.getClassLoader(), LandLord.class.getInterfaces(), new RentInvocationHandler());
        o1.rent();

    }

    @Test
    public void testProxy(){
       com.example.demo.proxy2.JDKProxy.ProxyO proxyO = new ProxyO(ThirdPartyTVClass.class.getClassLoader(), ThirdPartyTVClass.class.getInterfaces(), new RentInvocationHandler());
       proxyO.rent();
    }


}
