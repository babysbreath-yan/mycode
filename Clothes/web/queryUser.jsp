<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 甜啵虎
  Date: 2024/1/11
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0px;
            padding: 0px;
        }
        .top{
            width: 100%;
            height: 200px;
            background-color: beige;
        }
        .main{
            width: 100%;
            height: 600px;
        }
        .main ul{
            width: 100%;

        }
        .main ul li{
            list-style: none;
            float: left;
            font-weight: 600;
            width: 18%;
            height: 40px;
            line-height: 40px;
            font-size: 20px;
            background-color: cornclothesblue;
            border: 2px solid silver;
            text-align: center;
        }
        .main ol li{
            width: 18%;
            height: 50px;
            line-height: 50px;
            border: 2px solid lightgray;
            text-align: center;
            float: left;
            list-style: none;
            font-size: 18px;
            color: gray;
        }
    </style>
</head>
<body>
<div class="top">
    <form action="userServlet?tp=likeQuery" method="post">
        <label>用户名</label>
        <input type="text" name="userName" placeholder="输入用户名"/>
        <input type="submit" value="查询"/>
    </form>
</div>
<div class="main">
    <ul>
        <li>用户编号</li>
        <li>用户名</li>
        <li>密码</li>
        <li>身份</li>
        <li>操作</li>
    </ul>
    <c:forEach items="${userList}" var="users">
        <ol>
            <li>${users.userId}</li>
            <li>${users.userName}</li>
            <li>${users.password}</li>
            <li>${users.start}</li>
            <c:if test="${users.start==0}">
                <li><a href="${pageContext.request.contextPath}/userServlet?tp=delete&userId=${users.userId}">删除</a>&nbsp;&nbsp;
                    <a href="">修改</a></li>
            </c:if>
            <c:if test="${users.start==1}">
                <li>管理员</li>
            </c:if>
        </ol>
    </c:forEach>
</div>
<div>
    <a href="${pageContext.request.contextPath}/userServlet?tp=up">上一页</a>
    <a href="${pageContext.request.contextPath}/userServlet?tp=down">下一页</a>
</div>
</body>
</html>