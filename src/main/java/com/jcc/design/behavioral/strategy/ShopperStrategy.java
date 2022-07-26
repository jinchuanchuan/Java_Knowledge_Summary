package com.jcc.design.behavioral.strategy;

public class ShopperStrategy implements Strategy{
    @Override
    public void execute() {
        System.out.println("执行店长的审批流程!");
    }
}
