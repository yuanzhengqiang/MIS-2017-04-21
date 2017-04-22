package com.framework.system.mis.entity;

import java.util.List;

import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**
 * @Title: Entity
 * @Description: 订单表
 * @author feng.gu
 * @date 2017-04-21 16:39:13
 * @version V1.0
 * 
 */
@TableDescription(name = "s_order")
public class OrderEntity implements java.io.Serializable {
	public final static String ID = "ID";
	public final static String ORDER_NUM = "ORDER_NUM";
	public final static String TOTAL_PRICE = "TOTAL_PRICE";
	public final static String ORDER_CUSTOMER = "ORDER_CUSTOMER";
	public final static String ORDER_TIME = "ORDER_TIME";
	public final static String MEDICAL_HOSPITAL = "MEDICAL_HOSPITAL";
	public final static String MEDICAL_PERSON_NAME = "MEDICAL_PERSON_NAME";
	public final static String MEDICAL_PERSON_CARD = "MEDICAL_PERSON_CARD";
	public final static String MEDICAL_PERSON_GENDER = "MEDICAL_PERSON_GENDER";
	public final static String CONTACT_WAY = "CONTACT_WAY";
	public final static String REPORT_SEND_ADDR = "REPORT_SEND_ADDR";
	public final static String EXPECT_MEDICAL_TIME = "EXPECT_MEDICAL_TIME";
	public final static String MEDICAL_COMPLETE_TIME = "MEDICAL_COMPLETE_TIME";
	public final static String EXPECT_REPORT_COMPLETE_TIME = "EXPECT_REPORT_COMPLETE_TIME";
	public final static String REPORT_CREATE_TIME = "REPORT_CREATE_TIME";
	public final static String SERVICE_PERSON_ID = "SERVICE_PERSON_ID";
	public final static String STATUS = "STATUS";
	public final static String MEDICAL_REPORT_ID = "MEDICAL_REPORT_ID";

