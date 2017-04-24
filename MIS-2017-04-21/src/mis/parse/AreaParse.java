package mis.parse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.framework.system.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import com.framework.system.db.manager.DBManager;

import mis.entity.AreaEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;




import com.framework.system.util.JsonUtil;
import com.framework.system.db.query.OrderVO;
 /**   
 * @Title: Parse
 * @Description: 区域表解析器
 * @author feng.gu
 * @date 2017-04-21 16:26:10
 * @version V1.0   
 *
 */
public class AreaParse {
	private static Logger logger = Logger.getLogger(AreaParse.class);
	private static AreaParse areaParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static AreaParse getInstance() {
		if (areaParse == null) {
			areaParse = new AreaParse();
		}
		return areaParse;
	}

	public Map<String, Object> parse(int type, String command,String reqStr,
			HttpServletRequest request) {
		// 定义返回参数
		Map<String, Object> parseMap = new HashMap<String, Object>();
		if (type == 1) {
			// json
			parseMap = this.parseByJson(command,reqStr, request);
		} else if (type == 2) {
			// xml
			parseMap = this.parseByXml(command,reqStr, request);
		}
		return parseMap;
	}

	private Map<String, Object> parseByJson(String command,String reqStr,
			HttpServletRequest request) {
		// 定义返回参数
		Map<String, Object> parseMap = new HashMap<String, Object>();
		try {
			String actionReturn = null;
			AreaEntity areaReturn = null;
			List<AreaEntity> areaListReturn = null;
			Integer idReturn = null;			
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;
			
						
			//json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject)reqParams.get("content");
			if ("ADD_AREA_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				areaReturn = new AreaEntity();
				if(true){
					if(contentreq!=null){
												    						    Integer id = (Integer)contentreq.get("id");
	                		if(id!=null){
	                		    	                		    areaReturn  = (AreaEntity)dbManager.getById(id, AreaEntity.class);	                		    
	                		    			                	areaReturn.setId(id);
			                }
						    												    						    String area = (String)contentreq.get("area");
	                		if(area!=null){
	                		    			                	areaReturn.setArea(area);
			                }
						    												    						    String updateTime = (String)contentreq.get("updateTime");
	                		if(updateTime!=null){
	                		    			                	areaReturn.setUpdateTime(updateTime);
			                }
						    											}					
				}
							} else if ("QUERY_AREA_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if(true){
					if(contentreq!=null){
						idReturn = (Integer)contentreq.get("id");
					        					}	
				}
			} else if ("QUERY_AREA_LIST_REQUEST".equals(command)) {
				actionReturn = "getListByCondition";
				if(true){
					if(contentreq!=null){
						queryMapReturn = new HashMap<String, Object>();
																		Integer id_gt = (Integer)contentreq.get("id_gt");
						Integer id_ge = (Integer)contentreq.get("id_ge");
						Integer id_lt = (Integer)contentreq.get("id_lt");
						Integer id_le = (Integer)contentreq.get("id_le");
						String id_in = (String)contentreq.get("id_in");
						Integer id = (Integer)contentreq.get("id");
                        if(id_gt!=null){
                        	queryMapReturn.put("id_gt", id_gt);
						}
						if(id_ge!=null){
                        	queryMapReturn.put("id_ge", id_ge);
						}
						if(id_lt!=null){
                        	queryMapReturn.put("id_lt", id_lt);
						}
						if(id_le!=null){
                        	queryMapReturn.put("id_le", id_le);
						}
						if(id_in!=null){
                        	queryMapReturn.put("id_in", id_in);
						}
						if(id!=null){
                        	queryMapReturn.put("id", id);
						}		
																																String area_like = (String)contentreq.get("area_like");
							String area_isNull = (String)contentreq.get("area_isNull");
							String area_isNotNull = (String)contentreq.get("area_isNotNull");
							String area_in = (String)contentreq.get("area_in");
							String area = (String)contentreq.get("area");
							if(area_like!=null){
	                        	queryMapReturn.put("area_like", area_like);
							}
							if(area_isNull!=null){
	                        	queryMapReturn.put("area_isNull", area_isNull);
							}
							if(area_isNotNull!=null){
	                        	queryMapReturn.put("area_isNotNull", area_isNotNull);
							}
							if(area_in!=null){
	                        	queryMapReturn.put("area_in", area_in);
							}
							if(area!=null){
	                        	queryMapReturn.put("area", area);
							}						           
																																							String updateTime_gt = (String)contentreq.get("updateTime_gt");
							String updateTime_ge = (String)contentreq.get("updateTime_ge");
							String updateTime_lt = (String)contentreq.get("updateTime_lt");
							String updateTime_le = (String)contentreq.get("updateTime_le");
	                        if(updateTime_gt!=null){
	                        	queryMapReturn.put("updateTime_gt", updateTime_gt);
							}
							if(updateTime_ge!=null){
	                        	queryMapReturn.put("updateTime_ge", updateTime_ge);
							}
							if(updateTime_lt!=null){
	                        	queryMapReturn.put("updateTime_lt", updateTime_lt);
							}
							if(updateTime_le!=null){
	                        	queryMapReturn.put("updateTime_le", updateTime_le);
							} 
																						
						    							
												}
					JSONObject pagereq = (JSONObject)reqParams.get("page");
				    if (pagereq != null) {
				    String pagenotemp = (String)pagereq.get("pageno");
				    String pagesizetemp = (String)pagereq.get("pagesize");
				    if ((pagenotemp != null) && (!"".equals(pagenotemp.trim()))) {
				          pagenoReturn = Integer.valueOf(pagenotemp).intValue();
				    }
				    if ((pagesizetemp != null) && (!"".equals(pagesizetemp.trim()))) {
				          pagesizeReturn = Integer.valueOf(pagesizetemp).intValue();
				        }
				    }
				    Object orderreq = (Object) reqParams.get("order");
					if (orderreq != null) {
						JSONArray order = (JSONArray)orderreq;
						orderListReturn = new ArrayList<OrderVO>();
						for(int i=0;i<order.size();i++){
							JSONObject obj = order.getJSONObject(i);
							OrderVO orderVO = new OrderVO();
							orderVO.setName((String)obj.get("column"));
							orderVO.setOrderType((String)obj.get("type"));
							orderListReturn.add(orderVO);
						}						
					}
				}
			} else if ("DEL_AREA_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if(true){
					if(contentreq!=null){
						idReturn = (Integer)contentreq.get("id");	
						    					}	
				}
			} else if ("DEL_AREA_LIST_REQUEST".equals(command)) {
				actionReturn = "delList";
				if(true){
					if(contentreq!=null){
						queryMapReturn = new HashMap<String, Object>();
																		Integer id_gt = (Integer)contentreq.get("id_gt");
						Integer id_ge = (Integer)contentreq.get("id_ge");
						Integer id_lt = (Integer)contentreq.get("id_lt");
						Integer id_le = (Integer)contentreq.get("id_le");
						String id_in = (String)contentreq.get("id_in");
						Integer id = (Integer)contentreq.get("id");
                        if(id_gt!=null){
                        	queryMapReturn.put("id_gt", id_gt);
						}
						if(id_ge!=null){
                        	queryMapReturn.put("id_ge", id_ge);
						}
						if(id_lt!=null){
                        	queryMapReturn.put("id_lt", id_lt);
						}
						if(id_le!=null){
                        	queryMapReturn.put("id_le", id_le);
						}
						if(id_in!=null){
                        	queryMapReturn.put("id_in", id_in);
						}
						if(id!=null){
                        	queryMapReturn.put("id", id);
						}		
																																String area_like = (String)contentreq.get("area_like");
							String area_isNull = (String)contentreq.get("area_isNull");
							String area_isNotNull = (String)contentreq.get("area_isNotNull");
							String area_in = (String)contentreq.get("area_in");
							String area = (String)contentreq.get("area");
							if(area_like!=null){
	                        	queryMapReturn.put("area_like", area_like);
							}
							if(area_isNull!=null){
	                        	queryMapReturn.put("area_isNull", area_isNull);
							}
							if(area_isNotNull!=null){
	                        	queryMapReturn.put("area_isNotNull", area_isNotNull);
							}
							if(area_in!=null){
	                        	queryMapReturn.put("area_in", area_in);
							}
							if(area!=null){
	                        	queryMapReturn.put("area", area);
							}						           
																																							String updateTime_gt = (String)contentreq.get("updateTime_gt");
							String updateTime_ge = (String)contentreq.get("updateTime_ge");
							String updateTime_lt = (String)contentreq.get("updateTime_lt");
							String updateTime_le = (String)contentreq.get("updateTime_le");
	                        if(updateTime_gt!=null){
	                        	queryMapReturn.put("updateTime_gt", updateTime_gt);
							}
							if(updateTime_ge!=null){
	                        	queryMapReturn.put("updateTime_ge", updateTime_ge);
							}
							if(updateTime_lt!=null){
	                        	queryMapReturn.put("updateTime_lt", updateTime_lt);
							}
							if(updateTime_le!=null){
	                        	queryMapReturn.put("updateTime_le", updateTime_le);
							} 
																									
											}
					JSONObject pagereq = (JSONObject)reqParams.get("page");
				    if (pagereq != null) {
				    String pagenotemp = (String)pagereq.get("pageno");
				    String pagesizetemp = (String)pagereq.get("pagesize");
				    if ((pagenotemp != null) && (!"".equals(pagenotemp.trim()))) {
				          pagenoReturn = Integer.valueOf(pagenotemp).intValue();
				    }
				    if ((pagesizetemp != null) && (!"".equals(pagesizetemp.trim()))) {
				          pagesizeReturn = Integer.valueOf(pagesizetemp).intValue();
				        }
				    }
				}
			}

			if (actionReturn != null && !"".equals(actionReturn)) {
				parseMap.put("action", actionReturn);
			}
			if (areaReturn != null) {
				parseMap.put("area", areaReturn);
			}
			if (areaListReturn != null && areaListReturn.size() > 0) {
				parseMap.put("areaList", areaListReturn);
			}
			if (idReturn != null) {
				parseMap.put("id", idReturn);
			}	
			if (orderListReturn != null && orderListReturn.size() > 0) {
				parseMap.put("orderList", orderListReturn);
			}		
			if (queryMapReturn != null) {
				parseMap.put("queryMap", queryMapReturn);
			}
			if (pagenoReturn > 0) {
				parseMap.put("pageno", pagenoReturn);
			}
			if (pagesizeReturn > 0) {
				parseMap.put("pagesize", pagesizeReturn);
			}
			
			
						
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		return parseMap;
	}

	private Map<String, Object> parseByXml(String command,String reqStr,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
