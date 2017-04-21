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
<title>老人工单详情</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>
<script src="weixinjs/bootstrap.min.js"></script>

<style>
.TPhide {
	display: none
}
</style>
</head>

<body>
	<div class="fixedTOP">
		<h3 id="head_gdbianhao"></h3>
		<a href="###" class="logo" id="backToGzlr"> 
			<span class="glyphicon glyphicon-chevron-left"></span> 
		</a>
	</div>
	<div style="display:none;">
		<a href="###" id="gdtz_a1" style="display:none;">
			<span id="gdtz1">生理参数跳转</span>
		</a> 
		<a href="###" id="gdtz_a2" style="display:none;">
			<span id="gdtz2">日常生活问询跳转</span>
		</a> 
		<a href="###" id="gdtz_a3" style="display:none;">
			<span id="gdtz3">水肿情况跳转</span>
		</a>
	</div>
	<table class="table">
		<tbody>
			<tr>
				<td>老人姓名</td>
				<td id="name_input">未知</td>
			</tr>
			<tr>
				<td>服务人员</td>
				<td id="fwry_input">未知</td>
			</tr>
			<tr>
				<td>服务内容</td>
				<td id="fwnr_input">无</td>
			</tr>
			<tr>
				<td colspan="2">服务子项
					<p id="fwzx_input">无</p>
				</td>
			</tr>
			<tr>
				<td>预计服务时间</td>
				<td id="yjfwsj_input">无</td>
			</tr>
			<tr>
				<td>预计服务时长</td>
				<td id="yjfwsc_input">无</td>
			</tr>
			<tr>
				<td>工单状态</td>
				<td id="gdzt_input">服务未开始</td>
			</tr>
			<tr>
				<td>服务开始时间</td>
				<td id="fwkssj_input">服务未开始</td>
			</tr>
			<tr>
				<td>服务结束时间</td>
				<td id="fwjssj_input">服务未开始</td>
			</tr>
			<tr>
				<td>服务时长</td>
				<td id="fwsc_input">暂无</td>
			</tr>
			<tr>
				<td>服务照片</td>
				<td>&nbsp;</td>
			</tr>
			<tr onclick="$('#tpxqclick').click();">
				<td style="border:0" colspan="2"><img id="fwphoto_input1" src="" class="TPhide" /> 
					<img id="fwphoto_input2" src="" class="TPhide" /> 
					<img id="fwphoto_input3" src="" class="TPhide" /> 
					<img id="fwphoto_input4" src="" class="TPhide" /> 
					<img id="fwphoto_input5" src="" class="TPhide" /> 
					<img id="fwphoto_input6" src="" class="TPhide" />
				</td>
			</tr>
			<tr onclick="$('#gdtz1').click()">
				<td>生理参数</td>
				<td>
					<span class="glyphicon glyphicon-chevron-right"></span>
				</td>
			</tr>
			<tr onclick="$('#gdtz2').click()">
				<td>日常生活问询</td>
				<td>
					<span class="glyphicon glyphicon-chevron-right"></span>
				</td>
			</tr>
			<tr onclick="$('#gdtz3').click()">
				<td>水肿情况</td>
				<td>
					<span class="glyphicon glyphicon-chevron-right"></span>
				</td>
			</tr>
			<tr>
				<td colspan="2">康复护理情况
					<p id="kfhlqk_input">无</p>
				</td>
			</tr>
			<tr>
				<td colspan="2">客户告知
					<p id="khgz_input">无</p>
				</td>
			</tr>
		</tbody>
	</table>
	<div style="display:none;">
		<a href="###" id="tpxq" style="display:none;">
			<span id="tpxqclick">图片详情</span>
		</a>
	</div>
	<div style="display:none;">
		<a href="###" id="yhpj" style="display:none;">
			<span id="yhpjclick">用户评价</span>
		</a>
	</div>
	<div id="userEvaluate" class="fixedBOTTOM" onclick="$('#yhpjclick').click();">
		<h3>用户评价</h3>
	</div>

