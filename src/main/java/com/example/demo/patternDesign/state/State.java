package com.example.demo.patternDesign.state;

/**
 * @author sunxian
 * @version 2022-08-09 10:56
 */
public abstract class State {

    /**
     * 投币
     */
    public abstract void insertQuarter();

    /**
     * 退币
     */
    public abstract void ejectQuarter();

    /**
     * 转动出糖曲轴
     */
    public abstract void turnCrank();

    /**
     * 发糖
     */
    public abstract void dispense();

    /**
     * 退还硬币
     */
    protected void returnQuarter() {
        System.out.println("退币……");
    }
}
