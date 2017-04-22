package com.framework.system.mis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;

import com.framework.system.db.connect.DbUtils;
import com.framework.system.db.manager.DBManager;
import com.framework.system.db.query.OrderByCondition;
import com.framework.system.db.query.OrderVO;
import com.framework.system.db.query.PageList;
import com.framework.system.db.query.QueryCondition;
import com.framework.system.db.transaction.TransactionManager;
import com.framework.system.mis.entity.HospitalDetectingItemRelationEntity;
import com.framework.system.mis.entity.HospitalEntity;
import com.framework.system.util.StringUtil;

/**
 * @Title: Service
 * @Description: 医院体检项目关系表服务类
 * @author feng.gu
 * @date 2017-04-21 17:12:18
 * @version V1.0
 * 
 */
public class HospitalDetectingItemRelationService {
	private static Logger logger = Logger
			.getLogger(HospitalDetectingItemRelationService.class);
	private DBManager dbManager = DBManager.getInstance();

	private static HospitalDetectingItemRelationService hospitalDetectingItemRelationService;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static HospitalDetectingItemRelationService getInstance() {
		if (hospitalDetectingItemRelationService == null) {
			hospitalDetectingItemRelationService = new HospitalDetectingItemRelationService();
		}
		return hospitalDetectingItemRelationService;
	}

