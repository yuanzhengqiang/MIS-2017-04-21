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
<title>健康评估列表</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>	
	.table{margin:0}
	.table>tbody>tr:nth-last-child(1)>td{border-bottom:1px solid #ddd;}	
	.table>tbody>tr>td:nth-child(1){min-width:80px}
	.table>tbody>tr>td:nth-child(3), .table>thead>tr>th:nth-child(3){text-align:right}
	.table>tbody>tr>td:nth-child(2),.table>thead>tr>th:nth-child(2){text-align:center;}	
	.table>tbody>tr>td:nth-child(4){width:30px;color:#888}
	.table>tbody>tr>td:nth-child(2) span{color:#333}	
	.select-1{margin:60px auto 5px auto;width:100px}
	.select-2{margin:5px auto ;width:100px}
	.select-1 option, .select-2 option{font-size:18px;}
</style>
</head>

<body>
	<div class="fixedTOP">		
		<h3>健康评估</h3>
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
	</div>
	<div style="display:none;">
		<a href="###" id="jkpg_a1" style="display:none;"><span id="jkpg1">跳转</span></a>
		<a href="###" id="jkpg_a2" style="display:none;"><span id="jkpg2">跳转</span></a>
		<a href="###" id="jkpg_a3" style="display:none;"><span id="jkpg3">跳转</span></a>
		<a href="###" id="jkpg_a4" style="display:none;"><span id="jkpg4">跳转</span></a>
		<a href="###" id="jkpg_a5" style="display:none;"><span id="jkpg5">跳转</span></a>
		<a href="###" id="jkpg_a6" style="display:none;"><span id="jkpg6">跳转</span></a>
		<a href="###" id="jkpg_a7" style="display:none;"><span id="jkpg7">跳转</span></a>
		<a href="###" id="jkpg_a8" style="display:none;"><span id="jkpg8">跳转</span></a>
		<a href="###" id="jkpg_a9" style="display:none;"><span id="jkpg9">跳转</span></a>
		<a href="###" id="jkpg_a10" style="display:none;"><span id="jkpg10">跳转</span></a>
	</div>
	<select  class="form-control btn-info select-1" id="paginationArea" onchange="queryJKPG()">
      <!-- <option value="1">&nbsp;首 页&nbsp;</option>
      <option value="3">第 3 页</option>
      <option value="4">第 4 页</option>
      <option value="5" selected>第 5 页</option>
      <option value="6">第 6 页</option>
      <option value="7">第 7 页</option>
      <option value="22">&nbsp;末 页&nbsp;</option> -->
    </select>

  <table class="table" id="tableweizhi">
   <thead>
		<tr>
			<th>评估类型</th>
			<th>评估人</th>
			<th>评估时间</th>
			<th></th>
		</tr>
   </thead>
   <tbody id="datacontainer">
      <!-- 一页10组数据，tbody中共有10个tr，
      <tr>
         <td>混合评估</td>
         <td>王医师</td>       
         <td>2016-02-05 12:00:00</td>
         <td><span class="glyphicon glyphicon-chevron-right"></span></td>
      </tr>
      <tr>
         <td>混合评估</td>
         <td>王医师</td>       
         <td>2016-02-05 12:00:00</td>
         <td><span class="glyphicon glyphicon-chevron-right"></span></td>
      </tr>
      <tr>
         <td>混合评估</td>
         <td>王医师</td>       
         <td>2016-02-05 12:00:00</td>
         <td><span class="glyphicon glyphicon-chevron-right"></span></td>
      </tr> -->
   </tbody>
   </table>
	<select  class="form-control btn-info select-2" id="paginationArea2" onchange="queryJKPG2()">
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
<script type="text/javascript">
	$(document).ready(function(){
		var olderId = "<%=request.getAttribute("olderId")%>";
    	$("#backToGzlr").attr("href","<%=request.getContextPath()%>/" + "wechatOlder.do?mainXQ&olderId=" + olderId + "&weixin=weixin");
    	
		queryJKPGCSH();
		
	});

var currentshownpage = 1;

function queryJKPGCSH(){
	currentshownpage = 1;
	go2page(1);
}

function queryJKPG(){
	var pagenumber = $("#paginationArea").val();
	currentshownpage = pagenumber;
	go2page(pagenumber);
}
function queryJKPG2(){
	var pagenumber = $("#paginationArea2").val();
	currentshownpage = pagenumber;
	go2page(pagenumber);
}

function go2page(pagenumber){
	var olderId = "<%=request.getAttribute("olderId")%>";
	
	var reqmsg="{'action':'QUERY_HEALTH_ASSESSMENT_LIST_REQUEST','order':[{'column':'assessmentTime','type':'desc'}],'page':{'pageno':'" + pagenumber + "','pagesize':'10'},'content':{";
	
	if (olderId != null && olderId != "") {
		reqmsg += "\"olderId\":" + olderId + ",";
	}
	if (olderId != null && olderId != "") {
		reqmsg += "\"taskStatus_in\":\"3\",";
	}
	
	reqmsg += "}}";

    jQuery.ajax({
          type : "post",
          async:true,
          url : "healthAssessment.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
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
	var olderId = "<%=request.getAttribute("olderId")%>";
	if (data.content != null) {
		if(data.content.healthAssessmentList != null) {
			jQuery.each(data.content.healthAssessmentList, function(i, item) {
				$("#jkpg_a" + (i+1)).attr("href","<%=request.getContextPath()%>" + "/wechatHealthAssessment.do?mainBG&healthReportId=" + item.healthReportId + "&olderId=" + olderId + "&type=" + item.type + "&weixin=weixin");
				htmlcode += "<tr onclick=\"$('#jkpg"+ (i+1) + "').click()\">";
				htmlcode += "<td>" + changeType(item.type) + "</td>";
				if(item.employeeName != null && item.employeeName !=""){
					htmlcode += "<td>" + item.employeeName + "</td>";
		    	}else{
		    		htmlcode += "<td></td>";
		    	}
				htmlcode += "<td>" + formateTime(item.assessmentTime) + "</td>";
				htmlcode += "<td><span class=\"glyphicon glyphicon-chevron-right\"></span></td>";
				htmlcode += "</tr>";
			});
		}
	}
	$("#datacontainer").html(htmlcode);
	if(htmlcode == ""){
		$("#paginationArea").attr("style","display:none;");
		$("#paginationArea2").attr("style","display:none;");
		return;
	}
	if(data.page.recordCount < 11){
		$("#tableweizhi").attr("style","margin-top:50px;");
		$("#paginationArea").attr("style","display:none;");
		$("#paginationArea2").attr("style","display:none;");
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

//评估类别转化
function changeType(type){
	var typeName = "";
	switch(type){
		case 1:
			typeName = "康复评估";
			break;
		case 2:
			typeName = "护理评估";
			break;
		case 3:
			typeName = "混合健康评估";
			break;
		default:
			typeName = "未知";
			break;
	}
	return typeName;
}
</script>