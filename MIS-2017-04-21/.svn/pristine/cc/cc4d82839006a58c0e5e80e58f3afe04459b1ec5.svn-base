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
	<title>角色管理</title>
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
	<link rel="stylesheet" href="css/jquery.treetable.theme.default.css" />
	<link rel="stylesheet" href="css/jquery.treetable.css" />
	<link href="js/jquery.icheck/skins/square/blue.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="js/jquery.datatables/bootstrap-adapter/css/datatables.css" />
	<script type="text/javascript" src="js/sortListTool.js"></script>
	<style>
		#data-rule-edit-tag a{padding-left:6px;padding-right:6px;min-width: 50px}
	</style>
</head>
<body style="opacity: 1; margin-left: 0px;">
	<div style="width: 100%; height: 100%;">
		<div class="container-fluid" style="padding: 0px">
			<!-- 头部开始 -->
			<div class="page-head">
				<h2>角色管理</h2>
				<ol class="breadcrumb">
					<li><a href="welcome.do?center">首页</a></li>
					<input type="hidden" value="" id="sortType">
					<input type="hidden" value="" id="sortColumn">
					<li class="active">角色管理</li></ol>
			</div>
		</div>
		<!-- 头部结束 -->
		<div class="cl-mcont">
			<div class="row">
				<div class="col-md-12">
					<div class="block-flat">
						<div class="header">
							<h3>角色表格数据</h3></div>
						<div class="content">
							<div class="table-responsive">
								<div class="dataTables_wrapper form-inline">
									<!-- 查询框开始 -->
									<div class="row">
										<div class="col-sm-1" style="margin-top:5px ;margin-bottom:5px;">
											<label>角色名称</label></div>
										<div class="col-sm-5">
											<input class="form-control" type="text" id="rolename_input" style="width:100%"></div>
										<div class="col-sm-1" style="clear:both;margin-top:5px ;margin-bottom:5px; ">
											<label>创建时间</label></div>
										<div class="col-sm-5">
											<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;">
												<span class="input-group-addon btn btn-primary">
													<span class="glyphicon glyphicon-th"></span>
												</span>
												<input class="form-control" size="16" value="" readonly="" type="text" id="createdate_start" placeholder="开始时间">
												<span class="input-group-btn">
													<button class="btn btn-danger deleteThisTime" type="button">
														<span class="fa fa-times"></span>
													</button>
												</span>
											</div>
										</div>
										<div class="col-sm-5">
											<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;">
												<span class="input-group-addon btn btn-primary">
													<span class="glyphicon glyphicon-th"></span>
												</span>
												<input class="form-control" size="16" value="" readonly="" type="text" id="createdate_end" placeholder="结束时间">
												<span class="input-group-btn">
													<button class="btn btn-danger deleteThisTime" type="button">
														<span class="fa fa-times"></span>
													</button>
												</span>
											</div>
										</div>
									</div>
									<!-- 查询框结束 -->
									<!-- 操作按钮开始 -->
									<div class="row">
										<div class="col-sm-12">
											<c:if test="${role_query_btn_control != 'yes' or role_query_btn_show == 'yes'}">
												<button class="btn btn-primary" style="margin-bottom: 0px !important; height: 34px;margin-left:0;" onclick="query()">查询</button>
											</c:if>
											<c:if test="${role_del_btn_control != 'yes' or role_del_btn_show == 'yes'}">
												<button type="button" class="btn btn-danger btn-flat" style="float: right; margin-right: 0px;" onclick="doDel()">
													<span><i class="fa fa-trash-o" style="margin-right:5px;"></i>删除</span>
												</button>
											</c:if>
											<!-- <c:if test="${role_edit_btn_control !=' yes' or role_edit_btn_show==' yes'}"> -->
											<!-- <button type="button" class="btn btn-primary btn-flat" style="float: right;" onclick="doEdit()"> -->
											<!-- <span><i class="fa fa-pencil" style="margin-right:5px;"></i>编辑</span> -->
											<!-- </button> -->
											<!-- </c:if> -->
											<button type="button" style="display: none" class="md-trigger" id="realyedit" data-modal="md-scale"></button>
											<c:if test="${role_add_btn_control != 'yes' or role_add_btn_show == 'yes'}">
												<button type="button" class="btn btn-primary btn-flat md-trigger" data-modal="md-scale" style="float: right;" onclick="doAdd()">
													<span><i class="fa fa-plus" style="margin-right:5px;"></i>新增</span>
												</button>
											</c:if>
											<button type="button" style="display: none" class="md-trigger" id="realymodule" data-modal="md-scale-module"></button>
											<!-- <c:if test="${role_data_add_btn_control !=' yes' or role_data_add_btn_show==' yes'}"> -->
											<!-- <button type="button" class="btn btn-success btn-flat" style="float: right;"> -->
											<!-- <span><i class="fa fa-tag" style="margin-right:5px;"></i>数据权限</span>												 -->
											<!-- </button> -->
											<!-- </c:if> -->
											<button type="button" style="display: none" class="md-trigger" id="realydatarule" data-modal="md-scale-data-rule"></button>
											<button type="button" style="display: none" class="md-trigger" id="realymodule" data-modal="md-scale-module"></button>
											<!-- <c:if test="${role_module_add_btn_control !=' yes' or role_module_add_btn_show==' yes'}"> -->
											<!-- <button type="button" class="btn btn-success btn-flat" style="float: right;" onclick="doAddModuleList()"> -->
											<!-- <span><i class="fa fa-paperclip" style="margin-right:5px;"></i>功能权限</span>												 -->
											<!-- </button> -->
											<!-- </c:if> -->
										</div>
									</div>
									<!-- 操作按钮结束 -->
									<!-- 数据表格开始 -->
									<div class="row">
										<div class="col-sm-12">
											<table class="table table-bordered dataTable hover" id="datatable" aria-describedby="datatable_info">
												<thead>
													<tr role="row">
														<th style="width:2%;">
															<input id="allselectchecker" type="checkbox" class="col_selector" onclick="selectAll();"></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_name')">
															<strong>角色名称</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_des')">
															<strong>角色描述</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'createTime')">
															<strong>创建时间</strong></th>
														<th>
															<strong>操作</strong></th>
													</tr>
												</thead>
												<tbody id="datacontainer" role="alert" aria-live="polite" aria-relevant="all"></tbody>
											</table>
										</div>
									</div>
									<!-- 数据表格结束 -->
									<!-- 数据条数提示开始 -->
									<div class="row">
										<div class="col-sm-12">
											<div class="pull-left">
												<div id="datatable_info" class="dataTables_info">当前显示0 条总记录中的第0-0条</div></div>
											<div class="clearfix"></div>
										</div>
									</div>
									<!-- 数据条数提示结束 -->
									<!-- 分页条开始 -->
									<div class="row">
										<div class="col-sm-4">
											<div class="dataTables_length" id="datatable2_length">
												<label style="margin-top:18px;">每页
													<select id="pageSizeSelector" class="form-control" aria-controls="datatable2" size="1" name="datatable2_length" onchange="query()">
														<option selected="selected" value="10">10</option>
														<option value="25">25</option>
														<option value="50">50</option>
														<option value="100">100</option>
													</select>条</label>
											</div>
										</div>
										<div class="col-sm-8">
											<div class="pull-right">
												<div class="dataTables_paginate paging_bs_normal">
													<ul id="paginationArea" class="pagination"></ul>
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
	<!-- 模态框 开始 -->
	<!-- 角色信息 编辑 -->
	<div class="md-modal md-effect-1" id="md-scale">
		<div class="row">
			<div class="col-md-12">
				<div class="block-flat">
					<div class="header">
						<h3>角色信息</h3></div>
					<div class="content">
						<form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
							<input type="hidden" name="entityId" id="entityId">
							<div class="form-group">
								<label class="col-sm-3 control-label">角色名称</label>
								<div class="col-sm-6">
									<input id="name" type="text" class="form-control"></div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">角色描述</label>
								<div class="col-sm-6">
									<input id="des" type="text" class="form-control"></div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">父ID</label>
								<div class="col-sm-6">
									<input id="parentId" type="text" class="form-control"></div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">创建用户ID</label>
								<div class="col-sm-6">
									<input id="createUserId" type="text" class="form-control"></div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">创建时间</label>
								<div class="col-sm-6">
									<input id="createTime" type="text" class="form-control"></div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">更新用户ID</label>
								<div class="col-sm-6">
									<input id="updateUserId" type="text" class="form-control"></div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">更新时间</label>
								<div class="col-sm-6">
									<input id="updateTime" type="text" class="form-control"></div>
							</div>
							<div class="form-group" style="text-align: center;">
								<button type="button" class="btn btn-primary btn-rad" onclick="saveInfo();">
									<span>
										<i class="fa fa-check" style="margin-right:5px;"></i>保存</span>
								</button>
								<button id="cancel_button" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
									<span>
										<i class="fa fa-times" style="margin-right:5px;"></i>取消</span>
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 角色信息 新增 -->
	<div class="md-modal md-effect-1" id="md-scale-module">
		<div class="row">
			<div class="col-md-12">
				<div class="block-flat" style="height:650px;overflow:hidden;overflow-y:auto;">
					<div class="header">
						<h3>模块信息</h3></div>
					<div class="content">
						<table class="table table-bordered dataTable" id="datatable-module" aria-describedby="datatable_info">
							<thead>
								<tr role="row">
									<th>
										<strong>模块名称</strong></th>
									<th>
										<strong>模块标识</strong></th>
									<th style="width:2%;">
										<input id="allselectchecker-module" type="checkbox" class="col_selector" onclick="selectModuleAll();"></th>
								</tr>
							</thead>
							<tbody id="datacontainer-module" role="alert" aria-live="polite" aria-relevant="all"></tbody>
						</table>
					</div>
					<div class="form-group" style="text-align: center;">
						<input type="hidden" name="roleId" id="roleId">
						<button type="button" class="btn btn-primary btn-rad" onclick="saveRelationList();">
							<span>
								<i class="fa fa-check" style="margin-right:5px;"></i>保存</span>
						</button>
						<button id="cancel_button-module" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
							<span>
								<i class="fa fa-times" style="margin-right:5px;"></i>取消</span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<!-- 数据权限设置 -->
	<div class="md-modal md-effect-1" id="md-scale-data-rule" style="max-width:1000px;min-width:750px">
		<div class="row">
			<div class="col-md-12">
				<div class="block-flat" style="height:450px;overflow:hidden;overflow-y:auto;min-width:580px;background:#eee;margin-bottom:0">
					<div class="header" style="border-bottom:0">
						<h3>数据权限 --<span id="roleName" style="font-size:18px">角色</span></h3>
					</div>
					<div class="tab-container">
						<ul class="nav nav-tabs" id="data-rule-edit-tag">
							<li class="active">
								<a href="#data-rule1" data-toggle="tab">员工管理</a></li>
							<li class="">
								<a href="#data-rule2" data-toggle="tab">会员</a></li>
							<li class="">
								<a href="#data-rule3" data-toggle="tab">健康评估任务管理</a></li>
							<li class="">
								<a href="#data-rule4" data-toggle="tab">工单管理</a></li>
							<li class="">
								<a href="#data-rule5" data-toggle="tab">护理计划管理</a></li>
							<li class="">
								<a href="#data-rule6" data-toggle="tab">交接班管理</a></li>
							<li class="">
								<a href="#data-rule7" data-toggle="tab">充值消费记录</a></li>
							<li class="">
								<a href="#data-rule8" data-toggle="tab">回访记录</a></li>
							<!--
							<li class=""><a href="#data-rule8" data-toggle="tab">健康评估列表</a></li>  和健康评估任务管理 一致，不显示
							-->
						</ul>
						<div class="tab-content" id="data-rule-edit-content" style="margin-bottom:0">
							<div class="tab-pane  active" id="data-rule1">
								<!-- 员工管理 -->
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad1" class="icheck" value="7" id="radio_7">显示全部站点员工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad1" class="icheck" value="8" id="radio_8">只显示本站点员工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad1" class="icheck" value="11" id="radio_11">只显示本组员工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad1" class="icheck" value="12" id="radio_12">只显示自己</label></div>
							</div>
							<div class="tab-pane " id="data-rule2">
								<!-- 员工 -->
								<p>会员状态（至少选一项，可多选）</p>
								<div class="radio">
									<label>
										<input type="checkbox" checked="" name="check2" class="icheck" value="14" id="radio_14">显示正常状态会员</label></div>
								<div class="radio">
									<label>
										<input type="checkbox" name="check2" class="icheck" value="15" id="radio_15">显示审核不通过状态会员</label></div>
								<div class="radio">
									<label>
										<input type="checkbox" name="check2" class="icheck" value="16" id="radio_16">显示待评估状态会员</label></div>
								<!-- 
								13-正常、审核不通过、待评估 14-正常 15 -审核不通过 16-待评估 17-正常、审核不通过 18-正常、待评估 19- 审核不通过、待评估
								 -->
								<p></p>
								<p>会员站点</p>
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad2" class="icheck" value="2" id="radio_2">显示全部站点会员</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad2" class="icheck" value="3" id="radio_3">显示本站点会员</label></div>
							</div>
							<div class="tab-pane " id="data-rule3">
								<!-- 健康评估任务管理 -->
								<p>评估对象</p>
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad3" class="icheck" value="20" id="radio_20">显示所有站点会员</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad3" class="icheck" value="21" id="radio_21">显示本站点会员</label></div>
								<p></p>
								<p>评估人</p>
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad4" class="icheck" value="22" id="radio_22">显示所有站点员工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad4" class="icheck" value="23" id="radio_23">只显示本站点员工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad4" class="icheck" value="24" id="radio_24">只显示本组员工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad4" class="icheck" value="25" id="radio_25">只显示自己</label></div>
							</div>
							<div class="tab-pane " id="data-rule4">
								<!-- 工单管理 -->
								<p>服务站点</p>
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad5" class="icheck" value="32" id="radio_32">显示全部站点工单</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad5" class="icheck" value="33" id="radio_33">显示本站点工单</label></div>
								<p></p>
								<p>服务人员</p>
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad6" class="icheck" value="34" id="radio_34">显示全部站点护工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad6" class="icheck" value="35" id="radio_35">只显示本站点护工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad6" class="icheck" value="36" id="radio_36">只显示本组护工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad6" class="icheck" value="37" id="radio_37">只显示自己</label></div>
							</div>
							<div class="tab-pane " id="data-rule5">
								<!-- 护理计划管理 -->
								<p>会员</p>
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad7" class="icheck" value="26" id="radio_26">显示全部站点会员</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad7" class="icheck" value="27" id="radio_27">显示本站点会员</label></div>
								<p></p>
								<p>添加人</p>
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad8" class="icheck" value="28" id="radio_28">显示全部站点员工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad8" class="icheck" value="29" id="radio_29">只显示本站点员工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad8" class="icheck" value="30" id="radio_30">只显示本组员工</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad8" class="icheck" value="38" id="radio_38">只显示自己</label></div>
							</div>
							<div class="tab-pane  " id="data-rule6">
								<!-- 交接班管理 -->
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad9" class="icheck" value="45" id="radio_45">显示全部站点交接班</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad9" class="icheck" value="46" id="radio_46">显示本站点交接班</label></div>
							</div>
							<div class="tab-pane  " id="data-rule7">
								<!-- 充值消费记录 -->
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad10" class="icheck" value="47" id="radio_47">显示全部站点会员</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad10" class="icheck" value="48" id="radio_48">显示本站点会员</label></div>
							</div>
							<div class="tab-pane  " id="data-rule8">
								<!-- 回访记录 -->
								<div class="radio">
									<label>
										<input type="radio" checked="" name="rad11" class="icheck" value="49" id="radio_49">显示全部站点</label></div>
								<div class="radio">
									<label>
										<input type="radio" name="rad11" class="icheck" value="50" id="radio_50">显示本站点</label></div>
							</div>
							<!-- 
							<div class="tab-pane " id="data-rule8">
							<p>评估对象</p>
							<div class="radio"> 
							<label> <input type="radio" checked="" name="rad11" class="icheck" value="39" id="radio_39"> 所有会员</label></div>
							<div class="radio"> 
							<label> <input type="radio" name="rad11" class="icheck" value="40" id="radio_40"> 本站会员</label></div>
							<p> </p>
							<p>评估人</p>
							<div class="radio"> 
							<label> <input type="radio" checked="" name="rad12" class="icheck" value="41" id="radio_41"> 全部员工</label></div>
							<div class="radio"> 
							<label> <input type="radio" name="rad12" class="icheck" value="42" id="radio_42"> 本站员工</label></div>
							<div class="radio"> 
							<label> <input type="radio" name="rad12" class="icheck" value="43" id="radio_43"> 本组员工</label></div>
							<div class="radio"> 
							<label> <input type="radio" name="rad12" class="icheck" value="44" id="radio_44"> 自己</label></div>
							</div>
							-->
						</div>
					</div>
					<div class="form-group" style="text-align: center;margin-bottom:0">
						<input type="hidden" name="roleId1" id="roleId1">
						<button type="button" class="btn btn-primary btn-rad" onclick="saveRoleFunctionList();">
							<span>
								<i class="fa fa-check" style="margin-right:5px;"></i>保存</span>
						</button>
						<button id="cancel_button-datarule" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
							<span>
								<i class="fa fa-times" style="margin-right:5px;"></i>取消</span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 二次确认是否删除 模态框 -->
	<div class="md-modal md-effect-1" id="isSure2Delete">
		<div class="row">
			<div class="col-md-12">
				<div class="block-flat">
					<div class="header">
						<h4>是否确认删除选中的角色信息</h4></div>
					<div class="content">
						<p id="isSure2DeleteInfo" style="font-size:18px;margin:20px">该角色信息将被同时从用户的角色信息中删除,确认删除吗?</p>
						<div class="form-group" style="text-align: center;">
							<button type="button" class="btn btn-success btn-rad " id="Sure2Delete">
								<span>
									<i class="fa fa-check" style="margin-right:5px;"></i>确定</span>
							</button>
							<button id="cancel2Delete" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
								<span>
									<i class="fa fa-times" style="margin-right:5px;"></i>取消</span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<!-- Modal的遮罩层-->
	<div class="md-overlay"></div>	
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
<script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
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


	var currentshownpage = 1; //当前页码
	var path="systemRole.do";	
	$(document).ready(function(){
	    App.init();
	    $(".md-trigger").modalEffects(); //初始化js及模态框
		query(); //查询角色
		$(".deleteThisTime").click(function(){ //清除日期框中的值
	       $(this).parent().prev()[0].value = "";
	    });	
	});

	function selectAll() { //全选、反选
		if ($("#allselectchecker").is(':checked')) {
			$(".col_selector").prop("checked", true);
		} else {
			$(".col_selector").prop("checked", false);
		}
	}

	function selectModuleAll() { //所有模块全选、反选
		if ($("#allselectchecker-module").is(':checked')) {
			$("tbody#datacontainer-module .col_selector").prop("checked", true);
		} else {
			$("tbody#datacontainer-module .col_selector").prop("checked", false);
		}
	}

	function doAdd() { //新增角色前 清空原编辑框中内容
		$("#entityId").val("");
		$("#name").val("");
		$("#des").val("");
		$("#parentId").val("");
		$("#createUserId").val("");
		$("#createTime").val("");
		$("#updateUserId").val("");
		$("#updateTime").val("");
	}

	function doEdit() { //编辑角色前，加载角色现有信息
		var selectedItemNumber = $("tbody .col_selector:checked").length;
		if (selectedItemNumber > 1) {
			alert("每次只能编辑一条数据");
		} else if (selectedItemNumber == 1) {
			var id2edit = $("tbody .col_selector:checked").val();
			var reqmsg="{'action':'QUERY_ROLE_INFO_REQUEST','content':{";		
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
		                 $("#realyedit").click();
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
	 * 编辑角色
	 * @param roleid 要编辑的角色id
	 */
	function editRole(roleid) {
		var reqmsg="{'action':'QUERY_ROLE_INFO_REQUEST','content':{";	
		if (roleid != null && roleid != "") {
			reqmsg += "\"id\":" + roleid + ",";
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
					$("#realyedit").click();
				}
			},
			error:function(){
				alert("error");
			}
		});
	}	
	
	function doDel() { //选择需要删除的角色
		var selectedItemNumber = $("tbody .col_selector:checked").length;	
		if (selectedItemNumber >= 1) {
			var ids2del = "";
			$("tbody .col_selector:checked").each(function() {
				ids2del += $(this).val() + ",";
			});
			if (ids2del != "") {
				ids2del = ids2del.substring(0, ids2del.length - 1);
			}			
			delRole(ids2del);
		} else {
			alert("请选择要删除的数据");
		}	
	}

	/**
	 * 删除角色
	 * @param roleids 要删除角色的id，多个id之间用半角逗号分隔
	 */
	function delRole(roleids) {
			$("#isSure2Delete").addClass("md-show");
			//document.getElementById("isSure2DeleteInfo").innerHTML = ; 	//要删除哪些信息在此展示	
			document.getElementById("Sure2Delete").onclick = function(){   //使用.click会重复
				$("#isSure2Delete").removeClass("md-show");
				jQuery.ajax({
					type:"post",
					url:path+"?del",
					async:true,
					dataType:"json",
					data:{ids:roleids},
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
			document.getElementById("cancel2Delete").onclick = function(){
				$("#isSure2Delete").removeClass("md-show");				
			}
	}
	
	/**
	 * 通过按钮分配权限
	 */
	function doAddModuleList() {
		var selectedItemNumber = $("tbody#datacontainer .col_selector:checked").length;
		if (selectedItemNumber > 1) {
			alert("每次只能分配一条数据");
		} else if (selectedItemNumber == 1) {		
			var reqmsg="{'action':'QUERY_MODULE_LIST_REQUEST','order':[{'column':'showIndex','type':'asc'}],'page':{'pageno':'1','pagesize':'10000'},'content':{";
			reqmsg += "\"type\":1,";	
			reqmsg += "\"childModuleListShow\":\"true\",";	
			reqmsg += "}}";			
			var roleId = $("tbody#datacontainer .col_selector:checked").val();	
		    jQuery.ajax({
		          type : "post",
		          async:true,
		          url : "systemModule.do?handler",
		          dataType : "json",
		          data: {
		               "reqmsg":reqmsg
		          },
		          success : function(data){
		              if(data.des=="success"){
		            	  changeModuleList(data,roleId);
		            	  $("#realymodule").click();
		              }else if(data.des=="failure"){
		                 alert("查询失败");
		              }
		          },
		          error:function(){
			           alert("error");
		          }
		     });
		} else {
			alert("请选择一条要分配角色的账号记录");
		}
	}

	function modifyRoleModule(roleid) { //功能权限编辑
		var reqmsg="{'action':'QUERY_MODULE_LIST_REQUEST','order':[{'column':'showIndex','type':'asc'}],'page':{'pageno':'1','pagesize':'10000'},'content':{";
		reqmsg += "\"type_in\":\"1,4\",";	
		reqmsg += "\"childModuleListShow\":\"true\",";	
		reqmsg += "}}";		
		$("#allselectchecker").prop("checked", false);
		$("tbody#datacontainer .col_selector").prop("checked", false);
		$("#roleId").val(roleid);
		var roleId = roleid;
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "systemModule.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	  changeModuleList(data,roleId);
	            	  $("#realymodule").click();
	              }else if(data.des=="failure"){
	                 alert("查询失败");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });
	}

	function modifyRoleDataRule(roleid,name) { //查询某个角色id 的数据权限状态
		$("#roleId1").val(roleid);
		$("#roleName").text(name);
		var roleId = roleid;
		var reqmsg="{'action':'QUERY_PRIVILEGE_LIST_REQUEST','page':{'pageno':'1','pagesize':'10000'},'content':{'roleId':"+roleId+",'funcitonType':'2'}}";
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "systemPrivilege.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg              
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	  changeRadioBox(data);
	            	  $("#realydatarule").click();
	            	  $("a[href='#data-rule1']").click();//切换第一个页签
	              }else if(data.des=="failure"){
	                 alert("查询失败");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });
	}

	function changeRadioBox(data){ //加载某个角色id 的数据权限状态
		//清空上一次打开模态框留下的数据权限状态
		$("#radio_7, #radio_2, #radio_20, #radio_22, #radio_32, #radio_34, #radio_26, #radio_45, #radio_47, #radio_39, #radio_41, #radio_49").iCheck('check'); 
		$("#radio_14, #radio_15, #radio_16").iCheck('check');//checkbox默认全选
		//加载新状态
		if (data.content != null) {
			jQuery.each(data.content.privilegeList, function(i, item) {	
				//多选13-正常、审核不通过、待评估;14-正常；15 -审核不通过；  16-待评估；	17-正常、审核不通过；  18-正常、待评估；  19- 审核不通过、待评估；
				if(item.functionId == 13){
					$("#radio_14, #radio_15, #radio_16").iCheck('check'); 
				}else if(item.functionId == 17){
					$("#radio_14, #radio_15").iCheck('check');
					$("#radio_16").iCheck('uncheck');
				}else if(item.functionId == 18){
					$("#radio_14, #radio_16").iCheck('check');
					$("#radio_15").iCheck('uncheck');
				}else if(item.functionId ==19){
					$("#radio_15, #radio_16").iCheck('check');
					$("#radio_14").iCheck('uncheck');
				}else if(item.functionId == 14){
					$("#radio_15, #radio_16").iCheck('uncheck');
					$("#radio_14").iCheck('check');				
				}else if(item.functionId == 16){
					$("#radio_14, #radio_15").iCheck('uncheck');
					$("#radio_16").iCheck('check');
				}else if(item.functionId == 15){
					$("#radio_14, #radio_16").iCheck('uncheck');
					$("#radio_15").iCheck('check');
				}else{
					$("#radio_"+item.functionId+"").iCheck('check'); //其他单选
				}		    	
			});
		}	
	}

	
	function go2page(pagenumber){ //查询角色信息
		var pagesize = $("#pageSizeSelector option:selected").val();
		var name2search = $("#rolename_input").val();		
		var timestart = $("#createdate_start").val();
		var timeend = $("#createdate_end").val();
		if(timestart !="" && timeend !="" && timestart > timeend){
			alert("开始时间不能大于结束时间");
			return;
		}		
		var reqmsg="{'action':'QUERY_ROLE_LIST_REQUEST',";
		
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
			jQuery.each(data.content.roleList, function(i, item) {
				htmlcode += "<tr class=\"gradeA odd\"><td>";
				if (item.id != 1 && item.name != "站长" && item.name != "组长") {
					htmlcode += "<input type=\"checkbox\" value=\"" + item.id + "\" class=\"col_selector\">";
				} else {
					htmlcode += "&nbsp;";
				}
				htmlcode += "</td>";
				htmlcode += "<td>" + item.name + "</td>";
				htmlcode += "<td>" + item.des + "</td>";
				htmlcode += "<td>" + formateTime(item.createTime) + "</td>";
				htmlcode += "<td>";
				if (item.id != 1) {
					htmlcode += "<div class=\"btn-group\">";
					htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
					htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
					htmlcode += "<span class=\"caret\"></span><span class=\"sr-only\">Toggle Dropdown</span></button>";
					htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";	
					<c:if test="${role_module_opt_control != 'yes' or role_module_opt_show == 'yes'}">			
						htmlcode += "<li><a onclick=\"modifyRoleModule('" + item.id + "')\">功能权限</a></li>";
					</c:if>	
					<c:if test="${role_data_opt_control != 'yes' or role_data_opt_show == 'yes'}">				
						htmlcode += "<li><a onclick=\"modifyRoleDataRule('" + item.id + "','" + item.name + "')\">数据权限</a></li>";
					</c:if>	
					if (item.id != 1 && item.name != "站长" && item.name != "组长") {
						<c:if test="${role_edit_opt_control != 'yes' or role_edit_opt_show == 'yes'}">
							htmlcode += "<li class=\"divider\"></li><li><a onclick=\"editRole('" + item.id + "');\">编辑角色</a></li>";
						</c:if>	
						<c:if test="${role_del_opt_control != 'yes' or role_del_opt_show == 'yes'}">	
							htmlcode += "<li><a onclick=\"delRole('" + item.id + "')\">删除角色</a></li>";
						</c:if>
					}
					htmlcode += "</ul></div>";
				} else {
					htmlcode += "&nbsp;";
				}
				htmlcode += "</td>"
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
			$("#des").val(data.content.des);
			$("#parentId").val(data.content.parentId);
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

	/**
	 * 保存角色信息
	 * @method saveInfo
	 */
	function saveInfo() {
		var id = $("#entityId").val();
		var name = $("#name").val();
		//校验
		if($.trim(name) == ""){
		    alert("必填项：角色名称为空");
		    return;
		}
		var des = $("#des").val();
		var parentId = $("#parentId").val();
		var createUserId = $("#createUserId").val();
		var createTime = $("#createTime").val();
		var updateUserId = $("#updateUserId").val();
		var updateTime = $("#updateTime").val();		
		var reqmsg="{'action':'ADD_ROLE_INFO_REQUEST','content':{";		
		if (id != null && id != "") {
			reqmsg += "\"id\":" + id + ",";
		}
		reqmsg += "\"name\":\"" + name + "\",";
		reqmsg += "\"des\":\"" + des + "\",";
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
	              }else if(data.des=="have"){
	                 alert("角色名已存在");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });
	}

	/**
	 * 保存关联信息
	 * @method saveRelationList
	 */
	function saveRelationList() {
		var roleId = $("tbody#datacontainer .col_selector:checked").val();
		if($("tbody#datacontainer .col_selector:checked").length == 0){
			roleId = $("#roleId").val();
		}
		
		var moduleIdObjs = $("tbody#datacontainer-module .col_selector:checked");
		var moduleIds="";
		if(moduleIdObjs.length>0){
		   var l = 0;
		   while(l<moduleIdObjs.length){
		     if(l==0){
		        moduleIds = $("tbody#datacontainer-module .col_selector:checked").eq(l).val();
		     }else{
		        moduleIds = moduleIds+","+$("tbody#datacontainer-module .col_selector:checked").eq(l).val();
		     }	     
		     l++;
		   }
		}
		jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "systemPrivilege.do?saveList",
	          dataType : "json",
	          data: {
	               "roleId":roleId,
	               "moduleIds":moduleIds,
	               "functionType":1,
	               "functionId":1
	          },
	          success : function(data){
	              if(data.result=="success"){
	              	$("#cancel_button-module").click();
	            	  //go2page(currentshownpage);
	              }else if(data.result=="failure"){
	                 alert("保存失败");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });
		
	}

/**
     加载模块树
**/
<%--function changeDataRuleList(data,roleId){--%>
<%--	var htmlcodetag = "";--%>
<%--	var htmlcodecontent = "";--%>
<%--	var temp="";--%>
<%--	if (data.content != null) {--%>
<%--		jQuery.each(data.content.dataRuleList, function(i, item) {	--%>
<%--		    if(temp!=item.entityName){--%>
<%--		       var active="";--%>
<%--		       if(temp==""){--%>
<%--		         active="active";--%>
<%--		       }else{--%>
<%--		         htmlcodecontent += "</div>";--%>
<%--		       }--%>
<%--		       htmlcodetag +="<li class=\""+active+"\"><a href=\"#"+item.entityName+"\" data-toggle=\"tab\">"+item.entityShow+"</a></li>";--%>
<%--		       htmlcodecontent += "<div class=\"tab-pane cont "+active+"\" id=\""+item.entityName+"\">";--%>
<%--		    }--%>
<%--		    --%>
<%--		    htmlcodecontent += "<div class=\"radio\"><label class=\"\"><div class=\"iradio_square-blue\" aria-checked=\"false\" aria-disabled=\"false\" style=\"position: relative;\"><input type=\"radio\"  id=\"radio_"+item.id+"\" name=\"radio_"+item.entityName+"\" value=\""+item.id+"\" class=\"icheck\" style=\"position: absolute; opacity: 0;\"><ins class=\"iCheck-helper\" style=\"position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);\"></ins></div>"+item.name+"</label></div>";--%>
<%----%>
<%--		    temp = item.entityName;--%>
<%--		});--%>
<%--	}--%>
<%--	$("#data-rule-edit-tag").html(htmlcodetag);--%>
<%--	$("#data-rule-edit-content").html(htmlcodecontent);--%>
<%--	--%>
<%--	//控件初始化--%>
<%--     $('.icheck').iCheck({--%>
<%--          checkboxClass: 'icheckbox_square-blue checkbox',--%>
<%--          radioClass: 'iradio_square-blue'--%>
<%--        });--%>
<%--     --%>
<%--     //默认第一个选中--%>
<%--     temp="";--%>
<%--     if (data.content != null) {--%>
<%--		jQuery.each(data.content.dataRuleList, function(i, item) {	--%>
<%--		    if(temp!=item.entityName){--%>
<%--		       $("#radio_"+item.id+"").iCheck('check'); 		     --%>
<%--		    }	    		  --%>
<%--		    temp = item.entityName;--%>
<%--		});--%>
<%--	 }--%>
<%--     --%>
<%--     --%>
<%--	--%>
<%--	var reqmsg="{'action':'QUERY_PRIVILEGE_LIST_REQUEST','page':{'pageno':'1','pagesize':'10000'},'content':{'roleId':"+roleId+",'funcitonType':'2'}}";--%>
<%--    jQuery.ajax({--%>
<%--          type : "post",--%>
<%--          async:true,--%>
<%--          url : "systemPrivilege.do?handler",--%>
<%--          dataType : "json",--%>
<%--          data: {--%>
<%--               "reqmsg":reqmsg              --%>
<%--          },--%>
<%--          success : function(data){--%>
<%--              if(data.des=="success"){--%>
<%--            	  changeRadioBox(data);--%>
<%--              }else if(data.des=="failure"){--%>
<%--                 alert("查询失败");--%>
<%--              }--%>
<%--          },--%>
<%--          error:function(){--%>
<%--	           alert("error");--%>
<%--          }--%>
<%--     });--%>
<%--}--%>



	/**
	 * 保存数据权限关联信息
	 * @method saveRelationList
	 */
	function saveRoleFunctionList() {
		roleId = $("#roleId1").val();		
		var functionIdObjs = $(".icheck:checked");	
		if(functionIdObjs.length == 11){ //表示checkbox的状态未选择
			alert("错误：会员状态请至少选择一项");
			return;
		}
		if(functionIdObjs.length < 0 || functionIdObjs.length > 14){ 
			alert("错误：请检查数据权限配置情况");
			return;
		}
		var functionIds = $(".icheck:checked").eq(0).val();
		//判断checkbox的选中状态 //多选13-正常、审核不通过、待评估;	 14-正常 15 -审核不通过  16-待评估	17-正常、审核不通过 	18-正常、待评估  19- 审核不通过、待评估
		if($("#radio_14").is(':checked') && $("#radio_15").is(':checked') && $("#radio_16").is(':checked')){
			functionIds+=","+13;
		}else if($("#radio_14").is(':checked') && $("#radio_15").is(':checked')){
			functionIds+=","+17;
		}else if($("#radio_14").is(':checked') && $("#radio_16").is(':checked')){
			functionIds+=","+18;
		}else if($("#radio_15").is(':checked') && $("#radio_16").is(':checked')){
			functionIds+=","+19;
		}else{ //只有一个选中
			 functionIds+=","+$(".icheck:checked").eq(1).val();	
		}
		//最后10个radio的选中状态
	    var last9 = functionIdObjs.length - 10;
	    while(last9 < functionIdObjs.length){	     
	        functionIds = functionIds+","+$(".icheck:checked").eq(last9).val();	
	        if($(".icheck:checked").eq(last9).val() <=25 && $(".icheck:checked").eq(last9).val() >=20){
	        	functionIds += ","+($(".icheck:checked").eq(last9).val()-(-19));	//健康评估任务管理和健康评估任务列表的选项一一对应；20~25对应39~44（一共12+2个数字）
	        }
	        last9++;
	    }	
		jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "systemPrivilege.do?saveRoleFunctionList",
	          dataType : "json",
	          data: {
	               "roleId":roleId,
	               "functionType":2,
	               "functionIds":functionIds
	          },
	          success : function(data){
	              if(data.result=="success"){
	              	$("#cancel_button-datarule").click();
	              	 alert(data.des);
	            	  //go2page(currentshownpage);
	              }else if(data.result=="failure"){
	                 alert("保存失败");
	              }
	          },
	          error:function(){
		           alert("error");
	          }
	     });
		
	}


	/**
	     加载模块树
	**/
	function changeModuleList(data,roleId){
		var htmlcode = "";
		if (data.content != null) {
			jQuery.each(data.content.moduleList, function(i, item) {		
				htmlcode += "<tr class=\"gradeA odd\" data-tt-id='"+item.id+"' data-tt-parent-id='"+item.parentId+"'>";
			    htmlcode += "<td><i class=\"fa "+ item.icon +"\"></i>" + item.name + "</td>";				
			    htmlcode += "<td>" + item.code + "</td>";	
			    htmlcode += "<td><input type=\"checkbox\" id=\"checkbox-module"+item.id+"\" value=\"" + item.id + "\" class=\"col_selector\" onclick=\"checkIndexBox("+item.id+","+item.parentId+");\"></td>"; 
				htmlcode += "</tr>";
				htmlcode += getChildTreeCode(item.childModuleList)
			});
		}
		$("#datacontainer-module").html(htmlcode);
		
		 $("#datatable-module").treetable({ expandable: true }, true);
	      // Highlight selected row
	      $("#datatable-module tbody").on("mousedown", "tr", function() {
	        $(".selected").not(this).removeClass("selected");
	        $(this).toggleClass("selected");
	      });
	
	      $("#datatable-module .folder").each(function() {
	        $(this).parents("#datatable-module tr").droppable({
	          accept: ".file, .folder",
	          drop: function(e, ui) {
	            var droppedEl = ui.draggable.parents("tr");
	            $("#datatable-module").treetable("move", droppedEl.data("ttId"), $(this).data("ttId"));
	          },
	          hoverClass: "accept",
	          over: function(e, ui) {
	            var droppedEl = ui.draggable.parents("tr");
	            if(this != droppedEl[0] && !$(this).is(".expanded")) {
	              $("#datatable-module").treetable("expandNode", $(this).data("ttId"));
	            }
	          }
	      });
	     });
	     jQuery("#datatable-module").treetable("expandAll");
		
		
		var reqmsg="{'action':'QUERY_PRIVILEGE_LIST_REQUEST','page':{'pageno':'1','pagesize':'10000'},'content':{'roleId':"+roleId+",'funcitonType':'1'}}";
		
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "systemPrivilege.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg              
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	  changeIndexBox(data);
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
				if(item.type==2){
			      htmlcode += "<td><i class=\"fa "+ item.icon +"\"></i>" + item.name + "</td>";		
			    }else if(item.type==3){
			     htmlcode += "<td><i class=\"fa fa-tablet\"></i>" + item.name + "</td>";		
			    }		    		
			    htmlcode += "<td>" + item.code + "</td>";			  
			    htmlcode += "<td><input type=\"checkbox\" id=\"checkbox-module"+item.id+"\" value=\"" + item.id + "\" class=\"col_selector\" onclick=\"checkIndexBox("+item.id+","+item.parentId+");\"></td>"; 	
				htmlcode += "</tr>";
				htmlcode += getChildTreeCode(item.childModuleList)
			});
		}
	    return htmlcode;
	}
	
	/**
	 * 选中子节点同时选中父节点；取消选中子节点时，判断父节点是否要取消选中（是否无子节点是选中状态）；选中/取消选中父节点的时候同时对子节点进行同样操作
	 */
	function checkIndexBox(nodeId,parentId){	
		selectAllParentsOfNode(nodeId);
		selectAllChildrenOfNode(nodeId);
	}

	/**
	 * 递归选中父节点，递归判断父节点是否要取消选中（无子节点选中时，取消选中）
	 */
	function selectAllParentsOfNode(nodeId) {
		//先确定父节点的nodeId
		var parentNodeId = $("#checkbox-module" + nodeId).parent().parent().attr("data-tt-parent-id");
		
		$("#datacontainer-module tr").each(function() {
			if ($(this).attr("data-tt-id") == parentNodeId) {  //是父节点
				if ($("#checkbox-module" + nodeId).is(':checked')) {  //选中了节点，递归选中父节点
					$("#checkbox-module" + parentNodeId).prop("checked", true);
					selectAllParentsOfNode(parentNodeId);  //其实也不用递归了，1级模块没有父模块了
				} else {  //取消选中了节点，判断父节点的子节点是否全部未选中，若是，则取消父节点的选中并递归
					if ($(this).attr("data-tt-parent-id") == 0) {  //现系统中，只有1级模块不允许在没有2级子模块选中的情况下被选中
						var hasChildSelected = false;
						$("#datacontainer-module tr").each(function() {
							if (parentNodeId == $(this).attr("data-tt-parent-id") && $("#checkbox-module" + $(this).attr("data-tt-id")).is(':checked')) {  //有子元素是选中的
								hasChildSelected = true;
							}
						});
						if (hasChildSelected == false) {
							$("#checkbox-module" + parentNodeId).prop("checked", false);
							//selectAllParentsOfNode(parentNodeId);  //不用递归了，1级模块没有父模块了
						}
					}
				}
			}
		});
	}

	/**
	 * 递归选中子节点--只对1级模块生效
	 */
	function selectAllChildrenOfNode(nodeId) {
		var parentNodeId = $("#checkbox-module" + nodeId).parent().parent().attr("data-tt-parent-id");
		//if (parentNodeId == 0) {  //如果是1级菜单
			$("#datacontainer-module tr").each(function() {
				if ($(this).attr("data-tt-parent-id") == nodeId) {
					$("#checkbox-module" + $(this).attr("data-tt-id")).prop("checked", $("#checkbox-module" + nodeId).is(':checked'));  //将二级子菜单的选中状态设为与操作的一级菜单一致			
				    //递归
				    selectAllChildrenOfNode($(this).attr("data-tt-id")) 
				}
			});
		//}
	}

	function changeIndexBox(data){	
		if (data.content != null) {
			jQuery.each(data.content.privilegeList, function(i, item) {			
		    	$("#checkbox-module"+item.moduleId).prop("checked", true);			
			});
		}	
	}
</script>
</body>
</html>