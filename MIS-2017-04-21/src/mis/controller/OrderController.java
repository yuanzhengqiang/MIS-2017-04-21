package mis.controller;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.OrderEntity;
import mis.handler.OrderHandler;
import mis.service.OrderService;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.servlet.pushMessage;

import com.framework.system.common.entity.json.AjaxJson;
import com.framework.system.util.JsonUtil;


@RequestMapping("/order")
@Controller	
public class OrderController {
	private static Logger logger = Logger.getLogger(OrderController.class);	
	/**
	 * 处理器
	 */
	private OrderHandler orderHandler = OrderHandler.getInstance();
	/**
	 * 服务类
	 */
	private OrderService orderService = OrderService.getInstance();
	
	/**
	 * 体检订单管理
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "main")
	public ModelAndView center(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("orderManagement/orderList");
		return mav;
	}
	
	/**
	 * 体检订单新增
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "mainAdd")
	public ModelAndView mainAdd(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("orderManagement/orderAdd");
		return mav;
	}
	
	/**
	 * 体检订单详情
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "mainDetail")
	public ModelAndView mainDetail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("orderManagement/orderDetail");
		String id = "";
		if (request.getParameter("id") != null && !"".equals(request.getParameter("id"))) {
			id = request.getParameter("id");
		}
		mav.addObject("id", id);
		return mav;
	}
	
	/**
	 * 批量删除 ids英文逗号间隔
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();		
		String result="failure";
		String des="删除失败";
		String ids = request.getParameter("ids");
		if(ids!=null&&!"".equals(ids)){
			boolean falg = orderService.del(ids);	
			if(falg){
				result="success";
				des="删除成功";
			}
		}
		j.setResult(result);
        j.setDes(des);
		return j;
	}
	
	/**
	 * 消息体格式请求处理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "handler")
	@ResponseBody
	public String query(HttpServletRequest request,HttpServletResponse response) {
		String msg="";
		try {
			String reqmsg = request.getParameter("reqmsg");
		    Map reqParams = JsonUtil.getMap4Json(reqmsg);
		    if (reqParams == null) {
		      return msg;
		    }
		    String action = (String)reqParams.get("action");
		    String rep = orderHandler.doHandler(1, action, reqmsg, request, response);
		    msg = new String(rep.getBytes("utf-8"), "iso-8859-1");
		} catch (Exception e) {
			logger.error(e.toString());
		}	

		return msg;
	}
	
	/**
	 * 消息体格式请求处理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "handlercontent")
	public void queryApp(HttpServletRequest request,HttpServletResponse response) {
		try {			
			InputStream is = request.getInputStream();
  	        byte[] bis = IOUtils.toByteArray(is);
  	        String reqmsg = new String(bis, "UTF-8"); 	     
		    Map reqParams = JsonUtil.getMap4Json(reqmsg);
		    if (reqParams == null) {
		      return;
		    }
		    String action = (String)reqParams.get("action");
		    String rep = orderHandler.doHandler(1, action, reqmsg, request, response);
		    OutputStream os = response.getOutputStream();
		    os.write(rep.toString().getBytes("UTF-8"));
		} catch (Exception e) {
			logger.error(e.toString());
		}	
	}

	/**
	 * 体检时间通知
	 * @param orderId	订单 id
	 * @return
	 */
	@RequestMapping(params = "timenotice")
	@ResponseBody
	public String examinationTimeNotice(String orderId){
		JSONObject jobj = new JSONObject();
		if (orderId != null && !orderId.equals("")) {
			try {
				int orderid = Integer.parseInt(orderId);
				OrderEntity _temp_ = OrderService.getInstance().getById(orderid);
				String time = _temp_.getMedicalCompleteTime();
				if (time == null || time.length() < 8) {
					jobj.put("result", 200);
					jobj.put("des", "体检时间未填写");
				} else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
					Date date = sdf1.parse(time);
					time = sdf2.format(date);
					String year = time.substring(0, 4);
					String month = time.substring(4, 6);
					String day = time.substring(6, 8);
					time = year + "年" + month + "月" + day + "日";
					if (_temp_.getServicePersonName() != null && _temp_.getServicePersonName().trim().length() > 0) {
						if (_temp_.getMedicalHospital() != null && _temp_.getMedicalHospital().trim().length() > 0) {
							pushMessage.examinationTimeNotice(_temp_.getOrderCustomer(), _temp_.getServicePersonName(), _temp_.getMedicalHospital(), time);
							jobj.put("result", 100);
							jobj.put("des", "已发送");
						} else {
							jobj.put("result", 200);
							jobj.put("des", "体检医院未填写");
						}
					} else {
						jobj.put("result", 200);
						jobj.put("des", "服务人员未填写");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		} else {
			jobj.put("result", 200);
			jobj.put("des", "订单 ID 为空");
		}
		String str = jobj.toString();
		try {
			str = new String(str.getBytes("utf-8"), "ISO-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return str;
	}
	
	/**
	 * 体检报告寄出通知
	 * @param orderId
	 * @return
	 */
	@RequestMapping(params = "medicalreportsentnotice")
	@ResponseBody
	public String medicalReportSentNotice(String orderId){
		JSONObject jobj = new JSONObject();
		if (orderId != null && !orderId.equals("")) {
			try {
				int orderid = Integer.parseInt(orderId);
				OrderEntity _temp_ = OrderService.getInstance().getById(orderid);
				if (_temp_.getServicePersonName() != null && _temp_.getServicePersonName().trim().length() > 0) {
					if (_temp_.getMedicalReportExpress() != null && _temp_.getMedicalReportExpress().trim().length() > 0) {
						if (_temp_.getMedicalReportExpressOrderNum() != null && _temp_.getMedicalReportExpressOrderNum().trim().length() > 0) {
							pushMessage.medicalReportSentNotice(_temp_.getOrderCustomer(), _temp_.getServicePersonName(), _temp_.getMedicalReportExpress(), _temp_.getMedicalReportExpressOrderNum());
							jobj.put("result", 100);
							jobj.put("des", "已发送");
						} else {
							jobj.put("result", 200);
							jobj.put("des", "快递单号未填写");
						}
					} else {
						jobj.put("result", 200);
						jobj.put("des", "快递寄送公司未填写");
					}
				} else {
					jobj.put("result", 200);
					jobj.put("des", "服务人员未填写");
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		} else {
			jobj.put("result", 200);
			jobj.put("des", "订单 ID 为空");
		}
		String str = jobj.toString();
		try {
			str = new String(str.getBytes("utf-8"), "ISO-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return str;
	}

	/**
	 * 体检完成通知
	 * @param orderId 订单id
	 * @return
	 */
	@RequestMapping(params = "physicalexaminationnotice")
	@ResponseBody
	public String physicalExaminationNotice(String orderId){
		JSONObject jobj = new JSONObject();
		if (orderId != null && !orderId.equals("")) {
			try {
				int orderid = Integer.parseInt(orderId);
				OrderEntity _temp_ = OrderService.getInstance().getById(orderid);
				if (_temp_.getServicePersonName() != null && _temp_.getServicePersonName().trim().length() > 0) {
					if (_temp_.getStatus() == 2 || _temp_.getStatus() == 3) {
						pushMessage.physicalExaminationNotice(_temp_.getOrderCustomer(),  _temp_.getServicePersonName());
						jobj.put("result", 100);
						jobj.put("des", "已发送");
					} else if (_temp_.getStatus() == 4) {
						jobj.put("result", 200);
						jobj.put("des", "体检已取消");
					} else if (_temp_.getStatus() == 1) {
						jobj.put("result", 200);
						jobj.put("des", "尚未体检");
					} else {
						jobj.put("result", 200);
						jobj.put("des", "未知错误");
					}
				} else {
					jobj.put("result", 200);
					jobj.put("des", "服务人员未填写");
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		} else {
			jobj.put("result", 200);
			jobj.put("des", "订单 ID 为空");
		}
		String str = jobj.toString();
		try {
			str = new String(str.getBytes("utf-8"), "ISO-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return str;
	}
	
	/**
	 * 体检报告完成通知
	 * @param orderId
	 * @return
	 */
	@RequestMapping(params = "physicalexaminationreport")
	@ResponseBody
	public String physicalExaminationReport(String orderId){
		JSONObject jobj = new JSONObject();
		if (orderId != null && !orderId.equals("")) {
			try {
				int orderid = Integer.parseInt(orderId);
				OrderEntity _temp_ = OrderService.getInstance().getById(orderid);
				String time = _temp_.getReportCreateTime();
				if (time == null || time.length() < 8) {
					jobj.put("result", 200);
					jobj.put("des", "报告时间未填写");
				} else {
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
					Date date = sdf1.parse(time);
					time = sdf2.format(date);
					String year = time.substring(0, 4);
					String month = time.substring(4, 6);
					String day = time.substring(6, 8);
					time = year + "年" + month + "月" + day + "日";
					if (_temp_.getServicePersonName() != null && _temp_.getServicePersonName().trim().length() > 0) {
						if (_temp_.getMedicalHospital() != null && _temp_.getMedicalHospital().trim().length() > 0) {
							pushMessage.physicalExaminationReport(_temp_.getOrderCustomer(), _temp_.getServicePersonName(), _temp_.getOrderNum(), time, _temp_.getMedicalHospital());
							jobj.put("result", 100);
							jobj.put("des", "已发送");
						} else {
							jobj.put("result", 200);
							jobj.put("des", "体检医院未填写");
						}
					} else {
						jobj.put("result", 200);
						jobj.put("des", "服务人员未填写");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		} else {
			jobj.put("result", 200);
			jobj.put("des", "订单 ID 为空");
		}
		String str = jobj.toString();
		try {
			str = new String(str.getBytes("utf-8"), "ISO-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return str;
	}
	
}
