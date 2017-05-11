package mis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.handler.MenuHandler;
import mis.service.MenuService;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sbtj.init.SystemInit;
import weixin.servlet.createMenu;
import weixin.tools.SignUtil;

import com.framework.system.common.entity.json.AjaxJson;
import com.framework.system.util.JsonUtil;

@RequestMapping("/menu")
@Controller
public class MenuController {
	private static Logger logger = Logger.getLogger(MenuController.class);
	/**
	 * 处理器
	 */
	private MenuHandler menuHandler = MenuHandler.getInstance();
	/**
	 * 服务类
	 */
	private MenuService menuService = MenuService.getInstance();

	/**
	 * 微信菜单管理
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "wechatMenuManagement")
	public ModelAndView wechatMenuManagement(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/wechatMenu/wechatMenuManagement");
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
			// 取到父菜单ID
			Map<String, Object> delMenuMap = new HashMap<String, Object>();
			delMenuMap.put("parentId_in", ids);
			menuService.delList(delMenuMap);
			boolean falg = menuService.del(ids);
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
		try {
			String reqmsg = request.getParameter("reqmsg");
			Map reqParams = JsonUtil.getMap4Json(reqmsg);
			if (reqParams == null) {
				return msg;
			}
			String action = (String) reqParams.get("action");
			String rep = menuHandler.doHandler(1, action, reqmsg, request,
					response);

			msg = new String(rep.getBytes("utf-8"), "iso-8859-1");
		} catch (Exception e) {
			logger.error(e.toString());
		}

		return msg;
	}

	/**
	 * 消息体格式请求处理
	 * 
	 * @param request
	 * @param response
	 * @return 微信处理
	 */
	@RequestMapping(params = "handlerWechat", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryWechat(HttpServletRequest request,
			HttpServletResponse response) {
		String msg = "";
		try {
			String reqmsg = request.getParameter("reqmsg");
			reqmsg = new String(reqmsg.getBytes("iso-8859-1"), "utf-8");
			Map reqParams = JsonUtil.getMap4Json(reqmsg);
			if (reqParams == null) {
				return msg;
			}
			String action = (String) reqParams.get("action");
			msg = menuHandler.doHandler(1, action, reqmsg, request, response);
		} catch (Exception e) {
			logger.error(e.toString());
		}

		return msg;
	}

	/**
	 * 消息体格式请求处理
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "handlercontent")
	public void queryApp(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			InputStream is = request.getInputStream();
			byte[] bis = IOUtils.toByteArray(is);
			String reqmsg = new String(bis, "UTF-8");
			Map reqParams = JsonUtil.getMap4Json(reqmsg);
			if (reqParams == null) {
				return;
			}
			String action = (String) reqParams.get("action");
			String rep = menuHandler.doHandler(1, action, reqmsg, request,
					response);
			OutputStream os = response.getOutputStream();
			os.write(rep.toString().getBytes("UTF-8"));
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}

	/**
	 * 获取微信公众号素材
	 * 
	 * @param idnumber
	 * @return
	 */
	@RequestMapping(params = "getMaterial")
	@ResponseBody
	public String getMaterial(HttpServletRequest request,
			Integer currentshownpage) {
		JSONObject jsonResult = new JSONObject();
		Map demoJson = null;
		// true则代表正式环境，可以开启获取token线程，获取微信服务器数据
		if ("formal".equals(SystemInit.weixinmsgpush)) {
			Integer offset = 0;
			if (currentshownpage > 1) {
				offset = 10 * (currentshownpage - 1);
			}
			SignUtil.getAccess_tokenByThread();
			// 获取素材地址
			String access_token = SystemInit.access_token;
			String reqmsg = "{\"type\":\"news\",\"offset\":\"" + offset
					+ "\",\"count\":\"10\"}";// type=news图文，offset=0位置开始返回，count=素材的数量取值在1到20之间
			String message = SignUtil.postForMaterial(
					"https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token="
							+ access_token, reqmsg);
			demoJson = JsonUtil.getMap4Json(message);
			String errmsg = (String) demoJson.get("errmsg");
			if (demoJson != null && errmsg == null) {// 返回体有errmsg则请求微信服务器出错
				jsonResult.put("item", demoJson);
				jsonResult.put("des", "success");
			} else {
				jsonResult.put("result", "获取微信素材列表失败");
				jsonResult.put("des", "failure");
			}
		} else {
			jsonResult.put("result", "当前测试环境，无法获取微信素材列表");
			jsonResult.put("des", "failure");
		}
		String json2return = jsonResult.toString();
		try {
			json2return = new String(json2return.getBytes("utf-8"),
					"iso-8859-1");
		} catch (UnsupportedEncodingException e) {

		}
		return json2return;
	}

	/**
	 * 更新微信菜单
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "updateWeChatMenu")
	@ResponseBody
	public String updateWeChatMenu(HttpServletRequest request) {
		Integer flag = 0;
		// true则代表正式环境，可以开启获取token线程，获取微信服务器数据
		if ("formal".equals(SystemInit.weixinmsgpush)) {
			SignUtil.getAccess_tokenByThread();
			try {
				flag = createMenu.createMenu();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			flag = 2;
		}
		JSONObject jsonResult = new JSONObject();
		if (flag == 1) {
			jsonResult.put("result", "更新微信菜单成功");
			jsonResult.put("des", "success");
		} else if (flag == 2) {
			jsonResult.put("result", "当前测试环境，无法更新微信菜单");
			jsonResult.put("des", "failure");
		} else {
			jsonResult.put("result", "更新微信菜单失败");
			jsonResult.put("des", "failure");
		}
		String json2return = jsonResult.toString();
		try {
			json2return = new String(json2return.getBytes("utf-8"),
					"iso-8859-1");
		} catch (UnsupportedEncodingException e) {

		}
		return json2return;
	}

}
