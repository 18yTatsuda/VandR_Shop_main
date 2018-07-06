package jp.co.example.VandR_Shop.entity;

import java.io.Serializable;

public class ShopAdmin implements Serializable {

	private Integer shop_id;
	private String shopadmin_name;
	private String password;

	public Integer getShopAdminId() {
		return shop_id;
	}

	public void setShopAdminId(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public String getShopAdminName() {
		return shopadmin_name;
	}

	public void setShopAdminName(String shopadmin_name) {
		this.shopadmin_name = shopadmin_name;
	}

	public String getShopPassword() {
		return password;
	}

	public void setShopPassword(String password) {
		this.password = password;
	}
}