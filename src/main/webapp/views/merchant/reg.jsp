<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
    <form action="/shop/merchant/reg">
    	account<input type="text" name="account"><br>
    	password<input type="password" name="password"><br>
    	password<input type="password" name="confirmPW"><br>
    	phone<input type="text" name="phone"><br>
    	address
    	<select name="aid"><option value="1">1</select>
    	<select name="province"><option value="广东省">广东省</select>
    	<select name="city"><option value="广州市">广州市</select>
    	<select name="area"><option value="天河区">天河区</select>
    	<select name="liveArea"><option value="汇景小区">汇景小区</select>
    	<br>
    		 <input type="submit" value="注册">
    </form>
  </body>
</html>
