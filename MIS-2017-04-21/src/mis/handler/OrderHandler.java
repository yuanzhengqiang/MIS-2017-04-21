package mis.handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.MedicalItemEntity;
import mis.entity.MedicalReportEntity;
import mis.entity.OrderEntity;
import mis.entity.OrderMedicalItemRelationEntity;
import mis.pack.OrderPack;
import mis.parse.OrderParse;
import mis.service.MedicalItemService;
import mis.service.OrderMedicalItemRelationService;
import mis.service.OrderService;
import mis.utils.RandomNum;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.framework.system.business.handler.BaseHandler;
import com.framework.system.db.query.OrderVO;

/**
 * @Title: Handler
 * @Description: 医院体检项目关系表业务处理器
 * @author feng.gu
 * @date 2017-04-29 18:28:51
 * @version V1.0
 *
 */
public class OrderHandler extends BaseHandler {
	private static Logger logger = Logger.getLogger(OrderService.class);
	/**
	 * 解析器
	 */
	private OrderParse orderParse = OrderParse.getInstance();
	/**
	 * 业务处理器
	 */
	private OrderService orderService = OrderService.getInstance();
	/**
	 * 封装器
	 */
	private OrderPack orderPack = OrderPack.getInstance();

	private static OrderHandler orderHandler;

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static OrderHandler getInstance() {
		if (orderHandler == null) {
			orderHandler = new OrderHandler();
		}
		return orderHandler;
	}

