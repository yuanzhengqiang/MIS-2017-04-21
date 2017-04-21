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
<title>服务预约</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>
<script src="weixinjs/bootstrap.min.js"></script>
<style>
textarea {
	resize: none
}

.modal-body label {
	margin-right: 15px
}

.modal-body table td:nth-child(3) {
	text-align: right;
	color: #888;
	padding-right: 10px
}

.modal-body table td:nth-child(2) {
	color: #555;
}

.modal-body table td:nth-child(1) {
	padding-left: 10px
}

.modal-body table tr:nth-child(1) {
	border-top: 1px solid #eee
}

.modal-body table tr {
	line-height: 36px;
	border-bottom: 1px solid #eee
}

.modal-body .checkbox label {
	color: #666
}
</style>
</head>

<body style="background:#eee">
	<div class="fixedTOP">
		<h3>服务预约</h3>
		<a href="###" class="logo" onclick="tiaozhuan()"> <span class="glyphicon glyphicon-chevron-left" id=""></span> </a>

	</div>

	<div class="form-horizontal" style="padding:60px 10px 1px 10px;background:#fff">
		<input type="hidden" value="0" id="serviceId_hide"> <input type="hidden" value="0" id="wechatId_hide">
		<div class="form-group">
			<div class="col-xs-6 control-label" id="xmname">无</div>
			<div class="col-xs-6 control-label text-right" id="money_time">无</div>
		</div>
	</div>
	<p></p>
	<form class="form-horizontal" style="padding:10px 10px 10px 10px;background:#fff" role="form">
		<div class="form-group">
			<label class="col-xs-3 control-label">老人姓名</label>
			<div class="col-xs-9 ">
				<div class="input-group">
					<input type="hidden" value="0" id="olderId_hide"> 
					<input type="text" class="form-control" id="olderName_input" readonly> 
					<span class="input-group-addon" style="padding:0 0 0 10px;background:#fff;border:0" onclick="chooseOlder()">
						<button type="button" class="btn btn-info " data-toggle="modal" id="olderModal" data-target="#myModal3">
							<span class="glyphicon glyphicon-user"></span>
						</button> 
					</span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">服务站点</label>
			<div class="col-xs-9 ">
				<select class="form-control" id="olderFWZD_hide"></select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">联系人</label>
			<div class="col-xs-9 ">
				<input class="form-control" id="lianxiren_input">
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">联系电话</label>
			<div class="col-xs-9 ">
				<input class="form-control" id="dianhua_input">
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">地址</label>
			<div class="col-xs-9 ">
				<input class="form-control" id="address_input">
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">预计服务时长(分钟)</label>
			<div class="col-xs-9 ">
				<input class="form-control" id="yjfwsc_input" onpaste="return false;" onkeypress="keyPress()">
			</div>
		</div>
		</div>
		<div class="form-group">
			<label class="col-xs-3 control-label">服务子项</label>
			<div class="col-xs-9 ">
				<textarea class="form-control" rows="2" id="fwzx_input" readonly placeholder="点击选择或更改" onclick="bianjifwzx_input()" data-toggle="modal" data-target="#myModal"></textarea>
			</div>
		</div>
		</div>
	</form>

	<div style="padding:15px  ">
		<button type="button" class="btn btn-success " onclick="tiaozhuanxiadan()" style="width:100%">下 单</button>
	</div>


	<!-- 选择所需服务 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">请选择所需服务子项</h4>
				</div>
				<div class="modal-body" style="padding-top:0;padding-bottom:0" id="fwzixiang">
					<!-- <div class="checkbox">
				  <label><input type="checkbox" value="">选项 1</label>
				</div>
				<div class="checkbox">
				  <label><input type="checkbox" value="">选项 1</label>
				</div>
				 -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="sureFwzixiang()">确定</button>
					<button type="button" class="btn btn-default" data-dismiss="modal" id="closeFwzixiang">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 下单确认 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">下单确认</h4>
				</div>
				<div class="modal-body">请核对您的信息，确认无误后提交您的订单。</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">提交订单</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 老人选择 -->
	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<table style="width:100%" id="olderList">
						<!-- <tr><td>张鲁</td><td>LR201602054878</td><td><span class="glyphicon glyphicon-chevron-right"></span></td></tr>
				 <tr><td>张1鲁</td><td>LR201602054878</td><td><span class="glyphicon glyphicon-chevron-right"></span></td></tr>
				 <tr><td>张2鲁</td><td>LR201602054878</td><td><span class="glyphicon glyphicon-chevron-right"></span></td></tr>
				 <tr><td>张3鲁</td><td>LR201602054878</td><td><span class="glyphicon glyphicon-chevron-right"></span></td></tr> -->
					</table>
				</div>
				<input type="hidden" class="btn btn-default" data-dismiss="modal">
				<button type="button" class="btn btn-default" data-dismiss="modal" style="display:none;" id="closeChoosOlder">关闭</button>
				<div class="modal-footer">
					<div class="col-xs-12">
						<div class="text-center">
							<button type="button" class="btn my_btn-success" onclick="jumpToOlderAdd()" style="width:120px">新增关注老人</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>


	<script type="text/javascript" src="js/mordo.tools/mordo.inputControl.js"></script>
	<script type="text/javascript">
