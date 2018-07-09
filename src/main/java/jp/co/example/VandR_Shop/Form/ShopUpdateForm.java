package jp.co.example.VandR_Shop.Form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ShopUpdateForm {

	@NotNull
	private Integer shop_id;

	@NotBlank
	private String shop_name;

	@NotBlank
	private String telephone;

	@NotNull
	private Integer category_id;

	@NotNull
	private Integer region_id;

	private String budget;
	private String numberofseats;
	private String comment;
	private String holiday;
	private String shopimage;
	private String foodimage;
	private String starttime;
	private String finishtime;


	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}

	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getNumberofseats() {
		return numberofseats;
	}
	public void setNumberofseats(String numberofseats) {
		this.numberofseats = numberofseats;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public String getShopimage() {
		return shopimage;
	}
	public void setShopimage(String shopimage) {
		this.shopimage = shopimage;
	}

	public String getFoodimage() {
		return foodimage;
	}
	public void setFoodimage(String foodimage) {
		this.foodimage = foodimage;
	}

	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}
}
