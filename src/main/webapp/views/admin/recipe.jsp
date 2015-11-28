<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-cn">
	<jsp:include page="head.jsp">
		<jsp:param value="请填写食谱信息" name="title"/>
	</jsp:include>
<body class="fill-recipe">
<div class="header">
    <h1>中心管理系统</h1>
</div>
	<div class="step-progress">
	    <ul class="progress-list">
	        <li class="long-li">
	        </li>
	        <span class="right-angle"></span>
	        <span class="hollow-angle-active"></span>
	        <li class="long-li active">请填写食谱信息</li>
	        <span class="right-angle-active"></span>
	        <span class="hollow-angle"></span>
	        <li class="long-li"></li>
	    </ul>
	</div>
	<div class="container">
	    <div class="content">
	        <p class="first-recipe">食谱一：此处应有描述</p>
	
	        <form class="fill-form" action="#">
	            <div class="fill-recipe-form-group form-group">
	                <label class="sr-only" for="description">添加描述性文字</label>
	
	                <div class="input-group">
	                    <input class="fill-input form-control" type="text" id="description" placeholder="添加描述性文字"/>
	                    <div class="input-group-addon">1/5</div>
	                </div>
	            </div>
	            <button class="file-chooser">+</button>
	            <input class="file-input" type="file"/>
	            <p class="no-selected">尚未选择文件</p>
	            <input class="add-step-submit btn btn-default" type="submit" value="添加食谱"/>
	            <a class="add-step btn btn-default" href="#">添加步骤</a>
	        </form>
	    </div>
	</div>
	<%@include file="script.jsp" %>
</body>
</html>