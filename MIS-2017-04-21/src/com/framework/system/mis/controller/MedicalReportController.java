package com.framework.system.mis.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.framework.system.common.entity.json.AjaxJson;
import com.framework.system.mis.handler.MedicalReportHandler;
import com.framework.system.mis.service.MedicalReportService;
import com.framework.system.util.JsonUtil;

@RequestMapping("/medicalReport")
@Controller
public class MedicalReportController {
	private static Logger logger = Logger
			.getLogger(MedicalReportController.class);
	/**
	 * 处理器
	 */
	private MedicalReportHandler medicalReportHandler = MedicalReportHandler
			.getInstance();
	/**
	 * 服务类
	 */
	private MedicalReportService medicalReportService = MedicalReportService
			.getInstance();
	
	/**
	 * 体检报告列表
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "main")
	public ModelAndView center(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("medicalReport/MedicalReportList");
		return mav;
	}
	
	/**
	 * 体检报告详情
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "medicalReportDetail")
	public ModelAndView deatil(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("medicalReport/medicalReportDetail");
		String id = request.getParameter("id");
		mav.addObject("id", id);
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
			boolean falg = medicalReportService.del(ids);
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
			String rep = medicalReportHandler.doHandler(1, action, reqmsg,
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
			String rep = medicalReportHandler.doHandler(1, action, reqmsg,
					request, response);
			OutputStream os = response.getOutputStream();
			os.write(rep.toString().getBytes("UTF-8"));
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}

}
