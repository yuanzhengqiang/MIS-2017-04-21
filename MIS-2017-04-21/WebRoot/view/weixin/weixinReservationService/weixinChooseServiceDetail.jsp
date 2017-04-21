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
<title>服务详情</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>	
.table{margin-top:-1px}
.table tr td{border:0;}
.table td img{width:50px;height:auto;border:0;border-radius:50%;}
.table td:nth-child(1){width:70px;min-width: 60px; vertical-align:middle}
.table td:nth-child(2){text-align:left;padding-left:0;padding-right:0;vertical-align:middle}
.table td:nth-child(2) p{text-indent:0}
.table td:nth-child(3){text-align:right;width:80px;padding-left:0;padding-right:8px;vertical-align:middle}
#serviceDetailList{left:35px;padding-left:0px}
</style>
<script type="text/javascript" src="js/addressJS.js"></script>
</head>
<body>
	<div class="fixedTOP">
		<a href="###" class="logo" id="turnMainList">
        	<span class="glyphicon glyphicon-chevron-left"></span>
        </a>
		<a href="###" class="logo" id="serviceDetailList">
        	<span style="">服务详情</span>
        </a> 
	</div>
	
	<div class="tab-content " style="position:absolute;top:50px;width:100%" id="xiaoxiangbody">
	</div>
</body>
<script type="text/javascript">
	 
      //获取体检项目信息
     function getxiangmu(typeId){
      	var html="";
        var reqmsg="{'action':'QUERY_SERVICE_LIST_REQUEST','page':{'pageno':'1','pagesize':'1000000'},'content':{\"servicePhotoListShow\":\"true\",";
		reqmsg += "\"deleted\":0,";
		reqmsg += "\"status\":1,";
		reqmsg += "\"typeId\":" + typeId + ",";
        reqmsg += "}}";
        
		var headUrl = "<%=request.getContextPath()%>";
		
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
            	  	if (data.content != null) {
            	  		if(data.content.serviceList != null && data.content.serviceList.length > 0){
            	  			html+= "<div class=\"tab-pane fade in active\">";
            	  			
            	  			html+= "<table class=\"table\">";
        					html+= "<tbody id=\"\">";
        						
            	  			jQuery.each(data.content.serviceList, function(i, item) {
        						html+= "<tr onclick=\"tiaozhuan('"+headUrl+"/wechatReservationService.do?mainXQ&id="+item.id +"&weixin=weixin')\">";
        						if(item.servicePhotoList != null && item.servicePhotoList.length > 0){
        							html+= "<td><img src=\"" + item.servicePhotoList[0].photoUrl + "?random=" + Math.random() + "\"></td>";
        						}else{
        							html+= "<td><img src=\"###\"></td>";
        						}
        						html+= "<td><h4>" + item.name + "</h4></td>";
        						html+= "<td>￥" + item.marketPrice + "</td>";
        						html+= "</tr>";
        					});
        						
        					html+= "</tbody>";
        					html+= "</table>";
        					html+= "</div>";
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
        $("#xiaoxiangbody").html(html);
     }
      
     //页面跳转
     function tiaozhuan(url){
	     window.location.replace(url);
     }
      
	
	$(document).ready(function(){
		var typeId="<%=request.getAttribute("typeId")%>";
		 getxiangmu(typeId);
		 
		 var phoneH = $(window).height()-50; 		 
		 $("#navheight").css("min-height", phoneH+"px");	
		 
		 //设置返回地址
		 var headUrl = "<%=request.getContextPath()%>";
		 var url = headUrl+"/wechatReservationService.do?main&weixin=weixin"
		 $("#turnMainList").attr("href",url)
		 
	});
</script>
</html>
