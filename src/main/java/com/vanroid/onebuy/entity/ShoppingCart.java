package com.vanroid.onebuy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*@author kaiscript
*2016年1月17日 下午3:53:09
*/

@Entity
@Table(name = "ob_shoppingcart")
public class ShoppingCart {
	
	private Integer id;
	private User ownedUser;
	private Good good;
	private Integer quality;
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	public User getOwnedUser() {
		return ownedUser;
	}
	public void setOwnedUser(User ownedUser) {
		this.ownedUser = ownedUser;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "good_id")
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	
	@Column
	public Integer getQuality() {
		return quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	
	public ShoppingCart(Integer id, User ownedUser, Good good, Integer quality) {
		super();
		this.id = id;
		this.ownedUser = ownedUser;
		this.good = good;
		this.quality = quality;
	}
	
	
}
