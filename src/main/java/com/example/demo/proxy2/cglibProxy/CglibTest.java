package com.example.demo.proxy2.cglibProxy;

import com.example.demo.proxy.tencent.cglib.ProxyCglibFactory;
import com.example.demo.proxy.tencent.cglib.ThirdPartyTVCglibClass;
import com.example.demo.proxy2.staticProxy.LandLord;
import com.example.demo.proxy2.staticProxy.Rent;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author sunxian
 * @version 2022-08-15 9:23
 */
public class CglibTest {

   @Test
   public  void testCglibProxy() {

      //设置cglib生成的代理类输出到本地
      System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\\\classes");
      Enhancer en = new Enhancer();
      //设置父类(被代理类)
      en.setSuperclass(LandLord.class);
      //设置拦截对象 方法调用会被转发到该类的intercept()方法
      en.setCallback(new RentMethodInterceptor());
      //创建子类对象代理
      Rent proxyInstance=(Rent) en.create();

      proxyInstance.rent();

   }
}
