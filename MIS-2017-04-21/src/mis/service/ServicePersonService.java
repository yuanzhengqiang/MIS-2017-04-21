package mis.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import mis.entity.ServicePersonEntity;

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
 * @Description: 服务人员表服务类
 * @author feng.gu
 * @date 2017-04-21 16:22:00
 * @version V1.0   
 *
 */
public class ServicePersonService {
	   private static Logger logger = Logger.getLogger(ServicePersonService.class);
	   private DBManager dbManager = DBManager.getInstance();
    		
	   private static ServicePersonService servicePersonService;
	   /**
	    * 获取实例	
	    * @return
	    */
	   public static ServicePersonService getInstance(){
		if(servicePersonService==null){
			servicePersonService = new ServicePersonService();
		}
		return servicePersonService;
	   }
	                 	                 				     				     				     				     
				     	 
	   /**
		 * 保存记录
		 * 
		 * @param obj
		 */
		public boolean save(ServicePersonEntity servicePerson) {			
			boolean result =false;
			if(servicePerson!=null){
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					 tx.beginTransaction();					 					 
					 					 result=dbManager.saveNoTransaction(servicePerson);	
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
		public boolean saveList(List<ServicePersonEntity> servicePersonList) {
			boolean result = false;
			if (servicePersonList != null && servicePersonList.size() > 0) {
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					tx.beginTransaction(); 
					for(ServicePersonEntity servicePerson:servicePersonList){
						if(servicePerson!=null){												  								 
								 								 result=dbManager.saveNoTransaction(servicePerson);								 			
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
		public ServicePersonEntity getById(Integer id) {
			ServicePersonEntity obj = null;
			if (id!=null) {
				obj = (ServicePersonEntity)dbManager.getById(id, ServicePersonEntity.class);
							}
			return obj;
		}
		
		/**
		 * 根据条件查询记录集合（不分页 不带排序 不级联查询）
		 * @param queryMap 查询条件集合		
		 * @return
		 */
		public List<ServicePersonEntity> getListByCondition(Map<String,Object> queryMap) {
		    List<ServicePersonEntity> returnlist = null;
			List<Object> list = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
			QueryCondition qc = changeMapToQc(queryMap);  			
						            list = dbManager.queryByCondition(ServicePersonEntity.class,qc);    
            if(list!=null&&list.size()>0){
               returnlist = new ArrayList<ServicePersonEntity>();
               for (Object obj:list) {           
                 returnlist.add((ServicePersonEntity)obj);
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
		public List<ServicePersonEntity> getListByCondition(Map<String,Object> queryMap,List<OrderVO> orderList) {
			List<ServicePersonEntity> returnlist = null;
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
            list = dbManager.queryByConditions(ServicePersonEntity.class,qc,oc);
                        					    			if(list!=null&&list.size()>0){
               returnlist = new ArrayList<ServicePersonEntity>();
               for (Object obj:list) {           
                 returnlist.add((ServicePersonEntity)obj);
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
						            pagelist = dbManager.queryByCondition(ServicePersonEntity.class,qc,pageno,pagesize);	                      			
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
            pagelist = dbManager.queryByConditions(ServicePersonEntity.class,qc,dataRuleQclist,oc,pageno,pagesize);	           
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
										result = dbManager.delNoTransaction(id, ServicePersonEntity.class);
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
					QueryCondition qc = new QueryCondition(ServicePersonEntity.ID,QueryCondition.in, ids);
					result = dbManager.delByConditionsNoTransaction(ServicePersonEntity.class, qc);
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
										result = dbManager.delByConditionsNoTransaction(ServicePersonEntity.class,qc);				
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
																										Object gender=queryMap.get("gender");
					Object gender_like=queryMap.get("gender_like");
					Object gender_isNull=queryMap.get("gender_isNull");
					Object gender_isNotNull=queryMap.get("gender_isNotNull");
					Object gender_in=queryMap.get("gender_in");
																										Object headPortrait=queryMap.get("headPortrait");
					Object headPortrait_like=queryMap.get("headPortrait_like");
					Object headPortrait_isNull=queryMap.get("headPortrait_isNull");
					Object headPortrait_isNotNull=queryMap.get("headPortrait_isNotNull");
					Object headPortrait_in=queryMap.get("headPortrait_in");
																										Object birthday=queryMap.get("birthday");
					Object birthday_like=queryMap.get("birthday_like");
					Object birthday_isNull=queryMap.get("birthday_isNull");
					Object birthday_isNotNull=queryMap.get("birthday_isNotNull");
					Object birthday_in=queryMap.get("birthday_in");
																										Object academic=queryMap.get("academic");
					Object academic_like=queryMap.get("academic_like");
					Object academic_isNull=queryMap.get("academic_isNull");
					Object academic_isNotNull=queryMap.get("academic_isNotNull");
					Object academic_in=queryMap.get("academic_in");
																										Object contact=queryMap.get("contact");
					Object contact_like=queryMap.get("contact_like");
					Object contact_isNull=queryMap.get("contact_isNull");
					Object contact_isNotNull=queryMap.get("contact_isNotNull");
					Object contact_in=queryMap.get("contact_in");
																										Object wechatNum=queryMap.get("wechatNum");
					Object wechatNum_like=queryMap.get("wechatNum_like");
					Object wechatNum_isNull=queryMap.get("wechatNum_isNull");
					Object wechatNum_isNotNull=queryMap.get("wechatNum_isNotNull");
					Object wechatNum_in=queryMap.get("wechatNum_in");
																										Object wechatQrCode=queryMap.get("wechatQrCode");
					Object wechatQrCode_like=queryMap.get("wechatQrCode_like");
					Object wechatQrCode_isNull=queryMap.get("wechatQrCode_isNull");
					Object wechatQrCode_isNotNull=queryMap.get("wechatQrCode_isNotNull");
					Object wechatQrCode_in=queryMap.get("wechatQrCode_in");
												
			

						
			
			QueryCondition qc = new QueryCondition(ServicePersonEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ID, QueryCondition.in, id_in));}
															  					if(name!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.NAME, QueryCondition.eq, name));}
		            if(name_like!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.NAME, QueryCondition.like, name_like));}
		            if(name_isNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.NAME, QueryCondition.isNull, name_isNull));}
		            if(name_isNotNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.NAME, QueryCondition.isNotNull, name_isNotNull));}
				    if(name_in!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.NAME, QueryCondition.in, name_in));}
				  															  					if(gender!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.GENDER, QueryCondition.eq, gender));}
		            if(gender_like!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.GENDER, QueryCondition.like, gender_like));}
		            if(gender_isNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.GENDER, QueryCondition.isNull, gender_isNull));}
		            if(gender_isNotNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.GENDER, QueryCondition.isNotNull, gender_isNotNull));}
				    if(gender_in!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.GENDER, QueryCondition.in, gender_in));}
				  															  					if(headPortrait!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.HEAD_PORTRAIT, QueryCondition.eq, headPortrait));}
		            if(headPortrait_like!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.HEAD_PORTRAIT, QueryCondition.like, headPortrait_like));}
		            if(headPortrait_isNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.HEAD_PORTRAIT, QueryCondition.isNull, headPortrait_isNull));}
		            if(headPortrait_isNotNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.HEAD_PORTRAIT, QueryCondition.isNotNull, headPortrait_isNotNull));}
				    if(headPortrait_in!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.HEAD_PORTRAIT, QueryCondition.in, headPortrait_in));}
				  															  					if(birthday!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.BIRTHDAY, QueryCondition.eq, birthday));}
		            if(birthday_like!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.BIRTHDAY, QueryCondition.like, birthday_like));}
		            if(birthday_isNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.BIRTHDAY, QueryCondition.isNull, birthday_isNull));}
		            if(birthday_isNotNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.BIRTHDAY, QueryCondition.isNotNull, birthday_isNotNull));}
				    if(birthday_in!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.BIRTHDAY, QueryCondition.in, birthday_in));}
				  															  					if(academic!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ACADEMIC, QueryCondition.eq, academic));}
		            if(academic_like!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ACADEMIC, QueryCondition.like, academic_like));}
		            if(academic_isNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ACADEMIC, QueryCondition.isNull, academic_isNull));}
		            if(academic_isNotNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ACADEMIC, QueryCondition.isNotNull, academic_isNotNull));}
				    if(academic_in!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.ACADEMIC, QueryCondition.in, academic_in));}
				  															  					if(contact!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.CONTACT, QueryCondition.eq, contact));}
		            if(contact_like!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.CONTACT, QueryCondition.like, contact_like));}
		            if(contact_isNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.CONTACT, QueryCondition.isNull, contact_isNull));}
		            if(contact_isNotNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.CONTACT, QueryCondition.isNotNull, contact_isNotNull));}
				    if(contact_in!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.CONTACT, QueryCondition.in, contact_in));}
				  															  					if(wechatNum!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.WECHAT_NUM, QueryCondition.eq, wechatNum));}
		            if(wechatNum_like!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.WECHAT_NUM, QueryCondition.like, wechatNum_like));}
		            if(wechatNum_isNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.WECHAT_NUM, QueryCondition.isNull, wechatNum_isNull));}
		            if(wechatNum_isNotNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.WECHAT_NUM, QueryCondition.isNotNull, wechatNum_isNotNull));}
				    if(wechatNum_in!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.WECHAT_NUM, QueryCondition.in, wechatNum_in));}
				  															  					if(wechatQrCode!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.WECHAT_QR_CODE, QueryCondition.eq, wechatQrCode));}
		            if(wechatQrCode_like!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.WECHAT_QR_CODE, QueryCondition.like, wechatQrCode_like));}
		            if(wechatQrCode_isNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.WECHAT_QR_CODE, QueryCondition.isNull, wechatQrCode_isNull));}
		            if(wechatQrCode_isNotNull!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.WECHAT_QR_CODE, QueryCondition.isNotNull, wechatQrCode_isNotNull));}
				    if(wechatQrCode_in!=null){qc.andCondition(new QueryCondition(ServicePersonEntity.WECHAT_QR_CODE, QueryCondition.in, wechatQrCode_in));}
				  										return qc; 
	}
		
		
}
