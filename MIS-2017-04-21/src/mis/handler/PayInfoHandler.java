package mis.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.PayInfoEntity;
import mis.pack.PayInfoPack;
import mis.parse.PayInfoParse;
import mis.service.PayInfoService;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;

/**
 * @Title: Handler
 * @Description: 支付信息表业务处理器
 * @author feng.gu
 * @date 2017-04-21 17:17:50
 * @version V1.0
 * 
 */
public class PayInfoHandler extends BaseHandler {
	private static Logger logger = Logger.getLogger(PayInfoService.class);
	/**
	 * 解析器
	 */
	private PayInfoParse payInfoParse = PayInfoParse.getInstance();
	/**
	 * 业务处理器
	 */
	private PayInfoService payInfoService = PayInfoService.getInstance();
	/**
	 * 封装器
	 */
	private PayInfoPack payInfoPack = PayInfoPack.getInstance();

	private static PayInfoHandler payInfoHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static PayInfoHandler getInstance() {
		if (payInfoHandler == null) {
			payInfoHandler = new PayInfoHandler();
		}
		return payInfoHandler;
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
			Map<String, Object> parseMap = payInfoParse.parse(type, command,
					reqStr, request);
			String action = (String) parseMap.get("action");
			PayInfoEntity payInfo = (PayInfoEntity) parseMap.get("payInfo");
			List<PayInfoEntity> payInfoList = (List<PayInfoEntity>) parseMap
					.get("payInfoList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");

			Boolean orderEntityShow = (Boolean) parseMap.get("orderEntityShow");
			Boolean delOrderEntity = (Boolean) parseMap.get("delOrderEntity");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				result = payInfoService.save(payInfo);
			} else if ("saveList".equals(action)) {
				result = payInfoService.saveList(payInfoList);
			} else if ("getById".equals(action)) {
				result = payInfoService.getById(id, orderEntityShow);
			} else if ("getListByCondition".equals(action)) {
				result = payInfoService.getListByCondition(queryMap, orderList,
						pageno, pagesize, orderEntityShow);
			} else if ("del".equals(action)) {
				result = payInfoService.del(id, delOrderEntity);
			} else if ("delList".equals(action)) {
				result = payInfoService.delList(queryMap, delOrderEntity);
			}
			// 封装
			Map<String, Object> packMap = payInfoPack.pack(type, action,
					result, payInfo);
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
}