	/**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
	/**
	 * 订单编号
	 */
	@ColumnDescription(name = "ORDER_NUM")
	private String orderNum;
	/**
	 * 总价
	 */
	@ColumnDescription(name = "TOTAL_PRICE")
	private Integer totalPrice;
	/**
	 * 下单客户
	 */
	@ColumnDescription(name = "ORDER_CUSTOMER")
	private String orderCustomer;
	/**
	 * 下单时间
	 */
	@ColumnDescription(name = "ORDER_TIME")
	private String orderTime;
	/**
	 * 体检医院
	 */
	@ColumnDescription(name = "MEDICAL_HOSPITAL")
	private String medicalHospital;
	/**
	 * 体检人姓名
	 */
	@ColumnDescription(name = "MEDICAL_PERSON_NAME")
	private String medicalPersonName;
	/**
	 * 体检人身份证号
	 */
	@ColumnDescription(name = "MEDICAL_PERSON_CARD")
	private String medicalPersonCard;
	/**
	 * 体检人性别
	 */
	@ColumnDescription(name = "MEDICAL_PERSON_GENDER")
	private Object medicalPersonGender;
	/**
	 * 联系方式
	 */
	@ColumnDescription(name = "CONTACT_WAY")
	private String contactWay;
	/**
	 * 报告寄送地址
	 */
	@ColumnDescription(name = "REPORT_SEND_ADDR")
	private String reportSendAddr;
	/**
	 * 预计体检时间
	 */
	@ColumnDescription(name = "EXPECT_MEDICAL_TIME")
	private String expectMedicalTime;
	/**
	 * 体检完成时间
	 */
	@ColumnDescription(name = "MEDICAL_COMPLETE_TIME")
	private String medicalCompleteTime;
	/**
	 * 预计报告完成时间
	 */
	@ColumnDescription(name = "EXPECT_REPORT_COMPLETE_TIME")
	private String expectReportCompleteTime;
	/**
	 * 报告生成时间
	 */
	@ColumnDescription(name = "REPORT_CREATE_TIME")
	private String reportCreateTime;
	/**
	 * 服务人员id
	 */
	@ColumnDescription(name = "SERVICE_PERSON_ID")
	private Integer servicePersonId;
	/**
	 * 状态（预约成功/体检完成/生成报告1（还未支付余额）/生成报告2（已经支付余额）/取消）
	 */
	@ColumnDescription(name = "STATUS")
	private Integer status;
	/**
	 * 体检报告id
	 */
	@ColumnDescription(name = "MEDICAL_REPORT_ID")
	private Integer medicalReportId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(String orderCustomer) {
		this.orderCustomer = orderCustomer;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getMedicalHospital() {
		return medicalHospital;
	}

	public void setMedicalHospital(String medicalHospital) {
		this.medicalHospital = medicalHospital;
	}

	public String getMedicalPersonName() {
		return medicalPersonName;
	}

	public void setMedicalPersonName(String medicalPersonName) {
		this.medicalPersonName = medicalPersonName;
	}

	public String getMedicalPersonCard() {
		return medicalPersonCard;
	}

	public void setMedicalPersonCard(String medicalPersonCard) {
		this.medicalPersonCard = medicalPersonCard;
	}

	public Object getMedicalPersonGender() {
		return medicalPersonGender;
	}

	public void setMedicalPersonGender(Object medicalPersonGender) {
		this.medicalPersonGender = medicalPersonGender;
	}

	public String getContactWay() {
		return contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public String getReportSendAddr() {
		return reportSendAddr;
	}

	public void setReportSendAddr(String reportSendAddr) {
		this.reportSendAddr = reportSendAddr;
	}

	public String getExpectMedicalTime() {
		return expectMedicalTime;
	}

	public void setExpectMedicalTime(String expectMedicalTime) {
		this.expectMedicalTime = expectMedicalTime;
	}

	public String getMedicalCompleteTime() {
		return medicalCompleteTime;
	}

	public void setMedicalCompleteTime(String medicalCompleteTime) {
		this.medicalCompleteTime = medicalCompleteTime;
	}

	public String getExpectReportCompleteTime() {
		return expectReportCompleteTime;
	}

	public void setExpectReportCompleteTime(String expectReportCompleteTime) {
		this.expectReportCompleteTime = expectReportCompleteTime;
	}

	public String getReportCreateTime() {
		return reportCreateTime;
	}

	public void setReportCreateTime(String reportCreateTime) {
		this.reportCreateTime = reportCreateTime;
	}

	public Integer getServicePersonId() {
		return servicePersonId;
	}

	public void setServicePersonId(Integer servicePersonId) {
		this.servicePersonId = servicePersonId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMedicalReportId() {
		return medicalReportId;
	}

	public void setMedicalReportId(Integer medicalReportId) {
		this.medicalReportId = medicalReportId;
	}

	/**
	 * 关系描述
	 */
	@RelationlDescription(relation = "ManyToOne", joinEntity = "OrderEntity", joinColumn = "PARENT_ID")
	private OrderEntity parentOrder;

	public OrderEntity getParentOrder() {
		return parentOrder;
	}

	public void setParentOrder(OrderEntity parentOrder) {
		this.parentOrder = parentOrder;
	}

	@RelationlDescription(relation = "OneToMany", joinEntity = "OrderEntity", joinColumn = "PARENT_ID")
	private List<OrderEntity> childOrderList;

	public List<OrderEntity> getChildOrderList() {
		return childOrderList;
	}

	public void setChildOrderList(List<OrderEntity> childOrderList) {
		this.childOrderList = childOrderList;
	}

	/**
	 * 关系描述
	 */
	@RelationlDescription(relation = "ManyToOne", joinEntity = "ServicePersonEntity", joinColumn = "ID")
	private ServicePersonEntity servicePerson;

	public ServicePersonEntity getServicePerson() {
		return servicePerson;
	}

	public void setServicePerson(ServicePersonEntity servicePerson) {
		this.servicePerson = servicePerson;
	}

	/**
	 * 关系描述
	 */
	@RelationlDescription(relation = "ManyToOne", joinEntity = "MedicalReportEntity", joinColumn = "ID")
	private MedicalReportEntity medicalReport;

	public MedicalReportEntity getMedicalReport() {
		return medicalReport;
	}

	public void setMedicalReport(MedicalReportEntity medicalReport) {
		this.medicalReport = medicalReport;
	}

}
