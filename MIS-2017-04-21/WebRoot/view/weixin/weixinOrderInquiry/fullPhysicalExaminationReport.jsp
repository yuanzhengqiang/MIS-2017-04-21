<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<title>报告详情</title>
<style>
		html{font-size: 100px;}
        body{
            padding:0;
            margin:0;
        }
		.container-fluid {
			margin: 0px;
			padding: 0px;
			height:100%; 
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
            box-shadow: 0.02rem 0.04rem 0.1rem #DDD;
        }
		.margin0{
			margin:0px;
		}
		
		.inlineBlock{
			display:inline-block;
		}
		.header{
			background:-moz-linear-gradient(left,#8ACA38,#5FA835);
			background:-webkit-linear-gradient(left,#8ACA38,#5FA835);
			background:linear-gradient(left,#8ACA38,#5FA835);
			padding: 0rem 0.15rem;
			height: 0.32rem;
			display:flex;
			display:-webkit-flex;
		}
		.headerItem1{
			flex:1;
			display: inline-block;
			position: relative;
		}
		.headerItem3{
			flex:3;
			color: #FFF;
			font-size: 0.16rem;
			margin-bottom: 0px;
			font-weight: 700;
			display: inline-block;
		}
		.headerImg{
			width: 0.2rem;
			height: 0.2rem;
			position: absolute;
		    top: 50%;
    		webkit-transform: translateY(-50%);
			-moz-transform: translateY(-50%);
			-ms-transform: translateY(-50%);
			transform: translateY(-50%);
		}
		.headerName{
			display: inline-block;
		    letter-spacing: 0.03rem;
		    line-height: 0.32rem;
			height: 0.32rem;
		}
		.content{
			height: auto;
			width: 100%;
			background-color: #f1f1f1;
			overflow-y:auto; 
			position: absolute;
			top: 0.32rem;
			bottom:0rem;
		}
		.borderBottomNone{
			border-bottom: transparent;
		}
		.block{
			display: block;
		}
		.right0{
			right:0;
		}
		.left0{
			left:0;
		}
		.top11{
			top: 0.11rem;
		}
		.progress{
			flex: 4;
			text-align: center;
			height: 0.45rem;
			line-height: 0.45rem;
		}
		.expressageInfo{
			height: auto;
		    margin: 0.05rem 0.16rem;
		    border-radius: 0.06rem;
		    overflow: hidden;
		    box-shadow: 0px 0px 0.1rem 0.01rem #DDDDDD;
			display:flex;
			display:-webkit-flex;
		}
		.expressageLeft{
			flex: 2;
			background:-moz-linear-gradient(left,#89ca39,#91d33f);
			background:-webkit-linear-gradient(left,#89ca39,#91d33f);
			background:linear-gradient(left,#89ca39,#91d33f);
			text-align: center;
		}
		.expressageLeftImg{
			width: 0.24rem;
			height: 0.24rem;
			display: block;
		}
		.expressageLeftText{
			font-size: 0.12rem;
		}
		.expressageRight{
			flex: 5;
			background-color: #FFF;
		}
		.expressageRightTop{
			height: 0.6rem;
			display:flex;
			display:-webkit-flex;
			font-size: 0.16rem;
		}
		.expressageRightTopLeft{
			height: 0.6rem;
			flex: 3;
			text-align: left;
			margin-left: 0.15rem;
		}
		.expressageRightTopRight{
			height: 0.6rem;
			flex: 4;
			text-align: left;
			margin-right: 0.15rem;
		}
		.orderName{
			color: #aeaeae;
		    font-size: 0.12rem;
		    display: block;
		    height: 0.12rem;
		    line-height: 0.12rem;
		    margin-top: 0.15rem;
		}
		.orderNameDes{
			color: #414972;
		    font-size: 0.12rem;
		    display: block;
		    height: 0.12rem;
		    line-height: 0.12rem;
		    margin-top: 0.08rem;
		}
		.expressageRightBottom{
			min-height: 0.5rem;
			text-align: left;
			margin: 0rem 0.15rem;
			font-size: 0.16rem;
			padding-bottom: 0.15rem;
		}
		.siteName{
			color:#aeaeae;
			font-size: 0.12rem;
			display: block;
			margin-top: 0.1rem;
		}		
		.siteDes{
			font-size: 0.12rem;
			display: block;
			margin-top: 0.06rem;
			color: #414972;
		}
		.expressageLeftImg{
			width: 0.24rem;
		    height: 0.24rem;
		    display: block;
		    margin: 0 auto;
		    margin-top: 0.45rem;
		}
		.expressageLeftText{
			font-size: 0.12rem;
		    height: 0.2rem;
		    line-height: 0.2rem;
		    color: #FFF;
		    display: block;
		    margin-top: 0.05rem;
		}
		.border1{
			background: -webkit-linear-gradient(left,#fff,#e9e9e9,#FFF);
		    height: 0.01rem;
		    width: 100%;
		}
		.downloadInfo{
			height: auto;
		    margin: 0.2rem 0.16rem;
		    border-radius: 0.06rem;
		    overflow: hidden;
		    box-shadow: 0px 0px 0.1rem 0.01rem #DDDDDD;
			display:flex;
			display:-webkit-flex;
		}
		.downloadLeft{
			flex: 2;
			background:-moz-linear-gradient(left,#64a2d8,#5194cd);
			background:-webkit-linear-gradient(left,#64a2d8,#5194cd);
			background:linear-gradient(left,#64a2d8,#5194cd);
			text-align: center;
			height: 0.8rem;
		}
		.downloadLeftImg{
			width: 0.24rem;
		    height: 0.24rem;
		    display: block;
		    margin: 0 auto;
		    margin-top: 0.16rem;
		}
		.downloadLeftText{
			font-size: 0.12rem;
		    height: 0.2rem;
		    line-height: 0.2rem;
		    color: #FFF;
		    display: block;
		    margin-top: 0.05rem;
		}
		.downloadRight{
			flex: 5;
			background-color: #FFF;
			display:flex;
			display:-webkit-flex;
			height: 0.8rem;
		}
		.downloadRightLeft{
			margin: 0rem 0.15rem;
		    width: 1.5rem;
		    text-align: left;
		    flex: 9;
		    letter-spacing: 0.01rem;
		}
		.downloadRightRight{
			margin-right: 0.15rem;
			width: 0.16rem;
			height: 0.16rem;
			text-align: right;
			flex: 2;
			font-size: 0.16rem;
		}
		.downloadRightImg{
			width: 0.16rem;
			height: 0.16rem;
			margin-top: 0.32rem;
		}
		.downloadRightLeftDes{
			color: #414972;
		    font-size: 0.12rem;
		    display: block;
		    height: 0.12rem;
		    line-height: 0.2rem;
		    margin-top: 0.2rem;
		}
		.detail{
			margin: 0 auto;
		    text-align: center;
		    font-size: 0.16rem;
		    margin-top: 0.4rem;
		    margin-bottom: 0.1rem;
		}
		.detailText{
			font-size: 0.11rem;
			color: #aeaeae;
		}
		.hide{
			display: none;
		}
	</style>
</head>
<body id="body" class="hide">
	<div class="container-fluid">
		<div class="header">
	        <span class="headerItem1 text-left">
	            <img src="wechatImg/return.png" class="headerImg left0" onclick="returnPage()">
	        </span>
	        <span class="headerItem3 text-center">
	            <label class="headerName">报告详情</label>
	        </span>  
	        <span class="headerItem1 text-right">
	        	<img src="wechatImg/service.jpg" class = "headerImg right0" onclick="$('#fixedDialingNumbers').click();">
				<a href="tel:10086" style="display:none;"><span id="fixedDialingNumbers">一键拨号</span></a>
	        </span>
	    </div>
		
		<div class="content">
			<div class="detail">
				<span class="detailText">体检资料（发票及体检报告等）快递信息</span>
			</div>
			<div class="expressageInfo">
				<div class="expressageLeft">
					<img src="wechatImg/expressage.png" class="expressageLeftImg">
					<label class="expressageLeftText" class="expressageLeftText">快递地址</label>
				</div>
				<div class="expressageRight">
					<div class="expressageRightTop">
						<div class="expressageRightTopLeft">
							<label class="orderName">姓名</label>
							<label class="orderNameDes" id="medicalPersonName"></label>
						</div>
						<div class="expressageRightTopRight">
							<label class="orderName">联系方式</label>
							<label class="orderNameDes" id="contactWay"></label>
						</div>
					</div>
					<div class="border1"></div>
					<div class="expressageRightBottom">
						<label class="siteName">地址</label>
						<label class="siteDes" id="reportSendAddr"></label>
					</div>
				</div>
			</div>
			<div class="downloadInfo">
				<div class="downloadLeft">
					<img src="wechatImg/download.png" class="downloadLeftImg">
					<label class="downloadLeftText" class="downloadLeftText">快递地址</label>
				</div>
				<div class="downloadRight" onclick="$('#downloadFile').submit();">
					<div class="downloadRight">
						<div class="downloadRightLeft">
							<label class="downloadRightLeftDes">体检报告完整内容PDF下载链接及在浏览器打开说明</label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form action="document.do?download&weixin=weixin" id="downloadFile" method="post" style="display:none;">
    	<input type="text" style="display:none;" name="medicalReportId" id="medicalReportId" value="<%=request.getAttribute("id")%>">
    	<input type="text" style="display:none;" name="filePath" id="filePath" value="">
    	<input type="submit" value="Submit"  style="display:none;"/>
    </form>
	
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
		    (function(){
		        return;
		        var dpr = scale =1;
		         var isIPhone = win.navigator.appVersion.match(/iphone/gi);
		        var devicePixelRatio = win.devicePixelRatio;
		        if (isIPhone) {
		            // iOS下，对于2和3的屏，用2倍的方案，其余的用1倍方案
		            if (devicePixelRatio >= 3 && (!dpr || dpr >= 3)) {                
		                dpr = 3;
		            } else if (devicePixelRatio >= 2 && (!dpr || dpr >= 2)){
		                dpr = 2;
		            } else {
		                dpr = 1;
		            }
		        } else {
		            // 其他设备下，仍旧使用1倍的方案
		            dpr = 1;
		        }
		           scale = 1 / dpr;
		           
		           // 
		           var metaEl = "";
		           metaEl = doc.createElement('meta');
		        metaEl.setAttribute('name', 'viewport');
		        metaEl.setAttribute('content', 'initial-scale=' + scale + ', maximum-scale=' + scale + ', minimum-scale=' + scale + ', user-scalable=no');
		        if (docEl.firstElementChild) {
		            docEl.firstElementChild.appendChild(metaEl);
		        } else {
		            var wrap = doc.createElement('div');
		            wrap.appendChild(metaEl);
		            doc.write(wrap.innerHTML);
		        }
		    })();
		    document.getElementById('body').removeAttribute('class','hide');       
		})(document, window); 
	</script>
	<script type="text/javascript">
		//返回前一页
		function returnPage(){
			var orderId = "<%=request.getAttribute("orderId")%>";
			window.location.replace("<%=request.getContextPath()%>/" + "weixinOrderInquiry.do?orderDetails&orderId=" + orderId + "&weixin=weixin");
		}
		
		$(document).ready(function() {
			var orderId = "<%=request.getAttribute("orderId")%>";
			queryOrderReport(orderId);//查询订单报告信息
		});
		
		//查询订单报告信息
	    function queryOrderReport(orderId) {
	    	var reqmsg = "{'action':'QUERY_ORDER_INFO_REQUEST','content':{'medicalReportShow':'true','id':" + orderId + "}}";
			jQuery.ajax({
				type : "post",
	          	async:true,
	          	url : "order.do?handler",
	          	dataType : "json",
	          	data: {
	            	"reqmsg":reqmsg,
	            	"weixin":"weixin"
	          	},
	          	success : function(data){
	            	if (data.des == "success") {
	              		if (data.content != null) {
	              			$("#medicalPersonName").html(data.content.medicalPersonName);
	              			$("#contactWay").html(data.content.contactWay);
	              			$("#reportSendAddr").html(data.content.reportSendAddr);
								
	              			if (data.content.medicalReport != null && data.content.medicalReport != "") {
	              				if (data.content.medicalReport.medicalReportDownloadLink != null && data.content.medicalReport.medicalReportDownloadLink != "") {
	              					$("#medicalReportId").val(data.content.medicalReport.id);
	              					$("#filePath").val(data.content.medicalReport.medicalReportDownloadLink);
	              				}
	              			}
						}
					} else {
	                	alert("查询订单报告信息失败");
	                }
	          	},
	          	error:function(){
		        	alert("查询订单报告信息失败");
	          	}
			});
	    }
	    
	</script>
</body>
</html>