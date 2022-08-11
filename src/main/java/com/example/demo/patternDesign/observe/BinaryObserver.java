package com.example.demo.patternDesign.observe;

/**
 * @author sunxian
 * @version 2022-06-29 16:50
 */
public class BinaryObserver extends Observer{
   public BinaryObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println( "Binary String: "
              + Integer.toBinaryString( subject.getState() ) );
   }
}
