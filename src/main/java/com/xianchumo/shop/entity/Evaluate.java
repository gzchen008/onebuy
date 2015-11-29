package com.xianchumo.shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 评价类
 * @author yangtk
 *
 */
@Entity
@Table(name="evaluate")
public class Evaluate implements Serializable{
	@Id @Column(name="eid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eid;
	@ManyToOne(targetEntity=Good.class)
	@JoinColumn(name="good_id", referencedColumnName="gid",
			nullable=false)
	private Good good;
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id",  referencedColumnName="uid",
			nullable=false)
	private User user;
	@ManyToOne(targetEntity=Merchant.class, fetch=FetchType.LAZY)
	@JoinColumn(name="merchant_id", referencedColumnName="mid", nullable=false)
	private Merchant merchant;
	private double fraction;//评分
	@Column(length=150)
	private String comment;//评语
	
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getFraction() {
		return fraction;
	}
	public void setFraction(double fraction) {
		this.fraction = fraction;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	
}
