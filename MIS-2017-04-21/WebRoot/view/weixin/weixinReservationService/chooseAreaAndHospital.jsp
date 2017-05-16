<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>身边·陪检服务</title>
<style>
html {
	font-size: 100px;
	height: 100%;
}

body {
	padding: 0;
	margin: 0;
	width: 100%;
	height: 100%;
}

ul,li {
	margin: 0px;
	padding: 0px;
}

.container-fluid {
	margin: 0px;
	padding: 0px;
	width: 100%;
	height: 100%;
	background: -moz-linear-gradient(left, #8ACA38, #5FA835);
	background: -webkit-linear-gradient(left, #8ACA38, #5FA835);
	background: linear-gradient(left, #8ACA38, #5FA835);
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

button:active {
	box-shadow: 0.02rem 0.03rem 0.1rem #235189;
}

.margin0 {
	margin: 0px;
}

.inlineBlock {
	display: inline-block;
}

.header {
	background-color: transparent;
	padding: 0rem 0.15rem;
	height: 0.32rem;
	display: flex;
	display: -webkit-flex;
}

.headerItem1 {
	flex: 1;
	display: inline-block;
	position: relative;
}

.headerItem3 {
	flex: 3;
	color: #FFF;
	font-size: 0.16rem;
	margin-bottom: 0px;
	font-weight: 700;
	display: inline-block;
}

.headerImg {
	width: 0.2rem;
	height: 0.2rem;
	position: absolute;
	top: 50%;
	webkit-transform: translateY(-50%);
	-moz-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
	transform: translateY(-50%);
}

.headerName {
	display: inline-block;
	letter-spacing: 0.03rem;
	line-height: 0.32rem;
	height: 0.32rem;
}

.content {
	height: 100%;
	width: 100%;
	background: -moz-linear-gradient(left, #8ACA38, #5FA835);
	background: -webkit-linear-gradient(left, #8ACA38, #5FA835);
	background: linear-gradient(left, #8ACA38, #5FA835);
	background-image: url(wechatImg/firstBackground.jpg);
	background-size: 100%;
}

.borderBottomNone {
	border-bottom: transparent;
}

.block {
	display: block;
}

.right0 {
	right: 0;
}

.left0 {
	left: 0;
}

.top11 {
	top: 0.11rem;
}

.payInfo {
	height: auto;
	text-align: center;
	margin-top: 1.2rem;
}

.payStatus1 {
	color: #FFF;
	font-size: 0.12rem;
	margin-bottom: 0px;
	font-weight: 700;
	letter-spacing: 0.05rem;
	display: block;
}

.payStatus2 {
	color: #FFF;
	font-size: 0.102rem;
	letter-spacing: 0.02rem;
	display: block;
}

.btnGroup {
	margin-top: 0.4rem;
}

.btn {
	height: 0.36rem;
	font-size: 0.16rem;
	margin: 0.2rem 0.5rem;
	border: 1px solid #FFF;
	background-color: transparent;
	border-radius: 8px;
	position: relative;
}

.textInfo {
	height: 0.36rem;
	line-height: 0.36rem;
	color: #FFF;
	text-align: left;
	margin-left: 0.2rem;
	font-size: 0.12rem;
	display: block;
}

.hide {
	display: none;
}

ul {
	margin-top: 0.05rem;
	width: 1.82rem;
	height: auto;
	list-style: none;
	padding: 0rem 0.2rem;
	font-size: 0.12rem;
	line-height: 0.3rem;
	background-color: #FFF;
	z-index: 500;
	display: block;
	position: absolute;
	left: -0.01rem;
	max-height: 2.1rem;
	border-radius: 0.08rem;
	overflow-y: auto;
}

li {
	border-bottom: 0.01rem solid #b5df91;
	color: #7cbb44;
	font-weight: 100;
	height: 0.3rem;
}

li:active {
	color: rgba(124, 187, 68, 0.8);
	font-weight: 700;
}

.liActive {
	background-color: #5c93d7;
	width: 0.03rem;
	height: 0.3rem;
	display: inline-block;
	position: relative;
	left: -0.2rem;
}

.liText {
	position: relative;
	top: -0.10rem;
	height: 0.3rem;
	display: inline-block;
}

.visibilityV {
	visibility: visible;
}

.visibilityH {
	visibility: hidden;
}

.show {
	display: block;
}

.btnDiv {
	height: 0.36rem;
	font-size: 0.16rem;
	margin: 0.2rem 0.5rem;
	background-color: transparent;
	position: relative;
}

.btnNext {
	background-color: #5c93d7;
	width: 100%;
	height: 0.36rem;
	border-radius: 8px;
	color: #FFF;
	box-shadow: 2px 4px 10px #6BB06D;
	outline: none;
	border: none;
}

.borderNone {
	border: none;
}

.weight100 {
	font-weight: 100
}

.weight700 {
	font-weight: 700
}

.heightTop {
	height: 0.25rem;
	top: 0.05rem;
}

.top005 {
	top: -0.05rem;
}

::-webkit-scrollbar {
	width: 0px
}

scrollbar {
	width: 0px
}

.model {
	width: 100%;
	height: 100%;
	z-index: 99;
	position: absolute;
	position: fixed;
	top: 0px;
	left: 0px;
	opacity: 0.9;
	background-color: #000;
	display: none;
}

.serviceContent1 {
	background-color: #FFF;
	width: 80vw;
	min-width: 200px;
	height: auto;
	min-height: 50vmin;
	border-radius: 15px;
	padding: 2px;
	font-size: 16px;
	position: relative;
}

.serviceBox {
	width: auto;
	height: auto;
	z-index: 100;
	position: fixed;
	top: 50%;
	left: 50%;
	webkit-transform: translateX(-50%) translateY(-50%);
	-moz-transform: translateX(-50%) translateY(-50%);
	-ms-transform: translateX(-50%) translateY(-50%);
	transform: translateX(-50%) translateY(-50%);
	background-color: transparent;
	display: none;
}

.serviceContentInfo1 {
	width: 70vw;
	height: auto;
	min-height: 50px;
	margin: 0px auto;
	position: fixed;
	top: 50%;
	left: 50%;
	webkit-transform: translateX(-50%) translateY(-50%);
	-moz-transform: translateX(-50%) translateY(-50%);
	-ms-transform: translateX(-50%) translateY(-50%);
	transform: translateX(-50%) translateY(-50%);
	padding: 15px;
}

.serviceContentBtn {
	width: 60vw;
	height: 30px;
	position: fixed;
	top: 75%;
	left: 50%;
	webkit-transform: translateX(-50%) translateY(-50%);
	-moz-transform: translateX(-50%) translateY(-50%);
	-ms-transform: translateX(-50%) translateY(-50%);
	transform: translateX(-50%) translateY(-50%);
	border-radius: 0.05rem;
}

.serviceBtn {
	width: 100%;
	height: 100%;
	border: none;
	background-color: #87cd50;
	border-radius: 5px;
	box-shadow: 2px 2px 5px 1px #ABCD83;
	outline: none;
	-webkit-appearance: none; /*解决iphone safari上的圆角问题*/
}
.serviceBox{
			width: auto;
			height:auto;
			z-index: 100;
			position: fixed;
			top: 50%;
			left: 50%;
			webkit-transform: translateX(-50%) translateY(-50%);
			-moz-transform: translateX(-50%) translateY(-50%);
			-ms-transform: translateX(-50%) translateY(-50%);
			transform: translateX(-50%) translateY(-50%);
			background-color: transparent;
			display: none;
			border-radius: 0.1rem;
    		overflow: hidden;
		}
		.promptly{
			padding: 0.05rem 0.3rem;
		    margin-bottom: 0.1rem;
		    border: none;
		    outline: none;
		    background-color: #92D050;
		    color: #FFF;
		}
		.margin1{
			margin: 0.1rem auto;
			font-size: 0.14rem;
		}
		.modelContent2 {
			background-color: #FFF;
		    width: 75vw;
		    min-width: 2rem;
		    height: auto;
		    padding: 0rem 0.15rem;
		    font-size: 0.16rem;
		    border-radius: 0rem 0rem 0.1rem 0.1rem;
		}
		.modelContentInfo2{
			height: auto;
			min-height: 0.3rem;
			padding: 0.15rem 0rem 0rem;
			font-size: 0.13rem;
			text-align: left;
			position: relative;
    		left: 0.01rem;
    		border-top: 1px solid #DDD;
		}
</style>
</head>
<body id="body" class="hide">
	<div class="container-fluid">
		<div class="content">
			<div class="header">
				<span class="headerItem1 text-left" style="visibility: hidden;">
					<img src="wechatImg/return.png" class="headerImg left0">
				</span>
				<span class="headerItem3 text-center" style="visibility: hidden;">
					<label class="headerName"></label>
				</span>
				<span class="headerItem1 text-right">
					<img src="wechatImg/service.png" class="headerImg right0" id="service">
				</span>
			</div>
			<div class="payInfo">
				<label class="payStatus1">SHENBIAN</label>
				<label class="payStatus2">你的身边陪检服务</label>
			</div>
			<div class="btnGroup">
		    	<div class="btn">
					<span class="textInfo" id="area">地区</span>
					<ul class="absolute hide" id="areaContent">
						<!-- <li><span class="liActive visibilityH"></span><span class="liText">上海</span></li>
						<li class="borderNone"><span class="liActive visibilityH"></span><span class="liText">北京</span></li> -->
					</ul>
		    	</div>
		    	<div class="btn">
		    		<span class="textInfo" id="hospital">医院</span>
					<ul class="absolute hide" id="hospitalContent">
						<!-- <li><span class="liActive visibilityH"></span><span class="liText">医院F</span></li>
						<li class="borderNone"><span class="liActive visibilityH"></span><span class="liText">医院E</span></li> -->
					</ul>
		    	</div>
		    	<div class="btnDiv">
					<button class="btnNext" onclick="turnPage()">下 一 步</button>
				</div>
		    </div>
		</div>
	</div>

	<input type="hidden" id="areaId">
	<input type="hidden" id="hospitalId">

	<div class="serviceBox">
    	<div class="modelContent2">
			<div class="modelContentInfo2 text-center" style="padding-top: 0rem">
				<div class="text-center margin1" style="margin-top: 0.2rem;">身边 · 24小时服务电话</div>
				<div class="text-center margin1" style="color: #62698D">1855-0065-068</div>
				<a href="tel:18550065068" class="hide"><span id="fixedDialingNumbers">一键拨号</span></a>
			</div>
			<div class="text-center">
				<button class="promptly" onclick="$('.model').css('display','none');$('.serviceBox').css('display','none');$('#fixedDialingNumbers').click();">立 即 拨 打</button>
			</div>
    	</div>
	</div>

	<div class="model"></div>
	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript">
		(function (doc, win) {
		    // 分辨率Resolution适配
		    var docEl = doc.documentElement,
		        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
		        recalc = function () {
		            var clientWidth = docEl.clientWidth;
		            if (!clientWidth) return;
		            docEl.style.fontSize = 100 * (clientWidth / 320) + 'px';
		        };

		    // Abort if browser does not support addEventListener
		    if (!doc.addEventListener) return;
		    win.addEventListener(resizeEvt, recalc, false);
		    doc.addEventListener('DOMContentLoaded', recalc, false);
		    // 一物理像素在不同屏幕的显示效果不一样。要根据devicePixelRatio来修改meta标签的scale,要注释上面的meta标签
		    document.getElementById('body').removeAttribute('class','hide')
		})(document, window);
	</script>
	<script type="text/javascript">
		$("body:not('ul')").click(function(event) {
			$(".absolute").addClass('hide').removeClass('show');
			console.log(1)
			/* Act on the event */
		});

		$(".textInfo").click(function(event) {
			$(this).next().addClass("show").removeClass("hide");
			$(this).parents(".btn").siblings().find('.absolute').addClass("hide").removeClass("show");
			event.stopPropagation();
			return false;
		});

		$("ul").on("click", "li", function(event){
			if($(this).index() == 0) {
				$(this).find('.liActive').addClass('heightTop');
				$(this).find('.liText').addClass('top005');
			} else {
				$(this).find('.liActive').removeClass('heightTop');
				$(this).find('.liText').removeClass('top005');
			}
			var name = $(this).find('.liText').text();
			$(this).find('.liText').addClass('weight700').removeClass('weight100');
			$(this).find('.liActive').addClass('visibilityV').removeClass('visibilityH');
			$(this).siblings("li").find('.liActive').addClass('visibilityH').removeClass('visibilityV');
			$(this).siblings("li").find('.liText').addClass('weight100').removeClass('weight700');
			$(this).parents(".absolute").addClass('hide').removeClass('show').prev().text(name);
			event.stopPropagation();
			return false;
		});
		
		$("#service").on("click", function() {
			$(".model").css("display","block");
			$(".serviceBox").css("display","block");
		});
		$(".model").on("click", function() {
			$(".model").css("display","none");
			$(".serviceBox").css("display","none");
		});
		
		$(document).ready(function() {
	    	queryArea();
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
								var length = data.content.areaList.length - 1;
								jQuery.each(data.content.areaList,function(i, item) {
									if (i == length) {
										html += "<li class='borderNone' onclick='changeHospital(" + item.id + ",\"" + item.area + "\")'><span class='liActive visibilityH'></span><span class='liText'>" + item.area + "</span></li>";
									} else {
										html += "<li onclick='changeHospital(" + item.id + ",\"" + item.area + "\")'><span class='liActive visibilityH'></span><span class='liText'>" + item.area + "</span></li>";
									}
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
								var length = data.content.hospitalList.length - 1;
								jQuery.each(data.content.hospitalList,function(i, item) {
									if (i == length) {
										html += "<li class='borderNone' onclick='finishChooseHospital(" + item.id + ",\"" + item.hospitalName + "\")'><span class='liActive visibilityH'></span><span class='liText'>" + item.hospitalName + "</span></li>";
									} else {
										html += "<li onclick='finishChooseHospital(" + item.id + ",\"" + item.hospitalName + "\")'><span class='liActive visibilityH'></span><span class='liText'>" + item.hospitalName + "</span></li>";
									}
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
		}
		
		//跳转体检项目检查页面
		function turnPage() {
			var areaId = $("#areaId").val();
			var hospitalId = $("#hospitalId").val();
			if (hospitalId != null && hospitalId != "") {
				window.location.replace("<%=request.getContextPath()%>/" + "weixinReservationService.do?choosePhysicalExaminationItems&hospitalId=" + hospitalId + "&weixin=weixin");
			} else {
				if (areaId == null || areaId == "") {
					alert("请选择地区");
				} else {
					alert("请选择医院");
				}
			}
		}
	</script>
</body>
</html>