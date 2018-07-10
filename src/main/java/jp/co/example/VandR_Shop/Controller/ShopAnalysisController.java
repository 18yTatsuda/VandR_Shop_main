package jp.co.example.VandR_Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.VandR_Shop.entity.ShopSessionInfo;

@Controller
public class ShopAnalysisController {


	@Autowired
	ShopSessionInfo sessioninfo;

    @RequestMapping(value = "/shopAnalysisCheckMonth", method = RequestMethod.GET)
    public String analysisMonth(Model model) {
    	return "shopAnalysisCheckMonth";
    }

    @RequestMapping(value = "/shopAnalysisCheckDate", method = RequestMethod.GET)
    public String analysisDate(Model model) {
    	return "shopAnalysisCheckDate";
    }

    @RequestMapping(value = "/shopAnalysisCheckTime", method = RequestMethod.GET)
    public String analysisTime(Model model) {
    	return "shopAnalysisCheckTime";
    }

    @RequestMapping(value = "/shopAnalysisCheckYear", method = RequestMethod.GET)
    public String analysisYear(Model model) {
    	return "shopAnalysisCheckYear";
    }

}
