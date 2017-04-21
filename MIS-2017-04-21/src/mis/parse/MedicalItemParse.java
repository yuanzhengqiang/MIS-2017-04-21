package mis.parse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.framework.system.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import com.framework.system.db.manager.DBManager;

import mis.entity.MedicalItemEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;




import com.framework.system.util.JsonUtil;
import com.framework.system.db.query.OrderVO;
 /**   
 * @Title: Parse
 * @Description: 体检项目表解析器
 * @author feng.gu
 * @date 2017-04-21 16:09:59
 * @version V1.0   
 *
 */
public class MedicalItemParse {
	private static Logger logger = Logger.getLogger(MedicalItemParse.class);
	private static MedicalItemParse medicalItemParse;
	private DBManager dbManager = DBManager.getInstance();

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static MedicalItemParse getInstance() {
		if (medicalItemParse == null) {
			medicalItemParse = new MedicalItemParse();
		}
		return medicalItemParse;
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
			MedicalItemEntity medicalItemReturn = null;
			List<MedicalItemEntity> medicalItemListReturn = null;
			Integer idReturn = null;			
			Map<String, Object> queryMapReturn = null;
			int pagenoReturn = 1;
			int pagesizeReturn = 10;
			List<OrderVO> orderListReturn = null;
			
						
			//json
			Map reqParams = JsonUtil.getMap4Json(reqStr);
			JSONObject contentreq = (JSONObject)reqParams.get("content");
			if ("ADD_MEDICAL_ITEM_INFO_REQUEST".equals(command)) {
				actionReturn = "save";
				medicalItemReturn = new MedicalItemEntity();
				if(true){
					if(contentreq!=null){
												    						    Integer id = (Integer)contentreq.get("id");
	                		if(id!=null){
	                		    	                		    medicalItemReturn  = (MedicalItemEntity)dbManager.getById(id, MedicalItemEntity.class);	                		    
	                		    			                	medicalItemReturn.setId(id);
			                }
						    												    						    String itemName = (String)contentreq.get("itemName");
	                		if(itemName!=null){
	                		    			                	medicalItemReturn.setItemName(itemName);
			                }
						    												    						    Integer category = (Integer)contentreq.get("category");
	                		if(category!=null){
	                		    			                	medicalItemReturn.setCategory(category);
			                }
						    												    						    String testWay = (String)contentreq.get("testWay");
	                		if(testWay!=null){
	                		    			                	medicalItemReturn.setTestWay(testWay);
			                }
						    												    						    String testPurpose = (String)contentreq.get("testPurpose");
	                		if(testPurpose!=null){
	                		    			                	medicalItemReturn.setTestPurpose(testPurpose);
			                }
						    												    						    String selectDes = (String)contentreq.get("selectDes");
	                		if(selectDes!=null){
	                		    			                	medicalItemReturn.setSelectDes(selectDes);
			                }
						    												    						     						     						     Double price = JsonUtil.getJSONDouble(contentreq, "price");
							 if (price != null) {
								medicalItemReturn.setPrice(price);
							 }
						     						    												    						    String des = (String)contentreq.get("des");
	                		if(des!=null){
	                		    			                	medicalItemReturn.setDes(des);
			                }
						    												    						    String mattersNeedAttention = (String)contentreq.get("mattersNeedAttention");
	                		if(mattersNeedAttention!=null){
	                		    			                	medicalItemReturn.setMattersNeedAttention(mattersNeedAttention);
			                }
						    											}					
				}
							} else if ("QUERY_MEDICAL_ITEM_INFO_REQUEST".equals(command)) {
				actionReturn = "getById";
				if(true){
					if(contentreq!=null){
						idReturn = (Integer)contentreq.get("id");
					        					}	
				}
			} else if ("QUERY_MEDICAL_ITEM_LIST_REQUEST".equals(command)) {
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
																																String itemName_like = (String)contentreq.get("itemName_like");
							String itemName_isNull = (String)contentreq.get("itemName_isNull");
							String itemName_isNotNull = (String)contentreq.get("itemName_isNotNull");
							String itemName_in = (String)contentreq.get("itemName_in");
							String itemName = (String)contentreq.get("itemName");
							if(itemName_like!=null){
	                        	queryMapReturn.put("itemName_like", itemName_like);
							}
							if(itemName_isNull!=null){
	                        	queryMapReturn.put("itemName_isNull", itemName_isNull);
							}
							if(itemName_isNotNull!=null){
	                        	queryMapReturn.put("itemName_isNotNull", itemName_isNotNull);
							}
							if(itemName_in!=null){
	                        	queryMapReturn.put("itemName_in", itemName_in);
							}
							if(itemName!=null){
	                        	queryMapReturn.put("itemName", itemName);
							}						           
																															Integer category_gt = (Integer)contentreq.get("category_gt");
						Integer category_ge = (Integer)contentreq.get("category_ge");
						Integer category_lt = (Integer)contentreq.get("category_lt");
						Integer category_le = (Integer)contentreq.get("category_le");
						String category_in = (String)contentreq.get("category_in");
						Integer category = (Integer)contentreq.get("category");
                        if(category_gt!=null){
                        	queryMapReturn.put("category_gt", category_gt);
						}
						if(category_ge!=null){
                        	queryMapReturn.put("category_ge", category_ge);
						}
						if(category_lt!=null){
                        	queryMapReturn.put("category_lt", category_lt);
						}
						if(category_le!=null){
                        	queryMapReturn.put("category_le", category_le);
						}
						if(category_in!=null){
                        	queryMapReturn.put("category_in", category_in);
						}
						if(category!=null){
                        	queryMapReturn.put("category", category);
						}		
																																String testWay_like = (String)contentreq.get("testWay_like");
							String testWay_isNull = (String)contentreq.get("testWay_isNull");
							String testWay_isNotNull = (String)contentreq.get("testWay_isNotNull");
							String testWay_in = (String)contentreq.get("testWay_in");
							String testWay = (String)contentreq.get("testWay");
							if(testWay_like!=null){
	                        	queryMapReturn.put("testWay_like", testWay_like);
							}
							if(testWay_isNull!=null){
	                        	queryMapReturn.put("testWay_isNull", testWay_isNull);
							}
							if(testWay_isNotNull!=null){
	                        	queryMapReturn.put("testWay_isNotNull", testWay_isNotNull);
							}
							if(testWay_in!=null){
	                        	queryMapReturn.put("testWay_in", testWay_in);
							}
							if(testWay!=null){
	                        	queryMapReturn.put("testWay", testWay);
							}						           
																																							String testPurpose_like = (String)contentreq.get("testPurpose_like");
							String testPurpose_isNull = (String)contentreq.get("testPurpose_isNull");
							String testPurpose_isNotNull = (String)contentreq.get("testPurpose_isNotNull");
							String testPurpose_in = (String)contentreq.get("testPurpose_in");
							String testPurpose = (String)contentreq.get("testPurpose");
							if(testPurpose_like!=null){
	                        	queryMapReturn.put("testPurpose_like", testPurpose_like);
							}
							if(testPurpose_isNull!=null){
	                        	queryMapReturn.put("testPurpose_isNull", testPurpose_isNull);
							}
							if(testPurpose_isNotNull!=null){
	                        	queryMapReturn.put("testPurpose_isNotNull", testPurpose_isNotNull);
							}
							if(testPurpose_in!=null){
	                        	queryMapReturn.put("testPurpose_in", testPurpose_in);
							}
							if(testPurpose!=null){
	                        	queryMapReturn.put("testPurpose", testPurpose);
							}						           
																																							String selectDes_like = (String)contentreq.get("selectDes_like");
							String selectDes_isNull = (String)contentreq.get("selectDes_isNull");
							String selectDes_isNotNull = (String)contentreq.get("selectDes_isNotNull");
							String selectDes_in = (String)contentreq.get("selectDes_in");
							String selectDes = (String)contentreq.get("selectDes");
							if(selectDes_like!=null){
	                        	queryMapReturn.put("selectDes_like", selectDes_like);
							}
							if(selectDes_isNull!=null){
	                        	queryMapReturn.put("selectDes_isNull", selectDes_isNull);
							}
							if(selectDes_isNotNull!=null){
	                        	queryMapReturn.put("selectDes_isNotNull", selectDes_isNotNull);
							}
							if(selectDes_in!=null){
	                        	queryMapReturn.put("selectDes_in", selectDes_in);
							}
							if(selectDes!=null){
	                        	queryMapReturn.put("selectDes", selectDes);
							}						           
																																							String price_like = (String)contentreq.get("price_like");
							String price_isNull = (String)contentreq.get("price_isNull");
							String price_isNotNull = (String)contentreq.get("price_isNotNull");
							String price_in = (String)contentreq.get("price_in");
							String price = (String)contentreq.get("price");
							if(price_like!=null){
	                        	queryMapReturn.put("price_like", price_like);
							}
							if(price_isNull!=null){
	                        	queryMapReturn.put("price_isNull", price_isNull);
							}
							if(price_isNotNull!=null){
	                        	queryMapReturn.put("price_isNotNull", price_isNotNull);
							}
							if(price_in!=null){
	                        	queryMapReturn.put("price_in", price_in);
							}
							if(price!=null){
	                        	queryMapReturn.put("price", price);
							}						           
																																							String des_like = (String)contentreq.get("des_like");
							String des_isNull = (String)contentreq.get("des_isNull");
							String des_isNotNull = (String)contentreq.get("des_isNotNull");
							String des_in = (String)contentreq.get("des_in");
							String des = (String)contentreq.get("des");
							if(des_like!=null){
	                        	queryMapReturn.put("des_like", des_like);
							}
							if(des_isNull!=null){
	                        	queryMapReturn.put("des_isNull", des_isNull);
							}
							if(des_isNotNull!=null){
	                        	queryMapReturn.put("des_isNotNull", des_isNotNull);
							}
							if(des_in!=null){
	                        	queryMapReturn.put("des_in", des_in);
							}
							if(des!=null){
	                        	queryMapReturn.put("des", des);
							}						           
																																							String mattersNeedAttention_like = (String)contentreq.get("mattersNeedAttention_like");
							String mattersNeedAttention_isNull = (String)contentreq.get("mattersNeedAttention_isNull");
							String mattersNeedAttention_isNotNull = (String)contentreq.get("mattersNeedAttention_isNotNull");
							String mattersNeedAttention_in = (String)contentreq.get("mattersNeedAttention_in");
							String mattersNeedAttention = (String)contentreq.get("mattersNeedAttention");
							if(mattersNeedAttention_like!=null){
	                        	queryMapReturn.put("mattersNeedAttention_like", mattersNeedAttention_like);
							}
							if(mattersNeedAttention_isNull!=null){
	                        	queryMapReturn.put("mattersNeedAttention_isNull", mattersNeedAttention_isNull);
							}
							if(mattersNeedAttention_isNotNull!=null){
	                        	queryMapReturn.put("mattersNeedAttention_isNotNull", mattersNeedAttention_isNotNull);
							}
							if(mattersNeedAttention_in!=null){
	                        	queryMapReturn.put("mattersNeedAttention_in", mattersNeedAttention_in);
							}
							if(mattersNeedAttention!=null){
	                        	queryMapReturn.put("mattersNeedAttention", mattersNeedAttention);
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
			} else if ("DEL_MEDICAL_ITEM_INFO_REQUEST".equals(command)) {
				actionReturn = "del";
				if(true){
					if(contentreq!=null){
						idReturn = (Integer)contentreq.get("id");	
						    					}	
				}
			} else if ("DEL_MEDICAL_ITEM_LIST_REQUEST".equals(command)) {
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
																																String itemName_like = (String)contentreq.get("itemName_like");
							String itemName_isNull = (String)contentreq.get("itemName_isNull");
							String itemName_isNotNull = (String)contentreq.get("itemName_isNotNull");
							String itemName_in = (String)contentreq.get("itemName_in");
							String itemName = (String)contentreq.get("itemName");
							if(itemName_like!=null){
	                        	queryMapReturn.put("itemName_like", itemName_like);
							}
							if(itemName_isNull!=null){
	                        	queryMapReturn.put("itemName_isNull", itemName_isNull);
							}
							if(itemName_isNotNull!=null){
	                        	queryMapReturn.put("itemName_isNotNull", itemName_isNotNull);
							}
							if(itemName_in!=null){
	                        	queryMapReturn.put("itemName_in", itemName_in);
							}
							if(itemName!=null){
	                        	queryMapReturn.put("itemName", itemName);
							}						           
																															Integer category_gt = (Integer)contentreq.get("category_gt");
						Integer category_ge = (Integer)contentreq.get("category_ge");
						Integer category_lt = (Integer)contentreq.get("category_lt");
						Integer category_le = (Integer)contentreq.get("category_le");
						String category_in = (String)contentreq.get("category_in");
						Integer category = (Integer)contentreq.get("category");
                        if(category_gt!=null){
                        	queryMapReturn.put("category_gt", category_gt);
						}
						if(category_ge!=null){
                        	queryMapReturn.put("category_ge", category_ge);
						}
						if(category_lt!=null){
                        	queryMapReturn.put("category_lt", category_lt);
						}
						if(category_le!=null){
                        	queryMapReturn.put("category_le", category_le);
						}
						if(category_in!=null){
                        	queryMapReturn.put("category_in", category_in);
						}
						if(category!=null){
                        	queryMapReturn.put("category", category);
						}		
																																String testWay_like = (String)contentreq.get("testWay_like");
							String testWay_isNull = (String)contentreq.get("testWay_isNull");
							String testWay_isNotNull = (String)contentreq.get("testWay_isNotNull");
							String testWay_in = (String)contentreq.get("testWay_in");
							String testWay = (String)contentreq.get("testWay");
							if(testWay_like!=null){
	                        	queryMapReturn.put("testWay_like", testWay_like);
							}
							if(testWay_isNull!=null){
	                        	queryMapReturn.put("testWay_isNull", testWay_isNull);
							}
							if(testWay_isNotNull!=null){
	                        	queryMapReturn.put("testWay_isNotNull", testWay_isNotNull);
							}
							if(testWay_in!=null){
	                        	queryMapReturn.put("testWay_in", testWay_in);
							}
							if(testWay!=null){
	                        	queryMapReturn.put("testWay", testWay);
							}						           
																																							String testPurpose_like = (String)contentreq.get("testPurpose_like");
							String testPurpose_isNull = (String)contentreq.get("testPurpose_isNull");
							String testPurpose_isNotNull = (String)contentreq.get("testPurpose_isNotNull");
							String testPurpose_in = (String)contentreq.get("testPurpose_in");
							String testPurpose = (String)contentreq.get("testPurpose");
							if(testPurpose_like!=null){
	                        	queryMapReturn.put("testPurpose_like", testPurpose_like);
							}
							if(testPurpose_isNull!=null){
	                        	queryMapReturn.put("testPurpose_isNull", testPurpose_isNull);
							}
							if(testPurpose_isNotNull!=null){
	                        	queryMapReturn.put("testPurpose_isNotNull", testPurpose_isNotNull);
							}
							if(testPurpose_in!=null){
	                        	queryMapReturn.put("testPurpose_in", testPurpose_in);
							}
							if(testPurpose!=null){
	                        	queryMapReturn.put("testPurpose", testPurpose);
							}						           
																																							String selectDes_like = (String)contentreq.get("selectDes_like");
							String selectDes_isNull = (String)contentreq.get("selectDes_isNull");
							String selectDes_isNotNull = (String)contentreq.get("selectDes_isNotNull");
							String selectDes_in = (String)contentreq.get("selectDes_in");
							String selectDes = (String)contentreq.get("selectDes");
							if(selectDes_like!=null){
	                        	queryMapReturn.put("selectDes_like", selectDes_like);
							}
							if(selectDes_isNull!=null){
	                        	queryMapReturn.put("selectDes_isNull", selectDes_isNull);
							}
							if(selectDes_isNotNull!=null){
	                        	queryMapReturn.put("selectDes_isNotNull", selectDes_isNotNull);
							}
							if(selectDes_in!=null){
	                        	queryMapReturn.put("selectDes_in", selectDes_in);
							}
							if(selectDes!=null){
	                        	queryMapReturn.put("selectDes", selectDes);
							}						           
																																							String price_like = (String)contentreq.get("price_like");
							String price_isNull = (String)contentreq.get("price_isNull");
							String price_isNotNull = (String)contentreq.get("price_isNotNull");
							String price_in = (String)contentreq.get("price_in");
							String price = (String)contentreq.get("price");
							if(price_like!=null){
	                        	queryMapReturn.put("price_like", price_like);
							}
							if(price_isNull!=null){
	                        	queryMapReturn.put("price_isNull", price_isNull);
							}
							if(price_isNotNull!=null){
	                        	queryMapReturn.put("price_isNotNull", price_isNotNull);
							}
							if(price_in!=null){
	                        	queryMapReturn.put("price_in", price_in);
							}
							if(price!=null){
	                        	queryMapReturn.put("price", price);
							}						           
																																							String des_like = (String)contentreq.get("des_like");
							String des_isNull = (String)contentreq.get("des_isNull");
							String des_isNotNull = (String)contentreq.get("des_isNotNull");
							String des_in = (String)contentreq.get("des_in");
							String des = (String)contentreq.get("des");
							if(des_like!=null){
	                        	queryMapReturn.put("des_like", des_like);
							}
							if(des_isNull!=null){
	                        	queryMapReturn.put("des_isNull", des_isNull);
							}
							if(des_isNotNull!=null){
	                        	queryMapReturn.put("des_isNotNull", des_isNotNull);
							}
							if(des_in!=null){
	                        	queryMapReturn.put("des_in", des_in);
							}
							if(des!=null){
	                        	queryMapReturn.put("des", des);
							}						           
																																							String mattersNeedAttention_like = (String)contentreq.get("mattersNeedAttention_like");
							String mattersNeedAttention_isNull = (String)contentreq.get("mattersNeedAttention_isNull");
							String mattersNeedAttention_isNotNull = (String)contentreq.get("mattersNeedAttention_isNotNull");
							String mattersNeedAttention_in = (String)contentreq.get("mattersNeedAttention_in");
							String mattersNeedAttention = (String)contentreq.get("mattersNeedAttention");
							if(mattersNeedAttention_like!=null){
	                        	queryMapReturn.put("mattersNeedAttention_like", mattersNeedAttention_like);
							}
							if(mattersNeedAttention_isNull!=null){
	                        	queryMapReturn.put("mattersNeedAttention_isNull", mattersNeedAttention_isNull);
							}
							if(mattersNeedAttention_isNotNull!=null){
	                        	queryMapReturn.put("mattersNeedAttention_isNotNull", mattersNeedAttention_isNotNull);
							}
							if(mattersNeedAttention_in!=null){
	                        	queryMapReturn.put("mattersNeedAttention_in", mattersNeedAttention_in);
							}
							if(mattersNeedAttention!=null){
	                        	queryMapReturn.put("mattersNeedAttention", mattersNeedAttention);
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
			if (medicalItemReturn != null) {
				parseMap.put("medicalItem", medicalItemReturn);
			}
			if (medicalItemListReturn != null && medicalItemListReturn.size() > 0) {
				parseMap.put("medicalItemList", medicalItemListReturn);
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
