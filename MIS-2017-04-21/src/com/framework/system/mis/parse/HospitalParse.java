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
import com.framework.system.mis.entity.AreaEntity;
import com.framework.system.mis.entity.HospitalEntity;
import com.framework.system.util.JsonUtil;

/**
 * @Title: Parse
 * @Description: 医院表解析器
 * @author feng.gu
 * @date 2017-04-21 17:05:03
 * @version V1.0
 * 
 */
public class HospitalParse {
	private static Logger logger = Logger.getLogger(HospitalParse.class);
	private static HospitalParse hospitalParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static HospitalParse getInstance() {
		if (hospitalParse == null) {
			hospitalParse = new HospitalParse();
		}
		return hospitalParse;
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
			HospitalEntity hospitalReturn = null;
			List<HospitalEntity> hospitalListReturn = null;
			Integer idReturn = null;
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;

			Boolean areaEntityShowReturn = false;
			Boolean delAreaEntityReturn = false;

			// json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject) reqParams.get("content");
			if ("ADD_HOSPITAL_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				hospitalReturn = new HospitalEntity();
				if (true) {
					if (contentreq != null) {
						Integer id = (Integer) contentreq.get("id");
						if (id != null) {
							hospitalReturn = (HospitalEntity) dbManager
									.getById(id, HospitalEntity.class);
							hospitalReturn.setId(id);
						}
						String hospitalName = (String) contentreq
								.get("hospitalName");
						if (hospitalName != null) {
							hospitalReturn.setHospitalName(hospitalName);
						}
						String level = (String) contentreq.get("level");
						if (level != null) {
							hospitalReturn.setLevel(level);
						}
						Integer areaId = (Integer) contentreq.get("areaId");
						if (areaId != null) {
							hospitalReturn.setAreaId(areaId);
						}
						String addr = (String) contentreq.get("addr");
						if (addr != null) {
							hospitalReturn.setAddr(addr);
						}
					}
				}
				if (true) {
					Object areaEntity = contentreq.get("areaEntity");
					if (areaEntity != null) {
						JSONObject obj = (JSONObject) areaEntity;
						if (obj != null) {
							AreaEntity entity = new AreaEntity();
							Integer id = (Integer) obj.get("id");
							if (id != null) {
								entity.setId(id);
							}
							String area = (String) obj.get("area");
							if (area != null) {
								entity.setArea(area);
							}
							String updateTime = (String) obj.get("updateTime");
							if (updateTime != null) {
								entity.setUpdateTime(updateTime);
							}
							hospitalReturn.setAreaEntity(entity);
						}
					}
				}
			} else if ("QUERY_HOSPITAL_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String areaEntityShow = (String) contentreq
								.get("areaEntityShow");
						if ("true".equals(areaEntityShow)) {
							areaEntityShowReturn = true;
						}
					}
				}
			} else if ("QUERY_HOSPITAL_LIST_REQUEST".equals(command)) {
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
						String hospitalName_like = (String) contentreq
								.get("hospitalName_like");
						String hospitalName_isNull = (String) contentreq
								.get("hospitalName_isNull");
						String hospitalName_isNotNull = (String) contentreq
								.get("hospitalName_isNotNull");
						String hospitalName_in = (String) contentreq
								.get("hospitalName_in");
						String hospitalName = (String) contentreq
								.get("hospitalName");
						if (hospitalName_like != null) {
							queryMapReturn.put("hospitalName_like",
									hospitalName_like);
						}
						if (hospitalName_isNull != null) {
							queryMapReturn.put("hospitalName_isNull",
									hospitalName_isNull);
						}
						if (hospitalName_isNotNull != null) {
							queryMapReturn.put("hospitalName_isNotNull",
									hospitalName_isNotNull);
						}
						if (hospitalName_in != null) {
							queryMapReturn.put("hospitalName_in",
									hospitalName_in);
						}
						if (hospitalName != null) {
							queryMapReturn.put("hospitalName", hospitalName);
						}
						String level_like = (String) contentreq
								.get("level_like");
						String level_isNull = (String) contentreq
								.get("level_isNull");
						String level_isNotNull = (String) contentreq
								.get("level_isNotNull");
						String level_in = (String) contentreq.get("level_in");
						String level = (String) contentreq.get("level");
						if (level_like != null) {
							queryMapReturn.put("level_like", level_like);
						}
						if (level_isNull != null) {
							queryMapReturn.put("level_isNull", level_isNull);
						}
						if (level_isNotNull != null) {
							queryMapReturn.put("level_isNotNull",
									level_isNotNull);
						}
						if (level_in != null) {
							queryMapReturn.put("level_in", level_in);
						}
						if (level != null) {
							queryMapReturn.put("level", level);
						}
						Integer areaId_gt = (Integer) contentreq
								.get("areaId_gt");
						Integer areaId_ge = (Integer) contentreq
								.get("areaId_ge");
						Integer areaId_lt = (Integer) contentreq
								.get("areaId_lt");
						Integer areaId_le = (Integer) contentreq
								.get("areaId_le");
						String areaId_in = (String) contentreq.get("areaId_in");
						Integer areaId = (Integer) contentreq.get("areaId");
						if (areaId_gt != null) {
							queryMapReturn.put("areaId_gt", areaId_gt);
						}
						if (areaId_ge != null) {
							queryMapReturn.put("areaId_ge", areaId_ge);
						}
						if (areaId_lt != null) {
							queryMapReturn.put("areaId_lt", areaId_lt);
						}
						if (areaId_le != null) {
							queryMapReturn.put("areaId_le", areaId_le);
						}
						if (areaId_in != null) {
							queryMapReturn.put("areaId_in", areaId_in);
						}
						if (areaId != null) {
							queryMapReturn.put("areaId", areaId);
						}
						String addr_like = (String) contentreq.get("addr_like");
						String addr_isNull = (String) contentreq
								.get("addr_isNull");
						String addr_isNotNull = (String) contentreq
								.get("addr_isNotNull");
						String addr_in = (String) contentreq.get("addr_in");
						String addr = (String) contentreq.get("addr");
						if (addr_like != null) {
							queryMapReturn.put("addr_like", addr_like);
						}
						if (addr_isNull != null) {
							queryMapReturn.put("addr_isNull", addr_isNull);
						}
						if (addr_isNotNull != null) {
							queryMapReturn
									.put("addr_isNotNull", addr_isNotNull);
						}
						if (addr_in != null) {
							queryMapReturn.put("addr_in", addr_in);
						}
						if (addr != null) {
							queryMapReturn.put("addr", addr);
						}

						String areaEntityShow = (String) contentreq
								.get("areaEntityShow");
						if ("true".equals(areaEntityShow)) {
							areaEntityShowReturn = true;
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
			} else if ("DEL_HOSPITAL_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
						String delAreaEntity = (String) contentreq
								.get("delAreaEntity");
						if ("true".equals(delAreaEntity)) {
							delAreaEntityReturn = true;
						}
					}
				}
			} else if ("DEL_HOSPITAL_LIST_REQUEST".equals(command)) {
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
						String hospitalName_like = (String) contentreq
								.get("hospitalName_like");
						String hospitalName_isNull = (String) contentreq
								.get("hospitalName_isNull");
						String hospitalName_isNotNull = (String) contentreq
								.get("hospitalName_isNotNull");
						String hospitalName_in = (String) contentreq
								.get("hospitalName_in");
						String hospitalName = (String) contentreq
								.get("hospitalName");
						if (hospitalName_like != null) {
							queryMapReturn.put("hospitalName_like",
									hospitalName_like);
						}
						if (hospitalName_isNull != null) {
							queryMapReturn.put("hospitalName_isNull",
									hospitalName_isNull);
						}
						if (hospitalName_isNotNull != null) {
							queryMapReturn.put("hospitalName_isNotNull",
									hospitalName_isNotNull);
						}
						if (hospitalName_in != null) {
							queryMapReturn.put("hospitalName_in",
									hospitalName_in);
						}
						if (hospitalName != null) {
							queryMapReturn.put("hospitalName", hospitalName);
						}
						String level_like = (String) contentreq
								.get("level_like");
						String level_isNull = (String) contentreq
								.get("level_isNull");
						String level_isNotNull = (String) contentreq
								.get("level_isNotNull");
						String level_in = (String) contentreq.get("level_in");
						String level = (String) contentreq.get("level");
						if (level_like != null) {
							queryMapReturn.put("level_like", level_like);
						}
						if (level_isNull != null) {
							queryMapReturn.put("level_isNull", level_isNull);
						}
						if (level_isNotNull != null) {
							queryMapReturn.put("level_isNotNull",
									level_isNotNull);
						}
						if (level_in != null) {
							queryMapReturn.put("level_in", level_in);
						}
						if (level != null) {
							queryMapReturn.put("level", level);
						}
						Integer areaId_gt = (Integer) contentreq
								.get("areaId_gt");
						Integer areaId_ge = (Integer) contentreq
								.get("areaId_ge");
						Integer areaId_lt = (Integer) contentreq
								.get("areaId_lt");
						Integer areaId_le = (Integer) contentreq
								.get("areaId_le");
						String areaId_in = (String) contentreq.get("areaId_in");
						Integer areaId = (Integer) contentreq.get("areaId");
						if (areaId_gt != null) {
							queryMapReturn.put("areaId_gt", areaId_gt);
						}
						if (areaId_ge != null) {
							queryMapReturn.put("areaId_ge", areaId_ge);
						}
						if (areaId_lt != null) {
							queryMapReturn.put("areaId_lt", areaId_lt);
						}
						if (areaId_le != null) {
							queryMapReturn.put("areaId_le", areaId_le);
						}
						if (areaId_in != null) {
							queryMapReturn.put("areaId_in", areaId_in);
						}
						if (areaId != null) {
							queryMapReturn.put("areaId", areaId);
						}
						String addr_like = (String) contentreq.get("addr_like");
						String addr_isNull = (String) contentreq
								.get("addr_isNull");
						String addr_isNotNull = (String) contentreq
								.get("addr_isNotNull");
						String addr_in = (String) contentreq.get("addr_in");
						String addr = (String) contentreq.get("addr");
						if (addr_like != null) {
							queryMapReturn.put("addr_like", addr_like);
						}
						if (addr_isNull != null) {
							queryMapReturn.put("addr_isNull", addr_isNull);
						}
						if (addr_isNotNull != null) {
							queryMapReturn
									.put("addr_isNotNull", addr_isNotNull);
						}
						if (addr_in != null) {
							queryMapReturn.put("addr_in", addr_in);
						}
						if (addr != null) {
							queryMapReturn.put("addr", addr);
						}

						String delAreaEntity = (String) contentreq
								.get("delAreaEntity");
						if ("true".equals(delAreaEntity)) {
							delAreaEntityReturn = true;
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
			if (hospitalReturn != null) {
				parseMap.put("hospital", hospitalReturn);
			}
			if (hospitalListReturn != null && hospitalListReturn.size() > 0) {
				parseMap.put("hospitalList", hospitalListReturn);
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

			if (areaEntityShowReturn != null) {
				parseMap.put("areaEntityShow", areaEntityShowReturn);
			}
			if (delAreaEntityReturn != null) {
				parseMap.put("delAreaEntity", delAreaEntityReturn);
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
