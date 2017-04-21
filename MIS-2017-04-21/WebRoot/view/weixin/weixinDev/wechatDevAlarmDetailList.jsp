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
		<title>报警详情</title>
		<link rel="stylesheet" href="weixincss/bootstrap.min.css">
		<link rel="stylesheet" href="weixincss/mycss.css">
		<script src="weixinjs/jquery.js"></script>
		<script src="weixinjs/bootstrap.min.js"></script>
		<style>
          .basicinfo{margin-top:50px}
          .basicinfo h4,.place h4{text-indent:10px;background:#eee;line-height:40px;}
          .basicinfo p,.place p{margin-left:30px}
          .maphere{height:500px}
        </style>
	</head>
	<body>
		<div class="fixedTOP"> <!-- 页面标题 开始 -->
			<h3>报警详情</h3>
			<a href="###" class="logo" id="backToGzlr">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
		</div> <!-- 页面标题 结束 -->
		<div class="basicinfo"> <!-- 报警详情基本信息 开始 -->
			<h4>基本信息</h4>
			<p>报警时间：
				<span id="alarmTime"></span></p>
			<p>报警内容：
				<span id="alarmContent"></span></p>
			<p>报警地址：
				<span id="address"></span></p>
		</div> <!-- 报警详情基本信息 结束 -->
		<div class="place"> <!-- 报警详情百度地图 开始 -->
			<h4 style="margin-top:20px">位置</h4>
			<p>报警点经纬度：
				<span id="posLong"></span></p>
			<div class="maphere" id="maphere"></div>
		</div> <!-- 报警详情百度地图 结束 -->
    
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=TbEPXcQbr7UROaKUR1zzKGoB"></script>
	<script type="text/javascript">
		var olderId = ""; //老人id
		var devid = ""; //设备id
		var id = "" //报警信息id
		$(document).ready(function() {
			GetRequest();  //根据url地址获得相关参数
			$("#backToGzlr").attr("href", "<%=request.getContextPath()%>" + "/wechatDev.do?mainAlram&olderId=" + olderId + "&id=" + devid + "&weixin=weixin");//返回报警历史页面
			queryDetail(); //获取报警详情
		});
		function GetRequest() { //根据url地址获得相关参数
			var url = location.search; //获取url中"?"符后的字串
			var theRequest = new Object();
			if (url.indexOf("?") != -1) {
				var str = url.substr(1);
				strs = str.split("&"); //报警信息id,devId,olderId
				id = strs[1].split("=")[1];
				devid = strs[2].split("=")[1];
				olderId = strs[3].split("=")[1];
			}
		}
		function queryDetail() { //获取报警详情
			var reqmsg = "{'action':'QUERY_DEV_ALARM_INFO_REQUEST','content':{";
			if (id != null && id != "" && id != "0") {
				reqmsg += "\"id\":" + id + ",";
			}
			reqmsg += "}}";
			jQuery.ajax({
				type: "post",
				async: true,
				url: "devAlarm.do?handler",
				dataType: "json",
				data: {
					"reqmsg": reqmsg,
					"weixin": "weixin"
				},
				success: function(data) {
					if (data.des == "success") {
						changeData(data);
					} else if (data.des == "failure") {
						alert("查询失败");
					}
				},
				error: function() {
					alert("error");
				}
			});
		}

		function changeData(data) { //报警详情页面展示
			if (data.content != null) {
				$("#alarmTime").text(formateTime(data.content.alarmTime));
				$("#alarmContent").text(data.content.alarmContent);
				$("#address").text(data.content.address); //报警详情基本信息

				// 百度地图API功能
				var map = new BMap.Map("maphere");
				var point1 = new BMap.Point(116.404, 39.915);
				map.centerAndZoom(point1, 16);
				map.addControl(new BMap.NavigationControl()); ///放大缩小
				map.addControl(new BMap.ScaleControl());
				map.addControl(new BMap.OverviewMapControl());
				map.enableScrollWheelZoom(); //百度地图初始化完毕
				if (data.content.posLong != "" && data.content.posLong != null && data.content.posLat != "" && data.content.posLat != null) {
					$("#posLong").html("(" + data.content.posLong + "," + data.content.posLat + ")");
					var point = new BMap.Point(data.content.posLong, data.content.posLat);
					var marker = new BMap.Marker(point); //报警经纬度	    	
					map.addOverlay(marker);
					map.setCenter(point); //加载报警点
				} else {
					return;
				}
			}
		}

		/**
       * 格式化时间
       * @method formateTime
       * @param {String} time 时间信息(YYYYMMDDHHmmSS)
       * @return 格式化的时间(YYYY-MM-DD HH:mm)
       */
		function formateTime(time) {
			if (time != null && time.length == 14) {
				return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + " " + time.substring(8, 10) + ":" + time.substring(10, 12);
			} else {
				return time;
			}
		}
    </script>
	</body>
</html>