package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author sunxian
 * @version 2022-05-06 16:14
 */
@Slf4j
public class ListTest {

    @Test
    void sysss(){
        List<Long> objects = new ArrayList<>();
        List<Long> objects1 = new ArrayList<>();
        objects.add(1L);
       objects1.add(3L);
       objects1.add(4L);
        objects1.removeAll(objects);
        objects1.addAll(objects);
        log.info("ssss");
        objects1.forEach(i->log.info(i+""));


    }
}
