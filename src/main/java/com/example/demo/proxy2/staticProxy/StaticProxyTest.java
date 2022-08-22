package com.example.demo.proxy2.staticProxy;

import org.junit.Test;

/**
 * @author sunxian
 * @version 2022-08-05 9:48
 */
public class StaticProxyTest {

   public static void main(String[] args) {


      Agency agency = new Agency();
      agency.rent();

   }

   @Test
   public void t1() {
      LandLord landLord = new LandLord();
      landLord.rent();

   }
}
