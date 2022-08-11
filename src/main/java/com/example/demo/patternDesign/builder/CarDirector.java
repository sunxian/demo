package com.example.demo.patternDesign.builder;

/**
 * @author sunxian
 * @version 2022-06-27 13:45
 */
public class CarDirector {

     //private  Builder builder;

//    public Car createNormal(){
//        NomalCarBuilder nomalCarBuilder = new NomalCarBuilder();
//        return  nomalCarBuilder.getResult();
//    }
//
//    public Car createSportsCar(){
//        SportsCarBuilder sportsCarBuilder = new SportsCarBuilder();
//        return  sportsCarBuilder.getResult();
//    }

    public Car createNormal(CarBuilder builder){
         builder.reset();
         builder.setEngine(new Engine("4缸"));
         builder.setSeats(4);

        return  builder.getResult();
    }


    public Car createPaoche(CarBuilder builder){
        builder.reset();
        builder.setEngine(new Engine("8缸"));
        builder.setSeats(2);
        builder.setGPS("gps");
        return  builder.getResult();
    }
}
