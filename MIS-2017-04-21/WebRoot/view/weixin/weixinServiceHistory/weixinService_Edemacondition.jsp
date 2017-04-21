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
<title>老人工单水肿情况详情</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>	
	.table tr:nth-child(2n) td{border:0;padding-top:0}
</style>
</head>

<body>
	<div class="fixedTOP">		
		<h3>水肿情况</h3>
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
	</div>
	<table class="table" >
   		<tbody id="szqkList">
      		<!-- <tr>
         		<td>水肿类别</td>
         		<td>局部性水肿</td>
      		</tr>
      		<tr>
         		<td>水肿部位</td>
         		<td>小腿</td>
      		</tr> -->
   		</tbody>
	</table>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		var gongdanId = "<%=request.getAttribute("gongdanId")%>";
		$("#backToGzlr").attr("href","<%=request.getContextPath()%>" + "/wechatServiceHistory.do?mainXQ&gongdanId=" + gongdanId + "&weixin=weixin");
	
		querygongdan();
	});
	
	function querygongdan(){
		var gongdanId = "<%=request.getAttribute("gongdanId")%>";
		var reqmsg="{'action':'QUERY_SERVICE_TASK_INFO_REQUEST','content':{\"edemaConditionListShow\":\"true\",\"id\":"+gongdanId+"}}";
		
		  jQuery.ajax({
          type : "post",
          async:false,
          url : "serviceTask.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des=="success"){
            	  if (data.content != null) {
	            	 var html = "";
 					 if(data.content.edemaConditionList != null && data.content.edemaConditionList != ""){
 						for(var i=0;i < data.content.edemaConditionList.length;i++){
 							html +="<tr>";
 							html +="<td>水肿类别</td>";
 							html +="<td>" + data.content.edemaConditionList[i].type + "</td>";
 							html +="</tr>";
 							html +="<tr>";
 							html +="<td>水肿部位</td>";
 							html +="<td>" + data.content.edemaConditionList[i].edemaSite + "</td>";
 							html +="</tr>";
 						}
 					 }else{
 					 	html +="<tr><td>暂无</td></tr>";
 					 }
 					 $("#szqkList").html(html);
 				  }
              }else if(data.des=="failure"){
                 alert("查询失败");
              }
          },
          error:function(){
	           alert("error");
          }
    	 });
	}

</script>