package com.example.demo.patternDesign.observe;

/**
 * @author sunxian
 * @version 2022-06-29 16:49
 */
public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}
