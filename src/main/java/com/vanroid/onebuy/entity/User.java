package com.vanroid.onebuy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author kaiscript
 * @date 2016年1月17日 下午2:35:00 
 */
@Entity
@Table(name = "ob_user")
public class User {
	
	private long id;
	private String username;
	private String password;
	private String phone;
	private String wxOpenid;
	private UserDetail userDetail;
	private Order order;
	private Stage stage;
	private ShoppingCart shoppingCart;
	private Code code;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(length=255)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(length=64)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=18)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(length=64)
	public String getWxOpenid() {
		return wxOpenid;
	}
	public void setWxOpenid(String wxOpenid) {
		this.wxOpenid = wxOpenid;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userdetail_id")
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	@OneToOne(mappedBy = "user")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@OneToOne(mappedBy = "luckyUser")
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	@OneToOne(mappedBy = "ownedUser")
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	@OneToOne(mappedBy = "ownedUser")
	public Code getCode() {
		return code;
	}
	public void setCode(Code code) {
		this.code = code;
	}
	
	
}
