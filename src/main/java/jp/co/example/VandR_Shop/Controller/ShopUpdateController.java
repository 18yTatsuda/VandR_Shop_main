package jp.co.example.VandR_Shop.Controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String profileInput(@ModelAttribute("shopUpdateForm")ShopUpdateForm form,Model model) {

		ShopAdmin admin = sessionInfo.getLoginShop();
		shopService.locator(admin.getShop_id());
		model.addAttribute("shop", sessionInfo.getPrevShopProfile());
		model.addAttribute("sAdmin",sessionInfo.getLoginShop());
		return "shopProfileUpdateInput";
	}

	@RequestMapping(value = "/shopUpdate", method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute("shopUpdateForm") ShopUpdateForm form,
			BindingResult bindingResult,@RequestParam("shopimage") MultipartFile shopImage,
			@RequestParam("foodimage") MultipartFile foodImage,HttpSession session,Model model) throws IOException {

		String errorMsg = messageSource.getMessage("shopupdate.error", null, Locale.getDefault());

		if (form.hasRequiredError()) {
			model.addAttribute("shop", sessionInfo.getPrevShopProfile());
			model.addAttribute("sAdmin",sessionInfo.getLoginShop());
			model.addAttribute("errmsg", errorMsg);
			return "shopProfileUpdateInput";
		}

		ShopInfo beforeShop = (ShopInfo) session.getAttribute("loginShop");

		form.setShop_id(beforeShop.getShop_id());
		form.setShop_name(beforeShop.getShop_name());
		form.setTelephone(beforeShop.getTelephone());
		form.setRegion_id(beforeShop.getRegion_id());
		//form.setCategory_id(beforeShop.getCategory_id());

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
		afterShop.setStarttime(form.getStarttime());
		afterShop.setFinishtime(form.getFinishtime());

		Path siPath = Paths.get(System.getProperty("java.io.tmpdir"),shopImage.getOriginalFilename());
		shopImage.transferTo(siPath.toFile());
		model.addAttribute("shopImage", siPath);

		Path fiPath = Paths.get(System.getProperty("java.io.tmpdir"),foodImage.getOriginalFilename());
		foodImage.transferTo(fiPath.toFile());
		model.addAttribute("shopImage", fiPath);

		System.out.println(siPath);

		afterShop.setShopimage(siPath.toString());
		afterShop.setFoodimage(fiPath.toString());


		//一つも変更がないと更新できない
		if(afterShop.equals(beforeShop)) {
			String rErrorMsg = messageSource.getMessage("required.change", null, Locale.getDefault());
			model.addAttribute("shop", sessionInfo.getPrevShopProfile());
			model.addAttribute("sAdmin",sessionInfo.getLoginShop());
			model.addAttribute("errmsg", rErrorMsg);
			return "shopProfileUpdateInput";
		}

		shopService.update(afterShop);

		session.setAttribute("loginShop",afterShop);
		model.addAttribute("sAdmin",sessionInfo.getLoginShop());

		return "shopProfileUpdateResult";
	}
}
