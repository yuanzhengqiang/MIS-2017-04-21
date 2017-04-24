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
<title>服务人员管理</title>
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
				<h2>服务人员管理</h2>
				<ol class="breadcrumb">
					<li>基础信息/</li>
					<input type="hidden" value="" id="sortType">
					<input type="hidden" value="" id="sortColumn">
					<li class="active">服务人员管理</li>
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
											<label>姓名</label>
										</div>
										<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
											<input id="name" class="form-control" type="text" value="" autocomplete="off" style="width:100%">
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
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_name')">
															<strong>姓名</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_gender')">
															<strong>性别</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'birthday')">
															<strong>出生日期</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_academic')">
															<strong>学历</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'contact')">
															<strong>联系方式</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'wechatNum')">
															<strong>微信号</strong>
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
	<!-- 图片 -->
	<form style="display:none;" id="image_submit" action="position.do?pic2" method="post"  enctype="multipart/form-data">
        <input type="hidden" name="srcPath" id="srcPath" value="" />
        <input type="hidden" name="type" id="type" value="servicePersonPhoto_" />
		<input type="hidden" name="x1" id="x1" value="0" />
		<input type="hidden" name="y1" id="y1" value="0" />
		<input type="hidden" name="x2" id="x2" value="0" />
		<input type="hidden" name="y2" id="y2" value="0" />
	</form>  
	<button type="button" class="btn btn-primary btn-flat" style="display:none;" id="sure_SC" onclick="uploadPic_cut()">确定</button>  
	<form id="picuploadform_Card1" class="secondcol" action="position.do?pic1" method="post" style="display:none;" enctype="multipart/form-data">
		<input id="pic4upload_Card1" name="pic4upload_Card" type="file" onchange="uploadPic_Card('1')" accept="image/*">
	</form>
	<form id="picuploadform_Card2" class="secondcol" action="position.do?pic1" method="post" style="display:none;" enctype="multipart/form-data">
		<input id="pic4upload_Card2" name="pic4upload_Card" type="file" onchange="uploadPic_Card('2')" accept="image/*">
	</form>
	<input type="hidden" id="weizhiId" value="" />
	<input type="hidden" id="hide_tupian_Card1" value="" />
	<input type="hidden" id="hide_tupian_Card2" value="" />
	
	<button class="md-trigger" data-modal="editDetail" style="display:none;" id="edit"></button>
	<div class="md-modal md-effect-1" id="editDetail">
		<div class="row">
			<div class="col-md-12" style="padding: 10px 0px;">
				<div class="block-flat" style="padding-right: 0px;">
					<div class="header">
						<h3>服务人员信息</h3>
					</div>
					<div class="content form-horizontal group-border-dashed" style="overflow-y:scroll;max-height:400px;">
						<input type="hidden" name="entityId" id="servicePersonId">
						<div class="form-group">
							<label class="col-sm-3 control-label">姓名</label>
							<div class="col-sm-6">
								<input id="namePopup" type="text" class="form-control" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">性别</label>
							<div class="col-sm-6">
								<input id="genderPopup" type="text" class="form-control" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">出生日期</label>
							<div class="col-sm-6">
								<div class="input-group date datetime " data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom:0;">
									<input class="form-control" id="birthdayPopup" size="16" type="text" value="" placeholder="日期格式：yyyy-mm-dd">
									<span class="input-group-addon btn btn-primary">
										<span class="glyphicon glyphicon-th"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">学历</label>
							<div class="col-sm-6">
								<input id="academicPopup" type="text" class="form-control" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">联系方式</label>
							<div class="col-sm-6">
								<input id="contactPopup" type="text" class="form-control" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">微信号</label>
							<div class="col-sm-6">
								<input id="wechatNumPopup" type="text" class="form-control" autocomplete="off">
							</div>
						</div>
						<div class="gallery-cont col-sm-6 col-md-4 col-lg-3" id="Fptphoto_Card1">
							<div class="item" style="width:100%;">
								<div class="photo" style="width:350px;height:250px;">
									<div class="head">
										<span class="pull-right">
											<button type="button" class="btn btn-danger btn-sm" id="deltupian_CardId1" onclick="deltupian_Card('1')">删除图片</button>
										</span>
									</div>
									<div class="img">
										<img src="photos/IDCardFront.png" id="ptphoto_Card1" style="width:350px;height:200px;" />
										<div class="over" style="width:350px;height:200px;margin-top:23px;" id="identyIdOver1">
											<div class="func">
												<a onclick="$('#pic4upload_Card1').click();">
													<i class="fa fa-pencil"></i>
												</a>
												<a class="image-zoom" id="Bigptphoto_Card1" href="###">
													<i class="fa fa-search"></i>
												</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="gallery-cont col-sm-6 col-md-4 col-lg-3" id="Fptphoto_Card2" style="margin-left:100px">
							<div class="item" style="width:100%;">
								<div class="photo" style="width:350px;height:250px;">
									<div class="head">
										<span class="pull-right">
											<button type="button" class="btn btn-danger btn-sm" id="deltupian_CardId2" onclick="deltupian_Card('2')">删除图片</button>
										</span>
									</div>
									<div class="img">
										<img src="photos/IDCardSide.png" id="ptphoto_Card2" style="width:350px;height:200px;" />
										<div class="over" style="width:350px;height:200px;margin-top:23px;" id="identyIdOver2">
											<div class="func">
												<a onclick="$('#pic4upload_Card2').click();">
													<i class="fa fa-pencil"></i>
												</a>
												<a class="image-zoom" id="Bigptphoto_Card2" href="###">
													<i class="fa fa-search"></i>
												</a>
											</div>
										</div>
									</div>
								</div>
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
							<button id="cancel_button" type="button" id="cancel" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
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

	<div class="md-overlay"></div>
	<!-- Nifty Modal的遮罩层-->

	<script type="text/javascript" src="js/mordo.tools/mordo.timeProcessing.js"></script>
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
	    
		query();
	});
	
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
	//查询服务人员信息
	function query() {
		go2page(1);
	}
	function go2page(pagenumber) {
		var pagesize = $("#pageSizeSelector option:selected").val();
		var name = $.trim($("#name").val());
		var reqmsg = "{'action':'QUERY_SERVICE_PERSON_LIST_REQUEST',";
		
		var sortType = $("#sortType").val();
		var sortColumn = $("#sortColumn").val();
		if (sortType != null && sortType != "") {
			reqmsg += "'order':[{'column':'" + sortColumn + "','type':'" + sortType + "'}],";
		}
		reqmsg += "'page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{'areaEntityShow':'true',";
		if (name != null && name != "") {
			reqmsg += "'name_like':'" + name + "',";
		}
		reqmsg += "}}";

	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "servicePerson.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg              
	          },
	          success : function(data) {
	              if (data.des == "success") {
	            	  changeData(data);
	              } else {
	                 alert("查询服务人员信息失败");
	              }
	          },
	          error:function() {
		          alert("查询服务人员信息失败");
	          }
	     });
	}
	function changeData(data) {
		var htmlcode = "";
		if (data.content != null) {
			if (data.content.servicePersonList != null) {
				jQuery.each(data.content.servicePersonList,function(i, item) {
					htmlcode += "<tr class=\"gradeA odd\">";
					htmlcode += "<td>" + item.name + "</td>";
					htmlcode += "<td>" + item.gender + "</td>";
					htmlcode += "<td>" + formateTime5(item.birthday) + "</td>";
					htmlcode += "<td>" + item.academic + "</td>";
					htmlcode += "<td>" + item.contact + "</td>";
					htmlcode += "<td>" + item.wechatNum + "</td>";
					
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
		$("#namePopup").val("");
		$("#genderPopup").val("");
		$("#birthdayPopup").val("");
		$("#academicPopup").val("");
		$("#contactPopup").val("");
		$("#wechatNumPopup").val("");
		$("#servicePersonId").val("");
	}
	//编辑服务人员信息
	function edit(id){
		emptyPopup();
		$("#servicePersonId").val(id);
		var reqmsg = "{'action':'QUERY_SERVICE_PERSON_INFO_REQUEST','content':{'id':" + id + "}}";

		jQuery.ajax({
	          type : "post",
	          async:false,
	          url : "servicePerson.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data) {
	              if (data.des == "success") {
	              	if (data.content != null) {
	              		$("#namePopup").val(data.content.name);
						$("#genderPopup").val(data.content.gender);
						$("#birthdayPopup").val(conversionDate(data.content.birthday));
						$("#academicPopup").val(data.content.academic);
						$("#contactPopup").val(data.content.contact);
						$("#wechatNumPopup").val(data.content.wechatNum);
	              	}
	              } else {
	                 alert("查询服务人员信息失败");
	              }
	          },
	          error:function() {
		          alert("查询服务人员信息失败");
	          }
	    });
		$("#edit").click();
	}
	//转化日期
    function conversionDate(data) {
    	var date2 = "";
    	if (data != null && data != "" && data.length == 8) {
    		date2 = data.substr(0,4) + "-" + data.substr(4,2) + "-" + data.substr(6,2);
    	}
    	return date2;
    }
	
	//保存服务人员信息
	function save() {
		var id = $("#wechatCustomerId").val();
		var namePopup = $.trim($("#namePopup").val());
		var genderPopup = $.trim($("#genderPopup").val());
		var birthdayPopup = $.trim($("#birthdayPopup").val());
		var academicPopup = $.trim($("#academicPopup").val());
		var contactPopup = $.trim($("#contactPopup").val());
		var wechatNumPopup = $.trim($("#wechatNumPopup").val());
		
		var reqmsg = "{'action':'ADD_SERVICE_PERSON_INFO_REQUEST','content':{";
		if (id != null && id != "") {//编辑
			reqmsg += "'id':" + id + ",";
		}
		reqmsg += "'name':'" + namePopup + "',";
		reqmsg += "'gender':'" + genderPopup + "',";
		if (birthdayPopup != null && birthdayPopup != "") {
			birthdayPopup = birthdayPopup.split("-")[0] + birthdayPopup.split("-")[1] + birthdayPopup.split("-")[2];
			reqmsg += "'birthday':'" + birthdayPopup + "',";
		}
		reqmsg += "'academic':'" + academicPopup + "',";
		reqmsg += "'contact':'" + contactPopup + "',";
		reqmsg += "'wechatNum':'" + wechatNumPopup + "',";
		reqmsg += "}}";

		jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "servicePerson.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data) {
	              if (data.des == "success") {
	              	$("#cancel").click();
	              	go2page(currentshownpage);
	              } else {
	                 alert("保存服务人员信息失败");
	              }
	          },
	          error:function() {
		          alert("保存服务人员信息失败");
	          }
	     });
	}

	//删除服务人员信息
	function del(id) {
		if (confirm("是否确认删除?"))  {  
			jQuery.ajax({
				type:"post",
				url:"servicePerson.do?del",
				async:true,
				dataType:"json",
				data:{ids:id},
				success:function(data) {
					alert(data.des);
					if (data.result == "success") {
						go2page(currentshownpage);
					} else {
	                    alert("删除服务人员信息失败");
	                }
				},
				error:function() {
					alert("删除服务人员信息失败");
				}
			});
		}
	}
	
	
	function openImagejsp(data){
		var weizhiId = $("#weizhiId").val();
		var url = "view/imageCut/jquery-image-cut/image.jsp?";
		if(weizhiId != "0"){//身份证操作
			url = url + "flag=IDCard&";
		}
		window.open (url + data, "newwindow", "height=550, width=1100, top=200, left=450, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
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
					if(weizhi == "0"){//头像
						$("#hide_olderTupian").val(result.base64);
						$("#touxiangId").attr("src", result.url);  //将当前图片设为上传的图片
						baocuntouxiang();
					}else{//身份证
						$("#hide_tupian_Card" + weizhi).val(result.base64);
						$("#ptphoto_Card" + weizhi).attr("src", result.url);  //将当前图片设为上传的图片
						$("#Bigptphoto_Card" + weizhi).show();
						$("#Bigptphoto_Card" + weizhi).attr("href", result.url);//设置大图
					}
				} else {
					alert("图片上传失败");
				}
			}
		};
		$("#image_submit").ajaxSubmit(ajax_option);
	}
	
	////////身份证图片操作////////
	function deltupian_Card(flag){
		$("#hide_tupian_Card" + flag).val("");
		if(flag == "1"){
			$("#ptphoto_Card" + flag).attr("src","photos/IDCardFront.png");
		}else{
			$("#ptphoto_Card" + flag).attr("src","photos/IDCardSide.png");
		}
		$("#Bigptphoto_Card" + flag).attr("href","");
		$("#Bigptphoto_Card" + flag).hide();
		$("#pic4upload_Card" + flag).val("");
	}
	//上传图片
	function uploadPic_Card(weizhi) {
		$("#weizhiId").val(weizhi);
		var currPic = $("#pic4upload_Card" + weizhi).val();
		if (currPic != null && currPic != "") {
			var ajax_option = {
				async:false,
				data:{},
				success:function(data) {
					if (data != null && data != "") {
						$("#srcPath").val(data);
						openImagejsp(data);
					} else {
						alert("图片上传失败");
					}
				}
			};
			$("#picuploadform_Card" + weizhi).ajaxSubmit(ajax_option);
		} else {
			//alert("请选择图片");
		}
	}
	</script>
	</body>
</html>