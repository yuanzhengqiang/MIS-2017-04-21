//package com.framework.system.common;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//import org.apache.log4j.Logger;
//
//import sbtj.entity.softInfo.SoftInfoEntity;
//import sbtj.service.softInfo.SoftInfoService;
//
//import com.framework.system.common.entity.user.UserEntity;
//import com.framework.system.common.service.user.UserService;
//import com.framework.system.db.query.OrderVO;
//import com.framework.system.util.Md5Utils;
//
///**
// * @Title: Service
// * @Description: 服务类
// * @author feng.gu
// * @date 2015-11-20 10:50:06
// * @version V1.0
// * 
// */
//public class SystemService {
//	private static Logger logger = Logger.getLogger(SystemService.class);
//	private static SystemService systemService;
//	private UserService userService = UserService.getInstance();
//	private SoftInfoService softInfoService = SoftInfoService.getInstance();
//	private static SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
//
//	/**
//	 * 获取实例
//	 * 
//	 * @return
//	 */
//	public static SystemService getInstance() {   
//		if (systemService == null) {
//			systemService = new SystemService();
//		}
//		return systemService;
//	}
//
//
//	
//	
//	/**
//	 * 根据userId查询用户的角色集合
//	 * @param userId
//	 * @return
//	 */
//	public String getUserRoleIdsByUserId(Integer userId){
//		String roleIds="";
//		try {
//													
//		} catch (Exception e) {
//			logger.error(e);
//		}
//		return roleIds;
//	}
//	
//	/**
//	 * 根据roleIds查询的角色集合的权限集合并查询一级和二级菜单
//	 * @param roleIds
//	 * @return
//	 */
//	
//	/**
//	 * 根据roleIds查询的角色集合的权限集合
//	 * @param roleIds
//	 * @return
//	 */
//	public List<PrivilegeEntity> getPrivilegesByRoleIds(String roleIds){
//		List<PrivilegeEntity> privileges=new ArrayList<PrivilegeEntity>();;
//		try {
//			Map<String,Object> queryMap = new HashMap<String,Object>();
//			queryMap.put("roleId_in", roleIds);		
//			List<Object> list= privilegeService.getListByCondition(queryMap, null, null, true, null);	
//			if(list!=null&&list.size()>0){
//				for(Object obj:list){
//					PrivilegeEntity entity = (PrivilegeEntity)obj;					
//					privileges.add(entity);
//				}
//			}
//		} catch (Exception e) {
//			logger.error(e);
//		}
//		return privileges;
//	}
//	
//
//    /**
//     * 查询时增加数据规则
//     * @param request
//     * @return
//     */
//	public Map<String, Object> addDataRule(String entityName,Map<String, Object> map,HttpServletRequest request) {
//		Map<String, Object> temp = map;
//		try {
//			//1.查询当前用户角色
//			String roleIds = (String)request.getSession().getAttribute("roleIds");	
//			if(roleIds!=null&&!"".equals(roleIds)){
//				//1.查询当前用户数据权限集合
//				Map<String,Object> queryMap = new HashMap<String,Object>();
//				queryMap.put("roleId_in", roleIds);	
//				queryMap.put("funcitonType", 2);				
//				List<Object> list=privilegeService.getListByCondition(queryMap);	
//				String privilegeIds = "";
//				if(list!=null&&list.size()>0){
//					for(Object obj:list){
//						PrivilegeEntity p = (PrivilegeEntity)obj;
//						privilegeIds += p.getFunctionId()+",";
//					}
//				}
//				if(privilegeIds!=null&&!"".equals(privilegeIds.trim())){
//					privilegeIds = privilegeIds.substring(0,privilegeIds.length()-1);
//					//2.查询该实体对应的数据规则
//					Map<String,Object> queryMap2 = new HashMap<String,Object>();
//					queryMap2.put("entityName_like", entityName);	
//					queryMap2.put("id_in", privilegeIds);	
//					List<DataRuleEntity> list2= dataRuleService.getListByCondition(queryMap2);	
//					if(list2!=null&&list2.size()>0){
//						for(Object obj:list2){
//							DataRuleEntity dataRule = (DataRuleEntity)obj;	
//							if(dataRule!=null){
//								if(dataRule.getDataCondition()==null||"".equals(dataRule.getDataCondition().trim())){
//									//全部 没有查询条件
////									continue;
//									return map;
//								}else{
//									//格式：[{"condition":"role_in","value":"roleIds"}]
//									String conditionjson = dataRule.getDataCondition();
//									JSONArray clist = JSONArray.fromObject(conditionjson);
//									if(clist!=null&&clist.size()>0){
//										for(int i=0;i<clist.size();i++){
//											JSONObject cobj = clist.getJSONObject(i);
//											if(cobj!=null){
//												String condition = (String)cobj.get("condition");
//												String value = (String)cobj.get("value");			
//												if(condition!=null&&!"".equals(condition.trim())&&value!=null&&!"".equals(value.trim())){
//													if(value.indexOf("$")>-1){
//														//变量参数
//														value = value.replaceAll("\\$", "");
//														Object valueobj = request.getSession().getAttribute(value);	
//														if(valueobj!=null){
//															map.put(condition, valueobj);
//														}else{
//															map.put(condition, "-1");
//														}
//													}else{
//														//直接参数
//														map.put(condition, value);
//													}
//													
//												}
//											}
//										}
//									}
//								}
//							}					
//						}
//					}
//				}
//					
//			}
//		} catch (Exception e) {
//			logger.error(e);
//			return temp;
//		}
//		return map;
//	}
//	
//	/**
//     * 查询时增加数据规则2 多个角色数据权限：自定义查询条件 and(角色1数据权限  or 角色2数据权限) 即 A0 and ((A1 and B1) or (A2 and B2))
//     * @param request
//     * @return
//     */
//	public Map<String, Object> addDataRuleByRoles(String entityName,Map<String, Object> map,HttpServletRequest request) {
//		Map<String, Object> temp = map;
//		List<Map<String, Object>> dataRuleMapList = new ArrayList<Map<String, Object>>();
//		//缓存这个角色 某个条件全部查询 若此条件全部查询key为entityName value为"all"字符串
//		Map<String,String> allDataConditionMap = new HashMap<String,String>();			
//		//此实体查询条件数目
//		int conditionNum=0;
//		try {		
//			//1.查询当前用户角色
//			String roleIds = (String)request.getSession().getAttribute("roleIds");	
//			if(roleIds!=null&&!"".equals(roleIds)){
//				//1.查询当前用户数据权限集合
//				String[] sage = roleIds.split(",");
//				if(sage!=null&&sage.length>0){					
//					for(int a=0;a<sage.length;a++){
//						Map<String, Object> qcMap = new HashMap<String,Object>();
//						//查询数据权限
//						Map<String,Object> queryMap = new HashMap<String,Object>();
//						queryMap.put("roleId_in", sage[a]);	
//						queryMap.put("funcitonType", 2);				
//						List<Object> list=privilegeService.getListByCondition(queryMap);	
//						String privilegeIds = "";
//						if(list!=null&&list.size()>0){
//							for(Object obj:list){
//								PrivilegeEntity p = (PrivilegeEntity)obj;
//								privilegeIds += p.getFunctionId()+",";
//							}
//						}
//						if(privilegeIds!=null&&!"".equals(privilegeIds.trim())){
//							privilegeIds = privilegeIds.substring(0,privilegeIds.length()-1);
//							//2.查询该实体对应的数据规则
//							Map<String,Object> queryMap2 = new HashMap<String,Object>();
//							queryMap2.put("entityName_like", entityName);	
//							queryMap2.put("id_in", privilegeIds);	
//							List<DataRuleEntity> list2= dataRuleService.getListByCondition(queryMap2);	
//							if(list2!=null&&list2.size()>0){
//								//赋值
//								conditionNum = list2.size();
//								boolean addDataRule = false;								
//								for(Object obj:list2){
//									DataRuleEntity dataRule = (DataRuleEntity)obj;	
//									if(dataRule!=null){
//										if(dataRule.getDataCondition()==null||"".equals(dataRule.getDataCondition().trim())){
//											//全部 没有查询条件
//											allDataConditionMap.put(dataRule.getEntityName(), "all");	
//											continue;
//										}else{
//											//格式：[{"condition":"role_in","value":"roleIds"}]
//											String conditionjson = dataRule.getDataCondition();
//											JSONArray clist = JSONArray.fromObject(conditionjson);
//											if(clist!=null&&clist.size()>0){
//												for(int i=0;i<clist.size();i++){
//													JSONObject cobj = clist.getJSONObject(i);
//													if(cobj!=null){
//														String condition = (String)cobj.get("condition");
//														String value = (String)cobj.get("value");			
//														if(condition!=null&&!"".equals(condition.trim())&&value!=null&&!"".equals(value.trim())){
//															addDataRule = true;
//															if(value.indexOf("$")>-1){
//																//变量参数
//																value = value.replaceAll("\\$", "");
//																Object valueobj = request.getSession().getAttribute(value);	
//																if(valueobj!=null){
//																	qcMap.put(condition, valueobj);
//																}else{
//																	qcMap.put(condition, "-1");
//																}																
//															}else{
//																//直接参数
//																qcMap.put(condition, value);
//															}
//															
//														}
//													}
//												}
//											}
//										}
//									}					
//								}
//								if(addDataRule){
//									dataRuleMapList.add(qcMap);
//								}								
//							}
//						}						
//					}					
//				}
//									
//			}
//		} catch (Exception e) {
//			logger.error(e);
//			return temp;
//		}
//		if(allDataConditionMap.size()==conditionNum){
//			//如果 所有角色查询所有的条件数 与条件个相同 则返回map查询所有
//			return map;
//		}
//		if(dataRuleMapList!=null&&dataRuleMapList.size()>0){
//			map.put("dataRuleMapList", dataRuleMapList);
//		}
//		return map;
//	}
//	
//	/**
//	 * 根据角色名称查询账号集合
//	 * @param userId
//	 * @return
//	 */
//	public String getUserIdsByRoleName(String roleName){
//		String userIds="";
//		try {
//			   //查询role的集合
//			   String roleIds="";
//			   Map<String,Object> queryMap2 = new HashMap<String,Object>();
//			   queryMap2.put("name", roleName);		
//			   List<Object> list2= roleService.getListByCondition(queryMap2);
//			   if(list2!=null&&list2.size()>0){
//					for(Object obj:list2){
//						RoleEntity entity = (RoleEntity)obj;
//						if(entity.getId()!=null){
//							roleIds += entity.getId()+",";
//						}
//						
//					}
//			   }
//			   //查询role和user关联表
//			   if(roleIds!=null&&roleIds.length()>0){
//					roleIds = roleIds.substring(0, roleIds.length()-1);
//					//用户与角色关联信息
//					Map<String,Object> queryMap = new HashMap<String,Object>();
//					queryMap.put("roleId_in", roleIds);		
//					List<UserRoleEntity> list= userRoleService.getListByCondition(queryMap);
//					if(list!=null&&list.size()>0){
//						for(UserRoleEntity entity:list){
//							if(entity.getUserId()!=null){
//								userIds += entity.getUserId()+",";
//							}							
//						}
//					}					
//			   }
//			  
//			   if(userIds!=null&&userIds.length()>0){
//				   userIds = userIds.substring(0, userIds.length()-1);
//			   }				
//															
//		} catch (Exception e) {
//			logger.error(e);
//		}
//		return userIds;
//	}
//	
//	/**
//	 * 根据账号名创建账号 默认密码
//	 * @param loginname
//	 * @return
//	 */
//	public Integer createUserByLoginName(String loginname,Integer createUserId,String userType){
//		Integer result = null;
//		String pwd=Md5Utils.MD5("123456");
//		try {
//			 UserEntity user =new UserEntity();
//			 Date date = new Date();
//             String md5_pwd = Md5Utils.MD5(loginname + "$" + pwd); 
//			 user.setLoginname(loginname);
//			 user.setNickname(loginname);
//			 user.setStatus(0);//pei新增时默认状态为0
//			 user.setPassword(md5_pwd);
//			 user.setCreateTime(formater.format(date));
//			 user.setCreateUserId(createUserId);
//			 user.setType(userType);
//			 userService.save(user);
//			 if(user.getId()!=null){
//				 result = user.getId();
//			 }
//		} catch (Exception e) {
//			logger.error(e);
//		}
//		return result;
//	}
//	
//	/**
//	 * 根据当前最新更新版本
//	 * @param currentCode
//	 * @return
//	 */
//	public String getUpdateVersion(String currentCode){
//		JSONObject result = new JSONObject();
//		result.put("action", "QUERY_SOFT_UPDATE_INFO_RESPONSE");
//		result.put("result", "100");
//		result.put("des", "success");
//		JSONObject content = new JSONObject();
//		try {
//			//目前逻辑返回最新的一条			
//			Map<String,Object> queryMap = new HashMap<String,Object>();
//			List<OrderVO> orderList = new ArrayList<OrderVO>();
//			OrderVO orderVO = new OrderVO();
//			orderVO.setName("softCode");
//			orderVO.setOrderType(OrderVO.desc);
//			orderList.add(orderVO);	
//			List<SoftInfoEntity> list=softInfoService.getListByCondition(queryMap, orderList);	  		
//			if(list!=null&&list.size()>0){
//				content=JSONObject.fromObject(list.get(0));
//			}
//															
//		} catch (Exception e) {
//			logger.error(e);
//		}
//		result.put("content", content);
//		return result.toString();
//	}
//	
//	
//
//}
