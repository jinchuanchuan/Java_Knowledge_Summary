package com.jcc.mybatis.dto;

/**
 * @program: javaknowledge->User_Role
 * @description: 用户角色关联关系
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-08 20:59
 **/
public class User_Role {
    private User user;
    private Role role;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
