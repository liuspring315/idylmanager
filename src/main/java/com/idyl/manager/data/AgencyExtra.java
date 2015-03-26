package com.idyl.manager.data;

import com.idyl.manager.dao.Column;
import com.idyl.manager.dao.Table;

/**
 * AgencyExtra entity. @author MyEclipse Persistence Tools
 */
@Table(name="agency_extra")
public class AgencyExtra extends UserGeneralInfo  implements java.io.Serializable {

	// Fields

	private Integer userGeneralInfoId;
	private Integer authentication;
	private Integer certificateType;
	private String certificateNum;
	private String idcardFront;
	private String idcardBack;
	private String remark;
	private Double deposit;
	private String introduction;
	private String photographerDesc;
	private String stylistDesc;
	private String dressDesc;
	private String address;
	private Integer registerCheckState;

	// Constructors

	/** default constructor */
	public AgencyExtra() {
	}

	/** minimal constructor */
	public AgencyExtra(Integer userGeneralInfoId) {
		this.userGeneralInfoId = userGeneralInfoId;
	}

	/** full constructor */
	public AgencyExtra(Integer userGeneralInfoId, Integer authentication,
			Integer certificateType, String certificateNum, String idcardFront,
			String idcardBack, String remark, Double deposit,
			String introduction, String photographerDesc, String stylistDesc,
			String dressDesc, String address, Integer registerCheckState) {
		this.userGeneralInfoId = userGeneralInfoId;
		this.authentication = authentication;
		this.certificateType = certificateType;
		this.certificateNum = certificateNum;
		this.idcardFront = idcardFront;
		this.idcardBack = idcardBack;
		this.remark = remark;
		this.deposit = deposit;
		this.introduction = introduction;
		this.photographerDesc = photographerDesc;
		this.stylistDesc = stylistDesc;
		this.dressDesc = dressDesc;
		this.address = address;
		this.registerCheckState = registerCheckState;
	}

	// Property accessors
	@Column(name = "user_general_info_id")
	public Integer getUserGeneralInfoId() {
		return this.userGeneralInfoId;
	}

	public void setUserGeneralInfoId(Integer userGeneralInfoId) {
		this.userGeneralInfoId = userGeneralInfoId;
	}

	@Column(name = "authentication")
	public Integer getAuthentication() {
		return this.authentication;
	}

	public void setAuthentication(Integer authentication) {
		this.authentication = authentication;
	}

	@Column(name = "certificate_type")
	public Integer getCertificateType() {
		return this.certificateType;
	}

	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}

	@Column(name = "certificate_num")
	public String getCertificateNum() {
		return this.certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	@Column(name = "idcard_front")
	public String getIdcardFront() {
		return this.idcardFront;
	}

	public void setIdcardFront(String idcardFront) {
		this.idcardFront = idcardFront;
	}

	@Column(name = "idcard_back")
	public String getIdcardBack() {
		return this.idcardBack;
	}

	public void setIdcardBack(String idcardBack) {
		this.idcardBack = idcardBack;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "deposit")
	public Double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	@Column(name = "introduction")
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "photographer_desc")
	public String getPhotographerDesc() {
		return this.photographerDesc;
	}

	public void setPhotographerDesc(String photographerDesc) {
		this.photographerDesc = photographerDesc;
	}

	@Column(name = "stylist_desc")
	public String getStylistDesc() {
		return this.stylistDesc;
	}

	public void setStylistDesc(String stylistDesc) {
		this.stylistDesc = stylistDesc;
	}

	@Column(name = "dress_desc")
	public String getDressDesc() {
		return this.dressDesc;
	}

	public void setDressDesc(String dressDesc) {
		this.dressDesc = dressDesc;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "register_check_state")
	public Integer getRegisterCheckState() {
		return this.registerCheckState;
	}

	public void setRegisterCheckState(Integer registerCheckState) {
		this.registerCheckState = registerCheckState;
	}

}