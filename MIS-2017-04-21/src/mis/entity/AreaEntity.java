package mis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**   
 * @Title: Entity
 * @Description: 区域表
 * @author feng.gu
 * @date 2017-04-21 16:26:10
 * @version V1.0   
 *
 */
@TableDescription(name = "s_area")
public class AreaEntity implements java.io.Serializable {
    public final static String ID = "ID";
    public final static String AREA = "AREA";
    public final static String UPDATE_TIME = "UPDATE_TIME";
    
    /**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
    /**
	 * 地区
	 */
	@ColumnDescription(name = "AREA")
	private String area;
    /**
	 * 修改时间(yyyyMMddHHmmss)
	 */
	@ColumnDescription(name = "UPDATE_TIME")
	private String updateTime;
        
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
    public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
        
    	
}
