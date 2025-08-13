package com.it.servlet;

import com.it.dao.UserDao;
import com.it.dao.imp.UserDaoImp;
import com.it.servers.UserServers;
import com.it.servers.imp.UserServersImp;
import com.it.util.Pages;
import com.it.util.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    //获取对象
    UserServers userServers=new UserServersImp();
    UserDao userDao=new UserDaoImp();
    Pages pages=new Pages();
    private Object HttpServletResponse;

    {
        pages.setPageNum(1);
        pages.setPageSize(8);
        pages.setPageAll(userDao.queryUsersAll().size());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String tp=req.getParameter("tp");
        System.out.println(tp);
        if("login".equals(tp)){
            this.login(req,resp);
        }else if("register".equals(tp)){
            this.register(req,resp);
        }else if("delete".equals(tp)){
            this.deleteUsers(req,resp);
        }else if("likeQuery".equals(tp)){
            this.likeQuery(req,resp);
        }else if("up".equals(tp)){
            pages.up();
            this.queryUserAll(req,resp);
        }else if("down".equals(tp)){
            pages.down();
            this.queryUserAll(req,resp);
        }

    }
    //模糊查询
    protected void likeQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("userName");
        List<Users> usersList=userServers.likeQuery(userName);
        HttpSession session=req.getSession();
        session.setAttribute("userList",usersList);
        req.getRequestDispatcher("queryUser.jsp").forward(req,resp);
    }
    //删除用户
    protected void deleteUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId=Integer.parseInt(req.getParameter("userId"));
        boolean fig=userServers.deleteUsers(userId);
        if(fig){
            this.queryUserAll(req,resp);
        }else {
            System.out.println("删除失败");
        }
    }
    //用户注册
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名
        String userName=req.getParameter("userName");
        //获取密码
        String password=req.getParameter("password");
        //创建用户对象
        Users users=new Users();
        users.setUserName(userName);
        users.setPassword(password);
        //执行注册
        boolean fig=userServers.register(users);
        if(!fig){
            req.setAttribute("str1","注册失败");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
    //用户登录
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名
        String userName=req.getParameter("userName");
        //获取密码
        String password=req.getParameter("password");

        //创建用户对象
        Users users=new Users();
        users.setUserName(userName);
        users.setPassword(password);
        //执行登录
        Users users1=userServers.login(users);

        if(users1==null){
            req.setAttribute("str","登录失败，请重新登录");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            //存储对象
            HttpSession session=req.getSession();
            session.setAttribute("users",users1);
            if(users1.getStart()==1){
                //管理员
                //重定向到管理员主页
                List<Users> usersList=userServers.queryUsersPage(pages);
                session.setAttribute("userList",usersList);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }else {
                //用户
                //转发
                //req.getRequestDispatcher("index.jsp").forward(req,resp);
                //重定向到用户主页
                resp.sendRedirect("clothesServlet?tp=rm");
            }
        }
    }
    //查询所有用户
    protected void queryUserAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> usersList=userServers.queryUsersPage(pages);
        HttpSession session=req.getSession();
        session.setAttribute("userList",usersList);
        req.getRequestDispatcher("queryUser.jsp").forward(req,resp);
    }
    protected void addUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userName= request.getParameter("userName");
        String userPassword =request.getParameter("userPassword");
        int start = Integer.parseInt(request.getParameter("start"));
        Users users=new Users(userId,userName,userPassword,start);
        boolean fig = userServers.addUsers(users);
        if (fig) {
            this.queryUserAdmin(request, response);
        } else {
            System.out.println("添加失败");
        }
    }

    private void queryUserAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName= request.getParameter("userName");

        List<Pages> userListPage = userServers.queryuserAllPage(pages);
        request.setAttribute("userListPage", userListPage);
        request.getRequestDispatcher("queryUser.jsp").forward(request,response);

    }

    protected void usersAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pages> flowerListPage = userServers.queryuserAllPage(pages);
        request.setAttribute("flowerListPage", flowerListPage);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }
    protected void likeQueryAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        List<Users> userListPage = userServers.likeQueryUser(userName);
        request.setAttribute("flowerListPage", userListPage);
        request.getRequestDispatcher("queryUser.jsp").forward(request, response);


}}