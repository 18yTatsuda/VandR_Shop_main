package jp.co.example.VandR_Shop.Form;

import javax.validation.constraints.NotBlank;

/*
 * ログイン画面用フォーム
 */
public class ShopLoginForm {

	@NotBlank
	private String loginId;

	@NotBlank
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String _loginId) {
		this.loginId = _loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String _password) {
		this.password = _password;
	}
}
