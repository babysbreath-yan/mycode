package com.it.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
    public static Connection getConn(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/clothesDB";//连接字符串
            conn= DriverManager.getConnection(url,"root","tsy20040510");
        } catch (Exception e) {
            System.err.println("错误："+e.getMessage());
        }
        return conn;
    }

    public static void closes(Connection conn, PreparedStatement pstm, ResultSet rst){
        try {
            if(conn!=null){
                conn.close();
            }
            if(pstm!=null){
                pstm.close();
            }
            if(rst!=null){
                rst.close();
            }
        }catch (Exception e){
            System.err.println("错误："+e.getMessage());
        }
    }
}