package com.hr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EmployeeDao;
import com.hr.entity.DepPage;
import com.hr.entity.Department;


/**
 * Servlet implementation class depservlet
 */
@WebServlet("/depservlet")
public class depservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao dao=new EmployeeDao();
    
    public depservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String state=request.getParameter("state");
		if(state.equals("findallbypage")){
			this.findAllByPage(request, response);
		}else if(state.equals("toadd")){
			this.toAdd(request, response);
		}else if(state.equals("toadddep")){
			this.toAddDep(request, response);
		}
		else if(state.equals("update")){
			this.toUpdate(request, response);
		}
		else if(state.equals("toupdate")){
			this.toUpdateDep(request, response);
		}
		else if(state.equals("delete")){
			this.delDep(request, response);
		}
	}
	 private void findAllByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 	   //第几页
	 	 int pageIndex=1;
	 	 //一共多少条数据
	 	 int dataCount=dao.findDepByCount();
	      //设置每页有多少条数据
	 	 int pageSize=3;
	 	 //总页数
	 	 int pageCount=dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
	 	 String pageIndexString=request.getParameter("pageIndex");
	 	 if(pageIndexString!=null&&pageIndexString.length()>0){
	 		 pageIndex=Integer.parseInt(pageIndexString);
	 	 }
	 	 //pageIndex当前的页数，并不是数据查找的起始位置  （3-1）*3
	 	 List<Department> list=dao.findAllDepByPage((pageIndex-1)*pageSize, pageSize);
	      DepPage pe=new DepPage(pageSize, dataCount, pageCount, pageIndex);
	      request.setAttribute("pe", pe);
	      request.setAttribute("list", list);
	      request.getRequestDispatcher("dept_list.jsp").forward(request, response);	  
	  }
	 private void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	//获取最后一个部门的部门号
	    	List<Department>list=dao.findDepertmentsAll();
	    	int departmentNumber=(list.get(list.size()-1)).getDepartment_number()+1;
	    	List<Department> dlist=dao.findDepertmentsAll();
	    	request.setAttribute("dlist", dlist);
	    	request.setAttribute("departmentNumber",departmentNumber);
	    	request.getRequestDispatcher("dept_add.jsp").forward(request, response);
	    }
	 private void toAddDep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	String snum=request.getParameter("departmentNumber");
	    	int num=Integer.parseInt(snum);
	    	String name=request.getParameter("name");
	    	name=new String(name.getBytes("iso-8859-1"),"utf-8");
	    	String telephone=request.getParameter("telephone");
	    	String address=request.getParameter("address");
	    	address=new String(address.getBytes("iso-8859-1"),"utf-8");
	    	String notes=request.getParameter("notes");
	    	notes=new String(notes.getBytes("iso-8859-1"),"utf-8");
	    	Department dep =new Department(num, name,telephone,address,notes); 	
	    	dao.toAddDep(dep);;
	    	request.getRequestDispatcher("/depservlet?state=findallbypage").forward(request, response);
	    }
	 private void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	Department department=dao.findDepById(id);
	    	request.setAttribute("dep", department);
	    	request.getRequestDispatcher("dept_update.jsp").forward(request, response);	
	    }
	    private void toUpdateDep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	String snum=request.getParameter("departmentNumber");
	    	int num=Integer.parseInt(snum);
	    	String name=request.getParameter("name");
	    	name=new String(name.getBytes("iso-8859-1"),"utf-8");
	    	String telephone=request.getParameter("telephone");
	    	String address=request.getParameter("address");
	    	address=new String(address.getBytes("iso-8859-1"),"utf-8");
	    	String notes=request.getParameter("notes");
	    	notes=new String(notes.getBytes("iso-8859-1"),"utf-8");
	    	Department dep =new Department(id,num,name,telephone,address,notes); 	
	    	dao.toUpdateDep(dep);;
	    	request.getRequestDispatcher("/depservlet?state=findallbypage").forward(request, response);   	
	    }
	    private void delDep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	dao.delDepById(id);
	    	request.getRequestDispatcher("/depservlet?state=findallbypage").forward(request, response);
	    }
}
