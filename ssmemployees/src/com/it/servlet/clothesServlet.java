package com.it.servlet;

import com.it.dao.clothesDao;
import com.it.dao.imp.clothesDaoImp;
import com.it.servers.clothesServers;
import com.it.servers.imp.clothesServersImp;
import com.it.util.clothes;
import com.it.util.Older;
import com.it.util.Pages;
import com.it.util.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/clothesServlet")
public class clothesServlet extends HttpServlet {
    clothesServers clothesServers=new clothesServersImp();
    clothesDao clothesDao=new clothesDaoImp();
    Pages pages=new Pages();
    {
        pages.setPageSize(9);
        pages.setPageNum(1);
        pages.setPageAll(clothesDao.queryclothesAll().size());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String tp=request.getParameter("tp");
        if("rm".equals(tp)){
            this.clothesRm(request,response);
        }else if("clothesAll".equals(tp)){
            this.clothesAll(request,response);
        }else if("up".equals(tp)){
            pages.up();
            this.clothesAll(request,response);
        }else if("down".equals(tp)){
            pages.down();
            this.clothesAll(request,response);
        }else if("queryclothes".equals(tp)){
            this.queryclothesAdmin(request,response);
        }else if("delete".equals(tp)){
            this.deleteclothes(request,response);
        }else if("upAdmin".equals(tp)){
            pages.up();
            this.queryclothesAdmin(request,response);
        }else if("downAdmin".equals(tp)){
            pages.down();
            this.queryclothesAdmin(request,response);
        }else if("likeQueryAdmin".equals(tp)){
            this.likeQueryAdmin(request,response);
        }else if("addclothes".equals(tp)){
            this.addclothes(request,response);
        }else if("clothesQueryOne".equals(tp)){
            this.clothesQueryOne(request,response);
        }else if("addOlder".equals(tp)){
            this.addOlder(request,response);
        }
    }
    //添加订单
    protected void addOlder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clothesId=Integer.parseInt(request.getParameter("clothesId"));
        HttpSession session=request.getSession();
        Users users=(Users)session.getAttribute("users");
        if(users==null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else {
            int userId=users.getUserId();
            int num=Integer.parseInt(request.getParameter("num"));
            Date date=new Date();
            SimpleDateFormat smt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time=smt.format(date);
            Older older=new Older(userId,clothesId,num,time);
            boolean fig=clothesServers.addOlder(older);
            if(fig){
                session.setAttribute("gmStr","购买成功");
                this.clothesQueryOne(request,response);
            }else {
                request.getRequestDispatcher("err.jsp").forward(request,response);
            }
        }


    }
    //添加衣服商品
    protected void clothesQueryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clothesId=Integer.parseInt(request.getParameter("clothesId"));
        clothes clothes=clothesServers.clothesQueryOne(clothesId);
        request.setAttribute("clothes",clothes);
        request.getRequestDispatcher("clothesQueryOne.jsp").forward(request,response);
    }


    //添加衣服商品
    protected void addclothes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clothesName=request.getParameter("clothesName");
        String clothesPct="images/"+request.getParameter("clothesPct");
        String clothesCount=request.getParameter("clothesCount");
        double price=Double.parseDouble(request.getParameter("price"));
        String type=request.getParameter("type");
        int clothesNum=Integer.parseInt(request.getParameter("clothesNum"));
        int stata=Integer.parseInt(request.getParameter("stata"));
        clothes clothes=new clothes(clothesName,clothesPct,clothesCount,price,type,clothesNum,0,stata);
        boolean fig=clothesServers.addclothes(clothes);
        if(fig){
            this.queryclothesAdmin(request,response);
        }else {
            System.out.println("添加失败");
        }
    }
    //衣服模糊查询
    protected void likeQueryAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clothesName=request.getParameter("clothesName");
        List<clothes> clothesListPage=clothesServers.likeQueryclothes(clothesName);
        request.setAttribute("clothesListPage",clothesListPage);
        request.getRequestDispatcher("queryclothes.jsp").forward(request,response);
    }
    //删除衣服商品
    protected void deleteclothes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clothesId=Integer.parseInt(request.getParameter("clothesId"));
        boolean fig=clothesServers.deleteclothes(clothesId);
        if(fig){
            this.queryclothesAdmin(request,response);
        }else {
            System.out.println("删除失败");
        }
    }
    //管理员分页查询商品
    protected void queryclothesAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<clothes> clothesListPage=clothesServers.queryclothesAllPage(pages);
        request.setAttribute("clothesListPage",clothesListPage);
        request.getRequestDispatcher("queryclothes.jsp").forward(request,response);
    }
    //展示所有商品
    protected void clothesAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<clothes> clothesListPage=clothesServers.queryclothesAllPage(pages);
        request.setAttribute("clothesListPage",clothesListPage);
        request.getRequestDispatcher("category.jsp").forward(request,response);
    }
    //首页展示
    protected void clothesRm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<clothes> clothesListRm =clothesServers.queryclothesRm();
        List<clothes> clothesListXp =clothesServers.queryclothesXp();
        HttpSession session=request.getSession();
        session.setAttribute("clothesListRm",clothesListRm);
        session.setAttribute("clothesListXp",clothesListXp);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}