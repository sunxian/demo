package com.example.demo.patternDesign.prototype;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

/**
 * @author sunxian
 * @version 2022-06-27 16:08
 */
@Slf4j
public class PrototypePatternDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }

    @Test
    public  void  t1() throws CloneNotSupportedException {

        Circle circle = new Circle();
        circle.setId("ss");
        Circle clone = (Circle)circle.clone();
        clone.setId("2");
        log.info(circle.toString());
        log.info(clone.toString());

    }

    @Test
    public  void  t2() throws CloneNotSupportedException {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Man man = new Man("s","s","s",new Date());
        }
        long end = System.currentTimeMillis();
        log.info(end-start+"");

        Man circle = new Man("s","s","s",new Date());
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Man clone = (Man)circle.clone();
        }
        long e1 = System.currentTimeMillis();
        log.info(e1-s1+"");

    }
}
