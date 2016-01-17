package com.vanroid.onebuy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
*@author kaiscript
*2016年1月17日 下午2:42:44
*/
@Entity
@Table(name = "ob_good")
public class Good {
	
	private long id;
	private String name;
	private String mainPhoto;
	private String[] detailPhotos;
	private Stage stage;
	private ShoppingCart shoppingCart;
	private UserDetail userDetail;
	
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(length = 255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 65535)
	public String getMainPhoto() {
		return mainPhoto;
	}
	public void setMainPhoto(String mainPhoto) {
		this.mainPhoto = mainPhoto;
	}
	
	@Column
	public String[] getDetailPhotos() {
		return detailPhotos;
	}
	public void setDetailPhotos(String[] detailPhotos) {
		this.detailPhotos = detailPhotos;
	}
	
	@OneToOne(mappedBy = "good")
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	@OneToOne(mappedBy = "good")
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	@ManyToOne()
	@JoinColumn(name = "userdetail_id")
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	public Good(long id, String name, String mainPhoto, String[] detailPhotos, Stage stage, ShoppingCart shoppingCart,
			UserDetail userDetail) {
		super();
		this.id = id;
		this.name = name;
		this.mainPhoto = mainPhoto;
		this.detailPhotos = detailPhotos;
		this.stage = stage;
		this.shoppingCart = shoppingCart;
		this.userDetail = userDetail;
	}
	
	
}
