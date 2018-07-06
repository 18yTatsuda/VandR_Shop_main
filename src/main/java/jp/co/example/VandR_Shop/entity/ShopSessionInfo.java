package jp.co.example.VandR_Shop.entity;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value= "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShopSessionInfo implements Serializable {

	private static final long serialVersionUID = 6334063099671792256L;

    private ShopAdmin loginShop;

    private ShopInfo prevShopProfile;

	private  ShopInfo newShopProfile;


	public ShopAdmin getLoginShop() {
		return loginShop;
	}

	public void setLoginShop(ShopAdmin loginShop) {
		this.loginShop = loginShop;
	}

	public ShopInfo getPrevShopProfile() {
		return prevShopProfile;
	}

	public void setPrevShopProfile(ShopInfo prevShopProfile) {
		this.prevShopProfile = prevShopProfile;
	}

	public ShopInfo getNewShopProfile() {
		return newShopProfile;
	}

	public void setNewShopProfile(ShopInfo newShopProfile) {
		this.newShopProfile = newShopProfile;
	}

//	public ReservationInfo getNewReserv() {
//		return newReserv;
//	}
//
//	public void setNewReserv(ReservationInfo newReserv) {
//		this.newReserv = newReserv;
//	}
//
//	public ReservationInfo getPrevReserv() {
//		return prevReserv;
//	}
//
//	public void setPrevReserv(ReservationInfo prevReserv) {
//		this.prevReserv = prevReserv;
//	}

	public void invalidate() {
		loginShop = null;
		newShopProfile = null;
		prevShopProfile = null;
	}
}
