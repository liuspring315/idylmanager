package com.idyl.manager.data;

import com.idyl.manager.dao.Column;
import com.idyl.manager.dao.Table;

import java.util.Arrays;

/**
 * CustomerExtra entity. @author MyEclipse Persistence Tools
 */
@Table(name = "customer_extra")
public class CustomerExtra extends UserGeneralInfo implements java.io.Serializable {

	// Fields

	private Integer userGeneralInfoId;
	private String signature;
	private String destination;
	private String remark;

	// Constructors

	/** default constructor */
	public CustomerExtra() {
	}

	/** minimal constructor */
	public CustomerExtra(Integer userGeneralInfoId) {
		this.userGeneralInfoId = userGeneralInfoId;
	}

	/** full constructor */
	public CustomerExtra(Integer userGeneralInfoId, String signature,
			String destination, String remark) {
		this.userGeneralInfoId = userGeneralInfoId;
		this.signature = signature;
		this.destination = destination;
		this.remark = remark;
	}

	// Property accessors
	@Column(name = "user_general_info_id")
	public Integer getUserGeneralInfoId() {
		return this.userGeneralInfoId;
	}

	public void setUserGeneralInfoId(Integer userGeneralInfoId) {
		this.userGeneralInfoId = userGeneralInfoId;
	}

	@Column(name = "signature")
	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Column(name = "destination")
	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public static void main(String[] args) {

		System.out.println(Arrays.toString(new CustomerExtra().getClass().getSuperclass().getDeclaredFields()));

	}
}