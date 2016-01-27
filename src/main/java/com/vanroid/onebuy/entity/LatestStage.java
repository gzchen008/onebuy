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
*@date 2016年1月22日 下午9:01:36
*/
@Entity
@Table(name = "ob_latest_stage")
public class LatestStage {
	
	private Long id;
	private Good good;
	private Integer num;
	private Integer totalPrice;
	private Integer quantity;
	private Integer purchasedQuantity;
	private Integer price;
	private Date endTime;
	private Date createTime;
	private Order order;
	
	private Integer status;
	private Date announceTime;
	private String luckyCode;
	private User luckyUser;
	private Integer ifDelivery;
	private Set<Code> codes = new HashSet<Code>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "good_id",nullable=false)
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	
	@Column
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	@Column
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Column
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Column(columnDefinition = "Integer default 0")
	public Integer getPurchasedQuantity() {
		return purchasedQuantity;
	}
	public void setPurchasedQuantity(Integer purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}
	
	@Column
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = true)
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@OneToOne(mappedBy = "stage")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Column
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Temporal(value= TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = true)
	public Date getAnnounceTime() {
		return announceTime;
	}
	public void setAnnounceTime(Date announceTime) {
		this.announceTime = announceTime;
	}
	
	@Column(nullable = true)
	public String getLuckyCode() {
		return luckyCode;
	}
	public void setLuckyCode(String luckyCode) {
		this.luckyCode = luckyCode;
	}
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getLuckyUser() {
		return luckyUser;
	}
	public void setLuckyUser(User luckyUser) {
		this.luckyUser = luckyUser;
	}
	
	@Column(columnDefinition = "Integer default 0")
	public Integer getIfDelivery() {
		return ifDelivery;
	}
	public void setIfDelivery(Integer ifDelivery) {
		this.ifDelivery = ifDelivery;
	}
	
	@OneToMany(cascade= CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="latestStage")
	public Set<Code> getCodes() {
		return codes;
	}
	public void setCodes(Set<Code> codes) {
		this.codes = codes;
	}
	public LatestStage() {
		super();
	}
	
}
