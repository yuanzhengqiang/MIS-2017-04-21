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
  	<link rel="stylesheet" type="text/css" href="js/jquery.datatables/bootstrap-adapter/css/datatables.css" />
	<script type="text/javascript" src="js/sortListTool.js"></script>
</head>
<body style="opacity: 1; margin-left: 0px;">
	<div style="width: 100%; height: 100%;">
		<div class="container-fluid" style="padding: 0px">
		<!-- 头部开始 -->
			<div class="page-head">
				<h2>数据规则功能</h2>
				<ol class="breadcrumb">
					<li><a href="welcome.do?center">首页</a></li>
					<input type="hidden" value="" id="sortType">
					<input type="hidden" value="" id="sortColumn">
					<li class="active">数据规则功能</li>
				</ol>
			</div>
		</div>
		<!-- 头部结束 -->

		<div class="cl-mcont">
			<div class="row">
				<div class="col-md-12">
					<div class="block-flat">
						<div class="header">
							<h3>数据规则功能表格数据</h3>
						</div>
				
						<div class="content">
							<div class="table-responsive">
								<div class="dataTables_wrapper form-inline">
								    <!-- 查询框开始 -->
									<div class="row">
										
										<div class="col-sm-1" style=" vertical-align: middle; height: 34px; line-height: 34px;">
											<label>名称</label>
										</div>
										<div class="col-sm-5" style="margin-bottom:5px;">
											<input class="form-control" type="text" style="width: 100%" id="name_input">
										</div>
										<div class="col-sm-1" style="clear:both;vertical-align: middle; height: 34px; line-height: 34px;">
											<label>起始创建时间</label>
										</div>
										<div class="col-sm-5">
											<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;">
											<span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
												<input class="form-control" size="16" value="" readonly="" type="text" id="createdate_start" placeholder="开始时间">												
												<span class="input-group-btn"><button class="btn btn-danger deleteThisTime" type="button"><span class="fa fa-times"></span></button></span>
											</div>
										</div>
										<div class="col-sm-5">
											<div class="input-group date datetime"
												data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;">
												<span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
												<input class="form-control" size="16" value="" readonly="" type="text" id="createdate_end"  placeholder="结束时间">
												<span class="input-group-btn"><button class="btn btn-danger deleteThisTime" type="button"><span class="fa fa-times"></span></button></span>
											</div>
										</div>
									</div>
									<!-- 查询框结束 -->
									<!-- 操作按钮开始 -->
									<div class="row">
										<div class="col-sm-12">
										 <c:if test="${dataRule_query_control != 'yes' or dataRule_query_show == 'yes'}">
											<button class="btn btn-primary" style="margin-bottom: 0px !important; height: 34px;margin-left:0;" onclick="query()">查询</button>
										    </c:if>
										    <c:if test="${dataRule_del_control != 'yes' or dataRule_del_show == 'yes'}">
											<button type="button" class="btn btn-danger btn-flat" style="float: right; margin-right: 0px;" onclick="doDel()">
												<span><i class="fa fa-trash-o" style="margin-right:5px;"></i>删除</span>
											</button>
											</c:if>
											<c:if test="${dataRule_edit_control != 'yes' or dataRule_edit_show == 'yes'}">
											<button type="button" class="btn btn-primary btn-flat" style="float: right;" onclick="doEdit()">
												<span><i class="fa fa-pencil" style="margin-right:5px;"></i>编辑</span>
											</button>
											<button type="button" style="display: none" class="md-trigger" id="realyedit" data-modal="md-scale"></button>
											</c:if>
											<c:if test="${dataRule_add_control != 'yes' or dataRule_add_show == 'yes'}">
											<button type="button" class="btn btn-primary btn-flat md-trigger" data-modal="md-scale" style="float: right;" onclick="doAdd()">
												<span><i class="fa fa-plus" style="margin-right:5px;"></i>新增</span>
											</button>
											</c:if>
										</div>
									</div>
									<!-- 操作按钮结束 -->
                                    <!-- 数据表格开始 -->
									<div class="row">
										<div class="col-sm-12">							
											<table class="table table-bordered dataTable hover" id="datatable" aria-describedby="datatable_info">
												<thead>
													<tr role="row">
														<th style="width:2%;"><input id="allselectchecker" type="checkbox" class="col_selector" onclick="selectAll();"></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_name')"><strong>名称</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'entityName')"><strong>实体名</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_entityShow')"><strong>标签显示</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'dataCondition')"><strong>语法条件</strong></th>
														<th style="display:none"><strong>创建用户ID</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'createTime')"><strong>创建时间</strong></th>
														<th style="display:none"><strong>更新用户ID</strong></th>
														<th style="display:none"><strong>更新时间</strong></th>
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
												<div id="datatable_info" class="dataTables_info">
													当前显示0 条总记录中的第0-0条
												</div>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<!-- 数据条数提示结束 -->
								    <!-- 分页条开始 -->
									<div class="row">
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
	<div class="md-modal md-effect-1" id="md-scale" style="height:650px;overflow:hidden;overflow-y:auto;background:#fff;">
    	<div class="row">
			<div class="col-md-12">
				<div class="block-flat">
					<div class="header">
						<h3>数据规则功能信息</h3>
					</div>
			
					<div class="content">
						<form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
							<input type="hidden" name="entityId" id="entityId">
							<div class="form-group">
								<label class="col-sm-3 control-label">名称</label>
								<div class="col-sm-6">
									<input id="name" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">实体名</label>
								<div class="col-sm-6">
									<input id="entityName" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">标签显示</label>
								<div class="col-sm-6">
									<input id="entityShow" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">语法条件</label>
								<div class="col-sm-6">
									<textarea cols="40" rows="5" id="dataCondition" name="contactus"></textarea>
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
var path="systemDataRule.do";

