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
import com.framework.system.mis.entity.OrderEntity;
import com.framework.system.mis.entity.PayInfoEntity;
import com.framework.system.util.StringUtil;

/**
 * @Title: Service
 * @Description: 支付信息表服务类
 * @author feng.gu
 * @date 2017-04-21 17:17:50
 * @version V1.0
 * 
 */
public class PayInfoService {
	private static Logger logger = Logger.getLogger(PayInfoService.class);
	private DBManager dbManager = DBManager.getInstance();

	private static PayInfoService payInfoService;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static PayInfoService getInstance() {
		if (payInfoService == null) {
			payInfoService = new PayInfoService();
		}
		return payInfoService;
	}

	/**
	 * 保存记录
	 * 
	 * @param obj
	 */
	public boolean save(PayInfoEntity payInfo) {
		boolean result = false;
		if (payInfo != null) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 关联信息保存
				OrderEntity orderEntity = payInfo.getOrderEntity();
				if (orderEntity != null) {
					dbManager.saveNoTransaction(orderEntity);
					payInfo.setOrderId(orderEntity.getId());
				}
				result = dbManager.saveNoTransaction(payInfo);
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
	public boolean saveList(List<PayInfoEntity> payInfoList) {
		boolean result = false;
		if (payInfoList != null && payInfoList.size() > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				for (PayInfoEntity payInfo : payInfoList) {
					if (payInfo != null) {
						// 关联信息保存
						OrderEntity orderEntity = payInfo.getOrderEntity();
						if (orderEntity != null) {
							dbManager.saveNoTransaction(orderEntity);
							payInfo.setOrderId(orderEntity.getId());
						}
						result = dbManager.saveNoTransaction(payInfo);
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
	public PayInfoEntity getById(Integer id) {
		PayInfoEntity obj = null;
		if (id != null) {
			obj = (PayInfoEntity) dbManager.getById(id, PayInfoEntity.class);
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
	 * @param obj
	 */
	public PayInfoEntity getById(Integer id, Boolean orderEntityShow) {
		PayInfoEntity obj = null;
		if (id != null) {
			obj = (PayInfoEntity) dbManager.getById(id, PayInfoEntity.class);
			// 查询关联内容
			if (orderEntityShow != null && orderEntityShow.booleanValue()
					&& obj != null && obj.getOrderId() != null
					&& obj.getOrderId() > 0) {
				OrderEntity orderEntity = (OrderEntity) dbManager.getById(
						obj.getOrderId(), OrderEntity.class);
				obj.setOrderEntity(orderEntity);
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
	public List<PayInfoEntity> getListByCondition(Map<String, Object> queryMap) {
		List<PayInfoEntity> returnlist = null;
		List<Object> list = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		QueryCondition qc = changeMapToQc(queryMap);
		list = dbManager.queryByCondition(PayInfoEntity.class, qc);
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<PayInfoEntity>();
			for (Object obj : list) {
				returnlist.add((PayInfoEntity) obj);
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
	 * @return
	 */
	public List<PayInfoEntity> getListByCondition(Map<String, Object> queryMap,
			List<OrderVO> orderList, Boolean orderEntityShow) {
		List<PayInfoEntity> returnlist = null;
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
		list = dbManager.queryByConditions(PayInfoEntity.class, qc, oc);
		int a = 0;
		if (orderEntityShow != null && orderEntityShow.booleanValue()) {
			a++;
		}
		if (a > 0 && list != null && list.size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				PayInfoEntity obj = (PayInfoEntity) list.get(i);
				// 查询关联内容
				if (orderEntityShow != null && orderEntityShow.booleanValue()
						&& obj != null && obj.getOrderId() != null
						&& obj.getOrderId() > 0) {
					OrderEntity orderEntity = (OrderEntity) dbManager.getById(
							obj.getOrderId(), OrderEntity.class);
					obj.setOrderEntity(orderEntity);
				}
				result.add(obj);
			}
			list = result;
		}
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<PayInfoEntity>();
			for (Object obj : list) {
				returnlist.add((PayInfoEntity) obj);
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
		pagelist = dbManager.queryByCondition(PayInfoEntity.class, qc, pageno,
				pagesize);
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
	 * @return
	 */
	public PageList getListByCondition(Map<String, Object> queryMap,
			List<OrderVO> orderList, int pageno, int pagesize,
			Boolean orderEntityShow) {
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
		pagelist = dbManager.queryByConditions(PayInfoEntity.class, qc,
				dataRuleQclist, oc, pageno, pagesize);
		int a = 0;
		if (orderEntityShow != null && orderEntityShow.booleanValue()) {
			a++;
		}
		if (a > 0 && pagelist != null && pagelist.getResultList() != null
				&& pagelist.getResultList().size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < pagelist.getResultList().size(); i++) {
				PayInfoEntity obj = (PayInfoEntity) pagelist.getResultList()
						.get(i);
				// 查询关联内容
				if (orderEntityShow != null && orderEntityShow.booleanValue()
						&& obj != null && obj.getOrderId() != null
						&& obj.getOrderId() > 0) {
					OrderEntity orderEntity = (OrderEntity) dbManager.getById(
							obj.getOrderId(), OrderEntity.class);
					obj.setOrderEntity(orderEntity);
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
	public boolean del(Integer id, Boolean delOrderEntity) {
		boolean result = false;
		if (id != null && id > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 删除关联信息
				if (delOrderEntity != null && delOrderEntity.booleanValue()) {
					PayInfoEntity payInfo = (PayInfoEntity) dbManager.getById(
							id, PayInfoEntity.class);
					if (payInfo != null && payInfo.getOrderId() != null) {
						dbManager.delNoTransaction(payInfo.getOrderId(),
								OrderEntity.class);
					}
				}
				result = dbManager.delNoTransaction(id, PayInfoEntity.class);
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
				QueryCondition qc = new QueryCondition(PayInfoEntity.ID,
						QueryCondition.in, ids);
				result = dbManager.delByConditionsNoTransaction(
						PayInfoEntity.class, qc);
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
	public boolean delList(Map<String, Object> queryMap, Boolean delOrderEntity) {
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
							.queryByConditionNoTransaction(PayInfoEntity.class,
									qc);
					String strIds = "";
					if (list != null && list.size() > 0) {
						for (Object obj : list) {
							PayInfoEntity entity = (PayInfoEntity) obj;
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
				result = dbManager.delByConditionsNoTransaction(
						PayInfoEntity.class, qc);
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
		Object money = queryMap.get("money");
		Object money_like = queryMap.get("money_like");
		Object money_isNull = queryMap.get("money_isNull");
		Object money_isNotNull = queryMap.get("money_isNotNull");
		Object money_in = queryMap.get("money_in");
		Object type = queryMap.get("type");
		Object type_like = queryMap.get("type_like");
		Object type_isNull = queryMap.get("type_isNull");
		Object type_isNotNull = queryMap.get("type_isNotNull");
		Object type_in = queryMap.get("type_in");
		Object payTime_gt = queryMap.get("payTime_gt");
		Object payTime_ge = queryMap.get("payTime_ge");
		Object payTime_lt = queryMap.get("payTime_lt");
		Object payTime_le = queryMap.get("payTime_le");
		Object payNum = queryMap.get("payNum");
		Object payNum_like = queryMap.get("payNum_like");
		Object payNum_isNull = queryMap.get("payNum_isNull");
		Object payNum_isNotNull = queryMap.get("payNum_isNotNull");
		Object payNum_in = queryMap.get("payNum_in");

		QueryCondition qc = new QueryCondition(PayInfoEntity.ID,
				QueryCondition.gt, "0");
		if (id != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ID,
					QueryCondition.eq, id));
		}
		if (id_gt != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ID,
					QueryCondition.gt, id_gt));
		}
		if (id_ge != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ID,
					QueryCondition.ge, id_ge));
		}
		if (id_lt != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ID,
					QueryCondition.lt, id_lt));
		}
		if (id_le != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ID,
					QueryCondition.le, id_le));
		}
		if (id_in != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ID,
					QueryCondition.in, id_in));
		}
		if (orderId != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ORDER_ID,
					QueryCondition.eq, orderId));
		}
		if (orderId_gt != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ORDER_ID,
					QueryCondition.gt, orderId_gt));
		}
		if (orderId_ge != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ORDER_ID,
					QueryCondition.ge, orderId_ge));
		}
		if (orderId_lt != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ORDER_ID,
					QueryCondition.lt, orderId_lt));
		}
		if (orderId_le != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ORDER_ID,
					QueryCondition.le, orderId_le));
		}
		if (orderId_in != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.ORDER_ID,
					QueryCondition.in, orderId_in));
		}
		if (money != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.MONEY,
					QueryCondition.eq, money));
		}
		if (money_like != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.MONEY,
					QueryCondition.like, money_like));
		}
		if (money_isNull != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.MONEY,
					QueryCondition.isNull, money_isNull));
		}
		if (money_isNotNull != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.MONEY,
					QueryCondition.isNotNull, money_isNotNull));
		}
		if (money_in != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.MONEY,
					QueryCondition.in, money_in));
		}
		if (type != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.TYPE,
					QueryCondition.eq, type));
		}
		if (type_like != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.TYPE,
					QueryCondition.like, type_like));
		}
		if (type_isNull != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.TYPE,
					QueryCondition.isNull, type_isNull));
		}
		if (type_isNotNull != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.TYPE,
					QueryCondition.isNotNull, type_isNotNull));
		}
		if (type_in != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.TYPE,
					QueryCondition.in, type_in));
		}
		if (payTime_gt != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.PAY_TIME,
					QueryCondition.gt, payTime_gt));
		}
		if (payTime_ge != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.PAY_TIME,
					QueryCondition.ge, payTime_ge));
		}
		if (payTime_lt != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.PAY_TIME,
					QueryCondition.lt, payTime_lt));
		}
		if (payTime_le != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.PAY_TIME,
					QueryCondition.le, payTime_le));
		}
		if (payNum != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.PAY_NUM,
					QueryCondition.eq, payNum));
		}
		if (payNum_like != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.PAY_NUM,
					QueryCondition.like, payNum_like));
		}
		if (payNum_isNull != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.PAY_NUM,
					QueryCondition.isNull, payNum_isNull));
		}
		if (payNum_isNotNull != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.PAY_NUM,
					QueryCondition.isNotNull, payNum_isNotNull));
		}
		if (payNum_in != null) {
			qc.andCondition(new QueryCondition(PayInfoEntity.PAY_NUM,
					QueryCondition.in, payNum_in));
		}
		return qc;
	}

}
