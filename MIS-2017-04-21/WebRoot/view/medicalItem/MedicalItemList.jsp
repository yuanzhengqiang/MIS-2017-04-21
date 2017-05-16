<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="images/logo.png">

<title>体检项目管理</title>
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
<script type="text/javascript" src="js/sortListTool.js"></script>
<style type="text/css">
.red {
	color: red;
}
</style>
</head>
<body style="opacity: 1; margin-left: 0px;">
	<div style="width: 100%; height: 100%;">
		<div class="container-fluid" style="padding: 0px">
			<!-- 头部开始 -->
			<div class="page-head">
				<h2>体检项目管理</h2>
				<ol class="breadcrumb">
					<li>基础信息/</li>
					<input type="hidden" value="" id="sortType">
					<input type="hidden" value="" id="sortColumn">
					<li class="active">体检项目管理</li>
				</ol>
			</div>
			<!-- 头部结束 -->
		</div>

		<div class="cl-mcont">
			<div class="row">
				<div class="col-md-12">
					<div class="block-flat">
						<div class="content">
							<div class="table-responsive">
								<div class="dataTables_wrapper form-inline">
									<!-- 查询框开始 -->
									<div class="row">
										<div class="col-xs-6 col-sm-2 text-left" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
											<label>项目名称</label>
										</div>
										<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
											<input id="queryItemName" class="form-control" type="text" value="" autocomplete="off" style="width:100%">
										</div>
									</div>
									<!-- 查询框结束 -->
									<!-- 操作按钮开始 -->
									<div class="row">
										<div class="col-sm-12">
											<button class="btn btn-primary " style="margin-bottom: 0px !important; height: 34px;margin-left:0;float:left;" onclick="query();">查询</button>
											<button class="btn btn-primary btn-flat" style="margin-bottom: 0px !important; height: 34px;margin-left:0;float:right;" onclick="add();">新增</button>
										</div>
									</div>
									<!-- 操作按钮结束 -->
									<!-- 数据表格开始 -->
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-bordered dataTable hover" id="datatable" aria-describedby="datatable_info">
												<thead>
													<tr role="row">
														<th name="needSort" class="sorting" onclick="queryBySort(this,'itemName')">
															<strong>项目名称</strong>
														</th>
														<th>
															<strong>icon</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'price')">
															<strong>价格</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'category')">
															<strong>类别</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_testWay')">
															<strong>检测方式</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_testPurpose')">
															<strong>检测目的</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_selectDes')">
															<strong>选择说明</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_des')">
															<strong>备注</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_mattersNeedAttention ')">
															<strong>注意事项</strong>
														</th>
														<th style="min-width: 100px;">
															<strong>操作<strong>
														</th>
													</tr>
												</thead>
												<tbody id="datacontainer" role="alert" aria-live="polite" aria-relevant="all">
												</tbody>
											</table>
										</div>
									</div>
									<!-- 数据表格结束 -->
									<!-- 数据条数提示开始 -->
									<div class="row">
										<div class="col-sm-12">
											<div class="pull-left">
												<div id="datatable_info" class="dataTables_info">当前显示0 条总记录中的第0-0条</div>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<!-- 数据条数提示结束 -->
									<!-- 分页条开始 -->
									<div class="row">
										<div class="col-sm-4">
											<div class="dataTables_length" id="datatable2_length">
												<label style="margin-top:18px;">
													每页 <select id="pageSizeSelector" class="form-control" aria-controls="datatable2" size="1" name="datatable2_length" onchange="query()"><option selected="selected" value="10">10</option>
														<option value="25">25</option>
														<option value="50">50</option>
														<option value="100">100</option>
													</select> 条
												</label>
											</div>
										</div>
										<div class="col-sm-8">
											<div class="pull-right">
												<div class="dataTables_paginate paging_bs_normal">
													<ul id="paginationArea" class="pagination">
														<li class="prev disabled">
															<a href="#">
																<span class="fa fa-angle-left"></span>
																&nbsp;上一页
															</a>
														</li>
														<li class="active">
															<a href="#">1</a>
														</li>
														<li class="next">
															<a href="#">
																下一页&nbsp;
																<span class="fa fa-angle-right"></span>
															</a>
														</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
									<!-- 分页条结束 -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Nifty Modal -->
	<button class="md-trigger" data-modal="editDetail" style="display:none;" id="editDes"></button>
	<div class="md-modal md-effect-1" id="editDetail" style="height: 650px;">
		<div class="row">
			<div class="col-md-12" style="padding: 10px 0px;">
				<div class="block-flat" style="padding-right: 0px;">
					<div class="header">
						<h3>体检项目信息</h3>
					</div>
					<div class="content" style="height: 530px;overflow-y: auto;">
						<form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
							<input type="hidden" name="entityId" id="medicalItemInfoId">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									项目名称
									<span class="red">*</span>
								</label>
								<div class="col-sm-6">
									<input id="itemName" type="text" class="form-control" autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">
									项目icon
									<span class="red">*</span>
								</label>
								<div class="col-sm-6">
									<img src="###" id="iconImage" value="" style="width:30px;height:30px">
									<button type="button" class="btn btn-primary btn-rad md-trigger" data-modal="iconChooseModal" onclick="chooseIcon();" style="float:right">
										<span>
											<i class="fa fa-check" style="margin-right:5px;"></i>选择
										</span>
									</button>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">
									价格
									<span class="red">*</span>
								</label>
								<div class="col-sm-6">
									<input id="price" class="form-control" autocomplete="off" placeholder="最小保留小数点后两位">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">
									类别
									<span class="red">*</span>
								</label>
								<div class="col-sm-6">
									<select id="category" style="width:100%;height:30px;">
										<option value=""></option>
										<option value="1">基础检查</option>
										<option value="2">肿瘤</option>
										<option value="3">心脑血管</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">检测方式</label>
								<div class="col-sm-6">
									<input id="testWay" type="text" class="form-control" autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">检测目的</label>
								<div class="col-sm-6">
									<input id="testPurpose" type="text" class="form-control" autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">选择说明</label>
								<div class="col-sm-6">
									<textarea class="form-control" id="selectDes"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">备注</label>
								<div class="col-sm-6">
									<textarea class="form-control" id="des"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">注意事项</label>
								<div class="col-sm-6">
									<textarea class="form-control" id="mattersNeedAttention"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-12 control-label" style="text-align: center;">项目说明</label>
								<div class="col-sm-12">
									<div class="content">
										<div class="form-group" style="padding-top:0;">
											<div id="reportContent"></div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="footer">
						<div class="form-group" style="text-align: center;margin:0px">
							<button type="button" class="btn btn-primary btn-rad" onclick="saveInfo();">
								<span>
									<i class="fa fa-check" style="margin-right:5px;"></i>保存
								</span>
							</button>
							<button id="cancel_button" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
								<span>
									<i class="fa fa-times" style="margin-right:5px;"></i>取消
								</span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Nifty Modal -->

	<!-- icon选择 -->
	<div class="md-modal colored-header custom-width md-effect-9" id="iconChooseModal">
		<div class="md-content">
			<div class="modal-header">
				<h3>icon选择</h3>
				<button type="button" class="close md-close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body form">
				<div class="form-group">
					<label>
						<input name="icons" type="radio" value="medicalItemIcons/icon1.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon1.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon2.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon2.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon3.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon3.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon4.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon4.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon5.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon5.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon6.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon6.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon7.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon7.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon8.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon8.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon9.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon9.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon10.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon10.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon11.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon11.png">
						<input name="icons" type="radio" value="medicalItemIcons/icon12.png" /><img style="width:20px;height:20px;margin-right:20px;margin-left:5px" src="medicalItemIcons/icon12.png">
					</label>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn-flat" data-dismiss="modal" onclick="saveChoose()">保存</button>
				<button type="button" class="btn btn-default btn-flat md-close" data-dismiss="modal" id="closeIconChoose">取消</button>
			</div>
		</div>
	</div>

	<div class="md-overlay"></div>
	<!-- Nifty Modal的遮罩层-->

	<script type="text/javascript" src="js/mordo.tools/mordo.selectionBoxProcessing.js"></script>
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
	//根据排序规则重新查询
	function queryBySort(par,column){
		var classFlag = listSortClickEvent(par);
		var type = judgmentChinese(column);
		if(type != null && type != ""){
			classFlag = type + classFlag;
			column = column.substr(8,column.length);
		}
		$("#sortType").val(classFlag);
		$("#sortColumn").val(column);
		go2page(currentshownpage);
	}
	
	var currentshownpage = 1;
	var path="";
	
	$(document).ready(function(){
	    App.init();
	    App.textEditor();
	    $(".btn-toolbar").css("margin", "0px auto");	  
	    $(".note-codable").css("min-width", "730");  
	    // $('#some-textarea').wysihtml5();
        $('#reportContent').summernote({
        	height:300
        });
	    var windowHeight=$(window).height();
	   	$("#editDetail").css("height", (windowHeight) + "px");
	   	$("#editDetail").find(".modal-body").css("height", (windowHeight - 50) + "px");
	    $(".md-trigger").modalEffects();
		query();
		$(".deleteThisTime").click(function(){               //清除日期框中的值 
	           $(this).parent().prev()[0].value = "";               
	    });
	});
	
	function selectAll() {
		if ($("#allselectchecker").is(':checked')) {
			$("tbody#datacontainer .col_selector").prop("checked", true);
		} else {
			$("tbody#datacontainer .col_selector").prop("checked", false);
		}
	}
	
	//新增
	function add() {
		$("#medicalItemInfoId").val("");
		$("#itemName").val("");
		$("#iconImage").val("");
		$("#iconImage").attr("src","###");
		$("#price").val("");
		$("#category").val("");
		$("#testWay").val("");
		$("#testPurpose").val("");
		$("#selectDes").val("");
		$("#mattersNeedAttention").val("");
		$("#reportContent").code("");
		$("#des").val("");
		$("#editDes").click();
	}
	
	//编辑显示详情
	function editInfo(id, itemName,iconImage, price, category, testWay, testPurpose, selectDes, des, mattersNeedAttention,par) {
		$("#medicalItemInfoId").val(id);
		$("#itemName").val(itemName);
		$("#iconImage").val(iconImage);
		$("#iconImage").attr("src",iconImage);
		$("#price").val(price);
		$("#category").val(category);
		$("#testWay").val(testWay);
		$("#testPurpose").val(testPurpose);
		$("#selectDes").val(selectDes);
		$("#mattersNeedAttention").val(mattersNeedAttention);
		$("#reportContent").code($(par).find("input").val());
		$("#des").val(des);
		$("#editDes").click();
	}
	
	//删除
	function del(id) {
		if (confirm("是否确认删除?"))  {  
			jQuery.ajax({
				type:"post",
				url: "medicalItem.do?del",
				async:true,
				dataType:"json",
				data:{ids:id},
				success:function(data) {
					if (data.result == "success") {
						alert(data.des);
						go2page(1);
					}else if(data.result=="failure"){
	                    alert(data.des);
	                }
				},
				error:function() {
					alert("删除失败");
				}
			});
		}
	}
	
	
	/**
	 * 保存信息
	 * @method saveInfo
	 */
	function saveInfo() {
		var id = $("#medicalItemInfoId").val();
		var itemName = $.trim($("#itemName").val());//项目名称
		var iconImage = $("#iconImage").val();//icon图片
		if (iconImage == null || iconImage == "") {
			alert("icon不能为空");
			return;
		}
		var price = $.trim($("#price").val());//价格
		var category = $.trim($("#category").val());//分类
		var testWay = $.trim($("#testWay").val());//检测方式
		var testPurpose = $.trim($("#testPurpose").val());//检测目的
		var selectDes = $.trim($("#selectDes").val());//选择说明
		var mattersNeedAttention = $.trim($("#mattersNeedAttention").val());//注意事项
		var reportContent = $("#reportContent").code();
		var des = $.trim($("#des").val());//备注
		
		var reqmsg="{'action':'ADD_MEDICAL_ITEM_INFO_REQUEST','content':{";
		
		if (id != null && id != "") {
			reqmsg += "\"id\":" + id + ",";
		}
		if (itemName != null && itemName != "") {
			reqmsg += "\"itemName\":\"" + itemName + "\",";
		} else {
			alert("项目名称不能为空");
			return;
		}
		reqmsg += "\"icons\":\"" + iconImage + "\",";
		if (price != null && price != "") {
			if ( number(price) ) {
				var priceNum = parseFloat(price)
				priceNum = priceNum.toFixed(2);
				reqmsg += "\"price\":" + priceNum + ",";
			} else {
				alert("价格输入有误,请重新输入");
				return;
			}
		} else {
			alert("价格不能为空");
			return;
		}
		
		if (category != null && category != "") {
			reqmsg += "\"category\":" + category + ",";
		} else {
			alert("类别不能为空");
			return;
		}
		
		if (testWay != null && testWay != "") {
			reqmsg += "\"testWay\":\"" + testWay + "\",";
		} else {
			reqmsg += "\"testWay\":\"\",";
		}
		
		if (testPurpose != null && testPurpose != "") {
			reqmsg += "\"testPurpose\":\"" + testPurpose + "\",";
		} else {
			reqmsg += "\"testPurpose\":\"\",";
		}
		    
		if (selectDes != null && selectDes != "") {
	        reqmsg += "\"selectDes\":\"" + selectDes + "\",";
		} else {
			reqmsg += "\"selectDes\":\"\",";
		}
		if (mattersNeedAttention != null && mattersNeedAttention != "") {
	        reqmsg += "\"mattersNeedAttention\":\"" + mattersNeedAttention + "\",";
		} else {
			reqmsg += "\"mattersNeedAttention\":\"\",";
		}
		if (reportContent != null && reportContent != "") {
			reportContent = JSON.stringify(reportContent);
			/*if(reportContent.length > 1000){
				alert("字数过长，请重新输入");
				return;
			}*/
			reqmsg += "'itemDes':" + reportContent + ",";
		} else {
			reqmsg += "'itemDes':'',";
		}
		if (des != null && des != "") {
	        reqmsg += "\"des\":\"" + des + "\",";
		} else {
			reqmsg += "\"des\":\"\",";
		}
		
		reqmsg += "}}";

		jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "medicalItem.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des=="success"){
	              	$("#cancel_button").click();
	            	  alert("保存成功");
	            	  go2page(1);
	              }else if(data.des=="failure"){
	                 alert("保存失败");
	              }
	          },
	          error:function(){
		           alert("保存失败");
	          }
	     });
	}
	
	//判断数字字符
	function number(str){
	    var pattern = /^\d+(\.\d+)?$/;
	    if(pattern.test(str)){
	        return true;
	    }else{
	        return false;
	    }
	}
	
	function go2page(pagenumber){
		var pagesize = $("#pageSizeSelector option:selected").val();
		var itemName = $.trim($("#queryItemName").val());
		var reqmsg="{'action':'QUERY_MEDICAL_ITEM_LIST_REQUEST',";
		
		var sortType = $("#sortType").val();
		var sortColumn = $("#sortColumn").val();
		if(sortType != null && sortType != ""){
			reqmsg += "'order':[{'column':'" + sortColumn + "','type':'" + sortType + "'}],";
		} else {
			reqmsg += "'order':[{'column':'id','type':'asc'}],";
		}
		
		reqmsg += "'page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{";
		
		if (itemName != null && itemName != "") {
			reqmsg += "\"itemName_like\":\"" + itemName + "\",";
		}
		reqmsg += "}}";
	
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "medicalItem.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg              
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	  changeData(data);
	              }else if(data.des=="failure"){
	                 alert("查询失败");
	              }
	          },
	          error:function(){
		           alert("error7");
	          }
	     });
	}
	
	function changeStatus(status){
		var statusName = "";
		switch(status){
			case 1:
				statusName = "基础检查";
				break;
			case 2:
				statusName = "肿瘤";
				break;
			case 3:
				statusName = "心脑血管";
			default:
				break;
		}
		return statusName;
	}
	
	
	function changeData(data){
		var htmlcode = ""
		if (data.content != null) {
			jQuery.each(data.content.medicalItemList, function(i, item) {
				htmlcode += "<tr class=\"gradeA odd\">";	
			    htmlcode += "<td>" + item.itemName + "</td>";		
			    htmlcode += "<td><img style='width:20px;height:20px;' src='" + ((item.icons != null && item.icons != "") ? item.icons : "###") + "'></td>";		
			    htmlcode += "<td>" + item.price + "</td>";	
			    htmlcode += "<td>" + changeStatus(item.category) + "</td>";
			    htmlcode += "<td>" + item.testWay + "</td>";	
			    htmlcode += "<td>" + strBreviary(item.testPurpose) + "</td>";
			    htmlcode += "<td>" + strBreviary(item.selectDes) + "</td>";
			    htmlcode += "<td>" + strBreviary(item.des) + "</td>";
			    htmlcode += "<td>" + strBreviary(item.mattersNeedAttention) + "</td>";
				htmlcode += "<td><div class=\"btn-group\">";
				htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
				htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
				htmlcode += "<span class=\"caret\"></span>";
				htmlcode += "<span class=\"sr-only\">Toggle Dropdown</span>";
				htmlcode += "</button>";
				htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";
				htmlcode += "<li onclick=\"editInfo('"+item.id+"','"+ item.itemName+"','"+item.icons+"','"+ item.price+"','"+ item.category+"','"+ item.testWay+"','"+ item.testPurpose+"','"+ item.selectDes+"','"+ item.des+"','"+ item.mattersNeedAttention+"',this)\"><input type='hidden' value='" + item.itemDes + "'><a href=\"###\">编辑</a></li>";
				htmlcode += "<li onclick=\"del('"+item.id+"')\"><a href=\"###\">删除</a></li>";
				htmlcode += "</ul></div></td>";
				htmlcode += "</tr>";
			});
		}
		$("#datacontainer").html(htmlcode);
		if (data.page != null) {
			genaratePaginateHtml(data.page.pageno, data.page.pageCount);
			genarateRecordNumberHtml(data.page.pageno, data.page.pagesize, data.page.recordCount);
		} else {
			genaratePaginateHtml(1, 1);
			genarateRecordNumberHtml(1, 10, 0);
		}
	}
	
	function query() {
		go2page(1);
	}
	
	//文字缩略显示
	function strBreviary(str) {
		var strNew;
		if (str != "" && str.length > 30) {
			strNew = str.substr(0, 30) + "...";
		} else {
			strNew = str;
		}
		return strNew
	}
	
	
	/**
	 * 生成记录数信息
	 * @method genarateRecordNumberHtml
	 * @param {Number} currentpage 当前页
	 * @param {Number} pagesize 每页记录条目数
	 * @param {Number} totalRecord 总记录数
	 */
	function genarateRecordNumberHtml(currentpage, pagesize, totalRecord) {
		var recordInfos = "";
		if (totalRecord > 0) {
		    recordInfos = "当前显示" + totalRecord + "条总记录";
			recordInfos += "中第" + ((currentpage - 1) * pagesize + 1) + "-";
			if (currentpage * pagesize > totalRecord) {
				recordInfos += totalRecord;
			} else {
				recordInfos += currentpage * pagesize;
			}
			recordInfos += "条 ";
		} else {
			recordInfos = "当前显示0 条总记录中的第0-0条";
		}
		
		$("#datatable_info").html(recordInfos);
	}
	
	/**
	 * 生成分页信息
	 * @method genaratePaginateHtml
	 * @param {Number} currentpage 当前页
	 * @param {Number} totalpage 总页数
	 */
	function genaratePaginateHtml(currentpage, totalpage, pagesize) {
	
		var htmlcode = "";
		
		//上一页
		if (currentpage > 1) {
			htmlcode += "<li class=\"pre\"><a href=\"#\" onclick=\"go2page('1')\"><span class=\"fa fa-angle-left\"></span>&nbsp;首页</a></li>";
			htmlcode += "<li class=\"pre\"><a href=\"#\" onclick=\"go2page('" + (currentpage - 1) + "')\"><span class=\"fa fa-angle-left\"></span>&nbsp;上一页</a></li>";
		} else {
			htmlcode += "<li class=\"pre disabled\"><a href=\"#\"><span class=\"fa fa-angle-left\"></span>&nbsp;首页</a></li>";
			htmlcode += "<li class=\"pre disabled\"><a href=\"#\"><span class=\"fa fa-angle-left\"></span>&nbsp;上一页</a></li>";
		}
		
		//具体页码
		if (totalpage <= 5) {
			for (var i = 1; i <= totalpage; i++) {
				if (currentpage == i) {
					htmlcode += "<li class=\"active\"><a href=\"#\">" + i + "</a></li>";
				} else {
					htmlcode += "<li><a href=\"#\" onclick=\"go2page('" + i + "')\">" + i + "</a></li>";
				}
			}
		} else {
			var startpage = currentpage;
			var endpage = currentpage;
			while (true) {
				if (endpage - startpage >= 4) {
					break;
				} else {
					if (startpage > 1) {
						startpage = startpage - 1;
					}
					if (endpage < totalpage) {
						endpage = endpage - (-1);
					}
				}
			}
			
			for (var i = startpage; i <= endpage; i++) {
				if (currentpage == i) {
					htmlcode += "<li class=\"active\"><a href=\"#\">" + i + "</a></li>";
				} else {
					htmlcode += "<li><a href=\"#\" onclick=\"go2page('" + i + "')\">" + i + "</a></li>";
				}
			}
		}
		
		//下一页
		if (totalpage > currentpage) {
			htmlcode += "<li class=\"next\"><a href=\"#\" onclick=\"go2page('" + (parseInt(currentpage) + 1) + "')\">下一页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
			htmlcode += "<li class=\"next\"><a href=\"#\" onclick=\"go2page('" + parseInt(totalpage) + "')\">末页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
		} else {
			htmlcode += "<li class=\"next disabled\"><a href=\"#\">下一页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
			htmlcode += "<li class=\"next disabled\"><a href=\"#\">末页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
		}
		$("#paginationArea").html(htmlcode);
	}		
	
	//icon赋值
	function chooseIcon() {
		var iconName = $("#iconImage").val();
		if (iconName != null && iconName != "") {
			checkRadioByNameAndValue(iconName,"icons");
		}
	}
	//icon确认选择
	function saveChoose() {
	   var iconName = getValueByRadioName("icons");
	   if (iconName != null && iconName != "") {
	   	   $("#iconImage").attr("src",iconName);
	   	   $("#iconImage").val(iconName);
	   }
	   $("#closeIconChoose").click();
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