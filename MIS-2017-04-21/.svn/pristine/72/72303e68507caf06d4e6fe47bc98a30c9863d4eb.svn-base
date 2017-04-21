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
<title>我的关注</title>
<link rel="stylesheet" type="text/css" href="weixincss/bootstrap.css">
<link rel="stylesheet" type="text/css" href="weixincss/core.css">
<link rel="stylesheet" type="text/css" href="weixincss/color.css">
<link rel="stylesheet" type="text/css" href="weixincss/my_Frame.css">
<script type="text/javascript" src="weixinjs/jquery-1.11.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script type="text/javascript" src="weixinjs/bootstrap.min.js"></script>

<script type="text/javascript" src="js/jquery.js"></script>

</head>

<body class="page-body">
	<div class="page-header">
		<div class="navbar-brand">
			<a href="#" class="logo"> <span>老人列表</span> </a>
		</div>
		<div class="top_right top_right_man" onclick="qingkongtanchuang()">
			<a href="#" data-toggle="modal" data-target="#myModal"> <img src="weixinimages/man.png"> </a>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="main">
		<div class="w_con">
			<div style="text-align:center;">
				<a href="###" id="longActingInsuranceAgentA" style="display:none;"><span id="longActingInsuranceAgentSpan">长护险代理跳转</span>
				</a>
				<button type="button" class="btn btn-primary" style="width:90%;" onclick="$('#longActingInsuranceAgentSpan').click();">长护险代理</button>
			</div>
			<ul class="pay_man" id="olderList">

			</ul>
		</div>
	</div>
	<div class="panel-footer pos_footer">
		热线电话：<span class="font_blue"><a href="tel:4000965258">4000965258</a>
		</span>
	</div>
	<!-- #include file ="Footer.html" -->

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">添加老人</h4>
				</div>
				<div class="modal-body">
					<form role="form">
						<div class="form-group">
							<label for="name" class="font_blue" style=" letter-spacing:2px;">姓&nbsp;&nbsp;&nbsp;&nbsp;名</label> <input id="name" type="text" class="form-control" placeholder="文本输入">
						</div>
						<div class="form-group">
							<label for="name" class="font_blue" style=" letter-spacing:4px;">身份证</label> <input id="pid" type="text" class="form-control" placeholder="文本输入">
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<div class="col-xs-12">
						<div class="text-center">
							<button type="button" class="btn my_btn-success" onclick="concernedOlder()" style="width:50px">完成</button>
							<button type="button" class="btn btn-default btn-flat md-close" data-dismiss="modal" id="quxiao_tanchuang" style="width:50px">取消</button>
						</div>
					</div>
				</div>
				<div class="con_Spacing"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<input type="hidden" id="wechatId" value="">
