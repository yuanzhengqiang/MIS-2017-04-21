//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//2013-09-16 KXTCall.OCX JS demo
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
var isConnect_CTI = 0;
var nTimer_id;
var login_uid,login_pwd,login_ext;
var IsCallDisconnect = 0;
var IsQueryAgentsInfo = 0;
var IsTelphonePickup = 0;

window.onunload = function() {
  $("Prompt").value ="";
};

// 控件处理函数
function Connect_CTI() {
   var strIP = $("txtIP").value;
   //"LONG Connect(String lpServer, LONG lPort, LONG nHeartBeatMs);"
   var nRet_conn = document.ut_atocx.Connect(strIP, 3000, 5000);
   if (nRet_conn == 0) {
   		rem("连接CTI服务器成功！");
   		isConnect_CTI = 1;
    } else {
      alert("与KXT CTI连接失败，请检查，原因：\n  1.网络连接是否正常.\n  2.KXT CTI工作是否正常.");
    }
    return false;
}

function DisConnect_CTI() {
    document.ut_atocx.Disconnect();
    isConnect_CTI = 0;
    return false;
}

//座席登录
function client_login() {
    var validity = false; // assume valid
	  //"LONG Login(BSTR AgentName, BSTR ExtCode, BSTR WorkNum);	"
    login_uid = $("txtUid").value; //坐席名
    login_pwd = $("txtPwd").value; //工号
    login_ext = $("txtExt").value; //分机号
    if (login_pwd == "") login_pwd = "";

    if (!check_empty(login_uid)) {
        alert('对不起，您输入的座席名不正确！');
        return validity;
    }
    if (!check_empty(login_ext)) {
        alert('对不起，您输入的座席工号不正确！');
        return validity;
    }
		//LONG Login([in] BSTR AgentName, [in] BSTR ExtCode, [in] BSTR WorkNum);
    document.ut_atocx.Login(login_uid, login_ext, login_pwd);
    validity = true;
    return validity;
}

//座席登出
 function client_logout() {
    var validity = true; // assume valid 
     //if (isConnect_CTI > 0) {
         document.ut_atocx.Logout();
     //    isConnect_CTI = 0;
         rem("座席成功退出");
     //}
     return validity;
 }

 function check_empty(text) {
     return (text.length > 0); // 如果为空则返回错误
 }


//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//表示座席员状态发生变化，显示相应状态
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
function show_agent_status(frmDetails, strUid, strStatus) {
    document.ut_atocx.UidSelected = strUid;
    var user_ext = document.ut_atocx.UidExt; //ATSeatstrUID();
    var user_name = document.ut_atocx.UidName; //ATSeatstrUID();
    if (user_name == "") user_name = document.ut_atocx.UidCode;
    if (user_name == "") user_name = document.ut_atocx.UidExt;
    var lbl_name = get_call_status(strStatus);
    if (strUid == login_uid) IsCallDisconnect = 1;

    //01：可工作 02：置忙 03：事后处理 04：离席
    var UidStatus = document.ut_atocx.UidStatus;
    if (UidStatus == "01") UidStatus = "可工作";
    else if (UidStatus == "02") UidStatus = "置忙";
    else if (UidStatus == "03") UidStatus = "事后处理";
    else if (UidStatus == "04") UidStatus = "离席";
    else if (UidStatus == "06") UidStatus = "未准备好";
    else if (UidStatus == "00") UidStatus = "注销";
    rem("座席状态：" + UidStatus + "，姓名：" + user_name + "，分机：" + user_ext + "，呼叫状态：" + lbl_name);
}

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//表示分机状态发生变化，显示相应状态
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
function show_ext_status(frmDetails, strExt, strStatus) {

    document.ut_atocx.ExtSelected = strExt;
    var strUid = document.ut_atocx.Ext_Uid;
    //不处理登录座席
    if (strUid != "") return;

    var lbl_name = get_call_status(strStatus);
    rem("分机状态：" + lbl_name + "，分机：" + strExt);
}

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//表示外线状态发生变化，显示相应状态
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
function show_trunk_status(frmDetails, strTrunk, strStatus) {
    var strDisp, strPrompt;
    var caller_code, ext_code, nDirection;

    var lbl_name = get_call_status(strStatus);
    caller_code = document.ut_atocx.TrunkCaller;
    ext_code = document.ut_atocx.TrunkCalled;
    nDirection = document.ut_atocx.TrunkDirection;
    rem("外线状态：" + lbl_name + "，主叫：" + caller_code + "，被叫：" + ext_code + "，方向：" + nDirection + "，时长：" + document.ut_atocx.TrunkTimer);
}

