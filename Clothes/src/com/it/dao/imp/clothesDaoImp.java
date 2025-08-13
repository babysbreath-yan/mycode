package com.it.dao.imp;

import com.it.dao.clothesDao;
import com.it.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clothesDaoImp implements clothesDao {
    Connection conn=null;
    PreparedStatement pstm=null;
    ResultSet rst=null;
    @Override
    public List<clothes> queryclothesAll() {
        conn= DBUtil.getConn();
        List<clothes> clothesList=new ArrayList<>();
        String sql="select * from clothes";
        try {
            pstm=conn.prepareStatement(sql);
            rst=pstm.executeQuery();
            while (rst.next()){
                clothes clothes=new clothes();
                clothes.setclothesId(rst.getInt(1));
                clothes.setclothesName(rst.getString(2));
                clothes.setclothesPct(rst.getString(3));
                clothes.setclothesCount(rst.getString(4));
                clothes.setPrice(rst.getDouble(5));
                clothes.setType(rst.getString(6));
                clothes.setclothesNum(rst.getInt(7));
                clothes.setclothesXl(rst.getInt(8));
                clothes.setStata(rst.getInt(9));
                clothesList.add(clothes);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return clothesList;
    }

    @Override
    public List<clothes> queryclothesAllPage(Pages pages) {
        conn= DBUtil.getConn();
        List<clothes> clothesList=new ArrayList<>();
        String sql="select * from clothes limit ?,?;";
        try {
            pstm=conn.prepareStatement(sql);
            System.out.println(pages.getPageNum()+"--"+pages.getPageSize());
            pstm.setInt(1,(pages.getPageNum()-1)*pages.getPageSize());
            pstm.setInt(2,pages.getPageSize());
            rst=pstm.executeQuery();
            while (rst.next()){
                clothes clothes=new clothes();
                clothes.setclothesId(rst.getInt(1));
                clothes.setclothesName(rst.getString(2));
                clothes.setclothesPct(rst.getString(3));
                clothes.setclothesCount(rst.getString(4));
                clothes.setPrice(rst.getDouble(5));
                clothes.setType(rst.getString(6));
                clothes.setclothesNum(rst.getInt(7));
                clothes.setclothesXl(rst.getInt(8));
                clothes.setStata(rst.getInt(9));
                clothesList.add(clothes);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return clothesList;
    }

    @Override
    public int deleteclothes(int clothesId) {
        conn= DBUtil.getConn();
        int num=0;
        String sql="delete from clothes where clothes_id=?";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,clothesId);
            num=pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return num;
    }

    @Override
    public List<clothes> likeQueryclothes(String clothesName) {
        conn= DBUtil.getConn();
        List<clothes> clothesList=new ArrayList<>();
        String sql="select * from clothes where clothes_name like ?;";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,"%"+clothesName+"%");
            rst=pstm.executeQuery();
            while (rst.next()){
                clothes clothes=new clothes();
                clothes.setclothesId(rst.getInt(1));
                clothes.setclothesName(rst.getString(2));
                clothes.setclothesPct(rst.getString(3));
                clothes.setclothesCount(rst.getString(4));
                clothes.setPrice(rst.getDouble(5));
                clothes.setType(rst.getString(6));
                clothes.setclothesNum(rst.getInt(7));
                clothes.setclothesXl(rst.getInt(8));
                clothes.setStata(rst.getInt(9));
                clothesList.add(clothes);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return clothesList;
    }

    @Override
    public int addclothes(clothes clothes) {
        conn= DBUtil.getConn();
        int num=0;
        String sql="insert into clothes(clothes_name, clothes_pct, clothes_count, price, type, clothes_num, clothes_xl, stata)" +
                "            values (?,?,?,?,?,?,?,?);";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,clothes.getclothesName());
            pstm.setString(2,clothes.getclothesPct());
            pstm.setString(3,clothes.getclothesCount());
            pstm.setDouble(4,clothes.getPrice());
            pstm.setString(5,clothes.getType());
            pstm.setInt(6,clothes.getclothesNum());
            pstm.setInt(7,clothes.getclothesXl());
            pstm.setInt(8,clothes.getStata());
            num=pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return num;
    }

    @Override
    public clothes clothesQueryOne(int clothesId) {
        conn= DBUtil.getConn();
        clothes clothes=null;
        String sql="select * from clothes where clothes_id=?";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,clothesId);
            rst=pstm.executeQuery();
            while (rst.next()){
                clothes=new clothes();
                clothes.setclothesId(rst.getInt(1));
                clothes.setclothesName(rst.getString(2));
                clothes.setclothesPct(rst.getString(3));
                clothes.setclothesCount(rst.getString(4));
                clothes.setPrice(rst.getDouble(5));
                clothes.setType(rst.getString(6));
                clothes.setclothesNum(rst.getInt(7));
                clothes.setclothesXl(rst.getInt(8));
                clothes.setStata(rst.getInt(9));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return clothes;
    }

    @Override
    public int addOlder(Older older) {
        conn= DBUtil.getConn();
        int num=0;
        String sql="insert into older(user_id, clothes_id, num, time) values(?,?,?,?)";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,older.getUserId());
            pstm.setInt(2,older.getclothesId());
            pstm.setInt(3,older.getNum());
            pstm.setString(4,older.getTime());
            num=pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return num;
    }
}