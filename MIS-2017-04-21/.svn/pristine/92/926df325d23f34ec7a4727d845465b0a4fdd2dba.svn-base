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

<title>服务项目类别管理</title>

<!-- Bootstrap core CSS -->
<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet"
	href="fonts/font-awesome-4/css/font-awesome.min.css">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->
<link rel="stylesheet" type="text/css"
	href="js/jquery.gritter/css/jquery.gritter.css" />

<link rel="stylesheet" type="text/css"
	href="js/jquery.nanoscroller/nanoscroller.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />
<link rel="stylesheet" type="text/css"
	href="js/bootstrap.switch/bootstrap-switch.css" />
<link rel="stylesheet" type="text/css"
	href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery.select2/select2.css" />
<link rel="stylesheet" type="text/css"
	href="js/bootstrap.slider/css/slider.css" />
<link rel="stylesheet" type="text/css" href="js/intro.js/introjs.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery.niftymodals/css/component.css" />
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="js/jquery.datatables/bootstrap-adapter/css/datatables.css" />
<script type="text/javascript" src="js/sortListTool.js"></script>
</head>
<body style="opacity: 1; margin-left: 0px;">
	<div style="width: 100%; height: 100%;">
		<div class="container-fluid" style="padding: 0px">
			<!-- 头部开始 -->
			<div class="page-head">
				<h2>服务项目类别管理</h2>
				<ol class="breadcrumb">
					<li>系统设置</li>
					<input type="hidden" value="" id="sortType">
					<input type="hidden" value="" id="sortColumn">					
					<li class="active">服务项目类别管理</li>
				</ol>
			</div>
		</div>
		<!-- 头部结束 -->

		<div class="cl-mcont">
			<div class="row">
				<div class="col-md-12">
					<div class="block-flat">
						<div class="content">
							<div class="table-responsive">
								<div class="dataTables_wrapper form-inline">
									<!-- 查询框开始 -->
									<div class="row">
										<div class="col-sm-1" style="margin-bottom:5px;">
										 <c:if test="${dicService_query_btn_control != 'yes' or dicService_query_btn_show == 'yes'}">
											<button class="btn btn-primary"
												style="margin-bottom: 0px !important; height: 34px;"
												onclick="query()">查询</button>
										</c:if>
										</div>
										<div class="col-sm-1"
											style="clear:both;text-align: center; vertical-align: middle; height: 34px; line-height: 34px;width:60px;">
											<label>名称</label>
										</div>
										<div class="col-sm-2">
											<input class="form-control" type="text" style="width: 100%"
												id="name_input">
										</div>
										<!--<div class="col-sm-1" style="text-align: right; vertical-align: middle; height: 34px; line-height: 34px;">
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
										</div> -->
										
									</div>
									<!-- 查询框结束 -->
									<!-- 操作按钮开始 -->
									 <div class="row">
										<div class="col-sm-12">
											<!--<button type="button" class="btn btn-primary btn-flat" style="float: right;" onclick="doEdit()">
												<span><i class="fa fa-pencil" style="margin-right:5px;"></i>编辑</span>
											</button>-->
											<button type="button" style="display: none" class="md-trigger" id="realyedit" data-modal="md-scale"></button>
											<div style="float:left";>
											<ol class="breadcrumb" style="background:white; margin-left: 16px;margin-bottom:0;" id="breadcrumb2">
											</ol>
											</div>
											<div style="float:right";>
											<c:if test="${dicService_del_btn_control != 'yes' or dicService_del_btn_show == 'yes'}">
											<button type="button" class="btn btn-danger btn-flat" style="float: right; margin-right: 30px;" onclick="doDel()">
												<span><i class="fa fa-trash-o" style="margin-right:5px;"></i>删除</span>
											</button>
											</c:if>
											<c:if test="${dicService_gx_btn_control != 'yes' or dicService_gx_btn_show == 'yes'}">
											<button type="button" class="btn btn-primary btn-flat" style="float: right;" onclick="dogx()">
												<span><i class="fa fa-refresh" style="margin-right:5px;"></i>更新</span>
											</button>
											</c:if>
