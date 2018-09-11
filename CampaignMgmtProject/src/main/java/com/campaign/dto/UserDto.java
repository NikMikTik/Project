package com.campaign.dto;

import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserDto {

	private long userId;

	@NotBlank(message = "User Name cannot be Blank")
	private String userName;

	@NotBlank(message = "User Email cannot be Blank")
	@Email(message = "Enter Unique Email Id Ex: abc@xyz.pqr")
	private String userEmail;

	@NotBlank(message = "User Password cannot be Blank")
	@Pattern(regexp = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z]).*$")
	private String password;

	@NotBlank(message = "Merchant Confirm Password cannot be Blank")
	@Pattern(regexp = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z]).*$")
	@Transient
	private String confirmPassword;

	@NotBlank(message = "User Designation cannot be Blank")
	private String userDesignation;

	@NotBlank(message = "User Phone No. cannot be Blank")
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}")
	private String userPhoneNo;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

}
