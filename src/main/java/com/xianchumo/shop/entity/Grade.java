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
 * 等级类
 * @author yangtk
 *
 */
@Entity
@Table(name="grade")
public class Grade implements Serializable{
	@Id @Column(name="gid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long gid;
	@OneToOne(targetEntity=User.class)
	@JoinColumn(name="user_id", referencedColumnName="uid",
			unique=true)
	private User user;
	private int exp;//经验
	private int grade;//等级
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {	
		this.gid = gid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
