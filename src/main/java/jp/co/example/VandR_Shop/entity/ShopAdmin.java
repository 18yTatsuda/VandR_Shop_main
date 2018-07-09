package jp.co.example.VandR_Shop.entity;

import java.io.Serializable;

public class ShopAdmin implements Serializable {

	private Integer shop_id;
	private String shopadmin_name;
	private String password;

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public String getShopadmin_name() {
		return shopadmin_name;
	}

	public void setShopadmin_name(String shopadmin_name) {
		this.shopadmin_name = shopadmin_name;
	}

	public String getShopPassword() {
		return password;
	}

	public void setShopPassword(String password) {
		this.password = password;
	}
}