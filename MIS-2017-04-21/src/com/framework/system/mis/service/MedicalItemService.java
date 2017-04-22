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
import com.framework.system.mis.entity.MedicalItemEntity;
import com.framework.system.util.StringUtil;



/**   
 * @Title: Service
 * @Description: 体检项目表服务类
 * @author feng.gu
 * @date 2017-04-21 16:09:59
 * @version V1.0   
 *
 */
public class MedicalItemService {
	   private static Logger logger = Logger.getLogger(MedicalItemService.class);
	   private DBManager dbManager = DBManager.getInstance();
    		
	   private static MedicalItemService medicalItemService;
	   /**
	    * 获取实例	
	    * @return
	    */
	   public static MedicalItemService getInstance(){
		if(medicalItemService==null){
			medicalItemService = new MedicalItemService();
		}
		return medicalItemService;
	   }
	                 	                 				     				     				     				     
				     	 
	   /**
		 * 保存记录
		 * 
		 * @param obj
		 */
		public boolean save(MedicalItemEntity medicalItem) {			
			boolean result =false;
			if(medicalItem!=null){
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					 tx.beginTransaction();					 					 
					 					 result=dbManager.saveNoTransaction(medicalItem);	
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
		public boolean saveList(List<MedicalItemEntity> medicalItemList) {
			boolean result = false;
			if (medicalItemList != null && medicalItemList.size() > 0) {
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					tx.beginTransaction(); 
					for(MedicalItemEntity medicalItem:medicalItemList){
						if(medicalItem!=null){												  								 
								 								 result=dbManager.saveNoTransaction(medicalItem);								 			
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
		public MedicalItemEntity getById(Integer id) {
			MedicalItemEntity obj = null;
			if (id!=null) {
				obj = (MedicalItemEntity)dbManager.getById(id, MedicalItemEntity.class);
							}
			return obj;
		}
		
		/**
		 * 根据条件查询记录集合（不分页 不带排序 不级联查询）
		 * @param queryMap 查询条件集合		
		 * @return
		 */
		public List<MedicalItemEntity> getListByCondition(Map<String,Object> queryMap) {
		    List<MedicalItemEntity> returnlist = null;
			List<Object> list = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
			QueryCondition qc = changeMapToQc(queryMap);  			
						            list = dbManager.queryByCondition(MedicalItemEntity.class,qc);    
            if(list!=null&&list.size()>0){
               returnlist = new ArrayList<MedicalItemEntity>();
               for (Object obj:list) {           
                 returnlist.add((MedicalItemEntity)obj);
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
		public List<MedicalItemEntity> getListByCondition(Map<String,Object> queryMap,List<OrderVO> orderList) {
			List<MedicalItemEntity> returnlist = null;
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
            list = dbManager.queryByConditions(MedicalItemEntity.class,qc,oc);
                        					    			if(list!=null&&list.size()>0){
               returnlist = new ArrayList<MedicalItemEntity>();
               for (Object obj:list) {           
                 returnlist.add((MedicalItemEntity)obj);
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
						            pagelist = dbManager.queryByCondition(MedicalItemEntity.class,qc,pageno,pagesize);	                      			
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
            pagelist = dbManager.queryByConditions(MedicalItemEntity.class,qc,dataRuleQclist,oc,pageno,pagesize);	           
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
										result = dbManager.delNoTransaction(id, MedicalItemEntity.class);
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
					QueryCondition qc = new QueryCondition(MedicalItemEntity.ID,QueryCondition.in, ids);
					result = dbManager.delByConditionsNoTransaction(MedicalItemEntity.class, qc);
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
										result = dbManager.delByConditionsNoTransaction(MedicalItemEntity.class,qc);				
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
																					Object itemName=queryMap.get("itemName");
					Object itemName_like=queryMap.get("itemName_like");
					Object itemName_isNull=queryMap.get("itemName_isNull");
					Object itemName_isNotNull=queryMap.get("itemName_isNotNull");
					Object itemName_in=queryMap.get("itemName_in");
																					Object category=queryMap.get("category");
					Object category_gt=queryMap.get("category_gt");
					Object category_ge=queryMap.get("category_ge");
					Object category_lt=queryMap.get("category_lt");
					Object category_le=queryMap.get("category_le");
					Object category_in=queryMap.get("category_in");
																					Object testWay=queryMap.get("testWay");
					Object testWay_like=queryMap.get("testWay_like");
					Object testWay_isNull=queryMap.get("testWay_isNull");
					Object testWay_isNotNull=queryMap.get("testWay_isNotNull");
					Object testWay_in=queryMap.get("testWay_in");
																										Object testPurpose=queryMap.get("testPurpose");
					Object testPurpose_like=queryMap.get("testPurpose_like");
					Object testPurpose_isNull=queryMap.get("testPurpose_isNull");
					Object testPurpose_isNotNull=queryMap.get("testPurpose_isNotNull");
					Object testPurpose_in=queryMap.get("testPurpose_in");
																										Object selectDes=queryMap.get("selectDes");
					Object selectDes_like=queryMap.get("selectDes_like");
					Object selectDes_isNull=queryMap.get("selectDes_isNull");
					Object selectDes_isNotNull=queryMap.get("selectDes_isNotNull");
					Object selectDes_in=queryMap.get("selectDes_in");
																										Object price=queryMap.get("price");
					Object price_like=queryMap.get("price_like");
					Object price_isNull=queryMap.get("price_isNull");
					Object price_isNotNull=queryMap.get("price_isNotNull");
					Object price_in=queryMap.get("price_in");
																										Object des=queryMap.get("des");
					Object des_like=queryMap.get("des_like");
					Object des_isNull=queryMap.get("des_isNull");
					Object des_isNotNull=queryMap.get("des_isNotNull");
					Object des_in=queryMap.get("des_in");
																										Object mattersNeedAttention=queryMap.get("mattersNeedAttention");
					Object mattersNeedAttention_like=queryMap.get("mattersNeedAttention_like");
					Object mattersNeedAttention_isNull=queryMap.get("mattersNeedAttention_isNull");
					Object mattersNeedAttention_isNotNull=queryMap.get("mattersNeedAttention_isNotNull");
					Object mattersNeedAttention_in=queryMap.get("mattersNeedAttention_in");
												
			

						
			
			QueryCondition qc = new QueryCondition(MedicalItemEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ID, QueryCondition.in, id_in));}
															  					if(itemName!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ITEM_NAME, QueryCondition.eq, itemName));}
		            if(itemName_like!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ITEM_NAME, QueryCondition.like, itemName_like));}
		            if(itemName_isNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ITEM_NAME, QueryCondition.isNull, itemName_isNull));}
		            if(itemName_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ITEM_NAME, QueryCondition.isNotNull, itemName_isNotNull));}
				    if(itemName_in!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.ITEM_NAME, QueryCondition.in, itemName_in));}
				  																if(category!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.CATEGORY, QueryCondition.eq, category));}
					if(category_gt!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.CATEGORY, QueryCondition.gt, category_gt));}
					if(category_ge!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.CATEGORY, QueryCondition.ge, category_ge));}
					if(category_lt!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.CATEGORY, QueryCondition.lt, category_lt));}
					if(category_le!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.CATEGORY, QueryCondition.le, category_le));}
					if(category_in!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.CATEGORY, QueryCondition.in, category_in));}
															  					if(testWay!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.TEST_WAY, QueryCondition.eq, testWay));}
		            if(testWay_like!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.TEST_WAY, QueryCondition.like, testWay_like));}
		            if(testWay_isNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.TEST_WAY, QueryCondition.isNull, testWay_isNull));}
		            if(testWay_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.TEST_WAY, QueryCondition.isNotNull, testWay_isNotNull));}
				    if(testWay_in!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.TEST_WAY, QueryCondition.in, testWay_in));}
				  															  					if(testPurpose!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.TEST_PURPOSE, QueryCondition.eq, testPurpose));}
		            if(testPurpose_like!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.TEST_PURPOSE, QueryCondition.like, testPurpose_like));}
		            if(testPurpose_isNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.TEST_PURPOSE, QueryCondition.isNull, testPurpose_isNull));}
		            if(testPurpose_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.TEST_PURPOSE, QueryCondition.isNotNull, testPurpose_isNotNull));}
				    if(testPurpose_in!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.TEST_PURPOSE, QueryCondition.in, testPurpose_in));}
				  															  					if(selectDes!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.SELECT_DES, QueryCondition.eq, selectDes));}
		            if(selectDes_like!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.SELECT_DES, QueryCondition.like, selectDes_like));}
		            if(selectDes_isNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.SELECT_DES, QueryCondition.isNull, selectDes_isNull));}
		            if(selectDes_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.SELECT_DES, QueryCondition.isNotNull, selectDes_isNotNull));}
				    if(selectDes_in!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.SELECT_DES, QueryCondition.in, selectDes_in));}
				  															  					if(price!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.PRICE, QueryCondition.eq, price));}
		            if(price_like!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.PRICE, QueryCondition.like, price_like));}
		            if(price_isNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.PRICE, QueryCondition.isNull, price_isNull));}
		            if(price_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.PRICE, QueryCondition.isNotNull, price_isNotNull));}
				    if(price_in!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.PRICE, QueryCondition.in, price_in));}
				  															  					if(des!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.DES, QueryCondition.eq, des));}
		            if(des_like!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.DES, QueryCondition.like, des_like));}
		            if(des_isNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.DES, QueryCondition.isNull, des_isNull));}
		            if(des_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.DES, QueryCondition.isNotNull, des_isNotNull));}
				    if(des_in!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.DES, QueryCondition.in, des_in));}
				  															  					if(mattersNeedAttention!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.MATTERS_NEED_ATTENTION, QueryCondition.eq, mattersNeedAttention));}
		            if(mattersNeedAttention_like!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.MATTERS_NEED_ATTENTION, QueryCondition.like, mattersNeedAttention_like));}
		            if(mattersNeedAttention_isNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.MATTERS_NEED_ATTENTION, QueryCondition.isNull, mattersNeedAttention_isNull));}
		            if(mattersNeedAttention_isNotNull!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.MATTERS_NEED_ATTENTION, QueryCondition.isNotNull, mattersNeedAttention_isNotNull));}
				    if(mattersNeedAttention_in!=null){qc.andCondition(new QueryCondition(MedicalItemEntity.MATTERS_NEED_ATTENTION, QueryCondition.in, mattersNeedAttention_in));}
				  										return qc; 
	}
		
		
}
