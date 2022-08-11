package com.example.demo.patternDesign.builder;

import cn.hutool.core.date.DateUtil;

/**
 * @author sunxian
 * @version 2022-06-27 13:39
 */
public interface Builder {
   public  void reset();
   public void setSeats(Integer seats);
   public  void setEngine(Engine engine);
   public  void setGPS(String gps);

}
