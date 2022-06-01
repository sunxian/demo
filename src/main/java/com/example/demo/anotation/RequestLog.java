package com.example.demo.anotation;

import java.lang.annotation.*;

/**
 * @author sunxian
 * @version 2022-06-01 13:41
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestLog {

    int value() default 0;
}