</body>
</html>
<script type="text/javascript" src="js/mordo.tools/mordo.timeProcessing.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var wechatId = "<%=request.getAttribute("wechatId")%>";
		if(wechatId != null && wechatId != ""){
			$("#wechatId").val(wechatId);
			getwechatOldList();
		}
		var url = "<%=request.getContextPath()%>" + "/wechatOlder.do?mainAdd&flag=longActingInsuranceAgent&wechatId=" + wechatId + "&weixin=weixin";
		$("#longActingInsuranceAgentA").attr("href",url);
	});
	
	
	//获取用户已关注老人列表
	function getwechatOldList(){
		var wechatId = $("#wechatId").val();
		
		var reqmsg = "{'action':'QUERY_OLDER_WECHAT_LIST_REQUEST','page':{'pageno':'1','pagesize':'10000'},'content':{\"olderShow\":\"true\",";
	
		if (wechatId != null && wechatId != "") {
			 reqmsg += "\"wechatId\":" + wechatId + ",";
		}
		reqmsg += "}}";
		
		var headUrl = "<%=request.getContextPath()%>";
		
    	jQuery.ajax({
          	type : "post",
          	async:true,
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
            	  			var html = "";
            	  			var olderPhotoUrl = "";
            	  			var olderName = "";
            	  			//var memberNum = "";
            	  			var idnumber = "";
            	  			var memberStatus = 3;//未知
							jQuery.each(data.content.olderWechatList, function(i, item) {	
								if(item.older != null){
                            		olderPhotoUrl = item.older.mainPhoto + "?random=" + Math.random();
                            		olderName = item.older.name;
                            		//memberNum = item.older.memberNum;
                            		idnumber = item.older.idnumber;
                            		memberStatus = item.older.memberStatus;
                            	}
                            	
								html += "<div class=\"line\"></div>";
                    			html += "<li>";
                    			html += "<div class=\"container\">";
                            	html += "<a href=\""+headUrl+"/wechatOlder.do?mainXQ&olderId="+item.olderId+"&weixin=weixin\">";
                            	if(olderPhotoUrl == "" || olderPhotoUrl == null){
                            		html += "<span class=\"gz_man_pic\"><img style=\"width:75px;height:75px;\" src=\""+headUrl+"/weixinimages/oldernull.png\"></span>";
                            	}else{
                                	html += "<span class=\"gz_man_pic\"><img style=\"width:75px;height:75px;\" src=\"" + olderPhotoUrl + "\"></span>";
                                }
                                html += "<span class=\"gz_man_con\">";
                                html += "<span><strong style=\"font-size:18px;\">" + olderName + "</strong></span>";
                                html += "<span style=\"font-size:15px;\">" + idnumber + "</span>";
                                html += "<span>" + changeMemberStatus(memberStatus) + "</span>";
                                html += "</span>";
                                html += "<span class=\"glyphicon glyphicon-chevron-right text-muted gz_mam_right\"></span>";
                            	html += "</a>";
                        		html += "</div>";
                    			html += "</li>";
                    			
								olderPhotoUrl = "";
								olderName = "";
            	  			 	//memberNum = "";
            	  			 	idnumber = "";
            	  			 	memberStatus = 3;
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
	
	//关注老人
	function concernedOlder(){
		var name = $("#name").val();
		var pid = $("#pid").val();
		if(name == null || name == ""){
			alert("请填写姓名");
			return;
		}
		if(pid == null || pid == ""){
			alert("请填写身份证");
			return;
		}
		var oldId = getolderId(name,pid);
		if(oldId == ""){
			alert("查询出错");
			return;
		}
		if(oldId == "0"){
			if (confirm("老人不存在，点击确定跳转老人新增页"))  {  
				var wechatId = $("#wechatId").val();
				var url = "<%=request.getContextPath()%>" + "/wechatOlder.do?mainAdd&name=" + name + "&olderNumberId=" + pid + "&wechatId=" + wechatId + "&weixin=weixin";
				window.location.replace(url);
			}
			return;
		}
		
		var wechatId = $("#wechatId").val();
		
		var ifHave = checkIfOldHave(oldId,wechatId);
		if(ifHave == "1"){
			alert("该老人已绑定");
			return;
		}
		if(ifHave == "0"){
			alert("查询出错");
			return;
		}
		
		var reqmsg="{'action':'ADD_OLDER_WECHAT_INFO_REQUEST','content':{";
	
		reqmsg += "\"olderId\":" + oldId + ",";
		reqmsg += "\"wechatId\":" + wechatId + ",";
		reqmsg += "\"addTime\":\"" + getCurrentTime() + "\",";
		
		reqmsg += "}}";

    	jQuery.ajax({
          	type : "post",
          	async:true,
          	url : "olderWechat.do?handler",
          	dataType : "json",
          	data: {
               	"reqmsg":reqmsg,
               	"weixin":"weixin"
          	},
          	success : function(data){
              	if(data.result=="100"){
              		alert("绑定成功");
              		$("#quxiao_tanchuang").click();
              		getwechatOldList();
              	}else if(data.result=="failure"){
                 	alert("绑定失败");
              	}
         	},
          	error:function(){
	           	alert("error");
          	}
     	});
		
	}
	
	//判断老人是否存在
	function getolderId(name,pid){
		var oldId = "";
		
		var reqmsg="{'action':'QUERY_OLDER_LIST_REQUEST','page':{'pageno':'1','pagesize':'1'},'content':{";
	
		if (name != null && name != "") {
			reqmsg += "\"name\":\"" + name + "\",";
		}
		if (pid != null && pid != "") {
			reqmsg += "\"idnumber\":\"" + pid + "\"";
		}
		reqmsg += "}}";
	
	    jQuery.ajax({
	          type : "post",
	          async:false,
	          url : "older.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg,
	               "weixin":"weixin"
	          },
	          success : function(data){
	              if(data.des=="success"){
	              	  if(data.content != null){
	              	  	 if(data.content.olderList != null){
	            	  		 oldId = data.content.olderList[0].id;
			    	 	 }else{
			    	  	 	 oldId = "0";
			    	  	 }
			    	  }else{
			    	  	 oldId = "0";
			    	  }
	              }else if(data.des=="failure"){
	                 //alert("查询失败");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });
	     return oldId;
	}
	
	//判断老人是否已经绑定
	function checkIfOldHave(oldId,wechatId){
			var flag = "";
		
			var reqmsg="{'action':'QUERY_OLDER_WECHAT_LIST_REQUEST','page':{'pageno':'1','pagesize':'10000'},'content':{";
		
			if (oldId != null && oldId != "") {
				 reqmsg += "\"olderId\":" + oldId + ",";
			}
			if (wechatId != null && wechatId != "") {
				 reqmsg += "\"wechatId\":" + wechatId + ",";
			}
			reqmsg += "}}";
	
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
	            	  		if (data.content.olderWechatList != null && data.content.olderWechatList.length > 0) {
	            	  			flag = "1";
				      		}
				      	}
	              	}else{
	              		flag = "0";
	              	}
	         	},
	          	error:function(){
	          		flag = "0";
	          	}
	     	});
	     return flag;
	}
	
	//清空弹窗
	function qingkongtanchuang(){
		$("#name").val("");
		$("#pid").val("");
	}
	
	//客户状态
	function changeMemberStatus(id){
		var name = "未知";
	    switch (id)
		{
			case 0:
	  		name = "正常";
	  		break;
	  			
			case 1:
	  		name = "审核不通过";
	  		break;
	
			case 2:
	  		name = "待评估";
	  		break;
	  			
	  		default:
	  		break;
		}
		return name;
	}
</script>