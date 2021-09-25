package com.macquarie.niks.exception;

/**
 * This enum will contain all error type with their codes and messages.
 * @author abc
 *
 */
public enum ErrorType {
	
	//TODO: Many more error codes can be added
	RECORD__NOT__FOUND_EXIST(40,"Records not found");
	
	int errorCode;
	String errorMsg;
	
	private ErrorType(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

}
