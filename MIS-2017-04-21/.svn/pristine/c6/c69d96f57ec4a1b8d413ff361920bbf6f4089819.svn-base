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
<title>服务介绍</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<link rel="stylesheet" href="weixinjs/jquery.mobile-1.3.2.min.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/jquery.mobile-1.3.2.min.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>
</style>
</head>
<body>
	<div class="fixedTOP">		
		<h3 id="fuwu_name">无</h3>
		<a href="###" class="logo" onclick="tiaozhuan()">
        	<span class="glyphicon glyphicon-chevron-left"></span>
        </a>
	</div>
	<div class="container">
		<input type="hidden" value="0" id="serviceId_hide">
		<input type="hidden" value="" id="typeId_hide">
		<div class="row" style="background:#fff;margin-top:50px">
			<div class="col-xs-12" style="text-align:center">
				<h4><span id="name">无</span><small><span id="money_time">无</span></small></h4>			 
			</div>
		</div>
        <div class="row">
            <div class="col-xs-12" style="padding-left:0;padding-right:0;">
				<div id="myCarousel" class="carousel slide" >	
				<div class="carousel-inner" id="tupianneirong">
					<!-- <div class="item active" tag="pic1" >  
						<img src="weixinimages/slide1.png"  >
								 
					</div>
					<div class="item" tag="pic2" >
						<img src="weixinimages/slide2.png"  >
						
					</div>
					<div class="item" tag="pic3" >
						<img src="weixinimages/slide3.png" >
						
					</div> -->
				</div>	
				<!-- 左右示意 -->
					<span class="carousel-control left" >&lsaquo;</span>
					<span class="carousel-control right" >&rsaquo;</span>			
				</div>
				
				
			</div> 
		</div>
		<div class="row" style="background:#fff;padding-top:15px">
		<div class="col-xs-12">
			<p>服务子项：</p>
			<p id="fuwuzixiang">无</p>
		</div>
	</div>
	<div class="row" style="background:#fff;margin-top:15px;margin-bottom:60px">
	   <div class="col-xs-12" style="margin-bottom:10px">图文详情：</div>
	   <div class="col-xs-12" id="xmjianjie">暂无</div>
	</div>
	</div>
	


		<div class="fixedBOTTOM1" onclick="turnOrder()">
			<button type="button" class="btn btn-success " style="width:100%" >立即预约</button>
		</div>
	
</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
	var id = "<%=request.getAttribute("id")%>";
	$("#serviceId_hide").val(id);
	queryService(id);

	
	//$('#myCarousel').carousel('cycle');
	 var phonew = $(window).width();
	 $("#myCarousel img").css("width",phonew+"px");
	$('#myCarousel').carousel({	
		interval: false //不自动轮播
	});

	//手势右滑 回到上一个画面
    $('#myCarousel').bind('swiperight swiperightup swiperightdown',function(){
       $("#myCarousel").carousel('prev');     
       

    });
    //手势左滑 进入下一个画面
    $('#myCarousel').bind('swipeleft swipeleftup swipeleftdown',function(){

        $("#myCarousel").carousel('next');      

    });
});

	 //页面跳转
     function tiaozhuan(){
    	 var typeId=$("#typeId_hide").val();
    	 var headUrl = "<%=request.getContextPath()%>";
    	 var url = headUrl+"/wechatReservationService.do?mainList&typeId="+typeId + "&weixin=weixin";
		 window.location.replace(url);
     }

	function queryService(id){
		var reqmsg="{'action':'QUERY_SERVICE_INFO_REQUEST','content':{\"serviceChildListShow\":\"true\",\"servicePhotoListShow\":\"true\",\"id\":"+id+"}}";
		
		var html = "";
		
		  jQuery.ajax({
          type : "post",
          async:false,
          url : "service.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des=="success"){
              		if(data.content != null) {
              			$("#fuwu_name").html(data.content.name);
              			$("#name").html(data.content.name);
              			$("#money_time").html("—" + data.content.marketPrice + "元");
              			$("#typeId_hide").val(data.content.typeId);
 						//图片
 						if(data.content.servicePhotoList != null && data.content.servicePhotoList != ""){
							jQuery.each(data.content.servicePhotoList, function(i, item) {
								if(i == 0){
									html += "<div class=\"item active\" tag=\"pic" + (i+1) + "\" >";
								}else{
									html += "<div class=\"item\" tag=\"pic" + (i+1) + "\" >";
								}
								html += "<img src=\"" + item.photoUrl + "?random=" + Math.random() + "\">";
								html += "</div>";
							});
							$("#tupianneirong").html(html);
						}
						
						//子项
 						if(data.content.serviceChildList != null && data.content.serviceChildList.length > 0){
							var fuwuzixiang = "";
 							for(var i=0;i < data.content.serviceChildList.length;i++){
 								fuwuzixiang += data.content.serviceChildList[i].name + ",";
 							}
 							if(fuwuzixiang != ""){
 								fuwuzixiang = fuwuzixiang.substr(0,fuwuzixiang.length-1);
 							}
							$("#fuwuzixiang").html("&nbsp;&nbsp;&nbsp;" + fuwuzixiang);
 						}
 						
						if(data.content.profile != null && data.content.profile != ""){
							var xmjianjieHtml = data.content.profile;
              				xmjianjieHtml = xmjianjieHtml.replace(/\'/g, "\"");
              				$("#xmjianjie").html(xmjianjieHtml);
						}
					}
              }else if(data.des=="failure"){
                 alert("查询失败");
              }
          },
          error:function(){
	           alert("error");
          }
    	 });
	}
	
	//跳转预约
	function turnOrder(){
		var id = $("#serviceId_hide").val();
		var headUrl = "<%=request.getContextPath()%>";
   	 	var url = headUrl+"/wechatReservationService.do?mainOrder&id=" + id + "&weixin=weixin";
		window.location.replace(url);
	}

</script>