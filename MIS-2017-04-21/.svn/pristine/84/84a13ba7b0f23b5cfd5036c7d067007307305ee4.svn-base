<%@ page contentType="text/html;charset=UTF-8" language="java"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>  
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="description" content="Xenon Boostrap Admin Panel" />
    <meta name="author" content="" />
    <title>关注老人</title>
    <link rel="stylesheet" href="weixincss/AttentionFollowcss/bootstrap.css">
    <link rel="stylesheet" href="weixincss/AttentionFollowcss/core.css">
    <link rel="stylesheet" href="weixincss/AttentionFollowcss/color.css">
    <link rel="stylesheet" href="weixincss/AttentionFollowcss/my_Frame.css">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script type="text/javascript" src="weixinjs/jquery-1.11.1.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script type="text/javascript" src="weixinjs/bootstrap.min.js"></script>
    <style>
      .thumbnail{border:0px;width:80%;margin:10px auto;} 
      .col-xs-3{padding-left:5px;padding-right:5px}
    </style>
  </head>  
  <body>
    <!-- 顶部导航栏 -->
    <div class="page-header">
      <div class="navbar-brand">
        <a href="###" class="logo" id="backToGzlr">
          <img src="weixinimages/AttentionFollowimages/back.png" width="25" alt="" class="hidden-xs" />
          <img src="weixinimages/AttentionFollowimages/back.png" width="25" alt="" class="visible-xs" />
          <span id="backToGzlrclick">关注老人</span></a>
      </div>
      <div class="clearfix"></div>
    </div>
    <!-- 头像信息 -->
    <div class="container" style="margin-top:20px;margin-bottom:10px;">
      <div class="row">
        <div class="col-xs-3"></div>
        <div class="col-xs-6">
          <a href="#" class="thumbnail" style="border:0px;">
            <img class="img-circle" id="photoUrl_older" src="" width="70"></img>
          </a>
          <h3 style="text-align:center;color:#576b95;margin-top:-15px;">
            <span id="name_older" style="vertical-align:middle;font-size:20px !important;"></span>
            <span id="huiyuanhao_older" style="vertical-align:middle;font-size:20px !important;"></span>
            <a href="###">
              <img style="vertical-align:middle;padding-left:8px;" src="weixinimages/AttentionFollowimages/infoicon.png"></img>
            </a>
          </h3>
        </div>
        <div class="col-xs-3"></div>
      </div>
    </div>
    <!-- 8大模块 -->
    <div class="container">
      <div class="row" style="border-top:1px solid #ddd;border-bottom:1px solid #ddd;">
        <div class="col-xs-3">
          <a href="###" id="lishifuwu_older" class="thumbnail">
            <img src="weixinimages/AttentionFollowimages/shebei1.png"></img>
          </a>
          <p style="text-align:center;">历史服务</p></div>
        <div class="col-xs-3" style="border-left:1px solid #ddd;border-right:1px solid #ddd;">
          <a href="###" id="jkbg_older" class="thumbnail">
            <img src="weixinimages/AttentionFollowimages/shuju1.png"></img>
          </a>
          <p style="text-align:center;">健康评估</p></div>
        <div class="col-xs-3" style="border-right:1px solid #ddd;">
          <a href="###" id="slcs_older" class="thumbnail">
            <img src="weixinimages/AttentionFollowimages/jianyi1.png"></img>
          </a>
          <p style="text-align:center;">生理参数</p></div>
        <div class="col-xs-3">
          <a href="###" id="smjh_older" class="thumbnail">
            <img src="weixinimages/AttentionFollowimages/smjh.png"></img>
          </a>
          <p style="text-align:center;">睡眠监护</p></div>
        <div class="col-xs-3" style="border-top:1px solid #ddd;">
          <a href="###" id="aqsb_older" class="thumbnail">
            <img src="weixinimages/AttentionFollowimages/saveDev.png"></img>
          </a>
          <p style="text-align:center;">安全设备</p></div>
        <div class="col-xs-3" style="border-top:1px solid #ddd;border-right:1px solid #ddd;border-left:1px solid #ddd;">
          <a href="###" id="jkzx_older" class="thumbnail">
            <img src="weixinimages/AttentionFollowimages/healthAsk.png"></img>
          </a>
          <p style="text-align:center;">健康咨询</p></div>
        <div class="col-xs-3" style="border-top:1px solid #ddd;border-right:1px solid #ddd;">
          <a href="###" id="zhye_older" class="thumbnail">
            <img src="weixinimages/AttentionFollowimages/accountBalance.png"></img>
          </a>
          <p style="text-align:center;">账户余额</p></div>
        <div class="col-xs-3" style="border-top:1px solid #ddd;">
          <a href="###" id="yytx_older" class="thumbnail">
            <img src="weixinimages/AttentionFollowimages/yytx.png"></img>
          </a>
          <p style="text-align:center;">药用提醒</p></div>
      </div>
    </div>
    <!-- 取消绑定按钮 -->
    <div class="container" style="margin-top:20px;margin-bottom:50px;">
      <div class="row">
        <div class="col-xs-3"></div>
        <div class="col-xs-6" onclick="quxiaobangdin()">
          <a class="btn btn-success btn-lg" id="cencel" style="display:block;" role="button">取消关注</a></div>
        <div class="col-xs-3"></div>
      </div>
    </div>
    <!-- 底部热线电话 -->
    <div class="panel-footer pos_footer">热线电话：
      <span class="font_blue">
        <a href="tel:4000965258">4000965258</a></span>
    </div>
    <!-- #include file="../Footer.html" --></body>

