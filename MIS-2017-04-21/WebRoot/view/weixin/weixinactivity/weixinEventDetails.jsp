<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<title>活动详情</title>
</head>
<body style="background-image: url(wechatImg/firstBackground.jpg);background-size: 100%;">
	<div>
		<label>我的邀请码</label><label><%=request.getAttribute("invitationCode") %></label>
	</div>
	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
</body>
</html>