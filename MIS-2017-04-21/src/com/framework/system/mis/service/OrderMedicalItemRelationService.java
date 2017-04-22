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
import com.framework.system.mis.entity.MedicalItemEntity;
import com.framework.system.mis.entity.OrderEntity;
import com.framework.system.mis.entity.OrderMedicalItemRelationEntity;
import com.framework.system.util.StringUtil;

/**
 * @Title: Service
 * @Description: 订单体检项目关系表服务类
 * @author feng.gu
 * @date 2017-04-21 17:23:21
 * @version V1.0
 * 
 */
public class OrderMedicalItemRelationService {
	private static Logger logger = Logger
			.getLogger(OrderMedicalItemRelationService.class);
	private DBManager dbManager = DBManager.getInstance();

	private static OrderMedicalItemRelationService orderMedicalItemRelationService;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static OrderMedicalItemRelationService getInstance() {
		if (orderMedicalItemRelationService == null) {
			orderMedicalItemRelationService = new OrderMedicalItemRelationService();
		}
		return orderMedicalItemRelationService;
	}

	/**
	 * 保存记录
	 * 
	 * @param obj
	 */
	public boolean save(OrderMedicalItemRelationEntity orderMedicalItemRelation) {
		boolean result = false;
		if (orderMedicalItemRelation != null) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 关联信息保存
				OrderEntity orderEntity = orderMedicalItemRelation
						.getOrderEntity();
				if (orderEntity != null) {
					dbManager.saveNoTransaction(orderEntity);
					orderMedicalItemRelation.setOrderId(orderEntity.getId());
				}
				// 关联信息保存
				MedicalItemEntity medicalItem = orderMedicalItemRelation
						.getMedicalItem();
				if (medicalItem != null) {
					dbManager.saveNoTransaction(medicalItem);
					orderMedicalItemRelation.setMedicalItemId(medicalItem
							.getId());
				}
				result = dbManager.saveNoTransaction(orderMedicalItemRelation);
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
			List<OrderMedicalItemRelationEntity> orderMedicalItemRelationList) {
		boolean result = false;
		if (orderMedicalItemRelationList != null
				&& orderMedicalItemRelationList.size() > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				for (OrderMedicalItemRelationEntity orderMedicalItemRelation : orderMedicalItemRelationList) {
					if (orderMedicalItemRelation != null) {
						// 关联信息保存
						OrderEntity orderEntity = orderMedicalItemRelation
								.getOrderEntity();
						if (orderEntity != null) {
							dbManager.saveNoTransaction(orderEntity);
							orderMedicalItemRelation.setOrderId(orderEntity
									.getId());
						}
						// 关联信息保存
						MedicalItemEntity medicalItem = orderMedicalItemRelation
								.getMedicalItem();
						if (medicalItem != null) {
							dbManager.saveNoTransaction(medicalItem);
							orderMedicalItemRelation
									.setMedicalItemId(medicalItem.getId());
						}
						result = dbManager
								.saveNoTransaction(orderMedicalItemRelation);
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
	public OrderMedicalItemRelationEntity getById(Integer id) {
		OrderMedicalItemRelationEntity obj = null;
		if (id != null) {
			obj = (OrderMedicalItemRelationEntity) dbManager.getById(id,
					OrderMedicalItemRelationEntity.class);
		}
		return obj;
	}

	/**
	 * 根据id读取记录
	 * 
	 * @param id
	 *            主键
	 * @param orderEntityShow
	 *            是否查询关联信息
	 * @param medicalItemShow
	 *            是否查询关联信息
	 * @param obj
	 */
	public OrderMedicalItemRelationEntity getById(Integer id,
			Boolean orderEntityShow, Boolean medicalItemShow) {
		OrderMedicalItemRelationEntity obj = null;
		if (id != null) {
			obj = (OrderMedicalItemRelationEntity) dbManager.getById(id,
					OrderMedicalItemRelationEntity.class);
			// 查询关联内容
			if (orderEntityShow != null && orderEntityShow.booleanValue()
					&& obj != null && obj.getOrderId() != null
					&& obj.getOrderId() > 0) {
				OrderEntity orderEntity = (OrderEntity) dbManager.getById(
						obj.getOrderId(), OrderEntity.class);
				obj.setOrderEntity(orderEntity);
			}
			// 查询关联内容
			if (medicalItemShow != null && medicalItemShow.booleanValue()
					&& obj != null && obj.getMedicalItemId() != null
					&& obj.getMedicalItemId() > 0) {
				MedicalItemEntity medicalItem = (MedicalItemEntity) dbManager
						.getById(obj.getMedicalItemId(),
								MedicalItemEntity.class);
				obj.setMedicalItem(medicalItem);
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
	public List<OrderMedicalItemRelationEntity> getListByCondition(
			Map<String, Object> queryMap) {
		List<OrderMedicalItemRelationEntity> returnlist = null;
		List<Object> list = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		QueryCondition qc = changeMapToQc(queryMap);
		list = dbManager.queryByCondition(OrderMedicalItemRelationEntity.class,
				qc);
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<OrderMedicalItemRelationEntity>();
			for (Object obj : list) {
				returnlist.add((OrderMedicalItemRelationEntity) obj);
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
	 * @param orderEntityShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param medicalItemShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public List<OrderMedicalItemRelationEntity> getListByCondition(
			Map<String, Object> queryMap, List<OrderVO> orderList,
			Boolean orderEntityShow, Boolean medicalItemShow) {
		List<OrderMedicalItemRelationEntity> returnlist = null;
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
				OrderMedicalItemRelationEntity.class, qc, oc);
		int a = 0;
		if (orderEntityShow != null && orderEntityShow.booleanValue()) {
			a++;
		}
		if (medicalItemShow != null && medicalItemShow.booleanValue()) {
			a++;
		}
		if (a > 0 && list != null && list.size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				OrderMedicalItemRelationEntity obj = (OrderMedicalItemRelationEntity) list
						.get(i);
				// 查询关联内容
				if (orderEntityShow != null && orderEntityShow.booleanValue()
						&& obj != null && obj.getOrderId() != null
						&& obj.getOrderId() > 0) {
					OrderEntity orderEntity = (OrderEntity) dbManager.getById(
							obj.getOrderId(), OrderEntity.class);
					obj.setOrderEntity(orderEntity);
				}
				// 查询关联内容
				if (medicalItemShow != null && medicalItemShow.booleanValue()
						&& obj != null && obj.getMedicalItemId() != null
						&& obj.getMedicalItemId() > 0) {
					MedicalItemEntity medicalItem = (MedicalItemEntity) dbManager
							.getById(obj.getMedicalItemId(),
									MedicalItemEntity.class);
					obj.setMedicalItem(medicalItem);
				}
				result.add(obj);
			}
			list = result;
		}
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<OrderMedicalItemRelationEntity>();
			for (Object obj : list) {
				returnlist.add((OrderMedicalItemRelationEntity) obj);
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
		pagelist = dbManager.queryByCondition(
				OrderMedicalItemRelationEntity.class, qc, pageno, pagesize);
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
	 * @param orderEntityShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param medicalItemShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public PageList getListByCondition(Map<String, Object> queryMap,
			List<OrderVO> orderList, int pageno, int pagesize,
			Boolean orderEntityShow, Boolean medicalItemShow) {
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
				OrderMedicalItemRelationEntity.class, qc, dataRuleQclist, oc,
				pageno, pagesize);
		int a = 0;
		if (orderEntityShow != null && orderEntityShow.booleanValue()) {
			a++;
		}
		if (medicalItemShow != null && medicalItemShow.booleanValue()) {
			a++;
		}
		if (a > 0 && pagelist != null && pagelist.getResultList() != null
				&& pagelist.getResultList().size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < pagelist.getResultList().size(); i++) {
				OrderMedicalItemRelationEntity obj = (OrderMedicalItemRelationEntity) pagelist
						.getResultList().get(i);
				// 查询关联内容
				if (orderEntityShow != null && orderEntityShow.booleanValue()
						&& obj != null && obj.getOrderId() != null
						&& obj.getOrderId() > 0) {
					OrderEntity orderEntity = (OrderEntity) dbManager.getById(
							obj.getOrderId(), OrderEntity.class);
					obj.setOrderEntity(orderEntity);
				}
				// 查询关联内容
				if (medicalItemShow != null && medicalItemShow.booleanValue()
						&& obj != null && obj.getMedicalItemId() != null
						&& obj.getMedicalItemId() > 0) {
					MedicalItemEntity medicalItem = (MedicalItemEntity) dbManager
							.getById(obj.getMedicalItemId(),
									MedicalItemEntity.class);
					obj.setMedicalItem(medicalItem);
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
	public boolean del(Integer id, Boolean delOrderEntity,
			Boolean delMedicalItem) {
		boolean result = false;
		if (id != null && id > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 删除关联信息
				if (delOrderEntity != null && delOrderEntity.booleanValue()) {
					OrderMedicalItemRelationEntity orderMedicalItemRelation = (OrderMedicalItemRelationEntity) dbManager
							.getById(id, OrderMedicalItemRelationEntity.class);
					if (orderMedicalItemRelation != null
							&& orderMedicalItemRelation.getOrderId() != null) {
						dbManager.delNoTransaction(
								orderMedicalItemRelation.getOrderId(),
								OrderEntity.class);
					}
				}
				// 删除关联信息
				if (delMedicalItem != null && delMedicalItem.booleanValue()) {
					OrderMedicalItemRelationEntity orderMedicalItemRelation = (OrderMedicalItemRelationEntity) dbManager
							.getById(id, OrderMedicalItemRelationEntity.class);
					if (orderMedicalItemRelation != null
							&& orderMedicalItemRelation.getMedicalItemId() != null) {
						dbManager.delNoTransaction(
								orderMedicalItemRelation.getMedicalItemId(),
								MedicalItemEntity.class);
					}
				}
				result = dbManager.delNoTransaction(id,
						OrderMedicalItemRelationEntity.class);
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
						OrderMedicalItemRelationEntity.ID, QueryCondition.in,
						ids);
				result = dbManager.delByConditionsNoTransaction(
						OrderMedicalItemRelationEntity.class, qc);
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
			Boolean delOrderEntity, Boolean delMedicalItem) {
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
				if (delOrderEntity != null && delOrderEntity.booleanValue()) {
					List<Object> list = dbManager
							.queryByConditionNoTransaction(
									OrderMedicalItemRelationEntity.class, qc);
					String strIds = "";
					if (list != null && list.size() > 0) {
						for (Object obj : list) {
							OrderMedicalItemRelationEntity entity = (OrderMedicalItemRelationEntity) obj;
							strIds += entity.getOrderId() + ",";
						}
						strIds = strIds.substring(0, strIds.length() - 1);
					}
					if (strIds != null && !"".equals(strIds)) {
						QueryCondition qc1 = new QueryCondition(OrderEntity.ID,
								QueryCondition.in, strIds);
						dbManager.delByConditionsNoTransaction(
								OrderEntity.class, qc1);
					}

				}
				// 删除关联信息
				if (delMedicalItem != null && delMedicalItem.booleanValue()) {
					List<Object> list = dbManager
							.queryByConditionNoTransaction(
									OrderMedicalItemRelationEntity.class, qc);
					String strIds = "";
					if (list != null && list.size() > 0) {
						for (Object obj : list) {
							OrderMedicalItemRelationEntity entity = (OrderMedicalItemRelationEntity) obj;
							strIds += entity.getMedicalItemId() + ",";
						}
						strIds = strIds.substring(0, strIds.length() - 1);
					}
					if (strIds != null && !"".equals(strIds)) {
						QueryCondition qc1 = new QueryCondition(
								MedicalItemEntity.ID, QueryCondition.in, strIds);
						dbManager.delByConditionsNoTransaction(
								MedicalItemEntity.class, qc1);
					}

				}
				result = dbManager.delByConditionsNoTransaction(
						OrderMedicalItemRelationEntity.class, qc);
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
		Object orderId = queryMap.get("orderId");
		Object orderId_gt = queryMap.get("orderId_gt");
		Object orderId_ge = queryMap.get("orderId_ge");
		Object orderId_lt = queryMap.get("orderId_lt");
		Object orderId_le = queryMap.get("orderId_le");
		Object orderId_in = queryMap.get("orderId_in");
		Object medicalItemId = queryMap.get("medicalItemId");
		Object medicalItemId_gt = queryMap.get("medicalItemId_gt");
		Object medicalItemId_ge = queryMap.get("medicalItemId_ge");
		Object medicalItemId_lt = queryMap.get("medicalItemId_lt");
		Object medicalItemId_le = queryMap.get("medicalItemId_le");
		Object medicalItemId_in = queryMap.get("medicalItemId_in");
		Object medicalItemName = queryMap.get("medicalItemName");
		Object medicalItemName_gt = queryMap.get("medicalItemName_gt");
		Object medicalItemName_ge = queryMap.get("medicalItemName_ge");
		Object medicalItemName_lt = queryMap.get("medicalItemName_lt");
		Object medicalItemName_le = queryMap.get("medicalItemName_le");
		Object medicalItemName_in = queryMap.get("medicalItemName_in");
		Object medicalItemPrice = queryMap.get("medicalItemPrice");
		Object medicalItemPrice_gt = queryMap.get("medicalItemPrice_gt");
		Object medicalItemPrice_ge = queryMap.get("medicalItemPrice_ge");
		Object medicalItemPrice_lt = queryMap.get("medicalItemPrice_lt");
		Object medicalItemPrice_le = queryMap.get("medicalItemPrice_le");
		Object medicalItemPrice_in = queryMap.get("medicalItemPrice_in");

		QueryCondition qc = new QueryCondition(
				OrderMedicalItemRelationEntity.ID, QueryCondition.gt, "0");
		if (id != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ID, QueryCondition.eq, id));
		}
		if (id_gt != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ID, QueryCondition.gt, id_gt));
		}
		if (id_ge != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ID, QueryCondition.ge, id_ge));
		}
		if (id_lt != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ID, QueryCondition.lt, id_lt));
		}
		if (id_le != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ID, QueryCondition.le, id_le));
		}
		if (id_in != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ID, QueryCondition.in, id_in));
		}
		if (orderId != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ORDER_ID, QueryCondition.eq,
					orderId));
		}
		if (orderId_gt != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ORDER_ID, QueryCondition.gt,
					orderId_gt));
		}
		if (orderId_ge != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ORDER_ID, QueryCondition.ge,
					orderId_ge));
		}
		if (orderId_lt != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ORDER_ID, QueryCondition.lt,
					orderId_lt));
		}
		if (orderId_le != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ORDER_ID, QueryCondition.le,
					orderId_le));
		}
		if (orderId_in != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.ORDER_ID, QueryCondition.in,
					orderId_in));
		}
		if (medicalItemId != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_ID,
					QueryCondition.eq, medicalItemId));
		}
		if (medicalItemId_gt != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_ID,
					QueryCondition.gt, medicalItemId_gt));
		}
		if (medicalItemId_ge != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_ID,
					QueryCondition.ge, medicalItemId_ge));
		}
		if (medicalItemId_lt != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_ID,
					QueryCondition.lt, medicalItemId_lt));
		}
		if (medicalItemId_le != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_ID,
					QueryCondition.le, medicalItemId_le));
		}
		if (medicalItemId_in != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_ID,
					QueryCondition.in, medicalItemId_in));
		}
		if (medicalItemName != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_NAME,
					QueryCondition.eq, medicalItemName));
		}
		if (medicalItemName_gt != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_NAME,
					QueryCondition.gt, medicalItemName_gt));
		}
		if (medicalItemName_ge != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_NAME,
					QueryCondition.ge, medicalItemName_ge));
		}
		if (medicalItemName_lt != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_NAME,
					QueryCondition.lt, medicalItemName_lt));
		}
		if (medicalItemName_le != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_NAME,
					QueryCondition.le, medicalItemName_le));
		}
		if (medicalItemName_in != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_NAME,
					QueryCondition.in, medicalItemName_in));
		}
		if (medicalItemPrice != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_PRICE,
					QueryCondition.eq, medicalItemPrice));
		}
		if (medicalItemPrice_gt != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_PRICE,
					QueryCondition.gt, medicalItemPrice_gt));
		}
		if (medicalItemPrice_ge != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_PRICE,
					QueryCondition.ge, medicalItemPrice_ge));
		}
		if (medicalItemPrice_lt != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_PRICE,
					QueryCondition.lt, medicalItemPrice_lt));
		}
		if (medicalItemPrice_le != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_PRICE,
					QueryCondition.le, medicalItemPrice_le));
		}
		if (medicalItemPrice_in != null) {
			qc.andCondition(new QueryCondition(
					OrderMedicalItemRelationEntity.MEDICAL_ITEM_PRICE,
					QueryCondition.in, medicalItemPrice_in));
		}
		return qc;
	}

}
