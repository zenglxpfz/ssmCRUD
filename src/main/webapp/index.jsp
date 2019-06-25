<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息</title>
<% pageContext.setAttribute("Path",request.getContextPath()); %>
<script src="static/js/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<link href="/ssmCRUD/static/bootstrap-3.3.7-dist/css/bootstrap-theme.css" rel="stylesheet">
<link href="/ssmCRUD/static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="/ssmCRUD/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="/ssmCRUD/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script  src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


</head>
<body>

	<!-- 员工新增模态框 -->
<div class="modal fade" id="emp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加员工</h4>
      </div>
      <div class="modal-body">
      
      <!-- 新增表单 -->
      <form class="form-horizontal" onsubmit="return false">
  			<div class="form-group">
    				<label for="inputeName" name="eName" class="col-sm-2 control-label">姓名</label>
    			<div class="col-sm-10">
     				 <input type="text" name="eName" class="form-control" id="emp_add_eName" placeholder="请输入姓名">
    			<!-- 校验信息span -->
    			<span class="help-block"></span>
    			
    			</div>
  			</div>
  			
  			
  			<div class="form-group">
  					<label class="col-sm-2 control-label">性别</label>
  			 	<div class="col-sm-10">
  					<label class="radio-inline">
         				<input type="radio" name="sex" id="emp_add_sex1" value="男" checked="checked"> 男
           			</label>
           			<label class="radio-inline">
         				<input type="radio" name="sex" id="emp_add_sex2" value="女"> 女
          			</label>
				</div>
	   		</div>

  			
  			<div class="form-group">
    			<label for="inputemail" class="col-sm-2 control-label">邮箱</label>
   			 <div class="col-sm-10">
      			<input name="email" type="text" class="form-control" id="emp_add_email" placeholder="email@qq.com">
   			 	<span class="help-block"></span>
   			 
   			 </div>
  			</div>
  			
  			<div class="form-group">
    			<label class="col-sm-2 control-label">部门</label>
   	 		 <div class="col-sm-4">
   	 			 <!--  添加部门id就行 -->
   	 			
      			<select class="form-control" name="dId" >
  				
					</select>
   			 </div>
  			</div>
  			
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>

<!-- 员工修改模态框 -->
<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">员工修改</h4>
      </div>
      <div class="modal-body">
      
      <!-- 新增表单 -->
      <form class="form-horizontal" onsubmit="return false">
  			<div class="form-group">
    				<label for="inputeName" name="eName" class="col-sm-2 control-label">姓名</label>
    			<div class="col-sm-10">
     				 <p class="form-control-static" id="eName_update_static"></p>

    			</div>
  			</div>
  			
  			
  			<div class="form-group">
  					<label class="col-sm-2 control-label">性别</label>
  			 	<div class="col-sm-10">
  					<label class="radio-inline">
         				<input type="radio" name="sex" id="emp_update_sex1" value="男" checked="checked"> 男
           			</label>
           			<label class="radio-inline">
         				<input type="radio" name="sex" id="emp_update_sex2" value="女"> 女
          			</label>
				</div>
	   		</div>

  			
  			<div class="form-group">
    			<label for="inputemail" class="col-sm-2 control-label">邮箱</label>
   			 <div class="col-sm-10">
      			<input name="email" type="text" class="form-control" id="emp_update_email" placeholder="email@qq.com">
   			 	<span class="help-block"></span>
   			 
   			 </div>
  			</div>
  			
  			<div class="form-group">
    			<label class="col-sm-2 control-label">部门</label>
   	 		 <div class="col-sm-4">
   	 			 <!--  添加部门id就行 -->
   	 			
      			<select class="form-control" name="dId" >
  				
					</select>
   			 </div>
  			</div>
  			
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
      </div>
    </div>
  </div>
</div>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1>SSMCRUD</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-8">
			<button class="btn btn-primary" type="button" id="emp_add_modal_btn">新增</button>
			<button class="btn btn-danger" id="emp_delete_all">删除</button>
		</div>
	</div>
	<div class="col-md-12">
	   <table class="table table-hover" id="emps_table">
	   	<thead>
	   	<tr>
	   	<th><input type="checkbox" id="check_all"/></th>
	   		<th>员工号</th>
	   		<th>姓名</th>
	   		<th>性别</th>
	   		<th>邮箱</th>
	   		<th>所在部门</th>
	   	<th>操作</th>
	   	
	   	</tr>
	   </thead>
	   <tbody>
	   
	   </tbody>
	   </table>
	
	</div>
	
	<div class="row">
	<!-- 显示的信息 -->
		<div class="col-md-6" id="info"></div>
		
		<!-- 分页条信息 -->
		<div class="col-md-6" id="page_info">
			
		</div>
	</div>
	
