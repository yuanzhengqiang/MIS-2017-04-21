package com.framework.system.common.controller.user;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.framework.system.common.entity.json.AjaxJson;
import com.framework.system.common.entity.user.UserEntity;
import com.framework.system.common.handler.user.UserHandler;
import com.framework.system.common.service.user.UserService;
import com.framework.system.util.JsonUtil;

@RequestMapping("/systemUser")
@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	/**
	 * 服务类
	 */
	private UserService userService = UserService.getInstance();

	/**
	 * 列表页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "main")
	public ModelAndView center(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/system/user/UserList");
		return mav;
	}

	/**
	 * 批量删除 ids英文逗号间隔
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String result = "failure";
		String des = "删除失败";
		String ids = request.getParameter("ids");
		if (ids != null && !"".equals(ids)) {
			boolean falg = userService.del(ids);
			if (falg) {
				result = "success";
				des = "删除成功";
			}
		}
		j.setResult(result);
		j.setDes(des);
		return j;
	}

	/**
	 * 消息体格式请求处理
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "handler")
	@ResponseBody
	public String query(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		String reqmsg = (String) request.getParameter("reqmsg");
		// {'action':'QUERY_USER_LIST_REQUEST','page':{'pageno':'1','pagesize':'10'},'content':{}}

		Map reqParams = JsonUtil.getMap4Json(reqmsg);
		if (reqParams == null) {
			return msg;
		}

		String action = (String) reqParams.get("action");

		// 校验账号名称是否存在，新增和编辑
		if (action.equals("ADD_USER_INFO_REQUEST")) {
			JSONObject content = (JSONObject) reqParams.get("content");
			int id = 0;
			if (content.get("id") != null) {
				id = (Integer) content.get("id");
			}

			String loginname = (String) content.get("loginname");

			if (id == 0) {// 新增
				Map<String, Object> queryMap = new HashMap<String, Object>();
				queryMap.put("loginname", loginname);
				List<UserEntity> entiy = userService
						.getListByCondition(queryMap);
				if (entiy != null && entiy.size() > 0) {
					JSONObject jsonResult = new JSONObject();
					jsonResult.put("des", "have");
					String json2return = jsonResult.toString();
					try {
						json2return = new String(json2return.getBytes("utf-8"),
								"iso-8859-1");
					} catch (Exception e) {

					}
					return json2return;
				}
			} else {// 编辑
				Map<String, Object> queryMap = new HashMap<String, Object>();
				queryMap.put("loginname", loginname);
				List<UserEntity> entiy = userService
						.getListByCondition(queryMap);
				if (entiy != null && entiy.size() > 0) {
					for (UserEntity obj : entiy) {
						if (obj != null) {
							if (!obj.getId().equals(id)) {
								JSONObject jsonResult = new JSONObject();
								jsonResult.put("des", "have");
								String json2return = jsonResult.toString();
								try {
									json2return = new String(
											json2return.getBytes("utf-8"),
											"iso-8859-1");
								} catch (Exception e) {
									e.printStackTrace();
								}
								return json2return;
							}
						}
					}
				}
			}
		} else if ("QUERY_USER_LIST_REQUEST".equals(action)) {
			msg = UserHandler.getInstance().doHandler(1, action,
					reqParams.get("content").toString(), request, response);
		}
		return msg;
	}

	/**
	 * 重置用户的登入密码为默认
	 * 
	 * @param userid
	 *            用户的ID
	 * @return
	 */
	@RequestMapping(params = "reset")
	@ResponseBody
	public String resetPassword(String userid) {
		boolean resetResult = false;
		String des = "重置密码失败";
		int userId = 0;
		try {
			userId = Integer.parseInt(userid);
		} catch (Exception e) {
		}
		if (userId > 0) {
			resetResult = userService.resetPassword(userId);
			if (resetResult) {
				des = "密码重置成功";
			}
		} else {
			des = "错误的用户信息";
		}

		AjaxJson result = new AjaxJson();
		result.setDes(des);
		if (resetResult) {
			result.setResult("success");
		} else {
			result.setResult("failure");
		}

		String json2return = JSONObject.fromObject(result).toString();
		try {
			json2return = new String(json2return.getBytes("utf-8"),
					"iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return json2return;
	}

}
