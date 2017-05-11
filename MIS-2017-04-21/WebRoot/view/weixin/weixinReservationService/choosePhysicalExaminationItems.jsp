<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<title>体检项目选择</title>
	<style>
		/*320px布局*/
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
            box-shadow: 0.02rem 0.04rem 0.1rem #ddd;
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
		.footer{
			height: 0.45rem;
			position: absolute;
    		bottom: 0rem;
   			width: 100%;
   			overflow: hidden;
   			display:flex;
			display:-webkit-flex;
			font-size: 0.16rem;
		}
		.costInfo{
			flex:2;
			height: 0.45rem;
			display:flex;
			display:-webkit-flex;
		}
		.orders{
			flex:1;
			display: inline-block;
			background-color: #5B8BC9;
		}
		.cost{
			flex: 1;
		    display: inline-block;
		    text-align: center;
		}
		.des{
			flex:1;
			font-size: 0.7rem;
			color: #7A7C88;
			display:flex;
			display:-webkit-flex;
		}
		.costNum{
			font-size: 0.16rem;
		    display: inline-block;
		    font-weight: 700;
		    color: #79B036;
		    height: 0.35rem;
		    line-height: 0.35rem;
		    margin-top: 0.05rem;
		    width:100%;
		}
		.btn{
			background: transparent;
		    border: none;
		    width: 100%;
		    height: 0.45rem;
		    color: #FFF;
		    letter-spacing: 0.05rem;
		    outline: none;
		    font-size: 0.14rem;
		    font-family: SimHei;
		    display: inline-block;
		    margin-left: 0.02rem;
		    -webkit-appearance : none ;  /*解决iphone safari上的圆角问题*/
		}
		.medicalInfo{
		    height: auto;
		    margin: 0.10rem 0.16rem;
		    border-radius: 0.1rem;
		    background-color: #FFF;
		    box-shadow: 0px 0px 0.1rem 0.01rem #DDDDDD;
		    overflow: hidden;
		    font-size: 0.16rem;
		}
		.medicalType{
			height: 0.44rem;
    		display:flex;
			display:-webkit-flex;
		}
		.medicalTypeLeft{
			flex: 1;
		    display: inline-block;
		    text-align: center;
		    vertical-align: sub;
		    height: 0.4rem;
		    line-height: 0.4rem;
		    font-size: 0.14rem;
		   	font-weight: 600;
		    color: #FFF;
		    background-color: #87c738;
		    letter-spacing: 0.01rem;
		    border-radius: 0.1rem 0px 0px 0px;
		    position: relative;
		    border: 0.02rem solid #87C738;
		    cursor: pointer;
		}
		.medicalTypeRight{
			flex: 1;
		    text-align: center;
		    font-size: 0.14rem;
		    font-weight: 600;
		    border-radius: 0px 0.1rem 0px 0px;
		    border: 0.02rem solid #87c738;
		    letter-spacing: 0.01rem;
		    color: #87c738;
		    height: 0.4rem;
		    line-height: 0.4rem;
		    cursor: pointer;
		    position: relative;
		}
		
		.medicalName{
			height: 0.5rem;
    		padding: 0px;
    		display:flex;
			display:-webkit-flex;
			border-bottom: 0.01rem solid #F2F2F2;
		}
		.medicalNameLeft{
			flex: 63;
		    display: inline-block;
		    text-align: left;
		    vertical-align: sub;
		    height: 0.5rem;
		}
		.medicalNameLeftText{
			line-height: 0.5rem;
		    color: #434B76;
		    margin-left: 0.05rem;
		    font-size: 0.115rem;
		    font-weight: 700;
    	}
		.medicalNameCenter{
			flex: 98;
		    text-align: left;
		    position: relative;
		}
		.medicalNameCenterBox{
			text-align: left;
		    position: absolute;
		    top: 50%;
    		webkit-transform: translateY(-50%);
			-moz-transform: translateY(-50%);
			-ms-transform: translateY(-50%);
			transform: translateY(-50%);
		}
		.medicalNameCenterBoxTop{
			text-align: left;
			font-size: 0.1rem;
		}
		.medicalNameCenterBoxTopName{
			font-size: 0.1rem;
    		color: #5a5a5a;
    		font-weight: 600;
    		display: inline-block;
    		margin-bottom: 0.05rem;
		}
		.medicalNameCenterBoxTopDes{
			width: 0.09rem;
		    height: 0.09rem;
		    position: relative;
		    top: 0.01rem;
		}
		.medicalNameCenterBoxDesText{
			font-size: 0.09rem;
		    color: #bfbfbf;
		    display: block;
		    width: 100%;
		    white-space: nowrap;
		    overflow: hidden;
		    text-overflow: ellipsis;
		}
		.medicalNameRight{
		    flex: 30;
		    display: inline-block;
		    text-align: right;
		    height: 0.5rem;
		    padding-right: 0.1rem;
		}
		.medicalNameRightText{
			height: 0.3rem;
		    width: 100%;
		    line-height: 0.3rem;
		    display: inline-block;
		    margin-top: 0.1rem;
		    border-left: 0.01rem solid #f1f1f1;
		    font-size: 0.12rem;
		    font-weight: 700;
		    color: #414972;
		}
		.medicalNameCenterText{
			height: 0.5rem;
		    line-height: 0.5rem;
		    color: #858585;
		    font-size: 0.8rem;
		}
		.model{
			width: 100%;
			height:100%;
			z-index: 99;
			position: absolute;
			position: fixed;
			top: 0px;
			left: 0px;
			opacity: 0.9;
			background-color: #000;
			display: none;
		}
		.closeModel1{
			display: inline-block;
		    float: right;
		    overflow: auto;
		    height: 0.3rem;
		    width: 0.3rem;
		}
		.closeModel2{
			display: inline-block;
		    position: absolute;
		    overflow: auto;
		    height: 0.3rem;
		    width: 0.3rem;
		    right: 0px;
		}
		.modelContent1 {
			background-color: #FFF;
			width: 80vw;
			min-width: 2rem;
			height: auto;
			min-height: 50vmin;
			border-radius: 0.15rem;
			padding: 0.2rem;
			font-size: 0.16rem;
			position: relative;
		}
		.modelContent2 {
			background-color: #FFF;
		    width: 75vw;
		    min-width: 2rem;
		    height: auto;
		    padding: 0rem 0.2rem;
		    font-size: 0.16rem;
		    min-height: 1.5rem;
		}
		.modelHeader1{
			padding: 0.15rem 0rem;
			color: #FFF;
			font-size: 0.18rem;
			min-height: 0.25rem;
		}
		.modelHeader2{
			padding: 0.15rem 0rem;
		    color: #000;
		    font-size: 0.18rem;
		    background-color: #FFF;
		    text-align: center;
		}
		.close1{
			cursor: pointer;
		    z-index: 100;
		    width: 0.2rem;
		    height: 0.2rem;
		    display: inline-block;
		}
		.close2{
			cursor: pointer;
		    z-index: 100;
		    display: block;
		    width: 0.3em;
		    height: 0.3rem;
		}
		.box1{
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
		.box2{
			width: auto;
			height:auto;
			z-index: 100;
			position: fixed;
			top: 45%;
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
		.modelContentInfo1{
			width: 70vw;
			height: auto;
			min-height: 0.5rem;
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
		.modelContentInfo2{
			width: 70vw;
			height: auto;
			min-height: 0.3rem;
			margin: 0px auto;
			padding: 0.15rem 0rem;
			font-size: 0.12rem;
			text-align: left;
			border-top: 1px solid #DDD;
		}
		.modelContentBtn{
			width: 60vw;
    		height: 0.3rem;
			position: fixed;
			top: 75%;
			left: 50%;
			webkit-transform: translateX(-50%) translateY(-50%);
			-moz-transform: translateX(-50%) translateY(-50%);
			-ms-transform: translateX(-50%) translateY(-50%);
			transform: translateX(-50%) translateY(-50%);
			border-radius: 0.05rem;
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

		.hospitalInfo{
			margin-top: 0.06rem;
    		text-align: center;
    		font-size: 0.16rem;
		}
		.hospitalInfoLeft{
			display: inline-block;
			position: relative;
		}
		.hospitalInfoRight{
			display: inline-block;
		    position: relative;
		    top: -0.05rem;
		    margin-left: 0.1rem;		
		}
		.hospitalInfoImg{
			width: 0.2rem;
    		height: 0.2rem;
    	}
		.hospitalInfoText{
			color: #7c7c7c;
    		font-size: 0.11rem;
		}
		.basisInfo {
		    height: 0.6rem;
		    margin: 0.05rem 0.16rem 0.20rem;
		    border-radius: 0.1rem;
		    overflow: hidden;
		    background-color: #FFF;
		    box-shadow: 0px 0px 0.1rem 1px #DDDDDD;
		    font-size: 0.16rem;
		}
		.basisTop{
			width: 100%;
			height: 0.07rem;
			background-color: #87c738;
			
		}
		.basisContent{
			display: flex;
    		display: -webkit-flex;
    		height: 0.53rem;
		}
		.basisContentLeft{
			flex: 15;
    		display: inline-block;
    		height: 0.5rem;
    		text-align: center;
		}
		.basisContentCenter{
			flex: 56;
    		display: inline-block;
    		height: 0.5rem;
		}
		.basisContentRight{
			flex: 12;
		    display: inline-block;
		    height: 0.5rem;
		    text-align: right;
		    padding-right: 0.1rem;
		}
		.basisContentLeftBox{
			display: inline-block;
			text-align: center;
			position: relative;
		    top: 54%;
    		webkit-transform: translateY(-50%);
			-moz-transform: translateY(-50%);
			-ms-transform: translateY(-50%);
			transform: translateY(-50%);
		}
		.basisContentLeftBoxImg{
			width: 0.12rem;
			height: 0.12rem;
			display: block;
			margin: 0px auto;
    		webkit-transform: translateY(20%);
			-moz-transform: translateY(20%);
			-ms-transform: translateY(20%);
			transform: translateY(20%);
		}
		.basisContentLeftBoxText{
			font-size: 0.08rem;
		}
		.basisContentCenterBox{
			position: relative;
    		top: 50%;
    		webkit-transform: translateY(-50%);
			-moz-transform: translateY(-50%);
			-ms-transform: translateY(-50%);
			transform: translateY(-50%);		}
		.basisContentCenterBoxTop{
			text-align: center;
			margin-bottom: 0.05rem;
		}
		.basisContentCenterBoxTopName{
			display: inline-block;
		    font-size: 0.125rem;
		    font-weight: 600;
		    letter-spacing: 0.03rem;
		    color: #414972;
		}
		.basisContentCenterBoxTopDes{
			width: 0.125rem;
    		height: 0.125rem;
    		webkit-transform: translateY(20%);
			-moz-transform: translateY(20%);
			-ms-transform: translateY(20%);
			transform: translateY(20%);
			cursor: pointer;
		}
		.basisContentCenterBoxDes{
			text-align:center;
			position: relative;
		}
		.basisContentCenterBoxDesText{
			color: #bfbfbf;
			font-size: 0.09rem;
			display: block;
			text-align: center;
		}
		.trigon{
			width: 0;
		    height: 0;
		    border-left: 0.06rem solid transparent;
		    border-right: 0.06rem solid transparent;
		    border-bottom: 0.1rem solid #FFF;
		    position: absolute;
		    bottom: -0.03rem;
		    left: 50%;
		    webkit-transform: translateX(-50%);
			-moz-transform: translateX(-50%);
			-ms-transform: translateX(-50%);
			transform: translateX(-50%);
		}
		.unit{
			font-size: 0.055rem;
		    color: #414972;
		    font-weight: 300;
		    margin-left:0.01rem; 
		}
		.unit7{
			font-size: 0.07rem;
		    color: #414972;
		    margin-left: 0.03rem;
		    font-weight: 300;
			margin-left:0.03rem; 
		}
		.notActive{
			background-color: #FFF;
    		color: #87c738;
    	}
    	.isActive{
    		background-color: #87c738;
    		color: #FFF;
    	}
    	.hide{
    		display: none;
    	}
    	.medicalNameLeftImg{
			width: 0.13rem;
		    height: 0.13rem;
		    position: relative;
		    top: 0.03rem;
		    margin-left: 0.1rem;
		}
		.flexLeft{
			flex: 68;
		}
		.flexCenter{
			flex: 95;
		}
		.flexRight{
			flex: 34;
		}
		.right0{
			right:0;
		}
		.left0{
			left:0;
		}
		.borderNone{
			border: none;
		}
		.borderLeft{
			border-left: 0.01rem solid #f1f1f1;
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
	            <label class="headerName">SHENBIAN</label>
	        </span>  
	        <span class="headerItem1 text-right">
	            <img src="wechatImg/service.jpg" class = "headerImg right0" onclick="$('#fixedDialingNumbers').click();">
				<a href="tel:10086" style="display:none;"><span id="fixedDialingNumbers">一键拨号</span></a>
	        </span>
	    </div>

		<div class="content">
			<div class="hospitalInfo">
				<div class="hospitalInfoLeft">
					<img src="wechatImg/hospitaGray.png" class="hospitalInfoImg">
				</div>
				<div class="hospitalInfoRight">
					<span class="hospitalInfoText" id="hospitalNameHead">苏大附一院</span>
				</div>
			</div>

			<div class="basisInfo">
				<div class="basisTop"></div>
				<div class="basisContent">
					<div class="basisContentLeft">
						<div class="basisContentLeftBox">
							<img src="wechatImg/selected.png" class="basisContentLeftBoxImg">
							<span class="basisContentLeftBoxText">(必选)</span>
						</div>
					</div>
					<div class="basisContentCenter">
						<div class="basisContentCenterBox">
							<div class="basisContentCenterBoxTop">
								<label  class="basisContentCenterBoxTopName">基础检查服务</label>
								<img src="wechatImg/explain.png" class="basisContentCenterBoxTopDes" id="basicInspectionSelectDes" title="">
							</div>
							<span class="basisContentCenterBoxDesText" id="basicInspectionSelectDesSub">无</span>
						</div>
					</div>
					<div  class="basisContentRight">
						<label class="medicalNameRightText borderNone"><span id="basicInspectionPrice">0</span><span class="unit">元</span></label>
					</div>
				</div>
			</div>

			<div class="medicalInfo">
				<div class="medicalType">
					<div class="medicalTypeLeft" id="tumour">
						<label class="medicalTypeRightText">肿瘤早期筛查</label>
						<span class="trigon"></span>
					</div>
					<div class="medicalTypeRight" id="cardio">
						<label class="medicalTypeRightText">心脑血管疾病筛查</label>
						<span class="trigon hide"></span>
					</div>
				</div>
				<div class="tumour" id="cancerProject">
					<!-- <div class="medicalName">
						<div class="medicalNameLeft">
							<img src="wechatImg/notSelect.png" class="medicalNameLeftImg notSelect ">
							<img src="wechatImg/selected.png" class="medicalNameLeftImg selected hide">
							<label class="inlineBlock medicalNameLeftText">肿瘤套餐</label>
						</div>
						<div class="medicalNameCenter">
							<div class="medicalNameCenterBox">
								<div class="medicalNameCenterBoxTop">
									<label  class="medicalNameCenterBoxTopName">多肿瘤标志物，肿瘤补充套餐</label>
									<img src="wechatImg/explain.png" class="medicalNameCenterBoxTopDes" title="肝癌、食管癌、前列腺癌、膀胱癌等...">
								</div>
								<span class="medicalNameCenterBoxDesText">肝癌、食管癌、前列腺癌、膀胱癌等...</span>
							</div>
						</div>
						<div class="medicalNameRight">
							<label class="medicalNameRightText">500<span class="unit">元</span></label>
						</div>
					</div> -->
				</div>
				<div class="cardio hide" id="cardioCerebrovascular">
					<!-- <div class="medicalName">
						<div class="medicalNameLeft flexLeft">
							<img src="wechatImg/notSelect.png" class="medicalNameLeftImg notSelect">
							<img src="wechatImg/selected.png" class="medicalNameLeftImg selected hide">
							<label class="inlineBlock medicalNameLeftText">心血管疾病</label>
						</div>
						<div class="medicalNameCenter flexCenter">
							<div class="medicalNameCenterBox">
								<div class="medicalNameCenterBoxTop">
									<label  class="medicalNameCenterBoxTopName">彩色心超</label>
									<img src="wechatImg/explain.png" class="medicalNameCenterBoxTopDes" title="(冠心病、心肌梗塞)持续出现...">
								</div>
								<span class="medicalNameCenterBoxDesText">(冠心病、心肌梗塞)持续出现...</span>
							</div>
						</div>
						<div class="medicalNameRight Right">
							<label class="medicalNameRightText">800<span class="unit">元</span></label>
						</div>
					</div> -->
				</div>
			</div>
		</div>
		
		<div class="footer">
			<div class="costInfo">
				<div class="cost">
					<div class="costNum"><span id="selectItemNum">0</span><span class="unit7">项</span></div>
				</div>
				<div class="cost">
					<div class="costNum borderLeft"><span id="selectItemPrice">0</span><span class="unit7">元</span></div>
				</div>
			</div>
			<div class="orders">
				<button class="btn" onclick="jumpToConfirmOrder()">去结算</button>
			</div>
		</div>
	</div>
	
	<div class="box1">
		<div class="modelHeader1">
			<div class="closeModel1">
				<img src="wechatImg/close.png" height="30" width="30" alt="&times" class="close1">
			</div>
		</div>
    	<div class="modelContent1">
			<div class="modelContentInfo1 text-center">
				<span>支付时间及方式、订单取消、价格以及免责声明。</span>
			</div>
			<div class="modelContentBtn">
				<button class="orderBtn">立即下单</button>
			</div>
    	</div>
	</div>

	<div class="box2">
		<div class="closeModel2">
				<img src="wechatImg/x.png" height="30" width="30" alt="&times" class="close2">
			</div>
		<div class="modelHeader2">
			<span style="display:inline-block;" id="box2Header"></span>
		</div>
    	<div class="modelContent2">
			<div class="modelContentInfo2 text-center">
				<span id="ContentInfo2"></span>
			</div>
    	</div>
	</div>
	
	<div class="model"></div>
	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript">
		// 该代码来自http://www.ghugo.com/mobile-h5-fluid-layout-for-iphone6/
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
		$(".basisContentCenterBoxTopDes").click(function(){
			var title = $(this).attr("title");
			var header = $(this).siblings('label').text();
			$("#box2Header").text("关于" + header);
			$("#ContentInfo2").text(title);
			$(".model").css("display","block");
			$(".box2").css("display","block");
			return false;
		});
		/* $(".medicalNameCenterBoxTopDes").click(function(){
			var title = $(this).attr("title");
			var header = $(this).siblings('label').text();
			$("#box2Header").text("关于" + header);
			$("#ContentInfo2").text(title);
			$(".model").css("display","block");
			$(".box2").css("display","block");
			return false;
		}); */
		$(".closeModel2").click(function(){
			$(".model").css("display","none");
			$(".box2").css("display","none");
			return false;
		});

		//切换肿瘤和心脑血管
		$("#cardio").on('click', function() {
			$(this).addClass('isActive').removeClass('notActive').find(".trigon").show();
			$("#tumour").removeClass('isActive').addClass('notActive').find(".trigon").hide();
			$(".cardio").show().siblings('.tumour').hide();
		});
		$("#tumour").on('click', function() {
			$(this).addClass('isActive').removeClass('notActive').find(".trigon").show();
			$("#cardio").removeClass('isActive').addClass('notActive').find(".trigon").hide();
			$(".tumour").show().siblings('.cardio').hide();
		});

		/* //选择
		$(".notSelect").on('click', function() {
			$(this).hide().siblings('.selected').show();
		});	
		$(".selected").on('click', function() {
			$(this).hide().siblings('.notSelect').show();
		});	 */	
		
		$(".medicalNameLeftText").on('click', function() {
			$(this).parents(".medicalName").find('.medicalNameCenterBox').click();;
		});
		
		//返回前一页
		function returnPage(){
			window.location.replace("<%=request.getContextPath()%>/" + "weixinReservationService.do?chooseAreaAndHospital&weixin=weixin");
		}
		
		$(document).ready(function() {
			var hospitalId = "<%=request.getAttribute("hospitalId")%>";
        	if (hospitalId != null && hospitalId != "") {
	    		queryMedicalItem(hospitalId);
	    	}
	    	
	    });
	    
	    //查询医院体检项目
	    function queryMedicalItem(hospitalId) {
		    var reqmsg = "{'action':'QUERY_HOSPITAL_INFO_REQUEST','content':{'id':" + hospitalId + "}}";

			jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "hospital.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg,
		           "weixin":"weixin"    
	          },
	          success : function(data) {
	              if (data.des == "success") {
	              	if (data.content != null) {
	              		$("#hospitalNameHead").html(data.content.hospitalName);
						if (data.content.medicalItemlist != null) {
							var html1 = "";
							var html2 = "";
							jQuery.each(data.content.medicalItemlist, function(i, item) {
								if (item.category == 1) {
									if (item.selectDes != null && item.selectDes != "") {
										if (item.selectDes.length > 15) {
											$("#basicInspectionSelectDesSub").html(item.selectDes.substr(0,15) + "...");
										} else {
											$("#basicInspectionSelectDesSub").html(item.selectDes);
										}
										$("#basicInspectionSelectDes").attr("title",item.selectDes)
									}
									$("#basicInspectionPrice").html(item.price);
									itemList = item.id + ",";
								}
								if (item.category == 2) {
									html1 += "<div class='medicalName'>";
									html1 += "<div class='medicalNameLeft'>";
									html1 += "<img src='wechatImg/notSelect.png' class='medicalNameLeftImg notSelect' onclick='calculationTotalCost(" + item.id + ",\"" + item.price + "\")'>";
									html1 += "<img src='wechatImg/selected.png' class='medicalNameLeftImg selected hide' onclick='calculationTotalCost(" + item.id + ",\"-" + item.price + "\")'>";
									
									if (item.testPurpose != null && item.testPurpose != "") {
										if (item.testPurpose.length > 4) {
											html1 += "<label class='inlineBlock medicalNameLeftText'>" + item.testPurpose.substr(0,4) + "...</label>";
										} else {
											html1 += "<label class='inlineBlock medicalNameLeftText'>" + item.testPurpose + "</label>";
										}
									} else {
										html1 += "<label class='inlineBlock medicalNameLeftText'>无</label>";
									}
									
									html1 += "</div>";
									html1 += "<div class='medicalNameCenter'>";
									html1 += "<div class='medicalNameCenterBox'>";
									html1 += "<div class='medicalNameCenterBoxTop'>";
									
									if (item.itemName != null && item.itemName != "") {
										if (item.itemName.length > 10) {
											html1 += "<label class='medicalNameCenterBoxTopName'>" + item.itemName.substr(0,10) + "...</label>";
										} else {
											html1 += "<label class='medicalNameCenterBoxTopName'>" + item.itemName + "</label>";
										}
									} else {
										html1 += "<label class='medicalNameCenterBoxTopName'>无</label>";
									}
									
									if (item.selectDes != null && item.selectDes != "") {
										html1 += "<img src='wechatImg/explain.png' class='medicalNameCenterBoxTopDes' title='" + item.selectDes + "'>";
									} else {
										html1 += "<img src='wechatImg/explain.png' class='medicalNameCenterBoxTopDes' title='无'>";
									}
									
									html1 += "</div>";
									
									if (item.selectDes != null && item.selectDes != "") {
										if (item.selectDes.length > 15) {
											html1 += "<span class='medicalNameCenterBoxDesText'>" + item.selectDes.substr(0,15) + "..." + "</span>";
										} else {
											html1 += "<span class='medicalNameCenterBoxDesText'>" + item.selectDes + "</span>";
										}
									} else {
										html1 += "<span class='medicalNameCenterBoxDesText'>无</span>";
									}
									
									html1 += "</div>";
									html1 += "</div>";
									html1 += "<div class='medicalNameRight'>";
									html1 += "<label class='medicalNameRightText'>" + item.price + "<span class='unit'>元</span></label>";
									html1 += "</div>";
									html1 += "</div>";
								}
								if (item.category == 3) {
									html2 += "<div class='medicalName'>";
									html2 += "<div class='medicalNameLeft flexLeft'>";
									html2 += "<img src='wechatImg/notSelect.png' class='medicalNameLeftImg notSelect' onclick='calculationTotalCost(" + item.id + ",\"" + item.price + "\")'>";
									html2 += "<img src='wechatImg/selected.png' class='medicalNameLeftImg selected hide' onclick='calculationTotalCost(" + item.id + ",\"-" + item.price + "\")'>";
									
									if (item.testPurpose != null && item.testPurpose != "") {
										if (item.testPurpose.length > 4) {
											html2 += "<label class='inlineBlock medicalNameLeftText'>" + item.testPurpose.substr(0,4) + "...</label>";
										} else {
											html2 += "<label class='inlineBlock medicalNameLeftText'>" + item.testPurpose + "</label>";
										}
									} else {
										html2 += "<label class='inlineBlock medicalNameLeftText'>无</label>";
									}
									
									html2 += "</div>";
									html2 += "<div class='medicalNameCenter flexCenter'>";
									html2 += "<div class='medicalNameCenterBox'>";
									html2 += "<div class='medicalNameCenterBoxTop'>";
									
									if (item.itemName != null && item.itemName != "") {
										if (item.itemName.length > 10) {
											html2 += "<label class='medicalNameCenterBoxTopName'>" + item.itemName.substr(0,10) + "...</label>";
										} else {
											html2 += "<label class='medicalNameCenterBoxTopName'>" + item.itemName + "</label>";
										}
									} else {
										html2 += "<label class='medicalNameCenterBoxTopName'>无</label>";
									}
									
									if (item.selectDes != null && item.selectDes != "") {
										html2 += "<img src='wechatImg/explain.png' class='medicalNameCenterBoxTopDes' title='" + item.selectDes + "'>";
									} else {
										html2 += "<img src='wechatImg/explain.png' class='medicalNameCenterBoxTopDes' title='无'>";
									}
									
									html2 += "</div>";
									
									if (item.selectDes != null && item.selectDes != "") {
										if (item.selectDes.length > 15) {
											html2 += "<span class='medicalNameCenterBoxDesText'>" + item.selectDes.substr(0,15) + "..." + "</span>";
										} else {
											html2 += "<span class='medicalNameCenterBoxDesText'>" + item.selectDes + "</span>";
										}
									} else {
										html2 += "<span class='medicalNameCenterBoxDesText'>无</span>";
									}
									
									html2 += "</div>";
									html2 += "</div>";
									html2 += "<div class='medicalNameRight Right'>";
									html2 += "<label class='medicalNameRightText'>" + item.price + "<span class='unit'>元</span></label>";
									html2 += "</div>";
									html2 += "</div>";
								}
							});
							//计算固定基础项目价格
							var basicInspectionPrice = $("#basicInspectionPrice").html();
							if (basicInspectionPrice != null && basicInspectionPrice != "") {
								totalPrice += parseInt(basicInspectionPrice);//基础项目
								itemNum ++;
							}
							$("#selectItemNum").html(itemNum);
							$("#selectItemPrice").html(totalPrice);
							
							$("#cancerProject").html(html1);
							$("#cardioCerebrovascular").html(html2);
							$(".medicalNameCenterBox").click(function(){
								var title = $(this).find('img').attr("title");
								var header = $(this).find('label').text();
								$("#box2Header").text("关于" + header);
								$("#ContentInfo2").text(title);
								$(".model").css("display","block");
								$(".box2").css("display","block");
								return false;
							});
							//选择
							$(".notSelect").on('click', function() {
								calculationTotalCost();
								$(this).hide().siblings('.selected').show();
							});	
							$(".selected").on('click', function() {
								calculationTotalCost();
								$(this).hide().siblings('.notSelect').show();
							});	
						}
	              	 }
	              } else {
	                 alert("查询医院体检项目信息失败");
	              }
	          },
	          error:function() {
		          alert("查询医院体检项目信息失败");
	          }
	    	});
		}
		
		var itemNum = 0;
		var totalPrice = 0;
		var itemList = "";
		//计算总费用
		function calculationTotalCost(id,price) {
			if (price != null && price != "") {
				if (price.length > 0) {
					if (price.substr(0,1) == "-") {
						itemList = itemList.substr(0,itemList.length - 1);
						var itemListArray = itemList.split(",");
						itemList = "";
						for (var i = 0;i < itemListArray.length;i++) {
							if (itemListArray[i] != id) {
								itemList += itemListArray[i] + ",";
							}
						}
						itemNum --;
						totalPrice = totalPrice - parseInt(price.substr(1,price.length));
					} else {
						itemList += id + ",";
						itemNum ++;
						totalPrice = totalPrice + parseInt(price);
					}
				}
			}
			$("#selectItemNum").html(itemNum);
			$("#selectItemPrice").html(totalPrice);
		}	
		
		//跳转下单页面
		function jumpToConfirmOrder(){
			itemList = itemList.substr(0,itemList.length - 1);
			var hospitalId = "<%=request.getAttribute("hospitalId")%>";
			window.location.replace("<%=request.getContextPath()%>/" + "weixinReservationService.do?confirmOrder&hospitalId=" + hospitalId + "&itemList=" + itemList + "&weixin=weixin");
		}
	</script>
</body>
</html>