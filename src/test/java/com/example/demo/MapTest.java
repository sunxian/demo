package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author sunxian
 * @Date 2022/4/23 16:05
 */
public class MapTest {

    @Test
    void skipMap(){
        ConcurrentSkipListMap<Object, Object> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put("1","sun");
        skipListMap.put("2","sisi");
        ConcurrentNavigableMap<Object, Object> m = skipListMap.headMap("2");
    }
}
