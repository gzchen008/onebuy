package com.vanroid.weixin.pojo;
/**
 * ��ɫ��
 * @author CGZ
 *
 */
public class Role {
	private int id;		//��ɫid
	private String name;		//��ɫ���
	private String picPath;		//��ɫ·��
	public Role(int id, String name, String picPath) {
		this.id = id;
		this.name = name;
		this.picPath = picPath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
