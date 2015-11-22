package com.xianchumo.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
	@Id
	@Column(name = "oid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	@Column(length = 18)
	private String orderNumber;// 订单编号
	private double money;
	@ManyToOne(targetEntity = Address.class)
	@JoinColumn(name = "address_id", referencedColumnName = "aid", nullable = false)
	private Address address;
	@ManyToOne(targetEntity = Merchant.class)
	@JoinColumn(name = "merchant_id", referencedColumnName = "mid", nullable = false)
	private Merchant merchant;
	@OneToMany(targetEntity = OrderItem.class, mappedBy = "order",cascade=CascadeType.ALL)
	private Set<OrderItem> goods;
	/**
	 * 下单时间
	 */
	private Date orderTime;
	/**
	 * 所属用户
	 */
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id", referencedColumnName = "uid", nullable = false)
	private User user;

	private int orderState;// 订单状态

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Set<OrderItem> getGoods() {
		return goods;
	}

	public void setGoods(Set<OrderItem> goods) {
		this.goods = goods;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * 总价
	 */
	public double getTotal() {
		double sum = 0;
		for (OrderItem oi : goods) {
			sum += oi.getSubtotal();
		}
		return sum;
	}
	
	public int getAmount(){
		int sum =0;
		for(OrderItem oi : goods){
			sum+=oi.getAmount();
		}
		return sum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o != null && o.getClass().equals(Order.class)) {
			Order target = (Order) o;
			return target.getOid().equals(this.oid);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		if (this.oid != null) {
			hash = hash * 31 + this.oid.hashCode();
		}
		return hash;
	}
}
