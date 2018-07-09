package jp.co.example.VandR_Shop.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.VandR_Shop.DAO.IShopInfoDao;
import jp.co.example.VandR_Shop.entity.ShopInfo;

@Repository
public class ShopInfoDao implements IShopInfoDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public ShopInfo findById(Integer id) {
		String sql = "SELECT * FROM shop WHERE shop_id = :shopId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("shopId", id);

		List<ShopInfo> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<ShopInfo>(ShopInfo.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public void update(ShopInfo shop) {
		String sql = "UPDATE shop SET "
				+ "category_id = :category_id,"
				+ "region_id = :region_id,"
				+ "budget = :budget,"
				+ "numberofseats = :numberofseats,"
				+ "comment = :comment,"
				+ "holiday = :holiday,"
				+ "shopimage = :shopimage,"
				+ "foodimage = :foodimage,"
				+ "starttime = :starttime,"
				+ "finishtime = :finishtime"
				+ " WHERE "
				+ "shop_id = :shop_id";

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("category_id",shop.getCategory_id()) ;
		param.addValue("region_id",shop.getRegion_id()) ;
		param.addValue("budget",shop.getBudget());
		param.addValue("numberofseats",shop.getNumberofseats());
		param.addValue("comment", shop.getComment());
		param.addValue("holiday",shop.getHoliday());
		param.addValue("shopimage",shop.getShopimage());
		param.addValue("foodimage", shop.getFoodimage());
		param.addValue("starttime",shop.getStarttime());
		param.addValue("finishtime",shop.getFinishtime());
		param.addValue("shop_id", shop.getShop_id());

		jdbcTemplate.update(sql, param);

	}
}
