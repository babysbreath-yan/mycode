<%--
  Created by IntelliJ IDEA.
  User: 甜啵虎
  Date: 2024/1/14
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/orange.css">
    <title>支付</title>
    <style>
        *{
            margin: 0px;
            padding: 0px;
        }
        .top{
            width: 100%;
            height: 200px;
            background-color: darkorange;
            text-align: center;
        }
        .main{
            width: 100%;
            height: 1000px;
            text-align: center;
            background-color: lightskyblue;
        }
    </style>
</head>
<div class="top">
    <form action="flowerServlet?tp=likeQueryAdmin" method="post">
        <label><font size="10" text-align="center">谢谢您的选择，我们将为您提供最优质的快递服务</font></label>
    </form>
</div>
<div class="main" method="post">
    <form action="" >
        <font size="5" >收货人：</font><input type="text" name="name" size="20"><br>
        <font size="5" >收货地址：</font><input type="text" name="addre" size="20"><br>
        <font size="5" > 联系方式：</font><input type="text" name="phon" size="20"><br>
        <font size="5" > 支付方式：</font><br>
        <input type="radio" name="sex" size="10">微信支付<input type="radio" name="sex" size="10">支付宝支付&nbsp;
        <br>
        <br>
        <a href="erweima.jsp"class="orange-btn"><font size="5" >结算</font></a>
    </form>              
</div>

</body>
</html>