package com.vanroid.onebuy.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*@author kaiscript
*@date 2016年1月17日 下午3:46:34
*/
@Entity
@Table(name = "ob_showorder")
public class ShowOrder {
	
	private Long id;
	private Order order;
	private Date time;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	public ShowOrder(Long id, Order order, Date time) {
		super();
		this.id = id;
		this.order = order;
		this.time = time;
	}
	
	
}
