package com.jcc.mybatis.dto;

/**
 * @program: javaknowledge->Person
 * @description: person
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-08 14:12
 **/
public class Person {

    private Long pid;

    private String pname;

    public Long getPid() {
        return pid;
    }
    public void setPid(Long pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
