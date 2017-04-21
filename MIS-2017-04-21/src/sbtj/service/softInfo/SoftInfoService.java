package sbtj.service.softInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import sbtj.entity.softInfo.SoftInfoEntity;

import com.framework.system.db.connect.DbUtils;
import com.framework.system.db.manager.DBManager;
import com.framework.system.db.query.OrderByCondition;
import com.framework.system.db.query.OrderVO;
import com.framework.system.db.query.PageList;
import com.framework.system.db.query.QueryCondition;
import com.framework.system.db.transaction.TransactionManager;
import com.framework.system.util.StringUtil;



/**   
 * @Title: Service
 * @Description: 软件版本管理服务类
 * @author feng.gu
 * @date 2016-07-27 16:18:42
 * @version V1.0   
 *
 */
public class SoftInfoService {
	   private static Logger logger = Logger.getLogger(SoftInfoService.class);
	   private DBManager dbManager = DBManager.getInstance();
    		
	   private static SoftInfoService softInfoService;
	   /**
	    * 获取实例	
	    * @return
	    */
	   public static SoftInfoService getInstance(){
		if(softInfoService==null){
			softInfoService = new SoftInfoService();
		}
		return softInfoService;
	   }
	                 	                 				     				     				     				     
				     	 
	   /**
		 * 保存记录
		 * 
		 * @param obj
		 */
		public boolean save(SoftInfoEntity softInfo) {			
			boolean result =false;
			if(softInfo!=null){
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					 tx.beginTransaction();					 					 
					 					 result=dbManager.saveNoTransaction(softInfo);	
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
		public boolean saveList(List<SoftInfoEntity> softInfoList) {
			boolean result = false;
			if (softInfoList != null && softInfoList.size() > 0) {
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					tx.beginTransaction(); 
					for(SoftInfoEntity softInfo:softInfoList){
						if(softInfo!=null){												  								 
								 								 result=dbManager.saveNoTransaction(softInfo);								 			
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
		public SoftInfoEntity getById(Integer id) {
			SoftInfoEntity obj = null;
			if (id!=null) {
				obj = (SoftInfoEntity)dbManager.getById(id, SoftInfoEntity.class);
							}
			return obj;
		}
		
		/**
		 * 根据条件查询记录集合（不分页 不带排序 不级联查询）
		 * @param queryMap 查询条件集合		
		 * @return
		 */
		public List<SoftInfoEntity> getListByCondition(Map<String,Object> queryMap) {
		    List<SoftInfoEntity> returnlist = null;
			List<Object> list = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
												Object id=queryMap.get("id");
					Object id_gt=queryMap.get("id_gt");
					Object id_ge=queryMap.get("id_ge");
					Object id_lt=queryMap.get("id_lt");
					Object id_le=queryMap.get("id_le");
					Object id_in=queryMap.get("id_in");
																					Object softName=queryMap.get("softName");
					Object softName_like=queryMap.get("softName_like");
					Object softName_isNull=queryMap.get("softName_isNull");
					Object softName_isNotNull=queryMap.get("softName_isNotNull");
					Object softName_in=queryMap.get("softName_in");
																										Object softVersion=queryMap.get("softVersion");
					Object softVersion_like=queryMap.get("softVersion_like");
					Object softVersion_isNull=queryMap.get("softVersion_isNull");
					Object softVersion_isNotNull=queryMap.get("softVersion_isNotNull");
					Object softVersion_in=queryMap.get("softVersion_in");
																										Object softCode=queryMap.get("softCode");
					Object softCode_like=queryMap.get("softCode_like");
					Object softCode_isNull=queryMap.get("softCode_isNull");
					Object softCode_isNotNull=queryMap.get("softCode_isNotNull");
					Object softCode_in=queryMap.get("softCode_in");
																										Object updateLog_gt=queryMap.get("updateLog_gt");
					Object updateLog_ge=queryMap.get("updateLog_ge");
					Object updateLog_lt=queryMap.get("updateLog_lt");
					Object updateLog_le=queryMap.get("updateLog_le");
																					Object mandatoryUpdate=queryMap.get("mandatoryUpdate");
					Object mandatoryUpdate_gt=queryMap.get("mandatoryUpdate_gt");
					Object mandatoryUpdate_ge=queryMap.get("mandatoryUpdate_ge");
					Object mandatoryUpdate_lt=queryMap.get("mandatoryUpdate_lt");
					Object mandatoryUpdate_le=queryMap.get("mandatoryUpdate_le");
					Object mandatoryUpdate_in=queryMap.get("mandatoryUpdate_in");
																					Object updateUrl_gt=queryMap.get("updateUrl_gt");
					Object updateUrl_ge=queryMap.get("updateUrl_ge");
					Object updateUrl_lt=queryMap.get("updateUrl_lt");
					Object updateUrl_le=queryMap.get("updateUrl_le");
																										Object lastVersion=queryMap.get("lastVersion");
					Object lastVersion_like=queryMap.get("lastVersion_like");
					Object lastVersion_isNull=queryMap.get("lastVersion_isNull");
					Object lastVersion_isNotNull=queryMap.get("lastVersion_isNotNull");
					Object lastVersion_in=queryMap.get("lastVersion_in");
																										Object redundantField1=queryMap.get("redundantField1");
					Object redundantField1_like=queryMap.get("redundantField1_like");
					Object redundantField1_isNull=queryMap.get("redundantField1_isNull");
					Object redundantField1_isNotNull=queryMap.get("redundantField1_isNotNull");
					Object redundantField1_in=queryMap.get("redundantField1_in");
																										Object redundantField2=queryMap.get("redundantField2");
					Object redundantField2_like=queryMap.get("redundantField2_like");
					Object redundantField2_isNull=queryMap.get("redundantField2_isNull");
					Object redundantField2_isNotNull=queryMap.get("redundantField2_isNotNull");
					Object redundantField2_in=queryMap.get("redundantField2_in");
												
			

						
			
			QueryCondition qc = new QueryCondition(SoftInfoEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.in, id_in));}
															  					if(softName!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.eq, softName));}
		            if(softName_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.like, softName_like));}
		            if(softName_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.isNull, softName_isNull));}
		            if(softName_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.isNotNull, softName_isNotNull));}
				    if(softName_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.in, softName_in));}
				  															  					if(softVersion!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.eq, softVersion));}
		            if(softVersion_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.like, softVersion_like));}
		            if(softVersion_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.isNull, softVersion_isNull));}
		            if(softVersion_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.isNotNull, softVersion_isNotNull));}
				    if(softVersion_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.in, softVersion_in));}
				  															  					if(softCode!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.eq, softCode));}
		            if(softCode_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.like, softCode_like));}
		            if(softCode_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.isNull, softCode_isNull));}
		            if(softCode_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.isNotNull, softCode_isNotNull));}
				    if(softCode_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.in, softCode_in));}
				  															  					if(updateLog_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.gt, updateLog_gt));}
					if(updateLog_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.ge, updateLog_ge));}
					if(updateLog_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.lt, updateLog_lt));}
					if(updateLog_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.le, updateLog_le));}
				  																if(mandatoryUpdate!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.eq, mandatoryUpdate));}
					if(mandatoryUpdate_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.gt, mandatoryUpdate_gt));}
					if(mandatoryUpdate_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.ge, mandatoryUpdate_ge));}
					if(mandatoryUpdate_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.lt, mandatoryUpdate_lt));}
					if(mandatoryUpdate_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.le, mandatoryUpdate_le));}
					if(mandatoryUpdate_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.in, mandatoryUpdate_in));}
															  					if(updateUrl_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.gt, updateUrl_gt));}
					if(updateUrl_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.ge, updateUrl_ge));}
					if(updateUrl_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.lt, updateUrl_lt));}
					if(updateUrl_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.le, updateUrl_le));}
				  															  					if(lastVersion!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.eq, lastVersion));}
		            if(lastVersion_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.like, lastVersion_like));}
		            if(lastVersion_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.isNull, lastVersion_isNull));}
		            if(lastVersion_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.isNotNull, lastVersion_isNotNull));}
				    if(lastVersion_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.in, lastVersion_in));}
				  															  					if(redundantField1!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.eq, redundantField1));}
		            if(redundantField1_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.like, redundantField1_like));}
		            if(redundantField1_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.isNull, redundantField1_isNull));}
		            if(redundantField1_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.isNotNull, redundantField1_isNotNull));}
				    if(redundantField1_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.in, redundantField1_in));}
				  															  					if(redundantField2!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.eq, redundantField2));}
		            if(redundantField2_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.like, redundantField2_like));}
		            if(redundantField2_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.isNull, redundantField2_isNull));}
		            if(redundantField2_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.isNotNull, redundantField2_isNotNull));}
				    if(redundantField2_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.in, redundantField2_in));}
				  										
			            list = dbManager.queryByCondition(SoftInfoEntity.class,qc);    
            if(list!=null&&list.size()>0){
               returnlist = new ArrayList<SoftInfoEntity>();
               for (Object obj:list) {           
                 returnlist.add((SoftInfoEntity)obj);
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
		public List<SoftInfoEntity> getListByCondition(Map<String,Object> queryMap,List<OrderVO> orderList) {
			List<SoftInfoEntity> returnlist = null;
			List<Object> list = null;
			if(queryMap==null){
				queryMap = new HashMap<String,Object>();
			}
												Object id=queryMap.get("id");
					Object id_gt=queryMap.get("id_gt");
					Object id_ge=queryMap.get("id_ge");
					Object id_lt=queryMap.get("id_lt");
					Object id_le=queryMap.get("id_le");
					Object id_in=queryMap.get("id_in");
																					Object softName=queryMap.get("softName");
					Object softName_like=queryMap.get("softName_like");
					Object softName_isNull=queryMap.get("softName_isNull");
					Object softName_isNotNull=queryMap.get("softName_isNotNull");
					Object softName_in=queryMap.get("softName_in");
																										Object softVersion=queryMap.get("softVersion");
					Object softVersion_like=queryMap.get("softVersion_like");
					Object softVersion_isNull=queryMap.get("softVersion_isNull");
					Object softVersion_isNotNull=queryMap.get("softVersion_isNotNull");
					Object softVersion_in=queryMap.get("softVersion_in");
																										Object softCode=queryMap.get("softCode");
					Object softCode_like=queryMap.get("softCode_like");
					Object softCode_isNull=queryMap.get("softCode_isNull");
					Object softCode_isNotNull=queryMap.get("softCode_isNotNull");
					Object softCode_in=queryMap.get("softCode_in");
																										Object updateLog_gt=queryMap.get("updateLog_gt");
					Object updateLog_ge=queryMap.get("updateLog_ge");
					Object updateLog_lt=queryMap.get("updateLog_lt");
					Object updateLog_le=queryMap.get("updateLog_le");
																					Object mandatoryUpdate=queryMap.get("mandatoryUpdate");
					Object mandatoryUpdate_gt=queryMap.get("mandatoryUpdate_gt");
					Object mandatoryUpdate_ge=queryMap.get("mandatoryUpdate_ge");
					Object mandatoryUpdate_lt=queryMap.get("mandatoryUpdate_lt");
					Object mandatoryUpdate_le=queryMap.get("mandatoryUpdate_le");
					Object mandatoryUpdate_in=queryMap.get("mandatoryUpdate_in");
																					Object updateUrl_gt=queryMap.get("updateUrl_gt");
					Object updateUrl_ge=queryMap.get("updateUrl_ge");
					Object updateUrl_lt=queryMap.get("updateUrl_lt");
					Object updateUrl_le=queryMap.get("updateUrl_le");
																										Object lastVersion=queryMap.get("lastVersion");
					Object lastVersion_like=queryMap.get("lastVersion_like");
					Object lastVersion_isNull=queryMap.get("lastVersion_isNull");
					Object lastVersion_isNotNull=queryMap.get("lastVersion_isNotNull");
					Object lastVersion_in=queryMap.get("lastVersion_in");
																										Object redundantField1=queryMap.get("redundantField1");
					Object redundantField1_like=queryMap.get("redundantField1_like");
					Object redundantField1_isNull=queryMap.get("redundantField1_isNull");
					Object redundantField1_isNotNull=queryMap.get("redundantField1_isNotNull");
					Object redundantField1_in=queryMap.get("redundantField1_in");
																										Object redundantField2=queryMap.get("redundantField2");
					Object redundantField2_like=queryMap.get("redundantField2_like");
					Object redundantField2_isNull=queryMap.get("redundantField2_isNull");
					Object redundantField2_isNotNull=queryMap.get("redundantField2_isNotNull");
					Object redundantField2_in=queryMap.get("redundantField2_in");
												
			

						
			
			QueryCondition qc = new QueryCondition(SoftInfoEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.in, id_in));}
															  					if(softName!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.eq, softName));}
		            if(softName_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.like, softName_like));}
		            if(softName_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.isNull, softName_isNull));}
		            if(softName_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.isNotNull, softName_isNotNull));}
				    if(softName_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.in, softName_in));}
				  															  					if(softVersion!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.eq, softVersion));}
		            if(softVersion_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.like, softVersion_like));}
		            if(softVersion_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.isNull, softVersion_isNull));}
		            if(softVersion_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.isNotNull, softVersion_isNotNull));}
				    if(softVersion_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.in, softVersion_in));}
				  															  					if(softCode!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.eq, softCode));}
		            if(softCode_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.like, softCode_like));}
		            if(softCode_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.isNull, softCode_isNull));}
		            if(softCode_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.isNotNull, softCode_isNotNull));}
				    if(softCode_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.in, softCode_in));}
				  															  					if(updateLog_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.gt, updateLog_gt));}
					if(updateLog_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.ge, updateLog_ge));}
					if(updateLog_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.lt, updateLog_lt));}
					if(updateLog_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.le, updateLog_le));}
				  																if(mandatoryUpdate!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.eq, mandatoryUpdate));}
					if(mandatoryUpdate_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.gt, mandatoryUpdate_gt));}
					if(mandatoryUpdate_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.ge, mandatoryUpdate_ge));}
					if(mandatoryUpdate_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.lt, mandatoryUpdate_lt));}
					if(mandatoryUpdate_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.le, mandatoryUpdate_le));}
					if(mandatoryUpdate_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.in, mandatoryUpdate_in));}
															  					if(updateUrl_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.gt, updateUrl_gt));}
					if(updateUrl_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.ge, updateUrl_ge));}
					if(updateUrl_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.lt, updateUrl_lt));}
					if(updateUrl_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.le, updateUrl_le));}
				  															  					if(lastVersion!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.eq, lastVersion));}
		            if(lastVersion_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.like, lastVersion_like));}
		            if(lastVersion_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.isNull, lastVersion_isNull));}
		            if(lastVersion_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.isNotNull, lastVersion_isNotNull));}
				    if(lastVersion_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.in, lastVersion_in));}
				  															  					if(redundantField1!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.eq, redundantField1));}
		            if(redundantField1_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.like, redundantField1_like));}
		            if(redundantField1_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.isNull, redundantField1_isNull));}
		            if(redundantField1_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.isNotNull, redundantField1_isNotNull));}
				    if(redundantField1_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.in, redundantField1_in));}
				  															  					if(redundantField2!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.eq, redundantField2));}
		            if(redundantField2_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.like, redundantField2_like));}
		            if(redundantField2_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.isNull, redundantField2_isNull));}
		            if(redundantField2_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.isNotNull, redundantField2_isNotNull));}
				    if(redundantField2_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.in, redundantField2_in));}
				  										
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
            list = dbManager.queryByConditions(SoftInfoEntity.class,qc,oc);
                        					    			if(list!=null&&list.size()>0){
               returnlist = new ArrayList<SoftInfoEntity>();
               for (Object obj:list) {           
                 returnlist.add((SoftInfoEntity)obj);
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
												Object id=queryMap.get("id");
					Object id_gt=queryMap.get("id_gt");
					Object id_ge=queryMap.get("id_ge");
					Object id_lt=queryMap.get("id_lt");
					Object id_le=queryMap.get("id_le");
					Object id_in=queryMap.get("id_in");
															  					Object softName=queryMap.get("softName");
					Object softName_like=queryMap.get("softName_like");
					Object softName_isNull=queryMap.get("softName_isNull");
					Object softName_isNotNull=queryMap.get("softName_isNotNull");
					Object softName_in=queryMap.get("softName_in");
				   															  					Object softVersion=queryMap.get("softVersion");
					Object softVersion_like=queryMap.get("softVersion_like");
					Object softVersion_isNull=queryMap.get("softVersion_isNull");
					Object softVersion_isNotNull=queryMap.get("softVersion_isNotNull");
					Object softVersion_in=queryMap.get("softVersion_in");
				   															  					Object softCode=queryMap.get("softCode");
					Object softCode_like=queryMap.get("softCode_like");
					Object softCode_isNull=queryMap.get("softCode_isNull");
					Object softCode_isNotNull=queryMap.get("softCode_isNotNull");
					Object softCode_in=queryMap.get("softCode_in");
				   															  					Object updateLog_gt=queryMap.get("updateLog_gt");
					Object updateLog_ge=queryMap.get("updateLog_ge");
					Object updateLog_lt=queryMap.get("updateLog_lt");
					Object updateLog_le=queryMap.get("updateLog_le");
				  																Object mandatoryUpdate=queryMap.get("mandatoryUpdate");
					Object mandatoryUpdate_gt=queryMap.get("mandatoryUpdate_gt");
					Object mandatoryUpdate_ge=queryMap.get("mandatoryUpdate_ge");
					Object mandatoryUpdate_lt=queryMap.get("mandatoryUpdate_lt");
					Object mandatoryUpdate_le=queryMap.get("mandatoryUpdate_le");
					Object mandatoryUpdate_in=queryMap.get("mandatoryUpdate_in");
															  					Object updateUrl_gt=queryMap.get("updateUrl_gt");
					Object updateUrl_ge=queryMap.get("updateUrl_ge");
					Object updateUrl_lt=queryMap.get("updateUrl_lt");
					Object updateUrl_le=queryMap.get("updateUrl_le");
				  															  					Object lastVersion=queryMap.get("lastVersion");
					Object lastVersion_like=queryMap.get("lastVersion_like");
					Object lastVersion_isNull=queryMap.get("lastVersion_isNull");
					Object lastVersion_isNotNull=queryMap.get("lastVersion_isNotNull");
					Object lastVersion_in=queryMap.get("lastVersion_in");
				   															  					Object redundantField1=queryMap.get("redundantField1");
					Object redundantField1_like=queryMap.get("redundantField1_like");
					Object redundantField1_isNull=queryMap.get("redundantField1_isNull");
					Object redundantField1_isNotNull=queryMap.get("redundantField1_isNotNull");
					Object redundantField1_in=queryMap.get("redundantField1_in");
				   															  					Object redundantField2=queryMap.get("redundantField2");
					Object redundantField2_like=queryMap.get("redundantField2_like");
					Object redundantField2_isNull=queryMap.get("redundantField2_isNull");
					Object redundantField2_isNotNull=queryMap.get("redundantField2_isNotNull");
					Object redundantField2_in=queryMap.get("redundantField2_in");
				   							
			

						
			
			QueryCondition qc = new QueryCondition(SoftInfoEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.in, id_in));}
															  					if(softName!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.eq, softName));}
		            if(softName_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.like, softName_like));}
		            if(softName_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.isNull, softName_isNull));}
		            if(softName_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.isNotNull, softName_isNotNull));}
				    if(softName_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.in, softName_in));}
				  															  					if(softVersion!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.eq, softVersion));}
		            if(softVersion_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.like, softVersion_like));}
		            if(softVersion_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.isNull, softVersion_isNull));}
		            if(softVersion_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.isNotNull, softVersion_isNotNull));}
				    if(softVersion_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.in, softVersion_in));}
				  															  					if(softCode!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.eq, softCode));}
		            if(softCode_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.like, softCode_like));}
		            if(softCode_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.isNull, softCode_isNull));}
		            if(softCode_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.isNotNull, softCode_isNotNull));}
				    if(softCode_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.in, softCode_in));}
				  															  					if(updateLog_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.gt, updateLog_gt));}
					if(updateLog_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.ge, updateLog_ge));}
					if(updateLog_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.lt, updateLog_lt));}
					if(updateLog_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.le, updateLog_le));}
				  																if(mandatoryUpdate!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.eq, mandatoryUpdate));}
					if(mandatoryUpdate_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.gt, mandatoryUpdate_gt));}
					if(mandatoryUpdate_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.ge, mandatoryUpdate_ge));}
					if(mandatoryUpdate_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.lt, mandatoryUpdate_lt));}
					if(mandatoryUpdate_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.le, mandatoryUpdate_le));}
					if(mandatoryUpdate_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.in, mandatoryUpdate_in));}
															  					if(updateUrl_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.gt, updateUrl_gt));}
					if(updateUrl_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.ge, updateUrl_ge));}
					if(updateUrl_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.lt, updateUrl_lt));}
					if(updateUrl_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.le, updateUrl_le));}
				  															  					if(lastVersion!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.eq, lastVersion));}
		            if(lastVersion_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.like, lastVersion_like));}
		            if(lastVersion_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.isNull, lastVersion_isNull));}
		            if(lastVersion_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.isNotNull, lastVersion_isNotNull));}
				    if(lastVersion_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.in, lastVersion_in));}
				  															  					if(redundantField1!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.eq, redundantField1));}
		            if(redundantField1_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.like, redundantField1_like));}
		            if(redundantField1_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.isNull, redundantField1_isNull));}
		            if(redundantField1_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.isNotNull, redundantField1_isNotNull));}
				    if(redundantField1_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.in, redundantField1_in));}
				  															  					if(redundantField2!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.eq, redundantField2));}
		            if(redundantField2_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.like, redundantField2_like));}
		            if(redundantField2_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.isNull, redundantField2_isNull));}
		            if(redundantField2_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.isNotNull, redundantField2_isNotNull));}
				    if(redundantField2_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.in, redundantField2_in));}
				  										
			            pagelist = dbManager.queryByCondition(SoftInfoEntity.class,qc,pageno,pagesize);	                      			
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
												Object id=queryMap.get("id");
					Object id_gt=queryMap.get("id_gt");
					Object id_ge=queryMap.get("id_ge");
					Object id_lt=queryMap.get("id_lt");
					Object id_le=queryMap.get("id_le");
					Object id_in=queryMap.get("id_in");
															  					Object softName=queryMap.get("softName");
					Object softName_like=queryMap.get("softName_like");
					Object softName_isNull=queryMap.get("softName_isNull");
					Object softName_isNotNull=queryMap.get("softName_isNotNull");
					Object softName_in=queryMap.get("softName_in");
				   															  					Object softVersion=queryMap.get("softVersion");
					Object softVersion_like=queryMap.get("softVersion_like");
					Object softVersion_isNull=queryMap.get("softVersion_isNull");
					Object softVersion_isNotNull=queryMap.get("softVersion_isNotNull");
					Object softVersion_in=queryMap.get("softVersion_in");
				   															  					Object softCode=queryMap.get("softCode");
					Object softCode_like=queryMap.get("softCode_like");
					Object softCode_isNull=queryMap.get("softCode_isNull");
					Object softCode_isNotNull=queryMap.get("softCode_isNotNull");
					Object softCode_in=queryMap.get("softCode_in");
				   															  					Object updateLog_gt=queryMap.get("updateLog_gt");
					Object updateLog_ge=queryMap.get("updateLog_ge");
					Object updateLog_lt=queryMap.get("updateLog_lt");
					Object updateLog_le=queryMap.get("updateLog_le");
				  																Object mandatoryUpdate=queryMap.get("mandatoryUpdate");
					Object mandatoryUpdate_gt=queryMap.get("mandatoryUpdate_gt");
					Object mandatoryUpdate_ge=queryMap.get("mandatoryUpdate_ge");
					Object mandatoryUpdate_lt=queryMap.get("mandatoryUpdate_lt");
					Object mandatoryUpdate_le=queryMap.get("mandatoryUpdate_le");
					Object mandatoryUpdate_in=queryMap.get("mandatoryUpdate_in");
															  					Object updateUrl_gt=queryMap.get("updateUrl_gt");
					Object updateUrl_ge=queryMap.get("updateUrl_ge");
					Object updateUrl_lt=queryMap.get("updateUrl_lt");
					Object updateUrl_le=queryMap.get("updateUrl_le");
				  															  					Object lastVersion=queryMap.get("lastVersion");
					Object lastVersion_like=queryMap.get("lastVersion_like");
					Object lastVersion_isNull=queryMap.get("lastVersion_isNull");
					Object lastVersion_isNotNull=queryMap.get("lastVersion_isNotNull");
					Object lastVersion_in=queryMap.get("lastVersion_in");
				   															  					Object redundantField1=queryMap.get("redundantField1");
					Object redundantField1_like=queryMap.get("redundantField1_like");
					Object redundantField1_isNull=queryMap.get("redundantField1_isNull");
					Object redundantField1_isNotNull=queryMap.get("redundantField1_isNotNull");
					Object redundantField1_in=queryMap.get("redundantField1_in");
				   															  					Object redundantField2=queryMap.get("redundantField2");
					Object redundantField2_like=queryMap.get("redundantField2_like");
					Object redundantField2_isNull=queryMap.get("redundantField2_isNull");
					Object redundantField2_isNotNull=queryMap.get("redundantField2_isNotNull");
					Object redundantField2_in=queryMap.get("redundantField2_in");
				   							
			

						
			
			QueryCondition qc = new QueryCondition(SoftInfoEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.in, id_in));}
															  					if(softName!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.eq, softName));}
		            if(softName_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.like, softName_like));}
		            if(softName_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.isNull, softName_isNull));}
		            if(softName_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.isNotNull, softName_isNotNull));}
				    if(softName_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.in, softName_in));}
				  															  					if(softVersion!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.eq, softVersion));}
		            if(softVersion_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.like, softVersion_like));}
		            if(softVersion_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.isNull, softVersion_isNull));}
		            if(softVersion_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.isNotNull, softVersion_isNotNull));}
				    if(softVersion_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.in, softVersion_in));}
				  															  					if(softCode!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.eq, softCode));}
		            if(softCode_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.like, softCode_like));}
		            if(softCode_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.isNull, softCode_isNull));}
		            if(softCode_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.isNotNull, softCode_isNotNull));}
				    if(softCode_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.in, softCode_in));}
				  															  					if(updateLog_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.gt, updateLog_gt));}
					if(updateLog_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.ge, updateLog_ge));}
					if(updateLog_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.lt, updateLog_lt));}
					if(updateLog_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.le, updateLog_le));}
				  																if(mandatoryUpdate!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.eq, mandatoryUpdate));}
					if(mandatoryUpdate_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.gt, mandatoryUpdate_gt));}
					if(mandatoryUpdate_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.ge, mandatoryUpdate_ge));}
					if(mandatoryUpdate_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.lt, mandatoryUpdate_lt));}
					if(mandatoryUpdate_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.le, mandatoryUpdate_le));}
					if(mandatoryUpdate_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.in, mandatoryUpdate_in));}
															  					if(updateUrl_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.gt, updateUrl_gt));}
					if(updateUrl_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.ge, updateUrl_ge));}
					if(updateUrl_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.lt, updateUrl_lt));}
					if(updateUrl_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.le, updateUrl_le));}
				  															  					if(lastVersion!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.eq, lastVersion));}
		            if(lastVersion_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.like, lastVersion_like));}
		            if(lastVersion_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.isNull, lastVersion_isNull));}
		            if(lastVersion_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.isNotNull, lastVersion_isNotNull));}
				    if(lastVersion_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.in, lastVersion_in));}
				  															  					if(redundantField1!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.eq, redundantField1));}
		            if(redundantField1_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.like, redundantField1_like));}
		            if(redundantField1_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.isNull, redundantField1_isNull));}
		            if(redundantField1_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.isNotNull, redundantField1_isNotNull));}
				    if(redundantField1_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.in, redundantField1_in));}
				  															  					if(redundantField2!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.eq, redundantField2));}
		            if(redundantField2_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.like, redundantField2_like));}
		            if(redundantField2_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.isNull, redundantField2_isNull));}
		            if(redundantField2_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.isNotNull, redundantField2_isNotNull));}
				    if(redundantField2_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.in, redundantField2_in));}
				  										
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
            pagelist = dbManager.queryByConditions(SoftInfoEntity.class,qc,oc,pageno,pagesize);	           
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
										result = dbManager.delNoTransaction(id, SoftInfoEntity.class);
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
					QueryCondition qc = new QueryCondition(SoftInfoEntity.ID,QueryCondition.in, ids);
					result = dbManager.delByConditionsNoTransaction(SoftInfoEntity.class, qc);
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
												Object id=queryMap.get("id");
					Object id_gt=queryMap.get("id_gt");
					Object id_ge=queryMap.get("id_ge");
					Object id_lt=queryMap.get("id_lt");
					Object id_le=queryMap.get("id_le");
					Object id_in=queryMap.get("id_in");
															  					Object softName=queryMap.get("softName");
					Object softName_like=queryMap.get("softName_like");
					Object softName_isNull=queryMap.get("softName_isNull");
					Object softName_isNotNull=queryMap.get("softName_isNotNull");
					Object softName_in=queryMap.get("softName_in");
				  															  					Object softVersion=queryMap.get("softVersion");
					Object softVersion_like=queryMap.get("softVersion_like");
					Object softVersion_isNull=queryMap.get("softVersion_isNull");
					Object softVersion_isNotNull=queryMap.get("softVersion_isNotNull");
					Object softVersion_in=queryMap.get("softVersion_in");
				  															  					Object softCode=queryMap.get("softCode");
					Object softCode_like=queryMap.get("softCode_like");
					Object softCode_isNull=queryMap.get("softCode_isNull");
					Object softCode_isNotNull=queryMap.get("softCode_isNotNull");
					Object softCode_in=queryMap.get("softCode_in");
				  															  					Object updateLog_gt=queryMap.get("updateLog_gt");
					Object updateLog_ge=queryMap.get("updateLog_ge");
					Object updateLog_lt=queryMap.get("updateLog_lt");
					Object updateLog_le=queryMap.get("updateLog_le");
				  																Object mandatoryUpdate=queryMap.get("mandatoryUpdate");
					Object mandatoryUpdate_gt=queryMap.get("mandatoryUpdate_gt");
					Object mandatoryUpdate_ge=queryMap.get("mandatoryUpdate_ge");
					Object mandatoryUpdate_lt=queryMap.get("mandatoryUpdate_lt");
					Object mandatoryUpdate_le=queryMap.get("mandatoryUpdate_le");
					Object mandatoryUpdate_in=queryMap.get("mandatoryUpdate_in");
															  					Object updateUrl_gt=queryMap.get("updateUrl_gt");
					Object updateUrl_ge=queryMap.get("updateUrl_ge");
					Object updateUrl_lt=queryMap.get("updateUrl_lt");
					Object updateUrl_le=queryMap.get("updateUrl_le");
				  															  					Object lastVersion=queryMap.get("lastVersion");
					Object lastVersion_like=queryMap.get("lastVersion_like");
					Object lastVersion_isNull=queryMap.get("lastVersion_isNull");
					Object lastVersion_isNotNull=queryMap.get("lastVersion_isNotNull");
					Object lastVersion_in=queryMap.get("lastVersion_in");
				  															  					Object redundantField1=queryMap.get("redundantField1");
					Object redundantField1_like=queryMap.get("redundantField1_like");
					Object redundantField1_isNull=queryMap.get("redundantField1_isNull");
					Object redundantField1_isNotNull=queryMap.get("redundantField1_isNotNull");
					Object redundantField1_in=queryMap.get("redundantField1_in");
				  															  					Object redundantField2=queryMap.get("redundantField2");
					Object redundantField2_like=queryMap.get("redundantField2_like");
					Object redundantField2_isNull=queryMap.get("redundantField2_isNull");
					Object redundantField2_isNotNull=queryMap.get("redundantField2_isNotNull");
					Object redundantField2_in=queryMap.get("redundantField2_in");
				  													
			QueryCondition qc = new QueryCondition(SoftInfoEntity.ID, QueryCondition.gt, "0");				
												if(id!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.eq, id));}
					if(id_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.gt, id_gt));}
					if(id_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.ge, id_ge));}
					if(id_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.lt, id_lt));}
					if(id_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.le, id_le));}
					if(id_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.ID, QueryCondition.in, id_in));}
															  					if(softName!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.eq, softName));}
		            if(softName_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.like, softName_like));}
		            if(softName_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.isNull, softName_isNull));}
		            if(softName_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.isNotNull, softName_isNotNull));}
				    if(softName_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_NAME, QueryCondition.in, softName_in));}
				  															  					if(softVersion!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.eq, softVersion));}
		            if(softVersion_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.like, softVersion_like));}
		            if(softVersion_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.isNull, softVersion_isNull));}
		            if(softVersion_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.isNotNull, softVersion_isNotNull));}
				    if(softVersion_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_VERSION, QueryCondition.in, softVersion_in));}
				  															  					if(softCode!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.eq, softCode));}
		            if(softCode_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.like, softCode_like));}
		            if(softCode_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.isNull, softCode_isNull));}
		            if(softCode_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.isNotNull, softCode_isNotNull));}
				    if(softCode_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.SOFT_CODE, QueryCondition.in, softCode_in));}
				  															  					if(updateLog_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.gt, updateLog_gt));}
					if(updateLog_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.ge, updateLog_ge));}
					if(updateLog_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.lt, updateLog_lt));}
					if(updateLog_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_LOG, QueryCondition.le, updateLog_le));}
				  																if(mandatoryUpdate!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.eq, mandatoryUpdate));}
					if(mandatoryUpdate_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.gt, mandatoryUpdate_gt));}
					if(mandatoryUpdate_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.ge, mandatoryUpdate_ge));}
					if(mandatoryUpdate_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.lt, mandatoryUpdate_lt));}
					if(mandatoryUpdate_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.le, mandatoryUpdate_le));}
					if(mandatoryUpdate_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.MANDATORY_UPDATE, QueryCondition.in, mandatoryUpdate_in));}
															  					if(updateUrl_gt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.gt, updateUrl_gt));}
					if(updateUrl_ge!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.ge, updateUrl_ge));}
					if(updateUrl_lt!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.lt, updateUrl_lt));}
					if(updateUrl_le!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.UPDATE_URL, QueryCondition.le, updateUrl_le));}
				  															  					if(lastVersion!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.eq, lastVersion));}
		            if(lastVersion_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.like, lastVersion_like));}
		            if(lastVersion_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.isNull, lastVersion_isNull));}
		            if(lastVersion_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.isNotNull, lastVersion_isNotNull));}
				    if(lastVersion_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.LAST_VERSION, QueryCondition.in, lastVersion_in));}
				  															  					if(redundantField1!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.eq, redundantField1));}
		            if(redundantField1_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.like, redundantField1_like));}
		            if(redundantField1_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.isNull, redundantField1_isNull));}
		            if(redundantField1_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.isNotNull, redundantField1_isNotNull));}
				    if(redundantField1_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD1, QueryCondition.in, redundantField1_in));}
				  															  					if(redundantField2!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.eq, redundantField2));}
		            if(redundantField2_like!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.like, redundantField2_like));}
		            if(redundantField2_isNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.isNull, redundantField2_isNull));}
		            if(redundantField2_isNotNull!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.isNotNull, redundantField2_isNotNull));}
				    if(redundantField2_in!=null){qc.andCondition(new QueryCondition(SoftInfoEntity.REDUNDANT_FIELD2, QueryCondition.in, redundantField2_in));}
				  										
						if (qc.getQueryNextCondition()!=null) {
				TransactionManager tx = DbUtils.getTranManager();   
				try{   
					tx.beginTransaction(); 						
										result = dbManager.delByConditionsNoTransaction(SoftInfoEntity.class,qc);				
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
		
		
}
