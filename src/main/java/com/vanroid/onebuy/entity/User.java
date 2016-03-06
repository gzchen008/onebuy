package com.vanroid.onebuy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author kaiscript
 * @date 2016年1月17日 下午2:35:00
 */
@Entity
@Table(name = "ob_user")
public class User {

	private long id;
	private String username;
	private String password;
	private String phone;
	private String wxOpenid;
	/**
	 * 性别 女1 男2 保密 -1
	 */
	private Integer sex;
	/**
	 * 生日： YYYY-MM-DD
	 */
	private String birthday;
	/**
	 * 居信地
	 */
	private String residence;
	private UserDetail userDetail;
	private Stage stage;
	private ShoppingCart shoppingCart;
	/**
	 * 经验值
	 */
	private Integer exp;
	/**
	 * 福份值
	 */
	private Integer luckPoint;
	/**
	 * 帐户余额
	 */
	private Integer balance;
	private Set<Code> codes = new HashSet<Code>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(length = 255)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length = 64)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 18)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 64)
	public String getWxOpenid() {
		return wxOpenid;
	}

	public void setWxOpenid(String wxOpenid) {
		this.wxOpenid = wxOpenid;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userdetail_id")
	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	@OneToOne(mappedBy = "luckyUser")
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@Column(name = "exp", nullable = false, columnDefinition = "int default 100")
	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	@OneToOne(mappedBy = "ownedUser")
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ownedUser")
	public Set<Code> getCodes() {
		return codes;
	}

	public void setCodes(Set<Code> codes) {
		this.codes = codes;
	}

	@Column(name = "luck_point", nullable = false, columnDefinition = "int default 0")
	public Integer getLuckPoint() {
		return luckPoint;
	}

	public void setLuckPoint(Integer luckPoint) {
		this.luckPoint = luckPoint;
	}

	@Column(name = "residence", length = 50)
	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	@Column(name = "balance", nullable = false, columnDefinition = "int default 0")
	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Column(name = "sex", nullable = false, columnDefinition = "int default -1", length = 3)
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
