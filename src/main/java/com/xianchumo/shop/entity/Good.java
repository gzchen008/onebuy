package com.xianchumo.shop.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
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

/**
 * 商品类
 * 
 * @author yangtk
 *
 */
@Entity
@Table(name = "good")
public class Good implements Serializable {
	@Id
	@Column(name = "gid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long gid;
	@Column(length = 24)
	protected String name;
	@Column(length = 18)
	protected String unit;// 单位,打包方式，如包，盒
	protected double nowPrice;// 单价，现价
	protected double freePrice;// 特价
	protected int allowance;// 余量
	protected String photoUrl;// 商品图片
	@Column(length = 25, nullable = false)
	private String quantity; // 每单位净含量，如0.5kg 200g
	@ManyToOne(targetEntity = Kind.class)
	@JoinColumn(name = "kind_id", referencedColumnName = "kind_id", nullable = false)
	protected Kind kind;
	@OneToOne(targetEntity = GoodInfo.class, cascade = CascadeType.ALL, mappedBy = "good", fetch = FetchType.LAZY)
	protected GoodInfo info;// 商品信息
	@OneToMany(targetEntity = Evaluate.class, mappedBy = "good", fetch = FetchType.LAZY)
	private Set<Evaluate> evaluates;
	/**
	 * 商品备注 
	 * recommend 为推荐商品
	 * timelimit 限时抢购
	 */
	@Column(length = 50, nullable = true)
	private String remark;

	
	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public double getFreePrice() {
		return freePrice;
	}

	public void setFreePrice(double freePrice) {
		this.freePrice = freePrice;
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public GoodInfo getInfo() {
		return info;
	}

	public void setInfo(GoodInfo info) {
		this.info = info;
	}

	public Set<Evaluate> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(Set<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public double getScore() {
		if (evaluates == null || evaluates.size() == 0) {
			return 0;
		}
		double score = 0;
		DecimalFormat df = new DecimalFormat("0.0");
		for (Evaluate e : evaluates) {
			score += e.getFraction();
		}
		score = Double.parseDouble(df.format(score / evaluates.size()));
		return score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o != null && o.getClass().equals(Good.class)) {
			Good target = (Good) o;
			return target.getGid().equals(this.gid);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		if (this.gid != null) {
			hash = hash * 31 + this.gid.hashCode();
		}
		return hash;
	}

	public Good() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Good(Long gid) {
		super();
		this.gid = gid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
