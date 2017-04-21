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
<title>生理参数概况</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>
<style>	
	.table>tbody>tr>td:nth-child(3){width:32px;vertical-align:middle}
	.table>tbody>tr>td:nth-child(1){padding-right:0;vertical-align:middle;font-size:20px;}
	.table>tbody>tr>td:nth-child(1) img{border:0;margin:0 10px;max-width:30px;height:auto}
	.table>tbody>tr>td:nth-child(2) p{text-align:left;margin:0;color:#555;text-indent:0}
	.table>tbody>tr>td:nth-child(2) p .danwei{color:#555}
	.table>tbody>tr:nth-last-child(1)>td{border-bottom:1px solid #ddd;}
	.table td:nth-child(3) span{color:#888}
	.table td:nth-child(2) span.glyphicon-arrow-up , .table td:nth-child(2) span.glyphicon-arrow-down{color:#e2221a;float:right}

	
</style>
</head>

<body>
	<div class="fixedTOP">		
		<h3>生理参数</h3>
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
	</div>
	<div style="display:none;">
		<a href="###" id="slcsls_xueya_a" style="display:none;"><span id="slcsls_xueya">跳转</span></a>
		<a href="###" id="slcsls_xuetang_a" style="display:none;"><span id="slcsls_xuetang">跳转</span></a>
		<a href="###" id="slcsls_maibo_a" style="display:none;"><span id="slcsls_maibo">跳转</span></a>
		<a href="###" id="slcsls_tiwen_a" style="display:none;"><span id="slcsls_tiwen">跳转</span></a>
		<a href="###" id="slcsls_huxi_a" style="display:none;"><span id="slcsls_huxi">跳转</span></a>
		<a href="###" id="slcsls_xueyang_a" style="display:none;"><span id="slcsls_xueyang">跳转</span></a>
		<a href="###" id="slcsls_gumidu_a" style="display:none;"><span id="slcsls_gumidu">跳转</span></a>
	</div>

	<table class="table" >
   <tbody>
      <tr onclick="$('#slcsls_xueya').click();">
      	 <td><img src="weixinimages/xueya.png" />血压</td>
         <td>         	
			 <p>收缩压：<span id="zhi_xueya_ssy">未测量</span><span id="danwei_xueya_ssy" class="danwei"></span><span id="state_xueya_ssy" class=""></span></p>
			 <p>舒张压：<span id="zhi_xueya_szy">未测量</span><span id="danwei_xueya_szy" class="danwei"></span><span id="state_xueya_szy" class=""></span></p>
			 <p id="zhi_xueya_time"></p>			
		 </td>
         <td><span class="glyphicon glyphicon-chevron-right"></span></td>
      </tr>
      <tr onclick="$('#slcsls_xuetang').click();">
      	 <td><img src="weixinimages/xuetang.png" />血糖</td>
         <td>         	
			 <p>空腹血糖：<span id="zhi_xuetang_kf">未测量</span><span id="danwei_xuetang_kf" class="danwei"></span><span id="state_xuetang_kf" class=""></span></p>
			 <p>餐后血糖：<span id="zhi_xuetang_ch">未测量</span><span id="danwei_xuetang_ch" class="danwei"></span><span id="state_xuetang_ch" class=""></span></p>
			 <p id="zhi_xuetang_time"></p>			
		 </td>
         <td><span class="glyphicon glyphicon-chevron-right"></span></td>
      </tr>
      <tr onclick="$('#slcsls_maibo').click();">
      	 <td><img src="weixinimages/maibo.png" />脉搏</td>
         <td> 
			 <p>脉搏：<span id="zhi_maibo">未测量</span><span id="danwei_maibo" class="danwei"></span><span id="state_maibo" class=""></span></p>
			 <p id="zhi_maibo_time"></p>			
		 </td>
         <td><span class="glyphicon glyphicon-chevron-right"></span></td>
      </tr>
      <tr onclick="$('#slcsls_tiwen').click();">
      	 <td><img src="weixinimages/tiwen.png" />体温</td>
         <td> 
			 <p>体温：<span id="zhi_tiwen">未测量</span><span id="danwei_tiwen" class="danwei"></span> <span id="state_tiwen" class=""></span></p>
			 <p id="zhi_tiwen_time"></p>			
		 </td>
         <td><span class="glyphicon glyphicon-chevron-right"></span></td>
      </tr>
      <tr onclick="$('#slcsls_huxi').click();">
      	 <td><img src="weixinimages/huxi.png" />呼吸</td>
         <td> 
			 <p>呼吸：<span id="zhi_huxi">未测量</span><span id="danwei_huxi" class="danwei"></span><span id="state_huxi" class=""></span></p>
			 <p id="zhi_huxi_time"></p>			
		 </td>
         <td><span class="glyphicon glyphicon-chevron-right"></span></td>
      </tr>
      <tr onclick="$('#slcsls_xueyang').click();">
      	 <td><img src="weixinimages/xueyang.png" />血氧</td>
         <td> 
			 <p>血氧：<span id="zhi_xueyang">未测量</span><span id="danwei_xueyang" class="danwei"></span><span id="state_xueyang" class=""></span></p>
			 <p id="zhi_xueyang_time"></p>				
		 </td>
         <td><span class="glyphicon glyphicon-chevron-right"></span></td>
      </tr>
      <tr onclick="$('#slcsls_gumidu').click();">
      	 <td><img src="weixinimages/gumidu.png" />骨密度</td>
         <td> 
			 <p>骨密度：<span id="zhi_gumidu">未测量</span><span id="danwei_gumidu" class="danwei"></span><span id="state_gumidu" class=""></span></p>
			 <p id="zhi_gumidu_time"></p>				
		 </td>
         <td><span class="glyphicon glyphicon-chevron-right"></span></td>
      </tr>
  
	  
   </tbody>
   </table>

</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		var olderId = "<%=request.getAttribute("olderId")%>";
    	$("#backToGzlr").attr("href","<%=request.getContextPath()%>/" + "wechatOlder.do?mainXQ&olderId=" + olderId + "&weixin=weixin");
		
		queryOlder_physiological();
		
	});
	
 function queryOlder_physiological(){
	var reqmsg="{'action':'QUERY_PHYSIOLOGICAL_PARAMETERS_CURRENT_LIST_REQUEST','content':{";
	
	var olderId = "<%=request.getAttribute("olderId")%>";
	if (olderId != null && olderId != "") {
		reqmsg += "\"olderId\":" + olderId + ",";
	}
	
	reqmsg += "}}";
	
    jQuery.ajax({
          type : "post",
          async:false,
          url : "physiologicalParametersCurrent.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des=="success"){
              	  if(data.content != null){
              	  	 var kfxttime = 0;
					 var chxttime = 0;
              	  	 if(data.content.physiologicalParametersCurrentList != null){
              	  	 	jQuery.each(data.content.physiologicalParametersCurrentList, function(i, item) {
              	  	 		if(item.type == "1"){
              	  	 			$("#slcsls_xueya_a").attr("href","<%=request.getContextPath()%>" + "/wechatPhysiologicalPar.do?mainHistory2&type=xueya&olderId=" + item.olderId + "&weixin=weixin");
              	  	 			$("#zhi_xueya_ssy").html(item.value);
              	  	 			$("#zhi_xueya_szy").html(item.value2);
              	  	 			$("#danwei_xueya_ssy").html(item.unit);
              	  	 			$("#danwei_xueya_szy").html(item.unit);
              	  	 			$("#zhi_xueya_time").html(formateTime(item.createTime));
              	  	 			if(item.status == "2"){
              	  	 				$("#state_xueya_ssy").attr("class","glyphicon glyphicon-arrow-up");
              	  	 			}
              	  	 			if(item.status == "3"){
              	  	 				$("#state_xueya_ssy").attr("class","glyphicon glyphicon-arrow-down");
              	  	 			}
              	  	 			if(item.status2 == "2"){
              	  	 				$("#state_xueya_szy").attr("class","glyphicon glyphicon-arrow-up");
              	  	 			}
              	  	 			if(item.status2 == "3"){
              	  	 				$("#state_xueya_szy").attr("class","glyphicon glyphicon-arrow-down");
              	  	 			}
              	  	 		}
              	  	 		if(item.type == "3"){
              	  	 			$("#slcsls_xuetang_a").attr("href","<%=request.getContextPath()%>" + "/wechatPhysiologicalPar.do?mainHistory1&type=xuetang&olderId=" + item.olderId + "&weixin=weixin");
              	  	 			kfxttime = item.createTime;
								if(kfxttime > chxttime){
									$("#zhi_xuetang_time").html(formateTime(item.createTime));
								}
              	  	 			$("#zhi_xuetang_kf").html(item.value);
              	  	 			$("#danwei_xuetang_kf").html(item.unit);
              	  	 			if(item.status == "2"){
              	  	 				$("#state_xuetang_kf").attr("class","glyphicon glyphicon-arrow-up");
              	  	 			}
              	  	 			if(item.status == "3"){
              	  	 				$("#state_xuetang_kf").attr("class","glyphicon glyphicon-arrow-down");
              	  	 			}
              	  	 		}
              	  	 		if(item.type == "4"){
              	  	 			$("#slcsls_xuetang_a").attr("href","<%=request.getContextPath()%>" + "/wechatPhysiologicalPar.do?mainHistory1&type=xuetang&olderId=" + item.olderId + "&weixin=weixin");
              	  	 			chxttime = item.createTime;
								if(chxttime > kfxttime){
              	  	 				$("#zhi_xuetang_time").html(formateTime(item.createTime));
								}
              	  	 			$("#zhi_xuetang_ch").html(item.value);
              	  	 			$("#danwei_xuetang_ch").html(item.unit);
              	  	 			if(item.status == "2"){
              	  	 				$("#state_xuetang_ch").attr("class","glyphicon glyphicon-arrow-up");
              	  	 			}
              	  	 			if(item.status == "3"){
              	  	 				$("#state_xuetang_ch").attr("class","glyphicon glyphicon-arrow-down");
              	  	 			}
              	  	 		}
              	  	 		if(item.type == "5"){
              	  	 			$("#slcsls_maibo_a").attr("href","<%=request.getContextPath()%>" + "/wechatPhysiologicalPar.do?mainHistory1&type=maibo&olderId=" + item.olderId + "&weixin=weixin");
              	  	 			$("#zhi_maibo").html(item.value);
              	  	 			$("#danwei_maibo").html(item.unit);
              	  	 			$("#zhi_maibo_time").html(formateTime(item.createTime));
              	  	 			if(item.status == "2"){
              	  	 				$("#state_maibo").attr("class","glyphicon glyphicon-arrow-up");
              	  	 			}
              	  	 			if(item.status == "3"){
              	  	 				$("#state_maibo").attr("class","glyphicon glyphicon-arrow-down");
              	  	 			}
              	  	 		}
              	  	 		if(item.type == "6"){
              	  	 			$("#slcsls_tiwen_a").attr("href","<%=request.getContextPath()%>" + "/wechatPhysiologicalPar.do?mainHistory1&type=tiwen&olderId=" + item.olderId + "&weixin=weixin");
              	  	 			$("#zhi_tiwen").html(item.value);
              	  	 			$("#danwei_tiwen").html(item.unit);
              	  	 			$("#zhi_tiwen_time").html(formateTime(item.createTime));
              	  	 			if(item.status == "2"){
              	  	 				$("#state_tiwen").attr("class","glyphicon glyphicon-arrow-up");
              	  	 			}
              	  	 			if(item.status == "3"){
              	  	 				$("#state_tiwen").attr("class","glyphicon glyphicon-arrow-down");
              	  	 			}
              	  	 		}
              	  	 		if(item.type == "7"){
              	  	 			$("#slcsls_huxi_a").attr("href","<%=request.getContextPath()%>" + "/wechatPhysiologicalPar.do?mainHistory1&type=huxi&olderId=" + item.olderId + "&weixin=weixin");
              	  	 			$("#zhi_huxi").html(item.value);
              	  	 			$("#danwei_huxi").html(item.unit);
              	  	 			$("#zhi_huxi_time").html(formateTime(item.createTime));
              	  	 			if(item.status == "2"){
              	  	 				$("#state_huxi").attr("class","glyphicon glyphicon-arrow-up");
              	  	 			}
              	  	 			if(item.status == "3"){
              	  	 				$("#state_huxi").attr("class","glyphicon glyphicon-arrow-down");
              	  	 			}
              	  	 		}
              	  	 		if(item.type == "8"){
              	  	 			$("#slcsls_xueyang_a").attr("href","<%=request.getContextPath()%>" + "/wechatPhysiologicalPar.do?mainHistory1&type=xueyang&olderId=" + item.olderId + "&weixin=weixin");
              	  	 			$("#zhi_xueyang").html(item.value);
              	  	 			$("#danwei_xueyang").html(item.unit);
              	  	 			$("#zhi_xueyang_time").html(formateTime(item.createTime));
              	  	 			if(item.status == "2"){
              	  	 				$("#state_xueyang").attr("class","glyphicon glyphicon-arrow-up");
              	  	 			}
              	  	 			if(item.status == "3"){
              	  	 				$("#state_xueyang").attr("class","glyphicon glyphicon-arrow-down");
              	  	 			}
              	  	 		}
              	  	 		if(item.type == "9"){
              	  	 			$("#slcsls_gumidu_a").attr("href","<%=request.getContextPath()%>" + "/wechatPhysiologicalPar.do?mainHistory1&type=gumidu&olderId=" + item.olderId + "&weixin=weixin");
              	  	 			$("#zhi_gumidu").html(item.value);
              	  	 			$("#danwei_gumidu").html(item.unit);
              	  	 			$("#zhi_gumidu_time").html(formateTime(item.createTime));
              	  	 			if(item.status == "2"){
              	  	 				$("#state_gumidu").attr("class","glyphicon glyphicon-arrow-up");
              	  	 			}
              	  	 			if(item.status == "3"){
              	  	 				$("#state_gumidu").attr("class","glyphicon glyphicon-arrow-down");
              	  	 			}
              	  	 		}
              	  	 	
              	  	 	});
              	  	 }
		    	  }
              }else if(data.des=="failure"){
                 //alert("查询失败");
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

</script>