package jp.co.example.VandR_Shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.VandR_Shop.DAO.impl.ShopAdminDao;
import jp.co.example.VandR_Shop.entity.ShopAdmin;
import jp.co.example.VandR_Shop.service.IShopAdminService;

@Service
@Transactional
public class ShopAdminService implements IShopAdminService {

	@Autowired
	private ShopAdminDao shopAdminDao;

	@Override
	public ShopAdmin authentication(String id, String password) {
		return shopAdminDao.findByIdAndPassword(id, password);
	}

}
