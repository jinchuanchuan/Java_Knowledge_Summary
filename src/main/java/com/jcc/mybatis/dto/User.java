package com.jcc.mybatis.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: javaknowledge->User
 * @description: user
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-08 15:51
 **/
public class User implements Serializable {
    private static final long serialVersionUID = -6117583318163279735L;

    private int id;

    private String username;

    private String sex;

    private Date birthday;

    private String address;

    private Date createtime;

    private Date updatetime;

    //一个用户能创建多个订单，用户和订单构成一对多的关系
    public List<Orders> orders;

    public List<Role> roles;

    public List<Orders> getOrders() {
        return orders;
    }
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", orders=" + orders +
                ", roles=" + roles +
                '}';
    }
}
