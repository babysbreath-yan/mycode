package com.it.servers.imp;

import com.it.dao.UserDao;
import com.it.dao.imp.UserDaoImp;
import com.it.servers.UserServers;
import com.it.util.Pages;
import com.it.util.Users;

import java.util.List;

public class UserServersImp implements UserServers {
    UserDao userDao=new UserDaoImp();
    @Override
    public Users login(Users users) {

        return userDao.login(users);
    }

    @Override
    public boolean register(Users users) {
        return userDao.register(users)>0;
    }

    @Override
    public List<Users> queryUsersAll() {
        return userDao.queryUsersAll();
    }

    @Override
    public boolean deleteUsers(int userId) {
        return userDao.deleteUsers(userId)>0;
    }

    @Override
    public List<Users> likeQuery(String userName) {
        return userDao.likeQuery(userName);
    }

    @Override
    public List<Users> queryUsersPage(Pages pages) {
        return userDao.queryUsersPage(pages);
    }
    @Override
    public boolean addUsers(Users users) {
        return userDao.addUsers(users)>0;
    }

    @Override
    public List<Pages> queryuserAllPage(Pages pages) {
        return userDao.queryUsersAllPage(pages);
    }

    @Override
    public List<Users> likeQueryUser(String userName) {
        return userDao.likeQueryUser(userName);
}}