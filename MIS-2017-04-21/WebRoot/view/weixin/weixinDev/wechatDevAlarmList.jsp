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
		<title>历史报警</title>
		<link rel="stylesheet" href="weixincss/bootstrap.min.css">
		<link rel="stylesheet" href="weixincss/mycss.css">
		<script src="weixinjs/jquery.js"></script>
		<script src="weixinjs/bootstrap.min.js"></script>
		<style>
          .table{margin:0} 
          .table th:nth-child(1), .table td:nth-child(1) {min-width: 0;} 
          .table th:nth-child(2), .table td:nth-child(2) {text-align:center} 
          .table th:nth-child(3), .table td:nth-child(3) {text-align:right} 
          .table>tbody>tr:nth-last-child(1)>td{border-bottom:1px solid #ddd;} 
          .select-1{margin:60px auto 5px auto;width:100px} 
          .select-2{margin:5px auto ;width:100px} 
          .select-1 option, .select-2 option{font-size:18px;}
        </style>
    </head>
	<body>
		<div class="fixedTOP"> <!-- 页面标题 开始 -->
			<h3>历史报警</h3>
			<a href="###" class="logo" id="backToGzlr">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
		</div> <!-- 页面标题 结束 -->
		<a href="###" id="fakeLink2alarm" style="display:none;">
			<span>跳转</span></a>
		<select class="form-control btn-info select-1" id="paginationArea" onchange="query()"> <!-- 列表分页 开始 -->
			<!-- <option value="1">&nbsp;首 页&nbsp;</option>
			<option value="3">第 3 页</option>
			<option value="4">第 4 页</option>
			<option value="5" selected>第 5 页</option>
			<option value="6">第 6 页</option>
			<option value="7">第 7 页</option>
			<option value="22">&nbsp;末 页&nbsp;</option> -->
       </select> <!-- 列表分页 结束 -->
		<table class="table"> <!-- 报警列表 开始 -->
			<tbody id="datacontainer">
				<!-- <tr>
				<td>
				<table class="tableInTable">
				<tr><td>服务工单编号</td><td>FW201602020003</td></tr>
				<tr><td>服务项目</td><td>饮食照料、身体护U</td></tr>
				<tr><td>服务时间</td><td>2016-02-05 12:30</td></tr></table>
				</td>
				<td><span class="glyphicon glyphicon-chevron-right"></span></td></tr> -->
			</tbody>
		</table> <!-- 报警列表 结束 -->
		<select class="form-control btn-info select-2" id="paginationArea2" onchange="query2()"> <!-- 列表分页 开始 -->
			<!-- <option value="1">&nbsp;首 页&nbsp;</option>
			<option value="3">第 3 页</option>
			<option value="4">第 4 页</option>
			<option value="5" selected>第 5 页</option>
			<option value="6">第 6 页</option>
			<option value="7">第 7 页</option>
			<option value="22">&nbsp;末 页&nbsp;</option> -->
        </select> <!-- 列表分页 结束 -->
	</body>

</html>
<script type="text/javascript">
	var olderId = ""; //老人id
	var devid = ""; //设备id
	$(document).ready(function() {
		GetRequest();
		$("#backToGzlr").attr("href", "<%=request.getContextPath()%>/" + "wechatDev.do?main&olderId=" + olderId + "&weixin=weixin"); //返回绑定的设备列表页面	
		queryalarm(1); //获取报警列表

	});
	function GetRequest() { //根据url地址获得相关参数
		var url = location.search; //获取url中"?"符后的字串
		var theRequest = new Object();
		if (url.indexOf("?") != -1) {
			var str = url.substr(1);
			strs = str.split("&");
			devid = strs[2].split("=")[1];
			console.log(devid);
			olderId = strs[1].split("=")[1];
		}
	}

	var currentshownpage = 1; //当前页码
	function query() { //根据页码选择跳转
		var pagenumber = $("#paginationArea").val();
		if (currentshownpage != pagenumber) {
			currentshownpage = pagenumber;
			queryalarm(pagenumber);
		} else {
			return;
		}
	}
	function query2() { //根据页码选择跳转
		var pagenumber = $("#paginationArea2").val();
		if (currentshownpage != pagenumber) {
			currentshownpage = pagenumber;
			queryalarm2(pagenumber);
		} else {
			return;
		}
	}
	function queryalarm(pagenumber) { //获取报警列表
		var pagesize = 10; //默认每页10条报警信息
		var reqmsg = "{'action':'QUERY_DEV_ALARM_LIST_REQUEST','order':[{'column':'alarmTime','type':'desc'}],'page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{";
		if (olderId != null && olderId != "" && olderId != "0") {
			reqmsg += "\"olderId\":" + olderId + ",";
		}
		if (devid != null && devid != "" && devid != "0") {
			reqmsg += "\"devId\":" + devid + ",";
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
	
	function changeData(data) { //获取的报警历史以表格形式展示
		var htmlcode = "";
		if (data.content != null) {
			jQuery.each(data.content.devAlarmList, function(i, item) {
				htmlcode += "<tr onclick=\"go2alarmlistdetail('" + item.id + "','" + item.devId + "','" + item.olderId + "')\">"; //报警信息id,devId,olderId
				htmlcode += "<td>" + item.alarmContent + "</td>";
				htmlcode += "<td>" + formateTime(item.alarmTime) + "</td>";
				htmlcode += "<td>" + item.address + "</td>";
				htmlcode += "</tr>";
			});
		}
		$("#datacontainer").html(htmlcode);
		if (htmlcode == "") {
			$("#paginationArea").attr("style", "display:none;");
			$("#paginationArea2").attr("style", "display:none;");
			return;
		}
		if (data.page != null) {
			genaratePaginateHtml(data.page.pageno, data.page.pageCount);
		} else {
			genaratePaginateHtml(1, 1);
		}
	}

	/**
	 * 生成分页信息
	 * @method genaratePaginateHtml
	 * @param {Number} currentpage 当前页
	 * @param {Number} totalpage 总页数
	 */
	function genaratePaginateHtml(currentpage, totalpage) {
		currentshownpage = currentpage;
		var htmlcode = "";
		//首 页
		htmlcode += "<option value=\"1\">&nbsp;首 页&nbsp;</option>";
		//具体页码
		if (totalpage <= 5) {
			for (var i = 1; i <= totalpage; i++) {
				if (currentpage == i) {
					htmlcode += "<option value=\"" + i + "\" selected>第" + i + "页</option>";
				} else {
					htmlcode += "<option value=\"" + i + "\">第" + i + "页</option>";
				}
			}
		} else {
			var startpage = currentpage;
			var endpage = currentpage;
			while (true) {
				if (endpage - startpage >= 4) {
					break;
				} else {
					if (startpage > 1) {
						startpage = startpage - 1;
					}
					if (endpage < totalpage) {
						endpage = endpage - ( - 1);
					}
				}
			}

			for (var i = startpage; i <= endpage; i++) {
				if (currentpage == i) {
					htmlcode += "<option value=\"" + i + "\" selected>第" + i + "页</option>";
				} else {
					htmlcode += "<option value=\"" + i + "\">第" + i + "页</option>";
				}
			}
		}
		//末页
		htmlcode += "<option value=\"" + totalpage + "\">&nbsp;末页&nbsp;</option>";
		$("#paginationArea").html(htmlcode);
		$("#paginationArea2").html(htmlcode);
	 }
	
	 function go2alarmlistdetail(id, devId, olderId) { //跳转到报警详情页面（报警信息id,devId,olderId）
		$("#fakeLink2alarm").attr("href", "<%=request.getContextPath()%>" + "/wechatDev.do?mainDetail&id=" + id + "&devId=" + devId + "&olderId=" + olderId + "&weixin=weixin");
		$("#fakeLink2alarm span").click();
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



