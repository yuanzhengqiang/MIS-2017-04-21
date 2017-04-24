package mis.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.ServicePersonEntity;
import mis.pack.ServicePersonPack;
import mis.parse.ServicePersonParse;
import mis.service.ServicePersonService;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;

/**
 * @Title: Handler
 * @Description: 服务人员表业务处理器
 * @author feng.gu
 * @date 2017-04-21 16:22:00
 * @version V1.0
 * 
 */
public class ServicePersonHandler extends BaseHandler {
	private static Logger logger = Logger.getLogger(ServicePersonService.class);
	/**
	 * 解析器
	 */
	private ServicePersonParse servicePersonParse = ServicePersonParse
			.getInstance();
	/**
	 * 业务处理器
	 */
	private ServicePersonService servicePersonService = ServicePersonService
			.getInstance();
	/**
	 * 封装器
	 */
	private ServicePersonPack servicePersonPack = ServicePersonPack
			.getInstance();

	private static ServicePersonHandler servicePersonHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static ServicePersonHandler getInstance() {
		if (servicePersonHandler == null) {
			servicePersonHandler = new ServicePersonHandler();
		}
		return servicePersonHandler;
	}

	/**
	 * 
	 * @param type
	 *            1-json 2-xml
	 * @param entityName
	 * @param command
	 * @param reqStr
	 * @param request
	 * @param response
	 */
	public String doHandler(int type, String command, String reqStr,
			HttpServletRequest request, HttpServletResponse response) {
		logger.debug("请求消息：" + reqStr);
		String resultStr = "";
		try {
			// 解析
			Map<String, Object> parseMap = servicePersonParse.parse(type,
					command, reqStr, request);
			String action = (String) parseMap.get("action");
			ServicePersonEntity servicePerson = (ServicePersonEntity) parseMap
					.get("servicePerson");
			List<ServicePersonEntity> servicePersonList = (List<ServicePersonEntity>) parseMap
					.get("servicePersonList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				result = servicePersonService.save(servicePerson);
			} else if ("saveList".equals(action)) {
				result = servicePersonService.saveList(servicePersonList);
			} else if ("getById".equals(action)) {
				result = servicePersonService.getById(id);
			} else if ("getListByCondition".equals(action)) {
				result = servicePersonService.getListByCondition(queryMap,
						orderList, pageno, pagesize);
			} else if ("del".equals(action)) {
				result = servicePersonService.del(id);
			} else if ("delList".equals(action)) {
				result = servicePersonService.delList(queryMap);
			}
			// 封装
			Map<String, Object> packMap = servicePersonPack.pack(type, action,
					result, servicePerson);
			String actionBack = (String) packMap.get("action");
			String resultBack = (String) packMap.get("result");
			String desBack = (String) packMap.get("des");
			JSONObject pageBack = (JSONObject) packMap.get("page");
			JSONObject contentBack = (JSONObject) packMap.get("content");

			JSONObject repJson = new JSONObject();
			if (actionBack != null && !"".equals(actionBack)) {
				repJson.put("action", actionBack);
			}
			if (resultBack != null && !"".equals(resultBack)) {
				repJson.put("result", resultBack);
			}
			if (desBack != null && !"".equals(desBack)) {
				repJson.put("des", desBack);
			}
			if (pageBack != null) {
				repJson.put("page", pageBack);
			}
			if (contentBack != null && !"".equals(contentBack)) {
				repJson.put("content", contentBack);
			}
			logger.debug("返回消息：" + repJson.toString());
			resultStr = repJson.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		return resultStr;
	}
}
