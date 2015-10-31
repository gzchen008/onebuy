package com.xianchumo.shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author yangtk
 *
 */
@Entity
@Table(name = "merchant")
public class Merchant implements Serializable {
	@Id
	@Column(name = "mid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mid;
	/**
	 * 帐号
	 */
	@Column(length = 18)
	private String account;
	@Column(length = 50)
	private String password;
	@Column(length = 11)
	private String telephone;// 座机
	@Column(length = 11)
	private String phone;// 手机
	@ManyToOne(targetEntity = AddressBase.class)
	@JoinColumn(name="address_id", referencedColumnName = "abid", nullable = true)
	private AddressBase addressBase;
	/**
	 * 余额
	 */
	private double overage;

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AddressBase getAddressBase() {
		return addressBase;
	}

	public void setAddressBase(AddressBase addressBase) {
		this.addressBase = addressBase;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public double getOverage() {
		return overage;
	}

	public void setOverage(double overage) {
		this.overage = overage;
	}
	public void subMoney(double money){
		this.overage -= money;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o != null && o.getClass().equals(Order.class)) {
			Merchant target = (Merchant) o;
			return target.getMid().equals(this.mid);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		if (this.mid != null) {
			hash = hash * 31 + this.mid.hashCode();
		}
		return hash;
	}
}