<!-- 											<c:if test="${dicService_add_btn_control != 'yes' or dicService_add_btn_show == 'yes'}"> -->
<!-- 											<button type="button" class="btn btn-primary btn-flat md-trigger" data-modal="md-scale" style="float: right;" onclick="doAdd()"> -->
<!-- 												<span><i class="fa fa-plus" style="margin-right:5px;"></i>新增</span> -->
<!-- 											</button> -->
<!-- 											</c:if> -->
											</div>
										</div>
									</div> 
									<!-- 操作按钮结束 -->
									<!-- 数据表格开始 -->
									<div class="row"  style="margin-top:0;">
										<div class="col-sm-12">
											<table class="table table-bordered dataTable hover"
												id="datatable" aria-describedby="datatable_info">
												<thead>
													<tr role="row">
														<th style="width:2%;"><input id="allselectchecker"
															type="checkbox" class="col_selector"
															onclick="selectAll();"></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_name')"><strong>名称</strong></th>
														<th><strong>层级</strong></th>
														<th><strong>上级名称</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'createTime')"><strong>创建时间</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'updateTime')"><strong>编辑时间</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_des')"><strong>备注</strong></th>
														<th><strong>操作</strong></th>
													</tr>
												</thead>
												<tbody id="datacontainer" role="alert" aria-live="polite"
													aria-relevant="all">
												</tbody>
											</table>
										</div>
									</div>
									<!-- 数据表格结束 -->
									<!-- 数据条数提示开始 -->
									<div class="row">
										<div class="col-sm-12">
											<div class="pull-left">
												<div id="datatable_info" class="dataTables_info">
													当前显示0 条总记录中的第0-0条</div>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<!-- 数据条数提示结束 -->
									<!-- 分页条开始 -->
									<div class="row">
										<div class="col-sm-4">
											<div class="dataTables_length" id="datatable2_length">
												<label style="margin-top:18px;">每页 <select
													id="pageSizeSelector" class="form-control"
													aria-controls="datatable2" size="1"
													name="datatable2_length" onchange="querys()"><option
															selected="selected" value="10">10</option>
														<option value="25">25</option>
														<option value="50">50</option>
														<option value="100">100</option>
												</select> 条</label>
											</div>
										</div>
										<div class="col-sm-8">
											<div class="pull-right">
												<div class="dataTables_paginate paging_bs_normal">
													<ul id="paginationArea" class="pagination">
														<li class="prev disabled"><a href="#"><span
																class="fa fa-angle-left"></span>&nbsp;上一页</a></li>
														<li class="active"><a href="#">1</a></li>
														<li class="next"><a href="#">下一页&nbsp;<span
																class="fa fa-angle-right"></span> </a></li>
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
	<div class="md-modal md-effect-1" id="md-scale">
		<div class="row">
			<div class="col-md-12">
				<div class="block-flat">
					<div class="header">
						<h3>数据字典信息</h3>
					</div>

					<div class="content">
						<form class="form-horizontal group-border-dashed" action="#"
							style="border-radius: 0px;">
							<input type="hidden" name="parentlinshi" id="parentlinshi" value="5187">
							<input type="hidden" name="addOrEdit" id="addOrEdit">
							<input type="hidden" name="entityId" id="entityId">
							<div class="form-group">
								<label class="col-sm-3 control-label">名称</label>
								<div class="col-sm-6">
									<input id="namet" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">层级</label>
								<div class="col-sm-6">
									<input id="cengji" readonly="readonly" rea type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">上级名称</label>
								<div class="col-sm-6">
									<input id="lastName" readonly="readonly" type="text" class="form-control">
								</div>
							</div>
