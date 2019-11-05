package com.jk.exception;

public class CustomeExceptionHandler extends Exception{
	private static final long serialVersionUID = -6658768893856463640L;
	
	public CustomeExceptionHandler() {
		super("No data is available for this given id");
	}
}
