package com.example.demo.patternDesign.prototype;

/**
 * @author sunxian
 * @version 2022-06-27 16:06
 */
public class Circle extends Shape{

   public Circle(){
      type = "Circle";
   }

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }

   @Override
   public String toString() {
      return super.toString();
   }
}
