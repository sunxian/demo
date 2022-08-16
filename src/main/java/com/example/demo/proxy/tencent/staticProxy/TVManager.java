package com.example.demo.proxy.tencent.staticProxy;

import com.example.demo.proxy.tencent.ThirdPartyTVClass;
import com.example.demo.proxy.tencent.staticProxy.CachedTVClass;

/**
 * @author sunxian
 * @version 2022-06-23 16:15
 */
public class TVManager {
  //代理服务
  static CachedTVClass cachedTVClass = new CachedTVClass();

   public static void main(String[] args) throws InterruptedException {

      cachedTVClass.getVideoInfo();
      cachedTVClass.getVideoInfo();
      cachedTVClass.getVideoInfo();
      cachedTVClass.getVideoInfo();
      cachedTVClass.getVideoInfo();
   }
}
