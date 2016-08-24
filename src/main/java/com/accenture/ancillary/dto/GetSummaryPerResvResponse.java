package com.accenture.ancillary.dto;

import java.io.Serializable;
import java.util.List;

public class GetSummaryPerResvResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ServicePerReservation> listOfServices;
	private ReservationDto reservationDto;
	private String saving;
	private String totalCost;
	
	public String getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	public String getSaving() {
		return saving;
	}
	public void setSaving(String saving) {
		this.saving = saving;
	}
	public List<ServicePerReservation> getListOfServices() {
		return listOfServices;
	}
	public void setListOfServices(List<ServicePerReservation> listOfServices) {
		this.listOfServices = listOfServices;
	}
	public ReservationDto getReservationDto() {
		return reservationDto;
	}
	public void setReservationDto(ReservationDto reservationDto) {
		this.reservationDto = reservationDto;
	}

}
