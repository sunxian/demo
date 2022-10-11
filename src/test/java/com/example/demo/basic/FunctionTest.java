package com.example.demo.basic;

import com.example.demo.functionInterFace.SayHello;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author sunxian
 * @version 2022-09-13 10:04
 */
public class FunctionTest {
    public static void main(String[] args) {

        int[] i =new int[]{1,2,3};
        Stream.of(1,2,3,4).forEach(System.out::println);
        SayHello sayHello = () -> System.out.println("hello world!");
        sayHello.sayhello();
    }
}
