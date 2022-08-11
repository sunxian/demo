package com.example.demo.proxy.tencent.cglib;

import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * @author sunxian
 * @version 2022-06-24 17:32
 */
public class CglibTest {


    @Test
    public  void testCglibProxy() {
        //设置cglib生成的代理类输出到本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\\\classes");

        ProxyCglibFactory proxyCglibFactory = new ProxyCglibFactory();
        //生成代理对象
        ThirdPartyTVCglibClass proxyInstance = (ThirdPartyTVCglibClass) proxyCglibFactory.getProxyInstance();
        proxyInstance.getVideoInfo();
        proxyInstance.getVideoInfo();
        proxyInstance.getVideoInfo();
    

}


}
