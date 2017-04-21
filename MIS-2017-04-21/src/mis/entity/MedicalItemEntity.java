package mis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**   
 * @Title: Entity
 * @Description: 体检项目表
 * @author feng.gu
 * @date 2017-04-21 16:09:59
 * @version V1.0   
 *
 */
@TableDescription(name = "s_medical_item")
public class MedicalItemEntity implements java.io.Serializable {
    public final static String ID = "ID";
    public final static String ITEM_NAME = "ITEM_NAME";
    public final static String CATEGORY = "CATEGORY";
    public final static String TEST_WAY = "TEST_WAY";
    public final static String TEST_PURPOSE = "TEST_PURPOSE";
    public final static String SELECT_DES = "SELECT_DES";
    public final static String PRICE = "PRICE";
    public final static String DES = "DES";
    public final static String MATTERS_NEED_ATTENTION = "MATTERS_NEED_ATTENTION";
    
    /**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
    /**
	 * 项目名称
	 */
	@ColumnDescription(name = "ITEM_NAME")
	private String itemName;
    /**
	 * 类别
	 */
	@ColumnDescription(name = "CATEGORY")
	private Integer category;
    /**
	 * 检测方式
	 */
	@ColumnDescription(name = "TEST_WAY")
	private String testWay;
    /**
	 * 检测目的
	 */
	@ColumnDescription(name = "TEST_PURPOSE")
	private String testPurpose;
    /**
	 * 选择说明
	 */
	@ColumnDescription(name = "SELECT_DES")
	private String selectDes;
    /**
	 * 价格
	 */
	@ColumnDescription(name = "PRICE")
	private Double price;
    /**
	 * 备注
	 */
	@ColumnDescription(name = "DES")
	private String des;
    /**
	 * 注意事项
	 */
	@ColumnDescription(name = "MATTERS_NEED_ATTENTION")
	private String mattersNeedAttention;
        
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
    public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}
    public String getTestWay() {
		return testWay;
	}

	public void setTestWay(String testWay) {
		this.testWay = testWay;
	}
    public String getTestPurpose() {
		return testPurpose;
	}

	public void setTestPurpose(String testPurpose) {
		this.testPurpose = testPurpose;
	}
    public String getSelectDes() {
		return selectDes;
	}

	public void setSelectDes(String selectDes) {
		this.selectDes = selectDes;
	}
    public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
    public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
    public String getMattersNeedAttention() {
		return mattersNeedAttention;
	}

	public void setMattersNeedAttention(String mattersNeedAttention) {
		this.mattersNeedAttention = mattersNeedAttention;
	}
        
    	
}
