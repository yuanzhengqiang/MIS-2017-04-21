<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head> 
<script src="weixinjs/jquery.js"></script>	
<title>支付</title> 
</head>
<body> 
    <script language="javascript" type="text/javascript">
    	var p = 0;
        if(p == 0)
    	{
        	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
            	pay();
        	});
    	}
    	
//唤起微信支付  
function pay(){
		p = 1;
    	var appId = "";
        var timeStamp = ""; 
        var nonceStr = "";  
        var pg = "";  
        var paySign = ""; 
        var olderId = "";
        var total_fee = "";
        var out_trade_no = "";
        
        var path="<%=request.getContextPath()%>";
       
        var result = "<%=request.getAttribute("result")%>";
        if(result == "100"){
	        appId = "<%=request.getAttribute("appId")%>";
       		timeStamp = "<%=request.getAttribute("timeStamp")%>";
       		nonceStr = "<%=request.getAttribute("nonceStr")%>";
       		pg = "<%=request.getAttribute("pg")%>";
       		paySign = "<%=request.getAttribute("paySign")%>";
       		olderId = "<%=request.getAttribute("olderId")%>";
       		total_fee = "<%=request.getAttribute("total_fee")%>";
       		out_trade_no = "<%=request.getAttribute("out_trade_no")%>";
        }
       
       //alert(appId + "|||" + timeStamp+ "|||" + nonceStr + "|||" + pg + "|||" + paySign + "|||" +olderId);
      
         
    WeixinJSBridge.invoke(    
        'getBrandWCPayRequest', {    
            "appId" : appId,     //公众号名称，由商户传入         
            "timeStamp": timeStamp,         //时间戳，自1970年以来的秒数         
            "nonceStr" : nonceStr, //随机串         
            "package" : pg,         
            "signType" : "MD5",         //微信签名方式:         
            "paySign" : paySign    //微信签名     
        },    
            
        function(res){         
            if(res.err_msg == "get_brand_wcpay_request:ok" ) {    
                //alert("支付成功");  // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。     
                //回到老人余额页 
            	window.location.href = path + "/wechatYuE.do?mainBalance&olderId=" + olderId + "&weixin=weixin";
                save_recharge(olderId,total_fee,out_trade_no);
            }else if (res.err_msg == "get_brand_wcpay_request:cancel")  {  
                alert("支付过程中用户取消");  
            }else if (res.err_msg == "get_brand_wcpay_request:fail")  {  
                alert("支付失败");  
            }else{  
               //支付失败  
               alert(res.err_msg)  
            }   
            
        } 
    );      
}    

function save_recharge(olderId,total_fee,out_trade_no){
	var reqmsg="{'action':'ADD_OLDER_INFO_REQUEST','content':{";
	reqmsg += "\"id\":" + olderId + ",";
	reqmsg += "\"accountNumType\":\"add_weixin\",";
	reqmsg += "\"accountNum\":" + total_fee + ",";
	reqmsg += "\"out_trade_no\":\"" + out_trade_no + "\",";
	reqmsg += "}}";

	jQuery.ajax({
          type : "post",
          async:false,
          url : "addOlders.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg,
               "weixin":"weixin"
          },
          success : function(data){
              if(data.result=="100"){
              	 alert("充值成功");
              }else{
                 alert("充值失败");
              }
          },
          error:function(){
	           alert("error");
          }
     });
}
    </script>

<body>
</body>
</html>