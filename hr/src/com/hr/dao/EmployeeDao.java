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
 * 员工数据访问类
 * @author gyr
 *
 */
public class EmployeeDao {
private Connection conn=null;
//DBUtil工具类
private QueryRunner qr=new QueryRunner();
/**
 * 员工登陆查询
 * @param num 工号
 * @param pwd 返回登录成功的员工信息
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
 * 查找全部的员工
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
 * 根据id查找员工
 * @param id
 * @return 对应id的员工信息
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
 * 获取员工总数
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
 * 分页查找员工
 * @param pageIndex 获取数据起始位置
 * @param pageSizev数据长度，每页显示几条数据
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
 * 添加员工
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
 * 更新员工信息
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
 * 根据id删除员工
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
 * 查询部门
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
 * 查询职称
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
 * 获取部门总数
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
 * 分页查找部门
 * @param pageIndex 获取数据起始位置
 * @param pageSizev数据长度，每页显示几条数据
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
 * 添加部门
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
 * 根据id查找部门
 * @param id
 * @return 对应id的员工信息
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
 * 更新部门信息
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
 * 根据id删除部门
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
	//查询
	/*Employee employee = dao.findById(2);
	System.out.println(employee);
	List<Employee> list = dao.findAll();
	System.out.println(list);*/
	//总数
	//int employee=dao.findEmoByCount();
	//System.out.println(employee);
	//分页
	//List<Employee> employee=dao.findAllByPage(3, 3);
	//System.out.println(employee);
}
}
