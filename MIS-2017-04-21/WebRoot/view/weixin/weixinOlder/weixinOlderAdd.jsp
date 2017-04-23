<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fsk.init.SystemInit"%>
<%
	String photourlMR = SystemInit.photourl;
%>
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
<style type="text/css">
.mdStyle {
	display: block;
	margin-top: 50px;
	background-color: #FFF
}
</style>
</head>

<body class="page-body">
	<!-- 顶部导航栏 -->
	<div class="page-header">
		<div class="navbar-brand">
			<a href="###" class="logo" id="backToGzlr"> <img src="weixinimages/AttentionFollowimages/back.png" width="25" alt="" class="hidden-xs" /> <img src="weixinimages/AttentionFollowimages/back.png" width="25" alt="" class="visible-xs" /> <span>新增关注老人</span> </a>
		</div>
		<div class="clearfix"></div>
	</div>
	<div>
		<table class="table">
			<tbody>
				<tr>
					<td>姓名<span style="color:red">*</span>
					</td>
					<td><input type="text" class="form-control" id="name_input">
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td><select class="form-control" id="sex_input">
							<option value="男">男</option>
							<option value="女">女</option>
					</select></td>
				</tr>
				<tr>
					<td>出生年月<span style="color:red">*</span>
					</td>
					<td><input type="date" class="form-control" size="10" id="birthDay_input" placeholder="YYYY-MM-DD">
					</td>
				</tr>
				<tr>
					<td>婚姻</td>
					<td><select class="form-control" id="hunyin_input">
							<option value="已婚">已婚</option>
							<option value="丧偶">丧偶</option>
							<option value="再婚">再婚</option>
							<option value="未婚">未婚</option>
							<option value="离婚">离婚</option>
							<option value="其他">其他</option>
					</select></td>
				</tr>
				<tr>
					<td>身份证号<span style="color:red">*</span>
					</td>
					<td><input type="text" class="form-control" id="identityId_input">
					</td>
				</tr>
				<tr id="IDCardPhotos1">
					<td>身份证正面</td>
					<td>&nbsp;<input type="hidden" value="" id="base_IDCard1"></td>
				</tr>
				<tr id="IDCardPhotos2">
					<td style="border:0;text-align:center;" colspan="2" onclick="chooseImage('IDCard1')">
						<img id="IDCard1" style="width:280px;height:157px;" src="photos/IDCardFront.png"/> 
					</td>
				</tr>
				<tr id="IDCardPhotos3">
					<td>身份证反面</td>
					<td>&nbsp;<input type="hidden" value="" id="base_IDCard2"></td>
				</tr>
				<tr id="IDCardPhotos4">
					<td style="border:0;text-align:center;" colspan="2" onclick="chooseImage('IDCard2')">
						<img id="IDCard2" style="width:280px;height:157px;" src="photos/IDCardSide.png"/>
					</td>
				</tr>
				<tr>
					<td>社保卡号</td>
					<td><input type="text" class="form-control" id="ssn_input">
					</td>
				</tr>
				<button data-toggle="modal" data-target="#addressModel" id="addOrEditAddressInformationModel" style="display:none;"></button>
				<tr>
					<td>户籍地址:</td>
					<td onclick="editAddressInformation('permanentAddress')"><input type="text" class="form-control" id="permanentAddress_input" readonly="readonly" style="background-color:white;">
					</td>
					<input type="hidden" value="" id="permanentAddress_provincePopup">
					<input type="hidden" value="" id="permanentAddress_cityPopup">
					<input type="hidden" value="" id="permanentAddress_areaPopup">
					<input type="hidden" value="" id="permanentAddress_streetPopup">
					<input type="hidden" value="" id="permanentAddress_villageCommitteePopup">
					<input type="hidden" value="" id="permanentAddress_roadPopup">
					<input type="hidden" value="" id="permanentAddress_lanePopup">
					<input type="hidden" value="" id="permanentAddress_numberPopup">
					<input type="hidden" value="" id="permanentAddress_roomPopup">
					<input type="hidden" value="" id="permanentAddress_specificAddressPopup">
					<input type="hidden" value="" id="permanentAddress_zipCodePopup">
				</tr>
				<tr>
					<td>居住地址</td>
					<td onclick="editAddressInformation('residentialAddress')"><input type="text" class="form-control" id="residentialAddress_input" readonly="readonly" style="background-color:white;">
					</td>
					<input type="hidden" value="" id="residentialAddress_provincePopup">
					<input type="hidden" value="" id="residentialAddress_cityPopup">
					<input type="hidden" value="" id="residentialAddress_areaPopup">
					<input type="hidden" value="" id="residentialAddress_streetPopup">
					<input type="hidden" value="" id="residentialAddress_villageCommitteePopup">
					<input type="hidden" value="" id="residentialAddress_roadPopup">
					<input type="hidden" value="" id="residentialAddress_lanePopup">
					<input type="hidden" value="" id="residentialAddress_numberPopup">
					<input type="hidden" value="" id="residentialAddress_roomPopup">
					<input type="hidden" value="" id="residentialAddress_specificAddressPopup">
					<input type="hidden" value="" id="residentialAddress_zipCodePopup">
				</tr>
				<tr>
					<td>收信地址</td>
					<td onclick="editAddressInformation('insideAddress')"><input type="text" class="form-control" id="insideAddress_input" readonly="readonly" style="background-color:white;">
					</td>
					<input type="hidden" value="" id="insideAddress_provincePopup">
					<input type="hidden" value="" id="insideAddress_cityPopup">
					<input type="hidden" value="" id="insideAddress_areaPopup">
					<input type="hidden" value="" id="insideAddress_streetPopup">
					<input type="hidden" value="" id="insideAddress_villageCommitteePopup">
					<input type="hidden" value="" id="insideAddress_roadPopup">
					<input type="hidden" value="" id="insideAddress_lanePopup">
					<input type="hidden" value="" id="insideAddress_numberPopup">
					<input type="hidden" value="" id="insideAddress_roomPopup">
					<input type="hidden" value="" id="insideAddress_specificAddressPopup">
					<input type="hidden" value="" id="insideAddress_zipCodePopup">
				</tr>
				<tr>
					<td>固定电话</td>
					<td><input type="number" class="form-control" onpaste="return false;" id="homeTel_input">
					</td>
				</tr>
				<tr>
					<td>手机号码<span style="color:red">*</span>
					</td>
					<td><input type="number" class="form-control" onpaste="return false;" onkeypress="keyPress()" id="telephone_input">
					</td>
				</tr>
				<tr>
					<td>生活状况</td>
					<td><select class="form-control" id="shzk_input">
							<option value="独居">独居</option>
							<option value="孤老">孤老</option>
							<option value="纯老">纯老</option>
							<option value="其他">其他</option>
					</select></td>
				</tr>
				<tr>
					<td>所属区域（省）</td>
					<td><select class="form-control" id="quyushen_input"></select></td>
				</tr>
				<tr>
					<td>所属区域（市）</td>
					<td><select class="form-control" id="quyushi_input"></select></td>
				</tr>
				<tr>
					<td>所属区域（区）</td>
					<td><select class="form-control" id="quyuqu_input"></select></td>
				</tr>
				<tr>
					<td>所属区域（街道）</td>
					<td><select class="form-control" id="quyujiedao_input"></select></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div style="text-align:center;margin-top:15px;">
		<button type="button" class="btn  btn-success" style="width:30%;margin-left:15px" onclick="save()">
			<span class="glyphicon glyphicon-ok"></span> 保存
		</button>
	</div>
	<input type="hidden" value="" id="wechatId_hide">
	<input type="hidden" value="" id="flag_hide">
	<input type="hidden" value="" id="serviceId_hide">

	<!-- 地址信息 -->
	<div class="modal fade" id="addressModel" style="margin-top: 50px;tabindex=" -1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="md-content" style="background-color: #FFF;padding-bottom:10px;margin:0px 15px;">
			<div class="modal-header" style="position: relative;">
				<h3 style="margin: 0px;">地址信息</h3>
				<button type="button" style="margin: 0px;position: absolute;top: 10px;right: 10px;" class="close md-close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<input type="hidden" value="" id="addressType">
			</div>
			<div class="modal-body ">
				<div class="row " style="font-size:12px">
					<div class="col-sm-4  col-xs-6" style="margin-bottom:6px">
						<select class="form-control" id="provincePopup"></select>
					</div>
					<div class="col-sm-4  col-xs-6" style="margin-bottom:6px">
						<select class="form-control" id="cityPopup"></select>
					</div>
					<div class="col-sm-4  col-xs-6" style="margin-bottom:6px">
						<select class="form-control" id="areaPopup"></select>
					</div>
					<div class="col-sm-4  col-xs-6" style="margin-bottom:6px">
						<input type="text" class="form-control" id="streetPopup" placeholder="街道">
					</div>
					<div class="col-sm-4  col-xs-6" style="margin-bottom:6px">
						<input type="text" class="form-control" id="villageCommitteePopup" placeholder="居委/村">
					</div>
					<div class="col-sm-4  col-xs-6" style="margin-bottom:6px">
						<input type="text" class="form-control" id="roadPopup" placeholder="路">
					</div>
					<div class="col-sm-4  col-xs-6" style="margin-bottom:6px">
						<input type="text" class="form-control" id="lanePopup" placeholder="弄">
					</div>
					<div class="col-sm-4  col-xs-6" style="margin-bottom:6px">
						<input type="text" class="form-control" id="numberPopup" placeholder="号">
					</div>
					<div class="col-sm-4  col-xs-6" style="margin-bottom:6px">
						<input type="text" class="form-control" id="roomPopup" placeholder="室">
					</div>
					<div class="col-sm-4  col-xs-12" style="margin-bottom:6px">
						<input type="text" class="form-control" id="specificAddressPopup" placeholder="具体地址">
					</div>
					<div class="col-sm-4  col-xs-6" style="margin-bottom:6px">
						<input type="text" class="form-control" id="zipCodePopup" placeholder="邮编">
					</div>
				</div>
			</div>
			<div class="modal-footer" style="padding: 0px 10px;">
				<button type="button" class="btn btn-primary btn-flat" data-dismiss="modal" onclick="saveAddressInformationModel()">保存</button>
				<button type="button" class="btn btn-default btn-flat md-close" data-dismiss="modal" id="closeAddressInformationModel">取消</button>
			</div>
		</div>
	</div>
	
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
	/**微信接口调用拍照功能模块**开始**/
	var appId = "";
	var timeStamp = ""; 
	var nonceStr = ""; 
	var signature = "";
	if("<%=request.getAttribute("flag")%>" == "longActingInsuranceAgent"){
		appId = "<%=request.getAttribute("appId")%>";
	    timeStamp = "<%=request.getAttribute("timeStamp")%>"; 
	    nonceStr = "<%=request.getAttribute("nonceStr")%>";
	    signature = "<%=request.getAttribute("signature")%>";

		//通过config接口注入权限验证配置,所有需要使用JS-SDK的页面必须先注入配置信息，否则将无法调用
		wx.config({
		    debug: false,
		    appId: appId,
		    timestamp:timeStamp,
		    nonceStr: nonceStr,
		    signature: signature,
		    jsApiList: [
		       'chooseImage',
		       'previewImage',
		       'uploadImage',
		       'downloadImage'
		    ]
		});
		//config信息验证失败会执行error函数，如签名过期导致验证失败
		//具体错误信息可以打开config的debug:true模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
		wx.error(function(res){
			alert(JSON.stringify(res));
		});
	}
	
	//config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后
	//config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口
	//则须把相关接口放在ready函数中调用来确保正确执行。
	//对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
	//wx.ready(function () {});
	  
	//全局图片数组
	var images = {
	   localId: [],
	   serverId: []
	};
	  
	//调起拍照功能
	function chooseImage(flag){
	   wx.chooseImage({
	      sizeType: ['compressed'],
	      success: function (res) {
	         images.localId = res.localIds;
	         $("#" + flag).attr("src",res.localIds);//拍照完毕，将本地图片地址赋值到img标签，页面显示图片
	         uploadImage(flag);//上传图片到微信服务器
	      }
	   });
	}
	  
	//上传图片到微信服务器
	function uploadImage(flag){
	   if (images.localId.length == 0) {
	      alert('请先使用选择图片');
	      return;
	   }
	   var i = 0, length = images.localId.length;
	   images.serverId = [];
	   function upload() {
	      wx.uploadImage({
	        localId: images.localId[i],
	        success: function (res) {
	          i++;
	          images.serverId.push(res.serverId);
	          if (i < length) {
	            upload();
	          }
	          //上传完成后得到微信服务器返回的图片id
	          var photoUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=" + "<%=request.getAttribute("access_token")%>" + "&media_id=" + res.serverId;
	          //存入微信服务器图片下载地址
	          $("#base_" + flag).val(photoUrl);
	          //downloadImage(flag);//从微信服务器下载图片
	        },
	        fail: function (res) {
	          alert(JSON.stringify(res));
	        }
	      });
	   }
	   upload();
	}
	  
	 /*  //  图片预览
	  function previewImage(){
	    wx.previewImage({
	      current: 'photos/av.png',
	      urls: [
	        'photos/av.png',
	        'photos/zhandian.png',
	      ]
	    });
	  }

	  // 从微信服务器下载图片
	  function downloadImage(flag){
	    if (images.serverId.length === 0) {
	      alert('请先使用 uploadImage 上传图片');
	      return;
	    }
	    var i = 0, length = images.serverId.length;
	    images.localId = [];
	    function download() {
	      wx.downloadImage({
	        serverId: images.serverId[i],
	        success: function (res) {
	          i++;
	          //alert('已下载：' + i + '/' + length);
	          images.localId.push(res.localId);
	          if (i < length) {
	            download();
	          }
	          //$("#" + flag).attr("src",res.localId);//赋值到页面对应图片位置
	          alert("down==" + $("#" + flag).attr("src"));
	        }
	      });
	    }
	    download();
	  } */
	  /**微信接口调用拍照功能模块**结束**/
