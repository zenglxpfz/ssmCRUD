<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息</title>
<% pageContext.setAttribute("Path",request.getContextPath()); %>
<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
<link href="/ssmCRUD/static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet">
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1>SSMCRUD</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<button class="btn btn-primary">新增</button>
			<button class="btn btn-danger">删除</button>
		</div>
	</div>
	<div class="row">
	   <table class="table-hover">
	   	<tr>
	   		<th>员工号</th>
	   		<th>姓名</th>
	   		<th>性别</th>
	   		<th>邮箱</th>
	   		<th>所在部门</th>
	   	<th>操作</th>
	   	
	   	</tr>
	   	<c:forEach items="${pageInfo.getList()}" var="emps">
	   	<tr>
	   		<th>${emps.eId }</th>
	   		<th>${ emps.eName}</th>
	   		<th>${ emps.sex}</th>
	   		<th>${ emps.email}</th>
	   		<th>${ emps.department.deptName}</th>
	   		<th>
	   			<button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-pencil"></span>编辑</button>
				<button class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>删除</button>
	   		</th>
	   	
	   	</tr>
	   	</c:forEach>
	   </table>
	
	</div>
	
	<div class="row">
		<div class="col-md-2">当前为第${pageInfo.pageNum }页,总${pageInfo.pages }页,总${pageInfo.total}条</div>
		
		<!-- 分页条信息 -->
		<div class="col-md-5">
			<nav aria-label="Page navigation">
 				 <ul class="pagination">
 				
 				 	 <li><a href="/ssmCRUD/emp?pn=1">首页</a></li>
 				 	
 				 	 <!-- 判断如果有上一页就显示，默认为true -->
 				 <c:if test="${pageInfo.hasPreviousPage }">
   					 <li>
   					 <!-- 传过去的pn是要查询第几页，拿到该页的数据然后显示 -->
      					<a href="/ssmCRUD/emp?pn=${pageInfo.pageNum-1}" aria-label="Previous">
        					<span aria-hidden="true">&laquo;</span>
      					</a>
    				</li>
    			</c:if>
    				<!-- 拿到连续显示的页码，是一个数组,然后循环，在页面中显示，一页一页的页码 -->
    				<c:forEach items="${pageInfo.navigatepageNums }" var="page">
   					 <c:if test="${page==pageInfo.pageNum }">
   					 	 <li class="active"><a href="/ssmCRUD/emp?pn=${page}">${page}</a></li>
   					 </c:if>
   					 <c:if test="${page!=pageInfo.pageNum }">
   					 <li><a href="/ssmCRUD/emp?pn=${page}">${page}</a></li>
   					 </c:if>
    				
    				
   					 </c:forEach>
   					 <!-- 判断是否有下一页 ，为真就执行-->
   				<c:if test="${pageInfo.hasNextPage}">
    				<li>
     					 <a href="/ssmCRUD/emp?pn=${pageInfo.pageNum+1}" aria-label="Next">
       						 <span aria-hidden="true">&raquo;</span>
      					</a>
   					 </li>
   					 </c:if>
   					 
   					<!--  最后一页pages,总页数 -->
   					  <li><a href="/ssmCRUD/emp?pn=${pageInfo.pages }">末页</a></li>
  				</ul>
			</nav>
		</div>
	</div>
	
</div>

</body>
</html>