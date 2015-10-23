package com.xianchumo.shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年10月21日 @author CGZ
 * @description 收货地址
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {
	@Id
	@Column(name = "aid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;
	/**
	 * 省
	 */
	@Column(length = 24)
	private String province = "广东省";
	/**
	 * 市
	 */
	@Column(length = 24)
	private String city = "广州市";
	/**
	 * 区
	 */
	@Column(length = 24)
	private String area;
	/**
	 * 社区
	 */
	@Column(name = "live_area", length = 24)
	/**
	 * 生活区
	 */
	private String liveArea;
	/**
	 * 柜子号
	 */
	@Column(length = 10)
	private String cabinet;

	/**
	 * 收货人名
	 */
	@Column(length = 20)
	private String userName;
	/**
	 * 电话号码
	 */
	@Column(length = 11)
	private String phoneNum;

	/**
	 * 所属用户
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "uid")
	private User user;

	public Address() {
	}

	public Address(String province, String city, String area, String liveArea, String cabinet) {
		super();
		this.province = province;
		this.city = city;
		this.area = area;
		this.liveArea = liveArea;
		this.cabinet = cabinet;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLiveArea() {
		return liveArea;
	}

	public void setLiveArea(String liveArea) {
		this.liveArea = liveArea;
	}

	public String getCabinet() {
		return cabinet;
	}

	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", province=" + province + ", city=" + city + ", area=" + area + ", liveArea="
				+ liveArea + ", cabinet=" + cabinet + ", userName=" + userName + ", phoneNum=" + phoneNum + "]";
	}

}
