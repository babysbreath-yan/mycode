<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 甜啵虎
  Date: 2024/1/13
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <form action="clothesServlet?tp=likeQueryAdmin" method="post">
        <label>衣服名</label>
        <input type="text" name="clothesName" placeholder="输入衣服名称"/>
        <input type="submit" value="查询"/>
    </form>
</div>
<div class="main">
    <ul>
        <li>衣服编号</li>
        <li>衣服名</li>
        <li>价格</li>
        <li>库存</li>
        <li>类型</li>
        <li>销量</li>
        <li>状态</li>
        <li>操作</li>
    </ul>

    <c:forEach items="${clothesListPage}" var="clothes">
        <ol>
            <li>${clothes.clothesId}</li>
            <li>${clothes.clothesName}</li>
            <li>${clothes.price}</li>
            <li>${clothes.clothesNum}</li>
            <li>${clothes.type}</li>
            <li>${clothes.clothesXl}</li>
            <li>${clothes.stata}</li>
            <li>
                <a href="${pageContext.request.contextPath}/clothesServlet?tp=delete&clothesId=${clothes.clothesId}">删除</a>&nbsp;&nbsp;
                <a href="">修改</a>
            </li>
        </ol>
    </c:forEach>
</div>
<div>
    <a href="${pageContext.request.contextPath}/clothesServlet?tp=upAdmin">上一页</a>
    <a href="${pageContext.request.contextPath}/clothesServlet?tp=downAdmin">下一页</a>
</div>
</body>
</html>
