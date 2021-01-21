package com.jcc.mybatis.charter07.mapper;

import com.jcc.mybatis.dto.User;

import java.util.List;

public interface UserMapper {
    //根据 id 查询 user 表数据
    public User selectUserById(int id) throws Exception;

    //向 user 表插入一条数据
    public void insertUser(User user) throws Exception;

    //根据 id 修改 user 表数据
    public void updateUserById(User user) throws Exception;

    //根据 id 删除 user 表数据
    public void deleteUserById(int id) throws Exception;

    //根据用户id查询用户信息，以及用户下面的所有订单信息
    public User selectUserAndOrdersByUserId(int UserId);

    /**
     * 多对多关联关系
     * @param roleId
     * @return
     */
    //给定一个角色id，要得到具有这个角色的所有用户信息
    public List<User> getUserByRoleId(int roleId);
}
