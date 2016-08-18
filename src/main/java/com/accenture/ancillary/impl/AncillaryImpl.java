package com.accenture.ancillary.impl;

import org.apache.log4j.Logger;

import com.accenture.ancillary.data.AncillaryDataDAL;
import com.accenture.ancillary.service.AncillaryService;

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

}
