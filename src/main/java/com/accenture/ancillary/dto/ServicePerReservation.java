package com.accenture.ancillary.dto;

import java.io.Serializable;

public class ServicePerReservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceName;
	private String serviceStart;
	private String serviceEnd;
	private String serviceCost;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
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
	

}
