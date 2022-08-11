package com.example.demo.proxy.tencent.jdk;

import com.example.demo.proxy.tencent.ThirdPartyTVClass;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sunxian
 * @version 2022-06-23 17:15
 * JDK动态代理需要目标对象实现业务接口，代理类只需实现InvocationHandler接口
 * 首先实现一个InvocationHandler，方法调用会被转发到该类的invoke()方法。
 */
@Slf4j
public class TVProxyFactory {

    private static String videoCache;
    //被代理类目标对象
    private ThirdPartyTVClass target;

    public TVProxyFactory(ThirdPartyTVClass target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        /**
         * 类加载器
         * 代理需要实现的接口
         * 方法调用的实际处理者
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(videoCache==null){
                            // 执行目标对象方法
                            videoCache=method.invoke(target, args).toString();
                        }
                        log.info("观看视频 {}", videoCache);
                        return videoCache;
                    }
                });
    }
}
