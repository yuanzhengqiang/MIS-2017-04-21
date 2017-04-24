package mis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mis.entity.MedicalReportEntity;
import mis.entity.OrderEntity;
import mis.entity.ServicePersonEntity;

import org.apache.log4j.Logger;

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
 * @Description: 订单表服务类
 * @author feng.gu
 * @date 2017-04-21 16:39:13
 * @version V1.0
 * 
 */
public class OrderService {
	private static Logger logger = Logger.getLogger(OrderService.class);
	private DBManager dbManager = DBManager.getInstance();

	private static OrderService orderService;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static OrderService getInstance() {
		if (orderService == null) {
			orderService = new OrderService();
		}
		return orderService;
	}

	/**
	 * 保存记录
	 * 
	 * @param obj
	 */
	public boolean save(OrderEntity order) {
		boolean result = false;
		if (order != null) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 关联信息保存
				if (order.getChildOrderList() != null
						&& order.getChildOrderList().size() > 0) {
					for (OrderEntity orderEntity : order.getChildOrderList()) {
						dbManager.saveNoTransaction(orderEntity);
					}
				}
				// 关联信息保存
				ServicePersonEntity servicePerson = order.getServicePerson();
				if (servicePerson != null) {
					dbManager.saveNoTransaction(servicePerson);
					order.setServicePersonId(servicePerson.getId());
				}
				// 关联信息保存
				MedicalReportEntity medicalReport = order.getMedicalReport();
				if (medicalReport != null) {
					dbManager.saveNoTransaction(medicalReport);
					order.setMedicalReportId(medicalReport.getId());
				}
				result = dbManager.saveNoTransaction(order);
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
	public boolean saveList(List<OrderEntity> orderList) {
		boolean result = false;
		if (orderList != null && orderList.size() > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				for (OrderEntity order : orderList) {
					if (order != null) {
						// 关联信息保存
						if (order.getChildOrderList() != null
								&& order.getChildOrderList().size() > 0) {
							for (OrderEntity orderEntity : order
									.getChildOrderList()) {
								dbManager.saveNoTransaction(orderEntity);
							}
						}
						// 关联信息保存
						ServicePersonEntity servicePerson = order
								.getServicePerson();
						if (servicePerson != null) {
							dbManager.saveNoTransaction(servicePerson);
							order.setServicePersonId(servicePerson.getId());
						}
						// 关联信息保存
						MedicalReportEntity medicalReport = order
								.getMedicalReport();
						if (medicalReport != null) {
							dbManager.saveNoTransaction(medicalReport);
							order.setMedicalReportId(medicalReport.getId());
						}
						result = dbManager.saveNoTransaction(order);
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
	public OrderEntity getById(Integer id) {
		OrderEntity obj = null;
		if (id != null) {
			obj = (OrderEntity) dbManager.getById(id, OrderEntity.class);
		}
		return obj;
	}

	/**
	 * 根据id读取记录
	 * 
	 * @param id
	 *            主键
	 * @param parentOrderShow
	 *            是否查询关联信息
	 * @param childOrderListShow
	 *            是否查询关联信息
	 * @param servicePersonShow
	 *            是否查询关联信息
	 * @param medicalReportShow
	 *            是否查询关联信息
	 * @param obj
	 */
	public OrderEntity getById(Integer id, Boolean servicePersonShow,
			Boolean medicalReportShow) {
		OrderEntity obj = null;
		if (id != null) {
			obj = (OrderEntity) dbManager.getById(id, OrderEntity.class);
			// 查询关联内容
			if (servicePersonShow != null && servicePersonShow.booleanValue()
					&& obj != null && obj.getServicePersonId() != null
					&& obj.getServicePersonId() > 0) {
				ServicePersonEntity servicePerson = (ServicePersonEntity) dbManager
						.getById(obj.getServicePersonId(),
								ServicePersonEntity.class);
				obj.setServicePerson(servicePerson);
			}
			// 查询关联内容
			if (medicalReportShow != null && medicalReportShow.booleanValue()
					&& obj != null && obj.getMedicalReportId() != null
					&& obj.getMedicalReportId() > 0) {
				MedicalReportEntity medicalReport = (MedicalReportEntity) dbManager
						.getById(obj.getMedicalReportId(),
								MedicalReportEntity.class);
				obj.setMedicalReport(medicalReport);
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
	public List<OrderEntity> getListByCondition(Map<String, Object> queryMap) {
		List<OrderEntity> returnlist = null;
		List<Object> list = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		QueryCondition qc = changeMapToQc(queryMap);
		list = dbManager.queryByCondition(OrderEntity.class, qc);
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<OrderEntity>();
			for (Object obj : list) {
				returnlist.add((OrderEntity) obj);
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
	 * @param parentOrderShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param childOrderListShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param servicePersonShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param medicalReportShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public List<OrderEntity> getListByCondition(Map<String, Object> queryMap,
			List<OrderVO> orderList, Boolean servicePersonShow,
			Boolean medicalReportShow) {
		List<OrderEntity> returnlist = null;
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
		list = dbManager.queryByConditions(OrderEntity.class, qc, oc);
		int a = 0;
		if (servicePersonShow != null && servicePersonShow.booleanValue()) {
			a++;
		}
		if (medicalReportShow != null && medicalReportShow.booleanValue()) {
			a++;
		}
		if (a > 0 && list != null && list.size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				OrderEntity obj = (OrderEntity) list.get(i);
				// 查询关联内容
				if (servicePersonShow != null
						&& servicePersonShow.booleanValue() && obj != null
						&& obj.getServicePersonId() != null
						&& obj.getServicePersonId() > 0) {
					ServicePersonEntity servicePerson = (ServicePersonEntity) dbManager
							.getById(obj.getServicePersonId(),
									ServicePersonEntity.class);
					obj.setServicePerson(servicePerson);
				}
				// 查询关联内容
				if (medicalReportShow != null
						&& medicalReportShow.booleanValue() && obj != null
						&& obj.getMedicalReportId() != null
						&& obj.getMedicalReportId() > 0) {
					MedicalReportEntity medicalReport = (MedicalReportEntity) dbManager
							.getById(obj.getMedicalReportId(),
									MedicalReportEntity.class);
					obj.setMedicalReport(medicalReport);
				}
				result.add(obj);
			}
			list = result;
		}
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<OrderEntity>();
			for (Object obj : list) {
				returnlist.add((OrderEntity) obj);
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
		pagelist = dbManager.queryByCondition(OrderEntity.class, qc, pageno,
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
	 * @param parentOrderShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param childOrderListShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param servicePersonShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @param medicalReportShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public PageList getListByCondition(Map<String, Object> queryMap, List<OrderVO> orderList, int pageno, int pagesize,
			Boolean servicePersonShow, Boolean medicalReportShow) {
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
		pagelist = dbManager.queryByConditions(OrderEntity.class, qc,
				dataRuleQclist, oc, pageno, pagesize);
		int a = 0;
		if (servicePersonShow != null && servicePersonShow.booleanValue()) {
			a++;
		}
		if (medicalReportShow != null && medicalReportShow.booleanValue()) {
			a++;
		}
		if (a > 0 && pagelist != null && pagelist.getResultList() != null
				&& pagelist.getResultList().size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < pagelist.getResultList().size(); i++) {
				OrderEntity obj = (OrderEntity) pagelist.getResultList().get(i);
				// 查询关联内容
				if (servicePersonShow != null
						&& servicePersonShow.booleanValue() && obj != null
						&& obj.getServicePersonId() != null
						&& obj.getServicePersonId() > 0) {
					ServicePersonEntity servicePerson = (ServicePersonEntity) dbManager
							.getById(obj.getServicePersonId(),
									ServicePersonEntity.class);
					obj.setServicePerson(servicePerson);
				}
				// 查询关联内容
				if (medicalReportShow != null
						&& medicalReportShow.booleanValue() && obj != null
						&& obj.getMedicalReportId() != null
						&& obj.getMedicalReportId() > 0) {
					MedicalReportEntity medicalReport = (MedicalReportEntity) dbManager
							.getById(obj.getMedicalReportId(),
									MedicalReportEntity.class);
					obj.setMedicalReport(medicalReport);
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
	public boolean del(Integer id, Boolean delServicePerson,
			Boolean delMedicalReport) {
		boolean result = false;
		if (id != null && id > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 删除关联信息
				if (delServicePerson != null && delServicePerson.booleanValue()) {
					OrderEntity order = (OrderEntity) dbManager.getById(id,
							OrderEntity.class);
					if (order != null && order.getServicePersonId() != null) {
						dbManager.delNoTransaction(order.getServicePersonId(),
								ServicePersonEntity.class);
					}
				}
				// 删除关联信息
				if (delMedicalReport != null && delMedicalReport.booleanValue()) {
					OrderEntity order = (OrderEntity) dbManager.getById(id,
							OrderEntity.class);
					if (order != null && order.getMedicalReportId() != null) {
						dbManager.delNoTransaction(order.getMedicalReportId(),
								MedicalReportEntity.class);
					}
				}
				result = dbManager.delNoTransaction(id, OrderEntity.class);
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
				QueryCondition qc = new QueryCondition(OrderEntity.ID,
						QueryCondition.in, ids);
				result = dbManager.delByConditionsNoTransaction(
						OrderEntity.class, qc);
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
			Boolean delServicePerson, Boolean delMedicalReport) {
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
				if (delServicePerson != null && delServicePerson.booleanValue()) {
					List<Object> list = dbManager
							.queryByConditionNoTransaction(OrderEntity.class,
									qc);
					String strIds = "";
					if (list != null && list.size() > 0) {
						for (Object obj : list) {
							OrderEntity entity = (OrderEntity) obj;
							strIds += entity.getServicePersonId() + ",";
						}
						strIds = strIds.substring(0, strIds.length() - 1);
					}
					if (strIds != null && !"".equals(strIds)) {
						QueryCondition qc1 = new QueryCondition(
								ServicePersonEntity.ID, QueryCondition.in,
								strIds);
						dbManager.delByConditionsNoTransaction(
								ServicePersonEntity.class, qc1);
					}

				}
				// 删除关联信息
				if (delMedicalReport != null && delMedicalReport.booleanValue()) {
					List<Object> list = dbManager
							.queryByConditionNoTransaction(OrderEntity.class,
									qc);
					String strIds = "";
					if (list != null && list.size() > 0) {
						for (Object obj : list) {
							OrderEntity entity = (OrderEntity) obj;
							strIds += entity.getMedicalReportId() + ",";
						}
						strIds = strIds.substring(0, strIds.length() - 1);
					}
					if (strIds != null && !"".equals(strIds)) {
						QueryCondition qc1 = new QueryCondition(
								MedicalReportEntity.ID, QueryCondition.in,
								strIds);
						dbManager.delByConditionsNoTransaction(
								MedicalReportEntity.class, qc1);
					}

				}
				result = dbManager.delByConditionsNoTransaction(
						OrderEntity.class, qc);
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
		Object orderNum = queryMap.get("orderNum");
		Object orderNum_like = queryMap.get("orderNum_like");
		Object orderNum_isNull = queryMap.get("orderNum_isNull");
		Object orderNum_isNotNull = queryMap.get("orderNum_isNotNull");
		Object orderNum_in = queryMap.get("orderNum_in");
		Object totalPrice = queryMap.get("totalPrice");
		Object totalPrice_gt = queryMap.get("totalPrice_gt");
		Object totalPrice_ge = queryMap.get("totalPrice_ge");
		Object totalPrice_lt = queryMap.get("totalPrice_lt");
		Object totalPrice_le = queryMap.get("totalPrice_le");
		Object totalPrice_in = queryMap.get("totalPrice_in");
		Object orderCustomer = queryMap.get("orderCustomer");
		Object orderCustomer_like = queryMap.get("orderCustomer_like");
		Object orderCustomer_isNull = queryMap.get("orderCustomer_isNull");
		Object orderCustomer_isNotNull = queryMap
				.get("orderCustomer_isNotNull");
		Object orderCustomer_in = queryMap.get("orderCustomer_in");
		Object orderTime_gt = queryMap.get("orderTime_gt");
		Object orderTime_ge = queryMap.get("orderTime_ge");
		Object orderTime_lt = queryMap.get("orderTime_lt");
		Object orderTime_le = queryMap.get("orderTime_le");
		Object medicalHospital = queryMap.get("medicalHospital");
		Object medicalHospital_like = queryMap.get("medicalHospital_like");
		Object medicalHospital_isNull = queryMap.get("medicalHospital_isNull");
		Object medicalHospital_isNotNull = queryMap
				.get("medicalHospital_isNotNull");
		Object medicalHospital_in = queryMap.get("medicalHospital_in");
		Object medicalPersonName = queryMap.get("medicalPersonName");
		Object medicalPersonName_like = queryMap.get("medicalPersonName_like");
		Object medicalPersonName_isNull = queryMap
				.get("medicalPersonName_isNull");
		Object medicalPersonName_isNotNull = queryMap
				.get("medicalPersonName_isNotNull");
		Object medicalPersonName_in = queryMap.get("medicalPersonName_in");
		Object medicalPersonCard = queryMap.get("medicalPersonCard");
		Object medicalPersonCard_like = queryMap.get("medicalPersonCard_like");
		Object medicalPersonCard_isNull = queryMap
				.get("medicalPersonCard_isNull");
		Object medicalPersonCard_isNotNull = queryMap
				.get("medicalPersonCard_isNotNull");
		Object medicalPersonCard_in = queryMap.get("medicalPersonCard_in");
		Object medicalPersonGender = queryMap.get("medicalPersonGender");
		Object medicalPersonGender_like = queryMap
				.get("medicalPersonGender_like");
		Object medicalPersonGender_isNull = queryMap
				.get("medicalPersonGender_isNull");
		Object medicalPersonGender_isNotNull = queryMap
				.get("medicalPersonGender_isNotNull");
		Object medicalPersonGender_in = queryMap.get("medicalPersonGender_in");
		Object contactWay = queryMap.get("contactWay");
		Object contactWay_like = queryMap.get("contactWay_like");
		Object contactWay_isNull = queryMap.get("contactWay_isNull");
		Object contactWay_isNotNull = queryMap.get("contactWay_isNotNull");
		Object contactWay_in = queryMap.get("contactWay_in");
		Object reportSendAddr = queryMap.get("reportSendAddr");
		Object reportSendAddr_like = queryMap.get("reportSendAddr_like");
		Object reportSendAddr_isNull = queryMap.get("reportSendAddr_isNull");
		Object reportSendAddr_isNotNull = queryMap
				.get("reportSendAddr_isNotNull");
		Object reportSendAddr_in = queryMap.get("reportSendAddr_in");
		Object expectMedicalTime_gt = queryMap.get("expectMedicalTime_gt");
		Object expectMedicalTime_ge = queryMap.get("expectMedicalTime_ge");
		Object expectMedicalTime_lt = queryMap.get("expectMedicalTime_lt");
		Object expectMedicalTime_le = queryMap.get("expectMedicalTime_le");
		Object medicalCompleteTime_gt = queryMap.get("medicalCompleteTime_gt");
		Object medicalCompleteTime_ge = queryMap.get("medicalCompleteTime_ge");
		Object medicalCompleteTime_lt = queryMap.get("medicalCompleteTime_lt");
		Object medicalCompleteTime_le = queryMap.get("medicalCompleteTime_le");
		Object expectReportCompleteTime_gt = queryMap
				.get("expectReportCompleteTime_gt");
		Object expectReportCompleteTime_ge = queryMap
				.get("expectReportCompleteTime_ge");
		Object expectReportCompleteTime_lt = queryMap
				.get("expectReportCompleteTime_lt");
		Object expectReportCompleteTime_le = queryMap
				.get("expectReportCompleteTime_le");
		Object reportCreateTime_gt = queryMap.get("reportCreateTime_gt");
		Object reportCreateTime_ge = queryMap.get("reportCreateTime_ge");
		Object reportCreateTime_lt = queryMap.get("reportCreateTime_lt");
		Object reportCreateTime_le = queryMap.get("reportCreateTime_le");
		Object servicePersonId = queryMap.get("servicePersonId");
		Object servicePersonId_gt = queryMap.get("servicePersonId_gt");
		Object servicePersonId_ge = queryMap.get("servicePersonId_ge");
		Object servicePersonId_lt = queryMap.get("servicePersonId_lt");
		Object servicePersonId_le = queryMap.get("servicePersonId_le");
		Object servicePersonId_in = queryMap.get("servicePersonId_in");
		Object status = queryMap.get("status");
		Object status_gt = queryMap.get("status_gt");
		Object status_ge = queryMap.get("status_ge");
		Object status_lt = queryMap.get("status_lt");
		Object status_le = queryMap.get("status_le");
		Object status_in = queryMap.get("status_in");
		Object medicalReportId = queryMap.get("medicalReportId");
		Object medicalReportId_gt = queryMap.get("medicalReportId_gt");
		Object medicalReportId_ge = queryMap.get("medicalReportId_ge");
		Object medicalReportId_lt = queryMap.get("medicalReportId_lt");
		Object medicalReportId_le = queryMap.get("medicalReportId_le");
		Object medicalReportId_in = queryMap.get("medicalReportId_in");

		QueryCondition qc = new QueryCondition(OrderEntity.ID,
				QueryCondition.gt, "0");
		if (id != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ID,
					QueryCondition.eq, id));
		}
		if (id_gt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ID,
					QueryCondition.gt, id_gt));
		}
		if (id_ge != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ID,
					QueryCondition.ge, id_ge));
		}
		if (id_lt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ID,
					QueryCondition.lt, id_lt));
		}
		if (id_le != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ID,
					QueryCondition.le, id_le));
		}
		if (id_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ID,
					QueryCondition.in, id_in));
		}
		if (orderNum != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_NUM,
					QueryCondition.eq, orderNum));
		}
		if (orderNum_like != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_NUM,
					QueryCondition.like, orderNum_like));
		}
		if (orderNum_isNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_NUM,
					QueryCondition.isNull, orderNum_isNull));
		}
		if (orderNum_isNotNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_NUM,
					QueryCondition.isNotNull, orderNum_isNotNull));
		}
		if (orderNum_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_NUM,
					QueryCondition.in, orderNum_in));
		}
		if (totalPrice != null) {
			qc.andCondition(new QueryCondition(OrderEntity.TOTAL_PRICE,
					QueryCondition.eq, totalPrice));
		}
		if (totalPrice_gt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.TOTAL_PRICE,
					QueryCondition.gt, totalPrice_gt));
		}
		if (totalPrice_ge != null) {
			qc.andCondition(new QueryCondition(OrderEntity.TOTAL_PRICE,
					QueryCondition.ge, totalPrice_ge));
		}
		if (totalPrice_lt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.TOTAL_PRICE,
					QueryCondition.lt, totalPrice_lt));
		}
		if (totalPrice_le != null) {
			qc.andCondition(new QueryCondition(OrderEntity.TOTAL_PRICE,
					QueryCondition.le, totalPrice_le));
		}
		if (totalPrice_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.TOTAL_PRICE,
					QueryCondition.in, totalPrice_in));
		}
		if (orderCustomer != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_CUSTOMER,
					QueryCondition.eq, orderCustomer));
		}
		if (orderCustomer_like != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_CUSTOMER,
					QueryCondition.like, orderCustomer_like));
		}
		if (orderCustomer_isNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_CUSTOMER,
					QueryCondition.isNull, orderCustomer_isNull));
		}
		if (orderCustomer_isNotNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_CUSTOMER,
					QueryCondition.isNotNull, orderCustomer_isNotNull));
		}
		if (orderCustomer_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_CUSTOMER,
					QueryCondition.in, orderCustomer_in));
		}
		if (orderTime_gt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_TIME,
					QueryCondition.gt, orderTime_gt));
		}
		if (orderTime_ge != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_TIME,
					QueryCondition.ge, orderTime_ge));
		}
		if (orderTime_lt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_TIME,
					QueryCondition.lt, orderTime_lt));
		}
		if (orderTime_le != null) {
			qc.andCondition(new QueryCondition(OrderEntity.ORDER_TIME,
					QueryCondition.le, orderTime_le));
		}
		if (medicalHospital != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_HOSPITAL,
					QueryCondition.eq, medicalHospital));
		}
		if (medicalHospital_like != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_HOSPITAL,
					QueryCondition.like, medicalHospital_like));
		}
		if (medicalHospital_isNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_HOSPITAL,
					QueryCondition.isNull, medicalHospital_isNull));
		}
		if (medicalHospital_isNotNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_HOSPITAL,
					QueryCondition.isNotNull, medicalHospital_isNotNull));
		}
		if (medicalHospital_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_HOSPITAL,
					QueryCondition.in, medicalHospital_in));
		}
		if (medicalPersonName != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_PERSON_NAME,
					QueryCondition.eq, medicalPersonName));
		}
		if (medicalPersonName_like != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_PERSON_NAME,
					QueryCondition.like, medicalPersonName_like));
		}
		if (medicalPersonName_isNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_PERSON_NAME,
					QueryCondition.isNull, medicalPersonName_isNull));
		}
		if (medicalPersonName_isNotNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_PERSON_NAME,
					QueryCondition.isNotNull, medicalPersonName_isNotNull));
		}
		if (medicalPersonName_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_PERSON_NAME,
					QueryCondition.in, medicalPersonName_in));
		}
		if (medicalPersonCard != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_PERSON_CARD,
					QueryCondition.eq, medicalPersonCard));
		}
		if (medicalPersonCard_like != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_PERSON_CARD,
					QueryCondition.like, medicalPersonCard_like));
		}
		if (medicalPersonCard_isNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_PERSON_CARD,
					QueryCondition.isNull, medicalPersonCard_isNull));
		}
		if (medicalPersonCard_isNotNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_PERSON_CARD,
					QueryCondition.isNotNull, medicalPersonCard_isNotNull));
		}
		if (medicalPersonCard_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_PERSON_CARD,
					QueryCondition.in, medicalPersonCard_in));
		}
		if (medicalPersonGender != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.MEDICAL_PERSON_GENDER, QueryCondition.eq,
					medicalPersonGender));
		}
		if (medicalPersonGender_like != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.MEDICAL_PERSON_GENDER, QueryCondition.like,
					medicalPersonGender_like));
		}
		if (medicalPersonGender_isNull != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.MEDICAL_PERSON_GENDER, QueryCondition.isNull,
					medicalPersonGender_isNull));
		}
		if (medicalPersonGender_isNotNull != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.MEDICAL_PERSON_GENDER,
					QueryCondition.isNotNull, medicalPersonGender_isNotNull));
		}
		if (medicalPersonGender_in != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.MEDICAL_PERSON_GENDER, QueryCondition.in,
					medicalPersonGender_in));
		}
		if (contactWay != null) {
			qc.andCondition(new QueryCondition(OrderEntity.CONTACT_WAY,
					QueryCondition.eq, contactWay));
		}
		if (contactWay_like != null) {
			qc.andCondition(new QueryCondition(OrderEntity.CONTACT_WAY,
					QueryCondition.like, contactWay_like));
		}
		if (contactWay_isNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.CONTACT_WAY,
					QueryCondition.isNull, contactWay_isNull));
		}
		if (contactWay_isNotNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.CONTACT_WAY,
					QueryCondition.isNotNull, contactWay_isNotNull));
		}
		if (contactWay_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.CONTACT_WAY,
					QueryCondition.in, contactWay_in));
		}
		if (reportSendAddr != null) {
			qc.andCondition(new QueryCondition(OrderEntity.REPORT_SEND_ADDR,
					QueryCondition.eq, reportSendAddr));
		}
		if (reportSendAddr_like != null) {
			qc.andCondition(new QueryCondition(OrderEntity.REPORT_SEND_ADDR,
					QueryCondition.like, reportSendAddr_like));
		}
		if (reportSendAddr_isNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.REPORT_SEND_ADDR,
					QueryCondition.isNull, reportSendAddr_isNull));
		}
		if (reportSendAddr_isNotNull != null) {
			qc.andCondition(new QueryCondition(OrderEntity.REPORT_SEND_ADDR,
					QueryCondition.isNotNull, reportSendAddr_isNotNull));
		}
		if (reportSendAddr_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.REPORT_SEND_ADDR,
					QueryCondition.in, reportSendAddr_in));
		}
		if (expectMedicalTime_gt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.EXPECT_MEDICAL_TIME,
					QueryCondition.gt, expectMedicalTime_gt));
		}
		if (expectMedicalTime_ge != null) {
			qc.andCondition(new QueryCondition(OrderEntity.EXPECT_MEDICAL_TIME,
					QueryCondition.ge, expectMedicalTime_ge));
		}
		if (expectMedicalTime_lt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.EXPECT_MEDICAL_TIME,
					QueryCondition.lt, expectMedicalTime_lt));
		}
		if (expectMedicalTime_le != null) {
			qc.andCondition(new QueryCondition(OrderEntity.EXPECT_MEDICAL_TIME,
					QueryCondition.le, expectMedicalTime_le));
		}
		if (medicalCompleteTime_gt != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.MEDICAL_COMPLETE_TIME, QueryCondition.gt,
					medicalCompleteTime_gt));
		}
		if (medicalCompleteTime_ge != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.MEDICAL_COMPLETE_TIME, QueryCondition.ge,
					medicalCompleteTime_ge));
		}
		if (medicalCompleteTime_lt != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.MEDICAL_COMPLETE_TIME, QueryCondition.lt,
					medicalCompleteTime_lt));
		}
		if (medicalCompleteTime_le != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.MEDICAL_COMPLETE_TIME, QueryCondition.le,
					medicalCompleteTime_le));
		}
		if (expectReportCompleteTime_gt != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.EXPECT_REPORT_COMPLETE_TIME, QueryCondition.gt,
					expectReportCompleteTime_gt));
		}
		if (expectReportCompleteTime_ge != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.EXPECT_REPORT_COMPLETE_TIME, QueryCondition.ge,
					expectReportCompleteTime_ge));
		}
		if (expectReportCompleteTime_lt != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.EXPECT_REPORT_COMPLETE_TIME, QueryCondition.lt,
					expectReportCompleteTime_lt));
		}
		if (expectReportCompleteTime_le != null) {
			qc.andCondition(new QueryCondition(
					OrderEntity.EXPECT_REPORT_COMPLETE_TIME, QueryCondition.le,
					expectReportCompleteTime_le));
		}
		if (reportCreateTime_gt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.REPORT_CREATE_TIME,
					QueryCondition.gt, reportCreateTime_gt));
		}
		if (reportCreateTime_ge != null) {
			qc.andCondition(new QueryCondition(OrderEntity.REPORT_CREATE_TIME,
					QueryCondition.ge, reportCreateTime_ge));
		}
		if (reportCreateTime_lt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.REPORT_CREATE_TIME,
					QueryCondition.lt, reportCreateTime_lt));
		}
		if (reportCreateTime_le != null) {
			qc.andCondition(new QueryCondition(OrderEntity.REPORT_CREATE_TIME,
					QueryCondition.le, reportCreateTime_le));
		}
		if (servicePersonId != null) {
			qc.andCondition(new QueryCondition(OrderEntity.SERVICE_PERSON_ID,
					QueryCondition.eq, servicePersonId));
		}
		if (servicePersonId_gt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.SERVICE_PERSON_ID,
					QueryCondition.gt, servicePersonId_gt));
		}
		if (servicePersonId_ge != null) {
			qc.andCondition(new QueryCondition(OrderEntity.SERVICE_PERSON_ID,
					QueryCondition.ge, servicePersonId_ge));
		}
		if (servicePersonId_lt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.SERVICE_PERSON_ID,
					QueryCondition.lt, servicePersonId_lt));
		}
		if (servicePersonId_le != null) {
			qc.andCondition(new QueryCondition(OrderEntity.SERVICE_PERSON_ID,
					QueryCondition.le, servicePersonId_le));
		}
		if (servicePersonId_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.SERVICE_PERSON_ID,
					QueryCondition.in, servicePersonId_in));
		}
		if (status != null) {
			qc.andCondition(new QueryCondition(OrderEntity.STATUS,
					QueryCondition.eq, status));
		}
		if (status_gt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.STATUS,
					QueryCondition.gt, status_gt));
		}
		if (status_ge != null) {
			qc.andCondition(new QueryCondition(OrderEntity.STATUS,
					QueryCondition.ge, status_ge));
		}
		if (status_lt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.STATUS,
					QueryCondition.lt, status_lt));
		}
		if (status_le != null) {
			qc.andCondition(new QueryCondition(OrderEntity.STATUS,
					QueryCondition.le, status_le));
		}
		if (status_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.STATUS,
					QueryCondition.in, status_in));
		}
		if (medicalReportId != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_REPORT_ID,
					QueryCondition.eq, medicalReportId));
		}
		if (medicalReportId_gt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_REPORT_ID,
					QueryCondition.gt, medicalReportId_gt));
		}
		if (medicalReportId_ge != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_REPORT_ID,
					QueryCondition.ge, medicalReportId_ge));
		}
		if (medicalReportId_lt != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_REPORT_ID,
					QueryCondition.lt, medicalReportId_lt));
		}
		if (medicalReportId_le != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_REPORT_ID,
					QueryCondition.le, medicalReportId_le));
		}
		if (medicalReportId_in != null) {
			qc.andCondition(new QueryCondition(OrderEntity.MEDICAL_REPORT_ID,
					QueryCondition.in, medicalReportId_in));
		}
		return qc;
	}

}
