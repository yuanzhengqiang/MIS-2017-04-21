package mis.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.HospitalEntity;
import mis.pack.HospitalPack;
import mis.parse.HospitalParse;
import mis.service.HospitalService;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;

/**
 * @Title: Handler
 * @Description: 医院表业务处理器
 * @author feng.gu
 * @date 2017-04-21 17:05:03
 * @version V1.0
 * 
 */
public class HospitalHandler extends BaseHandler {
	private static Logger logger = Logger.getLogger(HospitalService.class);
	/**
	 * 解析器
	 */
	private HospitalParse hospitalParse = HospitalParse.getInstance();
	/**
	 * 业务处理器
	 */
	private HospitalService hospitalService = HospitalService.getInstance();
	/**
	 * 封装器
	 */
	private HospitalPack hospitalPack = HospitalPack.getInstance();

	private static HospitalHandler hospitalHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static HospitalHandler getInstance() {
		if (hospitalHandler == null) {
			hospitalHandler = new HospitalHandler();
		}
		return hospitalHandler;
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
			Map<String, Object> parseMap = hospitalParse.parse(type, command,
					reqStr, request);
			String action = (String) parseMap.get("action");
			HospitalEntity hospital = (HospitalEntity) parseMap.get("hospital");
			List<HospitalEntity> hospitalList = (List<HospitalEntity>) parseMap
					.get("hospitalList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");

			Boolean areaEntityShow = (Boolean) parseMap.get("areaEntityShow");
			Boolean delAreaEntity = (Boolean) parseMap.get("delAreaEntity");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				result = hospitalService.save(hospital);
			} else if ("saveList".equals(action)) {
				result = hospitalService.saveList(hospitalList);
			} else if ("getById".equals(action)) {
				result = hospitalService.getById(id, areaEntityShow);
			} else if ("getListByCondition".equals(action)) {
				 result = hospitalService.getListByCondition(queryMap,
				 orderList, pageno, pagesize, areaEntityShow);
			} else if ("del".equals(action)) {
				result = hospitalService.del(id, delAreaEntity);
			} else if ("delList".equals(action)) {
				result = hospitalService.delList(queryMap, delAreaEntity);
			}
			// 封装
			Map<String, Object> packMap = hospitalPack.pack(type, action,
					result, hospital);
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
