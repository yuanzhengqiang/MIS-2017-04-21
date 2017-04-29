package mis.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mis.entity.HospitalDetectingItemRelationEntity;
import mis.entity.HospitalEntity;
import mis.entity.MedicalItemEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.db.manager.DBManager;
import com.framework.system.db.query.OrderVO;
import com.framework.system.util.JsonUtil;

/**
 * @Title: Parse
 * @Description: 医院体检项目关系表解析器
 * @author feng.gu
 * @date 2017-04-26 22:16:09
 * @version V1.0
 *
 */
public class HospitalDetectingItemRelationParse {
	private static Logger logger = Logger
			.getLogger(HospitalDetectingItemRelationParse.class);
	private static HospitalDetectingItemRelationParse HospitalDetectingItemRelationParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static HospitalDetectingItemRelationParse getInstance() {
		if (HospitalDetectingItemRelationParse == null) {
			HospitalDetectingItemRelationParse = new HospitalDetectingItemRelationParse();
		}
		return HospitalDetectingItemRelationParse;
	}

	public Map<String, Object> parse(int type, String command, String reqStr,
			HttpServletRequest request) {
		// 定义返回参数
		Map<String, Object> parseMap = new HashMap<String, Object>();
		if (type == 1) {
			// json
			parseMap = this.parseByJson(command, reqStr, request);
		} else if (type == 2) {
			// xml
			parseMap = this.parseByXml(command, reqStr, request);
		}
		return parseMap;
	}

