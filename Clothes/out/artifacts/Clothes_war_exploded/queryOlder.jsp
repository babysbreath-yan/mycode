<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 甜啵虎
  Date: 2024/1/13
  Time: 17:15
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
            width: 12%;
            height: 40px;
            line-height: 40px;
            font-size: 20px;
            background-color: cornclothesblue;
            border: 2px solid silver;
            text-align: center;
        }
        .main ol li{
            width: 12%;
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
        <li>订单编号</li>
        <li>用户名</li>
        <li>购买数量</li>
        <li>衣服名称</li>
        <li>价格</li>
        <li>图片</li>
        <li>时间</li>
        <li>操作</li>
    </ul>
    <c:forEach items="${olderInfoList}" var="olderInfo">
        <ol>
            <li>${olderInfo.olderId}</li>
            <li style="overflow: hidden">${olderInfo.userName}</li>
            <li>${olderInfo.num}</li>
            <li style="overflow: hidden">${olderInfo.clothesName}</li>
            <li>${olderInfo.price}</li>
            <li><img  src="${olderInfo.clothesPct}" width="70px" height="40px"/></li>
            <li style="overflow: hidden">${olderInfo.time}</li>
            <li>
                <a href="${pageContext.request.contextPath}/olderServlet?tp=deleteOlder&olderId=${olderInfo.olderId}">删除</a>&nbsp;&nbsp;
                <a href="">修改</a>
            </li>
        </ol>
    </c:forEach>
</div>
<div>
    <a href="${pageContext.request.contextPath}/olderServlet?tp=up">上一页</a>
    <a href="${pageContext.request.contextPath}/olderServlet?tp=down">下一页</a>
</div>
</body>
</html>