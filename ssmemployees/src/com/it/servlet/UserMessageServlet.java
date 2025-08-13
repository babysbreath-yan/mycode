package com.it.servlet;

import com.it.servers.UserMessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.UserMessage;
import java.io.IOException;
import java.util.List;
import java.io.IOException;

@WebServlet({"/message/add","/message/delete","/message/show","/message/search"})
public class UserMessageServlet extends HttpServlet {
        private UserMessageService userMessageService = new UserMessageService();

        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String servletPath = request.getServletPath();
            if ("/message/add".equals(servletPath)){
                addUserMessage(request,response);
            } else if ("/message/delete".equals(servletPath)) {
                deleteUserMessage(request,response);
            }else if ("/message/show".equals(servletPath)) {
                showAllUserMessages(request,response);
            }
        }

        // 添加用户消息
        private void addUserMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int userId = Integer.parseInt(request.getParameter("userId"));
            String message = request.getParameter("message");
            UserMessage userMessage = new UserMessage(userId, message);
            userMessageService.addUserMessage(userMessage);

            response.sendRedirect(request.getContextPath() + "/message/show");
        }

        // 删除用户消息
        private void deleteUserMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            userMessageService.deleteUserMessage(id);

            response.sendRedirect(request.getContextPath() + "/message/show");
        }

        // 查看所有用户消息
        private void showAllUserMessages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<UserMessage> messages = userMessageService.getAllUserMessages();
            HttpSession session = request.getSession();
            session.setAttribute("messages",messages);
            response.sendRedirect(request.getContextPath() + "/show_message.jsp");
        }


}
