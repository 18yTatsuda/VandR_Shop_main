package jp.co.example.VandR_Shop.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.example.VandR_Shop.entity.Reservation;
import jp.co.example.VandR_Shop.entity.ReservationJoin;
import jp.co.example.VandR_Shop.entity.Seat;
import jp.co.example.VandR_Shop.entity.ShopSessionInfo;
import jp.co.example.VandR_Shop.service.IReservationService;

@Controller
public class ShopReservationController {

	@Autowired
	IReservationService reservationService;

	@Autowired
	ShopSessionInfo sessioninfo;


    @RequestMapping(value = "/shopProfileUpdate", method = RequestMethod.POST)
    public String profileUpdateResult(Model model) {
    	return "shopProfileUpdateResult";
    }
    //予約情報を一覧表示
    @RequestMapping(value = "/shopReservationCheck", method = RequestMethod.GET)
    public String reservation(Model model) {

    	//findByShopIdの()には、sessionInfoに保存した店舗idが入ります
    	List<ReservationJoin> resultList = reservationService.findByShopId(1);
    	ArrayList<Reservation> reservation = new ArrayList<Reservation>();
    	ArrayList<Seat> seat = new ArrayList<Seat>();
    	for(ReservationJoin rJoin : resultList) {
    		reservation.add(rJoin.getReservation());
    		seat.add(rJoin.getSeat());
    	}
    	model.addAttribute("reservelist", resultList);
    	model.addAttribute("reservationlist", reservation);
    	model.addAttribute("seatlist", seat);
    	return "shopReservationCheck";
    }

    @RequestMapping(value = "/shopReservationInsert", method = RequestMethod.GET)
    public String reservationInsert(Model model) {
    	return "shopReservationInsert";
    }

    @RequestMapping(value = "/shopReservationInsertResult", method = RequestMethod.POST)
    public String reservationInsertResult(Model model) {
    	return "shopReservationInsertResult";
    }
    //reserve_idをもとに予約を削除します
    @RequestMapping(value = "/shopReservationDelete", method = RequestMethod.POST)
    public String reservationDelete(@RequestParam("shopReservationDelete")int id, Model model) {
    	ReservationJoin join = reservationService.findById(id);
    	int vacId = join.getReservation().getVacancy_id();
    	sessioninfo.setVacancy_id(vacId);
    	model.addAttribute("reserve", join);


    	return "shopReservationDelete";
    }
    //reserve_id,vacancy_idをもとに予約を削除します
    @RequestMapping(value = "/shopReservationDeleteResult", method = RequestMethod.POST)
    public String reservationDeleteResult(@RequestParam("shopReservationDeleteResult") int id, Model model) {
    	int vacId = sessioninfo.getVacancy_id();
    	reservationService.flagUpdate(vacId);
    	reservationService.delete(id);
    	return "shopReservationDeleteResult";
    }

    @RequestMapping(value = "/shopReservationLeave", method = RequestMethod.POST)
    public String reservationLeave(@RequestParam("shopReservationLeave") int id, Model model) {
    	reservationService.leaveFlagUpdate(id);
    	int vacancy_id = reservationService.selectVacancyId(id);
    	reservationService.flagUpdateIn(vacancy_id);
    	return "shopReservationCheck";
    }


}
