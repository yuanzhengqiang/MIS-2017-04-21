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
<title>订单确认</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>		
textarea{ resize: none}
.modal-body label{margin-right:15px}
.modal-body table td:nth-child(3){text-align:right;color:#888;padding-right:10px}
.modal-body table td:nth-child(2){color:#555;}
.modal-body table td:nth-child(1){padding-left:10px}
.modal-body table tr:nth-child(1){border-top:1px solid #eee}
.modal-body table tr{line-height:36px;border-bottom:1px solid #eee}
.modal-body .checkbox label{color:#666}
</style>
<script type="text/javascript" src="js/addressJS.js"></script>
</head>

<body style="background:#eee">
	<div class="fixedTOP">		
		<h3>订单确认</h3>
		<a href="###" class="logo" id="" onclick="backclick()">
          <span class="glyphicon glyphicon-chevron-left" id=""></span>
        </a>
		
	</div>

	<form class="form-horizontal" style="padding:60px 10px 10px 10px;background:#fff" role="form">
		<input type="hidden" id="wechatId" value="">
		<input type="hidden" id="wechatNickname" value="">
        <div class="form-group">
			<label class="col-xs-3 control-label">项目名称</label>
			<input type="hidden" value="0" id="serviceId">
			<div class="col-xs-9 control-label" id="xmname">无</div>
		</div>
		 <div class="form-group">
			<label class="col-xs-3 control-label">价格</label>
			<input type="hidden" value="" id="shichangjiage">
			<div class="col-xs-9 control-label" id="money_time">无</div>
			
		</div>
	
		<div class="form-group">
			<label class="col-xs-3 control-label">老人姓名</label>
			<input type="hidden" value="0" id="olderId">
			<div class="col-xs-9 control-label" id="olderName">无</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">服务站点</label>
			<input type="hidden" value="0" id="olderFWZDId">
			<div class="col-xs-9 control-label" id="olderFWZD">无</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">联系人</label>
			<div class="col-xs-9 control-label" id="lianxiren_input">无</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">联系电话</label>
			<input type="hidden" value="" id="dianhua_input_hide">
			<div class="col-xs-9 control-label" id="dianhua_input">无</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">地址</label>			
			<div class="col-xs-9 control-label" id="address_input">无</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">预计服务时长</label>			
			<div class="col-xs-9 control-label" id="yjfwsc_input">无</div>
		</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">服务子项</label>			
			<div class="col-xs-9 control-label" id="fwzixiang_input">无</div>
		</div>
		</div>
	</form>
 
  <div  style="text-align:center;margin-top:15px;" >
  <button type="button" class="btn btn-primary " style="width:30%" onclick="backclick()"><span class="glyphicon glyphicon-pencil"></span> 返回修改</button>
  <button type="button" class="btn  btn-success" style="width:30%;margin-left:15px" onclick="surexiadan()"><span class="glyphicon glyphicon-ok"></span> 确认下单</button>
 </div> 
 
<script type="text/javascript">
	$(document).ready(function(){
		var serviceId = "<%=request.getAttribute("serviceId")%>";
		if(serviceId != null && serviceId != "" && serviceId != "0"){
			$("#serviceId").val(serviceId);
			queryService(serviceId);
		}
		var olderId = "<%=request.getAttribute("olderId")%>";
		if(olderId != null && olderId != "" && olderId != "0"){
			$("#olderId").val(olderId);
			queryOlder(olderId);
		}
		var lianxiren_input = "<%=request.getAttribute("lianxiren_input")%>";
		if(lianxiren_input != null && lianxiren_input != ""){
			$("#lianxiren_input").html(lianxiren_input);
		}
		var dianhua_input = "<%=request.getAttribute("dianhua_input")%>";
		if(dianhua_input != null && dianhua_input != ""){
			$("#dianhua_input").html(dianhua_input);
			$("#dianhua_input_hide").val(dianhua_input);
		}
		var address_input = "<%=request.getAttribute("address_input")%>";
		if(address_input != null && address_input != ""){
			$("#address_input").html(address_input);
		}
		var yjfwsc_input = "<%=request.getAttribute("yjfwsc_input")%>";
		if(yjfwsc_input != null && yjfwsc_input != ""){
			$("#yjfwsc_input").html(yjfwsc_input + "分钟");
		}
		var fwzx_input = "<%=request.getAttribute("fwzx_input")%>";
		if(fwzx_input != null && fwzx_input != ""){
			$("#fwzixiang_input").html(fwzx_input);
		}
		
		var wechatId = "<%=request.getAttribute("wechatId")%>";
		if(wechatId != null && wechatId != ""){
			$("#wechatId").val(wechatId);
		}
		var wechatNickname = "<%=request.getAttribute("wechatNickname")%>";
		if(wechatNickname != null && wechatNickname != ""){
			$("#wechatNickname").val(wechatNickname);
		}
		
		var olderFWZD_hideId = "<%=request.getAttribute("olderFWZD_hideId")%>";
		if(olderFWZD_hideId != null && olderFWZD_hideId != ""){
			$("#olderFWZDId").val(olderFWZD_hideId);
		}
		var olderFWZD_hideValue = "<%=request.getAttribute("olderFWZD_hideValue")%>";
		if(olderFWZD_hideValue != null && olderFWZD_hideValue != ""){
			$("#olderFWZD").html(olderFWZD_hideValue);
		}
	
	});
	
	 //获取服务信息
	 function queryService(serviceId){
		var reqmsg="{'action':'QUERY_SERVICE_INFO_REQUEST','content':{\"id\":"+serviceId+"}}";
		
		var html = "";
		
		  jQuery.ajax({
          type : "post",
          async:true,
          url : "service.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des=="success"){
              		if(data.content != null) {
              			$("#xmname").html(data.content.name);
              			$("#money_time").html(data.content.marketPrice + "元");
              			$("#shichangjiage").val(data.content.marketPrice);
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
	
	//获取老人信息
	function queryOlder(OlderId){
		var reqmsg="{'action':'QUERY_OLDER_INFO_REQUEST','content':{\"id\":"+OlderId+"}}";
		  jQuery.ajax({
          type : "post",
          async:true,
          url : "daeOlder.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des=="success"){
            	  if (data.content != null) {
            	  	$("#olderName").html(data.content.name);
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
	
	//页面返回
	function backclick(){
		var serviceId = $("#serviceId").val();
		var olderId = $("#olderId").val();
		var lianxiren_input = $("#lianxiren_input").html();
		var dianhua_input = $("#dianhua_input_hide").val();
		var address_input = $("#address_input").html();
		var yjfwsc_input = $("#yjfwsc_input").html();
		yjfwsc_input = yjfwsc_input.replace("分钟","");
		var fwzixiang_input = $("#fwzixiang_input").html();
		var olderFWZDId = $("#olderFWZDId").val();

		window.location.replace("<%=request.getContextPath()%>/" + "wechatReservationService.do?mainOrder&flag=flag&serviceId=" + serviceId + "&olderId=" + olderId + "&lianxiren_input=" + lianxiren_input + "&dianhua_input=" + dianhua_input + "&address_input=" + address_input + "&yjfwsc_input=" + yjfwsc_input + "&fwzx_input=" + fwzixiang_input + "&olderFWZDId=" + olderFWZDId + "&weixin=weixin");
	}
	
	
//下单////////////////////////////////////////////////////////////////////////////
function surexiadan(){
	var olderId = $("#olderId").val();
	
	var fuzerenSiteId_hide = $("#olderFWZDId").val();
	var fuzerenSiteName_hide = $("#olderFWZD").html();
	
	var olderData = getOlderJBXX(olderId);
	var olderMemberNum = "";
	var olderName = "";
	var olderBirthdate = "";
	var serviceAreaId = 0;
	var serviceStreetId = 0;
	if(olderData != ""){
		var obj = JSON.parse(olderData);
		olderMemberNum = obj.memberNum;
		olderName = obj.name;
		olderBirthdate = obj.birthdate;
		serviceAreaId = obj.serviceAreaId;
		serviceStreetId = obj.serviceStreetId;
	}
	
	var fwxminput_Id4_hide = $("#serviceId").val();
	var fwxminput_SCPRICE4_hide = $("#shichangjiage").val();
	var fuwuzixianginput_search = $("#fwzixiang_input").html();
	var yjfwsc = $("#yjfwsc_input").html();
	yjfwsc = yjfwsc.replace("分钟","");
	
	var contactName = $("#lianxiren_input").html();
	var contactTel = $("#dianhua_input_hide").val();
	var address = $("#address_input").html();
   
	var reqmsg="{'action':'ADD_SERVICE_TASK_INFO_REQUEST','content':{";
	
	var wechatId = $("#wechatId").val();
	var wechatNickname = $("#wechatNickname").val();
	if(wechatId != null && wechatId != "" && wechatId != "0"){
		reqmsg += "\"addPersonWechatId\":" + wechatId + ",";
		reqmsg += "\"addPersonWechatName\":\"" + wechatNickname + "\",";
	}
	reqmsg += "\"hasPay\":\"N\",";
		
	reqmsg += "\"addType\":\"微信工单\",";
	reqmsg += "\"source\":\"微信\",";
	if (olderId != null && olderId != "") {
        reqmsg += "\"olderId\":" + olderId + ",";
	}
	if (olderMemberNum != null && olderMemberNum != "") {
        reqmsg += "\"olderMemberNum\":\"" + olderMemberNum + "\",";
	}
	if (olderName != null && olderName != "") {
        reqmsg += "\"olderName\":\"" + olderName + "\",";
	}
	if (olderBirthdate != null && olderBirthdate != "") {
        reqmsg += "\"olderBirthdate\":\"" + olderBirthdate + "\",";
	}
	if (serviceAreaId != null && serviceAreaId != 0) {
        reqmsg += "\"serviceAreaId\":" + serviceAreaId + ",";
	}
	if (serviceStreetId != null && serviceStreetId != 0) {
        reqmsg += "\"serviceStreetId\":" + serviceStreetId + ",";
	}
	if (contactName != null && contactName != "") {
        reqmsg += "\"contactName\":\"" + contactName + "\",";
	}
	if (contactTel != null && contactTel != "") {
        reqmsg += "\"contactTel\":\"" + contactTel + "\",";
	}
	if (address != null && address != "") {
        reqmsg += "\"address\":\"" + address + "\",";
	}
	if (fwxminput_SCPRICE4_hide != null && fwxminput_SCPRICE4_hide != "") {
		reqmsg += "\"healthInsurance\":2,";
		reqmsg += "\"price\":" + fwxminput_SCPRICE4_hide + ",";
	}
	
	if (fuzerenSiteId_hide != null && fuzerenSiteId_hide != "" && fuzerenSiteId_hide != "null") {
        reqmsg += "\"siteId\":" + fuzerenSiteId_hide + ",";
	}
	if (fuzerenSiteName_hide != null && fuzerenSiteName_hide != "" && fuzerenSiteName_hide != "无") {
        reqmsg += "\"siteName\":\"" + fuzerenSiteName_hide + "\",";
	}
	
	reqmsg += "\"status\":8,";
	reqmsg += "\"addTime\":\"" + getNowFormatDate() + "\",";
	
	if (fwxminput_Id4_hide != null && fwxminput_Id4_hide != "") {
        reqmsg += "\"serviceTask_service_list\":[{";
        reqmsg += "\"serviceId\":" + fwxminput_Id4_hide + "," ;
        reqmsg += "\"fuwuSonNames\":\"" + fuwuzixianginput_search + "\",";
        reqmsg += "\"yjfuwuTime\":\"" + yjfwsc + "分钟\",";
        reqmsg += "}]," ;
	}
	
	reqmsg += "\"serviceLogList\":[" ;
	reqmsg += "{\"createTime\":\"" + getNowFormatDate() +"\",";
	reqmsg += "\"createPerson\":\"微信\",";
	reqmsg += "\"type\":\"微信工单\",";
	reqmsg += "\"log\":\"微信新增服务工单\"}";
	reqmsg += "],";
	
	reqmsg += "\"chargeEmployeeId\":0,";
	
	reqmsg=reqmsg.substr(0,reqmsg.length-1);
	reqmsg += "}}";

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
              if(data.des == "success"){
              	 //alert("下单成功");
              	 window.location.replace("<%=request.getContextPath()%>/" + "wechatReservationService.do?mainSuccessOrder&weixin=weixin");
              }else{
                 //alert("下单失败");
                 window.location.replace("<%=request.getContextPath()%>/" + "wechatReservationService.do?mainFailureOrder&weixin=weixin");
              }
          },
          error:function(){
	           //alert("error");
	           window.location.replace("<%=request.getContextPath()%>/" + "wechatReservationService.do?mainFailureOrder&weixin=weixin");
          }
     });
}
//获取老人基本信息
function getOlderJBXX(olderId){
	var olderData = "";
	var reqmsg="{'action':'QUERY_OLDER_INFO_REQUEST','content':{\"olderAddressListShow\":\"true\",\"id\":"+olderId+"}}";
		  jQuery.ajax({
          type : "post",
          async:false,
          url : "daeOlder.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des=="success"){
            	  if(data.content != null){
            	  	olderData = JSON.stringify(data.content);
            	  }
              }else if(data.des=="failure"){
                 alert("查询失败");
              }
          },
          error:function(){
	           alert("error");
          }
    });
    return olderData;
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
////////////////////////////////////////////////////////////////////////

</script>

<script type="text/javascript" src="js/jquery.form.js"></script>
</body>
</html>
