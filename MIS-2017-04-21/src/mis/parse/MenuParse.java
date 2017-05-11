package mis.parse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.system.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;

import com.framework.system.db.manager.DBManager;

import mis.entity.MenuEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;






import com.framework.system.util.JsonUtil;
import com.framework.system.db.query.OrderVO;
 /**   
 * @Title: Parse
 * @Description: 微信菜单表解析器
 * @author feng.gu
 * @date 2017-05-03 21:03:26
 * @version V1.0   
 *
 */
public class MenuParse {
	private static Logger logger = Logger.getLogger(MenuParse.class);
	private static MenuParse menuParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static MenuParse getInstance() {
		if (menuParse == null) {
			menuParse = new MenuParse();
		}
		return menuParse;
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
			MenuEntity menuReturn = null;
			List<MenuEntity> menuListReturn = null;
			Integer idReturn = null;			
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;
			
						
			//json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject)reqParams.get("content");
			if ("ADD_MENU_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				menuReturn = new MenuEntity();
				if(true){
					if(contentreq!=null){
												    						    Integer id = (Integer)contentreq.get("id");
	                		if(id!=null){
	                		    	                		    menuReturn  = (MenuEntity)dbManager.getById(id, MenuEntity.class);	                		    
	                		    			                	menuReturn.setId(id);
			                }
						    												    						    String name = (String)contentreq.get("name");
	                		if(name!=null){
	                		    			                	menuReturn.setName(name);
			                }
						    												    						    Integer orderColumn = (Integer)contentreq.get("orderColumn");
	                		if(orderColumn!=null){
	                		    			                	menuReturn.setOrderColumn(orderColumn);
			                }
						    												    						    Integer parentId = (Integer)contentreq.get("parentId");
	                		if(parentId!=null){
	                		    			                	menuReturn.setParentId(parentId);
			                }
						    												    						    String address = (String)contentreq.get("address");
	                		if(address!=null){
	                		    			                	menuReturn.setAddress(address);
			                }
						    												    						    String createTime = (String)contentreq.get("createTime");
	                		if(createTime!=null){
	                		    			                	menuReturn.setCreateTime(createTime);
			                }
						    												    						    Integer addressType = (Integer)contentreq.get("addressType");
	                		if(addressType!=null){
	                		    			                	menuReturn.setAddressType(addressType);
			                }
						    											}					
				}
							} else if ("QUERY_MENU_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if(true){
					if(contentreq!=null){
						idReturn = (Integer)contentreq.get("id");
					        					}	
				}
			} else if ("QUERY_MENU_LIST_REQUEST".equals(command)) {
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
																																String name_like = (String)contentreq.get("name_like");
							String name_isNull = (String)contentreq.get("name_isNull");
							String name_isNotNull = (String)contentreq.get("name_isNotNull");
							String name_in = (String)contentreq.get("name_in");
							String name = (String)contentreq.get("name");
							if(name_like!=null){
	                        	queryMapReturn.put("name_like", name_like);
							}
							if(name_isNull!=null){
	                        	queryMapReturn.put("name_isNull", name_isNull);
							}
							if(name_isNotNull!=null){
	                        	queryMapReturn.put("name_isNotNull", name_isNotNull);
							}
							if(name_in!=null){
	                        	queryMapReturn.put("name_in", name_in);
							}
							if(name!=null){
	                        	queryMapReturn.put("name", name);
							}						           
																															Integer orderColumn_gt = (Integer)contentreq.get("orderColumn_gt");
						Integer orderColumn_ge = (Integer)contentreq.get("orderColumn_ge");
						Integer orderColumn_lt = (Integer)contentreq.get("orderColumn_lt");
						Integer orderColumn_le = (Integer)contentreq.get("orderColumn_le");
						String orderColumn_in = (String)contentreq.get("orderColumn_in");
						Integer orderColumn = (Integer)contentreq.get("orderColumn");
                        if(orderColumn_gt!=null){
                        	queryMapReturn.put("orderColumn_gt", orderColumn_gt);
						}
						if(orderColumn_ge!=null){
                        	queryMapReturn.put("orderColumn_ge", orderColumn_ge);
						}
						if(orderColumn_lt!=null){
                        	queryMapReturn.put("orderColumn_lt", orderColumn_lt);
						}
						if(orderColumn_le!=null){
                        	queryMapReturn.put("orderColumn_le", orderColumn_le);
						}
						if(orderColumn_in!=null){
                        	queryMapReturn.put("orderColumn_in", orderColumn_in);
						}
						if(orderColumn!=null){
                        	queryMapReturn.put("orderColumn", orderColumn);
						}		
																								Integer parentId_gt = (Integer)contentreq.get("parentId_gt");
						Integer parentId_ge = (Integer)contentreq.get("parentId_ge");
						Integer parentId_lt = (Integer)contentreq.get("parentId_lt");
						Integer parentId_le = (Integer)contentreq.get("parentId_le");
						String parentId_in = (String)contentreq.get("parentId_in");
						Integer parentId = (Integer)contentreq.get("parentId");
                        if(parentId_gt!=null){
                        	queryMapReturn.put("parentId_gt", parentId_gt);
						}
						if(parentId_ge!=null){
                        	queryMapReturn.put("parentId_ge", parentId_ge);
						}
						if(parentId_lt!=null){
                        	queryMapReturn.put("parentId_lt", parentId_lt);
						}
						if(parentId_le!=null){
                        	queryMapReturn.put("parentId_le", parentId_le);
						}
						if(parentId_in!=null){
                        	queryMapReturn.put("parentId_in", parentId_in);
						}
						if(parentId!=null){
                        	queryMapReturn.put("parentId", parentId);
						}		
																																String address_like = (String)contentreq.get("address_like");
							String address_isNull = (String)contentreq.get("address_isNull");
							String address_isNotNull = (String)contentreq.get("address_isNotNull");
							String address_in = (String)contentreq.get("address_in");
							String address = (String)contentreq.get("address");
							if(address_like!=null){
	                        	queryMapReturn.put("address_like", address_like);
							}
							if(address_isNull!=null){
	                        	queryMapReturn.put("address_isNull", address_isNull);
							}
							if(address_isNotNull!=null){
	                        	queryMapReturn.put("address_isNotNull", address_isNotNull);
							}
							if(address_in!=null){
	                        	queryMapReturn.put("address_in", address_in);
							}
							if(address!=null){
	                        	queryMapReturn.put("address", address);
							}						           
																																							String createTime_gt = (String)contentreq.get("createTime_gt");
							String createTime_ge = (String)contentreq.get("createTime_ge");
							String createTime_lt = (String)contentreq.get("createTime_lt");
							String createTime_le = (String)contentreq.get("createTime_le");
	                        if(createTime_gt!=null){
	                        	queryMapReturn.put("createTime_gt", createTime_gt);
							}
							if(createTime_ge!=null){
	                        	queryMapReturn.put("createTime_ge", createTime_ge);
							}
							if(createTime_lt!=null){
	                        	queryMapReturn.put("createTime_lt", createTime_lt);
							}
							if(createTime_le!=null){
	                        	queryMapReturn.put("createTime_le", createTime_le);
							} 
																															Integer addressType_gt = (Integer)contentreq.get("addressType_gt");
						Integer addressType_ge = (Integer)contentreq.get("addressType_ge");
						Integer addressType_lt = (Integer)contentreq.get("addressType_lt");
						Integer addressType_le = (Integer)contentreq.get("addressType_le");
						String addressType_in = (String)contentreq.get("addressType_in");
						Integer addressType = (Integer)contentreq.get("addressType");
                        if(addressType_gt!=null){
                        	queryMapReturn.put("addressType_gt", addressType_gt);
						}
						if(addressType_ge!=null){
                        	queryMapReturn.put("addressType_ge", addressType_ge);
						}
						if(addressType_lt!=null){
                        	queryMapReturn.put("addressType_lt", addressType_lt);
						}
						if(addressType_le!=null){
                        	queryMapReturn.put("addressType_le", addressType_le);
						}
						if(addressType_in!=null){
                        	queryMapReturn.put("addressType_in", addressType_in);
						}
						if(addressType!=null){
                        	queryMapReturn.put("addressType", addressType);
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
			} else if ("DEL_MENU_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if(true){
					if(contentreq!=null){
						idReturn = (Integer)contentreq.get("id");	
						    					}	
				}
			} else if ("DEL_MENU_LIST_REQUEST".equals(command)) {
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
																																String name_like = (String)contentreq.get("name_like");
							String name_isNull = (String)contentreq.get("name_isNull");
							String name_isNotNull = (String)contentreq.get("name_isNotNull");
							String name_in = (String)contentreq.get("name_in");
							String name = (String)contentreq.get("name");
							if(name_like!=null){
	                        	queryMapReturn.put("name_like", name_like);
							}
							if(name_isNull!=null){
	                        	queryMapReturn.put("name_isNull", name_isNull);
							}
							if(name_isNotNull!=null){
	                        	queryMapReturn.put("name_isNotNull", name_isNotNull);
							}
							if(name_in!=null){
	                        	queryMapReturn.put("name_in", name_in);
							}
							if(name!=null){
	                        	queryMapReturn.put("name", name);
							}						           
																															Integer orderColumn_gt = (Integer)contentreq.get("orderColumn_gt");
						Integer orderColumn_ge = (Integer)contentreq.get("orderColumn_ge");
						Integer orderColumn_lt = (Integer)contentreq.get("orderColumn_lt");
						Integer orderColumn_le = (Integer)contentreq.get("orderColumn_le");
						String orderColumn_in = (String)contentreq.get("orderColumn_in");
						Integer orderColumn = (Integer)contentreq.get("orderColumn");
                        if(orderColumn_gt!=null){
                        	queryMapReturn.put("orderColumn_gt", orderColumn_gt);
						}
						if(orderColumn_ge!=null){
                        	queryMapReturn.put("orderColumn_ge", orderColumn_ge);
						}
						if(orderColumn_lt!=null){
                        	queryMapReturn.put("orderColumn_lt", orderColumn_lt);
						}
						if(orderColumn_le!=null){
                        	queryMapReturn.put("orderColumn_le", orderColumn_le);
						}
						if(orderColumn_in!=null){
                        	queryMapReturn.put("orderColumn_in", orderColumn_in);
						}
						if(orderColumn!=null){
                        	queryMapReturn.put("orderColumn", orderColumn);
						}		
																								Integer parentId_gt = (Integer)contentreq.get("parentId_gt");
						Integer parentId_ge = (Integer)contentreq.get("parentId_ge");
						Integer parentId_lt = (Integer)contentreq.get("parentId_lt");
						Integer parentId_le = (Integer)contentreq.get("parentId_le");
						String parentId_in = (String)contentreq.get("parentId_in");
						Integer parentId = (Integer)contentreq.get("parentId");
                        if(parentId_gt!=null){
                        	queryMapReturn.put("parentId_gt", parentId_gt);
						}
						if(parentId_ge!=null){
                        	queryMapReturn.put("parentId_ge", parentId_ge);
						}
						if(parentId_lt!=null){
                        	queryMapReturn.put("parentId_lt", parentId_lt);
						}
						if(parentId_le!=null){
                        	queryMapReturn.put("parentId_le", parentId_le);
						}
						if(parentId_in!=null){
                        	queryMapReturn.put("parentId_in", parentId_in);
						}
						if(parentId!=null){
                        	queryMapReturn.put("parentId", parentId);
						}		
																																String address_like = (String)contentreq.get("address_like");
							String address_isNull = (String)contentreq.get("address_isNull");
							String address_isNotNull = (String)contentreq.get("address_isNotNull");
							String address_in = (String)contentreq.get("address_in");
							String address = (String)contentreq.get("address");
							if(address_like!=null){
	                        	queryMapReturn.put("address_like", address_like);
							}
							if(address_isNull!=null){
	                        	queryMapReturn.put("address_isNull", address_isNull);
							}
							if(address_isNotNull!=null){
	                        	queryMapReturn.put("address_isNotNull", address_isNotNull);
							}
							if(address_in!=null){
	                        	queryMapReturn.put("address_in", address_in);
							}
							if(address!=null){
	                        	queryMapReturn.put("address", address);
							}						           
																																							String createTime_gt = (String)contentreq.get("createTime_gt");
							String createTime_ge = (String)contentreq.get("createTime_ge");
							String createTime_lt = (String)contentreq.get("createTime_lt");
							String createTime_le = (String)contentreq.get("createTime_le");
	                        if(createTime_gt!=null){
	                        	queryMapReturn.put("createTime_gt", createTime_gt);
							}
							if(createTime_ge!=null){
	                        	queryMapReturn.put("createTime_ge", createTime_ge);
							}
							if(createTime_lt!=null){
	                        	queryMapReturn.put("createTime_lt", createTime_lt);
							}
							if(createTime_le!=null){
	                        	queryMapReturn.put("createTime_le", createTime_le);
							} 
																															Integer addressType_gt = (Integer)contentreq.get("addressType_gt");
						Integer addressType_ge = (Integer)contentreq.get("addressType_ge");
						Integer addressType_lt = (Integer)contentreq.get("addressType_lt");
						Integer addressType_le = (Integer)contentreq.get("addressType_le");
						String addressType_in = (String)contentreq.get("addressType_in");
						Integer addressType = (Integer)contentreq.get("addressType");
                        if(addressType_gt!=null){
                        	queryMapReturn.put("addressType_gt", addressType_gt);
						}
						if(addressType_ge!=null){
                        	queryMapReturn.put("addressType_ge", addressType_ge);
						}
						if(addressType_lt!=null){
                        	queryMapReturn.put("addressType_lt", addressType_lt);
						}
						if(addressType_le!=null){
                        	queryMapReturn.put("addressType_le", addressType_le);
						}
						if(addressType_in!=null){
                        	queryMapReturn.put("addressType_in", addressType_in);
						}
						if(addressType!=null){
                        	queryMapReturn.put("addressType", addressType);
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
			if (menuReturn != null) {
				parseMap.put("menu", menuReturn);
			}
			if (menuListReturn != null && menuListReturn.size() > 0) {
				parseMap.put("menuList", menuListReturn);
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
