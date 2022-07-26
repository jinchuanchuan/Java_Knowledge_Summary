package com.jcc.design.behavioral.strategy;

public class ManagerStrategy implements Strategy{
    @Override
    public void execute() {
        System.out.println("执行经理的审批流程");
    }
}
