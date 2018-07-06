package jp.co.example.VandR_Shop.service;

import jp.co.example.VandR_Shop.entity.ShopInfo;

public interface IShopInfoService {

	public ShopInfo locator(Integer id);
	public void update(ShopInfo shop);
}
