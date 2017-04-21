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

    <title>Clean Zone</title>
  
    <!-- Bootstrap core CSS -->
    <link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet" />
	<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->
	    <link rel="stylesheet" type="text/css" href="js/jquery.gritter/css/jquery.gritter.css" />

  <link rel="stylesheet" type="text/css" href="js/jquery.nanoscroller/nanoscroller.css" />
  <link rel="stylesheet" type="text/css" href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.select2/select2.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.slider/css/slider.css" />
	<link rel="stylesheet" type="text/css" href="js/intro.js/introjs.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.niftymodals/css/component.css" />
  <!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet" />
<!-- treeTable start-->

<link rel="stylesheet" href="css/jquery.treetable.theme.default.css" />
<link rel="stylesheet" href="css/jquery.treetable.css" />
<!-- treeTable end-->     

</head>
<body style="opacity: 1; margin-left: 0px;">
	<div style="width: 100%; height: 100%;">
		<div class="container-fluid" style="padding: 0px">
		<!-- 头部开始 -->
			<div class="page-head">
				<h2>权限管理</h2>
				<ol class="breadcrumb">
					<li><a href="welcome.do?center">首页</a></li>
					<li class="active">权限管理</li>
				</ol>
			</div>
		</div>
		<!-- 头部结束 -->

		<div class="cl-mcont">
			<div class="row">
				<div class="col-md-12">
					<div class="block-flat">
						<div class="header">
							<h3>权限管理</h3>
						</div>
				
						<div class="content">
							<div class="table-responsive">
								<div class="dataTables_wrapper form-inline">
								    <!-- 查询框开始 -->
									<div class="row"  style="display:none">
										<div class="col-sm-1"></div>
										<div class="col-sm-1" style="text-align: right; vertical-align: middle; height: 34px; line-height: 34px;">
											<label>名称</label>
										</div>
										<div class="col-sm-2">
											<input class="form-control" type="text" style="width: 100%" id="name_input">
										</div>
										<div class="col-sm-1" style="text-align: right; vertical-align: middle; height: 34px; line-height: 34px;">
											<label>起始创建时间</label>
										</div>
										<div class="col-sm-2">
											<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;">
												<input class="form-control" size="16" value="" readonly="" type="text" id="createdate_start">
												<span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
											</div>
										</div>
										<div class="col-sm-1" style="text-align: right; vertical-align: middle; height: 34px; line-height: 34px;">
											<label>结束创建时间</label>
										</div>
										<div class="col-sm-2">
											<div class="input-group date datetime"
												data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;">
												<input class="form-control" size="16" value="" readonly="" type="text" id="createdate_end">
												<span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
											</div>
										</div>
										<div class="col-sm-1" style="text-align: center;">
										    <c:if test="${module_query_btn_control != 'yes' or module_query_btn_show == 'yes'}">
											<button class="btn btn-primary" style="margin-bottom: 0px !important; height: 34px;" onclick="query()">查询</button>
										    </c:if>
										</div>
									</div>
									<!-- 查询框结束 -->
									<!-- 操作按钮开始 -->
									<div class="row">
										<div class="col-sm-12">
										    <c:if test="${module_del_btn_control != 'yes' or module_del_btn_show == 'yes'}">
											<button type="button" class="btn btn-danger btn-flat" style="float: right; margin-right: 30px;" onclick="doDel()">
												<span><i class="fa fa-trash-o" style="margin-right:5px;"></i>删除</span>
											</button>
											</c:if>
											<c:if test="${module_edit_btn_control != 'yes' or module_edit_btn_show == 'yes'}">
											<button type="button" class="btn btn-primary btn-flat" style="float: right;" onclick="doEdit()">
												<span><i class="fa fa-pencil" style="margin-right:5px;"></i>编辑</span>
											</button>
											<button type="button" style="display: none" class="md-trigger" id="realyedit" data-modal="md-scale"></button>
											</c:if>
											<c:if test="${module_add_btn_control != 'yes' or module_add_btn_show == 'yes'}">											
											<button type="button" class="btn btn-primary btn-flat" style="float: right;" onclick="doAdd1()">
												<span><i class="fa fa-plus" style="margin-right:5px;"></i>新增一级菜单</span>
											</button>
											<button type="button" style="display: none" class="md-trigger" id="fake_add" data-modal="md-scale"></button>
											</c:if>
											<c:if test="${module_add_app_btn_control != 'yes' or module_add_app_btn_show == 'yes'}">											
											<button type="button" class="btn btn-primary btn-flat" style="float: right;" onclick="doAddApp()">
												<span><i class="fa fa-plus" style="margin-right:5px;"></i>新增app菜单</span>
											</button>
											<button type="button" style="display: none" class="md-trigger" id="fake_app" data-modal="md-scale"></button>
											</c:if>
										</div>
									</div>
									<!-- 操作按钮结束 -->
                                    <!-- 数据表格开始 -->
									<div class="row">
										<div class="col-sm-12">							
											<table class="table table-bordered dataTable" id="datatable" aria-describedby="datatable_info">
												<thead>
													<tr role="row">
														<th><strong>模块名称</strong></th>
														<th><strong>模块标识</strong></th>
														<th><strong>模块类型</strong></th>
														<th><strong>模块地址</strong></th>
														<th><strong>模块图标</strong></th>
														<th style="display:none"><strong>父模块ID</strong></th>
														<th style="display:none"><strong>创建用户ID</strong></th>
														<th style="display:none"><strong>创建时间</strong></th>
														<th style="display:none"><strong>更新用户ID</strong></th>
														<th style="display:none"><strong>更新时间</strong></th>
														<th><strong>显示顺序</strong></th>
														<th><strong>操作</strong></th>
													</tr>
												</thead>
												<tbody id="datacontainer" role="alert" aria-live="polite" aria-relevant="all">												
												</tbody>
												
												</table>
										</div>
									</div>
									<!-- 数据表格结束 -->
								    <!-- 数据条数提示开始 -->
									<div class="row" style="display:none">
										<div class="col-sm-12">
											<div class="pull-left">
												<div id="datatable_info" class="dataTables_info">
													当前显示0 条总记录中的第0-0条
												</div>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<!-- 数据条数提示结束 -->
								    <!-- 分页条开始 -->
									<div class="row" style="display:none">
										<div class="col-sm-4">
											<div class="dataTables_length" id="datatable2_length">
												<label style="margin-top:18px;">每页 <select id="pageSizeSelector" class="form-control" aria-controls="datatable2" size="1" name="datatable2_length" onchange="query()"><option selected="selected" value="10">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select> 条</label>
											</div>
										</div>
										<div class="col-sm-8">
											<div class="pull-right">
												<div class="dataTables_paginate paging_bs_normal">
													<ul id="paginationArea" class="pagination">
													<li class="prev disabled"><a href="#"><span class="fa fa-angle-left"></span>&nbsp;上一页</a></li>
													<li class="active"><a href="#">1</a></li>
													<li class="next"><a href="#">下一页&nbsp;<span class="fa fa-angle-right"></span></a></li></ul>
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
	<div class="md-modal md-effect-1" id="md-scale" style="height:650px;background:#fff;">
    	<div class="row">
			<div class="col-md-12">
				<div class="block-flat">
					<div class="header">
						<h3>页面模块(父菜单、子菜单、页面元素)信息</h3>
					</div>
			
					<div class="content">
						<form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
							<input type="hidden" name="entityId" id="entityId">
							<div class="form-group">
								<label class="col-sm-3 control-label">父模块</label>
								<div class="col-sm-6">
									<input id="parentId" type="hidden">
									<input id="parentName" type="text" class="form-control" disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">模块类型</label>
								<div class="col-sm-6" disabled="disabled">
									<input id="type" type="hidden">
									<input id="typeName" type="text" class="form-control" disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label color-danger">*模块名称</label>
								<div class="col-sm-6">
									<input id="name" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label color-danger">*模块标识</label>
								<div class="col-sm-6">
									<input id="code" type="text" class="form-control">
								</div>
							</div>														
							<div class="form-group">
								<label class="col-sm-3 control-label">模块地址</label>
								<div class="col-sm-6">
									<input id="url" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">模块图标</label>
								<div class="col-sm-6">
									<input id="icon" type="text" class="form-control">
								</div>
							</div>							
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">创建用户ID</label>
								<div class="col-sm-6">
									<input id="createUserId" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">创建时间</label>
								<div class="col-sm-6">
									<input id="createTime" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">更新用户ID</label>
								<div class="col-sm-6">
									<input id="updateUserId" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">更新时间</label>
								<div class="col-sm-6">
									<input id="updateTime" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">显示顺序</label>
								<div class="col-sm-6">
									<input id="showIndex" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="text-align: center;">
								<button type="button" class="btn btn-primary btn-rad" onclick="saveInfo();">
									<span><i class="fa fa-check" style="margin-right:5px;"></i>保存</span>
								</button>
								<button id="cancel_button" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
									<span><i class="fa fa-times" style="margin-right:5px;"></i>取消</span>
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Nifty Modal -->
	
	<!-- 二次确认是否删除 模态框 -->
	  <div class="md-modal md-effect-1" id="isSure2Delete"  >
      <div class="row">
     
        <div class="col-md-12">
         <div class="block-flat">
       		 <div class="header">
              <h4>是否确认删除选中的页面模块信息</h4>
            </div>
            <div class="content">
			<p id="isSure2DeleteInfo" style="font-size:18px;margin:20px">删除该模块会连带删除此模块下的子模块,确认删除吗?</p>
			
              <div class="form-group" style="text-align: center;">
                <button type="button" class="btn btn-success btn-rad " id="Sure2Delete">
                  <span><i class="fa fa-check" style="margin-right:5px;"></i>确定</span>
                </button>
                <button id="cancel2Delete" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;" >
                  <span><i class="fa fa-times" style="margin-right:5px;"></i>取消</span>
                </button>
              </div>
			</div>
          </div>
        </div>
      </div>
    </div>

	<div class="md-overlay"></div> <!-- Nifty Modal的遮罩层-->
	
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.gritter/js/jquery.gritter.js"></script>
<script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
<script type="text/javascript" src="js/behaviour/general.js"></script>
<script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
<script type="text/javascript" src="js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
<script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="js/jquery.select2/select2.min.js" type="text/javascript"></script>
<script src="js/skycons/skycons.js" type="text/javascript"></script>
<script src="js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
<script src="js/intro.js/intro.js" type="text/javascript"></script> 
<script src="js/behaviour/voice-commands.js"></script>
<script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.resize.js"></script>
<script type="text/javascript" src="js/jquery.flot/jquery.flot.labels.js"></script>
<script type="text/javascript" src="js/jquery.niftymodals/js/jquery.modalEffects.js"></script>
<script src="js/jquery.treetable.js"></script>
<script type="text/javascript">
var currentshownpage = 1;
var path="systemModule.do";

