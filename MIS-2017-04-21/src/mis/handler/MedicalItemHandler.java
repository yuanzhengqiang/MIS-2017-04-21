package mis.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.MedicalItemEntity;
import mis.pack.MedicalItemPack;
import mis.parse.MedicalItemParse;
import mis.service.MedicalItemService;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;

/**
 * @Title: Handler
 * @Description: 体检项目表业务处理器
 * @author feng.gu
 * @date 2017-04-21 16:09:59
 * @version V1.0
 * 
 */
public class MedicalItemHandler extends BaseHandler {
	private static Logger logger = Logger.getLogger(MedicalItemService.class);
	/**
	 * 解析器
	 */
	private MedicalItemParse medicalItemParse = MedicalItemParse.getInstance();
	/**
	 * 业务处理器
	 */
	private MedicalItemService medicalItemService = MedicalItemService
			.getInstance();
	/**
	 * 封装器
	 */
	private MedicalItemPack medicalItemPack = MedicalItemPack.getInstance();

	private static MedicalItemHandler medicalItemHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static MedicalItemHandler getInstance() {
		if (medicalItemHandler == null) {
			medicalItemHandler = new MedicalItemHandler();
		}
		return medicalItemHandler;
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
			Map<String, Object> parseMap = medicalItemParse.parse(type,
					command, reqStr, request);
			String action = (String) parseMap.get("action");
			MedicalItemEntity medicalItem = (MedicalItemEntity) parseMap
					.get("medicalItem");
			List<MedicalItemEntity> medicalItemList = (List<MedicalItemEntity>) parseMap
					.get("medicalItemList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				result = medicalItemService.save(medicalItem);
			} else if ("saveList".equals(action)) {
				result = medicalItemService.saveList(medicalItemList);
			} else if ("getById".equals(action)) {
				result = medicalItemService.getById(id);
			} else if ("getListByCondition".equals(action)) {
				// // 根据数据权限 增加查询条件
				// queryMap = systemService.addDataRuleByRoles(
				// "MedicalItemEntity", queryMap, request);
				// result = medicalItemService.getListByCondition(queryMap,
				// orderList, pageno, pagesize);
			} else if ("del".equals(action)) {
				result = medicalItemService.del(id);
			} else if ("delList".equals(action)) {
				result = medicalItemService.delList(queryMap);
			}
			// 封装
			Map<String, Object> packMap = medicalItemPack.pack(type, action,
					result, medicalItem);
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
