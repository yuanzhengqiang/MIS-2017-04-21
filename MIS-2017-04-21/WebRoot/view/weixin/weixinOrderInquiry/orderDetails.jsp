<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<title>订单详情</title>
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
			background-color: #f7f7f7;
			overflow-y:auto; 
			position: absolute;
			top: 0.32rem;
			bottom:0.45rem;
		}
		.footer1{
			height: 0.45rem;
			position: absolute;
    		bottom: 0px;
   			width: 100%;
   			overflow: hidden;
   			display:flex;
			display:-webkit-flex;
		}
		.footer2{
			height: 0.45rem;
			position: absolute;
    		bottom: 0px;
   			width: 100%;
   			overflow: hidden;
   			display:flex;
			display:-webkit-flex;
			border-top: 0.01rem solid #5B8BC9;
		}
		.orders{
			flex:2;
			display: inline-block;
			background-color: #5B8BC9;
			font-size: 0.16rem;
		}
		.btn{
			background: transparent;
		    border: none;
		    width: 100%;
		    height: 0.45rem;
		    color: #FFF;
		    letter-spacing: 0.03rem;
		    outline: none;
		    font-size: 0.14rem;
		    -webkit-appearance : none ;  /*解决iphone safari上的圆角问题*/
		}

		.personalInfo{
		    height: auto;
		    margin: 0.20rem 0.16rem 0.15rem;
		    border-radius: 0.1rem;
		    background-color: #FFF;
		    box-shadow: 0px 0px 0.1rem 0.01rem #DDDDDD;
		    font-size: 0.16rem;
		    overflow: hidden;
		}
		.personalName{
			height: 0.45rem;
    		padding: 0px 0.1rem;
    		display:flex;
			display:-webkit-flex;
			border-bottom: 0.01rem solid #F2F2F2;
		}
		.personalNameLeft{
			flex:2;
			display: inline-block;
		    text-align: left;
		    vertical-align: sub;
		    padding: 0rem 0.1rem;
		    height: 0.45rem;
		}
		.personalNameLeftImg{
			position: relative;
    		width: 0.16rem;
    		height: 0.16rem;
    		top: 0.03rem;
		}
		.personalNameLeftText{
			color: #434B76;
		    font-size: 0.12rem;
		    margin-left: 0.05rem;
		    font-weight: 700;
		    line-height: 0.45rem;
		}
		.personalNameRight{
			flex: 3;
		    padding-right: 0.1rem;
		    height: 0.45rem;
		    line-height: 0.45rem;
		    text-align: right;
		}
		.personalNameRightInput{
			height: 0.3rem;
		    border: none;
		    outline: none;
		    text-align: right;
		    width: 100%;
		    font-size: 0.12rem;
		    background-color: transparent;
		    border-left: 0.01rem solid #f2f2f2;
		    padding: 0rem;
		}
		::-webkit-input-placeholder {
			color: #CFCFCF;
			font-size: 0.12rem;
			text-align: right;
		}
		::-moz-placeholder {
			color: #CFCFCF;
			font-size: 0.12rem;
			text-align: right;
		}
		
		.medicalInfo{
		    height: auto;
		    margin: 0.15rem 0.16rem 0rem;
		    border-radius: 0.1rem;
		    background-color: #FFF;
		    box-shadow: 0px 0px 0.1rem 0.01rem #DDDDDD;
		    font-size: 0.16rem;
		    position: relative;
		}
		.hospitalNameLeftImg{
			width: 0.18rem;
    		height: 0.18rem; 
    		position: relative;
		    top: 0.05rem;
		}
		.hospitalNameRight{
			flex: 1;
		    text-align: right;
		    font-size: 0.12rem;
		    padding-right: 0.1rem;
		    font-weight: 600;
		    color: #424f72;
		    letter-spacing: 0.01rem;
		    font-family: Microsoft YaHei;
		}
		.hospitalNameRightText{
			height: 0.4rem;
    		line-height: 0.4rem;
		}
		.medicalName{
			height: 0.4rem;
    		padding: 0px 0.1rem;
    		display:flex;
			display:-webkit-flex;
			border-bottom: 0.01rem solid #F2F2F2;
		}
		.medicalNameLeft{
			flex: 3;
		    display: inline-block;
		    text-align: left;
		    vertical-align: sub;
		    padding: 0rem 0.1rem;
		    height: 0.5rem;
		}
		.medicalNameLeftText{
		    color: #434B76;
		    font-size: 0.12rem;
		    margin-left: 0.1rem;
		    font-weight: 700;
		    line-height: 0.5rem;
		    font-family: SimHei;
    	}
		
		.medicalNameCenter{
			flex: 3;
		    text-align: left;
		    padding-left: 0.1rem;
		}
		.medicalNameRight{
		    flex: 2;
		    display: inline-block;
		    padding-right: 0.1rem;
		    text-align: right;
		}
		.medicalNameRightText{
			height: 0.5rem;
			line-height:0.5rem;
			color: #405081;
			font-size: 0.12rem;
			font-weight: 600;
		}
		.medicalNameCenterText{
			height: 0.5rem;
		    line-height: 0.5rem;
		    color: #858585;
		    font-size: 0.1rem;
		}
		.orderBtn{
			width: 100%;
		    height: 100%;
		    border: none;
		    background-color: #87cd50;
		    border-radius: 0.05rem;
		    box-shadow: 0.02rem 0.02rem 0.05rem 0.01rem #ABCD83;
		    outline: none;
		    -webkit-appearance : none ;  /*解决iphone safari上的圆角问题*/
		}
		.borderBottomNone{
			border-bottom: transparent;
		}
		.block{
			display: block;
		}
		.seviceCostImg{
			cursor: pointer;
		    position: relative;
		    width: 0.14rem;
		    height: 0.14rem;
		    top: 0.02rem;
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
		.gender{
			margin: 0rem 0.05rem;
		    position: relative;
		    top: 0.03rem;
		}
		.hide{
			display: none;
		}
		.labelInfo{
			margin: 0rem 0.2rem;
		}
		.unit{
			font-size: 0.055rem;
		    color: #000;
		    font-weight: 300;
		    position: relative;
		    top: -0.01rem;
		}
		.costNameDes{
		    height: 0.45rem;
		    line-height: 0.45rem;
		    display: inline-block;
		    position: relative;
    		top: 0.007rem;
		}
		.colorGray{
			background-color: #DDD;
		}
		.dim{
			-moz-filter: blur(5px);
		    -webkit-filter: blur(5px);
		    -o-filter: blur(5px);
		    -ms-filter: blur(5px);
		    filter: blur(5px);
		}
		.shade{
			position: absolute;
		    left: 0;
		    top: 0;
		    bottom: 0;
		    right: 0;
		    width: 100%;
		    height: 100%;
		    z-index: 99;
		    opacity: 0.75;
		    background-color: #284166;
		    border-radius: 10px;
		    text-align: center;
		}
		.notPay{
			margin: 0rem auto;
		    margin-top: 0.35rem;
		    display: block;
		    width: 0.28rem;
		    height: 0.15rem;
		}
		.notPayDes{
			display: block;
		    margin-top: 0.16rem;
		    color: #FFF;
		    font-size: 0.10rem;
    		letter-spacing: 0.02rem;
		}
		.progressInfo{
			height: auto;
		    margin: 0rem 0.16rem;
		    border-radius: 0.1rem;
		    background-color: #FFF;
		    box-shadow: 0px 0px 0.1rem 0.01rem #DDDDDD;
		    font-size: 0.16rem;
		    padding: 0.18rem 0rem;
		}
		.progressName{
			display: flex;
		    text-align: center;
		    font-size: 0.12rem;
		    font-weight: 700;
		    color: #71b341;
		    font-family: SimHei;
		}
		.progressNameDes{
			flex: 1;
		}
		.progressStatus{
			display: flex;
		    text-align: center;
		    font-size: 0.12rem;
		    font-weight: 700;
		    color: #71b341;
		    font-family: SimHei;
		    margin: 0.08rem 0rem;
		}
		.progressStatusDes{
			flex: 1;
		}
		.progressStatusDesLight{
			background-color: #a1d460;
			width: 0.18rem;
			height: 0.18rem;
			border-radius: 0.09rem;
		    display: inline-block;
		}
		.progressStatusDesDark{
			background-color: #dadada;
			width: 0.18rem;
			height: 0.18rem;
			border-radius: 0.09rem;
			display: inline-block;
		}
		.progressDes{
			display: flex;
		    text-align: center;
		    font-size: 0.10rem;
		    font-weight: 400;
		    color: #606060;
		}
		.progressDesDes{
			flex: 1;
		}
		.progressStatusImg{
	    	width: 2.1rem;
		    height: 0.18rem;
		    display: inline-block;
		    margin: 0 auto;
		}
		.orderNum{
			height: 0.4rem;
		    background-color: #92cc4a;
		    font-size: 0.16rem;
		}
		.orderNumInfo{
			font-size: 0.12rem;
		    height: 0.4rem;
		    line-height: 0.4rem;
		    color: #FFF;
		    margin-left: 0.18rem
		}
		.personalImg{
			width: 0.3rem;
		    height: 0.3rem;
		    position: relative;
		    top: 0.08rem;
		    border-radius: 0.15rem;
		}
		.padding2015{
			padding: 0.2rem 0.15rem;
		}
		.medicalConclusion{
			font-size: 0.12rem;
			height: auto;
			line-height: 0.18rem;
		}
		.heightAuto{
			height: auto;
		}
		.overflowH{
			max-height: 2rem;
    		overflow: hidden;
		}
		.btnRight{
			background: transparent;
		    border: none;
		    width: 100%;
		    height: 0.45rem;
		    color: #FFF;
		    letter-spacing: 0.02rem;
		    outline: none;
		    font-size: 0.14rem;
		    font-family: SimHei;
		    -webkit-appearance: none;
		}
		.btnLeft{
			background: #FFF;
		    border: none;
		    width: 100%;
		    height: 0.45rem;
		    color: #434B76;
		    letter-spacing: 0.02rem;
		    outline: none;
		    font-size: 0.14rem;
		    font-family: SimHei;
		    -webkit-appearance: none;
		}
		.leftImg, .rightImg{
			width: 0.14rem;
		    height: 0.14rem;
		    position: relative;
		    top: 0.03rem;
		    margin: 0px 0.03rem;
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
	            <label class="headerName">订单详情</label>
	        </span>  
	        <span class="headerItem1 text-right">
	        	<img src="wechatImg/service.jpg" class = "headerImg right0" onclick="$('#fixedDialingNumbers').click();">
				<a href="tel:10086" style="display:none;"><span id="fixedDialingNumbers">一键拨号</span></a>
	        </span>
	    </div>

		<div class="content">
			<div class="personalInfo">
				<div class="personalName">
					<div class="personalNameLeft">
						<img src="wechatImg/personal.png" class="inlineBlock personalNameLeftImg">
						<label class="inlineBlock personalNameLeftText">体检人姓名</label>
					</div>
					<div class="personalNameRight inlineBlock">
						<label class="inlineBlock personalNameLeftText" id="medicalPersonName"></label>
					</div>
				</div>
				<div class="personalName">
					<div class="personalNameLeft">
						<img src="wechatImg/hospital.png" class="inlineBlock personalNameLeftImg">
						<label class="inlineBlock personalNameLeftText">体检医院</label>
					</div>
					<div class="personalNameRight inlineBlock">
						<label class="inlineBlock personalNameLeftText" id="medicalHospital"></label>
					</div>
				</div>
				<div class="personalName borderBottomNone">
					<div class="personalNameLeft">
						<img src="wechatImg/caretakers.png" class="inlineBlock personalNameLeftImg">
						<label class="inlineBlock personalNameLeftText">陪检人</label>
					</div>
					<div class="personalNameRight inlineBlock">
						<label class="inlineBlock personalNameLeftText" onclick="escortDetails()" id="servicePerson">暂无</label>
					</div>
				</div>	
			</div>
			
			<div class="progressInfo">
				<div class="progressName">
					<label class="progressNameDes">下单成功</label>
					<label class="progressNameDes">体检完成</label>
					<label class="progressNameDes">体检报告</label>
				</div>
				<div class="progressStatus">
					<!--<label class="progressStatusDes">
						<span class="progressStatusDesLight"></span>
					</label>
					<label class="progressStatusDes">
						<span class="progressStatusDesLight"></span>
					</label>
					<label class="progressStatusDes">
						<span class="progressStatusDesDark"></span>
					</label>-->
					<img src="wechatImg/progress1.png" class="progressStatusImg" id="progressStatusImg">
				</div>
				<div class="progressDes">
					<label class="progressDesDes" id="orderTime"></label>
					<label class="progressDesDes" id="medicalCompleteTime">预约中</label>
					<label class="progressDesDes" id="reportCreateTime"></label>
				</div>
			</div>
			
			<!-- 遮罩 -->
			<div class="medicalInfo hide" id="mask">
				<div class="shade">
					<img src="wechatImg/notPay.png" class="notPay">
					<label class="notPayDes">支付成功后查看体检结论</label>
				</div>
				<div class="medicalName dim">
					<div class="medicalNameLeft">
						<img src="wechatImg/gastricCancer.png" class="hospitalNameLeftImg">
						<label class="inlineBlock medicalNameLeftText">胃癌</label>
					</div>
					<div class="medicalNameCenter">
						<label class="inlineBlock medicalNameCenterText">胃癌早期筛查</label>
					</div>
					<div class="medicalNameRight">
						<label class="medicalNameRightText">550<span class="unit">元</span></label>
					</div>
				</div>
				<div class="medicalName dim">
					<div class="medicalNameLeft">
						<img src="wechatImg/gastricCancer.png" class="hospitalNameLeftImg">
						<label class="inlineBlock medicalNameLeftText">胃癌</label>
					</div>
					<div class="medicalNameCenter">
						<label class="inlineBlock medicalNameCenterText">胃癌中期筛查</label>
					</div>
					<div class="medicalNameRight">
						<label class="medicalNameRightText">550<span class="unit">元</span></label>
					</div>
				</div>
				<div class="medicalName dim">
					<div class="medicalNameLeft">
						<img src="wechatImg/gastricCancer.png" class="hospitalNameLeftImg">
						<label class="inlineBlock medicalNameLeftText">胃癌</label>
					</div>
					<div class="medicalNameCenter">
						<label class="inlineBlock medicalNameCenterText">胃癌晚期筛查</label>
					</div>
					<div class="medicalNameRight">
						<label class="medicalNameRightText">550<span class="unit">元</span></label>
					</div>
				</div>
			</div>
			
			<!-- 	下单成功/体检完成/取消 -->
			<input type="hidden" id="totalPrice">
			<div class="medicalInfo hide" id="itemListInfo">
				<div class="medicalName">
					<div class="medicalNameLeft">
						<img src="wechatImg/gastricCancer.png" class="hospitalNameLeftImg">
						<label class="inlineBlock medicalNameLeftText">胃癌</label>
					</div>
					<div class="medicalNameCenter">
						<label class="inlineBlock medicalNameCenterText">胃癌早期筛查</label>
					</div>
					<div class="medicalNameRight">
						<label class="medicalNameRightText">550<span class="unit">元</span></label>
					</div>
				</div>
				<div class="medicalName">
					<div class="medicalNameLeft">
						<img src="wechatImg/gastricCancer.png" class="hospitalNameLeftImg">
						<label class="inlineBlock medicalNameLeftText">胃癌</label>
					</div>
					<div class="medicalNameCenter">
						<label class="inlineBlock medicalNameCenterText">胃癌早期筛查</label>
					</div>
					<div class="medicalNameRight">
						<label class="medicalNameRightText">550<span class="unit">元</span></label>
					</div>
				</div>
			</div>
			
			<div class="medicalInfo hide" id="medicalConclusionIfHide">
				<div class="medicalName padding2015 heightAuto">
					<div class="medicalConclusion" id="medicalConclusion">
					
					</div>
				</div>
			</div>
			
			<!-- <div class="medicalInfo hide">
				<div class="shade hide">
					<img src="wechatImg/notPay.png" class="notPay">
					<label class="notPayDes">支付成功后查看体检结论</label>
				</div>
				<div class="medicalName padding2015 heightAuto">
					<div class="medicalConclusion">
						1、合理搭配营养素：在限制总热量的情况下，三大营养素——碳水化合物提供的热量应占总热量的55%-60%，蛋白质应占总热量的15%-20%，脂肪应占总热量的30%以下。 <br>a、碳水化合物：宜食用高膳食纤维的粗粮,如：燕麦、荞麦、薏米、黑米、黄豆、黑豆、绿豆等。建议膳食纤维每日不少于15-20克。<br>b、蛋白质：选择优质蛋白，如瘦肉、家禽类、鱼虾、鸡蛋、牛奶、豆制品等。应保证每天摄入一个鸡蛋（50克），一袋奶（250ml）<br>c、脂肪：选择植物油作为烹调油，加上动物食物中所含的脂肪已足够补充每日所需。
					</div>
				</div>
			</div> -->

			<!-- 生成报告-未付款-遮罩 -->
			<!-- <div class="medicalInfo hide">
				<div class="shade hide">
					<img src="wechatImg/notPay.png" class="notPay">
					<label class="notPayDes">支付成功后查看体检结论</label>
				</div>
				<div class="medicalName padding2015 heightAuto">
					<div class="medicalConclusion dim">
						1、合理搭配营养素：在限制总热量的情况下，三大营养素——碳水化合物提供的热量应占总热量的55%-60%，蛋白质应占总热量的15%-20%，脂肪应占总热量的30%以下。 <br>a、碳水化合物：宜食用高膳食纤维的粗粮,如：燕麦、荞麦、薏米、黑米、黄豆、黑豆、绿豆等。建议膳食纤维每日不少于15-20克。<br>b、蛋白质：选择优质蛋白，如瘦肉、家禽类、鱼虾、鸡蛋、牛奶、豆制品等。应保证每天摄入一个鸡蛋（50克），一袋奶（250ml）<br>c、脂肪：选择植物油作为烹调油，加上动物食物中所含的脂肪已足够补充每日所需。
					</div>
				</div>
			</div> -->
		</div>
		
		<div class="footer1 hide" id="noPay">
			<div class="orders">
				<button class="btn" onclick="alert('公众号支付功能还未开启');">付 款</button>
			</div>
		</div>
		
		<div class="footer2 hide" id="physicalExaminationItemsListAndReport">
			<div class="orders">
				<button class="btnLeft" onclick="turnPhysicalExaminationItemsList()"><img src="wechatImg/left.png" class="leftImg">体检项目清单</button>
			</div>
			<div class="orders">
				<button class="btnRight" onclick="turnFullPhysicalExaminationReport()">完整体检报告<img src="wechatImg/right.png" class="rightImg"></button>
			</div>
		</div>
	</div>
	
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
		    document.getElementById('body').removeAttribute('class','hide')
		})(document, window);
	</script>
	<script type="text/javascript">
		//返回前一页
		function returnPage(){
			window.location.replace("<%=request.getContextPath()%>/" + "weixinOrderInquiry.do?historyOrderList&weixin=weixin");
		}
		
		//跳转陪护人详情
		function escortDetails() {
			var orderId = "<%=request.getAttribute("orderId")%>";
			window.location.replace("<%=request.getContextPath()%>/" + "weixinOrderInquiry.do?escortDetails&orderId=" + orderId + "&weixin=weixin");
		}
		
		//付款
		function payment() {
			var orderId = "<%=request.getAttribute("orderId")%>";
			var totalPrice = $("#totalPrice").val();
			if (totalPrice != null && totalPrice != "") {
				var url = "<%=request.getContextPath()%>" +"/weixinOrderInquiry.do?mainPay&weixin=weixin&orderId="+orderId + "&total_fee=" + totalPrice;
        		window.location.replace(url);
			} else {
				alert("价格有误，无法付款");
				return;
			}
		}
		
		//体检项目清单
		function turnPhysicalExaminationItemsList() {
			var orderId = "<%=request.getAttribute("orderId")%>";
			window.location.replace("<%=request.getContextPath()%>/" + "weixinOrderInquiry.do?physicalExaminationItemsList&orderId=" + orderId + "&weixin=weixin");
		}
		
		//跳转完整体检报告
		function turnFullPhysicalExaminationReport(){
			var orderId = "<%=request.getAttribute("orderId")%>";
			window.location.replace("<%=request.getContextPath()%>/" + "weixinOrderInquiry.do?fullPhysicalExaminationReport&orderId=" + orderId + "&weixin=weixin");
		}
		
		$(document).ready(function() {
			var orderId = "<%=request.getAttribute("orderId")%>";
			queryOrder(orderId);//获取订单信息
		});
		
		//查询订单
	    function queryOrder(orderId) {
	    	var reqmsg = "{'action':'QUERY_ORDER_INFO_REQUEST','content':{'medicalReportShow':'true','servicePersonShow':'true','id':" + orderId + "}}";
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
	              			var totalPrice = data.content.totalPrice;//总价
	              			$("#totalPrice").val(totalPrice);
	              			
	              			$("#medicalPersonName").html(data.content.medicalPersonName);
	              			
	              			var medicalHospital = data.content.medicalHospital;
	              			if (medicalHospital != null && medicalHospital != "") {
								if (medicalHospital.length > 10) {
									$("#medicalHospital").html(medicalHospital.substr(0,10) + "...");
								} else {
									$("#medicalHospital").html(medicalHospital);
								}
							} else {
								$("#medicalHospital").html("无");
							}
	              			
	              			if (data.content.servicePerson != null && data.content.servicePerson != "") {
	              				if (data.content.servicePerson.name != null && data.content.servicePerson.name != "") {
	              					$("#servicePerson").html("<img src='" + data.content.servicePerson.headPortrait + "' class='personalImg'>");
	              				}
	              			}
	              			
	              			
	              			//进度条
	              			if (data.content.orderTime != null && data.content.orderTime != "") {
	              				$("#orderTime").html(formateTime(data.content.orderTime));//下单成功时间
	              			}
	              			if (data.content.medicalCompleteTime != null && data.content.medicalCompleteTime != "") {
	              				$("#medicalCompleteTime").html(formateTime(data.content.medicalCompleteTime));//体检时间
	              			}
	              			if (data.content.reportCreateTime != null && data.content.reportCreateTime != "") {
	              				$("#reportCreateTime").html(formateTime(data.content.reportCreateTime));//报告时间
	              			}
	              			if (data.content.status == 1) {//下单成功
	              				$("#progressStatusImg").attr("src","wechatImg/progress1.png");
	              			} else if (data.content.status == 2) {//体检完成
	              				$("#progressStatusImg").attr("src","wechatImg/progress2.png");
	              			} else if (data.content.status == 3) {//生成报告
	              				$("#progressStatusImg").attr("src","wechatImg/progress3.png");
	              			}
	              			
	              			//下单成功/体检完成/取消
	              			if (data.content.status == 1 || data.content.status == 2 || data.content.status == 4) {
	              				queryMedicalItem(data.content.id);
	              				$("#itemListInfo").removeClass("hide");
	              				if (data.content.isPay == 0) {//未付款
		              				$("#noPay").removeClass("hide");
		              			}
	              			} else if (data.content.status == 3){//生成报告
	              				if (data.content.isPay == 1) {//已付款
	              					if (data.content.medicalReport != null && data.content.medicalReport != "") {
	              						$("#medicalConclusion").html(data.content.medicalReport.medicalReportContent);
	              					}
	              					$("#medicalConclusionIfHide").removeClass("hide");
	              					$("#physicalExaminationItemsListAndReport").removeClass("hide");
		              			} else if (data.content.isPay == 0) {//未付款
		              				$("#mask").removeClass("hide");
		              				$("#noPay").removeClass("hide");
		              			}
	              			}
						}
					} else {
	                	alert("查询订单失败");
	                }
	          	},
	          	error:function(){
		        	alert("查询订单失败");
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
		
		//查询订单的体检项目
		function queryMedicalItem(id) {
			var reqmsg = "{'action':'QUERY_ORDER_MEDICAL_ITEM_RELATION_LIST_REQUEST','page':{'pageno':'1','pagesize':'1000000'},'content':{'orderId':" + id + "}}";
			var html = "";
			
		    jQuery.ajax({
		          type : "post",
		          async:true,
		          url : "orderMedicalItemRelation.do?handler",
		          dataType : "json",
		          data: {
		               "reqmsg":reqmsg,
		               "weixin":"weixin"
		          },
		          success : function(data) {
		              if (data.des == "success") {
		            	  if (data.content != null) {
							 if (data.content.orderMedicalItemRelationList != null) {
								jQuery.each(data.content.orderMedicalItemRelationList,function(i, item) {
		              				html += "<div class='medicalName'>";
									html += "<div class='medicalNameLeft'>";
									html += "<img src='" + item.icons  + "' class='hospitalNameLeftImg'>";
									
									if (item.testPurpose != null && item.testPurpose != "") {
										if (item.testPurpose.length > 3) {
											html += "<label class='inlineBlock medicalNameLeftText'>" + item.testPurpose.substr(0,3) + "...</label>";
										} else {
											html += "<label class='inlineBlock medicalNameLeftText'>" + item.testPurpose + "</label>";
										}
									} else {
										html += "<label class='inlineBlock medicalNameLeftText'>无</label>";
									}
								
									html += "</div>";
									html += "<div class='medicalNameCenter'>";
									
									if (item.medicalItemName != null && item.medicalItemName != "") {
										if (item.medicalItemName.length > 6) {
											html += "<label class='inlineBlock medicalNameCenterText'>" + item.medicalItemName.substr(0,6) + "...</label>";
										} else {
											html += "<label class='inlineBlock medicalNameCenterText'>" + item.medicalItemName + "</label>";
										}
									} else {
										html += "<label class='inlineBlock medicalNameCenterText'>无</label>";
									}
								
									html += "</div>";
									html += "<div class='medicalNameRight'>";
									html += "<label class='medicalNameRightText'>" + item.medicalItemPrice + "<span class='unit'>元</span></label>";
									html += "</div>";
									html += "</div>";
		              			});
		              			$("#itemListInfo").html(html);
		              		  }
		              	  }
		              } else {
		                 alert("查询体检项目失败");
		              }
		          },
		          error:function() {
			          alert("查询体检项目失败");
		          }
		     });
		}
	</script>
</body>
</html>