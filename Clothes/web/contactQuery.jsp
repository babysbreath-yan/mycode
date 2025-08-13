<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 甜啵虎
  Date: 2024/1/14
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Messages</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 40px;
            font-size: 16px;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f9f9f9;
        }

        thead {
            background-color: #f5f5f5;
        }

        a {
            text-decoration: none;
            color: #333;
        }

        a:hover {
            color: #555;
        }

        form {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="number"],
        input[type="text"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 4px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            margin-bottom: 20px;
        }

        button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>User Messages</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>User ID</th>
        <th>Message</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.messages}" var="message">
        <tr>
            <td>${message.id}</td>
            <td>${message.userId}</td>
            <td>${message.message}</td>
            <td>
                <a href="<c:url value='/message/delete'/>?id=${message.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
