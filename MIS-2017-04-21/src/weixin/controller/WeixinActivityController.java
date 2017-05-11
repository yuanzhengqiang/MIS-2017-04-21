package weixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/weixinactivity")
@Controller
public class WeixinActivityController {

	/**
	 * 微信活动详情页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "weixinEventDetails")
	public ModelAndView weixinEventDetails(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("weixin/weixinactivity/weixinEventDetails");
		String invitationCode = request.getParameter("invitationCode");
		mav.addObject("invitationCode",invitationCode);
		return mav;
	}
}
