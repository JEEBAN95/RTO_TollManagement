package com.jk.command;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleOwnerAdderssDetlsCmd {
	
	private String hNo;
	private String streetName;
	private String city;
	private Integer zipCode;
	
}
