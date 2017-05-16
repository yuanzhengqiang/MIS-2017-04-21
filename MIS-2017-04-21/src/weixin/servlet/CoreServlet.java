package weixin.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.omg.CORBA.NVList;

import sbtj.init.SystemInit;
import sbtj.util.EmojiFilter;
import weixin.tools.SignUtil;
import weixin.tools.XMLUtil;

import com.framework.system.util.JsonUtil;

/**
 * 核心请求处理类
 * 
 */
public class CoreServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(CoreServlet.class);

	private static final long serialVersionUID = 4440739483644821986L;
	
	private static SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * 确认请求来自微信服务器 验证微信接入服务器是否成功,微信地址配置项
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			logger.debug("微信服务器       验证接入");
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 消息的接收、处理、响应
		logger.debug("微信     用户关注进入或者取消关注,或者接收用户消息");
		message(request, response);
	}

	/**
	 * <p>
	 * XML组装组件
	 * </p>
	 */
	private void message(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		InputStream is = request.getInputStream();
		// 取HTTP请求流长度
		int size = request.getContentLength();
		// 用于缓存每次读取的数据
		byte[] buffer = new byte[size];
		// 用于存放结果的数组
		byte[] xmldataByte = new byte[size];
		int count = 0;
		int rbyte = 0;
		// 循环读取
		while (count < size) {
			// 每次实际读取长度存于rbyte中
			rbyte = is.read(buffer);
			for (int i = 0; i < rbyte; i++) {
				xmldataByte[count + i] = buffer[i];
			}
			count += rbyte;
		}
		is.close();
		String requestStr = new String(xmldataByte, "UTF-8");

		try {
			//logger.debug("微信测试message:requestStr     " + requestStr);
			manageMessage(requestStr, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * 业务转发组件
	 * </p>
	 * 
	 */
	private void manageMessage(String requestStr, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// true则代表正式环境，可以开启获取token线程，获取微信服务器数据
		if ("formal".equals(SystemInit.weixinmsgpush)) {
			SignUtil.getAccess_tokenByThread();
		}
		String responseStr = null;
		String MsgType = null;
		String Event = null;
		String Content = null;
		String FromUserName = null;
		String ToUserName = null;
		String huifuString = null;
		try {
			Document document = DocumentHelper.parseText(requestStr);
			if(document==null){
				logger.debug("微信：document为空！");
			}else{	
				Element rootNode = document.getRootElement();
				if(rootNode==null){
					logger.debug("微信：rootNode为空！");
				}else{
					String rootName = rootNode.getName();
					if("xml".equals(rootName)){
						Iterator<Element> iterator = rootNode.elementIterator();  
						while(iterator.hasNext()){  
							Element e = iterator.next();  
							if(e.getName().equals("MsgType")){
								MsgType = e.getText();
							}
							if(e.getName().equals("Event")){
								Event = e.getText();
							}
							if(e.getName().equals("Content")){
								Content = e.getText();
							}
							if(e.getName().equals("FromUserName")){
								FromUserName = e.getText();
							}
							if(e.getName().equals("ToUserName")){
								ToUserName = e.getText();
							}
						} 
					}
					
				}
			}
			logger.debug("微信    用户端请求体  " + requestStr);
			if (MsgType.equals("event")) {
				if(Event.equals("subscribe")){//第一次关注
					String access_token =  SystemInit.access_token;
					String message = SignUtil.getUrl("https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + access_token + "&openid=" + FromUserName + "&lang=zh_CN");	
					logger.debug("微信测试    第一次关注  message=" + message);
					Map demoJson = JsonUtil.getMap4Json(message);
					Integer subscribe =(Integer) demoJson.get("subscribe");//是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息
					
					if(subscribe != 0){
						String openid = (String) demoJson.get("openid");//用户的标识，对当前公众号唯一
						String nickname = (String) demoJson.get("nickname");//昵称
						nickname = EmojiFilter.filterEmoji(nickname);
						
						Integer sex = (Integer) demoJson.get("sex");//性别
						String country = (String) demoJson.get("country");//国家
						String province = (String) demoJson.get("province");//省份
						String city = (String) demoJson.get("city");//城市
						
						//String headimgurl = (String) demoJson.get("headimgurl");//头像
						Date date = new Date();
						String createTime = formater.format(date);
						
						String reqmsg = "{\"action\":\"ADD_WECHAT_CUSTOMER_INFO_REQUEST\",\"content\":{\"openId\":\"" + openid + "\",\"nakeName\":\"" + nickname + "\",";
						
						/*if(headimgurl != null && !"".equals(headimgurl) && headimgurl.length() > 4){
							if(headimgurl.substring(0,4).equals("http")){
								headimgurl = SignUtil.getPhoto(headimgurl);//头像转base64
								reqmsg += "\"photoUrl\":\"" + headimgurl + "\",";
							}
						}*/
						
						reqmsg += "\"gender\":" + getSex(sex) + ",";
						reqmsg += "\"country\":\"" + country + "\",";
						reqmsg += "\"province\":\"" + province + "\",";
						reqmsg += "\"city\":\"" + city + "\",";
						
						reqmsg += "\"updateTime\":\"" + createTime + "\"}}";
						
						String ifFinish = SignUtil.doHttpPost(SignUtil.handlerurl + "/wechatCustomer.do?handlerWechat",reqmsg);
						logger.debug("微信测试      reqmsg= " + reqmsg + "    ifFinish= " + ifFinish);
						Map reqParams = JsonUtil.getMap4Json(ifFinish);
						String result = (String) reqParams.get("result");
						if(result.equals("100")){//注册成功
							JSONObject content = (JSONObject) reqParams.get("content");
							String inviteCode = "";
							if (content != null) {
								String id = content.getString("id");
								String reqmsg2 = "{\"action\":\"QUERY_WECHAT_CUSTOMER_INFO_REQUEST\",\"content\":{\"id\":" + id + "}}";
								String query2 = SignUtil.doHttpPost(SignUtil.handlerurl + "/wechatCustomer.do?handlerWechat",reqmsg2);
								Map reqParams2 = JsonUtil.getMap4Json(query2);
								String result2 = (String) reqParams2.get("result");
								if(result2.equals("100")){
									JSONObject content2 = (JSONObject) reqParams2.get("content");
									if (content2 != null) {
										inviteCode = content2.getString("inviteCode");
									}
								}
							}
							huifuString = XMLUtil.formatXmlAnswer(FromUserName,ToUserName,"感谢关注！【" + nickname + "】,您已成为我们的会员。您的邀请码是：" + inviteCode + "。<a href=\"" + SignUtil.handlerurl + "/weixinactivity.do?weixinEventDetails&weixin=weixin&invitationCode=" + inviteCode + "\">活动链接地址</a>");
							logger.debug(nickname + "   " + FromUserName +"   微信注册成功");
							OutputStream os = response.getOutputStream();
							os.write(huifuString.getBytes("UTF-8"));
						}else{
							huifuString = XMLUtil.formatXmlAnswer(FromUserName,ToUserName,"注册失败!");
							OutputStream os = response.getOutputStream();
							os.write(huifuString.getBytes("UTF-8"));
						}
					}else{
						huifuString = XMLUtil.formatXmlAnswer(FromUserName,ToUserName,"注册失败!");
						OutputStream os = response.getOutputStream();
						os.write(huifuString.getBytes("UTF-8"));
					}
				}
				if(Event.equals("VIEW")){//(已关注)正常进入微信公众号，用于拉取更新用户最新信息
					String access_token = SystemInit.access_token;
					String message = SignUtil.getUrl("https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + access_token + "&openid=" + FromUserName + "&lang=zh_CN");	
					Map demoJson = JsonUtil.getMap4Json(message);
					Integer subscribe =(Integer) demoJson.get("subscribe");//是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息
					
					if(subscribe != 0){
						String openid = (String) demoJson.get("openid");//用户的标识，对当前公众号唯一
						String nickname = (String) demoJson.get("nickname");//昵称
						String headimgurl = (String) demoJson.get("headimgurl");//头像
						//if(headimgurl.substring(0,4).equals("http")){
						//	headimgurl = SignUtil.getPhoto(headimgurl);//头像转base64
						//}
						
						Integer sex = (Integer) demoJson.get("sex");//性别
						String country = (String) demoJson.get("country");//国家
						String province = (String) demoJson.get("province");//省份
						String city = (String) demoJson.get("city");//城市
						
						//根据openid获取用户id
						String reqmsgQuery = "{\"action\":\"QUERY_WECHAT_CUSTOMER_LIST_REQUEST\",\"page\":{\"pageno\":\"1\",\"pagesize\":\"1\"},\"content\":{\"openId\":\"" + openid + "\"}}";
						String queryId = SignUtil.doHttpPost(SignUtil.handlerurl + "/wechatCustomer.do?handlerWechat",reqmsgQuery);
						Map reqParamsQueryId = JsonUtil.getMap4Json(queryId);
						String resultQuery = (String) reqParamsQueryId.get("result");
						String id = "0";
						if(resultQuery.equals("100")){
							JSONObject contentQuery = (JSONObject) reqParamsQueryId.get("content");
							if (contentQuery != null && contentQuery.size() > 0) {
								JSONArray wechatList = contentQuery.getJSONArray("wechatCustomerList");
								if (wechatList != null && wechatList.size() > 0) {
									JSONObject jsonTemp = wechatList.getJSONObject(0);
									id = jsonTemp.getString("id");
								}
							}
						}
						
						//根据微信用户表主键id更新基本信息
						if(!"0".equals(id)){
							String reqmsg = "{\"action\":\"ADD_WECHAT_CUSTOMER_INFO_REQUEST\",\"content\":{";
							reqmsg += "\"id\":" + id + ",";
							reqmsg += "\"nakeName\":\"" + nickname + "\",";
							reqmsg += "\"gender\":" + getSex(sex) + ",";
							reqmsg += "\"country\":\"" + country + "\",";
							reqmsg += "\"province\":\"" + province + "\",";
							reqmsg += "\"city\":\"" + city + "\",";
							//reqmsg += "\"photoUrl\":\"" + headimgurl + "\"";
							reqmsg += "}}";
							
							String ifFinish = SignUtil.doHttpPost(SignUtil.handlerurl + "/wechatCustomer.do?handlerWechat",reqmsg);
							Map reqParams = JsonUtil.getMap4Json(ifFinish);
							String result = (String) reqParams.get("result");
							if(result.equals("100")){
								logger.debug(nickname + "   " + FromUserName +"   更新用户最新信息成功");
							}else{
								logger.debug(nickname + "   " + FromUserName +"   更新用户最新信息失败");
							}
						}else{
							logger.debug(nickname + "   " + FromUserName +"   更新用户最新信息失败");
						}
					}
					logger.debug(FromUserName +"   微信 更新用户最新信息");
				}
				if(Event.equals("unsubscribe")){//取消关注
					logger.debug(FromUserName +"   微信 取消关注成功");
				}
			}
			//用户输入消息-介绍码
			if (MsgType.equals("text")) {
				if (Content != null && !"".equals(Content)) {
					if (Content.length() == 7) {
						if ("邀请码".equals(Content.substring(0,3))) {
							String invitationCode = Content.substring(3,7);
							String access_token =  SystemInit.access_token;
							String message = SignUtil.getUrl("https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + access_token + "&openid=" + FromUserName + "&lang=zh_CN");	
							Map demoJson = JsonUtil.getMap4Json(message);
							if (demoJson != null) {
								String openid = (String) demoJson.get("openid");
								
								String introduceCode = "";
								
								//根据openid获取用户id
								String reqmsgQuery = "{\"action\":\"QUERY_WECHAT_CUSTOMER_LIST_REQUEST\",\"page\":{\"pageno\":\"1\",\"pagesize\":\"1\"},\"content\":{\"openId\":\"" + openid + "\"}}";
								String queryId = SignUtil.doHttpPost(SignUtil.handlerurl + "/wechatCustomer.do?handlerWechat",reqmsgQuery);
								Map reqParamsQueryId = JsonUtil.getMap4Json(queryId);
								String resultQuery = (String) reqParamsQueryId.get("result");
								String id = "0";
								if(resultQuery.equals("100")){
									JSONObject contentQuery = (JSONObject) reqParamsQueryId.get("content");
									if (contentQuery != null && contentQuery.size() > 0) {
										JSONArray wechatList = contentQuery.getJSONArray("wechatCustomerList");
										if (wechatList != null && wechatList.size() > 0) {
											JSONObject jsonTemp = wechatList.getJSONObject(0);
											id = jsonTemp.getString("id");
											introduceCode = jsonTemp.getString("introduceCode");
										}
									}
								}
								
								if (introduceCode != null && !"".equals(introduceCode)) {//判断介绍码是否已存在，已存在则退出
									huifuString = XMLUtil.formatXmlAnswer(FromUserName,ToUserName,"对不起，您已填写过邀请码了！");
									OutputStream os = response.getOutputStream();
									os.write(huifuString.getBytes("UTF-8"));
									return;
								}
								
								//根据微信用户表主键id更新基本信息
								if(!"0".equals(id)){
									String reqmsg = "{\"action\":\"ADD_WECHAT_CUSTOMER_INFO_REQUEST\",\"content\":{";
									reqmsg += "\"id\":" + id + ",";
									reqmsg += "\"introduceCode\":\"" + invitationCode + "\",";
									reqmsg += "}}";
									
									String ifFinish = SignUtil.doHttpPost(SignUtil.handlerurl + "/wechatCustomer.do?handlerWechat",reqmsg);
									Map reqParams = JsonUtil.getMap4Json(ifFinish);
									String result = (String) reqParams.get("result");
									if(result.equals("100")){
										huifuString = XMLUtil.formatXmlAnswer(FromUserName,ToUserName,"邀请码填写录入成功！");
										OutputStream os = response.getOutputStream();
										os.write(huifuString.getBytes("UTF-8"));
									}
								}
							}
						} else {
							huifuString = XMLUtil.formatXmlAnswer(FromUserName,ToUserName,"邀请码格式错误，应为：邀请码XXXX");
							OutputStream os = response.getOutputStream();
							os.write(huifuString.getBytes("UTF-8"));
						}
					} else {
						huifuString = XMLUtil.formatXmlAnswer(FromUserName,ToUserName,"邀请码格式错误，应为：邀请码XXXX");
						OutputStream os = response.getOutputStream();
						os.write(huifuString.getBytes("UTF-8"));
					}
				}
			}
		} catch (Exception e) {
			logger.debug("微信关注和取消关注入口出错    " + e.toString());
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取设备类型
	 * 
	 * @return 名称
	 */
	public static String getSex(Integer id) {
		String name = "";
		if (id == null || id == 0) {
			return name;
		}
		switch (id) {
		case 1:
			name = "1";//男
			break;
		case 2:
			name = "0";//女
			break;
		default:
			name = "0";
			break;
		}
		return name;
	}
}
