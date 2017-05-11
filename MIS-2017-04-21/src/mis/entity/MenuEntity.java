package mis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**   
 * @Title: Entity
 * @Description: 微信菜单表
 * @author feng.gu
 * @date 2017-05-03 21:03:26
 * @version V1.0   
 *
 */
@TableDescription(name = "s_menu")
public class MenuEntity implements java.io.Serializable {
    public final static String ID = "ID";
    public final static String NAME = "NAME";
    public final static String ORDER_COLUMN = "ORDER_COLUMN";
    public final static String PARENT_ID = "PARENT_ID";
    public final static String ADDRESS = "ADDRESS";
    public final static String CREATE_TIME = "CREATE_TIME";
    public final static String ADDRESS_TYPE = "ADDRESS_TYPE";
    
    /**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
    /**
	 * 菜单名称
	 */
	@ColumnDescription(name = "NAME")
	private String name;
    /**
	 * 菜单顺序
	 */
	@ColumnDescription(name = "ORDER_COLUMN")
	private Integer orderColumn;
    /**
	 * 父菜单ID
	 */
	@ColumnDescription(name = "PARENT_ID")
	private Integer parentId;
    /**
	 * 菜单地址
	 */
	@ColumnDescription(name = "ADDRESS")
	private String address;
    /**
	 * 编辑时间
	 */
	@ColumnDescription(name = "CREATE_TIME")
	private String createTime;
    /**
	 * 地址类型（1-系统，2-微盟，3-素材）
	 */
	@ColumnDescription(name = "ADDRESS_TYPE")
	private Integer addressType;
        
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    public Integer getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(Integer orderColumn) {
		this.orderColumn = orderColumn;
	}
    public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
    public Integer getAddressType() {
		return addressType;
	}

	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}
        
    	
}
