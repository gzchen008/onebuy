package com.vanroid.onebuy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年3月5日
 * @version 1.0
 * @description 用户晒单表
 */
@Entity
@Table(name = "ob_luck_show")
public class LuckShow {

	private long id;
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 文本内容
	 */
	private String content;

	/**
	 * 获奖期
	 */
	private Stage stage;

	/**
	 * 晒单图片
	 */
	private String[] photos;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stage_id")
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public String[] getPhotos() {
		return photos;
	}

	public void setPhotos(String[] photos) {
		this.photos = photos;
	}

}
