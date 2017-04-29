package mis.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mis.entity.HospitalEntity;
import mis.entity.MedicalReportEntity;
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
 * @date 2017-04-28 13:31:49
 * @version V1.0
 *
 */
public class MedicalReportParse {
	private static Logger logger = Logger.getLogger(MedicalReportParse.class);
	private static MedicalReportParse medicalReportParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static MedicalReportParse getInstance() {
		if (medicalReportParse == null) {
			medicalReportParse = new MedicalReportParse();
		}
		return medicalReportParse;
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
			MedicalReportEntity medicalReportReturn = null;
			List<MedicalReportEntity> medicalReportListReturn = null;
			Integer idReturn = null;
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;

			Boolean hospitalShowReturn = false;
			Boolean delHospitalReturn = false;

			// json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject) reqParams.get("content");
			if ("ADD_MEDICAL_REPORT_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				medicalReportReturn = new MedicalReportEntity();
				if (true) {
					if (contentreq != null) {
						Integer id = (Integer) contentreq.get("id");
						if (id != null) {
							medicalReportReturn = (MedicalReportEntity) dbManager
									.getById(id, MedicalReportEntity.class);
							medicalReportReturn.setId(id);
						}
						String medicalReportNum = (String) contentreq
								.get("medicalReportNum");
						if (medicalReportNum != null) {
							medicalReportReturn
									.setMedicalReportNum(medicalReportNum);
						}
						String medicalReportCreateTime = (String) contentreq
								.get("medicalReportCreateTime");
						if (medicalReportCreateTime != null) {
							medicalReportReturn
									.setMedicalReportCreateTime(medicalReportCreateTime);
						}
						String medicalPersonName = (String) contentreq
								.get("medicalPersonName");
						if (medicalPersonName != null) {
							medicalReportReturn
									.setMedicalPersonName(medicalPersonName);
						}
						Object medicalPersonGender = (Object) contentreq
								.get("medicalPersonGender");
						if (medicalPersonGender != null) {
							medicalReportReturn
									.setMedicalPersonGender(medicalPersonGender);
						}
						String medicalPersonCardNum = (String) contentreq
								.get("medicalPersonCardNum");
						if (medicalPersonCardNum != null) {
							medicalReportReturn
									.setMedicalPersonCardNum(medicalPersonCardNum);
						}
						Integer medicalPersonAge = (Integer) contentreq
								.get("medicalPersonAge");
						if (medicalPersonAge != null) {
							medicalReportReturn
									.setMedicalPersonAge(medicalPersonAge);
						}
						String medicalReportContent = (String) contentreq
								.get("medicalReportContent");
						if (medicalReportContent != null) {
							medicalReportReturn
									.setMedicalReportContent(medicalReportContent);
						}
						String medicalHospital = (String) contentreq
								.get("medicalHospital");
						if (medicalHospital != null) {
							medicalReportReturn
									.setMedicalHospital(medicalHospital);
						}
						Integer hospitalId = (Integer) contentreq
								.get("hospitalId");
						if (hospitalId != null) {
							medicalReportReturn.setHospitalId(hospitalId);
						}
					}
				}
				if (true) {
					Object hospital = contentreq.get("hospital");
					if (hospital != null) {
						JSONObject obj = (JSONObject) hospital;
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
							medicalReportReturn.setHospital(entity);
						}
					}
				}
			} else if ("QUERY_MEDICAL_REPORT_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String hospitalShow = (String) contentreq
								.get("hospitalShow");
						if ("true".equals(hospitalShow)) {
							hospitalShowReturn = true;
						}
					}
				}
			} else if ("QUERY_MEDICAL_REPORT_LIST_REQUEST".equals(command)) {
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
						String medicalReportNum_like = (String) contentreq
								.get("medicalReportNum_like");
						String medicalReportNum_isNull = (String) contentreq
								.get("medicalReportNum_isNull");
						String medicalReportNum_isNotNull = (String) contentreq
								.get("medicalReportNum_isNotNull");
						String medicalReportNum_in = (String) contentreq
								.get("medicalReportNum_in");
						String medicalReportNum = (String) contentreq
								.get("medicalReportNum");
						if (medicalReportNum_like != null) {
							queryMapReturn.put("medicalReportNum_like",
									medicalReportNum_like);
						}
						if (medicalReportNum_isNull != null) {
							queryMapReturn.put("medicalReportNum_isNull",
									medicalReportNum_isNull);
						}
						if (medicalReportNum_isNotNull != null) {
							queryMapReturn.put("medicalReportNum_isNotNull",
									medicalReportNum_isNotNull);
						}
						if (medicalReportNum_in != null) {
							queryMapReturn.put("medicalReportNum_in",
									medicalReportNum_in);
						}
						if (medicalReportNum != null) {
							queryMapReturn.put("medicalReportNum",
									medicalReportNum);
						}
						String medicalReportStatus_like = (String) contentreq
								.get("medicalReportStatus_like");
						String medicalReportStatus_isNull = (String) contentreq
								.get("medicalReportStatus_isNull");
						String medicalReportStatus_isNotNull = (String) contentreq
								.get("medicalReportStatus_isNotNull");
						String medicalReportStatus_in = (String) contentreq
								.get("medicalReportStatus_in");
						String medicalReportStatus = (String) contentreq
								.get("medicalReportStatus");
						if (medicalReportStatus_like != null) {
							queryMapReturn.put("medicalReportStatus_like",
									medicalReportStatus_like);
						}
						if (medicalReportStatus_isNull != null) {
							queryMapReturn.put("medicalReportStatus_isNull",
									medicalReportStatus_isNull);
						}
						if (medicalReportStatus_isNotNull != null) {
							queryMapReturn.put("medicalReportStatus_isNotNull",
									medicalReportStatus_isNotNull);
						}
						if (medicalReportStatus_in != null) {
							queryMapReturn.put("medicalReportStatus_in",
									medicalReportStatus_in);
						}
						if (medicalReportStatus != null) {
							queryMapReturn.put("medicalReportStatus",
									medicalReportStatus);
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
						String medicalReportCreateTime_gt = (String) contentreq
								.get("medicalReportCreateTime_gt");
						String medicalReportCreateTime_ge = (String) contentreq
								.get("medicalReportCreateTime_ge");
						String medicalReportCreateTime_lt = (String) contentreq
								.get("medicalReportCreateTime_lt");
						String medicalReportCreateTime_le = (String) contentreq
								.get("medicalReportCreateTime_le");
						if (medicalReportCreateTime_gt != null) {
							queryMapReturn.put("medicalReportCreateTime_gt",
									medicalReportCreateTime_gt);
						}
						if (medicalReportCreateTime_ge != null) {
							queryMapReturn.put("medicalReportCreateTime_ge",
									medicalReportCreateTime_ge);
						}
						if (medicalReportCreateTime_lt != null) {
							queryMapReturn.put("medicalReportCreateTime_lt",
									medicalReportCreateTime_lt);
						}
						if (medicalReportCreateTime_le != null) {
							queryMapReturn.put("medicalReportCreateTime_le",
									medicalReportCreateTime_le);
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
						String medicalPersonCardNum_like = (String) contentreq
								.get("medicalPersonCardNum_like");
						String medicalPersonCardNum_isNull = (String) contentreq
								.get("medicalPersonCardNum_isNull");
						String medicalPersonCardNum_isNotNull = (String) contentreq
								.get("medicalPersonCardNum_isNotNull");
						String medicalPersonCardNum_in = (String) contentreq
								.get("medicalPersonCardNum_in");
						String medicalPersonCardNum = (String) contentreq
								.get("medicalPersonCardNum");
						if (medicalPersonCardNum_like != null) {
							queryMapReturn.put("medicalPersonCardNum_like",
									medicalPersonCardNum_like);
						}
						if (medicalPersonCardNum_isNull != null) {
							queryMapReturn.put("medicalPersonCardNum_isNull",
									medicalPersonCardNum_isNull);
						}
						if (medicalPersonCardNum_isNotNull != null) {
							queryMapReturn.put(
									"medicalPersonCardNum_isNotNull",
									medicalPersonCardNum_isNotNull);
						}
						if (medicalPersonCardNum_in != null) {
							queryMapReturn.put("medicalPersonCardNum_in",
									medicalPersonCardNum_in);
						}
						if (medicalPersonCardNum != null) {
							queryMapReturn.put("medicalPersonCardNum",
									medicalPersonCardNum);
						}
						Integer medicalPersonAge_gt = (Integer) contentreq
								.get("medicalPersonAge_gt");
						Integer medicalPersonAge_ge = (Integer) contentreq
								.get("medicalPersonAge_ge");
						Integer medicalPersonAge_lt = (Integer) contentreq
								.get("medicalPersonAge_lt");
						Integer medicalPersonAge_le = (Integer) contentreq
								.get("medicalPersonAge_le");
						String medicalPersonAge_in = (String) contentreq
								.get("medicalPersonAge_in");
						Integer medicalPersonAge = (Integer) contentreq
								.get("medicalPersonAge");
						if (medicalPersonAge_gt != null) {
							queryMapReturn.put("medicalPersonAge_gt",
									medicalPersonAge_gt);
						}
						if (medicalPersonAge_ge != null) {
							queryMapReturn.put("medicalPersonAge_ge",
									medicalPersonAge_ge);
						}
						if (medicalPersonAge_lt != null) {
							queryMapReturn.put("medicalPersonAge_lt",
									medicalPersonAge_lt);
						}
						if (medicalPersonAge_le != null) {
							queryMapReturn.put("medicalPersonAge_le",
									medicalPersonAge_le);
						}
						if (medicalPersonAge_in != null) {
							queryMapReturn.put("medicalPersonAge_in",
									medicalPersonAge_in);
						}
						if (medicalPersonAge != null) {
							queryMapReturn.put("medicalPersonAge",
									medicalPersonAge);
						}
						String medicalReportContent_like = (String) contentreq
								.get("medicalReportContent_like");
						String medicalReportContent_isNull = (String) contentreq
								.get("medicalReportContent_isNull");
						String medicalReportContent_isNotNull = (String) contentreq
								.get("medicalReportContent_isNotNull");
						String medicalReportContent_in = (String) contentreq
								.get("medicalReportContent_in");
						String medicalReportContent = (String) contentreq
								.get("medicalReportContent");
						if (medicalReportContent_like != null) {
							queryMapReturn.put("medicalReportContent_like",
									medicalReportContent_like);
						}
						if (medicalReportContent_isNull != null) {
							queryMapReturn.put("medicalReportContent_isNull",
									medicalReportContent_isNull);
						}
						if (medicalReportContent_isNotNull != null) {
							queryMapReturn.put(
									"medicalReportContent_isNotNull",
									medicalReportContent_isNotNull);
						}
						if (medicalReportContent_in != null) {
							queryMapReturn.put("medicalReportContent_in",
									medicalReportContent_in);
						}
						if (medicalReportContent != null) {
							queryMapReturn.put("medicalReportContent",
									medicalReportContent);
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

						String hospitalShow = (String) contentreq
								.get("hospitalShow");
						if ("true".equals(hospitalShow)) {
							hospitalShowReturn = true;
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
			} else if ("DEL_MEDICAL_REPORT_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String delHospital = (String) contentreq
								.get("delHospital");
						if ("true".equals(delHospital)) {
							delHospitalReturn = true;
						}
					}
				}
			} else if ("DEL_MEDICAL_REPORT_LIST_REQUEST".equals(command)) {
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
						String medicalReportNum_like = (String) contentreq
								.get("medicalReportNum_like");
						String medicalReportNum_isNull = (String) contentreq
								.get("medicalReportNum_isNull");
						String medicalReportNum_isNotNull = (String) contentreq
								.get("medicalReportNum_isNotNull");
						String medicalReportNum_in = (String) contentreq
								.get("medicalReportNum_in");
						String medicalReportNum = (String) contentreq
								.get("medicalReportNum");
						if (medicalReportNum_like != null) {
							queryMapReturn.put("medicalReportNum_like",
									medicalReportNum_like);
						}
						if (medicalReportNum_isNull != null) {
							queryMapReturn.put("medicalReportNum_isNull",
									medicalReportNum_isNull);
						}
						if (medicalReportNum_isNotNull != null) {
							queryMapReturn.put("medicalReportNum_isNotNull",
									medicalReportNum_isNotNull);
						}
						if (medicalReportNum_in != null) {
							queryMapReturn.put("medicalReportNum_in",
									medicalReportNum_in);
						}
						if (medicalReportNum != null) {
							queryMapReturn.put("medicalReportNum",
									medicalReportNum);
						}
						String medicalReportStatus_like = (String) contentreq
								.get("medicalReportStatus_like");
						String medicalReportStatus_isNull = (String) contentreq
								.get("medicalReportStatus_isNull");
						String medicalReportStatus_isNotNull = (String) contentreq
								.get("medicalReportStatus_isNotNull");
						String medicalReportStatus_in = (String) contentreq
								.get("medicalReportStatus_in");
						String medicalReportStatus = (String) contentreq
								.get("medicalReportStatus");
						if (medicalReportStatus_like != null) {
							queryMapReturn.put("medicalReportStatus_like",
									medicalReportStatus_like);
						}
						if (medicalReportStatus_isNull != null) {
							queryMapReturn.put("medicalReportStatus_isNull",
									medicalReportStatus_isNull);
						}
						if (medicalReportStatus_isNotNull != null) {
							queryMapReturn.put("medicalReportStatus_isNotNull",
									medicalReportStatus_isNotNull);
						}
						if (medicalReportStatus_in != null) {
							queryMapReturn.put("medicalReportStatus_in",
									medicalReportStatus_in);
						}
						if (medicalReportStatus != null) {
							queryMapReturn.put("medicalReportStatus",
									medicalReportStatus);
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
						String medicalReportCreateTime_gt = (String) contentreq
								.get("medicalReportCreateTime_gt");
						String medicalReportCreateTime_ge = (String) contentreq
								.get("medicalReportCreateTime_ge");
						String medicalReportCreateTime_lt = (String) contentreq
								.get("medicalReportCreateTime_lt");
						String medicalReportCreateTime_le = (String) contentreq
								.get("medicalReportCreateTime_le");
						if (medicalReportCreateTime_gt != null) {
							queryMapReturn.put("medicalReportCreateTime_gt",
									medicalReportCreateTime_gt);
						}
						if (medicalReportCreateTime_ge != null) {
							queryMapReturn.put("medicalReportCreateTime_ge",
									medicalReportCreateTime_ge);
						}
						if (medicalReportCreateTime_lt != null) {
							queryMapReturn.put("medicalReportCreateTime_lt",
									medicalReportCreateTime_lt);
						}
						if (medicalReportCreateTime_le != null) {
							queryMapReturn.put("medicalReportCreateTime_le",
									medicalReportCreateTime_le);
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
						String medicalPersonCardNum_like = (String) contentreq
								.get("medicalPersonCardNum_like");
						String medicalPersonCardNum_isNull = (String) contentreq
								.get("medicalPersonCardNum_isNull");
						String medicalPersonCardNum_isNotNull = (String) contentreq
								.get("medicalPersonCardNum_isNotNull");
						String medicalPersonCardNum_in = (String) contentreq
								.get("medicalPersonCardNum_in");
						String medicalPersonCardNum = (String) contentreq
								.get("medicalPersonCardNum");
						if (medicalPersonCardNum_like != null) {
							queryMapReturn.put("medicalPersonCardNum_like",
									medicalPersonCardNum_like);
						}
						if (medicalPersonCardNum_isNull != null) {
							queryMapReturn.put("medicalPersonCardNum_isNull",
									medicalPersonCardNum_isNull);
						}
						if (medicalPersonCardNum_isNotNull != null) {
							queryMapReturn.put(
									"medicalPersonCardNum_isNotNull",
									medicalPersonCardNum_isNotNull);
						}
						if (medicalPersonCardNum_in != null) {
							queryMapReturn.put("medicalPersonCardNum_in",
									medicalPersonCardNum_in);
						}
						if (medicalPersonCardNum != null) {
							queryMapReturn.put("medicalPersonCardNum",
									medicalPersonCardNum);
						}
						Integer medicalPersonAge_gt = (Integer) contentreq
								.get("medicalPersonAge_gt");
						Integer medicalPersonAge_ge = (Integer) contentreq
								.get("medicalPersonAge_ge");
						Integer medicalPersonAge_lt = (Integer) contentreq
								.get("medicalPersonAge_lt");
						Integer medicalPersonAge_le = (Integer) contentreq
								.get("medicalPersonAge_le");
						String medicalPersonAge_in = (String) contentreq
								.get("medicalPersonAge_in");
						Integer medicalPersonAge = (Integer) contentreq
								.get("medicalPersonAge");
						if (medicalPersonAge_gt != null) {
							queryMapReturn.put("medicalPersonAge_gt",
									medicalPersonAge_gt);
						}
						if (medicalPersonAge_ge != null) {
							queryMapReturn.put("medicalPersonAge_ge",
									medicalPersonAge_ge);
						}
						if (medicalPersonAge_lt != null) {
							queryMapReturn.put("medicalPersonAge_lt",
									medicalPersonAge_lt);
						}
						if (medicalPersonAge_le != null) {
							queryMapReturn.put("medicalPersonAge_le",
									medicalPersonAge_le);
						}
						if (medicalPersonAge_in != null) {
							queryMapReturn.put("medicalPersonAge_in",
									medicalPersonAge_in);
						}
						if (medicalPersonAge != null) {
							queryMapReturn.put("medicalPersonAge",
									medicalPersonAge);
						}
						String medicalReportContent_like = (String) contentreq
								.get("medicalReportContent_like");
						String medicalReportContent_isNull = (String) contentreq
								.get("medicalReportContent_isNull");
						String medicalReportContent_isNotNull = (String) contentreq
								.get("medicalReportContent_isNotNull");
						String medicalReportContent_in = (String) contentreq
								.get("medicalReportContent_in");
						String medicalReportContent = (String) contentreq
								.get("medicalReportContent");
						if (medicalReportContent_like != null) {
							queryMapReturn.put("medicalReportContent_like",
									medicalReportContent_like);
						}
						if (medicalReportContent_isNull != null) {
							queryMapReturn.put("medicalReportContent_isNull",
									medicalReportContent_isNull);
						}
						if (medicalReportContent_isNotNull != null) {
							queryMapReturn.put(
									"medicalReportContent_isNotNull",
									medicalReportContent_isNotNull);
						}
						if (medicalReportContent_in != null) {
							queryMapReturn.put("medicalReportContent_in",
									medicalReportContent_in);
						}
						if (medicalReportContent != null) {
							queryMapReturn.put("medicalReportContent",
									medicalReportContent);
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

						String delHospital = (String) contentreq
								.get("delHospital");
						if ("true".equals(delHospital)) {
							delHospitalReturn = true;
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
			if (medicalReportReturn != null) {
				parseMap.put("medicalReport", medicalReportReturn);
			}
			if (medicalReportListReturn != null
					&& medicalReportListReturn.size() > 0) {
				parseMap.put("medicalReportList", medicalReportListReturn);
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

			if (hospitalShowReturn != null) {
				parseMap.put("hospitalShow", hospitalShowReturn);
			}
			if (delHospitalReturn != null) {
				parseMap.put("delHospital", delHospitalReturn);
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
