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
<title>账户余额</title>
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
</head>

<body style="background:#eee">
	<div class="fixedTOP">		
		<h3>账户余额</h3>
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left" id=""></span>
        </a>
	</div>
        <div class="form-group" style="margin-top: 50px;padding-top: 50px;padding-bottom: 30px;text-align: center;">
			<img src="weixinimages/zhanghuyue.png" style="width: 80px;height: 80px;">
		</div>
		 
		<div class="form-group" style="height: 50px;">
			<label class="col-xs-5 control-label"><span style="font-size: 40px; float:right;">￥</span></label>			
			<div class="col-xs-6 control-label"><span style="font-size: 40px;" id="yue">0.00</span></div>
		</div>
	
 
 		<div  style="text-align:center;margin-top:15px; clear:both;" >
 		<div>
 		 <button type="button" class="btn btn-primary " style="width:80% " onclick="chongzhi()">充值</button>
 		</div>
		
		<div style="margin:20px 0px">
 		 <button type="button" class="btn  btn-success" style="width:80%;" onclick="mingxi()"><span class="glyphicon glyphicon-ok"></span> 明细</button>
 		</div>
		  
		 </div>
		
 

<script type="text/javascript">
	$(document).ready(function(){
		var olderId = "<%=request.getAttribute("olderId")%>";
    	$("#backToGzlr").attr("href","<%=request.getContextPath()%>/" + "wechatOlder.do?mainXQ&olderId=" + olderId + "&weixin=weixin");
    	
		queryyue(olderId);
		
	});
	
	function queryyue(olderId){
		var reqmsg="{'action':'QUERY_OLDER_INFO_REQUEST','content':{\"id\":"+olderId+"}}";
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
            	 if (data.content != null) {
            	  	 $("#yue").html(data.content.accountNum);
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
	
	function chongzhi(){
		var olderId = "<%=request.getAttribute("olderId")%>";
		var path="<%=request.getContextPath()%>";
        var url=path+"/wechatYuE.do?mainRecharge&weixin=weixin&olderId="+olderId;
        window.location.replace(url);
	}
	
	function mingxi(){
		var olderId = "<%=request.getAttribute("olderId")%>";
		var path="<%=request.getContextPath()%>";
        var url=path+"/wechatYuE.do?mainMoneyDetails&weixin=weixin&olderId="+olderId;
        window.location.replace(url);
	}
	
	
</script>
</body>
</html>
