package com.jcc.algorichms.algLiuyubo.Charter02.SelectionSort02;

/**
 * @program: javaknowledge->Student
 * @description: 学生
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-27 14:50
 **/
public class Student implements Comparable<Object> {
    private final String name;
    private final int score;

    public Student(String name, int score) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student that = (Student)o;
        if (this.score < that.score) {
            return -1;
        } else if(this.score > that.score) {
            return 1;
        } else {
            return this.name.compareTo(that.name);
        }
    }
}

