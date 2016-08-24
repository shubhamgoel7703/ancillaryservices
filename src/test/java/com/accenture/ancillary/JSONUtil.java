package com.accenture.ancillary;

import com.accenture.ancillary.dto.ReservationDto;
import com.accenture.ancillary.dto.ReservationServiceDto;
import com.accenture.ancillary.util.AncillaryUtils;

public class JSONUtil {
	
	public static void main(String[] args) throws Exception {
		ReservationDto dto=new ReservationDto();
		dto.setHotelId(10002);
		dto.setGuestName("Sridhar Bhat");
		dto.setGuestAddress("Banshankri");
		dto.setGuestEmail("bhat@acc.com");
		dto.setCheckInDate("8/22/2016");
		dto.setCheckOutDate("8/24/2016");
		dto.setResvPrice("150$");
		//System.out.println(convertClassToObject(dto));
		
		ReservationServiceDto dto2=new ReservationServiceDto();
		dto2.setReservationId(12345);
		dto2.setServiceId(30002);
		dto2.setServiceStart("8/22/2016");
		dto2.setServiceEnd("8/24/2016");
		dto2.setServiceCost("50$");
		dto2.setServiceReqFor("1");
		System.out.println(convertClassToObject(dto2));
		
		
	}

	private static String convertClassToObject(Object dto) throws Exception{
		return AncillaryUtils.writeObjectAsString(dto);
	}
}
