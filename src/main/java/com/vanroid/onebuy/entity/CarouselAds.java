package com.vanroid.onebuy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*@author kaiscript
*@date 2016年1月17日 下午3:49:39
*/
@Entity
@Table(name = "ob_carousel_ads")
public class CarouselAds {
	
	private Integer id;
	private Stage stage;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne()
	@JoinColumn(name = "stage_id")
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public CarouselAds() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
