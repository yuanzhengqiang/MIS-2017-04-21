package mis.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.WechatCustomerEntity;
import mis.pack.WechatCustomerPack;
import mis.parse.WechatCustomerParse;
import mis.service.WechatCustomerService;
import mis.utils.RandomNum;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import weixin.tools.SignUtil;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;
import com.framework.system.util.JsonUtil;

/**
 * @Title: Handler
 * @Description: 微信客户表业务处理器
 * @author feng.gu
 * @date 2017-04-21 17:29:44
 * @version V1.0
 * 
 */
public class WechatCustomerHandler extends BaseHandler {
	private static Logger logger = Logger
			.getLogger(WechatCustomerService.class);
	/**
	 * 解析器
	 */
	private WechatCustomerParse wechatCustomerParse = WechatCustomerParse
			.getInstance();
	/**
	 * 业务处理器
	 */
	private WechatCustomerService wechatCustomerService = WechatCustomerService
			.getInstance();
	/**
	 * 封装器
	 */
	private WechatCustomerPack wechatCustomerPack = WechatCustomerPack
			.getInstance();

	private static WechatCustomerHandler wechatCustomerHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static WechatCustomerHandler getInstance() {
		if (wechatCustomerHandler == null) {
			wechatCustomerHandler = new WechatCustomerHandler();
		}
		return wechatCustomerHandler;
	}

	/**
	 * 
	 * @param type
	 *            1-json 2-xml
	 * @param entityName
	 * @param command
	 * @param reqStr
	 * @param request
	 * @param response
	 */
	public String doHandler(int type, String command, String reqStr,
			HttpServletRequest request, HttpServletResponse response) {
		logger.debug("请求消息：" + reqStr);
		String resultStr = "";
		try {
			// 解析
			Map<String, Object> parseMap = wechatCustomerParse.parse(type,
					command, reqStr, request);
			String action = (String) parseMap.get("action");
			WechatCustomerEntity wechatCustomer = (WechatCustomerEntity) parseMap
					.get("wechatCustomer");
			List<WechatCustomerEntity> wechatCustomerList = (List<WechatCustomerEntity>) parseMap
					.get("wechatCustomerList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				WechatCustomerEntity temp = null;
				/** 编辑 */
				if (wechatCustomer.getId() != null) {
					temp = wechatCustomerService.getById(wechatCustomer.getId());
					if (wechatCustomer.getCity() != null)
						temp.setCity(wechatCustomer.getCity());
					if (wechatCustomer.getCountry() != null)
						temp.setCountry(wechatCustomer.getCountry());
					if (wechatCustomer.getGender() != null)
						temp.setGender(wechatCustomer.getGender());
					if (wechatCustomer.getNakeName() != null)
						temp.setNakeName(wechatCustomer.getNakeName());
					if (wechatCustomer.getNoteName() != null)
						temp.setNoteName(wechatCustomer.getNoteName());
					if (wechatCustomer.getProvince() != null)
						temp.setProvince(wechatCustomer.getProvince());
					if (wechatCustomer.getUpdateTime() != null)
						temp.setUpdateTime(wechatCustomer.getUpdateTime());
					if (wechatCustomer.getIntroduceCode() != null) {
						/** 判断邀请码是否存在 */
						Map<String, Object> _querymap_ = new HashMap<String, Object>();
						_querymap_.put("inviteCode", wechatCustomer.getIntroduceCode());
						List<WechatCustomerEntity> _list_ = WechatCustomerService.getInstance().getListByCondition(_querymap_);
						if (_list_ != null && _list_.size() > 0) {
							temp.setIntroduceCode(wechatCustomer.getIntroduceCode());
						}
					}
				} else {
					/** 首先判断是否已经关注了 */
					if (wechatCustomer.getOpenId() != null && wechatCustomer.getOpenId().length() > 0) {
						Map<String, Object> qmap = new HashMap<String, Object>();
						qmap.put("openId", wechatCustomer.getOpenId());
						List<WechatCustomerEntity> _list_ = wechatCustomerService.getListByCondition(qmap);
						if (_list_ != null && _list_.size() > 0) {
							temp = _list_.get(0);
							wechatCustomer.setId(temp.getId());
						}
						wechatCustomer.setInviteCode(RandomNum.generate4HexString());
						temp = wechatCustomer;
					}
				}
				result = wechatCustomerService.save(temp);
			} else if ("saveList".equals(action)) {
				result = wechatCustomerService.saveList(wechatCustomerList);
			} else if ("getById".equals(action)) {
				result = wechatCustomerService.getById(id);
			} else if ("getListByCondition".equals(action)) {
				result = wechatCustomerService.getListByCondition(queryMap,
						orderList, pageno, pagesize);
			} else if ("del".equals(action)) {
				result = wechatCustomerService.del(id);
			} else if ("delList".equals(action)) {
				result = wechatCustomerService.delList(queryMap);
			}
			// 封装
			Map<String, Object> packMap = wechatCustomerPack.pack(type, action,
					result, wechatCustomer);
			String actionBack = (String) packMap.get("action");
			String resultBack = (String) packMap.get("result");
			String desBack = (String) packMap.get("des");
			JSONObject pageBack = (JSONObject) packMap.get("page");
			JSONObject contentBack = (JSONObject) packMap.get("content");

			JSONObject repJson = new JSONObject();
			if (actionBack != null && !"".equals(actionBack)) {
				repJson.put("action", actionBack);
			}
			if (resultBack != null && !"".equals(resultBack)) {
				repJson.put("result", resultBack);
			}
			if (desBack != null && !"".equals(desBack)) {
				repJson.put("des", desBack);
			}
			if (pageBack != null) {
				repJson.put("page", pageBack);
			}
			if (contentBack != null && !"".equals(contentBack)) {
				repJson.put("content", contentBack);
			}
			logger.debug("返回消息：" + repJson.toString());
			resultStr = repJson.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		return resultStr;
	}
	
	public static void main(String[] argv) {
		String reqmsg = "{\"action\":\"ADD_WECHAT_CUSTOMER_INFO_REQUEST\",\"content\":{\"openId\":\"oNSHgwbWIaXnG55G84URbT0sJZqQ\",\"nakeName\":\"张大大大虾\",\"gender\":1,\"country\":\"中国\",\"province\":\"江苏\",\"city\":\"苏州\",\"updateTime\":\"20170503234931\"}}";
		String ifFinish = SignUtil.doHttpPost("http://localhost:8080/MIS-2017-04-21/wechatCustomer.do?handlercontent",reqmsg);
//		System.out.println(ifFinish);
		Map reqParams = JsonUtil.getMap4Json(ifFinish);
		String result = (String) reqParams.get("result");
		System.out.println(result);
	}
}
