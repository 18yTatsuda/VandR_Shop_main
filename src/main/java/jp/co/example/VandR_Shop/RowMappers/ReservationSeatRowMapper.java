package jp.co.example.VandR_Shop.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jp.co.example.VandR_Shop.entity.Reservation;
import jp.co.example.VandR_Shop.entity.ReservationJoin;
import jp.co.example.VandR_Shop.entity.Seat;



public class ReservationSeatRowMapper implements RowMapper<ReservationJoin> {

	@Override
	public ReservationJoin mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReservationJoin reservationJoin = new ReservationJoin();
		Reservation reservation = new Reservation();
		Seat seat = new Seat();
		reservation.setUser_name(rs.getString("user_name"));
		reservation.setReservation_id(rs.getInt("reservation_id"));
		reservation.setNum(rs.getString("num"));
		reservation.setTime(rs.getString("time"));
		reservation.setVacancy_id(rs.getInt("vacancy_id"));

		seat.setSeattype(rs.getString("seattype"));
		seat.setSeat_num(rs.getInt("seat_num"));

		reservationJoin.setSeat(seat);
		reservationJoin.setReservation(reservation);

		return reservationJoin;
	}


}
