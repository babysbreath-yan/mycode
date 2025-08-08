package com.hr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.PositionDao;
import com.hr.entity.PosPage;
import com.hr.entity.Position;

/**
 * Servlet implementation class posservlet
 */
@WebServlet("/posservlet")
public class posservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PositionDao dao=new PositionDao();
    
    public posservlet() {
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
		}else if(state.equals("toaddpos")){
			this.toAddPos(request, response);
		}
		else if(state.equals("update")){
			this.toUpdate(request, response);
		}
		else if(state.equals("toupdate")){
			this.toUpdatePos(request, response);
		}
		else if(state.equals("delete")){
			this.delPos(request, response);
		}
	}
	 private void findAllByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 	   //第几页
	 	 int pageIndex=1;
	 	 //一共多少条数据
	 	 int dataCount=dao.findPosByCount();
	      //设置每页有多少条数据
	 	 int pageSize=3;
	 	 //总页数
	 	 int pageCount=dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
	 	 String pageIndexString=request.getParameter("pageIndex");
	 	 if(pageIndexString!=null&&pageIndexString.length()>0){
	 		 pageIndex=Integer.parseInt(pageIndexString);
	 	 }
	 	 //pageIndex当前的页数，并不是数据查找的起始位置  （3-1）*3
	 	 List<Position> list=dao.findAllPosByPage((pageIndex-1)*pageSize, pageSize);
	      PosPage pe=new PosPage(pageSize, dataCount, pageCount, pageIndex);
	      request.setAttribute("pe", pe);
	      request.setAttribute("list", list);
	      request.getRequestDispatcher("position_list.jsp").forward(request, response);	  
	  }
	 private void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	//获取最后一个部门的部门号
	    	List<Position>list=dao.findPositions();
	    	int positionNumber=(list.get(list.size()-1)).getPosition_number()+1;
	    	List<Position> plist=dao.findPositions();
	    	request.setAttribute("plist", plist);
	    	request.setAttribute("positionNumber",positionNumber);
	    	request.getRequestDispatcher("position_add.jsp").forward(request, response);
	    }
	 private void toAddPos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	String snum=request.getParameter("positionNumber");
	    	int num=Integer.parseInt(snum);
	    	String name=request.getParameter("name");
	    	name=new String(name.getBytes("iso-8859-1"),"utf-8");
	    	String level=request.getParameter("level");
	    	String notes=request.getParameter("notes");
	    	notes=new String(notes.getBytes("iso-8859-1"),"utf-8");
	    	Position pos =new Position(num,name,level,notes); 	
	    	dao.toAddPos(pos);;
	    	request.getRequestDispatcher("/posservlet?state=findallbypage").forward(request, response);
	    }
	 private void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	Position position=dao.findPosById(id);
	    	request.setAttribute("pos", position);
	    	request.getRequestDispatcher("position_update.jsp").forward(request, response);	
	    }
	    private void toUpdatePos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	String snum=request.getParameter("positionNumber");
	    	int num=Integer.parseInt(snum);
	    	String name=request.getParameter("name");
	    	name=new String(name.getBytes("iso-8859-1"),"utf-8");
	    	String level=request.getParameter("level");
	    	level=new String(level.getBytes("iso-8859-1"),"utf-8");
	    	String notes=request.getParameter("notes");
	    	notes=new String(notes.getBytes("iso-8859-1"),"utf-8");
	    	Position pos =new Position(id,num,name,level,notes); 	
	    	dao.toUpdatePos(pos);;
	    	request.getRequestDispatcher("/posservlet?state=findallbypage").forward(request, response);   	
	    }
	    private void delPos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	dao.delPosById(id);
	    	request.getRequestDispatcher("/posservlet?state=findallbypage").forward(request, response);
	    }
}
