<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% String path = request.getContextPath(); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HR医院 - 部门列表</title>
	<meta name="keywords" content="">
	<meta name="description" content="">

	<link rel="shortcut icon" href="favicon.ico">
	<link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

	<!-- Data Tables -->
	<link href="<%=path %>/css/plugins/dataTables/dataTables.bootstrap.css"
		rel="stylesheet">
	<link href="<%=path %>/css/animate.css" rel="stylesheet">
	<link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>部门列表</h5>
					</div>
					<div class="ibox-content">
						<div>
							<a href="<%=path %>/depservlet?state=toadd" class="btn btn-success">添加部门</a>
						</div>
						<table class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>序号</th>
									<th>部门号</th>
									<th>部门名称</th>
									<th>电话</th>
									<th>地址</th>
									<th width="100px">备注</th>
									<th>管理</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="m" varStatus="i">
								<tr class="gradeA">
									<td>${i.index + 1 }</td>
									<td>${m.department_number }</td>
									<td>${m.name }</td>
									<td>${m.telephone }</td>
									<td>${m.address }</td>
									<td>${m.notes }</td>
								    <td><a href="<%=path %>/depservlet?state=update&id=${m.id}" class="btn btn-primary">修改</a>&nbsp;&nbsp;
										<a onclick="del(${m.id})" class="btn btn-danger delete">删除</a>
									  </td>
								</tr>
							 </c:forEach>
							<%-- <%
								Page<Department> pe=(Page<Department>)request.getAttribute("page");
	                            if(null != pe && null != pe.getRecords() && pe.getRecords().size()>0){
	                            	List<Department> list = pe.getRecords();
	                            	int index=1;
	                            	for(Department department : list){
                            %>
								<tr class="gradeA">
									<td><%=index++ %></td>
									<td><%=department.getDepartmentNumber() %></td>
									<td><%=department.getName() %></td>
									<td><%=department.getTelephone() %></td>
									<td><%=department.getAddress() %></td>
									<td><%=department.getNotes() %></td>
									<td><a href="<%=path %>/department/<%=department.getId() %>/toUpdate.do" class="btn btn-primary">修改</a>&nbsp;&nbsp;
										<a href="<%=path %>/department/<%=department.getId() %>/delete.do" class="btn btn-danger">删除</a></td>
								</tr>
							<%
                            		}
                           		 }
                             %> --%>
							</tbody>
						</table>
						<div>
							<span style="float: left; padding: 5px">
								当前&nbsp;<span style="color: red;">${pe.pageIndex }</span>&nbsp;/&nbsp;<b>${pe.pageCount }</b>&nbsp;页&nbsp;&nbsp;
								总共&nbsp;<b>${pe.dataCount }</b>&nbsp;条</span>
							<nav aria-label="Page navigation" style="margin: 0 auto; width: 320px">
								<ul class="pagination" style="margin: 0;">
									<c:if test="${pe.pageIndex!=1 }">
						
											<li><a href="<%=path%>/depservlet?state=findallbypage&pageIndex=1" aria-label="Previous"> <span aria-hidden="true">首页</span></a></li>
											<li><a href="<%=path%>/depservlet?state=findallbypage&pageIndex=${pe.pageIndex-1 }" aria-label="Previous"> <span aria-hidden="true">前一页</span></a></li>	
									</c:if>
									<c:forEach begin="1" end="${pe.pageCount }" var="i">
										
											<li><a href="<%=path%>/depservlet?state=findallbypage&pageIndex=${i }" ${i==pe.pageIndex?"style=\"color:#ff2200\";":""} class="a">${i }</a></li>
										
									</c:forEach>
									<c:if test="${pe.pageIndex!=pe.pageCount&&pe.pageCount!=0 }">
											<li><a href="<%=path%>/depservlet?state=findallbypage&pageIndex=${pe.pageIndex+1 }" aria-label="Next"> <span aria-hidden="true">后一页</span></a></li>
											<li><a href="<%=path%>/depservlet?state=findallbypage&pageIndex=${pe.pageCount }" aria-label="Next"> <span aria-hidden="true">尾页</span></a></li>
									</c:if>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 全局js -->
	<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="<%=path %>/js/plugins/jeditable/jquery.jeditable.js"></script>

	<!-- Data Tables -->
	<script src="<%=path %>/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="<%=path %>/js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<!-- 自定义js -->
	<script src="<%=path %>/js/content.js?v=1.0.0"></script>
<script type="text/javascript">
	
	function del(id){
		parent.layer.confirm('确认删除？', {
		    btn: ['确认','取消'], //按钮
		    shade: false //不显示遮罩
		}, function(){
		    parent.layer.msg('删除成功！', {icon: 1});
		    location.href="./"+"/depservlet?state=delete&id="+id;
		});
	}
	</script>
</body>
</html>
