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
<title>老人历史服务</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>
<script src="weixinjs/bootstrap.min.js"></script>
<style>
.table {
	margin: 0
}

.table>tbody>tr>td:nth-child(2) {
	width: 32px;
	vertical-align: middle
}

.table>tbody>tr>td:nth-child(1) {
	padding-right: 0
}

.table>tbody>tr:nth-last-child(1)>td {
	border-bottom: 1px solid #ddd;
}

.select-1 {
	margin: 60px auto 5px auto;
	width: 100px
}

.select-2 {
	margin: 5px auto;
	width: 100px
}

.select-1 option,.select-2 option {
	font-size: 18px;
}
</style>
</head>

<body>
	<div class="fixedTOP">
		<h3>历史服务</h3>
		<a href="###" class="logo" id="backToGzlr"> <span class="glyphicon glyphicon-chevron-left"></span> </a>
	</div>
	<div style="display:none;">
		<a href="###" id="gdtz_a1" style="display:none;"><span id="gdtz1">跳转</span>
		</a> <a href="###" id="gdtz_a2" style="display:none;"><span id="gdtz2">跳转</span>
		</a> <a href="###" id="gdtz_a3" style="display:none;"><span id="gdtz3">跳转</span>
		</a> <a href="###" id="gdtz_a4" style="display:none;"><span id="gdtz4">跳转</span>
		</a> <a href="###" id="gdtz_a5" style="display:none;"><span id="gdtz5">跳转</span>
		</a> <a href="###" id="gdtz_a6" style="display:none;"><span id="gdtz6">跳转</span>
		</a> <a href="###" id="gdtz_a7" style="display:none;"><span id="gdtz7">跳转</span>
		</a> <a href="###" id="gdtz_a8" style="display:none;"><span id="gdtz8">跳转</span>
		</a> <a href="###" id="gdtz_a9" style="display:none;"><span id="gdtz9">跳转</span>
		</a> <a href="###" id="gdtz_a10" style="display:none;"><span id="gdtz10">跳转</span>
		</a>
	</div>
	<div style="text-align: center;margin-bottom:15px;margin-top:10px;">
		<select id="fuwustate_input" style="margin-top:50px;width:100px;display: inline-block;text-align: center;" class="form-control btn-info" id="" onchange="queryServiceHistory('top')">
			<option value="">全部</option>
			<option value="1">取消</option>
			<option value="8">已下单</option>
			<option value="4">待服务</option>
			<option value="5,6,7">已服务</option>
		</select> 
		<select class="form-control btn-info select-1" id="paginationArea" onchange="queryServiceHistory('top')" style="margin: 0 auto;display: inline-block;text-align: center;">
			<!-- <option value="1">&nbsp;首 页&nbsp;</option>
      			<option value="3">第 3 页</option>
      			<option value="4">第 4 页</option>
      			<option value="5" selected>第 5 页</option>
      			<option value="6">第 6 页</option>
      			<option value="7">第 7 页</option>
      		<option value="22">&nbsp;末 页&nbsp;</option> -->
		</select>
	</div>

	<table class="table" id="tableweizhi">
		<tbody id="datacontainer">
			<!-- <tr>
         			<td>
		 			<table class="tableInTable">
						<tr><td>服务工单编号</td><td>FW201602020003</td></tr>
						<tr><td>服务项目</td><td>饮食照料、身体护U</td></tr>
						<tr><td>服务时间</td><td>2016-02-05 12:30</td></tr>
		 			</table>
		 			</td>
         			<td><span class="glyphicon glyphicon-chevron-right"></span></td>
      		</tr> -->
		</tbody>
	</table>
	<select class="form-control btn-info select-2" id="paginationArea2" onchange="queryServiceHistory('bottom')">
		<!-- <option value="1">&nbsp;首 页&nbsp;</option>
      			<option value="3">第 3 页</option>
      			<option value="4">第 4 页</option>
      			<option value="5" selected>第 5 页</option>
      			<option value="6">第 6 页</option>
      			<option value="7">第 7 页</option>
      	<option value="22">&nbsp;末 页&nbsp;</option> -->
	</select>
	<!-- <p class="jumpPage">
		跳转到第&nbsp;<input type="text" size="2">&nbsp;/<span id="totalPage">22</span>&nbsp;页&nbsp;&nbsp;<a>GO!</a>
	</p> -->
