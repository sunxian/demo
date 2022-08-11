package com.example.demo.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunxian
 * @version 2022-06-29 10:48
 */
@Slf4j
public class ListTest {



    @Test
    void t1(){
        List<String> values = new ArrayList<>();
        values.add("a");
        values.add("b");
        String firstValue = values.get(0);

        List<String> values2 = new LinkedList<>();
        values.add("a");
        values.add("b");
        String firstValue2 = values.get(0);
                log.info(firstValue);
                log.info(firstValue2);
    }
}
