package mis.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.OrderEntity;
import mis.pack.OrderPack;
import mis.parse.OrderParse;
import mis.service.OrderService;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;

/**
 * @Title: Handler
 * @Description: 订单表业务处理器
 * @author feng.gu
 * @date 2017-04-21 16:39:13
 * @version V1.0
 * 
 */
public class OrderHandler extends BaseHandler {
	private static Logger logger = Logger.getLogger(OrderService.class);
	/**
	 * 解析器
	 */
	private OrderParse orderParse = OrderParse.getInstance();
	/**
	 * 业务处理器
	 */
	private OrderService orderService = OrderService.getInstance();
	/**
	 * 封装器
	 */
	private OrderPack orderPack = OrderPack.getInstance();

	private static OrderHandler orderHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static OrderHandler getInstance() {
		if (orderHandler == null) {
			orderHandler = new OrderHandler();
		}
		return orderHandler;
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
			Map<String, Object> parseMap = orderParse.parse(type, command,
					reqStr, request);
			String action = (String) parseMap.get("action");
			OrderEntity order = (OrderEntity) parseMap.get("order");
			List<OrderEntity> orderList = (List<OrderEntity>) parseMap
					.get("orderList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");

			List<OrderVO> ordervo = (List<OrderVO>) parseMap.get("orderList");
			
			Boolean delChildOrderList = (Boolean) parseMap
					.get("delChildOrderList");
			Boolean servicePersonShow = (Boolean) parseMap
					.get("servicePersonShow");
			Boolean delServicePerson = (Boolean) parseMap
					.get("delServicePerson");
			Boolean medicalReportShow = (Boolean) parseMap
					.get("medicalReportShow");
			Boolean delMedicalReport = (Boolean) parseMap
					.get("delMedicalReport");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				result = orderService.save(order);
			} else if ("saveList".equals(action)) {
				result = orderService.saveList(orderList);
			} else if ("getById".equals(action)) {
				result = orderService.getById(id, servicePersonShow, medicalReportShow);
			} else if ("getListByCondition".equals(action)) {
				result = orderService.getListByCondition(queryMap, ordervo,
						pageno, pagesize, servicePersonShow, medicalReportShow);
			} else if ("del".equals(action)) {
				result = orderService.del(id, delServicePerson, delMedicalReport);
			} else if ("delList".equals(action)) {
				result = orderService.delList(queryMap, delServicePerson, delMedicalReport);
			}
			// 封装
			Map<String, Object> packMap = orderPack.pack(type, action, result,
					order);
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
