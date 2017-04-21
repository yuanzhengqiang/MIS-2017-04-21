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
<title>老人工单详情用户评价</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>	
	label{font-weight:normal}
	textarea{ resize: vertical}
	.divider{border:1px solid #bbb}
	select option{font-size:18px}
</style>
</head>

<body>
	<div class="fixedTOP">		
		<h3>评价及反馈</h3>
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left" id="yhpj_head"></span>
        </a>
		<button id="fat-btn" class="btn btn-sm"  type="button" onclick="tijiao()">提 交</button>
	</div>

	<form class="form-horizontal" style="margin:65px 10px 10px 10px" role="form">
		<label>用户评价
          <span class="glyphicon glyphicon-comment"></span></label>
        <div class="form-group">
			<label class="col-xs-5 control-label">&nbsp;&nbsp;服务时间</label>
			<div class="col-xs-5">
				<select class="form-control" id="zt_hfsj_hf">
				    <option value="按计划">按计划</option><option value="时间不足">时间不足</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-5 control-label">&nbsp;&nbsp;服务态度</label>
			<div class="col-xs-5">
				<select class="form-control" id="zt_hftd_hf">
				     <option value="很好">很好</option><option value="好">好</option><option value="中">中</option><option value="一般">一般</option><option value="差">差</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="col-xs-5 control-label">&nbsp;&nbsp;服务质量</label>
			<div class="col-xs-5">
				<select class="form-control" id="zt_hfzl_hf">
				  	 <option value="很好">很好</option><option value="好">好</option><option value="中">中</option><option value="一般">一般</option><option value="差">差</option>
				</select>
			</div>
		</div>
	</form>
	<div class="divider"></div>
	<form class="form-horizontal" style="margin:15px 10px 60px 10px;" role="form">
		<label>用户反馈
          <span class="glyphicon glyphicon-edit"></span></label>
		<div class="form-group">			
			<div class="col-xs-12">
				<textarea class="form-control" rows="3" id="zt_hfneirong_hf"></textarea>
			</div>
		</div>
	</form>

</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		var gongdanId = "<%=request.getAttribute("gongdanId")%>";
		$("#backToGzlr").attr("href","<%=request.getContextPath()%>" + "/wechatServiceHistory.do?mainXQ&gongdanId=" + gongdanId + "&weixin=weixin");

	});
	
	function tijiao(){
		var	zt_hfsj_hf = $("#zt_hfsj_hf").val();	
 		var	zt_hftd_hf = $("#zt_hftd_hf").val();		
 		var	zt_hfzl_hf = $("#zt_hfzl_hf").val();	
 		var	zt_hfneirong_hf = $("#zt_hfneirong_hf").val();	
 		var gongdanId = "<%=request.getAttribute("gongdanId")%>";
 		
 		var reqmsg="{'action':'ADD_SERVICE_TASK_INFO_REQUEST','content':{";
 		
 		reqmsg += "\"id\":" + gongdanId + ",";
 		if (zt_hfsj_hf != null && zt_hfsj_hf != "") {
       		reqmsg += "\"visitServiceTime\":\"" + zt_hfsj_hf + "\",";
		}
		if (zt_hftd_hf != null && zt_hftd_hf != "") {
       		reqmsg += "\"visitServiceAttitude\":\"" + zt_hftd_hf + "\",";
		}
		if (zt_hfzl_hf != null && zt_hfzl_hf != "") {
       		reqmsg += "\"visitServiceQuality\":\"" + zt_hfzl_hf + "\",";
		}
		if (zt_hfneirong_hf != null && zt_hfneirong_hf != "") {
			zt_hfneirong_hf = JSON.stringify(zt_hfneirong_hf);
			if(zt_hfneirong_hf.length > 200){
				alert("用户反馈超过最大字数限制200字");
				return;
			}
       		reqmsg += "\"visitRecord\":" + zt_hfneirong_hf + ",";
		}
		
		reqmsg += "\"serviceLogList\":[" ;
		reqmsg += "{\"createTime\":\"" + getNowFormatDate() +"\",";
		reqmsg += "\"createPerson\":\"用户\",";
		reqmsg += "\"type\":\"评价工单\",";
		if(zt_hfneirong_hf == "" || zt_hfneirong_hf == null){
			zt_hfneirong_hf = "\"用户评价了工单\"";
		}
		reqmsg += "\"log\":" + zt_hfneirong_hf + "}";
		reqmsg += "],";
		
		reqmsg += "}}";
		
		jQuery.ajax({
          type : "post",
          async: true,
          url : "serviceTask.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des=="success"){
              	alert("评价成功");
              	$("#yhpj_head").click();
              }else if(data.des=="failure"){
                 alert("修改失败");
              }else{
              	alert(data.des);
              }
          },
          error:function(){
	           alert("error");
          }
     	});
	
	}

//获取当前时间return yyyymmddhhmmss
function getNowFormatDate() {
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var strHour = date.getHours();
    var strMinutes = date.getMinutes();
    var strSeconds = date.getSeconds();
    
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if (strHour >= 0 && strHour <= 9) {
        strHour = "0" + strHour;
    }
    if (strMinutes >= 0 && strMinutes <= 9) {
        strMinutes = "0" + strMinutes;
    }
    if (strSeconds >= 0 && strSeconds <= 9) {
        strSeconds = "0" + strSeconds;
    }
    var currentdate = date.getFullYear() + "" + month + "" + strDate + "" + strHour + "" + strMinutes + "" + strSeconds;
    return currentdate;
}

</script>