</body>
</html>
<script type="text/javascript" src="js/mordo.tools/mordo.timeProcessing.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var gongdanId = "<%=request.getAttribute("gongdanId")%>";
		$("#gdtz_a1").attr("href","<%=request.getContextPath()%>" + "/wechatServiceHistory.do?mainXQ_Physiological&gongdanId=" + gongdanId + "&weixin=weixin");
		$("#gdtz_a2").attr("href","<%=request.getContextPath()%>" + "/wechatServiceHistory.do?mainXQ_DailylifeAsk&gongdanId=" + gongdanId + "&weixin=weixin");
		$("#gdtz_a3").attr("href","<%=request.getContextPath()%>" + "/wechatServiceHistory.do?mainXQ_Edemacondition&gongdanId=" + gongdanId + "&weixin=weixin");
		$("#tpxq").attr("href","<%=request.getContextPath()%>" + "/wechatServiceHistory.do?mainXQ_tupianXQ&gongdanId=" + gongdanId + "&weixin=weixin");
		$("#yhpj").attr("href","<%=request.getContextPath()%>" + "/wechatServiceHistory.do?mainXQ_userpj&gongdanId=" + gongdanId + "&weixin=weixin");

		queryServiceDetails();
	});
	
	function queryServiceDetails(){
		var gongdanId = "<%=request.getAttribute("gongdanId")%>";
		var reqmsg="{'action':'QUERY_SERVICE_TASK_INFO_REQUEST','content':{\"serviceListShow\":\"true\",\"serviceEmployeeListShow\":\"true\",\"serviceTaskPhotoListShow\":\"true\",\"id\":"+gongdanId+"}}";
		
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
            	  	  $("#head_gdbianhao").html(data.content.serviceCode);
            	  	  $("#backToGzlr").attr("href","<%=request.getContextPath()%>/" + "wechatServiceHistory.do?main&olderId=" + data.content.olderId + "&weixin=weixin");
            	  	  
            	  	  if(data.content.olderName != null && data.content.olderName != ""){
            	  	  	 $("#name_input").html(data.content.olderName);
            	  	  }
            	  	  if(data.content.serviceEmployeeList != null){
 						jQuery.each(data.content.serviceEmployeeList, function(i, item) {
 							if(item.type == 1){
 								$("#fwry_input").html(item.name);
 							}
 						});
 					  }
	            	  if(data.content.serviceList != null){
	            	  	if(data.content.serviceList[0].name != null && data.content.serviceList[0].name != ""){
	            	  		$("#fwnr_input").html(data.content.serviceList[0].name);
	            	  	}
	            	  	if(data.content.serviceList[0].fuwuSonNames != null && data.content.serviceList[0].fuwuSonNames != ""){
	            	  		$("#fwzx_input").html(data.content.serviceList[0].fuwuSonNames);
	            	  	}
	            	  	if(data.content.serviceList[0].yjfuwuTime != null && data.content.serviceList[0].yjfuwuTime != ""){
 							$("#yjfwsc_input").html(data.content.serviceList[0].yjfuwuTime);
 						}
	            	  }
            	  	  if(data.content.serviceExpectTime != null && data.content.serviceExpectTime != ""){
 						$("#yjfwsj_input").html(formateTime3(data.content.serviceExpectTime));
 					  }
 					  if(data.content.status != null && data.content.status != ""){
 					  	$("#gdzt_input").html(fwstateChange(data.content.status));
 					  }
 					  if(data.content.status == 6 || data.content.status == 7){
 					  	$("#userEvaluate").show();
 					  }else{
 					  	$("#userEvaluate").hide();
 					  }
            	  	  if(data.content.serviceStartTime != null && data.content.serviceStartTime != ""){
 						  $("#fwkssj_input").html(formateTime3(data.content.serviceStartTime));
 					  }else{
 						  $("#fwkssj_input").html("服务未开始");
 						  $("#fwjssj_input").html("服务未开始");
 					  }
            	  	  if(data.content.serviceEndTime != null && data.content.serviceEndTime != ""){
 						  $("#fwjssj_input").html(formateTime3(data.content.serviceEndTime));
 					  }else{
 					  	  if(data.content.serviceStartTime != null && data.content.serviceStartTime != ""){
 							  $("#fwjssj_input").html("服务未结束");
 						  }
 					  }
 					  if(data.content.serviceTimeCount != null && data.content.serviceTimeCount != ""){
 						  $("#fwsc_input").html(data.content.serviceTimeCount + "分钟");
 					  }
 					  if(data.content.nursingRecord != null && data.content.nursingRecord != ""){
 					  	  $("#kfhlqk_input").html(data.content.nursingRecord);	
 					  }
 					  if(data.content.customerInformed != null && data.content.customerInformed != ""){
 					  	  $("#khgz_input").html(data.content.customerInformed);		
            	  	  }
            	  	  if(data.content.serviceTaskPhotoList != null && data.content.serviceTaskPhotoList != ""){
						  jQuery.each(data.content.serviceTaskPhotoList, function(i, item) {
							  $("#fwphoto_input"+(i+1)).removeClass("TPhide");
							  $("#fwphoto_input"+(i+1)).attr("src",item.photoUrl + "?random=" + Math.random());
						  });
					  }else{
					  	  $("#tpxq").attr("href","###");
					  }
					  
			
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
	
	//服务状态
	function fwstateChange(id){
		var name = "未知";
     	switch (id)
		{
			case 1:
  			name="取消";
  			break;
  			
			case 2:
  			name="待排班";
  			break;
  			
  			case 3:
  			name="待审核";
  			break;
  			
  			case 4:
  			name="审核通过";
  			break;
  			
  			case 5:
  			name="服务开始";
  			break;
  			
  			case 6:
  			name="服务结束";
  			break;
  			
  			case 7:
  			name="回访结束";
  			break;
  			
  			case 8:
  			name="已下单";
  			break;
  			
  			default:
  			break;
		}
		return name;
	}

</script>