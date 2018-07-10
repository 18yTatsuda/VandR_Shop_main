package jp.co.example.VandR_Shop.entity;

public class Seat {
	private int seat_id;

	private String seattype;
	private int seat_num;

	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	public String getSeattype() {
		return seattype;
	}
	public void setSeattype(String seattype) {
		this.seattype = seattype;
	}
	public int getSeat_num() {
		return seat_num;
	}
	public void setSeat_num(int num) {
		this.seat_num = num;
	}
}