$(document).ready(function(){
    App.init();
    $(".md-trigger").modalEffects();
	query();	
});
/**
 * 新增一级菜单
 */
function doAdd1() {    
        $("#entityId").val("");
		$("#name").val("");
		$("#code").val("");
		$("#url").val("");
		$("#icon").val("");	
		$("#createUserId").val("");
		$("#createTime").val("");
		$("#updateUserId").val("");
		$("#updateTime").val("");
		$("#showIndex").val(""); 
        
        $("#parentId").val("0");
		$("#parentName").val("根节点");
		$("#type").val("1");
		$("#typeName").val("一级菜单");
	    
	    $("#fake_add").click();  //可以创建子节点时，才显示新增的框

}

/**
 * 新增App一级菜单
 */
function doAddApp() {    
        $("#entityId").val("");
		$("#name").val("");
		$("#code").val("");
		$("#url").val("");
		$("#icon").val("");	
		$("#createUserId").val("");
		$("#createTime").val("");
		$("#updateUserId").val("");
		$("#updateTime").val("");
		$("#showIndex").val(""); 
        
        $("#parentId").val("0");
		$("#parentName").val("根节点");
		$("#type").val("4");
		$("#typeName").val("app菜单");
	    
	    $("#fake_app").click();  //可以创建子节点时，才显示新增的框

}

