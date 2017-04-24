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
<title>微信客户管理</title>
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
				<h2>微信客户管理</h2>
				<ol class="breadcrumb">
					<li>基础信息/</li>
					<input type="hidden" value="" id="sortType">
					<input type="hidden" value="" id="sortColumn">
					<li class="active">微信客户管理</li>
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
											<label>昵称</label>
										</div>
										<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
											<input id="nickName" class="form-control" type="text" value="" autocomplete="off" style="width:100%">
										</div>
										<div class="col-xs-6 col-sm-2" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
											<label>备注名</label>
										</div>
										<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
											<input id="memoName" class="form-control" type="text" value="" autocomplete="off" style="width:100%">
										</div>
									</div>
									<!-- 查询框结束 -->
									<!-- 操作按钮开始 -->
									<div class="row">
										<div class="col-sm-12">
											<button class="btn btn-primary " style="margin-bottom: 0px !important; height: 34px;margin-left:0;float:left;" onclick="query();">查询</button>
										</div>
									</div>
									<!-- 操作按钮结束 -->
									<!-- 数据表格开始 -->
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-bordered dataTable hover" id="datatable" aria-describedby="datatable_info">
												<thead>
													<tr role="row">
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_openId')">
															<strong>Openid</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_nakeName')">
															<strong>昵称</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_noteName')">
															<strong>备注名</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_gender')">
															<strong>性别</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_country')">
															<strong>国家</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_province')">
															<strong>省</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_city')">
															<strong>市</strong>
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
						<h3>微信客户信息</h3>
					</div>
					<div class="content form-horizontal group-border-dashed" style="overflow-y: auto;">
						<input type="hidden" name="entityId" id="wechatCustomerId">
						<div class="form-group">
							<label class="col-sm-3 control-label">Openid</label>
							<div class="col-sm-6" id="OpenidPopup" style="margin-top:6px;">
								
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">昵称</label>
							<div class="col-sm-6" id="nickNamePopup" style="margin-top:6px;">
								
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">备注名</label>
							<div class="col-sm-6">
								<input id="memoNamePopup" type="text" class="form-control" autocomplete="off">
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
	//查询微信客户信息
	function query() {
		go2page(1);
	}
	function go2page(pagenumber) {
		var pagesize = $("#pageSizeSelector option:selected").val();
		var nickName = $.trim($("#nickName").val());
		var memoName = $.trim($("#memoName").val());
		var reqmsg = "{'action':'QUERY_WECHAT_CUSTOMER_LIST_REQUEST',";
		
		var sortType = $("#sortType").val();
		var sortColumn = $("#sortColumn").val();
		if (sortType != null && sortType != "") {
			reqmsg += "'order':[{'column':'" + sortColumn + "','type':'" + sortType + "'}],";
		}
		reqmsg += "'page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{'areaEntityShow':'true',";
		if (nickName != null && nickName != "") {
			reqmsg += "'nakeName_like':'" + nickName + "',";
		}
		if (memoName != null && memoName != "") {
			reqmsg += "'noteName_like':'" + memoName + "',";
		}
		reqmsg += "}}";

	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "wechatCustomer.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg              
	          },
	          success : function(data) {
	              if (data.des == "success") {
	            	  changeData(data);
	              } else {
	                 alert("查询微信客户信息失败");
	              }
	          },
	          error:function() {
		          alert("查询微信客户信息失败");
	          }
	     });
	}
	function changeData(data) {
		var htmlcode = "";
		if (data.content != null) {
			if (data.content.wechatCustomerList != null) {
				jQuery.each(data.content.wechatCustomerList,function(i, item) {
					htmlcode += "<tr class=\"gradeA odd\">";
					htmlcode += "<td>" + item.openId + "</td>";
					htmlcode += "<td>" + item.nakeName + "</td>";
					htmlcode += "<td>" + item.noteName + "</td>";
					htmlcode += "<td>" + item.gender + "</td>";
					htmlcode += "<td>" + item.country + "</td>";
					htmlcode += "<td>" + item.province + "</td>";
					htmlcode += "<td>" + item.city + "</td>";
					
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
		$("#OpenidPopup").html("");
		$("#nickNamePopup").html("");
		$("#memoNamePopup").val("");
		$("#wechatCustomerId").val("");
	}
	//编辑微信客户信息
	function edit(id){
		emptyPopup();
		$("#wechatCustomerId").val(id);
		var reqmsg = "{'action':'QUERY_WECHAT_CUSTOMER_INFO_REQUEST','content':{'id':" + id + "}}";

		jQuery.ajax({
	          type : "post",
	          async:false,
	          url : "wechatCustomer.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data) {
	              if (data.des == "success") {
	              	if (data.content != null) {
	              		$("#OpenidPopup").html(data.content.openId);
						$("#nickNamePopup").html(data.content.nakeName);
						$("#memoNamePopup").val(data.content.noteName);
	              	}
	              } else {
	                 alert("查询微信客户信息失败");
	              }
	          },
	          error:function() {
		          alert("查询微信客户信息失败");
	          }
	    });
		$("#edit").click();
	}
	
	//保存微信客户信息
	function save() {
		var id = $("#wechatCustomerId").val();
		var memoNamePopup = $.trim($("#memoNamePopup").val());
		
		var reqmsg = "{'action':'ADD_WECHAT_CUSTOMER_INFO_REQUEST','content':{";
		reqmsg += "'id':" + id + ",";//只有编辑
		reqmsg += "'noteName':'" + memoNamePopup + "',";
		reqmsg += "}}";

		jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "wechatCustomer.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data) {
	              if (data.des == "success") {
	              	 $("#cancel").click();
	              	 go2page(currentshownpage);
	              	 alert("保存微信客户信息成功");
	              } else {
	                 alert("保存微信客户信息失败");
	              }
	          },
	          error:function() {
		          alert("保存微信客户信息失败");
	          }
	     });
	}

	//删除微信客户
	function del(id) {
		if (confirm("是否确认删除?"))  {  
			jQuery.ajax({
				type:"post",
				url:"wechatCustomer.do?del",
				async:true,
				dataType:"json",
				data:{ids:id},
				success:function(data) {
					alert(data.des);
					if (data.result == "success") {
						go2page(currentshownpage);
					} else {
	                    alert("删除微信客户失败");
	                }
				},
				error:function() {
					alert("删除微信客户失败");
				}
			});
		}
	}
	</script>
	</body>
</html>