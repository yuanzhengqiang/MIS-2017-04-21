package com.framework.system.mis.pack;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;


import com.framework.system.db.query.PageList;
import com.framework.system.mis.entity.OrderEntity;
 /**   
 * @Title: Pack
 * @Description: 订单表封装器
 * @author feng.gu
 * @date 2017-04-21 16:39:13
 * @version V1.0   
 *
 */
public class OrderPack {
	private static Logger logger = Logger.getLogger(OrderPack.class);
	private static OrderPack orderPack;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static OrderPack getInstance() {
		if (orderPack == null) {
			orderPack = new OrderPack();
		}
		return orderPack;
	}

	public Map<String, Object> pack(int type, String action, Object request,Object entity) {
		// 定义返回参数
		Map<String, Object> packMap = new HashMap<String, Object>();
		if (type == 1) {
			// json
			packMap = this.packByJson(action, request,entity);
		} else if (type == 2) {
			// xml
			packMap = this.packByXml(action, request,entity);
		}
		return packMap;
	}

	private Map<String, Object> packByJson(String action, Object request,Object entity) {
		// 定义返回参数
		Map<String, Object> packMap = new HashMap<String, Object>();
		String actionBack = null;
		String resultBack = null;
		String desBack = null;
		JSONObject pageBack = null;
		JSONObject contentBack = null;
		try {
			if ("save".equals(action)) {
				actionBack="ADD_ORDER_INFO_RESPONSE";	
				if(request.equals(true)){
					resultBack="100";
					desBack="success";
				}else if(request.equals(false)){
					resultBack="200";
					desBack="failure";
				}   
				OrderEntity order = (OrderEntity)entity;
				if(order!=null){
					contentBack = new JSONObject();
					contentBack.put("id", order.getId());
					
																														if(order.getParentOrder()!=null){
						contentBack.put("parentOrderId", order.getParentOrder().getId());
					}
																																			if(order.getServicePerson()!=null){
						contentBack.put("servicePersonId", order.getServicePerson().getId());
					}
																																								if(order.getMedicalReport()!=null){
						contentBack.put("medicalReportId", order.getMedicalReport().getId());
					}
																								}
			} else if ("getById".equals(action)) {
				actionBack="QUERY_ORDER_INFO_RESPONSE";		
				resultBack="100";
				desBack="success";
				OrderEntity order = (OrderEntity)request;
				if(order!=null){
					contentBack = JSONObject.fromObject(order);
																														if(order.getParentOrder()!=null){
						contentBack.put("parentOrder", JSONObject.fromObject(order.getParentOrder()));
					}
					if(order.getChildOrderList()!=null){
						contentBack.put("childOrderList", JSONArray.fromObject(order.getChildOrderList()));
					}
																																			if(order.getServicePerson()!=null){
						contentBack.put("servicePerson", JSONObject.fromObject(order.getServicePerson()));
					}
																																								if(order.getMedicalReport()!=null){
						contentBack.put("medicalReport", JSONObject.fromObject(order.getMedicalReport()));
					}
																								}
			} else if ("getListByCondition".equals(action)) {
				actionBack="QUERY_ORDER_LIST_RESPONSE";
				resultBack="100";
				desBack="success";
				PageList pageList = (PageList)request;
				if(pageList!=null&&pageList.getResultList()!=null&&pageList.getResultList().size()>0){
					contentBack = new JSONObject();
					pageBack = new JSONObject();
					JSONArray list = JSONArray.fromObject(pageList.getResultList());
					contentBack.put("orderList", list);
					
					pageBack.put("pageno", pageList.getPageno());
					pageBack.put("pagesize", pageList.getPagesize());
					pageBack.put("recordCount", pageList.getRecordCount());
					pageBack.put("pageCount", pageList.getPageCount());
					
				}
			} else if ("del".equals(action)) {
				actionBack="DEL_ORDER_INFO_REQUEST";	
				if(request.equals(true)){
					resultBack="100";
					desBack="success";
				}else if(request.equals(false)){
					resultBack="200";
					desBack="failure";
				} 
			} else if ("delList".equals(action)) {
				actionBack="DEL_ORDER_LIST_REQUEST";	
				if(request.equals(true)){
					resultBack="100";
					desBack="success";
				}else if(request.equals(false)){
					resultBack="200";
					desBack="failure";
				} 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		if (actionBack != null && !"".equals(actionBack)) {
			packMap.put("action", actionBack);
		}
		if (resultBack != null&& !"".equals(resultBack)) {
			packMap.put("result", resultBack);
		}
		if (desBack != null&& !"".equals(desBack)) {
			packMap.put("des", desBack);
		}
		if (pageBack != null) {
			packMap.put("page", pageBack);
		}
		if (contentBack != null) {
			packMap.put("content", contentBack);
		}
		return packMap;
	}

	private Map<String, Object> packByXml(String action, Object request,Object entity) {
		Map<String, Object> packMap = new HashMap<String, Object>();
		return packMap;
	}

}
