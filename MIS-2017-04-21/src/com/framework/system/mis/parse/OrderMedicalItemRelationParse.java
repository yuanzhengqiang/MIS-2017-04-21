package com.framework.system.mis.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.db.manager.DBManager;
import com.framework.system.db.query.OrderVO;
import com.framework.system.mis.entity.MedicalItemEntity;
import com.framework.system.mis.entity.OrderEntity;
import com.framework.system.mis.entity.OrderMedicalItemRelationEntity;
import com.framework.system.util.JsonUtil;

/**
 * @Title: Parse
 * @Description: 订单体检项目关系表解析器
 * @author feng.gu
 * @date 2017-04-21 17:23:21
 * @version V1.0
 * 
 */
public class OrderMedicalItemRelationParse {
	private static Logger logger = Logger
			.getLogger(OrderMedicalItemRelationParse.class);
	private static OrderMedicalItemRelationParse orderMedicalItemRelationParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static OrderMedicalItemRelationParse getInstance() {
		if (orderMedicalItemRelationParse == null) {
			orderMedicalItemRelationParse = new OrderMedicalItemRelationParse();
		}
		return orderMedicalItemRelationParse;
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
			OrderMedicalItemRelationEntity orderMedicalItemRelationReturn = null;
			List<OrderMedicalItemRelationEntity> orderMedicalItemRelationListReturn = null;
			Integer idReturn = null;
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;

			Boolean orderEntityShowReturn = false;
			Boolean delOrderEntityReturn = false;
			Boolean medicalItemShowReturn = false;
			Boolean delMedicalItemReturn = false;

			// json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject) reqParams.get("content");
			if ("ADD_ORDER_MEDICAL_ITEM_RELATION_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				orderMedicalItemRelationReturn = new OrderMedicalItemRelationEntity();
				if (true) {
					if (contentreq != null) {
						Integer id = (Integer) contentreq.get("id");
						if (id != null) {
							orderMedicalItemRelationReturn = (OrderMedicalItemRelationEntity) dbManager
									.getById(
											id,
											OrderMedicalItemRelationEntity.class);
							orderMedicalItemRelationReturn.setId(id);
						}
						Integer orderId = (Integer) contentreq.get("orderId");
						if (orderId != null) {
							orderMedicalItemRelationReturn.setOrderId(orderId);
						}
						Integer medicalItemId = (Integer) contentreq
								.get("medicalItemId");
						if (medicalItemId != null) {
							orderMedicalItemRelationReturn
									.setMedicalItemId(medicalItemId);
						}
						Integer medicalItemName = (Integer) contentreq
								.get("medicalItemName");
						if (medicalItemName != null) {
							orderMedicalItemRelationReturn
									.setMedicalItemName(medicalItemName);
						}
						Integer medicalItemPrice = (Integer) contentreq
								.get("medicalItemPrice");
						if (medicalItemPrice != null) {
							orderMedicalItemRelationReturn
									.setMedicalItemPrice(medicalItemPrice);
						}
					}
				}
				if (true) {
					Object orderEntity = contentreq.get("orderEntity");
					if (orderEntity != null) {
						JSONObject obj = (JSONObject) orderEntity;
						if (obj != null) {
							OrderEntity entity = new OrderEntity();
							Integer id = (Integer) obj.get("id");
							if (id != null) {
								entity.setId(id);
							}
							String orderNum = (String) obj.get("orderNum");
							if (orderNum != null) {
								entity.setOrderNum(orderNum);
							}
							Integer totalPrice = (Integer) obj
									.get("totalPrice");
							if (totalPrice != null) {
								entity.setTotalPrice(totalPrice);
							}
							String orderCustomer = (String) obj
									.get("orderCustomer");
							if (orderCustomer != null) {
								entity.setOrderCustomer(orderCustomer);
							}
							String orderTime = (String) obj.get("orderTime");
							if (orderTime != null) {
								entity.setOrderTime(orderTime);
							}
							String medicalHospital = (String) obj
									.get("medicalHospital");
							if (medicalHospital != null) {
								entity.setMedicalHospital(medicalHospital);
							}
							String medicalPersonName = (String) obj
									.get("medicalPersonName");
							if (medicalPersonName != null) {
								entity.setMedicalPersonName(medicalPersonName);
							}
							String medicalPersonCard = (String) obj
									.get("medicalPersonCard");
							if (medicalPersonCard != null) {
								entity.setMedicalPersonCard(medicalPersonCard);
							}
							Object medicalPersonGender = (Object) obj
									.get("medicalPersonGender");
							if (medicalPersonGender != null) {
								entity.setMedicalPersonGender(medicalPersonGender);
							}
							String contactWay = (String) obj.get("contactWay");
							if (contactWay != null) {
								entity.setContactWay(contactWay);
							}
							String reportSendAddr = (String) obj
									.get("reportSendAddr");
							if (reportSendAddr != null) {
								entity.setReportSendAddr(reportSendAddr);
							}
							String expectMedicalTime = (String) obj
									.get("expectMedicalTime");
							if (expectMedicalTime != null) {
								entity.setExpectMedicalTime(expectMedicalTime);
							}
							String medicalCompleteTime = (String) obj
									.get("medicalCompleteTime");
							if (medicalCompleteTime != null) {
								entity.setMedicalCompleteTime(medicalCompleteTime);
							}
							String expectReportCompleteTime = (String) obj
									.get("expectReportCompleteTime");
							if (expectReportCompleteTime != null) {
								entity.setExpectReportCompleteTime(expectReportCompleteTime);
							}
							String reportCreateTime = (String) obj
									.get("reportCreateTime");
							if (reportCreateTime != null) {
								entity.setReportCreateTime(reportCreateTime);
							}
							Integer servicePersonId = (Integer) obj
									.get("servicePersonId");
							if (servicePersonId != null) {
								entity.setServicePersonId(servicePersonId);
							}
							Integer status = (Integer) obj.get("status");
							if (status != null) {
								entity.setStatus(status);
							}
							Integer medicalReportId = (Integer) obj
									.get("medicalReportId");
							if (medicalReportId != null) {
								entity.setMedicalReportId(medicalReportId);
							}
							orderMedicalItemRelationReturn
									.setOrderEntity(entity);
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
							orderMedicalItemRelationReturn
									.setMedicalItem(entity);
						}
					}
				}
			} else if ("QUERY_ORDER_MEDICAL_ITEM_RELATION_INFO_REQUEST"
					.equals(command)) {
				actionReturn = "getById";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String orderEntityShow = (String) contentreq
								.get("orderEntityShow");
						if ("true".equals(orderEntityShow)) {
							orderEntityShowReturn = true;
						}
						String medicalItemShow = (String) contentreq
								.get("medicalItemShow");
						if ("true".equals(medicalItemShow)) {
							medicalItemShowReturn = true;
						}
					}
				}
			} else if ("QUERY_ORDER_MEDICAL_ITEM_RELATION_LIST_REQUEST"
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
						Integer orderId_gt = (Integer) contentreq
								.get("orderId_gt");
						Integer orderId_ge = (Integer) contentreq
								.get("orderId_ge");
						Integer orderId_lt = (Integer) contentreq
								.get("orderId_lt");
						Integer orderId_le = (Integer) contentreq
								.get("orderId_le");
						String orderId_in = (String) contentreq
								.get("orderId_in");
						Integer orderId = (Integer) contentreq.get("orderId");
						if (orderId_gt != null) {
							queryMapReturn.put("orderId_gt", orderId_gt);
						}
						if (orderId_ge != null) {
							queryMapReturn.put("orderId_ge", orderId_ge);
						}
						if (orderId_lt != null) {
							queryMapReturn.put("orderId_lt", orderId_lt);
						}
						if (orderId_le != null) {
							queryMapReturn.put("orderId_le", orderId_le);
						}
						if (orderId_in != null) {
							queryMapReturn.put("orderId_in", orderId_in);
						}
						if (orderId != null) {
							queryMapReturn.put("orderId", orderId);
						}
						Integer medicalItemId_gt = (Integer) contentreq
								.get("medicalItemId_gt");
						Integer medicalItemId_ge = (Integer) contentreq
								.get("medicalItemId_ge");
						Integer medicalItemId_lt = (Integer) contentreq
								.get("medicalItemId_lt");
						Integer medicalItemId_le = (Integer) contentreq
								.get("medicalItemId_le");
						String medicalItemId_in = (String) contentreq
								.get("medicalItemId_in");
						Integer medicalItemId = (Integer) contentreq
								.get("medicalItemId");
						if (medicalItemId_gt != null) {
							queryMapReturn.put("medicalItemId_gt",
									medicalItemId_gt);
						}
						if (medicalItemId_ge != null) {
							queryMapReturn.put("medicalItemId_ge",
									medicalItemId_ge);
						}
						if (medicalItemId_lt != null) {
							queryMapReturn.put("medicalItemId_lt",
									medicalItemId_lt);
						}
						if (medicalItemId_le != null) {
							queryMapReturn.put("medicalItemId_le",
									medicalItemId_le);
						}
						if (medicalItemId_in != null) {
							queryMapReturn.put("medicalItemId_in",
									medicalItemId_in);
						}
						if (medicalItemId != null) {
							queryMapReturn.put("medicalItemId", medicalItemId);
						}
						Integer medicalItemName_gt = (Integer) contentreq
								.get("medicalItemName_gt");
						Integer medicalItemName_ge = (Integer) contentreq
								.get("medicalItemName_ge");
						Integer medicalItemName_lt = (Integer) contentreq
								.get("medicalItemName_lt");
						Integer medicalItemName_le = (Integer) contentreq
								.get("medicalItemName_le");
						String medicalItemName_in = (String) contentreq
								.get("medicalItemName_in");
						Integer medicalItemName = (Integer) contentreq
								.get("medicalItemName");
						if (medicalItemName_gt != null) {
							queryMapReturn.put("medicalItemName_gt",
									medicalItemName_gt);
						}
						if (medicalItemName_ge != null) {
							queryMapReturn.put("medicalItemName_ge",
									medicalItemName_ge);
						}
						if (medicalItemName_lt != null) {
							queryMapReturn.put("medicalItemName_lt",
									medicalItemName_lt);
						}
						if (medicalItemName_le != null) {
							queryMapReturn.put("medicalItemName_le",
									medicalItemName_le);
						}
						if (medicalItemName_in != null) {
							queryMapReturn.put("medicalItemName_in",
									medicalItemName_in);
						}
						if (medicalItemName != null) {
							queryMapReturn.put("medicalItemName",
									medicalItemName);
						}
						Integer medicalItemPrice_gt = (Integer) contentreq
								.get("medicalItemPrice_gt");
						Integer medicalItemPrice_ge = (Integer) contentreq
								.get("medicalItemPrice_ge");
						Integer medicalItemPrice_lt = (Integer) contentreq
								.get("medicalItemPrice_lt");
						Integer medicalItemPrice_le = (Integer) contentreq
								.get("medicalItemPrice_le");
						String medicalItemPrice_in = (String) contentreq
								.get("medicalItemPrice_in");
						Integer medicalItemPrice = (Integer) contentreq
								.get("medicalItemPrice");
						if (medicalItemPrice_gt != null) {
							queryMapReturn.put("medicalItemPrice_gt",
									medicalItemPrice_gt);
						}
						if (medicalItemPrice_ge != null) {
							queryMapReturn.put("medicalItemPrice_ge",
									medicalItemPrice_ge);
						}
						if (medicalItemPrice_lt != null) {
							queryMapReturn.put("medicalItemPrice_lt",
									medicalItemPrice_lt);
						}
						if (medicalItemPrice_le != null) {
							queryMapReturn.put("medicalItemPrice_le",
									medicalItemPrice_le);
						}
						if (medicalItemPrice_in != null) {
							queryMapReturn.put("medicalItemPrice_in",
									medicalItemPrice_in);
						}
						if (medicalItemPrice != null) {
							queryMapReturn.put("medicalItemPrice",
									medicalItemPrice);
						}

						String orderEntityShow = (String) contentreq
								.get("orderEntityShow");
						if ("true".equals(orderEntityShow)) {
							orderEntityShowReturn = true;
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
			} else if ("DEL_ORDER_MEDICAL_ITEM_RELATION_INFO_REQUEST"
					.equals(command)) {
				actionReturn = "del";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String delOrderEntity = (String) contentreq
								.get("delOrderEntity");
						if ("true".equals(delOrderEntity)) {
							delOrderEntityReturn = true;
						}
						String delMedicalItem = (String) contentreq
								.get("delMedicalItem");
						if ("true".equals(delMedicalItem)) {
							delMedicalItemReturn = true;
						}
					}
				}
			} else if ("DEL_ORDER_MEDICAL_ITEM_RELATION_LIST_REQUEST"
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
						Integer orderId_gt = (Integer) contentreq
								.get("orderId_gt");
						Integer orderId_ge = (Integer) contentreq
								.get("orderId_ge");
						Integer orderId_lt = (Integer) contentreq
								.get("orderId_lt");
						Integer orderId_le = (Integer) contentreq
								.get("orderId_le");
						String orderId_in = (String) contentreq
								.get("orderId_in");
						Integer orderId = (Integer) contentreq.get("orderId");
						if (orderId_gt != null) {
							queryMapReturn.put("orderId_gt", orderId_gt);
						}
						if (orderId_ge != null) {
							queryMapReturn.put("orderId_ge", orderId_ge);
						}
						if (orderId_lt != null) {
							queryMapReturn.put("orderId_lt", orderId_lt);
						}
						if (orderId_le != null) {
							queryMapReturn.put("orderId_le", orderId_le);
						}
						if (orderId_in != null) {
							queryMapReturn.put("orderId_in", orderId_in);
						}
						if (orderId != null) {
							queryMapReturn.put("orderId", orderId);
						}
						Integer medicalItemId_gt = (Integer) contentreq
								.get("medicalItemId_gt");
						Integer medicalItemId_ge = (Integer) contentreq
								.get("medicalItemId_ge");
						Integer medicalItemId_lt = (Integer) contentreq
								.get("medicalItemId_lt");
						Integer medicalItemId_le = (Integer) contentreq
								.get("medicalItemId_le");
						String medicalItemId_in = (String) contentreq
								.get("medicalItemId_in");
						Integer medicalItemId = (Integer) contentreq
								.get("medicalItemId");
						if (medicalItemId_gt != null) {
							queryMapReturn.put("medicalItemId_gt",
									medicalItemId_gt);
						}
						if (medicalItemId_ge != null) {
							queryMapReturn.put("medicalItemId_ge",
									medicalItemId_ge);
						}
						if (medicalItemId_lt != null) {
							queryMapReturn.put("medicalItemId_lt",
									medicalItemId_lt);
						}
						if (medicalItemId_le != null) {
							queryMapReturn.put("medicalItemId_le",
									medicalItemId_le);
						}
						if (medicalItemId_in != null) {
							queryMapReturn.put("medicalItemId_in",
									medicalItemId_in);
						}
						if (medicalItemId != null) {
							queryMapReturn.put("medicalItemId", medicalItemId);
						}
						Integer medicalItemName_gt = (Integer) contentreq
								.get("medicalItemName_gt");
						Integer medicalItemName_ge = (Integer) contentreq
								.get("medicalItemName_ge");
						Integer medicalItemName_lt = (Integer) contentreq
								.get("medicalItemName_lt");
						Integer medicalItemName_le = (Integer) contentreq
								.get("medicalItemName_le");
						String medicalItemName_in = (String) contentreq
								.get("medicalItemName_in");
						Integer medicalItemName = (Integer) contentreq
								.get("medicalItemName");
						if (medicalItemName_gt != null) {
							queryMapReturn.put("medicalItemName_gt",
									medicalItemName_gt);
						}
						if (medicalItemName_ge != null) {
							queryMapReturn.put("medicalItemName_ge",
									medicalItemName_ge);
						}
						if (medicalItemName_lt != null) {
							queryMapReturn.put("medicalItemName_lt",
									medicalItemName_lt);
						}
						if (medicalItemName_le != null) {
							queryMapReturn.put("medicalItemName_le",
									medicalItemName_le);
						}
						if (medicalItemName_in != null) {
							queryMapReturn.put("medicalItemName_in",
									medicalItemName_in);
						}
						if (medicalItemName != null) {
							queryMapReturn.put("medicalItemName",
									medicalItemName);
						}
						Integer medicalItemPrice_gt = (Integer) contentreq
								.get("medicalItemPrice_gt");
						Integer medicalItemPrice_ge = (Integer) contentreq
								.get("medicalItemPrice_ge");
						Integer medicalItemPrice_lt = (Integer) contentreq
								.get("medicalItemPrice_lt");
						Integer medicalItemPrice_le = (Integer) contentreq
								.get("medicalItemPrice_le");
						String medicalItemPrice_in = (String) contentreq
								.get("medicalItemPrice_in");
						Integer medicalItemPrice = (Integer) contentreq
								.get("medicalItemPrice");
						if (medicalItemPrice_gt != null) {
							queryMapReturn.put("medicalItemPrice_gt",
									medicalItemPrice_gt);
						}
						if (medicalItemPrice_ge != null) {
							queryMapReturn.put("medicalItemPrice_ge",
									medicalItemPrice_ge);
						}
						if (medicalItemPrice_lt != null) {
							queryMapReturn.put("medicalItemPrice_lt",
									medicalItemPrice_lt);
						}
						if (medicalItemPrice_le != null) {
							queryMapReturn.put("medicalItemPrice_le",
									medicalItemPrice_le);
						}
						if (medicalItemPrice_in != null) {
							queryMapReturn.put("medicalItemPrice_in",
									medicalItemPrice_in);
						}
						if (medicalItemPrice != null) {
							queryMapReturn.put("medicalItemPrice",
									medicalItemPrice);
						}

						String delOrderEntity = (String) contentreq
								.get("delOrderEntity");
						if ("true".equals(delOrderEntity)) {
							delOrderEntityReturn = true;
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
			if (orderMedicalItemRelationReturn != null) {
				parseMap.put("orderMedicalItemRelation",
						orderMedicalItemRelationReturn);
			}
			if (orderMedicalItemRelationListReturn != null
					&& orderMedicalItemRelationListReturn.size() > 0) {
				parseMap.put("orderMedicalItemRelationList",
						orderMedicalItemRelationListReturn);
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

			if (orderEntityShowReturn != null) {
				parseMap.put("orderEntityShow", orderEntityShowReturn);
			}
			if (delOrderEntityReturn != null) {
				parseMap.put("delOrderEntity", delOrderEntityReturn);
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
