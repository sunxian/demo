package com.example.demo.patternDesign.prototype;

/**
 * @author sunxian
 * @version 2022-06-27 16:01
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
