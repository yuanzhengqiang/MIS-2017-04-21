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

    <title>账号管理</title>
  
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
  <script type="text/javascript">
	//显示状态更新时间的js组件
	var timeTip = {
		$:function(ele){
			if(typeof(ele)=="object")
				return ele;
			else if(typeof(ele)=="string"||typeof(ele)=="number")
				return document.getElementById(ele.toString());
			return null;
		}, 
		mousePos:function(e){
			var x,y;
			var e = e||window.event;
			//alert(document.body.scrollLeft);
			//alert(document.body.scrollTop);
			return{x:e.clientX+document.body.scrollLeft-document.documentElement.scrollLeft,
				y:e.clientY+document.body.scrollTop-document.documentElement.scrollTop};
		},
		showtip:function(obj, dateString){
			var self = this;
			var t = self.$("timeTip");
			obj.onmousemove = function(e){
				var mouse = self.mousePos(e);
				t.style.left = mouse.x +10+ 'px';
				t.style.top = mouse.y +10+'px';
				t.innerHTML = "<div>本次登录时间：" + dateString +"</div>";
				t.style.display = 'block';
			};
			obj.onmouseout = function(){
				t.style.display = 'none';
			};
		}
	}
  </script>
</head>
<body style="opacity: 1; margin-left: 0px;">
	<div style="width: 100%; height: 100%;">
		<div class="container-fluid" style="padding: 0px">
		<!-- 头部开始 -->
			<div class="page-head">
				<h2>账号管理</h2>
				<ol class="breadcrumb">
					<li><a href="welcome.do?center">首页</a></li>
					<input type="hidden" value="" id="sortType">
					<input type="hidden" value="" id="sortColumn">
					<li class="active">账号管理</li>
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
										
										
										<div class="col-sm-1" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
                      						<label>账号名</label>
                    					</div>
                    					<div class="col-sm-11" style="margin-bottom:5px;">
                       						<input id="loginname_input" class="tags" type="hidden" value="" />
                    					</div>
										<div class="col-sm-1" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
                      						<label>账号类别</label>
                    					</div>
                    					<div class="col-sm-11" style="margin-bottom:5px;">
                      						<select id="login_type" class="select2" multiple>
                      							<option value="管理员">管理员</option>
                       							<option value="员工">员工</option>
                       							<option value="老人">老人</option>
                  	  						</select>
                    					</div>
										<div class="col-sm-1  hideAndShow" style=" vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px;">
                      						<label>账号状态</label>
                    					</div>
                    					<div class="col-sm-11  hideAndShow" style="margin-bottom:5px;">
                      						<select id="login_state" class="select2" multiple>
                       							<option value="0">正常</option>
                       							<option value="1">过期</option>
                       							<option value="2">锁定</option>
                  	  						</select>
                    					</div>
										<div class="col-sm-1  hideAndShow" style="vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px; ">
                      						<label>本次登录起止日期</label>
                    					</div>
										<div class="col-sm-5  hideAndShow">
                          					<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;"><span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                            					<input class="form-control" size="16" value="" readonly="readonly" type="text" id="thisLoginStartDate" placeholder="开始时间">
												<span class="input-group-btn"><button class="btn btn-danger deleteThisTime" type="button"><span class="fa fa-times"></span></button></span>
                          					</div>
                     					</div>
										<div class="col-sm-5  hideAndShow"> 
                          					<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;"><span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                            					<input class="form-control" size="16" value="" readonly="readonly" type="text" id="thisLoginEndDate" placeholder="结束时间">
                             					<span class="input-group-btn"><button class="btn btn-danger deleteThisTime" type="button"><span class="fa fa-times"></span></button></span>
                          					</div>
                     					</div>
                     					<div class="col-sm-1  hideAndShow" style="clear:both;vertical-align: middle; height: 34px; line-height: 34px;margin-bottom:5px; ">
                      						<label>上次登录起止日期</label>
                    					</div>
										<div class="col-sm-5  hideAndShow">
                          					<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;"><span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                            					<input class="form-control" size="16" value="" readonly="readonly" type="text" id="lastLoginStartDate" placeholder="开始时间">
                             					<span class="input-group-btn"><button class="btn btn-danger deleteThisTime" type="button"><span class="fa fa-times"></span></button></span>
                          					</div>
                     					</div>
										<div class="col-sm-5  hideAndShow">
                          					<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;"><span class="input-group-addon btn btn-primary"><span class="glyphicon glyphicon-th"></span></span>
                            					<input class="form-control" size="16" value="" readonly="readonly" type="text" id="lastLoginEndDate" placeholder="结束时间">
                             					<span class="input-group-btn"><button class="btn btn-danger deleteThisTime" type="button"><span class="fa fa-times"></span></button></span>
                          					</div>
                     					</div>
									</div>
									<!-- 查询框结束 -->
									<!-- 操作按钮开始 -->
									<div class="row">
										<div class="col-sm-12">	
											<c:if test="${user_query_btn_control != 'yes' or user_query_btn_show == 'yes'}">
                    						    <button class="btn btn-primary " style="margin-bottom: 0px !important; height: 34px;margin-left:0" onclick="query();">查询</button>
											</c:if>	
											<a style="cursor:pointer;text-decoration:underline;vertical-align:bottom;"  onclick="$('.hideAndShow').toggle();">更多查询条件</a>
