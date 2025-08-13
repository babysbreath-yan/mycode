<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 甜啵虎
  Date: 2024/1/13
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买衣服</title>
    <script>
        function jisu(f){
            var inp=document.getElementById("num");
            if(f=="+"){

                if((inp.value-0)<10){
                    inp.value=inp.value-0+1;
                }
            }
            if(f=="-"){
                if(inp.value-0>1){
                    inp.value=inp.value-0-1;
                }
            }
        }
    </script>
</head>
<body>
<a href="index.jsp">返回首页</a>
<form action="clothesServlet?tp=addOlder&clothesId=${clothes.clothesId}" method="post">
    <img src="${clothes.clothesPct}"/><br>
    <p>${clothes.clothesName}</p>
    <p style="color: red;">价格：${clothes.price}</p>
    <p></p>
    <p><input type="button" onclick="jisu('-')" value="-"/>
        <input type="text" id="num" style="width:20px;" name="num" value="1"/>
        <input type="button" onclick="jisu('+')" value="+"/>
    </p>
    <c:if test="${gmStr!=null}">
        <label style="color: green">${gmStr}</label>
    </c:if>
    <br>
    <input type="submit" value="立即购买"/>
</form>
</body>
</html>