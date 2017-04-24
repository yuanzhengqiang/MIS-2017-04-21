package mis.entity;

import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**
 * @Title: Entity
 * @Description: 医院表
 * @author feng.gu
 * @date 2017-04-21 17:05:03
 * @version V1.0
 * 
 */
@TableDescription(name = "s_hospital")
public class HospitalEntity implements java.io.Serializable {
	public final static String ID = "ID";
	public final static String HOSPITAL_NAME = "HOSPITAL_NAME";
	public final static String LEVEL = "LEVEL";
	public final static String AREA_ID = "AREA_ID";
	public final static String ADDR = "ADDR";

	/**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
	/**
	 * 医院名称
	 */
	@ColumnDescription(name = "HOSPITAL_NAME")
	private String hospitalName;
	/**
	 * 等级
	 */
	@ColumnDescription(name = "LEVEL")
	private String level;
	/**
	 * 地区id
	 */
	@ColumnDescription(name = "AREA_ID")
	private Integer areaId;
	/**
	 * 地址
	 */
	@ColumnDescription(name = "ADDR")
	private String addr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * 关系描述
	 */
	@RelationlDescription(relation = "ManyToOne", joinEntity = "AreaEntityEntity", joinColumn = "ID")
	private AreaEntity areaEntity;

	public AreaEntity getAreaEntity() {
		return areaEntity;
	}

	public void setAreaEntity(AreaEntity areaEntity) {
		this.areaEntity = areaEntity;
	}

}