<!--                                             <c:if test="${user_del_btn_control != 'yes' or user_del_btn_show == 'yes'}"> -->
<!-- 											<button id="user_del" type="button" class="btn btn-danger btn-flat" style="float: right; margin-right: 30px;" onclick="doDel()"> -->
<!-- 												<span><i class="fa fa-trash-o" style="margin-right:5px;"></i>删除</span> -->
<!-- 											</button> -->
<!-- 											</c:if> -->
											<button id="fake_reset_button" class="md-trigger" style="display: none;" data-modal="md-scale3"/> <!-- 假按钮 -->
<!-- 											<c:if test="${user_edit_control != 'yes' or user_edit_show == 'yes'}"> -->
<!-- 											<button id="user_edit" type="button" class="btn btn-primary btn-flat" style="float: right;" onclick="doEdit()"> -->
<!-- 												<span><i class="fa fa-pencil" style="margin-right:5px;"></i>编辑</span> -->
<!-- 											</button> -->
<!-- 											</c:if> -->
											<button type="button" style="display: none" class="md-trigger" id="realyedit" data-modal="md-scale"></button>	
											<%-- <c:if test="${user_add_btn_control != 'yes' or user_add_btn_show == 'yes'}">	
											<button id="user_add" type="button" class="btn btn-primary btn-flat md-trigger" data-modal="md-scale" style="float: right;" onclick="doAdd()">
												<span><i class="fa fa-plus" style="margin-right:5px;"></i>新增</span>
											</button>
											</c:if>  --%>
											<c:if test="${user_roleadd_btn_control != 'yes' or user_roleadd_btn_show == 'yes'}">
											<button id="user_role_add" type="button" class="btn btn-primary btn-flat" style="float: right;" onclick="doAddRoleList()">
												<span><i class="fa fa-user" style="margin-right:5px;"></i>分配角色</span>
												<button type="button" style="display: none" class="md-trigger" id="realyrole" data-modal="md-scale-role"></button>
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
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_loginname')"><strong>账号名</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'chinese_type')"><strong>账号类别</strong></th>
														<th><strong>角色</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'status')"><strong>账号状态</strong></th>
														<th><strong>本次登录</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'lastLoginTime')"><strong>上次登录</strong></th>													
														<th name="needSort" class="sorting" onclick="queryBySort(this,'loginNum')"><strong>本月登录次数</strong></th>
														<th name="needSort" class="sorting" onclick="queryBySort(this,'createTime')"><strong>注册时间</strong></th>
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
	<div class="md-modal md-effect-1" id="md-scale">
    	<div class="row">
			<div class="col-md-12">
				<div class="block-flat">
					<div class="header">
						<h3>系统账号信息</h3>
					</div>
			
					<div class="content">
						<form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
							<input type="hidden" name="entityId" id="entityId">
							<div class="form-group">
								<label class="col-sm-3 control-label color-danger">*账号名称</label>
								<div class="col-sm-6">
									<input id="loginname" type="text" class="form-control" disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label color-danger">*账号密码</label>
								<div class="col-sm-6">
									<input id="password" type="password" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">账号昵称</label>
								<div class="col-sm-6">
									<input id="nickname" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
                				<label class="col-sm-3 control-label">账号类别</label>
                				<div class="col-sm-6">
                					<input id="logintype" type="text" disabled="disabled" class="form-control">
                				</div>
			  				</div>
							<div class="form-group" style="margin-left:60px;">
                				<label class="col-sm-2 control-label">账号状态</label>
                				<div class="col-sm-4">
                      				<select id="loginstate" style="width:100px;height:30px;">
                       					<option value="0">正常</option>
                       					<option value="1">过期</option>
                       					<option value="2">锁定</option>
                  	  				</select>
                  	  			</div>
                    		</div>	
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">本月登录次数</label>
								<div class="col-sm-6">
									<input id="loginNum" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">本次登录时间</label>
								<div class="col-sm-6">
									<input id="loginTime" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">本次登录IP</label>
								<div class="col-sm-6">
									<input id="loginIp" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">上次登录时间</label>
								<div class="col-sm-6">
									<input id="lastLoginTime" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">上次登录IP</label>
								<div class="col-sm-6">
									<input id="lastLoginIp" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">部门ID</label>
								<div class="col-sm-6">
									<input id="departmentId" type="text" class="form-control">
								</div>
							</div>
							<div class="form-group" style="display:none">
								<label class="col-sm-3 control-label">个人信息ID</label>
								<div class="col-sm-6">
									<input id="personinfoId" type="text" class="form-control">
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
	
	<!-- 模态框 -->
	<div class="md-modal md-effect-1" id="md-scale3" >
      <div class="row">
        <div class="col-md-12">
         <div class="block-flat">
       		 <div class="header">
              <h4>密码重置确认</h4>
            </div>
            <div class="content">
			<p style="font-size:18px;margin:20px">是否将用户密码重设为“123456”？！</p>
              <div class="form-group" style="text-align: center;">
                <button type="button" class="btn btn-success btn-rad " onclick="doreset()">
                  <span><i class="fa fa-check" style="margin-right:5px;"></i>确定</span>
                </button>
                <button id="cancel2Reset" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;" >
                  <span><i class="fa fa-times" style="margin-right:5px;"></i>取消</span>
                </button>
              </div>
			</div>
          </div>
        </div>
      </div>
    </div>
	
	
	<!-- Nifty Modal Role -->
	<div class="md-modal md-effect-1" id="md-scale-role">
    	<div class="row">
			<div class="col-md-12">
				<div class="block-flat">
					<div class="header">
						<h3>角色信息</h3>
					</div>
			
					<div class="content">
						<table class="table table-bordered dataTable hover" id="datatable-role" aria-describedby="datatable_info">
												<thead>
													<tr role="row">
														<th style="width:2%;"><input id="allselectchecker-role" type="checkbox" class="col_selector" onclick="selectRoleAll();"></th>
														<th><strong>角色名称</strong></th>
									                    <th><strong>角色描述</strong></th>
														<th><strong>创建时间</strong></th>
													</tr>
												</thead>
												<tbody id="datacontainer-role" role="alert" aria-live="polite" aria-relevant="all">																														
												</tbody>
						</table>
					</div>
					<div class="form-group" style="text-align: center;">
								<input type="hidden" name="rollId" id="rollId">
								<button type="button" class="btn btn-primary btn-rad" onclick="saveRelationList();">
									<span><i class="fa fa-check" style="margin-right:5px;"></i>保存</span>
								</button>
								<button id="cancel_button-role" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
									<span><i class="fa fa-times" style="margin-right:5px;"></i>取消</span>
								</button>
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
              <h4>是否确认删除选中的账号</h4>
            </div>
            <div class="content">
			<p id="isSure2DeleteInfo" style="font-size:18px;margin:20px">删除该账号会删除该账号的基本信息,确认删除吗?</p>
			
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
var path="systemUser.do";
var lastpwd="";

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
		$("tbody#datacontainer .col_selector").prop("checked", true);
	} else {
		$("tbody#datacontainer .col_selector").prop("checked", false);
	}
}

