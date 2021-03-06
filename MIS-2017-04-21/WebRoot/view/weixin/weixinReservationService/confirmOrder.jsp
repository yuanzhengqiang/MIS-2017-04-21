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
			background-color: #f7f7f7;
			overflow-y:auto; 
			position: absolute;
			top: 0.32rem;
			bottom:0.45rem;
		}
		.footer{
			height: 0.45rem;
			position: absolute;
    		bottom: 0px;
   			width: 100%;
   			overflow: hidden;
   			display:flex;
			display:-webkit-flex;
		}
		.costInfo{
			flex:3;
			height: 0.45rem;
			display:flex;
			display:-webkit-flex;
			padding: 0rem 0.15rem;
		}
		.orders{
			flex:2;
			display: inline-block;
			background-color: #5B8BC9;
			font-size: 0.16rem;
		}
		.cost{
			flex:3;
			display: inline-block;
		}
		.des{
			flex:3;
			font-size: 0.08rem;
			color: #7A7C88;
			display:flex;
			display:-webkit-flex;
		}
		.desLift{
			flex: 2;
		    display: inline-block;
		    text-align: right;
		    height: 0.45rem;
		    margin-top: 0.12rem;
		    line-height: 0.12rem;
		    letter-spacing: 0.03rem;
		}
		.desRight{
			flex:1;
			display: inline-block;
			text-align: center;
		}
		.desRightImg{
			cursor: pointer;
		    margin-top: 0.15rem;
		    width: 0.15rem;
		    height: 0.15rem;
		}
		.costNum{
			flex: 3;
		    font-size: 0.18rem;
		    display: inline-block;
		    font-weight: 700;
		    color: #79B036;
		    height: 0.45rem;
		    line-height: 0.45rem;
		}
		.costName{
			flex: 2;
		    font-size: 0.12rem;
		    display: inline-block;
		    font-weight: 700;
		    letter-spacing: 0.01rem;
		    height: 0.45rem;
		    line-height: 0.45rem;
		    font-family: SimHei;
		    text-align: right;
		    color: #323b5a;
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
		    font-family: SimHei;
		    -webkit-appearance : none ;  /*解决iphone safari上的圆角问题*/
		}

		.personalInfo{
		    height: auto;
		    margin: 0.25rem 0.16rem;
		    border-radius: 0.1rem;
		    background-color: #FFF;
		    box-shadow: 0px 0px 0.1rem 0.01rem #DDDDDD;
		    font-size: 0.16rem;
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
		    font-family: SimHei;
		}
		.personalNameRight{
			flex: 3;
		    padding-right: 0.1rem;
		    height: 0.45rem;
		    line-height: 0.45rem;
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
		    margin: 0.2rem 0.16rem;
		    border-radius: 0.1rem;
		    background-color: #FFF;
		    box-shadow: 0px 0px 0.1rem 0.01rem #DDDDDD;
		    font-size: 0.16rem;
		}
		.hospitalName{
			height: 0.4rem;
    		padding: 0px 0.1rem;
    		display:flex;
			display:-webkit-flex;
			border-bottom: 0.01rem solid #F2F2F2;
		}
		.hospitalNameLeft{
			flex:1;
			padding-left: 0.1rem;
			display: inline-block;
		    text-align: left;
		    vertical-align: sub;
		    height: 0.4rem;
		}
		.hospitalNameLeftImg{
			width: 0.18rem;
    		height: 0.18rem; 
    		position: relative;
		    top: 0.05rem;
		}
		.hospitalNameRight{
			flex: 4;
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
			height: 0.5rem;
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
		    letter-spacing: 0.01rem;
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
		.closeModel3{
			display: inline-block;
		    float: right;
		    height: 0.3rem;
		    width: 0.3rem;
		}
		.modelContent1 {
			background-color: #FFF;
			width: 75vw;
			min-width: 2rem;
			height: auto;
			min-height: 50vmin;
			padding: 0.2rem;
			font-size: 0.16rem;
			position: relative;
		}
		.modelContent2 {
			background-color: #FFF;
		    width: 75vw;
		    min-width: 2rem;
		    height: auto;
		    padding: 0rem 0.25rem;
		    font-size: 0.16rem;
		}
		.modelContent3 {
			background-color: #FFF;
		    width: 75vw;
		    min-width: 2rem;
		    height: auto;
		    border-radius: 0.1rem;
		    padding: 0.3rem;
		    font-size: 0.16rem;
		}
		.modelHeader1{
			padding: 0.15rem 0rem;
		    color: #000;
		    font-size: 0.18rem;
		    min-height: 0.25rem;
		    text-align: center;
		    background-color: #FFF;
		}
		.modelHeader2{
		    color: #000;
		    font-size: 0.15rem;
		    background-color: #FFF;
		    text-align: center;
		    border-radius: 0.1rem 0.1rem 0px 0px;
		    height: 0.2rem;
		    line-height: 0.2rem;
		}
		.modelHeader3{
			padding: 0.15rem 0rem;
		    color: #000;
		    font-size: 0.18rem;
		    min-height: 0.25rem;
		    text-align: center;
		    background-color: #FFF;
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
		    width: 0.2rem;
		    height: 0.2rem;
		    display: inline-block;
		}
		.close3{
			cursor: pointer;
		    z-index: 100;
		    width: 0.2rem;
		    height: 0.2rem;
		    display: inline-block;
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
			padding: 0.15rem;
		}
		.modelContentInfo3{
			width: 70vw;
			height: auto;
			border-bottom: 0.01rem solid #BAB9BE;
			margin: 0px auto;
			padding: 0.15rem;
			font-size: 0.12rem;
			background-color: #FFF;
			text-align: center;
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
		    background-color: #7fc349;
		    border-radius: 0.05rem;
		    box-shadow: 0.02rem 0.02rem 0.05rem 0.01rem #ABCD83;
		    outline: none;
		    color: #FFF;
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
		    width: 0.15rem;
		    height: 0.15rem;
		    top: 0.03rem;
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
		.labelInfo{
			margin: 0rem 0.2rem;
		}
		.unit{
			font-size: 0.055rem;
		    color: #405081;
		    font-weight: 300;
		    position: relative;
		    top: -0.01rem;
		    margin-left: 0.03rem;
		}
		.unit1{
			font-size: 0.055rem;
		    color: #405081;
		    font-weight: 300;
		    position: relative;
		    top: -0.01rem;
		    margin-left: 0.01rem;
		}
		.costNameDes{
		    height: 0.45rem;
		    line-height: 0.45rem;
		    display: inline-block;
		    position: relative;
		    top: 0.015rem;
		}
		.hide{
			display: none;
		}
		.box2{
			width: auto;
			height:auto;
			z-index: 100;
			position: fixed;
			top: 20%;
			left: 50%;
			webkit-transform: translateX(-50%);
			-moz-transform: translateX(-50%);
			-ms-transform: translateX(-50%);
			transform: translateX(-50%);
			background-color: transparent;
			display: none;
			border-radius: 0.1rem;
    		overflow: hidden;
		}
		.box1{
			width: auto;
			height:auto;
			z-index: 100;
			position: fixed;
			top: 10%;
			left: 50%;
			webkit-transform: translateX(-50%);
			-moz-transform: translateX(-50%);
			-ms-transform: translateX(-50%);
			transform: translateX(-50%);
			background-color: transparent;
			display: none;
			border-radius: 0.1rem;
    		overflow: hidden;
		}
		.modelHeader2{
			padding: 0.1rem 0rem;
		    color: #000;
		    font-size: 0.15rem;
		    background-color: #FFF;
		    text-align: center;
		    border-radius: 0.1rem 0.1rem 0px 0px;
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
		ul{
			padding-left: 0.12rem;
			margin-top: 0.1rem;
		}
		li{
			font-size: 0.1rem;
		    
		    color: #777777;
    		font-family: SimHei;
    		line-height: 0.18rem;
		}
		.sure{
			padding: 0.05rem 0.5rem;
		    margin-bottom: 0.2rem;
		    border: none;
		    outline: none;
		    background-color: #92D050;
		    color: #FFF;
		}
		.borderTopNone{
			border-top: none;
		}
		.btnDiv{
			text-align: center;
			
		}
		.paddingTop0{
			padding-top: 0rem;
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
		.box4{
			width: auto;
			height:auto;
			z-index: 100;
			position: fixed;
			top: 20%;
			left: 50%;
			webkit-transform: translateX(-50%);
			-moz-transform: translateX(-50%);
			-ms-transform: translateX(-50%);
			transform: translateX(-50%);
			background-color: transparent;
			display: none;
			border-radius: 0.1rem;
    		overflow: hidden;
		}
		.serviceBox{
			width: auto;
			height:auto;
			z-index: 100;
			position: fixed;
			top: 20%;
			left: 50%;
			webkit-transform: translateX(-50%);
			-moz-transform: translateX(-50%);
			-ms-transform: translateX(-50%);
			transform: translateX(-50%);
			background-color: transparent;
			display: none;
			border-radius: 0.1rem;
    		overflow: hidden;
		}
		.promptly{
			padding: 0.05rem 0.5rem;
		    margin-bottom: 0.2rem;
		    border: none;
		    outline: none;
		    background-color: #92D050;
		    color: #FFF;
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
			padding: 0.1rem 0rem 0rem;
			font-size: 0.13rem;
			text-align: left;
			position: relative;
    		left: 0.01rem;
    		border-top: 1px solid #DDD;
		}
		.absolute{
			background-color: #fcfcfc;
		    z-index: 500;
		    position: absolute;
		    height: 0.6rem;
		    line-height: 0.3rem;
		    font-size: 0.12rem;
		    text-align: right;
		    border-radius: 0.08rem;
		    right: -0.1rem;
		    width: 80%;
		    top: 0.5rem;
		    color: #7cbb44;
		    padding: 0rem 0.2rem 0rem 0.1rem;
		}
		.borderBottom{
			border-bottom:1px solid #7cbb44;
		}
		.margin1{
			margin: 0.1rem auto;
			font-size: 0.14rem;
		}
		.show{
        	display: block;
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
	            <label class="headerName">确认订单</label>
	        </span>  
	        <span class="headerItem1 text-right">
	        	<img src="wechatImg/service.jpg" class = "headerImg right0" id="service">
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
						<input type="text" placeholder="未填写" id="medicalPersonName" class="personalNameRightInput">
					</div>
				</div>
				<div class="personalName">
					<div class="personalNameLeft">
						<img src="wechatImg/gender.png" class="inlineBlock personalNameLeftImg">
						<label class="inlineBlock personalNameLeftText">体检人性别</label>
					</div>
					<div class="personalNameRight inlineBlock" style="position: relative;">
						<input type="text" placeholder="未填写" id="medicalPersonGender" class="personalNameRightInput" readonly="readonly">
						<div class="absolute hide">
							<div class="borderBottom"><span class="liText">男</span></div>
							<div><span class="liText">女</span></div>
						</div>
					</div>
				</div>
				<div class="personalName borderBottomNone">
					<div class="personalNameLeft">
						<img src="wechatImg/contact.png" class="inlineBlock personalNameLeftImg">
						<label class="inlineBlock personalNameLeftText">联系方式</label>
					</div>
					<div class="personalNameRight inlineBlock">
						<input type="text" placeholder="未填写" id="contactWay" class="personalNameRightInput">
					</div>
				</div>	
			</div>
			<div class="medicalInfo" id="medicalInfo">
				<div class="hospitalName">
					<div class="hospitalNameLeft">
						<img src="wechatImg/hospital.png" class="hospitalNameLeftImg top11">
					</div>
					<div class="hospitalNameRight">
						<label class="hospitalNameRightText" id="hospitalNameHead"></label>
					</div>
				</div>
				<div class="medicalName">
					<div class="medicalNameLeft">
						<img src="wechatImg/serviceCharge.png" class="hospitalNameLeftImg">
						<label class="inlineBlock medicalNameLeftText" onclick="seviceCostImg()">服务费</label>
						<img src="wechatImg/question.png" class="seviceCostImg">
					</div>
					<div class="medicalNameRight">
						<label class="medicalNameRightText"><span id="selectItemPrice">0</span><span class="unit">元</span></label>
					</div>
				</div>
				<!-- <div class="medicalName">
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
				</div> -->
			</div>
		</div>
		
		<div class="footer">
			<div class="costInfo">
				<div class="costName">
					<label class="costNameDes">总额:</label>
				</div>
				<div class="costNum">
					<label><span id="totalPrice">0</span><span class="unit">元</span></label>
				</div>
				
				<div class="des">
					<div class="desLift">
						<p class="margin0">先体验</p>
						<p class="margin0">后付款</p>
					</div>
					<div class="desRight">
						<img src="wechatImg/question.png" class="desRightImg">
					</div>
				</div>
			</div>
			<div class="orders">
				<button class="btn">立即下单</button>
			</div>
		</div>
	</div>
	
	<div class="box1">
		<div class="modelHeader2">
			<span style="display:inline-block;">身边 · 先体验后付款</span>
		</div>
    	<div class="modelContent2">
			<div class="modelContentInfo2 text-center">
				<span>如何支付？</span>
				<ul>
					<li>为了您能放心享受陪检服务，我们采用了“先检查后付款”的支付模式，您可以在父母检查结束后，登入微信公众号的订单查询页面进行付款。</li>
				</ul>
			</div>
			<div class="modelContentInfo2 text-center borderTopNone paddingTop0" style="border-top: none;padding-top:0rem">
				<span>关于价格</span>
				<ul>
					<li>所有筛查项目的价格明细均与医院官方检查费用严格一致，我们希望您和家人通过最合理的价格得到权威医院的专业检查，同时享受到用心细致的线上和线下服务。</li>
					<li>如果您对价格有疑问，可查看医院官方网站或当地卫生厅(局)的《医疗服务项目价格公示》，或者直接拨打我们的24小时服务电话1855-0065-068。</li>
				</ul>
			</div>
			<div class="btnDiv">
				<button class="sure">确 定</button>
			</div>
    	</div>
	</div>

	<div class="box2">
		<div class="modelHeader2">
			<span style="display:inline-block;">身边 · 关于服务费用</span>
		</div>
    	<div class="modelContent2">
			<div class="modelContentInfo2 text-center" style="padding-top: 0rem">
				<ul>
					<li>我们将每单收取89元服务费。单笔检查总额满1000元，免收服务费。</li>
					<li>如果有任何疑问，欢迎您随时拨打身边·24小时服务电话1855-0065-068。</li>
				</ul>
			</div>
			<div class="btnDiv">
				<button class="sure">确 定</button>
			</div>
    	</div>
	</div>
	
	<div class="box4">
		<div class="modelHeader2">
			<span style="display:inline-block;">身边 ·后续服务流程</span>
		</div>
    	<div class="modelContent2">
			<div class="modelContentInfo2 text-center" style="padding-top: 0rem">
				<ul>
					<li>我们将在下单2小时后联系您的父母，约定检查日期，并发送体检地点、路线及检查注意事项。</li>
					<li>体检当天，我们会在医院内全程陪同父母，整个过程无需排队和办理其他手续。</li>
					<li>报告会在检查结束后5-7天内生成，您可在此期间完成支付并第一时间查看筛查结果。</li>
					<li>登录公众号可以随时查看进度。如有需要，我们将寄送全部检查材料（报告及发票等）供您查验。</li>
					<li>如有任何疑问，欢迎您随时拨打身边·24小时服务电话1855-0065-068。</li>
				</ul>
			</div>
			<div class="btnDiv">
				<button class="sure" onclick="confirmOrder()">确 定</button>
			</div>
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
		$(".des").click(function(){
			$(".model").css("display","block");
			$(".box1").css("display","block");
			$(".absolute").addClass('hide').removeClass('show');
			return false;
		});
		
		$(".btn").click(function(){
			$(".model").css("display","block");
			$(".box4").css("display","block");
			$(".absolute").addClass('hide').removeClass('show');
			return false;
		});
		
		$(".model").click(function(){
			$(".model").css("display","none");
			$(".box1").css("display","none");
			$(".box2").css("display","none");
			$(".box4").css("display","none");
			$(".serviceBox").css("display","none");
			return false;
		});
		
		$(".seviceCostImg").click(function(){
			$(".model").css("display","block");
			$(".box2").css("display","block");
			$(".absolute").addClass('hide').removeClass('show');
			return false;
		});
		function seviceCostImg() {
			$(".model").css("display","block");
			$(".box2").css("display","block");
			$(".absolute").addClass('hide').removeClass('show');
			return false;
		}
		
		//返回前一页
		function returnPage(){
			var hospitalId = "<%=request.getAttribute("hospitalId")%>";
			window.location.replace("<%=request.getContextPath()%>/" + "weixinReservationService.do?choosePhysicalExaminationItems&hospitalId=" + hospitalId + "&weixin=weixin");
		}

		//性别
		/*$("#medicalPersonGender").click(function(){
			$(".model").css("display","block");
			$(".box3").css("display","block");
			return false;
		});
		$(".closeModel3").click(function(){
			$(".model").css("display","none");
			$(".box3").css("display","none");
			return false;
		});
		$("input[name=gender]").on('click', function() {
			var gender = $(this).val();
			$("#medicalPersonGender").val(gender);
			$(".closeModel3").click();
			return false;
		});*/
		
		
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
							var html = "";
							var totalPrice = 0;
							var itemList = "," + "<%=request.getAttribute("itemList")%>" + ",";
							jQuery.each(data.content.medicalItemlist, function(i, item) {
								if(itemList.indexOf("," + item.id + ",") != -1){//包含这个已经选择的体检项目
									html += "<div class='medicalName'>";
									html += "<div class='medicalNameLeft'>";
									html += "<img src='" + item.icons + "' class='hospitalNameLeftImg'>";
									
									if (item.testPurpose != null && item.testPurpose != "") {
										if (item.testPurpose.length > 4) {
											html += "<label class='inlineBlock medicalNameLeftText'>" + item.testPurpose.substr(0,3) + "...</label>";
										} else {
											html += "<label class='inlineBlock medicalNameLeftText'>" + item.testPurpose + "</label>";
										}
									} else {
										html += "<label class='inlineBlock medicalNameLeftText'>无</label>";
									}
									
									html += "</div>";
									html += "<div class='medicalNameCenter'>";
									
									if (item.itemName != null && item.itemName != "") {
										if (item.itemName.length > 7) {
											html += "<label class='inlineBlock medicalNameCenterText'>" + item.itemName.substr(0,7) + "...</label>";
										} else {
											html += "<label class='inlineBlock medicalNameCenterText'>" + item.itemName + "</label>";
										}
									} else {
										html += "<label class='inlineBlock medicalNameCenterText'>无</label>";
									}
									
									html += "</div>";
									html += "<div class='medicalNameRight'>";
									html += "<label class='medicalNameRightText'>" + item.price + "<span class='unit'>元</span></label>";
									html += "</div>";
									html += "</div>";
									if (item.price != null && item.price != "") {
										totalPrice += parseInt(item.price);
									}
								}
							});
							$("#medicalInfo").append(html);
							//计算是否有服务费
							if (totalPrice < 1000) {//有服务费，目前为89
								totalPrice += 89;
								$("#selectItemPrice").html("89");
							}
							$("#totalPrice").html(totalPrice);
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
		
		//下单
		function confirmOrder() {
			var totalPrice = $("#totalPrice").html();
			var openId = "<%=request.getAttribute("openId")%>";
			var hospitalNameHead = $("#hospitalNameHead").html();
			var medicalPersonName = $.trim($("#medicalPersonName").val());
	    	if (medicalPersonName == null || medicalPersonName == "") {
				alert("体检人姓名必填");
				return;
			}
			var medicalPersonGender = $("#medicalPersonGender").val();
			if (medicalPersonGender == null || medicalPersonGender == "") {
				alert("性别必选");
				return;
			} else {
				if (medicalPersonGender == "男") {
					medicalPersonGender = "1";
				} else {
					medicalPersonGender = "0";
				}
			}
			var contactWay = $.trim($("#contactWay").val());
			if (contactWay == null || contactWay == "") {
				alert("联系方式必填");
				return;
			}
			var status = 1;//下单成功
			var isPay = 0;//未付款
			var servicePrice = $("#selectItemPrice").html();
			var itemList = "<%=request.getAttribute("itemList")%>";
			
			var reqmsg = "{'action':'ADD_ORDER_INFO_REQUEST','content':{";
	   		reqmsg += "'totalPrice':" + totalPrice + ",";
	   		reqmsg += "'orderCustomer':'" + openId + "',";
	   		reqmsg += "'medicalHospital':'" + hospitalNameHead + "',";
	    	reqmsg += "'medicalPersonName':'" + medicalPersonName + "',";
			reqmsg += "'medicalPersonGender':" + medicalPersonGender + ",";
	   		reqmsg += "'contactWay':'" + contactWay + "',";
	   		reqmsg += "'status':" + status + ",";
	   		reqmsg += "'isPay':" + isPay + ",";
	   		reqmsg += "'servicePrice':" + servicePrice + ",";
			reqmsg += "},";
			reqmsg += "'medicalItemList':'" + itemList + "'}";

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
	        		   	window.location.replace("<%=request.getContextPath()%>/" + "weixinReservationService.do?confirmSuccess&orderId=" + data.content.id + "&weixin=weixin");
	        		} else {
	        		  	window.location.replace("<%=request.getContextPath()%>/" + "weixinReservationService.do?confirmFailure&weixin=weixin");
	        		}
	      		},
	      		error:function(){
	   		    	window.location.replace("<%=request.getContextPath()%>/" + "weixinReservationService.do?confirmFailure&weixin=weixin");
	     		}
			});
		}
		
		$(".sure").click(function(){
			$(".model").css("display","none");
			$(".box1").css("display","none");
			$(".box2").css("display","none");
			$(".box3").css("display","none");
			$(".box4").css("display","none");
			return false;
		});
		
		$("#service").on("click", function() {
			$(".model").css("display","block");
			$(".serviceBox").css("display","block");
			$(".absolute").addClass('hide').removeClass('show');
		});
		
		$("body:not('.absolute')").click(function(event) {
			$(".absolute").addClass('hide').removeClass('show');
			/* Act on the event */
		});

		$("#medicalPersonGender").click(function(event) {
			$(this).next().addClass("show").removeClass("hide");
			event.stopPropagation();
			return false;
		});

		$(".absolute").on("click", "div", function(event){
			var name = $(this).text();
			$(this).addClass('weight700').removeClass('weight100');
			$(this).siblings().addClass('weight100').removeClass('weight700');
			$(".absolute").addClass('hide').removeClass('show');
			$("#medicalPersonGender").val(name);
			event.stopPropagation();
			return false;
		});
	</script>
</body>
</html>