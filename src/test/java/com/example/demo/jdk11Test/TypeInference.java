package com.example.demo.jdk11Test;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author sunxian
 * @version 2022-08-29 16:48
 */
public class TypeInference {

    @Test
    public void t1(){
        //局部变量类型推断
        var cities = List.of("Brussels", "Cardiff", "Cambridge");
        cities.forEach(i->System.out.println(i));
        List<Object> objects = Collections.emptyList();

        //java8
        Predicate<String> nameValidation = x -> x.length() > 0;
    }
}
