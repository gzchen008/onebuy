package com.vanroid.onebuy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*@author kaiscript
*@date 2016年1月17日 下午3:53:09
*/

@Entity
@Table(name = "ob_shoppingcart")
public class ShoppingCart {
	
	private Long id;
	private User ownedUser;
	private Stage stage;
	private Integer quality;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getOwnedUser() {
		return ownedUser;
	}
	public void setOwnedUser(User ownedUser) {
		this.ownedUser = ownedUser;
	}
	
	
	@Column
	public Integer getQuality() {
		return quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "stage_id")
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
}
