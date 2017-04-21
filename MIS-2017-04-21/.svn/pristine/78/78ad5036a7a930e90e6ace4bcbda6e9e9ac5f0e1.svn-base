<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="fsk.init.SystemInit" %>
<%
	String bigscreenlogo = SystemInit.bigscreenlogo;
	String bigscreencoordinateX = SystemInit.bigscreencoordinateX;
	String bigscreencoordinateY = SystemInit.bigscreencoordinateY;
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="shortcut icon" href="images/logo.png">
	<title>大屏展示页面</title>
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="../../assets/js/html5shiv.js"></script>
	  <script src="../../assets/js/respond.min.js"></script>
	<![endif]-->
	<link href="css/showcss.css" rel="stylesheet" />	
	<style>
		#my-slide1  .inner span:nth-child(1):after{
		content:"会员年龄分布";
		color:#222;
		}		
		#my-slide1  .inner span:nth-child(2):after{
		content:"会员性别分布";
		color:#222;
		}
		#my-slide1  .inner span:nth-child(3):after{
		content:"会员来源分布";
		color:#222;
		}
		#my-slide1 .inner span:nth-child(4):after{
		content:"会员疾病分布";
		color:#222;
		}
		#my-slide2 .inner span:nth-child(1):after{
		content:"工单类型分布";
		color:#222;
		}		
		#my-slide2 .inner span:nth-child(2):after{
		content:"市场类型分布";
		color:#222;
		}
		#my-slide2 .inner span:nth-child(3):after{
		content:"评估类型分布";
		color:#222;
		}
	</style>