</body>
</html>
<script type="text/javascript" src="js/mordo.tools/mordo.timeProcessing.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var olderId = "<%=request.getAttribute("olderId")%>";
    $("#backToGzlr").attr("href","<%=request.getContextPath()%>/" + "wechatOlder.do?mainXQ&olderId=" + olderId + "&weixin=weixin");
    	
	queryServiceHistoryInit();
});

var currentshownpage = 1;

function queryServiceHistoryInit(){//页面列表数据初始化
	go2page(1);
}

function queryServiceHistory(flag){//分页和状态搜索查询
	var pagenumber = "";
	if(flag == "top"){//顶部分页
		pagenumber = $("#paginationArea").val();
	}else if(flag == "bottom"){//底部分页
		pagenumber = $("#paginationArea2").val();
	}
	currentshownpage = pagenumber;
	go2page(pagenumber);
}

function go2page(pagenumber){
	var olderId = "<%=request.getAttribute("olderId")%>";
	
	var fuwustate_input = $("#fuwustate_input").val();
	
    jQuery.ajax({
          type : "post",
          async:true,
          url : "serviceTask.do?wechatQuery",
          dataType : "json",
          data: {
               "pageno":pagenumber,
               "pagesize":10,
               "olderId":olderId,
               "status":fuwustate_input,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des=="success"){
            	  changeData(data);
              }else if(data.des=="failure"){
                 alert("查询失败");
              }
          },
          error:function(){
	           alert("error");
          }
     });
} 
function changeData(data){
	var htmlcode = "";
	if (data.content != null) {
		var fwxm = "";
		var fzrname = "";
		jQuery.each(data.content.serviceTaskList, function(i, item) {
			fwxm = "";
			fzrname = "";
		    jQuery.each(item.serviceList, function(j, item2) {
		    	fwxm += item2.name + ",";
		    });
		    jQuery.each(item.serviceEmployeeList, function(z, item3) {
		    	if(item3.type == 1){
		    		fzrname = item3.name;
		    	}
		    });
		    if(fwxm != ""){
		    	fwxm = fwxm.substr(0,fwxm.length-1);
		    }
		    
		    $("#gdtz_a" + (i+1)).attr("href","<%=request.getContextPath()%>" + "/wechatServiceHistory.do?mainXQ&gongdanId=" + item.id + "&weixin=weixin");
      		htmlcode += "<tr onclick=\"$('#gdtz"+ (i+1) + "').click()\">";
		    htmlcode += "<td>";
		    htmlcode += "<table class=\"tableInTable\">"; 
		    htmlcode += "<tr><td>服务工单编号</td><td>" + item.serviceCode + "</td></tr>";
		    htmlcode += "<tr><td>服务项目</td><td>" + fwxm + "</td></tr>";
		    
		    htmlcode += "<tr><td>负责人</td><td>" + fzrname + "</td></tr>";
		 	
		 	if(item.serviceStartTime != null && item.serviceStartTime != ""){
		 		htmlcode += "<tr><td>服务时间</td><td>" + formateTime(item.serviceStartTime) + "</td></tr>";
		 	}else{
		 		htmlcode += "<tr><td>服务时间</td><td>服务未开始</td></tr>";
		 	}
		   
		    htmlcode += "</table>";
		    htmlcode += "</td>";
		    htmlcode += "<td><span class=\"glyphicon glyphicon-chevron-right\"></span></td>";
		    htmlcode += "</tr>";
		});
	}
	$("#datacontainer").html(htmlcode);
	if(htmlcode == ""){
		$("#paginationArea").hide();
		$("#paginationArea2").hide();
		return;
	}
	if(data.page.recordCount < 11){
		$("#tableweizhi").attr("style","margin-top:10px;");
		$("#paginationArea").hide();
		$("#paginationArea2").hide();
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
					endpage = endpage - (-1);
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
</script>