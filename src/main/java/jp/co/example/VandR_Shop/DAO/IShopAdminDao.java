package jp.co.example.VandR_Shop.DAO;

import jp.co.example.VandR_Shop.entity.ShopAdmin;

public interface IShopAdminDao {

	public ShopAdmin findByIdAndPassword(Integer id, String password);
}
