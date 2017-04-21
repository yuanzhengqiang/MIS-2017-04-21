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
<title>下单结果</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>	
.nav>li>a:hover, .nav>li>a:focus{background:#fff}
.nav>li>a, .nav>li>a{background:#eee}
.nav-stacked>li+li{margin-top:0}
.table{margin-top:-1px}
.table tr td{border:0;}
.table td img{width:50px;height:auto;border:0;border-radius:50%;}
.table td:nth-child(1){width:70px;min-width: 60px; vertical-align:middle}
.table td:nth-child(2){text-align:left;padding-left:0;padding-right:0;vertical-align:middle}
.table td:nth-child(2) p{text-indent:0}
.table td:nth-child(3){text-align:right;width:80px;padding-left:0;padding-right:8px;vertical-align:middle}

</style>
<script type="text/javascript" src="js/addressJS.js"></script>
</head>

<body>
	<div class="fixedTOP">
		<a href="###" class="logo">
        	<span style="">下单结果</span>
        </a> 
	</div>
	<div style="margin-top:48px;">
		<img src="weixinimages/orderSuccess.png" width="100%" >
	</div>
	<div style="margin-top:20px;">
		<img src="weixinimages/orderSuccessBut.png" width="100%" onclick="back()">
	</div>
</body>
<script type="text/javascript">
	function back(){
		window.location.replace("<%=request.getContextPath()%>/" + "wechatReservationService.do?main&weixin=weixin");
	}
	
	$(document).ready(function(){

	});
</script>
</html>
