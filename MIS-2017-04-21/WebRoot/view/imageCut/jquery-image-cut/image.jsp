<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
  	<link href="dist/cropper.css" rel="stylesheet">
  	<link href="css/main.css" rel="stylesheet">
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
	<style>
	@media (min-width: 992px){
.duiqi {
    margin-top: 202px;
}
}
	</style>
</head>
<body>
	<div class="htmleaf-container">
  <div class="container">
  
    <div class="row">
      <div class="col-md-9">
        <!-- <h3 class="page-header">Demo:</h3> -->
        <div class="img-container" style="background-color:black;" id="imgContent">
          <img src="assets/img/av.jpg" alt="Picture" id="pic_chuan">
        </div>
      </div>
      <div class="col-md-3">
        <!-- <h3 class="page-header">Preview:</h3> -->
        <div class="docs-preview clearfix"  style="display:none;">
          <div class="img-preview preview-lg">
          </div>
        </div>

        <!-- <h3 class="page-header">Data:</h3> -->
        <div class="docs-data">
          <div class="input-group">
            <label class="input-group-addon" for="dataX">X</label>
            <input class="form-control" id="dataX" type="text" placeholder="x">
            <span class="input-group-addon">px</span>
          </div>
          <div class="input-group">
            <label class="input-group-addon" for="dataY">Y</label>
            <input class="form-control" id="dataY" type="text" placeholder="y">
            <span class="input-group-addon">px</span>
          </div>
          <div class="input-group">
            <label class="input-group-addon" for="dataWidth">Width</label>
            <input class="form-control" id="dataWidth" type="text" placeholder="width">
            <span class="input-group-addon">px</span>
          </div>
          <div class="input-group">
            <label class="input-group-addon" for="dataHeight">Height</label>
            <input class="form-control" id="dataHeight" type="text" placeholder="height">
            <span class="input-group-addon">px</span>
          </div>
        </div>
        <div class="docs-data duiqi" style="display:none;" id="titleaDes">
        	<input id="flag" type="hidden" value="0">
        	<div class="input-group">
        		<label class="input-group-addon" for="photoTitle">照片标题</label>
            	<input class="form-control" id="photoTitle" type="text" value="">
            </div>
            <div class="input-group">
            	<label class="input-group-addon" for="photoDes">照片备注</label>
            	<textarea class="form-control" id="photoDes" value=""></textarea>
            </div>
        </div>
      </div>
    </div>
   
    <div class="row" style="margin-top:5px">
     <div class="col-md-9 docs-buttons">
     	<div class="btn-group">
         <button class="btn btn-primary" id="save_click" type="button" onclick="uploadPic_cut()">
           		确定
         </button>
       </div>
        <!-- <h3 class="page-header">Toolbar:</h3> -->
        <div class="btn-group" style="display:none;">
         <button class="btn btn-primary" id="clear_click" data-method="clear" type="button" title="Clear">
            <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;clear&quot;)">
              <span class="icon icon-remove"></span>
            </span>
         </button>
       </div>
	</div>
      <div class="col-md-3 docs-toggles" style="display:none;">
        <!-- <h3 class="page-header">Toggles:</h3> -->
        <div class="btn-group btn-group-justified" data-toggle="buttons">
           <label class="btn btn-primary" id="zfx_click" data-method="setAspectRatio" data-option="1" title="Set Aspect Ratio">
           <!-- <input class="sr-only" id="aspestRatio3" name="aspestRatio" value="1" type="radio">
             <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;setAspectRatio&quot;, 2 / 1)">
              2:1
            </span> -->
          </label>
        </div>
      </div><!-- /.docs-toggles -->
    </div>
  </div>
   <div style="position:absolute;height:530px;width:100%;z-index:222;left:0;top:0"  id="covermask"></div>	
  <!-- Alert -->
	</div>
