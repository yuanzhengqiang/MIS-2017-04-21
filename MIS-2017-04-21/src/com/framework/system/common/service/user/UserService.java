package com.framework.system.common.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.framework.system.common.entity.user.UserEntity;
import com.framework.system.db.connect.DbUtils;
import com.framework.system.db.manager.DBManager;
import com.framework.system.db.query.OrderByCondition;
import com.framework.system.db.query.OrderVO;
import com.framework.system.db.query.PageList;
import com.framework.system.db.query.QueryCondition;
import com.framework.system.db.transaction.TransactionManager;
import com.framework.system.util.Md5Utils;
import com.framework.system.util.StringUtil;

/**
 * @Title: Service
 * @Description: 系统账号服务类
 * @author feng.gu
 * @date 2016-04-21 11:15:43
 * @version V1.0
 * 
 */
public class UserService {
	private static Logger logger = Logger.getLogger(UserService.class);
	private DBManager dbManager = DBManager.getInstance();

	private static UserService userService;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static UserService getInstance() {
		if (userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	/**
	 * 保存记录
	 * 
	 * @param obj
	 */
	public boolean save(UserEntity user) {
		boolean result = false;
		if (user != null) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				UserEntity createUser = user.getCreateUser();
				if (createUser != null) {
					dbManager.saveNoTransaction(createUser);
					user.setCreateUserId(createUser.getId());
				}
				UserEntity updateUser = user.getUpdateUser();
				if (updateUser != null) {
					dbManager.saveNoTransaction(updateUser);
					user.setUpdateUserId(updateUser.getId());
				}
				dbManager.saveNoTransaction(user);
				result = dbManager.saveNoTransaction(user);
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
	 * 批量保存记录
	 * 
	 * @param list
	 */
	public boolean saveList(List<UserEntity> userList) {
		boolean result = false;
		if (userList != null && userList.size() > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				for (UserEntity user : userList) {
					if (user != null) {
						// 关联信息保存
						UserEntity createUser = user.getCreateUser();
						if (createUser != null) {
							dbManager.saveNoTransaction(createUser);
							user.setCreateUserId(createUser.getId());
						}
						// 关联信息保存
						UserEntity updateUser = user.getUpdateUser();
						if (updateUser != null) {
							dbManager.saveNoTransaction(updateUser);
							user.setUpdateUserId(updateUser.getId());
						}
						result = dbManager.saveNoTransaction(user);
					}
				}
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
	 * 根据id读取记录
	 * 
	 * @param id
	 *            主键
	 * @param obj
	 */
	public UserEntity getById(Integer id) {
		UserEntity obj = null;
		if (id != null) {
			obj = (UserEntity) dbManager.getById(id, UserEntity.class);
		}
		return obj;
	}


	/**
	 * 根据条件查询记录集合（不分页 不带排序 不级联查询）
	 * 
	 * @param queryMap
	 *            查询条件集合
	 * @return
	 */
	public List<UserEntity> getListByCondition(Map<String, Object> queryMap) {
		List<UserEntity> returnlist = null;
		List<Object> list = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		Object id = queryMap.get("id");
		Object id_gt = queryMap.get("id_gt");
		Object id_ge = queryMap.get("id_ge");
		Object id_lt = queryMap.get("id_lt");
		Object id_le = queryMap.get("id_le");
		Object id_in = queryMap.get("id_in");
		Object loginname = queryMap.get("loginname");
		Object loginname_like = queryMap.get("loginname_like");
		Object loginname_isNull = queryMap.get("loginname_isNull");
		Object loginname_isNotNull = queryMap.get("loginname_isNotNull");
		Object loginname_in = queryMap.get("loginname_in");
		Object password = queryMap.get("password");
		Object password_like = queryMap.get("password_like");
		Object password_isNull = queryMap.get("password_isNull");
		Object password_isNotNull = queryMap.get("password_isNotNull");
		Object password_in = queryMap.get("password_in");
		Object nickname = queryMap.get("nickname");
		Object nickname_like = queryMap.get("nickname_like");
		Object nickname_isNull = queryMap.get("nickname_isNull");
		Object nickname_isNotNull = queryMap.get("nickname_isNotNull");
		Object nickname_in = queryMap.get("nickname_in");
		Object status = queryMap.get("status");
		Object status_gt = queryMap.get("status_gt");
		Object status_ge = queryMap.get("status_ge");
		Object status_lt = queryMap.get("status_lt");
		Object status_le = queryMap.get("status_le");
		Object status_in = queryMap.get("status_in");
		Object loginNum = queryMap.get("loginNum");
		Object loginNum_gt = queryMap.get("loginNum_gt");
		Object loginNum_ge = queryMap.get("loginNum_ge");
		Object loginNum_lt = queryMap.get("loginNum_lt");
		Object loginNum_le = queryMap.get("loginNum_le");
		Object loginNum_in = queryMap.get("loginNum_in");
		Object loginTime_gt = queryMap.get("loginTime_gt");
		Object loginTime_ge = queryMap.get("loginTime_ge");
		Object loginTime_lt = queryMap.get("loginTime_lt");
		Object loginTime_le = queryMap.get("loginTime_le");
		Object loginIp = queryMap.get("loginIp");
		Object loginIp_like = queryMap.get("loginIp_like");
		Object loginIp_isNull = queryMap.get("loginIp_isNull");
		Object loginIp_isNotNull = queryMap.get("loginIp_isNotNull");
		Object loginIp_in = queryMap.get("loginIp_in");
		Object lastLoginTime_gt = queryMap.get("lastLoginTime_gt");
		Object lastLoginTime_ge = queryMap.get("lastLoginTime_ge");
		Object lastLoginTime_lt = queryMap.get("lastLoginTime_lt");
		Object lastLoginTime_le = queryMap.get("lastLoginTime_le");
		Object lastLoginIp = queryMap.get("lastLoginIp");
		Object lastLoginIp_like = queryMap.get("lastLoginIp_like");
		Object lastLoginIp_isNull = queryMap.get("lastLoginIp_isNull");
		Object lastLoginIp_isNotNull = queryMap.get("lastLoginIp_isNotNull");
		Object lastLoginIp_in = queryMap.get("lastLoginIp_in");
		Object createUserId = queryMap.get("createUserId");
		Object createUserId_gt = queryMap.get("createUserId_gt");
		Object createUserId_ge = queryMap.get("createUserId_ge");
		Object createUserId_lt = queryMap.get("createUserId_lt");
		Object createUserId_le = queryMap.get("createUserId_le");
		Object createUserId_in = queryMap.get("createUserId_in");
		Object createTime_gt = queryMap.get("createTime_gt");
		Object createTime_ge = queryMap.get("createTime_ge");
		Object createTime_lt = queryMap.get("createTime_lt");
		Object createTime_le = queryMap.get("createTime_le");
		Object updateUserId = queryMap.get("updateUserId");
		Object updateUserId_gt = queryMap.get("updateUserId_gt");
		Object updateUserId_ge = queryMap.get("updateUserId_ge");
		Object updateUserId_lt = queryMap.get("updateUserId_lt");
		Object updateUserId_le = queryMap.get("updateUserId_le");
		Object updateUserId_in = queryMap.get("updateUserId_in");
		Object updateTime_gt = queryMap.get("updateTime_gt");
		Object updateTime_ge = queryMap.get("updateTime_ge");
		Object updateTime_lt = queryMap.get("updateTime_lt");
		Object updateTime_le = queryMap.get("updateTime_le");
		Object type = queryMap.get("type");
		Object type_like = queryMap.get("type_like");
		Object type_isNull = queryMap.get("type_isNull");
		Object type_isNotNull = queryMap.get("type_isNotNull");
		Object type_in = queryMap.get("type_in");


		QueryCondition qc = new QueryCondition(UserEntity.ID,
				QueryCondition.gt, "0");
		if (id != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.eq, id));
		}
		if (id_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.gt, id_gt));
		}
		if (id_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.ge, id_ge));
		}
		if (id_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.lt, id_lt));
		}
		if (id_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.le, id_le));
		}
		if (id_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.in, id_in));
		}
		if (loginname != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.eq, loginname));
		}
		if (loginname_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.like, loginname_like));
		}
		if (loginname_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.isNull, loginname_isNull));
		}
		if (loginname_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.isNotNull, loginname_isNotNull));
		}
		if (loginname_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.in, loginname_in));
		}
		if (password != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.eq, password));
		}
		if (password_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.like, password_like));
		}
		if (password_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.isNull, password_isNull));
		}
		if (password_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.isNotNull, password_isNotNull));
		}
		if (password_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.in, password_in));
		}
		if (nickname != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.eq, nickname));
		}
		if (nickname_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.like, nickname_like));
		}
		if (nickname_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.isNull, nickname_isNull));
		}
		if (nickname_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.isNotNull, nickname_isNotNull));
		}
		if (nickname_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.in, nickname_in));
		}
		if (status != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.eq, status));
		}
		if (status_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.gt, status_gt));
		}
		if (status_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.ge, status_ge));
		}
		if (status_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.lt, status_lt));
		}
		if (status_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.le, status_le));
		}
		if (status_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.in, status_in));
		}
		if (loginNum != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.eq, loginNum));
		}
		if (loginNum_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.gt, loginNum_gt));
		}
		if (loginNum_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.ge, loginNum_ge));
		}
		if (loginNum_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.lt, loginNum_lt));
		}
		if (loginNum_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.le, loginNum_le));
		}
		if (loginNum_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.in, loginNum_in));
		}
		if (loginTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.gt, loginTime_gt));
		}
		if (loginTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.ge, loginTime_ge));
		}
		if (loginTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.lt, loginTime_lt));
		}
		if (loginTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.le, loginTime_le));
		}
		if (loginIp != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.eq, loginIp));
		}
		if (loginIp_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.like, loginIp_like));
		}
		if (loginIp_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.isNull, loginIp_isNull));
		}
		if (loginIp_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.isNotNull, loginIp_isNotNull));
		}
		if (loginIp_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.in, loginIp_in));
		}
		if (lastLoginTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.gt, lastLoginTime_gt));
		}
		if (lastLoginTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.ge, lastLoginTime_ge));
		}
		if (lastLoginTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.lt, lastLoginTime_lt));
		}
		if (lastLoginTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.le, lastLoginTime_le));
		}
		if (lastLoginIp != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.eq, lastLoginIp));
		}
		if (lastLoginIp_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.like, lastLoginIp_like));
		}
		if (lastLoginIp_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.isNull, lastLoginIp_isNull));
		}
		if (lastLoginIp_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.isNotNull, lastLoginIp_isNotNull));
		}
		if (lastLoginIp_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.in, lastLoginIp_in));
		}
		if (createUserId != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.eq, createUserId));
		}
		if (createUserId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.gt, createUserId_gt));
		}
		if (createUserId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.ge, createUserId_ge));
		}
		if (createUserId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.lt, createUserId_lt));
		}
		if (createUserId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.le, createUserId_le));
		}
		if (createUserId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.in, createUserId_in));
		}
		if (createTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.gt, createTime_gt));
		}
		if (createTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.ge, createTime_ge));
		}
		if (createTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.lt, createTime_lt));
		}
		if (createTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.le, createTime_le));
		}
		if (updateUserId != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.eq, updateUserId));
		}
		if (updateUserId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.gt, updateUserId_gt));
		}
		if (updateUserId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.ge, updateUserId_ge));
		}
		if (updateUserId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.lt, updateUserId_lt));
		}
		if (updateUserId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.le, updateUserId_le));
		}
		if (updateUserId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.in, updateUserId_in));
		}
		if (updateTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.gt, updateTime_gt));
		}
		if (updateTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.ge, updateTime_ge));
		}
		if (updateTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.lt, updateTime_lt));
		}
		if (updateTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.le, updateTime_le));
		}
		if (type != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.eq, type));
		}
		if (type_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.like, type_like));
		}
		if (type_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.isNull, type_isNull));
		}
		if (type_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.isNotNull, type_isNotNull));
		}
		if (type_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.in, type_in));
		}

		list = dbManager.queryByCondition(UserEntity.class, qc);
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<UserEntity>();
			for (Object obj : list) {
				returnlist.add((UserEntity) obj);
			}
		}
		return returnlist;
	}

	/**
	 * 根据条件查询记录集合（不分页 带排序 带级联查询）
	 * 
	 * @param queryMap
	 *            查询条件集合
	 * @param orderList
	 *            排序条件集合
	 * @param departmentShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param personinfoShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param createUserShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param updateUserShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param userGroupListShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public List<UserEntity> getListByCondition(Map<String, Object> queryMap, List<OrderVO> orderList, Boolean departmentShow, Boolean personinfoShow,
	        Boolean createUserShow, Boolean updateUserShow, Boolean userGroupListShow) {
		List<UserEntity> returnlist = null;
		List<Object> list = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		Object id = queryMap.get("id");
		Object id_gt = queryMap.get("id_gt");
		Object id_ge = queryMap.get("id_ge");
		Object id_lt = queryMap.get("id_lt");
		Object id_le = queryMap.get("id_le");
		Object id_in = queryMap.get("id_in");
		Object loginname = queryMap.get("loginname");
		Object loginname_like = queryMap.get("loginname_like");
		Object loginname_isNull = queryMap.get("loginname_isNull");
		Object loginname_isNotNull = queryMap.get("loginname_isNotNull");
		Object loginname_in = queryMap.get("loginname_in");
		Object password = queryMap.get("password");
		Object password_like = queryMap.get("password_like");
		Object password_isNull = queryMap.get("password_isNull");
		Object password_isNotNull = queryMap.get("password_isNotNull");
		Object password_in = queryMap.get("password_in");
		Object nickname = queryMap.get("nickname");
		Object nickname_like = queryMap.get("nickname_like");
		Object nickname_isNull = queryMap.get("nickname_isNull");
		Object nickname_isNotNull = queryMap.get("nickname_isNotNull");
		Object nickname_in = queryMap.get("nickname_in");
		Object status = queryMap.get("status");
		Object status_gt = queryMap.get("status_gt");
		Object status_ge = queryMap.get("status_ge");
		Object status_lt = queryMap.get("status_lt");
		Object status_le = queryMap.get("status_le");
		Object status_in = queryMap.get("status_in");
		Object loginNum = queryMap.get("loginNum");
		Object loginNum_gt = queryMap.get("loginNum_gt");
		Object loginNum_ge = queryMap.get("loginNum_ge");
		Object loginNum_lt = queryMap.get("loginNum_lt");
		Object loginNum_le = queryMap.get("loginNum_le");
		Object loginNum_in = queryMap.get("loginNum_in");
		Object loginTime_gt = queryMap.get("loginTime_gt");
		Object loginTime_ge = queryMap.get("loginTime_ge");
		Object loginTime_lt = queryMap.get("loginTime_lt");
		Object loginTime_le = queryMap.get("loginTime_le");
		Object loginIp = queryMap.get("loginIp");
		Object loginIp_like = queryMap.get("loginIp_like");
		Object loginIp_isNull = queryMap.get("loginIp_isNull");
		Object loginIp_isNotNull = queryMap.get("loginIp_isNotNull");
		Object loginIp_in = queryMap.get("loginIp_in");
		Object lastLoginTime_gt = queryMap.get("lastLoginTime_gt");
		Object lastLoginTime_ge = queryMap.get("lastLoginTime_ge");
		Object lastLoginTime_lt = queryMap.get("lastLoginTime_lt");
		Object lastLoginTime_le = queryMap.get("lastLoginTime_le");
		Object lastLoginIp = queryMap.get("lastLoginIp");
		Object lastLoginIp_like = queryMap.get("lastLoginIp_like");
		Object lastLoginIp_isNull = queryMap.get("lastLoginIp_isNull");
		Object lastLoginIp_isNotNull = queryMap.get("lastLoginIp_isNotNull");
		Object lastLoginIp_in = queryMap.get("lastLoginIp_in");
		Object departmentId = queryMap.get("departmentId");
		Object departmentId_gt = queryMap.get("departmentId_gt");
		Object departmentId_ge = queryMap.get("departmentId_ge");
		Object departmentId_lt = queryMap.get("departmentId_lt");
		Object departmentId_le = queryMap.get("departmentId_le");
		Object departmentId_in = queryMap.get("departmentId_in");
		Object personinfoId = queryMap.get("personinfoId");
		Object personinfoId_gt = queryMap.get("personinfoId_gt");
		Object personinfoId_ge = queryMap.get("personinfoId_ge");
		Object personinfoId_lt = queryMap.get("personinfoId_lt");
		Object personinfoId_le = queryMap.get("personinfoId_le");
		Object personinfoId_in = queryMap.get("personinfoId_in");
		Object createUserId = queryMap.get("createUserId");
		Object createUserId_gt = queryMap.get("createUserId_gt");
		Object createUserId_ge = queryMap.get("createUserId_ge");
		Object createUserId_lt = queryMap.get("createUserId_lt");
		Object createUserId_le = queryMap.get("createUserId_le");
		Object createUserId_in = queryMap.get("createUserId_in");
		Object createTime_gt = queryMap.get("createTime_gt");
		Object createTime_ge = queryMap.get("createTime_ge");
		Object createTime_lt = queryMap.get("createTime_lt");
		Object createTime_le = queryMap.get("createTime_le");
		Object updateUserId = queryMap.get("updateUserId");
		Object updateUserId_gt = queryMap.get("updateUserId_gt");
		Object updateUserId_ge = queryMap.get("updateUserId_ge");
		Object updateUserId_lt = queryMap.get("updateUserId_lt");
		Object updateUserId_le = queryMap.get("updateUserId_le");
		Object updateUserId_in = queryMap.get("updateUserId_in");
		Object updateTime_gt = queryMap.get("updateTime_gt");
		Object updateTime_ge = queryMap.get("updateTime_ge");
		Object updateTime_lt = queryMap.get("updateTime_lt");
		Object updateTime_le = queryMap.get("updateTime_le");
		Object type = queryMap.get("type");
		Object type_like = queryMap.get("type_like");
		Object type_isNull = queryMap.get("type_isNull");
		Object type_isNotNull = queryMap.get("type_isNotNull");
		Object type_in = queryMap.get("type_in");

		Object userGroupId = queryMap.get("userGroupId");

		QueryCondition qc = new QueryCondition(UserEntity.ID, QueryCondition.gt, "0");
		if (id != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID, QueryCondition.eq, id));
		}
		if (id_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID, QueryCondition.gt, id_gt));
		}
		if (id_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID, QueryCondition.ge, id_ge));
		}
		if (id_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID, QueryCondition.lt, id_lt));
		}
		if (id_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID, QueryCondition.le, id_le));
		}
		if (id_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID, QueryCondition.in, id_in));
		}
		if (loginname != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME, QueryCondition.eq, loginname));
		}
		if (loginname_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME, QueryCondition.like, loginname_like));
		}
		if (loginname_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME, QueryCondition.isNull, loginname_isNull));
		}
		if (loginname_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME, QueryCondition.isNotNull, loginname_isNotNull));
		}
		if (loginname_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME, QueryCondition.in, loginname_in));
		}
		if (password != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD, QueryCondition.eq, password));
		}
		if (password_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD, QueryCondition.like, password_like));
		}
		if (password_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD, QueryCondition.isNull, password_isNull));
		}
		if (password_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD, QueryCondition.isNotNull, password_isNotNull));
		}
		if (password_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD, QueryCondition.in, password_in));
		}
		if (nickname != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME, QueryCondition.eq, nickname));
		}
		if (nickname_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME, QueryCondition.like, nickname_like));
		}
		if (nickname_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME, QueryCondition.isNull, nickname_isNull));
		}
		if (nickname_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME, QueryCondition.isNotNull, nickname_isNotNull));
		}
		if (nickname_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME, QueryCondition.in, nickname_in));
		}
		if (status != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS, QueryCondition.eq, status));
		}
		if (status_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS, QueryCondition.gt, status_gt));
		}
		if (status_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS, QueryCondition.ge, status_ge));
		}
		if (status_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS, QueryCondition.lt, status_lt));
		}
		if (status_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS, QueryCondition.le, status_le));
		}
		if (status_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS, QueryCondition.in, status_in));
		}
		if (loginNum != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM, QueryCondition.eq, loginNum));
		}
		if (loginNum_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM, QueryCondition.gt, loginNum_gt));
		}
		if (loginNum_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM, QueryCondition.ge, loginNum_ge));
		}
		if (loginNum_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM, QueryCondition.lt, loginNum_lt));
		}
		if (loginNum_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM, QueryCondition.le, loginNum_le));
		}
		if (loginNum_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM, QueryCondition.in, loginNum_in));
		}
		if (loginTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME, QueryCondition.gt, loginTime_gt));
		}
		if (loginTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME, QueryCondition.ge, loginTime_ge));
		}
		if (loginTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME, QueryCondition.lt, loginTime_lt));
		}
		if (loginTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME, QueryCondition.le, loginTime_le));
		}
		if (loginIp != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP, QueryCondition.eq, loginIp));
		}
		if (loginIp_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP, QueryCondition.like, loginIp_like));
		}
		if (loginIp_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP, QueryCondition.isNull, loginIp_isNull));
		}
		if (loginIp_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP, QueryCondition.isNotNull, loginIp_isNotNull));
		}
		if (loginIp_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP, QueryCondition.in, loginIp_in));
		}
		if (lastLoginTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME, QueryCondition.gt, lastLoginTime_gt));
		}
		if (lastLoginTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME, QueryCondition.ge, lastLoginTime_ge));
		}
		if (lastLoginTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME, QueryCondition.lt, lastLoginTime_lt));
		}
		if (lastLoginTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME, QueryCondition.le, lastLoginTime_le));
		}
		if (lastLoginIp != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP, QueryCondition.eq, lastLoginIp));
		}
		if (lastLoginIp_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP, QueryCondition.like, lastLoginIp_like));
		}
		if (lastLoginIp_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP, QueryCondition.isNull, lastLoginIp_isNull));
		}
		if (lastLoginIp_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP, QueryCondition.isNotNull, lastLoginIp_isNotNull));
		}
		if (lastLoginIp_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP, QueryCondition.in, lastLoginIp_in));
		}
		if (departmentId != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID, QueryCondition.eq, departmentId));
		}
		if (departmentId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID, QueryCondition.gt, departmentId_gt));
		}
		if (departmentId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID, QueryCondition.ge, departmentId_ge));
		}
		if (departmentId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID, QueryCondition.lt, departmentId_lt));
		}
		if (departmentId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID, QueryCondition.le, departmentId_le));
		}
		if (departmentId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID, QueryCondition.in, departmentId_in));
		}
		if (personinfoId != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID, QueryCondition.eq, personinfoId));
		}
		if (personinfoId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID, QueryCondition.gt, personinfoId_gt));
		}
		if (personinfoId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID, QueryCondition.ge, personinfoId_ge));
		}
		if (personinfoId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID, QueryCondition.lt, personinfoId_lt));
		}
		if (personinfoId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID, QueryCondition.le, personinfoId_le));
		}
		if (personinfoId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID, QueryCondition.in, personinfoId_in));
		}
		if (createUserId != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID, QueryCondition.eq, createUserId));
		}
		if (createUserId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID, QueryCondition.gt, createUserId_gt));
		}
		if (createUserId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID, QueryCondition.ge, createUserId_ge));
		}
		if (createUserId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID, QueryCondition.lt, createUserId_lt));
		}
		if (createUserId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID, QueryCondition.le, createUserId_le));
		}
		if (createUserId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID, QueryCondition.in, createUserId_in));
		}
		if (createTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME, QueryCondition.gt, createTime_gt));
		}
		if (createTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME, QueryCondition.ge, createTime_ge));
		}
		if (createTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME, QueryCondition.lt, createTime_lt));
		}
		if (createTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME, QueryCondition.le, createTime_le));
		}
		if (updateUserId != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID, QueryCondition.eq, updateUserId));
		}
		if (updateUserId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID, QueryCondition.gt, updateUserId_gt));
		}
		if (updateUserId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID, QueryCondition.ge, updateUserId_ge));
		}
		if (updateUserId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID, QueryCondition.lt, updateUserId_lt));
		}
		if (updateUserId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID, QueryCondition.le, updateUserId_le));
		}
		if (updateUserId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID, QueryCondition.in, updateUserId_in));
		}
		if (updateTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME, QueryCondition.gt, updateTime_gt));
		}
		if (updateTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME, QueryCondition.ge, updateTime_ge));
		}
		if (updateTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME, QueryCondition.lt, updateTime_lt));
		}
		if (updateTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME, QueryCondition.le, updateTime_le));
		}
		if (type != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE, QueryCondition.eq, type));
		}
		if (type_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE, QueryCondition.like, type_like));
		}
		if (type_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE, QueryCondition.isNull, type_isNull));
		}
		if (type_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE, QueryCondition.isNotNull, type_isNotNull));
		}
		if (type_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE, QueryCondition.in, type_in));
		}

		OrderByCondition oc = null;
		if (orderList != null && orderList.size() > 0) {
			for (int i = 0; i < orderList.size(); i++) {
				OrderVO order = orderList.get(i);
				String orderColumnt = null;
				String orderType = null;
				if (order.getName() != null && !"".equals(order.getName())) {
					orderColumnt = StringUtil.formatFieldToColumnt(order.getName());
					orderType = order.getOrderType();
					if (orderType == null || "".equals(orderType.trim())) {
						orderType = OrderByCondition.desc;
					}
					if (i == 0) {
						oc = new OrderByCondition(orderColumnt, orderType);
					} else {
						oc.orderByCondition(new OrderByCondition(orderColumnt, orderType));
					}
				}

			}
		}
		list = dbManager.queryByConditions(UserEntity.class, qc, oc);
		int a = 0;
		if (departmentShow != null && departmentShow.booleanValue()) {
			a++;
		}
		if (personinfoShow != null && personinfoShow.booleanValue()) {
			a++;
		}
		if (createUserShow != null && createUserShow.booleanValue()) {
			a++;
		}
		if (updateUserShow != null && updateUserShow.booleanValue()) {
			a++;
		}
		if (userGroupListShow != null && userGroupListShow.booleanValue()) {
			a++;
		}
		if (a > 0 && list != null && list.size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				UserEntity obj = (UserEntity) list.get(i);
				// 查询关联内容
				if (createUserShow != null && createUserShow.booleanValue() && obj != null && obj.getCreateUserId() > 0) {
					UserEntity createUser = (UserEntity) dbManager.getById(obj.getCreateUserId(), UserEntity.class);
					obj.setCreateUser(createUser);
				}
				// 查询关联内容
				if (updateUserShow != null && updateUserShow.booleanValue() && obj != null && obj.getUpdateUserId() > 0) {
					UserEntity updateUser = (UserEntity) dbManager.getById(obj.getUpdateUserId(), UserEntity.class);
					obj.setUpdateUser(updateUser);
				}
				result.add(obj);
			}
			list = result;
		}
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<UserEntity>();
			for (Object obj : list) {
				returnlist.add((UserEntity) obj);
			}
		}
		return returnlist;
	}
	
	
	
	/**
	 * 根据条件查询记录集合（带分页 不带排序 不级联查询）
	 * 
	 * @param queryMap
	 *            查询条件集合
	 * @param pageno
	 *            查询页码
	 * @param pagesize
	 *            查询每页记录条数
	 * @return
	 */
	public PageList getListByCondition(Map<String, Object> queryMap,
			int pageno, int pagesize) {
		PageList pagelist = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		Object id = queryMap.get("id");
		Object id_gt = queryMap.get("id_gt");
		Object id_ge = queryMap.get("id_ge");
		Object id_lt = queryMap.get("id_lt");
		Object id_le = queryMap.get("id_le");
		Object id_in = queryMap.get("id_in");
		Object loginname = queryMap.get("loginname");
		Object loginname_like = queryMap.get("loginname_like");
		Object loginname_isNull = queryMap.get("loginname_isNull");
		Object loginname_isNotNull = queryMap.get("loginname_isNotNull");
		Object loginname_in = queryMap.get("loginname_in");
		Object password = queryMap.get("password");
		Object password_like = queryMap.get("password_like");
		Object password_isNull = queryMap.get("password_isNull");
		Object password_isNotNull = queryMap.get("password_isNotNull");
		Object password_in = queryMap.get("password_in");
		Object nickname = queryMap.get("nickname");
		Object nickname_like = queryMap.get("nickname_like");
		Object nickname_isNull = queryMap.get("nickname_isNull");
		Object nickname_isNotNull = queryMap.get("nickname_isNotNull");
		Object nickname_in = queryMap.get("nickname_in");
		Object status = queryMap.get("status");
		Object status_gt = queryMap.get("status_gt");
		Object status_ge = queryMap.get("status_ge");
		Object status_lt = queryMap.get("status_lt");
		Object status_le = queryMap.get("status_le");
		Object status_in = queryMap.get("status_in");
		Object loginNum = queryMap.get("loginNum");
		Object loginNum_gt = queryMap.get("loginNum_gt");
		Object loginNum_ge = queryMap.get("loginNum_ge");
		Object loginNum_lt = queryMap.get("loginNum_lt");
		Object loginNum_le = queryMap.get("loginNum_le");
		Object loginNum_in = queryMap.get("loginNum_in");
		Object loginTime_gt = queryMap.get("loginTime_gt");
		Object loginTime_ge = queryMap.get("loginTime_ge");
		Object loginTime_lt = queryMap.get("loginTime_lt");
		Object loginTime_le = queryMap.get("loginTime_le");
		Object loginIp = queryMap.get("loginIp");
		Object loginIp_like = queryMap.get("loginIp_like");
		Object loginIp_isNull = queryMap.get("loginIp_isNull");
		Object loginIp_isNotNull = queryMap.get("loginIp_isNotNull");
		Object loginIp_in = queryMap.get("loginIp_in");
		Object lastLoginTime_gt = queryMap.get("lastLoginTime_gt");
		Object lastLoginTime_ge = queryMap.get("lastLoginTime_ge");
		Object lastLoginTime_lt = queryMap.get("lastLoginTime_lt");
		Object lastLoginTime_le = queryMap.get("lastLoginTime_le");
		Object lastLoginIp = queryMap.get("lastLoginIp");
		Object lastLoginIp_like = queryMap.get("lastLoginIp_like");
		Object lastLoginIp_isNull = queryMap.get("lastLoginIp_isNull");
		Object lastLoginIp_isNotNull = queryMap.get("lastLoginIp_isNotNull");
		Object lastLoginIp_in = queryMap.get("lastLoginIp_in");
		Object departmentId = queryMap.get("departmentId");
		Object departmentId_gt = queryMap.get("departmentId_gt");
		Object departmentId_ge = queryMap.get("departmentId_ge");
		Object departmentId_lt = queryMap.get("departmentId_lt");
		Object departmentId_le = queryMap.get("departmentId_le");
		Object departmentId_in = queryMap.get("departmentId_in");
		Object personinfoId = queryMap.get("personinfoId");
		Object personinfoId_gt = queryMap.get("personinfoId_gt");
		Object personinfoId_ge = queryMap.get("personinfoId_ge");
		Object personinfoId_lt = queryMap.get("personinfoId_lt");
		Object personinfoId_le = queryMap.get("personinfoId_le");
		Object personinfoId_in = queryMap.get("personinfoId_in");
		Object createUserId = queryMap.get("createUserId");
		Object createUserId_gt = queryMap.get("createUserId_gt");
		Object createUserId_ge = queryMap.get("createUserId_ge");
		Object createUserId_lt = queryMap.get("createUserId_lt");
		Object createUserId_le = queryMap.get("createUserId_le");
		Object createUserId_in = queryMap.get("createUserId_in");
		Object createTime_gt = queryMap.get("createTime_gt");
		Object createTime_ge = queryMap.get("createTime_ge");
		Object createTime_lt = queryMap.get("createTime_lt");
		Object createTime_le = queryMap.get("createTime_le");
		Object updateUserId = queryMap.get("updateUserId");
		Object updateUserId_gt = queryMap.get("updateUserId_gt");
		Object updateUserId_ge = queryMap.get("updateUserId_ge");
		Object updateUserId_lt = queryMap.get("updateUserId_lt");
		Object updateUserId_le = queryMap.get("updateUserId_le");
		Object updateUserId_in = queryMap.get("updateUserId_in");
		Object updateTime_gt = queryMap.get("updateTime_gt");
		Object updateTime_ge = queryMap.get("updateTime_ge");
		Object updateTime_lt = queryMap.get("updateTime_lt");
		Object updateTime_le = queryMap.get("updateTime_le");
		Object type = queryMap.get("type");
		Object type_like = queryMap.get("type_like");
		Object type_isNull = queryMap.get("type_isNull");
		Object type_isNotNull = queryMap.get("type_isNotNull");
		Object type_in = queryMap.get("type_in");


		QueryCondition qc = new QueryCondition(UserEntity.ID,
				QueryCondition.gt, "0");
		if (id != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.eq, id));
		}
		if (id_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.gt, id_gt));
		}
		if (id_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.ge, id_ge));
		}
		if (id_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.lt, id_lt));
		}
		if (id_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.le, id_le));
		}
		if (id_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.in, id_in));
		}
		if (loginname != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.eq, loginname));
		}
		if (loginname_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.like, loginname_like));
		}
		if (loginname_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.isNull, loginname_isNull));
		}
		if (loginname_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.isNotNull, loginname_isNotNull));
		}
		if (loginname_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.in, loginname_in));
		}
		if (password != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.eq, password));
		}
		if (password_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.like, password_like));
		}
		if (password_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.isNull, password_isNull));
		}
		if (password_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.isNotNull, password_isNotNull));
		}
		if (password_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.in, password_in));
		}
		if (nickname != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.eq, nickname));
		}
		if (nickname_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.like, nickname_like));
		}
		if (nickname_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.isNull, nickname_isNull));
		}
		if (nickname_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.isNotNull, nickname_isNotNull));
		}
		if (nickname_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.in, nickname_in));
		}
		if (status != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.eq, status));
		}
		if (status_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.gt, status_gt));
		}
		if (status_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.ge, status_ge));
		}
		if (status_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.lt, status_lt));
		}
		if (status_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.le, status_le));
		}
		if (status_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.in, status_in));
		}
		if (loginNum != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.eq, loginNum));
		}
		if (loginNum_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.gt, loginNum_gt));
		}
		if (loginNum_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.ge, loginNum_ge));
		}
		if (loginNum_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.lt, loginNum_lt));
		}
		if (loginNum_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.le, loginNum_le));
		}
		if (loginNum_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.in, loginNum_in));
		}
		if (loginTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.gt, loginTime_gt));
		}
		if (loginTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.ge, loginTime_ge));
		}
		if (loginTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.lt, loginTime_lt));
		}
		if (loginTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.le, loginTime_le));
		}
		if (loginIp != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.eq, loginIp));
		}
		if (loginIp_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.like, loginIp_like));
		}
		if (loginIp_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.isNull, loginIp_isNull));
		}
		if (loginIp_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.isNotNull, loginIp_isNotNull));
		}
		if (loginIp_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.in, loginIp_in));
		}
		if (lastLoginTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.gt, lastLoginTime_gt));
		}
		if (lastLoginTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.ge, lastLoginTime_ge));
		}
		if (lastLoginTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.lt, lastLoginTime_lt));
		}
		if (lastLoginTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.le, lastLoginTime_le));
		}
		if (lastLoginIp != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.eq, lastLoginIp));
		}
		if (lastLoginIp_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.like, lastLoginIp_like));
		}
		if (lastLoginIp_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.isNull, lastLoginIp_isNull));
		}
		if (lastLoginIp_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.isNotNull, lastLoginIp_isNotNull));
		}
		if (lastLoginIp_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.in, lastLoginIp_in));
		}
		if (departmentId != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.eq, departmentId));
		}
		if (departmentId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.gt, departmentId_gt));
		}
		if (departmentId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.ge, departmentId_ge));
		}
		if (departmentId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.lt, departmentId_lt));
		}
		if (departmentId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.le, departmentId_le));
		}
		if (departmentId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.in, departmentId_in));
		}
		if (personinfoId != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.eq, personinfoId));
		}
		if (personinfoId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.gt, personinfoId_gt));
		}
		if (personinfoId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.ge, personinfoId_ge));
		}
		if (personinfoId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.lt, personinfoId_lt));
		}
		if (personinfoId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.le, personinfoId_le));
		}
		if (personinfoId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.in, personinfoId_in));
		}
		if (createUserId != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.eq, createUserId));
		}
		if (createUserId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.gt, createUserId_gt));
		}
		if (createUserId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.ge, createUserId_ge));
		}
		if (createUserId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.lt, createUserId_lt));
		}
		if (createUserId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.le, createUserId_le));
		}
		if (createUserId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.in, createUserId_in));
		}
		if (createTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.gt, createTime_gt));
		}
		if (createTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.ge, createTime_ge));
		}
		if (createTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.lt, createTime_lt));
		}
		if (createTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.le, createTime_le));
		}
		if (updateUserId != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.eq, updateUserId));
		}
		if (updateUserId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.gt, updateUserId_gt));
		}
		if (updateUserId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.ge, updateUserId_ge));
		}
		if (updateUserId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.lt, updateUserId_lt));
		}
		if (updateUserId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.le, updateUserId_le));
		}
		if (updateUserId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.in, updateUserId_in));
		}
		if (updateTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.gt, updateTime_gt));
		}
		if (updateTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.ge, updateTime_ge));
		}
		if (updateTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.lt, updateTime_lt));
		}
		if (updateTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.le, updateTime_le));
		}
		if (type != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.eq, type));
		}
		if (type_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.like, type_like));
		}
		if (type_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.isNull, type_isNull));
		}
		if (type_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.isNotNull, type_isNotNull));
		}
		if (type_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.in, type_in));
		}

		pagelist = dbManager.queryByCondition(UserEntity.class, qc, pageno,
				pagesize);
		return pagelist;
	}

	/**
	 * 删除记录
	 * 
	 * @param id
	 *            主键
	 * @param obj
	 */
	public boolean del(Integer id) {
		boolean result = false;
		if (id != null && id > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				result = dbManager.delNoTransaction(id, UserEntity.class);
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
				QueryCondition qc = new QueryCondition(UserEntity.ID,
						QueryCondition.in, ids);
				result = dbManager.delByConditionsNoTransaction(
						UserEntity.class, qc);
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
	 * 
	 * @param queryMap
	 *            查询条件集合
	 */
	public boolean delList(Map<String, Object> queryMap) {
		boolean result = false;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		Object id = queryMap.get("id");
		Object id_gt = queryMap.get("id_gt");
		Object id_ge = queryMap.get("id_ge");
		Object id_lt = queryMap.get("id_lt");
		Object id_le = queryMap.get("id_le");
		Object id_in = queryMap.get("id_in");
		Object loginname = queryMap.get("loginname");
		Object loginname_like = queryMap.get("loginname_like");
		Object loginname_isNull = queryMap.get("loginname_isNull");
		Object loginname_isNotNull = queryMap.get("loginname_isNotNull");
		Object loginname_in = queryMap.get("loginname_in");
		Object password = queryMap.get("password");
		Object password_like = queryMap.get("password_like");
		Object password_isNull = queryMap.get("password_isNull");
		Object password_isNotNull = queryMap.get("password_isNotNull");
		Object password_in = queryMap.get("password_in");
		Object nickname = queryMap.get("nickname");
		Object nickname_like = queryMap.get("nickname_like");
		Object nickname_isNull = queryMap.get("nickname_isNull");
		Object nickname_isNotNull = queryMap.get("nickname_isNotNull");
		Object nickname_in = queryMap.get("nickname_in");
		Object status = queryMap.get("status");
		Object status_gt = queryMap.get("status_gt");
		Object status_ge = queryMap.get("status_ge");
		Object status_lt = queryMap.get("status_lt");
		Object status_le = queryMap.get("status_le");
		Object status_in = queryMap.get("status_in");
		Object loginNum = queryMap.get("loginNum");
		Object loginNum_gt = queryMap.get("loginNum_gt");
		Object loginNum_ge = queryMap.get("loginNum_ge");
		Object loginNum_lt = queryMap.get("loginNum_lt");
		Object loginNum_le = queryMap.get("loginNum_le");
		Object loginNum_in = queryMap.get("loginNum_in");
		Object loginTime_gt = queryMap.get("loginTime_gt");
		Object loginTime_ge = queryMap.get("loginTime_ge");
		Object loginTime_lt = queryMap.get("loginTime_lt");
		Object loginTime_le = queryMap.get("loginTime_le");
		Object loginIp = queryMap.get("loginIp");
		Object loginIp_like = queryMap.get("loginIp_like");
		Object loginIp_isNull = queryMap.get("loginIp_isNull");
		Object loginIp_isNotNull = queryMap.get("loginIp_isNotNull");
		Object loginIp_in = queryMap.get("loginIp_in");
		Object lastLoginTime_gt = queryMap.get("lastLoginTime_gt");
		Object lastLoginTime_ge = queryMap.get("lastLoginTime_ge");
		Object lastLoginTime_lt = queryMap.get("lastLoginTime_lt");
		Object lastLoginTime_le = queryMap.get("lastLoginTime_le");
		Object lastLoginIp = queryMap.get("lastLoginIp");
		Object lastLoginIp_like = queryMap.get("lastLoginIp_like");
		Object lastLoginIp_isNull = queryMap.get("lastLoginIp_isNull");
		Object lastLoginIp_isNotNull = queryMap.get("lastLoginIp_isNotNull");
		Object lastLoginIp_in = queryMap.get("lastLoginIp_in");
		Object departmentId = queryMap.get("departmentId");
		Object departmentId_gt = queryMap.get("departmentId_gt");
		Object departmentId_ge = queryMap.get("departmentId_ge");
		Object departmentId_lt = queryMap.get("departmentId_lt");
		Object departmentId_le = queryMap.get("departmentId_le");
		Object departmentId_in = queryMap.get("departmentId_in");
		Object personinfoId = queryMap.get("personinfoId");
		Object personinfoId_gt = queryMap.get("personinfoId_gt");
		Object personinfoId_ge = queryMap.get("personinfoId_ge");
		Object personinfoId_lt = queryMap.get("personinfoId_lt");
		Object personinfoId_le = queryMap.get("personinfoId_le");
		Object personinfoId_in = queryMap.get("personinfoId_in");
		Object createUserId = queryMap.get("createUserId");
		Object createUserId_gt = queryMap.get("createUserId_gt");
		Object createUserId_ge = queryMap.get("createUserId_ge");
		Object createUserId_lt = queryMap.get("createUserId_lt");
		Object createUserId_le = queryMap.get("createUserId_le");
		Object createUserId_in = queryMap.get("createUserId_in");
		Object createTime_gt = queryMap.get("createTime_gt");
		Object createTime_ge = queryMap.get("createTime_ge");
		Object createTime_lt = queryMap.get("createTime_lt");
		Object createTime_le = queryMap.get("createTime_le");
		Object updateUserId = queryMap.get("updateUserId");
		Object updateUserId_gt = queryMap.get("updateUserId_gt");
		Object updateUserId_ge = queryMap.get("updateUserId_ge");
		Object updateUserId_lt = queryMap.get("updateUserId_lt");
		Object updateUserId_le = queryMap.get("updateUserId_le");
		Object updateUserId_in = queryMap.get("updateUserId_in");
		Object updateTime_gt = queryMap.get("updateTime_gt");
		Object updateTime_ge = queryMap.get("updateTime_ge");
		Object updateTime_lt = queryMap.get("updateTime_lt");
		Object updateTime_le = queryMap.get("updateTime_le");
		Object type = queryMap.get("type");
		Object type_like = queryMap.get("type_like");
		Object type_isNull = queryMap.get("type_isNull");
		Object type_isNotNull = queryMap.get("type_isNotNull");
		Object type_in = queryMap.get("type_in");

		QueryCondition qc = new QueryCondition(UserEntity.ID,
				QueryCondition.gt, "0");
		if (id != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.eq, id));
		}
		if (id_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.gt, id_gt));
		}
		if (id_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.ge, id_ge));
		}
		if (id_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.lt, id_lt));
		}
		if (id_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.le, id_le));
		}
		if (id_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.ID,
					QueryCondition.in, id_in));
		}
		if (loginname != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.eq, loginname));
		}
		if (loginname_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.like, loginname_like));
		}
		if (loginname_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.isNull, loginname_isNull));
		}
		if (loginname_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.isNotNull, loginname_isNotNull));
		}
		if (loginname_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGINNAME,
					QueryCondition.in, loginname_in));
		}
		if (password != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.eq, password));
		}
		if (password_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.like, password_like));
		}
		if (password_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.isNull, password_isNull));
		}
		if (password_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.isNotNull, password_isNotNull));
		}
		if (password_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.PASSWORD,
					QueryCondition.in, password_in));
		}
		if (nickname != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.eq, nickname));
		}
		if (nickname_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.like, nickname_like));
		}
		if (nickname_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.isNull, nickname_isNull));
		}
		if (nickname_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.isNotNull, nickname_isNotNull));
		}
		if (nickname_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.NICKNAME,
					QueryCondition.in, nickname_in));
		}
		if (status != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.eq, status));
		}
		if (status_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.gt, status_gt));
		}
		if (status_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.ge, status_ge));
		}
		if (status_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.lt, status_lt));
		}
		if (status_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.le, status_le));
		}
		if (status_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.STATUS,
					QueryCondition.in, status_in));
		}
		if (loginNum != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.eq, loginNum));
		}
		if (loginNum_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.gt, loginNum_gt));
		}
		if (loginNum_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.ge, loginNum_ge));
		}
		if (loginNum_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.lt, loginNum_lt));
		}
		if (loginNum_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.le, loginNum_le));
		}
		if (loginNum_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_NUM,
					QueryCondition.in, loginNum_in));
		}
		if (loginTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.gt, loginTime_gt));
		}
		if (loginTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.ge, loginTime_ge));
		}
		if (loginTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.lt, loginTime_lt));
		}
		if (loginTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_TIME,
					QueryCondition.le, loginTime_le));
		}
		if (loginIp != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.eq, loginIp));
		}
		if (loginIp_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.like, loginIp_like));
		}
		if (loginIp_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.isNull, loginIp_isNull));
		}
		if (loginIp_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.isNotNull, loginIp_isNotNull));
		}
		if (loginIp_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LOGIN_IP,
					QueryCondition.in, loginIp_in));
		}
		if (lastLoginTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.gt, lastLoginTime_gt));
		}
		if (lastLoginTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.ge, lastLoginTime_ge));
		}
		if (lastLoginTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.lt, lastLoginTime_lt));
		}
		if (lastLoginTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_TIME,
					QueryCondition.le, lastLoginTime_le));
		}
		if (lastLoginIp != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.eq, lastLoginIp));
		}
		if (lastLoginIp_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.like, lastLoginIp_like));
		}
		if (lastLoginIp_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.isNull, lastLoginIp_isNull));
		}
		if (lastLoginIp_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.isNotNull, lastLoginIp_isNotNull));
		}
		if (lastLoginIp_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.LAST_LOGIN_IP,
					QueryCondition.in, lastLoginIp_in));
		}
		if (departmentId != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.eq, departmentId));
		}
		if (departmentId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.gt, departmentId_gt));
		}
		if (departmentId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.ge, departmentId_ge));
		}
		if (departmentId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.lt, departmentId_lt));
		}
		if (departmentId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.le, departmentId_le));
		}
		if (departmentId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.DEPARTMENT_ID,
					QueryCondition.in, departmentId_in));
		}
		if (personinfoId != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.eq, personinfoId));
		}
		if (personinfoId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.gt, personinfoId_gt));
		}
		if (personinfoId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.ge, personinfoId_ge));
		}
		if (personinfoId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.lt, personinfoId_lt));
		}
		if (personinfoId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.le, personinfoId_le));
		}
		if (personinfoId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.PERSONINFO_ID,
					QueryCondition.in, personinfoId_in));
		}
		if (createUserId != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.eq, createUserId));
		}
		if (createUserId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.gt, createUserId_gt));
		}
		if (createUserId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.ge, createUserId_ge));
		}
		if (createUserId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.lt, createUserId_lt));
		}
		if (createUserId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.le, createUserId_le));
		}
		if (createUserId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_USER_ID,
					QueryCondition.in, createUserId_in));
		}
		if (createTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.gt, createTime_gt));
		}
		if (createTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.ge, createTime_ge));
		}
		if (createTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.lt, createTime_lt));
		}
		if (createTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.CREATE_TIME,
					QueryCondition.le, createTime_le));
		}
		if (updateUserId != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.eq, updateUserId));
		}
		if (updateUserId_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.gt, updateUserId_gt));
		}
		if (updateUserId_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.ge, updateUserId_ge));
		}
		if (updateUserId_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.lt, updateUserId_lt));
		}
		if (updateUserId_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.le, updateUserId_le));
		}
		if (updateUserId_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_USER_ID,
					QueryCondition.in, updateUserId_in));
		}
		if (updateTime_gt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.gt, updateTime_gt));
		}
		if (updateTime_ge != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.ge, updateTime_ge));
		}
		if (updateTime_lt != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.lt, updateTime_lt));
		}
		if (updateTime_le != null) {
			qc.andCondition(new QueryCondition(UserEntity.UPDATE_TIME,
					QueryCondition.le, updateTime_le));
		}
		if (type != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.eq, type));
		}
		if (type_like != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.like, type_like));
		}
		if (type_isNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.isNull, type_isNull));
		}
		if (type_isNotNull != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.isNotNull, type_isNotNull));
		}
		if (type_in != null) {
			qc.andCondition(new QueryCondition(UserEntity.TYPE,
					QueryCondition.in, type_in));
		}

		if (qc.getQueryNextCondition() != null) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				result = dbManager.delByConditionsNoTransaction(UserEntity.class, qc);
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
	 * 重置指定用户的密码id
	 * @param userId 要重置密码的用户id
	 * @return true操作成功/false操作失败
	 */
	public boolean resetPassword(int userId) {
		boolean result = false;
		
		UserEntity userinfo = getById(userId);
		if (userinfo != null) {
			userinfo.setPassword(Md5Utils.MD5(userinfo.getLoginname() + "$" + Md5Utils.MD5("123456")));  //密码重新设为123456
			result = save(userinfo);
		}
		
		return result;
	}
}
