<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="shortcut icon" href="images/logo.png">

	<title>体检订单详情</title>

	<!-- Bootstrap core CSS -->
	<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="js/jquery.gritter/css/jquery.gritter.css" />

	<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="../../assets/js/html5shiv.js"></script>
	  <script src="../../assets/js/respond.min.js"></script>
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="js/jquery.nanoscroller/nanoscroller.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.select2/select2.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.slider/css/slider.css" />
  <link rel="stylesheet" type="text/css" href="js/jquery.niftymodals/css/component.css" />
  <link href="js/jquery.icheck/skins/square/blue.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="js/dropzone/css/dropzone.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap.summernote/dist/summernote.css" />

  <link rel="stylesheet" href="js/jquery.crop/css/jquery.Jcrop.css" type="text/css" />
  
    <link rel="stylesheet" type="text/css" href="js/jquery.magnific-popup/dist/magnific-popup.css" />
    
	<link href="css/style.css" rel="stylesheet" />	
<style>
.control-label0{padding-top:7px;}
#picpreview>div{margin-top:5px; position:relative}
#picpreview .pichidediv{ position:absolute;bottom:0;width:100%;display:none;height:50px;background:#fff;opacity: 0.9; filter: alpha(opacity=90);}
#picpreview .pichidediv div { position:absolute;left:10px;top:7px;}
#picpreview .pichidediv div p{line-height:13px}
#picpreview .pichidediv button{position:absolute;right:40px;top:10px;}
#picpreview>div:hover .pichidediv{display:block}


.TPhide{display:none}
.gallery-cont .item {
    width:100% !important;} 
</style>
<script type="text/javascript" src="js/addressJS.js"></script>
</head>

<body>	
<div class="navbar-fixed-top">
	<div id="head-nav" class=""> 
        <div class="block-flat" style="padding-bottom:0;margin-bottom: 0px;">
          <div class="row">
            <div class="col-sm-8">
              <div >
                <h2 id="head_fuName">体检订单详情</h2>
              	<ol class="breadcrumb" style="padding:0;background:#fff;">
					<li>订单信息</li>
					<li >体检订单管理</li>
					<li class="active">体检订单详情</li>
				</ol>
               </div>
            </div>
            <div class="col-sm-4" style="text-align:right;padding-top:10px">
				<button class="btn btn-primary" onclick="save()">保存</button>
				<input type="hidden" id="hide_xmId">
            </div>
          </div>
        </div>
	</div>
