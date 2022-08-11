package com.example.demo.proxy2.staticProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sunxian
 * @version 2022-08-05 9:41
 * 房东
 */
@Slf4j
public class LandLord implements Rent {
    @Override
    public void rent() {
        log.info("出租");
    }
}
