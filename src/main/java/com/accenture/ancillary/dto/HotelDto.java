package com.accenture.ancillary.dto;

import java.io.Serializable;

public class HotelDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hotelId;
	private String hotelname;
	private String hotelCity;
	private String hotelCountry;
	private String hotelShortDesc;
	private String hotelPrice;
	public String getHotelPrice() {
		return hotelPrice;
	}
	public void setHotelPrice(String hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getHotelCity() {
		return hotelCity;
	}
	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}
	public String getHotelCountry() {
		return hotelCountry;
	}
	public void setHotelCountry(String hotelCountry) {
		this.hotelCountry = hotelCountry;
	}
	public String getHotelShortDesc() {
		return hotelShortDesc;
	}
	public void setHotelShortDesc(String hotelShortDesc) {
		this.hotelShortDesc = hotelShortDesc;
	}
	

}
