package com.idyl.manager.data;

import com.idyl.manager.dao.Column;
import com.idyl.manager.dao.Table;

/**
 * Access entity. @author MyEclipse Persistence Tools
 */
@Table(name = "access")
public class Access implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer orderId;
	private Integer isLeaf;
	private Integer pid;
	private String uri;
	private String remark;

	// Constructors

	/** default constructor */
	public Access() {
	}

	/** minimal constructor */
	public Access(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Access(Integer id, String name, Integer orderId, Integer isLeaf,
			Integer pid, String uri, String remark) {
		this.id = id;
		this.name = name;
		this.orderId = orderId;
		this.isLeaf = isLeaf;
		this.pid = pid;
		this.uri = uri;
		this.remark = remark;
	}

	// Property accessors
	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "order_id")
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "is_leaf")
	public Integer getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	@Column(name = "pid")
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "uri")
	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}