package com.jcc.mybatis.charter01;

import com.jcc.mybatis.dto.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaknowledge->CRUDDao
 * @description: curd
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-08 14:11
 * boke：https://www.cnblogs.com/ysocean/p/7287972.html
 **/
public class CRUDDao {
    //MySQL数据库驱动
    public static String driverClass = "com.mysql.jdbc.Driver";
    //MySQL用户名
    public static String userName = "root";
    //MySQL密码
    public static String passWord = "jia5211215";
    //MySQL URL
    public static String url = "jdbc:mysql://localhost:3306/test";
    //定义数据库连接
    public static Connection conn = null;
    //定义声明数据库语句,使用 预编译声明 PreparedStatement提高数据库执行性能
    public static PreparedStatement ps = null;
    //定义返回结果集
    public static ResultSet rs = null;
    /**
     * 查询 person 表信息
     * @return：返回 person 的 list 集合
     */
    public static List<Person> readPerson(){
        List<Person> list = new ArrayList<>();
        try {
            //加载数据库驱动
            Class.forName(driverClass);
            //获取数据库连接
            conn = DriverManager.getConnection(url, userName, passWord);
            //定义 sql 语句,?表示占位符
            String sql = "select * from person where pname=?";
            //获取预编译处理的statement
            ps = conn.prepareStatement(sql);
            //设置sql语句中的参数，第一个为sql语句中的参数的?(从1开始)，第二个为设置的参数值
            ps.setString(1, "qzy");
            //向数据库发出 sql 语句查询，并返回结果集
            rs = ps.executeQuery();
            while (rs.next()) {
                Person p = new Person();
                p.setPid(rs.getLong(1));
                p.setPname(rs.getString(2));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //关闭数据库连接
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(CRUDDao.readPerson());
    }
}
