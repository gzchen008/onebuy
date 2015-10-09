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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 购物车类
 * 
 * @author yangtk
 *
 */
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {
	@Id
	@Column(name = "sid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id", referencedColumnName = "uid", unique = true)
	private User user;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "shoppingCart")
	private Set<CartItem> cartItems;

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * 总价
	 */
	public double getTotal() {
		double sum = 0;
		for (CartItem ci : cartItems) {
			sum += ci.getSubtotal();
		}
		return sum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o != null && o.getClass().equals(Good.class)) {
			ShoppingCart target = (ShoppingCart) o;
			return target.getSid().equals(this.sid);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		if (this.sid != null) {
			hash = hash * 31 + this.sid.hashCode();
		}
		return hash;
	}

	/**
	 * 取得某商品的cartItem
	 * 
	 * @param gid
	 */
	public CartItem getCartItem(Long gid) {
		for (CartItem c : cartItems) {
			if (c.getGood().getGid() == gid) {
				return c;
			}
		}
		return null;

	}
}
