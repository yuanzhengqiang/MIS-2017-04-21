package mis.entity;

import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**
 * @Title: Entity
 * @Description: 订单体检项目关系表
 * @author feng.gu
 * @date 2017-04-21 17:23:21
 * @version V1.0
 * 
 */
@TableDescription(name = "s_order_medical_item_relation")
public class OrderMedicalItemRelationEntity implements java.io.Serializable {
	public final static String ID = "ID";
	public final static String ORDER_ID = "ORDER_ID";
	public final static String MEDICAL_ITEM_ID = "MEDICAL_ITEM_ID";
	public final static String MEDICAL_ITEM_NAME = "MEDICAL_ITEM_NAME";
	public final static String MEDICAL_ITEM_PRICE = "MEDICAL_ITEM_PRICE";
	public final static String ICONS = "ICONS";
	public final static String TEST_PURPOSE = "TEST_PURPOSE";

	/**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
	/**
	 * 订单id
	 */
	@ColumnDescription(name = "ORDER_ID")
	private Integer orderId;
	/**
	 * 体检项目id
	 */
	@ColumnDescription(name = "MEDICAL_ITEM_ID")
	private Integer medicalItemId;
	/**
	 * 体检项目名称
	 */
	@ColumnDescription(name = "MEDICAL_ITEM_NAME")
	private String medicalItemName;
	/**
	 * 体检项目价格
	 */
	@ColumnDescription(name = "MEDICAL_ITEM_PRICE")
	private Double medicalItemPrice;
	/**
	 * 体检项目图标
	 */
	@ColumnDescription(name = "ICONS")
	private String icons;
	/**
	 * 体检目的
	 */
	@ColumnDescription(name = "TEST_PURPOSE")
	private String testPurpose;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMedicalItemId() {
		return medicalItemId;
	}

	public void setMedicalItemId(Integer medicalItemId) {
		this.medicalItemId = medicalItemId;
	}

	public String getMedicalItemName() {
		return medicalItemName;
	}

	public void setMedicalItemName(String medicalItemName) {
		this.medicalItemName = medicalItemName;
	}

	public Double getMedicalItemPrice() {
		return medicalItemPrice;
	}

	public void setMedicalItemPrice(Double medicalItemPrice) {
		this.medicalItemPrice = medicalItemPrice;
	}
	
	public String getTestPurpose() {
		return testPurpose;
	}

	public void setTestPurpose(String testPurpose) {
		this.testPurpose = testPurpose;
	}
	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}
	/**
	 * 关系描述
	 */
	@RelationlDescription(relation = "ManyToOne", joinEntity = "OrderEntityEntity", joinColumn = "ID")
	private OrderEntity orderEntity;

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	/**
	 * 关系描述
	 */
	@RelationlDescription(relation = "ManyToOne", joinEntity = "MedicalItemEntity", joinColumn = "ID")
	private MedicalItemEntity medicalItem;

	public MedicalItemEntity getMedicalItem() {
		return medicalItem;
	}

	public void setMedicalItem(MedicalItemEntity medicalItem) {
		this.medicalItem = medicalItem;
	}

}