</div>
<div id="cl-wrapper1" style="overflow:hidden;padding-top: 100px;">	
<div class="cl-mcont" style="padding: 15px 0px;">
<div class="block-flat" >
<div class="row" style="margin-top:0">
<div class="col-sm-12">
<form class="form-horizontal group-border-dashed">
	 <div class="form-group">
                <div class="row">  
                	<div class="col-sm-2 col-md-2 col-lg-1" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">订单编号</div>
					<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
                		<label style="height:34px;line-height: 34px;">123154645</label>
					</div> 
					<div class="col-sm-2 col-md-2 col-lg-1" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">总价格</div>
					<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
                		<label style="height:34px;line-height: 34px;">123154645元</label>
					</div>
					<div class="col-sm-2 col-md-2 col-lg-1" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">服务费</div>
					<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
                		<label style="height:34px;line-height: 34px;">123154645元</label>
					</div> 
					<div class="col-sm-2 col-md-2 col-lg-1" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">是否已付款</div>
					<div class="col-sm-4 col-md-4 col-lg-2">
                		<label style="height:34px;line-height: 34px;">是</label>
					</div> 
					<div class="col-sm-2 col-md-2 col-lg-1" style="padding-left: 15px;padding-right: 0px;">下单客户</div>
					<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
                		<label style="height:34px;line-height: 34px;">张三</label>
					</div>  
					<div class="col-sm-2 col-md-2 col-lg-1" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">医院</div>
					<div class="col-sm-4 col-md-4 col-lg-2">
                		<label style="height:34px;line-height: 34px;">甲医院</label>
					</div>
					<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;">体检人姓名</div>
					<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
                		<input type="text" class="form-control"  id="xmname_input">
					</div>
					<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;">体检人身份证号</div>
					<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
                		<input type="text" class="form-control"  id="xmname_input">
					</div> 
					<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;" >体检人性别</div>
					<div class="col-sm-4 col-md-4 col-lg-2">
                		<select class="form-control" id="xm_leibie_input" style="margin-bottom:5px">
                			<option value=""></option>
                			<option value="1">男</option>
                			<option value="0">女</option>
                		</select>
					</div> 
					<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;">联系方式</div>
					<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
                		<input type="text" class="form-control"  id="xmname_input">
					</div> 
					<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;" >报告状态</div>
					<div class="col-sm-4 col-md-4 col-lg-2">
                		<select class="form-control" id="xm_leibie_input" style="margin-bottom:5px">
                			<option value=""></option>
                			<option value="1">已生成</option>
                			<option value="2">已寄出</option>
                		</select>
					</div> 
					<div class="col-sm-2 col-md-2 col-lg-1" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">报告生成时间</div>
					<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
                		<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;">
						<span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
						<input class="form-control" size="16" value="" readonly="" type="text" id="startTime" placeholder="开始时间">
						<span class="input-group-btn"><button class="btn btn-danger deleteThisTime" type="button"><span class="fa fa-times"></span></button></span>
					</div>
					</div>
					<div class="col-sm-2 col-md-2 col-lg-1" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">完整体验报告</div>
					<div class="col-sm-4 col-md-4 col-lg-2">
                		<a href="#" id="downloadFile" target="_blank" style="margin-bottom: 0px !important; height: 34px;margin-left:0;line-height:34px;">点击下载</a>
					</div>
					
                </div>
              </div>
              <div class="form-group" id="xmjianjie_input">               
                <div class="row"> 
                <div class="col-sm-12 " ><strong>体检报告内容</strong></div>
	                <div class="col-sm-12 " >
	                	<div class="content">
							<div class="form-group" style="padding-top:0;">
								<div id="xmjianjie"></div>
							</div>
						</div>
	                </div>
                </div>
              </div>
              </form>
</div>
</div>
</div></div>				
	
