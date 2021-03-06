package mis.pack;

import java.util.HashMap;
import java.util.Map;

import mis.entity.HospitalEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.db.query.PageList;

/**
 * @Title: Pack
 * @Description: 医院表封装器
 * @author feng.gu
 * @date 2017-04-21 17:05:03
 * @version V1.0
 *
 */
public class HospitalPack {
	private static Logger logger = Logger.getLogger(HospitalPack.class);
	private static HospitalPack hospitalPack;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static HospitalPack getInstance() {
		if (hospitalPack == null) {
			hospitalPack = new HospitalPack();
		}
		return hospitalPack;
	}

	public Map<String, Object> pack(int type, String action, Object request,
			Object entity) {
		// 定义返回参数
		Map<String, Object> packMap = new HashMap<String, Object>();
		if (type == 1) {
			// json
			packMap = this.packByJson(action, request, entity);
		} else if (type == 2) {
			// xml
			packMap = this.packByXml(action, request, entity);
		}
		return packMap;
	}

	private Map<String, Object> packByJson(String action, Object request,
			Object entity) {
		// 定义返回参数
		Map<String, Object> packMap = new HashMap<String, Object>();
		String actionBack = null;
		String resultBack = null;
		String desBack = null;
		JSONObject pageBack = null;
		JSONObject contentBack = null;
		try {
			if ("save".equals(action)) {
				actionBack = "ADD_HOSPITAL_INFO_RESPONSE";
				if (request.equals(true)) {
					resultBack = "100";
					desBack = "success";
				} else if (request.equals(false)) {
					resultBack = "200";
					desBack = "failure";
				}
				HospitalEntity hospital = (HospitalEntity) entity;
				if (hospital != null) {
					contentBack = new JSONObject();
					contentBack.put("id", hospital.getId());

					if (hospital.getAreaEntity() != null) {
						contentBack.put("areaEntityId", hospital
								.getAreaEntity().getId());
					}
				}
			} else if ("getById".equals(action)) {
				actionBack = "QUERY_HOSPITAL_INFO_RESPONSE";
				resultBack = "100";
				desBack = "success";
				HospitalEntity hospital = (HospitalEntity) request;
				if (hospital != null) {
					contentBack = JSONObject.fromObject(hospital);
					if (hospital.getAreaEntity() != null) {
						contentBack
								.put("areaEntity", JSONObject
										.fromObject(hospital.getAreaEntity()));
					}
					if (hospital.getMedicalItemlist() != null) {
						contentBack.put("medicalItemlist", JSONArray.fromObject(hospital.getMedicalItemlist()));
					}
				}
			} else if ("getListByCondition".equals(action)) {
				actionBack = "QUERY_HOSPITAL_LIST_RESPONSE";
				resultBack = "100";
				desBack = "success";
				PageList pageList = (PageList) request;
				if (pageList != null && pageList.getResultList() != null
						&& pageList.getResultList().size() > 0) {
					contentBack = new JSONObject();
					pageBack = new JSONObject();
					JSONArray list = JSONArray.fromObject(pageList
							.getResultList());
					contentBack.put("hospitalList", list);

					pageBack.put("pageno", pageList.getPageno());
					pageBack.put("pagesize", pageList.getPagesize());
					pageBack.put("recordCount", pageList.getRecordCount());
					pageBack.put("pageCount", pageList.getPageCount());

				}
			} else if ("del".equals(action)) {
				actionBack = "DEL_HOSPITAL_INFO_REQUEST";
				if (request.equals(true)) {
					resultBack = "100";
					desBack = "success";
				} else if (request.equals(false)) {
					resultBack = "200";
					desBack = "failure";
				}
			} else if ("delList".equals(action)) {
				actionBack = "DEL_HOSPITAL_LIST_REQUEST";
				if (request.equals(true)) {
					resultBack = "100";
					desBack = "success";
				} else if (request.equals(false)) {
					resultBack = "200";
					desBack = "failure";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		if (actionBack != null && !"".equals(actionBack)) {
			packMap.put("action", actionBack);
		}
		if (resultBack != null && !"".equals(resultBack)) {
			packMap.put("result", resultBack);
		}
		if (desBack != null && !"".equals(desBack)) {
			packMap.put("des", desBack);
		}
		if (pageBack != null) {
			packMap.put("page", pageBack);
		}
		if (contentBack != null) {
			packMap.put("content", contentBack);
		}
		return packMap;
	}

	private Map<String, Object> packByXml(String action, Object request,
			Object entity) {
		Map<String, Object> packMap = new HashMap<String, Object>();
		return packMap;
	}
}
