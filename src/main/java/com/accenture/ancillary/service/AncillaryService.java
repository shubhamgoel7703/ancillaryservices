package com.accenture.ancillary.service;

import javax.ws.rs.GET;
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
	
	@GET
	@Path("/getHotels")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHotels();
}
