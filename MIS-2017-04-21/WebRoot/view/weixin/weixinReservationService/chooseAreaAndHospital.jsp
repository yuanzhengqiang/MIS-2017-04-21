<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<title>选择地区医院</title>
	<style>
		@media screen and (min-width: 320px) {
		    html {font-size: 12px;}
		}
		 
		@media screen and (min-width: 360px) {
		    html {font-size: 14px;}
		}
		 
		@media screen and (min-width: 400px) {
		    html {font-size: 16px;}
		}
		 
		@media screen and (min-width: 440px) {
		    html {font-size: 18px;}
		}
		 
		@media screen and (min-width: 480px) {
		    html {font-size: 22px;}
		}
		 
		@media screen and (min-width: 640px) {
		    html {font-size: 24px;}
		}
		body{
			margin: 0px;
			background-color: #ABDD6A;
		}
		.container-fluid {
			margin-right: auto;
			margin-left: auto;
			padding-left: 10px;
			padding-right: 10px;
			overflow: hidden;
		}
		.row {
			margin-left: -15px;
			margin-right: -15px;
		}
		.text-left {
			text-align: left;
		}
		.text-right {
			text-align: right;
		}
		.text-center {
			text-align: center;
		}
		.mainInfo{
			width: 80vw;
			z-index: 100;
			position: fixed;
			top: 50%;
			left: 50%;
			webkit-transform: translateX(-50%) translateY(-50%);
			-moz-transform: translateX(-50%) translateY(-50%);
			-ms-transform: translateX(-50%) translateY(-50%);
			transform: translateX(-50%) translateY(-50%);
		}
		.box{
			width: 100vw;
			height:100vh;
			z-index: 100;
			position: fixed;
			top: 0;
			left: 0;
			background-color: transparenst;
			display: none;
			overflow-y: auto; 
		}
		.content {
			background-color: #FFF;
			width: 60vw;
			min-width: 100px;
			height: auto;
			min-height: 50vmin;
			border-radius: 15px;
			padding: 20px;
			font-size: 1rem;
			margin: 30px auto;
			position: fixed;
			top: 50%;
			left: 50%;
			webkit-transform: translateX(-50%) translateY(-50%);
			-moz-transform: translateX(-50%) translateY(-50%);
			-ms-transform: translateX(-50%) translateY(-50%);
			transform: translateX(-50%) translateY(-50%);
		}
		.model{
			width: 100%;
			height:100%;
			z-index: 99;
			position: fixed;
			top: 0;
			right: 0;
			bottom: 0;
			left: 0;
			opacity: 0.6;
			background-color: #333;
			display: none;
		}
		input[type="radio"]{
			margin: 0px 15px;
		}
		.labelInfo{
			display: block;
		}
		.btn{
			background-color: #4D90FD;
			width: 100%;
			height: 44px;
			border: 1px solid #6293D6;
			border-radius: 8px;
			color: #FFF;
			box-shadow: 2px 4px 10px #6BB06D;
			outline: none;
		}
		::-webkit-input-placeholder {
			color: #FFF;
			font-size: 1rem;
		}
		::-moz-placeholder {
			color: #FFF;
			font-size: 1rem;
		}
	</style>