function get_call_status(strStatus) {
    var lbl_name;
    switch (strStatus) {
        case "0": //呼叫成功
            lbl_name = "呼叫成功";
            break;
        case "1": //应答
            lbl_name = "无信号音";
            break;
        case "2": //无人接听
            lbl_name = "无人接听";
            break;
        case "3": //忙音
            lbl_name = "忙音";
            break;
        case "4": // 无空闲通道
            lbl_name = "无空闲通道";
            break;
        case "5": //回铃音
            lbl_name = "回铃音";
            break;
        case "6": //拒绝接听
            lbl_name = "拒绝接听";
            break;
        default: //未知
            lbl_name = "未知";
            break;
    }
    return lbl_name;
}

//-------------------------------------------------------------
function AT_Command(strCmd) {
    //if (isConnect_CTI < 1) {
    //    alert("请先连接CTI服务器! " + isConnect_CTI);
    //    return false;
   // }
    switch (strCmd) {
        case "Hangup":
            document.ut_atocx.Finish("");
            break;
        case "PlaceCall": //呼叫电话
        	if(IsTelphonePickup) {
        		//LONG PlaceCall(LPCTSTR CalledNo, LPCTSTR CallerNo, LONG ProjectID)
            document.ut_atocx.PlaceCall($("txtTel").value, "0", 1);
          } else {
          	alert("请先 摘起电话.");
          }
            break;
        case "HoldCall":
        		//0 保持(keep) [false]；1 去除保持(no keep) [true]
            document.ut_atocx.HoldResume(false);
            break;
        case "MuteOn":
        		//mute
            document.ut_atocx.Mute(true);
            break;
        case "MuteOff":
            document.ut_atocx.Mute(false);
            break;
        case "RetriveCall":
        //case "ResumeCall":
            document.ut_atocx.HoldResume(true);
            break;
        //case "TransCall": //单步转接
        //		//alert($("txtTel_tran").value);
        //		document.ut_atocx.Forward($("txtTel_tran").value);
        //		break;
        case "Conf_est":
        //case "CreateConf": //电话会议
        		if(1 != IsQueryAgentsInfo)
        		{
        			alert("请先点击 【查询】 按钮 查询坐席状态.");
        		} else {
        			if(IsTelphonePickup) {
   						//LONG ConfEst(CString CallNos, CString ConfName);
	        		//alert($("txtTel_conf").value);
	            //document.ut_atocx.ConfEst($("txtTel_conf").value, login_ext);
	            document.ut_atocx.PlaceCallInside($("txtTel_conf").value);
							} else {
						    alert("请先 摘起电话.");
							}
          	}
            break;
        case "ConsTrans": //协商转接
        		//LONG ConsConf(CString ConfName);
        		//LONG Join(CString CallJoinNo, CString ConfName);
            document.ut_atocx.Join($("txtTel_tran").value, login_ext);
            break;
        case "TranOver": //协商转接完成
        		//LONG ConfOver(CString ConfName);
            document.ut_atocx.ConfOver(login_ext);
            break;
        case "TransIVR": //转接IVR
            //var strIvr = "AC_SWITCHIVR;CALLID=" + document.ut_atocx.myCall_CallId + ";EXT=" + login_ext + ";IVRFILE=" + $("txtIvrFile").value + ";NODE=" + $("txtIvrNode").value + ";IVRMSG=自己定义;";
            strIvr = $("txtIvrNode").value;
            document.ut_atocx.TransIVR(strIvr);
            break;
        case "SendFax":
        		//LONG SendFax(CString FaxId, CString FaxPath);
        		document.ut_atocx.SendFax($("txtFaxId").value, $("txtFaxPath").value);
        		break;
        case "RecevieFax":
        		//LONG RecevieFax(CString FaxPath);
        		document.ut_atocx.RecevieFax($("txtFaxPath").value);
        		break;
        case "QueryInfo":
        		//LONG QueryAgentsInfo(CString ExtNo);
        		//document.ut_atocx.QueryAgentsInfo($("txtTel_insert").value);
        		//document.ut_atocx.Trigger("Not found EXTNO map!", 0);
        		//alert(document.LicenseDate); //???? ????
        		document.ut_atocx.QueryAgentsInfo("");
        		IsQueryAgentsInfo = 1;
        		break;
        case "Insert": //强插
        		//LONG Backin(String ExtNo)
        		if(1 != IsQueryAgentsInfo)
        		{
        			alert("请先点击 【查询】 按钮 查询坐席状态.");
        		} else {
        			if(1 != IsQueryAgentsInfo)
        		{
        			alert("请先点击 【查询】 按钮 查询坐席状态.");
        		} else {
            document.ut_atocx.Backin($("txtTel_insert").value);
          	}
         	 }
            break;
        case "Headoff": //拦截
        		if(1 != IsQueryAgentsInfo)
        		{
        			alert("请先点击 【查询】 按钮 查询坐席状态.");
        		} else {
        		if(1 != IsQueryAgentsInfo)
        		{
        			alert("请先点击 【查询】 按钮 查询坐席状态.");
        		} else {
            document.ut_atocx.Headoff($("txtTel_insert").value);
          	}
         	 }
        		break;
        case "Backout":
        case "DisConnect":
           if(1 != IsQueryAgentsInfo)
        		{
        			alert("请先点击 【查询】 按钮 查询坐席状态.");
        		} else {
        			if(1 != IsQueryAgentsInfo)
        		{
        			alert("请先点击 【查询】 按钮 查询坐席状态.");
        		} else {
        			//LONG  Backout(CString ExtNo);
            	document.ut_atocx.Backout($("txtTel_insert").value);
            }
          	}
        		break;
        case "MoniExt":  //监听
        		if(1 != IsQueryAgentsInfo)
        		{
        			alert("请先点击 【查询】 按钮 查询坐席状态.");
        		} else {
        			if(1 != IsQueryAgentsInfo)
        		{
        			alert("请先点击 【查询】 按钮 查询坐席状态.");
        		} else {
        			//LONG  QueryAgentsInfoSync(CString ExtNo);
            	document.ut_atocx.Monitor($("txtTel_insert").value);
            }
          	}
            break;
        case "Finish":
            document.ut_atocx.Finish($("txtTel_insert").value);
            break;
        case "SetBusy":
        		//LONG ChangeAgentState(LONG NewState);
            document.ut_atocx.ChangeAgentState(0);
            break;
        case "SetNoBusy":
         		//ChangeAgentState [0 示忙；1 示闲]
            document.ut_atocx.ChangeAgentState(1);
            break;
        case "SetLeave": //离席
            document.ut_atocx.ChangeAgentState(0);
            break;
        case "SetNoLeave": //取消离席
            document.ut_atocx.ChangeAgentState(1);
            break;
        case "Investigate":
        	document.ut_atocx.Investigate($("txtTel_insert").value);
        	break;
        case "CancelPlaceCall":
        	document.ut_atocx.CancelPlaceCall($("txtTel_insert").value);
        	break;
        case "CancelPlaceCallInside":
        	document.ut_atocx.CancelPlaceCallInside($("txtTel_conf").value); //txtTel_conf  txtTel_insert
        	break;
        case "UpdateIVRSet":
        	document.ut_atocx.UpdateIVRSet();
        	break;
        case "UpdateChannelSet":
        	document.ut_atocx.UpdateChannelSet();
        	break;
        default:
            alert("未处理命令：" + strCmd);
            break;
    }
    return true;
}

function btn_Command(strCmd) {
    switch (strCmd) {
        case "ClearDisp": //清除显示
            $("Prompt").value = "";
            break;
        default:
            alert("未处理命令：" + strCmd);
            break;
    }
    return true;
}

function rem(strMsg) {
    //alert(strMsg);
    var myPrompt = document.getElementById("Prompt");
    if (myPrompt != null)
        myPrompt.innerText = myPrompt.innerText + "\n" + strMsg;
}


function $(itemID) {
    if (document.getElementById) {
        return document.getElementById(itemID);
    } else {
        return document.all(itemID);
    }
}
