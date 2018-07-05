package jp.co.example.VandR_Shop.entity;

import java.io.Serializable;

public class ShopAdmin implements Serializable {

	private String shopAdminId;
	private String shopAdminName;
	private String shopPassword;

	public String getShopAdminId() {
		return shopAdminId;
	}

	public void setShopAdminId(String shopAdminId) {
		this.shopAdminId = shopAdminId;
	}

	public String getShopAdminName() {
		return shopAdminName;
	}

	public void setShopAdminName(String shopAdminName) {
		this.shopAdminName = shopAdminName;
	}

	public String getShopPassword() {
		return shopPassword;
	}

	public void setShopPassword(String shopPassword) {
		this.shopPassword = shopPassword;
	}
}