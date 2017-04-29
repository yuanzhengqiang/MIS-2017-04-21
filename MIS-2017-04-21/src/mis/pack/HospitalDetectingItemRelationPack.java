package mis.pack;

import java.util.HashMap;
import java.util.Map;

import mis.entity.HospitalDetectingItemRelationEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.db.query.PageList;

/**
 * @Title: Pack
 * @Description: 医院体检项目关系表封装器
 * @author feng.gu
 * @date 2017-04-26 22:16:09
 * @version V1.0
 *
 */
public class HospitalDetectingItemRelationPack {
	private static Logger logger = Logger
			.getLogger(HospitalDetectingItemRelationPack.class);
	private static HospitalDetectingItemRelationPack HospitalDetectingItemRelationPack;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static HospitalDetectingItemRelationPack getInstance() {
		if (HospitalDetectingItemRelationPack == null) {
			HospitalDetectingItemRelationPack = new HospitalDetectingItemRelationPack();
		}
		return HospitalDetectingItemRelationPack;
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
				actionBack = "ADD__HOSPITAL_DETECTING_ITEM_RELATION_INFO_RESPONSE";
				if (request.equals(true)) {
					resultBack = "100";
					desBack = "success";
				} else if (request.equals(false)) {
					resultBack = "200";
					desBack = "failure";
				}
				HospitalDetectingItemRelationEntity HospitalDetectingItemRelation = (HospitalDetectingItemRelationEntity) entity;
				if (HospitalDetectingItemRelation != null) {
					contentBack = new JSONObject();
					contentBack
							.put("id", HospitalDetectingItemRelation.getId());

					if (HospitalDetectingItemRelation
							.getParentHospitalDetectingItemRelation() != null) {
						contentBack
								.put("parentHospitalDetectingItemRelationId",
										HospitalDetectingItemRelation
												.getParentHospitalDetectingItemRelation()
												.getId());
					}
					if (HospitalDetectingItemRelation.getHospitalEntity() != null) {
						contentBack.put("hospitalEntityId",
								HospitalDetectingItemRelation
										.getHospitalEntity().getId());
					}
					if (HospitalDetectingItemRelation.getMedicalItem() != null) {
						contentBack.put("medicalItemId",
								HospitalDetectingItemRelation.getMedicalItem()
										.getId());
					}
				}
			} else if ("getById".equals(action)) {
				actionBack = "QUERY__HOSPITAL_DETECTING_ITEM_RELATION_INFO_RESPONSE";
				resultBack = "100";
				desBack = "success";
				HospitalDetectingItemRelationEntity HospitalDetectingItemRelation = (HospitalDetectingItemRelationEntity) request;
				if (HospitalDetectingItemRelation != null) {
					contentBack = JSONObject
							.fromObject(HospitalDetectingItemRelation);
					if (HospitalDetectingItemRelation
							.getParentHospitalDetectingItemRelation() != null) {
						contentBack
								.put("parentHospitalDetectingItemRelation",
										JSONObject
												.fromObject(HospitalDetectingItemRelation
														.getParentHospitalDetectingItemRelation()));
					}
					if (HospitalDetectingItemRelation
							.getChildHospitalDetectingItemRelationList() != null) {
						contentBack
								.put("childHospitalDetectingItemRelationList",
										JSONArray
												.fromObject(HospitalDetectingItemRelation
														.getChildHospitalDetectingItemRelationList()));
					}
					if (HospitalDetectingItemRelation.getHospitalEntity() != null) {
						contentBack.put("hospitalEntity", JSONObject
								.fromObject(HospitalDetectingItemRelation
										.getHospitalEntity()));
					}
					if (HospitalDetectingItemRelation.getMedicalItem() != null) {
						contentBack.put("medicalItem", JSONObject
								.fromObject(HospitalDetectingItemRelation
										.getMedicalItem()));
					}
				}
			} else if ("getListByCondition".equals(action)) {
				actionBack = "QUERY__HOSPITAL_DETECTING_ITEM_RELATION_LIST_RESPONSE";
				resultBack = "100";
				desBack = "success";
				PageList pageList = (PageList) request;
				if (pageList != null && pageList.getResultList() != null
						&& pageList.getResultList().size() > 0) {
					contentBack = new JSONObject();
					pageBack = new JSONObject();
					JSONArray list = JSONArray.fromObject(pageList
							.getResultList());
					contentBack.put("HospitalDetectingItemRelationList", list);

					pageBack.put("pageno", pageList.getPageno());
					pageBack.put("pagesize", pageList.getPagesize());
					pageBack.put("recordCount", pageList.getRecordCount());
					pageBack.put("pageCount", pageList.getPageCount());

				}
			} else if ("del".equals(action)) {
				actionBack = "DEL__HOSPITAL_DETECTING_ITEM_RELATION_INFO_REQUEST";
				if (request.equals(true)) {
					resultBack = "100";
					desBack = "success";
				} else if (request.equals(false)) {
					resultBack = "200";
					desBack = "failure";
				}
			} else if ("delList".equals(action)) {
				actionBack = "DEL__HOSPITAL_DETECTING_ITEM_RELATION_LIST_REQUEST";
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
