package com.framework.system.mis.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;
import com.framework.system.mis.entity.MedicalReportEntity;
import com.framework.system.mis.pack.MedicalReportPack;
import com.framework.system.mis.parse.MedicalReportParse;
import com.framework.system.mis.service.MedicalReportService;

/**
 * @Title: Handler
 * @Description: 体检记录表业务处理器
 * @author feng.gu
 * @date 2017-04-21 16:18:36
 * @version V1.0
 * 
 */
public class MedicalReportHandler extends BaseHandler {
	private static Logger logger = Logger.getLogger(MedicalReportService.class);
	/**
	 * 解析器
	 */
	private MedicalReportParse medicalReportParse = MedicalReportParse
			.getInstance();
	/**
	 * 业务处理器
	 */
	private MedicalReportService medicalReportService = MedicalReportService
			.getInstance();
	/**
	 * 封装器
	 */
	private MedicalReportPack medicalReportPack = MedicalReportPack
			.getInstance();

	private static MedicalReportHandler medicalReportHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static MedicalReportHandler getInstance() {
		if (medicalReportHandler == null) {
			medicalReportHandler = new MedicalReportHandler();
		}
		return medicalReportHandler;
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
			Map<String, Object> parseMap = medicalReportParse.parse(type,
					command, reqStr, request);
			String action = (String) parseMap.get("action");
			MedicalReportEntity medicalReport = (MedicalReportEntity) parseMap
					.get("medicalReport");
			List<MedicalReportEntity> medicalReportList = (List<MedicalReportEntity>) parseMap
					.get("medicalReportList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				result = medicalReportService.save(medicalReport);
			} else if ("saveList".equals(action)) {
				result = medicalReportService.saveList(medicalReportList);
			} else if ("getById".equals(action)) {
				result = medicalReportService.getById(id);
			} else if ("getListByCondition".equals(action)) {
				// // 根据数据权限 增加查询条件
				// queryMap = systemService.addDataRuleByRoles(
				// "MedicalReportEntity", queryMap, request);
				// result = medicalReportService.getListByCondition(queryMap,
				// orderList, pageno, pagesize);
			} else if ("del".equals(action)) {
				result = medicalReportService.del(id);
			} else if ("delList".equals(action)) {
				result = medicalReportService.delList(queryMap);
			}
			// 封装
			Map<String, Object> packMap = medicalReportPack.pack(type, action,
					result, medicalReport);
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
