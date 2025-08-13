package com.it.servlet;

import com.it.dao.OlderDao;
import com.it.dao.imp.OlderDaoImp;
import com.it.servers.OlderServers;
import com.it.servers.imp.OlderServersImp;
import com.it.util.OlderInfo;
import com.it.util.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/olderServlet")
public class OlderServlet extends HttpServlet {
    OlderServers olderServers=new OlderServersImp();
    OlderDao   olderDao=new OlderDaoImp();
    Pages pages=new Pages();
    {
        pages.setPageSize(10);
        pages.setPageNum(1);
        pages.setPageAll(olderDao.queryOlderAll().size());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String tp=request.getParameter("tp");
        if("queryOlder".equals(tp)){
            this.queryOlder(request,response);
        }else if("deleteOlder".equals(tp)){
            this.deleteOlder(request,response);
        }else if("up".equals(tp)){
            pages.up();
            this.queryOlder(request,response);
        }else if("down".equals(tp)){
            pages.down();
            this.queryOlder(request,response);
        }
    }
    protected void deleteOlder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int olderId=Integer.parseInt(request.getParameter("olderId"));
        boolean fig=olderServers.deleteOlder(olderId);
        if(fig){
            this.queryOlder(request,response);
        }else {
            request.getRequestDispatcher("err.jsp").forward(request,response);
        }
    }
    protected void queryOlder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OlderInfo> olderInfoList=olderServers.queryOlderPage(pages);
        request.setAttribute("olderInfoList",olderInfoList);
        request.getRequestDispatcher("queryOlder.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}