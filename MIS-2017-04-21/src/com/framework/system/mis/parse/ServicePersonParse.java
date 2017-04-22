package com.framework.system.mis.parse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.system.mis.entity.ServicePersonEntity;
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
 * @Description: 服务人员表解析器
 * @author feng.gu
 * @date 2017-04-21 16:22:00
 * @version V1.0   
 *
 */
public class ServicePersonParse {
	private static Logger logger = Logger.getLogger(ServicePersonParse.class);
	private static ServicePersonParse servicePersonParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static ServicePersonParse getInstance() {
		if (servicePersonParse == null) {
			servicePersonParse = new ServicePersonParse();
		}
		return servicePersonParse;
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
			ServicePersonEntity servicePersonReturn = null;
			List<ServicePersonEntity> servicePersonListReturn = null;
			Integer idReturn = null;			
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;
			
						
			//json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject)reqParams.get("content");
			if ("ADD_SERVICE_PERSON_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				servicePersonReturn = new ServicePersonEntity();
				if(true){
					if(contentreq!=null){
												    						    Integer id = (Integer)contentreq.get("id");
	                		if(id!=null){
	                		    	                		    servicePersonReturn  = (ServicePersonEntity)dbManager.getById(id, ServicePersonEntity.class);	                		    
	                		    			                	servicePersonReturn.setId(id);
			                }
						    												    						    String name = (String)contentreq.get("name");
	                		if(name!=null){
	                		    			                	servicePersonReturn.setName(name);
			                }
						    												    						    String gender = (String)contentreq.get("gender");
	                		if(gender!=null){
	                		    			                	servicePersonReturn.setGender(gender);
			                }
						    												    						    Object headPortrait = (Object)contentreq.get("headPortrait");
	                		if(headPortrait!=null){
	                		    			                	servicePersonReturn.setHeadPortrait(headPortrait);
			                }
						    												    						    String birthday = (String)contentreq.get("birthday");
	                		if(birthday!=null){
	                		    			                	servicePersonReturn.setBirthday(birthday);
			                }
						    												    						    String academic = (String)contentreq.get("academic");
	                		if(academic!=null){
	                		    			                	servicePersonReturn.setAcademic(academic);
			                }
						    												    						    String contact = (String)contentreq.get("contact");
	                		if(contact!=null){
	                		    			                	servicePersonReturn.setContact(contact);
			                }
						    												    						    String wechatNum = (String)contentreq.get("wechatNum");
	                		if(wechatNum!=null){
	                		    			                	servicePersonReturn.setWechatNum(wechatNum);
			                }
						    												    						    String wechatQrCode = (String)contentreq.get("wechatQrCode");
	                		if(wechatQrCode!=null){
	                		    			                	servicePersonReturn.setWechatQrCode(wechatQrCode);
			                }
						    											}					
				}
							} else if ("QUERY_SERVICE_PERSON_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if(true){
					if(contentreq!=null){
						idReturn = (Integer)contentreq.get("id");
					        					}	
				}
			} else if ("QUERY_SERVICE_PERSON_LIST_REQUEST".equals(command)) {
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
																																							String headPortrait_like = (String)contentreq.get("headPortrait_like");
							String headPortrait_isNull = (String)contentreq.get("headPortrait_isNull");
							String headPortrait_isNotNull = (String)contentreq.get("headPortrait_isNotNull");
							String headPortrait_in = (String)contentreq.get("headPortrait_in");
							String headPortrait = (String)contentreq.get("headPortrait");
							if(headPortrait_like!=null){
	                        	queryMapReturn.put("headPortrait_like", headPortrait_like);
							}
							if(headPortrait_isNull!=null){
	                        	queryMapReturn.put("headPortrait_isNull", headPortrait_isNull);
							}
							if(headPortrait_isNotNull!=null){
	                        	queryMapReturn.put("headPortrait_isNotNull", headPortrait_isNotNull);
							}
							if(headPortrait_in!=null){
	                        	queryMapReturn.put("headPortrait_in", headPortrait_in);
							}
							if(headPortrait!=null){
	                        	queryMapReturn.put("headPortrait", headPortrait);
							}						           
																																							String birthday_like = (String)contentreq.get("birthday_like");
							String birthday_isNull = (String)contentreq.get("birthday_isNull");
							String birthday_isNotNull = (String)contentreq.get("birthday_isNotNull");
							String birthday_in = (String)contentreq.get("birthday_in");
							String birthday = (String)contentreq.get("birthday");
							if(birthday_like!=null){
	                        	queryMapReturn.put("birthday_like", birthday_like);
							}
							if(birthday_isNull!=null){
	                        	queryMapReturn.put("birthday_isNull", birthday_isNull);
							}
							if(birthday_isNotNull!=null){
	                        	queryMapReturn.put("birthday_isNotNull", birthday_isNotNull);
							}
							if(birthday_in!=null){
	                        	queryMapReturn.put("birthday_in", birthday_in);
							}
							if(birthday!=null){
	                        	queryMapReturn.put("birthday", birthday);
							}						           
																																							String academic_like = (String)contentreq.get("academic_like");
							String academic_isNull = (String)contentreq.get("academic_isNull");
							String academic_isNotNull = (String)contentreq.get("academic_isNotNull");
							String academic_in = (String)contentreq.get("academic_in");
							String academic = (String)contentreq.get("academic");
							if(academic_like!=null){
	                        	queryMapReturn.put("academic_like", academic_like);
							}
							if(academic_isNull!=null){
	                        	queryMapReturn.put("academic_isNull", academic_isNull);
							}
							if(academic_isNotNull!=null){
	                        	queryMapReturn.put("academic_isNotNull", academic_isNotNull);
							}
							if(academic_in!=null){
	                        	queryMapReturn.put("academic_in", academic_in);
							}
							if(academic!=null){
	                        	queryMapReturn.put("academic", academic);
							}						           
																																							String contact_like = (String)contentreq.get("contact_like");
							String contact_isNull = (String)contentreq.get("contact_isNull");
							String contact_isNotNull = (String)contentreq.get("contact_isNotNull");
							String contact_in = (String)contentreq.get("contact_in");
							String contact = (String)contentreq.get("contact");
							if(contact_like!=null){
	                        	queryMapReturn.put("contact_like", contact_like);
							}
							if(contact_isNull!=null){
	                        	queryMapReturn.put("contact_isNull", contact_isNull);
							}
							if(contact_isNotNull!=null){
	                        	queryMapReturn.put("contact_isNotNull", contact_isNotNull);
							}
							if(contact_in!=null){
	                        	queryMapReturn.put("contact_in", contact_in);
							}
							if(contact!=null){
	                        	queryMapReturn.put("contact", contact);
							}						           
																																							String wechatNum_like = (String)contentreq.get("wechatNum_like");
							String wechatNum_isNull = (String)contentreq.get("wechatNum_isNull");
							String wechatNum_isNotNull = (String)contentreq.get("wechatNum_isNotNull");
							String wechatNum_in = (String)contentreq.get("wechatNum_in");
							String wechatNum = (String)contentreq.get("wechatNum");
							if(wechatNum_like!=null){
	                        	queryMapReturn.put("wechatNum_like", wechatNum_like);
							}
							if(wechatNum_isNull!=null){
	                        	queryMapReturn.put("wechatNum_isNull", wechatNum_isNull);
							}
							if(wechatNum_isNotNull!=null){
	                        	queryMapReturn.put("wechatNum_isNotNull", wechatNum_isNotNull);
							}
							if(wechatNum_in!=null){
	                        	queryMapReturn.put("wechatNum_in", wechatNum_in);
							}
							if(wechatNum!=null){
	                        	queryMapReturn.put("wechatNum", wechatNum);
							}						           
																																							String wechatQrCode_like = (String)contentreq.get("wechatQrCode_like");
							String wechatQrCode_isNull = (String)contentreq.get("wechatQrCode_isNull");
							String wechatQrCode_isNotNull = (String)contentreq.get("wechatQrCode_isNotNull");
							String wechatQrCode_in = (String)contentreq.get("wechatQrCode_in");
							String wechatQrCode = (String)contentreq.get("wechatQrCode");
							if(wechatQrCode_like!=null){
	                        	queryMapReturn.put("wechatQrCode_like", wechatQrCode_like);
							}
							if(wechatQrCode_isNull!=null){
	                        	queryMapReturn.put("wechatQrCode_isNull", wechatQrCode_isNull);
							}
							if(wechatQrCode_isNotNull!=null){
	                        	queryMapReturn.put("wechatQrCode_isNotNull", wechatQrCode_isNotNull);
							}
							if(wechatQrCode_in!=null){
	                        	queryMapReturn.put("wechatQrCode_in", wechatQrCode_in);
							}
							if(wechatQrCode!=null){
	                        	queryMapReturn.put("wechatQrCode", wechatQrCode);
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
			} else if ("DEL_SERVICE_PERSON_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if(true){
					if(contentreq!=null){
						idReturn = (Integer)contentreq.get("id");	
						    					}	
				}
			} else if ("DEL_SERVICE_PERSON_LIST_REQUEST".equals(command)) {
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
																																							String headPortrait_like = (String)contentreq.get("headPortrait_like");
							String headPortrait_isNull = (String)contentreq.get("headPortrait_isNull");
							String headPortrait_isNotNull = (String)contentreq.get("headPortrait_isNotNull");
							String headPortrait_in = (String)contentreq.get("headPortrait_in");
							String headPortrait = (String)contentreq.get("headPortrait");
							if(headPortrait_like!=null){
	                        	queryMapReturn.put("headPortrait_like", headPortrait_like);
							}
							if(headPortrait_isNull!=null){
	                        	queryMapReturn.put("headPortrait_isNull", headPortrait_isNull);
							}
							if(headPortrait_isNotNull!=null){
	                        	queryMapReturn.put("headPortrait_isNotNull", headPortrait_isNotNull);
							}
							if(headPortrait_in!=null){
	                        	queryMapReturn.put("headPortrait_in", headPortrait_in);
							}
							if(headPortrait!=null){
	                        	queryMapReturn.put("headPortrait", headPortrait);
							}						           
																																							String birthday_like = (String)contentreq.get("birthday_like");
							String birthday_isNull = (String)contentreq.get("birthday_isNull");
							String birthday_isNotNull = (String)contentreq.get("birthday_isNotNull");
							String birthday_in = (String)contentreq.get("birthday_in");
							String birthday = (String)contentreq.get("birthday");
							if(birthday_like!=null){
	                        	queryMapReturn.put("birthday_like", birthday_like);
							}
							if(birthday_isNull!=null){
	                        	queryMapReturn.put("birthday_isNull", birthday_isNull);
							}
							if(birthday_isNotNull!=null){
	                        	queryMapReturn.put("birthday_isNotNull", birthday_isNotNull);
							}
							if(birthday_in!=null){
	                        	queryMapReturn.put("birthday_in", birthday_in);
							}
							if(birthday!=null){
	                        	queryMapReturn.put("birthday", birthday);
							}						           
																																							String academic_like = (String)contentreq.get("academic_like");
							String academic_isNull = (String)contentreq.get("academic_isNull");
							String academic_isNotNull = (String)contentreq.get("academic_isNotNull");
							String academic_in = (String)contentreq.get("academic_in");
							String academic = (String)contentreq.get("academic");
							if(academic_like!=null){
	                        	queryMapReturn.put("academic_like", academic_like);
							}
							if(academic_isNull!=null){
	                        	queryMapReturn.put("academic_isNull", academic_isNull);
							}
							if(academic_isNotNull!=null){
	                        	queryMapReturn.put("academic_isNotNull", academic_isNotNull);
							}
							if(academic_in!=null){
	                        	queryMapReturn.put("academic_in", academic_in);
							}
							if(academic!=null){
	                        	queryMapReturn.put("academic", academic);
							}						           
																																							String contact_like = (String)contentreq.get("contact_like");
							String contact_isNull = (String)contentreq.get("contact_isNull");
							String contact_isNotNull = (String)contentreq.get("contact_isNotNull");
							String contact_in = (String)contentreq.get("contact_in");
							String contact = (String)contentreq.get("contact");
							if(contact_like!=null){
	                        	queryMapReturn.put("contact_like", contact_like);
							}
							if(contact_isNull!=null){
	                        	queryMapReturn.put("contact_isNull", contact_isNull);
							}
							if(contact_isNotNull!=null){
	                        	queryMapReturn.put("contact_isNotNull", contact_isNotNull);
							}
							if(contact_in!=null){
	                        	queryMapReturn.put("contact_in", contact_in);
							}
							if(contact!=null){
	                        	queryMapReturn.put("contact", contact);
							}						           
																																							String wechatNum_like = (String)contentreq.get("wechatNum_like");
							String wechatNum_isNull = (String)contentreq.get("wechatNum_isNull");
							String wechatNum_isNotNull = (String)contentreq.get("wechatNum_isNotNull");
							String wechatNum_in = (String)contentreq.get("wechatNum_in");
							String wechatNum = (String)contentreq.get("wechatNum");
							if(wechatNum_like!=null){
	                        	queryMapReturn.put("wechatNum_like", wechatNum_like);
							}
							if(wechatNum_isNull!=null){
	                        	queryMapReturn.put("wechatNum_isNull", wechatNum_isNull);
							}
							if(wechatNum_isNotNull!=null){
	                        	queryMapReturn.put("wechatNum_isNotNull", wechatNum_isNotNull);
							}
							if(wechatNum_in!=null){
	                        	queryMapReturn.put("wechatNum_in", wechatNum_in);
							}
							if(wechatNum!=null){
	                        	queryMapReturn.put("wechatNum", wechatNum);
							}						           
																																							String wechatQrCode_like = (String)contentreq.get("wechatQrCode_like");
							String wechatQrCode_isNull = (String)contentreq.get("wechatQrCode_isNull");
							String wechatQrCode_isNotNull = (String)contentreq.get("wechatQrCode_isNotNull");
							String wechatQrCode_in = (String)contentreq.get("wechatQrCode_in");
							String wechatQrCode = (String)contentreq.get("wechatQrCode");
							if(wechatQrCode_like!=null){
	                        	queryMapReturn.put("wechatQrCode_like", wechatQrCode_like);
							}
							if(wechatQrCode_isNull!=null){
	                        	queryMapReturn.put("wechatQrCode_isNull", wechatQrCode_isNull);
							}
							if(wechatQrCode_isNotNull!=null){
	                        	queryMapReturn.put("wechatQrCode_isNotNull", wechatQrCode_isNotNull);
							}
							if(wechatQrCode_in!=null){
	                        	queryMapReturn.put("wechatQrCode_in", wechatQrCode_in);
							}
							if(wechatQrCode!=null){
	                        	queryMapReturn.put("wechatQrCode", wechatQrCode);
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
			if (servicePersonReturn != null) {
				parseMap.put("servicePerson", servicePersonReturn);
			}
			if (servicePersonListReturn != null && servicePersonListReturn.size() > 0) {
				parseMap.put("servicePersonList", servicePersonListReturn);
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
