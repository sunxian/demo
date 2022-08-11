package com.example.demo.patternDesign.prototype;

/**
 * @author sunxian
 * @version 2022-06-27 16:02
 */
public class Square extends Shape{
    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