function selectRoleAll() {
	if ($("#allselectchecker-role").is(':checked')) {
		$("tbody#datacontainer-role .col_selector").prop("checked", true);
	} else {
		$("tbody#datacontainer-role .col_selector").prop("checked", false);
	}
}


function doAdd() {
	$("#entityId").val("");
	$("#loginname").val("");
	$("#password").val("");
	$("#nickname").val("");
	
	$("#logintype").val("");
	$("#loginstate").val("");
	  
	$("#loginNum").val("");
	$("#loginTime").val("");
	$("#loginIp").val("");
	$("#lastLoginTime").val("");
	$("#lastLoginIp").val("");
	$("#departmentId").val("");
	$("#personinfoId").val("");
	$("#createUserId").val("");
	$("#createTime").val("");
	$("#updateUserId").val("");
	$("#updateTime").val("");
}

// function doEdit() {
// 	var selectedItemNumber = $("tbody#datacontainer .col_selector:checked").length;
// 	if (selectedItemNumber > 1) {
// 		alert("每次只能编辑一条数据");
// 	} else if (selectedItemNumber == 1) {
// 		var id2edit = $("tbody#datacontainer .col_selector:checked").val();
// 		var reqmsg="{'action':'QUERY_USER_INFO_REQUEST','content':{";
	
