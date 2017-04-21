package mis.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mis.entity.OrderEntity;
import mis.entity.PayInfoEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.db.manager.DBManager;
import com.framework.system.db.query.OrderVO;
import com.framework.system.util.JsonUtil;

/**
 * @Title: Parse
 * @Description: 支付信息表解析器
 * @author feng.gu
 * @date 2017-04-21 17:17:50
 * @version V1.0
 * 
 */
public class PayInfoParse {
	private static Logger logger = Logger.getLogger(PayInfoParse.class);
	private static PayInfoParse payInfoParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static PayInfoParse getInstance() {
		if (payInfoParse == null) {
			payInfoParse = new PayInfoParse();
		}
		return payInfoParse;
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
			PayInfoEntity payInfoReturn = null;
			List<PayInfoEntity> payInfoListReturn = null;
			Integer idReturn = null;
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;

			Boolean orderEntityShowReturn = false;
			Boolean delOrderEntityReturn = false;

			// json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject) reqParams.get("content");
			if ("ADD_PAY_INFO_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				payInfoReturn = new PayInfoEntity();
				if (true) {
					if (contentreq != null) {
						Integer id = (Integer) contentreq.get("id");
						if (id != null) {
							payInfoReturn = (PayInfoEntity) dbManager.getById(
									id, PayInfoEntity.class);
							payInfoReturn.setId(id);
						}
						Integer orderId = (Integer) contentreq.get("orderId");
						if (orderId != null) {
							payInfoReturn.setOrderId(orderId);
						}
						Double money = JsonUtil.getJSONDouble(contentreq,
								"money");
						if (money != null) {
							payInfoReturn.setMoney(money);
						}
						Object type = (Object) contentreq.get("type");
						if (type != null) {
							payInfoReturn.setType(type);
						}
						String payTime = (String) contentreq.get("payTime");
						if (payTime != null) {
							payInfoReturn.setPayTime(payTime);
						}
						String payNum = (String) contentreq.get("payNum");
						if (payNum != null) {
							payInfoReturn.setPayNum(payNum);
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
							payInfoReturn.setOrderEntity(entity);
						}
					}
				}
			} else if ("QUERY_PAY_INFO_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String orderEntityShow = (String) contentreq
								.get("orderEntityShow");
						if ("true".equals(orderEntityShow)) {
							orderEntityShowReturn = true;
						}
					}
				}
			} else if ("QUERY_PAY_INFO_LIST_REQUEST".equals(command)) {
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
						String money_like = (String) contentreq
								.get("money_like");
						String money_isNull = (String) contentreq
								.get("money_isNull");
						String money_isNotNull = (String) contentreq
								.get("money_isNotNull");
						String money_in = (String) contentreq.get("money_in");
						String money = (String) contentreq.get("money");
						if (money_like != null) {
							queryMapReturn.put("money_like", money_like);
						}
						if (money_isNull != null) {
							queryMapReturn.put("money_isNull", money_isNull);
						}
						if (money_isNotNull != null) {
							queryMapReturn.put("money_isNotNull",
									money_isNotNull);
						}
						if (money_in != null) {
							queryMapReturn.put("money_in", money_in);
						}
						if (money != null) {
							queryMapReturn.put("money", money);
						}
						String type_like = (String) contentreq.get("type_like");
						String type_isNull = (String) contentreq
								.get("type_isNull");
						String type_isNotNull = (String) contentreq
								.get("type_isNotNull");
						String type_in = (String) contentreq.get("type_in");
						String type = (String) contentreq.get("type");
						if (type_like != null) {
							queryMapReturn.put("type_like", type_like);
						}
						if (type_isNull != null) {
							queryMapReturn.put("type_isNull", type_isNull);
						}
						if (type_isNotNull != null) {
							queryMapReturn
									.put("type_isNotNull", type_isNotNull);
						}
						if (type_in != null) {
							queryMapReturn.put("type_in", type_in);
						}
						if (type != null) {
							queryMapReturn.put("type", type);
						}
						String payTime_gt = (String) contentreq
								.get("payTime_gt");
						String payTime_ge = (String) contentreq
								.get("payTime_ge");
						String payTime_lt = (String) contentreq
								.get("payTime_lt");
						String payTime_le = (String) contentreq
								.get("payTime_le");
						if (payTime_gt != null) {
							queryMapReturn.put("payTime_gt", payTime_gt);
						}
						if (payTime_ge != null) {
							queryMapReturn.put("payTime_ge", payTime_ge);
						}
						if (payTime_lt != null) {
							queryMapReturn.put("payTime_lt", payTime_lt);
						}
						if (payTime_le != null) {
							queryMapReturn.put("payTime_le", payTime_le);
						}
						String payNum_like = (String) contentreq
								.get("payNum_like");
						String payNum_isNull = (String) contentreq
								.get("payNum_isNull");
						String payNum_isNotNull = (String) contentreq
								.get("payNum_isNotNull");
						String payNum_in = (String) contentreq.get("payNum_in");
						String payNum = (String) contentreq.get("payNum");
						if (payNum_like != null) {
							queryMapReturn.put("payNum_like", payNum_like);
						}
						if (payNum_isNull != null) {
							queryMapReturn.put("payNum_isNull", payNum_isNull);
						}
						if (payNum_isNotNull != null) {
							queryMapReturn.put("payNum_isNotNull",
									payNum_isNotNull);
						}
						if (payNum_in != null) {
							queryMapReturn.put("payNum_in", payNum_in);
						}
						if (payNum != null) {
							queryMapReturn.put("payNum", payNum);
						}

						String orderEntityShow = (String) contentreq
								.get("orderEntityShow");
						if ("true".equals(orderEntityShow)) {
							orderEntityShowReturn = true;
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
			} else if ("DEL_PAY_INFO_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String delOrderEntity = (String) contentreq
								.get("delOrderEntity");
						if ("true".equals(delOrderEntity)) {
							delOrderEntityReturn = true;
						}
					}
				}
			} else if ("DEL_PAY_INFO_LIST_REQUEST".equals(command)) {
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
						String money_like = (String) contentreq
								.get("money_like");
						String money_isNull = (String) contentreq
								.get("money_isNull");
						String money_isNotNull = (String) contentreq
								.get("money_isNotNull");
						String money_in = (String) contentreq.get("money_in");
						String money = (String) contentreq.get("money");
						if (money_like != null) {
							queryMapReturn.put("money_like", money_like);
						}
						if (money_isNull != null) {
							queryMapReturn.put("money_isNull", money_isNull);
						}
						if (money_isNotNull != null) {
							queryMapReturn.put("money_isNotNull",
									money_isNotNull);
						}
						if (money_in != null) {
							queryMapReturn.put("money_in", money_in);
						}
						if (money != null) {
							queryMapReturn.put("money", money);
						}
						String type_like = (String) contentreq.get("type_like");
						String type_isNull = (String) contentreq
								.get("type_isNull");
						String type_isNotNull = (String) contentreq
								.get("type_isNotNull");
						String type_in = (String) contentreq.get("type_in");
						String type = (String) contentreq.get("type");
						if (type_like != null) {
							queryMapReturn.put("type_like", type_like);
						}
						if (type_isNull != null) {
							queryMapReturn.put("type_isNull", type_isNull);
						}
						if (type_isNotNull != null) {
							queryMapReturn
									.put("type_isNotNull", type_isNotNull);
						}
						if (type_in != null) {
							queryMapReturn.put("type_in", type_in);
						}
						if (type != null) {
							queryMapReturn.put("type", type);
						}
						String payTime_gt = (String) contentreq
								.get("payTime_gt");
						String payTime_ge = (String) contentreq
								.get("payTime_ge");
						String payTime_lt = (String) contentreq
								.get("payTime_lt");
						String payTime_le = (String) contentreq
								.get("payTime_le");
						if (payTime_gt != null) {
							queryMapReturn.put("payTime_gt", payTime_gt);
						}
						if (payTime_ge != null) {
							queryMapReturn.put("payTime_ge", payTime_ge);
						}
						if (payTime_lt != null) {
							queryMapReturn.put("payTime_lt", payTime_lt);
						}
						if (payTime_le != null) {
							queryMapReturn.put("payTime_le", payTime_le);
						}
						String payNum_like = (String) contentreq
								.get("payNum_like");
						String payNum_isNull = (String) contentreq
								.get("payNum_isNull");
						String payNum_isNotNull = (String) contentreq
								.get("payNum_isNotNull");
						String payNum_in = (String) contentreq.get("payNum_in");
						String payNum = (String) contentreq.get("payNum");
						if (payNum_like != null) {
							queryMapReturn.put("payNum_like", payNum_like);
						}
						if (payNum_isNull != null) {
							queryMapReturn.put("payNum_isNull", payNum_isNull);
						}
						if (payNum_isNotNull != null) {
							queryMapReturn.put("payNum_isNotNull",
									payNum_isNotNull);
						}
						if (payNum_in != null) {
							queryMapReturn.put("payNum_in", payNum_in);
						}
						if (payNum != null) {
							queryMapReturn.put("payNum", payNum);
						}

						String delOrderEntity = (String) contentreq
								.get("delOrderEntity");
						if ("true".equals(delOrderEntity)) {
							delOrderEntityReturn = true;
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
			if (payInfoReturn != null) {
				parseMap.put("payInfo", payInfoReturn);
			}
			if (payInfoListReturn != null && payInfoListReturn.size() > 0) {
				parseMap.put("payInfoList", payInfoListReturn);
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
