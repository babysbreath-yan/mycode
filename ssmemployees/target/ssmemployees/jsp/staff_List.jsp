<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工列表</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/fontsawesome/css/font-awesome.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div class="main_box">
    <h2><span></span>员工列表</h2>
    <div class="cont_box">
        <form action="<%=request.getContextPath()%>/employee/deleteEmployees.do" method="post" id="staff_form">
            <div class="search_formbox clearfix">
                <a type="button" id="job" class="btn blue_btn curr" href="<%=request.getContextPath()%>/employee/getEmployeesByPage.do">
                    全部员工</a>
                <a type="button" id="quit" class="btn blue_btn" href="<%=request.getContextPath()%>/employee/getEmployeesByJob.do?jobId=0">
                    在职员工</a>
                <a type="button" id="all" class="btn blue_btn" href="<%=request.getContextPath()%>/employee/getEmployeesByJob.do?jobId=1">
                    离职员工</a>
                <input type="submit" id="del" class="btn blue_btn" value="批量删除"></input>
            </div>
            <table border="0" cellspacing="0" cellpadding="0" class="table" id="table_box">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>邮箱</th>
                    <th>性别</th>
                    <th>在职状态</th>
                    <th width="268">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${pageInfo!=null}">
                    <c:forEach var="emp" items="${pageInfo.list}">
                        <tr id="1"><!--此处id为进行编辑或查看时该条数据的唯一标识-->
                            <td>${emp.id}</td>
                            <td>${emp.lastName}</td>
                            <td>${emp.email}</td>
                            <td>
                                <c:if test="${emp.gender==1}">
                                    女
                                </c:if>
                                <c:if test="${emp.gender==0}">
                                    男
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${emp.jobId==0}">
                                    在职
                                </c:if>
                                <c:if test="${emp.jobId==1}">
                                    离职
                                </c:if>
                            </td>
                            <td>
                                <a href="<%=request.getContextPath()%>/employee/getEmployeeUpdateByPage.do?id=${emp.id}" class="table_btn table_edit edit_btn">
                                    <i class="fa fa-edit"></i>
                                    <span>编辑</span>
                                </a>
                                <a href="<%=request.getContextPath()%>/employee/deleteEmployee.do?id=${emp.id}" class="table_btn table_info see_btn">
                                    <i class="fa fa-eye"></i>
                                    <span>删除</span>
                                </a>
                                <input type="checkbox" name="id" value="${emp.id}" >
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${pageInfo==null}">
                    <c:forEach var="emp" items="${employeesByJob}">
                        <tr id="1"><!--此处id为进行编辑或查看时该条数据的唯一标识-->
                            <td>${emp.id}</td>
                            <td>${emp.lastName}</td>
                            <td>${emp.email}</td>
                            <td>
                                <c:if test="${emp.gender==1}">
                                    女
                                </c:if>
                                <c:if test="${emp.gender==0}">
                                    男
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${emp.jobId==0}">
                                    在职
                                </c:if>
                                <c:if test="${emp.jobId==1}">
                                    离职
                                </c:if>
                            </td>
                            <td>
                                <a href="employee/getAddPage.do" class="table_btn table_edit edit_btn">
                                    <i class="fa fa-edit"></i>
                                    <span>编辑</span>
                                </a>
                                <a href="javascript:void(0);" class="table_btn table_info see_btn">
                                    <i class="fa fa-eye"></i>
                                    <span>删除</span>
                                </a>
                                <input type="checkbox" name="id" value="${emp.id}">
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            <c:if test="${pageInfo!=null}">
                <ul style="margin-top: 30px;margin-left: 350px" class="pagination pagination-sm">
                    <li>
                        <a href="<%=request.getContextPath()%>/employee/getEmployeesByPage.do?pageNum=1">首页</a>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <a href="<%=request.getContextPath()%>/employee/getEmployeesByPage.do?pageNum=${pageInfo.prePage}">
                                上一页
                            </a>
                        </c:if>
                        <c:forEach var="pageNo" items="${pageInfo.navigatepageNums}">
                            <c:if test="${pageInfo.size/pageSize==0}">
                                <a href="<%=request.getContextPath()%>/employee/getEmployeesByPage.do?pageNum=${pageNo}
										&&pageSize=${pageInfo.pageSize}">
                                        ${pageNo}
                                </a>
                            </c:if>
                            <c:if test="${pageInfo.size/pageSize!=0}">
                                <a href="<%=request.getContextPath()%>/employee/getEmployeesByPage.do?
										pageNum=${pageNo}&&pageSize=${pageInfo.pageSize}">
                                        ${pageNo}
                                </a>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pageInfo.hasNextPage}">
                            <a href="<%=request.getContextPath()%>/employee/getEmployeesByPage.do?pageNum=${pageInfo.nextPage}">
                                下一页
                            </a>
                        </c:if>
                        <a href="<%=request.getContextPath()%>/employee/getEmployeesByPage.do?pageNum=${pageInfo.pages}">末页</a>
                    </li>
                </ul>
            </c:if>
        </form>
    </div>
</div>
<!--javascript include-->
<script src="js/jquery-2.2.1.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/other.js"></script>
<script>
    $(function(){
        $("body").other({tableId:"#table_box",tableWrap:[1,7],tableAas:[ 0,"desc"],tableSearch:true});
        $("body").tipWindow({method:"edit",type:"form",Class:".edit_btn",even:"click",tipTit:"编辑员工信息",Twidth:"700",Theight:"460",editUrl:"edit_Staff.html"});//editUrl 编辑员工信息请求地址
        $("body").tipWindow({method:"edit",type:"form",Class:".see_btn",even:"click",tipTit:"员工业绩",Twidth:"998",Theight:"600",editUrl:"staff_Achievement.html"});//editUrl 员工业绩请求地址
        //员工筛选
        $(".search_formbox .btn").click(function(){
            var dataId = $(this).prop("id"),//员工状态id
                that = $(this);
            $.ajax({
                type:"post",
                url:"#",
                data:{"id":dataId},
                success:function(data){
                    that.addClass("curr").siblings().removeClass("curr");
                }
            });
        });
    });
</script>
</body>
</html>