/**
 * 新增二级菜单和页面元素
 * @param parentId 父模块的ID
 */
function doAdd(parentId,type,parentName) {    
        $("#entityId").val("");
		$("#name").val("");
		$("#code").val("");
		$("#url").val("");
		$("#icon").val("");	
		$("#createUserId").val("");
		$("#createTime").val("");
		$("#updateUserId").val("");
		$("#updateTime").val("");
		$("#showIndex").val(""); 
    

	if(type==3){
	    alert("无法创建页面元素子节点！");
	}else{
	        if(type==1){
				$("#type").val("2");
				$("#typeName").val("二级菜单");
				
			}else if(type==2){
			    $("#type").val("3");
				$("#typeName").val("页面元素");
			}
	        $("#parentId").val(parentId);
	        $("#parentName").val(parentName);					
	    $("#fake_add").click();  //可以创建子节点时，才显示新增的框
	}
	
	
	
	
}


function doEdit() {
	var selectedItemNumber = $("#datatable tbody .selected").length;
	if (selectedItemNumber > 0) {
		var id2edit = $("#datatable tbody .selected").attr("data-tt-id");
		
		var reqmsg="{'action':'QUERY_MODULE_INFO_REQUEST','content':{\"parentModuleShow\":\"true\",";
		if (id2edit != null && id2edit != "") {
			reqmsg += "\"id\":" + id2edit + ",";
		}
		reqmsg += "}}";
		
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : path+"?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	  changeInfo(data);
	            	  $("#realyedit").click();
	              }else if(data.des=="failure"){
	                 alert("查询失败");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });
	} else {
		alert("请选择要编辑的数据");
	}
}

