package com.example.demo.proxy.tencent.cglib;

import com.example.demo.proxy.tencent.ThirdPartyTVClass;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sunxian
 * @version 2022-06-24 17:22
 */
@Slf4j
public  class ThirdPartyTVCglibClass {

   public String  getVideoInfo() {

      String video ="";
      try (BufferedReader br =
                   new BufferedReader(new FileReader("D:\\code\\demo\\demo\\src\\main\\java\\com\\example\\demo\\proxy\\tencent\\video.txt"))) {
         video=br.readLine();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      log.info("从视频服务器获取到视频 {}",video);
      return video;
   }

   public ThirdPartyTVCglibClass() {

      try {
         log.info("初始化***********");
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