	private Map<String, Object> parseByJson(String command, String reqStr,
			HttpServletRequest request) {
		// 定义返回参数
		Map<String, Object> parseMap = new HashMap<String, Object>();
		try {
			String actionReturn = null;
			HospitalDetectingItemRelationEntity HospitalDetectingItemRelationReturn = null;
			List<HospitalDetectingItemRelationEntity> HospitalDetectingItemRelationListReturn = null;
			Integer idReturn = null;
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;

			Boolean parentHospitalDetectingItemRelationShowReturn = false;
			Boolean delParentHospitalDetectingItemRelationReturn = false;
			Boolean delParentHospitalDetectingItemRelationListReturn = false;
			Boolean childHospitalDetectingItemRelationListShowReturn = false;
			Boolean delChildHospitalDetectingItemRelationListReturn = false;
			Boolean hospitalEntityShowReturn = false;
			Boolean delHospitalEntityReturn = false;
			Boolean medicalItemShowReturn = false;
			Boolean delMedicalItemReturn = false;

			// json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject) reqParams.get("content");
			if ("ADD__HOSPITAL_DETECTING_ITEM_RELATION_INFO_REQUEST"
					.equals(command)) {
				actionReturn = "save";
				HospitalDetectingItemRelationReturn = new HospitalDetectingItemRelationEntity();
				if (true) {
					if (contentreq != null) {
						Integer id = (Integer) contentreq.get("id");
						if (id != null) {
							HospitalDetectingItemRelationReturn = (HospitalDetectingItemRelationEntity) dbManager
									.getById(
											id,
											HospitalDetectingItemRelationEntity.class);
							HospitalDetectingItemRelationReturn.setId(id);
						}
						Integer hospitalId = (Integer) contentreq
								.get("hospitalId");
						if (hospitalId != null) {
							HospitalDetectingItemRelationReturn
									.setHospitalId(hospitalId);
						}
						Integer detectingItem = (Integer) contentreq
								.get("detectingItem");
						if (detectingItem != null) {
							HospitalDetectingItemRelationReturn
									.setDetectingItem(detectingItem);
						}
					}
				}
				if (true) {
					Object parentHospitalDetectingItemRelation = contentreq
							.get("parentHospitalDetectingItemRelation");
					if (parentHospitalDetectingItemRelation != null) {
						JSONObject obj = (JSONObject) parentHospitalDetectingItemRelation;
						if (obj != null) {
							HospitalDetectingItemRelationEntity entity = new HospitalDetectingItemRelationEntity();

							Integer id = (Integer) obj.get("id");
							if (id != null) {
								entity.setId(id);
							}
							Integer hospitalId = (Integer) obj
									.get("hospitalId");
							if (hospitalId != null) {
								entity.setHospitalId(hospitalId);
							}
							Integer detectingItem = (Integer) obj
									.get("detectingItem");
							if (detectingItem != null) {
								entity.setDetectingItem(detectingItem);
							}
						}
					}
				}
				if (true) {
					Object childHospitalDetectingItemRelationList = contentreq
							.get("childHospitalDetectingItemRelationList");
					if (childHospitalDetectingItemRelationList != null) {
						JSONArray list = (JSONArray) childHospitalDetectingItemRelationList;
						if (list != null) {
							List<HospitalDetectingItemRelationEntity> entityList = new ArrayList<HospitalDetectingItemRelationEntity>();
							for (int i = 0; i < list.size(); i++) {
								JSONObject obj = list.getJSONObject(i);
								if (obj != null) {
									HospitalDetectingItemRelationEntity entity = new HospitalDetectingItemRelationEntity();

									Integer id = (Integer) obj.get("id");
									if (id != null) {
										entity.setId(id);
									}
									Integer hospitalId = (Integer) obj
											.get("hospitalId");
									if (hospitalId != null) {
										entity.setHospitalId(hospitalId);
									}
									Integer detectingItem = (Integer) obj
											.get("detectingItem");
									if (detectingItem != null) {
										entity.setDetectingItem(detectingItem);
									}
									entityList.add(entity);
								}
							}
							HospitalDetectingItemRelationReturn
									.setChildHospitalDetectingItemRelationList(entityList);
						}

					}
				}
				if (true) {
					Object hospitalEntity = contentreq.get("hospitalEntity");
					if (hospitalEntity != null) {
						JSONObject obj = (JSONObject) hospitalEntity;
						if (obj != null) {
							HospitalEntity entity = new HospitalEntity();
							Integer id = (Integer) obj.get("id");
							if (id != null) {
								entity.setId(id);
							}
							String hospitalName = (String) obj
									.get("hospitalName");
							if (hospitalName != null) {
								entity.setHospitalName(hospitalName);
							}
							String level = (String) obj.get("level");
							if (level != null) {
								entity.setLevel(level);
							}
							Integer areaId = (Integer) obj.get("areaId");
							if (areaId != null) {
								entity.setAreaId(areaId);
							}
							String addr = (String) obj.get("addr");
							if (addr != null) {
								entity.setAddr(addr);
							}
							HospitalDetectingItemRelationReturn
									.setHospitalEntity(entity);
						}
					}
				}
				if (true) {
					Object medicalItem = contentreq.get("medicalItem");
					if (medicalItem != null) {
						JSONObject obj = (JSONObject) medicalItem;
						if (obj != null) {
							MedicalItemEntity entity = new MedicalItemEntity();
							Integer id = (Integer) obj.get("id");
							if (id != null) {
								entity.setId(id);
							}
							String itemName = (String) obj.get("itemName");
							if (itemName != null) {
								entity.setItemName(itemName);
							}
							Integer category = (Integer) obj.get("category");
							if (category != null) {
								entity.setCategory(category);
							}
							String testWay = (String) obj.get("testWay");
							if (testWay != null) {
								entity.setTestWay(testWay);
							}
							String testPurpose = (String) obj
									.get("testPurpose");
							if (testPurpose != null) {
								entity.setTestPurpose(testPurpose);
							}
							String selectDes = (String) obj.get("selectDes");
							if (selectDes != null) {
								entity.setSelectDes(selectDes);
							}
							Double price = JsonUtil.getJSONDouble(obj, "price");
							if (price != null) {
								entity.setPrice(price);
							}
							String des = (String) obj.get("des");
							if (des != null) {
								entity.setDes(des);
							}
							String mattersNeedAttention = (String) obj
									.get("mattersNeedAttention");
							if (mattersNeedAttention != null) {
								entity.setMattersNeedAttention(mattersNeedAttention);
							}
							String instructions = (String) obj
									.get("instructions");
							if (instructions != null) {
								entity.setInstructions(instructions);
							}
							HospitalDetectingItemRelationReturn
									.setMedicalItem(entity);
						}
					}
				}
			} else if ("QUERY__HOSPITAL_DETECTING_ITEM_RELATION_INFO_REQUEST"
					.equals(command)) {
				actionReturn = "getById";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String parentHospitalDetectingItemRelationShow = (String) contentreq
								.get("parentHospitalDetectingItemRelationShow");
						if ("true"
								.equals(parentHospitalDetectingItemRelationShow)) {
							parentHospitalDetectingItemRelationShowReturn = true;
						}
						String childHospitalDetectingItemRelationListShow = (String) contentreq
								.get("childHospitalDetectingItemRelationListShow");
						if ("true"
								.equals(childHospitalDetectingItemRelationListShow)) {
							childHospitalDetectingItemRelationListShowReturn = true;
						}
						String hospitalEntityShow = (String) contentreq
								.get("hospitalEntityShow");
						if ("true".equals(hospitalEntityShow)) {
							hospitalEntityShowReturn = true;
						}
						String medicalItemShow = (String) contentreq
								.get("medicalItemShow");
						if ("true".equals(medicalItemShow)) {
							medicalItemShowReturn = true;
						}
					}
				}
			} else if ("QUERY__HOSPITAL_DETECTING_ITEM_RELATION_LIST_REQUEST"
					.equals(command)) {
				actionReturn = "getListByCondition";
				if (true) {
					if (contentreq != null) {
						queryMapReturn = new HashMap<String, Object>();
						Integer id_gt = (Integer) contentreq.get("id_gt");
						Integer id_ge = (Integer) contentreq.get("id_ge");
						Integer id_lt = (Integer) contentreq.get("id_lt");
						Integer id_le = (Integer) contentreq.get("id_le");
						String id_in = (String) contentreq.get("id_in");
						Integer id = (Integer) contentreq.get("id");
						if (id_gt != null) {
							queryMapReturn.put("id_gt", id_gt);
						}
						if (id_ge != null) {
							queryMapReturn.put("id_ge", id_ge);
						}
						if (id_lt != null) {
							queryMapReturn.put("id_lt", id_lt);
						}
						if (id_le != null) {
							queryMapReturn.put("id_le", id_le);
						}
						if (id_in != null) {
							queryMapReturn.put("id_in", id_in);
						}
						if (id != null) {
							queryMapReturn.put("id", id);
						}
						Integer hospitalId_gt = (Integer) contentreq
								.get("hospitalId_gt");
						Integer hospitalId_ge = (Integer) contentreq
								.get("hospitalId_ge");
						Integer hospitalId_lt = (Integer) contentreq
								.get("hospitalId_lt");
						Integer hospitalId_le = (Integer) contentreq
								.get("hospitalId_le");
						String hospitalId_in = (String) contentreq
								.get("hospitalId_in");
						Integer hospitalId = (Integer) contentreq
								.get("hospitalId");
						if (hospitalId_gt != null) {
							queryMapReturn.put("hospitalId_gt", hospitalId_gt);
						}
						if (hospitalId_ge != null) {
							queryMapReturn.put("hospitalId_ge", hospitalId_ge);
						}
						if (hospitalId_lt != null) {
							queryMapReturn.put("hospitalId_lt", hospitalId_lt);
						}
						if (hospitalId_le != null) {
							queryMapReturn.put("hospitalId_le", hospitalId_le);
						}
						if (hospitalId_in != null) {
							queryMapReturn.put("hospitalId_in", hospitalId_in);
						}
						if (hospitalId != null) {
							queryMapReturn.put("hospitalId", hospitalId);
						}
						Integer detectingItem_gt = (Integer) contentreq
								.get("detectingItem_gt");
						Integer detectingItem_ge = (Integer) contentreq
								.get("detectingItem_ge");
						Integer detectingItem_lt = (Integer) contentreq
								.get("detectingItem_lt");
						Integer detectingItem_le = (Integer) contentreq
								.get("detectingItem_le");
						String detectingItem_in = (String) contentreq
								.get("detectingItem_in");
						Integer detectingItem = (Integer) contentreq
								.get("detectingItem");
						if (detectingItem_gt != null) {
							queryMapReturn.put("detectingItem_gt",
									detectingItem_gt);
						}
						if (detectingItem_ge != null) {
							queryMapReturn.put("detectingItem_ge",
									detectingItem_ge);
						}
						if (detectingItem_lt != null) {
							queryMapReturn.put("detectingItem_lt",
									detectingItem_lt);
						}
						if (detectingItem_le != null) {
							queryMapReturn.put("detectingItem_le",
									detectingItem_le);
						}
						if (detectingItem_in != null) {
							queryMapReturn.put("detectingItem_in",
									detectingItem_in);
						}
						if (detectingItem != null) {
							queryMapReturn.put("detectingItem", detectingItem);
						}

						String parentHospitalDetectingItemRelationShow = (String) contentreq
								.get("parentHospitalDetectingItemRelationShow");
						if ("true"
								.equals(parentHospitalDetectingItemRelationShow)) {
							parentHospitalDetectingItemRelationShowReturn = true;
						}
						String childHospitalDetectingItemRelationListShow = (String) contentreq
								.get("childHospitalDetectingItemRelationListShow");
						if ("true"
								.equals(childHospitalDetectingItemRelationListShow)) {
							childHospitalDetectingItemRelationListShowReturn = true;
						}
						String hospitalEntityShow = (String) contentreq
								.get("hospitalEntityShow");
						if ("true".equals(hospitalEntityShow)) {
							hospitalEntityShowReturn = true;
						}
						String medicalItemShow = (String) contentreq
								.get("medicalItemShow");
						if ("true".equals(medicalItemShow)) {
							medicalItemShowReturn = true;
						}
					}
					JSONObject pagereq = (JSONObject) reqParams.get("page");
					if (pagereq != null) {
						String pagenotemp = (String) pagereq.get("pageno");
						String pagesizetemp = (String) pagereq.get("pagesize");
						if ((pagenotemp != null)
								&& (!"".equals(pagenotemp.trim()))) {
							pagenoReturn = Integer.valueOf(pagenotemp)
									.intValue();
						}
						if ((pagesizetemp != null)
								&& (!"".equals(pagesizetemp.trim()))) {
							pagesizeReturn = Integer.valueOf(pagesizetemp)
									.intValue();
						}
					}
					Object orderreq = (Object) reqParams.get("order");
					if (orderreq != null) {
						JSONArray order = (JSONArray) orderreq;
						orderListReturn = new ArrayList<OrderVO>();
						for (int i = 0; i < order.size(); i++) {
							JSONObject obj = order.getJSONObject(i);
							OrderVO orderVO = new OrderVO();
							orderVO.setName((String) obj.get("column"));
							orderVO.setOrderType((String) obj.get("type"));
							orderListReturn.add(orderVO);
						}
					}
				}
			} else if ("DEL__HOSPITAL_DETECTING_ITEM_RELATION_INFO_REQUEST"
					.equals(command)) {
				actionReturn = "del";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String delParentHospitalDetectingItemRelation = (String) contentreq
								.get("delParentHospitalDetectingItemRelation");
						if ("true"
								.equals(delParentHospitalDetectingItemRelation)) {
							delParentHospitalDetectingItemRelationReturn = true;
						}
						String delChildHospitalDetectingItemRelationList = (String) contentreq
								.get("delChildHospitalDetectingItemRelationList");
						if ("true"
								.equals(delChildHospitalDetectingItemRelationList)) {
							delChildHospitalDetectingItemRelationListReturn = true;
						}
						String delHospitalEntity = (String) contentreq
								.get("delHospitalEntity");
						if ("true".equals(delHospitalEntity)) {
							delHospitalEntityReturn = true;
						}
						String delMedicalItem = (String) contentreq
								.get("delMedicalItem");
						if ("true".equals(delMedicalItem)) {
							delMedicalItemReturn = true;
						}
					}
				}
			} else if ("DEL__HOSPITAL_DETECTING_ITEM_RELATION_LIST_REQUEST"
					.equals(command)) {
				actionReturn = "delList";
				if (true) {
					if (contentreq != null) {
						queryMapReturn = new HashMap<String, Object>();
						Integer id_gt = (Integer) contentreq.get("id_gt");
						Integer id_ge = (Integer) contentreq.get("id_ge");
						Integer id_lt = (Integer) contentreq.get("id_lt");
						Integer id_le = (Integer) contentreq.get("id_le");
						String id_in = (String) contentreq.get("id_in");
						Integer id = (Integer) contentreq.get("id");
						if (id_gt != null) {
							queryMapReturn.put("id_gt", id_gt);
						}
						if (id_ge != null) {
							queryMapReturn.put("id_ge", id_ge);
						}
						if (id_lt != null) {
							queryMapReturn.put("id_lt", id_lt);
						}
						if (id_le != null) {
							queryMapReturn.put("id_le", id_le);
						}
						if (id_in != null) {
							queryMapReturn.put("id_in", id_in);
						}
						if (id != null) {
							queryMapReturn.put("id", id);
						}
						Integer hospitalId_gt = (Integer) contentreq
								.get("hospitalId_gt");
						Integer hospitalId_ge = (Integer) contentreq
								.get("hospitalId_ge");
						Integer hospitalId_lt = (Integer) contentreq
								.get("hospitalId_lt");
						Integer hospitalId_le = (Integer) contentreq
								.get("hospitalId_le");
						String hospitalId_in = (String) contentreq
								.get("hospitalId_in");
						Integer hospitalId = (Integer) contentreq
								.get("hospitalId");
						if (hospitalId_gt != null) {
							queryMapReturn.put("hospitalId_gt", hospitalId_gt);
						}
						if (hospitalId_ge != null) {
							queryMapReturn.put("hospitalId_ge", hospitalId_ge);
						}
						if (hospitalId_lt != null) {
							queryMapReturn.put("hospitalId_lt", hospitalId_lt);
						}
						if (hospitalId_le != null) {
							queryMapReturn.put("hospitalId_le", hospitalId_le);
						}
						if (hospitalId_in != null) {
							queryMapReturn.put("hospitalId_in", hospitalId_in);
						}
						if (hospitalId != null) {
							queryMapReturn.put("hospitalId", hospitalId);
						}
						Integer detectingItem_gt = (Integer) contentreq
								.get("detectingItem_gt");
						Integer detectingItem_ge = (Integer) contentreq
								.get("detectingItem_ge");
						Integer detectingItem_lt = (Integer) contentreq
								.get("detectingItem_lt");
						Integer detectingItem_le = (Integer) contentreq
								.get("detectingItem_le");
						String detectingItem_in = (String) contentreq
								.get("detectingItem_in");
						Integer detectingItem = (Integer) contentreq
								.get("detectingItem");
						if (detectingItem_gt != null) {
							queryMapReturn.put("detectingItem_gt",
									detectingItem_gt);
						}
						if (detectingItem_ge != null) {
							queryMapReturn.put("detectingItem_ge",
									detectingItem_ge);
						}
						if (detectingItem_lt != null) {
							queryMapReturn.put("detectingItem_lt",
									detectingItem_lt);
						}
						if (detectingItem_le != null) {
							queryMapReturn.put("detectingItem_le",
									detectingItem_le);
						}
						if (detectingItem_in != null) {
							queryMapReturn.put("detectingItem_in",
									detectingItem_in);
						}
						if (detectingItem != null) {
							queryMapReturn.put("detectingItem", detectingItem);
						}

						String delParentHospitalDetectingItemRelation = (String) contentreq
								.get("delParentHospitalDetectingItemRelation");
						if ("true"
								.equals(delParentHospitalDetectingItemRelation)) {
							delParentHospitalDetectingItemRelationReturn = true;
						}
						String delChildHospitalDetectingItemRelationList = (String) contentreq
								.get("delChildHospitalDetectingItemRelationList");
						if ("true"
								.equals(delChildHospitalDetectingItemRelationList)) {
							delChildHospitalDetectingItemRelationListReturn = true;
						}
						String delHospitalEntity = (String) contentreq
								.get("delHospitalEntity");
						if ("true".equals(delHospitalEntity)) {
							delHospitalEntityReturn = true;
						}
						String delMedicalItem = (String) contentreq
								.get("delMedicalItem");
						if ("true".equals(delMedicalItem)) {
							delMedicalItemReturn = true;
						}
					}
					JSONObject pagereq = (JSONObject) reqParams.get("page");
					if (pagereq != null) {
						String pagenotemp = (String) pagereq.get("pageno");
						String pagesizetemp = (String) pagereq.get("pagesize");
						if ((pagenotemp != null)
								&& (!"".equals(pagenotemp.trim()))) {
							pagenoReturn = Integer.valueOf(pagenotemp)
									.intValue();
						}
						if ((pagesizetemp != null)
								&& (!"".equals(pagesizetemp.trim()))) {
							pagesizeReturn = Integer.valueOf(pagesizetemp)
									.intValue();
						}
					}
				}
			}

			if (actionReturn != null && !"".equals(actionReturn)) {
				parseMap.put("action", actionReturn);
			}
			if (HospitalDetectingItemRelationReturn != null) {
				parseMap.put("HospitalDetectingItemRelation",
						HospitalDetectingItemRelationReturn);
			}
			if (HospitalDetectingItemRelationListReturn != null
					&& HospitalDetectingItemRelationListReturn.size() > 0) {
				parseMap.put("HospitalDetectingItemRelationList",
						HospitalDetectingItemRelationListReturn);
			}
			if (idReturn != null) {
				parseMap.put("id", idReturn);
			}
			if (orderListReturn != null && orderListReturn.size() > 0) {
				parseMap.put("orderList", orderListReturn);
			}
			if (queryMapReturn != null) {
				parseMap.put("queryMap", queryMapReturn);
			}
			if (pagenoReturn > 0) {
				parseMap.put("pageno", pagenoReturn);
			}
			if (pagesizeReturn > 0) {
				parseMap.put("pagesize", pagesizeReturn);
			}

			if (parentHospitalDetectingItemRelationShowReturn != null) {
				parseMap.put("parentHospitalDetectingItemRelationShow",
						parentHospitalDetectingItemRelationShowReturn);
			}
			if (delParentHospitalDetectingItemRelationReturn != null) {
				parseMap.put("delParentHospitalDetectingItemRelation",
						delParentHospitalDetectingItemRelationReturn);
			}
			if (delParentHospitalDetectingItemRelationListReturn != null) {
				parseMap.put("delParentHospitalDetectingItemRelationList",
						delParentHospitalDetectingItemRelationListReturn);
			}
			if (childHospitalDetectingItemRelationListShowReturn != null) {
				parseMap.put("childHospitalDetectingItemRelationListShow",
						childHospitalDetectingItemRelationListShowReturn);
			}
			if (delChildHospitalDetectingItemRelationListReturn != null) {
				parseMap.put("delChildHospitalDetectingItemRelationList",
						delChildHospitalDetectingItemRelationListReturn);
			}
			if (hospitalEntityShowReturn != null) {
				parseMap.put("hospitalEntityShow", hospitalEntityShowReturn);
			}
			if (delHospitalEntityReturn != null) {
				parseMap.put("delHospitalEntity", delHospitalEntityReturn);
			}
			if (medicalItemShowReturn != null) {
				parseMap.put("medicalItemShow", medicalItemShowReturn);
			}
			if (delMedicalItemReturn != null) {
				parseMap.put("delMedicalItem", delMedicalItemReturn);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		return parseMap;
	}

	private Map<String, Object> parseByXml(String command, String reqStr,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
