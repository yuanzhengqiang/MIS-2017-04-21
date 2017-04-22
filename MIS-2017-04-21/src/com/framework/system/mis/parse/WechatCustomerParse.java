package com.framework.system.mis.parse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.system.mis.entity.WechatCustomerEntity;
import com.framework.system.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import com.framework.system.db.manager.DBManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;




import com.framework.system.util.JsonUtil;
import com.framework.system.db.query.OrderVO;
 /**   
 * @Title: Parse
 * @Description: 微信客户表解析器
 * @author feng.gu
 * @date 2017-04-21 17:29:44
 * @version V1.0   
 *
 */
public class WechatCustomerParse {
	private static Logger logger = Logger.getLogger(WechatCustomerParse.class);
	private static WechatCustomerParse wechatCustomerParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static WechatCustomerParse getInstance() {
		if (wechatCustomerParse == null) {
			wechatCustomerParse = new WechatCustomerParse();
		}
		return wechatCustomerParse;
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
			WechatCustomerEntity wechatCustomerReturn = null;
			List<WechatCustomerEntity> wechatCustomerListReturn = null;
			Integer idReturn = null;			
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;
			
						
			//json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject)reqParams.get("content");
			if ("ADD_WECHAT_CUSTOMER_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				wechatCustomerReturn = new WechatCustomerEntity();
				if(true){
					if(contentreq!=null){
												    						    Integer id = (Integer)contentreq.get("id");
	                		if(id!=null){
	                		    	                		    wechatCustomerReturn  = (WechatCustomerEntity)dbManager.getById(id, WechatCustomerEntity.class);	                		    
	                		    			                	wechatCustomerReturn.setId(id);
			                }
						    												    						    String openId = (String)contentreq.get("openId");
	                		if(openId!=null){
	                		    			                	wechatCustomerReturn.setOpenId(openId);
			                }
						    												    						    String nakeName = (String)contentreq.get("nakeName");
	                		if(nakeName!=null){
	                		    			                	wechatCustomerReturn.setNakeName(nakeName);
			                }
						    												    						    String noteName = (String)contentreq.get("noteName");
	                		if(noteName!=null){
	                		    			                	wechatCustomerReturn.setNoteName(noteName);
			                }
						    												    						    Object gender = (Object)contentreq.get("gender");
	                		if(gender!=null){
	                		    			                	wechatCustomerReturn.setGender(gender);
			                }
						    												    						    String country = (String)contentreq.get("country");
	                		if(country!=null){
	                		    			                	wechatCustomerReturn.setCountry(country);
			                }
						    												    						    String province = (String)contentreq.get("province");
	                		if(province!=null){
	                		    			                	wechatCustomerReturn.setProvince(province);
			                }
						    												    						    String city = (String)contentreq.get("city");
	                		if(city!=null){
	                		    			                	wechatCustomerReturn.setCity(city);
			                }
						    												    						    String updateTime = (String)contentreq.get("updateTime");
	                		if(updateTime!=null){
	                		    			                	wechatCustomerReturn.setUpdateTime(updateTime);
			                }
						    											}					
				}
							} else if ("QUERY_WECHAT_CUSTOMER_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if(true){
					if(contentreq!=null){
						idReturn = (Integer)contentreq.get("id");
					        					}	
				}
			} else if ("QUERY_WECHAT_CUSTOMER_LIST_REQUEST".equals(command)) {
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
																																String openId_like = (String)contentreq.get("openId_like");
							String openId_isNull = (String)contentreq.get("openId_isNull");
							String openId_isNotNull = (String)contentreq.get("openId_isNotNull");
							String openId_in = (String)contentreq.get("openId_in");
							String openId = (String)contentreq.get("openId");
							if(openId_like!=null){
	                        	queryMapReturn.put("openId_like", openId_like);
							}
							if(openId_isNull!=null){
	                        	queryMapReturn.put("openId_isNull", openId_isNull);
							}
							if(openId_isNotNull!=null){
	                        	queryMapReturn.put("openId_isNotNull", openId_isNotNull);
							}
							if(openId_in!=null){
	                        	queryMapReturn.put("openId_in", openId_in);
							}
							if(openId!=null){
	                        	queryMapReturn.put("openId", openId);
							}						           
																																							String nakeName_like = (String)contentreq.get("nakeName_like");
							String nakeName_isNull = (String)contentreq.get("nakeName_isNull");
							String nakeName_isNotNull = (String)contentreq.get("nakeName_isNotNull");
							String nakeName_in = (String)contentreq.get("nakeName_in");
							String nakeName = (String)contentreq.get("nakeName");
							if(nakeName_like!=null){
	                        	queryMapReturn.put("nakeName_like", nakeName_like);
							}
							if(nakeName_isNull!=null){
	                        	queryMapReturn.put("nakeName_isNull", nakeName_isNull);
							}
							if(nakeName_isNotNull!=null){
	                        	queryMapReturn.put("nakeName_isNotNull", nakeName_isNotNull);
							}
							if(nakeName_in!=null){
	                        	queryMapReturn.put("nakeName_in", nakeName_in);
							}
							if(nakeName!=null){
	                        	queryMapReturn.put("nakeName", nakeName);
							}						           
																																							String noteName_like = (String)contentreq.get("noteName_like");
							String noteName_isNull = (String)contentreq.get("noteName_isNull");
							String noteName_isNotNull = (String)contentreq.get("noteName_isNotNull");
							String noteName_in = (String)contentreq.get("noteName_in");
							String noteName = (String)contentreq.get("noteName");
							if(noteName_like!=null){
	                        	queryMapReturn.put("noteName_like", noteName_like);
							}
							if(noteName_isNull!=null){
	                        	queryMapReturn.put("noteName_isNull", noteName_isNull);
							}
							if(noteName_isNotNull!=null){
	                        	queryMapReturn.put("noteName_isNotNull", noteName_isNotNull);
							}
							if(noteName_in!=null){
	                        	queryMapReturn.put("noteName_in", noteName_in);
							}
							if(noteName!=null){
	                        	queryMapReturn.put("noteName", noteName);
							}						           
																																							String gender_like = (String)contentreq.get("gender_like");
							String gender_isNull = (String)contentreq.get("gender_isNull");
							String gender_isNotNull = (String)contentreq.get("gender_isNotNull");
							String gender_in = (String)contentreq.get("gender_in");
							String gender = (String)contentreq.get("gender");
							if(gender_like!=null){
	                        	queryMapReturn.put("gender_like", gender_like);
							}
							if(gender_isNull!=null){
	                        	queryMapReturn.put("gender_isNull", gender_isNull);
							}
							if(gender_isNotNull!=null){
	                        	queryMapReturn.put("gender_isNotNull", gender_isNotNull);
							}
							if(gender_in!=null){
	                        	queryMapReturn.put("gender_in", gender_in);
							}
							if(gender!=null){
	                        	queryMapReturn.put("gender", gender);
							}						           
																																							String country_like = (String)contentreq.get("country_like");
							String country_isNull = (String)contentreq.get("country_isNull");
							String country_isNotNull = (String)contentreq.get("country_isNotNull");
							String country_in = (String)contentreq.get("country_in");
							String country = (String)contentreq.get("country");
							if(country_like!=null){
	                        	queryMapReturn.put("country_like", country_like);
							}
							if(country_isNull!=null){
	                        	queryMapReturn.put("country_isNull", country_isNull);
							}
							if(country_isNotNull!=null){
	                        	queryMapReturn.put("country_isNotNull", country_isNotNull);
							}
							if(country_in!=null){
	                        	queryMapReturn.put("country_in", country_in);
							}
							if(country!=null){
	                        	queryMapReturn.put("country", country);
							}						           
																																							String province_like = (String)contentreq.get("province_like");
							String province_isNull = (String)contentreq.get("province_isNull");
							String province_isNotNull = (String)contentreq.get("province_isNotNull");
							String province_in = (String)contentreq.get("province_in");
							String province = (String)contentreq.get("province");
							if(province_like!=null){
	                        	queryMapReturn.put("province_like", province_like);
							}
							if(province_isNull!=null){
	                        	queryMapReturn.put("province_isNull", province_isNull);
							}
							if(province_isNotNull!=null){
	                        	queryMapReturn.put("province_isNotNull", province_isNotNull);
							}
							if(province_in!=null){
	                        	queryMapReturn.put("province_in", province_in);
							}
							if(province!=null){
	                        	queryMapReturn.put("province", province);
							}						           
																																							String city_like = (String)contentreq.get("city_like");
							String city_isNull = (String)contentreq.get("city_isNull");
							String city_isNotNull = (String)contentreq.get("city_isNotNull");
							String city_in = (String)contentreq.get("city_in");
							String city = (String)contentreq.get("city");
							if(city_like!=null){
	                        	queryMapReturn.put("city_like", city_like);
							}
							if(city_isNull!=null){
	                        	queryMapReturn.put("city_isNull", city_isNull);
							}
							if(city_isNotNull!=null){
	                        	queryMapReturn.put("city_isNotNull", city_isNotNull);
							}
							if(city_in!=null){
	                        	queryMapReturn.put("city_in", city_in);
							}
							if(city!=null){
	                        	queryMapReturn.put("city", city);
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
			} else if ("DEL_WECHAT_CUSTOMER_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if(true){
					if(contentreq!=null){
						idReturn = (Integer)contentreq.get("id");	
						    					}	
				}
			} else if ("DEL_WECHAT_CUSTOMER_LIST_REQUEST".equals(command)) {
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
																																String openId_like = (String)contentreq.get("openId_like");
							String openId_isNull = (String)contentreq.get("openId_isNull");
							String openId_isNotNull = (String)contentreq.get("openId_isNotNull");
							String openId_in = (String)contentreq.get("openId_in");
							String openId = (String)contentreq.get("openId");
							if(openId_like!=null){
	                        	queryMapReturn.put("openId_like", openId_like);
							}
							if(openId_isNull!=null){
	                        	queryMapReturn.put("openId_isNull", openId_isNull);
							}
							if(openId_isNotNull!=null){
	                        	queryMapReturn.put("openId_isNotNull", openId_isNotNull);
							}
							if(openId_in!=null){
	                        	queryMapReturn.put("openId_in", openId_in);
							}
							if(openId!=null){
	                        	queryMapReturn.put("openId", openId);
							}						           
																																							String nakeName_like = (String)contentreq.get("nakeName_like");
							String nakeName_isNull = (String)contentreq.get("nakeName_isNull");
							String nakeName_isNotNull = (String)contentreq.get("nakeName_isNotNull");
							String nakeName_in = (String)contentreq.get("nakeName_in");
							String nakeName = (String)contentreq.get("nakeName");
							if(nakeName_like!=null){
	                        	queryMapReturn.put("nakeName_like", nakeName_like);
							}
							if(nakeName_isNull!=null){
	                        	queryMapReturn.put("nakeName_isNull", nakeName_isNull);
							}
							if(nakeName_isNotNull!=null){
	                        	queryMapReturn.put("nakeName_isNotNull", nakeName_isNotNull);
							}
							if(nakeName_in!=null){
	                        	queryMapReturn.put("nakeName_in", nakeName_in);
							}
							if(nakeName!=null){
	                        	queryMapReturn.put("nakeName", nakeName);
							}						           
																																							String noteName_like = (String)contentreq.get("noteName_like");
							String noteName_isNull = (String)contentreq.get("noteName_isNull");
							String noteName_isNotNull = (String)contentreq.get("noteName_isNotNull");
							String noteName_in = (String)contentreq.get("noteName_in");
							String noteName = (String)contentreq.get("noteName");
							if(noteName_like!=null){
	                        	queryMapReturn.put("noteName_like", noteName_like);
							}
							if(noteName_isNull!=null){
	                        	queryMapReturn.put("noteName_isNull", noteName_isNull);
							}
							if(noteName_isNotNull!=null){
	                        	queryMapReturn.put("noteName_isNotNull", noteName_isNotNull);
							}
							if(noteName_in!=null){
	                        	queryMapReturn.put("noteName_in", noteName_in);
							}
							if(noteName!=null){
	                        	queryMapReturn.put("noteName", noteName);
							}						           
																																							String gender_like = (String)contentreq.get("gender_like");
							String gender_isNull = (String)contentreq.get("gender_isNull");
							String gender_isNotNull = (String)contentreq.get("gender_isNotNull");
							String gender_in = (String)contentreq.get("gender_in");
							String gender = (String)contentreq.get("gender");
							if(gender_like!=null){
	                        	queryMapReturn.put("gender_like", gender_like);
							}
							if(gender_isNull!=null){
	                        	queryMapReturn.put("gender_isNull", gender_isNull);
							}
							if(gender_isNotNull!=null){
	                        	queryMapReturn.put("gender_isNotNull", gender_isNotNull);
							}
							if(gender_in!=null){
	                        	queryMapReturn.put("gender_in", gender_in);
							}
							if(gender!=null){
	                        	queryMapReturn.put("gender", gender);
							}						           
																																							String country_like = (String)contentreq.get("country_like");
							String country_isNull = (String)contentreq.get("country_isNull");
							String country_isNotNull = (String)contentreq.get("country_isNotNull");
							String country_in = (String)contentreq.get("country_in");
							String country = (String)contentreq.get("country");
							if(country_like!=null){
	                        	queryMapReturn.put("country_like", country_like);
							}
							if(country_isNull!=null){
	                        	queryMapReturn.put("country_isNull", country_isNull);
							}
							if(country_isNotNull!=null){
	                        	queryMapReturn.put("country_isNotNull", country_isNotNull);
							}
							if(country_in!=null){
	                        	queryMapReturn.put("country_in", country_in);
							}
							if(country!=null){
	                        	queryMapReturn.put("country", country);
							}						           
																																							String province_like = (String)contentreq.get("province_like");
							String province_isNull = (String)contentreq.get("province_isNull");
							String province_isNotNull = (String)contentreq.get("province_isNotNull");
							String province_in = (String)contentreq.get("province_in");
							String province = (String)contentreq.get("province");
							if(province_like!=null){
	                        	queryMapReturn.put("province_like", province_like);
							}
							if(province_isNull!=null){
	                        	queryMapReturn.put("province_isNull", province_isNull);
							}
							if(province_isNotNull!=null){
	                        	queryMapReturn.put("province_isNotNull", province_isNotNull);
							}
							if(province_in!=null){
	                        	queryMapReturn.put("province_in", province_in);
							}
							if(province!=null){
	                        	queryMapReturn.put("province", province);
							}						           
																																							String city_like = (String)contentreq.get("city_like");
							String city_isNull = (String)contentreq.get("city_isNull");
							String city_isNotNull = (String)contentreq.get("city_isNotNull");
							String city_in = (String)contentreq.get("city_in");
							String city = (String)contentreq.get("city");
							if(city_like!=null){
	                        	queryMapReturn.put("city_like", city_like);
							}
							if(city_isNull!=null){
	                        	queryMapReturn.put("city_isNull", city_isNull);
							}
							if(city_isNotNull!=null){
	                        	queryMapReturn.put("city_isNotNull", city_isNotNull);
							}
							if(city_in!=null){
	                        	queryMapReturn.put("city_in", city_in);
							}
							if(city!=null){
	                        	queryMapReturn.put("city", city);
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
			if (wechatCustomerReturn != null) {
				parseMap.put("wechatCustomer", wechatCustomerReturn);
			}
			if (wechatCustomerListReturn != null && wechatCustomerListReturn.size() > 0) {
				parseMap.put("wechatCustomerList", wechatCustomerListReturn);
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
