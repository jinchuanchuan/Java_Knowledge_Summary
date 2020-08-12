package com.jcc.java.lambda;

/**
 * @program: javaknowledge->Apple
 * @description: apple dto
 * @author: jinchuanchuan1@le.com
 * @create: 2020-05-08 19:57
 **/
public class Apple implements Comparable {
    private String color;
    private Double weight;

    public Apple(String color, Double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
