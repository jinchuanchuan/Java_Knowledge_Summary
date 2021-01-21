package com.jcc.mybatis.charter05.mapper;

import com.jcc.mybatis.dto.User;

public interface UserMapper {
    //根据 id 查询 user 表数据
    public User selectUserById(int id) throws Exception;

    //向 user 表插入一条数据
    public void insertUser(User user) throws Exception;

    //根据 id 修改 user 表数据
    public void updateUserById(User user) throws Exception;

    //根据 id 删除 user 表数据
    public void deleteUserById(int id) throws Exception;
}
