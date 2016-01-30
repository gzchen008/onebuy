package com.vanroid.onebuy.entity;

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

/**
 * @author kaiscript
 * @date 2016年1月17日 下午4:40:57
 */
@Entity
@Table(name = "ob_code")
public class Code {

	private Long id;
	private User ownedUser;
	private Stage stage;
	private Order order;
	/** 代码 */
	private String code;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne()
	@JoinColumn(name = "user_id",nullable=true)
	public User getOwnedUser() {
		return ownedUser;
	}
	public void setOwnedUser(User ownedUser) {
		this.ownedUser = ownedUser;
	}

	@ManyToOne()
	@JoinColumn(name = "stage_id", nullable = false)
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	@ManyToOne()
	@JoinColumn(name = "order_id",nullable = true)
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Column(length=10)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