/**
 * 编辑模块信息
 * @param moduleId 模块的ID
 */
function editModule(moduleId) {
	var id2edit = $("#datatable tbody .selected").attr("data-tt-id");

	var reqmsg = "{'action':'QUERY_MODULE_INFO_REQUEST','content':{\"parentModuleShow\":\"true\",";
	if (moduleId != null && moduleId != "") {
		reqmsg += "\"id\":" + moduleId + ",";
	}
	reqmsg += "}}";
	
	jQuery.ajax({
		type : "post",
		async : true,
		url : path + "?handler",
		dataType : "json",
		data: {
			"reqmsg":reqmsg
		},
		success : function(data) {
			if (data.des == "success") {
				changeInfo(data);
				$("#realyedit").click();
			} else if(data.des == "failure"){
				alert("查询要编辑的模块信息失败");
			}
		},
		error:function() {
			alert("error");
		}
	});
}

/**
 * 删除模块信息
 * @param moduleId 模块的ID
 */
function delModule(moduleId) {
	//判断是否有子节点
	var nextNodeParentId = $("#datatable tbody .selected").next().attr("data-tt-parent-id");
	if (moduleId != nextNodeParentId) {
		$("#isSure2Delete").addClass("md-show");
		//document.getElementById("isSure2DeleteInfo").innerHTML = ; 	//要删除哪些信息在此展示
		document.getElementById("Sure2Delete").onclick = function() {
			$("#isSure2Delete").removeClass("md-show");
			jQuery.ajax({
				type:"post",
				url:path+"?del",
				async:true,
				dataType:"json",
				data:{ids:moduleId},
				success:function(data) {
					if (data.result == "success") {
						var myiframe = window.parent.frames['welcomeCenter'];
						myiframe.src = myiframe.src
					} else if (data.des == "failure") {
						alert(data.des);
	                }
				},
				error:function() {
					alert("error");
				}
			});
		}
		document.getElementById("cancel2Delete").onclick = function(){
			$("#isSure2Delete").removeClass("md-show");
		}
	} else {
		alert("请先删除子节点");
	}
}

function doDel() {
	var selectedItemNumber = $("#datatable tbody .selected").length;
	if (selectedItemNumber > 0) {
		var ids2del = "";
		var ids2del = $("#datatable tbody .selected").attr("data-tt-id");
		//判断是否有子节点
		var nextNodeParentId = $("#datatable tbody .selected").next().attr("data-tt-parent-id");
		if(ids2del!=nextNodeParentId){
			$("#isSure2Delete").addClass("md-show");
			//document.getElementById("isSure2DeleteInfo").innerHTML = ; 	//要删除哪些信息在此展示
			document.getElementById("Sure2Delete").onclick = function(){
				$("#isSure2Delete").removeClass("md-show");
			    jQuery.ajax({
				type:"post",
				url:path+"?del",
				async:true,
				dataType:"json",
				data:{ids:ids2del},
				success:function(data) {
					if (data.result == "success") {
						//go2page(currentshownpage);
						var myiframe = window.parent.frames['welcomeCenter'];
	                    myiframe.src = myiframe.src
					}else if(data.result=="failure"){
	                 	alert(data.des);
	                } else {
	                	alert(data.result);
	                }
				},
				error:function() {
					alert("error");
				}
		    });
			}
			document.getElementById("cancel2Delete").onclick = function(){
			$("#isSure2Delete").removeClass("md-show");}

		}else {
		alert("请先删除子节点");
	}				
	} else {
		alert("请选择要删除的数据");
	}
}

