package mis.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.HospitalDetectingItemRelationEntity;
import mis.entity.HospitalEntity;
import mis.pack.HospitalPack;
import mis.parse.HospitalParse;
import mis.service.HospitalDetectingItemRelationService;
import mis.service.HospitalService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.manager.DBManager;
import com.framework.system.db.query.OrderVO;
import com.framework.system.db.query.QueryCondition;

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

	private DBManager dbManager = DBManager.getInstance();

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
			ArrayList<HospitalDetectingItemRelationEntity> hospitalMedicalItemList = (ArrayList<HospitalDetectingItemRelationEntity>) parseMap
					.get("hospitalMedicalItemList");
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
				/** 删除当前医院已经关联的体检项目关系 */
				QueryCondition qcdel = new QueryCondition(
						HospitalDetectingItemRelationEntity.HOSPITAL_ID,
						QueryCondition.eq, hospital.getId());
				dbManager.delByConditions(HospitalDetectingItemRelationEntity.class, qcdel);
				/** 如果没有体检项目的 list 说明没有关联体检项目 */
				if (hospitalMedicalItemList != null
						&& hospitalMedicalItemList.size() > 0) {
					for (int index = 0; index < hospitalMedicalItemList.size(); index++) {
						hospitalMedicalItemList.get(index).setHospitalId(hospital.getId());
					}
					HospitalDetectingItemRelationService.getInstance()
							.saveList(hospitalMedicalItemList);
				} else {
					QueryCondition qc = new QueryCondition(
							HospitalDetectingItemRelationEntity.HOSPITAL_ID,
							QueryCondition.eq, id);
					dbManager.delByConditions(HospitalDetectingItemRelationEntity.class, qc);
				}
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
		System.out.println(resultStr);
		return resultStr;
	}

	public static void main(String[] argv) {
		// JSONArray jarr = new JSONArray();
		// JSONObject jobj1 = new JSONObject();
		// jobj1.put("asdf", "qwer");
		// jarr.add(jobj1);
		// JSONObject jobj2 = new JSONObject();
		// jobj2.put("zxcv", "zxcv");
		// jarr.add(jobj2);
		String str = "[{\"asdf\":\"qwer\"},{\"zxcv\":\"zxcv\"}]";
		JSONArray jar = JSONArray.fromObject(str);
		System.out.println(((JSONObject) jar.get(0)).get("asdf"));
	}

}
