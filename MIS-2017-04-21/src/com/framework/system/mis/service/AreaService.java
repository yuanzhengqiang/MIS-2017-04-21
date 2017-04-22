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
import com.framework.system.mis.entity.AreaEntity;
import com.framework.system.util.StringUtil;



/**   
 * @Title: Service
 * @Description: 区域表服务类
 * @author feng.gu
 * @date 2017-04-21 16:26:10
 * @version V1.0   
 *
 */
public class AreaService {
	   private static Logger logger = Logger.getLogger(AreaService.class);
	   private DBManager dbManager = DBManager.getInstance();
    		
	   private static AreaService areaService;
	   /**
	    * 获取实例	
	    * @return
	    */
	   public static AreaService getInstance(){
		if(areaService==null){
			areaService = new AreaService();
		}
		return areaService;
	   }
	                 	                 				     				     				     				     
				     	 
	   /**
		 * 保存记录
		 * 
		 * @param obj
		 */
		public boolean save(AreaEntity area) {			
			boolean result =false;
			if(area!=null){
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					 tx.beginTransaction();					 					 
					 					 result=dbManager.saveNoTransaction(area);	
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
		public boolean saveList(List<AreaEntity> areaList) {
			boolean result = false;
			if (areaList != null && areaList.size() > 0) {
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					tx.beginTransaction(); 
					for(AreaEntity area:areaList){
						if(area!=null){												  								 
								 								 result=dbManager.saveNoTransaction(area);								 			
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
		public AreaEntity getById(Integer id) {
			AreaEntity obj = null;
			if (id!=null) {
				obj = (AreaEntity)dbManager.getById(id, AreaEntity.class);
							}
			return obj;
		}
		
		/**
		 * 根据条件查询记录集合（不分页 不带排序 不级联查询）
		 * @param queryMap 查询条件集合		
		 * @return
		 */
		public List<AreaEntity> getListByCondition(Map<String,Object> queryMap) {
		    List<AreaEntity> returnlist = null;
			List<Object> list = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
			QueryCondition qc = changeMapToQc(queryMap);  			
						            list = dbManager.queryByCondition(AreaEntity.class,qc);    
            if(list!=null&&list.size()>0){
               returnlist = new ArrayList<AreaEntity>();
               for (Object obj:list) {           
                 returnlist.add((AreaEntity)obj);
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
		public List<AreaEntity> getListByCondition(Map<String,Object> queryMap,List<OrderVO> orderList) {
			List<AreaEntity> returnlist = null;
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
            list = dbManager.queryByConditions(AreaEntity.class,qc,oc);
                        					    			if(list!=null&&list.size()>0){
               returnlist = new ArrayList<AreaEntity>();
               for (Object obj:list) {           
                 returnlist.add((AreaEntity)obj);
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
						            pagelist = dbManager.queryByCondition(AreaEntity.class,qc,pageno,pagesize);	                      			
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
            pagelist = dbManager.queryByConditions(AreaEntity.class,qc,dataRuleQclist,oc,pageno,pagesize);	           
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
										result = dbManager.delNoTransaction(id, AreaEntity.class);
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
					QueryCondition qc = new QueryCondition(AreaEntity.ID,QueryCondition.in, ids);
					result = dbManager.delByConditionsNoTransaction(AreaEntity.class, qc);
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
										result = dbManager.delByConditionsNoTransaction(AreaEntity.class,qc);				
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
																					Object area=queryMap.get("area");
					Object area_like=queryMap.get("area_like");
					Object area_isNull=queryMap.get("area_isNull");
					Object area_isNotNull=queryMap.get("area_isNotNull");
					Object area_in=queryMap.get("area_in");
																										Object updateTime_gt=queryMap.get("updateTime_gt");
					Object updateTime_ge=queryMap.get("updateTime_ge");
					Object updateTime_lt=queryMap.get("updateTime_lt");
					Object updateTime_le=queryMap.get("updateTime_le");
												
			

						
			
			QueryCondition qc = new QueryCondition(AreaEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(AreaEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(AreaEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(AreaEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(AreaEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(AreaEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(AreaEntity.ID, QueryCondition.in, id_in));}
															  					if(area!=null){qc.andCondition(new QueryCondition(AreaEntity.AREA, QueryCondition.eq, area));}
		            if(area_like!=null){qc.andCondition(new QueryCondition(AreaEntity.AREA, QueryCondition.like, area_like));}
		            if(area_isNull!=null){qc.andCondition(new QueryCondition(AreaEntity.AREA, QueryCondition.isNull, area_isNull));}
		            if(area_isNotNull!=null){qc.andCondition(new QueryCondition(AreaEntity.AREA, QueryCondition.isNotNull, area_isNotNull));}
				    if(area_in!=null){qc.andCondition(new QueryCondition(AreaEntity.AREA, QueryCondition.in, area_in));}
				  															  					if(updateTime_gt!=null){qc.andCondition(new QueryCondition(AreaEntity.UPDATE_TIME, QueryCondition.gt, updateTime_gt));}
					if(updateTime_ge!=null){qc.andCondition(new QueryCondition(AreaEntity.UPDATE_TIME, QueryCondition.ge, updateTime_ge));}
					if(updateTime_lt!=null){qc.andCondition(new QueryCondition(AreaEntity.UPDATE_TIME, QueryCondition.lt, updateTime_lt));}
					if(updateTime_le!=null){qc.andCondition(new QueryCondition(AreaEntity.UPDATE_TIME, QueryCondition.le, updateTime_le));}
				  										return qc; 
	}
		
		
}
