package com.hr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.EmployeeDao;
import com.hr.entity.Department;
import com.hr.entity.EmpPage;
import com.hr.entity.Employee;
import com.hr.entity.Position;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/empservlet")
public class empservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       EmployeeDao dao=new EmployeeDao();
    public empservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String state=request.getParameter("state");
		if(state.equals("login")){
			this.emplogin(request,response);
		}else if(state.equals("findallbypage")){
			this.findAllByPage(request, response);
		}
		else if(state.equals("toadd")){
			this.toAdd(request, response);
		}
		else if(state.equals("toaddemp")){
			this.toAddEmp(request, response);
		}
		else if(state.equals("show")){
			this.findById(request, response);
		}
		else if(state.equals("delete")){
			this.delEmp(request, response);
		}
		else if(state.equals("update")){
			this.toUpdate(request, response);
		}
		else if(state.equals("toupdate")){
			this.toUpdateEmp(request, response);
		}
	}
    private void emplogin(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
	String namestr=request.getParameter("employeeNumber");
    String pwd=request.getParameter("password");
    int name=Integer.parseInt(namestr);
    Employee emp=dao.selectLogin(name, pwd);
    if(emp==null){
    	response.sendRedirect("login.jsp");
    }else{
    	request.getSession().setAttribute("emp", emp);
        request.getRequestDispatcher("index1.jsp").forward(request, response);;
    }
    }
  //分页查询
    private void findAllByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 	   //第几页
 	 int pageIndex=1;
 	 //一共多少条数据
 	 int dataCount=dao.findEmpByCount();
      //设置每页有多少条数据
 	 int pageSize=3;
 	 //总页数
 	 int pageCount=dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
 	 String pageIndexString=request.getParameter("pageIndex");
 	 if(pageIndexString!=null&&pageIndexString.length()>0){
 		 pageIndex=Integer.parseInt(pageIndexString);
 	 }
 	 //pageIndex当前的页数，并不是数据查找的起始位置  （3-1）*3
 	 List<Employee> list=dao.findAllByPage((pageIndex-1)*pageSize, pageSize);
      EmpPage pe=new EmpPage(pageSize, dataCount, pageCount, pageIndex);
      request.setAttribute("pe", pe);
      request.setAttribute("list", list);
      request.getRequestDispatcher("employee_list.jsp").forward(request, response);
  
  }
    private void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//获取最后一名员工的工号
    	List<Employee>list=dao.findAll();
    	int employeeNumber=(list.get(list.size()-1)).getEmployee_number()+1;
    	List<Department> dlist=dao.findDepertmentsAll();
    	List<Position> plist=dao.findPositions();
    	request.setAttribute("dlist", dlist);
    	request.setAttribute("plist", plist);
    	request.setAttribute("employeeNumber",employeeNumber);
    	request.getRequestDispatcher("employee_add.jsp").forward(request, response);
    }
    private void toAddEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String snum=request.getParameter("employeeNumber");
    	int num=Integer.parseInt(snum);
    	String name=request.getParameter("name");
    	name=new String(name.getBytes("iso-8859-1"),"utf-8");
    	String password=request.getParameter("password");
    	String gender=request.getParameter("gender");
    	gender=new String(gender.getBytes("iso-8859-1"),"utf-8");
    	String date=request.getParameter("date");
    	String telephone=request.getParameter("telephone");
    	String email=request.getParameter("email");
    	String address=request.getParameter("address");
    	address=new String(address.getBytes("iso-8859-1"),"utf-8");
    	String education=request.getParameter("education");
    	education=new String(education.getBytes("iso-8859-1"),"utf-8");
    	int dnum=Integer.parseInt(request.getParameter("departmentNumber"));
    	int pnum=Integer.parseInt(request.getParameter("positionNumber"));
    	String notes=request.getParameter("notes");
    	notes=new String(notes.getBytes("iso-8859-1"),"utf-8");
    	Employee employee =new Employee(num, name, gender, date, telephone, email, address, education, dnum, pnum, password, notes);
    	dao.toAddEmp(employee);
    	request.getRequestDispatcher("/empservlet?state=findallbypage").forward(request, response);
    }
    private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	int id=Integer.parseInt(request.getParameter("id"));
    	Employee emp=dao.findById(id);
    	request.setAttribute("emp", emp);
    	request.getRequestDispatcher("oneself_detail.jsp").forward(request, response);
    }
    private void delEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	int id=Integer.parseInt(request.getParameter("id"));
    	dao.delEmpById(id);;
    	request.getRequestDispatcher("/empservlet?state=findallbypage").forward(request, response);
    }
    private void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	int id=Integer.parseInt(request.getParameter("id"));
    	Employee employee=dao.findById(id);
    	request.setAttribute("emp", employee);
    	List<Department> dlist=dao.findDepertmentsAll();
    	List<Position> plist=dao.findPositions();
    	request.setAttribute("dlist", dlist);
    	request.setAttribute("plist", plist);
    	request.setAttribute("emp", employee);
    	request.getRequestDispatcher("employee_update.jsp").forward(request, response);	
    }
    private void toUpdateEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	int id=Integer.parseInt(request.getParameter("id"));
    	String snum=request.getParameter("employeeNumber");
    	int num=Integer.parseInt(snum);
    	String name=request.getParameter("name");
    	name=new String(name.getBytes("iso-8859-1"),"utf-8");
    	String password=request.getParameter("password");
    	String gender=request.getParameter("gender");
    	gender=new String(gender.getBytes("iso-8859-1"),"utf-8");
    	String date=request.getParameter("date");
    	String telephone=request.getParameter("telephone");
    	String email=request.getParameter("email");
    	String address=request.getParameter("address");
    	address=new String(address.getBytes("iso-8859-1"),"utf-8");
    	String education=request.getParameter("education");
    	education=new String(education.getBytes("iso-8859-1"),"utf-8");
    	int dnum=Integer.parseInt(request.getParameter("departmentNumber"));
    	int pnum=Integer.parseInt(request.getParameter("positionNumber"));
    	String notes=request.getParameter("notes");
    	notes=new String(notes.getBytes("iso-8859-1"),"utf-8");
    	Employee emp=new Employee(id, num, name, gender, date, telephone, email, address, education, dnum, pnum, password, notes);
    	dao.toUpdate(emp);
    	request.getRequestDispatcher("/empservlet?state=findallbypage").forward(request, response);   	
    }
}

