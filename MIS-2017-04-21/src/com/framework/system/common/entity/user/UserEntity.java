package com.framework.system.common.entity.user;

import java.util.List;

import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**   
 * @Title: Entity
 * @Description: 系统账号
 * @author feng.gu
 * @date 2016-04-21 11:15:43
 * @version V1.0   
 *
 */
@TableDescription(name = "s_user")
public class UserEntity implements java.io.Serializable {
    public final static String ID = "ID";
    public final static String LOGINNAME = "LOGINNAME";
    public final static String PASSWORD = "PASSWORD";
    public final static String NICKNAME = "NICKNAME";
    public final static String STATUS = "STATUS";
    public final static String LOGIN_NUM = "LOGIN_NUM";
    public final static String LOGIN_TIME = "LOGIN_TIME";
    public final static String LOGIN_IP = "LOGIN_IP";
    public final static String LAST_LOGIN_TIME = "LAST_LOGIN_TIME";
    public final static String LAST_LOGIN_IP = "LAST_LOGIN_IP";
    public final static String DEPARTMENT_ID = "DEPARTMENT_ID";
    public final static String PERSONINFO_ID = "PERSONINFO_ID";
    public final static String CREATE_USER_ID = "CREATE_USER_ID";
    public final static String CREATE_TIME = "CREATE_TIME";
    public final static String UPDATE_USER_ID = "UPDATE_USER_ID";
    public final static String UPDATE_TIME = "UPDATE_TIME";
    public final static String TYPE = "TYPE";
    
    /**
	 * 主键
	 */
	@ColumnDescription(name = "ID", isPrimaryKey = true, isAutoIncrement = true)
	private Integer id;
    /**
	 * 账号账号
	 */
	@ColumnDescription(name = "LOGINNAME")
	private String loginname;
    /**
	 * 账号密码
	 */
	@ColumnDescription(name = "PASSWORD")
	private String password;
    /**
	 * 账户昵称
	 */
	@ColumnDescription(name = "NICKNAME")
	private String nickname;
    /**
	 * 账号状态
	 */
	@ColumnDescription(name = "STATUS")
	private Integer status;
    /**
	 * 本月登录次数
	 */
	@ColumnDescription(name = "LOGIN_NUM")
	private Integer loginNum;
    /**
	 * 本次登录时间
	 */
	@ColumnDescription(name = "LOGIN_TIME")
	private String loginTime;
    /**
	 * 本次登录IP
	 */
	@ColumnDescription(name = "LOGIN_IP")
	private String loginIp;
    /**
	 * 上次登录时间
	 */
	@ColumnDescription(name = "LAST_LOGIN_TIME")
	private String lastLoginTime;
    /**
	 * 上次登录IP
	 */
	@ColumnDescription(name = "LAST_LOGIN_IP")
	private String lastLoginIp;
    /**
	 * 部门ID
	 */
	@ColumnDescription(name = "DEPARTMENT_ID")
	private Integer departmentId;
    /**
	 * 个人信息ID
	 */
	@ColumnDescription(name = "PERSONINFO_ID")
	private Integer personinfoId;
    /**
	 * 创建用户ID
	 */
	@ColumnDescription(name = "CREATE_USER_ID")
	private Integer createUserId;
    /**
	 * 创建时间
	 */
	@ColumnDescription(name = "CREATE_TIME")
	private String createTime;
    /**
	 * 更新用户ID
	 */
	@ColumnDescription(name = "UPDATE_USER_ID")
	private Integer updateUserId;
    /**
	 * 更新时间
	 */
	@ColumnDescription(name = "UPDATE_TIME")
	private String updateTime;
    /**
	 * 类型
	 */
	@ColumnDescription(name = "TYPE")
	private String type;
        
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    public Integer getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}
    public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
    public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
    public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
    public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
    public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
    public Integer getPersoninfoId() {
		return personinfoId;
	}

	public void setPersoninfoId(Integer personinfoId) {
		this.personinfoId = personinfoId;
	}
    public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
    public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
    public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
    public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
        
	/**
     * 关系描述
	 */
    @RelationlDescription(relation = "ManyToOne",
	joinEntity="UserEntity"	,joinColumn="ID"	)
		
		
	private UserEntity createUser;
	        
	public UserEntity getCreateUser() {
		return createUser;
    }
	
	public void setCreateUser(UserEntity createUser) {
		this.createUser = createUser;
	}
	
	/**
	 * 关系描述
	 */
	@RelationlDescription(relation = "ManyToOne",
	joinEntity="UserEntity"	,joinColumn="ID"	)
	
	private UserEntity updateUser;
	        
	public UserEntity getUpdateUser() {
		return updateUser;
    }
	
	public void setUpdateUser(UserEntity updateUser) {
		this.updateUser = updateUser;
	}
}