<!-- 							<div class="form-group"> -->
<!-- 								<label class="col-sm-3 control-label">编辑时间</label> -->
<!-- 								<div class="col-sm-6"> -->
<!-- 									<input id="editTime" readonly="readonly" type="text" class="form-control"> -->
<!-- 								</div> -->
<!-- 							</div> -->
							<div class="form-group">
								<label class="col-sm-3 control-label">备注</label>
								<div class="col-sm-6">
								   <textarea class="form-control" id="des"></textarea>
								</div>
							</div>
							<div class="form-group" style="text-align: center;">
								<button type="button" class="btn btn-primary btn-rad"
									onclick="saveInfo();">
									<span><i class="fa fa-check" style="margin-right:5px;"></i>保存</span>
								</button>
								<button id="cancel_button" type="button"
									class="btn btn-primary btn-rad md-close"
									style="margin-left: 50px;">
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
              <h4>是否确认删除选中的数据节点</h4>
            </div>
            <div class="content">
			<p id="isSure2DeleteInfo" style="font-size:18px;margin:20px">删除该节点会连带删除节点下子节点,确认删除吗?</p>
			
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
	
	<div class="md-overlay"></div>
	<!-- Nifty Modal的遮罩层-->

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript"
		src="js/jquery.gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript"
		src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
	<script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript"
		src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript"
		src="js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
	<script type="text/javascript"
		src="js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript"
		src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript"
		src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/jquery.select2/select2.min.js" type="text/javascript"></script>
	<script src="js/skycons/skycons.js" type="text/javascript"></script>
	<script src="js/bootstrap.slider/js/bootstrap-slider.js"
		type="text/javascript"></script>
	<script src="js/intro.js/intro.js" type="text/javascript"></script>
	<script src="js/behaviour/voice-commands.js"></script>
	<script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
	<script type="text/javascript"
		src="js/jquery.flot/jquery.flot.resize.js"></script>
	<script type="text/javascript"
		src="js/jquery.flot/jquery.flot.labels.js"></script>
	<script type="text/javascript"
		src="js/jquery.niftymodals/js/jquery.modalEffects.js"></script>
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
		gopage(currentshownpage);
	}
	
var currentshownpage = 1;
var path="systemDataDic.do";

$(document).ready(function(){
    App.init();
    $(".md-trigger").modalEffects();
    $("#breadcrumb2").html("<li><a href=\"#\" onclick=\"javascript:query2('5187',1);\">服务项目类别</a></li>");	
	go2page("",1);
});

//复选框全选
function selectAll() {
	if ($("#allselectchecker").is(':checked')) {
		$(".col_selector").prop("checked", true);
	} else {
		$(".col_selector").prop("checked", false);
	}
}

//查询
function query() {
	if($("#name_input").val() == ""){
		return;
	}else{
		if($("#name_input").val().length > 50){
			alert("查询条件最多50个字符");
			return;
		}
		$("#parentlinshi").val("");
 		$("#breadcrumb2").html("<li><a href=\"#\" onclick=\"javascript:query2('5187',1);\">服务项目类别</a></li>");	
 		$("#datacontainer").html("");
		go2page("",1);
	}
}

//改变每页行数查询
function querys() {
	$("#name_input").val("");
	$("#parentlinshi").val("5187");
 	$("#breadcrumb2").html("<li><a href=\"#\" onclick=\"javascript:query2('5187',1);\">服务项目类别</a></li>");	
	go2page("",1);
}

