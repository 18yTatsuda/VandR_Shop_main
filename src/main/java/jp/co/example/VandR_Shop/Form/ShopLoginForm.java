package jp.co.example.VandR_Shop.Form;

import javax.validation.constraints.NotBlank;

/*
 * ログイン画面用フォーム
 */
public class ShopLoginForm {

	@NotBlank
	private String shopId;

	@NotBlank
	private String password;

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String _shopId) {
		this.shopId = _shopId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String _password) {
		this.password = _password;
	}
}
