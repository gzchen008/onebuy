package com.vanroid.onebuy.entity;

import java.util.HashSet;
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


/**
*@author kaiscript
*@date 2016年1月17日 下午2:31:28
*/
@Entity
@Table(name = "ob_user_detail")
public class UserDetail {
	
	private long id;
	private User user;
	private Set<Order> orders = new HashSet<Order>();
	private Set<Good> goods = new HashSet<Good>();
	private String[] address;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne(mappedBy = "userDetail")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userDetail")
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userDetail")
	@Column(nullable= true)
	public Set<Good> getGoods() {
		return goods;
	}
	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}
	
	@Column
	public String[] getAddress() {
		return address;
	}
	public void setAddress(String[] address) {
		this.address = address;
	}
	public UserDetail(long id, User user, Set<Order> orders, Set<Good> goods, String[] address) {
		super();
		this.id = id;
		this.user = user;
		this.orders = orders;
		this.goods = goods;
		this.address = address;
	}
	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
