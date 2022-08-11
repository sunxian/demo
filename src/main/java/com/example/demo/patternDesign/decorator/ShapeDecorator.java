package com.example.demo.patternDesign.decorator;

/**
 * @author sunxian
 * @version 2022-06-29 10:17
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
