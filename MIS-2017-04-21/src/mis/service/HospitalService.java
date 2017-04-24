package mis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mis.entity.AreaEntity;
import mis.entity.HospitalEntity;

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
 * @Description: 医院表服务类
 * @author feng.gu
 * @date 2017-04-21 17:05:03
 * @version V1.0
 * 
 */
public class HospitalService {
	private static Logger logger = Logger.getLogger(HospitalService.class);
	private DBManager dbManager = DBManager.getInstance();

	private static HospitalService hospitalService;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static HospitalService getInstance() {
		if (hospitalService == null) {
			hospitalService = new HospitalService();
		}
		return hospitalService;
	}

	/**
	 * 保存记录
	 * 
	 * @param obj
	 */
	public boolean save(HospitalEntity hospital) {
		boolean result = false;
		if (hospital != null) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 关联信息保存
				AreaEntity areaEntity = hospital.getAreaEntity();
				if (areaEntity != null) {
					dbManager.saveNoTransaction(areaEntity);
					hospital.setAreaId(areaEntity.getId());
				}
				result = dbManager.saveNoTransaction(hospital);
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
	public boolean saveList(List<HospitalEntity> hospitalList) {
		boolean result = false;
		if (hospitalList != null && hospitalList.size() > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				for (HospitalEntity hospital : hospitalList) {
					if (hospital != null) {
						// 关联信息保存
						AreaEntity areaEntity = hospital.getAreaEntity();
						if (areaEntity != null) {
							dbManager.saveNoTransaction(areaEntity);
							hospital.setAreaId(areaEntity.getId());
						}
						result = dbManager.saveNoTransaction(hospital);
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
	public HospitalEntity getById(Integer id) {
		HospitalEntity obj = null;
		if (id != null) {
			obj = (HospitalEntity) dbManager.getById(id, HospitalEntity.class);
		}
		return obj;
	}

	/**
	 * 根据id读取记录
	 * 
	 * @param id
	 *            主键
	 * @param areaEntityShow
	 *            是否查询关联信息
	 * @param obj
	 */
	public HospitalEntity getById(Integer id, Boolean areaEntityShow) {
		HospitalEntity obj = null;
		if (id != null) {
			obj = (HospitalEntity) dbManager.getById(id, HospitalEntity.class);
			// 查询关联内容
			if (areaEntityShow != null && areaEntityShow.booleanValue()
					&& obj != null && obj.getAreaId() != null
					&& obj.getAreaId() > 0) {
				AreaEntity areaEntity = (AreaEntity) dbManager.getById(
						obj.getAreaId(), AreaEntity.class);
				obj.setAreaEntity(areaEntity);
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
	public List<HospitalEntity> getListByCondition(Map<String, Object> queryMap) {
		List<HospitalEntity> returnlist = null;
		List<Object> list = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		QueryCondition qc = changeMapToQc(queryMap);
		list = dbManager.queryByCondition(HospitalEntity.class, qc);
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<HospitalEntity>();
			for (Object obj : list) {
				returnlist.add((HospitalEntity) obj);
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
	 * @param areaEntityShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public List<HospitalEntity> getListByCondition(
			Map<String, Object> queryMap, List<OrderVO> orderList,
			Boolean areaEntityShow) {
		List<HospitalEntity> returnlist = null;
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
		list = dbManager.queryByConditions(HospitalEntity.class, qc, oc);
		int a = 0;
		if (areaEntityShow != null && areaEntityShow.booleanValue()) {
			a++;
		}
		if (a > 0 && list != null && list.size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				HospitalEntity obj = (HospitalEntity) list.get(i);
				// 查询关联内容
				if (areaEntityShow != null && areaEntityShow.booleanValue()
						&& obj != null && obj.getAreaId() != null
						&& obj.getAreaId() > 0) {
					AreaEntity areaEntity = (AreaEntity) dbManager.getById(
							obj.getAreaId(), AreaEntity.class);
					obj.setAreaEntity(areaEntity);
				}
				result.add(obj);
			}
			list = result;
		}
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<HospitalEntity>();
			for (Object obj : list) {
				returnlist.add((HospitalEntity) obj);
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
		pagelist = dbManager.queryByCondition(HospitalEntity.class, qc, pageno,
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
	 * @param areaEntityShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public PageList getListByCondition(Map<String, Object> queryMap,
			List<OrderVO> orderList, int pageno, int pagesize,
			Boolean areaEntityShow) {
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
		pagelist = dbManager.queryByConditions(HospitalEntity.class, qc,
				dataRuleQclist, oc, pageno, pagesize);
		int a = 0;
		if (areaEntityShow != null && areaEntityShow.booleanValue()) {
			a++;
		}
		if (a > 0 && pagelist != null && pagelist.getResultList() != null
				&& pagelist.getResultList().size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < pagelist.getResultList().size(); i++) {
				HospitalEntity obj = (HospitalEntity) pagelist.getResultList()
						.get(i);
				// 查询关联内容
				if (areaEntityShow != null && areaEntityShow.booleanValue()
						&& obj != null && obj.getAreaId() != null
						&& obj.getAreaId() > 0) {
					AreaEntity areaEntity = (AreaEntity) dbManager.getById(
							obj.getAreaId(), AreaEntity.class);
					obj.setAreaEntity(areaEntity);
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
	public boolean del(Integer id, Boolean delAreaEntity) {
		boolean result = false;
		if (id != null && id > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 删除关联信息
				if (delAreaEntity != null && delAreaEntity.booleanValue()) {
					HospitalEntity hospital = (HospitalEntity) dbManager
							.getById(id, HospitalEntity.class);
					if (hospital != null && hospital.getAreaId() != null) {
						dbManager.delNoTransaction(hospital.getAreaId(),
								AreaEntity.class);
					}
				}
				result = dbManager.delNoTransaction(id, HospitalEntity.class);
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
				QueryCondition qc = new QueryCondition(HospitalEntity.ID,
						QueryCondition.in, ids);
				result = dbManager.delByConditionsNoTransaction(
						HospitalEntity.class, qc);
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
	public boolean delList(Map<String, Object> queryMap, Boolean delAreaEntity) {
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
				if (delAreaEntity != null && delAreaEntity.booleanValue()) {
					List<Object> list = dbManager
							.queryByConditionNoTransaction(
									HospitalEntity.class, qc);
					String strIds = "";
					if (list != null && list.size() > 0) {
						for (Object obj : list) {
							HospitalEntity entity = (HospitalEntity) obj;
							strIds += entity.getAreaId() + ",";
						}
						strIds = strIds.substring(0, strIds.length() - 1);
					}
					if (strIds != null && !"".equals(strIds)) {
						QueryCondition qc1 = new QueryCondition(AreaEntity.ID,
								QueryCondition.in, strIds);
						dbManager.delByConditionsNoTransaction(
								AreaEntity.class, qc1);
					}

				}
				result = dbManager.delByConditionsNoTransaction(
						HospitalEntity.class, qc);
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
		Object hospitalName = queryMap.get("hospitalName");
		Object hospitalName_like = queryMap.get("hospitalName_like");
		Object hospitalName_isNull = queryMap.get("hospitalName_isNull");
		Object hospitalName_isNotNull = queryMap.get("hospitalName_isNotNull");
		Object hospitalName_in = queryMap.get("hospitalName_in");
		Object level = queryMap.get("level");
		Object level_like = queryMap.get("level_like");
		Object level_isNull = queryMap.get("level_isNull");
		Object level_isNotNull = queryMap.get("level_isNotNull");
		Object level_in = queryMap.get("level_in");
		Object areaId = queryMap.get("areaId");
		Object areaId_gt = queryMap.get("areaId_gt");
		Object areaId_ge = queryMap.get("areaId_ge");
		Object areaId_lt = queryMap.get("areaId_lt");
		Object areaId_le = queryMap.get("areaId_le");
		Object areaId_in = queryMap.get("areaId_in");
		Object addr = queryMap.get("addr");
		Object addr_like = queryMap.get("addr_like");
		Object addr_isNull = queryMap.get("addr_isNull");
		Object addr_isNotNull = queryMap.get("addr_isNotNull");
		Object addr_in = queryMap.get("addr_in");

		QueryCondition qc = new QueryCondition(HospitalEntity.ID,
				QueryCondition.gt, "0");
		if (id != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ID,
					QueryCondition.eq, id));
		}
		if (id_gt != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ID,
					QueryCondition.gt, id_gt));
		}
		if (id_ge != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ID,
					QueryCondition.ge, id_ge));
		}
		if (id_lt != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ID,
					QueryCondition.lt, id_lt));
		}
		if (id_le != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ID,
					QueryCondition.le, id_le));
		}
		if (id_in != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ID,
					QueryCondition.in, id_in));
		}
		if (hospitalName != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.HOSPITAL_NAME,
					QueryCondition.eq, hospitalName));
		}
		if (hospitalName_like != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.HOSPITAL_NAME,
					QueryCondition.like, hospitalName_like));
		}
		if (hospitalName_isNull != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.HOSPITAL_NAME,
					QueryCondition.isNull, hospitalName_isNull));
		}
		if (hospitalName_isNotNull != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.HOSPITAL_NAME,
					QueryCondition.isNotNull, hospitalName_isNotNull));
		}
		if (hospitalName_in != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.HOSPITAL_NAME,
					QueryCondition.in, hospitalName_in));
		}
		if (level != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.LEVEL,
					QueryCondition.eq, level));
		}
		if (level_like != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.LEVEL,
					QueryCondition.like, level_like));
		}
		if (level_isNull != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.LEVEL,
					QueryCondition.isNull, level_isNull));
		}
		if (level_isNotNull != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.LEVEL,
					QueryCondition.isNotNull, level_isNotNull));
		}
		if (level_in != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.LEVEL,
					QueryCondition.in, level_in));
		}
		if (areaId != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.AREA_ID,
					QueryCondition.eq, areaId));
		}
		if (areaId_gt != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.AREA_ID,
					QueryCondition.gt, areaId_gt));
		}
		if (areaId_ge != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.AREA_ID,
					QueryCondition.ge, areaId_ge));
		}
		if (areaId_lt != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.AREA_ID,
					QueryCondition.lt, areaId_lt));
		}
		if (areaId_le != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.AREA_ID,
					QueryCondition.le, areaId_le));
		}
		if (areaId_in != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.AREA_ID,
					QueryCondition.in, areaId_in));
		}
		if (addr != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ADDR,
					QueryCondition.eq, addr));
		}
		if (addr_like != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ADDR,
					QueryCondition.like, addr_like));
		}
		if (addr_isNull != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ADDR,
					QueryCondition.isNull, addr_isNull));
		}
		if (addr_isNotNull != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ADDR,
					QueryCondition.isNotNull, addr_isNotNull));
		}
		if (addr_in != null) {
			qc.andCondition(new QueryCondition(HospitalEntity.ADDR,
					QueryCondition.in, addr_in));
		}
		return qc;
	}

}
