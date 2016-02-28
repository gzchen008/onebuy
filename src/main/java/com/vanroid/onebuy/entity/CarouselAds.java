package com.vanroid.onebuy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author kaiscript
 * @date 2016年1月17日 下午3:49:39 首页轮播图片
 */
@Entity
@Table(name = "ob_carousel_ads")
public class CarouselAds {

	private Long id;

	/**
	 * 超链接
	 */
	private String link;

	/**
	 * 图片地址
	 */
	private String photo;

	/**
	 * 网站配置
	 */
	private GlobalConfig globalConfig;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@ManyToOne()
	@JoinColumn(name = "global_config_id")
	public GlobalConfig getGlobalConfig() {
		return globalConfig;
	}

	public void setGlobalConfig(GlobalConfig globalConfig) {
		this.globalConfig = globalConfig;
	}

	public CarouselAds() {
		super();
		// TODO Auto-generated constructor stub
	}

}
