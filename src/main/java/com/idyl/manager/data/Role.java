package com.idyl.manager.data;

import com.idyl.manager.dao.Column;
import com.idyl.manager.dao.Table;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

@Table(name = "role")
public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Role(Integer id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	// Property accessors
	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "role_name")
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}