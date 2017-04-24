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

	<!-- Bootstrap core CSS -->
	<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="js/jquery.gritter/css/jquery.gritter.css" />

	<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="../../assets/js/html5shiv.js"></script>
	  <script src="../../assets/js/respond.min.js"></script>
	<![endif]-->
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
<script type="text/javascript" src="js/addressJS.js"></script>
</head>
<body>	
<div class="navbar-fixed-top">
	<div id="head-nav" class=""> 
        <div class="block-flat" style="padding-bottom:0;margin-bottom: 0px;">
          <div class="row">
            <div class="col-xs-12 col-sm-4">
              <div >
                <h2 id="head_fuName">体检订单详情</h2>
              	<ol class="breadcrumb" style="padding:0;background:#fff;">
					<li>订单信息</li>
					<li >体检订单管理</li>
					<li class="active">体检订单详情</li>
				</ol>
               </div>
            </div>
            <div class="col-xs-12 col-sm-8" style="text-align:right;padding-top:10px">
	            <button class="btn btn-primary" onclick="">发送体检时间通知</button>
	            <button class="btn btn-primary" onclick="">发送体检完成通知</button>
	            <button class="btn btn-primary" onclick="">发送体检报告查看通知</button>
	            <button class="btn btn-primary" onclick="">发送体检报告寄出通知</button>
				<button class="btn btn-primary" onclick="">保存</button>
				<input type="hidden" id="hide_xmId">
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
									<div class="col-sm-2 col-md-2 col-lg-1 text-center"
										style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">订单编号</div>
									<div class="col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;">123154645</label>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">总价格</div>
									<div class="col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;">123154645元</label>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">服务费</div>
									<div class="col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;">123154645元</label>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">是否已付款</div>
									<div class="col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;">是</label>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">下单客户</div>
									<div class="col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;">张三</label>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">医院</div>
									<div class="col-sm-10 col-md-10 col-lg-11" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;">甲医院</label>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">体检人姓名</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="xmname_input">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">体检人身份证号</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="xmname_input">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">体检人性别</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<select class="form-control" id="xm_leibie_input"
											style="margin-bottom:5px;height: 34px;line-height: 34px;">
											<option value=""></option>
											<option value="1">男</option>
											<option value="0">女</option>
										</select>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">联系方式</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="xmname_input">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">报告状态</div>
									<div class="col-sm-4 col-md-4 col-lg-2">
										<select class="form-control" id="xm_leibie_input"
											style="margin-bottom:5px;height: 34px;line-height: 34px;">
											<option value=""></option>
											<option value="1">已生成</option>
											<option value="2">已寄出</option>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2 col-md-4 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;">报告寄送地址</div>
									<div class="col-sm-10 col-md-8 col-lg-11" style="margin-bottom:5px;">
										<textarea class="form-control" id="selectDes"></textarea>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">报告寄送联系人</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="xmname_input">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">报告寄送联系方式</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="xmname_input">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">报告快递商</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="xmname_input">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">报告快递单号</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<input type="text" class="form-control" id="xmname_input">
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">预计体检时间</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<div class="input-group date datetime" data-min-view="1" data-date-format="yyyy-mm-dd hh:ii:ss" style="margin-bottom: 0px;">
											<span class="input-group-addon btn btn-primary">
												<span class="glyphicon glyphicon-th"></span>
											</span> 
											<input class="form-control" size="16" value="" readonly="" type="text" id="startTime" placeholder="预计体检时间"> 
											<span class="input-group-btn">
												<button class="btn btn-danger deleteThisTime" type="button">
													<span class="fa fa-times"></span>
												</button>
											</span>
										</div>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">体检完成时间</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<div class="input-group date datetime" data-min-view="1" data-date-format="yyyy-mm-dd hh:ii:ss" style="margin-bottom: 0px;">
											<span class="input-group-addon btn btn-primary">
												<span class="glyphicon glyphicon-th"></span>
											</span> 
											<input class="form-control" size="16" value="" readonly="" type="text" id="startTime" placeholder="预计体检时间"> 
											<span class="input-group-btn">
												<button class="btn btn-danger deleteThisTime" type="button">
													<span class="fa fa-times"></span>
												</button>
											</span>
										</div>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 15px;padding-right: 0px;height: 34px;line-height: 34px;">预计报告完成时间</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<div class="input-group date datetime" data-min-view="1" data-date-format="yyyy-mm-dd hh:ii:ss" style="margin-bottom: 0px;">
											<span class="input-group-addon btn btn-primary">
												<span class="glyphicon glyphicon-th"></span>
											</span> 
											<input class="form-control" size="16" value="" readonly="" type="text" id="startTime" placeholder="预计体检时间"> 
											<span class="input-group-btn">
												<button class="btn btn-danger deleteThisTime" type="button">
													<span class="fa fa-times"></span>
												</button>
											</span>
										</div>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;">状态</div>
									<div class="col-sm-4 col-md-4 col-lg-2">
										<select class="form-control" id="xm_leibie_input" style="margin-bottom:5px;height: 34px;line-height: 34px;">
											<option value=""></option>
											<option value="1">下单成功</option>
											<option value="2">体检完成</option>
											<option value="2">体检完成</option>
											<option value="2">生成报告</option>
											<option value="2">取消</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group" id="xmjianjie_input">
								<div class="row">
									<div class="col-sm-12 " style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<strong style="font-size: 16px;">体检项目</strong>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">项目名称</div>
									<div class="col-sm-4 col-md-4 col-lg-2"
										style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;">甲项目</label>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">价格</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;">100元</label>
									</div>
								</div>
							</div>
							<div class="form-group" id="xmjianjie_input">
								<div class="row">
									<div class="col-sm-12 " style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<strong style="font-size: 16px;">服务人员信息</strong>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">服务人员姓名</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;" id=""><span class="btn btn-primary btn-flat" onclick="$('#editDes').click()">无</span></label>
									</div>
								</div>
							</div>
							<div class="form-group" id="xmjianjie_input">
								<div class="row">
									<div class="col-sm-12 " style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<strong style="font-size: 16px;">体检报告内容</strong>
									</div>
									<div class="col-sm-2 col-md-2 col-lg-1 text-center" style="padding-left: 0px;padding-right: 0px;height: 34px;line-height: 34px;">体检报告编号</div>
									<div class="col-sm-4 col-md-4 col-lg-2" style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<label style="height:34px;line-height: 34px;"><a href="<%=request.getContextPath()%>/medicalReport.do?medicalReportDetail" class="btn btn-primary btn-flat" target="_blank" style="margin-bottom: 0px !important; height: 34px;margin-left:0;float:right;">无</a></label>
									</div>
								</div>
							</div>
							<div class="form-group" id="xmjianjie_input">
								<div class="row">
									<div class="col-sm-12 " style="margin-bottom:5px;height: 34px;line-height: 34px;">
										<strong style="font-size: 16px;">付费列表</strong>
									</div>
									<table class="table table-bordered dataTable hover" id="datatable" aria-describedby="datatable_info">
										<thead>
											<tr role="row">
												<!--<th style="width:2%;"><input id="allselectchecker" type="checkbox" class="col_selector" onclick="selectAll();"></th>-->
												<th name="needSort" class="sorting"
													onclick="queryBySort(this,'chinese_loginname')"><strong>金额</strong>
												</th>
												<th name="needSort" class="sorting"
													onclick="queryBySort(this,'chinese_type')"><strong>类型</strong>
												</th>
												<th name="needSort" class="sorting"
													onclick="queryBySort(this,'chinese_type')"><strong>支付时间</strong>
												</th>
												<th name="needSort" class="sorting"
													onclick="queryBySort(this,'chinese_type')"><strong>支付流水号</strong>
												</th>
											</tr>
										</thead>
										<tbody id="datacontainer" role="alert" aria-live="polite" aria-relevant="all">
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
							<input type="hidden" name="entityId" id="entityId">
							<div class="form-group">
								<label class="col-sm-3 control-label">服务人员</label>
								<div class="col-sm-6">
									<select id="category" style="width:100%;height:30px;">
										<option value=""></option>
                  	  				</select>
								</div>
							</div>
						</form>
					</div>
					<div class="footer">
						<div class="form-group" style="text-align: center;margin:0px">
							<button type="button" class="btn btn-primary btn-rad" onclick="">
								<span><i class="fa fa-check" style="margin-right:5px;"></i>选择</span>
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

	<div class="md-overlay"></div>

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

  	<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
  	<script src="js/jquery.upload/js/jquery.iframe-transport.js"></script>
  	<!-- The basic File Upload plugin -->
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
        
    });
   
        
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
