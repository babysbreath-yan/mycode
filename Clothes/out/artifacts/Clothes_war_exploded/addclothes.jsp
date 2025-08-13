
<%--
  Created by IntelliJ IDEA.
  User: 甜啵虎
  Date: 2024/1/13
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="clothesServlet?tp=addclothes" method="post">
    <label>衣服名称</label>
    <input type="text" name="clothesName"/><br>
    <label>衣服图片</label>
    <input type="file" name="clothesPct"/><br>
    <label>衣服介绍</label>
    <textarea rows="5" cols="10" name="clothesCount"></textarea><br>
    <label>衣服价格</label>
    <input type="number" name="price"/><br>
    <label>类型</label>
    <select name="type">
        <option value="A">热卖商品</option>
        <option value="B">新品</option>
        <option value="C">其它</option>
    </select>
    <br>
    <label>衣服库存</label>
    <input type="number" name="clothesNum"/><br>
    <label>状态</label>
    <select name="stata">
        <option value="1">上架</option>
        <option value="0">下架</option>
    </select><br>
    <input type="submit" value="添加商品"/>
    <input type="reset"/>
</form>
</body>
</html>