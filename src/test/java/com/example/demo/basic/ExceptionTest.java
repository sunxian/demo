package com.example.demo.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author sunxian
 * @version 2022-07-29 15:17
 */
@Slf4j
public class ExceptionTest {

   @Test
   public void t1(){
      try {
         log.info("hello");
         process();
      } catch (Exception e) {
         log.error("发生错误");
      }

   }


   void process(){
      //try {
         int  i=7;
         int i1 = i / 0;
     // } catch (Exception e) {
       //  log.error("error.....");
     // }

   }
}
