package com.example.demo.proxy2.staticProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sunxian
 * @version 2022-08-05 9:43
 * 中介
 */
@Slf4j
public class Agency implements Rent {

    private LandLord landLord;

    @Override
    public void rent() {

        log.info("带看");
        this.landLord=new LandLord();
        landLord.rent();
        log.info("收费");
    }
}
