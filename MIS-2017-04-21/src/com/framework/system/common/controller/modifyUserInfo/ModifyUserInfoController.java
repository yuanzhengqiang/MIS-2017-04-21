package com.framework.system.common.controller.modifyUserInfo;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.system.common.entity.user.UserEntity;
import com.framework.system.common.service.user.UserService;
import com.framework.system.util.Md5Utils;


@RequestMapping("/modifyUserInfo")
@Controller	
public class ModifyUserInfoController {
	
	// 修改用户密码
	@RequestMapping(params = "modifyUserPwd")
	@ResponseBody
	public String modifyUserPwd (HttpServletRequest request, @RequestParam("loginUserPwd")String loginUserPwd, 
			@RequestParam("newUserPwd")String newUserPwd) {
		JSONObject resultjson = new JSONObject();
		String result = "failure";
		String R_Message = "";
		
		// 通过 session 获取用户 ID
		Object uInfoObj = request.getSession().getAttribute("userId");
		Integer uId = (Integer)uInfoObj;		
		
		UserService uService =  UserService.getInstance();
		
		if (uId != null) {
			UserEntity uEntity  = uService.getById(uId);
			
			String oldUserPwd = uEntity.getPassword();
			
			String md5_pwd = Md5Utils.MD5(uEntity.getLoginname() + "$" + loginUserPwd);
			if (oldUserPwd.equals(md5_pwd)) {
				// 如果为真则进行修改密码
				if (oldUserPwd.equals(newUserPwd)) {
					R_Message = "新密码与旧密码相同";
				} else {
					String md5_newPwd = Md5Utils.MD5(uEntity.getLoginname() + "$" + newUserPwd);
					uEntity.setPassword(md5_newPwd);
					uService.save(uEntity);			
					R_Message = "密码修改成功";
					result = "success";
				}
			} else {
				R_Message = "原密码输入错误";
			}
		} else {
			R_Message = "获取用户信息失败";
		}
		resultjson.put("result", result);
		resultjson.put("des", R_Message);
		
		String json2return=null;
		try {
			json2return = new String(resultjson.toString().getBytes("utf-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return json2return;
	}

}
