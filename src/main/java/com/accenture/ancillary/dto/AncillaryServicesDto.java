package com.accenture.ancillary.dto;

import java.io.Serializable;

public class AncillaryServicesDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceId;
	private String serviceName;
	private String servicePrice;
	private String serviceDesc;
	
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}
	public String getServiceDesc() {
		return serviceDesc;
	}
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	
}