// 		if (id2edit != null && id2edit != "") {
// 			reqmsg += "\"id\":" + id2edit + ",";
// 		}
// 		reqmsg += "}}";
		
// 	    jQuery.ajax({
// 	          type : "post",
// 	          async:true,
// 	          url : path+"?handler",
// 	          dataType : "json",
// 	          data: {
// 	               "reqmsg":reqmsg
// 	          },
// 	          success : function(data){
// 	              if(data.des=="success"){
// 	            	  changeInfo(data);
// 	            	  $("#realyedit").click();
// 	              }else if(data.des=="failure"){
// 	                 alert("查询失败");
// 	              }
// 	          },
// 	          error:function(){
// 		           alert("error");
// 	          }
// 	     });
// 	} else {
// 		alert("请选择要编辑的数据");
// 	}
// }

// function doDel() {
// 	var selectedItemNumber = $("tbody#datacontainer .col_selector:checked").length;
// 	if (selectedItemNumber >= 1) {
// 		$("#isSure2Delete").addClass("md-show");
// 		document.getElementById("Sure2Delete").onclick = function(){   //使用.click会重复
// 		$("#isSure2Delete").removeClass("md-show");
// 		var ids2del = "";
// 		$("tbody#datacontainer .col_selector:checked").each(function() {
// 			ids2del += $(this).val() + ",";
// 		});
// 		if (ids2del != "") {
// 			ids2del = ids2del.substring(0, ids2del.length - 1);
// 		}
		
// 		jQuery.ajax({
// 			type:"post",
// 			url:path+"?del",
// 			async:true,
// 			dataType:"json",
// 			data:{ids:ids2del},
// 			success:function(data) {
// 				alert(data.des);
// 				if (data.result == "success") {
// 					go2page(currentshownpage);
// 				}else if(data.des=="failure"){
//                  alert("删除失败");
//                 }
// 			},
// 			error:function() {
// 				alert("error");
// 			}
// 		});
// 		}
// 		document.getElementById("cancel2Delete").onclick = function(){
// 			$("#isSure2Delete").removeClass("md-show");
// 	 	}
// 	} else {
// 		alert("请选择要删除的数据");
// 	}
// }

function doAddRoleList() {
	var selectedItemNumber = $("tbody#datacontainer .col_selector:checked").length;
	if (selectedItemNumber > 1) {
		alert("每次只能分配一条数据");
	} else if (selectedItemNumber == 1) {		
		var reqmsg="{'action':'QUERY_ROLE_LIST_REQUEST','page':{'pageno':'1','pagesize':'10000'},'content':{";

		reqmsg += "}}";
		
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "systemRole.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	  changeRoleList(data);
	            	  $("#realyrole").click();
	              }else if(data.des=="failure"){
	                 alert("查询失败");
	              }
	          },
	          error:function(){
		           alert("error1");
	          }
	     });
	} else {
		alert("请选择一条要分配角色的账号记录");
	}
}

