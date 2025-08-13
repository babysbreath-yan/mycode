<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 甜啵虎
  Date: 2024/1/11
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>卖衣服系统</title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <meta name="keywords" content="卖衣服系统">
    <meta name="discription" content="卖衣服系统">
    <link rel="stylesheet" href="css/admin/admin.css"/>
</head>
<body id="sysmain">
<div class="left">
    <div>
        <ul>
            <li>用户管理
                <ul>
                    <li><a href="queryUser.jsp" target="main">查询用户</a></li>
                    <li><a href="" target="main">增加用户</a></li>
                    <li><a href="#">查询用户详细信息</a></li>
                    <li><a href="" target="main">增加用户详细信息</a></li>
                </ul>
            </li>
            <li>公告管理
                <ul>
                    <li><a href="#">删除用户</a></li>
                    <li><a href="#">修改用户</a></li>
                    <li><a href="contactQuery.jsp"  target="main">查询用户</a></li>
                    <li><a href="#">增加用户</a></li>
                </ul>
            </li>
            <li>订单管理
                <ul>
                    <li><a href="olderServlet?tp=queryOlder" target="main">订单查询</a></li>
                    <li><a href="#">修改订单</a></li>


                </ul>
            </li>
            <li>商品管理
                <ul>
                    <li><a href="addclothes.jsp" target="main">添加商品</a></li>
                    <li><a href="#">修改用户</a></li>
                    <li><a href="clothesServlet?tp=queryclothes" target="main">商品查询</a></li>
                    <li><a href="addUsers.jsp">增加用户</a></li>
                </ul>
            </li>
            <li>用户管理</li>
            <li>用户管理</li>
        </ul>
    </div>
</div>
<div class="rit">
    <c:if test="${users!=null}">
        <label>欢迎管理员${users.userName}登录</label>
    </c:if>
    <iframe name="main" src="queryUser.jsp"></iframe>
</div>
</body>
</html>