package mis.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import mis.entity.MenuEntity;

import org.apache.log4j.Logger;




import com.framework.system.db.connect.DbUtils;
import com.framework.system.db.manager.DBManager;
import com.framework.system.db.query.PageList;
import com.framework.system.db.query.QueryCondition;
import com.framework.system.db.query.OrderByCondition;
import com.framework.system.db.query.OrderVO;
import com.framework.system.db.transaction.TransactionManager;
import com.framework.system.util.StringUtil;



/**   
 * @Title: Service
 * @Description: 微信菜单表服务类
 * @author feng.gu
 * @date 2017-05-03 21:03:26
 * @version V1.0   
 *
 */
public class MenuService {
	   private static Logger logger = Logger.getLogger(MenuService.class);
	   private DBManager dbManager = DBManager.getInstance();
    		
	   private static MenuService menuService;
	   /**
	    * 获取实例	
	    * @return
	    */
	   public static MenuService getInstance(){
		if(menuService==null){
			menuService = new MenuService();
		}
		return menuService;
	   }
	                 	                 				     				     				     				     
				     	 
	   /**
		 * 保存记录
		 * 
		 * @param obj
		 */
		public boolean save(MenuEntity menu) {			
			boolean result =false;
			if(menu!=null){
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					 tx.beginTransaction();					 					 
					 					 result=dbManager.saveNoTransaction(menu);	
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
		public boolean saveList(List<MenuEntity> menuList) {
			boolean result = false;
			if (menuList != null && menuList.size() > 0) {
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					tx.beginTransaction(); 
					for(MenuEntity menu:menuList){
						if(menu!=null){												  								 
								 								 result=dbManager.saveNoTransaction(menu);								 			
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
		public MenuEntity getById(Integer id) {
			MenuEntity obj = null;
			if (id!=null) {
				obj = (MenuEntity)dbManager.getById(id, MenuEntity.class);
							}
			return obj;
		}
		
		/**
		 * 根据条件查询记录集合（不分页 不带排序 不级联查询）
		 * @param queryMap 查询条件集合		
		 * @return
		 */
		public List<MenuEntity> getListByCondition(Map<String,Object> queryMap) {
		    List<MenuEntity> returnlist = null;
			List<Object> list = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
			QueryCondition qc = changeMapToQc(queryMap);  			
						            list = dbManager.queryByCondition(MenuEntity.class,qc);    
            if(list!=null&&list.size()>0){
               returnlist = new ArrayList<MenuEntity>();
               for (Object obj:list) {           
                 returnlist.add((MenuEntity)obj);
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
		public List<MenuEntity> getListByCondition(Map<String,Object> queryMap,List<OrderVO> orderList) {
			List<MenuEntity> returnlist = null;
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
            list = dbManager.queryByConditions(MenuEntity.class,qc,oc);
                        					    			if(list!=null&&list.size()>0){
               returnlist = new ArrayList<MenuEntity>();
               for (Object obj:list) {           
                 returnlist.add((MenuEntity)obj);
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
						            pagelist = dbManager.queryByCondition(MenuEntity.class,qc,pageno,pagesize);	                      			
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
            pagelist = dbManager.queryByConditions(MenuEntity.class,qc,dataRuleQclist,oc,pageno,pagesize);	           
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
										result = dbManager.delNoTransaction(id, MenuEntity.class);
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
					QueryCondition qc = new QueryCondition(MenuEntity.ID,QueryCondition.in, ids);
					result = dbManager.delByConditionsNoTransaction(MenuEntity.class, qc);
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
										result = dbManager.delByConditionsNoTransaction(MenuEntity.class,qc);				
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
																					Object name=queryMap.get("name");
					Object name_like=queryMap.get("name_like");
					Object name_isNull=queryMap.get("name_isNull");
					Object name_isNotNull=queryMap.get("name_isNotNull");
					Object name_in=queryMap.get("name_in");
																					Object orderColumn=queryMap.get("orderColumn");
					Object orderColumn_gt=queryMap.get("orderColumn_gt");
					Object orderColumn_ge=queryMap.get("orderColumn_ge");
					Object orderColumn_lt=queryMap.get("orderColumn_lt");
					Object orderColumn_le=queryMap.get("orderColumn_le");
					Object orderColumn_in=queryMap.get("orderColumn_in");
																Object parentId=queryMap.get("parentId");
					Object parentId_gt=queryMap.get("parentId_gt");
					Object parentId_ge=queryMap.get("parentId_ge");
					Object parentId_lt=queryMap.get("parentId_lt");
					Object parentId_le=queryMap.get("parentId_le");
					Object parentId_in=queryMap.get("parentId_in");
																					Object address=queryMap.get("address");
					Object address_like=queryMap.get("address_like");
					Object address_isNull=queryMap.get("address_isNull");
					Object address_isNotNull=queryMap.get("address_isNotNull");
					Object address_in=queryMap.get("address_in");
																										Object createTime_gt=queryMap.get("createTime_gt");
					Object createTime_ge=queryMap.get("createTime_ge");
					Object createTime_lt=queryMap.get("createTime_lt");
					Object createTime_le=queryMap.get("createTime_le");
																					Object addressType=queryMap.get("addressType");
					Object addressType_gt=queryMap.get("addressType_gt");
					Object addressType_ge=queryMap.get("addressType_ge");
					Object addressType_lt=queryMap.get("addressType_lt");
					Object addressType_le=queryMap.get("addressType_le");
					Object addressType_in=queryMap.get("addressType_in");
							
			

						
			
			QueryCondition qc = new QueryCondition(MenuEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(MenuEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(MenuEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(MenuEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(MenuEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(MenuEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(MenuEntity.ID, QueryCondition.in, id_in));}
															  					if(name!=null){qc.andCondition(new QueryCondition(MenuEntity.NAME, QueryCondition.eq, name));}
		            if(name_like!=null){qc.andCondition(new QueryCondition(MenuEntity.NAME, QueryCondition.like, name_like));}
		            if(name_isNull!=null){qc.andCondition(new QueryCondition(MenuEntity.NAME, QueryCondition.isNull, name_isNull));}
		            if(name_isNotNull!=null){qc.andCondition(new QueryCondition(MenuEntity.NAME, QueryCondition.isNotNull, name_isNotNull));}
				    if(name_in!=null){qc.andCondition(new QueryCondition(MenuEntity.NAME, QueryCondition.in, name_in));}
				  																if(orderColumn!=null){qc.andCondition(new QueryCondition(MenuEntity.ORDER_COLUMN, QueryCondition.eq, orderColumn));}
					if(orderColumn_gt!=null){qc.andCondition(new QueryCondition(MenuEntity.ORDER_COLUMN, QueryCondition.gt, orderColumn_gt));}
					if(orderColumn_ge!=null){qc.andCondition(new QueryCondition(MenuEntity.ORDER_COLUMN, QueryCondition.ge, orderColumn_ge));}
					if(orderColumn_lt!=null){qc.andCondition(new QueryCondition(MenuEntity.ORDER_COLUMN, QueryCondition.lt, orderColumn_lt));}
					if(orderColumn_le!=null){qc.andCondition(new QueryCondition(MenuEntity.ORDER_COLUMN, QueryCondition.le, orderColumn_le));}
					if(orderColumn_in!=null){qc.andCondition(new QueryCondition(MenuEntity.ORDER_COLUMN, QueryCondition.in, orderColumn_in));}
																if(parentId!=null){qc.andCondition(new QueryCondition(MenuEntity.PARENT_ID, QueryCondition.eq, parentId));}
					if(parentId_gt!=null){qc.andCondition(new QueryCondition(MenuEntity.PARENT_ID, QueryCondition.gt, parentId_gt));}
					if(parentId_ge!=null){qc.andCondition(new QueryCondition(MenuEntity.PARENT_ID, QueryCondition.ge, parentId_ge));}
					if(parentId_lt!=null){qc.andCondition(new QueryCondition(MenuEntity.PARENT_ID, QueryCondition.lt, parentId_lt));}
					if(parentId_le!=null){qc.andCondition(new QueryCondition(MenuEntity.PARENT_ID, QueryCondition.le, parentId_le));}
					if(parentId_in!=null){qc.andCondition(new QueryCondition(MenuEntity.PARENT_ID, QueryCondition.in, parentId_in));}
															  					if(address!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS, QueryCondition.eq, address));}
		            if(address_like!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS, QueryCondition.like, address_like));}
		            if(address_isNull!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS, QueryCondition.isNull, address_isNull));}
		            if(address_isNotNull!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS, QueryCondition.isNotNull, address_isNotNull));}
				    if(address_in!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS, QueryCondition.in, address_in));}
				  															  					if(createTime_gt!=null){qc.andCondition(new QueryCondition(MenuEntity.CREATE_TIME, QueryCondition.gt, createTime_gt));}
					if(createTime_ge!=null){qc.andCondition(new QueryCondition(MenuEntity.CREATE_TIME, QueryCondition.ge, createTime_ge));}
					if(createTime_lt!=null){qc.andCondition(new QueryCondition(MenuEntity.CREATE_TIME, QueryCondition.lt, createTime_lt));}
					if(createTime_le!=null){qc.andCondition(new QueryCondition(MenuEntity.CREATE_TIME, QueryCondition.le, createTime_le));}
				  																if(addressType!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS_TYPE, QueryCondition.eq, addressType));}
					if(addressType_gt!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS_TYPE, QueryCondition.gt, addressType_gt));}
					if(addressType_ge!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS_TYPE, QueryCondition.ge, addressType_ge));}
					if(addressType_lt!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS_TYPE, QueryCondition.lt, addressType_lt));}
					if(addressType_le!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS_TYPE, QueryCondition.le, addressType_le));}
					if(addressType_in!=null){qc.andCondition(new QueryCondition(MenuEntity.ADDRESS_TYPE, QueryCondition.in, addressType_in));}
										return qc; 
	}
		
		
}
