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
<title>老人健康报告详情</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>
.TPhide{display:none}
</style>
</head>

<body>
	<div class="fixedTOP">		
		<h3 id="jkbg_head">评估类型</h3>
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
	</div>
	<table class="table" >
   <tbody>
      <tr>
         <td>评估人</td>
         <td id="report_pgr">无</td>
      </tr>
      <tr>
         <td>评估时间</td>
         <td id="report_pgsj">无</td>
      </tr>
	  <tr>
         <td colspan="2">病情摘要
		 <p id="report_bqzy">无</p>
		 </td>         
      </tr>
      <tr>
         <td colspan="2">目前存在问题
		 <p id="report_mqczwt">无</p>
		 </td>         
      </tr>
      <tr>
         <td colspan="2">康复近期目标
		 <p id="report_kfjqmb">无</p>
		 </td>         
      </tr>
      <tr>
         <td colspan="2">康复远期目标
		 <p id="report_kfyqmb">无</p>
		 </td>         
      </tr>
      <tr>
         <td colspan="2">训练计划
		 <p id="report_xljh">无</p>
		 </td>         
      </tr>
      <tr>
         <td colspan="2">辅具使用建议
		 <p id="report_fzsyjy">无</p>
		 </td>         
      </tr>
      <tr>
         <td>近期照片</td>
         <td>&nbsp;</td>
      </tr>
	  <tr onclick="$('#tpxqclick').click();">
         <td style="border:0" colspan="2">
			<img id="fwphoto_input1" src="" class="TPhide"/>
			<img id="fwphoto_input2" src="" class="TPhide"/>
			<img id="fwphoto_input3" src="" class="TPhide"/>
			<img id="fwphoto_input4" src="" class="TPhide"/>
			<img id="fwphoto_input5" src="" class="TPhide"/>
			<img id="fwphoto_input6" src="" class="TPhide"/>
		 </td>
      </tr>

   </tbody>
</table>
<div style="display:none;">
	<a href="###" id="tpxq" style="display:none;"><span id="tpxqclick">图片详情</span></a>
</div>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		var healthReportId = "<%=request.getAttribute("healthReportId")%>";
		var olderId = "<%=request.getAttribute("olderId")%>";
		var type = "<%=request.getAttribute("type")%>";
        $("#jkbg_head").html(changeType(type));
		$("#backToGzlr").attr("href","<%=request.getContextPath()%>/" + "wechatHealthAssessment.do?main&olderId=" + olderId + "&weixin=weixin");
		$("#tpxq").attr("href","<%=request.getContextPath()%>" + "/wechatHealthAssessment.do?mainBGphotos&healthReportId=" + healthReportId + "&olderId=" + olderId + "&type=" + type + "&weixin=weixin");
		
		queryjkbg();
	});
	
	function queryjkbg(){
		var healthReportId = "<%=request.getAttribute("healthReportId")%>";
		var reqmsg="{'action':'QUERY_HEALTH_REPORT_INFO_REQUEST','content':{\"employeeShow\":\"true\",\"healthReportPhotoListShow\":\"true\",\"id\":"+healthReportId+"}}";
		
		  jQuery.ajax({
          type : "post",
          async:false,
          url : "healthReport.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des=="success"){
            	  if (data.content != null) {
	            	 if(data.content.employee != null && data.content.employee != ""){
 					      $("#report_pgr").html(data.content.employee.name);
 					 }
 					 if(data.content.assessmentTime != null && data.content.assessmentTime != ""){
 					      $("#report_pgsj").html(formateTime(data.content.assessmentTime));
 					 }
 					 if(data.content.diseaseSummary != null && data.content.diseaseSummary != ""){
 					      $("#report_bqzy").html(data.content.diseaseSummary);
 					 }
 					 if(data.content.mainProblem != null && data.content.mainProblem != ""){
 					      $("#report_mqczwt").html(data.content.mainProblem);
 					 }
 					 if(data.content.recentRehabilitationGoals != null && data.content.recentRehabilitationGoals != ""){
 					      $("#report_kfjqmb").html(data.content.recentRehabilitationGoals);
 					 }
 					 if(data.content.rehabilitationLongTermGoal != null && data.content.rehabilitationLongTermGoal != ""){
 					      $("#report_kfyqmb").html(data.content.rehabilitationLongTermGoal);
 					 }
 					 if(data.content.trainingProgram != null && data.content.trainingProgram != ""){
 					      $("#report_xljh").html(data.content.trainingProgram);
 					 }
 					 if(data.content.suggest != null && data.content.suggest != ""){
 					      $("#report_fzsyjy").html(data.content.suggest);
 					 }
 					 if(data.content.healthReportPhotoList != null && data.content.healthReportPhotoList != ""){
						  jQuery.each(data.content.healthReportPhotoList, function(i, item) {
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
		case "1":
			typeName = "康复评估";
			break;
		case "2":
			typeName = "护理评估";
			break;
		case "3":
			typeName = "混合健康评估";
			break;
		default:
			typeName = "未知";
			break;
	}
	return typeName;
}
</script>