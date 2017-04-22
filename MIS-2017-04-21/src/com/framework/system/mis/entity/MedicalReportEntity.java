package com.framework.system.mis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**   
 * @Title: Entity
 * @Description: 体检记录表
 * @author feng.gu
 * @date 2017-04-21 16:18:36
 * @version V1.0   
 *
 */
@TableDescription(name = "s_medical_report")
public class MedicalReportEntity implements java.io.Serializable {
    public final static String ID = "ID";
    public final static String MEDICAL_REPORT_NUM = "MEDICAL_REPORT_NUM";
    public final static String MEDICAL_REPORT_STATUS = "MEDICAL_REPORT_STATUS";
    public final static String MEDICAL_REPORT_EXPRESS = "MEDICAL_REPORT_EXPRESS";
    public final static String MEDICAL_REPORT_EXPRESS_ORDER_NUM = "MEDICAL_REPORT_EXPRESS_ORDER_NUM";
    public final static String MEDICAL_REPORT_CREATE_TIME = "MEDICAL_REPORT_CREATE_TIME";
    public final static String MEDICAL_PERSON_NAME = "MEDICAL_PERSON_NAME";
    public final static String MEDICAL_PERSON_GENDER = "MEDICAL_PERSON_GENDER";
    public final static String MEDICAL_PERSON_CARD_NUM = "MEDICAL_PERSON_CARD_NUM";
    public final static String MEDICAL_PERSON_AGE = "MEDICAL_PERSON_AGE";
    public final static String MEDICAL_REPORT_CONTENT = "MEDICAL_REPORT_CONTENT";
    public final static String MEDICAL_HOSPITAL = "MEDICAL_HOSPITAL";
    
    /**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
    /**
	 * 体检报告编号
	 */
	@ColumnDescription(name = "MEDICAL_REPORT_NUM")
	private String medicalReportNum;
    /**
	 * 体检报告状态
	 */
	@ColumnDescription(name = "MEDICAL_REPORT_STATUS")
	private Object medicalReportStatus;
    /**
	 * 体检报告快递商
	 */
	@ColumnDescription(name = "MEDICAL_REPORT_EXPRESS")
	private String medicalReportExpress;
    /**
	 * 体检报告快递单号
	 */
	@ColumnDescription(name = "MEDICAL_REPORT_EXPRESS_ORDER_NUM")
	private String medicalReportExpressOrderNum;
    /**
	 * 体检报告生成时间
	 */
	@ColumnDescription(name = "MEDICAL_REPORT_CREATE_TIME")
	private String medicalReportCreateTime;
    /**
	 * 体检人姓名
	 */
	@ColumnDescription(name = "MEDICAL_PERSON_NAME")
	private String medicalPersonName;
    /**
	 * 体检人性别（0-女/1-男）
	 */
	@ColumnDescription(name = "MEDICAL_PERSON_GENDER")
	private Object medicalPersonGender;
    /**
	 * 体检人身份证号
	 */
	@ColumnDescription(name = "MEDICAL_PERSON_CARD_NUM")
	private String medicalPersonCardNum;
    /**
	 * 体检人年龄
	 */
	@ColumnDescription(name = "MEDICAL_PERSON_AGE")
	private Integer medicalPersonAge;
    /**
	 * 体检报告内容
	 */
	@ColumnDescription(name = "MEDICAL_REPORT_CONTENT")
	private String medicalReportContent;
    /**
	 * 体检医院
	 */
	@ColumnDescription(name = "MEDICAL_HOSPITAL")
	private String medicalHospital;
        
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    public String getMedicalReportNum() {
		return medicalReportNum;
	}

	public void setMedicalReportNum(String medicalReportNum) {
		this.medicalReportNum = medicalReportNum;
	}
    public Object getMedicalReportStatus() {
		return medicalReportStatus;
	}

	public void setMedicalReportStatus(Object medicalReportStatus) {
		this.medicalReportStatus = medicalReportStatus;
	}
    public String getMedicalReportExpress() {
		return medicalReportExpress;
	}

	public void setMedicalReportExpress(String medicalReportExpress) {
		this.medicalReportExpress = medicalReportExpress;
	}
    public String getMedicalReportExpressOrderNum() {
		return medicalReportExpressOrderNum;
	}

	public void setMedicalReportExpressOrderNum(String medicalReportExpressOrderNum) {
		this.medicalReportExpressOrderNum = medicalReportExpressOrderNum;
	}
    public String getMedicalReportCreateTime() {
		return medicalReportCreateTime;
	}

	public void setMedicalReportCreateTime(String medicalReportCreateTime) {
		this.medicalReportCreateTime = medicalReportCreateTime;
	}
    public String getMedicalPersonName() {
		return medicalPersonName;
	}

	public void setMedicalPersonName(String medicalPersonName) {
		this.medicalPersonName = medicalPersonName;
	}
    public Object getMedicalPersonGender() {
		return medicalPersonGender;
	}

	public void setMedicalPersonGender(Object medicalPersonGender) {
		this.medicalPersonGender = medicalPersonGender;
	}
    public String getMedicalPersonCardNum() {
		return medicalPersonCardNum;
	}

	public void setMedicalPersonCardNum(String medicalPersonCardNum) {
		this.medicalPersonCardNum = medicalPersonCardNum;
	}
    public Integer getMedicalPersonAge() {
		return medicalPersonAge;
	}

	public void setMedicalPersonAge(Integer medicalPersonAge) {
		this.medicalPersonAge = medicalPersonAge;
	}
    public String getMedicalReportContent() {
		return medicalReportContent;
	}

	public void setMedicalReportContent(String medicalReportContent) {
		this.medicalReportContent = medicalReportContent;
	}
    public String getMedicalHospital() {
		return medicalHospital;
	}

	public void setMedicalHospital(String medicalHospital) {
		this.medicalHospital = medicalHospital;
	}
        
    	
}