function doAddRoleList2(id) {
	$("#allselectchecker").prop("checked", false);
	$("tbody#datacontainer .col_selector").prop("checked", false);
	
		var reqmsg="{'action':'QUERY_ROLE_LIST_REQUEST','page':{'pageno':'1','pagesize':'10000'},'content':{";
		$("#rollId").val(id);
		reqmsg += "}}";
		
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "systemRole.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg
	          },
	          success : function(data){
	              if(data.des=="success"){
	            	  changeRoleList2(data);
	            	  $("#realyrole").click();
	              }else if(data.des=="failure"){
	                 alert("查询失败");
	              }
	          },
	          error:function(){
		           alert("error2");
	          }
	     });
}

function changeRoleList2(data){
	var htmlcode = "";
	if (data.content != null) {
		jQuery.each(data.content.roleList, function(i, item) {
			htmlcode += "<tr class=\"gradeA odd\"><td><input type=\"checkbox\" id=\"checkbox-role"+item.id+"\" value=\"" + item.id + "\" class=\"col_selector\"></td>";
			htmlcode += "<td>" + item.name + "</td>";
			htmlcode += "<td>" + item.des + "</td>";
			htmlcode += "<td>" + formateTime(item.createTime) + "</td>";
			htmlcode += "</tr>";
		});
	}
	$("#datacontainer-role").html(htmlcode);
	
	//查询用户已经有的角色id
	var userId = $("#rollId").val();
	var reqmsg="{'action':'QUERY_USER_ROLE_LIST_REQUEST','page':{'pageno':'1','pagesize':'10000'},'content':{'userId':"+userId+"}}";
	
    jQuery.ajax({
          type : "post",
          async:true,
          url : "systemUserRole.do?handler",
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
	           alert("error3");
          }
     });
}

function edituser(id) {
		var reqmsg="{'action':'QUERY_USER_INFO_REQUEST','content':{";
	
		if (id != null && id != "") {
			reqmsg += "\"id\":" + id + ",";
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
		           alert("error4");
	          }
	     });
}

/**
 * 保存信息
 * @method saveInfo
 */
function saveInfo() {
	var id = $("#entityId").val();
	var loginname = $("#loginname").val();
	var password = $("#password").val();
	var nickname = $("#nickname").val();
	
	var logintype = $("#logintype").val();
	var status = $("#loginstate").val();
	
	var loginNum = $("#loginNum").val();
	var loginTime = $("#loginTime").val();
	var loginIp = $("#loginIp").val();
	var lastLoginTime = $("#lastLoginTime").val();
	var lastLoginIp = $("#lastLoginIp").val();
	var departmentId = $("#departmentId").val();
	var personinfoId = $("#personinfoId").val();
	var createUserId = $("#createUserId").val();
	var createTime = $("#createTime").val();
	var updateUserId = $("#updateUserId").val();
	var updateTime = $("#updateTime").val();
	
	//校验
	if($.trim(loginname) == ""){
	    alert("必填项：账号名称为空");
	    return;
	}
	if($.trim(password) == ""){
	    alert("必填项：账号密码为空");
	    return;
	}
	if(lastpwd!=password){
	    password = $.md5(password);
	}else{
	    lastpwd ="";
	    password = "";
	}
	
	
	var reqmsg="{'action':'ADD_USER_INFO_REQUEST','content':{";
	
	if (id != null && id != "") {
		reqmsg += "\"id\":" + id + ",";
	}
	reqmsg += "\"loginname\":\"" + loginname + "\",";
	    
	reqmsg += "\"nickname\":\"" + nickname + "\",";
	    
	if (password != null && password != "") {
        reqmsg += "\"password\":\"" + password + "\",";
	}
	
	if (logintype != null && logintype != "") {
        reqmsg += "\"type\":\"" + logintype + "\",";
	}
    if (status != null && status != "") {
        reqmsg += "\"status\":" + status + ",";
	}else{
        reqmsg += "\"status\":0,";
	}
	
    if (loginNum != null && loginNum != "") {
        reqmsg += "\"loginNum\":" + loginNum + ",";
	}else{
        reqmsg += "\"loginNum\":0,";
	}
    reqmsg += "\"loginTime\":\"" + loginTime + "\",";
	reqmsg += "\"loginIp\":\"" + loginIp + "\",";
	reqmsg += "\"lastLoginTime\":\"" + lastLoginTime + "\",";
	reqmsg += "\"lastLoginIp\":\"" + lastLoginIp + "\",";
    if (departmentId != null && departmentId != "") {
        reqmsg += "\"departmentId\":" + departmentId + ",";
	}else{
        reqmsg += "\"departmentId\":0,";
	}
    if (personinfoId != null && personinfoId != "") {
        reqmsg += "\"personinfoId\":" + personinfoId + ",";
	}else{
        reqmsg += "\"personinfoId\":0,";
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
                 alert("账号名已存在");
              }
          },
          error:function(){
	           alert("error5");
          }
     });
}

