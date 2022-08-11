package com.example.demo.patternDesign.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sunxian
 * @version 2022-06-29 10:19
 */
@Slf4j
public class RedShapeDecorator extends ShapeDecorator{

   public RedShapeDecorator(Shape decoratedShape) {
      super(decoratedShape);
   }

   @Override
   public void draw() {
      super.draw();
      setRedBorder();
   }

   private void setRedBorder(){
      log.info("Border Color: Red");
   }
}
