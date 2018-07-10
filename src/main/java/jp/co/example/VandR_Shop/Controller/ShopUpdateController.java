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

//	@RequestMapping("/shopSeatsUpdateInput")
//	public String seatsInput(Model model) {
//		//ショップ情報をセッションにいれておく
//		model.addAttribute("sAdmin",sessionInfo.getLoginShop());
//		return "shopSeatsUpdateInput";
//	}

	@RequestMapping("/shopProfileUpdateInput" )
	public String profileInput(Model model) {

//		Map<Integer,String> category = new HashMap<Integer, String>();
//		category.put(1, "和食");
//		category.put(2, "中華");
//		category.put(3, "イタリアン");
//		category.put(4, "フレンチ");
//
//		model.addAttribute("category",category);

//		Map<Integer,String> budget = new HashMap<Integer, String>();
//		budget.put(1,"～1000");
//		budget.put(2,"1000～1999");
//		budget.put(3,"2000～2999");
//		budget.put(4,"3000～4999");
//		budget.put(5,"5000～");


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
