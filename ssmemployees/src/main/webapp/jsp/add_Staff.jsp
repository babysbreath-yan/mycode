<%--
  Created by IntelliJ IDEA.
  User: 11830
  Date: 2025/1/9
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
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
    <h2><span></span>添加员工</h2>
    <div class="cont_box">
        <form action="<%=request.getContextPath()%>/employee/addEmployee.do" method="post" id="addstaff_form">
            <ul class="addpro_box">
                <li>
                    <label>姓名：</label>
                    <input type="text" placeholder="请输员工姓名"
                           name="lastName" required data-rule-fullname="true" data-msg-required="员工姓名不能为空"/>
                </li>
                <li>
                    <label>邮箱：</label>
                    <input type="email" placeholder="请输入邮箱"
                           name="email" required data-rule-mobile="true" data-msg-required="邮箱不能为空"/>
                </li>
                <li>
                    <label>性别：</label>
                    <div class="radio_box">
                        <input type="radio" name="gender"  required data-msg-required="性别不能为空" value="0"/>
                        <span>男</span>
                    </div>
                    <div class="radio_box">
                        <input type="radio" name="gender"  checked="checked" value="1"/>
                        <span>女</span>
                    </div>
                </li>
                <li>
                    <label>是否在职：</label>
                    <select name="jobId">
                        <option value="0">在职</option>
                        <option value="1">离职</option>
                    </select>
                </li>
            </ul>
            <div class="probtn_box clearfix">
                <input type="submit" value="添加员工" class="btn blue_btn"/>
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



