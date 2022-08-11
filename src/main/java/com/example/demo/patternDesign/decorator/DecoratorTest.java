package com.example.demo.patternDesign.decorator;

import org.junit.Test;

/**
 * @author sunxian
 * @version 2022-06-29 10:18
 */

/**
 * draw 方法的增加 draw既可以画方也可以画圆
 */
public class DecoratorTest {
    @Test
    public  void t1(){
        Rectangle rectangle = new Rectangle();
        RedShapeDecorator redShapeDecorator = new RedShapeDecorator(rectangle);
        redShapeDecorator.draw();
        Circle circle = new Circle();
        redShapeDecorator = new RedShapeDecorator(circle);
        redShapeDecorator.draw();
    }
}
