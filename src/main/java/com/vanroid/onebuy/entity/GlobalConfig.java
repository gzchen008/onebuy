package com.vanroid.onebuy.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年2月10日
 * @version 1.0
 * @description 全局參數
 */
@Entity
@Table(name = "ob_global_config")
public class GlobalConfig {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 首页轮播图片
	 */
	private List<CarouselAds> carouselAds;

	/**
	 * 网站名称
	 */
	private String siteName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CarouselAds> getCarouselAds() {
		return carouselAds;
	}

	public void setCarouselAds(List<CarouselAds> carouselAds) {
		this.carouselAds = carouselAds;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

}