$(document).ready(function(){
    App.init();
    $(".md-trigger").modalEffects();
	query();
	$(".deleteThisTime").click(function(){               //清除日期框中的值
       $(this).parent().prev()[0].value = "";
    });
});

function selectAll() {
	if ($("#allselectchecker").is(':checked')) {
		$(".col_selector").prop("checked", true);
	} else {
		$(".col_selector").prop("checked", false);
	}
}

function doAdd() {
	$("#entityId").val("");
	$("#name").val("");
	$("#entityName").val("");
	$("#entityShow").val("");
	$("#dataCondition").val("");
	$("#createUserId").val("");
	$("#createTime").val("");
	$("#updateUserId").val("");
	$("#updateTime").val("");
}

function doEdit() {
	var selectedItemNumber = $("tbody .col_selector:checked").length;
	if (selectedItemNumber > 1) {
		alert("每次只能编辑一条数据");
	} else if (selectedItemNumber == 1) {
		var id2edit = $("tbody .col_selector:checked").val();
		var reqmsg="{'action':'QUERY_DATA_RULE_INFO_REQUEST','content':{";
	
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
		if (confirm("是否确认删除?"))  { 
		jQuery.ajax({
			type:"post",
			url:path+"?del",
			async:true,
			dataType:"json",
			data:{ids:ids2del},
			success:function(data) {
				alert(data.des);
				if (data.result == "success") {
					go2page(currentshownpage);
				}else if(data.des=="failure"){
                 alert("删除失败");
                }
			},
			error:function() {
				alert("error");
			}
		});
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
	var entityName = $("#entityName").val();
	var entityShow = $("#entityShow").val();
	var dataCondition = $("#dataCondition").val();
	var createUserId = $("#createUserId").val();
	var createTime = $("#createTime").val();
	var updateUserId = $("#updateUserId").val();
	var updateTime = $("#updateTime").val();
	if(dataCondition!=null&&dataCondition != ""){
		if(dataCondition.substr(0, 1)!="["){
		   alert("请填入正确格式比如:[{\"condition\":\"principalEmployeeId\",\"value\":\"$employeeId\"}]");
		   return;
		}
		dataCondition=dataCondition.replace(/\"/g,"\\\"");
		dataCondition=dataCondition.replace(/\'/g,"\\\"");
	}
	
	var reqmsg="{'action':'ADD_DATA_RULE_INFO_REQUEST','content':{";
	
	if (id != null && id != "") {
		reqmsg += "\"id\":" + id + ",";
	}
	    reqmsg += "\"name\":\"" + name + "\",";
	    reqmsg += "\"entityName\":\"" + entityName + "\",";
	    reqmsg += "\"entityShow\":\"" + entityShow + "\",";
	    reqmsg += "\"dataCondition\":\"" + dataCondition + "\",";
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
            	  go2page(currentshownpage);
              }else if(data.des=="failure"){
                 alert("保存失败");
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
	var reqmsg="{'action':'QUERY_DATA_RULE_LIST_REQUEST',";
	
	var sortType = $("#sortType").val();
	var sortColumn = $("#sortColumn").val();
	if(sortType != null && sortType != ""){
		reqmsg += "'order':[{'column':'" + sortColumn + "','type':'" + sortType + "'}],";
	}
	
	reqmsg += "'page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{";
	
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

function changeData(data){
	var htmlcode = "";
	if (data.content != null) {
		jQuery.each(data.content.dataRuleList, function(i, item) {
			htmlcode += "<tr class=\"gradeA odd\"><td><input type=\"checkbox\" value=\"" + item.id + "\" class=\"col_selector\"></td>";
		    htmlcode += "<td>" + item.name + "</td>";				
		    htmlcode += "<td>" + item.entityName + "</td>";
		    htmlcode += "<td>" + item.entityShow + "</td>";
		    if(item.dataCondition){
		       htmlcode += "<td>" + JSON.stringify(item.dataCondition) + "</td>";		
		    }else{
		       htmlcode += "<td></td>";		
		    }			
		    		
		    htmlcode += "<td style=\"display:none\">" + item.createUserId + "</td>";				
		    htmlcode += "<td>" + formateTime(item.createTime) + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.updateUserId + "</td>";				
		    htmlcode += "<td style=\"display:none\">" + item.updateTime + "</td>";				
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

function changeInfo(data){
    if (data.content != null) {
        $("#entityId").val(data.content.id);
		$("#name").val(data.content.name);
		$("#entityName").val(data.content.entityName);	
		$("#entityShow").val(data.content.entityShow);	
		if(data.content.dataCondition){
		   $("#dataCondition").val(JSON.stringify(data.content.dataCondition));
		}else{
		  $("#dataCondition").val("");
		}	
		
		$("#createUserId").val(data.content.createUserId);
		$("#createTime").val(data.content.createTime);
		$("#updateUserId").val(data.content.updateUserId);
		$("#updateTime").val(data.content.updateTime);
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