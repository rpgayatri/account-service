package com.gayatri.accountservice.model;

public class ErrorResource {
	private String errorMsg;
	private int errorCode;
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public ErrorResource(int errorCode, String errorMsg) {
		super();
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}
	
	
}
