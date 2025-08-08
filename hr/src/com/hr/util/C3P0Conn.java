package com.hr.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Conn {
	//数据源类
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	//获取连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			conn.setTransactionIsolation(conn.TRANSACTION_READ_COMMITTED);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//关闭连接
	public static void closeConn(Connection conn) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

