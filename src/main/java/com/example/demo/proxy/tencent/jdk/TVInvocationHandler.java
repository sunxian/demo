package com.example.demo.proxy.tencent.jdk;

import com.example.demo.proxy.tencent.ThirdPartyTVClass;
import com.example.demo.proxy.tencent.cglib.ThirdPartyTVCglibClass;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunxian
 * @version 2022-06-25 10:41
 */
@Slf4j
public class TVInvocationHandler implements InvocationHandler {

    private static String videoCache;

    private ThirdPartyTVClass target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(target==null){
            target=new ThirdPartyTVClass();
        }

        if (videoCache == null) {
            // 执行目标对象方法
            videoCache = method.invoke(target, args).toString();
        }
        log.info("观看视频 {}", videoCache);
        return videoCache;

    }
}
