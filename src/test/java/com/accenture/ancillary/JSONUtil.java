package com.accenture.ancillary;

import com.accenture.ancillary.dto.ReservationDto;
import com.accenture.ancillary.util.AncillaryUtils;

public class JSONUtil {
	
	public static void main(String[] args) throws Exception {
		ReservationDto dto=new ReservationDto();
		dto.setHotelId(10002);
		dto.setGuestName("Sridhar Bhat");
		dto.setGuestAddress("Banshankri");
		dto.setGuestEmail("bhat@acc.com");
		dto.setCheckInDate("8/22/2016");
		dto.setCheckInDate("8/24/2016");
		System.out.println(convertClassToObject(dto));
		
	}

	private static String convertClassToObject(Object dto) throws Exception{
		return AncillaryUtils.writeObjectAsString(dto);
	}
}
