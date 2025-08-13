<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2024/1/14
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="userServlet?tp=addUser" method="post">
    <label>用户ID</label>
    <input type="text" name="userId"/><br>
    <label>用户名称</label>
    <input type="text" name="userName"/><br>

    <label>用户密码</label>
    <input type="password" name="userpassword"/><br>
    <label>用户类型</label>

    <input type="submit" value="添加用户"/>
    <input type="reset"/>
</form>
</body>
</html>
