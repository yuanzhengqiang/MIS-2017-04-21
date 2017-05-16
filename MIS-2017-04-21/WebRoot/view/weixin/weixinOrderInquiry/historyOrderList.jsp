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
		.orderInfo{
			height: auto;
		    margin: 0.2rem 0.16rem;
		    border-radius: 0.06rem;
		    overflow: hidden;
		    box-shadow: 0px 0px 0.1rem 0.01rem #DDDDDD;

		}
		.orderNum{
			height: 0.4rem;
			background-color: #92cc4a;
			font-size: 0.16rem;
		}
		.orderInfoType{
			height: 0.45rem;
			border-bottom: 1px solid #f1f1f1;
			background-color: #FFF;
			display:flex;
			display:-webkit-flex;
			font-size: 0.16rem;
		}
		.orderInfoDes{
			height: 0.45rem;
			background-color: #FFF;
			font-size: 0.16rem;
			display:flex;
			display:-webkit-flex;
		}
		.orderNumInfo{
			font-size: 0.12rem;
		    height: 0.4rem;
		    line-height: 0.4rem;
		    color: #FFF;
		    margin-left: 0.18rem
		}
		.orderTime{
			flex: 4;
			text-align: center;
			height: 0.45rem;
			line-height: 0.45rem;
		}
		.medicalTime{
			flex: 4;
			text-align: center;
			height: 0.45rem;
			line-height: 0.45rem;
		}
		.medicaler{
			flex: 3;
			text-align: center;
			height: 0.45rem;
			line-height: 0.45rem;
		}
		.progress{
			flex: 4;
			text-align: center;
			height: 0.45rem;
			line-height: 0.45rem;
		}
		.orderName{
			font-size: 0.12rem;
		    color: #414972;
		    height: 0.45rem;
		    line-height: 0.45rem;
		    font-weight: 600;
		    font-family: Microsoft YaHei;
		}
		.orderDes{
			font-size: 0.11rem;
		    color: #414972;
		    height: 0.45rem;
		    line-height: 0.45rem;
		    font-weight: 600;
		    font-family: SimHei ;
		}
		.hide{
			display: none;
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
		}
		.serviceContentInfo1{
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
		.serviceContentBtn{
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
		.serviceBtn{
			width: 100%;
		    height: 100%;
		    border: none;
		    background-color: #87cd50;
		    border-radius: 5px;
		    box-shadow: 2px 2px 5px 1px #ABCD83;
		    outline: none;
		    -webkit-appearance : none ;  /*解决iphone safari上的圆角问题*/
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
		<div class="header">
	        <span class="headerItem1 text-left">
	            <img src="wechatImg/return.png" class="headerImg left0" style="visibility: hidden;">
	        </span>
	        <span class="headerItem3 text-center">
	            <label class="headerName">历史订单</label>
	        </span>  
	        <span class="headerItem1 text-right">
	            <img src="wechatImg/service.jpg" class = "headerImg right0" id="service">
			</span>
	    </div>

		<div class="content" id="orderInfo">
			<!-- <div class="orderInfo">
				<div class="orderNum">
					<label class="orderNumInfo">订单编号:<span>95452156545</span></label>
				</div>
				<div class="orderInfoType">
					<div class="orderTime">
						<label class="orderName">下单时间</label>
					</div>
					<div class="medicalTime">
						<label class="orderName">体检时间</label>
					</div>
					<div class="medicaler">
						<label class="orderName">体检人</label>
					</div>
					<div class="progress">
						<label class="orderName">体检进度</label>
					</div>
				</div>
				<div class="orderInfoDes">
					<div class="orderTime">
						<label class="orderDes">2017.3.4</label>
					</div>
					<div class="medicalTime">
						<label class="orderDes">2017.3.12</label>
					</div>
					<div class="medicaler">
						<label class="orderDes">张三</label>
					</div>
					<div class="progress">
						<label class="orderDes">等待检查</label>
					</div>
				</div>
			</div> -->
		</div>
	</div>
	
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
		$(document).ready(function() {
	    	queryHistoryOrderList();
	    });
	    
	    //查询历史订单
	    function queryHistoryOrderList (){
	    	var openId = "<%=request.getAttribute("openId")%>";
	    	var reqmsg = "{'action':'QUERY_ORDER_LIST_REQUEST','page':{'pageno':'1','pagesize':'100000'},'content':{";
	    	reqmsg += "'orderCustomer':'" + openId + "'";
	    	reqmsg += "}}";
	    	
			var html = "";
			
		    jQuery.ajax({
		          type : "post",
		          async:true,
		          url : "order.do?handler",
		          dataType : "json",
		          data: {
		               "reqmsg":reqmsg,
		               "weixin":"weixin"             
		          },
		          success : function(data) {
		              if (data.des == "success") {
		            	 if (data.content != null) {
							if (data.content.orderList != null) {
								jQuery.each(data.content.orderList,function(i, item) {
									html += "<div class='orderInfo'>";
									html += "<div class='orderNum' onclick='jumpToDetails(" + item.id + ")'>";
									
									if (item.orderNum != null && item.orderNum != "") {
										if (item.orderNum.length > 20) {
											html += "<label class='orderNumInfo'>订单编号：<span>" + item.orderNum.substr(0,20) + "...</span></label>";
										} else {
											html += "<label class='orderNumInfo'>订单编号：<span>" + item.orderNum + "</span></label>";
										}
									} else {
										html += "<label class='orderNumInfo'>订单编号：<span>无</span></label>";
									}
									
									html += "</div>";
									html += "<div class='orderInfoType' onclick='jumpToDetails(" + item.id + ")'>";
									html += "<div class='orderTime'>";
									html += "<label class='orderName'>下单时间</label>";
									html += "</div>";
									html += "<div class='medicalTime'>";
									html += "<label class='orderName'>体检时间</label>";
									html += "</div>";
									html += "<div class='medicaler'>";
									html += "<label class='orderName'>体检人</label>";
									html += "</div>";
									html += "<div class='progress'>";
									html += "<label class='orderName'>体检进度</label>";
									html += "</div>";
									html += "</div>";
									html += "<div class='orderInfoDes' onclick='jumpToDetails(" + item.id + ")'>";
									html += "<div class='orderTime'>";
									if (item.orderTime != null && item.orderTime != "") {
										html += "<label class='orderDes'>" + formateTime(item.orderTime) + "</label>";
									} else {
										html += "<label class='orderDes'>无</label>";
									}
									html += "</div>";
									html += "<div class='medicalTime'>";
									if (item.medicalCompleteTime != null && item.medicalCompleteTime != "") {
										html += "<label class='orderDes'>" + formateTime(item.medicalCompleteTime) + "</label>";
									} else {
										html += "<label class='orderDes'>预约中</label>";
									}
									html += "</div>";
									html += "<div class='medicaler'>";
									html += "<label class='orderDes'>" + item.medicalPersonName + "</label>";
									html += "</div>";
									html += "<div class='progress'>";
									html += "<label class='orderDes'>" + matchingState(item.status) + "</label>";
									html += "</div>";
									html += "</div>";
									html += "</div>";
								});
								$("#orderInfo").html(html);
							}
						 }
		              } else {
		                  alert("查询历史订单失败");
		              }
		          },
		          error:function() {
			          alert("查询历史订单失败");
		          }
		     });
	    }
	    	
	    //格式化时间
	    function formateTime(time) {
			var timeFormate = "";
			if (time != null && time.length == 14) {
				timeFormate = time.substring(0, 4) + "." + time.substring(4, 6) + "."
						+ time.substring(6, 8);
			}
			return timeFormate;
		}
		
		//匹配订单状态
		function matchingState(state) {
			var name = "";
			switch (state) 
			{
				case 1:
				name = "等待体检";
	  			break;
	  			
	  			case 2:
				name = "体检完成";
	  			break;
	  			
				case 3:
				name = "报告生成";
	  			break;
	  			
	  			case 4:
				name = "取消";
	  			break;
	  			
				default:
	  			break;
			}
			return name;
		}
		
		//跳转到订单详情页
		function jumpToDetails(id) {
			window.location.replace("<%=request.getContextPath()%>/" + "weixinOrderInquiry.do?orderDetails&orderId=" + id + "&weixin=weixin");
		}
		
		$("#service").on("click", function() {
			$(".model").css("display","block");
			$(".serviceBox").css("display","block");
		});
		$(".model").on("click", function() {
			$(".model").css("display","none");
			$(".serviceBox").css("display","none");
		});
	</script>
</body>
</html>