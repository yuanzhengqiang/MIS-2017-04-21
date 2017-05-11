package mis.controller;

import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.handler.WechatCustomerHandler;
import mis.service.WechatCustomerService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.framework.system.common.entity.json.AjaxJson;
import com.framework.system.util.JsonUtil;

@RequestMapping("/wechatCustomer")
@Controller
public class WechatCustomerController {
	private static Logger logger = Logger
			.getLogger(WechatCustomerController.class);
	/**
	 * 处理器
	 */
	private WechatCustomerHandler wechatCustomerHandler = WechatCustomerHandler
			.getInstance();
	/**
	 * 服务类
	 */
	private WechatCustomerService wechatCustomerService = WechatCustomerService
			.getInstance();

	/**
	 * 微信客户管理
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "main")
	public ModelAndView center(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("wechatCustomerManagement/wechatCustomerList");
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
			boolean falg = wechatCustomerService.del(ids);
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
			String rep = wechatCustomerHandler.doHandler(1, action, reqmsg,
					request, response);
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
	public String queryWechat(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		try {
			String reqmsg = request.getParameter("reqmsg");
			reqmsg = new String(reqmsg.getBytes("iso-8859-1"), "utf-8");
			Map reqParams = JsonUtil.getMap4Json(reqmsg);
			if (reqParams == null) {
				return msg;
			}
			String action = (String) reqParams.get("action");
			msg = wechatCustomerHandler.doHandler(1, action, reqmsg, request, response);
		} catch (Exception e) {
			logger.error(e.toString());
		}

		return msg;
	}
}
