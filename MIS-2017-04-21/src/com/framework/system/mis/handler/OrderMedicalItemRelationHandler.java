package com.framework.system.mis.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;
import com.framework.system.mis.entity.OrderMedicalItemRelationEntity;
import com.framework.system.mis.pack.OrderMedicalItemRelationPack;
import com.framework.system.mis.parse.OrderMedicalItemRelationParse;
import com.framework.system.mis.service.OrderMedicalItemRelationService;

/**
 * @Title: Handler
 * @Description: 订单体检项目关系表业务处理器
 * @author feng.gu
 * @date 2017-04-21 17:23:21
 * @version V1.0
 * 
 */
public class OrderMedicalItemRelationHandler extends BaseHandler {
	private static Logger logger = Logger
			.getLogger(OrderMedicalItemRelationService.class);
	/**
	 * 解析器
	 */
	private OrderMedicalItemRelationParse orderMedicalItemRelationParse = OrderMedicalItemRelationParse
			.getInstance();
	/**
	 * 业务处理器
	 */
	private OrderMedicalItemRelationService orderMedicalItemRelationService = OrderMedicalItemRelationService
			.getInstance();
	/**
	 * 封装器
	 */
	private OrderMedicalItemRelationPack orderMedicalItemRelationPack = OrderMedicalItemRelationPack
			.getInstance();

	private static OrderMedicalItemRelationHandler orderMedicalItemRelationHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static OrderMedicalItemRelationHandler getInstance() {
		if (orderMedicalItemRelationHandler == null) {
			orderMedicalItemRelationHandler = new OrderMedicalItemRelationHandler();
		}
		return orderMedicalItemRelationHandler;
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
			Map<String, Object> parseMap = orderMedicalItemRelationParse.parse(
					type, command, reqStr, request);
			String action = (String) parseMap.get("action");
			OrderMedicalItemRelationEntity orderMedicalItemRelation = (OrderMedicalItemRelationEntity) parseMap
					.get("orderMedicalItemRelation");
			List<OrderMedicalItemRelationEntity> orderMedicalItemRelationList = (List<OrderMedicalItemRelationEntity>) parseMap
					.get("orderMedicalItemRelationList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");

			Boolean orderEntityShow = (Boolean) parseMap.get("orderEntityShow");
			Boolean delOrderEntity = (Boolean) parseMap.get("delOrderEntity");
			Boolean medicalItemShow = (Boolean) parseMap.get("medicalItemShow");
			Boolean delMedicalItem = (Boolean) parseMap.get("delMedicalItem");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				result = orderMedicalItemRelationService
						.save(orderMedicalItemRelation);
			} else if ("saveList".equals(action)) {
				result = orderMedicalItemRelationService
						.saveList(orderMedicalItemRelationList);
			} else if ("getById".equals(action)) {
				result = orderMedicalItemRelationService.getById(id,
						orderEntityShow, medicalItemShow);
			} else if ("getListByCondition".equals(action)) {
				// //根据数据权限 增加查询条件
				// queryMap =
				// systemService.addDataRuleByRoles("OrderMedicalItemRelationEntity",queryMap,request);
				// result =
				// orderMedicalItemRelationService.getListByCondition(queryMap,orderList,
				// pageno,
				// pagesize,orderEntityShow,medicalItemShow);
			} else if ("del".equals(action)) {
				result = orderMedicalItemRelationService.del(id,
						delOrderEntity, delMedicalItem);
			} else if ("delList".equals(action)) {
				result = orderMedicalItemRelationService.delList(queryMap,
						delOrderEntity, delMedicalItem);
			}
			// 封装
			Map<String, Object> packMap = orderMedicalItemRelationPack.pack(
					type, action, result, orderMedicalItemRelation);
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
