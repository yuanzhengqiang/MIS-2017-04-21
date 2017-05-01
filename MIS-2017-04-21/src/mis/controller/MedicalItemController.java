package mis.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.HospitalDetectingItemRelationEntity;
import mis.handler.MedicalItemHandler;
import mis.service.HospitalDetectingItemRelationService;
import mis.service.MedicalItemService;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.framework.system.common.entity.json.AjaxJson;
import com.framework.system.util.JsonUtil;

@RequestMapping("/medicalItem")
@Controller
public class MedicalItemController {
	private static Logger logger = Logger
			.getLogger(MedicalItemController.class);
	/**
	 * 处理器
	 */
	private MedicalItemHandler medicalItemHandler = MedicalItemHandler
			.getInstance();
	/**
	 * 服务类
	 */
	private MedicalItemService medicalItemService = MedicalItemService
			.getInstance();

	/**
	 * 体检项目
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "main")
	public ModelAndView center(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("medicalItem/MedicalItemList");
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
		boolean falg = false;
		if (ids != null && !"".equals(ids)) {
			/** 删除体检项目时应判断是否有医院与该项目关联，如果关联不应删除 */
			if (true) {
				Map<String, Object> qmp = new HashMap<String, Object>();
				qmp.put("medicalItem_in", ids);
				List<HospitalDetectingItemRelationEntity> _list_ = HospitalDetectingItemRelationService.getInstance().getListByCondition(qmp);
				if (_list_ != null && _list_.size() > 0) {
					des = "检项目已与医院关联不可删除";
				} else {
					falg = medicalItemService.del(ids);
				}
			}
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
			String rep = medicalItemHandler.doHandler(1, action, reqmsg,
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
			String rep = medicalItemHandler.doHandler(1, action, reqmsg,
					request, response);
			OutputStream os = response.getOutputStream();
			os.write(rep.toString().getBytes("UTF-8"));
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}
	
	
	

}
