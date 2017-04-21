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
<title>老人工单日常生活问询详情</title>
<link rel="stylesheet" href="weixincss/bootstrap.min.css">
<link rel="stylesheet" href="weixincss/mycss.css">
<script src="weixinjs/jquery.js"></script>	
<script src="weixinjs/bootstrap.min.js"></script>

</head>

<body>
	<div class="fixedTOP">		
		<h3>日常生活问询</h3>
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
	</div>
	
	<table class="table" >
   <tbody>
      <tr>
         <td>记录日期</td>
         <td id="rcsh_riqi">无</td>
      </tr>
      <tr>
         <td>记录人</td>
         <td id="rcsh_jlr">无</td>
      </tr>
	  <tr>
         <td>日摄水量1</td>
         <td id="rcsh_rshl1">无</td>
      </tr>
	  <tr>
         <td>日摄水量2</td>
         <td id="rcsh_rshl2">无</td>
      </tr>
	  <tr>
         <td>日摄食量(主食·g)</td>
         <td id="rcsh_rssl">无</td>
      </tr>
	   <tr>
         <td>小便次数</td>
         <td id="rcsh_xbcs">无</td>
      </tr>
	   <tr>
         <td>小便量</td>
         <td id="rcsh_xbl">无</td>
      </tr>
	   <tr>
         <td>大便次数</td>
         <td id="rcsh_dbcs">无</td>
      </tr>
	   <tr>
         <td>睡眠(小时/天)</td>
         <td id="rcsh_sm">无</td>
      </tr>
	  <tr>
         <td>睡眠质量</td>
         <td id="rcsh_smzl">无</td>
      </tr>
	  <tr>
         <td>精神</td>
         <td id="rcsh_js">无</td>
      </tr>
	  <tr>
         <td colspan="2">其他情况
		 <p id="rcsh_qtqk">无</p>
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
	
		querygongdan_DAILY_LIFE();
	});
	
	function querygongdan_DAILY_LIFE(){
		var gongdanId = "<%=request.getAttribute("gongdanId")%>";
		var reqmsg="{'action':'QUERY_DAILY_LIFE_ASK_LIST_REQUEST','order':[{'column':'createTime','type':'desc'}],'page':{'pageno':'1','pagesize':'1'},'content':{";
		reqmsg += "\"serviceTaskId\":" + gongdanId;
		reqmsg += "}}";

    	jQuery.ajax({
          	type : "post",
         	async:false,
          	url : "dailyLifeAsk.do?handler",
          	dataType : "json",
          	data: {
               	"reqmsg":reqmsg,
               	"weixin":"weixin"
          	},
            success : function(data){
              if(data.des=="success"){
            	 if (data.content != null) {
					jQuery.each(data.content.dailyLifeAskList, function(i, item) {
						$("#rcsh_riqi").html(formateTime(item.createTime));
						$("#rcsh_jlr").html(item.createPerson);
						$("#rcsh_rshl1").html(item.dailyWater1 + "ml");
						$("#rcsh_rshl2").html(item.dailyWater2 + "ml");
						$("#rcsh_rssl").html(item.dailyFood);
						$("#rcsh_xbcs").html(item.urine + "次");
						$("#rcsh_xbl").html(item.urineNum + "ml");
						$("#rcsh_dbcs").html(item.shit + "次" + item.shitDay + "天");
						$("#rcsh_sm").html(item.sleepHour);
						$("#rcsh_smzl").html(item.sleepQuality);
						$("#rcsh_js").html(item.morningSpirit);
						$("#rcsh_qtqk").html(item.other);
					});
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
</script>