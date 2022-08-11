package com.example.demo.patternDesign.state;

/**
 * @author sunxian
 * @version 2022-08-09 10:57
 */
public class NoQuarterState extends State {

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你投入了一个硬币");
        //转换为有硬币状态
        gumballMachine.setState(gumballMachine.hasQuarterState);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("没有硬币，无法弹出");
    }

    @Override
    public void turnCrank() {
        System.out.println("请先投币");
    }

    @Override
    public void dispense() {
        System.out.println("没有投币，无法发放糖果");
    }
}