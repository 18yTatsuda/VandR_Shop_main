package jp.co.example.VandR_Shop.service;

import jp.co.example.VandR_Shop.entity.ShopAdmin;

public interface IShopAdminService {

	public ShopAdmin authentication(Integer id, String password);

}
