package com.xianchumo.shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 种类
 * @author yangtk
 *
 */
@Entity
@Table(name="kind")
public class Kind implements Serializable{
	@Id @Column(name="kind_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long kid;
	
	public Long getKid() {
		return kid;
	}
	public void setKid(Long kid) {
		this.kid = kid;
	}
	@Column(length=15)
	private String kind;
	public String getKind(){
		return kind;
	}
	public void setKind(String kind){
		this.kind = kind;
	}
	public Kind() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kind(Long kid) {
		super();
		this.kid = kid;
	}
	
}

