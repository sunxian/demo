//package com.example.demo.patternDesign.builder;
//
//import lombok.Data;
//
///**
// * @author sunxian
// * @version 2022-06-27 13:32
// */
//@Data
//public class SportsCarBuilder implements Builder{
//
//
//   private Car car;
//
//
//   @Override
//   public void reset() {
//      car=new Car();
//   }
//
//   @Override
//   public void setSeats() {
//      car.setSeats(4);
//   }
//
//   @Override
//   public void setEngine() {
//      car.setEngine(new Engine("8缸"));
//   }
//
//   @Override
//   public void setGPS() {
//      car.setGps("gps");
//   }
//
//   public Car getResult(){
//      car=new Car();
//      setSeats();
//      setEngine();
//      setGPS();
//      return car;
//   }
//}
