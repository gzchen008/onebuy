<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 头部 -->
<%@ include file="include/head.jsp"%>
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>投诉问题列表</h2>
		<ol class="breadcrumb">
			<li><a href="#">系统管理</a></li>
			<li><a>功能设置</a></li>
			<li><strong>投诉问题设置</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 主内容 -->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-11">
			<form class="form-horizontal">
				<div class="form-group">
					<label class="control-label">角色</label> <select
						class="form-control" name="ctId" onchange="changeTitles();">
						<c:forEach items="${caseTypeInfos }" var="caseType">
							<option value="${caseType.id }">${caseType.name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label class="control-label">添加一条</label>
					<div class="input-group">
						<input type="text" name="name" class="form-control"> <span
							class="input-group-btn"><button type="button"
								class="btn btn-primary" onclick="ajaxAdd();">添加</button></span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label">已选择</label>
					<div class="input-group">
						<ol id="selectedName">
						<c:forEach items="${caseTitles }" var="caseTitle">
							<li><div class="input-group">
									<span class="form-control">${caseTitle.tName }</span><span
										class="input-group-btn"><button type="button"
											class="btn btn-primary" onclick="deleteTitle(${caseTitle.id });">删除</button></span>
								</div></li>
							</c:forEach>
						</ol>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!--底部-->
<%@ include file="include/footer.jsp"%>
<script>
	function ajaxAdd(){
		var ctId = $("select[name=ctId]").val();
		var name = $("input[name=name]").val();
		var json = {
				"ctId":ctId,
				"name":name
		};
		if(name == "")
			return ;
		$.ajax({
			url:'<c:url value="/admin/setting/addTitle"/>',
			type:'POST',
			data:json,
			success:function(data){
				alert(data.msg)
				if(data.status == 1){
					location.reload();
				}
				
			}
		});
	}
	function deleteTitle(id){
		if(id == ""){
			return;
		}
		var json = {
				"id":id
		};
		$.ajax({
			url:'<c:url value="/admin/setting/deleteTitle"/>',
			data:json,
			success:function(data){
				alert(data.msg);
				if(data.status == 1){
					location.reload();
				}
				
			}
		});
	}
	function changeTitles(){
		var ctId = $("select[name=ctId]").val();
		var json ={
			"ctId":ctId	
		};
		$.ajax({
			url:'<c:url value="/admin/setting/findTitle"/>',
			data:json,
			success:function(data){
				var ol = $("#selectedName");
				var htmlstr = "";
				$.each(data,function(n,value){
					htmlstr += "<li><div class=\"input-group\"> <span class=\"form-control\">"+value.tName+"</span><span class=\"input-group-btn\"><button type=\"button\" class=\"btn btn-primary\" onclick=\"deleteTitle("+value.id+");\">删除</button></span></div></li>";
					
				});
				ol.html(htmlstr);
				//更新列表
				
			}
		});
		//更新列表
		
	}
</script>
${msg }
</body>

</html>