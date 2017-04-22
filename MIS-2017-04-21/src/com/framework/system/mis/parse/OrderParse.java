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
import com.framework.system.mis.entity.MedicalReportEntity;
import com.framework.system.mis.entity.OrderEntity;
import com.framework.system.mis.entity.ServicePersonEntity;
import com.framework.system.util.JsonUtil;

/**
 * @Title: Parse
 * @Description: 订单表解析器
 * @author feng.gu
 * @date 2017-04-21 16:39:13
 * @version V1.0
 * 
 */
public class OrderParse {
	private static Logger logger = Logger.getLogger(OrderParse.class);
	private static OrderParse orderParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static OrderParse getInstance() {
		if (orderParse == null) {
			orderParse = new OrderParse();
		}
		return orderParse;
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
			OrderEntity orderReturn = null;
			// List<OrderEntity> orderListReturn = null;
			Integer idReturn = null;
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;

			Boolean parentOrderShowReturn = false;
			Boolean delParentOrderReturn = false;
			Boolean delParentOrderListReturn = false;
			Boolean childOrderListShowReturn = false;
			Boolean delChildOrderListReturn = false;
			Boolean servicePersonShowReturn = false;
			Boolean delServicePersonReturn = false;
			Boolean medicalReportShowReturn = false;
			Boolean delMedicalReportReturn = false;

			// json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject) reqParams.get("content");
			if ("ADD_ORDER_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				orderReturn = new OrderEntity();
				if (true) {
					if (contentreq != null) {
						Integer id = (Integer) contentreq.get("id");
						if (id != null) {
							orderReturn = (OrderEntity) dbManager.getById(id,
									OrderEntity.class);
							orderReturn.setId(id);
						}
						String orderNum = (String) contentreq.get("orderNum");
						if (orderNum != null) {
							orderReturn.setOrderNum(orderNum);
						}
						Integer totalPrice = (Integer) contentreq
								.get("totalPrice");
						if (totalPrice != null) {
							orderReturn.setTotalPrice(totalPrice);
						}
						String orderCustomer = (String) contentreq
								.get("orderCustomer");
						if (orderCustomer != null) {
							orderReturn.setOrderCustomer(orderCustomer);
						}
						String orderTime = (String) contentreq.get("orderTime");
						if (orderTime != null) {
							orderReturn.setOrderTime(orderTime);
						}
						String medicalHospital = (String) contentreq
								.get("medicalHospital");
						if (medicalHospital != null) {
							orderReturn.setMedicalHospital(medicalHospital);
						}
						String medicalPersonName = (String) contentreq
								.get("medicalPersonName");
						if (medicalPersonName != null) {
							orderReturn.setMedicalPersonName(medicalPersonName);
						}
						String medicalPersonCard = (String) contentreq
								.get("medicalPersonCard");
						if (medicalPersonCard != null) {
							orderReturn.setMedicalPersonCard(medicalPersonCard);
						}
						Object medicalPersonGender = (Object) contentreq
								.get("medicalPersonGender");
						if (medicalPersonGender != null) {
							orderReturn
									.setMedicalPersonGender(medicalPersonGender);
						}
						String contactWay = (String) contentreq
								.get("contactWay");
						if (contactWay != null) {
							orderReturn.setContactWay(contactWay);
						}
						String reportSendAddr = (String) contentreq
								.get("reportSendAddr");
						if (reportSendAddr != null) {
							orderReturn.setReportSendAddr(reportSendAddr);
						}
						String expectMedicalTime = (String) contentreq
								.get("expectMedicalTime");
						if (expectMedicalTime != null) {
							orderReturn.setExpectMedicalTime(expectMedicalTime);
						}
						String medicalCompleteTime = (String) contentreq
								.get("medicalCompleteTime");
						if (medicalCompleteTime != null) {
							orderReturn
									.setMedicalCompleteTime(medicalCompleteTime);
						}
						String expectReportCompleteTime = (String) contentreq
								.get("expectReportCompleteTime");
						if (expectReportCompleteTime != null) {
							orderReturn
									.setExpectReportCompleteTime(expectReportCompleteTime);
						}
						String reportCreateTime = (String) contentreq
								.get("reportCreateTime");
						if (reportCreateTime != null) {
							orderReturn.setReportCreateTime(reportCreateTime);
						}
						Integer servicePersonId = (Integer) contentreq
								.get("servicePersonId");
						if (servicePersonId != null) {
							orderReturn.setServicePersonId(servicePersonId);
						}
						Integer status = (Integer) contentreq.get("status");
						if (status != null) {
							orderReturn.setStatus(status);
						}
						Integer medicalReportId = (Integer) contentreq
								.get("medicalReportId");
						if (medicalReportId != null) {
							orderReturn.setMedicalReportId(medicalReportId);
						}
					}
				}
				if (true) {
					Object parentOrder = contentreq.get("parentOrder");
					if (parentOrder != null) {
						JSONObject obj = (JSONObject) parentOrder;
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
						}
					}
				}
				if (true) {
					Object childOrderList = contentreq.get("childOrderList");
					if (childOrderList != null) {
						JSONArray list = (JSONArray) childOrderList;
						if (list != null) {
							List<OrderEntity> entityList = new ArrayList<OrderEntity>();
							for (int i = 0; i < list.size(); i++) {
								JSONObject obj = list.getJSONObject(i);
								if (obj != null) {
									OrderEntity entity = new OrderEntity();

									Integer id = (Integer) obj.get("id");
									if (id != null) {
										entity.setId(id);
									}
									String orderNum = (String) obj
											.get("orderNum");
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
									String orderTime = (String) obj
											.get("orderTime");
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
									String contactWay = (String) obj
											.get("contactWay");
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
									Integer status = (Integer) obj
											.get("status");
									if (status != null) {
										entity.setStatus(status);
									}
									Integer medicalReportId = (Integer) obj
											.get("medicalReportId");
									if (medicalReportId != null) {
										entity.setMedicalReportId(medicalReportId);
									}
									entityList.add(entity);
								}
							}
							orderReturn.setChildOrderList(entityList);
						}

					}
				}
				if (true) {
					Object servicePerson = contentreq.get("servicePerson");
					if (servicePerson != null) {
						JSONObject obj = (JSONObject) servicePerson;
						if (obj != null) {
							ServicePersonEntity entity = new ServicePersonEntity();
							Integer id = (Integer) obj.get("id");
							if (id != null) {
								entity.setId(id);
							}
							String name = (String) obj.get("name");
							if (name != null) {
								entity.setName(name);
							}
							String gender = (String) obj.get("gender");
							if (gender != null) {
								entity.setGender(gender);
							}
							Object headPortrait = (Object) obj
									.get("headPortrait");
							if (headPortrait != null) {
								entity.setHeadPortrait(headPortrait);
							}
							String birthday = (String) obj.get("birthday");
							if (birthday != null) {
								entity.setBirthday(birthday);
							}
							String academic = (String) obj.get("academic");
							if (academic != null) {
								entity.setAcademic(academic);
							}
							String contact = (String) obj.get("contact");
							if (contact != null) {
								entity.setContact(contact);
							}
							String wechatNum = (String) obj.get("wechatNum");
							if (wechatNum != null) {
								entity.setWechatNum(wechatNum);
							}
							String wechatQrCode = (String) obj
									.get("wechatQrCode");
							if (wechatQrCode != null) {
								entity.setWechatQrCode(wechatQrCode);
							}
							orderReturn.setServicePerson(entity);
						}
					}
				}
				if (true) {
					Object medicalReport = contentreq.get("medicalReport");
					if (medicalReport != null) {
						JSONObject obj = (JSONObject) medicalReport;
						if (obj != null) {
							MedicalReportEntity entity = new MedicalReportEntity();
							Integer id = (Integer) obj.get("id");
							if (id != null) {
								entity.setId(id);
							}
							String medicalReportNum = (String) obj
									.get("medicalReportNum");
							if (medicalReportNum != null) {
								entity.setMedicalReportNum(medicalReportNum);
							}
							Object medicalReportStatus = (Object) obj
									.get("medicalReportStatus");
							if (medicalReportStatus != null) {
								entity.setMedicalReportStatus(medicalReportStatus);
							}
							String medicalReportExpress = (String) obj
									.get("medicalReportExpress");
							if (medicalReportExpress != null) {
								entity.setMedicalReportExpress(medicalReportExpress);
							}
							String medicalReportExpressOrderNum = (String) obj
									.get("medicalReportExpressOrderNum");
							if (medicalReportExpressOrderNum != null) {
								entity.setMedicalReportExpressOrderNum(medicalReportExpressOrderNum);
							}
							String medicalReportCreateTime = (String) obj
									.get("medicalReportCreateTime");
							if (medicalReportCreateTime != null) {
								entity.setMedicalReportCreateTime(medicalReportCreateTime);
							}
							String medicalPersonName = (String) obj
									.get("medicalPersonName");
							if (medicalPersonName != null) {
								entity.setMedicalPersonName(medicalPersonName);
							}
							Object medicalPersonGender = (Object) obj
									.get("medicalPersonGender");
							if (medicalPersonGender != null) {
								entity.setMedicalPersonGender(medicalPersonGender);
							}
							String medicalPersonCardNum = (String) obj
									.get("medicalPersonCardNum");
							if (medicalPersonCardNum != null) {
								entity.setMedicalPersonCardNum(medicalPersonCardNum);
							}
							Integer medicalPersonAge = (Integer) obj
									.get("medicalPersonAge");
							if (medicalPersonAge != null) {
								entity.setMedicalPersonAge(medicalPersonAge);
							}
							String medicalReportContent = (String) obj
									.get("medicalReportContent");
							if (medicalReportContent != null) {
								entity.setMedicalReportContent(medicalReportContent);
							}
							String medicalHospital = (String) obj
									.get("medicalHospital");
							if (medicalHospital != null) {
								entity.setMedicalHospital(medicalHospital);
							}
							orderReturn.setMedicalReport(entity);
						}
					}
				}
			} else if ("QUERY_ORDER_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String parentOrderShow = (String) contentreq
								.get("parentOrderShow");
						if ("true".equals(parentOrderShow)) {
							parentOrderShowReturn = true;
						}
						String childOrderListShow = (String) contentreq
								.get("childOrderListShow");
						if ("true".equals(childOrderListShow)) {
							childOrderListShowReturn = true;
						}
						String servicePersonShow = (String) contentreq
								.get("servicePersonShow");
						if ("true".equals(servicePersonShow)) {
							servicePersonShowReturn = true;
						}
						String medicalReportShow = (String) contentreq
								.get("medicalReportShow");
						if ("true".equals(medicalReportShow)) {
							medicalReportShowReturn = true;
						}
					}
				}
			} else if ("QUERY_ORDER_LIST_REQUEST".equals(command)) {
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
						String orderNum_like = (String) contentreq
								.get("orderNum_like");
						String orderNum_isNull = (String) contentreq
								.get("orderNum_isNull");
						String orderNum_isNotNull = (String) contentreq
								.get("orderNum_isNotNull");
						String orderNum_in = (String) contentreq
								.get("orderNum_in");
						String orderNum = (String) contentreq.get("orderNum");
						if (orderNum_like != null) {
							queryMapReturn.put("orderNum_like", orderNum_like);
						}
						if (orderNum_isNull != null) {
							queryMapReturn.put("orderNum_isNull",
									orderNum_isNull);
						}
						if (orderNum_isNotNull != null) {
							queryMapReturn.put("orderNum_isNotNull",
									orderNum_isNotNull);
						}
						if (orderNum_in != null) {
							queryMapReturn.put("orderNum_in", orderNum_in);
						}
						if (orderNum != null) {
							queryMapReturn.put("orderNum", orderNum);
						}
						Integer totalPrice_gt = (Integer) contentreq
								.get("totalPrice_gt");
						Integer totalPrice_ge = (Integer) contentreq
								.get("totalPrice_ge");
						Integer totalPrice_lt = (Integer) contentreq
								.get("totalPrice_lt");
						Integer totalPrice_le = (Integer) contentreq
								.get("totalPrice_le");
						String totalPrice_in = (String) contentreq
								.get("totalPrice_in");
						Integer totalPrice = (Integer) contentreq
								.get("totalPrice");
						if (totalPrice_gt != null) {
							queryMapReturn.put("totalPrice_gt", totalPrice_gt);
						}
						if (totalPrice_ge != null) {
							queryMapReturn.put("totalPrice_ge", totalPrice_ge);
						}
						if (totalPrice_lt != null) {
							queryMapReturn.put("totalPrice_lt", totalPrice_lt);
						}
						if (totalPrice_le != null) {
							queryMapReturn.put("totalPrice_le", totalPrice_le);
						}
						if (totalPrice_in != null) {
							queryMapReturn.put("totalPrice_in", totalPrice_in);
						}
						if (totalPrice != null) {
							queryMapReturn.put("totalPrice", totalPrice);
						}
						String orderCustomer_like = (String) contentreq
								.get("orderCustomer_like");
						String orderCustomer_isNull = (String) contentreq
								.get("orderCustomer_isNull");
						String orderCustomer_isNotNull = (String) contentreq
								.get("orderCustomer_isNotNull");
						String orderCustomer_in = (String) contentreq
								.get("orderCustomer_in");
						String orderCustomer = (String) contentreq
								.get("orderCustomer");
						if (orderCustomer_like != null) {
							queryMapReturn.put("orderCustomer_like",
									orderCustomer_like);
						}
						if (orderCustomer_isNull != null) {
							queryMapReturn.put("orderCustomer_isNull",
									orderCustomer_isNull);
						}
						if (orderCustomer_isNotNull != null) {
							queryMapReturn.put("orderCustomer_isNotNull",
									orderCustomer_isNotNull);
						}
						if (orderCustomer_in != null) {
							queryMapReturn.put("orderCustomer_in",
									orderCustomer_in);
						}
						if (orderCustomer != null) {
							queryMapReturn.put("orderCustomer", orderCustomer);
						}
						String orderTime_gt = (String) contentreq
								.get("orderTime_gt");
						String orderTime_ge = (String) contentreq
								.get("orderTime_ge");
						String orderTime_lt = (String) contentreq
								.get("orderTime_lt");
						String orderTime_le = (String) contentreq
								.get("orderTime_le");
						if (orderTime_gt != null) {
							queryMapReturn.put("orderTime_gt", orderTime_gt);
						}
						if (orderTime_ge != null) {
							queryMapReturn.put("orderTime_ge", orderTime_ge);
						}
						if (orderTime_lt != null) {
							queryMapReturn.put("orderTime_lt", orderTime_lt);
						}
						if (orderTime_le != null) {
							queryMapReturn.put("orderTime_le", orderTime_le);
						}
						String medicalHospital_like = (String) contentreq
								.get("medicalHospital_like");
						String medicalHospital_isNull = (String) contentreq
								.get("medicalHospital_isNull");
						String medicalHospital_isNotNull = (String) contentreq
								.get("medicalHospital_isNotNull");
						String medicalHospital_in = (String) contentreq
								.get("medicalHospital_in");
						String medicalHospital = (String) contentreq
								.get("medicalHospital");
						if (medicalHospital_like != null) {
							queryMapReturn.put("medicalHospital_like",
									medicalHospital_like);
						}
						if (medicalHospital_isNull != null) {
							queryMapReturn.put("medicalHospital_isNull",
									medicalHospital_isNull);
						}
						if (medicalHospital_isNotNull != null) {
							queryMapReturn.put("medicalHospital_isNotNull",
									medicalHospital_isNotNull);
						}
						if (medicalHospital_in != null) {
							queryMapReturn.put("medicalHospital_in",
									medicalHospital_in);
						}
						if (medicalHospital != null) {
							queryMapReturn.put("medicalHospital",
									medicalHospital);
						}
						String medicalPersonName_like = (String) contentreq
								.get("medicalPersonName_like");
						String medicalPersonName_isNull = (String) contentreq
								.get("medicalPersonName_isNull");
						String medicalPersonName_isNotNull = (String) contentreq
								.get("medicalPersonName_isNotNull");
						String medicalPersonName_in = (String) contentreq
								.get("medicalPersonName_in");
						String medicalPersonName = (String) contentreq
								.get("medicalPersonName");
						if (medicalPersonName_like != null) {
							queryMapReturn.put("medicalPersonName_like",
									medicalPersonName_like);
						}
						if (medicalPersonName_isNull != null) {
							queryMapReturn.put("medicalPersonName_isNull",
									medicalPersonName_isNull);
						}
						if (medicalPersonName_isNotNull != null) {
							queryMapReturn.put("medicalPersonName_isNotNull",
									medicalPersonName_isNotNull);
						}
						if (medicalPersonName_in != null) {
							queryMapReturn.put("medicalPersonName_in",
									medicalPersonName_in);
						}
						if (medicalPersonName != null) {
							queryMapReturn.put("medicalPersonName",
									medicalPersonName);
						}
						String medicalPersonCard_like = (String) contentreq
								.get("medicalPersonCard_like");
						String medicalPersonCard_isNull = (String) contentreq
								.get("medicalPersonCard_isNull");
						String medicalPersonCard_isNotNull = (String) contentreq
								.get("medicalPersonCard_isNotNull");
						String medicalPersonCard_in = (String) contentreq
								.get("medicalPersonCard_in");
						String medicalPersonCard = (String) contentreq
								.get("medicalPersonCard");
						if (medicalPersonCard_like != null) {
							queryMapReturn.put("medicalPersonCard_like",
									medicalPersonCard_like);
						}
						if (medicalPersonCard_isNull != null) {
							queryMapReturn.put("medicalPersonCard_isNull",
									medicalPersonCard_isNull);
						}
						if (medicalPersonCard_isNotNull != null) {
							queryMapReturn.put("medicalPersonCard_isNotNull",
									medicalPersonCard_isNotNull);
						}
						if (medicalPersonCard_in != null) {
							queryMapReturn.put("medicalPersonCard_in",
									medicalPersonCard_in);
						}
						if (medicalPersonCard != null) {
							queryMapReturn.put("medicalPersonCard",
									medicalPersonCard);
						}
						String medicalPersonGender_like = (String) contentreq
								.get("medicalPersonGender_like");
						String medicalPersonGender_isNull = (String) contentreq
								.get("medicalPersonGender_isNull");
						String medicalPersonGender_isNotNull = (String) contentreq
								.get("medicalPersonGender_isNotNull");
						String medicalPersonGender_in = (String) contentreq
								.get("medicalPersonGender_in");
						String medicalPersonGender = (String) contentreq
								.get("medicalPersonGender");
						if (medicalPersonGender_like != null) {
							queryMapReturn.put("medicalPersonGender_like",
									medicalPersonGender_like);
						}
						if (medicalPersonGender_isNull != null) {
							queryMapReturn.put("medicalPersonGender_isNull",
									medicalPersonGender_isNull);
						}
						if (medicalPersonGender_isNotNull != null) {
							queryMapReturn.put("medicalPersonGender_isNotNull",
									medicalPersonGender_isNotNull);
						}
						if (medicalPersonGender_in != null) {
							queryMapReturn.put("medicalPersonGender_in",
									medicalPersonGender_in);
						}
						if (medicalPersonGender != null) {
							queryMapReturn.put("medicalPersonGender",
									medicalPersonGender);
						}
						String contactWay_like = (String) contentreq
								.get("contactWay_like");
						String contactWay_isNull = (String) contentreq
								.get("contactWay_isNull");
						String contactWay_isNotNull = (String) contentreq
								.get("contactWay_isNotNull");
						String contactWay_in = (String) contentreq
								.get("contactWay_in");
						String contactWay = (String) contentreq
								.get("contactWay");
						if (contactWay_like != null) {
							queryMapReturn.put("contactWay_like",
									contactWay_like);
						}
						if (contactWay_isNull != null) {
							queryMapReturn.put("contactWay_isNull",
									contactWay_isNull);
						}
						if (contactWay_isNotNull != null) {
							queryMapReturn.put("contactWay_isNotNull",
									contactWay_isNotNull);
						}
						if (contactWay_in != null) {
							queryMapReturn.put("contactWay_in", contactWay_in);
						}
						if (contactWay != null) {
							queryMapReturn.put("contactWay", contactWay);
						}
						String reportSendAddr_like = (String) contentreq
								.get("reportSendAddr_like");
						String reportSendAddr_isNull = (String) contentreq
								.get("reportSendAddr_isNull");
						String reportSendAddr_isNotNull = (String) contentreq
								.get("reportSendAddr_isNotNull");
						String reportSendAddr_in = (String) contentreq
								.get("reportSendAddr_in");
						String reportSendAddr = (String) contentreq
								.get("reportSendAddr");
						if (reportSendAddr_like != null) {
							queryMapReturn.put("reportSendAddr_like",
									reportSendAddr_like);
						}
						if (reportSendAddr_isNull != null) {
							queryMapReturn.put("reportSendAddr_isNull",
									reportSendAddr_isNull);
						}
						if (reportSendAddr_isNotNull != null) {
							queryMapReturn.put("reportSendAddr_isNotNull",
									reportSendAddr_isNotNull);
						}
						if (reportSendAddr_in != null) {
							queryMapReturn.put("reportSendAddr_in",
									reportSendAddr_in);
						}
						if (reportSendAddr != null) {
							queryMapReturn
									.put("reportSendAddr", reportSendAddr);
						}
						String expectMedicalTime_gt = (String) contentreq
								.get("expectMedicalTime_gt");
						String expectMedicalTime_ge = (String) contentreq
								.get("expectMedicalTime_ge");
						String expectMedicalTime_lt = (String) contentreq
								.get("expectMedicalTime_lt");
						String expectMedicalTime_le = (String) contentreq
								.get("expectMedicalTime_le");
						if (expectMedicalTime_gt != null) {
							queryMapReturn.put("expectMedicalTime_gt",
									expectMedicalTime_gt);
						}
						if (expectMedicalTime_ge != null) {
							queryMapReturn.put("expectMedicalTime_ge",
									expectMedicalTime_ge);
						}
						if (expectMedicalTime_lt != null) {
							queryMapReturn.put("expectMedicalTime_lt",
									expectMedicalTime_lt);
						}
						if (expectMedicalTime_le != null) {
							queryMapReturn.put("expectMedicalTime_le",
									expectMedicalTime_le);
						}
						String medicalCompleteTime_gt = (String) contentreq
								.get("medicalCompleteTime_gt");
						String medicalCompleteTime_ge = (String) contentreq
								.get("medicalCompleteTime_ge");
						String medicalCompleteTime_lt = (String) contentreq
								.get("medicalCompleteTime_lt");
						String medicalCompleteTime_le = (String) contentreq
								.get("medicalCompleteTime_le");
						if (medicalCompleteTime_gt != null) {
							queryMapReturn.put("medicalCompleteTime_gt",
									medicalCompleteTime_gt);
						}
						if (medicalCompleteTime_ge != null) {
							queryMapReturn.put("medicalCompleteTime_ge",
									medicalCompleteTime_ge);
						}
						if (medicalCompleteTime_lt != null) {
							queryMapReturn.put("medicalCompleteTime_lt",
									medicalCompleteTime_lt);
						}
						if (medicalCompleteTime_le != null) {
							queryMapReturn.put("medicalCompleteTime_le",
									medicalCompleteTime_le);
						}
						String expectReportCompleteTime_gt = (String) contentreq
								.get("expectReportCompleteTime_gt");
						String expectReportCompleteTime_ge = (String) contentreq
								.get("expectReportCompleteTime_ge");
						String expectReportCompleteTime_lt = (String) contentreq
								.get("expectReportCompleteTime_lt");
						String expectReportCompleteTime_le = (String) contentreq
								.get("expectReportCompleteTime_le");
						if (expectReportCompleteTime_gt != null) {
							queryMapReturn.put("expectReportCompleteTime_gt",
									expectReportCompleteTime_gt);
						}
						if (expectReportCompleteTime_ge != null) {
							queryMapReturn.put("expectReportCompleteTime_ge",
									expectReportCompleteTime_ge);
						}
						if (expectReportCompleteTime_lt != null) {
							queryMapReturn.put("expectReportCompleteTime_lt",
									expectReportCompleteTime_lt);
						}
						if (expectReportCompleteTime_le != null) {
							queryMapReturn.put("expectReportCompleteTime_le",
									expectReportCompleteTime_le);
						}
						String reportCreateTime_gt = (String) contentreq
								.get("reportCreateTime_gt");
						String reportCreateTime_ge = (String) contentreq
								.get("reportCreateTime_ge");
						String reportCreateTime_lt = (String) contentreq
								.get("reportCreateTime_lt");
						String reportCreateTime_le = (String) contentreq
								.get("reportCreateTime_le");
						if (reportCreateTime_gt != null) {
							queryMapReturn.put("reportCreateTime_gt",
									reportCreateTime_gt);
						}
						if (reportCreateTime_ge != null) {
							queryMapReturn.put("reportCreateTime_ge",
									reportCreateTime_ge);
						}
						if (reportCreateTime_lt != null) {
							queryMapReturn.put("reportCreateTime_lt",
									reportCreateTime_lt);
						}
						if (reportCreateTime_le != null) {
							queryMapReturn.put("reportCreateTime_le",
									reportCreateTime_le);
						}
						Integer servicePersonId_gt = (Integer) contentreq
								.get("servicePersonId_gt");
						Integer servicePersonId_ge = (Integer) contentreq
								.get("servicePersonId_ge");
						Integer servicePersonId_lt = (Integer) contentreq
								.get("servicePersonId_lt");
						Integer servicePersonId_le = (Integer) contentreq
								.get("servicePersonId_le");
						String servicePersonId_in = (String) contentreq
								.get("servicePersonId_in");
						Integer servicePersonId = (Integer) contentreq
								.get("servicePersonId");
						if (servicePersonId_gt != null) {
							queryMapReturn.put("servicePersonId_gt",
									servicePersonId_gt);
						}
						if (servicePersonId_ge != null) {
							queryMapReturn.put("servicePersonId_ge",
									servicePersonId_ge);
						}
						if (servicePersonId_lt != null) {
							queryMapReturn.put("servicePersonId_lt",
									servicePersonId_lt);
						}
						if (servicePersonId_le != null) {
							queryMapReturn.put("servicePersonId_le",
									servicePersonId_le);
						}
						if (servicePersonId_in != null) {
							queryMapReturn.put("servicePersonId_in",
									servicePersonId_in);
						}
						if (servicePersonId != null) {
							queryMapReturn.put("servicePersonId",
									servicePersonId);
						}
						Integer status_gt = (Integer) contentreq
								.get("status_gt");
						Integer status_ge = (Integer) contentreq
								.get("status_ge");
						Integer status_lt = (Integer) contentreq
								.get("status_lt");
						Integer status_le = (Integer) contentreq
								.get("status_le");
						String status_in = (String) contentreq.get("status_in");
						Integer status = (Integer) contentreq.get("status");
						if (status_gt != null) {
							queryMapReturn.put("status_gt", status_gt);
						}
						if (status_ge != null) {
							queryMapReturn.put("status_ge", status_ge);
						}
						if (status_lt != null) {
							queryMapReturn.put("status_lt", status_lt);
						}
						if (status_le != null) {
							queryMapReturn.put("status_le", status_le);
						}
						if (status_in != null) {
							queryMapReturn.put("status_in", status_in);
						}
						if (status != null) {
							queryMapReturn.put("status", status);
						}
						Integer medicalReportId_gt = (Integer) contentreq
								.get("medicalReportId_gt");
						Integer medicalReportId_ge = (Integer) contentreq
								.get("medicalReportId_ge");
						Integer medicalReportId_lt = (Integer) contentreq
								.get("medicalReportId_lt");
						Integer medicalReportId_le = (Integer) contentreq
								.get("medicalReportId_le");
						String medicalReportId_in = (String) contentreq
								.get("medicalReportId_in");
						Integer medicalReportId = (Integer) contentreq
								.get("medicalReportId");
						if (medicalReportId_gt != null) {
							queryMapReturn.put("medicalReportId_gt",
									medicalReportId_gt);
						}
						if (medicalReportId_ge != null) {
							queryMapReturn.put("medicalReportId_ge",
									medicalReportId_ge);
						}
						if (medicalReportId_lt != null) {
							queryMapReturn.put("medicalReportId_lt",
									medicalReportId_lt);
						}
						if (medicalReportId_le != null) {
							queryMapReturn.put("medicalReportId_le",
									medicalReportId_le);
						}
						if (medicalReportId_in != null) {
							queryMapReturn.put("medicalReportId_in",
									medicalReportId_in);
						}
						if (medicalReportId != null) {
							queryMapReturn.put("medicalReportId",
									medicalReportId);
						}

						String parentOrderShow = (String) contentreq
								.get("parentOrderShow");
						if ("true".equals(parentOrderShow)) {
							parentOrderShowReturn = true;
						}
						String childOrderListShow = (String) contentreq
								.get("childOrderListShow");
						if ("true".equals(childOrderListShow)) {
							childOrderListShowReturn = true;
						}
						String servicePersonShow = (String) contentreq
								.get("servicePersonShow");
						if ("true".equals(servicePersonShow)) {
							servicePersonShowReturn = true;
						}
						String medicalReportShow = (String) contentreq
								.get("medicalReportShow");
						if ("true".equals(medicalReportShow)) {
							medicalReportShowReturn = true;
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
			} else if ("DEL_ORDER_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String delParentOrder = (String) contentreq
								.get("delParentOrder");
						if ("true".equals(delParentOrder)) {
							delParentOrderReturn = true;
						}
						String delChildOrderList = (String) contentreq
								.get("delChildOrderList");
						if ("true".equals(delChildOrderList)) {
							delChildOrderListReturn = true;
						}
						String delServicePerson = (String) contentreq
								.get("delServicePerson");
						if ("true".equals(delServicePerson)) {
							delServicePersonReturn = true;
						}
						String delMedicalReport = (String) contentreq
								.get("delMedicalReport");
						if ("true".equals(delMedicalReport)) {
							delMedicalReportReturn = true;
						}
					}
				}
			} else if ("DEL_ORDER_LIST_REQUEST".equals(command)) {
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
						String orderNum_like = (String) contentreq
								.get("orderNum_like");
						String orderNum_isNull = (String) contentreq
								.get("orderNum_isNull");
						String orderNum_isNotNull = (String) contentreq
								.get("orderNum_isNotNull");
						String orderNum_in = (String) contentreq
								.get("orderNum_in");
						String orderNum = (String) contentreq.get("orderNum");
						if (orderNum_like != null) {
							queryMapReturn.put("orderNum_like", orderNum_like);
						}
						if (orderNum_isNull != null) {
							queryMapReturn.put("orderNum_isNull",
									orderNum_isNull);
						}
						if (orderNum_isNotNull != null) {
							queryMapReturn.put("orderNum_isNotNull",
									orderNum_isNotNull);
						}
						if (orderNum_in != null) {
							queryMapReturn.put("orderNum_in", orderNum_in);
						}
						if (orderNum != null) {
							queryMapReturn.put("orderNum", orderNum);
						}
						Integer totalPrice_gt = (Integer) contentreq
								.get("totalPrice_gt");
						Integer totalPrice_ge = (Integer) contentreq
								.get("totalPrice_ge");
						Integer totalPrice_lt = (Integer) contentreq
								.get("totalPrice_lt");
						Integer totalPrice_le = (Integer) contentreq
								.get("totalPrice_le");
						String totalPrice_in = (String) contentreq
								.get("totalPrice_in");
						Integer totalPrice = (Integer) contentreq
								.get("totalPrice");
						if (totalPrice_gt != null) {
							queryMapReturn.put("totalPrice_gt", totalPrice_gt);
						}
						if (totalPrice_ge != null) {
							queryMapReturn.put("totalPrice_ge", totalPrice_ge);
						}
						if (totalPrice_lt != null) {
							queryMapReturn.put("totalPrice_lt", totalPrice_lt);
						}
						if (totalPrice_le != null) {
							queryMapReturn.put("totalPrice_le", totalPrice_le);
						}
						if (totalPrice_in != null) {
							queryMapReturn.put("totalPrice_in", totalPrice_in);
						}
						if (totalPrice != null) {
							queryMapReturn.put("totalPrice", totalPrice);
						}
						String orderCustomer_like = (String) contentreq
								.get("orderCustomer_like");
						String orderCustomer_isNull = (String) contentreq
								.get("orderCustomer_isNull");
						String orderCustomer_isNotNull = (String) contentreq
								.get("orderCustomer_isNotNull");
						String orderCustomer_in = (String) contentreq
								.get("orderCustomer_in");
						String orderCustomer = (String) contentreq
								.get("orderCustomer");
						if (orderCustomer_like != null) {
							queryMapReturn.put("orderCustomer_like",
									orderCustomer_like);
						}
						if (orderCustomer_isNull != null) {
							queryMapReturn.put("orderCustomer_isNull",
									orderCustomer_isNull);
						}
						if (orderCustomer_isNotNull != null) {
							queryMapReturn.put("orderCustomer_isNotNull",
									orderCustomer_isNotNull);
						}
						if (orderCustomer_in != null) {
							queryMapReturn.put("orderCustomer_in",
									orderCustomer_in);
						}
						if (orderCustomer != null) {
							queryMapReturn.put("orderCustomer", orderCustomer);
						}
						String orderTime_gt = (String) contentreq
								.get("orderTime_gt");
						String orderTime_ge = (String) contentreq
								.get("orderTime_ge");
						String orderTime_lt = (String) contentreq
								.get("orderTime_lt");
						String orderTime_le = (String) contentreq
								.get("orderTime_le");
						if (orderTime_gt != null) {
							queryMapReturn.put("orderTime_gt", orderTime_gt);
						}
						if (orderTime_ge != null) {
							queryMapReturn.put("orderTime_ge", orderTime_ge);
						}
						if (orderTime_lt != null) {
							queryMapReturn.put("orderTime_lt", orderTime_lt);
						}
						if (orderTime_le != null) {
							queryMapReturn.put("orderTime_le", orderTime_le);
						}
						String medicalHospital_like = (String) contentreq
								.get("medicalHospital_like");
						String medicalHospital_isNull = (String) contentreq
								.get("medicalHospital_isNull");
						String medicalHospital_isNotNull = (String) contentreq
								.get("medicalHospital_isNotNull");
						String medicalHospital_in = (String) contentreq
								.get("medicalHospital_in");
						String medicalHospital = (String) contentreq
								.get("medicalHospital");
						if (medicalHospital_like != null) {
							queryMapReturn.put("medicalHospital_like",
									medicalHospital_like);
						}
						if (medicalHospital_isNull != null) {
							queryMapReturn.put("medicalHospital_isNull",
									medicalHospital_isNull);
						}
						if (medicalHospital_isNotNull != null) {
							queryMapReturn.put("medicalHospital_isNotNull",
									medicalHospital_isNotNull);
						}
						if (medicalHospital_in != null) {
							queryMapReturn.put("medicalHospital_in",
									medicalHospital_in);
						}
						if (medicalHospital != null) {
							queryMapReturn.put("medicalHospital",
									medicalHospital);
						}
						String medicalPersonName_like = (String) contentreq
								.get("medicalPersonName_like");
						String medicalPersonName_isNull = (String) contentreq
								.get("medicalPersonName_isNull");
						String medicalPersonName_isNotNull = (String) contentreq
								.get("medicalPersonName_isNotNull");
						String medicalPersonName_in = (String) contentreq
								.get("medicalPersonName_in");
						String medicalPersonName = (String) contentreq
								.get("medicalPersonName");
						if (medicalPersonName_like != null) {
							queryMapReturn.put("medicalPersonName_like",
									medicalPersonName_like);
						}
						if (medicalPersonName_isNull != null) {
							queryMapReturn.put("medicalPersonName_isNull",
									medicalPersonName_isNull);
						}
						if (medicalPersonName_isNotNull != null) {
							queryMapReturn.put("medicalPersonName_isNotNull",
									medicalPersonName_isNotNull);
						}
						if (medicalPersonName_in != null) {
							queryMapReturn.put("medicalPersonName_in",
									medicalPersonName_in);
						}
						if (medicalPersonName != null) {
							queryMapReturn.put("medicalPersonName",
									medicalPersonName);
						}
						String medicalPersonCard_like = (String) contentreq
								.get("medicalPersonCard_like");
						String medicalPersonCard_isNull = (String) contentreq
								.get("medicalPersonCard_isNull");
						String medicalPersonCard_isNotNull = (String) contentreq
								.get("medicalPersonCard_isNotNull");
						String medicalPersonCard_in = (String) contentreq
								.get("medicalPersonCard_in");
						String medicalPersonCard = (String) contentreq
								.get("medicalPersonCard");
						if (medicalPersonCard_like != null) {
							queryMapReturn.put("medicalPersonCard_like",
									medicalPersonCard_like);
						}
						if (medicalPersonCard_isNull != null) {
							queryMapReturn.put("medicalPersonCard_isNull",
									medicalPersonCard_isNull);
						}
						if (medicalPersonCard_isNotNull != null) {
							queryMapReturn.put("medicalPersonCard_isNotNull",
									medicalPersonCard_isNotNull);
						}
						if (medicalPersonCard_in != null) {
							queryMapReturn.put("medicalPersonCard_in",
									medicalPersonCard_in);
						}
						if (medicalPersonCard != null) {
							queryMapReturn.put("medicalPersonCard",
									medicalPersonCard);
						}
						String medicalPersonGender_like = (String) contentreq
								.get("medicalPersonGender_like");
						String medicalPersonGender_isNull = (String) contentreq
								.get("medicalPersonGender_isNull");
						String medicalPersonGender_isNotNull = (String) contentreq
								.get("medicalPersonGender_isNotNull");
						String medicalPersonGender_in = (String) contentreq
								.get("medicalPersonGender_in");
						String medicalPersonGender = (String) contentreq
								.get("medicalPersonGender");
						if (medicalPersonGender_like != null) {
							queryMapReturn.put("medicalPersonGender_like",
									medicalPersonGender_like);
						}
						if (medicalPersonGender_isNull != null) {
							queryMapReturn.put("medicalPersonGender_isNull",
									medicalPersonGender_isNull);
						}
						if (medicalPersonGender_isNotNull != null) {
							queryMapReturn.put("medicalPersonGender_isNotNull",
									medicalPersonGender_isNotNull);
						}
						if (medicalPersonGender_in != null) {
							queryMapReturn.put("medicalPersonGender_in",
									medicalPersonGender_in);
						}
						if (medicalPersonGender != null) {
							queryMapReturn.put("medicalPersonGender",
									medicalPersonGender);
						}
						String contactWay_like = (String) contentreq
								.get("contactWay_like");
						String contactWay_isNull = (String) contentreq
								.get("contactWay_isNull");
						String contactWay_isNotNull = (String) contentreq
								.get("contactWay_isNotNull");
						String contactWay_in = (String) contentreq
								.get("contactWay_in");
						String contactWay = (String) contentreq
								.get("contactWay");
						if (contactWay_like != null) {
							queryMapReturn.put("contactWay_like",
									contactWay_like);
						}
						if (contactWay_isNull != null) {
							queryMapReturn.put("contactWay_isNull",
									contactWay_isNull);
						}
						if (contactWay_isNotNull != null) {
							queryMapReturn.put("contactWay_isNotNull",
									contactWay_isNotNull);
						}
						if (contactWay_in != null) {
							queryMapReturn.put("contactWay_in", contactWay_in);
						}
						if (contactWay != null) {
							queryMapReturn.put("contactWay", contactWay);
						}
						String reportSendAddr_like = (String) contentreq
								.get("reportSendAddr_like");
						String reportSendAddr_isNull = (String) contentreq
								.get("reportSendAddr_isNull");
						String reportSendAddr_isNotNull = (String) contentreq
								.get("reportSendAddr_isNotNull");
						String reportSendAddr_in = (String) contentreq
								.get("reportSendAddr_in");
						String reportSendAddr = (String) contentreq
								.get("reportSendAddr");
						if (reportSendAddr_like != null) {
							queryMapReturn.put("reportSendAddr_like",
									reportSendAddr_like);
						}
						if (reportSendAddr_isNull != null) {
							queryMapReturn.put("reportSendAddr_isNull",
									reportSendAddr_isNull);
						}
						if (reportSendAddr_isNotNull != null) {
							queryMapReturn.put("reportSendAddr_isNotNull",
									reportSendAddr_isNotNull);
						}
						if (reportSendAddr_in != null) {
							queryMapReturn.put("reportSendAddr_in",
									reportSendAddr_in);
						}
						if (reportSendAddr != null) {
							queryMapReturn
									.put("reportSendAddr", reportSendAddr);
						}
						String expectMedicalTime_gt = (String) contentreq
								.get("expectMedicalTime_gt");
						String expectMedicalTime_ge = (String) contentreq
								.get("expectMedicalTime_ge");
						String expectMedicalTime_lt = (String) contentreq
								.get("expectMedicalTime_lt");
						String expectMedicalTime_le = (String) contentreq
								.get("expectMedicalTime_le");
						if (expectMedicalTime_gt != null) {
							queryMapReturn.put("expectMedicalTime_gt",
									expectMedicalTime_gt);
						}
						if (expectMedicalTime_ge != null) {
							queryMapReturn.put("expectMedicalTime_ge",
									expectMedicalTime_ge);
						}
						if (expectMedicalTime_lt != null) {
							queryMapReturn.put("expectMedicalTime_lt",
									expectMedicalTime_lt);
						}
						if (expectMedicalTime_le != null) {
							queryMapReturn.put("expectMedicalTime_le",
									expectMedicalTime_le);
						}
						String medicalCompleteTime_gt = (String) contentreq
								.get("medicalCompleteTime_gt");
						String medicalCompleteTime_ge = (String) contentreq
								.get("medicalCompleteTime_ge");
						String medicalCompleteTime_lt = (String) contentreq
								.get("medicalCompleteTime_lt");
						String medicalCompleteTime_le = (String) contentreq
								.get("medicalCompleteTime_le");
						if (medicalCompleteTime_gt != null) {
							queryMapReturn.put("medicalCompleteTime_gt",
									medicalCompleteTime_gt);
						}
						if (medicalCompleteTime_ge != null) {
							queryMapReturn.put("medicalCompleteTime_ge",
									medicalCompleteTime_ge);
						}
						if (medicalCompleteTime_lt != null) {
							queryMapReturn.put("medicalCompleteTime_lt",
									medicalCompleteTime_lt);
						}
						if (medicalCompleteTime_le != null) {
							queryMapReturn.put("medicalCompleteTime_le",
									medicalCompleteTime_le);
						}
						String expectReportCompleteTime_gt = (String) contentreq
								.get("expectReportCompleteTime_gt");
						String expectReportCompleteTime_ge = (String) contentreq
								.get("expectReportCompleteTime_ge");
						String expectReportCompleteTime_lt = (String) contentreq
								.get("expectReportCompleteTime_lt");
						String expectReportCompleteTime_le = (String) contentreq
								.get("expectReportCompleteTime_le");
						if (expectReportCompleteTime_gt != null) {
							queryMapReturn.put("expectReportCompleteTime_gt",
									expectReportCompleteTime_gt);
						}
						if (expectReportCompleteTime_ge != null) {
							queryMapReturn.put("expectReportCompleteTime_ge",
									expectReportCompleteTime_ge);
						}
						if (expectReportCompleteTime_lt != null) {
							queryMapReturn.put("expectReportCompleteTime_lt",
									expectReportCompleteTime_lt);
						}
						if (expectReportCompleteTime_le != null) {
							queryMapReturn.put("expectReportCompleteTime_le",
									expectReportCompleteTime_le);
						}
						String reportCreateTime_gt = (String) contentreq
								.get("reportCreateTime_gt");
						String reportCreateTime_ge = (String) contentreq
								.get("reportCreateTime_ge");
						String reportCreateTime_lt = (String) contentreq
								.get("reportCreateTime_lt");
						String reportCreateTime_le = (String) contentreq
								.get("reportCreateTime_le");
						if (reportCreateTime_gt != null) {
							queryMapReturn.put("reportCreateTime_gt",
									reportCreateTime_gt);
						}
						if (reportCreateTime_ge != null) {
							queryMapReturn.put("reportCreateTime_ge",
									reportCreateTime_ge);
						}
						if (reportCreateTime_lt != null) {
							queryMapReturn.put("reportCreateTime_lt",
									reportCreateTime_lt);
						}
						if (reportCreateTime_le != null) {
							queryMapReturn.put("reportCreateTime_le",
									reportCreateTime_le);
						}
						Integer servicePersonId_gt = (Integer) contentreq
								.get("servicePersonId_gt");
						Integer servicePersonId_ge = (Integer) contentreq
								.get("servicePersonId_ge");
						Integer servicePersonId_lt = (Integer) contentreq
								.get("servicePersonId_lt");
						Integer servicePersonId_le = (Integer) contentreq
								.get("servicePersonId_le");
						String servicePersonId_in = (String) contentreq
								.get("servicePersonId_in");
						Integer servicePersonId = (Integer) contentreq
								.get("servicePersonId");
						if (servicePersonId_gt != null) {
							queryMapReturn.put("servicePersonId_gt",
									servicePersonId_gt);
						}
						if (servicePersonId_ge != null) {
							queryMapReturn.put("servicePersonId_ge",
									servicePersonId_ge);
						}
						if (servicePersonId_lt != null) {
							queryMapReturn.put("servicePersonId_lt",
									servicePersonId_lt);
						}
						if (servicePersonId_le != null) {
							queryMapReturn.put("servicePersonId_le",
									servicePersonId_le);
						}
						if (servicePersonId_in != null) {
							queryMapReturn.put("servicePersonId_in",
									servicePersonId_in);
						}
						if (servicePersonId != null) {
							queryMapReturn.put("servicePersonId",
									servicePersonId);
						}
						Integer status_gt = (Integer) contentreq
								.get("status_gt");
						Integer status_ge = (Integer) contentreq
								.get("status_ge");
						Integer status_lt = (Integer) contentreq
								.get("status_lt");
						Integer status_le = (Integer) contentreq
								.get("status_le");
						String status_in = (String) contentreq.get("status_in");
						Integer status = (Integer) contentreq.get("status");
						if (status_gt != null) {
							queryMapReturn.put("status_gt", status_gt);
						}
						if (status_ge != null) {
							queryMapReturn.put("status_ge", status_ge);
						}
						if (status_lt != null) {
							queryMapReturn.put("status_lt", status_lt);
						}
						if (status_le != null) {
							queryMapReturn.put("status_le", status_le);
						}
						if (status_in != null) {
							queryMapReturn.put("status_in", status_in);
						}
						if (status != null) {
							queryMapReturn.put("status", status);
						}
						Integer medicalReportId_gt = (Integer) contentreq
								.get("medicalReportId_gt");
						Integer medicalReportId_ge = (Integer) contentreq
								.get("medicalReportId_ge");
						Integer medicalReportId_lt = (Integer) contentreq
								.get("medicalReportId_lt");
						Integer medicalReportId_le = (Integer) contentreq
								.get("medicalReportId_le");
						String medicalReportId_in = (String) contentreq
								.get("medicalReportId_in");
						Integer medicalReportId = (Integer) contentreq
								.get("medicalReportId");
						if (medicalReportId_gt != null) {
							queryMapReturn.put("medicalReportId_gt",
									medicalReportId_gt);
						}
						if (medicalReportId_ge != null) {
							queryMapReturn.put("medicalReportId_ge",
									medicalReportId_ge);
						}
						if (medicalReportId_lt != null) {
							queryMapReturn.put("medicalReportId_lt",
									medicalReportId_lt);
						}
						if (medicalReportId_le != null) {
							queryMapReturn.put("medicalReportId_le",
									medicalReportId_le);
						}
						if (medicalReportId_in != null) {
							queryMapReturn.put("medicalReportId_in",
									medicalReportId_in);
						}
						if (medicalReportId != null) {
							queryMapReturn.put("medicalReportId",
									medicalReportId);
						}

						String delParentOrder = (String) contentreq
								.get("delParentOrder");
						if ("true".equals(delParentOrder)) {
							delParentOrderReturn = true;
						}
						String delChildOrderList = (String) contentreq
								.get("delChildOrderList");
						if ("true".equals(delChildOrderList)) {
							delChildOrderListReturn = true;
						}
						String delServicePerson = (String) contentreq
								.get("delServicePerson");
						if ("true".equals(delServicePerson)) {
							delServicePersonReturn = true;
						}
						String delMedicalReport = (String) contentreq
								.get("delMedicalReport");
						if ("true".equals(delMedicalReport)) {
							delMedicalReportReturn = true;
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
			if (orderReturn != null) {
				parseMap.put("order", orderReturn);
			}
			if (orderListReturn != null && orderListReturn.size() > 0) {
				parseMap.put("orderList", orderListReturn);
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

			if (parentOrderShowReturn != null) {
				parseMap.put("parentOrderShow", parentOrderShowReturn);
			}
			if (delParentOrderReturn != null) {
				parseMap.put("delParentOrder", delParentOrderReturn);
			}
			if (delParentOrderListReturn != null) {
				parseMap.put("delParentOrderList", delParentOrderListReturn);
			}
			if (childOrderListShowReturn != null) {
				parseMap.put("childOrderListShow", childOrderListShowReturn);
			}
			if (delChildOrderListReturn != null) {
				parseMap.put("delChildOrderList", delChildOrderListReturn);
			}
			if (servicePersonShowReturn != null) {
				parseMap.put("servicePersonShow", servicePersonShowReturn);
			}
			if (delServicePersonReturn != null) {
				parseMap.put("delServicePerson", delServicePersonReturn);
			}
			if (medicalReportShowReturn != null) {
				parseMap.put("medicalReportShow", medicalReportShowReturn);
			}
			if (delMedicalReportReturn != null) {
				parseMap.put("delMedicalReport", delMedicalReportReturn);
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
