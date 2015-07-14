package com.tage.bean;
/**
 * 用户bean
 * @author manggo
 *
 */
public class User {
	private int userid;
	private String username;
	private String password;
	private int userNo;
	private String organize;
	private int phone;
	private String remark;
	private int right;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getOrganize() {
		return organize;
	}
	public void setOrganize(String organize) {
		this.organize = organize;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}

}
