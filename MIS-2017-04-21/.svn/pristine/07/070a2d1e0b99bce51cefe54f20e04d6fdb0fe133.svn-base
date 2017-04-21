<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="description" content="Xenon Boostrap Admin Panel" />
		<meta name="author" content="" />
		<title>安全设备</title>
		<link rel="stylesheet" href="weixincss/bootstrap.min.css" />
		<link rel="stylesheet" href="weixincss/mycss.css" />
		<script src="weixinjs/jquery.js"></script>
		<script src="weixinjs/bootstrap.min.js"></script>
		<style>
          .table>tbody>tr>td{ling-height:50px;vertical-align:middle} 
          .table>tbody>tr>td:nth-child(1) img{border:0;width:40px;margin-right:30px} 
          .table>tbody>tr>td:nth-child(2) {text-align:left} 
          .table>tbody>tr>td:nth-child(3){padding-right:0}
         </style>
     </head>
	<body>
		<div class="fixedTOP"> <!-- 页面标题 开始 -->
			<h3>安全设备</h3>
			<a href="###" class="logo" id="backToGzlr">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
		</div> <!-- 页面标题 结束 -->
		<a href="###" id="fakeLink2alarm" style="display:none;">
			<span>跳转</span>
        </a>
		<table class="table"> <!-- 安全设备 开始 -->
			<tbody id="datacontainer"></tbody>
		</table> <!-- 安全设备 结束 -->
	</body>
</html>
<script type="text/javascript">
    $(document).ready(function() {
    	var olderId = "<%=request.getAttribute("olderId")%>";
    	$("#backToGzlr").attr("href", "<%=request.getContextPath()%>/" + "wechatOlder.do?mainXQ&olderId=" + olderId + "&weixin=weixin"); //返回各人主页
    	queryDev(1); //获取老人绑定的设备
    
    });
    
    //获取老人绑定的设备
    function queryDev(pagenumber) {
    	var pagesize = 999;
    	var reqmsg = "{'action':'QUERY_DEV_LIST_REQUEST','page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{";
    	var olderId = "<%=request.getAttribute("olderId")%>"; //老人id	
    	if (olderId != null && olderId != "") { 
    		reqmsg += "\"olderId\":" + olderId + ",";
    	} 	
    	reqmsg += "}}";
    	jQuery.ajax({
    		type: "post",
    		async: true,
    		url: "dev.do?handler",
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
    
    function changeData(data) { //获取的安全设备以表格形式展示
    	var htmlcode = "";
    	if (data.content != null) {
    		jQuery.each(data.content.devList, function(i, item) {
    			htmlcode += "<tr onclick=\"go2alarmlist('" + item.id + "','" + item.olderId + "')\">"; //设备id，老人id					
    			if (item.type == "1") {
    				htmlcode += "<td><img src=\"weixinimages/dingweiqi.png\"/>" + "老人定位器" + "</td>";
    			} else if (item.type == "2") {
    				htmlcode += "<td><img src=\"weixinimages/anhubao.png\"/>" + "安护宝" + "</td>";
    			} else {
    				htmlcode += "<td><img src=\"weixinimages/weizhi.png\"/>" + "未知设备类型" + "</td>";
    			}
    			htmlcode += "<td>" + item.code + "</td>";
    			htmlcode += "<td><span class=\"glyphicon glyphicon-chevron-right\"></span></td>";
    			htmlcode += "</tr>";
    		});
    	}
    	$("#datacontainer").html(htmlcode);
    }
    
    function go2alarmlist(id, olderId) { //跳转到设备的报警列表页面
    	$("#fakeLink2alarm").attr("href", "<%=request.getContextPath()%>" + "/wechatDev.do?mainAlram&olderId=" + olderId + "&id=" + id + "&weixin=weixin");
    	$("#fakeLink2alarm span").click();
    }
</script>