	/**
	 * 
	 * @param type
	 *            1-json 2-xml
	 * @param entityName
	 * @param command
	 * @param reqStr
	 * @param request
	 * @param response
	 */
	public String doHandler(int type, String command, String reqStr,
			HttpServletRequest request, HttpServletResponse response) {
		logger.debug("请求消息：" + reqStr);
		String resultStr = "";
		try {
			// 解析
			Map<String, Object> parseMap = orderParse.parse(type, command,
					reqStr, request);
			String action = (String) parseMap.get("action");
			OrderEntity order = (OrderEntity) parseMap.get("order");
			List<OrderEntity> orderList = (List<OrderEntity>) parseMap
					.get("orderList");
			Integer id = (Integer) parseMap.get("id");
			Map<String, Object> queryMap = (Map<String, Object>) parseMap
					.get("queryMap");
			Integer pageno = (Integer) parseMap.get("pageno");
			Integer pagesize = (Integer) parseMap.get("pagesize");
			List<OrderVO> orderListVO = (List<OrderVO>) parseMap.get("orderList");
			
			ArrayList<OrderMedicalItemRelationEntity> orderMedicalItemRelationList = (ArrayList<OrderMedicalItemRelationEntity>) parseMap.get("orderMedicalItemRelationList");

			Boolean medicalReportShow = (Boolean) parseMap
					.get("medicalReportShow");
			Boolean delMedicalReport = (Boolean) parseMap
					.get("delMedicalReport");
			Boolean servicePersonShow = (Boolean) parseMap
					.get("servicePersonShow");
			Boolean delServicePerson = (Boolean) parseMap
					.get("delServicePerson");

			// 业务处理
			Object result = null;
			if ("save".equals(action)) {
				if (order != null) {
					OrderEntity _temp_ = OrderService.getInstance().getById(order.getId());
					if (_temp_ != null) {
						if (order.getContactWay() != null)
							_temp_.setContactWay(order.getContactWay());
						if (order.getExpectMedicalTime() != null)
							_temp_.setExpectMedicalTime(order.getExpectMedicalTime());
						if (order.getExpectReportCompleteTime() != null)
							_temp_.setExpectReportCompleteTime(order.getExpectReportCompleteTime());
						if (order.getId() != null) {
							if (order.getMedicalReport() != null) {
								MedicalReportEntity _mre_ = order.getMedicalReport();
								if (_mre_ != null) {
									if (_mre_.getMedicalReportNum() == null || _mre_.getMedicalReportNum().length() == 0) {
										String _orderNum_ = RandomNum.generateHexString(2);
										_mre_.setMedicalReportNum(_orderNum_);
										order.setMedicalReport(_mre_);
									}
								}
							}
						}
						if (order.getIsPay() != null)
							_temp_.setIsPay(order.getIsPay());
						if (order.getMedicalCompleteTime() != null)
							_temp_.setMedicalCompleteTime(order.getMedicalCompleteTime());
						if (order.getMedicalHospital() != null)
							_temp_.setMedicalHospital(order.getMedicalHospital());
						if (order.getMedicalPersonCard() != null)
							_temp_.setMedicalPersonCard(order.getMedicalPersonCard());
						if (order.getMedicalPersonGender() != null)
							_temp_.setMedicalPersonGender(order.getMedicalPersonGender());
						if (order.getMedicalPersonName() != null)
							_temp_.setMedicalPersonName(order.getMedicalPersonName());
						if (order.getMedicalReport() != null)
							_temp_.setMedicalReport(order.getMedicalReport());
						if (order.getMedicalReportExpress() != null)
							_temp_.setMedicalReportExpress(order.getMedicalReportExpress());
						if (order.getMedicalReportExpressOrderNum() != null)
							_temp_.setMedicalReportExpressOrderNum(order.getMedicalReportExpressOrderNum());
						if (order.getMedicalReportId() != null)
							_temp_.setMedicalReportId(order.getMedicalReportId());
						if (order.getMedicalReportStatus() != null)
							_temp_.setMedicalReportStatus(order.getMedicalReportStatus());
						if (order.getOrderCustomer() != null)
							_temp_.setOrderCustomer(order.getOrderCustomer());
						if (order.getOrderNum() != null)
							_temp_.setOrderNum(order.getOrderNum());
						if (order.getOrderTime() != null)
							_temp_.setOrderTime(order.getOrderTime());
						if (order.getReportCreateTime() != null)
							_temp_.setReportCreateTime(order.getReportCreateTime());
						if (order.getReportSendAddr() != null)
							_temp_.setReportSendAddr(order.getReportSendAddr());
						if (order.getReportSendPerson() != null)
							_temp_.setReportSendPerson(order.getReportSendPerson());
						if (order.getReportSendPersonContactWay() != null)
							_temp_.setReportSendPersonContactWay(order.getReportSendPersonContactWay());
						if (order.getServicePerson() != null)
							_temp_.setServicePerson(order.getServicePerson());
						if (order.getServicePersonId() != null)
							_temp_.setServicePersonId(order.getServicePersonId());
						if (order.getServicePersonName() != null)
							_temp_.setServicePersonName(order.getServicePersonName());
						if (order.getServicePrice() != null)
							_temp_.setServicePrice(order.getServicePrice());
						if (order.getStatus() != null)
							_temp_.setStatus(order.getStatus());
						if (order.getTotalPrice() != null)
							_temp_.setTotalPrice(order.getTotalPrice());
						order = _temp_;
					}
				}
				if (order.getId() == null) {
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					order.setOrderTime(sdf.format(date));
					String orderNum = RandomNum.generateHexString(2);
					order.setOrderNum(orderNum);
					MedicalReportEntity _mre_ = order.getMedicalReport();
					if (_mre_ != null) {
						if (_mre_.getMedicalReportNum() == null) {
							String _orderNum_ = RandomNum.generateHexString(2);
							_mre_.setMedicalReportNum(_orderNum_);
							order.setMedicalReport(_mre_);
						}
					}
				}
				result = orderService.save(order);
				/** 这里保存体检订单和体检项目的关联关系 */
				if (orderMedicalItemRelationList != null && orderMedicalItemRelationList.size() > 0) {
					for (int index = 0; index < orderMedicalItemRelationList.size(); index++) {
						/** 填写冗余字段 */
						MedicalItemEntity medicalitem = MedicalItemService.getInstance().getById(orderMedicalItemRelationList.get(index).getMedicalItemId());
						if (medicalitem != null) {
							orderMedicalItemRelationList.get(index).setMedicalItemName(medicalitem.getItemName());
							orderMedicalItemRelationList.get(index).setMedicalItemPrice(medicalitem.getPrice());
							orderMedicalItemRelationList.get(index).setIcons(medicalitem.getIcons());
							orderMedicalItemRelationList.get(index).setTestPurpose(medicalitem.getTestPurpose());
						}
						orderMedicalItemRelationList.get(index).setOrderId(order.getId());
					}
					OrderMedicalItemRelationService.getInstance().saveList(orderMedicalItemRelationList);
				}
			} else if ("saveList".equals(action)) {
				result = orderService.saveList(orderList);
			} else if ("getById".equals(action)) {
				result = orderService.getById(id, medicalReportShow,
						servicePersonShow);
			} else if ("getListByCondition".equals(action)) {
				result = orderService.getListByCondition(queryMap, orderListVO,
						pageno, pagesize, medicalReportShow, servicePersonShow);
			} else if ("del".equals(action)) {
				result = orderService.del(id, delMedicalReport,
						delServicePerson);
			} else if ("delList".equals(action)) {
				result = orderService.delList(queryMap, delMedicalReport,
						delServicePerson);
			}
			// 封装
			Map<String, Object> packMap = orderPack.pack(type, action, result,
					order);
			String actionBack = (String) packMap.get("action");
			String resultBack = (String) packMap.get("result");
			String desBack = (String) packMap.get("des");
			JSONObject pageBack = (JSONObject) packMap.get("page");
			JSONObject contentBack = (JSONObject) packMap.get("content");

			JSONObject repJson = new JSONObject();
			if (actionBack != null && !"".equals(actionBack)) {
				repJson.put("action", actionBack);
			}
			if (resultBack != null && !"".equals(resultBack)) {
				repJson.put("result", resultBack);
			}
			if (desBack != null && !"".equals(desBack)) {
				repJson.put("des", desBack);
			}
			if (pageBack != null) {
				repJson.put("page", pageBack);
			}
			if (contentBack != null && !"".equals(contentBack)) {
				repJson.put("content", contentBack);
			}
			logger.debug("返回消息：" + repJson.toString());
			resultStr = repJson.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		return resultStr;
	}
	
	
	public static void main (String[] argvs) {
		JSONArray arr = new JSONArray();
		JSONObject jobj1 = new JSONObject();
		jobj1.put("haha", "哈哈");
		JSONObject jobj2 = new JSONObject();
		jobj2.put("hehe", "呵呵");
		arr.add(jobj1);
		arr.add(jobj2);
		System.out.println(arr.toString());
	}
	
}