</head>
<body >
	<div class="companyLogo">
		<img src="images/showpageIMG/<%=bigscreenlogo %>"></div>
	<!-- 人员 开始 -->
	<div class="Block block1">
		<div class="greenBanner greenBanner1">
			<div class="head-1">人员</div>
			<div class="head-2">
				<select id="shen_input">
					<option value="省">省</option></select>
				<select id="shi_input">
					<option value="市">市</option></select>
				<select id="qu_input">
					<option value="区">区</option></select>
				<select id="jiedao_input">
					<option value="街道">街道</option></select>
				<input type="button" onclick="chartPie1()" /></div>
			<div class="head-3 title-p1" id="title-slide1">会员年龄分布
				<ul></ul></div>
		</div>
		<div class="content content1">
			<div class="content-left">
				<div class="six-num">
					<p>老人</p>
					<p id="older_num"></p>
				</div>
				<div class="six-num">
					<p>站点</p>
					<p id="site_num"></p>
				</div>
				<div class="six-num">
					<p>服务人员</p>
					<p id="service_employee_num"></p>
				</div>
			</div>
			<div class="content-right">
				<div id="my-slide1" class="my-slide">
					<div style="background-color: #fff;" id="index-1" title="会员年龄分布">
						<div id="index-01" style="width:700px;height:380px;"></div>
					</div>
					<div style="background-color: #fff;" id="index-2" title="会员性别分布">
						<div id="index-02" style="width:700px;height:380px;"></div>
					</div>
					<div style="background-color: #fff;" id="index-3" title="会员来源分布">
						<div id="index-03" style="width:700px;height:380px;"></div>
					</div>
					<div style="background-color: #fff;" id="index-4" title="会员疾病分布">
						<div id="index-04" style="width:700px;height:380px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 人员 结束 -->
	<!-- 业务统计 开始 -->
	<div class="Block block2">
		<div class="greenBanner greenBanner2">
			<div class="head-1">业务统计</div>
			<div class="head-2">
				<select id="year">
					<option value="">全部</option>
					<option value="2016">2016年</option>
					<option value="2017">2017年</option>
					<option value="2018">2018年</option>
					<option value="2019">2019年</option>
					<option value="2020">2020年</option></select>
				<select id="month">
					<option value="">全年</option>
					<option value="1">1月</option>
					<option value="2">2月</option>
					<option value="3">3月</option>
					<option value="4">4月</option>
					<option value="5">5月</option>
					<option value="6">6月</option>
					<option value="7">7月</option>
					<option value="8">8月</option>
					<option value="9">9月</option>
					<option value="10">10月</option>
					<option value="11">11月</option>
					<option value="12">12月</option></select>
				<input type="button" onclick="chartPie2()" /></div>
			<div class="head-3 title-p2" id="title-slide2">工单类型分布</div></div>
		<div class="content content2">
			<div class="content-left">
				<div class="six-num">
					<p>服务工单</p>
					<p id="service_task_num"></p>
				</div>
				<div class="six-num">
					<p>健康评估</p>
					<p id="health_assessment_num"></p>
				</div>
				<div class="six-num">
					<p>护理计划</p>
					<p id="nursing_plan_num"></p>
				</div>
			</div>
			<div class="content-right">
				<div id="my-slide2" class="my-slide">
					<div style="background-color: #fff;" id="index-5" title="工单类型分布">
						<div id="index-05" style="width:700px;height:380px;"></div>
					</div>
					<div style="background-color: #fff;" id="index-6" title="市场类型分布">
						<div id="index-06" style="width:700px;height:380px;"></div>
					</div>
					<div style="background-color: #fff;" id="index-7" title="评估类型分布">
						<div id="index-07" style="width:700px;height:380px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 业务统计 结束 -->
	<!-- 设备地图 开始 -->
	<div class="Block block3">
		<div class="greenBanner greenBanner3">
			<div class="head-1">设备地图</div>
			<div class="head-2">
				<span id="anhubao_num">15</span>
				<span id="location_num">20</span></div>
		</div>
		<div class="content content3">
			<div class="content-left" id="scrollbar1">
				<div class="viewport" style="width: 100%">
					<div class="overview" style="width: 100%; top: 0px;">
						<ul id="srcoll-ul">
							<li style="height:500px">&nbsp;</li></ul>
					</div>
				</div>
			</div>
			<div class="content-right" id="maphere"></div>
		</div>
	</div>
	<!-- 设备地图 结束 -->
	<!-- 服务实时提醒  开始 -->
	<div class="Block block4">
		<div class="greenBanner greenBanner4">
			<div class="head-1" style="width:300px">服务实时提醒</div></div>
		<div class="content content4">
			<div>
				<table>
					<thead>
						<tr>
							<th>时间</th>
							<th>服务人员</th>
							<th>会员</th>
							<th>服务项目</th>
							<th>操作与备注</th></tr>
					</thead>
					<tbody id="scroll-1">
						<tr </tr></tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- 服务实时提醒  结束 -->
	<!-- 报警提示音乐  开始 -->
	<audio id="audio1" width="420">
		<source src="images/showpageIMG/song.mp3" type="audio/mp3" />
		<source src="images/showpageIMG/song.ogg" type="audio/ogg" /></audio>
	<!-- 报警提示音乐  结束 -->
	<script src="js/jquery.js"></script>
	<script src="js/highcharts.js"></script>
	<script src="js/no-data-to-display.js"></script>
	<script src="js/jquery.tinyscrollbar.js"></script>
	<script src="js/jquery.devrama.slider.js"></script>
	<script type="text/javascript" src="js/addressJS.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=TbEPXcQbr7UROaKUR1zzKGoB"></script>
      <!--加载鼠标绘制工具-->
	<script type="text/javascript" src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
	<link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
	<!--加载检索信息窗口-->
	<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.js"></script>
	<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.css" />
    <script type="text/javascript">
	 $(document).ready(function(){   
		Change();	 //块1、2 的标题变化 
		$('#scrollbar1').tinyscrollbar(); //初始化块3的滚动条
		$('#my-slide1').DrSlider({ //块1饼图轮播设置 
            width: 700,
			height: 380,
			userCSS: true,
			transitionSpeed: 1500,//过渡效果的时间
			duration: 15000,//15s轮播
			showNavigation: true, //导航粒
			transition: 'split3d',//动画效果
			pauseOnHover: true,				
        }); 
		$('#my-slide2').DrSlider({ //块2饼图轮播 设置
            width: 700,
			height: 380,
			userCSS: true,
			transitionSpeed: 1500,
			duration: 15000,
			showNavigation: true, 			
			transition: 'split3d',
			pauseOnHover: true,				
        }); 
	
		$("#title-slide1").mouseover(function(){	//鼠标移动到title导航栏出现 .5s没操作 自动隐藏
			$("#my-slide1 .navigation").fadeIn(500);
			setTimeout(function(){
				$("#my-slide1 .navigation").fadeOut();			
			},5000);
		   });	
		$("#title-slide2").mouseover(function(){	
			$("#my-slide2 .navigation").fadeIn(500);
			setTimeout(function(){
				$("#my-slide2 .navigation").fadeOut();			
			},5000);
		   });		
	
		$("#my-slide1 .inner").click(function(){ //鼠标点击切换视图
			$("#my-slide1 .navigation").fadeOut(100);		
		   });
		$("#my-slide2 .inner").click(function(){	
			$("#my-slide2 .navigation").fadeOut(100);		
		   });

		//省市区街道联动 
        var result = new Array();
        result = getAddresses(4897);		
        var html="";
        html+="<option value=\"省\">省</option>";
        for(var i=0;i<result.length;i++){
        	html+="<option value=\""+result[i].id+"\">"+result[i].name+"</option>";
        }
        $("#shen_input").html(html);
        $("#shi_input").html("<option value=\"市\">市</option>");
        $("#qu_input").html("<option value=\"区\">区</option>");
        $("#jiedao_input").html("<option value=\"街道\">街道</option>");
        
        $("#shen_input").change(function(e){
        	if($("#shen_input").val() == "省"){
        		$("#shi_input").html("<option value=\"市\">市</option>");
        		$("#qu_input").html("<option value=\"区\">区</option>");
        		$("#jiedao_input").html("<option value=\"街道\">街道</option>");
        	}else{
        		getquyushixinxi($("#shen_input").val());
        		getquyuquxinxi($("#shi_input").val());
        		getquyujiedaoxinxi($("#qu_input").val());
        	}
        });
        
        $("#shi_input").change(function(e){
        	if($("#shi_input").val() == "市"){
        		$("#qu_input").html("<option value=\"区\">区</option>");
        		$("#jiedao_input").html("<option value=\"街道\">街道</option>");
        	}else{
        		getquyuquxinxi($("#shi_input").val());
        		getquyujiedaoxinxi($("#qu_input").val());
        	}
        });
        
        $("#qu_input").change(function(e){
        	if($("#qu_input").val() == "区"){
        		$("#jiedao_input").html("<option value=\"街道\">街道</option>");
        	}else{
        		getquyujiedaoxinxi($("#qu_input").val());
        	}
        });

        Highcharts.theme = { //饼图统一设置 样式		
        		credits: {
        			enabled: false // 禁用版权信息
        		},
        		chart: {
        			plotBackgroundColor: null,
        			plotBorderWidth: null,
        			plotShadow: false
        		},
        		title: {
        			text: ''
        		},
        		tooltip: {
        			pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        		},
        		plotOptions: {
        			pie: {
        				size: '60%',
        				allowPointSelect: true,
        				cursor: 'pointer',
        				dataLabels: {
        					style: {
        						fontSize: "16px",
        						color: '#000'
        					},
        					enabled: true,
        					connectorColor: '#000',
        					distance: 40,
        					formatter: function() {
        						if (this.y == 0) {
        							return null;
        						} else {
        							return this.point.name + " ( " + Highcharts.numberFormat(this.percentage, 1) + "% )";
        						}
        						//return this.point.name+" ( "+Highcharts.numberFormat(this.percentage,1)+"% )";
        					}
        				}
        			}
        		}
        	};
			Highcharts.setOptions({ //饼图统一设置 各块颜色	
					colors: ['#7cb5ed','#424248','#91ed7c','#f7a35c','#8185ea','#f15c81']
			});
			Highcharts.setOptions(Highcharts.theme); //样式应用
			chartPie1();//块1，人员及饼图加载，数据刷新周期为1小时
			chartPie2();//块2，业务统计及饼图加载，数据刷新周期为1小时
			mapBaidu3();//块3，设备地图及报警加载，数据刷新周期为20s
			serviceList4();//块4，服务提醒及列表加载，数据刷新周期为20s		
	}); 
	
	function Change(){ //块1，2 title 的标题变化 
		for(var i=1;i<=7;i++){ 
			var my1 = document.getElementById("index-"+i);			
			if(my1.style.display=="block")
			{ 					
				var str = document.getElementById("index-"+i).getAttribute("title");
				if(i <= 4){
					document.getElementById("title-slide1").innerText=str;
				}else{
					document.getElementById("title-slide2").innerText=str;
				}
		    }
		}		
		window.setTimeout(Change, 500);
	}
	
	//获取市信息
	function getquyushixinxi(id) {
		var result = new Array();
		result = getAddresses(id);
		var html = "";
		html += "<option value=\"市\">市</option>";
		for (var i = 0; i < result.length; i++) {
			html += "<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
		}
		$("#shi_input").html(html);
	}

	//获取区信息
	function getquyuquxinxi(id) {
		var result = new Array();
		result = getAddresses(id);
		var html = "";
		html += "<option value=\"区\">区</option>";
		for (var i = 0; i < result.length; i++) {
			html += "<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
		}
		$("#qu_input").html(html);
	}

	//获取街道信息
	function getquyujiedaoxinxi(id) {
		var result = new Array();
		result = getAddresses(id);
		var html = "";
		html += "<option value=\"街道\">街道</option>";
		for (var i = 0; i < result.length; i++) {
			html += "<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
		}
		$("#jiedao_input").html(html);
	}
	
 	function chartPie1(){ //查询人员信息	
		var province = $("#shen_input").val(); 
		var city = $("#shi_input").val(); 
		var area = $("#qu_input").val();
		var street = $("#jiedao_input").val(); 
		var reqmsg="{'action':'QUERY_PERSON_INFO_REQUEST','content':{";
		if (province != "" && province != "省") { 
			reqmsg += "\"province\":\"" + province + "\",";
		}
		if (city != "" && city != "市") { 
			reqmsg += "\"city\":\"" + city + "\",";
		}
		if (area != "" && area != "区") {
			reqmsg += "\"area\":\"" + area + "\",";
		}
		if (street != "" && street != "街道") {
			reqmsg += "\"street\":\"" + street + "\",";
		}
		reqmsg += "}}";
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "show.do?person",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	 changeDatachartPie1(data);
	              }else if(data.des=="failure"){
	                 alert("人员查询失败");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });
	    setTimeout("chartPie1()",7200000);
	}
	  
	function changeDatachartPie1(data){ //人员信息及饼图分布展示
		$("#older_num").text(data.content.older_num);
		$("#site_num").text(data.content.site_num);
		$("#service_employee_num").text(data.content.service_employee_num);
	    var Array1 = new Array();
	    var Array2 = new Array();
	    var Array3 = new Array();
	    $.each(data.content, function(i, item) {
			var temp = new Object();
			if(i == "older_age1"){
				temp.name = '60岁以下';
				if(item != 0){
					temp.y = parseInt(item);Array1.push(temp);
				}				
			}else if(i == "older_age2"){
				temp.name = '60~70岁';
				if(item != 0){
					temp.y = parseInt(item);Array1.push(temp);
				}
			}else if(i == "older_age3"){
				temp.name = '70~80岁';
				if(item != 0){
					temp.y = parseInt(item);Array1.push(temp);
				}
			}else if(i == "older_age4"){
				temp.name = '80~90岁';
				if(item != 0){
					temp.y = parseInt(item);Array1.push(temp);
				}
			}else if(i == "older_age5"){
				temp.name = '90岁以上';
				if(item != 0){
					temp.y = parseInt(item);Array1.push(temp);
				}
			}else if(i == "older_sex1"){
				temp.name = '男性';
				if(item != 0){
					temp.y = parseInt(item);Array2.push(temp);
				}
			}else if(i =="older_sex2"){
				temp.name = '女性';
				if(item != 0){
					temp.y = parseInt(item);Array2.push(temp);
				}
			}else if(i =="older_source1"){
				temp.name = '医保';
				if(item != 0){
					temp.y = parseInt(item);Array3.push(temp);
				}
			}else if(i =="older_source2"){
				temp.name = '市场';
				if(item != 0){
					temp.y = parseInt(item);Array3.push(temp);
				}
			}			
		}); 
		var Array4_1 = new Array();//柱状图数据
		var Array4_2 = new Array();
	    $.each(data.content.diseaseList, function(i, item) {			
			Array4_1.push(i);
			Array4_2.push(parseInt(item));					
		});
	    $("#my-slide1 .inner .index0").click(); //刷新或重新查询，则轮播从新开始
	    $('#index-01').highcharts({
	        series: [{
	            type: 'pie',
	            name: '会员年龄分布',
	            data: Array1
	        }]
	    });
		$('#index-02').highcharts({
	        series: [{
	            type: 'pie',
	            name: '会员性别分布',
	            data:Array2
	        }]
	    });
		$('#index-03').highcharts({
	        series: [{
	            type: 'pie',
	            name: '会员来源分布',
	            data: Array3
	        }]
	    });
		$('#index-04').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: ''
	        },
	        legend: {
				enabled: false
			},
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            categories: Array4_1,
				labels: {
					style: {
						fontSize:'10px' //刻度字体大小
					}
				}
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: ' '
	            }
	        },
	        tooltip: {
	            headerFormat: '{series.name}<br>{point.key}: ',
	            pointFormat: '<b>{point.y:.0f}</b> 人',
	            footerFormat: ''
	            
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0,
	                 dataLabels:{enabled:true, 
					 color: '#555',}	           
	            }
	        },
	        series: [{
	            name: '会员常见疾病',
	            data: Array4_2 //[82,98,81,3,152,187,265,331,18,103,42,1042]//[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
	        }]
	    });
		
		
	}

	function chartPie2(){ //业务统计查询
		var year = $("#year").val(); 
		var month = $("#month").val(); 
		if(year=="" && month!=""){
			alert("请先选择年份");
			return;
		}
		var reqmsg="{'action':'QUERY_BUSINESS_TASK_INFO_REQUEST','content':{";
		if (year != "" && year != null) { 
			reqmsg += "\"year\":\"" + year + "\",";
		}
		if (month != "" && month != null) { 
			reqmsg += "\"month\":\"" + month + "\",";
		}
		reqmsg += "}}";
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "show.do?businessTask",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	 changeDatachartPie2(data);
	              }else if(data.des=="failure"){
	                 alert("业务统计查询失败");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });	    
	   setTimeout("chartPie2()",7200000);
	}
	
	function changeDatachartPie2(data){ //业务统计及饼图分布展示
		$("#service_task_num").text(data.content.service_task_num);
		$("#health_assessment_num").text(data.content.health_assessment_num);
		$("#nursing_plan_num").text(data.content.nursing_plan_num);
	    var Array4 = new Array();
	    var Array5 = new Array();
	    var Array6 = new Array();
	    $.each(data.content, function(i, item) {
			var temp = new Object();
			if(i == "service_type1"){
				temp.name = '基础护理';
				if(item != 0){
					temp.y = parseInt(item);Array4.push(temp);
				}
			}else if(i == "service_type2"){
				temp.name = '临床护理';
				if(item != 0){
					temp.y = parseInt(item);Array4.push(temp);
				}
			}else if(i == "service_type3"){
				temp.name = '中医康复';
				if(item != 0){
					temp.y = parseInt(item);Array4.push(temp);
				}
			}else if(i == "service_type4"){
				temp.name = '康复训练';
				if(item != 0){
					temp.y = parseInt(item);Array4.push(temp);
				}
			}else if(i == "service_type5"){
				temp.name = '其他';
				if(item != 0){
					temp.y = parseInt(item);Array4.push(temp);
				}
			}else if(i == "market_type1"){
				temp.name = '医保';
				if(item != 0){
					temp.y = parseInt(item);Array5.push(temp);
				}
			}else if(i =="market_type2"){
				temp.name = '市场';
				if(item != 0){
					temp.y = parseInt(item);Array5.push(temp);
				}
			}else if(i =="assessment_type1"){
				temp.name = '康复评定';
				if(item != 0){
					temp.y = parseInt(item);Array6.push(temp);
				}
			}else if(i =="assessment_type2"){
				temp.name = '护理评定';
				if(item != 0){
					temp.y = parseInt(item);Array6.push(temp);
				}
			}else if(i =="assessment_type3"){
				temp.name = '混合评估';
				if(item != 0){
					temp.y = parseInt(item);Array6.push(temp);
				}
			}			
		});   
	    $("#my-slide2 .inner .index0").click(); //刷新或者重新查询后，轮播从新开始	    
	    $('#index-05').highcharts({
	        series: [{
	            type: 'pie',
	            name: '工单类型分布',
	            data: Array4
	        }]
	    });
		$('#index-06').highcharts({
	        series: [{
	            type: 'pie',
	            name: '市场类型分布',
	            data: Array5
	        }]
	    });
		$('#index-07').highcharts({
	        series: [{
	            type: 'pie',
	            name: '评估类型分布',
	            data: Array6
	        }]
	    });		
	}

	function mapBaidu3(){ //设备地图查询
		var reqmsg="{'action':'QUERY_DEV_MAP_INFO_REQUEST'}";
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "show.do?devMap",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	 changeDatamapBaidu3(data);
	              }else if(data.des=="failure"){
	                 alert("设备地图查询失败");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });	    
	   setTimeout("mapBaidu3()",20000);
	}
	
	function changeDatamapBaidu3(data) { //设备绑定老人、设备安全位置及报警信息展示
		$("#anhubao_num").text(data.content.anhubao_num);
		$("#location_num").text(data.content.location_num);
		var htmlcode = "";
		var music = 0; //报警提示音
		if (data.content.devlist != null) {
			jQuery.each(data.content.devlist, function(i, item) {
				if (item.type == "1") { //定位器
					if (item.alarm == "Y") {
						if (item.alarmStatus == "0") {
							htmlcode += "<li class=\" black-dingwei redpointer \">";
							music = 1;
						}
					} else if (item.alarm == "N") {
						htmlcode += "<li class=\" black-dingwei \">";
					}
				} else if (item.type == "2") { //安护宝
					if (item.alarm == "Y") {
						if (item.alarmStatus == "0") {
							htmlcode += "<li class=\" black-anhu redpointer \">";
							music = 1;
						}
					} else if (item.alarm == "N") {
						htmlcode += "<li class=\" black-anhu \">";
					}
				}
				if (item.older_id != "0") { //有绑定老人id时，链接跳转老人详情
					htmlcode += "<a href=\"daeOlder.do?main&id=" + item.older_id + "\" target=\"_blank\">";
				} else {
					htmlcode += "<a>";
				}
				htmlcode += "<p>" + item.older_name + "</p>";
				htmlcode += "<p>" + item.older_member_num + "</p></a></li>";
			});
		}
		if (music == 1) { //有报警时，播放音乐
			var audio = document.getElementById("audio1");
			//重新播放
			audio.currentTime = 0;
			audio.play();
		}
		$("#srcoll-ul").html(htmlcode);
		//百度地图 开始
		map.clearOverlays(); //清除所有覆盖物
		for (var i = 0; i < data.content.devlist.length; i++) {
			var point = new BMap.Point(data.content.devlist[i].pos_long, data.content.devlist[i].pos_lat); //经纬度          
			var vDevType = data.content.devlist[i].type; //设备类型（1-定位器 2-安护宝）
			var valarm = data.content.devlist[i].alarm; //是否报警     
			if (valarm == "N") {
				if (vDevType == 1) {
					addBlackDingweiMarker(point);
				} else {
					addBlackAnhuMarker(point);
				}
			} else if (valarm == "Y") {
				if (vDevType == 1) {
					addRedDingweiMarker(point);
				} else {
					addRedAnhuMarker(point);
				}
			}
			if (i == 0 && valarm == "Y") {
				map.setCenter(point); //以查询到的第一个地点为地图中心map.centerAndZoom
			} else {
				map.setCenter(point1);
			}
		}
		//var allOverlay = map.getOverlays();console.log(allOverlay);
	}
	
	function serviceList4(){ //查询实时服务提醒列表 
		var reqmsg="{'action':'QUERY_SERVICE_REMIND_INFO_REQUEST'}";
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "show.do?serviceRemind",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	 changeDataserviceList4(data);
	              }else if(data.des=="failure"){
	                 alert("服务实时提醒查询失败");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });	    
	   setTimeout("serviceList4()",20000);
	}
	
	function changeDataserviceList4(data){ //实时服务提醒列表展示
		var htmlcode = "";
		if (data.content.serviceloglist != null) {
			jQuery.each(data.content.serviceloglist, function(i, item) {			
				htmlcode += "<tr><td>" + formateTime(item.create_time) + "</td>";		
			    htmlcode += "<td>" + item.service_person + "</td>";	
			    htmlcode += "<td>" + item.older_name + "</td>";	
			    htmlcode += "<td>" + item.service_name + "</td>";	
			    htmlcode += "<td title=\"" + item.log + "\">" + formateLog(item.log) + "</td>";			   
				htmlcode += "</tr>";
			});
		}
		$("#scroll-1").html(htmlcode);
	}
		
	/**
	 * 格式化时间
	 * @method formateTime
	 * @param {String} time 时间信息(YYYYMMDDHHmmSS)
	 * @return 格式化的时间(YYYY-MM-DD HH:mm:SS)
	 */
	function formateTime(time) {
		if (time != null && time.length == 14) {
			return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + " " + time.substring(8, 10) + ":" + time.substring(10, 12) + ":" + time.substring(12, 14);
		} else {
			return time;
		}
	}
	 
	//文字过长，缩略显示		 
	function formateLog(par){
		if (par != null && par.length >14) {
			return par.substring(0, 14) + "..." ;
		}else {
			return par;
		}
	}
