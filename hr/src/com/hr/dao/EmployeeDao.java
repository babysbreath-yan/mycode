package com.hr.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hr.entity.Department;
import com.hr.entity.Employee;
import com.hr.entity.Position;
import com.hr.util.C3P0Conn;

/**
 * Ա�����ݷ�����
 * @author gyr
 *
 */
public class EmployeeDao {
private Connection conn=null;
//DBUtil������
private QueryRunner qr=new QueryRunner();
/**
 * Ա����½��ѯ
 * @param num ����
 * @param pwd ���ص�¼�ɹ���Ա����Ϣ
 * @return
 */
public Employee selectLogin(int num,String pwd){
	Employee emp=null;
	conn=C3P0Conn.getConnection();
	String sql="select*from employee where employee_number=? and password=?";
	try {
		emp=qr.query(conn,sql,new BeanHandler<Employee>(Employee.class),num,pwd);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
	return emp;
}
/**
 * ����ȫ����Ա��
 * @return
 */
public List<Employee>findAll(){
	List<Employee>list=null;
	conn=C3P0Conn.getConnection();
	String sql="select*from employee";
	try {
		list=qr.query(conn, sql,new BeanListHandler<Employee>(Employee.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
	return list;
}
/**
 * ����id����Ա��
 * @param id
 * @return ��Ӧid��Ա����Ϣ
 */
public Employee findById(int id){
	Employee emp=null;
	conn=C3P0Conn.getConnection();
	String sql="select*from employee where id=?";
	try {
		emp=qr.query(conn, sql,new BeanHandler<Employee>(Employee.class),id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
	return emp;
}
/**
 * ��ȡԱ������
 * @return
 */
public int findEmpByCount(){
	int i=0;
	conn=C3P0Conn.getConnection();
	String sql="select count(*) c from employee";
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
 * ��ҳ����Ա��
 * @param pageIndex ��ȡ������ʼλ��
 * @param pageSizev���ݳ��ȣ�ÿҳ��ʾ��������
 * @return
 */
public List<Employee> findAllByPage(int pageIndex,int pageSize){
	List<Employee> list=null;
	conn=C3P0Conn.getConnection();
	String sql="select*from employee limit ?,?";
	try {
		list=qr.query(conn, sql, new BeanListHandler<Employee>(Employee.class),pageIndex,pageSize);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
	return list;
}
/**
 * ���Ա��
 * @param emp
 */
public void toAddEmp(Employee emp){
	Date date=new Date();
	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
	String sdate=sf.format(date);
	conn=C3P0Conn.getConnection();
	String sql="insert into employee(employee_number,name,gender,birthday,telephone,email,address,education,department_number,position_number,password,notes) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
		qr.update(conn,sql,emp.getEmployee_number(),emp.getName(),emp.getGender(),emp.getBirthday(),emp.getTelephone(),emp.getEmail(),emp.getAddress(),emp.getEducation(),emp.getDepartment_number(),emp.getPosition_number(),emp.getPassword(),emp.getNotes());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
}
/**
 * ����Ա����Ϣ
 * @param emp
 */
public void toUpdate(Employee emp){
	conn=C3P0Conn.getConnection();
	String sql="update employee set name=?,password=?,gender=?,birthday=?,telephone=?,email=?,address=?,education=?,department_number=?,position_number=?,notes=? where id=?";
    try {
		qr.update(conn, sql,emp.getName(),emp.getPassword(),emp.getGender(),emp.getBirthday(),emp.getTelephone(),emp.getEmail(),emp.getAddress(),emp.getEducation(),emp.getDepartment_number(),emp.getPosition_number(),emp.getNotes(),emp.getId());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
}
/**
 * ����idɾ��Ա��
 * @param id
 */
public void delEmpById(int id){
	conn=C3P0Conn.getConnection();
	String sql="delete from employee where id=?";
    try {
		qr.update(conn, sql,id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
}
/**
 * ��ѯ����
 * @return
 */
public List<Department> findDepertmentsAll(){
	List<Department>list=null;
	conn=C3P0Conn.getConnection();
	String sql="select*from department";
	try {
		list=qr.query(conn, sql,new BeanListHandler<Department>(Department.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
	return list;
}
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
 * ��ȡ��������
 * @return
 */
public int findDepByCount(){
	int i=0;
	conn=C3P0Conn.getConnection();
	String sql="select count(*) c from department";
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
 * ��ҳ���Ҳ���
 * @param pageIndex ��ȡ������ʼλ��
 * @param pageSizev���ݳ��ȣ�ÿҳ��ʾ��������
 * @return
 */
public List<Department> findAllDepByPage(int pageIndex,int pageSize){
	List<Department> list=null;
	conn=C3P0Conn.getConnection();
	String sql="select*from department limit ?,?";
	try {
		list=qr.query(conn, sql, new BeanListHandler<Department>(Department.class),pageIndex,pageSize);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
	return list;
}
/**
 * ��Ӳ���
 * @param emp
 */
public void toAddDep(Department dep){
	conn=C3P0Conn.getConnection();
	String sql="insert into department(department_number,name,telephone,address,notes) values(?,?,?,?,?)";
    try {
		qr.update(conn,sql,dep.getDepartment_number(),dep.getName(),dep.getTelephone(),dep.getAddress(),dep.getNotes());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
}
/**
 * ����id���Ҳ���
 * @param id
 * @return ��Ӧid��Ա����Ϣ
 */
public Department findDepById(int id){
	Department dep=null;
	conn=C3P0Conn.getConnection();
	String sql="select*from department where id=?";
	try {
		dep=qr.query(conn, sql,new BeanHandler<Department>(Department.class),id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
	return dep;
}
/**
 * ���²�����Ϣ
 * @param emp
 */
public void toUpdateDep(Department dep){
	conn=C3P0Conn.getConnection();
	String sql="update department set name=?,telephone=?,address=?,notes=? where id=?";
    try {
		qr.update(conn, sql,dep.getName(),dep.getTelephone(),dep.getAddress(),dep.getNotes(),dep.getId());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		C3P0Conn.closeConn(conn);
	}
}
/**
 * ����idɾ������
 * @param id
 */
public void delDepById(int id){
	conn=C3P0Conn.getConnection();
	String sql="delete from department where id=?";
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
	//EmployeeDao dao = new EmployeeDao();
	//��ѯ
	/*Employee employee = dao.findById(2);
	System.out.println(employee);
	List<Employee> list = dao.findAll();
	System.out.println(list);*/
	//����
	//int employee=dao.findEmoByCount();
	//System.out.println(employee);
	//��ҳ
	//List<Employee> employee=dao.findAllByPage(3, 3);
	//System.out.println(employee);
}
}
