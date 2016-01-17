package com.vanroid.onebuy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*@author kaiscript
*@date 2016年1月17日 下午4:40:57
*/
@Entity
@Table(name = "ob_code")
public class Code {
	
	private Integer id;
	private User ownedUser;
	private Stage stage;
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	public User getOwnedUser() {
		return ownedUser;
	}
	public void setOwnedUser(User ownedUser) {
		this.ownedUser = ownedUser;
	}
	
	@ManyToOne()
	@JoinColumn(name = "stage_id",nullable = false)
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}
