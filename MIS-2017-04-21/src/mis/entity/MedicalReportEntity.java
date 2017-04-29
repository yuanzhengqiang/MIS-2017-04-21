package mis.entity;

import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**
 * @Title: Entity
 * @Description: 医院体检项目关系表
 * @author feng.gu
 * @date 2017-04-28 13:31:49
 * @version V1.0
 *
 */
@TableDescription(name = "s_medical_report")
public class MedicalReportEntity implements java.io.Serializable {
	public final static String ID = "ID";
	public final static String MEDICAL_REPORT_NUM = "MEDICAL_REPORT_NUM";
	public final static String MEDICAL_REPORT_CREATE_TIME = "MEDICAL_REPORT_CREATE_TIME";
	public final static String MEDICAL_PERSON_NAME = "MEDICAL_PERSON_NAME";
	public final static String MEDICAL_PERSON_GENDER = "MEDICAL_PERSON_GENDER";
	public final static String MEDICAL_PERSON_CARD_NUM = "MEDICAL_PERSON_CARD_NUM";
	public final static String MEDICAL_PERSON_AGE = "MEDICAL_PERSON_AGE";
	public final static String MEDICAL_REPORT_CONTENT = "MEDICAL_REPORT_CONTENT";
	public final static String MEDICAL_HOSPITAL = "MEDICAL_HOSPITAL";
	public final static String HOSPITAL_ID = "HOSPITAL_ID";
	public final static String MEDICAL_REPORT_DOWNLOAD_LINK = "MEDICAL_REPORT_DOWNLOAD_LINK";

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
	/**
	 * 体检医院的 ID
	 */
	@ColumnDescription(name = "HOSPITAL_ID")
	private Integer hospitalId;
	/**
	 * 体检报告链接
	 */
	@ColumnDescription(name = "MEDICAL_REPORT_DOWNLOAD_LINK")
	private String medicalReportDownloadLink;

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

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/*****/
	
	public void setMedicalReportDownloadLink(String medicalReportDownloadLink) {
		this.medicalReportDownloadLink = medicalReportDownloadLink;
	}
	
	public String getMedicalReportDownloadLink() {
		return this.medicalReportDownloadLink;
	}
	
	/**
	 * 关系描述
	 */
	@RelationlDescription(relation = "ManyToOne", joinEntity = "HospitalEntity", joinColumn = "ID")
	private HospitalEntity hospital;

	public HospitalEntity getHospital() {
		return hospital;
	}

	public void setHospital(HospitalEntity hospital) {
		this.hospital = hospital;
	}

}
