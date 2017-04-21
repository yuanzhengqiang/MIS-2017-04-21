package weixin.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sbtj.util.CodeCreateUtil;
import weixin.tools.MD5Util;
import weixin.tools.SignUtil;
import weixin.tools.WXUtil;

@RequestMapping("/wechatYuE")
@Controller
public class WeinxinYuEController {

	private static Logger logger = Logger
			.getLogger(WeinxinYuEController.class);
	
	/**
	 * 余额页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "mainBalance")
	public ModelAndView centerBalance(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/weixin/weixinBalance/weixinBalance");
		String olderId = request.getParameter("olderId");
		mav.addObject("olderId", olderId);
		return mav;
	}
	
	/**
	 * 充值页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "mainRecharge")
	public ModelAndView centerRecharge(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/weixin/weixinBalance/weixinRecharge");
		String olderId = request.getParameter("olderId");
		mav.addObject("olderId", olderId);
		return mav;
	}
	
	/**
	 * 明细页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "mainMoneyDetails")
	public ModelAndView centerMoneyDetails(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/weixin/weixinBalance/weixinMoneyDetails");
		String olderId = request.getParameter("olderId");
		mav.addObject("olderId", olderId);
		return mav;
	}
	
	/**
	 * 支付页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "mainPay")
	public ModelAndView centerPay(HttpServletRequest request,HttpServletResponse response) throws Exception {  
			ModelAndView mav = new ModelAndView("/weixin/weixinBalance/weixinPay");
			
			String olderId = request.getParameter("olderId");
			String total_feeForDB = request.getParameter("total_fee");
			String total_fee = request.getParameter("total_fee");
			total_fee = (Double.parseDouble(total_fee)*100) + "";
			total_fee = total_fee.substring(0, total_fee.lastIndexOf("."));
			
			String openid = "";
			if(request.getSession().getAttribute("weixinopenid") != null && !"".equals(request.getSession().getAttribute("weixinopenid"))){
				openid = (String)request.getSession().getAttribute("weixinopenid");
			}else{
				return null;
			}
			logger.debug("微信获取openid------值 " + openid);  
			
		
	        //接收财付通通知的URL  
	        //String notify_url = SignUtil.payNotifyUrl + "&olderId=" + olderId + "&total_fee=" + total_fee;  
			String notify_url = SignUtil.payNotifyUrl;
					
					
	        //---------------生成订单号 开始------------------------ 
	        String out_trade_no =  CodeCreateUtil.creatrechargeNum();
	        logger.debug("微信获取out_trade_no------值 " + out_trade_no);  
	        //---------------生成订单号 结束------------------------  
	  
	        if (!"".equals(openid)) {  
	        	String noncestr = WXUtil.getNonceStr();  
	        	
	        	//生成获取预支付签名  
	        	SortedMap<Object,Object> parameters = new TreeMap<Object,Object>(); 
	        	parameters.put("body", "福寿康居家康复护理机构-余额充值"); //商品描述 
	            parameters.put("appid", SignUtil.APPID);  
	            parameters.put("mch_id", SignUtil.PARTNER); //商户号      
	            parameters.put("nonce_str", noncestr); 
	            parameters.put("notify_url", notify_url); //接收财付通通知的URL  
	            parameters.put("openid", openid); 
	            parameters.put("out_trade_no", out_trade_no); //商家订单号     
	            parameters.put("spbill_create_ip",request.getRemoteAddr()); //订单生成的机器IP，指用户浏览器端IP 
	            parameters.put("total_fee", total_fee); //商品金额,以分为单位 
	            parameters.put("trade_type", "JSAPI");
	            String mySign = createSign("UTF-8",parameters);//签名
	            logger.debug("微信获取mySign------值 " + mySign);  
	            
	            /*------5.生成需要提交给统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder 的xml数据-------*/
	            String xml="<xml>"+
	                    "<appid>" + SignUtil.APPID + "</appid>"+
	                    "<mch_id>"+ SignUtil.PARTNER+"</mch_id>"+
	                    "<nonce_str>"+noncestr+"</nonce_str>"+
	                    "<sign>"+mySign+"</sign>"+
	                    "<body><![CDATA[福寿康居家康复护理机构-余额充值]]></body>"+
	                    "<out_trade_no>"+out_trade_no+"</out_trade_no>"+
	                    "<total_fee>"+total_fee+"</total_fee>"+
	                    "<spbill_create_ip>"+request.getRemoteAddr()+"</spbill_create_ip>"+
	                    "<notify_url>"+notify_url+"</notify_url>"+
	                    "<trade_type>JSAPI</trade_type>"+
	                    "<openid>"+openid+"</openid>"+
	                    "</xml>";
	            logger.debug("微信获取prepay_id-xml " + xml);  
	            
