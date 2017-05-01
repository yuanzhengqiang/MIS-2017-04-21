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
<title>体检报告详情</title>
<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="js/jquery.gritter/css/jquery.gritter.css" />
<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">
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
.control-label0 {
	padding-top: 7px;
}

#picpreview>div {
	margin-top: 5px;
	position: relative
}

#picpreview .pichidediv {
	position: absolute;
	bottom: 0;
	width: 100%;
	display: none;
	height: 50px;
	background: #fff;
	opacity: 0.9;
	filter: alpha(opacity = 90);
}

#picpreview .pichidediv div {
	position: absolute;
	left: 10px;
	top: 7px;
}

#picpreview .pichidediv div p {
	line-height: 13px
}

#picpreview .pichidediv button {
	position: absolute;
	right: 40px;
	top: 10px;
}

#picpreview>div:hover .pichidediv {
	display: block
}

.TPhide {
	display: none
}

.gallery-cont .item {
	width: 100% !important;
}
</style>
</head>

<body>
	<div class="navbar-fixed-top">
		<div id="head-nav" class="">
			<div class="block-flat" style="padding-bottom:0;margin-bottom: 0px;">
				<div class="row">
					<div class="col-sm-8">
						<div>
							<h2 id="head_fuName">体检报告详情</h2>
							<ol class="breadcrumb" style="padding:0;background:#fff;">
								<li>订单信息</li>
								<li>体检报告管理</li>
								<li class="active">体检报告详情</li>
							</ol>
						</div>
					</div>
					<div class="col-sm-4" style="text-align:right;padding-top:10px">
						<button class="btn btn-primary" id="saveId" onclick="saveReport1()">保存</button>
						<input type="hidden" id="itemId">
						<input type="hidden" id="reportId">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="cl-wrapper1" style="overflow:hidden;padding-top: 100px;">
		<div class="cl-mcont" style="padding: 15px 0px;">
			<div class="block-flat">
				<div class="row" style="margin-top:0">
					<div class="col-sm-12">
						<div class="form-group form-horizontal group-border-dashed">
							<div class="row">
								<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 15px;padding-right: 0px;">报告编号</div>
								<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
									<input type="text" class="form-control" id="reportNumber" readonly="readonly">
								</div>
								<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;"><span style="color:red">*</span>体检人姓名</div>
								<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
									<input type="text" class="form-control" id="personName">
								</div>
								<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;">体检人身份证号</div>
								<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
									<input type="text" class="form-control" id="personID">
								</div>
								<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;">体检人性别</div>
								<div class="col-sm-4 col-md-4 col-lg-2">
									<select class="form-control" id="personGender" style="margin-bottom:5px">
										<option value="1">男</option>
										<option value="0">女</option>
									</select>
								</div>
								<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 15px;padding-right: 0px;">体检人年龄</div>
								<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
									<input type="text" onpaste="return false;" onkeypress="keyPress()" class="form-control" id="personAge">
								</div>
								<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;">报告生成时间</div>
								<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px">
									<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;">
										<span class="input-group-addon btn btn-primary">
											<span class="glyphicon glyphicon-th"></span>
										</span>
										<input class="form-control" size="16" value="" readonly="" type="text" id="reportGenerateStartTime" placeholder="报告生成时间">
										<span class="input-group-btn">
											<button class="btn btn-danger deleteThisTime" type="button">
												<span class="fa fa-times"></span>
											</button>
										</span>
									</div>
								</div>
								<input type="text" style="display:none;" id="hideMedicalReportId" value="">
								<input type="text" style="display:none;" id="hideFilePath" value="">
								<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;">完整体验报告</div>
								<div class="col-sm-4 col-md-4 col-lg-2">
									<input type="hidden" id="medicalReportDownloadLink">
									<form action="document.do?download" id="downloadFile" method="post" style="display:none;">
								    	<input type="text" style="display:none;" name="medicalReportId" id="medicalReportId" value="">
								    	<input type="text" style="display:none;" name="filePath" id="filePath" value="">
								    	<input type="submit" value="Submit"  style="display:none;"/>
								    </form>
									<a href="###" id="downloadFileA" onclick="$('#downloadFile').submit();" style="margin-bottom: 0px !important; height: 34px;margin-left:0;line-height:34px;">点击下载</a>
									<a href="###" id="uploadFileA" style="margin-bottom: 0px !important; height: 34px;margin-left:0;line-height:34px;" class="md-trigger addFile" data-modal="edit-file">点击上传</a>
								</div>
								<div class="col-sm-2 col-md-2 col-lg-1 control-label0" style="padding-left: 0px;padding-right: 0px;">医院</div>
								<div class="col-sm-4 col-md-4 col-lg-2">
									<select class="form-control" id="hospital" style="margin-bottom:5px">

									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12 ">
									<strong>体检报告内容</strong>
								</div>
								<div class="col-sm-12 ">
									<div class="content">
										<div class="form-group" style="padding-top:0;">
											<div id="reportContent"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 主页面结束 -->	

	<!-- 文件上传开始 -->
	<div class="md-modal colored-header custom-width md-effect-9" id="edit-file">
		<div class="md-content" style="box-shadow:2px 2px 4px 3px rgba(0, 0, 0, 0.5);">
			<div class="modal-header" style="padding:5px 20px">
				<h4>文件上传</h4>
			</div>
			<div class="modal-body form">
				<div class="form-group">
					<label>请选择要导入的文件</label>
					<input id="hideFile" class="form-control" onclick="$('input[id=xls4upload]').click();" value="" type="text" placeholder="点击此处上传文件..." readonly="readonly">
					<form style="display:none;" id="file_submit" action="document.do?upload" method="post"  enctype="multipart/form-data">
						<input id="xls4upload" name="xls4upload" type="file" class="btn btn-rad" onchange="getFileName(this.value)" style="width:80%;display:none;margin-left:10%;text-align:left;">
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn-flat" onclick="uploadFile()">确定</button>
				<button type="button" class="btn btn-default btn-flat md-close" data-dismiss="modal" id="cancelFile">取消</button>
			</div>
		</div>
	</div>
	<!-- 文件上传结束-->
	
	<div class="md-overlay"></div>

	<script type="text/javascript" src="js/mordo.tools/mordo.timeProcessing.js"></script>
	<script type="text/javascript" src="js/mordo.tools/mordo.inputControl.js"></script>
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
	<script src="js/jquery.upload/js/jquery.iframe-transport.js"></script>
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
        
        // $('#some-textarea').wysihtml5();
        $('#reportContent').summernote({
        	height:300
        });
        
      	//获取医院
        getHospital();
        
        var id = "<%=request.getAttribute("id")%>";
        if (id != null && id != "") {//编辑页
        	queryReport(id);
        } else {
        	$("#uploadFileA").attr("data-modal","");
        	$("#uploadFileA").attr("onclick","alert('请先新增体检报告内容');");
        	$("#downloadFileA").hide();//隐藏下载
        }
        
        var itemId = "<%=request.getAttribute("itemId")%>";
		if (itemId != null && itemId != "") {//属于订单详情的报告
			$("#itemId").val(itemId);
			if (id == null || id == "") {//属于订单详情新增报告
				$("#saveId").attr("onclick","saveReport2()");
			}
		}
    });
    
    //获取医院
    function getHospital() {
    	var html = "";
     	var reqmsg = "{'action':'QUERY_HOSPITAL_LIST_REQUEST','page':{'pageno':'1','pagesize':'1000000'},'content':{}}";
	
		jQuery.ajax({
			type : "post",
          	async:false,
          	url : "hospital.do?handler",
          	dataType : "json",
          	data: {
               "reqmsg":reqmsg
          	},
          	success : function(data) {
				if (data.des == "success") {
					if (data.content != null) {
	              		if (data.content.hospitalList != null) {
							jQuery.each(data.content.hospitalList,function(i, item) {
	              				html += "<option value='" + item.id + "'>" + item.hospitalName + "</option>";
							});
	 					}
	 				}
				} else {
                	alert("查询医院失败");
              	}
          	},
          	error:function(){
	           alert("查询医院失败");
          	}
		});
		$("#hospital").html(html);
    }
        
    //保存体检报告信息，有reportId新增，无reportId编辑
    function saveReport1() {
		var personName = $.trim($("#personName").val());
		if (personName == null || personName == "") {
			alert("姓名必填");
			return;
		}
		var personID = $.trim($("#personID").val());
		var reg1 = /(^\d{15}$)|(^\d{17}([0-9]|X)$)/; 
		if(!reg1.test(personID)){  
        	alert("身份证格式错误"); 
        	return; 
    	}
		var personGender = $("#personGender").val();
		if (personGender == null || personGender == "") {
			alert("性别必选");
			return;
		}
		var personAge = $.trim($("#personAge").val());
		var reg2 = new RegExp("^(0|[1-9][0-9]*)$"); 
		if(!reg2.test(personAge)){ 
        	alert("请输入正确的年龄");
			return;
    	}
		var reportGenerateStartTime = $.trim($("#reportGenerateStartTime").val());
		var reportContent = $("#reportContent").code();
		var medicalReportDownloadLink = $("#medicalReportDownloadLink").val();
		var hospitalId = $("#hospital").val();
		var hospitalName = $("#hospital").find("option:selected").text();
		if (hospitalId == null || hospitalId == "") {
			alert("医院必选");
			return;
		}
		var reportId = $("#reportId").val();
		var reqmsg = "{'action':'ADD_MEDICAL_REPORT_INFO_REQUEST','content':{";
			
		if (reportId != null && reportId != "") {//编辑
   		    reqmsg += "'id':" + reportId + ",";
		}
    	reqmsg += "'medicalPersonName':'" + personName + "',";
		reqmsg += "'medicalPersonCardNum':'" + personID + "',";
		reqmsg += "'medicalPersonGender':" + personGender + ",";
		if (personAge != null && personAge != "") {
			reqmsg += "'medicalPersonAge':" + personAge + ",";
		} else {
			reqmsg += "'medicalPersonAge':0";
		}
    	if (reportGenerateStartTime != null && reportGenerateStartTime != "") {
    		reportGenerateStartTime = formateTime7(reportGenerateStartTime) + "000000";
    		reqmsg += "'medicalReportCreateTime':'" + reportGenerateStartTime + "',";
    	} else {
    		reqmsg += "'medicalReportCreateTime':'',";
    	}
    	if (reportContent != null && reportContent != "") {
			reportContent = JSON.stringify(reportContent);
			if(reportContent.length > 500){
				alert("字数过长，请重新输入");
				return;
			}
			reqmsg += "'medicalReportContent':" + reportContent + ",";
		} else {
			reqmsg += "'medicalReportContent':'',";
		}
		reqmsg += "'medicalReportDownloadLink':'" + medicalReportDownloadLink + "',";
		reqmsg += "'medicalHospital':'" + hospitalName + "',";
		reqmsg += "'hospitalId':" + hospitalId + ",";
		reqmsg += "}}";

		jQuery.ajax({
       		type : "post",
       		async:true,
       		url : "medicalReport.do?handler",
       		dataType : "json",
       		data: {
       		     "reqmsg":reqmsg
       		},
      		success : function(data) {
       			if (data.des == "success") {
       				alert("保存体检报告成功");
        		   	var id = data.content.id;
        		   	var path = "<%=request.getContextPath()%>";
       		   		var url = path + "/medicalReport.do?medicalReportDetail&id=" + id;
      		   		window.location.replace(url);
        		} else {
        		  	alert("保存体检报告失败");
        		}
      		},
      		error:function(){
   		    	alert("保存体检报告失败");
     		}
		});
    }
    
    //保存体检报告信息，有reportId新增，无reportId编辑,属于体检报告
    function saveReport2() {
    	var itemId = $("#itemId").val();
		var personName = $.trim($("#personName").val());
		if (personName == null || personName == "") {
			alert("姓名必填");
			return;
		}
		var personID = $.trim($("#personID").val());
		var reg1 = /(^\d{15}$)|(^\d{17}([0-9]|X)$)/; 
		if(!reg1.test(personID)){  
        	alert("身份证格式错误"); 
        	return; 
    	}
		var personGender = $("#personGender").val();
		if (personGender == null || personGender == "") {
			alert("性别必选");
			return;
		}
		var personAge = $.trim($("#personAge").val());
		var reg2 = new RegExp("^(0|[1-9][0-9]*)$"); 
		if(!reg2.test(personAge)){ 
        	alert("请输入正确的年龄");
			return;
    	}
		var reportGenerateStartTime = $.trim($("#reportGenerateStartTime").val());
		var reportContent = $("#reportContent").code();
		var hospitalId = $("#hospital").val();
		var hospitalName = $("#hospital").find("option:selected").text();
		if (hospitalId == null || hospitalId == "") {
			alert("医院必选");
			return;
		}
		var reportId = $("#reportId").val();
		var reqmsg = "{'action':'ADD_ORDER_INFO_REQUEST','content':{";
		reqmsg += "'id':" + itemId + ",";	
			
		reqmsg += "'medicalReport':{";	
			
		if (reportId != null && reportId != "") {//编辑
   		    reqmsg += "'id':" + reportId + ",";
		}
    	reqmsg += "'medicalPersonName':'" + personName + "',";
		reqmsg += "'medicalPersonCardNum':'" + personID + "',";
		reqmsg += "'medicalPersonGender':" + personGender + ",";
		if (personAge != null && personAge != "") {
			reqmsg += "'medicalPersonAge':" + personAge + ",";
		} else {
			reqmsg += "'medicalPersonAge':0";
		}
    	if (reportGenerateStartTime != null && reportGenerateStartTime != "") {
    		reportGenerateStartTime = formateTime7(reportGenerateStartTime) + "000000";
    		reqmsg += "'medicalReportCreateTime':'" + reportGenerateStartTime + "',";
    	} else {
    		reqmsg += "'medicalReportCreateTime':'',";
    	}
    	if (reportContent != null && reportContent != "") {
			reportContent = JSON.stringify(reportContent);
			if(reportContent.length > 500){
				alert("字数过长，请重新输入");
				return;
			}
			reqmsg += "'medicalReportContent':" + reportContent + ",";
		} else {
			reqmsg += "'medicalReportContent':'',";
		}
		reqmsg += "'medicalReportDownloadLink':'" + medicalReportDownloadLink + "',";
		reqmsg += "'medicalHospital':'" + hospitalName + "',";
		reqmsg += "'hospitalId':" + hospitalId + ",";
		reqmsg += "}";	
		reqmsg += "}}";

		jQuery.ajax({
       		type : "post",
       		async:true,
       		url : "order.do?handler",
       		dataType : "json",
       		data: {
       		     "reqmsg":reqmsg
       		},
      		success : function(data) {
       			if (data.des == "success") {
       				alert("保存体检报告成功");
        		   	var id = data.content.medicalReportId;
        		   	var path = "<%=request.getContextPath()%>";
       		   		var url = path + "/medicalReport.do?medicalReportDetail&id=" + id;
      		   		window.location.replace(url);
        		} else {
        		  	alert("保存体检报告失败");
        		}
      		},
      		error:function(){
   		    	alert("保存体检报告失败");
     		}
		});
    }
    
	//查询体检报告详细信息
	function queryReport(id) {
		var reqmsg = "{'action':'QUERY_MEDICAL_REPORT_INFO_REQUEST','content':{'hospitalShow':'true','id':" + id + "}}";
		jQuery.ajax({
			type : "post",
          	async:false,
          	url : "medicalReport.do?handler",
          	dataType : "json",
          	data: {
            	"reqmsg":reqmsg
          	},
          	success : function(data){
            	if (data.des == "success") {
              		if (data.content != null) {
              			$("#reportId").val(data.content.id);
              			$("#reportNumber").val(data.content.medicalReportNum);
              			$("#personName").val(data.content.medicalPersonName);
              			$("#personID").val(data.content.medicalPersonCardNum);
              			if (data.content.medicalPersonGender == true) {
              				$("#personGender").val(1);
              			}
              			if (data.content.medicalPersonGender == false) {
              				$("#personGender").val(0);
              			}
              			$("#personAge").val(data.content.medicalPersonAge);
              			var medicalReportCreateTime = data.content.medicalReportCreateTime;
              			if (medicalReportCreateTime != null && medicalReportCreateTime != "") {
              				medicalReportCreateTime = formateTime2(medicalReportCreateTime);
              			} else {
              				medicalReportCreateTime= "";
              			}
              			$("#reportGenerateStartTime").val(medicalReportCreateTime);
              			
              			if (data.content.medicalReportDownloadLink != null && data.content.medicalReportDownloadLink != "") {
              				$("#medicalReportDownloadLink").val(data.content.medicalReportDownloadLink);
              				$("#filePath").val(data.content.medicalReportDownloadLink);
              				$("#hideFile").val(data.content.medicalReportDownloadLink);
              				$("#medicalReportId").val(data.content.id);
              				$("#hideMedicalReportId").val(data.content.id);
              				$("#hideFilePath").val(data.content.medicalReportDownloadLink);
              			} else {
              				$("#downloadFileA").hide();//隐藏下载
              			}
              			
              			$("#hospital").val(data.content.hospitalId);
              			$("#reportContent").code(data.content.medicalReportContent);
					}
				} else {
                	alert("查询体检报告失败");
                }
          	},
          	error:function(){
	        	alert("查询体检报告失败");
          	}
		});
	}
	
	//文件上传
	function uploadFile() {
		var id = "<%=request.getAttribute("id")%>";
		var ajax_option = {
			async:false,
			data:{
				"medicalReportId":id
			},
			success:function(data) {
				if (data != null && data != "") {
					var result = JSON.parse(data);
					if (result.result == "success") {
						$("#medicalReportDownloadLink").val(result.link);
						$("#filePath").val(result.link);
						$("#downloadFileA").show();
						$("#cancelFile").click();
						alert("文件上传成功");
					} else {
						alert("文件上传失败");
					}
				} else {
					alert("文件上传失败");
				}
			}
		};
		$("#file_submit").ajaxSubmit(ajax_option);
	}
	
	//文件下载
	function downloadFile() {
		var id = $("#medicalReportId").val();
		var filePath = $("#filePath").val();
		jQuery.ajax({
			type : "post",
          	async:false,
          	url : "document.do?download",
          	dataType : "json",
			data:{
				"medicalReportId":id,
				"filePath":filePath
			},
			success:function(data) {
				alert("111")
			}
		});
	}
	
	//自动获取文件名
	function getFileName(value) {
		document.getElementById('hideFile').value = value;
	}
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