</div> 
<!-- 主页面结束 -->

	<div class="md-overlay"></div>


	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
	<script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/jquery.select2/select2.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.gritter/js/jquery.gritter.js"></script>
  	<script type="text/javascript" src="js/jquery.niftymodals/js/jquery.modalEffects.js"></script>   
  
  	<script type="text/javascript" src="js/masonry.js"></script>
  
  	<script type="text/javascript" src="js/jquery.crop/js/jquery.Jcrop.js"></script>
	<script src="js/ckeditor/ckeditor.js"></script>
	<script src="js/ckeditor/adapters/jquery.js"></script>
  	<script type="text/javascript" src="js/bootstrap.summernote/dist/summernote.min.js"></script>
  	<script type="text/javascript" src="js/bootstrap.wysihtml5/lib/js/wysihtml5-0.3.0.js"></script>
 	 <script type="text/javascript" src="js/bootstrap.wysihtml5/src/bootstrap-wysihtml5.js"></script>

  	<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
  	<script src="js/jquery.upload/js/jquery.iframe-transport.js"></script>
  	<!-- The basic File Upload plugin -->
  	<script src="js/jquery.upload/js/jquery.fileupload.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
	<script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
	<script type="text/javascript" src="js/dropzone/dropzone.js"></script>

	<script type="text/javascript" src="js/jquery.magnific-popup/dist/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript">
   $(document).ready(function(){
    	$(".deleteThisTime").click(function(){               //清除日期框中的值
   	       $(this).parent().prev()[0].value = "";
   	    });
        App.init();
        App.textEditor();
        var homeUrl = "<%=request.getContextPath()%>" + "/welcome.do?main";
  		$(".navbar-brand").attr("href",homeUrl);
       // $('#some-textarea').wysihtml5();
        $('#xmjianjie').summernote({
        	height:300
        });
        
      	//获取默认服务项目类别
        getfuwuxmlb(5187);
        
        var id="<%=request.getAttribute("id")%>";
        if(id != null && id != ""){//编辑页
        	$("#xmbh_auto").attr("style","");
        	query(id);
        }
        
        //Initialize Mansory
      var $container = $('.gallery-cont');
      // initialize
      $container.masonry({
        columnWidth: 0,
        itemSelector: '.item'
      });
      
      //Resizes gallery items on sidebar collapse
      $("#sidebar-collapse").click(function(){
          $container.masonry();      
      });
      
      //MagnificPopup for images zoom
      $('.image-zoom').magnificPopup({ 
        type: 'image',
        mainClass: 'mfp-with-zoom', // this class is for CSS animation below
        zoom: {
        enabled: true, // By default it's false, so don't forget to enable it

        duration: 300, // duration of the effect, in milliseconds
        easing: 'ease-in-out', // CSS transition easing function 

        // The "opener" function should return the element from which popup will be zoomed in
        // and to which popup will be scaled down
        // By defailt it looks for an image tag:
        opener: function(openerElement) {
          // openerElement is the element on which popup was initialized, in this case its <a> tag
          // you don't need to add "opener" option if this code matches your needs, it's defailt one.
          var parent = $(openerElement).parents("div.img");
          return parent;
        }
        }

      });
       setTimeout("tztpys()",500);
    });
   
        //只能输入数字0-9
        function keyPress() {
            var theEvent = window.event || arguments.callee.caller.arguments[0];
    		var keyCode = theEvent.keyCode || theEvent.which;
    		if ((keyCode < 48 || keyCode > 57) && keyCode != 8 && keyCode != 37 && keyCode != 39) {
               theEvent.preventDefault();
            }
        } 
        //限制输入数字，且小数点保留两位
        function keyPress2() {
            var theEvent = window.event || arguments.callee.caller.arguments[0];
    		var keyCode = theEvent.keyCode || theEvent.which;
    		if ((keyCode < 48 || keyCode > 57) && keyCode != 8 && keyCode != 46 && keyCode != 37 && keyCode != 39) {
               theEvent.preventDefault();
            }
        } 
        
        //保存服务项目信息，有id新增，无id编辑
        function save(){
            var reg1 = new RegExp("^[0-9]+(.[0-9]{1,2})?$");
            //var reg2 = new RegExp("^(0|[1-9][0-9]*)$"); 
			var xmname_input = $("#xmname_input").val();
			if($.trim(xmname_input) == ""){
			 	alert("项目名称必填");
			 	return;
			}
			var xm_leibie_input = $("#xm_leibie_input").val();
			var xmzt_input = $("#xmzt_input").val();
			var xmyibao_input = $("#xmyibao_input").val();
			if($.trim(xmyibao_input) == ""){
			 	alert("医保单价必填");
			 	return;
			}
			if(!reg1.test(xmyibao_input)){ 
        		alert("请输入符合规范的医保单价!");
        		return;
    	 	}
			var xmshichang_input = $("#xmshichang_input").val();
			if($.trim(xmshichang_input) == ""){
			 	alert("市场单价必填");
			 	return;
			}
			if(!reg1.test(xmshichang_input)){ 
        		alert("请输入符合规范的市场单价!");
        		return;
    	 	}
			var xmdanwei_input = $("#xmdanwei_input").val();
			if($.trim(xmdanwei_input) == ""){
			 	alert("单位必填");
			 	return;
			}
			var xmsfsm_input = $("#xmsfsm_input").val();
			
			var xmkfwsj_input = $("#xmkfwsj_input").val();
			
			var xmsxry_input = $("#xmsxry_input").val();
			var xmbeizhu_input = $("#xmbeizhu_input").val();
	
			var hide_xmId = $("#hide_xmId").val();
			var reqmsg="{'action':'ADD_SERVICE_INFO_REQUEST','content':{";
			
			if (hide_xmId != null && hide_xmId != "") {//编辑
    		    reqmsg += "\"id\":" + hide_xmId + ",";
			}else{
				reqmsg += "\"deleted\":0,";
			}
			if (xmname_input != null && xmname_input != "") {
    		    reqmsg += "\"name\":\"" + xmname_input + "\",";
			}
    		if (xm_leibie_input != null && xm_leibie_input != "") {
    		    reqmsg += "\"typeId\":" + xm_leibie_input + ",";
			}
    		if (xmzt_input != null && xmzt_input != "") {
       			reqmsg += "\"status\":" + xmzt_input + ",";
			}
   		    if (xmyibao_input != null && xmyibao_input != "") {
        		reqmsg += "\"medicalPrice\":" + xmyibao_input + ",";
			}
    		if (xmshichang_input != null && xmshichang_input != "") {
        		reqmsg += "\"marketPrice\":" + xmshichang_input + ",";
			}
    		if (xmdanwei_input != null && xmdanwei_input != "") {
        		reqmsg += "\"unit\":\"" + xmdanwei_input + "\",";
			}
    		if (xmsfsm_input != null && xmsfsm_input != "") {
        		reqmsg += "\"goDoor\":" + xmsfsm_input + ",";
			}
    		if (xmkfwsj_input != null && xmkfwsj_input != "") {
        		reqmsg += "\"serviceTimes\":\"" + xmkfwsj_input + "\",";
			}
    		if (xmsxry_input != null && xmsxry_input != "") {
        		reqmsg += "\"needPerosn\":\"" + xmsxry_input + "\",";
			}
    		if (xmbeizhu_input != null && xmbeizhu_input != "") {
    			xmbeizhu_input = JSON.stringify(xmbeizhu_input);
        		reqmsg += "\"des\":" + xmbeizhu_input + ",";
			}else{
				reqmsg += "\"des\":\"\",";
			}
			reqmsg += "\"createTime\":\"" + getNowFormatDate2() + "\",";
			var xmjianjieHtml = $("#xmjianjie").code();
			//xmjianjieHtml = xmjianjieHtml.replace(/\"/g, "'");
			if(xmjianjieHtml != null && xmjianjieHtml != ""){
				xmjianjieHtml = JSON.stringify(xmjianjieHtml);
				//if(xmjianjieHtml.length > 3000){
				//	alert("字数过长，请重新输入");
				//	return;
				//}
				reqmsg += "\"profile\":" + xmjianjieHtml + ",";
			}else{
				reqmsg += "\"profile\":\"" + xmjianjieHtml + "\",";
			}
			
			var fuwuzixiangList = $("#fuwuzixiang tr");
			if(fuwuzixiangList.length > 1){//有服务子项
				reqmsg += "\"serviceChildList\":[";
				for(var i = 0;i<fuwuzixiangList.length-1;i++){
					reqmsg +="{\"name\":\"" + $("#fuwuzixiang").find("tr:eq("+i+")").find("td:eq(0)").html() + "\"},";
				}
				reqmsg +="],";	
			}
			
			var tupianFlag = 0;
			for(var i=1;i<7;i++){
				if($("#hide_tupian"+i).val() != null && $("#hide_tupian"+i).val() != ""){
					tupianFlag ++;
				}
			}
			if(tupianFlag != 0){
				tupianFlag = 1;
				reqmsg += "\"servicePhotoList\":[";
				for(var i=1;i<7;i++){
					if($("#hide_tupian"+i).val() != null && $("#hide_tupian"+i).val() != ""){
						reqmsg += "{\"photoUrl\":\"" + $("#hide_tupian"+i).val() + "\",";
						reqmsg += "\"showIndex\":" + tupianFlag + "},";
						tupianFlag++;
					}
				}
				reqmsg += "],";
			}
			
			reqmsg += "}}";
			
			jQuery.ajax({
          		type : "post",
          		async:true,
          		url : "service.do?handler",
          		dataType : "json",
          		data: {
          		     "reqmsg":reqmsg
          		},
         		 success : function(data){
          		    if(data.des=="success"){
           		   	alert("保存成功");
           		   	var id=data.content.id;
           		   	var path="<%=request.getContextPath()%>";
           		   	var url=path+"/service.do?mainXQ&id="+id;
          		   	window.location.replace(url);
            		}else if(data.des=="failure"){
            		     alert("保存失败");
            		}else{
            		  	alert(data.des);
            		}
          		},
          		error:function(){
	      		     alert("error");
         		 }
    		 });
  }
  
   //保存服务项目子项信息-静态
   function savefwzx(){
		 if($("#tc_fwzx").val() == "" || $("#tc_fwzx").val() == null){
        	alert("请输入服务子项!");
        	return;
		 }
		 var newhtml = '<tr><td>'+ $("#tc_fwzx").val() +'</td><td style=\"text-align:right\"><a class="label label-default" onclick="editzixiang(this)"><i class="fa fa-pencil"></i></a> <a class="label label-danger" onclick="$(this).parent().parent().remove();"><i class="fa fa-times"></i></a></td></tr>';
		 $(newhtml).insertBefore("#smcharu");
    	 $("#cancalOrClose").click();
 	}
	//编辑服务项目子项信息-静态
	function editzixiang(par){
		$("#tc_fwzx").val($(par).parent().prev().text());
		$("#quedingmeitianjia").show();
		$("#tianjiameiqueding").hide();
		$("#fake-add-zixiang").click();
		document.getElementById("quedingmeitianjia").onclick = function(){			
			$(par).parent().prev().text($("#tc_fwzx").val());
		}
	}
	//获取当前时间return yyyymmddhhmmss