</html>
<script type="text/javascript">
  $(document).ready(function() {
      var olderId = "<%=request.getAttribute("olderId")%>"; //老人id
      var openid = "<%=request.getAttribute("openid")%>"; //微信openid
      //各模块地址
      $("#lishifuwu_older").attr("href", "<%=request.getContextPath()%>/" + "wechatServiceHistory.do?main&olderId=" + olderId + "&weixin=weixin"); //历史服务
      $("#jkbg_older").attr("href", "<%=request.getContextPath()%>/" + "wechatHealthAssessment.do?main&olderId=" + olderId + "&weixin=weixin"); //健康报告
      $("#slcs_older").attr("href", "<%=request.getContextPath()%>/" + "wechatPhysiologicalPar.do?main&olderId=" + olderId + "&weixin=weixin");  //生理参数
      $("#zhye_older").attr("href", "<%=request.getContextPath()%>/" + "wechatYuE.do?mainBalance&olderId=" + olderId + "&weixin=weixin"); //账户余额
      $("#aqsb_older").attr("href", "<%=request.getContextPath()%>/" + "wechatDev.do?main&olderId=" + olderId + "&weixin=weixin"); //安全设备
      $("#jkzx_older").attr("href", "<%=request.getContextPath()%>/" + "wechatHealthyQuery.do?main&olderId=" + olderId + "&weixin=weixin"); //健康咨询
      $("#yytx_older").attr("href", "<%=request.getContextPath()%>/" + "wechatMed.do?main&olderId=" + olderId + "&weixin=weixin"); //药用提醒
      $("#smjh_older").attr("href", "http://org.yymedic.com:3001/mobile.html#/bind?wxid=" + openid); //睡眠监护
      $("#backToGzlr").attr("href", "<%=request.getContextPath()%>/" + "wechatOlder.do?main&flag=flag&weixin=weixin");  
      queryOlder();  
    });
  
    function queryOlder() { //加载老人信息
      var reqmsg = "{'action':'QUERY_OLDER_INFO_REQUEST','content':{";  
      var olderId = "<%=request.getAttribute("olderId")%>";
      if (olderId != null && olderId != "") {
        reqmsg += "\"id\":" + olderId + ",";
      }  
      reqmsg += "}}";  
      jQuery.ajax({
        type: "post",
        async: true,
        url: "older.do?handler",
        dataType: "json",
        data: {
          "reqmsg": reqmsg,
          "weixin": "weixin"
        },
        success: function(data) {
          if (data.des == "success") {
            if (data.content != null) {
              if (data.content.mainPhoto == "" || data.content.mainPhoto == null) {
                $("#photoUrl_older").attr("src", "<%=request.getContextPath()%>" + "/weixinimages/oldernull.png");
              } else {
                $("#photoUrl_older").attr("src", data.content.mainPhoto + "?random=" + Math.random());
              }
              $("#name_older").html(data.content.name);
              $("#huiyuanhao_older").html(data.content.memberNum);
            }
          } else if (data.des == "failure") {
            //alert("查询失败");
          }
        },
        error: function() {
          alert("error");
        }
      });
    }
  
    function quxiaobangdin() { //取消绑定老人二次确认及操作
      if (confirm("是否确认取消关注?")) {
        var olderWechatId = getOlderWechatId();
        if (olderWechatId == "") {
          alert("出错了");
          return;
        }
        jQuery.ajax({
          type: "post",
          url: "olderWechat.do?del",
          async: false,
          dataType: "json",
          data: {
            ids: olderWechatId,
            "weixin": "weixin"
          },
          success: function(data) {
            if (data.result == "success") {
              alert("取消关注成功");
              $("#backToGzlrclick").click();
            } else if (data.des == "failure") {
              alert("取消关注失败");
            }
          },
          error: function() {
            alert("error");
          }
        });
      }
    }
  
    function getOlderWechatId() { //获取老人微信id
      var openid = "<%=request.getAttribute("openid")%>";
      var reqmsg = "{'action':'QUERY_WECHAT_LIST_REQUEST','page':{'pageno':'1','pagesize':'1'},'content':{";
      var OlderWechatId = "";
      var WechatId = "";
      if (openid != null && openid != "") {
        reqmsg += "\"openid\":\"" + openid + "\",";
      }
      reqmsg += "}}";
  
      jQuery.ajax({
        type: "post",
        async: false,
        url: "wechat.do?handler",
        dataType: "json",
        data: {
          "reqmsg": reqmsg,
          "weixin": "weixin"
        },
        success: function(data) {
          if (data.des == "success") {
            if (data.content != null) {
              if (data.content.wechatList != null) {
                WechatId = data.content.wechatList[0].id;
              }
            }
          } else if (data.des == "failure") {
            //alert("查询失败");
          }
        },
        error: function() {
          alert("error");
        }
      });
  
      if (WechatId != "" && WechatId != null) {
        var olderId = "<%=request.getAttribute("olderId")%>";
        var reqmsg2 = "{'action':'QUERY_OLDER_WECHAT_LIST_REQUEST','page':{'pageno':'1','pagesize':'1'},'content':{";  
        reqmsg2 += "\"wechatId\":" + WechatId + ",";
        reqmsg2 += "\"olderId\":" + olderId + ",";  
        reqmsg2 += "}}";  
        jQuery.ajax({
          type: "post",
          async: false,
          url: "olderWechat.do?handler",
          dataType: "json",
          data: {
            "reqmsg": reqmsg2,
            "weixin": "weixin"
          },
          success: function(data) {
            if (data.des == "success") {
              if (data.content != null) {
                if (data.content.olderWechatList != null) {
                  OlderWechatId = data.content.olderWechatList[0].id;
                }
              }
            } else if (data.des == "failure") {
              //alert("查询失败");
            }
          },
          error: function() {
            alert("error");
          }
        });
      }  
      return OlderWechatId;
    }
  </script>