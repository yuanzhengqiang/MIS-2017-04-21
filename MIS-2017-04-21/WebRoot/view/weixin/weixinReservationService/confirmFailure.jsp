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
			background-color: #FFF;
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
		.payInfo{
			height: auto;
    		text-align: center;
    		margin-top: 1.15rem;
		}
		.payImg{
			width: 0.5rem;
			height: 0.5rem;
			display:block;
			margin: 0px auto;
		}
		.payStatus{
			font-size: 0.2rem;
		    display: block;
		    color: #30537e;
		    margin-top: 0.25rem;
		    font-weight: 600;
		}
		.btnGroup{
			margin-top: 0.25rem;
		}
		.btn{
			height: 0.4rem;
		    font-size: 0.16rem;
		    margin: 0.12rem 0.5rem;
		}
		.btn1Info{
			width: 100%;
		    height: 100%;
		    outline: none;
		    border: 2px solid #30537f;
		    border-radius: 0.1rem;
		    font-size: 0.12rem;
		    color: #30537e;
		    letter-spacing: 0.08rem;
		    background-color: #FFF;
		    font-weight: 600;
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
	            <img src="wechatImg/return.png" class="headerImg left0" onclick="returnPage()" style="visibility: hidden;">
	        </span>
	        <span class="headerItem3 text-center">
	            <label class="headerName">下单失败</label>
	        </span>  
	        <span class="headerItem1 text-right">
	        	<img src="wechatImg/service.jpg" class = "headerImg right0" id="service">
			</span>
	    </div>

		<div class="content">
			<div class="payInfo">
				<img src="wechatImg/failure.png" class="payImg">
				<label class="payStatus">下单失败</label>
			</div>
			<div class="btnGroup">
		    	<div class="btn">
		    		<button class="btn1Info" onclick="returnSelectMedicalInfo()">重新下单</button>
		    	</div>
		    </div>
		</div>
	</div>
	
	<div class="serviceBox">
    	<div class="modelContent2">
			<div class="modelContentInfo2 text-center">
				<div class="text-center margin1">身边 · 24小时服务电话</div>
				<div class="text-center margin1" style="color: #62698D">1855-0065-068</div>
				<a href="tel:18550065068" class="hide"><span id="fixedDialingNumbers">一键拨号</span></a>
			</div>
			<div class="text-center">
				<button class="promptly" onclick="$('#fixedDialingNumbers').click();$('.model').css('display','none');$('.serviceBox').css('display','none');">立 即 拨 打</button>
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
		/* function returnPage(){
			window.location.href="https://yuanzhengqiang.github.io/WechatTest/medicalInfo.html"; 
		} */
		function returnSelectMedicalInfo(){
			window.location.replace("<%=request.getContextPath()%>/" + "weixinReservationService.do?chooseAreaAndHospital&weixin=weixin");
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