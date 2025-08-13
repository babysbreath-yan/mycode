package com.it.dao.imp;

import com.it.dao.UserDao;
import com.it.util.DBUtil;
import com.it.util.Pages;
import com.it.util.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    Connection conn=null;
    PreparedStatement pstm=null;
    ResultSet rst=null;
    @Override
    public Users login(Users users) {
        conn= DBUtil.getConn();
        Users users1=null;
        String sql="select * from users where user_name=? and user_password=?";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,users.getUserName());
            pstm.setString(2,users.getPassword());
            rst=pstm.executeQuery();
            while (rst.next()){
                users1=new Users();
                users1.setUserId(rst.getInt(1));
                users1.setUserName(rst.getString(2));
                users1.setPassword(rst.getString(3));
                users1.setStart(rst.getInt(4));
                System.out.println(users1.toString());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        DBUtil.closes(conn,pstm,rst);
        return users1;
    }

    @Override
    public int register(Users users) {
        int num=0;
        conn= DBUtil.getConn();
        String sql="insert into users(user_name, user_password,start)  values (?,?,0);";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,users.getUserName());
            pstm.setString(2,users.getPassword());
            num=pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return num;
    }

    @Override
    public List<Users> queryUsersAll() {
        conn= DBUtil.getConn();
        List<Users> usersList=new ArrayList<>();
        String sql="select * from users";
        try {
            pstm=conn.prepareStatement(sql);
            rst=pstm.executeQuery();
            while (rst.next()){
                Users users=new Users();
                users.setUserId(rst.getInt(1));
                users.setUserName(rst.getString(2));
                users.setPassword(rst.getString(3));
                users.setStart(rst.getInt(4));
                usersList.add(users);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return usersList;
    }

    @Override
    public List<Users> queryUsersPage(Pages pages) {
        conn= DBUtil.getConn();
        List<Users> usersList=new ArrayList<>();
        String sql="select * from users limit ?,?";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,(pages.getPageNum()-1)*pages.getPageSize());
            pstm.setInt(2,pages.getPageSize());
            rst=pstm.executeQuery();
            while (rst.next()){
                Users users=new Users();
                users.setUserId(rst.getInt(1));
                users.setUserName(rst.getString(2));
                users.setPassword(rst.getString(3));
                users.setStart(rst.getInt(4));
                usersList.add(users);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return usersList;
    }

    @Override
    public int deleteUsers(int userId) {
        int num=0;
        conn= DBUtil.getConn();
        String sql="delete from users where user_id=?;";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,userId);
            num=pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return num;
    }

    @Override
    public List<Users> likeQuery(String userName) {
        conn= DBUtil.getConn();
        List<Users> usersList=new ArrayList<>();
        String sql="select * from users where user_name like ?;";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,"%"+userName+"%");
            rst=pstm.executeQuery();
            while (rst.next()){
                Users users=new Users();
                users.setUserId(rst.getInt(1));
                users.setUserName(rst.getString(2));
                users.setPassword(rst.getString(3));
                users.setStart(rst.getInt(4));
                usersList.add(users);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return usersList;
    }
    @Override
    public int addUsers(Users users) {
        conn= DBUtil.getConn();
        int num=0;
        String sql="insert into users(user_name,user_password,start) values (?,?,?,?);";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,users.getUserName());
            pstm.setInt(3,users.getStart());
            num=pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return num;
    }

    @Override
    public List<Users> likeQueryUser(String usersName) {
        return null;
    }

    @Override
    public List<Pages> queryUsersAllPage(Pages pages) {
        return null;
    }
}