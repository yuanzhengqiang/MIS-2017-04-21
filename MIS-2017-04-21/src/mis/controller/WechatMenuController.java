package mis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/wechatMenu")
@Controller
public class WechatMenuController {
	
	/**
	 * 微信菜单管理
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "wechatMenuManagement")
	public ModelAndView wechatMenuManagement(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("wechatMenu/wechatMenuManagement");
		return mav;
	}
}