</div>



<script type="text/javascript">

//定义变量最后一页，和当前页
var empage;
var prpage;
	$(function(){
	
		//去首页
		to_page(1);
		
		
			});
	
	function to_page(pn){
		
		$.ajax({
			//发送请求的地址
			url:"/ssmCRUD/emps",
			data:"pn="+pn,//发送请求的携带数据
		    type:"GET",
		    //data是接收服务器发过来 的数据的变量，为json形式{key：value}
		    success:function(result){
		    	//
		    	//1.解析接收到的员工数据
		    	//2.解析并显示分页的信息
		    	build_emps_table(result);//调用函数，解析拿到的数据
		    	//3.显示第几页、
		    	build_page_info(result);
		    	
		    	//4.分页条数据2
		    	build_page_nav(result);
		    	
		    }
		
		});
		
	}
			
	
	function build_emps_table(result){//函数为解析json数据
		//刷新数据前先清空表中的内容
		$("#emps_table tbody").empty();
		
		var emps=result.extend.pageInfo.list;//拿到mag类中的属性extend然后调用里面的对象pageInfo然后再调用list，拿到员工数据
		
		$.each(emps,function(index,item){//循环遍历该变量，一行一行拿到数据，item为临时变量
		var checkboxTd=$("<td><input type='checkbox' class='check_item'/></td>")
		var empIdTd=$("<td></td>").append(item.eId)//定义变量存单元格和内容
		var empNameTd=$("<td></td>").append(item.eName)
		var sexTd=$("<td></td>").append(item.sex)
		var emailTd=$("<td></td>").append(item.email)
		var deptNameTd=$("<td></td>").append(item.department.deptName)
			
		var editBtn=$("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
		.append($("<span></span>")
				.addClass("glyphicon glyphicon-pencil")).append("编辑");
		//添加编辑属性并赋值员工id
		editBtn.attr("edit-id",item.eId);
			
		var delBtn=$("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append($("<span></span>")
				.addClass("glyphicon glyphicon-trash")).append("删除");
		//添加删除属性并赋值id
		delBtn.attr("delete-id",item.eId);
		var btnTd=$("<td></td>").append(editBtn).append(delBtn);
		$("<tr></tr>").append(checkboxTd)
		.append(empIdTd)//一行添加的内容追加
		.append(empNameTd)
		.append(sexTd)
		.append(emailTd)
		.append(deptNameTd)
		.append(btnTd)
		.appendTo("#emps_table tbody");
		//把单元格放到行里面，append方法执行完成后还是返回原来的元素
																		//然后说明放在哪个位置，appendTo（“”）
			
		});
	}
	
	
	function build_page_info(result){
		$("#info").empty();
		//info
		//添加内容到div里面去
			$("#info").append("当前第"+result.extend.pageInfo.pageNum+"页，总"+result.extend.pageInfo.pages+"页，总"+result.extend.pageInfo.total+"条数据")
			
		empage=result.extend.pageInfo.total;
		prpage=result.extend.pageInfo.pageNum;
		
	}
	
	//显示分页条，并且可以点击
	function build_page_nav(result){
		$("#page_info").empty();
		//page_info
		var ul=$("<ul></ul>").addClass("pagination")
		
		//构建元素
			var firstPageli=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var perPageli=$("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
			
			//判断是否为第一页，是就不能点击首页和上一页
			if(result.extend.pageInfo.hasPreviousPage==false){
				firstPageli.addClass("disabled")
				perPageli.addClass("disabled")
			}else{
			//添加点击事件首页
			firstPageli.click(function(){
				
				to_page(1);
				
			})
			//上一页
			perPageli.click(function(){
				
				to_page(result.extend.pageInfo.pageNum-1);
				
			})
			}
			var nextPageli=$("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
			var lastPageli=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
		 
			//判断是否为最后一页，是就不能点击末页和下一页,否则就添加单击事件
			if(result.extend.pageInfo.hasNextPage==false){
				nextPageli.addClass("disabled");
				lastPageli.addClass("disabled");
			}
			else{
			//点击事件下一页和最后一页
	
			nextPageli.click(function(){
				
				to_page(result.extend.pageInfo.pageNum+1);
				
			})
			//最后一页
			lastPageli.click(function(){
				
				to_page(result.extend.pageInfo.pages);
				
			})
			}
			
			ul.append(firstPageli).append(perPageli)
		//遍历页码号12345
		 $.each(result.extend.pageInfo.navigatepageNums,function(index,item){
			 
			 
			 var numli=$("<li></li>").append($("<a></a>").append(item).attr("href","#"));
			 if(result.extend.pageInfo.pageNum==item){
				 
				 numli.addClass("active");
			 }
			 numli.click(function(){
				to_page(item); 
			 })
			 ul.append(numli);
			 
		 });
		 ul.append(nextPageli).append(lastPageli);
		 var navEle=$("<nav></nav>").append(ul)
		 navEle.appendTo("#page_info")
		
		
	}
		
	//清空表单内容 数据和样式都要重置
	function reset_form(ele){
		$(ele)[0].reset();
		//q清空样式
		$(ele).find("*").removeClass("has-error has-success");
		//找到信息提示框，清空
		$(ele).find(".help-block").text("");
		
	}
	
	//新增的点击事件
	$("#emp_add_modal_btn").click(function(){
		
		//清空表单内容 数据和样式都要重置
		reset_form("#emp form");
   		//$("#emp form")[0].reset(); 			
		//显示下拉框数据
		
		getDept("#emp select");
		
		//弹出模态框
		$("#emp").modal(
				{
					
					backdrop:"static"
				});
	});
	
   	function getDept(ele){
   			//清空下拉列表信息
   			$(ele).empty();
   		
   		 	$.ajax({
   		 
			url:"/ssmCRUD/depts",
			
		    type:"post",
		    //发送post请求
		     //接收控制器那边返回的数据		 
		    success:function(data){	
		    	//console.log(data);
			//alert(data[].deptName)
			//{"code":100,"msg":"处理成功！","extend":{"depts":[{"deptId":1,"deptName":"开发部"},{"deptId":2,"deptName":"测试部"}]}}
			 //{"code":100,"mag":"处理成功！"，"extend":{"depts":[{"deptId":1}]}}
			 //显示部门信息在下拉框列表中,遍历部门信息
			 var x=0;
			$.each(data.extend.depts,function(){				
				//用this代表当前吧，function中就没有变量,//列表中拿数据要带变量x【1,2,3】这些
				var le =$("<option></option>").append(data.extend.depts[x].deptName).attr("value",data.extend.depts[x].deptId);
				//整个模态框的id中的select				
				le.appendTo(ele) 
				x=x+1;
			}); 
		}
		 })
   		
   	}
	
   	//校验表单数据 属于前端校验
   	 function validate_add_form(){
   		//1.拿到要校验的数据
   		var empName=$("#emp_add_eName").val();
   		var regName=/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
   		if(!regName.test(empName)){
   			//alert("用户名可以是2-5位中文或者6-16位英文和数字组合")
   			
   			//校验是否符合要求，框架的要求
   			
   			/* Bootstrap 对表单控件的校验状态，如 error、warning 和 success 状态，
   			都定义了样式。使用时，添加 .has-warning、.has-error 或 .has-success 类到这些控件的父元素即可
   			。任何包含在此元素之内的 .control-label、
   			.form-control 和 .help-block 元素都将接受这些校验状态的样式。 */
   			
   			//统一封装函数
   			show_validate_msg("#emp_add_eName", "error","用户名必须是2-5位中文或者6-16位英文和数字组合")
   			//$("#emp_add_eName").parent().addClass("has-error");
   			//$("#emp_add_eName").next("span").text("用户名可以是2-5位中文或者6-16位英文和数字组合");
   			return false;
   		}else {
   			
   			show_validate_msg("#emp_add_eName", "success","")
   			
   			//$("#emp_add_eName").parent().addClass("has-success");
   			//$("#emp_add_eName").next("span").text("");
   			
   		}	
   		//2.校验邮箱
   		var email=$("#emp_add_email").val();
   		var regemail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
   		if(!regemail.test(email)){
   			//alert("邮箱格式不正确");
   			//$("#emp_add_email").parent().addClass("has-error");
   			//$("#emp_add_email").next("span").text("邮箱格式不正确");
   			show_validate_msg("#emp_add_email", "error", "邮箱格式不正确")
   			return false;
   		}else {
   			//$("#emp_add_email").parent().addClass("has-success");
   			//$("#emp_add_email").next("span").text("");
   			show_validate_msg("#emp_add_email", "success", "")
   			
   		}
   		
   		return true;
   	}
   	
   	//这个函数 是为了校验信息的统一封装，status是传递过来的状态信息，msg为提示显示信息,ele为判断哪个输入框的id
   	function show_validate_msg(ele,status,msg){
   		//在显示函数之前清空状态
   		$(ele).parent().removeClass("has-success has-error")
   		$(ele).next("span").text("");
   		
   		if("succsee"==status){
   		//校验成功显示内容
   		$(ele).parent().addClass("has-success");
   		$(ele).next("span").text(msg);
   			
   		}else if("error"==status)
   			//失败后显示内容
   		$(ele).parent().addClass("has-error");
   		$(ele).next("span").text(msg);
   			
   	}
   	
   	//在保存之前进行用户名是否可以用校验，文本框改变时发生
   	
   	$("#emp_add_eName").change(function(){
   		var eName=this.value;
   		//发送ajax请求数据库校验是否存在了用户名
   		$.ajax({
   			url:"/ssmCRUD/checkuser",
   			//发送的数据
   			data:"eName="+eName,
   			type:"post",
   			success:function(result){
   				//通过控制器传过来的状态码code（都封装在Mag这个类中了）来判断是哪个提示校验信息
   				
   				if(result.code==100){
   					show_validate_msg("#emp_add_eName", "success","用户名可用")
   					
   					//给保存按钮加属性，进行判断能否提交
   					$("#emp_save_btn").attr("ajax_va","success")
   				}else{
   					show_validate_msg("#emp_add_eName", "error",result.extend.va_mag)
   					//给保存按钮加属性，进行判断能否提交
   					$("#emp_save_btn").attr("ajax_va","error")
   				}
   				
   			}
   		})
   		
   	})
   	
   	//点击保存，产生函数事件
   	$("#emp_save_btn").click(function(){
   		
   	//1.模态框中填写的表单数据交给服务器进行保存
   	
   	//1.1先进行表单数据校验
    	if(!validate_add_form()){
   		return false;		
   	}  
   	
   	//1.2判断之前的ajax用户名校验是否成功，如果成功、失败就false不继续进行,属性是【保存】按钮的value值emp_save_btn
    if($("#emp_save_btn").attr("ajax_va")=="error"){
   		return false;
   	} 
   	
   	//2.发送Ajax请求保存员工，
   //	alert($("#emp form").serialize())
    	$.ajax({   	
   		url:"/ssmCRUD/emp",
   		type:"POST",
   		//表单的数据通过serialize来序列化，为键名：值，形式提取出来，提交给控制器那边使用,属性名和数据库那边的名一样，自动封装好类属性的值，然后添加到数据库中	
   		data:$("#emp form").serialize(),
   		
   		 success:function(result){
   			//进行结果 的判断，因为控制器那边已经处理了结果，不一样的结果信息
   			//成功
   			if(result.code==100){
   			
   			//1.关闭模态框
   			$("#emp").modal('hide');
   			//2.来到最后一页，因为之前处理了如果大于总页数会显示最后一页，所以跳转最后一页即可
   			to_page(empage);
   			
   			//alert(result.mag);
   			 }
   			else{
   				alert(result.extend.errorFields.email)
   				//显示失败信息
   				if(undefined !=result.extend.errorFields.email){
   					//显示邮箱错误信息result.extend.errorFields.email这里面就是信息
   					
   					show_validate_msg("#emp_add_email", "error", result.extend.errorFields.email)
   				}
   				if(undefined !=result.extend.errorFields.eName){
   					//显示用户名错误信息
   					show_validate_msg("#emp_add_eName", "error",result.extend.errorFields.eName)
   					
   				}
   				
   			}
   		}  
   		
 }) 
  		
   	})  
   	
   	//1.编辑事件
   	//1.我们是按钮创建之前就绑定了click，所以办不上
   	//可以在按钮创建的时候绑定，2.绑定点击事件.live(),后来加的也能绑上
   	//jQuery没有.live()，用on代替，（document）
   	$(document).on("click",".edit_btn",function(){
   		
   		//2.查出部门信息，显示部门信息,调用方法传入表单id
   		getDept("#update select")
   		
   	//1.查出员工信息,显示员工信息,传入id查询
   	    getemp($(this).attr("edit-id"));
   		
   		//传递员工id给更新按钮
   		$("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"))
   		//弹出模态框
   		$("#update").modal({
   			backdrop:"static"
   		})
   	})
  function getemp(id){
   		$.ajax({
   			url:"/ssmCRUD/emp/"+id,
   			type:"get",
   			success:function(result){
   				var empData=result.extend.Emp;
   				//给当前表单附上值
   				$("#eName_update_static").text(empData.eName)
   				$("#emp_update_email").val(empData.email)
   				//选中该标签，然后修改里面的val值
   				$("#update input[name=sex]").val([empData.sex]);
   				$("#update select").val([empData.dId])
   			}
   		
   		})
   		
   	}
   	
   	//点击更新按钮，进行信息更新函数
   	$("#emp_update_btn").click(function(){
   	//2.校验邮箱
   		var email=$("#emp_update_email").val();
   		var regemail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
   		if(!regemail.test(email)){
   			//alert("邮箱格式不正确");
   			//$("#emp_add_email").parent().addClass("has-error");
   			//$("#emp_add_email").next("span").text("邮箱格式不正确");
   			show_validate_msg("#emp_update_email", "error", "邮箱格式不正确")
   			return false;
   		}else {
   			//$("#emp_add_email").parent().addClass("has-success");
   			//$("#emp_add_email").next("span").text("");
   			show_validate_msg("#emp_update_email", "success", "")
   		}
   		$.ajax({
   			url:"/ssmCRUD/emp/"+$(this).attr("edit-id"),
   			//data:$("#update form").serialize()+"&_method=PUT",
   			
   			//type:"post",
   			data:$("#update form").serialize(),
   			type:"PUT",
   			success:function(result){
   				//1.更新完后关闭模态框
   				$("#update").modal("hide")
   				//2.来到本页面
   				to_page(prpage);
   			}
   		})
   			
   		
   		
   	})
   		
   	//根据id删除员工信息
   	$(document).on("click",".delete_btn",function(){
   		
   		//1.弹出确认删除框
   		var eName=$(this).parents("tr").find("td:eq(2)").text()
   	 var delid=$(this).attr("delete-id")
   		//alert($(this).parents("tr").find("td:eq(1)").text())	
   	if(confirm("确认删除"+eName+"吗？")){
   		
   		$.ajax({
   			url:"/ssmCRUD/empem/"+delid,       
   			type:"DELETE",
   			success:function(result){
   			alert(result.msg)
   				//2.回到本页面
   				to_page(prpage);
   			}
   			
   		})
   		
   	}
   	})
   	
   	//完成全选
   	$("#check_all").click(function(){
   		//原生属性用prop来获取和修改值，自定义的属性用attr来设置
   		//alert($(this).prop("checked")),选中时checked的值为true
   		$(".check_item").prop("checked",$(this).prop("checked"))
   		
   	})
   	
   	//check_item,条数决定全部
   		$(document).on("click",".check_item",function(){
   		//判断当前选中的元素是否为五个
   		var fal=$(".check_item:checked").length==$(".check_item").length;
   		//如果全选就fal就是true，否是false，所以，可以直接更改目录中的框的值
   		
   			$("#check_all").prop("checked",fal)
   		})
   	//全部删除事件
   	$("#emp_delete_all").click(function(){
   		var eNames=""
   		var del_idstr=""
   		$.each($(".check_item:checked"),function(){
   			//this遍历复选框的属性，，拿到这一行的名字,拼接名字
   			eNames+=$(this).parents("tr").find("td:eq(2)").text()+","
   			del_idstr+=$(this).parents("tr").find("td:eq(1)").text()+"-"
   		})
   		//去除多余的逗号
   		eNames=eNames.substring(0,eNames.length-1);
   		del_idstr=del_idstr.substring(0,del_idstr.length-1);
   		if(confirm("确认删除"+eNames+"吗？")){
   	   		
   			//发送ajax请求删除
   	   		$.ajax({
   	   			url:"/ssmCRUD/empem/"+del_idstr,       
   	   			type:"DELETE",
   	   			success:function(result){
   	   			alert(result.msg)
   	   				//2.回到本页面
   	   				to_page(prpage);
   	   			}
   	   			
   	   		})
   	   		
   	   	}
   	})
   		
</script>

</body>

</html>