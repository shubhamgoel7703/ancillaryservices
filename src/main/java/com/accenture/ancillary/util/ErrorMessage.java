package com.accenture.ancillary.util;

import java.io.Serializable;

public class ErrorMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ErrorMessage(){
		
	}
	
	ErrorMessage(String message){
		this.errorMessage=message;
	}
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
