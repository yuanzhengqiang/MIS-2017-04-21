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
<title>充值</title>
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
@media screen and (max-width:172px){
    html{font-size:35%;}
    }
@media screen and (min-width:173px) and (max-width:230px){
    html{font-size:38%;}
    }
@media screen and (min-width:231px) and (max-width:270px){
    html{font-size:42%;}
    }
@media screen and (min-width:270px) and (max-width:321px){
    html{font-size:50%}
    }

    @media screen and (min-width:321px) and (max-width:410px){
        html{font-size:60%}
    }

    @media screen and (min-width:410px)and (max-width:480px){
        html{font-size:70%}
    }
    @media screen and (min-width:480px)and (max-width:768px){
        html{font-size:80%}
    }   
    @media screen and (min-width:768px){
        html{font-size:90%}
    }
</style>
</head>

<body style="background:#eee">
	<div class="fixedTOP ">		
		<h3>充值</h3>
		
		<a href="###" class="logo" id="backToGzlr">
          <span class="glyphicon glyphicon-chevron-left" id=""></span>
        </a>
		
	</div>
		<div class="form-group" style="margin-top: 8rem;padding:2rem 3rem 1rem 3rem;text-align: center; background-color: #fff; height:auto">
            <div style="text-align:left; height:auto">
                <div style="float:left">
                	<img src="weixinimages/chongzhi.png" style="width: 4rem;height: 4rem;margin-right: 1rem;margin-top: 0.5rem;">
                </div>
                <div style="float:left">
                   <p style="font-size:1.5rem; margin-bottom: rem">微信支付</p>
                    <p style="font-size:1rem; color:#515151">已开通微信钱包的用户使用</p> 
                </div>
            </div>
            <div style="border-top: 1px solid #CCC; height:auto; text-align:left; clear:both; padding-top:1rem; height:auto">
               <p style="margin-top:0.5rem"> <label style=" font-size:1.6rem; margin-right:1.5rem">金额(￥)</label><input style="width: 15rem; height:3rem; border:none; border-left:1px #ccc solid; font-size:1.5rem" type="text" name="jine" id="money_cz" onpaste="return false;" onkeypress="keyPress()" placeholder=" 请输入充值金额"></p>
            </div>
        </div>
        
		
 
 		<div  style="text-align:center;margin-top:1em" >
            <button type="button" class="btn btn-primary " style="width:80% ;background-color: #34A3FF" onclick="chongzhi()">下一步</button>
        </div>
		
<script type="text/javascript">
	//只能输入数字0-9
        function keyPress() {
            /* var keyCode = event.keyCode;
            if ((keyCode >= 48 && keyCode <= 57)) {
                event.returnValue = true;
            } else {
                event.returnValue = false;
            } */
            var keyCode = event.keyCode;
            if ((keyCode >= 48 && keyCode <= 57) || keyCode == 46) {
                event.returnValue = true;
            } else {
                event.returnValue = false;
            }
        } 
        
	$(document).ready(function(){
		var olderId = "<%=request.getAttribute("olderId")%>";
    	$("#backToGzlr").attr("href","<%=request.getContextPath()%>/" + "wechatYuE.do?mainBalance&olderId=" + olderId + "&weixin=weixin");
    	
		
	});
	
	function chongzhi(){
		var total_fee = $("#money_cz").val();
		if(total_fee == "" || total_fee == null){
			alert("请填写充值金额");
			return;
		}
		/* var reg1 = new RegExp("^(0|[1-9][0-9]*)$");  
		if(!reg1.test(total_fee)){
			alert("请填写正确的金额");
			return;
		} */
		var reg2 = new RegExp("^[0-9]+(.[0-9]{1,2})?$");  
		if(!reg2.test(total_fee)){ 
        	alert("请填写正确的金额");
			return;
    	}
		
        var olderId = "<%=request.getAttribute("olderId")%>";
		var path="<%=request.getContextPath()%>";
		
        var url=path+"/wechatYuE.do?mainPay&weixin=weixin&olderId="+olderId + "&total_fee=" + total_fee;
        window.location.replace(url);
	}
</script>
	
</body>
</html>
