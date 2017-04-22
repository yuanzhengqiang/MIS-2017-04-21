package com.framework.system.mis.entity;

import com.framework.system.db.dao.annotation.ColumnDescription;
import com.framework.system.db.dao.annotation.RelationlDescription;
import com.framework.system.db.dao.annotation.TableDescription;

/**
 * @Title: Entity
 * @Description: 支付信息表
 * @author feng.gu
 * @date 2017-04-21 17:17:50
 * @version V1.0
 * 
 */
@TableDescription(name = "s_pay_info")
public class PayInfoEntity implements java.io.Serializable {
	public final static String ID = "ID";
	public final static String ORDER_ID = "ORDER_ID";
	public final static String MONEY = "MONEY";
	public final static String TYPE = "TYPE";
	public final static String PAY_TIME = "PAY_TIME";
	public final static String PAY_NUM = "PAY_NUM";

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
	 * 金额
	 */
	@ColumnDescription(name = "MONEY")
	private Double money;
	/**
	 * 类型（押金/尾款）
	 */
	@ColumnDescription(name = "TYPE")
	private Object type;
	/**
	 * 支付时间
	 */
	@ColumnDescription(name = "PAY_TIME")
	private String payTime;
	/**
	 * 支付流水号
	 */
	@ColumnDescription(name = "PAY_NUM")
	private String payNum;

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

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Object getType() {
		return type;
	}

	public void setType(Object type) {
		this.type = type;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPayNum() {
		return payNum;
	}

	public void setPayNum(String payNum) {
		this.payNum = payNum;
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

}
