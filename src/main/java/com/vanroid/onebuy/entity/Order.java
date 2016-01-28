package com.vanroid.onebuy.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*@author kaiscript
*@date 2016年1月17日 下午2:41:25
*/
@Entity
@Table(name = "ob_order")
public class Order {
	
	private Long  id;
	private Stage stage;
	private Date time;
	private ShowOrder showOrder;
	private UserDetail userDetail;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stage_id")
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(nullable = false)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@OneToOne(mappedBy = "order")
	public ShowOrder getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(ShowOrder showOrder) {
		this.showOrder = showOrder;
	}
	
	@ManyToOne()
	@JoinColumn(name = "userdetail_id",nullable = false)
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	
	public Order() {
		super();
	}
	
}
