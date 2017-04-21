package com.framework.system.common.controller.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sbtj.init.SystemInit;

import com.framework.system.common.entity.json.AjaxJson;
import com.framework.system.common.entity.user.UserEntity;
import com.framework.system.common.service.user.UserService;
import com.framework.system.util.Md5Utils;

@Controller
@RequestMapping("/systemLogin")
public class SystemLogin {
	private static Logger logger = Logger.getLogger(SystemLogin.class);
	private UserService userService = UserService.getInstance();
	
	@RequestMapping(params = "loginpage")
	public ModelAndView loginpage() {
		ModelAndView mav = new ModelAndView("/system/login");
		return mav;
	}

	@RequestMapping(params = "login")
	@ResponseBody
	public AjaxJson login(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String result = "failure";
		String msg = "登录失败";
		try {
			String username = request.getParameter("username").trim();
			String password = request.getParameter("password").trim();
			if (username == null || "".equals(username)) {
				result = "failure";
				msg = "请输入用户名";
				j.setResult(result);
				j.setDes(msg);
				return j;
			}
			if (password == null || Md5Utils.MD5("").equals(password)) {
				result = "failure";
				msg = "请输入密码";
				j.setResult(result);
				j.setDes(msg);
				return j;
			}
			// 校验
			String md5_pwd = Md5Utils.MD5(username + "$" + password);
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("loginname", username);
			List<UserEntity> listn = userService.getListByCondition(queryMap);
			if (listn == null || listn.size() == 0) {
				result = "failure";
				msg = "用户名不存在，请先注册";
				j.setResult(result);
				j.setDes(msg);
				return j;
			}
			queryMap.put("password", md5_pwd);
			List<UserEntity> list = userService.getListByCondition(queryMap);
			if (list != null && list.size() > 0) {
				UserEntity user = (UserEntity) list.get(0);
				if (user != null) {
					Map<String, Object> queryOlder = new HashMap<String, Object>();
					queryOlder.put("userId", user.getId());
					result = "success";
					msg = "登录成功";
					// 用户名保存到session
					request.getSession().setAttribute("userId", user.getId());
					request.getSession().setAttribute("loginname", user.getLoginname());
				}
			} else {
				result = "failure";
				msg = "密码错误";
				j.setResult(result);
				j.setDes(msg);
				return j;
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		j.setResult(result);
		j.setDes(msg);
		return j;
	}

	// 用户登出
	@RequestMapping(params = "logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().removeAttribute("userId");
		request.getSession().invalidate();
		return loginpage();
	}

}
