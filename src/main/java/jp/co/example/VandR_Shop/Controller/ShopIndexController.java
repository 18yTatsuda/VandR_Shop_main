package jp.co.example.VandR_Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.VandR_Shop.entity.ShopSessionInfo;

@Controller
public class ShopIndexController {

	@Autowired
	private ShopSessionInfo sessionInfo;

	@RequestMapping("/shopIndex")
	public String index(Model model) {
		return "shopIndex";
	}

	@RequestMapping("/shopMenu")
	public String menu(Model model) {
//		ShopAdmin sAdmin = sessionInfo.getLoginShop();
//		Integer loginShopId = sAdmin.getShopAdminId();
//		ShopInfo shopInfo = adminService.locator(loginShopId);

//		sessionInfo.setShopProfile(shopInfo);

//		model.addAttribute("shop",sessionInfo.getShopProfile());

		String test ="店舗名テストです";
		model.addAttribute("shop",test);
		return "shopMenu";
	}

}
