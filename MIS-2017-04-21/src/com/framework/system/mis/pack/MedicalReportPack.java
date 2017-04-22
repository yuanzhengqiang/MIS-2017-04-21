package com.framework.system.mis.pack;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;


import com.framework.system.db.query.PageList;
import com.framework.system.mis.entity.MedicalReportEntity;
 /**   
 * @Title: Pack
 * @Description: 体检记录表封装器
 * @author feng.gu
 * @date 2017-04-21 16:18:36
 * @version V1.0   
 *
 */
public class MedicalReportPack {
	private static Logger logger = Logger.getLogger(MedicalReportPack.class);
	private static MedicalReportPack medicalReportPack;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static MedicalReportPack getInstance() {
		if (medicalReportPack == null) {
			medicalReportPack = new MedicalReportPack();
		}
		return medicalReportPack;
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
				actionBack="ADD_MEDICAL_REPORT_INFO_RESPONSE";	
				if(request.equals(true)){
					resultBack="100";
					desBack="success";
				}else if(request.equals(false)){
					resultBack="200";
					desBack="failure";
				}   
				MedicalReportEntity medicalReport = (MedicalReportEntity)entity;
				if(medicalReport!=null){
					contentBack = new JSONObject();
					contentBack.put("id", medicalReport.getId());
					
									}
			} else if ("getById".equals(action)) {
				actionBack="QUERY_MEDICAL_REPORT_INFO_RESPONSE";		
				resultBack="100";
				desBack="success";
				MedicalReportEntity medicalReport = (MedicalReportEntity)request;
				if(medicalReport!=null){
					contentBack = JSONObject.fromObject(medicalReport);
									}
			} else if ("getListByCondition".equals(action)) {
				actionBack="QUERY_MEDICAL_REPORT_LIST_RESPONSE";
				resultBack="100";
				desBack="success";
				PageList pageList = (PageList)request;
				if(pageList!=null&&pageList.getResultList()!=null&&pageList.getResultList().size()>0){
					contentBack = new JSONObject();
					pageBack = new JSONObject();
					JSONArray list = JSONArray.fromObject(pageList.getResultList());
					contentBack.put("medicalReportList", list);
					
					pageBack.put("pageno", pageList.getPageno());
					pageBack.put("pagesize", pageList.getPagesize());
					pageBack.put("recordCount", pageList.getRecordCount());
					pageBack.put("pageCount", pageList.getPageCount());
					
				}
			} else if ("del".equals(action)) {
				actionBack="DEL_MEDICAL_REPORT_INFO_REQUEST";	
				if(request.equals(true)){
					resultBack="100";
					desBack="success";
				}else if(request.equals(false)){
					resultBack="200";
					desBack="failure";
				} 
			} else if ("delList".equals(action)) {
				actionBack="DEL_MEDICAL_REPORT_LIST_REQUEST";	
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
