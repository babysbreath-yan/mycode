package com.it.dao.imp;

import com.it.dao.OlderDao;
import com.it.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OlderDaoImp implements OlderDao {
    Connection conn=null;
    PreparedStatement pstm=null;
    ResultSet rst=null;
    @Override
    public List<OlderInfo> queryOlderPage(Pages pages) {
        conn= DBUtil.getConn();
        List<OlderInfo> olderInfoList=new ArrayList<>();
        String sql="select o.older_id,u.user_name,o.num,f.clothes_name,f.price,f.clothes_pct,o.time from older o inner join users u on o.user_id = u.user_id inner join clothes f on o.clothes_id = f.clothes_id limit ?,?";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,(pages.getPageNum()-1)*pages.getPageSize());
            pstm.setInt(2,pages.getPageSize());
            rst=pstm.executeQuery();
            while (rst.next()){
                OlderInfo olderInfo=new OlderInfo();
                olderInfo.setOlderId(rst.getInt(1));
                olderInfo.setUserName(rst.getString(2));
                olderInfo.setNum(rst.getInt(3));
                olderInfo.setclothesName(rst.getString(4));
                olderInfo.setPrice(rst.getDouble(5));
                olderInfo.setclothesPct(rst.getString(6));
                olderInfo.setTime(rst.getString(7));
                olderInfoList.add(olderInfo);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return olderInfoList;
    }

    @Override
    public List<OlderInfo> queryOlderAll() {
        conn= DBUtil.getConn();
        List<OlderInfo> olderInfoList=new ArrayList<>();
        String sql="select o.older_id,u.user_name,o.num,f.clothes_name,f.price,f.clothes_pct,o.time from older o inner join users u on o.user_id = u.user_id inner join clothes f on o.clothes_id = f.clothes_id";
        try {
            pstm=conn.prepareStatement(sql);
            rst=pstm.executeQuery();
            while (rst.next()){
                OlderInfo olderInfo=new OlderInfo();
                olderInfo.setOlderId(rst.getInt(1));
                olderInfo.setUserName(rst.getString(2));
                olderInfo.setNum(rst.getInt(3));
                olderInfo.setclothesName(rst.getString(4));
                olderInfo.setPrice(rst.getDouble(5));
                olderInfo.setclothesPct(rst.getString(6));
                olderInfo.setTime(rst.getString(7));
                olderInfoList.add(olderInfo);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return olderInfoList;
    }

    @Override
    public int deleteOlder(int olderId) {
        conn= DBUtil.getConn();
        int num=0;
        String sql="delete from older where older_id=?";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,olderId);
            num=pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return num;
    }
}