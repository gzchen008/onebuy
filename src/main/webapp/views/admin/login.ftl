<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>登录</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="${rootPath}/resources/css/admin/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${rootPath}/resources/css/admin/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <!-- <link href="${rootPath}/resources/css/admin/animate.css" rel="stylesheet"> -->
    <link href="${rootPath}/resources/css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">后台管理</h1>

            </div>
            <h3>欢迎使用后台管理</h3>

            <form class="m-t" role="form" action="javascript:validate('${rootPath}')">
                <div class="form-group">
                    <input id="name" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" id="password" class="form-control" placeholder="密码" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>

                <!-- <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
                </p> -->

            </form>
            <div id="warn" class="alert alert-warning hidden">
			<strong>用户不存在或密码错误!</strong>
		</div>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="${rootPath}/resources/js/admin/jquery-2.1.1.min.js"></script>
    <script src="${rootPath}/resources/js/admin/bootstrap.min.js?v=3.4.0"></script>
	<script>
		function validate(baseUrl){
			$.ajax({
				type : "POST",
				url : baseUrl+"/validate/check",
				data : {
					"name" : $("#name").val(),
					"password" : $("#password").val(),
				},
				dataType : "json",
				success : function(data) {
					if (data.message == "success") {
						url = baseUrl+'/admin/goods';
						window.location.href=url;
					}
					if (data.message == "fail") {
						$("#warn").attr("class", "alert alert-warning show");
						$("#warn").fadeOut(3000);
					}
				}
				

			});
		}
	
	</script>

</body>

</html>
