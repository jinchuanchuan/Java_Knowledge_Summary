package com.jcc.design.behavioral.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomeThing() {
        strategy.execute();
    }
}
