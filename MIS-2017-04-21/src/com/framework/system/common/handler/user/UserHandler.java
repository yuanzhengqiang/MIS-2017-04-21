package com.framework.system.common.handler.user;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.common.entity.user.UserEntity;
import com.framework.system.common.pack.user.UserPack;
import com.framework.system.common.parse.UserParse;
import com.framework.system.common.service.user.UserService;
import com.framework.system.db.query.OrderVO;

 /**   
 * @Title: Handler
 * @Description: 用户信息表业务处理器
 * @author feng.gu
 * @date 2017-04-21 12:22:49
 * @version V1.0   
 *
 */
public class UserHandler extends BaseHandler{
	private static Logger logger = Logger.getLogger(UserService.class);
	/**
	 * 解析器
	 */
	private UserParse userParse = UserParse.getInstance();
	/**
	 * 业务处理器
	 */
	private UserService userService = UserService.getInstance();
	/**
	 * 封装器
	 */
	private UserPack userPack = UserPack.getInstance();

	private static UserHandler userHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static UserHandler getInstance() {
		if (userHandler == null) {
			userHandler = new UserHandler();
		}
		return userHandler;
	}

	/**
	 * 
	 * @param type 1-json 2-xml
	 * @param entityName
	 * @param command
	 * @param reqStr
	 * @param request
	 * @param response
	 */
	public String doHandler(int type,String command,String reqStr, HttpServletRequest request,
			HttpServletResponse response) {		
		logger.debug("请求消息："+reqStr);
		String resultStr="";
		try {
			// 解析
			Map<String, Object> parseMap = userParse.parse(type,command,reqStr,request);		
			String action = (String) parseMap.get("action");
			UserEntity user = (UserEntity) parseMap.get("user");
			List<UserEntity> userList = (List<UserEntity>) parseMap.get("userList");
			Integer id = (Integer) parseMap.get("id");			
			Map<String, Object> queryMap = (Map<String, Object>) parseMap.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");
			
						
			// 业务处理
			Object result=null;
			if ("save".equals(action)) {
				result = userService.save(user);
			} else if ("saveList".equals(action)) {
				result = userService.saveList(userList);
			} else if ("getById".equals(action)) {
				result = userService.getById(id);
			} else if ("del".equals(action)) {
				result = userService.del(id);
			} else if ("delList".equals(action)) {
				result = userService.delList(queryMap);
			} else if ("getListByCondition".equals(action)) {
				result = userService.getListByCondition(queryMap, pageno, pagesize);
			}
			// 封装
			Map<String, Object> packMap = userPack.pack(type,action,result,user);
			String actionBack = (String)packMap.get("action");
			String resultBack = (String)packMap.get("result");
			String desBack = (String)packMap.get("des");
			JSONObject pageBack = (JSONObject)packMap.get("page");
			JSONObject contentBack = (JSONObject)packMap.get("content");
			
			JSONObject repJson = new JSONObject();
			if(actionBack!=null&&!"".equals(actionBack)){
				repJson.put("action", actionBack);
			}
			if(resultBack!=null&&!"".equals(resultBack)){
				repJson.put("result", resultBack);
			}
			if(desBack!=null&&!"".equals(desBack)){
				repJson.put("des", desBack);
			}
			if(pageBack!=null){
				repJson.put("page", pageBack);
			}
			if(contentBack!=null&&!"".equals(contentBack)){
				repJson.put("content", contentBack);
			}
			logger.debug("返回消息："+repJson.toString());
			resultStr = repJson.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		return resultStr;
	}
}