function getNowFormatDate2() {
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var strHour = date.getHours();
    var strMinutes = date.getMinutes();
    var strSeconds = date.getSeconds();
    
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if (strHour >= 0 && strHour <= 9) {
        strHour = "0" + strHour;
    }
    if (strMinutes >= 0 && strMinutes <= 9) {
        strMinutes = "0" + strMinutes;
    }
    if (strSeconds >= 0 && strSeconds <= 9) {
        strSeconds = "0" + strSeconds;
    }
    var currentdate = date.getFullYear() + "" + month + "" + strDate + "" + strHour + "" + strMinutes + "" + strSeconds;
    return currentdate;
}
	
	//查询服务项目详细信息
	function query(id){
		  var reqmsg="{'action':'QUERY_SERVICE_INFO_REQUEST','content':{\"serviceChildListShow\":\"true\",\"servicePhotoListShow\":\"true\",\"id\":"+id+"}}";
		
		  jQuery.ajax({
          type : "post",
          async:false,
          url : "service.do?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg
          },
          success : function(data){
              if(data.des=="success"){
              		if(data.content != null) {
              			$("#head_fuName").html(data.content.name);
              			$("#hide_xmId").val(data.content.id);
              			$("#xmbh_input").val(data.content.code);
              			$("#xmname_input").val(data.content.name);
              			$("#xm_leibie_input").val(data.content.typeId);
              			$("#xmzt_input").val(data.content.status);
              			$("#xmyibao_input").val(data.content.medicalPrice);
              			$("#xmshichang_input").val(data.content.marketPrice);
              			$("#xmdanwei_input").val(data.content.unit);
              			$("#xmsfsm_input").val(data.content.goDoor);
              			$("#xmkfwsj_input").val(data.content.serviceTimes);
              			$("#xmsxry_input").val(data.content.needPerosn);
              			$("#xmbeizhu_input").val(data.content.des);
              			var xmjianjieHtml = data.content.profile;
              			//xmjianjieHtml = xmjianjieHtml.replace(/\'/g, "\"");
              			$("#xmjianjie").code(xmjianjieHtml);
              			//子项列表
 						if(data.content.serviceChildList != null && data.content.serviceChildList.length > 0){
 							var htmlfuwuzixiangList="";
 							for(var i=0;i < data.content.serviceChildList.length;i++){
 								htmlfuwuzixiangList +="<tr>";
								htmlfuwuzixiangList +="<td>"+data.content.serviceChildList[i].name+"</td>";
								htmlfuwuzixiangList +="<td style=\"text-align:right\"><a class=\"label label-default\" onclick=\"editzixiang(this)\"><i class=\"fa fa-pencil\"></i></a> <a class=\"label label-danger\" onclick=\"$(this).parent().parent().remove();\"><i class=\"fa fa-times\"></i></a></td>";				
								htmlfuwuzixiangList +="</tr>";
 							}
 							htmlfuwuzixiangList +="<tr id=\"smcharu\">";
							htmlfuwuzixiangList +="<td> </td>";	
							htmlfuwuzixiangList +="<td style=\"text-align:right\"><a class=\"label label-primary\" onclick=\"$('#tianjiameiqueding').show();$('#quedingmeitianjia').hide();$('#add-zixiang input').val('');$('#ycpsList_hide').click();\"><i class=\"fa fa-plus\"></i></a></td>";				
							htmlfuwuzixiangList +="</tr>";
							$("#fuwuzixiang").html(htmlfuwuzixiangList);
 						}
 						//图片
 						if(data.content.servicePhotoList != null && data.content.servicePhotoList != ""){
							jQuery.each(data.content.servicePhotoList, function(i, item) {
								$("#Fptphoto"+(i+1)).removeClass("TPhide");
								$("#Fptphoto"+(i+1)).attr("name","show");
								$("#ptphoto"+(i+1)).attr("src",item.photoUrl + "?random=" + Math.random());
								$("#hide_tupian"+(i+1)).val(item.photoUrl);
								if(i == 5){
									$("#Fptphoto_add").attr("style","display:none;");
								}
								
								$("#Bigptphoto"+(i+1)).attr("href", item.photoUrl + "?random=" + Math.random());//设置大图
								$("#bianjiTP"+(i+1)).attr("onclick","uploadPic2('" + (i+1) + "')");
					
							});
							tztpys();
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
	
	 function tztpys(){
 		var i =  $("#ptphoto1").height();
 		if(i !=0){
 			 i += 100;
  			 $("#Fptphoto1").css("height",i+"px");
 		 }
   }
   
	//图片////////////////////////////////////////
	//添加图片
	function addtupian(){
		var weizhi = 1;
		for(var i=1;i<7;i++){
			if($("#Fptphoto"+i).attr("name") == "hide"){
				weizhi = i;
				break;
			}
		}
		$("#weizhiId").val(weizhi);
		$("#pic4upload"+weizhi).val("");
		$("#pic4upload"+weizhi).click();

	}
	//上传图片
	function uploadPic2(weizhi) {
		$("#pic4upload"+weizhi).click();
	}
	 //上传图片
	function uploadPic(weizhi) {
		$("#weizhiId").val(weizhi);
		var currPic = $("#pic4upload"+weizhi).val();
		if (currPic != null && currPic != "") {
			var ajax_option = {
				async:false,
				data:{},
				success:function(data) {
					if (data != null && data != "") {
						$("#srcPath").val(data); 
						//$("#touxiangId2").attr("src", data);  //将当前图片设为上传的图片
						openImagejsp(data);
					} else {
						alert("图片上传失败");
					}
				}
			};
			$("#picuploadform"+weizhi).ajaxSubmit(ajax_option);
		} else {
			//alert("请选择图片");
		}
	}
	//打开图片控件页面
	function openImagejsp(data){
		window.open ("view/imageCut/jquery-image-cut/image.jsp?"+data, "newwindow", "height=550, width=1100, top=200, left=450, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
	}
	 //上传裁剪后图片
	function uploadPic_cut() {
			var weizhi = $("#weizhiId").val();
			var ajax_option = {
				async:false,
				data:{},
				success:function(data) {
					if (data != null && data != "") {
						var result = JSON.parse(data);
						$("#Fptphoto"+weizhi).removeClass("TPhide");
					 	$("#Fptphoto"+weizhi).attr("name","show");
						if(weizhi == 6){
							$("#Fptphoto_add").attr("style","display:none;");
						}
						$("#hide_tupian"+weizhi).val(result.base64);
						$("#ptphoto"+weizhi).attr("src", result.url);  //将当前图片设为上传的图片
						$("#Bigptphoto"+weizhi).attr("href", result.url);//设置大图
						
						$("#tpTitle"+weizhi).html($("#photoTitle").val());
						$("#tpmiaoshu"+weizhi).html($("#photoDes").val());
						
						$("#bianjiTP"+weizhi).attr("onclick","uploadPic('" + weizhi + "','flag')");
						
						var evObj = document.createEvent('HTMLEvents');
						evObj.initEvent('resize', true, true);
						window.dispatchEvent(evObj);
					} else {
						alert("图片上传失败");
					}
				}
			};
			$("#image_submit").ajaxSubmit(ajax_option);
	}
	//删除图片
	function deltupian(weizhi){
		$("#hide_tupian"+weizhi).val("");
		$("#ptphoto"+weizhi).attr("src", "");
		$("#Fptphoto"+weizhi).attr("name","hide");
		$("#Fptphoto"+weizhi).addClass("TPhide");
	}
	////////////////////////////////////////
    </script>
    



  <script src="js/behaviour/voice-commands.js"></script>
  <script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.resize.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.labels.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
</body>
</html>
