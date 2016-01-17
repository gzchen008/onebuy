package com.vanroid.onebuy.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	private Integer id;
	private Stage stage;
	private User user;
	private Date time;
	private ShowOrder showOrder;
	private CarouselAds carouselAds;
	private UserDetail userDetail;
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	
	@OneToOne(mappedBy = "order")
	public CarouselAds getCarouselAds() {
		return carouselAds;
	}
	public void setCarouselAds(CarouselAds carouselAds) {
		this.carouselAds = carouselAds;
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
	public Order(Integer id, Stage stage, User user, Date time, ShowOrder showOrder, CarouselAds carouselAds,
			UserDetail userDetail) {
		super();
		this.id = id;
		this.stage = stage;
		this.user = user;
		this.time = time;
		this.showOrder = showOrder;
		this.carouselAds = carouselAds;
		this.userDetail = userDetail;
	}
	
	
}
