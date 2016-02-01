package com.vanroid.onebuy.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	private long  id;
	private Stage stage;
	private Integer purchasedQuantity;
	private Date time;
	private ShowOrder showOrder;
	private UserDetail userDetail;
	private Set<Code> codes = new HashSet<Code>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne()
	@JoinColumn(name = "stage_id")
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	@Column
	public Integer getPurchasedQuantity() {
		return purchasedQuantity;
	}
	public void setPurchasedQuantity(Integer purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(nullable = false)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "order")
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
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "order")
	public Set<Code> getCodes() {
		return codes;
	}
	public void setCodes(Set<Code> codes) {
		this.codes = codes;
	}

	public Order() {
		super();
	}
}
