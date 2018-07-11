package jp.co.example.VandR_Shop.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFile {

	private MultipartFile shopImage;

	private MultipartFile foodImage;



	public MultipartFile getShopImage() {
		return shopImage;
	}

	public void setShopImage(MultipartFile shopImage) {
		this.shopImage = shopImage;
	}


	public MultipartFile getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(MultipartFile foodImage) {
		this.foodImage = foodImage;
	}

}
