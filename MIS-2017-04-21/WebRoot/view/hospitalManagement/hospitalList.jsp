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
<title>医院管理</title>
<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">
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
<style type="text/css">
.hideAndShow {
	display: none;
}
</style>
</head>
<body style="opacity: 1; margin-left: 0px;">
	<div style="width: 100%; height: 100%;">
		<div class="container-fluid" style="padding: 0px">
			<!-- 头部开始 -->
			<div class="page-head">
				<h2>医院管理</h2>
				<ol class="breadcrumb">
					<li>基础信息/</li>
					<input type="hidden" value="" id="sortType">
					<input type="hidden" value="" id="sortColumn">
					<li class="active">医院管理</li>
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
										<div class="col-xs-6 col-sm-2" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
											<label>医院名称</label>
										</div>
										<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
											<input id="hospitalName" class="form-control" type="text" value="" autocomplete="off" style="width:100%">
										</div>
										<div class="col-xs-6 col-sm-2" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
											<label>地区</label>
										</div>
										<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
											<select id="regionName" class="form-control" style="width:100%">
												
											</select>
										</div>
									</div>
									<!-- 查询框结束 -->
									<!-- 操作按钮开始 -->
									<div class="row">
										<div class="col-sm-12">
											<button class="btn btn-primary " style="margin-bottom: 0px !important; height: 34px;margin-left:0;float:left;" onclick="query();">查询</button>
											<button class="btn btn-primary btn-flat md-trigger" data-modal="editDetail" style="margin-bottom: 0px !important; height: 34px;margin-left:0;float:right;" onclick="emptyPopup();">新增</button>
										</div>
									</div>
									<!-- 操作按钮结束 -->
									<!-- 数据表格开始 -->
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-bordered dataTable hover" id="datatable" aria-describedby="datatable_info">
												<thead>
													<tr role="row">
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_hospitalName')">
															<strong>医院名称</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_level')">
															<strong>等级</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'areaId')">
															<strong>地区</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_addr')">
															<strong>地址</strong>
														</th>
														<th>
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
	<button class="md-trigger" data-modal="editDetail" style="display:none;" id="edit"></button>
	<div class="md-modal md-effect-1" id="editDetail">
		<div class="row">
			<div class="col-md-12" style="padding: 10px 0px;">
				<div class="block-flat" style="padding-right: 0px;">
					<div class="header">
						<h3>医院信息</h3>
					</div>
					<div class="content form-horizontal group-border-dashed" style="overflow-y: auto;">
						<input type="hidden" name="entityId" id="hospitalId">
						<div class="form-group">
							<label class="col-sm-3 control-label">医院名称</label>
							<div class="col-sm-6">
								<input id="hospitalNamePopup" type="text" class="form-control" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">等级</label>
							<div class="col-sm-6">
								<input id="levelPopup" type="text" class="form-control" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">地区</label>
							<div class="col-sm-6">
								<select id="areaNamePopup" class="form-control" style="width:100%">
									<option value=""></option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">地址</label>
							<div class="col-sm-6">
								<input id="regionNamePopup" type="text" class="form-control" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">体检项目列表</label>
							<div class="col-sm-6" style="text-align:right;">
								<button type="button" class="btn btn-primary" onclick="addPhysicalExaminationProject()">
									体检项目新增
								</button>
							</div>
							<div style="clear:both;"></div>
                        	<div class="col-sm-11" style="text-align:center;">
                         		<table class="table no-border" >
									<thead class="no-border">
										<tr>										
											<th><strong>名称</strong></th>									
											<th><strong>价格</strong></th>	
											<th><strong>备注</strong></th>								
											<th style="text-align:right;width:15%" ><strong>操作</strong></th>
										</tr>
									</thead>
									<tbody class="no-border-y mytablenopadding" id="physicalExaminationProjecthtml">
										
									</tbody>
								</table>
                         	</div>
                        </div> 
					</div>
					<div class="footer">
						<div class="form-group" style="text-align: center;margin:0px">
							<button type="button" class="btn btn-primary btn-rad" onclick="save();">
								<span>
									<i class="fa fa-check" style="margin-right:5px;"></i>保存
								</span>
							</button>
							<button type="button" id="cancel" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
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
	
	<button class="md-trigger" data-modal="addPhysicalExaminationProjectModel" style="display:none;" id="addPhysicalExaminationProject"></button>
	<!-- 体检项目新增 -->
	<div class="md-modal colored-header custom-width md-effect-9" id="addPhysicalExaminationProjectModel">
		<div class="md-content" style="height:500px;overflow-y:scroll;width:800px;">
			<div class="modal-header">
				<h3>体检项目新增</h3>
				<button type="button" class="close md-close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<!-- 数据表格开始 -->
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered dataTable hover" id="datatable" aria-describedby="datatable_info">
							<thead>
								<tr role="row">
									<th style="width:2%;">
										<input id="allselectcheckerProject" type="checkbox" class="col_selectorProject" onclick="selectAllProject();">
									</th>
									<th><strong>名称</strong>
									</th>
									<th><strong>价格</strong>
									</th>
									<th><strong>备注</strong>
									</th>
								</tr>
							</thead>
							<tbody id="datacontainerProject" role="alert" aria-live="polite" aria-relevant="all">
							</tbody>
						</table>
					</div>
				</div>
				<!-- 数据表格结束 -->
				<!-- 数据条数提示开始 -->
				<div class="row">
					<div class="col-sm-12">
						<div class="pull-left">
							<div id="datatable_infoProject" class="dataTables_info">当前显示0 条总记录中的第0-0条</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<!-- 数据条数提示结束 -->
				<!-- 分页条开始 -->
				<div class="row">
					<div class="col-sm-4" style="clear:both;">
						<div class="pull-left" style="margin:10px 0" id="datatable2_length">
							<label class="pull-left" style="margin:10px 0;">每页</label> <label class="pull-left" style="margin:10px 0;"> <select id="pageSizeSelectorProject" class="form-control" aria-controls="datatableProject" size="1" name="datatable_length" onchange="queryProject()">
									<option selected="selected" value="10">10</option>
									<option value="25">25</option>
									<option value="50">50</option>
									<option value="100">100</option>
							</select> </label> <label class="pull-left" style="margin:10px 0;">条</label>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="pull-right">
							<div class="dataTables_paginate paging_bs_normal">
								<ul id="paginationAreaProject" class="pagination">
									<li class="prev disabled"><a href="#"><span class="fa fa-angle-left"></span>&nbsp;上一页</a>
									</li>
									<li class="active"><a href="#">1</a>
									</li>
									<li class="next"><a href="#">下一页&nbsp;<span class="fa fa-angle-right"></span>
									</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- 分页条结束 -->
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn-rad" onclick="addProject();">
								<span>
									<i class="fa fa-check" style="margin-right:5px;"></i>确定
								</span>
							</button>
				<button type="button" id="closeProject" class="btn btn-default btn-flat md-close" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
	
	<!-- Nifty Modal -->

	<div class="md-overlay"></div>
	<!-- Nifty Modal的遮罩层-->

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
	<script type="text/javascript" src="js/jquery.md5.js"></script>
	<script type="text/javascript" src="js/jquery.datatables/jquery.datatables.min.js"></script>
	<script type="text/javascript" src="js/jquery.datatables/bootstrap-adapter/js/datatables.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	    App.init();
	    var windowHeight = $(window).height();
	   	$("#editDetail").css("height", (windowHeight) + "px");
	   	$("#editDetail").find(".modal-body").css("height", (windowHeight - 50) + "px");
	    $(".md-trigger").modalEffects();
	    
	    getAreas();
		query();
	});
	
	//获取地区信息
	function getAreas(){
		var reqmsg = "{'action':'QUERY_AREA_LIST_REQUEST','page':{'pageno':'1','pagesize':'1000000'},'content':{}}";
		
	    jQuery.ajax({
	          type : "post",
	          async:false,
	          url : "area.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg              
	          },
	          success : function(data) {
	              if (data.des == "success") {
	            	 if (data.content != null) {
	            	  	if (data.content.areaList != null) {
	            	  		var html = "<option value=''></option>";
							jQuery.each(data.content.areaList,function(i, item) {
								html += "<option value='" + item.id + "'>" + item.area + "</option>";
							});
	     					$("#regionName").html(html);
	     					$("#areaNamePopup").html(html);
						}
					 }
	              } else {
	                 alert("查询地区信息失败");
	              }
	          },
	          error:function() {
		          alert("查询地区信息失败");
	          }
	     });
	}
	
	//根据排序规则重新查询
	function queryBySort(par,column) {
		var classFlag = listSortClickEvent(par);
		var type = judgmentChinese(column);
		if (type != null && type != "") {
			classFlag = type + classFlag;
			column = column.substr(8,column.length);
		}
		$("#sortType").val(classFlag);
		$("#sortColumn").val(column);
		go2page(currentshownpage);
	}
	
	var currentshownpage = 1; //当前页码
	//查询医院信息
	function query() {
		go2page(1);
	}
	function go2page(pagenumber) {
		var pagesize = $("#pageSizeSelector option:selected").val();
		var hospitalName = $.trim($("#hospitalName").val());
		var regionName = $("#regionName").val();
		var reqmsg = "{'action':'QUERY_HOSPITAL_LIST_REQUEST',";
		
		var sortType = $("#sortType").val();
		var sortColumn = $("#sortColumn").val();
		if (sortType != null && sortType != "") {
			reqmsg += "'order':[{'column':'" + sortColumn + "','type':'" + sortType + "'}],";
		}
		reqmsg += "'page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{'areaEntityShow':'true',";
		if (hospitalName != null && hospitalName != "") {
			reqmsg += "'hospitalName_like':'" + hospitalName + "',";
		}
		if (regionName != null && regionName != "") {
			reqmsg += "'areaId':" + regionName + ",";
		}
		reqmsg += "}}";

	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "hospital.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg              
	          },
	          success : function(data) {
	              if (data.des == "success") {
	            	  changeData(data);
	              } else {
	                 alert("查询医院信息失败");
	              }
	          },
	          error:function() {
		          alert("查询医院信息失败");
	          }
	     });
	}
	function changeData(data) {
		var htmlcode = "";
		if (data.content != null) {
			if (data.content.hospitalList != null) {
				jQuery.each(data.content.hospitalList,function(i, item) {
					htmlcode += "<tr class=\"gradeA odd\">";
					htmlcode += "<td>" + item.hospitalName + "</td>";
					htmlcode += "<td>" + item.level + "</td>";
					if (item.areaEntity != null) {
						htmlcode += "<td>" + item.areaEntity.area + "</td>";
					} else {
						htmlcode += "<td></td>";
					}
					htmlcode += "<td>" + item.addr + "</td>";
					
					htmlcode += "<td><div class=\"btn-group\">";
					htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
					htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
					htmlcode += "<span class=\"caret\"></span>";
					htmlcode += "<span class=\"sr-only\">Toggle Dropdown</span>";
					htmlcode += "</button>";
					htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";
					htmlcode += "<li onclick=\"edit(" + item.id + ")\"><a href=\"###\">编辑</a></li>";
					htmlcode += "<li onclick=\"del(" + item.id + ")\"><a href=\"###\">删除</a></li>";
					htmlcode += "</ul></div></td>";
					htmlcode += "</tr>";
				});
			}
		}
		$("#datacontainer").html(htmlcode);
		if (data.page != null) {
			genaratePaginateHtml(data.page.pageno, data.page.pageCount);
			genarateRecordNumberHtml(data.page.pageno, data.page.pagesize,data.page.recordCount);
		} else {
			genaratePaginateHtml(1, 1);
			genarateRecordNumberHtml(1, 10, 0);
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
			htmlcode += "<li class=\"pre\"><a href=\"#\" onclick=\"go2page('1')\"><span class=\"fa fa-angle-left\"></span>&nbsp;首页</a></li>";
			htmlcode += "<li class=\"pre\"><a href=\"#\" onclick=\"go2page('" + (currentpage - 1) + "')\"><span class=\"fa fa-angle-left\"></span>&nbsp;上一页</a></li>";
		} else {
			htmlcode += "<li class=\"pre disabled\"><a href=\"#\"><span class=\"fa fa-angle-left\"></span>&nbsp;首页</a></li>";
			htmlcode += "<li class=\"pre disabled\"><a href=\"#\"><span class=\"fa fa-angle-left\"></span>&nbsp;上一页</a></li>";
		}
		//具体页码
		if (totalpage <= 5) {
			for ( var i = 1; i <= totalpage; i++) {
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
			for ( var i = startpage; i <= endpage; i++) {
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

	//清空弹窗
	function emptyPopup() {
		$("#hospitalNamePopup").val("");
		$("#levelPopup").val("");
		$("#areaNamePopup option:first").prop("selected", 'selected');
		$("#regionNamePopup").val("");
		$("#hospitalId").val("");
		$("#physicalExaminationProjecthtml").html("");
	}
	//编辑医院信息
	function edit(id) {
		emptyPopup();
		$("#hospitalId").val(id);
		var reqmsg = "{'action':'QUERY_HOSPITAL_INFO_REQUEST','content':{'id':" + id + "}}";

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
	              		$("#hospitalNamePopup").val(data.content.hospitalName);
						$("#levelPopup").val(data.content.level);
						$("#areaNamePopup").val(data.content.areaId);
						$("#regionNamePopup").val(data.content.addr);
							 
						if (data.content.medicalItemlist != null) {
							var html = "";
							jQuery.each(data.content.medicalItemlist, function(i, item) {
								html += "<tr>";
								html += "<td>" + item.itemName  + "</td>";
								html += "<td>" + item.price  + "</td>";
								if (item.des != null && item.des != "") {
									if (item.des.length > 15) {
										html += "<td>" + item.des.substr(0,15) + "...</td>";
									} else {
										html += "<td>" + item.des + "</td>";
									}
								} else {
									html += "<td></td>";
								}
								html += "<td><input type='hidden' value='" + item.id + "'><a class='label label-danger' onclick='$(this).parent().parent().remove();'><i class='fa fa-times'></i></a></td>";
								html += "</tr>";
							});
							$("#physicalExaminationProjecthtml").html(html);
						}
	              	 }
	              } else {
	                 alert("查询医院信息失败");
	              }
	          },
	          error:function() {
		          alert("查询医院信息失败");
	          }
	    });
		$("#edit").click();
	}
	
	//打开体检项目新增弹窗
	function addPhysicalExaminationProject() {
		queryProject(1);
		$("#addPhysicalExaminationProject").click();
	}
	var currentshownpageProject = 1;
	function selectAllProject() {
		if ($("#allselectcheckerProject").is(':checked')) {
			$(".col_selectorProject").prop("checked", true);
	  	} else {
		 	$(".col_selectorProject").prop("checked", false);
	  	}
  	}
	//获取体检项目
	function queryProject(pagenumber) {
		var pagesize = $("#pageSizeSelectorProject option:selected").val();
		var reqmsg = "{'action':'QUERY_MEDICAL_ITEM_LIST_REQUEST','page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{}}";

	    jQuery.ajax({
	          type : "post",
	          async:false,
	          url : "medicalItem.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if (data.des == "success") {
	            	  changeDataProject(data);
	              } else {
	                 alert("查询体检项目失败");
	              }
	          },
	          error:function() {
		          alert("查询体检项目失败");
	          }
	     });
	}
	function changeDataProject(data){
		var htmlcode = "";
		if (data.content != null) {
			jQuery.each(data.content.medicalItemList, function(i, item) {
				htmlcode += "<tr class=\"gradeA odd\"><td><input type=\"checkbox\" value=\"" + item.id + "\" class=\"col_selector\"></td>";
			    htmlcode += "<td>" + item.itemName + "</td>";			
			    htmlcode += "<td>" + item.price + "</td>";
			    if (item.des != null && item.des != "") {
			    	if (item.des.length > 15) {
						htmlcode += "<td>" + item.des.substr(0,15) + "...</td>";
					} else {
						htmlcode += "<td>" + item.des + "</td>";
					}	
			    } else {
			    	htmlcode += "<td></td>";	
			    }				
				htmlcode += "</tr>";
			});
		}
		$("#datacontainerProject").html(htmlcode);
		if (data.page != null) {
			genaratePaginateHtmlProject(data.page.pageno, data.page.pageCount);
			genarateRecordNumberHtmlProject(data.page.pageno, data.page.pagesize, data.page.recordCount);
		} else {
			genaratePaginateHtmlProject(1, 1);
			genarateRecordNumberHtmlProject(1, 10, 0);
		}
	}
	/**
	 * 生成记录数信息
	 * @method genarateRecordNumberHtmlProject
	 * @param {Number} currentpage 当前页
	 * @param {Number} pagesize 每页记录条目数
	 * @param {Number} totalRecord 总记录数
	 */
	function genarateRecordNumberHtmlProject(currentpage, pagesize, totalRecord) {
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
		
		$("#datatable_infoProject").html(recordInfos);
	}
	/**
	 * 生成分页信息
	 * @method genaratePaginateHtmlProject
	 * @param {Number} currentpage 当前页
	 * @param {Number} totalpage 总页数
	 */
	function genaratePaginateHtmlProject(currentpage, totalpage, pagesize) {
		currentshownpageProject = currentpage;
	
		var htmlcode = "";
		
		//上一页
		if (currentpage > 1) {
			htmlcode += "<li class=\"pre\"><a href=\"#\" onclick=\"queryProject('1')\"><span class=\"fa fa-angle-left\"></span>&nbsp;首页</a></li>";
			htmlcode += "<li class=\"pre\"><a href=\"#\" onclick=\"queryProject('" + (currentpage - 1) + "')\"><span class=\"fa fa-angle-left\"></span>&nbsp;上一页</a></li>";
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
					htmlcode += "<li><a href=\"#\" onclick=\"queryProject('" + i + "')\">" + i + "</a></li>";
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
					htmlcode += "<li><a href=\"#\" onclick=\"queryProject('" + i + "')\">" + i + "</a></li>";
				}
			}
		}
		
		//下一页
		if (totalpage > currentpage) {
			htmlcode += "<li class=\"next\"><a href=\"#\" onclick=\"queryProject('" + (parseInt(currentpage) + 1) + "')\">下一页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
			htmlcode += "<li class=\"next\"><a href=\"#\" onclick=\"queryProject('" + parseInt(totalpage) + "')\">末页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
		} else {
			htmlcode += "<li class=\"next disabled\"><a href=\"#\">下一页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
			htmlcode += "<li class=\"next disabled\"><a href=\"#\">末页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
		}
		$("#paginationAreaProject").html(htmlcode);
	}
	//确认选择
	function addProject() {
		var html = $("#physicalExaminationProjecthtml").html();
		var datacontainerProject = "";
		$("#datacontainerProject .col_selector:checked").each(function() {
			if (!checkProjectIfRepeat($(this).val())) {
				datacontainerProject += "<tr>";
				datacontainerProject += "<td>" + $(this).parent().next().html()  + "</td>";
				datacontainerProject += "<td>" + $(this).parent().next().next().html()  + "</td>";
				datacontainerProject += "<td>" + $(this).parent().next().next().next().html()  + "</td>";
				datacontainerProject += "<td><input type='hidden' value='" + $(this).val() + "'><a class='label label-danger' onclick='$(this).parent().parent().remove();'><i class='fa fa-times'></i></a></td>";
				datacontainerProject += "</tr>";
			}
		});
		html = html + datacontainerProject;
		$("#physicalExaminationProjecthtml").html(html);
		$("#closeProject").click();
	}
	//检测当前一条体检项目是否已添加，已添加的不重复添加
	function checkProjectIfRepeat(id) {
		var flag = false;//不存在
		var physicalExaminationProjecthtml = $("#physicalExaminationProjecthtml tr")
		if (physicalExaminationProjecthtml.length > 0) {//有体检项目
			for (var i = 0;i < physicalExaminationProjecthtml.length;i++) {
				if ($("#physicalExaminationProjecthtml").find("tr:eq(" + i + ")").find("td:eq(3)").find("input").val() == id){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	
	//保存医院信息
	function save() {
		var id = $("#hospitalId").val();
		var hospitalNamePopup = $.trim($("#hospitalNamePopup").val());
		var levelPopup = $.trim($("#levelPopup").val());
		var areaId = $("#areaNamePopup").val();
		var regionNamePopup = $.trim($("#regionNamePopup").val());
		
		var reqmsg = "{'action':'ADD_HOSPITAL_INFO_REQUEST','content':{";
		if (id != null && id != "") {//编辑
			reqmsg += "'id':" + id + ",";
		}
		reqmsg += "'hospitalName':'" + hospitalNamePopup + "',";
		reqmsg += "'level':'" + levelPopup + "',";
		if (areaId != null && areaId != "") {
			reqmsg += "'areaId':" + areaId + ",";
		}
		reqmsg += "'addr':'" + regionNamePopup + "'";
		reqmsg += "},";
		
		var medicalItemIds = "" ;
		var physicalExaminationProjecthtml = $("#physicalExaminationProjecthtml tr")
		if (physicalExaminationProjecthtml.length > 0) {//有体检项目
			for (var i = 0;i < physicalExaminationProjecthtml.length;i++) {
				medicalItemIds += $("#physicalExaminationProjecthtml").find("tr:eq(" + i + ")").find("td:eq(3)").find("input").val() + ",";
			}
		}
		if (medicalItemIds != null && medicalItemIds != '') {
			medicalItemIds = medicalItemIds.substr(0,medicalItemIds.length - 1);
		}
		reqmsg += "'medicalItemList':'" + medicalItemIds + "'}";
		
		jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "hospital.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data) {
	              if (data.des == "success") {
	              	 alert("保存医院信息成功");
	              	 $("#cancel").click();
	              	 go2page(currentshownpage);
	              } else {
	                 alert("保存医院信息失败");
	              }
	          },
	          error:function() {
		          alert("保存医院信息失败");
	          }
	     });
	}

	//删除医院信息
	function del(id) {
		if (confirm("是否确认删除?"))  {  
			jQuery.ajax({
				type:"post",
				url:"hospital.do?del",
				async:true,
				dataType:"json",
				data:{ids:id},
				success:function(data) {
					alert(data.des);
					if (data.result == "success") {
						go2page(currentshownpage);
					} else {
	                    alert("删除医院信息失败");
	                }
				},
				error:function() {
					alert("删除医院信息失败");
				}
			});
		}
	}
	</script>
	</body>
</html>