package mis.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mis.entity.MedicalReportEntity;
import mis.entity.OrderEntity;
import mis.entity.ServicePersonEntity;
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
 * @date 2017-04-29 18:28:51
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
			List<OrderEntity> orderListReturn = null;
			Integer idReturn = null;
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturnVO = null;

			Boolean medicalReportShowReturn = false;
			Boolean delMedicalReportReturn = false;
			Boolean servicePersonShowReturn = false;
			Boolean delServicePersonReturn = false;

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
						Integer isPay = (Integer) contentreq.get("isPay");
						if (isPay != null) {
							orderReturn.setIsPay(isPay);
						}
						Integer medicalReportStatus = (Integer) contentreq
								.get("medicalReportStatus");
						if (medicalReportStatus != null) {
							orderReturn
									.setMedicalReportStatus(medicalReportStatus);
						}
						Double servicePrice = JsonUtil.getJSONDouble(
								contentreq, "servicePrice");
						if (servicePrice != null) {
							orderReturn.setServicePrice(servicePrice);
						}
						String reportSendPerson = (String) contentreq
								.get("reportSendPerson");
						if (reportSendPerson != null) {
							orderReturn.setReportSendPerson(reportSendPerson);
						}
						String reportSendPersonContactWay = (String) contentreq
								.get("reportSendPersonContactWay");
						if (reportSendPersonContactWay != null) {
							orderReturn
									.setReportSendPersonContactWay(reportSendPersonContactWay);
						}
						String medicalReportExpress = (String) contentreq
								.get("medicalReportExpress");
						if (medicalReportExpress != null) {
							orderReturn
									.setMedicalReportExpress(medicalReportExpress);
						}
						String medicalReportExpressOrderNum = (String) contentreq
								.get("medicalReportExpressOrderNum");
						if (medicalReportExpressOrderNum != null) {
							orderReturn
									.setMedicalReportExpressOrderNum(medicalReportExpressOrderNum);
						}
						String servicePersonName = (String) contentreq
								.get("servicePersonName");
						if (servicePersonName != null) {
							orderReturn.setServicePersonName(servicePersonName);
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
							String medicalReportDownloadLink = (String) obj
									.get("medicalReportDownloadLink");
							if (medicalReportDownloadLink != null) {
								entity.setMedicalReportDownloadLink(medicalReportDownloadLink);
							}
							Integer hospitalId = (Integer) obj
									.get("hospitalId");
							if (hospitalId != null) {
								entity.setHospitalId(hospitalId);
							}
							orderReturn.setMedicalReport(entity);
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
							String headPortrait = (String) obj
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
			} else if ("QUERY_ORDER_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String medicalReportShow = (String) contentreq
								.get("medicalReportShow");
						if ("true".equals(medicalReportShow)) {
							medicalReportShowReturn = true;
						}
						String servicePersonShow = (String) contentreq
								.get("servicePersonShow");
						if ("true".equals(servicePersonShow)) {
							servicePersonShowReturn = true;
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
						Integer isPay_gt = (Integer) contentreq.get("isPay_gt");
						Integer isPay_ge = (Integer) contentreq.get("isPay_ge");
						Integer isPay_lt = (Integer) contentreq.get("isPay_lt");
						Integer isPay_le = (Integer) contentreq.get("isPay_le");
						String isPay_in = (String) contentreq.get("isPay_in");
						Integer isPay = (Integer) contentreq.get("isPay");
						if (isPay_gt != null) {
							queryMapReturn.put("isPay_gt", isPay_gt);
						}
						if (isPay_ge != null) {
							queryMapReturn.put("isPay_ge", isPay_ge);
						}
						if (isPay_lt != null) {
							queryMapReturn.put("isPay_lt", isPay_lt);
						}
						if (isPay_le != null) {
							queryMapReturn.put("isPay_le", isPay_le);
						}
						if (isPay_in != null) {
							queryMapReturn.put("isPay_in", isPay_in);
						}
						if (isPay != null) {
							queryMapReturn.put("isPay", isPay);
						}
						Integer medicalReportStatus_gt = (Integer) contentreq
								.get("medicalReportStatus_gt");
						Integer medicalReportStatus_ge = (Integer) contentreq
								.get("medicalReportStatus_ge");
						Integer medicalReportStatus_lt = (Integer) contentreq
								.get("medicalReportStatus_lt");
						Integer medicalReportStatus_le = (Integer) contentreq
								.get("medicalReportStatus_le");
						String medicalReportStatus_in = (String) contentreq
								.get("medicalReportStatus_in");
						Integer medicalReportStatus = (Integer) contentreq
								.get("medicalReportStatus");
						if (medicalReportStatus_gt != null) {
							queryMapReturn.put("medicalReportStatus_gt",
									medicalReportStatus_gt);
						}
						if (medicalReportStatus_ge != null) {
							queryMapReturn.put("medicalReportStatus_ge",
									medicalReportStatus_ge);
						}
						if (medicalReportStatus_lt != null) {
							queryMapReturn.put("medicalReportStatus_lt",
									medicalReportStatus_lt);
						}
						if (medicalReportStatus_le != null) {
							queryMapReturn.put("medicalReportStatus_le",
									medicalReportStatus_le);
						}
						if (medicalReportStatus_in != null) {
							queryMapReturn.put("medicalReportStatus_in",
									medicalReportStatus_in);
						}
						if (medicalReportStatus != null) {
							queryMapReturn.put("medicalReportStatus",
									medicalReportStatus);
						}
						String servicePrice_like = (String) contentreq
								.get("servicePrice_like");
						String servicePrice_isNull = (String) contentreq
								.get("servicePrice_isNull");
						String servicePrice_isNotNull = (String) contentreq
								.get("servicePrice_isNotNull");
						String servicePrice_in = (String) contentreq
								.get("servicePrice_in");
						String servicePrice = (String) contentreq
								.get("servicePrice");
						if (servicePrice_like != null) {
							queryMapReturn.put("servicePrice_like",
									servicePrice_like);
						}
						if (servicePrice_isNull != null) {
							queryMapReturn.put("servicePrice_isNull",
									servicePrice_isNull);
						}
						if (servicePrice_isNotNull != null) {
							queryMapReturn.put("servicePrice_isNotNull",
									servicePrice_isNotNull);
						}
						if (servicePrice_in != null) {
							queryMapReturn.put("servicePrice_in",
									servicePrice_in);
						}
						if (servicePrice != null) {
							queryMapReturn.put("servicePrice", servicePrice);
						}
						String reportSendPerson_like = (String) contentreq
								.get("reportSendPerson_like");
						String reportSendPerson_isNull = (String) contentreq
								.get("reportSendPerson_isNull");
						String reportSendPerson_isNotNull = (String) contentreq
								.get("reportSendPerson_isNotNull");
						String reportSendPerson_in = (String) contentreq
								.get("reportSendPerson_in");
						String reportSendPerson = (String) contentreq
								.get("reportSendPerson");
						if (reportSendPerson_like != null) {
							queryMapReturn.put("reportSendPerson_like",
									reportSendPerson_like);
						}
						if (reportSendPerson_isNull != null) {
							queryMapReturn.put("reportSendPerson_isNull",
									reportSendPerson_isNull);
						}
						if (reportSendPerson_isNotNull != null) {
							queryMapReturn.put("reportSendPerson_isNotNull",
									reportSendPerson_isNotNull);
						}
						if (reportSendPerson_in != null) {
							queryMapReturn.put("reportSendPerson_in",
									reportSendPerson_in);
						}
						if (reportSendPerson != null) {
							queryMapReturn.put("reportSendPerson",
									reportSendPerson);
						}
						String reportSendPersonContactWay_like = (String) contentreq
								.get("reportSendPersonContactWay_like");
						String reportSendPersonContactWay_isNull = (String) contentreq
								.get("reportSendPersonContactWay_isNull");
						String reportSendPersonContactWay_isNotNull = (String) contentreq
								.get("reportSendPersonContactWay_isNotNull");
						String reportSendPersonContactWay_in = (String) contentreq
								.get("reportSendPersonContactWay_in");
						String reportSendPersonContactWay = (String) contentreq
								.get("reportSendPersonContactWay");
						if (reportSendPersonContactWay_like != null) {
							queryMapReturn.put(
									"reportSendPersonContactWay_like",
									reportSendPersonContactWay_like);
						}
						if (reportSendPersonContactWay_isNull != null) {
							queryMapReturn.put(
									"reportSendPersonContactWay_isNull",
									reportSendPersonContactWay_isNull);
						}
						if (reportSendPersonContactWay_isNotNull != null) {
							queryMapReturn.put(
									"reportSendPersonContactWay_isNotNull",
									reportSendPersonContactWay_isNotNull);
						}
						if (reportSendPersonContactWay_in != null) {
							queryMapReturn.put("reportSendPersonContactWay_in",
									reportSendPersonContactWay_in);
						}
						if (reportSendPersonContactWay != null) {
							queryMapReturn.put("reportSendPersonContactWay",
									reportSendPersonContactWay);
						}
						String medicalReportExpress_like = (String) contentreq
								.get("medicalReportExpress_like");
						String medicalReportExpress_isNull = (String) contentreq
								.get("medicalReportExpress_isNull");
						String medicalReportExpress_isNotNull = (String) contentreq
								.get("medicalReportExpress_isNotNull");
						String medicalReportExpress_in = (String) contentreq
								.get("medicalReportExpress_in");
						String medicalReportExpress = (String) contentreq
								.get("medicalReportExpress");
						if (medicalReportExpress_like != null) {
							queryMapReturn.put("medicalReportExpress_like",
									medicalReportExpress_like);
						}
						if (medicalReportExpress_isNull != null) {
							queryMapReturn.put("medicalReportExpress_isNull",
									medicalReportExpress_isNull);
						}
						if (medicalReportExpress_isNotNull != null) {
							queryMapReturn.put(
									"medicalReportExpress_isNotNull",
									medicalReportExpress_isNotNull);
						}
						if (medicalReportExpress_in != null) {
							queryMapReturn.put("medicalReportExpress_in",
									medicalReportExpress_in);
						}
						if (medicalReportExpress != null) {
							queryMapReturn.put("medicalReportExpress",
									medicalReportExpress);
						}
						String medicalReportExpressOrderNum_like = (String) contentreq
								.get("medicalReportExpressOrderNum_like");
						String medicalReportExpressOrderNum_isNull = (String) contentreq
								.get("medicalReportExpressOrderNum_isNull");
						String medicalReportExpressOrderNum_isNotNull = (String) contentreq
								.get("medicalReportExpressOrderNum_isNotNull");
						String medicalReportExpressOrderNum_in = (String) contentreq
								.get("medicalReportExpressOrderNum_in");
						String medicalReportExpressOrderNum = (String) contentreq
								.get("medicalReportExpressOrderNum");
						if (medicalReportExpressOrderNum_like != null) {
							queryMapReturn.put(
									"medicalReportExpressOrderNum_like",
									medicalReportExpressOrderNum_like);
						}
						if (medicalReportExpressOrderNum_isNull != null) {
							queryMapReturn.put(
									"medicalReportExpressOrderNum_isNull",
									medicalReportExpressOrderNum_isNull);
						}
						if (medicalReportExpressOrderNum_isNotNull != null) {
							queryMapReturn.put(
									"medicalReportExpressOrderNum_isNotNull",
									medicalReportExpressOrderNum_isNotNull);
						}
						if (medicalReportExpressOrderNum_in != null) {
							queryMapReturn.put(
									"medicalReportExpressOrderNum_in",
									medicalReportExpressOrderNum_in);
						}
						if (medicalReportExpressOrderNum != null) {
							queryMapReturn.put("medicalReportExpressOrderNum",
									medicalReportExpressOrderNum);
						}
						String servicePersonName_like = (String) contentreq
								.get("servicePersonName_like");
						String servicePersonName_isNull = (String) contentreq
								.get("servicePersonName_isNull");
						String servicePersonName_isNotNull = (String) contentreq
								.get("servicePersonName_isNotNull");
						String servicePersonName_in = (String) contentreq
								.get("servicePersonName_in");
						String servicePersonName = (String) contentreq
								.get("servicePersonName");
						if (servicePersonName_like != null) {
							queryMapReturn.put("servicePersonName_like",
									servicePersonName_like);
						}
						if (servicePersonName_isNull != null) {
							queryMapReturn.put("servicePersonName_isNull",
									servicePersonName_isNull);
						}
						if (servicePersonName_isNotNull != null) {
							queryMapReturn.put("servicePersonName_isNotNull",
									servicePersonName_isNotNull);
						}
						if (servicePersonName_in != null) {
							queryMapReturn.put("servicePersonName_in",
									servicePersonName_in);
						}
						if (servicePersonName != null) {
							queryMapReturn.put("servicePersonName",
									servicePersonName);
						}

						String medicalReportShow = (String) contentreq
								.get("medicalReportShow");
						if ("true".equals(medicalReportShow)) {
							medicalReportShowReturn = true;
						}
						String servicePersonShow = (String) contentreq
								.get("servicePersonShow");
						if ("true".equals(servicePersonShow)) {
							servicePersonShowReturn = true;
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
						orderListReturnVO = new ArrayList<OrderVO>();
						for (int i = 0; i < order.size(); i++) {
							JSONObject obj = order.getJSONObject(i);
							OrderVO orderVO = new OrderVO();
							orderVO.setName((String) obj.get("column"));
							orderVO.setOrderType((String) obj.get("type"));
							orderListReturnVO.add(orderVO);
						}
					}
				}
			} else if ("DEL_ORDER_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String delMedicalReport = (String) contentreq
								.get("delMedicalReport");
						if ("true".equals(delMedicalReport)) {
							delMedicalReportReturn = true;
						}
						String delServicePerson = (String) contentreq
								.get("delServicePerson");
						if ("true".equals(delServicePerson)) {
							delServicePersonReturn = true;
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
						Integer isPay_gt = (Integer) contentreq.get("isPay_gt");
						Integer isPay_ge = (Integer) contentreq.get("isPay_ge");
						Integer isPay_lt = (Integer) contentreq.get("isPay_lt");
						Integer isPay_le = (Integer) contentreq.get("isPay_le");
						String isPay_in = (String) contentreq.get("isPay_in");
						Integer isPay = (Integer) contentreq.get("isPay");
						if (isPay_gt != null) {
							queryMapReturn.put("isPay_gt", isPay_gt);
						}
						if (isPay_ge != null) {
							queryMapReturn.put("isPay_ge", isPay_ge);
						}
						if (isPay_lt != null) {
							queryMapReturn.put("isPay_lt", isPay_lt);
						}
						if (isPay_le != null) {
							queryMapReturn.put("isPay_le", isPay_le);
						}
						if (isPay_in != null) {
							queryMapReturn.put("isPay_in", isPay_in);
						}
						if (isPay != null) {
							queryMapReturn.put("isPay", isPay);
						}
						Integer medicalReportStatus_gt = (Integer) contentreq
								.get("medicalReportStatus_gt");
						Integer medicalReportStatus_ge = (Integer) contentreq
								.get("medicalReportStatus_ge");
						Integer medicalReportStatus_lt = (Integer) contentreq
								.get("medicalReportStatus_lt");
						Integer medicalReportStatus_le = (Integer) contentreq
								.get("medicalReportStatus_le");
						String medicalReportStatus_in = (String) contentreq
								.get("medicalReportStatus_in");
						Integer medicalReportStatus = (Integer) contentreq
								.get("medicalReportStatus");
						if (medicalReportStatus_gt != null) {
							queryMapReturn.put("medicalReportStatus_gt",
									medicalReportStatus_gt);
						}
						if (medicalReportStatus_ge != null) {
							queryMapReturn.put("medicalReportStatus_ge",
									medicalReportStatus_ge);
						}
						if (medicalReportStatus_lt != null) {
							queryMapReturn.put("medicalReportStatus_lt",
									medicalReportStatus_lt);
						}
						if (medicalReportStatus_le != null) {
							queryMapReturn.put("medicalReportStatus_le",
									medicalReportStatus_le);
						}
						if (medicalReportStatus_in != null) {
							queryMapReturn.put("medicalReportStatus_in",
									medicalReportStatus_in);
						}
						if (medicalReportStatus != null) {
							queryMapReturn.put("medicalReportStatus",
									medicalReportStatus);
						}
						String servicePrice_like = (String) contentreq
								.get("servicePrice_like");
						String servicePrice_isNull = (String) contentreq
								.get("servicePrice_isNull");
						String servicePrice_isNotNull = (String) contentreq
								.get("servicePrice_isNotNull");
						String servicePrice_in = (String) contentreq
								.get("servicePrice_in");
						String servicePrice = (String) contentreq
								.get("servicePrice");
						if (servicePrice_like != null) {
							queryMapReturn.put("servicePrice_like",
									servicePrice_like);
						}
						if (servicePrice_isNull != null) {
							queryMapReturn.put("servicePrice_isNull",
									servicePrice_isNull);
						}
						if (servicePrice_isNotNull != null) {
							queryMapReturn.put("servicePrice_isNotNull",
									servicePrice_isNotNull);
						}
						if (servicePrice_in != null) {
							queryMapReturn.put("servicePrice_in",
									servicePrice_in);
						}
						if (servicePrice != null) {
							queryMapReturn.put("servicePrice", servicePrice);
						}
						String reportSendPerson_like = (String) contentreq
								.get("reportSendPerson_like");
						String reportSendPerson_isNull = (String) contentreq
								.get("reportSendPerson_isNull");
						String reportSendPerson_isNotNull = (String) contentreq
								.get("reportSendPerson_isNotNull");
						String reportSendPerson_in = (String) contentreq
								.get("reportSendPerson_in");
						String reportSendPerson = (String) contentreq
								.get("reportSendPerson");
						if (reportSendPerson_like != null) {
							queryMapReturn.put("reportSendPerson_like",
									reportSendPerson_like);
						}
						if (reportSendPerson_isNull != null) {
							queryMapReturn.put("reportSendPerson_isNull",
									reportSendPerson_isNull);
						}
						if (reportSendPerson_isNotNull != null) {
							queryMapReturn.put("reportSendPerson_isNotNull",
									reportSendPerson_isNotNull);
						}
						if (reportSendPerson_in != null) {
							queryMapReturn.put("reportSendPerson_in",
									reportSendPerson_in);
						}
						if (reportSendPerson != null) {
							queryMapReturn.put("reportSendPerson",
									reportSendPerson);
						}
						String reportSendPersonContactWay_like = (String) contentreq
								.get("reportSendPersonContactWay_like");
						String reportSendPersonContactWay_isNull = (String) contentreq
								.get("reportSendPersonContactWay_isNull");
						String reportSendPersonContactWay_isNotNull = (String) contentreq
								.get("reportSendPersonContactWay_isNotNull");
						String reportSendPersonContactWay_in = (String) contentreq
								.get("reportSendPersonContactWay_in");
						String reportSendPersonContactWay = (String) contentreq
								.get("reportSendPersonContactWay");
						if (reportSendPersonContactWay_like != null) {
							queryMapReturn.put(
									"reportSendPersonContactWay_like",
									reportSendPersonContactWay_like);
						}
						if (reportSendPersonContactWay_isNull != null) {
							queryMapReturn.put(
									"reportSendPersonContactWay_isNull",
									reportSendPersonContactWay_isNull);
						}
						if (reportSendPersonContactWay_isNotNull != null) {
							queryMapReturn.put(
									"reportSendPersonContactWay_isNotNull",
									reportSendPersonContactWay_isNotNull);
						}
						if (reportSendPersonContactWay_in != null) {
							queryMapReturn.put("reportSendPersonContactWay_in",
									reportSendPersonContactWay_in);
						}
						if (reportSendPersonContactWay != null) {
							queryMapReturn.put("reportSendPersonContactWay",
									reportSendPersonContactWay);
						}
						String medicalReportExpress_like = (String) contentreq
								.get("medicalReportExpress_like");
						String medicalReportExpress_isNull = (String) contentreq
								.get("medicalReportExpress_isNull");
						String medicalReportExpress_isNotNull = (String) contentreq
								.get("medicalReportExpress_isNotNull");
						String medicalReportExpress_in = (String) contentreq
								.get("medicalReportExpress_in");
						String medicalReportExpress = (String) contentreq
								.get("medicalReportExpress");
						if (medicalReportExpress_like != null) {
							queryMapReturn.put("medicalReportExpress_like",
									medicalReportExpress_like);
						}
						if (medicalReportExpress_isNull != null) {
							queryMapReturn.put("medicalReportExpress_isNull",
									medicalReportExpress_isNull);
						}
						if (medicalReportExpress_isNotNull != null) {
							queryMapReturn.put(
									"medicalReportExpress_isNotNull",
									medicalReportExpress_isNotNull);
						}
						if (medicalReportExpress_in != null) {
							queryMapReturn.put("medicalReportExpress_in",
									medicalReportExpress_in);
						}
						if (medicalReportExpress != null) {
							queryMapReturn.put("medicalReportExpress",
									medicalReportExpress);
						}
						String medicalReportExpressOrderNum_like = (String) contentreq
								.get("medicalReportExpressOrderNum_like");
						String medicalReportExpressOrderNum_isNull = (String) contentreq
								.get("medicalReportExpressOrderNum_isNull");
						String medicalReportExpressOrderNum_isNotNull = (String) contentreq
								.get("medicalReportExpressOrderNum_isNotNull");
						String medicalReportExpressOrderNum_in = (String) contentreq
								.get("medicalReportExpressOrderNum_in");
						String medicalReportExpressOrderNum = (String) contentreq
								.get("medicalReportExpressOrderNum");
						if (medicalReportExpressOrderNum_like != null) {
							queryMapReturn.put(
									"medicalReportExpressOrderNum_like",
									medicalReportExpressOrderNum_like);
						}
						if (medicalReportExpressOrderNum_isNull != null) {
							queryMapReturn.put(
									"medicalReportExpressOrderNum_isNull",
									medicalReportExpressOrderNum_isNull);
						}
						if (medicalReportExpressOrderNum_isNotNull != null) {
							queryMapReturn.put(
									"medicalReportExpressOrderNum_isNotNull",
									medicalReportExpressOrderNum_isNotNull);
						}
						if (medicalReportExpressOrderNum_in != null) {
							queryMapReturn.put(
									"medicalReportExpressOrderNum_in",
									medicalReportExpressOrderNum_in);
						}
						if (medicalReportExpressOrderNum != null) {
							queryMapReturn.put("medicalReportExpressOrderNum",
									medicalReportExpressOrderNum);
						}
						String servicePersonName_like = (String) contentreq
								.get("servicePersonName_like");
						String servicePersonName_isNull = (String) contentreq
								.get("servicePersonName_isNull");
						String servicePersonName_isNotNull = (String) contentreq
								.get("servicePersonName_isNotNull");
						String servicePersonName_in = (String) contentreq
								.get("servicePersonName_in");
						String servicePersonName = (String) contentreq
								.get("servicePersonName");
						if (servicePersonName_like != null) {
							queryMapReturn.put("servicePersonName_like",
									servicePersonName_like);
						}
						if (servicePersonName_isNull != null) {
							queryMapReturn.put("servicePersonName_isNull",
									servicePersonName_isNull);
						}
						if (servicePersonName_isNotNull != null) {
							queryMapReturn.put("servicePersonName_isNotNull",
									servicePersonName_isNotNull);
						}
						if (servicePersonName_in != null) {
							queryMapReturn.put("servicePersonName_in",
									servicePersonName_in);
						}
						if (servicePersonName != null) {
							queryMapReturn.put("servicePersonName",
									servicePersonName);
						}

						String delMedicalReport = (String) contentreq
								.get("delMedicalReport");
						if ("true".equals(delMedicalReport)) {
							delMedicalReportReturn = true;
						}
						String delServicePerson = (String) contentreq
								.get("delServicePerson");
						if ("true".equals(delServicePerson)) {
							delServicePersonReturn = true;
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

			if (medicalReportShowReturn != null) {
				parseMap.put("medicalReportShow", medicalReportShowReturn);
			}
			if (delMedicalReportReturn != null) {
				parseMap.put("delMedicalReport", delMedicalReportReturn);
			}
			if (servicePersonShowReturn != null) {
				parseMap.put("servicePersonShow", servicePersonShowReturn);
			}
			if (delServicePersonReturn != null) {
				parseMap.put("delServicePerson", delServicePersonReturn);
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
