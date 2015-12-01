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
 * 商品信息类
 * @author yangtk
 *
 */
@Entity
@Table(name="good_info")
public class GoodInfo implements Serializable{
	@Id @Column(name="iid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iid;
	@OneToOne(targetEntity=Good.class)
	@JoinColumn(name="good_id", referencedColumnName="gid",
			unique=true)
	private Good good;
	private String[] imgs;//图片url
	@Column(length=90)
	private String introduce;//介绍,现在30个汉字以内
	@Column(length=9)
	private String standard;//规格
	@Column(length=15)
	private String pack;//包装
	@Column(length=15)
	private String cook;//烹饪方法
	@Column(length=60)
	private String trait;//特点
	@Column(length=30)
	private String source;//产地
	
	public Long getIid() {
		return iid;
	}
	public void setIid(Long iid) {
		this.iid = iid;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public String[] getImgs() {
		return imgs;
	}
	public void setImgs(String[] imgs) {
		this.imgs = imgs;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getCook() {
		return cook;
	}
	public void setCook(String cook) {
		this.cook = cook;
	}
	public String getTrait() {
		return trait;
	}
	public void setTrait(String trait) {
		this.trait = trait;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
}
