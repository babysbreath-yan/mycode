package com.it.servlet;

import com.it.dao.UserDao;
import com.it.dao.contactDao;
import com.it.dao.imp.UserDaoImp;
import com.it.servers.UserServers;
import com.it.servers.imp.UserServersImp;
import com.it.util.Pages;
import com.it.util.Users;
import com.it.util.contact;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class contactServlet extends HttpServlet {
    Pages pages=new Pages();
    {
        pages.setPageNum(1);
        pages.setPageSize(8);
        pages.setPageAll(contactDao.queryContactAll().size());
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String tp=req.getParameter("tp");
        System.out.println(tp);

    }
    protected void contact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id=req.getParameter("user_id");
        String email=req.getParameter("email");
        String telephone=req.getParameter("telephone");
        String content=req.getParameter("content");
        String publish_time=req.getParameter("publish_time");
        contact contact=new contact();
        contact.setUser_id(user_id);
        contact.setEmail(email);
        contact.setTelephone(telephone);
        contact.setContent(content);
        contact.setPublish_time(publish_time);
    }
    protected void querycontact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<contact> contactList= contactDao.queryContactAll();
        HttpSession session=req.getSession();
        session.setAttribute("contactList",contactList);
        req.getRequestDispatcher("contactQuery.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
