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
    <title>健康咨询</title>
    <link rel="stylesheet" href="weixincss/bootstrap.min.css">
    <link rel="stylesheet" href="weixincss/mycss.css">
    <script src="weixinjs/jquery.js"></script>
    <script src="weixinjs/bootstrap.min.js"></script>
    <style> 
      .chat-wi{margin:50px 0 20px 0;width:100%;}
      .chat-wi p{text-align:center;width:100%;color:#4aa4ec;font-size:12px;padding-top:10px}
      #msg_end{color:#fff}
      .c-bubble{word-break:break-all;}
    </style>
  </head>
  <body>
    <div class="fixedTOP"> <!-- 页面标题 开始 -->
      <h3>健康咨询</h3>
      <a href="###" class="logo" id="backToGzlr">
        <span class="glyphicon glyphicon-chevron-left"></span>
      </a>
      <a href="###" class="fresh" onclick="refresh();">
        <span class="glyphicon glyphicon-refresh"></span>
      </a>
    </div> <!-- 页面标题 结束 -->
    <div class="chat-wi"> <!-- 聊天框 开始 -->
      <p id="loadMore">
        <a>加载中...</a>
      </p>
      <div class="chat-content content" id="chat-content"></div>
    </div> <!-- 聊天框 结束 -->
    <a href="###" id="msg_end">fake-link</a>
    <div class="fixedBOTTOM"> <!-- 聊天编辑框 开始 -->
      <input type="submit" value="发 送" class="btn btn-info pull-right buttonarea" onclick="savechat();">
      <div class="inputarea">
        <textarea placeholder="请输入..." id="chatContent"></textarea>
      </div>
    </div> <!-- 聊天编辑框 结束 -->
  </body>

</html>
<script type="text/javascript">
  $(document).ready(function() {
      $("#backToGzlr").attr("href", "<%=request.getContextPath()%>/" + "wechatOlder.do?mainXQ&olderId=" + olderId + "&weixin=weixin"); //返回主页
      getOlderName(); //获得老人姓名，会员号
      queryWXInfo(); //根据openid获取当前微信账号的id 名字，头像  
    });
  
    var isFirst = "Y"; //判断是否首次加载或刷新操作，是-跳到页面底部。默认为“是”
    function getOlderName() { //根据老人id获得老人姓名
      var reqmsg = "{'action':'QUERY_OLDER_INFO_REQUEST','content':{\"id\":" + olderId + "}}";
      jQuery.ajax({
        type: "post",
        async: false,
        url: "daeOlder.do?handler",
        dataType: "json",
        data: {
          "reqmsg": reqmsg,
          "weixin": "weixin"
        },
        success: function(data) {
          if (data.des == "success") {
            olderName = data.content.name;
            memberNum = data.content.memberNum;
          } else if (data.des == "failure") {
            //alert("error");
          }
        },
        error: function() {
          alert("error");
        }
      });
    }
    
    function queryWXInfo() { //根据openid获得当前微信账号的相关信息
      var reqmsg = "{'action':'QUERY_WECHAT_LIST_REQUEST','content':{";
      if (openid == null || openid == "" || openid == "null") {
        alert("错误，请确认当前微信账号是否正确登陆！");
        return;
      } else {
        reqmsg += "\"openid\":\"" + openid + "\",";
      }
      reqmsg += "}}";  
      jQuery.ajax({
        type: "post",
        async: true,
        url: "wechatDetail.do?handler",
        dataType: "json",
        data: {
          "reqmsg": reqmsg,
          "weixin": "weixin"
        },
        success: function(data) {
          if (data.des == "success") {
            wechatid = data.content.wechatList[0].id;
            console.log(wechatid);
            wechatnickname = data.content.wechatList[0].nickname;
            wechatphotoUrl = data.content.wechatList[0].photoUrl;
            go2page(1); //有效登录情况下，加载对话信息
          } else if (data.des == "failure") {
            alert("当前微信账号信息查询失败");
          }
        },
        error: function() {
          alert("error");
        }
      });
    }
  
    var olderName = ""; //老人姓名
    var memberNum = ""; //会员号
    var olderId = "<%=request.getAttribute("olderId")%>";  
    //当前微信账号的openid ,微信id，昵称，微信头像
    var openid = "<%=request.getAttribute("openid")%>";
    //var openid = "oLglrxLev09-iwwPcrzQltnXBYI0"; 
    console.log("openid：" + openid);
    var wechatid;
    var wechatnickname = "";
    var wechatphotoUrl = "";
  
    var chatTime = getNowFormatDate(); //时间
    var chatTimeLastest = getNowFormatDate(); //最近一次加载的时间
    var currentshownpage = 1; //当前页
    function go2page(pagenumber) { //获取历史聊天信息的最新10条内容
      var reqmsg = "{\"action\":\"QUERY_CHAT_LIST_REQUEST\",\"page\":{\"pageno\":\"" + pagenumber + "\",\"pagesize\":\"10\"},\"order\":[{\"column\":\"id\",\"type\":\"desc\"}],\"content\":{";
  	  if (olderId == "" || olderId == null) {
        alert("错误");
        return;
      }
      reqmsg += "\"olderId\":" + olderId + ",";
      if (chatTime != null && chatTime != "") {
        reqmsg += "\"chatTime_lt\":\"" + chatTime + "\","; //聊天时间小于
      }
      reqmsg += "}}";  
      jQuery.ajax({
        type: "post",
        async: true,
        url: "chat.do?handler",  
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
  
    function changeData(data) { //展示获得的聊天信息
      if (data.content == null || data.content == "") {
        $("#loadMore").html("<a>目前没有聊天信息</a>");
      }
      if (data.page.pageno < data.page.pageCount) {
        $("#loadMore").html("<a onclick=\"go2page(1)\">点击加载更多...</a>");
      } else {
        $("#loadMore").html("<a>没有更多了...</a>");
      }
      var htmlCode = "";
      if (data.content != null) {
        if (data.content.chatList != null) {
          var list = data.content.chatList.reverse(); //倒叙排列
          //console.log(list);
          jQuery.each(list, function(i, item) {
            if (item.spokesType == 1) {
              htmlCode += "<div class=\"chat-conv sent\" >";  
            } else {
              htmlCode += "<div class=\"chat-conv\" >";  
            }
            htmlCode += "<img  src=\"" + item.spokesmanPhoto + "?random=" + Math.random() + "\" >";
            htmlCode += "<div class=\"c-bubble1\">" + item.spokesmanName + "&nbsp;&nbsp;&nbsp;" + formateTime(item.chatTime) + "</div>";
            htmlCode += "<div class=\"c-bubble\"><div>" + item.chatContent + "</div><span></span></div>";
            htmlCode += "</div>";
            if (i == 0) {
              chatTime = item.chatTime; //当前加载的时间最前的时间
            }
          });
        }
      }
      $("#chat-content").prepend(htmlCode); //插入10条聊天记录
      if (isFirst == "Y") { //判断是否首次加载，是-跳到页面底部
        document.getElementById("msg_end").scrollIntoView(false);
        isFirst = "N";
      } else { //加载更多时插入内容,并定位
        if (document.getElementsByClassName("chat-conv").length >= 9) {
            document.getElementsByClassName("chat-conv")[8].scrollIntoView({
            block: "start",
            behavior: "smooth"
          });
        }
      }
    }
    
    function go2pagelastest(pagenumber) { //点击“加载更多”时，请求前10条聊天记录
      var reqmsg = "{\"action\":\"QUERY_CHAT_LIST_REQUEST\",\"page\":{\"pageno\":\"1\",\"pagesize\":\"10\"},\"order\":[{\"column\":\"id\",\"type\":\"desc\"}],\"content\":{";
  	  if (olderId == "" || olderId == null) {
        alert("错误");
        return;
      }
      reqmsg += "\"olderId\":" + olderId + ",";
      if (chatTimeLastest != null && chatTimeLastest != "") {
        reqmsg += "\"chatTime_gt\":\"" + chatTimeLastest + "\","; //聊天时间小于
      }
      reqmsg += "}}";  
      jQuery.ajax({
        type: "post",
        async: true,
        url: "chat.do?handler",
  
        dataType: "json",
        data: {
          "reqmsg": reqmsg,
          "weixin": "weixin"
        },
        success: function(data) {
          if (data.des == "success") {
            changeDatalastest(data);
          } else if (data.des == "failure") {
            alert("查询失败");
          }
        },  
        error: function() {
          alert("error");
        }
      });
    }
  
    function changeDatalastest(data) { //加载最新聊天记录
      var htmlCode = "";
      if (data.content != null) {
        if (data.content.chatList != null) {
          var list = data.content.chatList.reverse(); //倒叙
          //console.log(list);
          jQuery.each(list, function(i, item) {
            if (item.spokesType == 1) {
              htmlCode += "<div class=\"chat-conv sent\"  >";  
            } else {
              htmlCode += "<div class=\"chat-conv\" >";  
            }
            htmlCode += "<img  src=\"" + item.spokesmanPhoto + "?random=" + Math.random() + "\" >";
            htmlCode += "<div class=\"c-bubble1\">" + item.spokesmanName + "&nbsp;&nbsp;&nbsp;" + formateTime(item.chatTime) + "</div>";
            htmlCode += "<div class=\"c-bubble\"><div>" + item.chatContent + "</div><span></span></div>";
            htmlCode += "</div>";
            chatTimeLastest = item.chatTime; //当前加载的时间最末的时间
          });
        }
      }
      $("#chat-content").append(htmlCode); 
      document.getElementById("msg_end").scrollIntoView(false);
    }
  
    function refresh() { //刷新，重新加载最新10条对话
      chatTime = getNowFormatDate(); //最新时间
      $("#chat-content").html("");
      isFirst = "Y";
      go2page(1);
    }
    
    /**
     * 格式化时间
     * @method formateTime
     * @param {String} time 时间信息(YYYYMMDDHHmmSS)
     * @return 格式化的时间(YYYY-MM-DD)
     */
    function formateTime(time) {
      if (time != null && time.length == 8) {
        return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8);
      } else if (time != null && time.length == 14) {
        return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + " " + time.substring(8, 10) + ":" + time.substring(10, 12) + ":" + time.substring(12, 14);
      } else {
        return time;
      }
    }
  
    function savechat() { //发送新的聊天信息
      if (olderId == "" || olderId == null) {
        return;
      }
      if (wechatid == "" || wechatid == null) {
        return;
      }
      var reqmsg = "{\"action\":\"ADD_CHAT_INFO_REQUEST\",\"content\":{";
      reqmsg += "\"olderId\":" + olderId + ",";
      reqmsg += "\"spokesmanId\":" + wechatid + ",";
      reqmsg += "\"olderName\":\"" + olderName + "\",";
      reqmsg += "\"olderMemberNum\":\"" + memberNum + "\",";
      reqmsg += "\"spokesmanName\":\"" + wechatnickname + "\",";
      reqmsg += "\"spokesmanPhoto\":\"" + wechatphotoUrl + "\",";
      reqmsg += "\"spokesmanType\":2,";
      reqmsg += "\"spokesType\":2,";
      var chatContent = document.getElementById("chatContent").value.replace(/\n/g, '_@').replace(/\r/g, '_#');
      chatContent = chatContent.replace(/_#_@/g, '<br/>'); //IE7-8
      chatContent = chatContent.replace(/_@/g, '<br/>'); //IE9、FF、chrome
      chatContent = chatContent.replace(/\s/g, '&nbsp;'); //空格处理
      if (chatContent != null && chatContent != "") {
        reqmsg += "\"chatContent\":\"" + chatContent + "\",";
      } else {
        alert("聊天内容不能为空");
        return;
      }
      var chatTime = getNowFormatDate();
      reqmsg += "\"chatTime\":\"" + chatTime + "\",";
      reqmsg += "}}";
  
      jQuery.ajax({
        type: "post",
        async: true,
        url: "chat.do?handler",
        dataType: "json",
        data: {
          "reqmsg": reqmsg,
          "weixin": "weixin"
        },
        success: function(data) {
          if (data.des == "success") {
            $("#chatContent").val("");
            //在聊天最后面加入最新发送的消息    
            go2pagelastest();
          } else if (data.des == "failure") {
            alert("发送失败");
          }
        },
        error: function() {
          alert("error");
        }
      });
    }
    
    function getNowFormatDate() { //获取当前时间，14位（20161020202000）
      var date = new Date();
      var month = date.getMonth() + 1;
      var currentdate = date.getFullYear() + "" + plus0(month) + "" + plus0(date.getDate()) + "" + plus0(date.getHours()) + "" + plus0(date.getMinutes()) + "" + plus0(date.getSeconds());
      return currentdate;
    }
    function plus0(par) { //月 日 时 分秒 小于10 前面+0
      if (par >= 0 && par <= 9) {
        par = "0" + par;
        return par;
      } else {
        return par;
      }
    }
</script>