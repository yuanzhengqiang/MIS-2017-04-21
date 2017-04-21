package mis.entity;

import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**
 * @Title: Entity
 * @Description: 医院体检项目关系表
 * @author feng.gu
 * @date 2017-04-21 17:12:18
 * @version V1.0
 * 
 */
@TableDescription(name = "s_hospital_detecting_item_relation")
public class HospitalDetectingItemRelationEntity implements
		java.io.Serializable {
	public final static String ID = "ID";
	public final static String HOSPITAL_ID = "HOSPITAL_ID";
	public final static String DETECTING_ITEM = "DETECTING_ITEM";

	/**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
	/**
	 * 医院id
	 */
	@ColumnDescription(name = "HOSPITAL_ID")
	private Integer hospitalId;
	/**
	 * 检测项目id
	 */
	@ColumnDescription(name = "DETECTING_ITEM")
	private Integer detectingItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getDetectingItem() {
		return detectingItem;
	}

	public void setDetectingItem(Integer detectingItem) {
		this.detectingItem = detectingItem;
	}

	/**
	 * 关系描述
	 */
	@RelationlDescription(relation = "ManyToOne", joinEntity = "HospitalEntityEntity", joinColumn = "ID")
	private HospitalEntity hospitalEntity;

	public HospitalEntity getHospitalEntity() {
		return hospitalEntity;
	}

	public void setHospitalEntity(HospitalEntity hospitalEntity) {
		this.hospitalEntity = hospitalEntity;
	}

}