	/**
	 * 保存记录
	 * 
	 * @param obj
	 */
	public boolean save(
			HospitalDetectingItemRelationEntity hospitalDetectingItemRelation) {
		boolean result = false;
		if (hospitalDetectingItemRelation != null) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 关联信息保存
				HospitalEntity hospitalEntity = hospitalDetectingItemRelation
						.getHospitalEntity();
				if (hospitalEntity != null) {
					dbManager.saveNoTransaction(hospitalEntity);
					hospitalDetectingItemRelation.setHospitalId(hospitalEntity
							.getId());
				}
				result = dbManager
						.saveNoTransaction(hospitalDetectingItemRelation);
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
	public boolean saveList(
			List<HospitalDetectingItemRelationEntity> hospitalDetectingItemRelationList) {
		boolean result = false;
		if (hospitalDetectingItemRelationList != null
				&& hospitalDetectingItemRelationList.size() > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				for (HospitalDetectingItemRelationEntity hospitalDetectingItemRelation : hospitalDetectingItemRelationList) {
					if (hospitalDetectingItemRelation != null) {
						// 关联信息保存
						HospitalEntity hospitalEntity = hospitalDetectingItemRelation
								.getHospitalEntity();
						if (hospitalEntity != null) {
							dbManager.saveNoTransaction(hospitalEntity);
							hospitalDetectingItemRelation
									.setHospitalId(hospitalEntity.getId());
						}
						result = dbManager
								.saveNoTransaction(hospitalDetectingItemRelation);
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
	public HospitalDetectingItemRelationEntity getById(Integer id) {
		HospitalDetectingItemRelationEntity obj = null;
		if (id != null) {
			obj = (HospitalDetectingItemRelationEntity) dbManager.getById(id,
					HospitalDetectingItemRelationEntity.class);
		}
		return obj;
	}

	/**
	 * 根据id读取记录
	 * 
	 * @param id
	 *            主键
	 * @param hospitalEntityShow
	 *            是否查询关联信息
	 * @param obj
	 */
	public HospitalDetectingItemRelationEntity getById(Integer id,
			Boolean hospitalEntityShow) {
		HospitalDetectingItemRelationEntity obj = null;
		if (id != null) {
			obj = (HospitalDetectingItemRelationEntity) dbManager.getById(id,
					HospitalDetectingItemRelationEntity.class);
			// 查询关联内容
			if (hospitalEntityShow != null && hospitalEntityShow.booleanValue()
					&& obj != null && obj.getHospitalId() != null
					&& obj.getHospitalId() > 0) {
				HospitalEntity hospitalEntity = (HospitalEntity) dbManager
						.getById(obj.getHospitalId(), HospitalEntity.class);
				obj.setHospitalEntity(hospitalEntity);
			}
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
	public List<HospitalDetectingItemRelationEntity> getListByCondition(
			Map<String, Object> queryMap) {
		List<HospitalDetectingItemRelationEntity> returnlist = null;
		List<Object> list = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		QueryCondition qc = changeMapToQc(queryMap);
		list = dbManager.queryByCondition(
				HospitalDetectingItemRelationEntity.class, qc);
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<HospitalDetectingItemRelationEntity>();
			for (Object obj : list) {
				returnlist.add((HospitalDetectingItemRelationEntity) obj);
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
	 * @param hospitalEntityShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public List<HospitalDetectingItemRelationEntity> getListByCondition(
			Map<String, Object> queryMap, List<OrderVO> orderList,
			Boolean hospitalEntityShow) {
		List<HospitalDetectingItemRelationEntity> returnlist = null;
		List<Object> list = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		QueryCondition qc = changeMapToQc(queryMap);
		OrderByCondition oc = null;
		if (orderList != null && orderList.size() > 0) {
			for (int i = 0; i < orderList.size(); i++) {
				OrderVO order = orderList.get(i);
				String orderColumnt = null;
				String orderType = null;
				if (order.getName() != null && !"".equals(order.getName())) {
					orderColumnt = StringUtil.formatFieldToColumnt(order
							.getName());
					orderType = order.getOrderType();
					if (orderType == null || "".equals(orderType.trim())) {
						orderType = OrderByCondition.desc;
					}
					if (i == 0) {
						oc = new OrderByCondition(orderColumnt, orderType);
					} else {
						oc.orderByCondition(new OrderByCondition(orderColumnt,
								orderType));
					}
				}

			}
		}
		list = dbManager.queryByConditions(
				HospitalDetectingItemRelationEntity.class, qc, oc);
		int a = 0;
		if (hospitalEntityShow != null && hospitalEntityShow.booleanValue()) {
			a++;
		}
		if (a > 0 && list != null && list.size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				HospitalDetectingItemRelationEntity obj = (HospitalDetectingItemRelationEntity) list
						.get(i);
				// 查询关联内容
				if (hospitalEntityShow != null
						&& hospitalEntityShow.booleanValue() && obj != null
						&& obj.getHospitalId() != null
						&& obj.getHospitalId() > 0) {
					HospitalEntity hospitalEntity = (HospitalEntity) dbManager
							.getById(obj.getHospitalId(), HospitalEntity.class);
					obj.setHospitalEntity(hospitalEntity);
				}
				result.add(obj);
			}
			list = result;
		}
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<HospitalDetectingItemRelationEntity>();
			for (Object obj : list) {
				returnlist.add((HospitalDetectingItemRelationEntity) obj);
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
		QueryCondition qc = changeMapToQc(queryMap);
		pagelist = dbManager
				.queryByCondition(HospitalDetectingItemRelationEntity.class,
						qc, pageno, pagesize);
		return pagelist;
	}

	/**
	 * 根据条件查询记录集合（带分页 带排序 带级联查询）
	 * 
	 * @param queryMap
	 *            查询条件集合
	 * @param orderList
	 *            排序条件集合
	 * @param pageno
	 *            查询页码
	 * @param pagesize
	 *            查询每页记录条数
	 * @param hospitalEntityShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public PageList getListByCondition(Map<String, Object> queryMap,
			List<OrderVO> orderList, int pageno, int pagesize,
			Boolean hospitalEntityShow) {
		PageList pagelist = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		QueryCondition qc = changeMapToQc(queryMap);
		OrderByCondition oc = null;
		if (orderList != null && orderList.size() > 0) {
			for (int i = 0; i < orderList.size(); i++) {
				OrderVO order = orderList.get(i);
				String orderColumnt = null;
				String orderType = null;
				if (order.getName() != null && !"".equals(order.getName())) {
					orderColumnt = StringUtil.formatFieldToColumnt(order
							.getName());
					orderType = order.getOrderType();
					if (orderType == null || "".equals(orderType.trim())) {
						orderType = OrderByCondition.desc;
					}
					if (i == 0) {
						oc = new OrderByCondition(orderColumnt, orderType);
					} else {
						oc.orderByCondition(new OrderByCondition(orderColumnt,
								orderType));
					}
				}

			}
		}
		// 数据权限
		List<QueryCondition> dataRuleQclist = null;
		List<Map<String, Object>> dataRuleMapList = (List<Map<String, Object>>) queryMap
				.get("dataRuleMapList");
		if (dataRuleMapList != null && dataRuleMapList.size() > 0) {
			dataRuleQclist = new ArrayList<QueryCondition>();
			for (Map<String, Object> dataRuleMap : dataRuleMapList) {
				QueryCondition dataRuleQc = changeMapToQc(dataRuleMap);
				dataRuleQclist.add(dataRuleQc);
			}
		}
		pagelist = dbManager.queryByConditions(
				HospitalDetectingItemRelationEntity.class, qc, dataRuleQclist,
				oc, pageno, pagesize);
		int a = 0;
		if (hospitalEntityShow != null && hospitalEntityShow.booleanValue()) {
			a++;
		}
		if (a > 0 && pagelist != null && pagelist.getResultList() != null
				&& pagelist.getResultList().size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < pagelist.getResultList().size(); i++) {
				HospitalDetectingItemRelationEntity obj = (HospitalDetectingItemRelationEntity) pagelist
						.getResultList().get(i);
				// 查询关联内容
				if (hospitalEntityShow != null
						&& hospitalEntityShow.booleanValue() && obj != null
						&& obj.getHospitalId() != null
						&& obj.getHospitalId() > 0) {
					HospitalEntity hospitalEntity = (HospitalEntity) dbManager
							.getById(obj.getHospitalId(), HospitalEntity.class);
					obj.setHospitalEntity(hospitalEntity);
				}
				result.add(obj);
			}
			pagelist.setResultList(result);
		}
		return pagelist;
	}

	/**
	 * 删除记录
	 * 
	 * @param id
	 *            主键
	 * @param obj
	 */
	public boolean del(Integer id, Boolean delHospitalEntity) {
		boolean result = false;
		if (id != null && id > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 删除关联信息
				if (delHospitalEntity != null
						&& delHospitalEntity.booleanValue()) {
					HospitalDetectingItemRelationEntity hospitalDetectingItemRelation = (HospitalDetectingItemRelationEntity) dbManager
							.getById(id,
									HospitalDetectingItemRelationEntity.class);
					if (hospitalDetectingItemRelation != null
							&& hospitalDetectingItemRelation.getHospitalId() != null) {
						dbManager.delNoTransaction(
								hospitalDetectingItemRelation.getHospitalId(),
								HospitalEntity.class);
					}
				}
				result = dbManager.delNoTransaction(id,
						HospitalDetectingItemRelationEntity.class);
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
				QueryCondition qc = new QueryCondition(
						HospitalDetectingItemRelationEntity.ID,
						QueryCondition.in, ids);
				result = dbManager.delByConditionsNoTransaction(
						HospitalDetectingItemRelationEntity.class, qc);
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
	public boolean delList(Map<String, Object> queryMap,
			Boolean delHospitalEntity) {
		boolean result = false;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		QueryCondition qc = changeMapToQc(queryMap);
		if (qc.getQueryNextCondition() != null) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 删除关联信息
				if (delHospitalEntity != null
						&& delHospitalEntity.booleanValue()) {
					List<Object> list = dbManager
							.queryByConditionNoTransaction(
									HospitalDetectingItemRelationEntity.class,
									qc);
					String strIds = "";
					if (list != null && list.size() > 0) {
						for (Object obj : list) {
							HospitalDetectingItemRelationEntity entity = (HospitalDetectingItemRelationEntity) obj;
							strIds += entity.getHospitalId() + ",";
						}
						strIds = strIds.substring(0, strIds.length() - 1);
					}
					if (strIds != null && !"".equals(strIds)) {
						QueryCondition qc1 = new QueryCondition(
								HospitalEntity.ID, QueryCondition.in, strIds);
						dbManager.delByConditionsNoTransaction(
								HospitalEntity.class, qc1);
					}

				}
				result = dbManager.delByConditionsNoTransaction(
						HospitalDetectingItemRelationEntity.class, qc);
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

	private QueryCondition changeMapToQc(Map<String, Object> queryMap) {
		Object id = queryMap.get("id");
		Object id_gt = queryMap.get("id_gt");
		Object id_ge = queryMap.get("id_ge");
		Object id_lt = queryMap.get("id_lt");
		Object id_le = queryMap.get("id_le");
		Object id_in = queryMap.get("id_in");
		Object hospitalId = queryMap.get("hospitalId");
		Object hospitalId_gt = queryMap.get("hospitalId_gt");
		Object hospitalId_ge = queryMap.get("hospitalId_ge");
		Object hospitalId_lt = queryMap.get("hospitalId_lt");
		Object hospitalId_le = queryMap.get("hospitalId_le");
		Object hospitalId_in = queryMap.get("hospitalId_in");
		Object detectingItem = queryMap.get("detectingItem");
		Object detectingItem_gt = queryMap.get("detectingItem_gt");
		Object detectingItem_ge = queryMap.get("detectingItem_ge");
		Object detectingItem_lt = queryMap.get("detectingItem_lt");
		Object detectingItem_le = queryMap.get("detectingItem_le");
		Object detectingItem_in = queryMap.get("detectingItem_in");

		QueryCondition qc = new QueryCondition(
				HospitalDetectingItemRelationEntity.ID, QueryCondition.gt, "0");
		if (id != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.ID, QueryCondition.eq,
					id));
		}
		if (id_gt != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.ID, QueryCondition.gt,
					id_gt));
		}
		if (id_ge != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.ID, QueryCondition.ge,
					id_ge));
		}
		if (id_lt != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.ID, QueryCondition.lt,
					id_lt));
		}
		if (id_le != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.ID, QueryCondition.le,
					id_le));
		}
		if (id_in != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.ID, QueryCondition.in,
					id_in));
		}
		if (hospitalId != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.HOSPITAL_ID,
					QueryCondition.eq, hospitalId));
		}
		if (hospitalId_gt != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.HOSPITAL_ID,
					QueryCondition.gt, hospitalId_gt));
		}
		if (hospitalId_ge != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.HOSPITAL_ID,
					QueryCondition.ge, hospitalId_ge));
		}
		if (hospitalId_lt != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.HOSPITAL_ID,
					QueryCondition.lt, hospitalId_lt));
		}
		if (hospitalId_le != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.HOSPITAL_ID,
					QueryCondition.le, hospitalId_le));
		}
		if (hospitalId_in != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.HOSPITAL_ID,
					QueryCondition.in, hospitalId_in));
		}
		if (detectingItem != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.DETECTING_ITEM,
					QueryCondition.eq, detectingItem));
		}
		if (detectingItem_gt != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.DETECTING_ITEM,
					QueryCondition.gt, detectingItem_gt));
		}
		if (detectingItem_ge != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.DETECTING_ITEM,
					QueryCondition.ge, detectingItem_ge));
		}
		if (detectingItem_lt != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.DETECTING_ITEM,
					QueryCondition.lt, detectingItem_lt));
		}
		if (detectingItem_le != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.DETECTING_ITEM,
					QueryCondition.le, detectingItem_le));
		}
		if (detectingItem_in != null) {
			qc.andCondition(new QueryCondition(
					HospitalDetectingItemRelationEntity.DETECTING_ITEM,
					QueryCondition.in, detectingItem_in));
		}
		return qc;
	}

}
