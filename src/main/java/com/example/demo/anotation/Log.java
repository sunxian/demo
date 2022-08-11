package com.example.demo.anotation;

import java.lang.annotation.*;

/**
 * @author sunxian
 * @version 2022-06-01 13:41
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    int value() default 0;
}
