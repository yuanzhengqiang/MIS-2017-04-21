<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="images/favicon.png">

<title>微信菜单管理</title>

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
				<h2>微信菜单管理</h2>
				<ol class="breadcrumb">
					<li><a href="welcome.do?center">首页</a>
					</li>
					<li class="active">微信菜单管理</li>
				</ol>
			</div>
		</div>
		<!-- 头部结束 -->

		<div class="cl-mcont">
			<div class="row">
				<div class="col-md-12">
					<div class="block-flat">
						<div class="header">
							<h3>微信菜单管理</h3>
						</div>

						<div class="content">
							<div class="table-responsive">
								<div class="dataTables_wrapper form-inline">
									<!-- 操作按钮开始 -->
									<div class="row">
										<div class="col-sm-12">
											<c:if test="${weChatMenuList_add_btn_control != 'yes' or weChatMenuList_add_btn_show == 'yes'}">
												<button type="button" class="btn btn-primary btn-flat"
													style="float: right;" id="addFirstMenuId"
													onclick="addFirstMenu()">
													<span><i class="fa fa-plus"
														style="margin-right:5px;"></i>新增一级菜单</span>
												</button>
												<button type="button" style="display: none"
													class="md-trigger" id="fake_add" data-modal="md-scale"></button>
											</c:if>
											<button type="button" class="btn btn-primary btn-flat" style="float: right;" onclick="updateWeChatMenu()">
													<span><i class="fa fa-cloud-upload"
														style="margin-right:5px;"></i>更新微信菜单</span>
												</button>
										</div>
									</div>
									<!-- 操作按钮结束 -->
									<!-- 数据表格开始 -->
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-bordered dataTable" id="datatable"
												aria-describedby="datatable_info">
												<thead>
													<tr role="row">
														<th><strong>菜单名称</strong>
														</th>
														<th><strong>菜单地址</strong>
														</th>
														<th><strong>菜单级别</strong>
														</th>
														<th><strong>编辑时间</strong>
														</th>
														<th><strong>地址类型</strong>
														</th>
														<th><strong>菜单顺序</strong>
														</th>
														<th><strong>操作</strong>
														</th>
													</tr>
												</thead>
												<tbody id="datacontainer" role="alert" aria-live="polite"
													aria-relevant="all">
												</tbody>

											</table>
										</div>
									</div>
									<!-- 数据表格结束 -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Nifty Modal -->
	<div class="md-modal md-effect-1" id="md-scale"
		style="height:650px;background:#fff;">
		<div class="row">
			<div class="col-md-12">
				<div class="block-flat">
					<div class="header">
						<h3>菜单信息</h3>
					</div>
					<div class="content">
						<form class="form-horizontal group-border-dashed" action="#"
							style="border-radius: 0px;">
							<input type="hidden" id="menuId">
							<div class="form-group">
								<label class="col-sm-3 control-label color-danger">菜单名称</label>
								<div class="col-sm-6">
									<input id="menuName" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">菜单地址</label>
								<div class="col-sm-6" disabled="disabled">
									<input id="menuAddress" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label color-danger">菜单级别</label>
								<div class="col-sm-6">
									<input id="menulevel" type="text" class="form-control"
										disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label color-danger">地址类型</label>
								<div class="col-sm-6">
									<select class="form-control" type="text" id="menuAddressType"
										style="width: 100%" onchange="menuAddressTypeChange()">
										<option value="1">系统</option>
										<!-- <option value="2">微盟</option> -->
										<option value="3">跳转链接</option>
										<option value="4">下发消息</option>
									</select>
								</div>
								<div class="col-sm-3">
									<button type="button" class="btn btn-primary"
										id="chooseSourceMaterialId" onclick="chooseSourceMaterial(1);">
										选择
									</button>
									<button type="button" style="display: none"
										class="btn btn-primary btn-flat btn-rad md-trigger"
										data-modal="sourceMaterialModal" id="sourceMaterialModalId">
									</button>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label color-danger">菜单顺序</label>
								<div class="col-sm-6">
									<input id="menuOrderColumn" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="text-align: center;">
								<button type="button" class="btn btn-primary btn-rad"
									id="saveAddFather" onclick="saveWeChatMenu('addFather');">
									<span><i class="fa fa-check" style="margin-right:5px;"></i>保存</span>
								</button>
								<button type="button" class="btn btn-primary btn-rad"
									id="saveAddSon" onclick="saveWeChatMenu('addSon');">
									<span><i class="fa fa-check" style="margin-right:5px;"></i>保存</span>
								</button>
								<button type="button" class="btn btn-primary btn-rad"
									id="saveEdit" onclick="saveWeChatMenu('editSon');">
									<span><i class="fa fa-check" style="margin-right:5px;"></i>保存</span>
								</button>
								<button type="button" id="closePopup"
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

	<!-- 素材列表 -->
	<div class="md-modal colored-header custom-width md-effect-9"
		id="sourceMaterialModal">
		<div class="md-content">
			<div class="modal-header">
				<h3>素材列表</h3>
				<button type="button" class="close md-close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body " id="materialData" style="height:280px;overflow-y:scroll;border:1px solid #ddd;">
				<!-- 数据表格开始 -->
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered dataTable hover" id="datatableMateria"
							aria-describedby="datatable_info">
							<thead>
								<tr role="row">
									<th><strong>选择</strong>
									</th>
									<th><strong>标题</strong>
									</th>
									<th><strong>作者</strong>
									</th>
								</tr>
							</thead>
							<tbody id="datacontainerMateria" role="alert" aria-live="polite"
								aria-relevant="all">
							</tbody>
						</table>
					</div>
				</div>
				<!-- 数据表格结束 -->
				<!-- 分页条开始 -->
				<div class="row">
					<div class="col-sm-4">
						<div class="dataTables_length">
							<label style="margin-top:18px;">每页10条</label>
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
			<div class="modal-footer">
				<button type="button" id="closeMateriaPopup" style="display:none;"
					class="btn btn-default btn-flat md-close" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>

	<!-- Nifty Modal -->

	<div class="md-overlay"></div>
	<!-- Nifty Modal的遮罩层-->
	<script type="text/javascript"
		src="js/mordo.tools/mordo.timeProcessing.js"></script>
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
	<script src="js/jquery.treetable.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
    	App.init();
   	    $(".md-trigger").modalEffects();
		queryWeChatFatherMenuList();//初始化，查询微信菜单父列表
	});
	
	//查询微信父菜单列表
	function queryWeChatFatherMenuList() {
		var htmlcode = "";
		var reqmsg = "{'action':'QUERY_MENU_LIST_REQUEST','order':[{'column':'orderColumn','type':'asc'}],'page':{'pageno':'1','pagesize':'3'},'content':{'parentId':0}}";
		
	    jQuery.ajax({
	          type : "post",
	          async: false,
	          url : "menu.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des == "success"){
	            	 if (data.content != null) {
	            	 	if (data.content.menuList != null) {
	            	 		var num = 0;
							jQuery.each(data.content.menuList, function(i, item) {
								var menusSon = queryWeChatChildMenuList(item.id);//根据父菜单id获取子菜单放入子菜单对象
								htmlcode += weChatMenuListMontage(item,menusSon);//拼接列表
								num ++;
							});
							if(num < 3){
								$("#addFirstMenuId").show();//父菜单数量小于3个，显示新增一级菜单按钮
							}else{
								$("#addFirstMenuId").hide();//否则隐藏
							}
							$("#datacontainer").html(htmlcode);
							loadPlugStyle();
						}
					 }
	              }else{
	                 alert("查询微信父菜单列表失败");
	              }
	          },
	          error:function(){
		          alert("查询微信父菜单列表失败");
	          }
	     });
	}
	//查询微信子菜单列表
	function queryWeChatChildMenuList(id) {
		var menusSon = new Array();
		var reqmsg = "{'action':'QUERY_MENU_LIST_REQUEST','order':[{'column':'orderColumn','type':'asc'}],'page':{'pageno':'1','pagesize':'5'},'content':{'parentId':" + id + "}}";
		
	    jQuery.ajax({
	          type : "post",
	          async: false,
	          url : "menu.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des == "success"){
	            	 if (data.content != null) {
	            	 	if (data.content.menuList != null) {
							jQuery.each(data.content.menuList, function(i, item) {
								menusSon.push(item);
							});
						}
					 }
	              }else{
	                 alert("查询微信子菜单列表失败");
	              }
	          },
	          error:function(){
		          alert("查询微信子菜单列表失败");
	          }
	     });
	     return menusSon;
	}
	//微信菜单列表拼接 单独每列
	function weChatMenuListMontage(menuFather,menuSon){
		var htmlcode = "";
		htmlcode += "<tr class=\"gradeA odd\" data-tt-id='" + menuFather.id + "' data-tt-parent-id='" + menuFather.parentId + "'>";
		htmlcode += "<td>" + menuFather.name + "</td>";	
		if(menuFather.address != null && menuFather.address != ""){
			htmlcode += "<td>" + ((menuFather.address.length > 30) ? (menuFather.address.substr(0,30) + "...") : menuFather.address) + "</td>";
		}else{
			htmlcode += "<td></td>";
		}
		htmlcode += "<td>一级菜单</td>";
		htmlcode += "<td>" + formateTime(menuFather.createTime) + "</td>";	
		htmlcode += "<td>" + matchingAddressType(menuFather.addressType) + "</td>";
		htmlcode += "<td>" + menuFather.orderColumn + "</td>";
	
		htmlcode += "<td><div class=\"btn-group\">";
		htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
		htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
		htmlcode += "<span class=\"caret\" style=\"padding:0;\"></span>";
		htmlcode += "<span class=\"sr-only\">Toggle Dropdown</span>";
		htmlcode += "</button>";
		htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";
		if(menuSon.length < 5){//子菜单数量小于5个，显示新增子菜单按钮
			htmlcode += "<li onclick=\"addMenuSon('" + menuFather.id +"')\"><a href=\"###\">新增子菜单</a></li>";
		}
		htmlcode += "<li onclick=\"editMenu('" + menuFather.id + "')\"><a href=\"###\">编辑</a></li>";
		htmlcode += "<li onclick=\"delMenu('" + menuFather.id + "')\"><a href=\"###\">删除</a></li></ul>";
		htmlcode += "</div></td>";
		htmlcode += "</tr>";
		if(menuSon != null && menuSon.length > 0){
			for(var i = 0; i < menuSon.length; i++) {
				htmlcode += "<tr class=\"gradeA odd\" data-tt-id='" + menuSon[i].id + "' data-tt-parent-id='" + menuSon[i].parentId + "'>";
				htmlcode += "<td>" + menuSon[i].name + "</td>";	
				if(menuSon[i].address != null && menuSon[i].address != ""){
					htmlcode += "<td>" + ((menuSon[i].address.length > 30) ? (menuSon[i].address.substr(0,30) + "...") : menuSon[i].address) + "</td>";
				}else{
					htmlcode += "<td></td>";
				}
				htmlcode += "<td>二级菜单</td>";
				htmlcode += "<td>" + formateTime(menuSon[i].createTime) + "</td>";	
				htmlcode += "<td>" + matchingAddressType(menuSon[i].addressType) + "</td>";
				htmlcode += "<td>" + menuSon[i].orderColumn + "</td>";
				htmlcode += "<td><div class=\"btn-group\">";
				htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
				htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
				htmlcode += "<span class=\"caret\" style=\"padding:0;\"></span>";
				htmlcode += "<span class=\"sr-only\">Toggle Dropdown</span>";
				htmlcode += "</button>";
				htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";
				htmlcode += "<li onclick=\"editMenu('" + menuSon[i].id + "')\"><a href=\"###\">编辑</a></li>";
				htmlcode += "<li onclick=\"delMenu('" + menuSon[i].id + "')\"><a href=\"###\">删除</a></li></ul>";
				htmlcode += "</div></td>";
				htmlcode += "</tr>";
			}
		}
		return htmlcode;
	}
	
	//删除微信菜单
	function delMenu(id) {
	    if (confirm("删除操作会连带删除下面的子菜单，是否确认删除?"))  {  
			jQuery.ajax({
				type: "post",
				url: "menu.do?del",
				async: true,
				dataType: "json",
				data:{
					ids:id
				},
				success:function(data) {
					if (data.result == "success") {
						alert("删除微信菜单成功");
						var myiframe = window.parent.frames['welcomeCenter'];
		                myiframe.src = myiframe.src
					}else{
	                    alert("删除微信菜单失败");
	                }
				},
				error:function() {
					alert("删除微信菜单失败");
				}
			});
		}
	}
	
	//清空重置弹窗
	function resetMenuPopup() {
		$("#menuId").val("");
		$("#menuName").val("");
		$("#menuAddress").val("");
		$("#menulevel").val("");
		$("#menuAddressType").val("1");
		$("#chooseSourceMaterialId").hide();
		$("#menuOrderColumn").val("");
	}
	
	//编辑微信菜单
	function editMenu(id) {
		resetMenuPopup();
		$("#menuId").val(id);
		var reqmsg = "{'action':'QUERY_MENU_INFO_REQUEST','content':{'id':" + id + "}}";
		
		jQuery.ajax({
			type : "post",
			async : true,
			url : "menu.do?handler",
			dataType : "json",
			data: {
				"reqmsg":reqmsg
			},
			success : function(data) {
				if (data.des == "success") {
					if (data.content != null){
						$("#menuName").val(data.content.name);
						$("#menuAddress").val(data.content.address);
						if(data.content.parentId == 0){
							$("#menulevel").val("一级菜单");
						}else{
							$("#menulevel").val("二级菜单");
						}
						$("#menuAddressType").val(data.content.addressType);
						if(data.content.addressType == 3){//如果是素材，显示素材按钮
							$("#chooseSourceMaterialId").show();
						}
						$("#menuOrderColumn").val(data.content.orderColumn);
					}
					$("#saveEdit").show();
					$("#saveAddFather").hide();
					$("#saveAddSon").hide();
					$("#fake_add").click();//打开弹窗
				} else{
					alert("查询微信菜单详情失败");
				}
			},
			error:function() {
				alert("查询微信菜单详情失败");
			}
		});
	}
	//新增子菜单
	function addMenuSon(id){
		resetMenuPopup();
		$("#menuId").val(id);
		$("#menulevel").val("二级菜单");
		$("#saveAddFather").hide();
		$("#saveEdit").hide();
		$("#saveAddSon").show();
		$("#fake_add").click();//打开弹窗
	}
	//新增一级菜单
	function addFirstMenu(){
		resetMenuPopup();
		$("#menulevel").val("一级菜单");
		$("#saveAddFather").show();
		$("#saveAddSon").hide();
		$("#saveEdit").hide();
		$("#fake_add").click();//打开弹窗
	}
	//保存微信菜单信息
	function saveWeChatMenu(flag) {
		var menuId = $("#menuId").val();
		var menuName = $("#menuName").val();
		var menuAddress = $("#menuAddress").val();
		var menuAddressType = $("#menuAddressType").val();
		var menuOrderColumn = $("#menuOrderColumn").val();
		if(menuName == null || menuName == ""){
			alert("菜单名称必填");
			return;
		}
		if(menuOrderColumn == null || menuOrderColumn == ""){
			alert("菜单顺序必填");
			return;
		}
		
		var reqmsg = "{'action':'ADD_MENU_INFO_REQUEST','content':{";
		if(flag == 'addFather'){//新增一级菜单操作
			reqmsg += "'parentId':0,";
		}else if(flag == 'addSon'){//新增子菜单操作
			reqmsg += "'parentId':" + menuId + ",";
		}else if(flag == 'editSon'){//编辑菜单操作
			reqmsg += "'id':" + menuId + ",";
		}
		reqmsg += "'name':'" + menuName + "',"; 
		reqmsg += "'address':'" + menuAddress + "',";
		reqmsg += "'addressType':" + menuAddressType + ",";
		reqmsg += "'orderColumn':" + menuOrderColumn + ",";
		reqmsg += "}}";
		
		jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "menu.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des == "success"){
	              	 alert("保存微信菜单信息成功");
	              	 $("#closePopup").click();//关闭弹窗
	              	 var myiframe = window.parent.frames['welcomeCenter'];
		             myiframe.src = myiframe.src
	              }else{
	                 alert("保存微信菜单信息失败");
	              }
	          },
	          error:function(){
		          alert("保存微信菜单信息失败");
	          }
	     });
	}
	
	//更新微信菜单
	function updateWeChatMenu(){
		jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "menu.do?updateWeChatMenu",
	          dataType : "json",
	          data: {},
	          success : function(data){
	              if(data.des == "success"){
	              	 alert(data.result);
	              }else{
	                 alert(data.result);
	              }
	          },
	          error:function(){
		          alert("更新微信菜单失败");
	          }
	    });
	}		
	
	//选择素材
	function chooseSourceMaterial(currentshownpage){
		var html = "";
		var total_count = 0;
		var menuAddressType = $("#menuAddressType").val();
		jQuery.ajax({
	          type : "post",
	          async:false,
	          url : "menu.do?getMaterial",
	          dataType : "json",
	          data: {
	          	"currentshownpage":currentshownpage
	          },
	          success : function(data){
	              if(data.des == "success"){
	              	 if(data.item != null){
	              	 	if(data.item.item != null && data.item.item.length > 0){
		              	 	jQuery.each(data.item.item, function(i, item) {
		              	 		html += "<tr>";
		              	 		if (menuAddressType == "3") {//跳转链接
			              	 		if(item.content != null){
			              	 			if(item.content.news_item != null && item.content.news_item.length > 0){
			              	 				html += "<td class=\"btn btn-primary btn-md\" style=\"color:#fff;\" onclick=\"$('#menuAddress').val('" + item.content.news_item[0].url + "');$('#closeMateriaPopup').click();\">选择</td>";
			              	 			}
			              	 		}
		              	 		} else if (menuAddressType == "4") {//下发消息
			              	 		html += "<td class=\"btn btn-primary btn-md\" style=\"color:#fff;\" onclick=\"$('#menuAddress').val('" + item.media_id + "');$('#closeMateriaPopup').click();\">选择</td>";
			              	 	}
			              	 	html += "<td>" + item.content.news_item[0].title + "</td>";
			              	 	html += "<td>" + item.content.news_item[0].author + "</td>";
								html += "</tr>";
		              	 	});
	              	 	}
		              	total_count = data.item.total_count;//微信只返回total_count该类型的素材的总数，item_count本次调用获取的素材的数量，本页面固定10
	              	 }
	              	 $("#datacontainerMateria").html(html);
					 $("#sourceMaterialModalId").click();//打开素材弹窗
	              }else{
	                 alert(data.result);
	              }
	          },
	          error:function(){
		          alert("获取微信素材信息失败");
	          }
	    });
	    if (total_count < 11) {//总数据条数
	    	genaratePaginateHtml(1, 1);
		} else {
			genaratePaginateHtml(currentshownpage, Math.ceil(total_count/10));
		}
	}	
	
	/**
	 * 生成分页信息
	 * @method genaratePaginateHtml
	 * @param {Number} currentshownpage 当前页
	 * @param {Number} totalpage 总页数
	 */
	function genaratePaginateHtml(currentshownpage, totalpage) {
		var htmlcode = "";
		//上一页
		if (currentshownpage > 1) {
			htmlcode += "<li class=\"pre\"><a href=\"#\" onclick=\"chooseSourceMaterial(1)\"><span class=\"fa fa-angle-left\"></span>&nbsp;首页</a></li>";
			htmlcode += "<li class=\"pre\"><a href=\"#\" onclick=\"chooseSourceMaterial('" + (currentshownpage - 1) + "')\"><span class=\"fa fa-angle-left\"></span>&nbsp;上一页</a></li>";
		} else {
			htmlcode += "<li class=\"pre disabled\"><a href=\"#\"><span class=\"fa fa-angle-left\"></span>&nbsp;首页</a></li>";
			htmlcode += "<li class=\"pre disabled\"><a href=\"#\"><span class=\"fa fa-angle-left\"></span>&nbsp;上一页</a></li>";
		}
		
		//具体页码
		if (totalpage <= 5) {
			for (var i = 1; i <= totalpage; i++) {
				if (currentshownpage == i) {
					htmlcode += "<li class=\"active\"><a href=\"#\">" + i + "</a></li>";
				} else {
					htmlcode += "<li><a href=\"#\" onclick=\"chooseSourceMaterial(" + i + ")\">" + i + "</a></li>";
				}
			}
		} else {
			var startpage = currentshownpage;
			var endpage = currentshownpage;
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
				if (currentshownpage == i) {
					htmlcode += "<li class=\"active\"><a href=\"#\">" + i + "</a></li>";
				} else {
					htmlcode += "<li><a href=\"#\" onclick=\"chooseSourceMaterial(" + i + ")\">" + i + "</a></li>";
				}
			}
		}
		
		//下一页
		if (totalpage > currentshownpage) {
			htmlcode += "<li class=\"next\"><a href=\"#\" onclick=\"chooseSourceMaterial(" + (parseInt(currentshownpage) + 1) + ")\">下一页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
			htmlcode += "<li class=\"next\"><a href=\"#\" onclick=\"chooseSourceMaterial(" + parseInt(totalpage) + ")\">末页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
		} else {
			htmlcode += "<li class=\"next disabled\"><a href=\"#\">下一页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
			htmlcode += "<li class=\"next disabled\"><a href=\"#\">末页&nbsp;<span class=\"fa fa-angle-right\"></span></a></li>";
		}
		$("#paginationArea").html(htmlcode);
	}	
	
	//地址类型单选框变化事件
	function menuAddressTypeChange(){
		var menuAddressType = $("#menuAddressType").val();
		if(menuAddressType == "3" || menuAddressType == "4"){//显示素材按钮
			$("#chooseSourceMaterialId").show();
		}else{
			$("#chooseSourceMaterialId").hide();
		}
	}
	
	//匹配地址类型
	function matchingAddressType(addressType){
		var name = "未知";
	    switch (addressType)
		{
			case 1:
	  		name="系统";
	  		break;
	  			
			case 2:
	  		name="微盟";
	  		break;
	
			case 3:
	  		name="跳转链接";
	  		break;
	  		
	  		case 4:
	  		name="下发消息";
	  		break;
	  			
	  		default:
	  		break;
		}
		return name;
	}
	
	//加载插件样式
	function loadPlugStyle(){
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
	}
	
	</script>
</body>
</html>