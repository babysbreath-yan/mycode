package com.it.servers;

import com.it.util.Pages;
import com.it.util.Users;

import java.util.List;

public interface UserServers {
    //用户登录
    public Users login(Users users);
    //用户注册
    public boolean  register(Users users);
    //查询所有用户
    public List<Users> queryUsersAll();
    //根据id删除用户
    public boolean deleteUsers(int userId);
    //根据用户名模糊查询
    public List<Users> likeQuery(String userName);
    //查询所有用户
    public List<Users>  queryUsersPage(Pages pages);
    public  boolean addUsers(Users users);

    List<Pages> queryuserAllPage(Pages pages);

    List<Users> likeQueryUser(String userName);
}