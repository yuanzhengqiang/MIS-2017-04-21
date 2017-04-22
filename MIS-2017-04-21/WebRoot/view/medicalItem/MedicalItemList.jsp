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
  	<style type="text/css">
      .timeTip{width:220px;height:80px;background:#f3f9ff;border:2px solid #dadada;z-index:10;}
      .timeTip div{margin:20px 30px}
      .hideAndShow{display:none;}
  	</style>
</head>
<body style="opacity: 1; margin-left: 0px;">
	<div style="width: 100%; height: 100%;">
		<div class="container-fluid" style="padding: 0px">
		<!-- 头部开始 -->
			<div class="page-head">
				<h2>体检项目管理</h2>
				<ol class="breadcrumb">
					<li>首页</li>
					<input type="hidden" value="" id="sortType">
					<input type="hidden" value="" id="sortColumn">
					<li class="active">体检项目管理</li>
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
										<div class="col-xs-6 col-sm-2 text-center" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
                      						<label>项目名称</label>
                    					</div>
                    					<div class="col-xs-6 col-sm-4" style="margin-bottom:5px;">
                       						<input id="queryItemName" class="form-control" type="text" value="" autocomplete="off">
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
														<th style="width:2%;"><input id="allselectchecker" type="checkbox" class="col_selector" onclick="selectAll();"></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_loginname')"><strong>项目名称</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_type')"><strong>价格</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_type')"><strong>类别</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_type')"><strong>检测方式</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'status')"><strong>检测目的</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_type')"><strong>选择说明</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'lastLoginTime')"><strong>备注</strong></th>													
														<th name="needSort" class="sorting" onclick="queryBySort(this,'loginNum')"><strong>注意事项</strong></th>
														<th><strong>操作<strong></th>
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
								<label class="col-sm-3 control-label">项目名称</label>
								<div class="col-sm-6">
									<input id="itemName" type="text" class="form-control" autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">价格</label>
								<div class="col-sm-6">
									<input id="price"class="form-control" autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">类别</label>
								<div class="col-sm-6">
									<select id="category" style="width:100%;height:30px;">
										<option value=""></option>
                       					<option value="0">基础检查</option>
                       					<option value="1">肿瘤</option>
                       					<option value="2">心脑血管</option>
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
						</form>
					</div>
					<div class="footer">
						<div class="form-group" style="text-align: center;margin:0px">
							<button type="button" class="btn btn-primary btn-rad" onclick="saveInfo();">
								<span><i class="fa fa-check" style="margin-right:5px;"></i>保存</span>
							</button>
							<button id="cancel_button" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
								<span><i class="fa fa-times" style="margin-right:5px;"></i>取消</span>
							</button>
						</div>
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
<script type="text/javascript" src="js/jquery.md5.js"></script>
<script type="text/javascript" src="js/jquery.datatables/jquery.datatables.min.js"></script>
<script type="text/javascript" src="js/jquery.datatables/bootstrap-adapter/js/datatables.js"></script>
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
	$("#price").val("");
	$("#category").val("");
	$("#testWay").val("");
	$("#testPurpose").val("");
	$("#selectDes").val("");
	$("#mattersNeedAttention").val("");
	$("#des").val("");
	$("#editDes").click();
}

//编辑显示详情
function editInfo(id, itemName, price, category, testWay, testPurpose, selectDes, des, mattersNeedAttention) {
	$("#medicalItemInfoId").val(id);
	$("#itemName").val(itemName);
	$("#price").val(price);
	$("#category").val(category);
	$("#testWay").val(testWay);
	$("#testPurpose").val(testPurpose);
	$("#selectDes").val(selectDes);
	$("#mattersNeedAttention").val(mattersNeedAttention);
	$("#des").val(des);
	$("#editDes").click();
}

