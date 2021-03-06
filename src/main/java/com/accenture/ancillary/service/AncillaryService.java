package com.accenture.ancillary.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@Path("/restservice")
public interface AncillaryService {

	
	@GET
	@Path("/testmethod")
	@Produces(MediaType.APPLICATION_JSON)
	public String testMethod();
	
	@POST
	@Path("/getHotels")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHotels();
	
	@POST
	@Path("/getServices")
	@Produces(MediaType.APPLICATION_JSON)
	public String getServices();
	
	@POST
	@Path("/getServicesOfHotel")
	@Produces(MediaType.APPLICATION_JSON)
	public String getServicesOfHotel(String hotelId);
	
	@POST
	@Path("/saveReservation")
	@Produces(MediaType.APPLICATION_JSON)
	public String saveReservation(String resvInput);
	
	@POST
	@Path("/saveServicesPerRes")
	@Produces(MediaType.APPLICATION_JSON)
	public String saveServicesPerRes(String resvInput);
	
	@POST
	@Path("/getSummaryForResv")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSummaryForResv(String resId);
	
	@POST
	@Path("/getRecommendedServices")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRecommendedServices(String emailId);
	
	@POST
	@Path("/getRevenueReport")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRevenueReport(String startDate);
	
	@POST
	@Path("/generateReport")
	@Produces(MediaType.APPLICATION_JSON)
	public String generateReport(String startDate);
}
