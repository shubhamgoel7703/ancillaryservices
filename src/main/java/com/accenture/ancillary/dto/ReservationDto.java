package com.accenture.ancillary.dto;

import java.io.Serializable;

public class ReservationDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hotelId;
	private String reservationId;
	private String guestName;
	private String guestAddress;
	private String checkInDate;
	private String checkOutDate;
	private String guestEmail;
	private String resvPrice;
	
	public String getResvPrice() {
		return resvPrice;
	}
	public void setResvPrice(String resvPrice) {
		this.resvPrice = resvPrice;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestAddress() {
		return guestAddress;
	}
	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

}