//删除
function doDel() {
	var selectedItemNumber = $("tbody#datacontainer .col_selector:checked").length;
	if (selectedItemNumber >= 1) {
		$("#isSure2Delete").addClass("md-show");
		document.getElementById("Sure2Delete").onclick = function(){   //使用.click会重复
		$("#isSure2Delete").removeClass("md-show");
		var ids2del = "";
		$("tbody#datacontainer .col_selector:checked").each(function() {
			ids2del += $(this).val() + ",";
		});
		if (ids2del != "") {
			ids2del = ids2del.substring(0, ids2del.length - 1);
		}
		
		jQuery.ajax({
			type:"post",
			url: "medicalItem.do?del",
			async:true,
			dataType:"json",
			data:{ids:ids2del},
			success:function(data) {
				alert(data.des);
				if (data.result == "success") {
					go2page(1);
				}else if(data.des=="failure"){
                 alert("删除失败");
                }
			},
			error:function() {
				alert("删除失败");
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
 * 保存信息
 * @method saveInfo
 */
function saveInfo() {
	var id = $("#medicalItemInfoId").val();
	var itemName = $.trim($("#itemName").val());
	var price = $.trim($("#price").val());
	var category = $.trim($("#category").val());
	var testWay = $.trim($("#testWay").val());
	var testPurpose = $.trim($("#testPurpose").val());
	var selectDes = $.trim($("#selectDes").val());
	var mattersNeedAttention = $.trim($("#mattersNeedAttention").val());
	var des = $.trim($("#des").val());
	
	var reqmsg="{'action':'ADD_MEDICAL_ITEM_INFO_REQUEST','content':{";
	
	if (id != null && id != "") {
		reqmsg += "\"id\":" + id + ",";
	} else {
		reqmsg += "\"id\":,";
	}
	reqmsg += "\"itemName\":\"" + itemName + "\",";
	    
	reqmsg += "\"price\":\"" + price + "\",";
	reqmsg += "\"category\":" + category + ",";
	reqmsg += "\"testWay\":\"" + testWay + "\",";
	reqmsg += "\"testPurpose\":\"" + testPurpose + "\",";
	    
	if (selectDes != null && selectDes != "") {
        reqmsg += "\"selectDes\":\"" + selectDes + "\",";
	} else {
		reqmsg += "\"selectDes\":\"\",";
	}
	if (mattersNeedAttention != null && mattersNeedAttention != "") {
        reqmsg += "\"mattersNeedAttention\":\"" + mattersNeedAttention + "\",";
	} else {
		reqmsg += "\"selectDes\":\"\",";
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

function go2page(pagenumber){
	var pagesize = $("#pageSizeSelector option:selected").val();
	var itemName = $("#queryItemName").val();
	var reqmsg="{'action':'QUERY_MEDICAL_ITEM_LIST_REQUEST',";
	
	var sortType = $("#sortType").val();
	var sortColumn = $("#sortColumn").val();
	if(sortType != null && sortType != ""){
		reqmsg += "'order':[{'column':'" + sortColumn + "','type':'" + sortType + "'}],";
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
		case 0:
			statusName = "正常";
			break;
		case 1:
			statusName = "过期";
			break;
		case 2:
			statusName = "锁定";
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
		    htmlcode += "<td>" + item.price + "</td>";	
		    htmlcode += "<td>" + item.category + "</td>";
		    htmlcode += "<td>" + item.testWay + "</td>";	
		    htmlcode += "<td>" + item.testPurpose + "</td>";
		    htmlcode += "<td>" + item.selectDes + "</td>";
		    htmlcode += "<td>" + item.des + "</td>";
		    htmlcode += "<td>" + item.mattersNeedAttention + "</td>";
			htmlcode += "<td><div class=\"btn-group\">";
			htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
			htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
			htmlcode += "<span class=\"caret\"></span>";
			htmlcode += "<span class=\"sr-only\">Toggle Dropdown</span>";
			htmlcode += "</button>";
			htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";
			htmlcode += "<li onclick=\"editInfo("+item.id+","+ item.itemName+","+ item.price+","+ item.category+","+ item.testWay+","+ item.testPurpose+","+ item.selectDes+","+ item.des+","+ item.mattersNeedAttention+")\"><a href=\"###\">编辑</a></li>";
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
<!-- 弹出框 -->
	<div id="timeTip" class="timeTip" style="position:absolute;left:0;top:0;display:none;"></div> 
  </body>
</html>