package com.jcc.design.behavioral.strategy;

public enum LevelTypeEnum {
    SHOPPER(1, "店长"),
    MANAGER(2,"经理")
    ;

    private int level;
    private String desc;


    LevelTypeEnum(int level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
