package com.itwzhangzx.boot.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private String userCode;
	private String userName;
	private Date createTime;
	private String userType;
	private  String mobile;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User{" +
				"userCode='" + userCode + '\'' +
				", userName='" + userName + '\'' +
				", createTime=" + createTime +
				", userType='" + userType + '\'' +
				", mobile='" + mobile + '\'' +
				'}';
	}
}