/**
 * 保存信息
 * @method saveInfo
 */
function saveInfo() {
	var id = $("#entityId").val();
	var name = $("#name").val();
	var code = $("#code").val();
	var type = $("#type").val();
	var url = $("#url").val();
	var icon = $("#icon").val();
	var parentId = $("#parentId").val();
	var createUserId = $("#createUserId").val();
	var createTime = $("#createTime").val();
	var updateUserId = $("#updateUserId").val();
	var updateTime = $("#updateTime").val();
	var showIndex = $("#showIndex").val();
	
	
	//校验
	if(name.length==0){
	    alert("必填项：模块名称为空");
	    return;
	}
	if(code.length==0){
	    alert("必填项：模块标识为空");
	    return;
	}
	if(showIndex.length==0){
	   showIndex=0;
	}	
	
	var reqmsg="{'action':'ADD_MODULE_INFO_REQUEST','content':{";
	if (id != null && id != "") {
		reqmsg += "\"id\":" + id + ",";
	}
	    reqmsg += "\"name\":\"" + name + "\",";
	    reqmsg += "\"code\":\"" + code + "\",";
    if (type != null && type != "") {
        reqmsg += "\"type\":" + type + ",";
	}else{
        reqmsg += "\"type\":0,";
	}
	    reqmsg += "\"url\":\"" + url + "\",";
	    reqmsg += "\"icon\":\"" + icon + "\",";
    if (parentId != null && parentId != "") {
        reqmsg += "\"parentId\":" + parentId + ",";
	}else{
        reqmsg += "\"parentId\":0,";
	}
    if (createUserId != null && createUserId != "") {
        reqmsg += "\"createUserId\":" + createUserId + ",";
	}else{
        reqmsg += "\"createUserId\":0,";
	}
	    reqmsg += "\"createTime\":\"" + createTime + "\",";
    if (updateUserId != null && updateUserId != "") {
        reqmsg += "\"updateUserId\":" + updateUserId + ",";
	}else{
        reqmsg += "\"updateUserId\":0,";
	}
	    reqmsg += "\"updateTime\":\"" + updateTime + "\",";
	if (showIndex != null && showIndex != "") {
        reqmsg += "\"showIndex\":" + showIndex + ",";
	}else{
        reqmsg += "\"showIndex\":0,";
	}
	
	reqmsg += "}}";
	
	jQuery.ajax({
          type : "post",
          async:true,
          url : path+"?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg
          },
          success : function(data){
              if(data.des=="success"){
              	$("#cancel_button").click();
            	  //go2page(currentshownpage);
            	  var myiframe = window.parent.frames['welcomeCenter'];
                  myiframe.src = myiframe.src
              }else if(data.des=="failure"){
                 alert(data.result);
              }
          },
          error:function(){
	           alert("error");
          }
     });
}

function go2page(pagenumber){
	var pagesize = $("#pageSizeSelector option:selected").val();
	var name2search = $("#name_input").val();
	var timestart = $("#createdate_start").val();
	var timeend = $("#createdate_end").val();
	var reqmsg="{'action':'QUERY_MODULE_LIST_REQUEST','order':[{'column':'showIndex','type':'asc'}],'page':{'pageno':'" + pagenumber + "','pagesize':'10000'},'content':{";
	
	if (name2search != null && name2search != "") {
		reqmsg += "\"name_like\":\"" + name2search + "\",";
	}
	if (timestart != null && timestart != "") {
	    timestart = timestart.substring(0, 4) + timestart.substring(5, 7) + timestart.substring(8, 10) + "000000";
		reqmsg += "\"createTime_ge\":\"" + timestart + "\",";
	}
	if (timeend != null && timeend != "") {
		timeend = timeend.substring(0, 4) + timeend.substring(5, 7) + timeend.substring(8, 10) + "240000";
		reqmsg += "\"createTime_le\":\"" + timeend + "\",";
	}
	reqmsg += "\"type_in\":\"1,4\",";	
	reqmsg += "\"childModuleListShow\":\"true\",";	
	reqmsg += "}}";
	
    jQuery.ajax({
          type : "post",
          async:true,
          url : path+"?handler",
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
	           alert("error");
          }
     });
}

