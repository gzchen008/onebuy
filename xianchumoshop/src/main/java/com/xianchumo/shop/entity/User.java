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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@Column(name = "uid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	@Column(length = 40)
	private String openid;
	@Column(length = 100)
	private String password;
	@Column(length = 12)
	private String name;
	@Column(length = 11, unique = true)
	private String phone;
	@ManyToOne(targetEntity = Address.class)
	//常用地址
	@JoinColumn(name = "address_id", referencedColumnName = "aid", nullable = true)
	private Address address;
	@OneToOne(targetEntity = Grade.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Grade grade;
	@OneToOne(targetEntity = Wallet.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Wallet wallet;
	@OneToOne(targetEntity = ShoppingCart.class, mappedBy = "user")
	private ShoppingCart shoppingCart;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o != null && o.getClass().equals(User.class)) {
			User target = (User) o;
			return target.getUid().equals(this.uid);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		if (this.uid != null) {
			hash = hash * 31 + this.uid.hashCode();
		}
		return hash;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", openid=" + openid + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", address=" + address + ", grade=" + grade + ", wallet=" + wallet + ", shoppingCart="
				+ shoppingCart + "]";
	}

}
