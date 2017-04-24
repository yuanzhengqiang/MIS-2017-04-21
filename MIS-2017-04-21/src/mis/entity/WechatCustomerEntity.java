package mis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**   
 * @Title: Entity
 * @Description: 微信客户表
 * @author feng.gu
 * @date 2017-04-21 17:29:44
 * @version V1.0   
 *
 */
@TableDescription(name = "s_wechat_customer")
public class WechatCustomerEntity implements java.io.Serializable {
    public final static String ID = "ID";
    public final static String OPEN_ID = "OPEN_ID";
    public final static String NAKE_NAME = "NAKE_NAME";
    public final static String NOTE_NAME = "NOTE_NAME";
    public final static String GENDER = "GENDER";
    public final static String COUNTRY = "COUNTRY";
    public final static String PROVINCE = "PROVINCE";
    public final static String CITY = "CITY";
    public final static String UPDATE_TIME = "UPDATE_TIME";
    
    /**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
    /**
	 * OpenID
	 */
	@ColumnDescription(name = "OPEN_ID")
	private String openId;
    /**
	 * 昵称
	 */
	@ColumnDescription(name = "NAKE_NAME")
	private String nakeName;
    /**
	 * 备注名
	 */
	@ColumnDescription(name = "NOTE_NAME")
	private String noteName;
    /**
	 * 性别
	 */
	@ColumnDescription(name = "GENDER")
	private Object gender;
    /**
	 * 国家
	 */
	@ColumnDescription(name = "COUNTRY")
	private String country;
    /**
	 * 省
	 */
	@ColumnDescription(name = "PROVINCE")
	private String province;
    /**
	 * 市
	 */
	@ColumnDescription(name = "CITY")
	private String city;
    /**
	 * 添加时间
	 */
	@ColumnDescription(name = "UPDATE_TIME")
	private String updateTime;
        
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
    public String getNakeName() {
		return nakeName;
	}

	public void setNakeName(String nakeName) {
		this.nakeName = nakeName;
	}
    public String getNoteName() {
		return noteName;
	}

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
    public Object getGender() {
		return gender;
	}

	public void setGender(Object gender) {
		this.gender = gender;
	}
    public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
    public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
        
    	
}