</head>
<body style="background-image: url(wechatImg/firstBackground.jpg);background-size: 100%;">
	<div class="container-fluid">
		<div class="row" style="margin-top: 15px;margin-left: 0px;margin-right: 0px;">
			<div class="text-right" style="float: right; display: inline-block;">
				<img src="wechatImg/service.jpg" style="width:2rem;height:2rem" onclick="$('#fixedDialingNumbers').click();">
				<a href="tel:10086" style="display:none;"><span id="fixedDialingNumbers">一键拨号</span></a>
			</div>
		</div>
		<div class="mainInfo">
			<div class="row">
				<div class="text-center">
					<label style="color: #FFF;font-size: 1.1rem;margin-bottom: 0px;font-weight: 700; letter-spacing: 4px;">SHENBIAN</label>
				</div>
				<div class="text-center">
					<span style="color: #FFF;font-size: 0.89rem;letter-spacing: 2px;">你的身边陪检服务</span>
				</div>
			</div>
			<div class="row" style="padding: 20px 30px;margin-top: 30px;">
				<div class="text-center" style="border: 1px solid #FFF;background-color: transparent;padding: 10px 20px;border-radius: 8px;color: #FFF;text-align: left;" id="areaDiv">
					<span id="area">地区</span>
				</div>
				<div class="text-center" style="border: 1px solid #FFF;background-color: transparent;padding: 10px 20px;border-radius: 8px;margin-top: 15px;color: #FFF;text-align: left;" id="hospitalDiv">
					<!--<input type="text" name="hospital" placeholder="医 院" style="width: 100%;border: none;background-color: transparent;outline-color: transparent;" readonly="readonly">-->
					<span id="hospital">医院</span>
				</div>
				<div class="text-center" style="margin-top: 20px;padding: 0px;">
					<button class="btn" style="background-color: #5c93d7;width: 100%;height: 44px;border: 1px solid #6293D6;border-radius: 8px;color: #FFF;box-shadow: 2px 4px 10px #6BB06D;outline: none;" onclick="turnPage()">下 一 步</button>
				</div>
				<a href="" id="turnPage"></a>
			</div>
		</div>
	</div>

	<div class="box" id="areaBox">
    	<div class="content" id="areaContent">
			<!-- <label class="labelInfo"><input type="radio" name="area"><span>上海</span></label> -->
    	</div>
	</div>
	<div class="box" id="hospitalBox">
    	<div class="content" id="hospitalContent">
			<!-- <label class="labelInfo"><input type="radio" name="hospital"><span>医院1</span></label> -->
    	</div>
	</div>
	<input type="hidden" id="areaId">
	<input type="hidden" id="hospitalId">
	<div class="model"></div>
	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript">
		//跳转体检项目检查页面
		function turnPage() {
			var hospitalId = $("#hospitalId").val();
			if (hospitalId != null && hospitalId != "") {
				window.location.replace("<%=request.getContextPath()%>/" + "weixinReservationService.do?choosePhysicalExaminationItems&hospitalId=" + hospitalId + "&weixin=weixin");
			} else {
				alert("请选择地区和医院");
			}
		}
		
		$(document).ready(function() {
	    	queryArea();
	    	
	    	$("#areaDiv").on("click", function() {
				$(".model").css("display","block");
				$("#areaBox").css("display","block");
			});
			$("#hospitalDiv").on("click", function() {
				$(".model").css("display","block");
				$("#hospitalBox").css("display","block");
			});
		  /*$(".content").on("click", function(event) {
				$(".model").css("display","block");
				$(this).parent().css("display","block");
				event.stopPropagation();  
			});
			 */
			$(".box").click(function(event){
				$(".model").css("display","none");
				$(this).css("display","none");
				event.stopPropagation();  
				return false;
			});
		});
		
		//查询地区
		function queryArea() {
			var reqmsg = "{'action':'QUERY_AREA_LIST_REQUEST','page':{'pageno':'1','pagesize':'1000'},'content':{}}";
			var html = "";
			
		    jQuery.ajax({
		          type : "post",
		          async:false,
		          url : "area.do?handler",
		          dataType : "json",
		          data: {
		               "reqmsg":reqmsg,
		               "weixin":"weixin"             
		          },
		          success : function(data) {
		              if (data.des == "success") {
		            	 if (data.content != null) {
							if (data.content.areaList != null) {
								jQuery.each(data.content.areaList,function(i, item) {
									html += "<label class='labelInfo' onclick='changeHospital(" + item.id + ",\"" + item.area + "\")'><input type='radio' name='area'><span>" + item.area + "</span></label>";
								});
								$("#areaContent").html(html);
							}
						 }
		              } else {
		                  alert("查询地区信息失败");
		              }
		          },
		          error:function() {
			          alert("查询地区信息失败");
		          }
		     });
		}
		
		//获取对应地区医院信息
		function changeHospital(id, area) {
			$("#areaId").val(id);
			$("#area").text(area);
			$("#hospitalId").val("");
			$("#hospital").text("医院");
			$(".model").css("display","none");
			$("#areaBox").css("display","none");
			
			var reqmsg = "{'action':'QUERY_HOSPITAL_LIST_REQUEST','page':{'pageno':'1','pagesize':'1000'},'content':{'areaId':" + id + "}}";
			var html = "";
	
		    jQuery.ajax({
		          type : "post",
		          async:false,
		          url : "hospital.do?handler",
		          dataType : "json",
		          data: {
		               "reqmsg":reqmsg,
		               "weixin":"weixin"               
		          },
		          success : function(data) {
		              if (data.des == "success") {
		            	 if (data.content != null) {
							if (data.content.hospitalList != null) {
								jQuery.each(data.content.hospitalList,function(i, item) {
									html += "<label class='labelInfo' onclick='finishChooseHospital(" + item.id + ",\"" + item.hospitalName + "\")'><input type='radio' name='hospital' value='" + item.id + "'><span>" + item.hospitalName + "</span></label>";
								});
							}
						 }
		              } else {
		                 alert("查询医院信息失败");
		              }
		          },
		          error:function() {
			          alert("查询医院信息失败");
		          }
		     });
		     $("#hospitalContent").html(html);
		}
		//完成选择医院操作
		function finishChooseHospital(id, hospitalName) {
			$("#hospitalId").val(id);
			$("#hospital").text(hospitalName);
			$(".model").css("display","none");
			$("#hospitalBox").css("display","none");
		}
	</script>
</body>
</html>