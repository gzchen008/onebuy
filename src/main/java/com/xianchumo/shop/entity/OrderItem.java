package com.xianchumo.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 选购商品类
 * @author yangtk
 *
 */
@Entity
@Table(name="order_item")
public class OrderItem{
	@Id @Column(name="gid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long gid;
	@ManyToOne(targetEntity=Order.class)
	@JoinColumn(name="order_id", referencedColumnName="oid",
			nullable=true)
	private Order order;
	private int amount;
	@ManyToOne(targetEntity=Good.class)
	@JoinColumn(name="good_id", referencedColumnName="gid",
			nullable=false)
	private Good good;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	@Override
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o != null && o.getClass().equals(OrderItem.class)){
			OrderItem target = (OrderItem)o;
			return target.getGid().equals(this.gid);
		}
		return false;
	}
	@Override
	public int hashCode(){
		int hash = 17;
		if(this.gid != null){
			hash = hash * 31 + this.gid.hashCode();
		}
		return hash;
	}
}
