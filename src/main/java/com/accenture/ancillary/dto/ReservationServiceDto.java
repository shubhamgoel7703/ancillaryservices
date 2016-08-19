package com.accenture.ancillary.dto;

import java.io.Serializable;

public class ReservationServiceDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int reservationId;
	private String reservationServiceId;
	private String serviceId;
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public String getReservationServiceId() {
		return reservationServiceId;
	}
	public void setReservationServiceId(String reservationServiceId) {
		this.reservationServiceId = reservationServiceId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}
