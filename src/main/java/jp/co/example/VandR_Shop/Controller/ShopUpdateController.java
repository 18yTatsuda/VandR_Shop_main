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
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping("/shopProfileUpdateInput" )
	public String profileInput(Model model) {

		ShopAdmin admin = sessionInfo.getLoginShop();
		shopService.locator(admin.getShop_id());
		model.addAttribute("shop", sessionInfo.getPrevShopProfile());
		model.addAttribute("sAdmin",sessionInfo.getLoginShop());
		return "shopProfileUpdateInput";
	}

	@RequestMapping(value = "/shopUpdate", method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute("shopUpdateForm") ShopUpdateForm form,
			BindingResult bindingResult,HttpSession session,Model model) {

		String errorMsg = messageSource.getMessage("shopupdate.error", null, Locale.getDefault());

		ShopInfo beforeShop = (ShopInfo) session.getAttribute("loginShop");

		form.setShop_id(beforeShop.getShop_id());
		form.setShop_name(beforeShop.getShop_name());
		form.setTelephone(beforeShop.getTelephone());
		form.setRegion_id(beforeShop.getRegion_id());
		form.setCategory_id(beforeShop.getCategory_id());

		ShopInfo afterShop = new ShopInfo();
		afterShop.setShop_id(form.getShop_id());
		afterShop.setShop_name(form.getShop_name());
		afterShop.setTelephone(form.getTelephone());
		afterShop.setRegion_id(form.getRegion_id());
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

		if((afterShop.equals(beforeShop))&&(afterShop == beforeShop)) {
			String rErrorMsg = messageSource.getMessage("required.change", null, Locale.getDefault());
			model.addAttribute("shop", sessionInfo.getPrevShopProfile());
			model.addAttribute("sAdmin",sessionInfo.getLoginShop());
			model.addAttribute("errmsg", rErrorMsg);

			return "shopProfileUpdateInput";
		}

		if((afterShop.getCategory_id()==0)||(afterShop.getCategory_id().equals(null))) {
			model.addAttribute("shop", sessionInfo.getPrevShopProfile());
			model.addAttribute("sAdmin",sessionInfo.getLoginShop());
			model.addAttribute("errmsg", errorMsg);
			return "shopProfileUpdateInput";
		}

		shopService.update(afterShop);

		session.setAttribute("loginShop",afterShop);
		model.addAttribute("sAdmin",sessionInfo.getLoginShop());

		return "shopProfileUpdateResult";
	}
}
