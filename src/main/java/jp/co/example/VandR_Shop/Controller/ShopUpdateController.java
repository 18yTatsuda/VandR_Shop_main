package jp.co.example.VandR_Shop.Controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.VandR_Shop.Form.ShopUpdateForm;
import jp.co.example.VandR_Shop.entity.ShopAdmin;
import jp.co.example.VandR_Shop.entity.ShopInfo;
import jp.co.example.VandR_Shop.entity.ShopSessionInfo;
import jp.co.example.VandR_Shop.service.impl.ShopInfoService;

@Controller
public class ShopUpdateController {
	@Autowired
	private ShopSessionInfo sessionInfo;

	@Autowired
    MessageSource messageSource;

	@Autowired
	private ShopInfoService shopService;

//	@RequestMapping("/shopSeatsUpdateInput")
//	public String seatsInput(Model model) {
//		//ショップ情報をセッションにいれておく
//		model.addAttribute("sAdmin",sessionInfo.getLoginShop());
//		return "shopSeatsUpdateInput";
//	}

	@RequestMapping("/shopProfileUpdateInput")
	public String profileInput(Model model) {
		ShopAdmin admin = sessionInfo.getLoginShop();
		shopService.locator(admin.getShop_id());
		model.addAttribute("shop", sessionInfo.getPrevShopProfile());
		model.addAttribute("sAdmin",sessionInfo.getLoginShop());
		return "shopProfileUpdateInput";
	}

	@RequestMapping("/shopUpdate")
	public String update(@Validated @ModelAttribute("shopUpdateForm") ShopUpdateForm form,BindingResult bindingResult,
			HttpSession session,Model model) {

		String errorMsg = messageSource.getMessage("shopupdate.error", null, Locale.getDefault());

		if (bindingResult.hasErrors()) {
			model.addAttribute("errmsg", errorMsg);
			return "shopProfileUpdateInput";
		}

		ShopInfo beforeShop = (ShopInfo) session.getAttribute("loginShop");

		ShopInfo afterShop = new ShopInfo();
		afterShop.setShop_id(beforeShop.getShop_id());
		afterShop.setShop_name(beforeShop.getShop_name());
		afterShop.setTelephone(beforeShop.getTelephone());
		afterShop.setCategory_id(form.getCategory_id());
		afterShop.setRegion_id(form.getRegion_id());
		afterShop.setBudget(form.getBudget());
		afterShop.setNumberofseats(form.getNumberofseats());
		afterShop.setComment(form.getComment());
		afterShop.setHoliday(form.getHoliday());
		afterShop.setShopimage(form.getShopimage());
		afterShop.setFoodimage(form.getFoodimage());
		afterShop.setStarttime(form.getStarttime());
		afterShop.setFinishtime(form.getFinishtime());

		shopService.update(afterShop);

		model.addAttribute("sAdmin",sessionInfo.getLoginShop());

		return "shopSeatsUpdateResult";
	}


//	@RequestMapping(value ="/shopSeatsUpdate" , method = RequestMethod.POST)
//	public String seatsUpdate(@Validated @ModelAttribute("seatUpdateForm") ShopUpdateForm form, BindingResult bindingResult,
//			Model model) {
//	return "shopSeatsUpdateResult";
//	}

//	@RequestMapping(value = "/updateInput", method = RequestMethod.POST)
//	public String updateInput(@Validated @ModelAttribute("seatUpdateForm") ShopUpdateForm form, BindingResult bindingResult,
//			Model model) {
//
//		if (bindingResult.hasFieldErrors("userId")) {
//			String errorMsg = messageSource.getMessage("required.error", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
//			return "update";
//		}
//
//		ShopAdmin sAdmin = shopAdminService.findById(form.getUserId());
//
//		if(user == null) {
//			String errorMsg = messageSource.getMessage("id.not.found.error", null, Locale.getDefault());
//			model.addAttribute("errmsg", errorMsg);
//			return "update";
//		}
//
//		sessionInfo.setPrevUser(user);
//
//		form.setNewName(user.getUserName());
//		form.setNewTel(user.getTelephone());
//		form.setNewPassword(user.getPassword());
//
//		return "updateInput";
//	}
}
