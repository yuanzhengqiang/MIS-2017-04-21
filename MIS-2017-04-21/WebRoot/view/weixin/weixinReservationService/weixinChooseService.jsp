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
<title>服务列表</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>	
.border1{border:#ccc 1px solid;border-left:0;border-top:0;}
.serviceFont{font-size:100%;text-align:center;}
.fontDiv{height:35%}
.servicesBox{min-height:80px;text-align:center;height:auto;max-height:320px}
.serviceImg{height:65%;width:auto;text-align:center;max-width:180px;max-height:180px;margin-top:20px}
.divBox{height: 100%;}
.imgDiv{height: 65%;}
@media only screen and (max-width:240px){
  .serviceFont{font-size:12px!important}
  .servicesBox{height:80px;text-align:center;}
}
@media only screen and (min-width:240px){
  .serviceFont{font-size:14px!important}
  .servicesBox{height:110px;text-align:center;}
}
@media only screen and (min-width:320px){
  .serviceFont{font-size:16px!important}
  .servicesBox{height:120px;text-align:center;}
}
@media only screen and (min-width:360px){
  .serviceFont{font-size:16px!important}
  .servicesBox{height:130px;text-align:center;}
}
@media only screen and (min-width:480px){
  .serviceFont{font-size:20px!important}
  .servicesBox{height:140px;text-align:center;}
  .divBox{left:14%;bottom:14%}
  .imgDiv{margin-bottom: 12px;}
}
@media only screen and (min-width:560px){
  .serviceFont{font-size:21px!important}
  .servicesBox{height:150px;text-align:center;}
}
@media only screen and (min-width:640px){
  .serviceFont{font-size:22px!important}
  .servicesBox{height:170px;text-align:center;}
}
@media only screen and (min-width:720px){
  .serviceFont{font-size:26px!important}
  .servicesBox{height:190px;text-align:center;}
}
@media only screen and (min-width:840px){
  .serviceFont{font-size:28px!important}
  .servicesBox{height:210px;text-align:center;}
}
@media only screen and (min-width:960px){
  .serviceFont{font-size:32px!important}
  .servicesBox{height:230px;text-align:center;}
}
@media only screen and (min-width:1080px){
  .serviceFont{font-size:36px!important}
  .servicesBox{height:250px;text-align:center;}
}
@media only screen and (min-width:1248px){
  .serviceFont{font-size:36px!important}
  .servicesBox{height:250px;text-align:center;}
}
@media only screen and (min-width:1444px){
  .serviceFont{font-size:36px!important}
  .servicesBox{height:250px;text-align:center;}
}
</style>
<script type="text/javascript" src="js/addressJS.js"></script>
</head>

<body>
	<div class="fixedTOP">
		<a href="###" class="logo">
        	<span style="">服务列表</span>
        </a> 
	</div>
	
	   <div class="container-fluid" style="height: auto;margin:0;padding:0;margin-top:70px;border-top:#ccc 1px solid;" id="navheight">
		<div class="row">
			<div class="content">
			
			</div>
		</div>

</body>
<script type="text/javascript">
		//获取服务项目类别
		function getfwxmtype(){
		var result = new Array();
		result = getAddresses(5187);
		var html="";
		var imgSrc = ""
		for(var i=0;i<result.length;i++){
			imgSrc = getIcon(result[i].name);
			html+="<div class=\"col-sm-4 col-xs-4 col-md-4 border1 servicesBox\" onclick=\"turnDetail(" + result[i].id + ")\"><div class=\"divBox\"><div class=\"imgDiv\"><img src=\"" + imgSrc + "\" class=\"serviceImg\"></div><div class=\"fontDiv\"><span class=\"serviceFont\">" + result[i].name + "</span></div></div></div>";
		}
		$("#navheight").html(html);
		}

		//跳转详情
		function turnDetail(typeId){
		  var headUrl = "<%=request.getContextPath()%>";
		  var url = headUrl+"/wechatReservationService.do?mainList&typeId="+typeId + "&weixin=weixin";
		  window.location.replace(url);
		}
	  
		//通过服务项目获取相关icon
		function getIcon(name){
			var imgName;
			switch (name)
			{
				case "基本护理":
				  imgName="weixinimages/basicCare.png";
				  break;
				case "临床护理":
				  imgName="weixinimages/clinicalCare.png";
				  break;
				case "中医康复":
				  imgName="weixinimages/rehabilitationMedicine.png";
				  break;
				case "康复训练":
				  imgName="weixinimages/rehabilitation.png";
				  break;
				case "日间照护中心":
				  imgName="weixinimages/careCenter.png";
				  break;
				case "长者照护之家":
				  imgName="weixinimages/careHome.png";
				  break;
				case "24小时看护":
				  imgName="weixinimages/allDayNurse.png";
				  break;
				case "上门洗浴":
				  imgName="weixinimages/dropWashBath.png";
				  break;
				case "生活介护":
				  imgName="weixinimages/lifeProtect.png";
				  break;
				case "其他":
				  imgName="weixinimages/other.png";
				  break;
				  
				default:
				  imgName="weixinimages/default.png";
			}
			return imgName
		}
    
	$(document).ready(function(){
		 getfwxmtype();
		 
		 var phoneH = $(window).height()-50; 		 
		 $("#navheight").css("min-height", phoneH+"px");		
		 
		//以上，页签样式调整 
	});
</script>
</html>
