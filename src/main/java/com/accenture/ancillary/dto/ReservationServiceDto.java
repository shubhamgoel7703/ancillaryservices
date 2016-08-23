package com.accenture.ancillary.dto;

import java.io.Serializable;

public class ReservationServiceDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int reservationId;
	private String reservationServiceId;
	private int serviceId;
	private String serviceStart="";
	private String serviceEnd="";
	private String serviceCost="";
	private String serviceReqFor="";
	
	public String getServiceStart() {
		return serviceStart;
	}
	public void setServiceStart(String serviceStart) {
		this.serviceStart = serviceStart;
	}
	public String getServiceEnd() {
		return serviceEnd;
	}
	public void setServiceEnd(String serviceEnd) {
		this.serviceEnd = serviceEnd;
	}
	public String getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}
	public String getServiceReqFor() {
		return serviceReqFor;
	}
	public void setServiceReqFor(String serviceReqFor) {
		this.serviceReqFor = serviceReqFor;
	}
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
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	

}
