package com.example.demo.proxy;

/**
 * @author sunxian
 * @version 2022-06-23 15:26
 */
public class RealImage implements Image{
   private String fileName;

   public RealImage(String fileName){
      this.fileName = fileName;
      loadFromDisk(fileName);
   }


   @Override
   public void display() {
      System.out.println("Displaying " + fileName);
   }

   private void loadFromDisk(String fileName){
      System.out.println("Loading " + fileName);
   }
}
