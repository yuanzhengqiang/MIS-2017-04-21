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
<title>老人工单生理参数详情</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>

</head>

<body>
	<div class="fixedTOP">		
		<h3>生理参数</h3>
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
	</div>
	<table class="table" >
   <tbody>
      <tr>
         <td>体温</td>
         <td id="slcs_tiwen">无</td>
      </tr>
      <tr>
         <td>血压</td>
         <td id="slcs_xueya">无</td>
      </tr>
	  <tr>
         <td>脉搏</td>
         <td id="slcs_maibo">无</td>
      </tr>
	  <tr>
         <td>呼吸</td>
         <td id="slcs_huxi">无</td>
      </tr>
	  <tr>
         <td>餐前血糖</td>
         <td id="slcs_cqxt">无</td>
      </tr>
	   <tr>
         <td>餐后血糖</td>
         <td id="slcs_chxt">无</td>
      </tr>
	   <tr>
         <td>血氧</td>
         <td id="slcs_xueyang">无</td>
      </tr>
	   <tr>
         <td>骨密度</td>
         <td id="slcs_gmd">无</td>
      </tr>
	  <tr>
         <td colspan="2">其他事项
		 <p id="slcs_qtsx">无</p>
		 </td>         
      </tr>

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
		var reqmsg="{'action':'QUERY_SERVICE_TASK_INFO_REQUEST','content':{\"physiologicalParametersHistoryListShow\":\"true\",\"id\":"+gongdanId+"}}";
		
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
	            	 if(data.content.physiologicalParametersHistoryList != null && data.content.physiologicalParametersHistoryList != ""){
 						jQuery.each(data.content.physiologicalParametersHistoryList, function(i, item) {
 							if(item.type == 6 ){
 								$("#slcs_tiwen").html(item.value + item.unit);
 							}
 							if(item.type == 1 ){
 								$("#slcs_xueya").html(item.value2 + item.unit + "/" + item.value + item.unit);
 							}
 							if(item.type == 5 ){
 								$("#slcs_maibo").html(item.value + item.unit);
 							}
 							if(item.type == 7 ){
 								$("#slcs_huxi").html(item.value + item.unit);
 							}
 							if(item.type == 3 ){
 								$("#slcs_cqxt").html(item.value + item.unit);
 							}
 							if(item.type == 4 ){
 								$("#slcs_chxt").html(item.value + item.unit);
 							}
 							if(item.type == 8 ){
 								$("#slcs_xueyang").html(item.value + item.unit);
 							}
 							if(item.type == 9 ){
 								$("#slcs_gmd").html(item.value + item.unit);
 							}
 					   });
 					   $("#slcs_qtsx").html(data.content.physiologicalParametersDes);
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

</script>