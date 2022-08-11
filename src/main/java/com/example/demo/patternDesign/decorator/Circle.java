package com.example.demo.patternDesign.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sunxian
 * @version 2022-06-29 10:15
 */
@Slf4j
public class Circle implements Shape{
   @Override
   public void draw() {
      log.info("Shape Circle ");
   }
}
