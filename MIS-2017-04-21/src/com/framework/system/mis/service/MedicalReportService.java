package com.framework.system.mis.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


import org.apache.log4j.Logger;



import com.framework.system.db.connect.DbUtils;
import com.framework.system.db.manager.DBManager;
import com.framework.system.db.query.PageList;
import com.framework.system.db.query.QueryCondition;
import com.framework.system.db.query.OrderByCondition;
import com.framework.system.db.query.OrderVO;
import com.framework.system.db.transaction.TransactionManager;
import com.framework.system.mis.entity.MedicalReportEntity;
import com.framework.system.util.StringUtil;



/**   
 * @Title: Service
 * @Description: 体检记录表服务类
 * @author feng.gu
 * @date 2017-04-21 16:18:36
 * @version V1.0   
 *
 */
public class MedicalReportService {
	   private static Logger logger = Logger.getLogger(MedicalReportService.class);
	   private DBManager dbManager = DBManager.getInstance();
    		
	   private static MedicalReportService medicalReportService;
	   /**
	    * 获取实例	
	    * @return
	    */
	   public static MedicalReportService getInstance(){
		if(medicalReportService==null){
			medicalReportService = new MedicalReportService();
		}
		return medicalReportService;
	   }
	                 	                 				     				     				     				     
				     	 
	   /**
		 * 保存记录
		 * 
		 * @param obj
		 */
		public boolean save(MedicalReportEntity medicalReport) {			
			boolean result =false;
			if(medicalReport!=null){
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					 tx.beginTransaction();					 					 
					 					 result=dbManager.saveNoTransaction(medicalReport);	
					 tx.commitAndClose();  
				}catch (Exception e) { 
					 logger.error("数据库提交失败！");
					 logger.error(e);
					 result = false;
				     try {				    
						   tx.rollbackAndClose();
					 } catch (Exception ex) {					   
						   logger.error("数据库回滚失败！");
						   logger.error(ex);
					 }   
				}  			
			}	
			return result;
		}
		
		/**
		 * 批量保存记录
		 * 
		 * @param list
		 */
		public boolean saveList(List<MedicalReportEntity> medicalReportList) {
			boolean result = false;
			if (medicalReportList != null && medicalReportList.size() > 0) {
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					tx.beginTransaction(); 
					for(MedicalReportEntity medicalReport:medicalReportList){
						if(medicalReport!=null){												  								 
								 								 result=dbManager.saveNoTransaction(medicalReport);								 			
						}	
					}
				    tx.commitAndClose(); 
				}catch (Exception e) { 
					 logger.error("数据库提交失败！");
					 logger.error(e);
					 result = false;
				     try {
						   tx.rollbackAndClose();
					 } catch (Exception ex) {					   
						   logger.error("数据库回滚失败！");
						   logger.error(ex);
					 }   
				}  
			}
			return result;
		}
		
				
		
		/**
		 * 根据id读取记录
		 * @param id 主键
		 		 * @param obj
		 */
		public MedicalReportEntity getById(Integer id) {
			MedicalReportEntity obj = null;
			if (id!=null) {
				obj = (MedicalReportEntity)dbManager.getById(id, MedicalReportEntity.class);
							}
			return obj;
		}
		
		/**
		 * 根据条件查询记录集合（不分页 不带排序 不级联查询）
		 * @param queryMap 查询条件集合		
		 * @return
		 */
		public List<MedicalReportEntity> getListByCondition(Map<String,Object> queryMap) {
		    List<MedicalReportEntity> returnlist = null;
			List<Object> list = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
			QueryCondition qc = changeMapToQc(queryMap);  			
						            list = dbManager.queryByCondition(MedicalReportEntity.class,qc);    
            if(list!=null&&list.size()>0){
               returnlist = new ArrayList<MedicalReportEntity>();
               for (Object obj:list) {           
                 returnlist.add((MedicalReportEntity)obj);
               }
            }       					
			return returnlist;
		}
		
		
		/**
		 * 根据条件查询记录集合（不分页 带排序 带级联查询）
		 * @param queryMap 查询条件集合
		 * @param orderList 排序条件集合
		 		 * @return
		 */
		public List<MedicalReportEntity> getListByCondition(Map<String,Object> queryMap,List<OrderVO> orderList) {
			List<MedicalReportEntity> returnlist = null;
			List<Object> list = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
			QueryCondition qc = changeMapToQc(queryMap); 
									OrderByCondition oc = null;
			if(orderList!=null&&orderList.size()>0){
				for(int i=0;i<orderList.size();i++){
					OrderVO order = orderList.get(i);
					String orderColumnt =null;
					String orderType=null;
					if(order.getName()!=null&&!"".equals(order.getName())){
						orderColumnt = StringUtil.formatFieldToColumnt(order.getName());
						orderType = order.getOrderType();
						if(orderType==null||"".equals(orderType.trim())){
							orderType=OrderByCondition.desc;
						}
						if(i==0){
							oc = new OrderByCondition(orderColumnt,orderType);
						}else{
							oc.orderByCondition(new OrderByCondition(orderColumnt,orderType));
						}					
					}
					
				}
			}			
            list = dbManager.queryByConditions(MedicalReportEntity.class,qc,oc);
                        					    			if(list!=null&&list.size()>0){
               returnlist = new ArrayList<MedicalReportEntity>();
               for (Object obj:list) {           
                 returnlist.add((MedicalReportEntity)obj);
               }
            }       					
			return returnlist;
		}
		
		/**
		 * 根据条件查询记录集合（带分页 不带排序 不级联查询）
		 * @param queryMap 查询条件集合
		 * @param pageno 查询页码
		 * @param pagesize 查询每页记录条数		
		 * @return
		 */
		public PageList getListByCondition(Map<String,Object> queryMap,int pageno,int pagesize) {
			PageList pagelist = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
			QueryCondition qc = changeMapToQc(queryMap); 
						            pagelist = dbManager.queryByCondition(MedicalReportEntity.class,qc,pageno,pagesize);	                      			
			return pagelist;
		}
		
		/**
		 * 根据条件查询记录集合（带分页 带排序 带级联查询）
		 * @param queryMap 查询条件集合
		 * @param orderList 排序条件集合
		 * @param pageno 查询页码
		 * @param pagesize 查询每页记录条数
		 		 * @return
		 */
		public PageList getListByCondition(Map<String,Object> queryMap,List<OrderVO> orderList,int pageno,int pagesize) {
			PageList pagelist = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
			QueryCondition qc = changeMapToQc(queryMap); 
									OrderByCondition oc = null;
			if(orderList!=null&&orderList.size()>0){
				for(int i=0;i<orderList.size();i++){
					OrderVO order = orderList.get(i);
					String orderColumnt =null;
					String orderType=null;
					if(order.getName()!=null&&!"".equals(order.getName())){
						orderColumnt = StringUtil.formatFieldToColumnt(order.getName());
						orderType = order.getOrderType();
						if(orderType==null||"".equals(orderType.trim())){
							orderType=OrderByCondition.desc;
						}
						if(i==0){
							oc = new OrderByCondition(orderColumnt,orderType);
						}else{
							oc.orderByCondition(new OrderByCondition(orderColumnt,orderType));
						}					
					}
					
				}
			}		
			//数据权限
			List<QueryCondition> dataRuleQclist = null;
			List<Map<String, Object>> dataRuleMapList = (List<Map<String, Object>>)queryMap.get("dataRuleMapList");
			if(dataRuleMapList!=null&&dataRuleMapList.size()>0){
				dataRuleQclist = new ArrayList<QueryCondition>();
				for(Map<String, Object> dataRuleMap:dataRuleMapList){
					QueryCondition dataRuleQc = changeMapToQc(dataRuleMap);	
					dataRuleQclist.add(dataRuleQc);
				}
			}
            pagelist = dbManager.queryByConditions(MedicalReportEntity.class,qc,dataRuleQclist,oc,pageno,pagesize);	           
                        					    			return pagelist;
		}
		
		/**
		 * 删除记录
		 * 
		 * @param id 主键
		 * @param obj
		 */
		public boolean del(Integer id) {
			boolean result = false;
			if (id !=null&&id>0) {
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					tx.beginTransaction(); 					
										result = dbManager.delNoTransaction(id, MedicalReportEntity.class);
					tx.commitAndClose(); 
				}catch (Exception e) { 
					 logger.error("数据库提交失败！");
					 logger.error(e);
					 result = false;
				     try {
						   tx.rollbackAndClose();
					 } catch (Exception ex) {					   
						   logger.error("数据库回滚失败！");
						   logger.error(ex);
					 }   
				}  
			}
			return result;
		}
		
		/**
		 * 批量删除记录
		 * 
		 * @param ids
		 *            主键 英文逗号间隔
		 * @param obj
		 */
		public boolean del(String ids) {
			boolean result = false;
			if (ids != null && !"".equals(ids.trim())) {
				TransactionManager tx = DbUtils.getTranManager();
				try {
					tx.beginTransaction();
					QueryCondition qc = new QueryCondition(MedicalReportEntity.ID,QueryCondition.in, ids);
					result = dbManager.delByConditionsNoTransaction(MedicalReportEntity.class, qc);
					tx.commitAndClose();
				} catch (Exception e) {
					logger.error("数据库提交失败！");
					logger.error(e);
					result = false;
					try {
						tx.rollbackAndClose();
					} catch (Exception ex) {
						logger.error("数据库回滚失败！");
						logger.error(ex);
					}
				}
			}
			return result;
		}

		/**
		 * 批量条件删除记录
		 * @param queryMap 查询条件集合
		 */
		public boolean delList(Map<String,Object> queryMap) {
			boolean result = false;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
			QueryCondition qc = changeMapToQc(queryMap);   
									if (qc.getQueryNextCondition()!=null) {
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					tx.beginTransaction(); 						
										result = dbManager.delByConditionsNoTransaction(MedicalReportEntity.class,qc);				
					tx.commitAndClose();  
				}catch (Exception e) { 
					 logger.error("数据库提交失败！");
					 logger.error(e);
					 result = false;
				     try {
						   tx.rollbackAndClose();
					 } catch (Exception ex) {					   
						   logger.error("数据库回滚失败！");
						   logger.error(ex);
					 }   
				}  
			}
			return result;
		}
		
	private QueryCondition changeMapToQc(Map<String, Object> queryMap) {	
											Object id=queryMap.get("id");
					Object id_gt=queryMap.get("id_gt");
					Object id_ge=queryMap.get("id_ge");
					Object id_lt=queryMap.get("id_lt");
					Object id_le=queryMap.get("id_le");
					Object id_in=queryMap.get("id_in");
																					Object medicalReportNum=queryMap.get("medicalReportNum");
					Object medicalReportNum_like=queryMap.get("medicalReportNum_like");
					Object medicalReportNum_isNull=queryMap.get("medicalReportNum_isNull");
					Object medicalReportNum_isNotNull=queryMap.get("medicalReportNum_isNotNull");
					Object medicalReportNum_in=queryMap.get("medicalReportNum_in");
																										Object medicalReportStatus=queryMap.get("medicalReportStatus");
					Object medicalReportStatus_like=queryMap.get("medicalReportStatus_like");
					Object medicalReportStatus_isNull=queryMap.get("medicalReportStatus_isNull");
					Object medicalReportStatus_isNotNull=queryMap.get("medicalReportStatus_isNotNull");
					Object medicalReportStatus_in=queryMap.get("medicalReportStatus_in");
																										Object medicalReportExpress=queryMap.get("medicalReportExpress");
					Object medicalReportExpress_like=queryMap.get("medicalReportExpress_like");
					Object medicalReportExpress_isNull=queryMap.get("medicalReportExpress_isNull");
					Object medicalReportExpress_isNotNull=queryMap.get("medicalReportExpress_isNotNull");
					Object medicalReportExpress_in=queryMap.get("medicalReportExpress_in");
																										Object medicalReportExpressOrderNum=queryMap.get("medicalReportExpressOrderNum");
					Object medicalReportExpressOrderNum_like=queryMap.get("medicalReportExpressOrderNum_like");
					Object medicalReportExpressOrderNum_isNull=queryMap.get("medicalReportExpressOrderNum_isNull");
					Object medicalReportExpressOrderNum_isNotNull=queryMap.get("medicalReportExpressOrderNum_isNotNull");
					Object medicalReportExpressOrderNum_in=queryMap.get("medicalReportExpressOrderNum_in");
																										Object medicalReportCreateTime_gt=queryMap.get("medicalReportCreateTime_gt");
					Object medicalReportCreateTime_ge=queryMap.get("medicalReportCreateTime_ge");
					Object medicalReportCreateTime_lt=queryMap.get("medicalReportCreateTime_lt");
					Object medicalReportCreateTime_le=queryMap.get("medicalReportCreateTime_le");
																										Object medicalPersonName=queryMap.get("medicalPersonName");
					Object medicalPersonName_like=queryMap.get("medicalPersonName_like");
					Object medicalPersonName_isNull=queryMap.get("medicalPersonName_isNull");
					Object medicalPersonName_isNotNull=queryMap.get("medicalPersonName_isNotNull");
					Object medicalPersonName_in=queryMap.get("medicalPersonName_in");
																										Object medicalPersonGender=queryMap.get("medicalPersonGender");
					Object medicalPersonGender_like=queryMap.get("medicalPersonGender_like");
					Object medicalPersonGender_isNull=queryMap.get("medicalPersonGender_isNull");
					Object medicalPersonGender_isNotNull=queryMap.get("medicalPersonGender_isNotNull");
					Object medicalPersonGender_in=queryMap.get("medicalPersonGender_in");
																										Object medicalPersonCardNum=queryMap.get("medicalPersonCardNum");
					Object medicalPersonCardNum_like=queryMap.get("medicalPersonCardNum_like");
					Object medicalPersonCardNum_isNull=queryMap.get("medicalPersonCardNum_isNull");
					Object medicalPersonCardNum_isNotNull=queryMap.get("medicalPersonCardNum_isNotNull");
					Object medicalPersonCardNum_in=queryMap.get("medicalPersonCardNum_in");
																					Object medicalPersonAge=queryMap.get("medicalPersonAge");
					Object medicalPersonAge_gt=queryMap.get("medicalPersonAge_gt");
					Object medicalPersonAge_ge=queryMap.get("medicalPersonAge_ge");
					Object medicalPersonAge_lt=queryMap.get("medicalPersonAge_lt");
					Object medicalPersonAge_le=queryMap.get("medicalPersonAge_le");
					Object medicalPersonAge_in=queryMap.get("medicalPersonAge_in");
																					Object medicalReportContent=queryMap.get("medicalReportContent");
					Object medicalReportContent_like=queryMap.get("medicalReportContent_like");
					Object medicalReportContent_isNull=queryMap.get("medicalReportContent_isNull");
					Object medicalReportContent_isNotNull=queryMap.get("medicalReportContent_isNotNull");
					Object medicalReportContent_in=queryMap.get("medicalReportContent_in");
																										Object medicalHospital=queryMap.get("medicalHospital");
					Object medicalHospital_like=queryMap.get("medicalHospital_like");
					Object medicalHospital_isNull=queryMap.get("medicalHospital_isNull");
					Object medicalHospital_isNotNull=queryMap.get("medicalHospital_isNotNull");
					Object medicalHospital_in=queryMap.get("medicalHospital_in");
												
			

						
			
			QueryCondition qc = new QueryCondition(MedicalReportEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.ID, QueryCondition.in, id_in));}
															  					if(medicalReportNum!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_NUM, QueryCondition.eq, medicalReportNum));}
		            if(medicalReportNum_like!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_NUM, QueryCondition.like, medicalReportNum_like));}
		            if(medicalReportNum_isNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_NUM, QueryCondition.isNull, medicalReportNum_isNull));}
		            if(medicalReportNum_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_NUM, QueryCondition.isNotNull, medicalReportNum_isNotNull));}
				    if(medicalReportNum_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_NUM, QueryCondition.in, medicalReportNum_in));}
				  															  					if(medicalReportStatus!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_STATUS, QueryCondition.eq, medicalReportStatus));}
		            if(medicalReportStatus_like!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_STATUS, QueryCondition.like, medicalReportStatus_like));}
		            if(medicalReportStatus_isNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_STATUS, QueryCondition.isNull, medicalReportStatus_isNull));}
		            if(medicalReportStatus_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_STATUS, QueryCondition.isNotNull, medicalReportStatus_isNotNull));}
				    if(medicalReportStatus_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_STATUS, QueryCondition.in, medicalReportStatus_in));}
				  															  					if(medicalReportExpress!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_EXPRESS, QueryCondition.eq, medicalReportExpress));}
		            if(medicalReportExpress_like!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_EXPRESS, QueryCondition.like, medicalReportExpress_like));}
		            if(medicalReportExpress_isNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_EXPRESS, QueryCondition.isNull, medicalReportExpress_isNull));}
		            if(medicalReportExpress_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_EXPRESS, QueryCondition.isNotNull, medicalReportExpress_isNotNull));}
				    if(medicalReportExpress_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_EXPRESS, QueryCondition.in, medicalReportExpress_in));}
				  															  					if(medicalReportExpressOrderNum!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_EXPRESS_ORDER_NUM, QueryCondition.eq, medicalReportExpressOrderNum));}
		            if(medicalReportExpressOrderNum_like!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_EXPRESS_ORDER_NUM, QueryCondition.like, medicalReportExpressOrderNum_like));}
		            if(medicalReportExpressOrderNum_isNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_EXPRESS_ORDER_NUM, QueryCondition.isNull, medicalReportExpressOrderNum_isNull));}
		            if(medicalReportExpressOrderNum_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_EXPRESS_ORDER_NUM, QueryCondition.isNotNull, medicalReportExpressOrderNum_isNotNull));}
				    if(medicalReportExpressOrderNum_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_EXPRESS_ORDER_NUM, QueryCondition.in, medicalReportExpressOrderNum_in));}
				  															  					if(medicalReportCreateTime_gt!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_CREATE_TIME, QueryCondition.gt, medicalReportCreateTime_gt));}
					if(medicalReportCreateTime_ge!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_CREATE_TIME, QueryCondition.ge, medicalReportCreateTime_ge));}
					if(medicalReportCreateTime_lt!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_CREATE_TIME, QueryCondition.lt, medicalReportCreateTime_lt));}
					if(medicalReportCreateTime_le!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_CREATE_TIME, QueryCondition.le, medicalReportCreateTime_le));}
				  															  					if(medicalPersonName!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_NAME, QueryCondition.eq, medicalPersonName));}
		            if(medicalPersonName_like!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_NAME, QueryCondition.like, medicalPersonName_like));}
		            if(medicalPersonName_isNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_NAME, QueryCondition.isNull, medicalPersonName_isNull));}
		            if(medicalPersonName_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_NAME, QueryCondition.isNotNull, medicalPersonName_isNotNull));}
				    if(medicalPersonName_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_NAME, QueryCondition.in, medicalPersonName_in));}
				  															  					if(medicalPersonGender!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_GENDER, QueryCondition.eq, medicalPersonGender));}
		            if(medicalPersonGender_like!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_GENDER, QueryCondition.like, medicalPersonGender_like));}
		            if(medicalPersonGender_isNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_GENDER, QueryCondition.isNull, medicalPersonGender_isNull));}
		            if(medicalPersonGender_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_GENDER, QueryCondition.isNotNull, medicalPersonGender_isNotNull));}
				    if(medicalPersonGender_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_GENDER, QueryCondition.in, medicalPersonGender_in));}
				  															  					if(medicalPersonCardNum!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_CARD_NUM, QueryCondition.eq, medicalPersonCardNum));}
		            if(medicalPersonCardNum_like!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_CARD_NUM, QueryCondition.like, medicalPersonCardNum_like));}
		            if(medicalPersonCardNum_isNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_CARD_NUM, QueryCondition.isNull, medicalPersonCardNum_isNull));}
		            if(medicalPersonCardNum_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_CARD_NUM, QueryCondition.isNotNull, medicalPersonCardNum_isNotNull));}
				    if(medicalPersonCardNum_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_CARD_NUM, QueryCondition.in, medicalPersonCardNum_in));}
				  																if(medicalPersonAge!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.eq, medicalPersonAge));}
					if(medicalPersonAge_gt!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.gt, medicalPersonAge_gt));}
					if(medicalPersonAge_ge!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.ge, medicalPersonAge_ge));}
					if(medicalPersonAge_lt!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.lt, medicalPersonAge_lt));}
					if(medicalPersonAge_le!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.le, medicalPersonAge_le));}
					if(medicalPersonAge_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.in, medicalPersonAge_in));}
															  					if(medicalReportContent!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_CONTENT, QueryCondition.eq, medicalReportContent));}
		            if(medicalReportContent_like!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_CONTENT, QueryCondition.like, medicalReportContent_like));}
		            if(medicalReportContent_isNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_CONTENT, QueryCondition.isNull, medicalReportContent_isNull));}
		            if(medicalReportContent_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_CONTENT, QueryCondition.isNotNull, medicalReportContent_isNotNull));}
				    if(medicalReportContent_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_REPORT_CONTENT, QueryCondition.in, medicalReportContent_in));}
				  															  					if(medicalHospital!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_HOSPITAL, QueryCondition.eq, medicalHospital));}
		            if(medicalHospital_like!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_HOSPITAL, QueryCondition.like, medicalHospital_like));}
		            if(medicalHospital_isNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_HOSPITAL, QueryCondition.isNull, medicalHospital_isNull));}
		            if(medicalHospital_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_HOSPITAL, QueryCondition.isNotNull, medicalHospital_isNotNull));}
				    if(medicalHospital_in!=null){qc.andCondition(new QueryCondition(MedicalReportEntity.MEDICAL_HOSPITAL, QueryCondition.in, medicalHospital_in));}
				  										return qc; 
	}
		
		
}
