package com.jcc.design.behavioral.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        getShenPiLiu(1);
        getShenPiLiu(2);

    }

    public static void getShenPiLiu(int level) {
        Context context = null;
        if (level == LevelTypeEnum.SHOPPER.getLevel()) {
            context = new Context(new ShopperStrategy());
        } else if (level == LevelTypeEnum.MANAGER.getLevel()) {
            context = new Context(new ManagerStrategy());
        }
        context.doSomeThing();
    }
}
