package com.framework.system.common.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.common.entity.user.UserEntity;
import com.framework.system.db.manager.DBManager;
import com.framework.system.db.query.OrderVO;
import com.framework.system.util.JsonUtil;

/**
 * @Title: Parse
 * @Description: 用户信息表解析器
 * @author feng.gu
 * @date 2017-04-21 12:20:27
 * @version V1.0
 * 
 */
public class UserParse {
	private static Logger logger = Logger.getLogger(UserParse.class);
	private static UserParse userParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static UserParse getInstance() {
		if (userParse == null) {
			userParse = new UserParse();
		}
		return userParse;
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
			UserEntity userReturn = null;
			List<UserEntity> userListReturn = null;
			Integer idReturn = null;
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;

			// json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject) reqParams.get("content");
			if ("ADD_USER_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				userReturn = new UserEntity();
				if (true) {
					if (contentreq != null) {
						Integer id = (Integer) contentreq.get("id");
						if (id != null) {
							userReturn = (UserEntity) dbManager.getById(id,
									UserEntity.class);
							userReturn.setId(id);
						}
						String loginname = (String) contentreq.get("loginname");
						if (loginname != null) {
							userReturn.setLoginname(loginname);
						}
						String password = (String) contentreq.get("password");
						if (password != null) {
							userReturn.setPassword(password);
						}
						String nickname = (String) contentreq.get("nickname");
						if (nickname != null) {
							userReturn.setNickname(nickname);
						}
						Integer status = (Integer) contentreq.get("status");
						if (status != null) {
							userReturn.setStatus(status);
						}
						Integer loginNum = (Integer) contentreq.get("loginNum");
						if (loginNum != null) {
							userReturn.setLoginNum(loginNum);
						}
						String loginTime = (String) contentreq.get("loginTime");
						if (loginTime != null) {
							userReturn.setLoginTime(loginTime);
						}
						String loginIp = (String) contentreq.get("loginIp");
						if (loginIp != null) {
							userReturn.setLoginIp(loginIp);
						}
						String lastLoginTime = (String) contentreq
								.get("lastLoginTime");
						if (lastLoginTime != null) {
							userReturn.setLastLoginTime(lastLoginTime);
						}
						String lastLoginIp = (String) contentreq
								.get("lastLoginIp");
						if (lastLoginIp != null) {
							userReturn.setLastLoginIp(lastLoginIp);
						}
						Integer createUserId = (Integer) contentreq
								.get("createUserId");
						if (createUserId != null) {
							userReturn.setCreateUserId(createUserId);
						}
						String createTime = (String) contentreq
								.get("createTime");
						if (createTime != null) {
							userReturn.setCreateTime(createTime);
						}
						Integer updateUserId = (Integer) contentreq
								.get("updateUserId");
						if (updateUserId != null) {
							userReturn.setUpdateUserId(updateUserId);
						}
						String updateTime = (String) contentreq
								.get("updateTime");
						if (updateTime != null) {
							userReturn.setUpdateTime(updateTime);
						}
						String type = (String) contentreq.get("type");
						if (type != null) {
							userReturn.setType(type);
						}
					}
				}
			} else if ("QUERY_USER_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
					}
				}
			} else if ("QUERY_USER_LIST_REQUEST".equals(command)) {
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
						String loginname_like = (String) contentreq
								.get("loginname_like");
						String loginname_isNull = (String) contentreq
								.get("loginname_isNull");
						String loginname_isNotNull = (String) contentreq
								.get("loginname_isNotNull");
						String loginname_in = (String) contentreq
								.get("loginname_in");
						String loginname = (String) contentreq.get("loginname");
						if (loginname_like != null) {
							queryMapReturn
									.put("loginname_like", loginname_like);
						}
						if (loginname_isNull != null) {
							queryMapReturn.put("loginname_isNull",
									loginname_isNull);
						}
						if (loginname_isNotNull != null) {
							queryMapReturn.put("loginname_isNotNull",
									loginname_isNotNull);
						}
						if (loginname_in != null) {
							queryMapReturn.put("loginname_in", loginname_in);
						}
						if (loginname != null) {
							queryMapReturn.put("loginname", loginname);
						}
						String password_like = (String) contentreq
								.get("password_like");
						String password_isNull = (String) contentreq
								.get("password_isNull");
						String password_isNotNull = (String) contentreq
								.get("password_isNotNull");
						String password_in = (String) contentreq
								.get("password_in");
						String password = (String) contentreq.get("password");
						if (password_like != null) {
							queryMapReturn.put("password_like", password_like);
						}
						if (password_isNull != null) {
							queryMapReturn.put("password_isNull",
									password_isNull);
						}
						if (password_isNotNull != null) {
							queryMapReturn.put("password_isNotNull",
									password_isNotNull);
						}
						if (password_in != null) {
							queryMapReturn.put("password_in", password_in);
						}
						if (password != null) {
							queryMapReturn.put("password", password);
						}
						String nickname_like = (String) contentreq
								.get("nickname_like");
						String nickname_isNull = (String) contentreq
								.get("nickname_isNull");
						String nickname_isNotNull = (String) contentreq
								.get("nickname_isNotNull");
						String nickname_in = (String) contentreq
								.get("nickname_in");
						String nickname = (String) contentreq.get("nickname");
						if (nickname_like != null) {
							queryMapReturn.put("nickname_like", nickname_like);
						}
						if (nickname_isNull != null) {
							queryMapReturn.put("nickname_isNull",
									nickname_isNull);
						}
						if (nickname_isNotNull != null) {
							queryMapReturn.put("nickname_isNotNull",
									nickname_isNotNull);
						}
						if (nickname_in != null) {
							queryMapReturn.put("nickname_in", nickname_in);
						}
						if (nickname != null) {
							queryMapReturn.put("nickname", nickname);
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
						Integer loginNum_gt = (Integer) contentreq
								.get("loginNum_gt");
						Integer loginNum_ge = (Integer) contentreq
								.get("loginNum_ge");
						Integer loginNum_lt = (Integer) contentreq
								.get("loginNum_lt");
						Integer loginNum_le = (Integer) contentreq
								.get("loginNum_le");
						String loginNum_in = (String) contentreq
								.get("loginNum_in");
						Integer loginNum = (Integer) contentreq.get("loginNum");
						if (loginNum_gt != null) {
							queryMapReturn.put("loginNum_gt", loginNum_gt);
						}
						if (loginNum_ge != null) {
							queryMapReturn.put("loginNum_ge", loginNum_ge);
						}
						if (loginNum_lt != null) {
							queryMapReturn.put("loginNum_lt", loginNum_lt);
						}
						if (loginNum_le != null) {
							queryMapReturn.put("loginNum_le", loginNum_le);
						}
						if (loginNum_in != null) {
							queryMapReturn.put("loginNum_in", loginNum_in);
						}
						if (loginNum != null) {
							queryMapReturn.put("loginNum", loginNum);
						}
						String loginTime_gt = (String) contentreq
								.get("loginTime_gt");
						String loginTime_ge = (String) contentreq
								.get("loginTime_ge");
						String loginTime_lt = (String) contentreq
								.get("loginTime_lt");
						String loginTime_le = (String) contentreq
								.get("loginTime_le");
						if (loginTime_gt != null) {
							queryMapReturn.put("loginTime_gt", loginTime_gt);
						}
						if (loginTime_ge != null) {
							queryMapReturn.put("loginTime_ge", loginTime_ge);
						}
						if (loginTime_lt != null) {
							queryMapReturn.put("loginTime_lt", loginTime_lt);
						}
						if (loginTime_le != null) {
							queryMapReturn.put("loginTime_le", loginTime_le);
						}
						String loginIp_like = (String) contentreq
								.get("loginIp_like");
						String loginIp_isNull = (String) contentreq
								.get("loginIp_isNull");
						String loginIp_isNotNull = (String) contentreq
								.get("loginIp_isNotNull");
						String loginIp_in = (String) contentreq
								.get("loginIp_in");
						String loginIp = (String) contentreq.get("loginIp");
						if (loginIp_like != null) {
							queryMapReturn.put("loginIp_like", loginIp_like);
						}
						if (loginIp_isNull != null) {
							queryMapReturn
									.put("loginIp_isNull", loginIp_isNull);
						}
						if (loginIp_isNotNull != null) {
							queryMapReturn.put("loginIp_isNotNull",
									loginIp_isNotNull);
						}
						if (loginIp_in != null) {
							queryMapReturn.put("loginIp_in", loginIp_in);
						}
						if (loginIp != null) {
							queryMapReturn.put("loginIp", loginIp);
						}
						String lastLoginTime_gt = (String) contentreq
								.get("lastLoginTime_gt");
						String lastLoginTime_ge = (String) contentreq
								.get("lastLoginTime_ge");
						String lastLoginTime_lt = (String) contentreq
								.get("lastLoginTime_lt");
						String lastLoginTime_le = (String) contentreq
								.get("lastLoginTime_le");
						if (lastLoginTime_gt != null) {
							queryMapReturn.put("lastLoginTime_gt",
									lastLoginTime_gt);
						}
						if (lastLoginTime_ge != null) {
							queryMapReturn.put("lastLoginTime_ge",
									lastLoginTime_ge);
						}
						if (lastLoginTime_lt != null) {
							queryMapReturn.put("lastLoginTime_lt",
									lastLoginTime_lt);
						}
						if (lastLoginTime_le != null) {
							queryMapReturn.put("lastLoginTime_le",
									lastLoginTime_le);
						}
						String lastLoginIp_like = (String) contentreq
								.get("lastLoginIp_like");
						String lastLoginIp_isNull = (String) contentreq
								.get("lastLoginIp_isNull");
						String lastLoginIp_isNotNull = (String) contentreq
								.get("lastLoginIp_isNotNull");
						String lastLoginIp_in = (String) contentreq
								.get("lastLoginIp_in");
						String lastLoginIp = (String) contentreq
								.get("lastLoginIp");
						if (lastLoginIp_like != null) {
							queryMapReturn.put("lastLoginIp_like",
									lastLoginIp_like);
						}
						if (lastLoginIp_isNull != null) {
							queryMapReturn.put("lastLoginIp_isNull",
									lastLoginIp_isNull);
						}
						if (lastLoginIp_isNotNull != null) {
							queryMapReturn.put("lastLoginIp_isNotNull",
									lastLoginIp_isNotNull);
						}
						if (lastLoginIp_in != null) {
							queryMapReturn
									.put("lastLoginIp_in", lastLoginIp_in);
						}
						if (lastLoginIp != null) {
							queryMapReturn.put("lastLoginIp", lastLoginIp);
						}
						Integer departmentId_gt = (Integer) contentreq
								.get("departmentId_gt");
						Integer departmentId_ge = (Integer) contentreq
								.get("departmentId_ge");
						Integer departmentId_lt = (Integer) contentreq
								.get("departmentId_lt");
						Integer departmentId_le = (Integer) contentreq
								.get("departmentId_le");
						String departmentId_in = (String) contentreq
								.get("departmentId_in");
						Integer departmentId = (Integer) contentreq
								.get("departmentId");
						if (departmentId_gt != null) {
							queryMapReturn.put("departmentId_gt",
									departmentId_gt);
						}
						if (departmentId_ge != null) {
							queryMapReturn.put("departmentId_ge",
									departmentId_ge);
						}
						if (departmentId_lt != null) {
							queryMapReturn.put("departmentId_lt",
									departmentId_lt);
						}
						if (departmentId_le != null) {
							queryMapReturn.put("departmentId_le",
									departmentId_le);
						}
						if (departmentId_in != null) {
							queryMapReturn.put("departmentId_in",
									departmentId_in);
						}
						if (departmentId != null) {
							queryMapReturn.put("departmentId", departmentId);
						}
						Integer createUserId_gt = (Integer) contentreq
								.get("createUserId_gt");
						Integer createUserId_ge = (Integer) contentreq
								.get("createUserId_ge");
						Integer createUserId_lt = (Integer) contentreq
								.get("createUserId_lt");
						Integer createUserId_le = (Integer) contentreq
								.get("createUserId_le");
						String createUserId_in = (String) contentreq
								.get("createUserId_in");
						Integer createUserId = (Integer) contentreq
								.get("createUserId");
						if (createUserId_gt != null) {
							queryMapReturn.put("createUserId_gt",
									createUserId_gt);
						}
						if (createUserId_ge != null) {
							queryMapReturn.put("createUserId_ge",
									createUserId_ge);
						}
						if (createUserId_lt != null) {
							queryMapReturn.put("createUserId_lt",
									createUserId_lt);
						}
						if (createUserId_le != null) {
							queryMapReturn.put("createUserId_le",
									createUserId_le);
						}
						if (createUserId_in != null) {
							queryMapReturn.put("createUserId_in",
									createUserId_in);
						}
						if (createUserId != null) {
							queryMapReturn.put("createUserId", createUserId);
						}
						String createTime_gt = (String) contentreq
								.get("createTime_gt");
						String createTime_ge = (String) contentreq
								.get("createTime_ge");
						String createTime_lt = (String) contentreq
								.get("createTime_lt");
						String createTime_le = (String) contentreq
								.get("createTime_le");
						if (createTime_gt != null) {
							queryMapReturn.put("createTime_gt", createTime_gt);
						}
						if (createTime_ge != null) {
							queryMapReturn.put("createTime_ge", createTime_ge);
						}
						if (createTime_lt != null) {
							queryMapReturn.put("createTime_lt", createTime_lt);
						}
						if (createTime_le != null) {
							queryMapReturn.put("createTime_le", createTime_le);
						}
						Integer updateUserId_gt = (Integer) contentreq
								.get("updateUserId_gt");
						Integer updateUserId_ge = (Integer) contentreq
								.get("updateUserId_ge");
						Integer updateUserId_lt = (Integer) contentreq
								.get("updateUserId_lt");
						Integer updateUserId_le = (Integer) contentreq
								.get("updateUserId_le");
						String updateUserId_in = (String) contentreq
								.get("updateUserId_in");
						Integer updateUserId = (Integer) contentreq
								.get("updateUserId");
						if (updateUserId_gt != null) {
							queryMapReturn.put("updateUserId_gt",
									updateUserId_gt);
						}
						if (updateUserId_ge != null) {
							queryMapReturn.put("updateUserId_ge",
									updateUserId_ge);
						}
						if (updateUserId_lt != null) {
							queryMapReturn.put("updateUserId_lt",
									updateUserId_lt);
						}
						if (updateUserId_le != null) {
							queryMapReturn.put("updateUserId_le",
									updateUserId_le);
						}
						if (updateUserId_in != null) {
							queryMapReturn.put("updateUserId_in",
									updateUserId_in);
						}
						if (updateUserId != null) {
							queryMapReturn.put("updateUserId", updateUserId);
						}
						String updateTime_gt = (String) contentreq
								.get("updateTime_gt");
						String updateTime_ge = (String) contentreq
								.get("updateTime_ge");
						String updateTime_lt = (String) contentreq
								.get("updateTime_lt");
						String updateTime_le = (String) contentreq
								.get("updateTime_le");
						if (updateTime_gt != null) {
							queryMapReturn.put("updateTime_gt", updateTime_gt);
						}
						if (updateTime_ge != null) {
							queryMapReturn.put("updateTime_ge", updateTime_ge);
						}
						if (updateTime_lt != null) {
							queryMapReturn.put("updateTime_lt", updateTime_lt);
						}
						if (updateTime_le != null) {
							queryMapReturn.put("updateTime_le", updateTime_le);
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
			} else if ("DEL_USER_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if (true) {
					if (contentreq != null) {
						idReturn = (Integer) contentreq.get("id");
					}
				}
			} else if ("DEL_USER_LIST_REQUEST".equals(command)) {
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
						String loginname_like = (String) contentreq
								.get("loginname_like");
						String loginname_isNull = (String) contentreq
								.get("loginname_isNull");
						String loginname_isNotNull = (String) contentreq
								.get("loginname_isNotNull");
						String loginname_in = (String) contentreq
								.get("loginname_in");
						String loginname = (String) contentreq.get("loginname");
						if (loginname_like != null) {
							queryMapReturn
									.put("loginname_like", loginname_like);
						}
						if (loginname_isNull != null) {
							queryMapReturn.put("loginname_isNull",
									loginname_isNull);
						}
						if (loginname_isNotNull != null) {
							queryMapReturn.put("loginname_isNotNull",
									loginname_isNotNull);
						}
						if (loginname_in != null) {
							queryMapReturn.put("loginname_in", loginname_in);
						}
						if (loginname != null) {
							queryMapReturn.put("loginname", loginname);
						}
						String password_like = (String) contentreq
								.get("password_like");
						String password_isNull = (String) contentreq
								.get("password_isNull");
						String password_isNotNull = (String) contentreq
								.get("password_isNotNull");
						String password_in = (String) contentreq
								.get("password_in");
						String password = (String) contentreq.get("password");
						if (password_like != null) {
							queryMapReturn.put("password_like", password_like);
						}
						if (password_isNull != null) {
							queryMapReturn.put("password_isNull",
									password_isNull);
						}
						if (password_isNotNull != null) {
							queryMapReturn.put("password_isNotNull",
									password_isNotNull);
						}
						if (password_in != null) {
							queryMapReturn.put("password_in", password_in);
						}
						if (password != null) {
							queryMapReturn.put("password", password);
						}
						String nickname_like = (String) contentreq
								.get("nickname_like");
						String nickname_isNull = (String) contentreq
								.get("nickname_isNull");
						String nickname_isNotNull = (String) contentreq
								.get("nickname_isNotNull");
						String nickname_in = (String) contentreq
								.get("nickname_in");
						String nickname = (String) contentreq.get("nickname");
						if (nickname_like != null) {
							queryMapReturn.put("nickname_like", nickname_like);
						}
						if (nickname_isNull != null) {
							queryMapReturn.put("nickname_isNull",
									nickname_isNull);
						}
						if (nickname_isNotNull != null) {
							queryMapReturn.put("nickname_isNotNull",
									nickname_isNotNull);
						}
						if (nickname_in != null) {
							queryMapReturn.put("nickname_in", nickname_in);
						}
						if (nickname != null) {
							queryMapReturn.put("nickname", nickname);
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
						Integer loginNum_gt = (Integer) contentreq
								.get("loginNum_gt");
						Integer loginNum_ge = (Integer) contentreq
								.get("loginNum_ge");
						Integer loginNum_lt = (Integer) contentreq
								.get("loginNum_lt");
						Integer loginNum_le = (Integer) contentreq
								.get("loginNum_le");
						String loginNum_in = (String) contentreq
								.get("loginNum_in");
						Integer loginNum = (Integer) contentreq.get("loginNum");
						if (loginNum_gt != null) {
							queryMapReturn.put("loginNum_gt", loginNum_gt);
						}
						if (loginNum_ge != null) {
							queryMapReturn.put("loginNum_ge", loginNum_ge);
						}
						if (loginNum_lt != null) {
							queryMapReturn.put("loginNum_lt", loginNum_lt);
						}
						if (loginNum_le != null) {
							queryMapReturn.put("loginNum_le", loginNum_le);
						}
						if (loginNum_in != null) {
							queryMapReturn.put("loginNum_in", loginNum_in);
						}
						if (loginNum != null) {
							queryMapReturn.put("loginNum", loginNum);
						}
						String loginTime_gt = (String) contentreq
								.get("loginTime_gt");
						String loginTime_ge = (String) contentreq
								.get("loginTime_ge");
						String loginTime_lt = (String) contentreq
								.get("loginTime_lt");
						String loginTime_le = (String) contentreq
								.get("loginTime_le");
						if (loginTime_gt != null) {
							queryMapReturn.put("loginTime_gt", loginTime_gt);
						}
						if (loginTime_ge != null) {
							queryMapReturn.put("loginTime_ge", loginTime_ge);
						}
						if (loginTime_lt != null) {
							queryMapReturn.put("loginTime_lt", loginTime_lt);
						}
						if (loginTime_le != null) {
							queryMapReturn.put("loginTime_le", loginTime_le);
						}
						String loginIp_like = (String) contentreq
								.get("loginIp_like");
						String loginIp_isNull = (String) contentreq
								.get("loginIp_isNull");
						String loginIp_isNotNull = (String) contentreq
								.get("loginIp_isNotNull");
						String loginIp_in = (String) contentreq
								.get("loginIp_in");
						String loginIp = (String) contentreq.get("loginIp");
						if (loginIp_like != null) {
							queryMapReturn.put("loginIp_like", loginIp_like);
						}
						if (loginIp_isNull != null) {
							queryMapReturn
									.put("loginIp_isNull", loginIp_isNull);
						}
						if (loginIp_isNotNull != null) {
							queryMapReturn.put("loginIp_isNotNull",
									loginIp_isNotNull);
						}
						if (loginIp_in != null) {
							queryMapReturn.put("loginIp_in", loginIp_in);
						}
						if (loginIp != null) {
							queryMapReturn.put("loginIp", loginIp);
						}
						String lastLoginTime_gt = (String) contentreq
								.get("lastLoginTime_gt");
						String lastLoginTime_ge = (String) contentreq
								.get("lastLoginTime_ge");
						String lastLoginTime_lt = (String) contentreq
								.get("lastLoginTime_lt");
						String lastLoginTime_le = (String) contentreq
								.get("lastLoginTime_le");
						if (lastLoginTime_gt != null) {
							queryMapReturn.put("lastLoginTime_gt",
									lastLoginTime_gt);
						}
						if (lastLoginTime_ge != null) {
							queryMapReturn.put("lastLoginTime_ge",
									lastLoginTime_ge);
						}
						if (lastLoginTime_lt != null) {
							queryMapReturn.put("lastLoginTime_lt",
									lastLoginTime_lt);
						}
						if (lastLoginTime_le != null) {
							queryMapReturn.put("lastLoginTime_le",
									lastLoginTime_le);
						}
						String lastLoginIp_like = (String) contentreq
								.get("lastLoginIp_like");
						String lastLoginIp_isNull = (String) contentreq
								.get("lastLoginIp_isNull");
						String lastLoginIp_isNotNull = (String) contentreq
								.get("lastLoginIp_isNotNull");
						String lastLoginIp_in = (String) contentreq
								.get("lastLoginIp_in");
						String lastLoginIp = (String) contentreq
								.get("lastLoginIp");
						if (lastLoginIp_like != null) {
							queryMapReturn.put("lastLoginIp_like",
									lastLoginIp_like);
						}
						if (lastLoginIp_isNull != null) {
							queryMapReturn.put("lastLoginIp_isNull",
									lastLoginIp_isNull);
						}
						if (lastLoginIp_isNotNull != null) {
							queryMapReturn.put("lastLoginIp_isNotNull",
									lastLoginIp_isNotNull);
						}
						if (lastLoginIp_in != null) {
							queryMapReturn
									.put("lastLoginIp_in", lastLoginIp_in);
						}
						if (lastLoginIp != null) {
							queryMapReturn.put("lastLoginIp", lastLoginIp);
						}
						Integer departmentId_gt = (Integer) contentreq
								.get("departmentId_gt");
						Integer departmentId_ge = (Integer) contentreq
								.get("departmentId_ge");
						Integer departmentId_lt = (Integer) contentreq
								.get("departmentId_lt");
						Integer departmentId_le = (Integer) contentreq
								.get("departmentId_le");
						String departmentId_in = (String) contentreq
								.get("departmentId_in");
						Integer departmentId = (Integer) contentreq
								.get("departmentId");
						if (departmentId_gt != null) {
							queryMapReturn.put("departmentId_gt",
									departmentId_gt);
						}
						if (departmentId_ge != null) {
							queryMapReturn.put("departmentId_ge",
									departmentId_ge);
						}
						if (departmentId_lt != null) {
							queryMapReturn.put("departmentId_lt",
									departmentId_lt);
						}
						if (departmentId_le != null) {
							queryMapReturn.put("departmentId_le",
									departmentId_le);
						}
						if (departmentId_in != null) {
							queryMapReturn.put("departmentId_in",
									departmentId_in);
						}
						if (departmentId != null) {
							queryMapReturn.put("departmentId", departmentId);
						}
						Integer personinfoId_gt = (Integer) contentreq
								.get("personinfoId_gt");
						Integer personinfoId_ge = (Integer) contentreq
								.get("personinfoId_ge");
						Integer personinfoId_lt = (Integer) contentreq
								.get("personinfoId_lt");
						Integer personinfoId_le = (Integer) contentreq
								.get("personinfoId_le");
						String personinfoId_in = (String) contentreq
								.get("personinfoId_in");
						Integer personinfoId = (Integer) contentreq
								.get("personinfoId");
						if (personinfoId_gt != null) {
							queryMapReturn.put("personinfoId_gt",
									personinfoId_gt);
						}
						if (personinfoId_ge != null) {
							queryMapReturn.put("personinfoId_ge",
									personinfoId_ge);
						}
						if (personinfoId_lt != null) {
							queryMapReturn.put("personinfoId_lt",
									personinfoId_lt);
						}
						if (personinfoId_le != null) {
							queryMapReturn.put("personinfoId_le",
									personinfoId_le);
						}
						if (personinfoId_in != null) {
							queryMapReturn.put("personinfoId_in",
									personinfoId_in);
						}
						if (personinfoId != null) {
							queryMapReturn.put("personinfoId", personinfoId);
						}
						Integer createUserId_gt = (Integer) contentreq
								.get("createUserId_gt");
						Integer createUserId_ge = (Integer) contentreq
								.get("createUserId_ge");
						Integer createUserId_lt = (Integer) contentreq
								.get("createUserId_lt");
						Integer createUserId_le = (Integer) contentreq
								.get("createUserId_le");
						String createUserId_in = (String) contentreq
								.get("createUserId_in");
						Integer createUserId = (Integer) contentreq
								.get("createUserId");
						if (createUserId_gt != null) {
							queryMapReturn.put("createUserId_gt",
									createUserId_gt);
						}
						if (createUserId_ge != null) {
							queryMapReturn.put("createUserId_ge",
									createUserId_ge);
						}
						if (createUserId_lt != null) {
							queryMapReturn.put("createUserId_lt",
									createUserId_lt);
						}
						if (createUserId_le != null) {
							queryMapReturn.put("createUserId_le",
									createUserId_le);
						}
						if (createUserId_in != null) {
							queryMapReturn.put("createUserId_in",
									createUserId_in);
						}
						if (createUserId != null) {
							queryMapReturn.put("createUserId", createUserId);
						}
						String createTime_gt = (String) contentreq
								.get("createTime_gt");
						String createTime_ge = (String) contentreq
								.get("createTime_ge");
						String createTime_lt = (String) contentreq
								.get("createTime_lt");
						String createTime_le = (String) contentreq
								.get("createTime_le");
						if (createTime_gt != null) {
							queryMapReturn.put("createTime_gt", createTime_gt);
						}
						if (createTime_ge != null) {
							queryMapReturn.put("createTime_ge", createTime_ge);
						}
						if (createTime_lt != null) {
							queryMapReturn.put("createTime_lt", createTime_lt);
						}
						if (createTime_le != null) {
							queryMapReturn.put("createTime_le", createTime_le);
						}
						Integer updateUserId_gt = (Integer) contentreq
								.get("updateUserId_gt");
						Integer updateUserId_ge = (Integer) contentreq
								.get("updateUserId_ge");
						Integer updateUserId_lt = (Integer) contentreq
								.get("updateUserId_lt");
						Integer updateUserId_le = (Integer) contentreq
								.get("updateUserId_le");
						String updateUserId_in = (String) contentreq
								.get("updateUserId_in");
						Integer updateUserId = (Integer) contentreq
								.get("updateUserId");
						if (updateUserId_gt != null) {
							queryMapReturn.put("updateUserId_gt",
									updateUserId_gt);
						}
						if (updateUserId_ge != null) {
							queryMapReturn.put("updateUserId_ge",
									updateUserId_ge);
						}
						if (updateUserId_lt != null) {
							queryMapReturn.put("updateUserId_lt",
									updateUserId_lt);
						}
						if (updateUserId_le != null) {
							queryMapReturn.put("updateUserId_le",
									updateUserId_le);
						}
						if (updateUserId_in != null) {
							queryMapReturn.put("updateUserId_in",
									updateUserId_in);
						}
						if (updateUserId != null) {
							queryMapReturn.put("updateUserId", updateUserId);
						}
						String updateTime_gt = (String) contentreq
								.get("updateTime_gt");
						String updateTime_ge = (String) contentreq
								.get("updateTime_ge");
						String updateTime_lt = (String) contentreq
								.get("updateTime_lt");
						String updateTime_le = (String) contentreq
								.get("updateTime_le");
						if (updateTime_gt != null) {
							queryMapReturn.put("updateTime_gt", updateTime_gt);
						}
						if (updateTime_ge != null) {
							queryMapReturn.put("updateTime_ge", updateTime_ge);
						}
						if (updateTime_lt != null) {
							queryMapReturn.put("updateTime_lt", updateTime_lt);
						}
						if (updateTime_le != null) {
							queryMapReturn.put("updateTime_le", updateTime_le);
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
			if (userReturn != null) {
				parseMap.put("user", userReturn);
			}
			if (userListReturn != null && userListReturn.size() > 0) {
				parseMap.put("userList", userListReturn);
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
