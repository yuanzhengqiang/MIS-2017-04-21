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
<title>体检订单详情</title>
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
							<h2 id="head_fuName">体检订单详情</h2>
							<ol class="breadcrumb" style="padding:0;background:#fff;">
								<li>订单信息</li>
								<li>体检订单管理</li>
								<li class="active">体检订单详情</li>
							</ol>
						</div>
					</div>
					<div class="col-xs-12 col-sm-8" style="text-align:right;padding-top:10px">
						<button class="btn btn-primary" onclick="examinationTimeNotice()">发送体检时间通知</button>
						<button class="btn btn-primary" onclick="physicalExaminationNotice()">发送体检完成通知</button>
						<button class="btn btn-primary" onclick="physicalExaminationReport()">发送体检报告查看通知</button>
						<button class="btn btn-primary" onclick="medicalReportSentNotice()">发送体检报告寄出通知</button>
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
										<label style="height:34px;line-height: 34px;" id="orderNum"></label>
									</div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">总价格</div>
									<div class="col-xs-8 col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;" id="totalPrice">元</label>
									</div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">服务费</div>
									<div class="col-xs-8 col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;" id="servicePrice">元</label>
									</div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">是否已付款</div>
									<div class="col-xs-8 col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;" id="isPay"></label>
									</div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">下单客户</div>
									<div class="col-xs-8 col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;" id="orderCustomer"></label>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">下单时间</div>
									<div class="col-xs-8 col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;" id="orderTime"></label>
									</div>
									<div style="clear:both;"></div>
									<div class="col-xs-4 col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">体检医院</div>
									<div class="col-xs-8 col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;" id="medicalHospital"></label>
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
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">体检时间</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;">
											<span class="input-group-addon btn btn-primary">
												<span class="glyphicon glyphicon-th"></span>
											</span>
											<input class="form-control" size="16" value="" readonly="" type="text" id="medicalCompleteTime" placeholder="体检时间">
											<span class="input-group-btn">
												<button class="btn btn-danger deleteThisTime" type="button">
													<span class="fa fa-times"></span>
												</button>
											</span>
										</div>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;height: 34px;line-height: 34px;">报告时间</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd" style="margin-bottom: 0px;">
											<span class="input-group-addon btn btn-primary">
												<span class="glyphicon glyphicon-th"></span>
											</span>
											<input class="form-control" size="16" value="" readonly="" type="text" id="reportCreateTime" placeholder="报告时间">
											<span class="input-group-btn">
												<button class="btn btn-danger deleteThisTime" type="button">
													<span class="fa fa-times"></span>
												</button>
											</span>
										</div>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-left" style="padding-left: 20px;padding-right: 0px;">订单状态</div>
									<div class="col-sm-4 col-md-4 col-lg-2">
										<select class="form-control" id="status" style="margin-bottom:5px;height: 34px;line-height: 34px;">
											<option value="0"></option>
											<option value="1">下单成功</option>
											<option value="2">体检完成</option>
											<option value="3">生成报告</option>
											<option value="4">取消</option>
										</select>
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
											<a id="medicalReportNum" href="" target="_blank" style="margin-bottom: 0px !important; height: 34px;margin-left:0;float:right;">无</a>
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
       
        queryServicePerson();//获取服务人员列表
        
        var id = "<%=request.getAttribute("id")%>";
        if (id != null && id != "") {//编辑页
        	queryOrder(id);//获取订单信息
        	queryMedicalItem(id);//获取体检项目
        	queryPayInfo(id);//获取付费列表
        }
    });
    
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
	        		if (data.content != null) {
		            	if (data.content.servicePersonList != null) {
							jQuery.each(data.content.servicePersonList,function(i, item) {
	              				html += "<option value='" + item.id + "'>" + item.name + "</option>";
							});
	 					}
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
    
    //查询订单
    function queryOrder(id) {
    	var reqmsg = "{'action':'QUERY_ORDER_INFO_REQUEST','content':{'medicalReportShow':'true','id':" + id + "}}";
		jQuery.ajax({
			type : "post",
          	async:true,
          	url : "order.do?handler",
          	dataType : "json",
          	data: {
            	"reqmsg":reqmsg
          	},
          	success : function(data){
            	if (data.des == "success") {
              		if (data.content != null) {
              			$("#orderNum").html(data.content.orderNum);
              			$("#totalPrice").html(data.content.totalPrice + "元");
              			$("#servicePrice").html(data.content.servicePrice + "元");
              			$("#isPay").html(matchingIsPay(data.content.isPay));
              			$("#orderCustomer").html(data.content.orderCustomer);
              			$("#orderTime").html(formateTime2(data.content.orderTime));
              			$("#medicalHospital").html(data.content.medicalHospital);
              			$("#medicalPersonName").val(data.content.medicalPersonName);
              			$("#medicalPersonCard").val(data.content.medicalPersonCard);
              			if (data.content.medicalPersonGender == true) {
              				$("#medicalPersonGender").val(1);
              			}
              			if (data.content.medicalPersonGender == false) {
              				$("#medicalPersonGender").val(0);
              			}
              			$("#contactWay").val(data.content.contactWay);
              			$("#medicalReportStatus").val(data.content.medicalReportStatus);
              			$("#reportSendAddr").val(data.content.reportSendAddr);
              			$("#reportSendPerson").val(data.content.reportSendPerson);
              			$("#reportSendPersonContactWay").val(data.content.reportSendPersonContactWay);
              			$("#medicalReportExpress").val(data.content.medicalReportExpress);
              			$("#medicalReportExpressOrderNum").val(data.content.medicalReportExpressOrderNum);             			
              			$("#medicalCompleteTime").val(formateTime2(data.content.medicalCompleteTime));
              			$("#reportCreateTime").val(formateTime2(data.content.reportCreateTime));
              			$("#status").val(data.content.status);
              			if (data.content.servicePersonId != null && data.content.servicePersonId != "") {
              				$("#servicePersonId").val(data.content.servicePersonId);
              				$("#servicePersonName").html(data.content.servicePersonName);
              			}
              			if (data.content.medicalReport != null) {//有体检报告
              				$("#medicalReportNum").html(data.content.medicalReport.medicalReportNum);
              				$("#medicalReportNum").attr("href","<%=request.getContextPath()%>/medicalReport.do?medicalReportDetail&itemId=" + data.content.id + "&id=" + data.content.medicalReportId);
              			} else {
              				$("#medicalReportNum").attr("href","<%=request.getContextPath()%>/medicalReport.do?medicalReportDetail&itemId=" + data.content.id);
              			}
					}
				} else {
                	alert("查询订单失败");
                }
          	},
          	error:function(){
	        	alert("查询订单失败");
          	}
		});
    }
    //匹配是否已付款状态
	function matchingIsPay(isPay) {
		var name = "";
		switch (isPay) 
		{
			case 1:
			name = "已付款";
  			break;
  			
  			case 0:
			name = "未付款";
  			break;
  			
			default:
  			break;
		}
		return name;
	}

	//查询体检项目
	function queryMedicalItem(id) {
		var reqmsg = "{'action':'QUERY_ORDER_MEDICAL_ITEM_RELATION_LIST_REQUEST','page':{'pageno':'1','pagesize':'1000000'},'content':{'orderId':" + id + "}}";
		var html = "";
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "orderMedicalItemRelation.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg              
	          },
	          success : function(data) {
	              if (data.des == "success") {
	            	  if (data.content != null) {
						 if (data.content.orderMedicalItemRelationList != null) {
							jQuery.each(data.content.orderMedicalItemRelationList,function(i, item) {
	              				html += "<tr>";
	              				html += "<td>" + item.medicalItemName + "</td>";
	              				html += "<td>" + item.medicalItemPrice + "</td>";
	              				html += "</tr>";
	              			});
	              			$("#datacontainerItem").html(html);
	              		  }
	              	  }
	              } else {
	                 alert("查询体检项目失败");
	              }
	          },
	          error:function() {
		          alert("查询体检项目失败");
	          }
	     });
	}
	
	//查询付费列表
	function queryPayInfo(id) {
		var reqmsg = "{'action':'QUERY_PAY_INFO_LIST_REQUEST','order':[{'column':'payTime','type':'desc'}],'page':{'pageno':'1','pagesize':'1000000'},'content':{'orderId':" + id + "}}";
		var html = "";
	    jQuery.ajax({
	          type : "post",
	          async:true,
	          url : "payInfo.do?handler",
	          dataType : "json",
	          data: {
	               "reqmsg":reqmsg              
	          },
	          success : function(data) {
	              if (data.des == "success") {
	            	  if (data.content != null) {
						 if (data.content.payInfoList != null) {
							jQuery.each(data.content.payInfoList,function(i, item) {
	              				html += "<tr>";
	              				html += "<td>" + item.money + "</td>";
	              				if (item.type != null && item.type != "") {
	              					if (item.type == true) {
			              				html += "<td>押金</td>";
			              			}
			              			if (item.type == false) {
			              				html += "<td>尾款</td>";
			              			}
	              				} else {
	              					html += "<td></td>";
	              				}
	              				html += "<td>" + formateTime(item.payTime) + "</td>";
	              				html += "<td>" + item.payNum + "</td>";
	              				html += "</tr>";
	              			});
	              			$("#datacontainerPay").html(html);
	              		  }
	              	  }
	              } else {
	                 alert("查询付费列表失败");
	              }
	          },
	          error:function() {
		          alert("查询付费列表失败");
	          }
	     });
	}
	
	//保存编辑订单
    function saveOrder() {
    	var id = "<%=request.getAttribute("id")%>";
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

		var medicalCompleteTime = $("#medicalCompleteTime").val();
		if (medicalCompleteTime != null && medicalCompleteTime != "") {
			medicalCompleteTime = formateTime7(medicalCompleteTime) + "000000";
		} else {
			medicalCompleteTime = "";
		}
		
		var reportCreateTime = $("#reportCreateTime").val();
		if (reportCreateTime != null && reportCreateTime != "") {
			reportCreateTime = formateTime7(reportCreateTime) + "000000";
		} else {
			reportCreateTime = "";
		}
		var status = $("#status").val();
		
		var servicePersonId = $("#servicePersonId").val();
		var servicePersonName = $("#servicePersonName").html();
		
		var reqmsg = "{'action':'ADD_ORDER_INFO_REQUEST','content':{";
   		reqmsg += "'id':" + id + ",";
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
		reqmsg += "'medicalCompleteTime':'" + medicalCompleteTime + "',";
		reqmsg += "'reportCreateTime':'" + reportCreateTime + "',";
		reqmsg += "'status':" + status + ",";
		if (servicePersonId != null && servicePersonId != "") {
			reqmsg += "'servicePersonId':" + servicePersonId + ",";
			reqmsg += "'servicePersonName':'" + servicePersonName + "',";
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
        		   	alert("保存订单成功");
        		} else {
        		  	alert("保存订单失败");
        		}
      		},
      		error:function(){
   		    	alert("保存订单失败");
     		}
		});
    }
    
    //发送体检时间通知
    function examinationTimeNotice() {
    	var id = "<%=request.getAttribute("id")%>";
    	jQuery.ajax({
       		type : "post",
       		async:true,
       		url : "order.do?timenotice",
       		dataType : "json",
       		data: {
       		     "orderId":id
       		},
      		success : function(data) {
      			alert(data.des);
      		},
      		error:function(){
   		    	alert(data.des);
     		}
		});
    }
    
    //发送体检完成通知
    function physicalExaminationNotice() {
    	var id = "<%=request.getAttribute("id")%>";
    	jQuery.ajax({
       		type : "post",
       		async:true,
       		url : "order.do?physicalexaminationnotice",
       		dataType : "json",
       		data: {
       		     "orderId":id
       		},
      		success : function(data) {
      			alert(data.des);
      		},
      		error:function(){
   		    	alert(data.des);
     		}
		});
    }
    
    //发送体检报告查看通知
    function physicalExaminationReport() {
    	var id = "<%=request.getAttribute("id")%>";
    	jQuery.ajax({
       		type : "post",
       		async:true,
       		url : "order.do?physicalexaminationreport",
       		dataType : "json",
       		data: {
       		     "orderId":id
       		},
      		success : function(data) {
      			alert(data.des);
      		},
      		error:function(){
   		    	alert(data.des);
     		}
		});
    }
    
    //发送体检报告寄出通知
    function medicalReportSentNotice() {
    	var id = "<%=request.getAttribute("id")%>";
    	jQuery.ajax({
       		type : "post",
       		async:true,
       		url : "order.do?medicalreportsentnotice",
       		dataType : "json",
       		data: {
       		     "orderId":id
       		},
      		success : function(data) {
      			alert(data.des);
      		},
      		error:function(){
   		    	alert(data.des);
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
