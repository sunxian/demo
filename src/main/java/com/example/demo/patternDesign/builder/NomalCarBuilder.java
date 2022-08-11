//package com.example.demo.patternDesign.builder;
//
//import lombok.Data;
//
///**
// * @author sunxian
// * @version 2022-06-27 13:32
// */
//@Data
//public class NomalCarBuilder implements Builder{
//
//
//   private Car car;
//
//
//    @Override
//    public void reset() {
//        car=new Car();
//    }
//
//    @Override
//   public void setSeats(String i) {
//
//      car.setSeats(4);
//   }
//
//   @Override
//   public void setEngine() {
//
//      car.setEngine(new Engine("4缸"));
//   }
//
//    @Override
//    public void setGPS() {
//
//    }
//
//    public Car getResult(){
//        reset();
//        setSeats();
//        setEngine();
//        return car;
//    }
//}
