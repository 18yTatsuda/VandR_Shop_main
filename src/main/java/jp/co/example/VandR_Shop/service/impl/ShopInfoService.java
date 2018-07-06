package jp.co.example.VandR_Shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.VandR_Shop.DAO.impl.ShopInfoDao;
import jp.co.example.VandR_Shop.entity.ShopInfo;
import jp.co.example.VandR_Shop.service.IShopInfoService;

@Service
@Transactional
public class ShopInfoService implements IShopInfoService{

	@Autowired
	private ShopInfoDao shopInfoDao;

	@Override
	public ShopInfo locator(Integer id) {
		return	shopInfoDao.findById(id);
	}

	@Override
	public void update(ShopInfo shop) {
		shopInfoDao.update(shop);
	}
}
