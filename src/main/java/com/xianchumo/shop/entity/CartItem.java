package com.xianchumo.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月23日 @author CGZ
 * @description 购物车项目
 */
@Entity
@Table(name = "cartItem")
public class CartItem implements Serializable{
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartItemId;
	/**
	 * 数量
	 */
	@Column
	private int quantity;
	/**
	 * 商品
	 */
	@OneToOne(targetEntity = Good.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "good_id")
	private Good good;
	/**
	 * 所属购物车
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE},targetEntity=ShoppingCart.class)
	@JoinColumn(name = "shoppingCart_id")
	private ShoppingCart shoppingCart;

	/**
	 * 小计
	 * 
	 * @return
	 */
	public double getSubtotal() {
		BigDecimal b1 = new BigDecimal(good.getNowPrice() + "");
		BigDecimal b2 = new BigDecimal(quantity + "");
		BigDecimal b3 = b1.multiply(b2);
		return b3.doubleValue();
	}

	public Long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	/**
	 * 商品号相等即相当
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj != null && obj.getClass().equals(CartItem.class)) {
			CartItem obj2 = (CartItem) obj;
			if (obj2.getGood().getGid().equals(this.getGood().getGid())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		Long hash = 17l;
		if (this.getGood().getGid() != null) {
			hash = hash * 31 + this.getGood().getGid();
		}
		return hash.intValue();
	}

}
