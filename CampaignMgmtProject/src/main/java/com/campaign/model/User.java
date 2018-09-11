package com.campaign.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Cmp_User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@NotBlank(message="User Designation cannot be Blank")
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", userDesignation=" + userDesignation
				+ ", userPhoneNo=" + userPhoneNo + "]";
	}

	public User(long userId, @NotBlank(message = "User Name cannot be Blank") String userName,
			@NotBlank(message = "User Email cannot be Blank") @Email(message = "Enter Unique Email Id Ex: abc@xyz.pqr") String userEmail,
			@NotBlank(message = "User Password cannot be Blank") @Pattern(regexp = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z]).*$") String password,
			@NotBlank(message = "Merchant Confirm Password cannot be Blank") @Pattern(regexp = "^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z]).*$") String confirmPassword,
			@NotBlank(message = "User Designation cannot be Blank") String userDesignation,
			@NotBlank(message = "User Phone No. cannot be Blank") @Pattern(regexp = "(0/91)?[7-9][0-9]{9}") String userPhoneNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userDesignation = userDesignation;
		this.userPhoneNo = userPhoneNo;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
