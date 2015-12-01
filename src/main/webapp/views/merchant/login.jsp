<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title></title>
	<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8" />
	<link rel="stylesheet" type="text/css" href="${rootPath}/resources/style/css/PC-Login.css">
</head>
<body>
	<div class="container">
		<div id="center-wrap">
			<div class="logo">
				<img src="${rootPath}/resources/img/loginlogo.png">
			</div>
			<form method="POST" action="${rootPath}/merchant/login">
				<div class="wrap">
					<div class="filed" id="account">
						<span id="loginMe">
							<i></i>
						</span>
						<input type="text" class="input" id="account" name="account"/>
					</div>
					<div class="filed" id="password">
						<span id="pw">
							<i></i>
						</span>
						<input type="password" name="password" />
					</div>
				</div>
				<div id="login">
					<button type="submit" class="submit" id="submit" name="submit">登录</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="${rootPath}/resources/js/regular.js"></script>
	<script type="text/javascript" src="${rootPath}/resources/js/PC-login.js"></script>
</body>
</html>
