package com.example.demo.patternDesign.builder;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author sunxian
 * @version 2022-06-27 13:48
 */
@Slf4j
public class BuilderTest {

    @Test
    public  void testBuild(){

        CarBuilder carBuilder = new CarBuilder();
        CarDirector carDirector = new CarDirector();
       // Car sportsCar = carDirector.createSportsCar();
        Car normal = carDirector.createNormal(carBuilder);
        log.info(normal.toString());

        Car paoche = carDirector.createPaoche(carBuilder);
        log.info(paoche.toString());


        CarBuilder carBuilder1 = new CarBuilder();
        carBuilder1.reset();
        carBuilder1.setSeats(2);
        carBuilder1.setEngine(new Engine("3缸"));
        Car result = carBuilder1.getResult();
        log.info(result.toString());
//        Car normalCar = carDirector.createNormal();
//        log.info(normalCar.toString());

    }
}
