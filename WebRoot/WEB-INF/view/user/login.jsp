<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆</title>
<link rel="stylesheet" href="${CONTEXT_PATH}/css/bootstrap.min.css" />
<script type="text/javascript" src="${CONTEXT_PATH}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${CONTEXT_PATH}/js/jquery-1.4.4.min.js"></script>
</head>
<body>
	<div class="container" style="width: 440px; margin-top: 16%;">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="form-group">
					<div class="col-sm-10" style="margin: 5px">
						<input id="username" name="username" class="form-control"
							type="text" placeholder="用户名" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10" style="margin: 5px">
						<input id="password" name="password" class="form-control"
							type="password" placeholder="密码" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10" style="text-align: center;">
						<input onclick="login()" class="btn btn-default" type="button"
							style="width: 100px;" value="立即登录" /> <a
							href="/user/toFindPwd">忘记密码？</a><a href="/user/toRegister">立即注册</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function login() {
			var username = $("#username").val();
			var password = $("#password").val();
			$.ajax({
			    type: "post",
			    dataType: 'json',
			    url: '/login',
			    data: {username: username,password:password},
			    success:function(res){
			        if(res.msg == 'success') {
			        	location.href = "/blog";
			        } else {
			        	alert(res);
			        }
			    }
			});
		}
	</script>
</body>
</html>