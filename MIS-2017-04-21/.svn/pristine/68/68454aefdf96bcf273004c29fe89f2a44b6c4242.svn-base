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
<title>生理参数历史</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>	
	.table{margin:0}
	.table>tbody>tr:nth-last-child(1)>td{border-bottom:1px solid #ddd;}
	.table tr:nth-child(2n) td{border:0;padding-top:0}
	.table>tbody>tr>td:nth-child(1){min-width:80px}
	.table>tbody>tr>td:nth-child(4),.table>thead>tr>th:nth-child(4){text-align:right}
	.table>tbody>tr>td:nth-child(2),.table>tbody>tr>td:nth-child(3),.table>thead>tr>th:nth-child(2),.table>thead>tr>th:nth-child(3){text-align:left;padding-left:0;padding-right:0;}	
	
	 span.glyphicon-arrow-down ,  span.glyphicon-arrow-up{color:#e2221a;}
	 span.glyphicon-star{color:#8ac007;}
	 .table>tbody>tr>td:nth-child(2) span{color:#333}	
	.select-1{margin:60px auto 5px auto;width:100px}
	.select-2{margin:5px auto ;width:100px}
	.select-1 option, .select-2 option{font-size:18px;}
</style>
</head>

<body>
	<div class="fixedTOP">		
		<h3 id="head_slcs">生理参数</h3>
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
	</div>
	<select  class="form-control btn-info select-1"  id="paginationArea" onchange="querySLCSHistory()">
      <!-- <option value="1">&nbsp;首 页&nbsp;</option>
      <option value="3">第 3 页</option>
      <option value="4">第 4 页</option>
      <option value="5" selected>第 5 页</option>
      <option value="6">第 6 页</option>
      <option value="7">第 7 页</option>
      <option value="22">&nbsp;末 页&nbsp;</option> -->
    </select>

  <table class="table" >
   <thead>
		<tr>
			<th>参数</th>
			<th>参数值</th>
			<th>状态</th>
			<th>评估时间</th>
		</tr>
   </thead>
   <tbody id="datacontainer">
   <!-- 一页10组数据，收缩压和舒张压,餐后餐前血糖每组有2个数据，tbody中共有20个tr，
      <tr>
         <td>收缩压</td>
         <td><span>90</span><span>&nbsp;mmHg</span></td>
         <td><span class="glyphicon glyphicon-arrow-down"></span></td>         
         <td>2016-02-05 12:00:00</td>
      </tr>
      <tr>
         <td>舒张压</td>
         <td><span>130</span><span>&nbsp;mmHg</span></td>
         <td></td>         
         <td>2016-02-05 12:00:00</td>
      </tr>
      <tr>
         <td>收缩压</td>
         <td><span>90</span><span>&nbsp;mmHg</span></td>
         <td><span class="glyphicon glyphicon-arrow-down"></span></td>         
         <td>2016-02-05 12:00:00</td>
      </tr>
      <tr>
         <td>舒张压</td>
         <td><span>190</span><span>&nbsp;mmHg</span></td>
         <td><span class="glyphicon glyphicon-arrow-up"></span></td>         
         <td>2016-02-05 12:00:00</td>
      </tr>
      <tr>
         <td>收缩压</td>
         <td><span>90</span><span>&nbsp;mmHg</span></td>
         <td><span class="glyphicon glyphicon-arrow-down"></span></td>         
         <td>2016-02-05 12:00:00</td>
      </tr>
      <tr>
         <td>舒张压</td>
         <td><span>120</span><span>&nbsp;mmHg</span></td>
         <td></td>      
         <td>2016-02-05 12:00:00</td>
      </tr> -->
   </tbody>
   </table>
	<select  class="form-control btn-info select-2" id="paginationArea2" onchange="querySLCSHistory2()">
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
    	$("#backToGzlr").attr("href","<%=request.getContextPath()%>/" + "wechatPhysiologicalPar.do?main&olderId=" + olderId + "&weixin=weixin");
    	var type = "<%=request.getAttribute("type")%>";
    	$("#head_slcs").html(pipeiSLCSLX2(type));
		querySLCSHistoryCSH();
		
	});

var currentshownpage = 1;

function querySLCSHistoryCSH(){
	currentshownpage = 1;
	go2page(1);
}

function querySLCSHistory(){
	var pagenumber = $("#paginationArea").val();
	currentshownpage = pagenumber;
	go2page(pagenumber);
}
function querySLCSHistory2(){
	var pagenumber = $("#paginationArea2").val();
	currentshownpage = pagenumber;
	go2page(pagenumber);
}

function go2page(pagenumber){
	var olderId = "<%=request.getAttribute("olderId")%>";
	var type = "<%=request.getAttribute("type")%>";
	type = pipeiSLCSLX(type);

	var reqmsg="{'action':'QUERY_PHYSIOLOGICAL_PARAMETERS_HISTORY_LIST_REQUEST','order':[{'column':'createTime','type':'desc'}],'page':{'pageno':'" + pagenumber + "','pagesize':'10'},'content':{";
	reqmsg += "\"olderId\":" + olderId + ",";
	reqmsg += "\"type_in\":\"" + type + "\",";
	
	reqmsg += "}}";

    jQuery.ajax({
          type : "post",
          async:false,
          url : "daeOlder.do?handler_Historyslcs", 
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
	
	if (data.content != null) {
		if(data.content.physiologicalParametersHistoryList != null && data.content.physiologicalParametersHistoryList.length >0){
			jQuery.each(data.content.physiologicalParametersHistoryList, function(i, item) {
				if(item.type == "1"){
					htmlcode += "<tr>";
		    		htmlcode += "<td>收缩压</td>";
		    		htmlcode += "<td><span>" + item.value + "</span><span>&nbsp;" + item.unit + "</span></td>"; 
		    		if(item.status == "2"){
		    			htmlcode += "<td><span class=\"glyphicon glyphicon-arrow-up\"></span></td>";
		    		}else if(item.status == "3"){
		    			htmlcode += "<td><span class=\"glyphicon glyphicon-arrow-down\"></span></td>";
		    		}else{
		    			htmlcode += "<td><span class=\"\"></span></td>";
		    		}
		    		htmlcode += "<td>" + formateTime(item.createTime) + "</td>";
		    		htmlcode += "</tr>";
		    		
		    		htmlcode += "<tr>";
		    		htmlcode += "<td>舒张压</td>";
		    		htmlcode += "<td><span>" + item.value2 + "</span><span>&nbsp;" + item.unit + "</span></td>"; 
		    		if(item.status2 == "2"){
		    			htmlcode += "<td><span class=\"glyphicon glyphicon-arrow-up\"></span></td>";
		    		}else if(item.status2 == "3"){
		    			htmlcode += "<td><span class=\"glyphicon glyphicon-arrow-down\"></span></td>";
		    		}else{
		    			htmlcode += "<td><span class=\"\"></span></td>";
		    		}
		    		htmlcode += "<td>" + formateTime(item.createTime) + "</td>";
		    		htmlcode += "</tr>";
				}
			});
		}
	}
	$("#datacontainer").html(htmlcode);
	if(htmlcode == ""){
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

 //生理参数类型转化
 function pipeiSLCSLX(type){
     	var types = "";
     	switch (type)
		{
			case "xueya":
  			types = "1";
  			break;
  			
			case "xuetang":
  			types = "3,4";
  			break;

			case "maibo":
  			types = "5";
  			break;
  			
  			case "tiwen":
  			types = "6";
  			break;
  			
  			case "huxi":
  			types = "7";
  			break;
  			
  			case "xueyang":
  			types = "8";
  			break;
  			
  			case "gumidu":
  			types = "9";
  			break;
  			
  			default:
  			break;
		}
		return types;
  }
 //生理参数类型转化
 function pipeiSLCSLX2(type){
     	var types = "";
     	switch (type)
		{
			case "xueya":
  			types = "血压";
  			break;
  			
			case "xuetang":
  			types = "血糖";
  			break;

			case "maibo":
  			types = "脉搏";
  			break;
  			
  			case "tiwen":
  			types = "体温";
  			break;
  			
  			case "huxi":
  			types = "呼吸";
  			break;
  			
  			case "xueyang":
  			types = "血氧";
  			break;
  			
  			case "gumidu":
  			types = "骨密度";
  			break;
  			
  			default:
  			break;
		}
		return types;
  }
</script>