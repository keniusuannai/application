package com.tage.bean;

import java.util.Date;

/**
 * 申请表bean
 * 
 * @author manggo
 * 
 */
public class Apply {
	private int applyid;
	private int userid;
	private int hostyear;
	private int hostmonth;
	private int hostday;
	private int hostapn;// 0上午，1下午，2晚上
	private String hostname;
	private Date addtime;
	private String place;
	private String eventype;
	private String eventname;
	private int number;
	private String describe;
	private int status;
	private String remark;
	
	public Apply() {
		super();
	}

	public Apply(int applyid, int userid, int hostyear, int hostmonth,
			int hostday, int hostapn, String hostname, Date addtime,
			String place, String eventype, String eventname, int number,
			String describe, int status, String remark) {
		super();
		this.applyid = applyid;
		this.userid = userid;
		this.hostyear = hostyear;
		this.hostmonth = hostmonth;
		this.hostday = hostday;
		this.hostapn = hostapn;
		this.hostname = hostname;
		this.addtime = addtime;
		this.place = place;
		this.eventype = eventype;
		this.eventname = eventname;
		this.number = number;
		this.describe = describe;
		this.status = status;
		this.remark = remark;
	}

	public int getApplyid() {
		return applyid;
	}

	public void setApplyid(int applyid) {
		this.applyid = applyid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getHostyear() {
		return hostyear;
	}

	public void setHostyear(int hostyear) {
		this.hostyear = hostyear;
	}

	public int getHostmonth() {
		return hostmonth;
	}

	public void setHostmonth(int hostmonth) {
		this.hostmonth = hostmonth;
	}

	public int getHostday() {
		return hostday;
	}

	public void setHostday(int hostday) {
		this.hostday = hostday;
	}

	public int getHostapn() {
		return hostapn;
	}

	public void setHostapn(int hostapn) {
		this.hostapn = hostapn;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getEventype() {
		return eventype;
	}

	public void setEventype(String eventype) {
		this.eventype = eventype;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Apply [applyid=" + applyid + ", userid=" + userid
				+ ", hostyear=" + hostyear + ", hostmonth=" + hostmonth
				+ ", hostday=" + hostday + ", hostapn=" + hostapn
				+ ", hostname=" + hostname + ", addtime=" + addtime
				+ ", place=" + place + ", eventype=" + eventype
				+ ", eventname=" + eventname + ", number=" + number
				+ ", describe=" + describe + ", status=" + status + ", remark="
				+ remark + "]";
	}
}
