package com.xianchumo.shop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年10月21日 @author yangtk
 * @description 红包
 */
@Entity
@Table(name ="redpacket")
public class RedPacket implements Serializable{
	@Id
	@Column(name = "rpid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rpid;

	/**
	 * 金额
	 */
	private int money;
	/**
	 * 到期时间
	 */
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	/**
	 * 起步金额
	 */
	private int lowestMoney;
	/**
	 * 所属用户
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	public long getRpid() {
		return rpid;
	}
	public void setRpid(long rpid) {
		this.rpid = rpid;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public int getLowestMoney() {
		return lowestMoney;
	}
	public void setLowestMoney(int lowestMoney) {
		this.lowestMoney = lowestMoney;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
