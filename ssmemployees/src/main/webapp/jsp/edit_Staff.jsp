<%--
  Created by IntelliJ IDEA.
  User: 11830
  Date: 2025/1/9
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加员工</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/fontsawesome/css/font-awesome.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div class="main_box">
    <div class="cont_box editpro_box">
        <form action="<%=request.getContextPath()%>/employee/updateEmployee.do" method="post" id="addstaff_form">
            <input type="hidden" name="id" value="${employee.id}">
            <ul class="addpro_box">
                <li>
                    <label>姓名：</label>
                    <input type="text" placeholder="请输员工姓名"
                           name="lastName" required data-rule-fullname="true"
                           data-msg-required="员工姓名不能为空" value="${employee.lastName}"/>
                </li>
                <li>
                    <label>邮箱：</label>
                    <input type="text" placeholder="请输入邮箱"
                           name="email" required data-rule-mobile="true" data-msg-required="邮箱不能为空" value="${employee.email}"/>
                </li>
                <li>
                    <label>性别：</label>
                    <div class="radio_box">
                        <c:if test="${employee.gender==0}">
                            <input type="radio" name="gender" value="0"
                                   required data-msg-required="性别不能为空" checked="checked"/>
                            <span>男</span>
                            <input type="radio" name="gender" value="1" />
                            <span>女</span>
                        </c:if>

                    </div>
                    <div class="radio_box">
                        <c:if test="${employee.gender==1}">
                            <input type="radio" name="gender" value="0"
                                   required data-msg-required="性别不能为空" />
                            <span>男</span>
                            <input type="radio" name="gender" value="1" checked="checked"/>
                            <span>女</span>
                        </c:if>
                    </div>
                </li>

                <li>
                    <label>在职状态</label>
                    <select name="jobId">
                        <c:if test="${employee.jobId==0}">
                        <option value="0" selected="selected">在职</option>
                        <option value="1">离职</option>
                        </c:if>
                        <c:if test="${employee.jobId==1}">
                        <option value="0" >在职</option>
                        <option value="1" selected="selected">离职</option>
                        </c:if>
                    </select>
                </li>
            </ul>
            <div class="probtn_box clearfix">
                <input type="submit" value="编辑" class="btn blue_btn"/>
            </div>
        </form>
    </div>
</div>
<!--javascript include-->
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/jquery.form.min.js"></script>
<script src="js/other.js"></script>
<script>
    $(function(){
        $("body").other({formId:"#addstaff_form",formUrl:"#"});//formUrl 表单请求地址
    });
</script>
</body>
</html>