function getChildTreeCode(childModuleList){
    var htmlcode = "";
    if (childModuleList != null) {
		jQuery.each(childModuleList, function(i, item) {		
			htmlcode += "<tr class=\"gradeA odd\" data-tt-id='"+item.id+"' data-tt-parent-id='"+item.parentId+"'>";
		    			
		    if(item.type==1){
		      htmlcode += "<td>" + item.name + "</td>";				
		      htmlcode += "<td>" + item.code + "</td>";	
		      htmlcode += "<td style=\"display:none\">" + item.type + "</td>";	
		      htmlcode += "<td>一级菜单</td>";	
		      
		    }else if(item.type==2){
		      htmlcode += "<td><i class=\"fa "+ item.icon +"\"></i>" + item.name + "</td>";				
		      htmlcode += "<td>" + item.code + "</td>";	
		      htmlcode += "<td style=\"display:none\">" + item.type + "</td>";	
		      htmlcode += "<td>二级菜单</td>";	
		    }else if(item.type==3){
		      htmlcode += "<td><i class=\"fa fa-tablet\"></i>" + item.name + "</td>";				
		      htmlcode += "<td>" + item.code + "</td>";	
		      htmlcode += "<td style=\"display:none\">" + item.type + "</td>";	
		      htmlcode += "<td>页面元素</td>";	
		    }else if(item.type==4){
		     htmlcode += "<td>" + item.name + "</td>";				
		      htmlcode += "<td>" + item.code + "</td>";	
		      htmlcode += "<td style=\"display:none\">" + item.type + "</td>";	
		      htmlcode += "<td>App菜单</td>";	
		    }
		    			
		    htmlcode += "<td>" + item.url + "</td>";				
		    htmlcode += "<td><i class=\"fa "+ item.icon +"\"></i>" + item.icon + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.parentId + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.createUserId + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.createTime + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.updateUserId + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.updateTime + "</td>";	
		    htmlcode += "<td>" + item.showIndex + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.treeNum + "</td>";			
		    
		    htmlcode += "<td><div class=\"btn-group\">";
			htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
			htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
			htmlcode += "<span class=\"caret\" style=\"padding:0;\"></span>";
			htmlcode += "<span class=\"sr-only\">Toggle Dropdown</span>";
			htmlcode += "</button>";
			htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";
			<c:if test="${module_addson_opt_control != 'yes' or module_addson_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"doAdd('" + item.id +"','"+item.type+"','"+item.name+ "')\"><a href=\"###\">新增子节点</a></li>";
			</c:if>	
			<c:if test="${module_edit_opt_control != 'yes' or module_edit_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"editModule('" + item.id + "')\"><a href=\"###\">编辑</a></li>";
			</c:if>	
			<c:if test="${module_del_opt_control != 'yes' or module_del_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"delModule('" + item.id + "')\"><a href=\"###\">删除</a></li>";
			</c:if>	
			htmlcode += "</ul>";
			htmlcode += "</div></td>";
			htmlcode += "</tr>";
			htmlcode += getChildTreeCode(item.childModuleList)
		});
	}
    return htmlcode;
}

