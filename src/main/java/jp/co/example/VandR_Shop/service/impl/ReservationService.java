package jp.co.example.VandR_Shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.VandR_Shop.DAO.IReservationDao;
import jp.co.example.VandR_Shop.entity.ReservationJoin;
import jp.co.example.VandR_Shop.service.IReservationService;


@Service
public class ReservationService implements IReservationService {
	@Autowired
	private IReservationDao reservationDao;
	@Override
	public List<ReservationJoin> findByShopId(Integer id) {
		return reservationDao.findByShopId(id);
	}

	public ReservationJoin findById(Integer id) {
		return reservationDao.findById(id);
	}

	public void delete(Integer id) {
		reservationDao.delete(id);
	}

	public void flagUpdate(Integer id) {
		reservationDao.flagUpdate(id);
	}

	public void leaveFlagUpdate(Integer id) {
		reservationDao.leaveFlagUpdate(id);
	}

	public void flagUpdateIn(Integer id) {
		reservationDao.flagUpdateIn(id);
	}

	public int selectVacancyId(Integer id) {
		return reservationDao.selectVacancyId(id);
	}
}