//查询数据
function go2page(id,pagenumber){
	var parentIdf = $("#parentlinshi").val();
	var pagesize = $("#pageSizeSelector option:selected").val();
	var name2search = $("#name_input").val();
	var reqmsg="{'action':'QUERY_DATA_DIC_LIST_REQUEST',";
	
	var sortType = $("#sortType").val();
	var sortColumn = $("#sortColumn").val();
	if(sortType != null && sortType != ""){
		reqmsg += "'order':[{'column':'" + sortColumn + "','type':'" + sortType + "'}],";
	}
	
	reqmsg += "'page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{";
	
	reqmsg += "\"code\":\"SERVICE_TYPE\",";
	
	if (id != null && id != "") {
		reqmsg += "\"id_in\":\"" + id + "\",";
	}
	
	if (name2search != null && name2search != "") {
		reqmsg += "\"name_like\":\"" + name2search + "\",";
	}
	
	if (parentIdf != null && parentIdf != "") {
		reqmsg += "\"parentId\":" + parentIdf + ",";
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

//根据parentID查找上级名称
function queryParentMenu(parentID){
    var val=["无","无"];
    jQuery.ajax({
          type : "post",
          async:false,
          url : path+"?dealHierarchy",
          dataType : "json",
          data: {
               "parentId":parentID
          },
          success : function(data){
              	val[0]=data.ceng;
              	val[1]=data.cengName;
          },
          error:function(){
	           alert("error");
          }
     });
     return val;
}

//数据列表
function changeData(data){
	var htmlcode = "";
	if (data.content != null) {
		jQuery.each(data.content.dataDicList, function(i, item) {
			htmlcode += "<tr class=\"gradeA odd\"><td><input type=\"checkbox\" value=\"" + item.id + "\" class=\"col_selector\"></td>";		
			if(item.name.length > 10){
		     	htmlcode += "<td onclick=\"query2('" + item.id + "',1)\" style=\"cursor:pointer;text-decoration:underline;\">" + item.name.substr(0,10)+"..." + "</td>";
		    }else{
		    	htmlcode += "<td onclick=\"query2('" + item.id + "',1)\" style=\"cursor:pointer;text-decoration:underline;\">" + item.name + "</td>";
		    }
		    
		    if(item.parentId == 0){
		      htmlcode += "<td>" + "1"+"</td>";
		      htmlcode += "<td>" +"无"+ "</td>";	
		    }else{
		    	var val = queryParentMenu(item.parentId);
		    	htmlcode += "<td>" + val[0]+"</td>";
		       	htmlcode += "<td>" + val[1]+ "</td>";	
		    }	
		    htmlcode += "<td>" + formateTime(item.createTime)+"</td>";
		    htmlcode += "<td>" + formateTime(item.updateTime)+"</td>";
		    if(item.des.length > 30){
		     	htmlcode += "<td>" + item.des.substr(0,30)+"..." + "</td>";	
		    }else{
		    	htmlcode += "<td>" + item.des + "</td>";	
		    }
		    htmlcode += "<td><div class=\"btn-group\">";
			htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
			htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
			htmlcode += "<span class=\"caret\" style=\"padding:0;\"></span>";
			htmlcode += "<span class=\"sr-only\">Toggle Dropdown</span>";
			htmlcode += "</button>";
			htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";
			<c:if test="${dicService_query_opt_control != 'yes' or dicService_query_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"query2('" + item.id + "',1)\"><a href=\"###\">查看子节点</a></li>";
			</c:if>	
			<c:if test="${dicService_addself_opt_control != 'yes' or dicService_addself_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"addSelf('" + item.id + "')\"><a href=\"###\">新增同级节点</a></li>";
			</c:if>
			<c:if test="${dicService_addson_opt_control != 'yes' or dicService_addson_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"addModule('" + item.id + "')\"><a href=\"###\">新增子节点</a></li>";
			</c:if>	
			<c:if test="${dicService_edit_opt_control != 'yes' or dicService_edit_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"editModule('" + item.id + "')\"><a href=\"###\">编辑</a></li>";
			</c:if>	
			<c:if test="${dicService_del_opt_control != 'yes' or dicService_del_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"delModule('" + item.id + "')\"><a href=\"###\">删除</a></li>";
			</c:if>	
			htmlcode += "</ul>";
			htmlcode += "</div></td>";
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

//查看子节点
function query2(id,pagenumber) {
	 var ids="";
	 if(id != ""){
	 jQuery.ajax({
          type : "post",
          async:false,
          url : path+"?querySonId",
          dataType : "json",
          data: {
               "parentId":id
          },
          success : function(data){
          	if(data.id == "无"){
              	ids=",";
          	}else{
          		ids=data.id;
          	}
          },
          error:function(){
	           alert("error");
          }
     });
     }
     if(ids == ","){
     	alert("下面没有子节点了！");
     	return;
     }
     
	if(id != ""){
		$("#name_input").val("");
	}
	$("#parentlinshi").val(id);

	//生成导航
	var htmlcode="<li><a href=\"#\" onclick=\"javascript:query2('5187',1);\">服务项目类别</a></li>";
	var val=["无","无"];
	if(id != ""){
    jQuery.ajax({
          type : "post",
          async:false,
          url : path+"?dealHierarchy",
          dataType : "json",
          data: {
               "parentId":id
          },
          success : function(data){
              	val[0]=data.ids;
              	val[1]=data.cengName;
          },
          error:function(){
	           alert("error");
          }
     });
     var idSplit=val[0].split(",");
     var nameSplit=val[1].split("-");
     if(idSplit.length == nameSplit.length){
     	if(idSplit.length == 1){
     		htmlcode="";
     		//htmlcode="<li><a href=\"#\" onclick=\"javascript:query2('5187',1);\">服务项目类别</a></li>";
     		if(nameSplit[0] != "无"){
     			htmlcode=htmlcode+"<li><a href=\"#\" onclick=\"javascript:query2('"+idSplit[0]+"',1);\">"+nameSplit[0]+"</a></li>";
     		}
     	}else if(idSplit.length > 1){
     		htmlcode="";
     		//htmlcode="<li><a href=\"#\" onclick=\"javascript:query2('5187',1);\">服务项目类别</a></li>";
      		for(var j=0;j<idSplit.length;j++){
      			htmlcode=htmlcode+"<li class=\"active\"><a href=\"#\" onclick=\"javascript:query2('"+idSplit[j]+"',1);\">"+nameSplit[j]+"</a></li>";
      		}
      	}
 	 }
 	 }
 	 $("#breadcrumb2").html(htmlcode);	
	 
	go2page(ids,pagenumber);
}

//分页查看 
function gopage(pagenumber){
	if($("#name_input").val() == ""){
		go2page("",pagenumber);
	}else{
	   var parentlinshi=$("#parentlinshi").val();
	   query2(parentlinshi,pagenumber);
	}
}

//增加同级节点
function addSelf(id){
	$("#namet").val("");
	$("#des").val("");
	
	//查找父ID
	var parentId= 0;
	var reqmsg="{'action':'QUERY_DATA_DIC_LIST_REQUEST','content':{\"id\":"+id+"}}";
    jQuery.ajax({
          type : "post",
          async:false,
          url : path+"?handler",
          dataType : "json",
          data: {
               "reqmsg":reqmsg
          },
          success : function(data){
              if(data.des=="success"){
            	  if (data.content != null) {
						jQuery.each(data.content.dataDicList, function(i, item) {
							parentId = item.parentId;
						});
				  }
              }else if(data.des=="failure"){
                 alert("查询失败");
              }
          },
          error:function(){
	           alert("error");
          }
    });
	$("#entityId").val(parentId);
	if(parentId == 0){
		$("#cengji").val("1");
	 	$("#lastName").val("根目录");
	}else{
		var val = queryParentMenu(parentId);
		$("#cengji").val(val[0]);
		$("#lastName").val(val[1]);
	}
	$("#addOrEdit").val("0");//代表新增
 	$("#realyedit").click();
}

//增加子节点数据
function addModule(moduleId) {
	$("#namet").val("");
	$("#des").val("");
	$("#entityId").val(moduleId);
	var val = queryParentMenu(moduleId);
	$("#cengji").val(val[0]);
	$("#lastName").val(val[1]);
 	//$("#editTime").val(getNowFormatDate());
 	$("#addOrEdit").val("0");//代表新增
 	$("#realyedit").click();
}

/**
 * 编辑信息
 */
function editModule(moduleId) {
	var reqmsg="{'action':'QUERY_DATA_DIC_LIST_REQUEST','content':{\"id\":"+moduleId+"}}";
	
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
            	  if (data.content != null) {
						jQuery.each(data.content.dataDicList, function(i, item) {
							$("#namet").val(item.name);
							if(item.parentId == 0){
		      					$("#cengji").val("1");
		      					$("#lastName").val("无");
		    				}else{
		    					var val = queryParentMenu(item.parentId);
		    					$("#cengji").val(val[0]);
		      					$("#lastName").val(val[1]);
		    				}	
		    				//$("#editTime").val(getNowFormatDate());
		    				$("#des").val(item.des);
		    				$("#entityId").val(moduleId);
		    				$("#addOrEdit").val("1");//代表编辑
						});
						$("#realyedit").click();
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

/**
 * 保存信息
 * @method saveInfo
 */
function saveInfo() {
	var id = $("#entityId").val();
	var name = $("#namet").val();
	if($.trim(name) == ""){
		alert("名称不能为空");
		return;
	}
	if(name.length > 50){
		alert("名称最多为50个字");
		return;
	}
	var des = $("#des").val();
	if(des.length > 100){
		alert("备注信息最多为100个字");
		return;
	}
//	var editTime = $("#editTime").val();
	var addOrEdit = $("#addOrEdit").val();
	jQuery.ajax({
          type : "post",
          async:true,
          url : path+"?saveEdit",
          dataType : "json",
          data: {
               "id":id,
               "name":name,
               "des":des,
               "code":"SERVICE_TYPE",
               "addOrEdit":addOrEdit
          },
          success : function(data){
              if(data.result == "success"){
                 alert(data.des);
              	 $("#cancel_button").click();
              	 var a = $("#paginationArea .active").html();
              	 a=a.split(">")[1]; 
              	 a=a.split("<")[0]; 
              	 gopage(a);
              }else if(data.result == "failure"){
                 alert(data.des);
              }else{
                 alert("失败");
              }
          },
          error:function(){
	           alert("error");
          }
     });
}

//批量删除
function doDel() {
	var selectedItemNumber = $("tbody .col_selector:checked").length;
	if (selectedItemNumber >= 1) {
		var ids2del = "";
		$("tbody .col_selector:checked").each(function() {
			ids2del += $(this).val() + ",";
		});
		if (ids2del != "") {
			ids2del = ids2del.substring(0, ids2del.length - 1);
		}
		$("#isSure2Delete").addClass("md-show");
		document.getElementById("Sure2Delete").onclick = function(){   //使用.click会重复
		$("#isSure2Delete").removeClass("md-show");
		jQuery.ajax({
			type:"post",
			url:path+"?del",
			async:true,
			dataType:"json",
			data:{ids:ids2del},
			success:function(data) {
				alert(data.des);
				if (data.result == "success") {
				    var a = $("#paginationArea .active").html();
              		a=a.split(">")[1]; 
              		a=a.split("<")[0]; 
              		gopage(a);
				//	$("#name_input").val("");
				 //	$("#parentlinshi").val("0");
				 //	$("#breadcrumb2").html("");
              	 //	go2page("",1);
				}else if(data.des=="failure"){
                 alert("删除失败");
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
		alert("请选择要删除的数据");
	}
}


/**
 * 删除信息
 */
function delModule(moduleId) {
	$("#isSure2Delete").addClass("md-show");
	document.getElementById("Sure2Delete").onclick = function(){   //使用.click会重复
	$("#isSure2Delete").removeClass("md-show");
    jQuery.ajax({
          type : "post",
          async:true,
          url : path+"?deletHierarchy",
          dataType : "json",
          data: {
               "moduleId":moduleId
          },
          success : function(data){
          		if(data.result == "success"){
                    alert(data.des);
              		var a = $("#paginationArea .active").html();
              		a=a.split(">")[1]; 
              		a=a.split("<")[0]; 
              		gopage(a);
                }else if(data.result == "failure"){
                	alert(data.des);
                }else{
                	alert("失败");
                }
          },
          error:function(){
	           alert("error");
          }
     });
     }
	 document.getElementById("cancel2Delete").onclick = function(){
			$("#isSure2Delete").removeClass("md-show");
	 }
}

//获取当前时间
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
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
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + strHour + seperator2 + strMinutes
            + seperator2 + strSeconds;
    return currentdate;
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
	}else if (time != null && time.length == 12) {
		return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + " " + time.substring(8, 10) + ":" + time.substring(10, 12);
	}else{
		return time;
	}
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
		htmlcode += "<li class=\"pre\"><a href=\"#\" onclick=\"gopage('1')\"><span class=\"fa fa-angle-left\"></span>&nbsp;首页</a></li>";
		htmlcode += "<li class=\"pre\"><a href=\"#\" onclick=\"gopage('" + (currentpage - 1) + "')\"><span class=\"fa fa-angle-left\"></span>&nbsp;上一页</a></li>";
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
				htmlcode += "<li><a href=\"#\" onclick=\"gopage('" + i + "')\">" + i + "</a></li>";
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
				htmlcode += "<li><a href=\"#\" onclick=\"gopage('" + i + "')\">" + i + "</a></li>";
			}
		}
	}
	
	//下一页
	if (totalpage > currentpage) {
		htmlcode += "<li class=\"next\"><a href=\"#\" onclick=\"gopage('" + (parseInt(currentpage) + 1) + "')\">下一页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
		htmlcode += "<li class=\"next\"><a href=\"#\" onclick=\"gopage('" + parseInt(totalpage) + "')\">末页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
	} else {
		htmlcode += "<li class=\"next disabled\"><a href=\"#\">下一页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
		htmlcode += "<li class=\"next disabled\"><a href=\"#\">末页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
	}
	$("#paginationArea").html(htmlcode);
}

function dogx(){
	jQuery.ajax({
          type : "post",
          async:true,
          url : path+"?createJS",
          dataType : "json",
          data: {
          },
          success : function(data){
          		if(data.result == "success"){
                    alert(data.des);
                }else if(data.result == "failure"){
                	alert(data.des);
                }else{
                	alert("失败");
                }
          },
          error:function(){
	           alert("error");
          }
     });
}
</script>
</body>
</html>