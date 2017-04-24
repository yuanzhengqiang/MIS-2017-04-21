package mis.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.AreaEntity;
import mis.pack.AreaPack;
import mis.parse.AreaParse;
import mis.service.AreaService;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;

/**
 * @Title: Handler
 * @Description: 区域表业务处理器
 * @author feng.gu
 * @date 2017-04-21 16:26:10
 * @version V1.0
 * 
 */
public class AreaHandler extends BaseHandler {
	private static Logger logger = Logger.getLogger(AreaService.class);
	/**
	 * 解析器
	 */
	private AreaParse areaParse = AreaParse.getInstance();
	/**
	 * 业务处理器
	 */
	private AreaService areaService = AreaService.getInstance();
	/**
	 * 封装器
	 */
	private AreaPack areaPack = AreaPack.getInstance();

	private static AreaHandler areaHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static AreaHandler getInstance() {
		if (areaHandler == null) {
			areaHandler = new AreaHandler();
		}
		return areaHandler;
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
			Map<String, Object> parseMap = areaParse.parse(type, command,
					reqStr, request);
			String action = (String) parseMap.get("action");
			AreaEntity area = (AreaEntity) parseMap.get("area");
			List<AreaEntity> areaList = (List<AreaEntity>) parseMap
					.get("areaList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderList = (List<OrderVO>) parseMap.get("orderList");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				/** 获取时间 */
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String time = sdf.format(date);
				area.setUpdateTime(time);
				result = areaService.save(area);
			} else if ("saveList".equals(action)) {
				result = areaService.saveList(areaList);
			} else if ("getById".equals(action)) {
				result = areaService.getById(id);
			} else if ("getListByCondition".equals(action)) {
				 result = areaService.getListByCondition(queryMap, orderList,
				 pageno, pagesize);
			} else if ("del".equals(action)) {
				result = areaService.del(id);
			} else if ("delList".equals(action)) {
				result = areaService.delList(queryMap);
			}
			// 封装
			Map<String, Object> packMap = areaPack.pack(type, action, result,
					area);
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
