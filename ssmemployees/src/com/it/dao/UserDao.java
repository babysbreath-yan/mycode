package com.it.dao;

import com.it.util.Pages;
import com.it.util.Users;

import java.util.List;

public interface UserDao {
    //用户登录
    public Users login(Users users);
    //用户注册
    public int  register(Users users);
    //查询所有用户
    public List<Users>  queryUsersAll();
    //查询所有用户
    public List<Users>  queryUsersPage(Pages pages);
    //根据id删除用户
    public int deleteUsers(int userId);
    //根据用户名模糊查询
    public List<Users> likeQuery(String userName);
    public  int addUsers(Users users);
    //根据鲜花名模糊查询
    public List<Users> likeQueryUser(String usersName);

    List<Pages> queryUsersAllPage(Pages pages);
}