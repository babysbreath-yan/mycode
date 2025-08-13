<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">

	<title>邻家汽服后台管理管理</title>
	<%--<%=request.getContextPath()%>--%>
	<link type="text/css" rel="stylesheet" href="fontsawesome/css/font-awesome.css"/>
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div class="header">
	<div class="logo">
		<a href="jsp/staff_Achievement.jsp"><img src="images/logo.png"/></a>
	</div>
	<div class="nav">
		<ul class="clearfix">
			<li>
				<i class="fa fa-users font_lager"></i>
				<p data-id="staff">员工管理</p>
			</li>
		</ul>
	</div>
	<div class="nav_roll f_left" style="display:none;">
		<div class="f_left">
			<i class="fa fa-caret-left fa-1x"></i>
		</div>
		<div class="f_right">
			<i class="fa fa-caret-right fa-1x"></i>
		</div>
	</div>
	<ul class="login_msg">

	</ul>
</div>
<!--top end-->
<div class="main_left">
	<h2><i class="menu_icon fa fa-reorder"></i></h2>
	<ul class="menu">
		<!--员工管理-->
		<li>
			<i class="menu_icon fa fa-users"></i>
			<a href="javascript:void(0);" data-id="staff" data-href="employee/getEmployeesByPage.do">员工列表</a>
		</li>
		<li>
			<i class="menu_icon fa fa-plus-square"></i>
			<a href="javascript:void(0);" data-id="staff" data-href="employee/getAddPage.do">添加员工</a>
		</li>
	</ul>
</div>
<!--left end-->
<div class="main_right">
	<iframe src="hello.jsp" name="cont_box" frameborder="0" width="100%" height="100%" seamless></iframe>
</div>
<!--desktop end-->
<!--javascript include-->
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/tipSuppliers.js"></script>
<script>
	$("iframe[name='cont_box']").on("load",function(){
		$(".loading").hide();
		setTimeout(function(){$("iframe[name='cont_box']").css("opacity","1");},500);
	});
	$(function(){
		$(".loading").hide();
		setTimeout(function(){$("iframe[name='cont_box']").css("opacity","1");},500);
		$(".nav li:first").trigger("click");
	});
	jQuery("body").jrdek({Mtop:".header",Mleft:".main_left",Mright:".main_right",foldCell:".main_left h2"});
	$(".logo").click(function(){
		$("iframe[name='cont_box']").prop("src","hello.jsp");
	});
</script>
</body>
</html>
