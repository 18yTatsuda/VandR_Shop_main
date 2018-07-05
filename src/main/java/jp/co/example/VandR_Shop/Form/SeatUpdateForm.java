package jp.co.example.VandR_Shop.Form;

import javax.validation.constraints.NotBlank;

public class SeatUpdateForm {
	@NotBlank
	private String seatId;

	@NotBlank
	private String seatType;

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String _seatId) {
		this.seatId = _seatId;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String _seatType) {
		this.seatType = _seatType;
	}

}
