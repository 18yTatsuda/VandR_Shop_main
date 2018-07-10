package jp.co.example.VandR_Shop.entity;

public class ReservationJoin {

public Seat seat;
public Reservation reservation;

public Seat getSeat() {
	return seat;
}
public void setSeat(Seat seat) {
	this.seat = seat;
}
public Reservation getReservation() {
	return reservation;
}
public void setReservation(Reservation reservation) {
	this.reservation = reservation;
}
}
