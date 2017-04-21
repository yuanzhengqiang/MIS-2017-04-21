package sbtj.entity.softInfo;

import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**   
 * @Title: Entity
 * @Description: 软件版本管理
 * @author feng.gu
 * @date 2016-07-27 16:18:42
 * @version V1.0   
 *
 */
@TableDescription(name = "B_SOFT_INFO")
public class SoftInfoEntity implements java.io.Serializable {
    public final static String ID = "ID";
    public final static String SOFT_NAME = "SOFT_NAME";
    public final static String SOFT_VERSION = "SOFT_VERSION";
    public final static String SOFT_CODE = "SOFT_CODE";
    public final static String UPDATE_LOG = "UPDATE_LOG";
    public final static String MANDATORY_UPDATE = "MANDATORY_UPDATE";
    public final static String UPDATE_URL = "UPDATE_URL";
    public final static String LAST_VERSION = "LAST_VERSION";
    public final static String REDUNDANT_FIELD1 = "REDUNDANT_FIELD1";
    public final static String REDUNDANT_FIELD2 = "REDUNDANT_FIELD2";
    
    /**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
    /**
	 * 软件名称
	 */
	@ColumnDescription(name = "SOFT_NAME")
	private String softName;
    /**
	 * 版本名称
	 */
	@ColumnDescription(name = "SOFT_VERSION")
	private String softVersion;
    /**
	 * 版本代码
	 */
	@ColumnDescription(name = "SOFT_CODE")
	private String softCode;
    /**
	 * 更新日志
	 */
	@ColumnDescription(name = "UPDATE_LOG")
	private String updateLog;
    /**
	 * 强制更新(0-否 1-是)
	 */
	@ColumnDescription(name = "MANDATORY_UPDATE")
	private Integer mandatoryUpdate;
    /**
	 * 更新地址
	 */
	@ColumnDescription(name = "UPDATE_URL")
	private String updateUrl;
    /**
	 * 原版本
	 */
	@ColumnDescription(name = "LAST_VERSION")
	private String lastVersion;
    /**
	 * 冗余字段1
	 */
	@ColumnDescription(name = "REDUNDANT_FIELD1")
	private String redundantField1;
    /**
	 * 冗余字段2
	 */
	@ColumnDescription(name = "REDUNDANT_FIELD2")
	private String redundantField2;
        
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    public String getSoftName() {
		return softName;
	}

	public void setSoftName(String softName) {
		this.softName = softName;
	}
    public String getSoftVersion() {
		return softVersion;
	}

	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}
    public String getSoftCode() {
		return softCode;
	}

	public void setSoftCode(String softCode) {
		this.softCode = softCode;
	}
    public String getUpdateLog() {
		return updateLog;
	}

	public void setUpdateLog(String updateLog) {
		this.updateLog = updateLog;
	}
    public Integer getMandatoryUpdate() {
		return mandatoryUpdate;
	}

	public void setMandatoryUpdate(Integer mandatoryUpdate) {
		this.mandatoryUpdate = mandatoryUpdate;
	}
    public String getUpdateUrl() {
		return updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}
    public String getLastVersion() {
		return lastVersion;
	}

	public void setLastVersion(String lastVersion) {
		this.lastVersion = lastVersion;
	}
    public String getRedundantField1() {
		return redundantField1;
	}

	public void setRedundantField1(String redundantField1) {
		this.redundantField1 = redundantField1;
	}
    public String getRedundantField2() {
		return redundantField2;
	}

	public void setRedundantField2(String redundantField2) {
		this.redundantField2 = redundantField2;
	}
        
    	
}
