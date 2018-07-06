package jp.co.example.VandR_Shop.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.VandR_Shop.DAO.IShopAdminDao;
import jp.co.example.VandR_Shop.entity.ShopAdmin;

@Repository
public class ShopAdminDao implements IShopAdminDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public ShopAdmin findByIdAndPassword(Integer id, String password) {
		String sql = "SELECT * FROM shopadmin WHERE shop_id = :shopId AND password = :password";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("shopId", id);
		param.addValue("password", password);

		List<ShopAdmin> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<ShopAdmin>(ShopAdmin.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}
}
