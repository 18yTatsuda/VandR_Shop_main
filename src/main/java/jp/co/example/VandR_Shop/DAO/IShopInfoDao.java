package jp.co.example.VandR_Shop.DAO;

import jp.co.example.VandR_Shop.entity.ShopInfo;

public interface IShopInfoDao {

	public ShopInfo findById(Integer id);
	public void update(ShopInfo shop);
}
