package jp.co.example.VandR_Shop.Form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ShopUpdateForm {

	//private MultipartFile multipartFile;

	@NotNull
	private Integer shop_id;

	@NotBlank
	private String shop_name;

	@NotBlank
	private String telephone;

	@NotNull
	private Integer category_id;

	private Integer newCategory_id;

	@NotNull
	private Integer region_id;

	private Integer newRegion_id;

	private String budget;
	private String numberofseats;
	private String comment;
	private String holiday;
	private String shopimage;
	private String foodimage;
	private String starttime;
	private String finishtime;

	private String newBudget;
	private String newNumberofseats;
	private String newComment;
	private String newHoliday;
	private String newShopimage;
	private String newFoodimage;
	private String newStarttime;
	private String newFinishtime;


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



	public Integer getNewCategory_id() {
		return newCategory_id;
	}
	public void setNewCategory_id(Integer newCategory_id) {
		this.newCategory_id = newCategory_id;
	}
	public Integer getNewRegion_id() {
		return newRegion_id;
	}
	public void setNewRegion_id(Integer newRegion_id) {
		this.newRegion_id = newRegion_id;
	}
	public String getNewBudget() {
		return newBudget;
	}
	public void setNewBudget(String newBudget) {
		this.newBudget = newBudget;
	}
	public String getNewNumberofseats() {
		return newNumberofseats;
	}
	public void setNewNumberofseats(String newNumberofseats) {
		this.newNumberofseats = newNumberofseats;
	}
	public String getNewComment() {
		return newComment;
	}
	public void setNewComment(String newComment) {
		this.newComment = newComment;
	}
	public String getNewHoliday() {
		return newHoliday;
	}
	public void setNewHoliday(String newHoliday) {
		this.newHoliday = newHoliday;
	}
	public String getNewShopimage() {
		return newShopimage;
	}
	public void setNewShopimage(String newShopimage) {
		this.newShopimage = newShopimage;
	}
	public String getNewFoodimage() {
		return newFoodimage;
	}
	public void setNewFoodimage(String newFoodimage) {
		this.newFoodimage = newFoodimage;
	}
	public String getNewStarttime() {
		return newStarttime;
	}
	public void setNewStarttime(String newStarttime) {
		this.newStarttime = newStarttime;
	}
	public String getNewFinishtime() {
		return newFinishtime;
	}
	public void setNewFinishtime(String newFinishtime) {
		this.newFinishtime = newFinishtime;
	}


	public boolean hasRequiredError() {
		return (newHoliday == null || newHoliday.isEmpty())
				|| (newCategory_id == null)
				|| (newRegion_id == null);
	}
}


