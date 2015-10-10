package com.xianchumo.shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 地址类
 * @author yangtk
 *
 */
@Entity
@Table(name="address")
public class Address implements Serializable{
	@Id @Column(name="aid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long aid;
	@Column(length=24)
	private String province;
	@Column(length=24)
	private String city;
	@Column(length=24)
	private String area;
	@Column(name="live_area", length=24)
	private String liveArea;//生活区
	public Address(){}
	public Address(String province, String city, String area){
		this.province = province;
		this.city = city;
		this.area = area;
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
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", province=" + province + ", city=" + city + ", area=" + area + ", liveArea="
				+ liveArea + "]";
	}
	
}