function changeData(data){
	var htmlcode = "";
	if (data.content != null) {
		jQuery.each(data.content.moduleList, function(i, item) {		
			htmlcode += "<tr class=\"gradeA odd\" data-tt-id='"+item.id+"' data-tt-parent-id='"+item.parentId+"'>";
		    htmlcode += "<td><i class=\"fa "+ item.icon +"\"></i>" + item.name + "</td>";			
		    htmlcode += "<td>" + item.code + "</td>";	
		    htmlcode += "<td style=\"display:none\">" + item.type + "</td>";				
		    if(item.type==1){
		      htmlcode += "<td>一级菜单</td>";	
		    }else if(item.type==2){
		      htmlcode += "<td>二级菜单</td>";	
		    }else if(item.type==3){
		      htmlcode += "<td>页面元素</td>";	
		    }else if(item.type==4){
		      htmlcode += "<td>App菜单</td>";	
		    }
		    			
		    htmlcode += "<td>" + item.url + "</td>";				
		    htmlcode += "<td><i class=\"fa "+ item.icon +"\"></i>" + item.icon + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.parentId + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.createUserId + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.createTime + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.updateUserId + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.updateTime + "</td>";	
		    htmlcode += "<td>" + item.showIndex + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.treeNum + "</td>";			
		    
		    
		    htmlcode += "<td><div class=\"btn-group\">";
			htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
			htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
			htmlcode += "<span class=\"caret\" style=\"padding:0;\"></span>";
			htmlcode += "<span class=\"sr-only\">Toggle Dropdown</span>";
			htmlcode += "</button>";
			htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";
			if(item.type!=4){
		      htmlcode += "<li onclick=\"doAdd('" + item.id +"','"+item.type+"','"+item.name+ "')\"><a href=\"###\">新增子节点</a></li>";
		    }
			
			htmlcode += "<li onclick=\"editModule('" + item.id + "')\"><a href=\"###\">编辑</a></li>";
			htmlcode += "<li onclick=\"delModule('" + item.id + "')\"><a href=\"###\">删除</a></li></ul>";
			htmlcode += "</div></td>";
		    
			htmlcode += "</tr>";
			htmlcode += getChildTreeCode(item.childModuleList)
		});
	}
	$("#datacontainer").html(htmlcode);
	

	  $("#datatable").treetable({ expandable: true });
      // Highlight selected row
      $("#datatable tbody").on("mousedown", "tr", function() {
        $(".selected").not(this).removeClass("selected");
        $(this).toggleClass("selected");
      });

      $("#datatable .folder").each(function() {
        $(this).parents("#datatable tr").droppable({
          accept: ".file, .folder",
          drop: function(e, ui) {
            var droppedEl = ui.draggable.parents("tr");
            $("#datatable").treetable("move", droppedEl.data("ttId"), $(this).data("ttId"));
          },
          hoverClass: "accept",
          over: function(e, ui) {
            var droppedEl = ui.draggable.parents("tr");
            if(this != droppedEl[0] && !$(this).is(".expanded")) {
              $("#datatable").treetable("expandNode", $(this).data("ttId"));
            }
          }
      });
     });
     jQuery('#datatable').treetable('expandAll');
	
	
	if (data.page != null) {
		genaratePaginateHtml(data.page.pageno, data.page.pageCount);
		genarateRecordNumberHtml(data.page.pageno, data.page.pagesize, data.page.recordCount);
	} else {
		genaratePaginateHtml(1, 1);
		genarateRecordNumberHtml(1, 10, 0);
	}	
}

function changeInfo(data){
    if (data.content != null) {
        $("#entityId").val(data.content.id);
		$("#name").val(data.content.name);
		$("#code").val(data.content.code);
		$("#type").val(data.content.type);
		$("#url").val(data.content.url);
		$("#icon").val(data.content.icon);
		$("#parentId").val(data.content.parentId);
		$("#createUserId").val(data.content.createUserId);
		$("#createTime").val(data.content.createTime);
		$("#updateUserId").val(data.content.updateUserId);
		$("#updateTime").val(data.content.updateTime);
		$("#showIndex").val(data.content.showIndex);
		$("#treeNum").val(data.content.treeNum);
		
		
		if(data.content.type==1){
		      $("#typeName").val("一级菜单");
		      $("#parentName").val("根节点");
		      $("#parentTreeNum").val("0");
		}else if(data.content.type==2){
		      $("#typeName").val("二级菜单");
		      $("#parentName").val(data.content.parentModule.name);
		      $("#parentTreeNum").val(data.content.parentModule.treeNum);
		}else if(data.content.type==3){
	          $("#typeName").val("页面元素");
	          $("#parentName").val(data.content.parentModule.name);
	          $("#parentTreeNum").val(data.content.parentModule.treeNum);
		}else if(data.content.type==4){
	          $("#typeName").val("App菜单");
		      $("#parentName").val("根节点");
		      $("#parentTreeNum").val("0");
		}
		
		
    }
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

function query() {
	go2page(1);
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
	currentshownpage = currentpage;

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

</script>
  </body>
</html>