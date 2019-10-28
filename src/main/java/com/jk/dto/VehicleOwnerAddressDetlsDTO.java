package com.jk.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class VehicleOwnerAddressDetlsDTO implements Serializable{
	private static final long serialVersionUID = -2464729519623335160L;
	
	private String hNo;
	private String streetName;
	private String city;
	private int zipCode;
}
