<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
<meta charset="utf-8">
<link rel="shortcut icon" href="images/logo.png">
<title>体检后台管理系统</title>
<!-- Bootstrap core CSS -->
<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet" />
<style>
body.texture {
	background: url(images/bgnew.png) no-repeat;
}

.middle-login1 {
	width: 450px;
	z-index: 22;
	right: 120px;
	top: 120px;
	position: absolute;
	margin: 0
}

.fskxiaoge {
	position: absolute;
	bottom: 0;
	z-index: 20;
	animation: mymove 5s ease 1;
	-webkit-animation: mymove 5s ease 1 -moz-animation:  mymove 5s ease 1;
	-o-animation: mymove 5s ease 1;
	animation-fill-mode: forwards;
	-webkit-animation-fill-mode: forwards;
	-moz-animation-fill-mode: forwards;
	-o-animation-fill-mode: forwards;
}

#username:-webkit-autofill {
	-webkit-box-shadow: 0 0 0px 1000px white inset;
}

#password:-webkit-autofill {
	-webkit-box-shadow: 0 0 0px 1000px white inset;
}

.control-label {
	padding-top: 7px;
	font-size: 16px;
	font-weight: normal;
	padding-right: 0
}

#loginbtn {
	padding: 5px 30px;
	font-size: 16px;
}

.foot {
	text-align: center !important;
	margin-top: 15px;
	margin-bottom: 20px
}

/* css3动画 */
@
keyframes mymove { 0% {
	right: 100%;
}

100%
{
right
:
450px;
 
}
}
@
-moz-keyframes mymove /* Firefox */ { 0% {
	right: 100%;
}

100%
{
right
:
450px;
 
}
}
@
-webkit-keyframes mymove /* Safari and Chrome */ { 0% {
	right: 100%;
}

100%
{
right
:
450px;
 
}
}
@
-o-keyframes mymove /* Opera */ { 0% {
	right: 100%;
}
100%
{
right
:
450px;
 
}
}
</style>
<script type="text/javascript">
    if (self != top) {  //判断页面是否在iframe里面
		parent.location.reload();  //若页面在iframe中，则刷新父页面。用以避免session过期时，将登陆页面显示到了iframe中
	}
    </script>
</head>
<body class="texture">
	<div id="cl-wrapper" class="login-container">
		<div class="middle-login1">
			<div class="block-flat">
				<div class="content">
					<h3 class="title" style="text-align:center;">
						<img src="" />
					</h3>
					<h3 class="title" style="text-align:center;">体检后台管理系统</h3>
					<div class="form-group ">
						<label for="username" class="col-sm-2 control-label" style="margin-top:20px">用户名</label>
						<div class="col-sm-10" style="margin-top:20px">
							<input type="text" class="form-control" id="username">
						</div>
					</div>
					<div class="form-group ">
						<label for="password" class="col-sm-2 control-label" style="margin-top:20px">密码</label>
						<div class="col-sm-10" style="margin-top:20px">
							<input type="password" class="form-control" id="password">
						</div>
						<p style="color:red;text-align:center" id="data-des">&nbsp;</p>
					</div>
					<div class="col-sm-12 text-center" style="margin-top:-15px">
						<label class="checkbox-inline"> <input id="rememberUsername" type="checkbox" checked="" name="rad1" class="icheck">记住用户名</label> <label class="checkbox-inline"> <input id="rememberPasswd" type="checkbox" checked="" name="rad1" class="icheck">记住密码</label>

					</div>
				</div>
				<div class="foot">
					<!-- <button class="btn btn-danger btn-lg" data-dismiss="modal"
							type="button" style="padding: 12px 34px;margin-top:5px;"
							id="register">注册</button> -->
					<button class="btn btn-primary " type="submit" id="loginbtn">登 录</button>
				</div>
			</div>
		</div>
		<div class="fskxiaoge">
			<img src="images/fskxiaoge.png" />
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.md5.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>
	<script type="text/javascript">
      var project_path= "<%=request.getContextPath()%>";
		$(document).ready(
				function() {
					$("#loginbtn").click(function() {
						var username = $("#username")[0].value;
						var password = $("#password")[0].value;
						login(username, password);
					});
					$("#register").click(function() {
						alert("注册用户请联系客服，电话:8888-88888888");
					});
					$("#username").keydown(function() { //焦点在用户名框时，按回车，焦点跳转到密码框
						if (event.keyCode == 13) {
							$("#password").focus();
						}
					});
					$("#password").keydown(function(event) { //焦点在在密码框时，按回车，视为点击“登录”按钮
						if (event.keyCode == 13) {
							$("#loginbtn").click();
						}
					});
					//从Cookies中读取记住的用户名（如果有的话）
					if ($.cookie("rememberUsername") != null
							&& $.cookie("rememberUsername") == "true") {
						$("#rememberUsername").prop("checked", true);
						$("#username").val($.cookie("username"));
					}
					//从Cookies中读取记住的密码（如果有的话）
					if ($.cookie("rememberPasswd") != null
							&& $.cookie("rememberPasswd") == "true") {
						$("#rememberPasswd").prop("checked", true);
						$("#password").val($.cookie("password"));
					}
				});

		function login(username, password) {
			if ($("#rememberUsername").prop("checked")) {
				$.cookie("rememberUsername", "true", {
					expires : 7,
					path : "/"
				});
				$.cookie("username", username, {
					expires : 7,
					path : "/"
				});

				if ($("#rememberPasswd").prop("checked")) {
					$.cookie("rememberPasswd", "true", {
						expires : 7,
						path : "/"
					});
					$.cookie("password", password, {
						expires : 7,
						path : "/"
					});
				} else {
					$.cookie("rememberPasswd", "false", {
						expires : -1,
						path : "/"
					});
					$.cookie("password", password, {
						expires : -1,
						path : "/"
					});
				}
			} else {
				$.cookie("rememberUsername", "false", {
					expires : -1,
					path : "/"
				});
				$.cookie("username", "", {
					expires : -1,
					path : "/"
				});
				$.cookie("rememberPasswd", "false", {
					expires : -1,
					path : "/"
				});
				$.cookie("password", "", {
					expires : -1,
					path : "/"
				});
			}

			password = $.md5(password); //在cookies保存之后再进行变换，避免cookies中存的密码信息被多次变换
			$.ajax({
				type : "post",
				async : true,
				url : project_path + "/systemLogin.do?login",
				dataType : "json",
				data : {
					"username" : username,
					"password" : password
				},
				// jsonp: "callbackjson",
				//  jsonpCallback:"jsonpCallback_loginbtn",
				success : function(data) {
					//var returnresult = $.parseJOSN(data);
					if (data.result == "success") {
						location.href = project_path
								+ "/welcome.do?main"
					} else {
						// alert(data.des);
						document.getElementById('data-des').innerHTML = data.des; //登录错误提示消息
					}
				},
				error : function() {
					alert("error");
				}
			});
		}
	</script>

</body>
</html>
