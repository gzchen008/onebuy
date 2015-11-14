package com.xianchumo.shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年10月21日 @author yangtk
 * @description 基础地址类，存后台录入的地址
 */
@Entity
@Table(name = "address_base")
public class AddressBase implements Serializable{
	@Id
	@Column(name = "abid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long abid;
	/**
	 * 地址名
	 */
	private String name;
	/**
	 * 上一层名字
	 */
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "pid", referencedColumnName = "abid", nullable = true)
	private AddressBase parent;

	/**
	 * 类型:province city area等
	 */
	private String type;

	public long getAbid() {
		return abid;
	}

	public void setAbid(long abid) {
		this.abid = abid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressBase getParent() {
		return parent;
	}

	public void setParent(AddressBase parent) {
		this.parent = parent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AddressBase [abid=" + abid + ", name=" + name + ", type=" + type + "]";
	}

}