</script>
<script type="text/javascript">
     var x = <%=bigscreencoordinateX %>;
     var y = <%=bigscreencoordinateY %>;
     var map = new BMap.Map("maphere");
     var point1 = new BMap.Point(x,y);
     map.centerAndZoom(point1, 10);
     map.addControl(new BMap.NavigationControl());  ///放大缩小
     map.addControl(new BMap.ScaleControl());
     map.addControl(new BMap.OverviewMapControl());
     map.enableScrollWheelZoom();

     // 编写自定义函数,创建标注；有报警的定位器
     function addRedDingweiMarker(point){
         var icons = "images/showpageIMG/reddingwei.png"; //要显示坐标的图片的相对路径 
         var icon = new BMap.Icon(icons, new BMap.Size(40, 40)); //显示图标大小 
         var marker = new BMap.Marker(point); //创建标注点
         marker.setIcon(icon); //设置标签的图标为自定义图标      
         marker.setTop(true);
         map.addOverlay(marker);
         marker.setAnimation(BMAP_ANIMATION_BOUNCE);
      	 // marker.setAnimation(BMAP_ANIMATION_DROP); 
         marker.addEventListener("click", function () {
         //console.log(point)
         //document.getElementById("txtOldIDHide").value=olderId;
         // document.getElementById("txtCodeHide").value=code;
         // document.getElementById("txtPointHideC").click();
        });
     }

     // 有报警的安护宝
     function addRedAnhuMarker(point){
         var icons = "images/showpageIMG/redanhu.png"; 
         var icon = new BMap.Icon(icons, new BMap.Size(40, 40)); 
         var marker = new BMap.Marker(point); 
         marker.setIcon(icon);      
         marker.setTop(true);
         map.addOverlay(marker);
         marker.setAnimation(BMAP_ANIMATION_BOUNCE);
         marker.addEventListener("click", function () {
     	});
     }

     // 没报警的定位器
     function addBlackDingweiMarker(point){
         var icons = "images/showpageIMG/bluedingwei.png"; 
         var icon = new BMap.Icon(icons, new BMap.Size(40, 40)); 
         var marker = new BMap.Marker(point); 
         marker.setIcon(icon); 
         map.addOverlay(marker);
     }

     // 没报警的安护宝
     function addBlackAnhuMarker(point){
         var icons = "images/showpageIMG/blueanhu.png"; 
         var icon = new BMap.Icon(icons, new BMap.Size(40,40)); 
         var marker = new BMap.Marker(point);
         marker.setIcon(icon); 
         map.addOverlay(marker);
     }

</script>
</body>
</html>
