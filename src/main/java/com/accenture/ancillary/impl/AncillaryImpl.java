package com.accenture.ancillary.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.accenture.ancillary.data.AncillaryDataDAL;
import com.accenture.ancillary.dto.ReservationDto;
import com.accenture.ancillary.service.AncillaryService;
import com.accenture.ancillary.util.AncillaryUtils;

public class AncillaryImpl implements AncillaryService{

	AncillaryDataDAL dataDAL;

	public AncillaryDataDAL getDataDAL() {
		return dataDAL;
	}
	public void setDataDAL(AncillaryDataDAL dataDAL) {
		this.dataDAL = dataDAL;
	}
	private static final Logger log = Logger.getLogger(AncillaryDataDAL.class);
	@Override
	public String testMethod() {
		log.info("Test logging");
		return "This is a test method";
	}
	@Override
	public String getHotels() {
		try {
			return AncillaryUtils.writeObjectAsString(getDataDAL().getHotelList());
		} catch (SQLException e) {
			return AncillaryUtils.createStackTraceAsString(e);
		} catch (Exception e) {
			return AncillaryUtils.createStackTraceAsString(e);
		}
	}
	@Override
	public String getServices() {
		try {
			return AncillaryUtils.writeObjectAsString(getDataDAL().getServiceList(0));
		} catch (SQLException e) {
			return AncillaryUtils.createStackTraceAsString(e);
		} catch (Exception e) {
			return AncillaryUtils.createStackTraceAsString(e);
		}
	}
	@Override
	public String getServicesOfHotel(String hotelId) {
		try {
			return AncillaryUtils.writeObjectAsString(getDataDAL().getServiceList(Integer.parseInt(hotelId)));
		} catch (SQLException e) {
			return AncillaryUtils.createStackTraceAsString(e);
		} catch (Exception e) {
			return AncillaryUtils.createStackTraceAsString(e);
		}
	}

	@Override
	public String saveReservation(String resvInput) {
		try {
			ReservationDto resDto=(ReservationDto) AncillaryUtils.getObjectFromString(resvInput, ReservationDto.class);
			return getDataDAL().saveReservation(AncillaryUtils.generateRandNum(), resDto.getHotelId(), resDto.getGuestName(),
					resDto.getGuestAddress(), resDto.getGuestEmail(), resDto.getCheckInDate(), resDto.getCheckOutDate())+"";
		} catch (SQLException e) {
			return AncillaryUtils.createStackTraceAsString(e);
		} catch (Exception e) {
			return AncillaryUtils.createStackTraceAsString(e);
		}
	}
}
