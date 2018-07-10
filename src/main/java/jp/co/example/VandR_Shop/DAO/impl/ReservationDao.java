package jp.co.example.VandR_Shop.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.VandR_Shop.DAO.IReservationDao;
import jp.co.example.VandR_Shop.RowMappers.ReservationSeatRowMapper;
import jp.co.example.VandR_Shop.entity.ReservationJoin;

@Repository
public class ReservationDao implements IReservationDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	@Override
	public List<ReservationJoin> findByShopId(Integer id) {
		String sql = "SELECT r.reservation_id, r.user_name, r.num, r.time, r.vacancy_id, s.seattype, s.seat_num "
				+ " FROM reservation r"
				+ " JOIN vacancy v ON r.vacancy_id = v.vacancy_id"
				+ " JOIN seat s ON v.seat_id = s.seat_id"
				+ " WHERE r.shop_id = :id"
				+ " AND r.leaveflag='0'";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id",id);
		RowMapper<ReservationJoin> rowMapper = new ReservationSeatRowMapper();

		List<ReservationJoin> list = jdbcTemplate.query(sql, param, rowMapper);
		return list;

	}


/*
		MapSqlParameterSource param = new MapSqlParameterSource();
		List<Map<String,Object>> resultList = jdbcTemplate.queryForList(sql,param.addValue("id", id));
		List<Reservation> reservationList = new ArrayList<Reservation>();
		for(Map<String, Object> result: resultList) {
			Reservation reservation = new Reservation();
			reservation.setUser_name((String) result.get("r.user_name"));
			reservation.setNum((String) result.get("r.num"));
			reservation.setTime((String) result.get("r.time"));
			reservation.setSeat_id((int) result.get("s.seat_id"));
			reservation.setSeattype((String) result.get("s.seattype"));
			reservation.setReservation_id((int)result.get("r.reservation_id"));
			reservationList.add(reservation);
		}
		return reservationList;*/
	@Override
	public ReservationJoin findById(Integer id) {
		String sql = "SELECT r.reservation_id, r.user_name, r.num, r.time, r.vacancy_id, s.seattype, s.seat_num "
				+ " FROM reservation r"
				+ " JOIN vacancy v ON r.vacancy_id = v.vacancy_id"
				+ " JOIN seat s ON v.seat_id = s.seat_id"
				+ " WHERE r.reservation_id = :id ";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id",id);
		RowMapper<ReservationJoin> rowMapper = new ReservationSeatRowMapper();
		return jdbcTemplate.queryForObject(sql, param,
				rowMapper);
	}

/*	//reservation\idをもとにseattypeとnumをget
	public Seat getSeatInfo(Integer id) {
		String sql = "SELECT r.reservation_id, r.user_name, r.time, s.seattype, s.num "
				+ "FROM reservation r"
				+ "JOIN vacancy v ON r.vacancy_id = v.vacancy_id"
				+ "JOIN seat s ON v.seat_id = s.seat_id"
				+ " WHERE reservation_id = :id";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);

		return jdbcTemplate.queryForObject(sql,param,
				new BeanPropertyRowMapper<Seat>(Seat.class));
	}*/

	//reservation_idをもとに削除
	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM reservation WHERE reservation_id = :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);

		jdbcTemplate.update(sql,  param);
	}
	//削除用にvacancy_idを検索
	@Override
	public int selectVacancyId (Integer id) {
		String sql = "SELECT vacancy_id FROM reservation WHERE reservation_id = :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id",id);
		return jdbcTemplate.queryForObject(sql, param, Integer.class);
	}
	//予約キャンセルでvacancy_flagを0にする
/*	public void flagUpdate(Integer id) {
		String sql = "UPDATE vacancy SET vacancy_flag = 1"
				+ " ORDER BY CASE WHEN (seat_id = :id) THEN 1 ELSE 0 END DESC,"
				+ " vacancy_flag ASC"
				+ " LIMIT 1";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);

		jdbcTemplate.update(sql, param);
	}*/
	@Override
	public void flagUpdate(Integer id) {
		String sql = "UPDATE vacancy SET vacancy_flag = 0 WHERE vacancy_id = :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);

		jdbcTemplate.update(sql, param);
	}
	@Override
	public void leaveFlagUpdate(Integer id) {
		String sql = "UPDATE reservation SET leaveflag=1 WHERE reservation_id = :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		jdbcTemplate.update(sql, param);
	}
	@Override
	public void flagUpdateIn(Integer id) {
		String sql = "UPDATE vacancy SET vacancy_flag = 0 WHERE vacancy_id = :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);

		jdbcTemplate.update(sql, param);
	}
}
