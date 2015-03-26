package com.idyl.manager.data;

import com.idyl.manager.dao.Column;
import com.idyl.manager.dao.Table;

import java.sql.Timestamp;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
@Table(name = "admin")
public class Admin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String nickName;
	private String password;
	private Integer userStat;
	private String remark;
	private Timestamp beginDate;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Admin(Integer id, String userName, String nickName, String password,
			Integer userStat, String remark, Timestamp beginDate) {
		this.id = id;
		this.userName = userName;
		this.nickName = nickName;
		this.password = password;
		this.userStat = userStat;
		this.remark = remark;
		this.beginDate = beginDate;
	}

	// Property accessors

	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "nick_name")
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "user_stat")
	public Integer getUserStat() {
		return this.userStat;
	}

	public void setUserStat(Integer userStat) {
		this.userStat = userStat;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "begin_date")
	public Timestamp getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Timestamp beginDate) {
		this.beginDate = beginDate;
	}

}