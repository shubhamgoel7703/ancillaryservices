package com.accenture.ancillary.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.accenture.ancillary.data.AncillaryDataDAL;
import com.accenture.ancillary.dto.GetSummaryPerResvResponse;
import com.accenture.ancillary.dto.ReservationDto;
import com.accenture.ancillary.dto.ReservationServiceDto;
import com.accenture.ancillary.dto.RevenueReportDto;
import com.accenture.ancillary.dto.ServicePerReservation;
import com.accenture.ancillary.dto.ServicesDto;
import com.accenture.ancillary.reports.GeneratePDF;
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
			List<ServicesDto> serviceDto = getDataDAL().getServiceList(Integer.parseInt(hotelId));
			return AncillaryUtils.writeObjectAsString(serviceDto.size()==0?"No Services found for the given hotel":serviceDto);
		} catch (SQLException e) {
			return AncillaryUtils.createStackTraceAsString(e);
		} catch (Exception e) {
			return AncillaryUtils.createStackTraceAsString(e);
		}
	}

	@Override
	public String saveReservation(String resvInput) {
		log.info("input :"+ resvInput);
		try {
			ReservationDto resDto=(ReservationDto) AncillaryUtils.getObjectFromString(resvInput, ReservationDto.class);
			return getDataDAL().saveReservation(AncillaryUtils.generateRandNum(), resDto.getHotelId(), resDto.getGuestName(),
					resDto.getGuestAddress(), resDto.getGuestEmail(), resDto.getCheckInDate(), resDto.getCheckOutDate(),resDto.getResvPrice())+"";
		} catch (SQLException e) {
			return AncillaryUtils.createStackTraceAsString(e);
		} catch (Exception e) {
			return AncillaryUtils.createStackTraceAsString(e);
		}
	}

	@Override
	public String saveServicesPerRes(String resvInput) {
		log.info("input"+resvInput);
		try {
			ReservationServiceDto resServDto=(ReservationServiceDto) AncillaryUtils.getObjectFromString(resvInput, ReservationServiceDto.class);
			return getDataDAL().saveServices(resServDto.getReservationId(), resServDto.getServiceId(),
					resServDto.getServiceStart(), resServDto.getServiceEnd(), resServDto.getServiceCost(), resServDto.getServiceReqFor())+"";
		} catch (SQLException e) {
			return AncillaryUtils.createStackTraceAsString(e);
		} catch (Exception e) {
			return AncillaryUtils.createStackTraceAsString(e);
		}
	}

	@Override
	public String getSummaryForResv(String resId) {
		try {
			List<ServicePerReservation> serviceDto = getDataDAL().getServicePerResv(Integer.parseInt(resId));
			ReservationDto dto = getDataDAL().getResvDetails(Integer.parseInt(resId));
			GetSummaryPerResvResponse response= new GetSummaryPerResvResponse();
			response.setListOfServices(serviceDto);
			response.setReservationDto(dto);
			double saving=0;
			if(serviceDto!=null && serviceDto.size()>0){
				for(ServicePerReservation obj:serviceDto){
					saving+=Double.parseDouble(obj.getServiceCost());
				}
				saving=saving*0.05;
			}
			response.setSaving(""+saving);
			return AncillaryUtils.writeObjectAsString(response);
		} catch (SQLException e) {
			return AncillaryUtils.createStackTraceAsString(e);
		} catch (Exception e) {
			return AncillaryUtils.createStackTraceAsString(e);
		}
	}

	@Override
	public String getRecommendedServices(String emailId) {
		try {
			return AncillaryUtils.writeObjectAsString(getDataDAL().getRecomendedServices(emailId));
		} catch (SQLException e) {
			return AncillaryUtils.createStackTraceAsString(e);
		} catch (Exception e) {
			return AncillaryUtils.createStackTraceAsString(e);
		}}
	
	@Override
	public String getRevenueReport(String startDate) {
		try {
			List<RevenueReportDto> serviceDto = getDataDAL().getRevenueReport(startDate);
			return AncillaryUtils.writeObjectAsString(serviceDto);
		} catch (SQLException e) {
			return AncillaryUtils.createStackTraceAsString(e);
		} catch (Exception e) {
			return AncillaryUtils.createStackTraceAsString(e);
		}
	}
	
	@Override
	public String generateReport(String startDate) {
		GeneratePDF.generateRevReport(startDate);
		return "Report is generated!!";
	}
}
