package com.hr.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.hr.entity.Position;
import com.hr.util.C3P0Conn;

public class PositionDao {
	private Connection conn=null;
	//DBUtil������
	private QueryRunner qr=new QueryRunner();
	/**
	 * ��ѯְ��
	 * @return
	 */
	public List<Position> findPositions(){
		List<Position>list=null;
		conn=C3P0Conn.getConnection();
		String sql="select*from position";
		try {
			list=qr.query(conn, sql,new BeanListHandler<Position>(Position.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Conn.closeConn(conn);
		}
		return list;
	}
	/**
	 * ��ȡְλ����
	 * @return
	 */
	public int findPosByCount(){
		int i=0;
		conn=C3P0Conn.getConnection();
		String sql="select count(*) c from position";
		try {
			long c=qr.query(conn, sql, new ScalarHandler<Long>());
		    i=(int)c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Conn.closeConn(conn);
		}
		return i;
	}
	/**
	 * ��ҳ����ְλ
	 * @param pageIndex ��ȡ������ʼλ��
	 * @param pageSizev���ݳ��ȣ�ÿҳ��ʾ��������
	 * @return
	 */
	public List<Position> findAllPosByPage(int pageIndex,int pageSize){
		List<Position> list=null;
		conn=C3P0Conn.getConnection();
		String sql="select*from position limit ?,?";
		try {
			list=qr.query(conn, sql, new BeanListHandler<Position>(Position.class),pageIndex,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Conn.closeConn(conn);
		}
		return list;
	}
	/**
	 * ���ְλ
	 * @param emp
	 */
	public void toAddPos(Position pos){
		conn=C3P0Conn.getConnection();
		String sql="insert into position(position_number,name,level,notes) values(?,?,?,?)";
	    try {
			qr.update(conn,sql,pos.getPosition_number(),pos.getName(),pos.getLevel(),pos.getNotes());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Conn.closeConn(conn);
		}
	}
	/**
	 * ����id����ְλ
	 * @param id
	 * @return ��Ӧid��ְλ��Ϣ
	 */
	public Position findPosById(int id){
		Position pos=null;
		conn=C3P0Conn.getConnection();
		String sql="select*from position where id=?";
		try {
			pos=qr.query(conn, sql,new BeanHandler<Position>(Position.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Conn.closeConn(conn);
		}
		return pos;
	}
	/**
	 * ����ְλ��Ϣ
	 * @param emp
	 */
	public void toUpdatePos(Position pos){
		conn=C3P0Conn.getConnection();
		String sql="update position set name=?,level=?,notes=? where id=?";
	    try {
			qr.update(conn, sql,pos.getName(),pos.getLevel(),pos.getNotes(),pos.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Conn.closeConn(conn);
		}
	}
	/**
	 * ����idɾ��ְλ
	 * @param id
	 */
	public void delPosById(int id){
		conn=C3P0Conn.getConnection();
		String sql="delete from position where id=?";
	    try {
			qr.update(conn, sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Conn.closeConn(conn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
