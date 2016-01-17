package com.vanroid.onebuy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*@author kaiscript
*@date 2016年1月17日 下午3:49:39
*/
@Entity
@Table(name = "ob_carousel_ads")
public class CarouselAds {
	
	private Integer id;
	private Order order;
	
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
	public CarouselAds(Integer id, Order order) {
		super();
		this.id = id;
		this.order = order;
	}
	
	
}
