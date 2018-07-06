package jp.co.example.VandR_Shop.Controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.VandR_Shop.Form.ShopLoginForm;
import jp.co.example.VandR_Shop.entity.ShopAdmin;
import jp.co.example.VandR_Shop.entity.ShopInfo;
import jp.co.example.VandR_Shop.entity.ShopSessionInfo;
import jp.co.example.VandR_Shop.service.impl.ShopAdminService;
import jp.co.example.VandR_Shop.service.impl.ShopInfoService;

@Controller
public class ShopAuthController {

	@Autowired
    MessageSource messageSource;

	@Autowired
	private ShopAdminService adminService;

	@Autowired
	private ShopInfoService shopService;

	@Autowired
	private ShopSessionInfo sessionInfo;

	@RequestMapping("/shopLogin")
	public String login(@ModelAttribute("shopLoginForm") ShopLoginForm form, Model model) {
		return "shopLogin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginShop(@Validated @ModelAttribute("shopLoginForm") ShopLoginForm form, BindingResult bindingResult,
			Model model) {

		String errorMsg = messageSource.getMessage("login.error", null, Locale.getDefault());

		if (bindingResult.hasErrors()) {
			model.addAttribute("errmsg", errorMsg);
			return "shopLogin";
		}

		String id = form.getShopId();

		try {
		int intId = Integer.parseInt(id);

		ShopAdmin sAdmin = adminService.authentication(intId, form.getPassword());

		if (sAdmin == null) {
			model.addAttribute("errmsg", errorMsg);
			return "shopLogin";
		} else {
			ShopInfo shop = shopService.locator(intId);
			sessionInfo.setLoginShop(sAdmin);
			sessionInfo.setPrevShopProfile(shop);
			String test ="店舗名テストです";
			model.addAttribute("shop",test);
			model.addAttribute("sAdmin", sessionInfo.getLoginShop());
			return "shopMenu";
		}

		}catch(NumberFormatException e){
			model.addAttribute("errmsg", errorMsg);
			return "shopLogin";
		}
	}

	@RequestMapping("/shopProfile")
	public String profile(Model model) {
		return "shopProfile";
	}

	@RequestMapping(value = "/shopLogout", method = RequestMethod.GET)
	public String logout(Model model) {
		sessionInfo.invalidate();
		return "shopLogout";
	}
}