	            /*------6.调用统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder 生产预支付订单----------*/
	            String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	            String prepay_id="";
	            try {
	            	String XMLResult = SignUtil.doHttpPost_weixin(createOrderURL, xml);
	            	logger.debug("微信-XMLResult" + XMLResult);  
	                Document document = DocumentHelper.parseText(XMLResult);
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
	    							if(e.getName().equals("prepay_id")){
	    								prepay_id = e.getText();
	    							}
	    						}
	    					}
	    				}
	    			}
	                logger.debug("获取prepayid------值 " + prepay_id);  
	            } catch (Exception e) {
	                logger.debug("统一支付接口获取预支付订单出错", e);
	            }
	            
	            //获取package包  
	            String packageValue = "prepay_id=" + prepay_id;
	            logger.debug("获取package------值 " + packageValue);  
	  
	            
	            //封装h5页面调用参数//////////////////////////////////
	            String timestamp = WXUtil.getTimeStamp();
	            
	            //获取新签名
	            SortedMap<Object,Object> parameters2 = new TreeMap<Object,Object>(); 
	            parameters2.put("appId", SignUtil.APPID);  
	            parameters2.put("timeStamp", timestamp); 
	            parameters2.put("nonceStr", noncestr); 
	            parameters2.put("package", packageValue); 
	            parameters2.put("signType", "MD5"); 
	        	String sign = createSign("UTF-8",parameters2);//签名
	        	
	        	mav.addObject("appId", SignUtil.APPID);
				mav.addObject("timeStamp", timestamp);
				mav.addObject("nonceStr", noncestr);
				mav.addObject("pg", packageValue);
				mav.addObject("paySign", sign);
				mav.addObject("olderId", olderId);
				mav.addObject("total_fee", total_feeForDB);
				mav.addObject("out_trade_no", out_trade_no);
				mav.addObject("result", "100");
	        }else{
	        	mav.addObject("result", "200");
	        }
			return mav;
	}
	
	/**
	 * 支付回调页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "mpayNotify")
	public void payNotify(HttpServletRequest request, HttpServletResponse response) {
		String out_trade_no=null;
	    String return_code =null;
	    try {
	        InputStream inStream = request.getInputStream();
	        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = inStream.read(buffer)) != -1) {
	            outSteam.write(buffer, 0, len);
	        }
	        outSteam.close();
	        inStream.close();
	        String resultStr  = new String(outSteam.toByteArray(),"utf-8");
	        logger.debug("支付成功的回调："+resultStr);
	        Map<String, Object> resultMap = parseXmlToList(resultStr);
	        String result_code = (String) resultMap.get("result_code");
	        String is_subscribe = (String) resultMap.get("is_subscribe");
	        String transaction_id = (String) resultMap.get("transaction_id");
	        String sign = (String) resultMap.get("sign");
	        String time_end = (String) resultMap.get("time_end");
	        String bank_type = (String) resultMap.get("bank_type");

	        out_trade_no = (String) resultMap.get("out_trade_no");
	        return_code = (String) resultMap.get("return_code");

	        request.setAttribute("out_trade_no", out_trade_no);
	        //通知微信.异步确认成功.必写.不然微信会一直通知后台.八次之后就认为交易失败了.
	        response.getWriter().write(setXML("SUCCESS", ""));
	    }  catch (Exception e) {
	        logger.error("微信回调接口出现错误：",e);
	        try {
	            response.getWriter().write(setXML("FAIL", "error"));
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    } 
	    if(return_code.equals("SUCCESS")){
	        //支付成功的业务逻辑
	    	logger.debug("支付成功的业务逻辑......");
	    	/*String olderId = request.getParameter("olderId");
			String total_fee = request.getParameter("total_fee");
	    	String reqmsg = "{'action':'ADD_OLDER_INFO_REQUEST','content':{";	
	    	reqmsg += "\"id\":" + olderId + ",";
	    	reqmsg += "\"accountNumType\":\"add\",";
	    	reqmsg += "\"accountNum\":" + total_fee + ",";
	    	reqmsg += "}}";
			
			String ifFinish = SignUtil.doHttpPost(SignUtil.handlerurl + "/addOlders.do?handler",reqmsg);
			Map reqParams = JsonUtil.getMap4Json(ifFinish);
			String result = (String) reqParams.get("result");*/
	    	
	    }else{
	        //支付失败的业务逻辑
	    }
	}
	
	 
    private static Map parseXmlToList(String xml) {
        Map retMap = new HashMap();
        try {
            Document document = DocumentHelper.parseText(xml);
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
							retMap.put(e.getName(), e.getText());
						}
					}
				}
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retMap;
    }
    
	 /** 
     * 微信支付签名算法sign 
     * @param characterEncoding 
     * @param parameters 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){  
        StringBuffer sb = new StringBuffer();  
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）  
        Iterator it = es.iterator();  
        while(it.hasNext()) {  
            Map.Entry entry = (Map.Entry)it.next();  
            String k = (String)entry.getKey();  
            Object v = entry.getValue();  
            if(null != v && !"".equals(v)   
                    && !"sign".equals(k) && !"key".equals(k)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
        sb.append("key=" + SignUtil.PARTNER_KEY);  
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();  
        return sign;  
    }  
    
    public static String setXML(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code
                + "]]></return_code><return_msg><![CDATA[" + return_msg
                + "]]></return_msg></xml>";
	}
}
