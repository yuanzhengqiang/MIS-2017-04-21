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
<title>明细</title>
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
.modal-body table tr:nth-child(1){border-bottom-top:1px solid #eee}
.modal-body table tr{line-height:36px;border-bottom-bottom:1px solid #eee}
.modal-body .checkbox label{color:#666}
</style>
</head>

<body style="background:#eee">
	<div class="fixedTOP" style="background-color: #F39800 ; margin: 0px;">		
		<h3>明细</h3>
		
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left" id=""></span>
        </a>
		
	</div>

	<input type="hidden" value="1" id="page">
        <div class="form-group" style="margin-top: 50px;background-color: #fff; height:auto">
            <!-- <div style=" width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;">
                <p style="height:20px">
                    <span style="float:left; font-size:18px;">充值</span>
                    <span style="float: right;  font-size:18px;">+100.00</span>
                </p>
                <p style="height:20px">
                    <span style="float:left;  font-size:10px; color:#777777;">微信充值</span>
                    <span style="float: right;  font-size:10px; color:#777777;">2016-09-13</span>
                </p>
            </div>
            <div style=" width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;">
                <p style="height:20px">
                    <span style="float:left; font-size:18px;">充值</span>
                    <span style="float: right;  font-size:18px;">+100.00</span>
                </p>
                <p style="height:20px">
                    <span style="float:left;  font-size:10px; color:#777777;">微信充值</span>
                    <span style="float: right;  font-size:10px; color:#777777;">2016-06-13</span>
                </p>
            </div>
            <div style=" width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;">
                <p style="height:20px">
                    <span style="float:left; font-size:18px;">饮食照料</span>
                    <span style="float: right;  font-size:18px;">-100.00</span>
                </p>
                <p style="height:20px">
                    <span style="float:left;  font-size:10px; color:#777777;">1254122221 市场扣除</span>
                    <span style="float: right;  font-size:10px; color:#777777;">2016-10-13</span>
                </p>
            </div>
            <div style=" width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;">
                <p style="height:20px">
                    <span style="float:left; font-size:18px;">充值</span>
                    <span style="float: right;  font-size:18px;">+300.00</span>
                </p>
                <p style="height:20px">
                    <span style="float:left;  font-size:10px; color:#777777;">微信充值</span>
                    <span style="float: right;  font-size:10px; color:#777777;">2016-09-19</span>
                </p>
            </div>
            <div style=" width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;">
                <p style="height:20px">
                    <span style="float:left; font-size:18px;">充值</span>
                    <span style="float: right;  font-size:18px;">+100.00</span>
                </p>
                <p style="height:20px">
                    <span style="float:left;  font-size:10px; color:#777777;">微信充值</span>
                    <span style="float: right;  font-size:10px; color:#777777;">2016-09-13</span>
                </p>
            </div>
            <div style=" width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;">
                <p style="height:20px">
                    <span style="float:left; font-size:18px;">饮食照料</span>
                    <span style="float: right;  font-size:18px;">-100.00</span>
                </p>
                <p style="height:20px">
                    <span style="float:left;  font-size:10px; color:#777777;">1254122221 市场扣除</span>
                    <span style="float: right;  font-size:10px; color:#777777;">2016-09-13</span>
                </p>
            </div>
            <div style=" width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;">
                <p style="height:20px">
                    <span style="float:left; font-size:18px;">充值</span>
                    <span style="float: right;  font-size:18px;">+100.00</span>
                </p>
                <p style="height:20px">
                    <span style="float:left;  font-size:10px; color:#777777;">微信充值</span>
                    <span style="float: right;  font-size:10px; color:#777777;">2016-09-13</span>
                </p>
            </div>
            <div style=" width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;">
                <p style="height:20px">
                    <span style="float:left; font-size:18px;">充值</span>
                    <span style="float: right;  font-size:18px;">+100.00</span>
                </p>
                <p style="height:20px">
                    <span style="float:left;  font-size:10px; color:#777777;">微信充值</span>
                    <span style="float: right;  font-size:10px; color:#777777;">2016-09-13</span>
                </p>
            </div>
            <div style=" width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;">
                <p style="height:20px">
                    <span style="float:left; font-size:18px;">充值</span>
                    <span style="float: right;  font-size:18px;">+100.00</span>
                </p>
                <p style="height:20px">
                    <span style="float:left;  font-size:10px; color:#777777;">微信充值</span>
                    <span style="float: right;  font-size:10px; color:#777777;">2016-09-13</span>
                </p>
            </div>
            <div style=" width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;">
                <p style="height:20px">
                    <span style="float:left; font-size:18px;">充值</span>
                    <span style="float: right;  font-size:18px;">+100.00</span>
                </p>
                <p style="height:20px">
                    <span style="float:left;  font-size:10px; color:#777777;">微信充值</span>
                    <span style="float: right;  font-size:10px; color:#777777;">2016-09-13</span>
                </p>
            </div> -->
            <div style="text-align:center; padding: 10px" id="datas">
                <button style="color:#000; font-size: 14px; border: none; background-color: #fff; ">加载更多</button>
            </div>
            
        </div>
        
		<script type="text/javascript">
               $(document).ready(function() {
               	var olderId = "<%=request.getAttribute("olderId")%>";
    			$("#backToGzlr").attr("href","<%=request.getContextPath()%>/" + "wechatYuE.do?mainBalance&olderId=" + olderId + "&weixin=weixin");
    	
    			query_czjl();
    			
                $(window).scroll(function() {
             
                    /*if ($(document).scrollTop()<=0){
                        alert("滚动条已经到达顶部");
                    }*/
             
                    if ($(document).scrollTop() >= $(document).height() - $(window).height()) {
                    	query_czjl();
                        //alert("滚动条已经到达底部");
                    }
                });
            });
        </script>
 
<script type="text/javascript">
	
	function query_czjl(){
		var olderId = "<%=request.getAttribute("olderId")%>";
		var page = $("#page").val();
		if(page == "0"){
			return;
		}
		var html = "";
		var flag = 0;
		
		var reqmsg="{'action':'QUERY_RECHARGE_LIST_REQUEST',\"order\":[{\"column\":\"createTime\",\"type\":\"desc\"}],\"page\":{\"pageno\":\"" + page + "\",\"pagesize\":\"10\"},'content':{\"olderId\":"+olderId+"}}";
		  jQuery.ajax({
          type : "post",
          async:false,
          url : "recharge.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.des=="success"){
            	 if (data.content != null) {
            	 	if(data.content.rechargeList != null){
            	 		jQuery.each(data.content.rechargeList, function(i, item) {	
	            	 		html += "<div style=\"width:100%;border-bottom: 1px #D8DBDE solid; height:60px; clear: both; padding: 10px 15px;\">";
            	  	 		html += "<p style=\"height:20px\">";
                	 		html += "<span style=\"float:left; font-size:18px;\">" + xiaofeiType(item.type) + "</span>";
                	 		if(item.type == 1){
                	 			html += "<span style=\"float: right;  font-size:18px;\">+" + item.amount + "</span>";
                	 		}else{
                	 			html += "<span style=\"float: right;  font-size:18px;\">-" + item.amount + "</span>";
                	 		}
                     		html += "</p>";
                	 		html += "<p style=\"height:20px\">";
                	 		if(item.type == 1){
                	 			html += "<span style=\"float:left;  font-size:10px; color:#777777;\">" + chongzhiWay(item.rechargeMethod) + "</span>";
                	 		}else{
                	 			html += "<span style=\"float:left;  font-size:10px; color:#777777;\">" + item.serviceTaskCode + " " + item.serviceName + "  " + chongzhiWay(item.rechargeMethod) + "</span>";
                	 		}
                	 		html += "<span style=\"float: right;  font-size:10px; color:#777777;\">" + formateTime(item.createTime) + "</span>";
                     		html += "</p>";
                     		html += "</div>";
                     		flag ++;
            	 		});
            	 		$(html).insertBefore("#datas"); 
            	 	}
            	 }
            	 if(flag == 10){
            	 	$("#page").val((parseInt(page) + 1));
            	 }else{
            	 	$("#datas").hide();
            	 	$("#page").val("0");
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
	
	
	function xiaofeiType(type){
		var name = "未知";
     	switch (type)
		{
			case 1:
  			name = "充值";
  			break;
  			
			case 2:
  			name = "消费";
  			break;
  			
  			default:
  			break;
		}
		return name;
	}
	
	function chongzhiWay(rechargeMethod){
		var name = "未知";
     	switch (rechargeMethod)
		{
			case 1:
  			name = "自动扣款";
  			break;
  			
			case 2:
  			name = "前台扣款";
  			break;
  			
  			case 3:
  			name = "微信充值";
  			break;
  			
  			case 4:
  			name = "前台充值";
  			break;
  			
  			case 5:
  			name = "其他充值";
  			break;
  			
  			case 6:
  			name = "其他扣款";
  			break;
  			
  			default:
  			break;
		}
		return name;
	}
	
/**
 * 格式化时间
 * @method formateTime
 * @param {String} time 时间信息(YYYYMMDDHHmmSS)
 * @return 格式化的时间(YYYY-MM-DD)
 */
function formateTime(time) {
	if (time != null && time.length == 14) {
		return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8);
	} else {
		return time;
	}
}
	
</script>
	
</body>
</html>