</body>
  	  <!--<script src="../../../../js/jquery.js"></script>
  	  <script type="text/javascript" src="../../../../js/jquery.form.js"></script> -->
	  <script src="assets/js/jquery.min.js"></script>
	  <script src="assets/js/bootstrap.min.js"></script>
	  <script src="dist/cropper.js"></script>
	  <script src="js/main.js"></script>
	  <script type="text/javascript">
	   $(document).ready(function(){
	   	var imgUrl = window.location.href;
	   	var imgUrlS = imgUrl.split("?");
	   	if(imgUrlS.length > 1){
	   		imgUrl = imgUrlS[1];
	   	}
	   	
	   	var imgUrlS2 = imgUrl.split("&");
	   	if(imgUrlS2.length > 2){
	   		if(imgUrlS2[0] == "flag=jkbg"){
	   			var tpTitle = imgUrlS2[1].split("=")[1];
	   			var tpmiaoshu = imgUrlS2[2].split("=")[1];
	   			tpTitle = decodeURI(tpTitle);
	   			tpmiaoshu = decodeURI(tpmiaoshu);
	   			$("#photoTitle").val(tpTitle);
	   			$("#photoDes").val(tpmiaoshu);
	   			$("#flag").val("1");
	   			$("#titleaDes").attr("style","display:block;");
	   			imgUrl = imgUrlS2[3];
	   		}
	   	}else if(imgUrlS2.length == 2){
	   		if(imgUrlS2[0] == "flag=jkbg"){
	   			$("#flag").val("1");
	   			$("#titleaDes").attr("style","display:block;");
	   			imgUrl = imgUrlS2[1];
	   		}else if(imgUrlS2[0] == "flag=IDCard"){
	   			$("#flag").val("2");
	   			imgUrl = imgUrlS2[1];
	   			$("#zfx_click").attr("data-option","0");
	   		}
	   	}
	   	
	   	var path="<%=request.getContextPath()%>";
	   	
	   	$("img").attr("src", path + "/" + imgUrl);
	   	
	   	$("#zfx_click").click();
	   
	   });
	   
	   window.onload=myfun;
	   function myfun()
	   {
    		var imgUrl = window.location.href;
	   		var imgUrlS = imgUrl.split("?");
	   		if(imgUrlS.length > 1){
	   			imgUrl = imgUrlS[1];
	   		}
	   	
	   		var path="<%=request.getContextPath()%>";
	   		$(".cropper-view-box").find("img").attr("src", path + "/" + imgUrl);
	   		$(".cropper-canvas").parent().attr("class","cropper-container cropper");
	   		
	   		
	   		var flagUrl = location.href;//部分浏览器不兼容，因此做刷新页面处理
			var flag = flagUrl.split("???");
			if(flag.length == 1){
	   			reurl();
			}
			
			$("#covermask").css("display","none");
	   }
	   
	   function reurl(){
			var url = location.href + "???flag";
			self.location.replace(url);
	   }


	//ä¸ä¼ è£åªåå¾ç
	function uploadPic_cut() {
		 if($("#flag").val() == "1"){
		 	if(document.getElementById("photoTitle").value == ""){
		 		document.getElementById("photoTitle").value = "标题";
		 	}
		 	if(document.getElementById("photoDes").value == ""){
		 		document.getElementById("photoDes").value = "描述";
		 	}
		 	window.opener.window.document.getElementById("photoTitle").value = document.getElementById("photoTitle").value;
		 	window.opener.window.document.getElementById("photoDes").value = document.getElementById("photoDes").value;
		 }
	     window.opener.window.document.getElementById("x1").value = document.getElementById("dataX").value;
         window.opener.window.document.getElementById("y1").value = document.getElementById("dataY").value;
         window.opener.window.document.getElementById("x2").value = document.getElementById("dataWidth").value;
         window.opener.window.document.getElementById("y2").value = document.getElementById("dataHeight").value;
         window.opener.window.document.getElementById("sure_SC").click();
         window.close();
	}
	  </script>
</html>