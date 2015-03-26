package com.idyl.manager.data;

import com.idyl.manager.dao.Column;
import com.idyl.manager.dao.Table;

import java.sql.Timestamp;
import java.util.Date;

/**
 * UserGeneralInfo entity. @author MyEclipse Persistence Tools
 */
@Table(name = "user_general_info")
public class UserGeneralInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userType;
	private String userName;
	private String email;
	private String password;
	private String familyName;
	private String lastName;
	private String mobile;
	private String telephone;
	private Integer location;
	private Date birthday;
	private String headThumb;
	private Timestamp addTime;
	private Timestamp beginTime;

	// Constructors

	/** default constructor */
	public UserGeneralInfo() {
	}

	/** minimal constructor */
	public UserGeneralInfo(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	/** full constructor */
	public UserGeneralInfo(Integer userType, String userName, String email,
			String password, String familyName, String lastName, String mobile,
			String telephone, Integer location, Date birthday,
			String headThumb, Timestamp addTime, Timestamp beginTime) {
		this.userType = userType;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.familyName = familyName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.telephone = telephone;
		this.location = location;
		this.birthday = birthday;
		this.headThumb = headThumb;
		this.addTime = addTime;
		this.beginTime = beginTime;
	}

	// Property accessors
	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_type")
	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "family_name")
	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "location")
	public Integer getLocation() {
		return this.location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	@Column(name = "birthday")
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "head_thumb")
	public String getHeadThumb() {
		return this.headThumb;
	}

	public void setHeadThumb(String headThumb) {
		this.headThumb = headThumb;
	}

	@Column(name = "add_time")
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "begin_time")
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

}