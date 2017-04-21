package mis.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**   
 * @Title: Entity
 * @Description: 服务人员表
 * @author feng.gu
 * @date 2017-04-21 16:22:00
 * @version V1.0   
 *
 */
@TableDescription(name = "s_service_person")
public class ServicePersonEntity implements java.io.Serializable {
    public final static String ID = "ID";
    public final static String NAME = "NAME";
    public final static String GENDER = "GENDER";
    public final static String HEAD_PORTRAIT = "HEAD_PORTRAIT";
    public final static String BIRTHDAY = "BIRTHDAY";
    public final static String ACADEMIC = "ACADEMIC";
    public final static String CONTACT = "CONTACT";
    public final static String WECHAT_NUM = "WECHAT_NUM";
    public final static String WECHAT_QR_CODE = "WECHAT_QR_CODE";
    
    /**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
    /**
	 * 姓名
	 */
	@ColumnDescription(name = "NAME")
	private String name;
    /**
	 * 性别
	 */
	@ColumnDescription(name = "GENDER")
	private String gender;
    /**
	 * 头像
	 */
	@ColumnDescription(name = "HEAD_PORTRAIT")
	private Object headPortrait;
    /**
	 * 生日
	 */
	@ColumnDescription(name = "BIRTHDAY")
	private String birthday;
    /**
	 * 学历
	 */
	@ColumnDescription(name = "ACADEMIC")
	private String academic;
    /**
	 * 联系方式
	 */
	@ColumnDescription(name = "CONTACT")
	private String contact;
    /**
	 * 微信号
	 */
	@ColumnDescription(name = "WECHAT_NUM")
	private String wechatNum;
    /**
	 * 二维码
	 */
	@ColumnDescription(name = "WECHAT_QR_CODE")
	private String wechatQrCode;
        
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
    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
    public Object getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(Object headPortrait) {
		this.headPortrait = headPortrait;
	}
    public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
    public String getAcademic() {
		return academic;
	}

	public void setAcademic(String academic) {
		this.academic = academic;
	}
    public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
    public String getWechatNum() {
		return wechatNum;
	}

	public void setWechatNum(String wechatNum) {
		this.wechatNum = wechatNum;
	}
    public String getWechatQrCode() {
		return wechatQrCode;
	}

	public void setWechatQrCode(String wechatQrCode) {
		this.wechatQrCode = wechatQrCode;
	}
        
    	
}
