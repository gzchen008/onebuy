package com.xianchumo.shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 钱包类
 * @author yangtk
 *
 */
@Entity
@Table(name="wallet")
public class Wallet implements Serializable{
	@Id @Column(name="wid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long wid;
	@OneToOne(targetEntity=User.class)
	@JoinColumn(name="user_id", referencedColumnName="uid",
			unique=true)
	private User user;
	private double overage;//余额
	private double credits;//积分
	
	public Long getWid() {
		return wid;
	}
	public void setWid(Long wid) {
		this.wid = wid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getOverage() {
		return overage;
	}
	public void setOverage(double overage) {
		this.overage = overage;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	
}
