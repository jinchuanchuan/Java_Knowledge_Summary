package com.jcc.mybatis.dto;

import java.util.List;

/**
 * @program: javaknowledge->Role
 * @description: 角色
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-08 20:57
 **/
public class Role {
    private int id;
    private String name;

    private List<User> users;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
