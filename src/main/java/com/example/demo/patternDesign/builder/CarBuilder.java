package com.example.demo.patternDesign.builder;

/**
 * @author sunxian
 * @version 2022-06-27 14:51
 */
public class CarBuilder implements Builder{

    private Car car;


    @Override
    public void reset() {
        car=new Car();
    }

    @Override
    public void setSeats(Integer num) {

        car.setSeats(num);
    }

    @Override
    public void setEngine(Engine engine) {

        car.setEngine(engine);
    }


    @Override
    public void setGPS(String a) {
        car.setGps(a);
    }

    public Car getResult(){

        return car;
    }
}