/**
 * 保存关联信息
 * @method saveRelationList
 */
function saveRelationList() {
	var userId =$("tbody#datacontainer .col_selector:checked").val();
	if($("tbody#datacontainer .col_selector:checked").length == 0){
		userId = $("#rollId").val();
	}
	var roleIdObjs = $("tbody#datacontainer-role .col_selector:checked");
	var roleIds="";
	if(roleIdObjs.length>0){
	   var l = 0;
	   while(l<roleIdObjs.length){
	     if(l==0){
	        roleIds = $("tbody#datacontainer-role .col_selector:checked").eq(l).val();
	     }else{
	        roleIds = roleIds+","+$("tbody#datacontainer-role .col_selector:checked").eq(l).val();
	     }	     
	     l++;
	   }
	}
	jQuery.ajax({
          type : "post",
          async:true,
          url : "systemUserRole.do?saveList",
          dataType : "json",
          data: {
               "userId":userId,
               "roleIds":roleIds
          },
          success : function(data){
              if(data.result=="success"){
              	$("#cancel_button-role").click();
            	    go2page(currentshownpage);
            	    alert("保存成功");
              }else if(data.result=="failure"){
                 alert("保存失败");
              }
          },
          error:function(){
	           alert("error6");
          }
     });
	
} 

function go2page(pagenumber){
	var pagesize = $("#pageSizeSelector option:selected").val();
	var name2search = "";
	var loginType = "";
	var status="";
	if ($("#loginname_input").val() != null) {
		name2search = $("#loginname_input").val() + "";
	}
	if ($("#login_type").val() != null) {
		loginType = $("#login_type").val() + "";
	}
	
	if ($("#login_state").val() != null) {
		status = $("#login_state").val() + "";
	}
	var thisLoginStartDate = $("#thisLoginStartDate").val();
	var thisLoginEndDate = $("#thisLoginEndDate").val();
	var lastLoginStartDate = $("#lastLoginStartDate").val();
	var lastLoginEndDate = $("#lastLoginEndDate").val();
	
	var reqmsg="{'action':'QUERY_USER_LIST_REQUEST',";
	
	var sortType = $("#sortType").val();
	var sortColumn = $("#sortColumn").val();
	if(sortType != null && sortType != ""){
		reqmsg += "'order':[{'column':'" + sortColumn + "','type':'" + sortType + "'}],";
	}
	
	reqmsg += "'page':{'pageno':'" + pagenumber + "','pagesize':'" + pagesize + "'},'content':{";
	
	if (name2search != null && name2search != "") {
		reqmsg += "\"loginname_in\":\"" + name2search + "\",";
	}
	if (loginType != null && loginType != "") {
		reqmsg += "\"type_in\":\"" + loginType + "\",";
	}
	if (status != null && status != "") {
		reqmsg += "\"status_in\":\"" + status + "\",";
	}
	if (thisLoginStartDate != null && thisLoginStartDate != "") {
	    thisLoginStartDate = thisLoginStartDate.substring(0, 4) + thisLoginStartDate.substring(5, 7) + thisLoginStartDate.substring(8, 10) + "000000";
		reqmsg += "\"loginTime_ge\":\"" + thisLoginStartDate + "\",";
	}
	if (thisLoginEndDate != null && thisLoginEndDate != "") {
		thisLoginEndDate = thisLoginEndDate.substring(0, 4) + thisLoginEndDate.substring(5, 7) + thisLoginEndDate.substring(8, 10) + "240000";
		reqmsg += "\"loginTime_le\":\"" + thisLoginEndDate + "\",";
	}
	if (lastLoginStartDate != null && lastLoginStartDate != "") {
	    lastLoginStartDate = lastLoginStartDate.substring(0, 4) + lastLoginStartDate.substring(5, 7) + lastLoginStartDate.substring(8, 10) + "000000";
		reqmsg += "\"lastLoginTime_ge\":\"" + thisLoginStartDate + "\",";
	}
	if (lastLoginEndDate != null && lastLoginEndDate != "") {
		lastLoginEndDate = lastLoginEndDate.substring(0, 4) + lastLoginEndDate.substring(5, 7) + lastLoginEndDate.substring(8, 10) + "240000";
		reqmsg += "\"lastLoginTime_le\":\"" + lastLoginEndDate + "\",";
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

/* function getRollName(id){
	var rolename="";
    jQuery.ajax({
          type : "post",
          async:false,
          url : path+"?rollname",
          dataType : "json",
          data: {
               "id":id              
          },
          success : function(data){
              rolename=data.rolename;
          },
          error:function(){
	          alert("error8");
          }
     });
     return rolename;
} */

var currentId2reset = "";
//重置密码
function resetuser(userid2reset) {
	currentId2reset = userid2reset;
	$("#fake_reset_button").click();
}

//确定重置
function doreset() {
	 	$.ajax({
	 		type:"post",
			url:"systemUser.do?reset",
			async:true,
			dataType:"json",
			data:{userid:currentId2reset},
			success:function(data) {
				if (data.result == "success") {
					$("#cancel2Reset").click();
				}
				alert(data.des);
			},
			error:function() {
				alert("重置密码时与服务器通讯错误");
			}
	 	});
}
	 
function changeData(data){
	var htmlcode = "";
	if (data.content != null) {
		jQuery.each(data.content.userList, function(i, item) {
			htmlcode += "<tr class=\"gradeA odd\">";
			if (item.id != 1) {	
			htmlcode += "<td><input type=\"checkbox\" value=\"" + item.id + "\" class=\"col_selector\"></td>";
			}else{
			htmlcode +="<td></td>";
			}
		    htmlcode += "<td>" + item.loginname + "</td>";				
		    htmlcode += "<td>" + item.type + "</td>";	
		    /* htmlcode += "<td>" + getRollName(item.id) + "</td>";	 */
		    htmlcode += "<td></td>";
		    htmlcode += "<td>" + changeStatus(item.status) + "</td>";	
		    
		    htmlcode += "<td onmouseover=\"timeTip.showtip(this, '" + formateTime(item.loginTime) + "')\">网站</td>";
		    
		    htmlcode += "<td>" + formateTime(item.lastLoginTime) + "</td>";	
		    htmlcode += "<td>" + item.loginNum + "</td>";	
		    htmlcode += "<td>" + formateTime(item.createTime) + "</td>";
		    if (item.id != 1) {			
			htmlcode += "<td><div class=\"btn-group\">";
			htmlcode += "<button class=\"btn btn-default btn-xs\" type=\"button\">操作</button>";
			htmlcode += "<button data-toggle=\"dropdown\" class=\"btn btn-xs btn-primary dropdown-toggle\" type=\"button\">";
			htmlcode += "<span class=\"caret\"></span>";
			htmlcode += "<span class=\"sr-only\">Toggle Dropdown</span>";
			htmlcode += "</button>";
			htmlcode += "<ul role=\"menu\" class=\"dropdown-menu pull-right\">";
			<c:if test="${user_roll_opt_control != 'yes' or user_roll_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"doAddRoleList2('" + item.id + "')\"><a href=\"###\">分配角色</a></li>";
			</c:if>	
			<c:if test="${user_edit_opt_control != 'yes' or user_edit_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"edituser('" + item.id + "')\"><a href=\"###\">编辑</a></li>";
			</c:if>	
			<c:if test="${user_resetmima_opt_control != 'yes' or user_resetmima_opt_show == 'yes'}">
			htmlcode += "<li onclick=\"resetuser('" + item.id + "')\"><a href=\"###\">重置密码</a></li>";
			</c:if>	
			//<c:if test="${user_del_opt_control != 'yes' or user_del_opt_show == 'yes'}">
			//htmlcode += "<li class=\"divider\"></li><li onclick=\"deluser('" + item.id + "')\"><a href=\"###\">删除</a></li>";
			//</c:if>	
			htmlcode += "</ul></div></td>";
			}else{
			htmlcode += "<td></td>";
			}
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
	$("#entityId").val("");
	$("#loginname").val("");
	$("#password").val("");
	$("#nickname").val("");
	
	$("#logintype").val("");
	$("#loginstate").val("");
	
	$("#loginNum").val("");
	$("#loginTime").val("");
	$("#loginIp").val("");
	$("#lastLoginTime").val("");
	$("#lastLoginIp").val("");
	$("#departmentId").val("");
	$("#personinfoId").val("");
	$("#createUserId").val("");
	$("#createTime").val("");
	$("#updateUserId").val("");
	$("#updateTime").val("");
    if (data.content != null) {
        $("#entityId").val(data.content.id);
		$("#loginname").val(data.content.loginname);
	
		$("#password").val(data.content.password);
			
		$("#nickname").val(data.content.nickname);

		$("#logintype").val(data.content.type);
		$("#loginstate").val(data.content.status);
		
		$("#loginNum").val(data.content.loginNum);
		$("#loginTime").val(data.content.loginTime);
		$("#loginIp").val(data.content.loginIp);
		$("#lastLoginTime").val(data.content.lastLoginTime);
		$("#lastLoginIp").val(data.content.lastLoginIp);
		$("#departmentId").val(data.content.departmentId);
		$("#personinfoId").val(data.content.personinfoId);
		$("#createUserId").val(data.content.createUserId);
		$("#createTime").val(data.content.createTime);
		$("#updateUserId").val(data.content.updateUserId);
		$("#updateTime").val(data.content.updateTime);
		
		if(data.content.password!=null){
		  lastpwd = data.content.password;
		}
    }
}

function changeRoleList(data){
	var htmlcode = "";
	if (data.content != null) {
		jQuery.each(data.content.roleList, function(i, item) {
			htmlcode += "<tr class=\"gradeA odd\"><td><input type=\"checkbox\" id=\"checkbox-role"+item.id+"\" value=\"" + item.id + "\" class=\"col_selector\"></td>";
			htmlcode += "<td>" + item.name + "</td>";
			htmlcode += "<td>" + item.des + "</td>";
			htmlcode += "<td>" + formateTime(item.createTime) + "</td>";
			htmlcode += "</tr>";
		});
	}
	$("#datacontainer-role").html(htmlcode);
	
	//查询用户已经有的角色id
	var userId = $("tbody#datacontainer .col_selector:checked").val();
	var reqmsg="{'action':'QUERY_USER_ROLE_LIST_REQUEST','page':{'pageno':'1','pagesize':'10000'},'content':{'userId':"+userId+"}}";
	
    jQuery.ajax({
          type : "post",
          async:true,
          url : "systemUserRole.do?handler",
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
	           alert("error9");
          }
     });
}

function changeIndexBox(data){	
	if (data.content != null) {
		jQuery.each(data.content.userRoleList, function(i, item) {			
	    	$("#checkbox-role"+item.roleId).prop("checked", true);			
		});
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
	var thisLoginStartDate = $("#thisLoginStartDate").val();
	var thisLoginEndDate = $("#thisLoginEndDate").val();
	var lastLoginStartDate = $("#lastLoginStartDate").val();
	var lastLoginEndDate = $("#lastLoginEndDate").val();
	if(thisLoginStartDate !="" && thisLoginEndDate !="" && thisLoginStartDate >= thisLoginEndDate){
		alert("开始时间必须小于结束时间");
		return;
	}
	if(lastLoginStartDate !="" && lastLoginEndDate !="" && lastLoginStartDate >= lastLoginEndDate){
		alert("开始时间必须小于结束时间");
		return;
	}
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