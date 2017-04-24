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
<title>体检订单管理</title>
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
				<h2>体检订单管理</h2>
				<ol class="breadcrumb">
					<li>订单信息/</li>
					<input type="hidden" value="" id="sortType">
					<input type="hidden" value="" id="sortColumn">
					<li class="active">体检订单管理</li>
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
											<label>订单编号</label>
										</div>
										<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
											<input id="orderNum" class="form-control" type="text" value="" autocomplete="off" style="width:100%">
										</div>
										<div class="col-xs-6 col-sm-2" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
											<label>体检人姓名</label>
										</div>
										<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
											<input id="medicalPersonName" class="form-control" type="text" value="" autocomplete="off" style="width:100%">
										</div>
										<div class="col-xs-6 col-sm-2" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
											<label>体检人身份证号</label>
										</div>
										<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
											<input id="medicalPersonCard" class="form-control" type="text" value="" autocomplete="off" style="width:100%">
										</div>
										<div class="col-xs-6 col-sm-2" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
											<label>订单状态</label>
										</div>
										<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
											<select id="status" class="form-control" style="width:100%">
												<option value="">全部</option>
												<option value="1">预约成功</option>
												<option value="2">体检完成</option>
												<option value="3">生成报告(未支付余额)</option>
												<option value="4">生成报告(已支付余额)</option>
												<option value="5">取消</option>
											</select>
										</div>
									</div>
									<!-- 查询框结束 -->
									<!-- 操作按钮开始 -->
									<div class="row">
										<div class="col-sm-12">
											<button class="btn btn-primary " style="margin-bottom: 0px !important; height: 34px;margin-left:0;float:left;" onclick="query();">查询</button>
											<a href="<%=request.getContextPath()%>/order.do?mainDetail" class="btn btn-primary btn-flat" target="_blank" style="margin-bottom: 0px !important; height: 34px;margin-left:0;float:right;">新增</a>
										</div>
									</div>
									<!-- 操作按钮结束 -->
									<!-- 数据表格开始 -->
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-bordered dataTable hover" id="datatable" aria-describedby="datatable_info">
												<thead>
													<tr role="row">
														<th name="needSort" class="sorting" onclick="queryBySort(this,'orderNum')">
															<strong>订单编号</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_medicalPersonName')">
															<strong>体检人姓名</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'medicalPersonCard')">
															<strong>体检人身份证号</strong>
														</th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'status')">
															<strong>订单状态</strong>
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
	//查询体检订单信息
	function query() {
		go2page(1);
	}
	function go2page(pagenumber) {
		var pagesize = $("#pageSizeSelector option:selected").val();
		var orderNum = $.trim($("#orderNum").val());
		var medicalPersonName = $.trim($("#medicalPersonName").val());
		var medicalPersonCard = $.trim($("#medicalPersonCard").val());
		var status = $("#status").val();
		var reqmsg = "{'action':'QUERY_ORDER_LIST_REQUEST',";
		
		var sortType = $("#sortType").val();
		var sortColumn = $("#sortColumn").val();
		if (sortType != null && sortType != "") {
			reqmsg += "'order':[{'column':'" + sortColumn + "','type':'" + sortType + "'}],";
		}
		reqmsg += "'page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{'areaEntityShow':'true',";
		if (orderNum != null && orderNum != "") {
			reqmsg += "'orderNum_like':'" + orderNum + "',";
		}
		if (medicalPersonName != null && medicalPersonName != "") {
			reqmsg += "'medicalPersonName_like':'" + medicalPersonName + "',";
		}
		if (medicalPersonCard != null && medicalPersonCard != "") {
			reqmsg += "'medicalPersonCard_like':'" + medicalPersonCard + "',";
		}
		if (status != null && status != "") {
			reqmsg += "'status':" + status + ",";
		}
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
	            	  changeData(data);
	              } else {
	                 alert("查询体检订单信息失败");
	              }
	          },
	          error:function() {
		          alert("查询体检订单信息失败");
	          }
	     });
	}
	function changeData(data) {
		var htmlcode = "";
		if (data.content != null) {
			if (data.content.orderList != null) {
				var headUrl = "<%=request.getContextPath()%>";
				jQuery.each(data.content.orderList,function(i, item) {
					htmlcode += "<tr class=\"gradeA odd\">";
					htmlcode += "<td>" + item.orderNum + "</td>";
					htmlcode += "<td>" + item.medicalPersonName + "</td>";
					htmlcode += "<td>" + item.medicalPersonCard + "</td>";
					htmlcode += "<td>" + matchingState(item.status) + "</td>";
					
					htmlcode += "<td><div class=\"btn-group\">";
					htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
					htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
					htmlcode += "<span class=\"caret\"></span>";
					htmlcode += "<span class=\"sr-only\">Toggle Dropdown</span>";
					htmlcode += "</button>";
					htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";
					htmlcode += "<li><a href=\"" + headUrl + "/order.do?mainDetail&id=" + item.id + "\" target=\"_blank\">查看</a></li>";
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
	
	//删除体检订单信息
	function del(id) {
		if (confirm("是否确认删除?"))  {  
			jQuery.ajax({
				type:"post",
				url:"order.do?del",
				async:true,
				dataType:"json",
				data:{ids:id},
				success:function(data) {
					alert(data.des);
					if (data.result == "success") {
						go2page(currentshownpage);
					} else {
	                    alert("删除体检订单信息失败");
	                }
				},
				error:function() {
					alert("删除体检订单信息失败");
				}
			});
		}
	}
	
	//匹配订单状态
	function matchingState(state) {
		var name = "";
		switch (state) 
		{
			case 1:
			name = "预约成功";
  			break;
  			
  			case 2:
			name = "体检完成";
  			break;
  			
			case 3:
			name = "生成报告(未支付余额)";
  			break;
  			
  			case 4:
			name = "生成报告(已支付余额)";
  			break;
  			
  			case 5:
			name = "取消";
  			break;
		
			default:
  			break;
		}
		return name;
	}
	</script>
	</body>
</html>