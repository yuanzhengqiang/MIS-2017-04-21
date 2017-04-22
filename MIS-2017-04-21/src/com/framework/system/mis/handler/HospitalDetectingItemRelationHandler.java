package com.framework.system.mis.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;
import com.framework.system.mis.entity.HospitalDetectingItemRelationEntity;
import com.framework.system.mis.pack.HospitalDetectingItemRelationPack;
import com.framework.system.mis.parse.HospitalDetectingItemRelationParse;
import com.framework.system.mis.service.HospitalDetectingItemRelationService;

/**
 * @Title: Handler
 * @Description: 医院体检项目关系表业务处理器
 * @author feng.gu
 * @date 2017-04-21 17:12:18
 * @version V1.0
 * 
 */
public class HospitalDetectingItemRelationHandler extends BaseHandler {
	private static Logger logger = Logger
			.getLogger(HospitalDetectingItemRelationService.class);
	/**
	 * 解析器
	 */
	private HospitalDetectingItemRelationParse hospitalDetectingItemRelationParse = HospitalDetectingItemRelationParse
			.getInstance();
	/**
	 * 业务处理器
	 */
	private HospitalDetectingItemRelationService hospitalDetectingItemRelationService = HospitalDetectingItemRelationService
			.getInstance();
	/**
	 * 封装器
	 */
	private HospitalDetectingItemRelationPack hospitalDetectingItemRelationPack = HospitalDetectingItemRelationPack
			.getInstance();

	private static HospitalDetectingItemRelationHandler hospitalDetectingItemRelationHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static HospitalDetectingItemRelationHandler getInstance() {
		if (hospitalDetectingItemRelationHandler == null) {
			hospitalDetectingItemRelationHandler = new HospitalDetectingItemRelationHandler();
		}
		return hospitalDetectingItemRelationHandler;
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
			Map<String, Object> parseMap = hospitalDetectingItemRelationParse
					.parse(type, command, reqStr, request);
			String action = (String) parseMap.get("action");
			HospitalDetectingItemRelationEntity hospitalDetectingItemRelation = (HospitalDetectingItemRelationEntity) parseMap
					.get("hospitalDetectingItemRelation");
			List<HospitalDetectingItemRelationEntity> hospitalDetectingItemRelationList = (List<HospitalDetectingItemRelationEntity>) parseMap
					.get("hospitalDetectingItemRelationList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");

			Boolean hospitalEntityShow = (Boolean) parseMap
					.get("hospitalEntityShow");
			Boolean delHospitalEntity = (Boolean) parseMap
					.get("delHospitalEntity");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				result = hospitalDetectingItemRelationService
						.save(hospitalDetectingItemRelation);
			} else if ("saveList".equals(action)) {
				result = hospitalDetectingItemRelationService
						.saveList(hospitalDetectingItemRelationList);
			} else if ("getById".equals(action)) {
				result = hospitalDetectingItemRelationService.getById(id,
						hospitalEntityShow);
			} else if ("getListByCondition".equals(action)) {
				// // 根据数据权限 增加查询条件
				// queryMap = systemService.addDataRuleByRoles(
				// "HospitalDetectingItemRelationEntity", queryMap,
				// request);
				// result = hospitalDetectingItemRelationService
				// .getListByCondition(queryMap, orderList, pageno,
				// pagesize, hospitalEntityShow);
			} else if ("del".equals(action)) {
				result = hospitalDetectingItemRelationService.del(id,
						delHospitalEntity);
			} else if ("delList".equals(action)) {
				result = hospitalDetectingItemRelationService.delList(queryMap,
						delHospitalEntity);
			}
			// 封装
			Map<String, Object> packMap = hospitalDetectingItemRelationPack
					.pack(type, action, result, hospitalDetectingItemRelation);
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
