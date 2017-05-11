package mis.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.MenuEntity;
import mis.pack.MenuPack;
import mis.parse.MenuParse;
import mis.service.MenuService;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;

 /**   
 * @Title: Handler
 * @Description: 微信菜单表业务处理器
 * @author feng.gu
 * @date 2017-05-03 21:03:26
 * @version V1.0   
 *
 */
public class MenuHandler extends BaseHandler{
	private static Logger logger = Logger.getLogger(MenuService.class);
	/**
	 * 解析器
	 */
	private MenuParse menuParse = MenuParse.getInstance();
	/**
	 * 业务处理器
	 */
	private MenuService menuService = MenuService.getInstance();
	/**
	 * 封装器
	 */
	private MenuPack menuPack = MenuPack.getInstance();

	private static MenuHandler menuHandler;
	

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static MenuHandler getInstance() {
		if (menuHandler == null) {
			menuHandler = new MenuHandler();
		}
		return menuHandler;
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
			Map<String, Object> parseMap = menuParse.parse(type,command,reqStr,request);		
			String action = (String) parseMap.get("action");
			MenuEntity menu = (MenuEntity) parseMap.get("menu");
			List<MenuEntity> menuList = (List<MenuEntity>) parseMap.get("menuList");
			Integer id = (Integer) parseMap.get("id");			
			Map<String, Object> queryMap = (Map<String, Object>) parseMap.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");
			
						
			// 业务处理
			Object result=null;
			if ("save".equals(action)) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String date_str = sdf.format(date);
				menu.setCreateTime(date_str);
				result = menuService.save(menu);
			} else if ("saveList".equals(action)) {
				result = menuService.saveList(menuList);
			} else if ("getById".equals(action)) {
				result = menuService.getById(id);
			} else if ("getListByCondition".equals(action)) {
				result = menuService.getListByCondition(queryMap,orderList, pageno,
						pagesize);
			} else if ("del".equals(action)) {
				result = menuService.del(id);
			} else if ("delList".equals(action)) {
				result = menuService.delList(queryMap);
			}
			// 封装
			Map<String, Object> packMap = menuPack.pack(type,action,result,menu);
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
