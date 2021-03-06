package jp.co.example.VandR_Shop.DAO;

import java.util.List;

import jp.co.example.VandR_Shop.entity.ReservationJoin;

public interface IReservationDao  {
	public List<ReservationJoin> findByShopId(Integer id);
	public ReservationJoin findById(Integer id);
	public void delete(Integer id);
	public void flagUpdate(Integer id);
	public void leaveFlagUpdate(Integer id);
	public void flagUpdateIn(Integer id);
	public int selectVacancyId(Integer id);
}
