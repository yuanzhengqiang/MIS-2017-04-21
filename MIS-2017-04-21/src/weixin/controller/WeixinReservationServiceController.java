package weixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sbtj.init.SystemInit;
import weixin.tools.SignUtil;

@RequestMapping("/weixinReservationService")
@Controller
public class WeixinReservationServiceController {

	/**
	 * 地区与医院选择页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "chooseAreaAndHospital")
	public ModelAndView chooseAreaAndHospital(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("weixin/weixinReservationService/chooseAreaAndHospital");
		// true则代表正式环境，可以开启获取token线程，获取微信服务器数据
		if ("formal".equals(SystemInit.weixinmsgpush)) {
			SignUtil.getAccess_tokenByThread();
		}
		String openId = "";
		if (request.getSession().getAttribute("openId") != null && !"".equals(request.getSession().getAttribute("openId"))) {//内部跳转
			openId = (String)request.getSession().getAttribute("openId");
		} else {
			openId = SignUtil.getopenid(request.getParameter("code"));
			request.getSession().setAttribute("openId", openId);
		}
		return mav;
	}

	/**
	 * 体检项目选择页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "choosePhysicalExaminationItems")
	public ModelAndView choosePhysicalExaminationItems(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("weixin/weixinReservationService/choosePhysicalExaminationItems");
		String hospitalId = request.getParameter("hospitalId");
		mav.addObject("hospitalId", hospitalId);
		return mav;
	}
	
	/**
	 * 订单确认页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "confirmOrder")
	public ModelAndView confirmOrder(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("weixin/weixinReservationService/confirmOrder");
		String hospitalId = request.getParameter("hospitalId");
		String itemList = request.getParameter("itemList");
		String openId = "";
		if (request.getSession().getAttribute("openId") != null && !"".equals(request.getSession().getAttribute("openId"))) {//内部跳转
			openId = (String)request.getSession().getAttribute("openId");
		}
		mav.addObject("hospitalId", hospitalId);
		mav.addObject("itemList", itemList);
		mav.addObject("openId", openId);
		return mav;
	}
	
	/**
	 * 下单成功页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "confirmSuccess")
	public ModelAndView confirmSuccess(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("weixin/weixinReservationService/confirmSuccess");
		String orderId = request.getParameter("orderId");
		mav.addObject("orderId", orderId);
		return mav;
	}
	
	/**
	 * 下单失败页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "confirmFailure")
	public ModelAndView confirmFailure(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("weixin/weixinReservationService/confirmFailure");
		return mav;
	}
}
