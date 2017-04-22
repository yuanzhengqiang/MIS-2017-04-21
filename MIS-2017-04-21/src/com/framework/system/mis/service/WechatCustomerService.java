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
import com.framework.system.mis.entity.WechatCustomerEntity;
import com.framework.system.util.StringUtil;



/**   
 * @Title: Service
 * @Description: 微信客户表服务类
 * @author feng.gu
 * @date 2017-04-21 17:29:44
 * @version V1.0   
 *
 */
public class WechatCustomerService {
	   private static Logger logger = Logger.getLogger(WechatCustomerService.class);
	   private DBManager dbManager = DBManager.getInstance();
    		
	   private static WechatCustomerService wechatCustomerService;
	   /**
	    * 获取实例	
	    * @return
	    */
	   public static WechatCustomerService getInstance(){
		if(wechatCustomerService==null){
			wechatCustomerService = new WechatCustomerService();
		}
		return wechatCustomerService;
	   }
	                 	                 				     				     				     				     
				     	 
	   /**
		 * 保存记录
		 * 
		 * @param obj
		 */
		public boolean save(WechatCustomerEntity wechatCustomer) {			
			boolean result =false;
			if(wechatCustomer!=null){
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					 tx.beginTransaction();					 					 
					 					 result=dbManager.saveNoTransaction(wechatCustomer);	
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
		public boolean saveList(List<WechatCustomerEntity> wechatCustomerList) {
			boolean result = false;
			if (wechatCustomerList != null && wechatCustomerList.size() > 0) {
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					tx.beginTransaction(); 
					for(WechatCustomerEntity wechatCustomer:wechatCustomerList){
						if(wechatCustomer!=null){												  								 
								 								 result=dbManager.saveNoTransaction(wechatCustomer);								 			
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
		public WechatCustomerEntity getById(Integer id) {
			WechatCustomerEntity obj = null;
			if (id!=null) {
				obj = (WechatCustomerEntity)dbManager.getById(id, WechatCustomerEntity.class);
							}
			return obj;
		}
		
		/**
		 * 根据条件查询记录集合（不分页 不带排序 不级联查询）
		 * @param queryMap 查询条件集合		
		 * @return
		 */
		public List<WechatCustomerEntity> getListByCondition(Map<String,Object> queryMap) {
		    List<WechatCustomerEntity> returnlist = null;
			List<Object> list = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
			QueryCondition qc = changeMapToQc(queryMap);  			
						            list = dbManager.queryByCondition(WechatCustomerEntity.class,qc);    
            if(list!=null&&list.size()>0){
               returnlist = new ArrayList<WechatCustomerEntity>();
               for (Object obj:list) {           
                 returnlist.add((WechatCustomerEntity)obj);
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
		public List<WechatCustomerEntity> getListByCondition(Map<String,Object> queryMap,List<OrderVO> orderList) {
			List<WechatCustomerEntity> returnlist = null;
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
            list = dbManager.queryByConditions(WechatCustomerEntity.class,qc,oc);
                        					    			if(list!=null&&list.size()>0){
               returnlist = new ArrayList<WechatCustomerEntity>();
               for (Object obj:list) {           
                 returnlist.add((WechatCustomerEntity)obj);
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
						            pagelist = dbManager.queryByCondition(WechatCustomerEntity.class,qc,pageno,pagesize);	                      			
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
            pagelist = dbManager.queryByConditions(WechatCustomerEntity.class,qc,dataRuleQclist,oc,pageno,pagesize);	           
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
										result = dbManager.delNoTransaction(id, WechatCustomerEntity.class);
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
					QueryCondition qc = new QueryCondition(WechatCustomerEntity.ID,QueryCondition.in, ids);
					result = dbManager.delByConditionsNoTransaction(WechatCustomerEntity.class, qc);
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
										result = dbManager.delByConditionsNoTransaction(WechatCustomerEntity.class,qc);				
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
																					Object openId=queryMap.get("openId");
					Object openId_like=queryMap.get("openId_like");
					Object openId_isNull=queryMap.get("openId_isNull");
					Object openId_isNotNull=queryMap.get("openId_isNotNull");
					Object openId_in=queryMap.get("openId_in");
																										Object nakeName=queryMap.get("nakeName");
					Object nakeName_like=queryMap.get("nakeName_like");
					Object nakeName_isNull=queryMap.get("nakeName_isNull");
					Object nakeName_isNotNull=queryMap.get("nakeName_isNotNull");
					Object nakeName_in=queryMap.get("nakeName_in");
																										Object noteName=queryMap.get("noteName");
					Object noteName_like=queryMap.get("noteName_like");
					Object noteName_isNull=queryMap.get("noteName_isNull");
					Object noteName_isNotNull=queryMap.get("noteName_isNotNull");
					Object noteName_in=queryMap.get("noteName_in");
																										Object gender=queryMap.get("gender");
					Object gender_like=queryMap.get("gender_like");
					Object gender_isNull=queryMap.get("gender_isNull");
					Object gender_isNotNull=queryMap.get("gender_isNotNull");
					Object gender_in=queryMap.get("gender_in");
																										Object country=queryMap.get("country");
					Object country_like=queryMap.get("country_like");
					Object country_isNull=queryMap.get("country_isNull");
					Object country_isNotNull=queryMap.get("country_isNotNull");
					Object country_in=queryMap.get("country_in");
																										Object province=queryMap.get("province");
					Object province_like=queryMap.get("province_like");
					Object province_isNull=queryMap.get("province_isNull");
					Object province_isNotNull=queryMap.get("province_isNotNull");
					Object province_in=queryMap.get("province_in");
																										Object city=queryMap.get("city");
					Object city_like=queryMap.get("city_like");
					Object city_isNull=queryMap.get("city_isNull");
					Object city_isNotNull=queryMap.get("city_isNotNull");
					Object city_in=queryMap.get("city_in");
																										Object updateTime_gt=queryMap.get("updateTime_gt");
					Object updateTime_ge=queryMap.get("updateTime_ge");
					Object updateTime_lt=queryMap.get("updateTime_lt");
					Object updateTime_le=queryMap.get("updateTime_le");
												
			

						
			
			QueryCondition qc = new QueryCondition(WechatCustomerEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.ID, QueryCondition.in, id_in));}
															  					if(openId!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.OPEN_ID, QueryCondition.eq, openId));}
		            if(openId_like!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.OPEN_ID, QueryCondition.like, openId_like));}
		            if(openId_isNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.OPEN_ID, QueryCondition.isNull, openId_isNull));}
		            if(openId_isNotNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.OPEN_ID, QueryCondition.isNotNull, openId_isNotNull));}
				    if(openId_in!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.OPEN_ID, QueryCondition.in, openId_in));}
				  															  					if(nakeName!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.NAKE_NAME, QueryCondition.eq, nakeName));}
		            if(nakeName_like!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.NAKE_NAME, QueryCondition.like, nakeName_like));}
		            if(nakeName_isNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.NAKE_NAME, QueryCondition.isNull, nakeName_isNull));}
		            if(nakeName_isNotNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.NAKE_NAME, QueryCondition.isNotNull, nakeName_isNotNull));}
				    if(nakeName_in!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.NAKE_NAME, QueryCondition.in, nakeName_in));}
				  															  					if(noteName!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.NOTE_NAME, QueryCondition.eq, noteName));}
		            if(noteName_like!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.NOTE_NAME, QueryCondition.like, noteName_like));}
		            if(noteName_isNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.NOTE_NAME, QueryCondition.isNull, noteName_isNull));}
		            if(noteName_isNotNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.NOTE_NAME, QueryCondition.isNotNull, noteName_isNotNull));}
				    if(noteName_in!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.NOTE_NAME, QueryCondition.in, noteName_in));}
				  															  					if(gender!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.GENDER, QueryCondition.eq, gender));}
		            if(gender_like!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.GENDER, QueryCondition.like, gender_like));}
		            if(gender_isNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.GENDER, QueryCondition.isNull, gender_isNull));}
		            if(gender_isNotNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.GENDER, QueryCondition.isNotNull, gender_isNotNull));}
				    if(gender_in!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.GENDER, QueryCondition.in, gender_in));}
				  															  					if(country!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.COUNTRY, QueryCondition.eq, country));}
		            if(country_like!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.COUNTRY, QueryCondition.like, country_like));}
		            if(country_isNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.COUNTRY, QueryCondition.isNull, country_isNull));}
		            if(country_isNotNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.COUNTRY, QueryCondition.isNotNull, country_isNotNull));}
				    if(country_in!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.COUNTRY, QueryCondition.in, country_in));}
				  															  					if(province!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.PROVINCE, QueryCondition.eq, province));}
		            if(province_like!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.PROVINCE, QueryCondition.like, province_like));}
		            if(province_isNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.PROVINCE, QueryCondition.isNull, province_isNull));}
		            if(province_isNotNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.PROVINCE, QueryCondition.isNotNull, province_isNotNull));}
				    if(province_in!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.PROVINCE, QueryCondition.in, province_in));}
				  															  					if(city!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.CITY, QueryCondition.eq, city));}
		            if(city_like!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.CITY, QueryCondition.like, city_like));}
		            if(city_isNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.CITY, QueryCondition.isNull, city_isNull));}
		            if(city_isNotNull!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.CITY, QueryCondition.isNotNull, city_isNotNull));}
				    if(city_in!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.CITY, QueryCondition.in, city_in));}
				  															  					if(updateTime_gt!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.UPDATE_TIME, QueryCondition.gt, updateTime_gt));}
					if(updateTime_ge!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.UPDATE_TIME, QueryCondition.ge, updateTime_ge));}
					if(updateTime_lt!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.UPDATE_TIME, QueryCondition.lt, updateTime_lt));}
					if(updateTime_le!=null){qc.andCondition(new QueryCondition(WechatCustomerEntity.UPDATE_TIME, QueryCondition.le, updateTime_le));}
				  										return qc; 
	}
		
		
}
