<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="description" content="Xenon Boostrap Admin Panel" />
<meta name="author" content="" />
<title>健康报告图片详情</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<link rel="stylesheet" href="weixinjs/jquery.mobile-1.3.2.min.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/jquery.mobile-1.3.2.min.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>
	.carousel-caption{padding-bottom:0;bottom:10px;text-shadow: 0 1px 2px #000;}
	#imageDes{position:fixed;left:0px;bottom:0;z-index:10;width:100%}
    #imageDes p,#imageDes h4{color:#fff;text-shadow: 0 1px 2px #555;}
	.carousel-control.right,.carousel-control.left{background-image:none}
	.carousel-control{top:50%;font-size:40px;margin-top:-20px}
</style>
</head>
<body style="background-color:#555">
	<div class="fixedTOP" style="background-color:#555">		
		<h3>图片详情</h3>
		<a class="logo" href="###">
          <span class="glyphicon glyphicon-chevron-left" onclick="fanhui()"></span>
        </a>
	</div>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-xs-12" style="padding-left:0;padding-right:0;">
                <div id="myCarousel" class="carousel slide">
                    <!-- 轮播（Carousel）图片放此处，（注意，tag的值与底部p的id一一对应，方便加载图片描述 -->
                    <div class="carousel-inner" id="tupianweizhi">
                        <!--<div class="item active" tag="pic1">  
                        <img src="weixinimages/slide1.png"  >
                        <div class="carousel-caption" >1/4  给老人剪指甲</div></div>
                        <div class="item" tag="pic2" >
                        <img src="weixinimages/slide2.png"  >
                        <div class="carousel-caption" >2/4  给老人洗脚</div></div>
                        <div class="item" tag="pic3" >
                        <img src="" >
                        <div class="carousel-caption" >3/4   给老人梳头</div></div>
                        <div class="item" tag="pic4" >
                        <img src="" >
                        <div class="carousel-caption" >4/4   给老人讲笑话</div></div> -->
                    </div>
                    <!-- 左右翻页示意 -->
                    <span class="carousel-control left">&lsaquo;</span>
                    <span class="carousel-control right">&rsaquo;</span></div>
            </div>
        </div>
    </div>
    <!-- 轮播（Carousel）图片底部描述 -->
	<div id="imageDes">
		<!-- <p id="pic1">1/4 描述1描述1描述11,描述1描述1描述1,描述1描述1描述1描述1！</p>
		<p id="pic2" style="display:none">2/4 描述2描述2描述2描述2,描述2描述2描述2,描述2描述2！</p>
		<p id="pic3" style="display:none">3/4 描述33描述3描述3描述3描述3描描述3,描述3描述3描述3描述3描述3描述3,描述3描述3描述3v！</p>
		<p id="pic4" style="display:none">4/4 描述43描述3描述3v！</p> -->
	</div>
<script>
	function fanhui() { //返回上一页
		var healthReportId = "<%=request.getAttribute("healthReportId")%>";
		var olderId = "<%=request.getAttribute("olderId")%>";
		var type = "<%=request.getAttribute("type")%>";
		var url = "<%=request.getContextPath()%>" + "/wechatHealthAssessment.do?mainBG&healthReportId=" + healthReportId + "&olderId=" + olderId + "&type=" + type + "&weixin=weixin";
		window.location.replace(url);
	}
	
	$(document).ready(function() {
		queryjkbgphotos();	//加载图片
		//轮播基础设置
		$('#myCarousel').carousel('cycle');
		$(".ui-page-active").css("background", "#555"); //统一背景颜色
		$('#myCarousel').carousel({
			interval: false //不自动轮播
		});
		setTimeout("relizeIMG1()", 100);
	
		//手势右滑 回到上一个画面
		$('#myCarousel').bind('swiperight swiperightup swiperightdown',function() {
			var phoneH = $(window).height();
			var imageH = $("#myCarousel").width();
			//  if(imageH==null){
			//  	imageH = $(".carousel-inner>div:last").height();
			//  }
			// $("#myCarousel").css("height",imageH+"px");
			if (imageH < phoneH) {
				$("#myCarousel").css("margin-top", (phoneH - imageH) / 2 + "px");
			} else {
				$("#myCarousel").css("margin-top", "0px");
			}
			$("#myCarousel").carousel('prev');
			$("#imageDes").show();
			$(".fixedTOP").show();
	
		});
		
		//手势左滑 进入下一个画面
		$('#myCarousel').bind('swipeleft swipeleftup swipeleftdown',function() {
			var phoneH = $(window).height();
			var imageH = $("#myCarousel").width();
			//  if(imageH==null){
			//	imageH = $(".carousel-inner>div:first").height();
			//  }
			//$("#myCarousel").css("height",imageH+"px");
			if (imageH < phoneH) {
				$("#myCarousel").css("margin-top", (phoneH - imageH) / 2 + "px");
			} else {
				$("#myCarousel").css("margin-top", "0px");
			}
			$("#myCarousel").carousel('next');
			$("#imageDes").show();
			$(".fixedTOP").show();
	
		});
		
		//点击图片 ，头部+底部bar消失/显示
		$('#myCarousel').bind('click',function() {
			if ($("#imageDes").is(':hidden')) {
				$("#imageDes").show();
				$(".fixedTOP").show();
				//处理业务  
			} else {
				$("#imageDes").hide();
				$(".fixedTOP").hide();
			}
	
		});
		
		//轮播完图片后更改描述
		$('#myCarousel').on('slid.bs.carousel',function() {
			var tt = $("div[class='item active']").attr("tag");
			$("#imageDes div").hide();
			$("#" + tt).show();
		});
	
	});
	
	function relizeIMG1() { //图片大小自适应
		var phoneH = $(window).height();
		var imageH = $("#myCarousel").height();
		console.log(imageH);
		if (imageH < phoneH) {
			$("#myCarousel").css("margin-top", (phoneH - imageH) / 2 + "px");
		} else {
			$("#myCarousel").css("margin-top", "0px");
		}	
	}
	
	function queryjkbgphotos() { //加载图片
		var healthReportId = "<%=request.getAttribute("healthReportId")%>";
		var reqmsg = "{'action':'QUERY_HEALTH_REPORT_INFO_REQUEST','content':{\"healthReportPhotoListShow\":\"true\",\"id\":" + healthReportId + "}}";	
		jQuery.ajax({
			type: "post",
			async: false,
			url: "healthReport.do?handler",
			dataType: "json",
			data: {
				"reqmsg": reqmsg,
				"weixin": "weixin"
			},
			success: function(data) {
				if (data.des == "success") {
					if (data.content != null) {
						var html = "";
						var html2 = "";
						var shuliang = 0;
						if (data.content.healthReportPhotoList != null && data.content.healthReportPhotoList != "") {
							shuliang = data.content.healthReportPhotoList.length;
							jQuery.each(data.content.healthReportPhotoList,function(i, item) {
								if (i == 0) {
									html += "<div class=\"item active\" tag=\"pic" + (i + 1) + "\" >";
								} else {
									html += "<div class=\"item\" tag=\"pic" + (i + 1) + "\" >";
								}
								html += "<img style=\"width:100%;\" src=\"" + item.photoUrl + "?random=" + Math.random() + "\"></div>";
								//	if(item.title == null || item.title == ""){
								//		html += "<div class=\"carousel-caption\">" + (i+1) + "/" + shuliang + "  无</div></div>";
								//	}else{
								//		html += "<div class=\"carousel-caption\">" + (i+1) + "/" + shuliang + "  " + item.title + "</div></div>";
								//	}
								if (item.des == null || item.des == "") {
									item.des == "无描述";
								}
								if (item.title == null || item.title == "") {
									item.title == "无标题";
								}
								if (i == 0) {
									//html2 += "<h4>" + (i+1) + "/" + shuliang + "  " + item.title + "</h4>";
									html2 += "<div id=\"pic" + (i + 1) + "\"><h4>" + (i + 1) + "/" + shuliang + "&nbsp;&nbsp;" + item.title + "</h4><p>" + item.des + "</p></div>";
								} else {
									//html2 += "<h4 style=\"display:none\">" + (i+1) + "/" + shuliang + "  " + item.title + "</h4>";
									html2 += "<div id=\"pic" + (i + 1) + "\" style=\"display:none\"><h4>" + (i + 1) + "/" + shuliang + "&nbsp;&nbsp;" + item.title + "</h4><p>" + item.des + "</p></div>";
								}
							});
						}
						$("#tupianweizhi").html(html);
						$("#imageDes").html(html2);
					}
				} else if (data.des == "failure") {
					alert("查询失败");
				}
			},
			error: function() {
				alert("error");
			}
		});
	}
</script>
</body>
</html>