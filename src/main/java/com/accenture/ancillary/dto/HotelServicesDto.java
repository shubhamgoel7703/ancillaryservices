package com.accenture.ancillary.dto;

import java.io.Serializable;

public class HotelServicesDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hotelId;
	private String hotelServiceId;
	private String serviceId;
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelServiceId() {
		return hotelServiceId;
	}
	public void setHotelServiceId(String hotelServiceId) {
		this.hotelServiceId = hotelServiceId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}