</script>
</body>
</html>
<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/addressJS.js"></script>
<script type="text/javascript" src="js/mordo.tools/mordo.inputControl.js"></script>
<script type="text/javascript" src="js/mordo.tools/mordo.timeProcessing.js"></script>
<script type="text/javascript">
      /**页面初始化**开始**/
	  $(document).ready(function(){
		var flag = "<%=request.getAttribute("flag")%>";
		if(flag == "service"){//为服务下单页面跳转过来，此值为标记
			$("#flag_hide").val(flag);
			var serviceId = "<%=request.getAttribute("serviceId")%>";
			$("#serviceId_hide").val(serviceId);
			//设置返回路径
			$("#backToGzlr").attr("href", "<%=request.getContextPath()%>/" + "wechatReservationService.do?mainOrder&id=" + serviceId + "&flag2=1&weixin=weixin");  
		}else{//老人列表页跳转过来
			//设置返回路径
			$("#backToGzlr").attr("href", "<%=request.getContextPath()%>/" + "wechatOlder.do?main&flag=flag&weixin=weixin");  
		}
	
		//不是老人列表页长护险代理跳转过来，隐藏拍照功能
		if(flag != "longActingInsuranceAgent"){
			$("#IDCardPhotos1").hide();
			$("#IDCardPhotos2").hide();
			$("#IDCardPhotos3").hide();
			$("#IDCardPhotos4").hide();
		}
		
		var wechatId = "<%=request.getAttribute("wechatId")%>";
		if(wechatId != null && wechatId != ""){
			$("#wechatId_hide").val(wechatId);
		}
	
		//赋值传递的姓名和身份证
		var name = "<%=request.getAttribute("name")%>";
		if(name != null && name != ""){
			$("#name_input").val(name);
		}
		var olderNumberId = "<%=request.getAttribute("olderNumberId")%>";
		if(olderNumberId != null && olderNumberId != ""){
			$("#identityId_input").val(olderNumberId);
		}
		
		//主页面所属区域地址初始化
		//获取默认省  
        var result = new Array();
        result = getAddresses(4897);
        var html = "";
        for(var i = 0;i < result.length;i++){
        	html +="<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
        }
        $("#quyushen_input").html(html);
        //获取默认市
        getquyushixinxi($("#quyushen_input").val());
        //获取默认区
        getquyuquxinxi($("#quyushi_input").val());
        //获取默认街道
        getquyujiedaoxinxi($("#quyuqu_input").val());
        //省级下拉框改变事件
        $("#quyushen_input").change(function(e){
        	getquyushixinxi($("#quyushen_input").val());
        	getquyuquxinxi($("#quyushi_input").val());
        	getquyujiedaoxinxi($("#quyuqu_input").val());
        });
        //市级下拉框改变事件
        $("#quyushi_input").change(function(e){
        	getquyuquxinxi($("#quyushi_input").val());
        	getquyujiedaoxinxi($("#quyuqu_input").val());
        });
        //区级下拉框改变事件
        $("#quyuqu_input").change(function(e){
        	getquyujiedaoxinxi($("#quyuqu_input").val());
        });
		
		//地址弹出框地址信息初始化
		//设置省默认值
		var result = new Array();
        result = getAddresses(4897);
        var html = "";
        for(var i = 0;i < result.length;i++){
        	html +="<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
        }
        $("#provincePopup").html(html);
        //设置省级变化事件
		$("#provincePopup").change(function(e){
        	getquyushixinxiT($("#provincePopup").val());
        	getquyuquxinxiT($("#cityPopup").val());
        });
        //设置市级变化事件
        $("#cityPopup").change(function(e){
        	getquyuquxinxiT($("#cityPopup").val());
        });
      });
      /**页面初始化**结束**/
	
	
	  /**主页面所属区域地址方法**开始**/
	  //获取市信息
      function getquyushixinxi(id){
      	var result = new Array();
    	result = getAddresses(id);
        var html = "";
        for(var i = 0;i < result.length;i++){
        	html +="<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
        }
        $("#quyushi_input").html(html);
      }
      //获取区信息
      function getquyuquxinxi(id){
        var result = new Array();
    	result = getAddresses(id);
        var html = "";
        for(var i = 0;i < result.length;i++){
        	html +="<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
        }
        $("#quyuqu_input").html(html);
      }
      //获取街道信息
      function getquyujiedaoxinxi(id){
        var result = new Array();
    	result = getAddresses(id);
        var html = "";
        for(var i = 0;i < result.length;i++){
        	html +="<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
        }
        $("#quyujiedao_input").html(html);
      }
      /**主页面所属区域地址方法**结束**/
      
      
      /**弹出框地址方法**开始**/
      //地址弹出框获取市信息
      function getquyushixinxiT(id){
	      var result = new Array();
	      result = getAddresses(id);
	      var html = "";
	      for(var i = 0;i < result.length;i++){
	          html += "<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
	      }
	      $("#cityPopup").html(html);
      }
      //地址弹出框获取区信息
      function getquyuquxinxiT(id){
	      var result = new Array();
	      result = getAddresses(id);
	      var html = "";
	      for(var i = 0;i < result.length;i++){
	       	 html += "<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
	      }
	      $("#areaPopup").html(html);
      }
      /**弹出框地址方法**结束**/
      
      
    /**弹出框信息操作**开始**/
	//编辑地址信息
	function editAddressInformation(flag){
		$("#addressType").val(flag);
		var inputvalues = $("#" + flag + "_input").val();
		if(inputvalues == ""){//如果选择的那一项地址类型没有值，则初始化地址信息弹窗地址值
	        var result = new Array();
	        result = getAddresses(4897);
	        var html = "";
	        for(var i = 0;i < result.length;i++){
	        	html +="<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
	        }
	        $("#provincePopup").html(html);//获取默认省
	        getquyushixinxiT($("#provincePopup").val());//获取默认市
	        getquyuquxinxiT($("#cityPopup").val());//获取默认区
	        
	        $("#streetPopup").val("");
        	$("#villageCommitteePopup").val("");
        	$("#roadPopup").val("");
        	$("#lanePopup").val("");
        	$("#numberPopup").val("");
        	$("#roomPopup").val("");
        	$("#specificAddressPopup").val("");
        	$("#zipCodePopup").val("");
        }else{
        	$("#provincePopup").val($("#" + flag + "_provincePopup").val());
        	getquyushixinxiT($("#provincePopup").val());//获取默认市
        	$("#cityPopup").val($("#" + flag + "_cityPopup").val());
        	getquyuquxinxiT($("#cityPopup").val());//获取默认区
        	$("#areaPopup").val($("#" + flag + "_areaPopup").val());
        	$("#streetPopup").val($("#" + flag + "_streetPopup").val());
        	$("#villageCommitteePopup").val($("#" + flag + "_villageCommitteePopup").val());
        	$("#roadPopup").val($("#" + flag + "_roadPopup").val());
        	$("#lanePopup").val($("#" + flag + "_lanePopup").val());
        	$("#numberPopup").val($("#" + flag + "_numberPopup").val());
        	$("#roomPopup").val($("#" + flag + "_roomPopup").val());
        	$("#specificAddressPopup").val($("#" + flag + "_specificAddressPopup").val());
        	$("#zipCodePopup").val($("#" + flag + "_zipCodePopup").val());
        }
		$("#addOrEditAddressInformationModel").click();
	}
	//保存地址信息
	function saveAddressInformationModel(){
		var addressType = $("#addressType").val();
		$("#" + addressType + "_provincePopup").val($("#provincePopup").val());
		$("#" + addressType + "_cityPopup").val($("#cityPopup").val());
		$("#" + addressType + "_areaPopup").val($("#areaPopup").val());
		$("#" + addressType + "_streetPopup").val($("#streetPopup").val());
		$("#" + addressType + "_villageCommitteePopup").val($("#villageCommitteePopup").val());
		$("#" + addressType + "_roadPopup").val($("#roadPopup").val());
		$("#" + addressType + "_lanePopup").val($("#lanePopup").val());
		$("#" + addressType + "_numberPopup").val($("#numberPopup").val());
		$("#" + addressType + "_roomPopup").val($("#roomPopup").val());
		$("#" + addressType + "_specificAddressPopup").val($("#specificAddressPopup").val());
		$("#" + addressType + "_zipCodePopup").val($("#zipCodePopup").val());
		
		var html = "";
		html += $("#provincePopup").find("option:selected").text() + "," + $("#cityPopup").find("option:selected").text() + "," + $("#areaPopup").find("option:selected").text();
		if($("#streetPopup").val() != null && $("#streetPopup").val() != ""){
			html += "," + $("#streetPopup").val() + "街道";
		}
		if($("#villageCommitteePopup").val() != null && $("#villageCommitteePopup").val() != ""){
			html += "," + $("#villageCommitteePopup").val() + "居委/村";
		}
		if($("#roadPopup").val() != null && $("#roadPopup").val() != ""){
			html += "," + $("#roadPopup").val() + "路";
		}
		if($("#lanePopup").val() != null && $("#lanePopup").val() != ""){
			html += "," + $("#lanePopup").val() + "弄";
		}
		if($("#numberPopup").val() != null && $("#numberPopup").val() != ""){
			html += "," + $("#numberPopup").val() + "号";
		}
		if($("#roomPopup").val() != null && $("#roomPopup").val() != ""){
			html += "," + $("#roomPopup").val() + "室";
		}
		if($("#specificAddressPopup").val() != null && $("#specificAddressPopup").val() != ""){
			html += "," + $("#specificAddressPopup").val();
		}
		if($("#zipCodePopup").val() != null && $("#zipCodePopup").val() != ""){
			html += ",邮编" + $("#zipCodePopup").val();
		}
		$("#" + addressType + "_input").val(html);
		$("#closeAddressInformationModel").click();
	}
	/**弹出框信息操作**结束**/
      

     /**新增操作**开始**/
     //保存-新增老人
     function save(){
     	var flag = "<%=request.getAttribute("flag")%>";
     	var touxiangSrc = "<%=photourlMR %>" + "/photos/av.jpg";
     	var name_input = $("#name_input").val();//姓名
		if($.trim(name_input) == ""){
	 		alert("姓名必填");
	 		return;
		}
		var sex_input = $("#sex_input").val();//性别
		var birthDay_input = $.trim($("#birthDay_input").val());//出生年月
		if(birthDay_input != "" && birthDay_input != ""){
	 		birthDay_input = birthDay_input.split("-")[0]+birthDay_input.split("-")[1]+birthDay_input.split("-")[2];
	 		if(birthDay_input.length != 8){
	 			alert("出生年月格式错误");
	 			return;
	 		}
		}else{
			alert("出生年月必填"); 
        	return; 
		}
		var hunyin_input = $("#hunyin_input").val();//婚姻
		var identityId_input = $("#identityId_input").val();//身份证
		if($.trim(identityId_input) == ""){
	 		alert("身份证必填");
	 		return;
		}
		var reg = /(^\d{15}$)|(^\d{17}([0-9]|X)$)/; 
		if(!reg.test(identityId_input)){  
        	alert("身份证格式错误"); 
        	return; 
    	}
    	var ssn_input = $("#ssn_input").val();//社保卡号
		var homeTel_input = $("#homeTel_input").val();//固话
		var telephone_input = $.trim($("#telephone_input").val());//手机
		if(telephone_input == "" || telephone_input == null){  
        	alert("手机必填"); 
        	return; 
    	}
    	var shzk_input = $("#shzk_input").val();//生活状况
    	
    	
		var quyushen_input = $("#quyushen_input").val();//所属区域（省）
		var quyushi_input = $("#quyushi_input").val();//所属区域（市）
		var quyuqu_input = $("#quyuqu_input").val();//所属区域（区）
		var quyujiedao_input = $("#quyujiedao_input").val();//所属区域（街道）
		if(quyujiedao_input == null || quyujiedao_input == ""){
			quyujiedao_input = "0";
		}
		var customerSource_input = "商业";//客户来源
		var kehuzhuangtai_input = "2";//客户状态 0.正常 1.审核不通过  2.待评估
		
		var base_IDCard1 = $("#base_IDCard1").val();//身份证正面
		var base_IDCard2 = $("#base_IDCard2").val();//身份证反面
		
		var reqmsg = "{'action':'ADD_OLDER_INFO_REQUEST','content':{";
		reqmsg += "'mainPhoto':'" + touxiangSrc + "',";
		reqmsg += "'name':'" + name_input + "',";
		reqmsg += "'gender':'" + sex_input + "',";
		reqmsg += "'birthdate':'" + birthDay_input + "',";
		reqmsg += "'hunyin_input':'" + hunyin_input + "',";
		reqmsg += "'idnumber':'" + identityId_input + "',";
		reqmsg += "'ssn_input':'" + ssn_input + "',";
		reqmsg += "'homeTel':'" + homeTel_input + "',";
		reqmsg += "'mobileTel':'" + telephone_input + "',";
		
		reqmsg += "'olderAddressList':["
		if($.trim($("#permanentAddress_input").val()) != null && $.trim($("#permanentAddress_input").val()) != ""){//户籍地址已填写
			reqmsg += "{'addressType':1,";
			reqmsg += "'provinceId':" + $("#permanentAddress_provincePopup").val() + ",";
			reqmsg += "'cityId':" + $("#permanentAddress_cityPopup").val() + ",";
			reqmsg += "'areaId':" + $("#permanentAddress_areaPopup").val() + ",";
			reqmsg += "'street':'" + $("#permanentAddress_streetPopup").val() + "',";
			reqmsg += "'committeeVillage':'" + $("#permanentAddress_villageCommitteePopup").val() + "',";
			reqmsg += "'road':'" + $("#permanentAddress_roadPopup").val() + "',";
			reqmsg += "'lane':'" + $("#permanentAddress_lanePopup").val() + "',";
			reqmsg += "'number':'" + $("#permanentAddress_numberPopup").val() + "',";
			reqmsg += "'room':'" + $("#permanentAddress_roomPopup").val() + "',";
			reqmsg += "'address':'" + $("#permanentAddress_specificAddressPopup").val() + "',";
			reqmsg += "'zipCode':'" + $("#permanentAddress_zipCodePopup").val() + "'},";
		}
		if($.trim($("#residentialAddress_input").val()) != null && $.trim($("#residentialAddress_input").val()) != ""){//居住地址已填写
			reqmsg += "{'addressType':0,";
			reqmsg += "'provinceId':" + $("#residentialAddress_provincePopup").val() + ",";
			reqmsg += "'cityId':" + $("#residentialAddress_cityPopup").val() + ",";
			reqmsg += "'areaId':" + $("#residentialAddress_areaPopup").val() + ",";
			reqmsg += "'street':'" + $("#residentialAddress_streetPopup").val() + "',";
			reqmsg += "'committeeVillage':'" + $("#residentialAddress_villageCommitteePopup").val() + "',";
			reqmsg += "'road':'" + $("#residentialAddress_roadPopup").val() + "',";
			reqmsg += "'lane':'" + $("#residentialAddress_lanePopup").val() + "',";
			reqmsg += "'number':'" + $("#residentialAddress_numberPopup").val() + "',";
			reqmsg += "'room':'" + $("#residentialAddress_roomPopup").val() + "',";
			reqmsg += "'address':'" + $("#residentialAddress_specificAddressPopup").val() + "',";
			reqmsg += "'zipCode':'" + $("#residentialAddress_zipCodePopup").val() + "'},";
		}
		if($.trim($("#insideAddress_input").val()) != null && $.trim($("#insideAddress_input").val()) != ""){//收信地址已填写
			reqmsg += "{'addressType':2,";
			reqmsg += "'provinceId':" + $("#insideAddress_provincePopup").val() + ",";
			reqmsg += "'cityId':" + $("#insideAddress_cityPopup").val() + ",";
			reqmsg += "'areaId':" + $("#insideAddress_areaPopup").val() + ",";
			reqmsg += "'street':'" + $("#insideAddress_streetPopup").val() + "',";
			reqmsg += "'committeeVillage':'" + $("#insideAddress_villageCommitteePopup").val() + "',";
			reqmsg += "'road':'" + $("#insideAddress_roadPopup").val() + "',";
			reqmsg += "'lane':'" + $("#insideAddress_lanePopup").val() + "',";
			reqmsg += "'number':'" + $("#insideAddress_numberPopup").val() + "',";
			reqmsg += "'room':'" + $("#insideAddress_roomPopup").val() + "',";
			reqmsg += "'address':'" + $("#insideAddress_specificAddressPopup").val() + "',";
			reqmsg += "'zipCode':'" + $("#insideAddress_zipCodePopup").val() + "'}";
		}
		reqmsg += "],"
		
		reqmsg += "'serviceProvinceId':" + quyushen_input + ",";
		reqmsg += "'serviceCityId':" + quyushi_input + ",";
		reqmsg += "'serviceAreaId':" + quyuqu_input + ",";
		reqmsg += "'serviceStreetId':" + quyujiedao_input + ",";
		reqmsg += "'memberSource':'" + customerSource_input + "',";
		reqmsg += "'memberStatus':" + kehuzhuangtai_input + ",";
		reqmsg += "'livingCondition':'" + shzk_input + "',";
		
		if(flag == "longActingInsuranceAgent"){//老人列表页长护险代理跳转过来,来源是长护险代理3
			reqmsg += "'source':3,";
			reqmsg += "'idFront':'" + base_IDCard1 + "',";
			reqmsg += "'idBack':'" + base_IDCard2 + "',";
		}else{
			reqmsg += "'source':2,";//类型是微信新增
		}
		reqmsg +="'accountNum':0,";
	
		
		reqmsg = reqmsg.substr(0,reqmsg.length-1);
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
              if(data.result == "100"){
              	alert("新增老人成功");
                var flag = concernedOlder(data.content.id);
                if(flag == 0){
                	alert("绑定关联老人失败");
                	return;
                }
                var url = ""
                if($("#flag_hide").val() == "1"){//为服务下单页面跳转过来，此值为标记,返回服务下单页面
                	var serviceId = $("#serviceId_hide").val();
                	url = "<%=request.getContextPath()%>" + "/wechatReservationService.do?mainOrder&id=" + serviceId + "&flag2=1&weixin=weixin";
                }else{//为老人关注列表跳转过来，返回老人关注列表页面
                	url = "<%=request.getContextPath()%>" + "/wechatOlder.do?main&flag=flag&weixin=weixin";
                }
				window.location.replace(url);
              }else if(data.result == "200"){
              	 if(data.des == "failure"){
              	 	alert("新增老人失败");
              	 }else{
                 	alert(data.des);
              	 }
              }
          },
          error:function(){
	           alert("新增老人失败");
          }
     	});
    }
	//新增后关注绑定老人
	function concernedOlder(id){
		var wechatId = $("#wechatId_hide").val();
		var flag = 0;
		var reqmsg = "{'action':'ADD_OLDER_WECHAT_INFO_REQUEST','content':{";
	
		reqmsg += "\"olderId\":" + id + ",";
		reqmsg += "\"wechatId\":" + wechatId + ",";
		reqmsg += "\"addTime\":\"" + getCurrentTime() + "\",";
		
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
              	if(data.result == "100"){
              		flag = 1;
              	}else{
                 	//alert("绑定关联老人失败");
              	}
         	},
          	error:function(){
	           	//alert("绑定关联老人失败");
          	}
     	});
		return flag;
	}
	/**新增操作**结束**/
</script>