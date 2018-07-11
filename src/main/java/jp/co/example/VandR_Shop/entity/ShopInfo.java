package jp.co.example.VandR_Shop.entity;

import java.io.Serializable;

public class ShopInfo implements Serializable {

	private Integer shop_id;
	private String shop_name;
	private Integer category_id;
	private Integer region_id;
	private String budget;
	private String telephone;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopInfo other = (ShopInfo) obj;
		if (category_id == null) {
			if (other.category_id != null)
				return false;
		} else if (!category_id.equals(other.category_id))
			return false;

		if (budget == null) {
			if (other.budget != null)
				return false;
		} else if (!budget.equals(other.budget))
			return false;

		if (numberofseats == null) {
			if (other.numberofseats != null)
				return false;
		} else if (!numberofseats.equals(other.numberofseats))
			return false;

		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;

		if (numberofseats == null) {
			if (other.numberofseats != null)
				return false;
		} else if (!numberofseats.equals(other.numberofseats))
			return false;

		if (holiday == null) {
			if (other.holiday != null)
				return false;
		} else if (!holiday.equals(other.holiday))
			return false;

		if (shopimage == null) {
			if (other.shopimage != null)
				return false;
		} else if (!shopimage.equals(other.shopimage))
			return false;

		if (foodimage == null) {
			if (other.foodimage != null)
				return false;
		} else if (!foodimage.equals(other.foodimage))
			return false;

		if (starttime == null) {
			if (other.starttime != null)
				return false;
		} else if (!starttime.equals(other.starttime))
			return false;

		if (finishtime == null) {
			if (other.finishtime != null)
				return false;
		} else if (!finishtime.equals(other.finishtime))
			return false;

		return true;
	}
}
