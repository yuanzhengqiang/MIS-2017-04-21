<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String loginname = (String) session.getAttribute("loginname");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="images/logo.png">
<title>体检后台管理系统</title>
<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="js/jquery.gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="js/jquery.nanoscroller/nanoscroller.css" />
<link rel="stylesheet" type="text/css" href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css" href="js/jquery.select2/select2.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap.slider/css/slider.css" />
<link rel="stylesheet" type="text/css" href="js/intro.js/introjs.css" />
<link rel="stylesheet" type="text/css" href="js/jquery.niftymodals/css/component.css" />
<link href="css/style.css" rel="stylesheet" />
<style>
.gongzuotai:hover {
	background: #36a3ff
}
</style>
</head>
<body>
	<!-- 上侧栏开始 -->
	<div id="head-nav" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="fa fa-gear"></span>
				</button>
				<a class="navbar-brand" href="###" style="width:auto;background: url(images/logo.png) no-repeat 0 10px">
					<span>体检后台管理系统</span>
				</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right user-nav">
					<li class="dropdown profile_menu">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<img src="images/avatar2.jpg" />
							<span id="accountNickname"><%=loginname %></span>
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="#" class="md-trigger" data-modal="md-scale3">密码修改</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="systemLogin.do?logout">退出登录</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- /.nav-collapse animate-collapse -->
		</div>
	</div>
	<!-- 上侧栏结束 -->

	<div id="cl-wrapper" class="fixed-menu">
		<div class="cl-sidebar">
			<!-- 左侧栏开始  -->
			<div class="cl-toggle">
				<i class="fa fa-bars"></i>
			</div>
			<div class="cl-navblock">
				<div class="menu-space">
					<div class="content">
						<div class="side-user">
							<div class="avatar">
								<img src="images/avatar1_50.jpg" alt="Avatar" />
							</div>
							<div class="info">
								<a href="#"><%=loginname %></a>
								<img src="images/state_online.png" alt="Status" />
								<span>正常</span>
							</div>
						</div>
						<ul class="cl-vnavigation">
							<li class="parent">
								<a href="">
									<i class="fa fa-folder-open"></i>
									<span>基础信息</span>
								</a>
								<ul class="sub-menu">
									<li>
										<a href="#" onclick="changeCenter('area.do?main')">
											<i class="fa fa-male"></i>地区管理
										</a>
									</li>

									<li>
										<a href="#" onclick="changeCenter('hospital.do?main')">
											<i class="fa fa-male"></i>医院管理
										</a>
									</li>

									<li>
										<a href="#" onclick="changeCenter('medicalItem.do?main')">
											<i class="fa fa-male"></i>体检项目管理
										</a>
									</li>

									<li>
										<a href="#" onclick="changeCenter('servicePerson.do?main')">
											<i class="fa fa-male"></i>服务人员管理
										</a>
									</li>
									<li>
										<a href="#" onclick="changeCenter('wechatCustomer.do?main')">
											<i class="fa fa-male"></i>微信客户管理
										</a>
									</li>
								</ul>
							</li>
							<li class="parent">
								<a href="system.do">
									<i class="fa fa-user"></i>
									<span>订单信息</span>
								</a>
								<ul class="sub-menu">
									<li>
										<a href="#" onclick="changeCenter('order.do?main')">
											<i class="fa fa-users"></i>体检订单管理
										</a>
									</li>
									<li>
										<a href="#" onclick="changeCenter('medicalReport.do?main')">
											<i class="fa fa-users"></i>体检报告管理
										</a>
									</li>
								</ul>
							</li>
							<li class="parent">
								<a href="system.do">
									<i class="fa fa-user"></i>
									<span>系统设置</span>
								</a>
								<ul class="sub-menu">
									<li>
										<a href="#" onclick="changeCenter('systemUser.do?main')">
											<i class="fa fa-users"></i>账号管理
										</a>
									</li>
									<li>
										<a href="#" onclick="changeCenter('wechatMenu.do?wechatMenuManagement')">
											<i class="fa fa-users"></i>微信菜单管理
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<div class="text-right collapse-button" style="padding:7px 9px;">
					<input type="text" class="form-control search" placeholder="Search..." />
					<button id="sidebar-collapse" class="btn btn-default">
						<i style="color:#fff;" class="fa fa-angle-left"></i>
					</button>
				</div>
			</div>
		</div>
		<!-- 左侧栏结束  -->

		<!-- 中间栏开始 -->
		<iframe id="welcomeCenter" scrolling="auto" frameborder="0" src="###" style="width: 100%; height: 99.5%;"> </iframe>
		<!-- 中间栏结束 -->
	</div>

	<!-- 密码重置模态框 -->
	<div class="md-modal md-effect-1" id="md-scale3">
		<div class="row">
			<div class="col-md-12">
				<div class="block-flat">
					<div class="header">
						<h3>用户密码重置</h3>
					</div>

					<div class="content form-horizontal group-border-dashed">
						<div class="form-group">
							<label class="col-sm-4 control-label" style="text-align:left">
								原密码
								<span style="color:red">*</span>
							</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" value="" id="loginPWD">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label" style="text-align:left;margin-bottom:5px;">
								新密码
								<span style="color:red">*</span>
							</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" value="" style="margin-bottom:5px;" id="newPWD_1">
							</div>
							<label class="col-sm-4 control-label" style="text-align:left;">
								新密码再次输入
								<span style="color:red">*</span>
							</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" value="" id="newPWD_2">
							</div>
						</div>
						<p style="text-align:center;color:red;display:block;" id="changePwdTips">&nbsp;</p>
						<div class="form-group" style="text-align: center;">
							<button type="button" class="btn btn-success btn-rad" id="changeUserPwd">
								<span>
									<i class="fa fa-check" style="margin-right:5px;"></i>确定重置
								</span>
							</button>
							<button id="cancel_button" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;" onclick="cancelmima();">
								<span>
									<i class="fa fa-times" style="margin-right:5px;"></i>取消
								</span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 密码重置模态框结束 -->

	<div class="md-overlay"></div>
	<!-- Nifty Modal模态框的遮罩层-->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
	<script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
	<script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/jquery.select2/select2.min.js" type="text/javascript"></script>
	<script src="js/skycons/skycons.js" type="text/javascript"></script>
	<script src="js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
	<script src="js/intro.js/intro.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.niftymodals/js/jquery.modalEffects.js"></script>
	<script type="text/javascript" src="js/jquery.md5.js"></script>

	<script type="text/javascript">
	$(document).ready(function() {
		changeCenter('systemUser.do?main');
		var homeUrl = "<%=request.getContextPath()%>" + "/welcome.do?main";
		$(".navbar-brand").attr("href",homeUrl);
		//initialize the javascript
		App.init();
		App.dashBoard(); 
		$(".md-trigger").modalEffects();  //初始化模态框          
		resizeframe();  //调整iframe的大小为容器大小
		$("body").bind("resize", resizeframe);  //尺寸变化时，调整iframe大小
		$("#changeUserPwd").bind("click", function() {
			var loginPWD = $("#loginPWD")[0].value; //原密码
			var newPWD_1 = $("#newPWD_1")[0].value; //新密码
			var newPWD_2 = $("#newPWD_2")[0].value; //第二次输入的新密码
			
			if (loginPWD.length == 0 || newPWD_1.length == 0  || newPWD_2.length == 0 ) {
				document.getElementById('changePwdTips').innerHTML = '三个框都是必填！';
			} else if (newPWD_1 != newPWD_2) {
				document.getElementById('changePwdTips').innerHTML = '两次新密码输入不一致！';
			} else {
				document.getElementById('changePwdTips').innerHTML = '&nbsp;';
				loginPWD = $.md5(loginPWD);
				newPWD_1 = $.md5(newPWD_1);
				changePwd(loginPWD,newPWD_1);
			}
		});
		$("li.myliactivestyle").bind("click",function(){  //点击菜单栏,对当前li添加class="active"
			$("li.myliactivestyle").removeClass("active");
			$(this).addClass("active");
		});
	});
	
	function changeCenter(url) {
		document.getElementById("welcomeCenter").src="<%=request.getContextPath()%>/" + url;
	}

		/** 调整iframe的大小为容器大小 */
		function resizeframe() {
			$("#welcomeCenter").css("height", ($("body").height() - 55) + "px");
		}

		function changePwd(loginPWD, newPWD_1) {
			$.ajax({
				type : "post",
				async : true,
				url : "modifyUserInfo.do?modifyUserPwd",
				dataType : "json",
				data : {
					"loginUserPwd" : loginPWD,
					"newUserPwd" : newPWD_1
				},
				success : function(data) {
					if (data.result == "success") {
						alert(data.des);
						$("#loginPWD")[0].value = "";
						$("#newPWD_1")[0].value = "";
						$("#newPWD_2")[0].value = "";
						$("#md-scale3").removeClass("md-show");
					} else if (data.result == "failure") {
						alert(data.des); //原密码错误，继续修改
					}
				},
				error : function() {
					alert("修改密码失败！");
				}
			});
		}

		function cancelmima() {
			$("#loginPWD").val("");
			$("#newPWD_1").val("");
			$("#newPWD_2").val("");
		}
	</script>

	<script src="js/behaviour/voice-commands.js"></script>
	<script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.resize.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.labels.js"></script>
</body>
</html>
