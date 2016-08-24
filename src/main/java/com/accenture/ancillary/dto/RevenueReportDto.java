package com.accenture.ancillary.dto;

import java.io.Serializable;

public class RevenueReportDto extends ServicePerReservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int resId;
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	
	

}
