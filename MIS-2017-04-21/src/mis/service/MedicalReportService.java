package mis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mis.entity.HospitalEntity;
import mis.entity.MedicalReportEntity;

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
 * @Description: 医院体检项目关系表服务类
 * @author feng.gu
 * @date 2017-04-28 13:31:49
 * @version V1.0
 *
 */
public class MedicalReportService {
	private static Logger logger = Logger.getLogger(MedicalReportService.class);
	private DBManager dbManager = DBManager.getInstance();

	private static MedicalReportService medicalReportService;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static MedicalReportService getInstance() {
		if (medicalReportService == null) {
			medicalReportService = new MedicalReportService();
		}
		return medicalReportService;
	}

	/**
	 * 保存记录
	 * 
	 * @param obj
	 */
	public boolean save(MedicalReportEntity medicalReport) {
		boolean result = false;
		if (medicalReport != null) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 关联信息保存
				HospitalEntity hospital = medicalReport.getHospital();
				if (hospital != null) {
					dbManager.saveNoTransaction(hospital);
					medicalReport.setHospitalId(hospital.getId());
				}
				result = dbManager.saveNoTransaction(medicalReport);
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
	public boolean saveList(List<MedicalReportEntity> medicalReportList) {
		boolean result = false;
		if (medicalReportList != null && medicalReportList.size() > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				for (MedicalReportEntity medicalReport : medicalReportList) {
					if (medicalReport != null) {
						// 关联信息保存
						HospitalEntity hospital = medicalReport.getHospital();
						if (hospital != null) {
							dbManager.saveNoTransaction(hospital);
							medicalReport.setHospitalId(hospital.getId());
						}
						result = dbManager.saveNoTransaction(medicalReport);
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
	public MedicalReportEntity getById(Integer id) {
		MedicalReportEntity obj = null;
		if (id != null) {
			obj = (MedicalReportEntity) dbManager.getById(id,
					MedicalReportEntity.class);
		}
		return obj;
	}

	/**
	 * 根据id读取记录
	 * 
	 * @param id
	 *            主键
	 * @param hospitalShow
	 *            是否查询关联信息
	 * @param obj
	 */
	public MedicalReportEntity getById(Integer id, Boolean hospitalShow) {
		MedicalReportEntity obj = null;
		if (id != null) {
			obj = (MedicalReportEntity) dbManager.getById(id,
					MedicalReportEntity.class);
			// 查询关联内容
			if (hospitalShow != null && hospitalShow.booleanValue()
					&& obj != null && obj.getHospitalId() != null
					&& obj.getHospitalId() > 0) {
				HospitalEntity hospital = (HospitalEntity) dbManager.getById(
						obj.getHospitalId(), HospitalEntity.class);
				obj.setHospital(hospital);
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
	public List<MedicalReportEntity> getListByCondition(
			Map<String, Object> queryMap) {
		List<MedicalReportEntity> returnlist = null;
		List<Object> list = null;
		if (queryMap == null) {
			queryMap = new HashMap<String, Object>();
		}
		QueryCondition qc = changeMapToQc(queryMap);
		list = dbManager.queryByCondition(MedicalReportEntity.class, qc);
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<MedicalReportEntity>();
			for (Object obj : list) {
				returnlist.add((MedicalReportEntity) obj);
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
	 * @param hospitalShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public List<MedicalReportEntity> getListByCondition(
			Map<String, Object> queryMap, List<OrderVO> orderList,
			Boolean hospitalShow) {
		List<MedicalReportEntity> returnlist = null;
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
		list = dbManager.queryByConditions(MedicalReportEntity.class, qc, oc);
		int a = 0;
		if (hospitalShow != null && hospitalShow.booleanValue()) {
			a++;
		}
		if (a > 0 && list != null && list.size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				MedicalReportEntity obj = (MedicalReportEntity) list.get(i);
				// 查询关联内容
				if (hospitalShow != null && hospitalShow.booleanValue()
						&& obj != null && obj.getHospitalId() != null
						&& obj.getHospitalId() > 0) {
					HospitalEntity hospital = (HospitalEntity) dbManager
							.getById(obj.getHospitalId(), HospitalEntity.class);
					obj.setHospital(hospital);
				}
				result.add(obj);
			}
			list = result;
		}
		if (list != null && list.size() > 0) {
			returnlist = new ArrayList<MedicalReportEntity>();
			for (Object obj : list) {
				returnlist.add((MedicalReportEntity) obj);
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
		pagelist = dbManager.queryByCondition(MedicalReportEntity.class, qc,
				pageno, pagesize);
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
	 * @param hospitalShow
	 *            是否查询关联信息,默认false(当为true时注意效率)
	 * @return
	 */
	public PageList getListByCondition(Map<String, Object> queryMap,
			List<OrderVO> orderList, int pageno, int pagesize,
			Boolean hospitalShow) {
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
		pagelist = dbManager.queryByConditions(MedicalReportEntity.class, qc,
				dataRuleQclist, oc, pageno, pagesize);
		int a = 0;
		if (hospitalShow != null && hospitalShow.booleanValue()) {
			a++;
		}
		if (a > 0 && pagelist != null && pagelist.getResultList() != null
				&& pagelist.getResultList().size() > 0) {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < pagelist.getResultList().size(); i++) {
				MedicalReportEntity obj = (MedicalReportEntity) pagelist
						.getResultList().get(i);
				// 查询关联内容
				if (hospitalShow != null && hospitalShow.booleanValue()
						&& obj != null && obj.getHospitalId() != null
						&& obj.getHospitalId() > 0) {
					HospitalEntity hospital = (HospitalEntity) dbManager
							.getById(obj.getHospitalId(), HospitalEntity.class);
					obj.setHospital(hospital);
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
	public boolean del(Integer id, Boolean delHospital) {
		boolean result = false;
		if (id != null && id > 0) {
			TransactionManager tx = DbUtils.getTranManager();
			try {
				tx.beginTransaction();
				// 删除关联信息
				if (delHospital != null && delHospital.booleanValue()) {
					MedicalReportEntity medicalReport = (MedicalReportEntity) dbManager
							.getById(id, MedicalReportEntity.class);
					if (medicalReport != null
							&& medicalReport.getHospitalId() != null) {
						dbManager.delNoTransaction(
								medicalReport.getHospitalId(),
								HospitalEntity.class);
					}
				}
				result = dbManager.delNoTransaction(id,
						MedicalReportEntity.class);
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
				QueryCondition qc = new QueryCondition(MedicalReportEntity.ID,
						QueryCondition.in, ids);
				result = dbManager.delByConditionsNoTransaction(
						MedicalReportEntity.class, qc);
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
	public boolean delList(Map<String, Object> queryMap, Boolean delHospital) {
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
				if (delHospital != null && delHospital.booleanValue()) {
					List<Object> list = dbManager
							.queryByConditionNoTransaction(
									MedicalReportEntity.class, qc);
					String strIds = "";
					if (list != null && list.size() > 0) {
						for (Object obj : list) {
							MedicalReportEntity entity = (MedicalReportEntity) obj;
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
						MedicalReportEntity.class, qc);
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
		Object medicalReportNum = queryMap.get("medicalReportNum");
		Object medicalReportNum_like = queryMap.get("medicalReportNum_like");
		Object medicalReportNum_isNull = queryMap
				.get("medicalReportNum_isNull");
		Object medicalReportNum_isNotNull = queryMap
				.get("medicalReportNum_isNotNull");
		Object medicalReportNum_in = queryMap.get("medicalReportNum_in");
		Object medicalReportCreateTime_gt = queryMap
				.get("medicalReportCreateTime_gt");
		Object medicalReportCreateTime_ge = queryMap
				.get("medicalReportCreateTime_ge");
		Object medicalReportCreateTime_lt = queryMap
				.get("medicalReportCreateTime_lt");
		Object medicalReportCreateTime_le = queryMap
				.get("medicalReportCreateTime_le");
		Object medicalPersonName = queryMap.get("medicalPersonName");
		Object medicalPersonName_like = queryMap.get("medicalPersonName_like");
		Object medicalPersonName_isNull = queryMap
				.get("medicalPersonName_isNull");
		Object medicalPersonName_isNotNull = queryMap
				.get("medicalPersonName_isNotNull");
		Object medicalPersonName_in = queryMap.get("medicalPersonName_in");
		Object medicalPersonGender = queryMap.get("medicalPersonGender");
		Object medicalPersonGender_like = queryMap
				.get("medicalPersonGender_like");
		Object medicalPersonGender_isNull = queryMap
				.get("medicalPersonGender_isNull");
		Object medicalPersonGender_isNotNull = queryMap
				.get("medicalPersonGender_isNotNull");
		Object medicalPersonGender_in = queryMap.get("medicalPersonGender_in");
		Object medicalPersonCardNum = queryMap.get("medicalPersonCardNum");
		Object medicalPersonCardNum_like = queryMap
				.get("medicalPersonCardNum_like");
		Object medicalPersonCardNum_isNull = queryMap
				.get("medicalPersonCardNum_isNull");
		Object medicalPersonCardNum_isNotNull = queryMap
				.get("medicalPersonCardNum_isNotNull");
		Object medicalPersonCardNum_in = queryMap
				.get("medicalPersonCardNum_in");
		Object medicalPersonAge = queryMap.get("medicalPersonAge");
		Object medicalPersonAge_gt = queryMap.get("medicalPersonAge_gt");
		Object medicalPersonAge_ge = queryMap.get("medicalPersonAge_ge");
		Object medicalPersonAge_lt = queryMap.get("medicalPersonAge_lt");
		Object medicalPersonAge_le = queryMap.get("medicalPersonAge_le");
		Object medicalPersonAge_in = queryMap.get("medicalPersonAge_in");
		Object medicalReportContent = queryMap.get("medicalReportContent");
		Object medicalReportContent_like = queryMap
				.get("medicalReportContent_like");
		Object medicalReportContent_isNull = queryMap
				.get("medicalReportContent_isNull");
		Object medicalReportContent_isNotNull = queryMap
				.get("medicalReportContent_isNotNull");
		Object medicalReportContent_in = queryMap
				.get("medicalReportContent_in");
		Object medicalHospital = queryMap.get("medicalHospital");
		Object medicalHospital_like = queryMap.get("medicalHospital_like");
		Object medicalHospital_isNull = queryMap.get("medicalHospital_isNull");
		Object medicalHospital_isNotNull = queryMap
				.get("medicalHospital_isNotNull");
		Object medicalHospital_in = queryMap.get("medicalHospital_in");
		Object hospitalId = queryMap.get("hospitalId");
		Object hospitalId_gt = queryMap.get("hospitalId_gt");
		Object hospitalId_ge = queryMap.get("hospitalId_ge");
		Object hospitalId_lt = queryMap.get("hospitalId_lt");
		Object hospitalId_le = queryMap.get("hospitalId_le");
		Object hospitalId_in = queryMap.get("hospitalId_in");

		QueryCondition qc = new QueryCondition(MedicalReportEntity.ID,
				QueryCondition.gt, "0");
		if (id != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.ID,
					QueryCondition.eq, id));
		}
		if (id_gt != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.ID,
					QueryCondition.gt, id_gt));
		}
		if (id_ge != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.ID,
					QueryCondition.ge, id_ge));
		}
		if (id_lt != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.ID,
					QueryCondition.lt, id_lt));
		}
		if (id_le != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.ID,
					QueryCondition.le, id_le));
		}
		if (id_in != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.ID,
					QueryCondition.in, id_in));
		}
		if (medicalReportNum != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_NUM, QueryCondition.eq,
					medicalReportNum));
		}
		if (medicalReportNum_like != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_NUM,
					QueryCondition.like, medicalReportNum_like));
		}
		if (medicalReportNum_isNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_NUM,
					QueryCondition.isNull, medicalReportNum_isNull));
		}
		if (medicalReportNum_isNotNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_NUM,
					QueryCondition.isNotNull, medicalReportNum_isNotNull));
		}
		if (medicalReportNum_in != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_NUM, QueryCondition.in,
					medicalReportNum_in));
		}
		if (medicalReportCreateTime_gt != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_CREATE_TIME,
					QueryCondition.gt, medicalReportCreateTime_gt));
		}
		if (medicalReportCreateTime_ge != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_CREATE_TIME,
					QueryCondition.ge, medicalReportCreateTime_ge));
		}
		if (medicalReportCreateTime_lt != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_CREATE_TIME,
					QueryCondition.lt, medicalReportCreateTime_lt));
		}
		if (medicalReportCreateTime_le != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_CREATE_TIME,
					QueryCondition.le, medicalReportCreateTime_le));
		}
		if (medicalPersonName != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_NAME, QueryCondition.eq,
					medicalPersonName));
		}
		if (medicalPersonName_like != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_NAME,
					QueryCondition.like, medicalPersonName_like));
		}
		if (medicalPersonName_isNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_NAME,
					QueryCondition.isNull, medicalPersonName_isNull));
		}
		if (medicalPersonName_isNotNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_NAME,
					QueryCondition.isNotNull, medicalPersonName_isNotNull));
		}
		if (medicalPersonName_in != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_NAME, QueryCondition.in,
					medicalPersonName_in));
		}
		if (medicalPersonGender != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_GENDER,
					QueryCondition.eq, medicalPersonGender));
		}
		if (medicalPersonGender_like != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_GENDER,
					QueryCondition.like, medicalPersonGender_like));
		}
		if (medicalPersonGender_isNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_GENDER,
					QueryCondition.isNull, medicalPersonGender_isNull));
		}
		if (medicalPersonGender_isNotNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_GENDER,
					QueryCondition.isNotNull, medicalPersonGender_isNotNull));
		}
		if (medicalPersonGender_in != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_GENDER,
					QueryCondition.in, medicalPersonGender_in));
		}
		if (medicalPersonCardNum != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_CARD_NUM,
					QueryCondition.eq, medicalPersonCardNum));
		}
		if (medicalPersonCardNum_like != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_CARD_NUM,
					QueryCondition.like, medicalPersonCardNum_like));
		}
		if (medicalPersonCardNum_isNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_CARD_NUM,
					QueryCondition.isNull, medicalPersonCardNum_isNull));
		}
		if (medicalPersonCardNum_isNotNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_CARD_NUM,
					QueryCondition.isNotNull, medicalPersonCardNum_isNotNull));
		}
		if (medicalPersonCardNum_in != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_CARD_NUM,
					QueryCondition.in, medicalPersonCardNum_in));
		}
		if (medicalPersonAge != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.eq,
					medicalPersonAge));
		}
		if (medicalPersonAge_gt != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.gt,
					medicalPersonAge_gt));
		}
		if (medicalPersonAge_ge != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.ge,
					medicalPersonAge_ge));
		}
		if (medicalPersonAge_lt != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.lt,
					medicalPersonAge_lt));
		}
		if (medicalPersonAge_le != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.le,
					medicalPersonAge_le));
		}
		if (medicalPersonAge_in != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_PERSON_AGE, QueryCondition.in,
					medicalPersonAge_in));
		}
		if (medicalReportContent != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_CONTENT,
					QueryCondition.eq, medicalReportContent));
		}
		if (medicalReportContent_like != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_CONTENT,
					QueryCondition.like, medicalReportContent_like));
		}
		if (medicalReportContent_isNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_CONTENT,
					QueryCondition.isNull, medicalReportContent_isNull));
		}
		if (medicalReportContent_isNotNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_CONTENT,
					QueryCondition.isNotNull, medicalReportContent_isNotNull));
		}
		if (medicalReportContent_in != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_REPORT_CONTENT,
					QueryCondition.in, medicalReportContent_in));
		}
		if (medicalHospital != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_HOSPITAL, QueryCondition.eq,
					medicalHospital));
		}
		if (medicalHospital_like != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_HOSPITAL, QueryCondition.like,
					medicalHospital_like));
		}
		if (medicalHospital_isNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_HOSPITAL,
					QueryCondition.isNull, medicalHospital_isNull));
		}
		if (medicalHospital_isNotNull != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_HOSPITAL,
					QueryCondition.isNotNull, medicalHospital_isNotNull));
		}
		if (medicalHospital_in != null) {
			qc.andCondition(new QueryCondition(
					MedicalReportEntity.MEDICAL_HOSPITAL, QueryCondition.in,
					medicalHospital_in));
		}
		if (hospitalId != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.HOSPITAL_ID,
					QueryCondition.eq, hospitalId));
		}
		if (hospitalId_gt != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.HOSPITAL_ID,
					QueryCondition.gt, hospitalId_gt));
		}
		if (hospitalId_ge != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.HOSPITAL_ID,
					QueryCondition.ge, hospitalId_ge));
		}
		if (hospitalId_lt != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.HOSPITAL_ID,
					QueryCondition.lt, hospitalId_lt));
		}
		if (hospitalId_le != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.HOSPITAL_ID,
					QueryCondition.le, hospitalId_le));
		}
		if (hospitalId_in != null) {
			qc.andCondition(new QueryCondition(MedicalReportEntity.HOSPITAL_ID,
					QueryCondition.in, hospitalId_in));
		}
		return qc;
	}

}
