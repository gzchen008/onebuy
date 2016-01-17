package com.vanroid.onebuy.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*@author kaiscript
*2016年1月17日 下午3:46:34
*/
@Entity
@Table(name = "ob_showorder")
public class ShowOrder {
	
	private Integer id;
	private Order order;
	private Date time;
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public ShowOrder(Integer id, Order order, Date time) {
		super();
		this.id = id;
		this.order = order;
		this.time = time;
	}
	
	
}
