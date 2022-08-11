package com.example.demo.proxy.tencent.cglib;

import com.example.demo.proxy.tencent.ThirdPartyTVClass;
import com.example.demo.proxy.tencent.ThirdPartyTVLib;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sunxian
 * @version 2022-06-24 17:25
 */
@Slf4j
public class ProxyCglibFactory implements MethodInterceptor {

    private static String videoCache;

    /**
     * 创建Enhancer实例
     * 通过setSuperclass方法来设置目标类
     * 通过setCallback 方法来设置拦截对象
     * create方法生成Target的代理类，并返回代理类的实例
     * @return
     */
    //为目标对象生成代理对象
    public Object  getProxyInstance() {
        //工具类 实例化一个增强器，也就是cglib中的一个class generator
        Enhancer en = new Enhancer();

        //设置父类(被代理类)
        en.setSuperclass(ThirdPartyTVCglibClass.class);
        //设置拦截对象 方法调用会被转发到该类的intercept()方法
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    //f1 被代理类 f2 代理类
    //而f1则是对应ThirdPartyTVCglibClass$$FastClassByCGLIB$$6700f748代理类，f2则对应ThirdPartyTVCglibClass$$EnhancerByCGLIB$$6682532b$$FastClassByCGLIB$$437adfc6代理类
    /**
     *
     * @paramr= target 代理类对象实例
     * @param   method 被代理的原始方法
     * @param objects 方法入参
     * @param methodProxy FastClass机制就是对一个类的方法建立索引，调用方法时根据方法的签名来计算索引，通过索引来直接调用相应的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        if (videoCache == null) {
         Object returnValue = methodProxy.invokeSuper(target, objects);
         //Object returnValue = methodProxy.invoke(target, objects);
            videoCache=returnValue.toString();
        }
        log.info("观看视频 {}", videoCache);
        return videoCache;
    }
}
