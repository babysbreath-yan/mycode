package com.it.dao;

import com.it.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {
    // 查询操作
    public static ResultSet executeQuery(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            pstmt = conn.prepareStatement(sql);
            // 设置参数
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // 更新操作（增加、删除）
    public static int executeUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rowsAffected = 0;
        try {
            conn = DBUtil.getConn();
            pstmt = conn.prepareStatement(sql);
            // 设置参数
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rowsAffected = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closes(conn, pstmt, null);
        }
        return rowsAffected;
    }
}