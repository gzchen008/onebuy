package com.xianchumo.shop.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@Column(name = "uid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	@Column(length = 40, unique = true)
	private String openid;
	@Column(length = 100)
	private String password;
	@Column(length = 70)
	private String name;
	@Column(length = 11, unique = true)
	private String phone;
	/**
	 * 用户地址列表
	 */
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Address> addresses;
	@OneToOne(targetEntity = Grade.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Grade grade;
	@OneToOne(targetEntity = Wallet.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Wallet wallet;
	@OneToOne(targetEntity = ShoppingCart.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
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
				+ phone + ", addresses=" + addresses + ", grade=" + grade + ", wallet=" + wallet + ", shoppingCart="
				+ shoppingCart + "]";
	}

}