/* center modal */
function centerModals(){
    $('.modal').each(function(i){
        var $clone = $(this).clone().css('display', 'block').appendTo('body');    var top = Math.round(($clone.height() - $clone.find('.modal-content').height()) / 2);
        top = top > 0 ? top : 0;
        $clone.remove();
        $(this).find('.modal-content').css("margin-top", top);
    });
}
$(document).ready(function(){	
	var id = "<%=request.getAttribute("id")%>";
	if(id != null && id != "" && id != "0"){
		$("#serviceId_hide").val(id);
		queryService(id);
	}
	var wechatId = "<%=request.getAttribute("wechatId")%>";
	if(wechatId != null && wechatId != "" && wechatId != "0"){
		$("#wechatId_hide").val(wechatId);
	}
	
	////下单页返回修改////////////////////////////////////////
	var flag = "<%=request.getAttribute("flag")%>";
	if(flag == "flag"){
		var serviceId = "<%=request.getAttribute("serviceId")%>";
		var olderId = "<%=request.getAttribute("olderId")%>";
		var lianxiren_input = "<%=request.getAttribute("lianxiren_input")%>";
		var dianhua_input = "<%=request.getAttribute("dianhua_input")%>";
		var address_input = "<%=request.getAttribute("address_input")%>";
		var yjfwsc_input = "<%=request.getAttribute("yjfwsc_input")%>";
		var fwzx_input = "<%=request.getAttribute("fwzx_input")%>";
		var olderFWZDId = "<%=request.getAttribute("olderFWZDId")%>";
		
		if(serviceId != null && serviceId != "" && serviceId != "0"){
			$("#serviceId_hide").val(serviceId);
			queryService(serviceId);
		}
		if(olderId != null && olderId != "" && olderId != "0"){
			$("#olderId_hide").val(olderId);
			queryOlder(olderId);
			querySites(olderId);
			if(olderFWZDId != null && olderFWZDId != "" && olderFWZDId != "0"){
				$("#olderFWZD_hide").val(olderFWZDId);
			}
		}
		if(lianxiren_input != null && lianxiren_input != ""){
			$("#lianxiren_input").val(lianxiren_input);
		}
		if(dianhua_input != null && dianhua_input != ""){
			$("#dianhua_input").val(dianhua_input);
		}
		if(address_input != null && address_input != ""){
			$("#address_input").val(address_input);
		}
		if(yjfwsc_input != null && yjfwsc_input != ""){
			$("#yjfwsc_input").val(yjfwsc_input);
		}
		if(fwzx_input != null && fwzx_input != ""){
			$("#fwzx_input").val(fwzx_input);
		}
	}
	///////////////////////////////////////////////////
	
	
	////跳转老人新增页后返回////////////////////////////////////////
	var flag2 = "<%=request.getAttribute("flag2")%>";
	if(flag2 == "1"){
		$("#olderModal").click();
	}
	///////////////////////////////////////////////////
	
	$('.modal').on('show.bs.modal', centerModals);
	$(window).on('resize', centerModals);
});
	 //页面跳转返回
     function tiaozhuan(){
     	var serviceId_hide = $("#serviceId_hide").val();
     	var headUrl = "<%=request.getContextPath()%>";
     	var url = headUrl+"/wechatReservationService.do?mainXQ&id="+serviceId_hide+"&weixin=weixin"
	    window.location.replace(url);
     }
     
     //获取服务信息
     function queryService(id){
		var reqmsg="{'action':'QUERY_SERVICE_INFO_REQUEST','content':{\"serviceChildListShow\":\"true\",\"id\":"+id+"}}";
		
		var html = "";
		
		  jQuery.ajax({
          type : "post",
          async:false,
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
              			
						//子项
 						if(data.content.serviceChildList != null && data.content.serviceChildList.length > 0){
							var fuwuzixiang = "";
 							for(var i=0;i < data.content.serviceChildList.length;i++){
 								fuwuzixiang += "<div class=\"checkbox\">";
 								fuwuzixiang += "<label class=\"checkbox-inline\"><input type=\"checkbox\" class=\"icheck\" name=\"checks\" id=\"checks_" + i + "\" value=\"" + data.content.serviceChildList[i].name + "\">" + data.content.serviceChildList[i].name + "</label>";
 								fuwuzixiang += "</div>";
 							}
							$("#fwzixiang").html(fuwuzixiang);
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
	//保存弹窗服务信息
	function sureFwzixiang(){
		var html = "";
		var boxes = document.getElementsByName("checks");
 		if(boxes != null){
 			if(boxes.length > 0){
 				for(i=0;i<boxes.length;i++){
					if(boxes[i].checked == true){
						html += $("#checks_" + i).val() + ",";
					}
				}
				if(html != ""){
					html = html.substr(0,html.length-1);
				}
 			}
		}
		$("#fwzx_input").val(html);
		$("#closeFwzixiang").click();
	}
	//编辑弹窗服务信息
	function bianjifwzx_input(){
		var fwzx_input = $("#fwzx_input").val();
		var fwzx_inputArray = fwzx_input.split(",");
		
		var boxes = document.getElementsByName("checks");
		for(i=0;i<boxes.length;i++){
			boxes[i].checked = false;
		}
		
		for(i=0;i<boxes.length;i++){
			for(j=0;j<fwzx_inputArray.length;j++){
				if($("#checks_" + i).val() == fwzx_inputArray[j]){
					boxes[i].checked = true;
					break;
				}
			}
		 }	
	}
	
	//获取用户已关注老人列表
	function chooseOlder(){
		var wechatId = $("#wechatId_hide").val();
		var reqmsg="{'action':'QUERY_OLDER_WECHAT_LIST_REQUEST','page':{'pageno':'1','pagesize':'10000'},'content':{\"olderShow\":\"true\",";
	
		if (wechatId != null && wechatId != "") {
			 reqmsg += "\"wechatId\":" + wechatId + ",";
		}
		reqmsg += "}}";
		
		var headUrl = "<%=request.getContextPath()%>";
		var html = "";
		
    	jQuery.ajax({
          	type : "post",
          	async:false,
          	url : "olderWechat.do?handler",
          	dataType : "json",
          	data: {
               	"reqmsg":reqmsg,
               	"weixin":"weixin"
          	},
          	success : function(data){
              	if(data.des=="success"){
              		if(data.content != null){
            	  		if (data.content.olderWechatList != null) {
            	  			var olderId = "0";
            	  			var olderName = "无";
            	  			var idnumber = "无";
							jQuery.each(data.content.olderWechatList, function(i, item) {	
								if(item.older != null){
									olderId = item.older.id;
                            		olderName = item.older.name;
                            		idnumber = item.older.idnumber;
                            	}
                            	if(olderName != "无" || idnumber != "无"){
                            		html += "<tr onclick=\"olderfuzhi('" + olderName + "'," + olderId + ")\"><td>" + olderName + "</td><td>" + idnumber + "</td><td><span class=\"glyphicon glyphicon-chevron-right\"></span></td></tr>";
                            	}
                            	
                            	olderId = "0";
								olderName = "无";
            	  			 	idnumber = "无";
							});
							$("#olderList").html(html);
			      		}else{
			      			$("#olderList").html("无关注老人信息！");
			      		}
			      	}else{
			      		$("#olderList").html("无关注老人信息！");
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
	//老人列表赋值
	function olderfuzhi(olderName,id){
		$("#olderName_input").val(olderName);
		$("#olderId_hide").val(id);
		$("#closeChoosOlder").click();
		querySites(id);
	}
	
	function querySites(olderId){
		  var html = "";
		
		  jQuery.ajax({
          type : "post",
          async:false,
          url : "older.do?querySiteName",
          dataType : "json",
          data: {
               "olderId":olderId,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des == "100"){
              	if(data.nameList != null){
              		jQuery.each(data.nameList, function(i, item) {
            	  		html += "<option value=\"" + item.id + "\">" + item.name + "</option>";
            	  	});
              	}
              }else{
                 alert("查询失败");
              }
          },
          error:function(){
	           alert("error");
          }
    	 });
    	 
    	 $("#olderFWZD_hide").html(html);
	}
	
	//跳转下单页
	function tiaozhuanxiadan(){
		var serviceId = $("#serviceId_hide").val();
		var olderId = $("#olderId_hide").val();
		if(olderId == null || olderId == "" || olderId == "0"){
			alert("请选择老人");
			return;
		}
		var lianxiren_input = $.trim($("#lianxiren_input").val());
		if(lianxiren_input == null || lianxiren_input == ""){
			alert("请填写联系人");
			return;
		}
		var dianhua_input = $.trim($("#dianhua_input").val());
		if(dianhua_input == null || dianhua_input == ""){
			alert("请填写联系电话");
			return;
		}
		var address_input = $.trim($("#address_input").val());
		if(address_input == null || address_input == ""){
			alert("请填写地址");
			return;
		}
		var yjfwsc_input = $.trim($("#yjfwsc_input").val());
		if(yjfwsc_input == null || yjfwsc_input == ""){
			alert("请填写预计服务时长");
			return;
		}else{
			var reg1 = new RegExp("^(0|[1-9][0-9]*)$"); 
			if(!reg1.test(yjfwsc_input)){ 
       			alert("请输入符合规范的预计服务时长!");
       			return;
   	 		}
		}
		var fwzx_input = $.trim($("#fwzx_input").val());
		if(fwzx_input == null || fwzx_input == ""){
		//	alert("请选择服务子项");
		//	return;
			fwzx_input = "";
		}
		var olderFWZD_hideId = $("#olderFWZD_hide").val();
		var olderFWZD_hideValue = $("#olderFWZD_hide  option:selected").text();
		
		window.location.replace("<%=request.getContextPath()%>/" + "wechatReservationService.do?mainOrderConfirmation&serviceId=" + serviceId + "&olderId=" + olderId + "&lianxiren_input=" + lianxiren_input + "&dianhua_input=" + dianhua_input + "&address_input=" + address_input + "&yjfwsc_input=" + yjfwsc_input + "&fwzx_input=" + fwzx_input + "&olderFWZD_hideId=" + olderFWZD_hideId + "&olderFWZD_hideValue=" + olderFWZD_hideValue + "&weixin=weixin");
	}
	
	
	////下单页返回修改//////////////
	//获取老人信息
	function queryOlder(OlderId){
		var reqmsg = "{'action':'QUERY_OLDER_INFO_REQUEST','content':{\"id\":"+OlderId+"}}";
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
              if(data.des == "success"){
            	  if (data.content != null) {
            	  	$("#olderName_input").val(data.content.name);
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
    ////////////////////////////
    
    //跳转老人新增页
    function jumpToOlderAdd(){
    	var wechatId = $("#wechatId_hide").val();
    	var serviceId_hide = $("#serviceId_hide").val();
    	var url = "<%=request.getContextPath()%>" + "/wechatOlder.do?mainAdd&flag=service&serviceId=" + serviceId_hide + "&wechatId=" + wechatId + "&weixin=weixin";
		window.location.replace(url);
	}
	</script>
</body>
</html>
