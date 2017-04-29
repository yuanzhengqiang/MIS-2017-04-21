<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="images/logo.png">
<title>体检订单新增</title>
<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="js/jquery.gritter/css/jquery.gritter.css" />
<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="js/jquery.nanoscroller/nanoscroller.css" />
<link rel="stylesheet" type="text/css" href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css" href="js/jquery.select2/select2.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap.slider/css/slider.css" />
<link rel="stylesheet" type="text/css" href="js/jquery.niftymodals/css/component.css" />
<link href="js/jquery.icheck/skins/square/blue.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="js/dropzone/css/dropzone.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap.summernote/dist/summernote.css" />
<link rel="stylesheet" href="js/jquery.crop/css/jquery.Jcrop.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="js/jquery.magnific-popup/dist/magnific-popup.css" />
<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<div class="navbar-fixed-top">
		<div id="head-nav" class="">
			<div class="block-flat" style="padding-bottom:0;margin-bottom: 0px;">
				<div class="row">
					<div class="col-xs-12 col-sm-4">
						<div>
							<h2 id="head_fuName">体检订单新增</h2>
							<ol class="breadcrumb" style="padding:0;background:#fff;">
								<li>订单信息</li>
								<li>体检订单管理</li>
								<li class="active">体检订单新增</li>
							</ol>
						</div>
					</div>
					<div class="col-xs-12 col-sm-8" style="text-align:right;padding-top:10px">
						<button class="btn btn-primary" onclick="">发送体检时间通知</button>
						<button class="btn btn-primary" onclick="">发送体检完成通知</button>
						<button class="btn btn-primary" onclick="">发送体检报告查看通知</button>
						<button class="btn btn-primary" onclick="">发送体检报告寄出通知</button>
						<button class="btn btn-primary" onclick="saveOrder()">保存</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="cl-wrapper1" style="overflow:hidden;padding-top: 100px;">
		<div class="cl-mcont" style="padding: 15px 0px;">
			<div class="block-flat">
				<div class="row" style="margin-top:0">
					<div class="col-sm-12">
						<form class="form-horizontal group-border-dashed">
							<div class="form-group">
								<div class="row">
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">订单编号</div>
									<div class="col-xs-8 col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;">无</label>
									</div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">总价格</div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="totalPrice">
									</div>
									<div style="clear:both;"></div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">服务费</div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="servicePrice">
									</div>
									<div style="clear:both;"></div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">是否已付款</div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<select class="form-control" id="isPay" style="margin-bottom:5px;height: 34px;line-height: 34px;">
											<option value="0">未付款</option>
											<option value="1">已付款</option>
										</select>
									</div>
									<div style="clear:both;"></div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">下单客户</div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="orderCustomer">
									</div>
									<div style="clear:both;"></div>
									<div class="col-sm-2 col-md-2 col-lg-1" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">下单时间</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<div class="input-group date datetime" data-min-view="1" data-date-format="yyyy-mm-dd hh:ii:ss" style="margin-bottom: 0px;">
											<span class="input-group-addon btn btn-primary">
												<span class="glyphicon glyphicon-th"></span>
											</span>
											<input class="form-control" size="16" value="" readonly="" type="text" id="orderTime" placeholder="下单时间">
											<span class="input-group-btn">
												<button class="btn btn-danger deleteThisTime" type="button">
													<span class="fa fa-times"></span>
												</button>
											</span>
										</div>
									</div>
									<div style="clear:both;"></div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">体检医院</div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<select class="form-control" id="medicalHospital" style="margin-bottom:5px;height: 34px;line-height: 34px;">
											
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">体检人姓名</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="medicalPersonName">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">体检人身份证号</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="medicalPersonCard">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">体检人性别</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<select class="form-control" id="medicalPersonGender" style="margin-bottom:5px;height: 34px;line-height: 34px;">
											<option value="1">男</option>
											<option value="0">女</option>
										</select>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">联系方式</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="contactWay">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">报告状态</div>
									<div class="col-sm-4 col-md-4 col-lg-2">
										<select class="form-control" id="medicalReportStatus" style="margin-bottom:5px;height: 34px;line-height: 34px;">
											<option value="0"></option>
											<option value="1">已生成</option>
											<option value="2">已寄出</option>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;">报告寄送地址</div>
									<div class="col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;">
										<textarea class="form-control" id="reportSendAddr"></textarea>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">报告寄送联系人</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="reportSendPerson">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">报告寄送联系方式</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="reportSendPersonContactWay">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">报告快递公司</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="medicalReportExpress">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">报告快递单号</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="medicalReportExpressOrderNum">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">预计体检时间</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<div class="input-group date datetime" data-min-view="1" data-date-format="yyyy-mm-dd hh:ii:ss" style="margin-bottom: 0px;">
											<span class="input-group-addon btn btn-primary">
												<span class="glyphicon glyphicon-th"></span>
											</span>
											<input class="form-control" size="16" value="" readonly="" type="text" id="expectMedicalTime" placeholder="预计体检时间">
											<span class="input-group-btn">
												<button class="btn btn-danger deleteThisTime" type="button">
													<span class="fa fa-times"></span>
												</button>
											</span>
										</div>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">体检完成时间</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<div class="input-group date datetime" data-min-view="1" data-date-format="yyyy-mm-dd hh:ii:ss" style="margin-bottom: 0px;">
											<span class="input-group-addon btn btn-primary">
												<span class="glyphicon glyphicon-th"></span>
											</span>
											<input class="form-control" size="16" value="" readonly="" type="text" id="medicalCompleteTime" placeholder="预计体检时间">
											<span class="input-group-btn">
												<button class="btn btn-danger deleteThisTime" type="button">
													<span class="fa fa-times"></span>
												</button>
											</span>
										</div>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">预计报告完成时间</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<div class="input-group date datetime" data-min-view="1" data-date-format="yyyy-mm-dd hh:ii:ss" style="margin-bottom: 0px;">
											<span class="input-group-addon btn btn-primary">
												<span class="glyphicon glyphicon-th"></span>
											</span>
											<input class="form-control" size="16" value="" readonly="" type="text" id="expectReportCompleteTime" placeholder="预计报告完成时间">
											<span class="input-group-btn">
												<button class="btn btn-danger deleteThisTime" type="button">
													<span class="fa fa-times"></span>
												</button>
											</span>
										</div>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;">状态</div>
									<div class="col-sm-4 col-md-4 col-lg-2">
										<select class="form-control" id="status" style="margin-bottom:5px;height: 34px;line-height: 34px;">
											<option value="0"></option>
											<option value="1">下单成功</option>
											<option value="2">体检完成</option>
											<option value="3">生成报告</option>
											<option value="4">取消</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="form-group">
									<div class="row">
										<div class="col-sm-12 " style="margin-bottom:5px;height: 34px;line-height: 34px;">
											<strong style="font-size: 16px;">体检项目</strong>
										</div>
										<table class="table table-bordered dataTable hover" id="datatable" aria-describedby="datatable_info" style="margin:0px 15px">
											<thead>
												<tr role="row">
													<th >
														<strong>项目名称</strong>
													</th>
													<th>
														<strong>价格</strong>
													</th>
												</tr>
											</thead>
											<tbody id="datacontainerItem" role="alert" aria-live="polite" aria-relevant="all">
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12 " style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<strong style="font-size: 16px;">服务人员信息</strong>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">服务人员姓名</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="hidden" id="servicePersonId">
										<label style="height:34px;line-height: 34px;">
											<span onclick="$('#editDes').click()" id="servicePersonName" style="color:blue;cursor: pointer;">无</span>
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12 " style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<strong style="font-size: 16px;">体检报告内容</strong>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">体检报告编号</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;">
											<span onclick="alert('订单还未新增成功，无法新增体检报告');" style="color:blue;cursor: pointer;">无</span>
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12 " style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<strong style="font-size: 16px;">付费列表</strong>
									</div>
									<table class="table table-bordered dataTable hover" id="datatable" aria-describedby="datatable_info" style="margin:0px 15px">
										<thead>
											<tr role="row">
												<th>
													<strong>金额</strong>
												</th>
												<th>
													<strong>类型</strong>
												</th>
												<th>
													<strong>支付时间</strong>
												</th>
												<th>
													<strong>支付流水号</strong>
												</th>
											</tr>
										</thead>
										<tbody id="datacontainerPay" role="alert" aria-live="polite" aria-relevant="all">
										</tbody>
									</table>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 主页面结束 -->

	<button class="md-trigger" data-modal="editDetail" style="display:none;" id="editDes"></button>
	<div class="md-modal md-effect-1" id="editDetail">
		<div class="row">
			<div class="col-md-12" style="padding: 10px 0px;">
				<div class="block-flat" style="padding-right: 0px;">
					<div class="header">
						<h3>服务人员信息</h3>
					</div>
					<div class="content">
						<form class="form-horizontal group-border-dashed" action="#" style="border-radius: 0px;">
							<div class="form-group">
								<label class="col-sm-3 control-label">服务人员</label>
								<div class="col-sm-6">
									<select id="servicePersonalName" style="width:100%;height:30px;">
										
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="footer">
						<div class="form-group" style="text-align: center;margin:0px">
							<button type="button" class="btn btn-primary btn-rad" onclick="chooseServicePersonalName()">
								<span>
									<i class="fa fa-check" style="margin-right:5px;"></i>选择
								</span>
							</button>
							<button id="cancel_button" type="button" class="btn btn-primary btn-rad md-close" style="margin-left: 50px;">
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

	<div class="md-overlay"></div>

	<script type="text/javascript" src="js/mordo.tools/mordo.timeProcessing.js"></script>
	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="js/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
	<script src="js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/jquery.select2/select2.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="js/jquery.niftymodals/js/jquery.modalEffects.js"></script>
	<script type="text/javascript" src="js/masonry.js"></script>
	<script type="text/javascript" src="js/jquery.crop/js/jquery.Jcrop.js"></script>
	<script src="js/ckeditor/ckeditor.js"></script>
	<script src="js/ckeditor/adapters/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.summernote/dist/summernote.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.wysihtml5/lib/js/wysihtml5-0.3.0.js"></script>
	<script type="text/javascript" src="js/bootstrap.wysihtml5/src/bootstrap-wysihtml5.js"></script>
	<script src="js/jquery.upload/js/jquery.iframe-transport.js"></script>
	<script src="js/jquery.upload/js/jquery.fileupload.js"></script>
	<script type="text/javascript" src="js/behaviour/general.js"></script>
	<script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
	<script type="text/javascript" src="js/dropzone/dropzone.js"></script>
	<script type="text/javascript" src="js/jquery.magnific-popup/dist/jquery.magnific-popup.min.js"></script>

	<script type="text/javascript">
	$(document).ready(function(){
    	$(".deleteThisTime").click(function(){               //清除日期框中的值
   	       $(this).parent().prev()[0].value = "";
   	    });
        App.init();
        
        getHospital();//获取医院
        queryServicePerson();//获取服务人员列表
    });
    
    //获取医院
    function getHospital() {
    	var html = "";
     	var reqmsg = "{'action':'QUERY_HOSPITAL_LIST_REQUEST','page':{'pageno':'1','pagesize':'1000000'},'content':{}}";
	
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
	              		if (data.content.hospitalList != null) {
							jQuery.each(data.content.hospitalList,function(i, item) {
	              				html += "<option value='" + item.hospitalName + "'>" + item.hospitalName + "</option>";
							});
	 					}
	 				}
				} else {
                	alert("查询医院失败");
              	}
          	},
          	error:function(){
	           alert("查询医院失败");
          	}
		});
		$("#medicalHospital").html(html);
    }
    
    //获取服务人员
    function queryServicePerson(){
    	var reqmsg = "{'action':'QUERY_SERVICE_PERSON_LIST_REQUEST','page':{'pageno':'1','pagesize':'1000000'},'content':{}}";
		var html = "";
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
	            	if (data.content.servicePersonList != null) {
						jQuery.each(data.content.servicePersonList,function(i, item) {
              				html += "<option value='" + item.id + "'>" + item.name + "</option>";
						});
 					}
	            } else {
	            	alert("查询服务人员信息失败");
	            }
			},
	        error:function() {
		    	alert("查询服务人员信息失败");
	        }
		});
		$("#servicePersonalName").html(html);
    }
    //确认选择服务人员
    function chooseServicePersonalName(){
    	var servicePersonalId = $("#servicePersonalName").val();
    	var servicePersonalName = $("#servicePersonalName").find("option:selected").text();
    	$("#servicePersonId").val(servicePersonalId);
    	$("#servicePersonName").html(servicePersonalName);
    	$("#cancel_button").click();
    }
    
	//新增订单
    function saveOrder() {
    	var totalPrice = $.trim($("#totalPrice").val());
    	var servicePrice = $.trim($("#servicePrice").val());
    	var isPay = $("#isPay").val();
    	var orderCustomer = $.trim($("#orderCustomer").val());	
    	var orderTime = $("#orderTime").val();
    	if (orderTime != null && orderTime != "") {
			orderTime = formateTime6(orderTime);
		} else {
			orderTime = "";
		}
    	var medicalHospital = $("#medicalPersonName").val();
    	
    	var medicalPersonName = $.trim($("#medicalPersonName").val());
    	if (medicalPersonName == null || medicalPersonName == "") {
			alert("体检人姓名必填");
			return;
		}
		var medicalPersonCard = $.trim($("#medicalPersonCard").val());
		var reg1 = /(^\d{15}$)|(^\d{17}([0-9]|X)$)/; 
		if(!reg1.test(medicalPersonCard)){  
        	alert("身份证格式错误"); 
        	return; 
    	}
		var medicalPersonGender = $("#medicalPersonGender").val();
		if (medicalPersonGender == null || medicalPersonGender == "") {
			alert("性别必选");
			return;
		}
		var contactWay = $.trim($("#contactWay").val());
		var medicalReportStatus = $("#medicalReportStatus").val();
		
		var reportSendAddr = $.trim($("#reportSendAddr").val());
		if (reportSendAddr != null && reportSendAddr != "") {
			reportSendAddr = JSON.stringify(reportSendAddr);
			if (reportSendAddr.length > 200) {
				alert("报告寄送地址超出字数限制");
				return;
			}
		}
		var reportSendPerson = $.trim($("#reportSendPerson").val());
		var reportSendPersonContactWay = $.trim($("#reportSendPersonContactWay").val());
		var medicalReportExpress = $.trim($("#medicalReportExpress").val());
		var medicalReportExpressOrderNum = $.trim($("#medicalReportExpressOrderNum").val());
		var expectMedicalTime = $("#expectMedicalTime").val();
		if (expectMedicalTime != null && expectMedicalTime != "") {
			expectMedicalTime = formateTime6(expectMedicalTime);
		} else {
			expectMedicalTime = "";
		}
		var medicalCompleteTime = $("#medicalCompleteTime").val();
		if (medicalCompleteTime != null && medicalCompleteTime != "") {
			medicalCompleteTime = formateTime6(medicalCompleteTime);
		} else {
			medicalCompleteTime = "";
		}
		var expectReportCompleteTime = $("#expectReportCompleteTime").val();
		if (expectReportCompleteTime != null && expectReportCompleteTime != "") {
			expectReportCompleteTime = formateTime6(expectReportCompleteTime);
		} else {
			expectReportCompleteTime = "";
		}
		var status = $("#status").val();
		
		var servicePersonId = $("#servicePersonId").val();
		var servicePersonName = $("#servicePersonName").html();
		
		var reqmsg = "{'action':'ADD_ORDER_INFO_REQUEST','content':{";
   		reqmsg += "'totalPrice':" + totalPrice + ",";
   		reqmsg += "'servicePrice':" + servicePrice + ",";
   		reqmsg += "'isPay':" + isPay + ",";
   		reqmsg += "'orderCustomer':'" + orderCustomer + "',";
   		reqmsg += "'orderTime':'" + orderTime + "',";
   		reqmsg += "'medicalHospital':'" + medicalHospital + "',";
    	reqmsg += "'medicalPersonName':'" + medicalPersonName + "',";
		reqmsg += "'medicalPersonCard':'" + medicalPersonCard + "',";
		reqmsg += "'medicalPersonGender':" + medicalPersonGender + ",";
		reqmsg += "'contactWay':'" + contactWay + "',";
		reqmsg += "'medicalReportStatus':" + medicalReportStatus + ",";
		if (reportSendAddr != null && reportSendAddr != "") {
			reqmsg += "'reportSendAddr':" + reportSendAddr + ",";
		} else {
			reqmsg += "'reportSendAddr':'',";
		}
		reqmsg += "'reportSendPerson':'" + reportSendPerson + "',";
		reqmsg += "'reportSendPersonContactWay':'" + reportSendPersonContactWay + "',";
		reqmsg += "'medicalReportExpress':'" + medicalReportExpress + "',";
		reqmsg += "'medicalReportExpressOrderNum':'" + medicalReportExpressOrderNum + "',";
		reqmsg += "'expectMedicalTime':'" + expectMedicalTime + "',";
		reqmsg += "'medicalCompleteTime':'" + medicalCompleteTime + "',";
		reqmsg += "'expectReportCompleteTime':'" + expectReportCompleteTime + "',";
		reqmsg += "'status':" + status + ",";
		if (servicePersonId != null && servicePersonId != "") {
			reqmsg += "'servicePersonId':" + servicePersonId + ",";
			reqmsg += "'servicePersonName':'" + servicePersonName + "',";
		}
		
		reqmsg += "}}";
	console.log(reqmsg);
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
        		   	alert("保存订单成功");
        		   	var id = data.content.id;
        		   	var path = "<%=request.getContextPath()%>";
       		   		var url = path + "/order.do?mainDetail&id=" + id;
      		   		window.location.replace(url);
        		} else {
        		  	alert("保存订单失败");
        		}
      		},
      		error:function(){
   		    	alert("保存订单失败");
     		}
		});
    }
	</script>

	<script src="js/behaviour/voice-commands.js"></script>
	<script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.resize.js"></script>
	<script type="text/javascript" src="js/jquery.flot/jquery.flot.labels.js"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
</body>
</html>
