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
		model.addAttribute("shop", sessionInfo.getLoginShop());
		return "shopMenu";
	}

}
