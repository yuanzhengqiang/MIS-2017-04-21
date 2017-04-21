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
    <title>药用提醒</title>
    <link rel="stylesheet" href="weixincss/bootstrap.min.css">
    <link rel="stylesheet" href="weixincss/mycss.css">
    <script src="weixinjs/jquery.js"></script>
    <script src="weixinjs/bootstrap.min.js"></script>
    <style>   
      .table th:nth-child(1), .table td:nth-child(1) {min-width: 80px;}
      .table th:nth-child(2), .table td:nth-child(2) {text-align:right}
      .table1 td{border:0 !important;padding-bottom:0 !important}
      .table1 {margin-top:50px;margin-bottom:10px}
      .divide{height:10px;background:#eee}
    </style>
  </head>
  <body>
    <div class="fixedTOP"> <!-- 页面标题 开始 -->
      <h3>药用提醒</h3>
      <a href="###" class="logo" id="backToGzlr">
        <span class="glyphicon glyphicon-chevron-left"></span>
      </a>
    </div> <!-- 页面标题 结束 -->
    <table class=" table table1">
      <tbody id="">
        <tr>
          <td><strong>开始时间</strong></td>
          <td id="startime"></td>
        </tr>
        <tr>
          <td><strong>结束时间</strong></td>
          <td id="endtime"></td>
        </tr>
        <tr>
          <td><strong>状态</strong></td>
          <td id="status"></td>
        </tr>
      </tbody>
    </table>
    <div class="divide"></div>
    <table class=" table table2" style="margin-top:10px">
      <thead>
        <tr>
          <th>
            <strong>提醒时间</strong></th>
          <th>
            <strong>提醒内容</strong></th>
        </tr>
      </thead>
      <tbody id="datacontainer"></tbody>
    </table>
    <script type="text/javascript">
      var path = "medPlan.do";
      var olderId = "<%=request.getAttribute("olderId")%>"; //老人id
      $(document).ready(function() {
        go2page(1); //加载用药信息
        $("#backToGzlr").attr("href", "<%=request.getContextPath()%>/" + "wechatOlder.do?mainXQ&olderId=" + olderId + "&weixin=weixin"); //返回个人主页
      });
      
      function go2page(pagenumber) { //加载用药信息
        var reqmsg = "{'action':'QUERY_MED_PLAN_LIST_REQUEST','content':{'medNoticeListShow':'true',";
        if (olderId != null && olderId != "") {
          reqmsg += "\"olderId\":" + olderId + ",";
        }
        reqmsg += "}}";
        jQuery.ajax({
          type: "post",
          async: false,
          url: path + "?handler",
          dataType: "json",
          data: {
            "reqmsg": reqmsg,
            "weixin": "weixin"
          },
          success: function(data) {
            if (data.des == "success") {
              changeData(data);
            } else if (data.des == "failure") {
              alert("查询失败");
            }
          },
          error: function() {
            alert("error");
          }
        });
      }

      function changeData(data) { //展示用药信息
        var htmlcode = "";
        if (data.content != null) {
          if (data.content.medPlanList[0] != null) {
            $("#status").text(formateStatus(data.content.medPlanList[0].status));
            $("#endtime").text(formateTime(data.content.medPlanList[0].endtime));
            $("#startime").text(formateTime(data.content.medPlanList[0].startime));
            jQuery.each(data.content.medPlanList[0].medNoticeList, function(i, item) {
              htmlcode += "<tr>";
              htmlcode += "<td>" + formateTime(item.noticeTime) + "</td>";
              htmlcode += "<td>" + item.noticeContent + "</td>";
              htmlcode += "</tr>";
            });
          }
          $("#datacontainer").html(htmlcode);
        } else {
          $("#status").text("该老人目前无服药计划");
        }
      }

      /**
     * 格式化时间
     * @method formateTime
     * @param {String} time 时间信息(YYYYMMDDHHmmSS)
     * @return 格式化的时间(YYYY-MM-DD HH:mm:SS)
     */
      function formateTime(time) {
        if (time != null && time.length == 14) { //YYYY-MM-DD HH:mm:SS
          return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + " " + time.substring(8, 10) + ":" + time.substring(10, 12) + ":" + time.substring(12, 14);
        } else if (time != null && time.length == 8) { //YYYY-MM-DD
          return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8);
        } else if (time != null && time.length == 4) { //mm:SS
          return time.substring(0, 2) + ":" + time.substring(2, 4);
        } else {
          return time;
        }
      }

      function formateStatus(par) {
        if (par == 1) {
          return "有效"
        } else if (par == 2) {
          return "无效"
        } else {
          return par
        }
      }
  </script>
  </body>
</html>