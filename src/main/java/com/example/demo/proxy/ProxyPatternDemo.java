package com.example.demo.proxy;

/**
 * @author sunxian
 * @version 2022-06-23 15:29
 */
public class ProxyPatternDemo {

   public static void main(String[] args) {
      Image image = new ProxyImage("test_10mb.jpg");

      // 图像将从磁盘加载
      image.display();
      System.out.println("");
      // 图像不需要从磁盘加载
      image.display();
   }
}
