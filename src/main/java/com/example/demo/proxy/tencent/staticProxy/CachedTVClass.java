package com.example.demo.proxy.tencent.staticProxy;

import com.example.demo.proxy.tencent.ThirdPartyTVClass;
import com.example.demo.proxy.tencent.ThirdPartyTVLib;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sunxian
 * @version 2022-06-23 16:00
 * 代理类 代理播放视频功能
 */
@Slf4j
public class CachedTVClass implements ThirdPartyTVLib {

    //缓存内容
    private static String videoCache;
    //被代理对象
    private ThirdPartyTVClass thirdPartyTVClass;


    @Override
    public String getVideoInfo() {

        //延迟初始化
        if (thirdPartyTVClass == null) {
            thirdPartyTVClass = new ThirdPartyTVClass();
        }
        if (videoCache == null) {
            //调用原对象
            videoCache = thirdPartyTVClass.getVideoInfo();
        }
        //附加操作
        log.info("观看视频 {}", videoCache);
        return videoCache;

    }

}
